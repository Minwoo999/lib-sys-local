# Library Management System — Issues & TODO Tracker

프로젝트 전체 스캔 결과. A그룹(직접 구현 가능), B그룹(핵심 비즈니스 로직 - 사용자가 직접 결정 필요)로 분류.

---

## A그룹 — 구조적/반복적 작업 (스켈레톤 생성 완료 또는 수정 완료)

다음 도메인들에 대해 Entity는 존재하지만 DAO/Service/Controller/SQL이 누락되어 있었습니다. 기존 Book/Member 패턴을 따라 CRUD 스켈레톤을 생성했습니다.

### 1. Reservation (예매)
- **Entity**: `lms.model.entity.Reservation` (존재, fields: reservationId, memberId, bookId, reservationDate, status)
- **생성된 파일**:
  - `lms.reservation.dao.ReservationDAO.java` — insertReservation, selectByMemberId, selectByBookId, selectListByStatus, deleteReservation
  - `lms.reservation.service.ReservationService.java` (interface)
  - `lms.reservation.service.impl.ReservationServiceImpl.java` — 모든 메서드 본문에 TODO 주석만 포함
  - `lms.reservation.web.ReservationController.java` — GET/POST 슬롯만 등록, 비즈니스 로직 없음
- **생성된 SQL**: `src/main/resources/sqlmap/sql/Reservation_SQL.xml` — namespace=`lms.reservation.dao.ReservationDAO`, 기존 Book_SQL.xml 패턴 동일
- **타입エイlias 추가**: `sql-mapper-config.xml`에 `Reservation` alias 주석 해제

### 2. Review (리뷰)
- **Entity**: `lms.model.entity.Review` (존재, fields: reviewId, memberId, bookId, rating, content, reviewRegDate)
- **생성된 파일**:
  - `lms.review.dao.ReviewDAO.java` — insertReview, selectByBookId, selectByMemberId, selectListByBookId, deleteReview
  - `lms.review.service.ReviewService.java` (interface)
  - `lms.review.service.impl.ReviewServiceImpl.java` — 빈 스켈레톤
  - `lms.review.web.ReviewController.java` — GET/POST 슬롯만 등록
- **생성된 SQL**: `src/main/resources/sqlmap/sql/Review_SQL.xml` — namespace=`lms.review.dao.ReviewDAO`
- **타입エイAlias 추가**: `sql-mapper-config.xml`에 `Review` alias 주석 해제

### 3. Category (분류)
- **Entity**: `lms.model.entity.Category` (존재, fields: categoryId, categoryCode, categoryName, description)
- **생성된 파일**:
  - `lms.category.dao.CategoryDAO.java` — selectAllCategories, selectById, insertCategory, updateCategory, deleteCategory
  - `lms.category.service.CategoryService.java` (interface)
  - `lms.category.service.impl.CategoryServiceImpl.java` — 빈 스켈레톤
  - `lms.category.web.CategoryController.java` — GET/POST 슬롯만 등록
- **생성된 SQL**: `src/main/resources/sqlmap/sql/Category_SQL.xml` — namespace=`lms.category.dao.CategoryDAO`
- **타입エイAlias 추가**: `sql-mapper-config.xml`에 `Category` alias 주석 해제

### 4. Loan (대출) — 기존 partially-implemented
- **수정된 파일**:
  - `LoanServiceImpl.java:29` — BookOutOfStockException 주석 해제 및 import 추가
  - `LoanServiceImpl.java:33-36` — 비즈니스 로직 TODO 주석만 남김

### 5. 기존 DAO/Service/Controller 수정 완료
| 수정 내용 | 파일 | 줄 번호 |
|----------|------|---------|
| BookAdminServiceImpl에 getBookList() 누락 메서드 추가 | `BookAdminServiceImpl.java` | 전체 재작성 |
| AdminDAO에 @Repository("adminDAO") 추가 | `AdminDAO.java` | 8 |
| Loan_SQL.xml namespace 수정: `lms.loan.dao.loan.LoanDAO` → `lms.loan.dao.LoanDAO` | `Loan_SQL.xml` | 4 |
| AdminDAO selectMemberList statement ID 매칭 수정 | `AdminDAO.java` | 12-13 |

