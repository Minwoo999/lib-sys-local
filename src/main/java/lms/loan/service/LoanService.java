package lms.loan.service;

import lms.model.LoanVO;

public interface LoanService {
    int loanBook(LoanVO loanVO) throws Exception;

    // int returnBook(LoanVO loanVO) throws Exception;
}
