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
			<c:if test="${not empty listSearch}">
				<div class="col-sm-4">
					<ul>
						<c:forEach var="listValue" items="${listSearch}">
						<h4>${listValue.typeNode}</h4>
							<li>${listValue.labelNode}</li>
							<c:forEach var="field" items="${listValue.listFields}">
								${field.key} : ${field.value}<br>
							</c:forEach>
						<a href="viewDetail?nameNode=${listValue.labelNode}">View more information</a>
						</c:forEach>
					</ul>
				</div>	
			</c:if>

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

			<c:if test="${not empty listDetailTechPerson}">
			<!-- Technology detail: List Person has_experience -->
				<div class="col-sm-4">
				<h4>Persons have experience</h4>
					<ul>
						<c:forEach var="listTechPerson" items="${listDetailTechPerson}">
							<c:forEach var="techPerson" items="${listTechPerson.listFields}">
								<a href="search?nameNode=${techPerson.key}">${techPerson.key}</a><br>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<c:if test="${not empty listDetailTechProject}">
			<!-- Technology detail: List Project used_in -->
				<div class="col-sm-4">
				<h4>Projects use</h4>
					<ul>
						<c:forEach var="listTechProject" items="${listDetailTechProject}">
							<c:forEach var="techProject" items="${listTechProject.listFields}">
								<a href="search?nameNode=${techProject.key}">${techProject.key}</a><br>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
			<c:if test="${not empty listDetailProjectPerson}">
			<!-- Project detail: List Person work_in -->
				<div class="col-sm-4">
				<h4>Persons work in project</h4>
					<ul>
						<c:forEach var="listProjectPerson" items="${listDetailProjectPerson}">
							<c:forEach var="projectPerson" items="${listProjectPerson.listFields}">
								<a href="search?nameNode=${projectPerson.key}">${projectPerson.key} </a><br>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
			<c:if test="${not empty listDetailProjectTech}">
			<!-- Project detail: List Technology used_in  -->
				<div class="col-sm-4">
				<h4>Technologies use in project</h4>
					<ul>
						<c:forEach var="listProjectTech" items="${listDetailProjectTech}">
							<c:forEach var="projectTech" items="${listProjectTech.listFields}">
								<a href="search?nameNode=${projectTech.key}">${projectTech.key}</a><br>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
			<c:if test="${not empty listTech}">
			<!-- Person detail: List Technology has_experience  -->
				<div class="col-sm-4">
				<h4>Technologies have experience</h4>
					<ul>
						<c:forEach var="listTech" items="${listTech}">
							<c:forEach var="personTech" items="${listTech.listFields}">
								<a href="search?nameNode=${personTech.key}">${personTech.key}</a><br>
							</c:forEach>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
			<c:if test="${not empty listProject}">
			<!-- Person detail: List Project work_in  -->
				<div class="col-sm-4">
				<h4>Projects worked in</h4>
					<ul>
						<c:forEach var="listProject" items="${listProject}">
							<c:forEach var="personProject" items="${listProject.listFields}">
								<a href="search?nameNode=${personProject.value}">${personProject.value}</a><br>
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