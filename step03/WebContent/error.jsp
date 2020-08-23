<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>error.jsp</title>
</head>
<body>
<script>alert('${requestScope.errorMsg}'); window.history.back(); </script>
</body>
</html>