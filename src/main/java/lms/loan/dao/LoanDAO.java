package lms.loan.dao;

import org.springframework.stereotype.Repository;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.LoanVO;

@Repository("loanDAO")
public class LoanDAO extends EgovAbstractMapper {

    public int insertLoanRecord(LoanVO loanVO) {
        return insert("LoanDAO.insertLoanRecord", loanVO);
    }

    public int updateReturnDate(Long loanId) {
        return update("LoanDAO.updateReturnDate", loanId);
    }

    public int updateDueDate(LoanVO loanVO) {
        return update("LoanDAO.updateDueDate", loanVO);
    }
}