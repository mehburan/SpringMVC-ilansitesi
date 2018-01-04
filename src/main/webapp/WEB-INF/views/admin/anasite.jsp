<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Kullanıcı Paneli</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <jsp:include page="${request.contextPath}/css"></jsp:include>
  
</head>
<body class="hold-transition skin-red sidebar-mini">
<div class="wrapper">

 <jsp:include page="${request.contextPath}/header"></jsp:include>
 
  

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      
    
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      
   <div class="container">
  
  <br>
  <h3>BBExpress'e Hoşgeldiniz</h3>
  <ul class="nav nav-pills nav-justified">
    
    <li><a href='<s:url value="/satiliksite"></s:url>'>Satılık İlan Sayfası</a></li><br/>
    <li><a href='<s:url value="/kiraliksite"></s:url>'>Kiralık İlan Sayfası</a></li><br/>
    <li><a href='<s:url value="/otosite"></s:url>'>Otomobil İlanları Sayfası</a></li><br/>
    <li><a href='<s:url value="/arazisite"></s:url>'>Arazi Aracı İlanları Sayfası</a></li><br/>
    <li><a href='<s:url value="/kamyonsite"></s:url>'>Kamyonet İlanları Sayfası</a></li>
  </ul>
</div>
   
      
      
           
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<jsp:include page="${request.contextPath}/footer"></jsp:include>

</div>
<!-- ./wrapper -->
<jsp:include page="${request.contextPath}/js"></jsp:include>

</body>
</html>