<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Person Experience</title>
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
				<table class="table">
					<thead>
						<tr>
							<th>Person Name</th>
							<th>Technology</th>
							<th>Year Experience</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="personExp" items="${personExperience}">		
							<c:forEach var="techExp" items="${personExp.listFields}">
							<tr>
								<td>${personExp.labelNode }</td>
								<td>${techExp.value}</td>
								<td>${techExp.key}</td>
							</tr>
							</c:forEach>
						</c:forEach>
					</tbody>
				</table>
			</div>	
		</div>
	</div>
	
</body>
</html>