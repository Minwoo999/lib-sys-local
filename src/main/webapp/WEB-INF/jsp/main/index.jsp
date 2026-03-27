<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
  메인 화면의 실제 내용을 담당하는 부분입니다.
  Layout에서 <body> 태그 안에 위치하게 되므로 <html>이나 <body> 태그는 생략합니다.
--%>
<section>
    <h2>🏠 환영합니다!</h2>
    <p>도서 관리 시스템의 메인 페이지입니다.</p>
    
    <div class="menu-box">
        <h3>빠른 메뉴</h3>
        <ul>
            <%-- 
               나중에 도서 목록으로 이동할 링크입니다.
               Spring Controller에서 설정한 .do 주소를 사용합니다.
            --%>
            <li><a href="<c:url value='/book/list.do'/>">📖 도서 목록 보기</a></li>
        </ul>
    </div>
</section>