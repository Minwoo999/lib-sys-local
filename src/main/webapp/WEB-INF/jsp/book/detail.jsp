<%-- 1. 페이지 설정 및 인코딩 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 2. URL 생성을 위한 JSTL Core (링크 걸 때 필요) --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
    <h2>📖 도서 상세 정보</h2>
    <hr>

    <table border="1">
        <tr>
            <th>도서 번호</th>
            <td>${detail.bookId}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${detail.title}</td>
        </tr>
        <tr>
            <th>저자</th>
            <td>${detail.author}</td>
        </tr>
        <tr>
            <th>설명</th>
            <td>${detail.bookDesc}</td>
        </tr>
    </table>

    <br>
    <a href="<c:url value='/book/list.do'/>">⬅️ 목록으로 돌아가기</a>
</section>