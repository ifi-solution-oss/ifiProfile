<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

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
	<div style="background: #008080; width: 100%; height: 65px; padding: 5px; border: 1px white;">
	  <div style="float: left; color: white">
	     <h1 style="font-size: 20px">IFI SOLUTION</h1>
	  </div>
	 
	  <div style="float: right; padding: 5px; text-align: right; position: relative;">
		 <h2 style="font-size: 17px; font-style: italic; color: #ffa64d;">an NTT DATA Company</h2>	
	  </div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<nav class="navbar navbar-expand-sm bg-info navbar-dark">
				  <a class="nav-link disabled" href="#" style="font-size: 17px">IFI Profile</a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				
				  <div class="collapse navbar-collapse" id="navbarSupportedContent">
				    <ul class="navbar-nav mr-auto">
				      <li class="nav-item active">
				        <a class="nav-link" href="">Home <span class="sr-only">(current)</span></a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="#">Link</a>
				      </li>
				    </ul>
				    <form class="form-inline my-2 my-lg-0" action="search" id="search" method="get">
				      <input class="form-control mr-sm-2" id="myInput" type="text" name="nameNode" placeholder="Search" >
				      <button class="btn btn-info" type="submit">Search</button>
				    </form>
				  </div>
				</nav>
			</div>
		</div>
	</div>
	
	<script>
	$(function(){
		 var data = []
		      <c:forEach items="${listNodeForSearch}" var="listValue">
		     	 <c:forEach var="field" items="${listValue.listFields}">
		     		data.push("<c:out value="${field.value}"/>");	
		     	 </c:forEach>
		      </c:forEach>
		$("#myInput").autocomplete({
			source: data
		});
	});
	</script>
</body>
