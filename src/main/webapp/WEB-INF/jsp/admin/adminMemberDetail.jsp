<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section style="width: 700px; margin: 30px auto;">
    <h2>👤 회원 상세 정보</h2>
    <hr>

    <table border="1" style="width: 100%; border-collapse: collapse;">
        <tr>
            <th style="padding: 12px; width: 120px; background-color: #f8f9fa;">회원 번호</th>
            <td style="padding: 12px;">${member.memberId}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">아이디</th>
            <td style="padding: 12px;">${member.loginId}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">이름</th>
            <td style="padding: 12px;">${member.name}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">이메일</th>
            <td style="padding: 12px;">${member.email}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">전화번호</th>
            <td style="padding: 12px;">${member.phone}</td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">권한</th>
            <td style="padding: 12px;">
                <c:choose>
                    <c:when test="${member.isAdmin()}">
                        <span style="color: red; font-weight: bold;">관리자 (ADMIN)</span>
                    </c:when>
                    <c:otherwise>일반 회원</c:otherwise>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th style="padding: 12px; background-color: #f8f9fa;">상태</th>
            <td style="padding: 12px;">${member.status}</td>
        </tr>
    </table>

    <div style="margin-top: 20px; text-align: center;">
        <a href="<c:url value='/admin/memberList.do'/>" 
           style="padding: 8px 16px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 4px; margin-right: 10px;">
            목록으로
        </a>
        
        <button type="button" onclick="document.getElementById('statusForm').style.display='block'" 
                style="padding: 8px 16px; background-color: #ffc107; color: white; border: none; border-radius: 4px; margin-right: 10px; cursor: pointer;">
            상태 변경
        </button>

        <form id="statusForm" action="<c:url value='/admin/changeStatus.do'/>" method="post" 
              style="display: none; margin-top: 15px; padding: 15px; background-color: #f8f9fa; border-radius: 4px;">
            <input type="hidden" name="memberId" value="${member.memberId}"/>
            <div style="margin-bottom: 10px;">
                <label>새 상태:</label>
                <select name="status" style="padding: 5px; margin-left: 10px;">
                    <option value="ACTIVE" ${member.status == 'ACTIVE' ? 'selected' : ''}>활성</option>
                    <option value="SUSPENDED" ${member.status == 'SUSPENDED' ? 'selected' : ''}>정지</option>
                    <option value="DELETED" ${member.status == 'DELETED' ? 'selected' : ''}>탈퇴</option>
                </select>
            </div>
            <button type="submit" style="padding: 6px 12px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer;">
                적용
            </button>
        </form>

        <a href="<c:url value='/admin/updateMember.do?memberId=${member.memberId}'/>" 
           style="padding: 8px 16px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px;">
            정보 수정
        </a>
    </div>
</section>
