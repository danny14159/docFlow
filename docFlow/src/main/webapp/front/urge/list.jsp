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

<h1 class="page-header">事务催办 - 查看</h1>

<a class="btn btn-xs btn-primary" href="/urge/add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;添加</a>
<table class="table table-striped table-bordered">
<caption>我催办的</caption>
<tr>
	<th><input type="checkbox" onchange="toggleSelectAll(this,$('[name=selectRow]'));"/></th>
	
	
	<th>被催办人</th>
	
	<th>催办内容</th>
	
	<th>截止日期</th>
	
	<th>操作</th>
</tr>
	<c:forEach items="${data }" var="i">
<tr>
<td><input type="checkbox" checked="checked" name="selectRow"/></td>
	
	<td>
		
		<c:out value="${i.target_name}"></c:out>
	</td>
	
	<td>
		
		<c:out value="${i.content}"></c:out>
	</td>
	
	<td>
		<fmt:formatDate value="${i.deadline}" pattern="yyyy-MM-dd"/>
		
	</td>
	
	<td><button class="btn btn-xs btn-link" onclick="del(${i.id})">删除</button></td>
</tr>
</c:forEach>
</table>

<table class="table table-striped table-bordered">
<caption>催办我的</caption>
<tr>
	<th><input type="checkbox" onchange="toggleSelectAll(this,$('[name=selectRow]'));"/></th>
	
	
	<th>催办人</th>
	
	<th>催办内容</th>
	
	<th>截止日期</th>
	
	<th>操作</th>
</tr>
	<c:forEach items="${data1 }" var="i">
<tr>
<td><input type="checkbox" checked="checked" name="selectRow"/></td>
	
	<td>
		
		<c:out value="${i.target_name}"></c:out>
	</td>
	
	<td>
		
		<c:out value="${i.content}"></c:out>
	</td>
	
	<td>
		<fmt:formatDate value="${i.deadline}" pattern="yyyy-MM-dd"/>
		
	</td>
	
	<td></td>
</tr>
</c:forEach>
</table>

<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/laypage/laypage.js"></script>
<script type="text/javascript">
$(function(){
	
})
function toggleSelectAll(self,$sel){
	if(self.checked)
		$sel.each(function(){
			if(!this.checked) $(this).click();
		});
	else{
		$sel.each(function(){
			if(this.checked) $(this).click();
		});
	}
}

function del(id){
	if(confirm('确认删除此记录？'))
	$.post('/urge/del',{
		id:id
	},function(data){
		if(data){
			alert('操作成功');location.reload();
		}
		else{
			alert('操作失败')
		}
	},'json');
}
</script>
</body>
</html>