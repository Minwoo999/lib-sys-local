<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8"/>
        <title>도서 관리 시스템</title>
    </head>

    <body>
        <div id="header_area">
            <tiles:insertAttribute name="header"/>
        </div>

        <div id="container">
            <tiles:insertAttribute name="body"/>
        </div>

        <div id="footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>

</html>