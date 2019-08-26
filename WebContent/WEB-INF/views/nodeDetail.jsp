<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Search Node</title>
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
			<c:if test="${not empty node}">
			<!-- get node -->
				<div class="col-sm-4">
					<ul>
						<c:forEach var="node" items="${node}">
						<h4>${node.typeNode}</h4>
							<li>${node.labelNode}</li>
							<c:forEach var="nodeDetail" items="${node.listFields}">
								${nodeDetail.key} : ${nodeDetail.value}<br>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</div>
	</div>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>