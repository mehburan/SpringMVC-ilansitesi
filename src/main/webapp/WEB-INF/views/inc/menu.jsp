<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        
        <div class="pull-left info">
          
          <br/>
         
        </div>
      </div>
      <br/>
      
    
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Admin Kontrol Paneli</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Kategoriler</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
             <li class>
             <a href='<s:url value="/admin/emlak"></s:url>' title="emlak" class>Emlak İlan Ekleme</a> 
            
             	<ul>
             	  <li class>
             	    <a href='<s:url value="/satiliksite"></s:url>'>Satılık İlanlar</a> 
             	    
             	  </li>
             	  <li class>
             	    <a href='<s:url value="/kiraliksite"></s:url>'>Kiralık ilanlar</a>
             	  </li>
               	</ul>
             </li>
             <li class>
             <a href='<s:url value="/admin/vasita"></s:url>' title="vasita" class>Vasıta İlan Ekleme</a>
             <ul>
             <li class>
             <a href='<s:url value="/otosite"></s:url>'>Otomobil ilanlar</a>
             </li>
             <li class>
             <a href='<s:url value="/arazisite"></s:url>'>Arazi ilanlar</a>
             </li>
             <li class>
             <a href='<s:url value="/kamyonsite"></s:url>'>Kamyonet ilanlar</a>
             </li>
             </ul>
             </li>
          </ul>
        </li>
        
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>