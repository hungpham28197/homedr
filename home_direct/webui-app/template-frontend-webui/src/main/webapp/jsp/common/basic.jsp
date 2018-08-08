<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<title>${title}</title>
<link rel="manifest" href="/resources/manifest.json">
<meta name="description" content="#">
<meta name="keywords" content="#">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<tilesx:useAttribute id="listCss" name="stylesheets"
	classname="java.util.List" />
<c:forEach var="item" items="${listCss}">
	<link rel="stylesheet" href="${pageContext.request.contextPath}${item}" />
</c:forEach>

</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<div class="row">
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<tilesx:useAttribute id="listJs" name="scripts"
		classname="java.util.List" />
	<c:forEach var="item" items="${listJs}">
		<script src="${pageContext.request.contextPath }${item}"></script>
	</c:forEach>
</body>
</html>