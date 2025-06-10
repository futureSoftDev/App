package com.company.accountservice.domain.base;

import com.company.accountservice.domain.audit.AuditAware;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class AuditingEntity extends BaseEntity {

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    LocalDateTime updateDate;

    @CreatedBy
    @Column(name = "creator")
    String creator;

    @LastModifiedBy
    @Column(name = "updater")
    String updater;
}