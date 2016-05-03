

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

<h1 class="page-header">添加用户</h1>

<form form-ajax class="form-horizontal" id="main-form" action="/user/insert" forward='/user/'>


<div class="col-sm-6">
  <div class="form-group">
    <label for="inputloginname" class="col-sm-4 control-label">
    	登录名
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputloginname" placeholder="登录名" name="loginname">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputpassword" class="col-sm-4 control-label">
    	密码
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputpassword" placeholder="密码" name="password">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputname" class="col-sm-4 control-label">
    	显示名
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputname" placeholder="显示名" name="name">
    
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