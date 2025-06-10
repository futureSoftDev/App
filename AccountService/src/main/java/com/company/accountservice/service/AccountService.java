package com.company.accountservice.service;

import com.company.accountservice.domain.Account;
import com.company.accountservice.dto.AccountContactInfoDto;
import com.company.accountservice.dto.AccountDetailDto;
import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.dto.CustomerDto;
import com.company.accountservice.mappers.AccountMapper;
import com.company.accountservice.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountService {

    AccountRepository accountRepository;
    AccountMapper accountMapper;
    CustomerService customerService;
    Environment environment;
    AccountContactInfoDto infoDto;

    @Transactional
    public Long create(AccountDto accountDto) {
        Long customerId = customerService.createOrUpdate(new CustomerDto(accountDto.getCustomerName(), accountDto.getCustomerEmail(), accountDto.getCustomerPhone()));
        Account account = accountMapper.toEntity(accountDto);
        account.setCustomerId(customerId);
        return accountRepository.save(account).getId();
    }

    @Transactional
    public Long update(Long id, AccountDto accountDto) {
        return accountRepository.findById(id).map(account -> {
            customerService.createOrUpdate(new CustomerDto(
                    accountDto.getCustomerName(),
                    accountDto.getCustomerEmail(),
                    accountDto.getCustomerPhone()
            ));

            accountMapper.updateEntityFromDto(accountDto, account);
            return accountRepository.save(account).getId();
        }).orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    @Transactional
    public AccountDetailDto get(Long id) {
        return accountRepository.findById(id).map(account -> new AccountDetailDto()).orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    public String getBuildVersion() {
        return environment.getProperty("build.version");
    }

    public AccountContactInfoDto getContactInfo() {
        return infoDto;
    }
}
