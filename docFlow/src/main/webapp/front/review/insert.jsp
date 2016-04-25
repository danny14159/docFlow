

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

<h1 class="page-header">审阅记录 - 新增</h1>

<form form-ajax class="form-horizontal" id="main-form" action="/review/insert">


<div class="col-sm-6">
  <div class="form-group">
    <label for="inputid" class="col-sm-4 control-label">
    	id
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputid" placeholder="" name="id">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputtime" class="col-sm-4 control-label">
    	审阅时间
    </label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control required laydate-icon" id="inputtime" placeholder="审阅时间" name="time" onclick="laydate()">
   
   
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputremark" class="col-sm-4 control-label">
    	审阅意见
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputremark" placeholder="审阅意见" name="remark">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputdoc_id" class="col-sm-4 control-label">
    	公文编号
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputdoc_id" placeholder="公文编号" name="doc_id">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputdept_id" class="col-sm-4 control-label">
    	部门编号
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputdept_id" placeholder="部门编号" name="dept_id">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputstate" class="col-sm-4 control-label">
    	审阅状态
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputstate" placeholder="审阅状态" name="state">
    
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