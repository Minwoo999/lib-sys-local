<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section style="width: 700px; margin: 30px auto;">
    <h2>📖 도서 상세 정보</h2>
    <hr>

    <table border="1" style="width: 100%; border-collapse: collapse;">
        <tr>
            <th style="padding: 12px; width: 120px; background-color: #f8f9fa;">도서 번호</th>
            <td style="padding: 12px;">${detail.bookId}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">제목</th>
            <td style="padding: 12px;">${detail.title}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">저자</th>
            <td style="padding: 12px;">${detail.author}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">출판사</th>
            <td style="padding: 12px;">${detail.publisher}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">카테고리</th>
            <td style="padding: 12px;">${detail.categoryCode}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">설명</th>
            <td style="padding: 12px;">${detail.bookDesc}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">총 수량</th>
            <td style="padding: 12px;">${detail.totalCnt}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">대출 가능</th>
            <td style="padding: 12px;">${detail.currentCnt}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">손상 수량</th>
            <td style="padding: 12px;">${detail.damagedCnt}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">등록일</th>
            <td style="padding: 12px;">${detail.bookRegDateTime}</td>
        </tr>
    </table>

    <div style="margin-top: 20px; text-align: center;">
        <a href="<c:url value='/book/admin/list.do'/>" 
           style="padding: 8px 16px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 4px; margin-right: 10px;">
            목록으로
        </a>
        <a href="<c:url value='/book/admin/modify.do?bookId=${detail.bookId}'/>" 
           style="padding: 8px 16px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px; margin-right: 10px;">
            수정
        </a>
        <form action="<c:url value='/book/admin/remove.do'/>" method="post" style="display: inline;" 
              onsubmit="return confirm('정말 삭제하시겠습니까?');">
            <input type="hidden" name="bookId" value="${detail.bookId}"/>
            <button type="submit" 
                    style="padding: 8px 16px; background-color: #dc3545; color: white; border: none; border-radius: 4px; cursor: pointer;">
                삭제
            </button>
        </form>
    </div>
</section>
