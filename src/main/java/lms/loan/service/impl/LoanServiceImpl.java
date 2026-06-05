package lms.loan.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lms.book.dao.BookDAO;
import lms.loan.dao.LoanDAO;
import lms.loan.service.LoanService;
import lms.member.dao.MemberDAO;
import lms.model.LoanVO;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("loanService")
public class LoanServiceImpl implements LoanService {
    
    private final MemberDAO memberDAO;
    private final BookDAO bookDAO;
    private final LoanDAO loanDAO;

    @Override
    @Transactional
    public int loanBook(LoanVO loanVO) throws Exception{
        int bookResult = bookDAO.decreaseCurrentCnt(loanVO.getBookId());
        
        if (bookResult == 0) {
            
        }


        MemberVO memberVO = new MemberVO();
        int memberResult = memberDAO.increaseCurrentLoanCnt(memberVO.getMemberId());
        
        return 1;
    }
}
