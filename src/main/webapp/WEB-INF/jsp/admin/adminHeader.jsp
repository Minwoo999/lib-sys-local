<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header style="background-color: #f8f9fa; border-bottom: 2px solid #dee2e6; padding: 10px;">
    <div style="display: flex; justify-content: space-between; align-items: center;">
        
        <h2>
            <a href="<c:url value='/index.do'/>" style="text-decoration: none; color: #333;">
                📚 도서 관리 시스템 
                <c:if test="${sessionScope.loginUser.isAdmin()}">
                    <span style="color: red; font-size: 0.8em;">[ADMIN]</span>
                </c:if>
            </a>
        </h2>

        <nav>
            <ul style="list-style: none; display: flex; gap: 20px; align-items: center; margin: 0; padding: 0;">
                
                <c:choose>
                    <%-- [1] 로그인 상태일 때 --%>
                    <c:when test="${not empty sessionScope.loginUser}">
                        
                        <%-- (A) 일반 유저/관리자 공통 --%>
                        <li><a href="<c:url value='/member/myPage.do'/>" style="text-decoration: none; color: #333;">마이페이지</a></li>
                        
                        <%-- (B) 관리자일 때만 '회원목록', '도서목록' 즉시 노출 --%>
                        <c:if test="${sessionScope.loginUser.isAdmin()}">
                            <li style="border-left: 1px solid #ccc; padding-left: 20px; margin-left: 10px;">
                                <a href="<c:url value='/admin/memberList.do'/>" style="text-decoration: none; color: #007bff; font-weight: bold;">회원 관리</a>
                            </li>
                            <li>
                                <a href="<c:url value='/admin/bookList.do'/>" style="text-decoration: none; color: #007bff; font-weight: bold;">도서 관리</a>
                            </li>
                        </c:if>
                        
                        <%-- (C) 로그아웃 --%>
                        <li style="margin-left: 20px;">
                            <a href="<c:url value='/member/logout.do'/>" style="text-decoration: none; color: gray; font-size: 0.9em;">로그아웃</a>
                        </li>
                    </c:when>

                    <%-- [2] 비로그인 상태일 때 --%>
                    <c:otherwise>
                        <li><a href="<c:url value='/member/login.do'/>" style="text-decoration: none; color: #333;">로그인</a></li>
                        <li><a href="<c:url value='/member/join.do'/>" style="text-decoration: none; color: #333;">회원가입</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </nav>
    </div>
</header>