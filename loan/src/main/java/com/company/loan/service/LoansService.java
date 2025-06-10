package com.company.loan.service;


import com.company.loan.dto.LoanContactInfoDto;
import com.company.loan.dto.LoanDto;

public interface LoansService {

    void create(String mobileNumber);

    LoanDto get(String mobileNumber);

    boolean update(LoanDto loanDto);

    boolean delete(String mobileNumber);

    LoanContactInfoDto getContactDetails();
}