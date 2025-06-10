package com.company.accountservice.service;

import com.company.accountservice.domain.Customer;
import com.company.accountservice.dto.CustomerDto;
import com.company.accountservice.mappers.CustomerMapper;
import com.company.accountservice.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    @Transactional
    public Customer createEntity(CustomerDto customerDto) {
        return customerRepository.save(customerMapper.toEntity(customerDto));
    }

    @Transactional
    public Long createOrUpdate(CustomerDto customerDto) {
        return customerRepository.findFirstByPhoneNumber(customerDto.getCustomerPhone()).map(customer -> this.update(customer, customerDto)).orElseGet(() -> this.createEntity(customerDto).getId());
    }

    private Long update(Customer customer, CustomerDto customerDto) {
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setPhoneNumber(customerDto.getCustomerPhone());
        return customerRepository.save(customer).getId();
    }
}