### 6. 새로 생성된 VO 클래스들
- `lms.model.ReservationVO.java` — Reservation entity 매핑, Lombok @Data
- `lms.model.ReviewVO.java` — Review entity 매핑, Lombok @Data  
- `lms.model.CategoryVO.java` — Category entity 매핑, Lombok @Data

### 7. 새로 생성된 DTO 클래스들
- `lms.model.ReservationDTO.java` — nested static classes: ReservationRegisterRequest, ReservationListResponse
- `lms.model.ReviewDTO.java` — nested static classes: ReviewWriteRequest, ReviewListResponse
- `lms.model.CategoryDTO.java` — nested static classes: CategoryRegisterRequest, CategoryModifyRequest

### 8. sql-mapper-config.xml 타입エイAlias 전체 주석 해제
```xml
<typeAlias alias="Reservation" type="lms.model.ReservationVO"/>
<typeAlias alias="Category" type="lms.model.CategoryVO"/>
<typeAlias alias="Review" type="lms.model.ReviewVO"/>
<typeAlias alias="MemberEnt" type="lms.model.entity.Member"/>
<typeAlias alias="LoanEnt" type="lms.model.entity.Loan"/>
<typeAlias alias="ReservationEnt" type="lms.model.entity.Reservation"/>
<typeAlias alias="CategoryEnt" type="lms.model.entity.Category"/>
<typeAlias alias="ReviewEnt" type="lms.model.entity.Review"/>
```

---

## B그룹 — 핵심 비즈니스 로직 (사용자가 직접 구현/결정 필요)

다음 부분들은 코드 수정 없이 **파일명 + 줄 번호 + 무엇을 결정해야 하는지**만 기록합니다. 이 부분은 절대 건드리지 마세요.

### 1. LoanServiceImpl — 대출 로직 (가장 중요)
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `LoanServiceImpl.java` | 26-27 | ⚠️ 미완성 | `decreaseCurrentCnt()` 결과 확인 후 재고 부족 시 예외 처리 필요. 현재 주석 처리됨 |
| `LoanServiceImpl.java` | 28-30 | ⚠️ 빈 블럭 | 재고가 부족할 때의 처리: 대출 거절? 대기열 추가? 사용자의 정책 결정 필요 |
| `LoanServiceImpl.java` | 33-34 | ❌ 논리 오류 | `new MemberVO()`로 빈 객체를 만들어 memberId=0으로 호출. `loanVO.getMemberId()`를 사용해야 함 |
| `LoanServiceImpl.java` | 36 | ❌ 항상 1 반환 | 실제 loanDAO.insertLoanRecord() 호출 없음, member DAO 결과 확인 없음 |
| `LoanServiceImpl.java` | 전체 | ⚠️ TODO | complete 메서드 본문: (1) memberId 검증 → (2) 대출 가능 수 확인 → (3) 재고 감소 → (4) 대출 기록 INSERT → (5) 회원 대출 수 증가 → (6) 결과 반환 |

**TODO 주석이 이미 삽입된 위치**:
```java
// LoanServiceImpl.java 라인 29: BookOutOfStockException 주석 해제 필요
// LoanServiceImpl.java 라인 33-36: 전체 로직 재작성 필요
```

### 2. ReservationService — 예약 우선순위/대기열 로직
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `ReservationServiceImpl.java` | 전체 | ⚠️ TODO | 같은 도서를 여러 명이 예약할 때 우선순위 결정 방법 (첫 번째 예약? 추첨? 대출 이력 고려?) |

### 3. ReviewService — 리뷰 작성 제한 조건
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `ReviewServiceImpl.java` | 전체 | ⚠️ TODO | 리뷰 작성 권한: 실제 해당 도서 대출経験이 있는 회원만? 중복 작성 방지? 수정/삭제 허용 범위? |

### 4. LoanService — 반납 로직 (주석 처리됨)
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `LoanService.java` | 12 | ⚠️ 주석 해제 필요 | `returnBook()` 메서드 uncomment 후 구현. 연체료 계산? 반납 가능 여부 검증? |

