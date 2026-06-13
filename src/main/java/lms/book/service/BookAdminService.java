package lms.book.service;

import java.util.List;

import lms.model.BookAdminDTO;
import lms.model.entity.Book;

public interface BookAdminService {
    int registerBook(BookAdminDTO.BookRegisterRequest registerRequest);

    int modifyDetail(BookAdminDTO.BookModifyDetailRequest modifyDetailRequest);

    int modifyStatus(BookAdminDTO.BookModifyStatusRequest modifyStatusRequest);

    int removeBook(int bookId);

    BookAdminDTO.BookDetailAdminResponse getDetail(int bookId);
    
    // 도서 전체 목록 조회
    List<Book> getBookList();
}
