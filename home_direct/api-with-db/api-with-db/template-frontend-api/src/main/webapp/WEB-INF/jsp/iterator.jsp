<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="UTF-8"%><%@ page
	contentType="text/html;charset=UTF-8"%>
<c:url value="?" var="params">
	<c:if test="${not empty date}">
		<c:param name="date" value="${date}"></c:param>
	</c:if>
	<c:if test="${not empty group}">
		<c:param name="group" value="${group}"></c:param>
	</c:if>
	<c:if test="${not empty category}">
		<c:param name="category" value="${category}"></c:param>
	</c:if>
	<c:if test="${not empty source}">
		<c:param name="source" value="${source}"></c:param>
	</c:if>
</c:url>
<div class="page_">
	<c:choose>
		<c:when test="${page.pageNumber - 3 <= 1}">
			<c:forEach var="i" begin="1"
				end="${page.pagesAvailable <= 7 ? page.pagesAvailable : 7}">
				<a class="${i == page.pageNumber ? 'current_page' : 'page_item'}"
					href="/article?${params}&page=${i}">${i}</a>
			</c:forEach>
			<c:if test="${page.pagesAvailable > 7}">
				... 
				<a class="${i == page.pageNumber ? 'current_page' : 'page_item'}"
					href="/article?${params}&page=${page.pagesAvailable}">${page.pagesAvailable}</a>
			</c:if>
		</c:when>
		<c:when
			test="${1 < page.pageNumber - 3 and page.pageNumber + 3 < page.pagesAvailable}">
			<a class="page_item" href="/article?${params}&page=1">1</a>
	        ...
	     <c:forEach var="i" begin="${page.pageNumber - 3}"
				end="${page.pageNumber + 3}">
				<a class="${i == page.pageNumber ? 'current_page' : 'page_item'}"
					href="/article?${params}&page=${i}">${i}</a>
			</c:forEach>
	        ...
	    <a class="page_item"
				href="/article?${params}&page=${page.pagesAvailable}">${page.pagesAvailable}</a>
		</c:when>
		<c:otherwise>
			<a href="/article?${params}&p=1">1</a> 
			...
			<c:forEach var="i" begin="${page.pagesAvailable - 7}"
				end="${page.pagesAvailable}">
				<a class="${i == page.pageNumber ? 'current_page' : 'page_item'}"
					href="/article?${params}&p=${i}">${i}</a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<span style="margin-left: 10px">( <fmt:formatNumber
			type="number" maxFractionDigits="3" value="${page.totalItems}" /> )
	</span>
</div>
