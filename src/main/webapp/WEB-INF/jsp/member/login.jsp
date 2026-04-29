<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 10px;">
    <h2 style="text-align: center;">로그인</h2>

    <c:if test="${not empty msg}">
        <p style="color: red; text-align: center; font-size: 0.9em;">${msg}</p>
    </c:if>

    <form action="<c:url value='/member/login.do'/>" method="post">
        <div style="margin-bottom: 15px;">
            <label for="loginId">아이디</label><br/>
            <input type="text" id="loginId" name="loginId" style="width: 100%; padding: 8px;" required>
        </div>

        <div style="margin-bottom: 20px;">
            <label for="password">비밀번호</label><br/>
            <input type="password" id="password" name="password" style="width: 100%; padding: 8px;" required>
        </div>

        <button type="submit" style="width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">
            로그인
        </button>
    </form>


    
    <hr style="margin: 20px 0; border: 0; border-top: 1px solid #eee;">
    <%-- 3. 소셜 로그인(OAuth) 버튼 영역 --%>
    <div style="display: flex; flex-direction: column; gap: 10px;">
        <a href="<c:url value='/OAuth/login/kakao.do'/>" style="display: block; text-align: center; padding: 10px; background-color: #FEE500; color: #3C1E1E; text-decoration: none; border-radius: 5px; font-weight: bold;">
            카카오 로그인
        </a>
        <a href="<c:url value='/OAuth/login/naver.do'/>" style="display: block; text-align: center; padding: 10px; background-color: #03C75A; color: white; text-decoration: none; border-radius: 5px; font-weight: bold;">
            네이버 로그인
        </a>
    </div>


    <div style="margin-top: 15px; text-align: center; font-size: 0.9em;">
        아직 회원이 아니신가요? <a href="<c:url value='/member/join.do'/>">회원가입</a>
    </div>
</div>