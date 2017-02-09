
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

$(function() {
	$('#delete').on('click', function(event) {
		var carindex = $('#carindex').val();
		var result = confirm('삭제 하시겠습니까?');
		if (result) {
			//yes
			location.href = ('/car/car/delete.action?carindex=' + carindex);
		} else {
			//no
		}
	});
});
$(function(){
	$('#search').on('click', function(event) {
		var url = "/car/car/searchview.action?startDate=" + $('#startDate').val() + "&endDate=" + $('#endDate').val()
				+ "&carindex="+$('#status').val();
		$("#searchlist").load(url);

	});
	});

</script>
       	
       	<table class="table table-striped" align="center" width="700px" id="searchlist">

			<tr style="height: 30px" align="center">

				<td>타겟조회</td><td></td>
				<td class="form-group"><label for="inputItem"></label>
					<input type="checkbox" class="form-control"	placeholder="카테고리" id="searchItem" /></td>
				
				<td><button type="button" id="search" >조회</button></td>
			</tr>
			<tr style="height: 30px; text-align: center;" align="center" >
				<td></td>
				<td>no</td>
				<td>아이디</td>
				<td></td>
			</tr>
		
			<tr style="height: 30px; text-align: center;" align="center">
				<td></td>
				<td>${ no }</td>
				<td>${ id }</td> 
				<td></td>
			</tr>
		</table>
			
    


