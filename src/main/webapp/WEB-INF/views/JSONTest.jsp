<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSONTest</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function() {
		$("#checkJson").click(function() {
			var member = {
				id : "park",
				name : "������",
				pwd : "1234",
				email : "park@test.com"
			};
			$.ajax({
				type : "post",
				url : "${contextPath}/test/info",
				contentType : "application/json",
				data : JSON.stringify(member),
				success : function(data, textStatus) {
				},
				error : function(data, textStatus) {
					alert("������ �߻��߽��ϴ�.");
				},
				complete : function(data, textStatus) {
				}
			}); //end ajax	

		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="ȸ�� ���� ������" />
	<br>
	<br>
	<div id="output"></div>
</body>
</html>