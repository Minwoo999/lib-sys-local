package lms.book.service;

import lms.model.BookAdminDTO;

public interface BookAdminService {
    int registerBook(BookAdminDTO.BookRegisterRequest registerRequest);

    int modifyDetail(BookAdminDTO.BookModifyDetailRequest modifyDetailRequest);

    int modifyStatus(BookAdminDTO.BookModifyStatusRequest modifyStatusRequest);

    int removeBook(int bookId);

    BookAdminDTO.BookDetailAdminResponse getDetail(int bookId);
}
