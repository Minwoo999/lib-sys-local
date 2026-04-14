package lms.book.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.BookUserDTO;
import lms.model.entity.Book;

@Repository("bookDAO")
public class BookDAO extends EgovAbstractMapper {

    // 도서 상세 조회 Book selectBook(int bookId);
    public Book selectBookDetail(int bookId) {
        return selectOne("BookDAO.selectBookDetail", bookId);
    }

    // 도서 목록 List<Book> selectBookList(Book book);
    public List<Book> selectBookList(BookUserDTO.BookSearchRequest searchRequest) {
        return selectList("BookDAO.selectBookList", searchRequest);
    }

    // 페이징, 페이지에 나오는 도서의 수 int selectBookListCount(Book book);
    public int selectBookListCount(BookUserDTO.BookSearchRequest searchRequest) {
        return selectOne("BookDAO.selectBookListCount", searchRequest);
    }

    // 도서 등록 int insertBook(Book book);
    public int insertBook(Book book) {
        return insert("BookDAO.insertBook", book);
    }

    // 도서 정보 수정 int updateBookDetail(Book book);
    public int updateBookDetail(Book book) {
        return update("BookDAO.updateBookDetail", book);
    }

    // 도서 상태 수정 int updateBookStatus(Book book);
    public int updateBookStatus(Book book) {
        return update("BookDAO.updateBookStatus", book);
    }

    // 도서 삭제 int deleteBook(int bookId);
    public int deleteBook(int bookId) {
        return delete("BookDAO.deleteBook", bookId);
    }
}