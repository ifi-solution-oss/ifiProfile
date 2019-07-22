<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Search Node By Name</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>



</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-10">
			<h4>Project Information</h4>
			<!-- get project information -->
				<c:forEach var="listPerson" items="${listPerson}">
					<c:forEach var="project" items="${listPerson.listFields}">
						${project.key}: ${project.value}<br>
					</c:forEach>
				</c:forEach>
			<h4>Project member</h4>
			<!-- get list person that were members join in project -->
				<c:forEach var="listPerson" items="${listPerson}">
					<li>${listPerson.labelNode}</li>
				</c:forEach>
			</div>	
		</div>
	</div>
	
</body>
</html>