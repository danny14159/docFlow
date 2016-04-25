<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
<style type="text/css">
body {
  padding-top: 40px;
  padding-bottom: 40px;
  /* background-color: #eee; */
  background: url('/static/img/bg.jpg')  no-repeat;
  background-size:100%; 
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
body{}
</style>
<title>登录</title>
</head>
<body>

<div class="container">

      <form class="form-signin" action="/app/login" method="post">
        <h2 class="form-signin-heading">欢迎</h2>${msg }
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" name="password" class="form-control" placeholder="密码" required>
        <button class="btn btn-sm btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->


</body>
</html>