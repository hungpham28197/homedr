<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%><%@ page
	contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${not empty title ? title : 'Hệ thống khai thác thông tin VietSpider'}</title>
<meta name="title"
	content="${not empty title ? title : 'Hệ thống khai thác thông tin VietSpider'}">
<meta name="description" content="Hệ thống khai thác dữ liệu VietSpider" />
<meta property="og:locale" content="vi_VN" />
<meta name="resource-type" content="document" />
<meta name="placename" content="Việt Nam" />
<meta name="copyright" content="©2017 {}" />
<meta name="owner" content="VietSpider" />
<meta name="distribution" content="Global" />
<link href="https://fonts.googleapis.com/css?family=Nunito"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/css/style.css" />
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</head>
<body style="padding-top: 0px; min-height: 500px">
	<div class="container web-wrap" 
		style=" margin-bottom: 5px; min-height: 80%; padding: 0px; max-width: 850px">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
	</div>
	<footer class="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
	
	
</body>
</html>