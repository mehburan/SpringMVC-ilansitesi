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
        Araç Düzenleme 
        
      </h1>
    
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
     
      <div class="col-md-12">
      
         <div class="btn-group" role="group" aria-label="...">
         <div class>
         <a href='<s:url value="/admin/otomobil"></s:url>'>
          <img src="http://localhost:80/resim/server/php/files/7/oto.jpg" alt="Admin" width="200" height="200">
   <button type="button" class="btn btn-primary btn-lg">Otomobil İlan Ekle ve Düzenle</button>
 </a>
 		<a href='<s:url value="/admin/arazi"></s:url>'>
  <button type="button" class="btn btn-primary btn-lg">Arazi İlan Ekle ve Düzenle</button>
   <img src="http://localhost:80/resim/server/php/files/7/jeep.jpg" alt="Admin" width="200" height="200">
	</a>
	<a href='<s:url value="/admin/kamyonet"></s:url>'>
	 <img src="http://localhost:80/resim/server/php/files/7/van.jpg" alt="Admin" width="200" height="200">
  <button type="button" class="btn btn-primary btn-lg">Kamyonet İlan Ekle ve Düzenle</button>
	</a>
	</div>
</div>
        </div>
      
      
           
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<jsp:include page="${request.contextPath}/footer"></jsp:include>


<!-- ./wrapper -->
<jsp:include page="${request.contextPath}/js"></jsp:include>
</div>
</body>
</html>
