<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" pageEncoding="UTF-8"%><%@ page
	contentType="text/html;charset=UTF-8"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/article">VietSpider</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Ngày ${not empty date ? date : ''}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <c:forEach items="${dataDates}" var="item">
            		<li><a href="/article?date=${item}">${item}</a></li>
            </c:forEach>
          </ul>
        </li>
        <li>
        		<a class="dropdown-toggle" data-toggle="dropdown" href="#" href=""> Nhóm ${not empty group ? group : ''}<span class="caret"></span></a>
        		<ul class="dropdown-menu">
	        		<c:forEach items="${groups}" var="item">
	          	  	<li><a href="/article?date=${not empty date ? date : ''}&group=${item.name}">${item.name}</a></li>
	           	</c:forEach>
	           	
            	</ul>
         </li>
         
        <c:if test="${not empty categories}">
        <li><a class="dropdown-toggle" data-toggle="dropdown" href="#" href=""> Mục ${not empty category ? category : ''}<span class="caret"></span></a>
        		<ul class="dropdown-menu">
	        		<c:forEach items="${categories}" var="item">
	          	  	<li><a href="/article?date=${not empty date ? date : ''}&group=${group}&category=${item.name}">${item.name}</a></li>
	           	</c:forEach>
            	</ul></li>
          </c:if>  	
          
          <c:if test="${not empty sources}">
       	 <li><a class="dropdown-toggle" data-toggle="dropdown" href="#" href="">Nguồn ${not empty source ? source : ''}<span class="caret"></span></a>
        		<ul class="dropdown-menu">
	        		<c:forEach items="${sources}" var="item">
	          	  	<li><a href="/article?date=${date}&group=${group}&category=${category}&source=${item.name}">${item.name}</a></li>
	           	</c:forEach>
            	</ul></li>
          </c:if>  	
      </ul>
      <!-- ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul-->
    </div>
  </div>
</nav>