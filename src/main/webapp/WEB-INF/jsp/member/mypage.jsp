<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width: 600px; margin: 50px auto; padding: 30px; border: 1px solid #ddd; border-radius: 12px; background-color: #fff; box-shadow: 0 4px 6px rgba(0,0,0,0.1);">
    <h2 style="text-align: center; color: #333; margin-bottom: 30px;">내 정보 확인</h2>

    <table style="width: 100%; border-collapse: collapse; margin-bottom: 30px;">
        <colgroup>
            <col style="width: 30%; background-color: #f9f9f9;">
            <col style="width: 70%;">
        </colgroup>
        <tr style="border-bottom: 1px solid #eee;">
            <th style="padding: 15px; text-align: left;">아이디</th>
            <td style="padding: 15px;"><strong>${sessionScope.loginUser.loginId}</strong></td>
        </tr>
        <tr style="border-bottom: 1px solid #eee;">
            <th style="padding: 15px; text-align: left;">이름</th>
            <td style="padding: 15px;">${sessionScope.loginUser.name}</td>
        </tr>
        <tr style="border-bottom: 1px solid #eee;">
            <th style="padding: 15px; text-align: left;">이메일</th>
            <td style="padding: 15px;">${sessionScope.loginUser.email}</td>
        </tr>
        <tr style="border-bottom: 1px solid #eee;">
            <th style="padding: 15px; text-align: left;">전화번호</th>
            <td style="padding: 15px;">${sessionScope.loginUser.phone}</td>
        </tr>
        <tr>
            <th style="padding: 15px; text-align: left;">회원 권한</th>
            <td style="padding: 15px;">
                <c:choose>
                    <c:when test="${sessionScope.loginUser.isAdmin()}">
                        <span style="color: red; font-weight: bold;">관리자(ADMIN)</span>
                    </c:when>
                    <c:otherwise>일반 회원</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>

    <div style="display: flex; gap: 10px; justify-content: center;">
        <a href="<c:url value='/member/update.do'/>" 
           style="flex: 1; text-align: center; padding: 12px; background-color: #007bff; color: white; text-decoration: none; border-radius: 5px;">
           정보 수정
        </a>
        <a href="<c:url value='/member/withdraw.do'/>" 
           onclick="return confirm('정말 탈퇴하시겠습니까?');"
           style="flex: 1; text-align: center; padding: 12px; background-color: #dc3545; color: white; text-decoration: none; border-radius: 5px;">
           회원 탈퇴
        </a>
    </div>
</div>