package lms.loan.service;

import lms.model.LoanVO;

public interface LoanService {
    int processBookLoan(LoanVO loanVO) throws exception;
}
