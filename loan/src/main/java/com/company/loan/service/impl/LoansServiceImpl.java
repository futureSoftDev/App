package com.company.loan.service.impl;

import com.company.loan.constants.LoansConstants;
import com.company.loan.dto.LoanContactInfoDto;
import com.company.loan.dto.LoanDto;
import com.company.loan.entity.Loans;
import com.company.loan.exception.LoanAlreadyExistsException;
import com.company.loan.exception.ResourceNotFoundException;
import com.company.loan.mapper.LoanMapper;
import com.company.loan.repository.LoanRepository;
import com.company.loan.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements LoansService {

    private LoanRepository loanRepository;
    private final LoanContactInfoDto loanContactInfoDto;

    @Override
    public void create(String mobileNumber) {
        Optional<Loans> optionalLoans = loanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoans.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber " + mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoanDto get(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoansDto(loans, new LoanDto());
    }

    @Override
    public boolean update(LoanDto loanDto) {
        Loans loans = loanRepository.findByLoanNumber(loanDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loanDto.getLoanNumber()));
        LoanMapper.mapToLoans(loanDto, loans);
        loanRepository.save(loans);
        return true;
    }

    @Override
    public boolean delete(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loans.getLoanId());
        return true;
    }

    @Override
    public LoanContactInfoDto getContactDetails() {
        return loanContactInfoDto;
    }
}
