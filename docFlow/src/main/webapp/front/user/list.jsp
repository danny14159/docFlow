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

<h1 class="page-header">用户 - 查看</h1>

<a class="btn btn-xs btn-primary" href="/user/add"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;添加</a>
<table class="table table-striped table-bordered">
<tr>
	<th><input type="checkbox" onchange="toggleSelectAll(this,$('[name=selectRow]'));"/></th>
	
	
	<th>登录名</th>
	
	<th>密码</th>
	
	<th>显示名</th>
	
	<th>角色</th>
	<th>操作</th>
</tr>
	<c:forEach items="${data }" var="i">
<tr>
<td><input type="checkbox" checked="checked" name="selectRow"/></td>
	
	<td>
		
		<c:out value="${i.loginname}"></c:out>
	</td>
	
	<td>
		<c:if test="${me.type == 'C' }">
			******
		</c:if>
		<c:if test="${me.type == 'M' }">
			<c:out value="${i.password}"></c:out>
		</c:if>
	</td>
	
	<td>
		
		<c:out value="${i.name}"></c:out>
	</td>
	<td>
		<c:if test="${i.type == 'C' }">普通用户</c:if>
		<c:if test="${i.type == 'M' }">管理员</c:if>
	</td>
	
	
	
	<td>
	<c:if test="${me.type == 'M' }">
	<button class="btn btn-xs btn-link" onclick="del(${i.id})">删除</button>
	<a class="btn btn-xs btn-link" href="/user/update/${i.id }">修改</a>
	</c:if>
	</td>
</tr>
</c:forEach>
</table>
<div id="pager"></div>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/laypage/laypage.js"></script>
<script type="text/javascript">
$(function(){
	laypage({
	    cont: "pager",
	    pages: "${pager.pageCount}", 
	    curr: "${pager.pageNumber}", 
	    jump: function(e, first){ 
	        if(!first){ 
	            location.href = "?ps=${pager.pageSize}&pn="+e.curr;
	        }
	    }
	});
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
	$.post('/user/del',{
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