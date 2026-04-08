<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header style="background-color: #f8f9fa; border-bottom: 2px solid #dee2e6; padding: 10px;">
    <div style="display: flex; justify-content: space-between; align-items: center;">
        
        <h2>
            <a href="<c:url value='/index.do'/>" style="text-decoration: none; color: #333;">
                📚 도서 관리 시스템 <span style="color: red;">[ADMIN]</span>
            </a>
        </h2>

        <nav>
            <ul style="list-style: none; display: flex; gap: 20px;">
                <li>
                    <a href="<c:url value='/admin/memberList.do'/>">회원 관리</a>
                </li>
                <li>
                    <a href="<c:url value='/admin/bookList.do'/>">도서 관리</a>
                </li>
                <li>
                    <a href="<c:url value='/member/logout.do'/>" style="color: gray;">로그아웃</a>
                </li>
            </ul>
        </nav>
    </div>
</header>