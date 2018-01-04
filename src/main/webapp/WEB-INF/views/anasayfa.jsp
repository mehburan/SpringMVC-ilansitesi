<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>BBExpress'e Hoşgeldiniz</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <jsp:include page="${request.contextPath}/css"></jsp:include>
  
</head>
<body class="hold-transition skin-black sidebar-mini">


 <jsp:include page="${request.contextPath}/header"></jsp:include>
<br/>
<div class="img">
<center>
<img src="http://localhost:80/resim/server/php/files/7/admin.jpg" alt="Admin" width="100" height="100">
</div>
<br/>
  
<div class="container">
  <a href='<s:url value="/giris"></s:url>' >
  <button type="button" class="btn btn-primary btn-lg btn-block">Admin Giriş Sayfası</button>
  </a>
  <br/>
<div class="png">
<center>
<img src="http://localhost:80/resim/server/php/files/7/kullanici.png" alt="Admin" width="100" height="100">
</div>

  <br/>
  <a href='<s:url value="anasite"></s:url>'>
<button type="button" class="btn btn-secondary btn-lg btn-block">Misafir Girişi</button>
</a>
</div>
  <!-- /.content-wrapper -->

<jsp:include page="${request.contextPath}/footer"></jsp:include>

<!-- ./wrapper -->
<jsp:include page="${request.contextPath}/js"></jsp:include>

</body>
</html>