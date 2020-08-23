<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.entity.Dictionary"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/list.css" type="text/css">
</head>
<table id="example-table-1"
	class="table table-bordered table-hover text-center">
	<c:choose>
		<c:when test="${requestScope.lanType == 2}">
			<c:forEach items="${requestScope.words}" var="w">
				<tr>
					<td>
						<p align="center">단어 : ${w.kor}</p>
					</td>
					<td>
						<p align="center">뜻 : ${w.en}</p>
					</td>
					<td>
						<button class="ss" onclick="searchToNaver(&quot;${w.en}&quot;)"
							style="background-color: transparent">
							<i class="fa fa-search"></i>
						</button>

					</td>
				</tr>

			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach items="${requestScope.words}" var="w">
				<tr>
					<td>
						<p align="center">단어 : ${w.kor}</p>
					</td>
					<td>
						<p align="center">뜻 : ${w.en}</p>
					</td>
					<td>
						<button class="ss" onclick="searchToNaver(&quot;${w.en}&quot;)"
							style="background-color: transparent">
							<i class="fa fa-search"></i>
						</button>
					</td>
				</tr>

			</c:forEach>
		</c:otherwise>
	</c:choose>

</table>

