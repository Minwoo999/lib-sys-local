<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section style="width: 900px; margin: 30px auto;">
    <h2>👥 회원 관리 목록</h2>
    
    <table border="1" style="width: 100%; border-collapse: collapse;">
        <thead>
            <tr style="background-color: #f8f9fa;">
                <th style="padding: 10px; text-align: center; width: 60px;">번호</th>
                <th style="padding: 10px; text-align: left; width: 120px;">아이디</th>
                <th style="padding: 10px; text-align: left; width: 100px;">이름</th>
                <th style="padding: 10px; text-align: left; width: 180px;">이메일</th>
                <th style="padding: 10px; text-align: center; width: 120px;">전화번호</th>
                <th style="padding: 10px; text-align: center; width: 80px;">권한</th>
                <th style="padding: 10px; text-align: center; width: 80px;">상태</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${empty list}">
                    <tr>
                        <td colspan="7" style="padding: 20px; text-align: center; color: #666;">
                            등록된 회원이 없습니다.
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="member" items="${list}" varStatus="status">
                        <tr>
                            <td style="padding: 10px; text-align: center;">${status.count}</td>
                            <td style="padding: 10px;">${member.loginId}</td>
                            <td style="padding: 10px;">${member.name}</td>
                            <td style="padding: 10px;">${member.email}</td>
                            <td style="padding: 10px; text-align: center;">${member.phone}</td>
                            <td style="padding: 10px; text-align: center;">
                                <c:choose>
                                    <c:when test="${member.isAdmin()}">
                                        <span style="color: red; font-weight: bold;">관리자</span>
                                    </c:when>
                                    <c:otherwise>일반</c:otherwise>
                                </c:choose>
                            </td>
                            <td style="padding: 10px; text-align: center;">${member.status}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</section>
