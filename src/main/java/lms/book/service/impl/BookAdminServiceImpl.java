package lms.book.service.impl;

import org.springframework.stereotype.Service;

import lms.book.dao.BookDAO;
import lms.model.BookAdminDTO.BookDetailAdminResponse;
import lms.model.BookAdminDTO.BookModifyDetailRequest;
import lms.model.BookAdminDTO.BookModifyStatusRequest;
import lms.model.BookAdminDTO.BookRegisterRequest;
import lms.model.entity.Book;
import lms.book.service.BookAdminService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BookAdminServiceImpl implements BookAdminService {

    private final BookDAO bookDAO;

    @Override
    public BookDetailAdminResponse getDetail(int bookId) {
        Book book = bookDAO.selectBookDetail(bookId);
        return BookDetailAdminResponse.toDTO(book);
    }

    @Override
    public int registerBook(BookRegisterRequest registerRequest) {
        Book book = registerRequest.toEntity();
        return bookDAO.insertBook(book);
    }

    @Override
    public int modifyDetail(BookModifyDetailRequest modifyDetailRequest) {
        Book book = modifyDetailRequest.toEntity();
        return bookDAO.updateBookDetail(book);
    }

    @Override
    public int modifyStatus(BookModifyStatusRequest modifyStatusRequest) {
        Book book = modifyStatusRequest.toEntity();
        return bookDAO.updateBookStatus(book);
    }

    @Override
    public int removeBook(int bookId) {
        return bookDAO.deleteBook(bookId);
    }
}
