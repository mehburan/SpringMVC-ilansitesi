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
<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">

 <jsp:include page="${request.contextPath}/header"></jsp:include>


  
    <section class="content">
      <!-- Info boxes -->
      <form method="get" action='<s:url value="/satilik"></s:url>'>
      <div class="content-wrapper">
        <h1>Satılık Ev İlanları Sayfası</h1>
     <style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
.tg .tg-rgzx{font-weight:bold;text-decoration:underline;color:#036400;vertical-align:top}
.tg .tg-4c2u{font-weight:bold;text-decoration:underline;color:#9a0000;vertical-align:top}
.tg .tg-5ifk{font-weight:bold;text-decoration:underline;color:#fd6864;vertical-align:top}
.tg .tg-61f7{font-weight:bold;text-decoration:underline;color:#010066;vertical-align:top}
.tg .tg-q1zm{font-weight:bold;text-decoration:underline;color:#000000;vertical-align:top}
.tg .tg-yw4l{vertical-align:top}
</style>
<table class="table">
  <tr>
  	<th class="tg-61f7">İlan Resim</th>
    <th class="tg-4c2u">İlan Başlık</th>
    <th class="tg-rgzx">İlan Açıklama</th>
    <th class="tg-61f7">İlan Detay</th> 
    <th class="tg-q1zm">İlan Fiyat</th>
    <th class="tg-5ifk">ID</th>
    <th class="tg-q1zm">İlana Git</th>
    
  </tr>
  <c:if test="${not empty ls }">
  <c:forEach items="${ ls }" var="es">
  
  
  <tr>
    <td class="tg-yw4l"><img src='http://localhost:80/resim/server/php/files/${id}/${us}' class="img"
					alt="User Image" width="50" height="50"></td>
    <td class="tg-yw4l"><c:out value="${ es.getEsbaslik() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ es.getEsacik() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ es.getEsdetay() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ es.getEsfiyat() }"></c:out></td>
     <td class="tg-yw4l"><c:out value="${ es.getEsid() }"></c:out></td>
    <td><a href='<s:url value="admin/satilikilan/${ es.getEsid() }"></s:url>' class="btn btn-success">İlana Git</a></td>
	
  </tr>
  
 
  </c:forEach>
</c:if>

</table>
  
      
      </div>  
      </form>   
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
