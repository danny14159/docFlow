<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<h1 class="page-header">${data.title }</h1>
<span class="text-muted">作者：${data.author }<fmt:formatDate value="${data.create_time }" pattern="yyyy-MM-dd HH:mm"/></span><a href="javascript:;" onclick="history.go(-1)">&lt;&lt;返回</a>

<div>
指定会签部门：
	<c:forEach items="${list }" var="i">
		${i.dept_name }、
	</c:forEach>
</div>
<div class="container">
${data.content }
</div>

<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript">
</script>
</body>
</html>