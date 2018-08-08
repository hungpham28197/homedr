<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%><%@ page
	contentType="text/html;charset=UTF-8"%>
<tiles:insertDefinition name="dataTemplate">
	<tiles:putAttribute name="body">
		<jsp:include page="iterator.jsp" />
		<article class="article">
			<c:forEach items="${page.pageItems}" var="item">
				<div class="meta">
					<h4>
						<a href="/article/${item.meta.alias}-pr${item.meta.id}"
							class="meta_title">${item.meta.title} </a>
					</h4>
					<table>
						<tbody>
							<tr>
								<c:if test="${not empty item.meta.image}">
									<td valign="top"><img src="${item.meta.image}" width="120"
										style="margin-right: 5px; margin-top: 5px" /></td>
								</c:if>
								<td valign="top">

									<div class="text" style="margin-top: 5px">${item.meta.desc}</div>
									<div class="properties2" align="right">
										${item.domain.category} - ${item.domain.sourceName} -
										${item.meta.properties['time']}</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</article>

		<jsp:include page="iterator.jsp" />

	</tiles:putAttribute>
</tiles:insertDefinition>