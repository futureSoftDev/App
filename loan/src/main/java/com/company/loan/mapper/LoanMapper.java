package com.company.loan.mapper;


import com.company.loan.dto.LoanDto;
import com.company.loan.entity.Loans;

public class LoanMapper {

    public static LoanDto mapToLoansDto(Loans loans, LoanDto loanDto) {
        loanDto.setLoanNumber(loans.getLoanNumber());
        loanDto.setLoanType(loans.getLoanType());
        loanDto.setMobileNumber(loans.getMobileNumber());
        loanDto.setTotalLoan(loans.getTotalLoan());
        loanDto.setAmountPaid(loans.getAmountPaid());
        loanDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loanDto;
    }

    public static Loans mapToLoans(LoanDto loanDto, Loans loans) {
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setMobileNumber(loanDto.getMobileNumber());
        loans.setTotalLoan(loanDto.getTotalLoan());
        loans.setAmountPaid(loanDto.getAmountPaid());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loans;
    }

}
