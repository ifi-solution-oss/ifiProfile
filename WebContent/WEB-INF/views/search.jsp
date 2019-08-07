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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<c:if test="${not empty listSearch}">
					<ul>
						<c:forEach var="listValue" items="${listSearch}">
						<h3>${listValue.typeNode}</h3>
							<li>${listValue.labelNode}</li>
							<c:forEach var="field" items="${listValue.listFields}">
								${field.key} : ${field.value}<br>
							</c:forEach>
							<a type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo" href="search?nameNode=${listValue.labelNode}">More Details</a>
						</c:forEach>
					</ul>
				</c:if>
				</div>
			<div class="col-sm-6">
		 	  <div id="demo" class="collapse" style="margin-top: 50px">
			    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			  </div>
			</div>
		</div>
	</div>
</body>
</html>