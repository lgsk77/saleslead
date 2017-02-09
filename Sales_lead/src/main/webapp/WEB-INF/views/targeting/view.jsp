
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"/>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"/>
<script type="text/javascript">

$(function(){
	$('#search').on('click', function(event) {
		var url = "/car/car/searchview.action?startDate=" + $('#startDate').val() + "&endDate=" + $('#endDate').val()
				+ "&carindex="+$('#status').val();
		$("#searchlist").load(url);

	});
	});
</script>

    <jsp:include page="/WEB-INF/views/include/head.jsp" />
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div>
	
       	<table class="table table-striped" align="center" width="700px" id="searchlist">
			<tr style="height: 30px" align="center">

				<td>타겟조회</td><td></td>
				<td class="form-group">
					<input type="checkbox"  id="searchItem" />노트북</td>
				
				<td><button type="button" id="search" >조회</button></td>
			</tr>
		</table>
       	<table class="table table-striped" align="center" width="500px">


			
			<tr style="height: 30px; text-align: center;" align="center" >
				<td></td>
				<td>no</td>
				<td>아이디</td>
				
			</tr>
		
			<c:forEach var="target" items="${ targets }">
			<tr style="height: 30px; text-align: center;" align="center">
				<td></td>
				<td>${ target.no }</td>
				<td>${ target.id }</td> 
				
			</tr>
			</c:forEach>
		</table>
	</div>
			
    


