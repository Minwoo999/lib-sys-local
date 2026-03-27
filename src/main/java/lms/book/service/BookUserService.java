package lms.book.service;

import java.util.Map;

public interface BookUserService {

    BookUserDTO.BookDetailUserResponse findDetail(int bookId);

    Map<String, Object> findList(BookUserDTO.BookSearchRequest searchRequest);
}