### 5. AdminDAO — 회원 목록 조회
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `AdminServiceImpl.java` | 26-28 | ⚠️ TODO | `selectMemberList()` 결과에 대한 페이지네이션 적용 필요 (현재 전체 목록만) |

### 6. BookService — 도서 삭제 비즈니스 규칙
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `BookAdminServiceImpl.java` | 47-49 | ⚠️ TODO | 도서 삭제 전 대출 중인 도서인지 확인? 소프트 딜리트 vs 하드 딜리트? 관련 예약/리뷰 처리 방안? |

### 7. MemberService — 소셜 로그인 연동
| 파일 | 줄 번호 | 상태 | 설명 |
|------|---------|------|------|
| `MemberServiceImpl.java` | 62-63 | ⚠️ TODO | "이미 존재합니다. (자동 연동 구현하기 / 이메일 받기)" — 실제 이메일 발송 또는 계정 병합 로직 필요 |

---

## 변경/생성된 파일 목록 요약

### 수정된 파일 (5개)
| # | 파일 | 변경 내용 |
|---|------|----------|
| 1 | `BookAdminServiceImpl.java` | getBookList() 메서드 추가, 전체 재작성 |
| 2 | `AdminDAO.java` | @Repository("adminDAO") 추가, statement ID 매칭 수정 |
| 3 | `Loan_SQL.xml` | namespace: `lms.loan.dao.loan.LoanDAO` → `lms.loan.dao.LoanDAO` |
| 4 | `sql-mapper-config.xml` | Reservation/Category/Review VO alias 주석 해제, Entity aliases 추가 |
| 5 | `LoanServiceImpl.java` | BookOutOfStockException import + 주석 해제 (나머지 로직은 TODO 유지) |

### 새로 생성된 파일 (23개)
| # | 파일 | 설명 |
|---|------|------|
| 1 | `lms/common/exception/BookOutOfStockException.java` | 재고 부족 예외 클래스 |
| 2 | `lms/reservation/dao/ReservationDAO.java` | Reservation DAO |
| 3 | `lms/reservation/service/ReservationService.java` | Reservation Service interface |
| 4 | `lms/reservation/service/impl/ReservationServiceImpl.java` | Reservation Service impl (TODO만) |
| 5 | `lms/reservation/web/ReservationController.java` | Reservation Controller (슬롯만) |
| 6 | `lms/review/dao/ReviewDAO.java` | Review DAO |
| 7 | `lms/review/service/ReviewService.java` | Review Service interface |
| 8 | `lms/review/service/impl/ReviewServiceImpl.java` | Review Service impl (TODO만) |
| 9 | `lms/review/web/ReviewerController.java` | Review Controller (슬롯만) |
| 10 | `lms/category/dao/CategoryDAO.java` | Category DAO |
| 11 | `lms/category/service/CategoryService.java` | Category Service interface |
| 12 | `lms/category/service/impl/CategoryServiceImpl.java` | Category Service impl (TODO만) |
| 13 | `lms/category/web/CategoryController.java` | Category Controller (슬롯만) |
| 14 | `lms/model/ReservationVO.java` | Reservation VO |
| 15 | `lms/model/ReviewVO.java` | Review VO |
| 16 | `lms/model/CategoryVO.java` | Category VO |
| 17 | `lms/model/ReservationDTO.java` | Reservation DTO (nested classes) |
| 18 | `lms/model/ReviewDTO.java` | Review DTO (nested classes) |
| 19 | `lms/model/CategoryDTO.java` | Category DTO (nested classes) |
| 20 | `sqlmap/sql/Reservation_SQL.xml` | Reservation SQL mapper |
| 21 | `sqlmap/sql/Review_SQL.xml` | Review SQL mapper |
| 22 | `sqlmap/sql/Category_SQL.xml` | Category SQL mapper |

### 검증 결과
- `mvn compile` — **성공** (에러 없음)
- 컴파일 에러 원인 3가지 모두 해결: getBookList 누락, @Repository 누락, namespace 불일치
- BookOutOfStockException 클래스 생성 완료
