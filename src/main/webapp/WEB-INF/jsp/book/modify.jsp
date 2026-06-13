<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section style="width: 500px; margin: 30px auto;">
    <h2>✏️ 도서 수정</h2>
    <hr>

    <form action="<c:url value='/book/admin/modify.do'/>" method="post">
        <input type="hidden" name="bookId" value="${detail.bookId}"/>

        <div style="margin-bottom: 15px;">
            <label for="title">제목 *</label><br/>
            <input type="text" id="title" name="title" required value="${detail.title}" 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 15px;">
            <label for="author">저자 *</label><br/>
            <input type="text" id="author" name="author" required value="${detail.author}" 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 15px;">
            <label for="publisher">출판사</label><br/>
            <input type="text" id="publisher" name="publisher" value="${detail.publisher}" 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 15px;">
            <label for="categoryCode">카테고리 *</label><br/>
            <input type="number" id="categoryCode" name="categoryCode" required value="${detail.categoryCode}" 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <div style="margin-bottom: 20px;">
            <label for="bookDesc">설명</label><br/>
            <textarea id="bookDesc" name="bookDesc" rows="4" 
                      style="width: 100%; padding: 8px; box-sizing: border-box;">${detail.bookDesc}</textarea>
        </div>

        <div style="text-align: center;">
            <button type="submit" 
                    style="padding: 10px 30px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1em;">
                수정 완료
            </button>
            <a href="<c:url value='/book/admin/detail.do?bookId=${detail.bookId}'/>" 
               style="padding: 10px 30px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 4px; margin-left: 10px;">
                취소
            </a>
        </div>
    </form>
</section>
