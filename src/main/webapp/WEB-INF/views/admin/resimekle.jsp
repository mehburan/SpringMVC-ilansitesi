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
<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">

 <jsp:include page="${request.contextPath}/header"></jsp:include>
 <jsp:include page="${request.contextPath}/menu"></jsp:include>
  

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        İlan Resim Ekle Sayfası 
      </h1>
      
    <div class>
    <h3>İlan Resim Ekle </h3>
    <form autocomplete="off" action='<s:url value="/resimekle/${ id }"></s:url>'method="get">
   <div class="row">
<div class="col-xs-2 col-md-12">
  <c:if test="${ not empty id }"> 
<iframe src='http://localhost:80/resim/index.php?resim_id=<c:out value="${ id }"></c:out>' style="width: 100%; height: 500px;" frameborder="0"></iframe>
  </c:if>
</div>

</div>
  </form>
 
</div>

    
    </div>
    
    </section>

    <!-- Main content -->
    
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<jsp:include page="${request.contextPath}/footer"></jsp:include>

</div>
<!-- ./wrapper -->
<jsp:include page="${request.contextPath}/js"></jsp:include>

</body>
</html>