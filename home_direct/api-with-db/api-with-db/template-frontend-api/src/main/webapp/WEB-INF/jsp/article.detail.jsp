<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="dataTemplate">
	<tiles:putAttribute name="body">
		<article class="article">
			<h3>${article.meta.title}</h3>
			<p class="text">
				<c:out value="${article.content.htmlContent}" escapeXml="false" />
			</p>
			<div class="row properties2" style="margin-top: 25px">
				  <div class="col-md-3 col-md-offset-3"> <a href="${article.meta.url}">Xem tin tại nguồn</a></div>
				  <div class="col-md-3 col-md-offset-3">
				    <c:if test="${not empty article.meta.properties['sourceTime']}">
				    		${article.meta.properties['sourceTime']} -
				    </c:if>
				  	${article.meta.properties['time']} - <a href="javascript:history.go(-1)">Quay lại</a>
				  	</div>
			</div>
			
		</article>
	</tiles:putAttribute>
</tiles:insertDefinition>
