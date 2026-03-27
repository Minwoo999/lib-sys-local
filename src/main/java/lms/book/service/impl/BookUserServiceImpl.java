package lms.book.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lms.book.dao.BookDAO;
import lms.book.service.BookUserService;
import lms.book.service.BookUserDTO.BookDetailUserResponse;
import lms.book.service.BookUserDTO.BookListResponse;
import lms.book.service.BookUserDTO.BookSearchRequest;
import lms.model.entity.Book;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BookUserServiceImpl implements BookUserService {

    private final BookDAO bookDAO;

    @Override
    public BookDetailUserResponse findDetail(int bookId) {
        Book book = bookDAO.selectBookDetail(bookId);
        return BookDetailUserResponse.toDTO(book);
    }

    @Override
    public Map<String, Object> findList(BookSearchRequest searchRequest) {
        searchRequest.calculatePage();

        List<Book> books = bookDAO.selectBookList(searchRequest);
        List<BookListResponse> listResponse = new ArrayList<>();
        for (Book book : books) {
            listResponse.add(BookListResponse.toDTO(book));
        }

        int totalCount = bookDAO.selectBookListCount(searchRequest);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultList", listResponse);
        resultMap.put("totalCount", totalCount);

        return resultMap;
    }
}
