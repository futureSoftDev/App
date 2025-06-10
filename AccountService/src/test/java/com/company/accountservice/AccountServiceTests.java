import com.company.accountservice.domain.Account;
import com.company.accountservice.dto.AccountDetailDto;
import com.company.accountservice.dto.CustomerDto;
import com.company.accountservice.mappers.AccountMapper;
import com.company.accountservice.repository.AccountRepository;
import com.company.accountservice.service.AccountService;
import com.company.accountservice.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTests {

    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper accountMapper;
    @Mock
    CustomerService customerService;
    @InjectMocks
    AccountService accountService;

    @Test
    void getReturnsAccountWithCustomer() {
        Account account = new Account();
        account.setId(1L);
        account.setCustomerId(2L);

        AccountDetailDto detailDto = new AccountDetailDto();
        CustomerDto customerDto = new CustomerDto("name", "email", "phone");
        detailDto.setCustomer(customerDto);

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        when(accountMapper.toDetailDto(account)).thenReturn(detailDto);
        when(customerService.get(2L)).thenReturn(customerDto);

        AccountDetailDto result = accountService.get(1L);
        assertSame(detailDto, result);
        assertSame(customerDto, result.getCustomer());
    }
}
