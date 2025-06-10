package com.company.accountservice.mappers;

import com.company.accountservice.domain.Customer;
import com.company.accountservice.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
}
