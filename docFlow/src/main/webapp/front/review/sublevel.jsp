<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
.error{color:red;}
</style>
</head>
<body>
<a href="javascript:;" onclick="history.go(-1)">&lt;&lt;返回</a>
<h1 class="page-header">审阅公文 - 移交下级</h1>

<form form-ajax class="form-horizontal" id="main-form" action="/review/sublevel/submit" forward="/review/">

<input type="hidden" name="docId" value="${docId }"/>

<div class="col-sm-12">
	<a href="/document/detail?id=${docId }">查看公文</a>
</div>
<div class="col-sm-12">
  <div class="form-group">
    <label for="inputid" class="col-sm-4 control-label">
    	选择部门
    </label>
    <div class="col-sm-6">
    
    <select class="form-control" name="dept_id">
    	<c:forEach items="${list }" var="i">
    		<option value="${i.id }">${i.name }，领导：${i.leader_name }</option>
    	</c:forEach>
    </select>
    
    </div>
  </div>
  </div>
 
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary btn-sm">提交</button>
      <button type="reset" class="btn btn-default btn-sm">重置</button>
    </div>
  </div>
</form>


<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/messages_zh.min.js"></script>
<script type="text/javascript" src="/static/js/form-ajax.js"></script>
<script type="text/javascript" src="/static/laydate/laydate.js"></script>
<script type="text/javascript">

</script>
</body>
</html>