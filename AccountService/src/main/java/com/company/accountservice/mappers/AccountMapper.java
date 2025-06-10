package com.company.accountservice.mappers;

import com.company.accountservice.domain.Account;
import com.company.accountservice.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper extends BaseMapper<Account, AccountDto> {

    void updateEntityFromDto(AccountDto dto, @MappingTarget Account entity);

}
