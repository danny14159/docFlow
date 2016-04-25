<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
<link href="/static/css/dashboard.css" rel="stylesheet"/>
<title>系统后台</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">公文流转管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <!-- <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li> -->
            <li><a href="/app/login">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>

<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="/user/" target="main">用户管理</a></li>
            <li><a href="/department/" target="main">部门管理</a></li>
            <li><a href="/document/" target="main">公文管理</a></li>
            <li><a href="/review/" target="main">审阅记录</a></li>
            <li><a href="/urge/" target="main">事务催办</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <iframe name="main" src="/user/" style="width:100%;border: none;height: 550px;"></iframe>
        </div>
      </div>
    </div>

<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.nav.nav-sidebar li').click(function(){
		$('.nav.nav-sidebar li').removeClass('active');
		$(this).addClass('active');
	});
})
</script>
</body>
</html>