package lms.common.exception;

/**
 * 도서 재고 부족 예외
 * 대출 시 재고가 남아있지 않을 때 발생
 */
public class BookOutOfStockException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookOutOfStockException(String message) {
        super(message);
    }

}
