<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width: 500px; margin: 50px auto; padding: 30px; border: 1px solid #ccc; border-radius: 10px;">
    <h2 style="text-align: center;">회원가입</h2>

    <form action="<c:url value='/member/join.do'/>" method="post">
        <div style="margin-bottom: 15px;">
            <label>아이디</label><br/>
            <input type="text" name="loginId" style="width: 80%; padding: 8px;" required>
            <button type="button" style="padding: 8px;">중복확인</button>
        </div>

        <div style="margin-bottom: 15px;">
            <label>비밀번호</label><br/>
            <input type="password" name="password" style="width: 100%; padding: 8px;" required>
        </div>

        <div style="margin-bottom: 15px;">
            <label>이름</label><br/>
            <input type="text" name="name" style="width: 100%; padding: 8px;" required>
        </div>

        <div style="margin-bottom: 15px;">
            <label>이메일</label><br/>
            <input type="email" name="email" style="width: 100%; padding: 8px;" required>
        </div>

        <div style="margin-bottom: 20px;">
            <label>전화번호</label><br/>
            <input type="tel" name="phone" placeholder="010-0000-0000" style="width: 100%; padding: 8px;" required>
        </div>

        <button type="submit" style="width: 100%; padding: 12px; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer; font-size: 1.1em;">
            회원가입 완료
        </button>
    </form>
</div>