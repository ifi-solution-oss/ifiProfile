<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Search Node By Name</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<c:if test="${not empty lists}">
					<h4>List Nodes:</h4>
					<table class="table table-hover table-bordered table-striped">
					<thead>
				      <tr>
				        <th>No</th>
				        <th class="col-md-1">Name</th>
				        <th>${node.relation}</th>
				        <th>Project</th>
				      </tr>
				    </thead>
				    <tbody>
				    <!-- use two-dimensional array to get value of node and field -->
				      <c:forEach var="listValue" items="${lists}" varStatus="count">
				      <tr data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
	      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">
						  <td>${count.index+1}</td>
						  <td>${listValue.labelNode}</td>
						  <td><i class="fas fa-check"></i></td>
						  <td></td>
				      </tr>
				      </c:forEach>
				    </tbody>
					</table>
				</c:if>
				</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$(function () {
        $(".idClass").click(function () {
        	var my_id_value = $(this).data('id');
            var list = $(this).data('list');
            $("#name-node").text(my_id_value + ' detail');

            var body = document.getElementById("modal-body");    	    
    	    body.innerHTML = '';
            
    	    var tbl  = document.createElement('table');
    	    tbl.style.border = '1px solid gray';
    	    
            while (list.length > 0){
            	var n = list.indexOf("*+*+");
				var rowText = list.substring(0, n);
            	
            	var tr = tbl.insertRow();
                var td = tr.insertCell();
                var m = list.indexOf(":");
                td.appendChild(document.createTextNode(rowText.substring(0, m)));
                td.style.border = '1px solid gray';
//                 td.style.width  = '100px';
                rowText = rowText.substring(m+1, rowText.length);
                var td = tr.insertCell();
                td.appendChild(document.createTextNode(rowText));
                td.style.border = '1px solid gray';

				list = list.substring(n+4, list.length);
            }
            body.appendChild(tbl);
        })
    });
	</script>

	<!-- The Modal -->
	<div class="modal fade" id="ifiModal">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 id="name-node" class="modal-title">Node Detail</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	
	      <!-- Modal body -->
	      <div id="modal-body" class="modal-body">
	        <label id="labelNode"></label>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" >Delete</button>
	      </div>
	
	    </div>
	  </div>
	</div>
</body>
</html>