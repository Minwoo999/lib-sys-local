<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section style="width: 500px; margin: 30px auto;">
    <h2>📝 도서 등록</h2>
    <hr>

    <!-- 도서 정보를 입력받는 폼 -->
    <form action="<c:url value='/book/admin/register.do'/>" method="post">
        <!-- 제목 입력 필드 -->
        <div style="margin-bottom: 15px;">
            <label for="title">제목 *</label><br/>
            <input type="text" id="title" name="title" required 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <!-- 저자 입력 필드 -->
        <div style="margin-bottom: 15px;">
            <label for="author">저자 *</label><br/>
            <input type="text" id="author" name="author" required 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <!-- 출판사 입력 필드 -->
        <div style="margin-bottom: 15px;">
            <label for="publisher">출판사</label><br/>
            <input type="text" id="publisher" name="publisher" 
                   style="width: 100%; padding: 8px; box-sizing: border-box;">
        </div>

        <!-- 카테고리 코드 입력 필드 -->
        <div style="margin-bottom: 15px;">
            <label for="categoryCode">카테고리 *</label><br/>
            <input type="number" id="categoryCode" name="categoryCode" required 
                   style="width: 100%; padding: 8px; box-sizing: border-box;" placeholder="예: 1, 2, 3...">
        </div>

        <!-- 도서 설명 입력 필드 -->
        <div style="margin-bottom: 15px;">
            <label for="bookDesc">설명</label><br/>
            <textarea id="bookDesc" name="bookDesc" rows="4" 
                      style="width: 100%; padding: 8px; box-sizing: border-box;"></textarea>
        </div>

        <!-- 총 수량 입력 필드 -->
        <div style="margin-bottom: 20px;">
            <label for="totalCnt">총 수량 *</label><br/>
            <input type="number" id="totalCnt" name="totalCnt" required 
                   style="width: 100%; padding: 8px; box-sizing: border-box;" placeholder="예: 5">
        </div>

        <!-- 제출 및 목록으로 이동 버튼 -->
        <div style="text-align: center;">
            <button type="submit" 
                    style="padding: 10px 30px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1em;">
                등록 완료
            </button>
            <a href="<c:url value='/book/admin/list.do'/>" 
               style="padding: 10px 30px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 4px; margin-left: 10px;">
                목록으로
            </a>
        </div>
    </form>
</section>
