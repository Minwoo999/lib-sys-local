<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
    <h2>📖 도서 목록</h2>
    <p>현재 등록된 도서 리스트입니다.</p>

    <table border="1">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>저자</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var ="book" items="${resultList}">
         <tr>
             <td>${book.bookId}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
    </tbody>

    </table>
</section>