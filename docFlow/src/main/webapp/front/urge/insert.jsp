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

<h1 class="page-header">事务催办 - 新增</h1>

<form form-ajax class="form-horizontal" id="main-form" action="/urge/insert" forward="/urge/">

 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputtarget_id" class="col-sm-4 control-label">
    	被催办人
    </label>
    <div class="col-sm-6">
    
   <select name="target_id" class="form-control">
   	<c:forEach items="${users }" var="i">
   		<option value="${i.id }">${i.name }</option>
   	</c:forEach>
   </select>
      <!-- <input type="text" class="form-control required" id="inputtarget_id" placeholder="被催办人" name="target_id"> -->
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputcontent" class="col-sm-4 control-label">
    	催办内容
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputcontent" placeholder="催办内容" name="content">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputdeadline" class="col-sm-4 control-label">
    	截止日期
    </label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control required laydate-icon" id="inputdeadline" placeholder="截止日期" name="deadline" onclick="laydate()">
   
   
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