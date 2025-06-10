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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "customer")
public class Customer extends AuditingEntity {


    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;
}
