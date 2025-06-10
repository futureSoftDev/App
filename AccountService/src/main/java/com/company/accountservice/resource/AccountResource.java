package com.company.accountservice.resource;

import com.company.accountservice.dto.AccountContactInfoDto;
import com.company.accountservice.dto.AccountDto;
import com.company.accountservice.dto.ResponseDto;
import com.company.accountservice.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountResource {

    AccountService accountService;

    @GetMapping("/current")
    public ResponseEntity<String> getAccount() {
        return ResponseEntity.ok("My account");
    }

    @PostMapping
    public ResponseDto<Long> create(@RequestBody AccountDto accountDto) {
        return ResponseDto.onSuccess(accountService.create(accountDto));
    }

    @PutMapping("/{id}")
    public ResponseDto<Long> update(@PathVariable Long id, @RequestBody AccountDto accountDto) {
        return ResponseDto.onSuccess(accountService.update(id, accountDto));
    }

    @GetMapping("/build-version")
    public ResponseDto<String> getBuildVersion() {
        return ResponseDto.onSuccess(accountService.getBuildVersion());
    }

    @GetMapping("/contact-info")
    public ResponseDto<AccountContactInfoDto> getContactInfo() {
        return ResponseDto.onSuccess(accountService.getContactInfo());
    }
}
