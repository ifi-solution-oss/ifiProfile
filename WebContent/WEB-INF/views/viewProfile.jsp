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
				<c:if test="${not empty nodeInfo}">
					<h2> Profile</h2> 
				    <!-- use two-dimensional array to get value of node and field -->
				    <h4>Individual Information</h4>
				      <c:forEach var="nodeInfo" items="${nodeInfo}" >
				      	<li>${nodeInfo.labelNode}</li>
	      					<c:forEach var="field" items="${nodeInfo.listFields}">
	      					${field.key} :
	      					${field.value}<br>
				    		</c:forEach>
				      </c:forEach>
				      <h4>Technologies</h4>
    				  	<c:forEach var="listTech" items="${listTech}">
    				  		<c:forEach var="tech" items="${listTech.listFields}">
    				  			<li>${tech.value}</li>			
    				  		</c:forEach>
     				 	</c:forEach>				
				</c:if>
			</div>
		</div>
	</div>
	
	
	 
	<script type="text/javascript">

	</script>

	
</body>
</html>