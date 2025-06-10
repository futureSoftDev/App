package com.company.accountservice.domain;

import com.company.accountservice.domain.base.AuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "account")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends AuditingEntity {

    @Column(name = "account_number", unique = true, nullable = false)
    String accountNumber;

    @Column(name = "account_type")
    String accountType;

    @Column(name = "branch_address")
    String branchAddress;

    @Column(name = "customer_id")
    Long customerId;
}