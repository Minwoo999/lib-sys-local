<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header style="padding: 20px; background-color: #f8f9fa; border-bottom: 1px solid #dee2e6;">
    <div style="display: flex; justify-content: space-between; align-items: center;">
        <h1 style="margin: 0;"><a href="<c:url value='/index.do'/>" style="text-decoration: none; color: #333;">📚 도서 관리 시스템</a></h1>
        
        <nav>
            <%-- 세션에 loginUser 정보가 있는지 확인 (로그인 여부 판단) --%>
            <c:choose>
                <c:when test="${empty sessionScope.loginUser}">
                    <%-- 로그인하지 않은 경우 --%>
                    <a href="<c:url value='/member/login.do'/>" style="margin-left: 15px;">로그인</a>
                    <a href="<c:url value='/member/join.do'/>" style="margin-left: 15px;">회원가입</a>
                </c:when>
                <c:otherwise>
                    <%-- 로그인한 경우 --%>
                    <strong>${sessionScope.loginUser.name}</strong>님 환영합니다!
                    <a href="<c:url value='/member/mypage.do'/>" style="margin-left: 15px;">내 정보</a>
                    <a href="<c:url value='/member/logout.do'/>" style="margin-left: 15px; color: red;">로그아웃</a>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</header>