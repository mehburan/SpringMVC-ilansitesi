<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin Yönetim Paneli</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <jsp:include page="${request.contextPath}/css"></jsp:include>
  
</head>
<body class="hold-transition skin-yellow sidebar-mini">
<div class="wrapper">

 <jsp:include page="${request.contextPath}/header"></jsp:include>
 <jsp:include page="${request.contextPath}/menu"></jsp:include>
  

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Emlak Düzenleme
        
      </h1>
    
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
     

      <div class="col-md-12">
     
         <div class="btn-group" role="group" aria-label="...">
         <div class="jpg">
        


         <a href='<s:url value="/admin/satilik"></s:url>'>
  <button type="button" class="btn btn-primary btn-lg">Satılık İlan Ekle ve Düzenle</button>
  <img src="http://localhost:80/resim/server/php/files/7/home.jpg" alt="Admin" width="200" height="200">
 </a></div>
 		
 		
<img src="http://localhost:80/resim/server/php/files/7/kira.png" alt="Admin" width="200" height="200">
         
 		<a href='<s:url value="/admin/kiralik"></s:url>'>
  <button type="button" class="btn btn-secondary btn-lg">Kiralık İlan Ekle ve Düzenle</button>
	</a>
</div>
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
