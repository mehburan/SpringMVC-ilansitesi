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
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

 <jsp:include page="${request.contextPath}/header"></jsp:include>
 <jsp:include page="${request.contextPath}/menu"></jsp:include>
  

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Kamyonet İlan Düzenleme Sayfası 
      </h1>
      
    <div class>
    <h3>İlan Başlığı</h3>
    <form autocomplete="off" action='<s:url value="/kamduzenle"></s:url>' method="POST">
    
    <div class="input-group input-group-lg">
  <span class="input-group-addon" id="sizing-addon1">"Aa"</span>
  <input type="hidden" name="vkid" value='<c:out value="${ vk.getVkid() }"></c:out>'>
  <input  type="text" class="form-control" name="vkbaslik" value='<c:out value="${ vk.getVkbaslik() }"></c:out>' placeholder="İlan Başlığı" aria-describedby="sizing-addon1">
  </div>
  <h3>İlan Açıklaması</h3>
  	<div class="input-group input-group-lg">
  	<span class="input-group-addon" id="sizing-addon1">"Aa"</span>
  	<input type="text" name="vkacik" value='<c:out value="${ vk.getVkacik() }"></c:out>' class="form-control" placeholder="İlan Açıklaması" aria-describedby="sizing-addon1">
  	</div>
  	<h3>İlan Detayı</h3>
  	<div class="input-group input-group-lg">
  	<span class="input-group-addon" id="sizing-addon1">"Aa"</span>
  	<input type="text" name="vkdetay" value='<c:out value="${ vk.getVkdetay() }"></c:out>' class="form-control" placeholder="İlan Detayı" aria-describedby="sizing-addon1">
  	</div>
  
<h3>İlan Fiyatı</h3>
  	<div class="input-group">
  <span class="input-group-addon">₺</span>
  <input name="vkfiyat" type="text" value="${ vk.getVkfiyat() }" class="form-control" aria-label="Amount (to the nearest dollar)">
  <span class="input-group-addon">.00</span>
</div>
<br/>
<div class="row">
<div class="col-sm-1">
<input class="form-control" type="submit" value="Düzenle">
</div>
</div>
<br/>
  </form>
 
</div>

    
    </div>
    
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      <form method="get" action='<s:url value="admin/kamyonet"></s:url>'>
      <div class="content-wrapper">
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
    <th class="tg-5ifk">ID</th>
    <th class="tg-4c2u">İlan Başlık</th>
    <th class="tg-rgzx">İlan Açıklama</th>
    <th class="tg-61f7">İlan Detay</th>
     <th class="tg-61f7">İlan Resim</th>
    <th class="tg-q1zm">İlan Fiyat</th>
     <th class="tg-q1zm">İlan Resim Ekle</th>
  </tr>
  <c:if test="${not empty ls }">
  <c:forEach items="${ ls }" var="vk">
  <tr>
    <td class="tg-yw4l"><c:out value="${ vk.getVkid() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ vk.getVkbaslik() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ vk.getVkacik() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ vk.getVkdetay() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ vk.getVkresim() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ vk.getVkfiyat() }"></c:out></td>
    <td><a href='<s:url value="/kamduzenle/${ vk.getVkid() }"></s:url>' class="btn btn-warning">Resim Düzenle</a></td>
   
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
