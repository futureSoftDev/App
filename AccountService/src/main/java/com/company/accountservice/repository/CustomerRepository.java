package com.company.accountservice.repository;

import com.company.accountservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findFirstByPhoneNumber(String phoneNumber);
}
