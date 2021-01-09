<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>MrGeek</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="resources/MrGeek_files/bootstrap.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="resources/MrGeek_files/hux-blog.css">
</head>

</head>
<body>
	<%-- 	<c:forEach items="${fileContentList}" var="fileContent" varStatus="sta"> --%>
	<!-- 		<tr align="center"> -->
	<!-- 			<br> -->
	<!-- 			<br> -->
	<!-- 			<br> -->
	<!-- 			<td> -->
	<%-- 				${sta.index+1} --%>
	<!-- 			</td> -->
	<%-- 			<td>${fileContent}</td> --%>
	<!-- 		</tr>				 -->
	<%-- 	</c:forEach> --%>

	<c:forEach items="${newslist}" var="news" varStatus="sta">
		<tr align="center">
			<br>
			<br>
			<br>
			<td>${sta.index+1}</td>
			<td>
				<div class="container">
					<div class="post-preview">
						<a href="${news.url}">
							<div class="post-content-preview">${news.title}</div>
						</a>
					</div>
					<hr>
					<hr>
				</div>
			</td>
		</tr>
	</c:forEach>

</body>
</html>