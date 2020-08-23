<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% System.out.println("jsp nn" + request.getParameter("name")); 
request.setCharacterEncoding("UTF-8");%>
${param.name}-${param.age}
