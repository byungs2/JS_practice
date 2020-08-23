<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/listAll.css" type="text/css">
<meta charset="UTF-8">
<title>listall.jsp</title>
</head>
<body align="center">

<h1 style="color:white;">모든 단어 보기</h1><br><br>
	<c:choose>
		<c:when
			test="${empty requestScope.listall || fn:length(listall)  == 0}">

			<p align="center">
				<b><span style="font-size: 9pt;">등록된 단어가 없습니다</span></b>
			</p><br>

		</c:when>
		<c:otherwise>
			<c:forEach items="${requestScope.listall}" var="e" >
				<form name="requestForm" action="controller" id="resf">
					<h5 style="color:white;">영어 : </h5>
					<input class="inputBox" name="eng" value="${e.en}"> 
					<h5 style="color:white;" >한글 : </h5>
					<input class="inputBox" name="kor" value="${e.kor}" readonly> 
					<input type="hidden" name="command" value="update">
					<input type="submit" class="mybutton2" value="수정" />
				</form>
			    <form action="controller">
					<input type="hidden" name="kor" value="${e.kor}" />
					<input type="hidden" name="command" value="delete"> 
					<input type="submit" class="mybutton2" value="삭제" />
					<br>
				</form>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<p><a href="index.html" class="mybutton1">돌아가기</a></p>
</body>
</html>