<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Kullanıcı Paneli</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<jsp:include page="${request.contextPath}/css"></jsp:include>

</head>
<body class="hold-transition skin-green sidebar-mini">
	<div class="wrapper">

		<jsp:include page="${request.contextPath}/header"></jsp:include>

<div class="content-wrapper">

		<section class="content">
			<!-- Info boxes -->
					<h1>İlan Sayfası</h1>


							<c:if test="${not empty uos }">

								<div id="myCarousel" class="carousel slide" data-ride="carousel">
									<!-- Indicators -->
									<ol class="carousel-indicators">
									<c:set var="count" value="1" scope="page" />
									<c:forEach items="${ uos }" var="item">
									
										<li data-target="#myCarousel" data-slide-to="${ count }" class="active"></li>
										<c:set var="count" value="${count + 1}" scope="page" />
									</c:forEach>
									</ol>

									<!-- Wrapper for slides -->
									<div class="carousel-inner">
									<div class="item active">
											<center>
												<img
													src='http://localhost:80/resim/server/php/files/kiralik.png'
													class="img" alt="User Image" width="250" height="250"></center>
											</div>
										<c:forEach items="${ uos }" var="item">

											<div class="item">
											<center>
												<img
													src='http://localhost:80/resim/server/php/files/${id}/${item.getUadi()}'
													class="img" alt="User Image" width="250" height="250">
											</div>
										</c:forEach>

									</div>

									<!-- Left and right controls -->
									<a class="left carousel-control" href="#myCarousel"
										data-slide="prev"> <span
										class="glyphicon glyphicon-chevron-left"></span> <span
										class="sr-only">Previous</span>
									</a> <a class="right carousel-control" href="#myCarousel"
										data-slide="next"> <span
										class="glyphicon glyphicon-chevron-right"></span> <span
										class="sr-only">Next</span>
									</a>
								</div>
							</c:if>
					  <h1>Satılık Otomobil İlanı Sayfası</h1>
					  <form method="get" action='<s:url value="/otomobil"></s:url>'>
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
  
    <th class="tg-4c2u">İlan Başlık</th>
    <th class="tg-rgzx">İlan Açıklama</th>
    <th class="tg-61f7">İlan Detay</th> 
    <th class="tg-q1zm">İlan Fiyat</th>
    <th class="tg-5ifk">ID</th>
    
    
  </tr>
  <c:if test="${not empty votomobil }">
  
  
  <tr>
    
    <td class="tg-yw4l"><c:out value="${ votomobil.getVobaslik() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ votomobil.getVoacik() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ votomobil.getVodetay() }"></c:out></td>
    <td class="tg-yw4l"><c:out value="${ votomobil.getVofiyat() }"></c:out></td>
     <td class="tg-yw4l"><c:out value="${ votomobil.getVoidd() }"></c:out></td>
    
  </tr>
  
 
</c:if>

</table>
</form>

		</section>
		</div>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

	<jsp:include page="${request.contextPath}/footer"></jsp:include>

	<!-- ./wrapper -->
	<jsp:include page="${request.contextPath}/js"></jsp:include>

</body>
</html>
