<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section style="width: 800px; margin: 30px auto;">
    <h2>📚 도서 관리 목록</h2>
    
    <div style="margin-bottom: 15px; text-align: right;">
        <a href="<c:url value='/book/admin/register.do'/>" 
           style="padding: 8px 16px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px;">
            + 도서 등록
        </a>
    </div>

    <table border="1" style="width: 100%; border-collapse: collapse;">
        <thead>
            <tr style="background-color: #f8f9fa;">
                <th style="padding: 10px; text-align: center; width: 60px;">번호</th>
                <th style="padding: 10px; text-align: left;">제목</th>
                <th style="padding: 10px; text-align: left; width: 120px;">저자</th>
                <th style="padding: 10px; text-align: center; width: 80px;">상태</th>
                <th style="padding: 10px; text-align: center; width: 150px;">관리</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty books}">
                    <tr>
                        <td colspan="5" style="padding: 20px; text-align: center; color: #666;">
                            등록된 도서가 없습니다.
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="book" items="${books}" varStatus="status">
                        <tr>
                            <td style="padding: 10px; text-align: center;">${book.bookId}</td>
                            <td style="padding: 10px;">${book.title}</td>
                            <td style="padding: 10px;">${book.author}</td>
                            <td style="padding: 10px; text-align: center;">
                                ${book.currentCnt}/${book.totalCnt}
                            </td>
                            <td style="padding: 10px; text-align: center;">
                                <a href="<c:url value='/book/admin/detail.do?bookId=${book.bookId}'/>">
                                    상세
                                </a> | 
                                <a href="<c:url value='/book/admin/modify.do?bookId=${book.bookId}'/>">
                                    수정
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</section>
