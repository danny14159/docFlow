
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
.error{color:red;}
</style>
</head>
<body>

<h1 class="page-header">公文 - 修改</h1>

<form form-ajax class="form-horizontal" id="main-form" action="/tdocument/update" forward="/tdocument/">


<div class="col-sm-6">
  <div class="form-group">
    <label for="inputid" class="col-sm-4 control-label">
    	id
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputid" placeholder="" name="id" value="${data.id}">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputstate" class="col-sm-4 control-label">
    	公文状态	
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputstate" placeholder="公文状态" name="state" value="${data.state}">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputauthor" class="col-sm-4 control-label">
    	公文作者	
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputauthor" placeholder="公文作者" name="author" value="${data.author}">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputcontent" class="col-sm-4 control-label">
    	公文内容	
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputcontent" placeholder="公文内容" name="content" value="${data.content}">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputtitle" class="col-sm-4 control-label">
    	公文标题	
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputtitle" placeholder="公文标题" name="title" value="${data.title}">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputcreate_time" class="col-sm-4 control-label">
    	create_time
    </label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control required laydate-icon" id="inputcreate_time" placeholder="" name="create_time" onclick="laydate()" value="<fmt:formatDate value="${data.create_time}" pattern="yyyy-MM-dd"/>">
   
   
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputupdate_time" class="col-sm-4 control-label">
    	update_time
    </label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control required laydate-icon" id="inputupdate_time" placeholder="" name="update_time" onclick="laydate()" value="<fmt:formatDate value="${data.update_time}" pattern="yyyy-MM-dd"/>">
   
   
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputcover" class="col-sm-4 control-label">
    	封面	
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputcover" placeholder="封面" name="cover" value="${data.cover}">
    
    </div>
  </div>
  </div>
 
<div class="col-sm-6">
  <div class="form-group">
    <label for="inputbrief_intro" class="col-sm-4 control-label">
    	简介	
    </label>
    <div class="col-sm-6">
    
   
      <input type="text" class="form-control required" id="inputbrief_intro" placeholder="简介" name="brief_intro" value="${data.brief_intro}">
    
    </div>
  </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary btn-sm">修改</button>
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