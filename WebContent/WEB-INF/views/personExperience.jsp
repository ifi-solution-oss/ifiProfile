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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
<link href = "https://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css" rel = "stylesheet">
<link href = "https://cdn.datatables.net/1.10.2/css/jquery.dataTables_themeroller.css" rel = "stylesheet">
<script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
<script src = "https://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>



</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<table class="table">
					<thead>
						<tr>
							<th>Person Name</th>
							<th>Year Experience</th>
							<th></th>
							<th></th>
							<th>Technology</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="personExp" items="${personExperience}">	
						<tr>
						<td>${personExp.labelNode}</td>	
							<c:forEach var="techExp" items="${personExp.listFields}">
								<td>${techExp.key}</td>
								<td>${techExp.value}</td>
							</c:forEach>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>	
		</div>
	</div>
</body>
</html>