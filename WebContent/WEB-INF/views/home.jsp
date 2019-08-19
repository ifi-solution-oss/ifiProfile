<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
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
	
		<!-- Home page -->
	<div id="Home" class="tabcontent">
		<div class="container">
			<div class="row">
			<!--  -->
				<div class="col-sm-12">
					<!-- Search person by name -->
					
					<!-- View profile -->
					<br><br>
					<form action="viewProfile" method="get" id="profile">
						<input type="text" name="nameNode">
						<input type="submit" value="View Profile">
					</form>
					 
					<!-- Search person by experience -->
					<!-- 
					<button id="btn-experience">Search Person By Experience</button><br><br>
					 -->
				</div>
				<!--  
				<div class="col-sm-6">
				<form action="searchByRelation" method="post" id="searchRelation">
					<select name="typeNode">
						<option value="">----Node Source----</option>
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode}" >${list.typeNode}</option>
						</c:forEach>
					</select>
					<input type="text" name="relation" placeholder="Enter Relationship" style="width: 30%">
					<select name="typeNode" id="show-input" onchange="searchRelationship()">
						<option value="">----Destination----</option>
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
					</select>
					<br><input type="submit" value="Search">
				</form>
				</div>
				-->
				
				<!-- Create relationship -->
				<!-- 
				<div class="col-sm-6">
				<button id="btn-relate">Create Relationship</button>
				 -->
				<!-- Add a new node -->
				<!--
				<form id="form" action="add" method="post">
					<br><input type="submit" value="Create Node"><br>
					<p>Type Node:</p>
					<input type="text" name="typeNode"><br>
					<p>Label Node:</p>
					<input type="text" name="labelNode"><br>
					<p>Properties:</p>
				</form>
				<button id="addBtn" onclick="addField()">Add Field</button><br>
				</div>
				 -->
				<div class = "col-sm-4" id="person">
					<c:if test="${not empty listPersons}">
						<h4>List Persons:</h4>
						<table id="tbl-person" class="table table-hover table-bordered table-striped">
						<thead>
					      <tr>
					        <th>No</th>
					        <th class="col-md-1">Name</th>
					      </tr>
					    </thead>
					    <tbody>
					    <!-- use two-dimensional array to get value of node and field -->
					      <c:forEach var="listValue" items="${listPersons}" varStatus="count">
					      <tr>
							  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.typeNode}" data-type="${listValue.typeNode }"
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${count.index+1}</td>
							  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${listValue.labelNode}</td>
							 <!-- delete function -->
							  <td data-toggle="modal" data-target="#ifiModal" class="deleteClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }"
							  data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-remove"><i class="fas fa-trash-alt"></i></button></td>
							  <!-- update function -->
							  <td data-toggle="modal" data-target="#ifiModal" class="updateClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }"
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-update" ><i class="fas fa-pen"></i></button></td>		
					      </tr>
					      </c:forEach>
					    </tbody>
						</table>
					</c:if>
				</div>
				
				<div class = "col-sm-4" id="project">
					<c:if test="${not empty listProjects}">
						<h4>List Projects:</h4>
						<table class="table table-hover table-bordered table-striped">
						<thead>
					      <tr>
					        <th>No</th>
					        <th class="col-md-1">Name</th>
					      </tr>
					    </thead>
					    <tbody>
					    <!-- use two-dimensional array to get value of node and field -->
					      <c:forEach var="listValue" items="${listProjects}" varStatus="count">
					      <tr>
							  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }"
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${count.index+1}</td>
							  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${listValue.labelNode}</td>
							 <!-- delete function -->
							  <td data-toggle="modal" data-target="#ifiModal" class="deleteClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }"
							  data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-remove"><i class="fas fa-trash-alt"></i></button></td>
							  <!-- update function -->
							  <td data-toggle="modal" data-target="#ifiModal" class="updateClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }" 
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-update" ><i class="fas fa-pen"></i></button></td>		
					      </tr>
					      </c:forEach>
					    </tbody>
						</table>
					</c:if>
				</div>
				
				<div class = "col-sm-4" id="technologies">
					<c:if test="${not empty listTechs}">
						<h4>List Technologies:</h4>
						<table class="table table-hover table-bordered table-striped">
						<thead>
					      <tr>
					        <th>No</th>
					        <th class="col-md-1">Name</th>
					      </tr>
					    </thead>
					    <tbody>
					    <!-- use two-dimensional array to get value of node and field -->
					      <c:forEach var="listValue" items="${listTechs}" varStatus="count">
					      <tr>
							  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }"
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${count.index+1}</td>
							  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${listValue.labelNode}</td>
							 <!-- delete function -->
							  <td data-toggle="modal" data-target="#ifiModal" class="deleteClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }"
							  data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-remove"><i class="fas fa-trash-alt"></i></button></td>
							  <!-- update function -->
							  <td data-toggle="modal" data-target="#ifiModal" class="updateClass" data-id="${listValue.labelNode}" data-type="${listValue.typeNode }" 
		      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-update" ><i class="fas fa-pen"></i></button></td>		
					      </tr>
					      </c:forEach>
					    </tbody>
						</table>
					</c:if>
				</div>
			<!-- Search function -->
				
			</div>
		</div>
	</div>

	<script type="text/javascript">
	var i = 0;
	function addField() {
		
		var x = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		x.setAttribute("type", "text");
		x.setAttribute("name", tmpName+"key");
		x.setAttribute("id","property-key"+i);
		
		var y = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		y.setAttribute("type", "text");
		y.setAttribute("name", tmpName+"value");
		y.setAttribute("id","property-value"+i);

		var elem = document.createElement('br');
		elem.setAttribute("id","property-br"+i); 

		var form = document.getElementById("form");
		form.appendChild(x);
		form.appendChild(y);
		var newlabel = document.createElement("Label");
	    newlabel.innerHTML = "Delete";
	    newlabel.setAttribute("onclick","deleteField("+i+")");
	    newlabel.setAttribute("id","property-label"+i);
	    form.appendChild(newlabel);
		form.appendChild(elem);
		i++;
	}
	
	function addUpdateField() {
			
		var x = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		x.setAttribute("type", "text");
		x.setAttribute("name", tmpName+"key");
		x.setAttribute("id","property-key"+i);
		console.log(x);
		var y = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		y.setAttribute("type", "text");
		y.setAttribute("name", tmpName+"value");
		y.setAttribute("id","property-value"+i);

		var elem = document.createElement('br');
		elem.setAttribute("id","property-br"+i); 

		var form = document.getElementById("formUpdate");
		form.appendChild(x);
		form.appendChild(y);
		var newlabel = document.createElement("Label");
	    newlabel.innerHTML = "Delete";
	    newlabel.setAttribute("onclick","deleteField("+i+")");
	    newlabel.setAttribute("id","property-label"+i);
	    form.appendChild(newlabel);
		form.appendChild(elem);
		i++;
	}
	
	function searchRelationship() {
		
		var x = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		x.setAttribute("type", "text");
		x.setAttribute("name", tmpName+"key");
		x.setAttribute("id","property-key"+i);
		console.log(x);
		var y = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		y.setAttribute("type", "text");
		y.setAttribute("name", tmpName+"value");
		y.setAttribute("id","property-value"+i);

		var elem = document.createElement('br');
		elem.setAttribute("id","property-br"+i); 

		var form = document.getElementById("searchRelation");
		form.appendChild(x);
		form.appendChild(y);
		var newlabel = document.createElement("Label");
	    newlabel.innerHTML = "Delete";
	    newlabel.setAttribute("onclick","deleteField("+i+")");
	    newlabel.setAttribute("id","property-label"+i);
	    form.appendChild(newlabel);
		form.appendChild(elem);
		i++;
	}
	
	function addRelationField() {
		var i = 2;
		var x = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		x.setAttribute("type", "text");
		x.setAttribute("name", tmpName+"key");
		x.setAttribute("id","property-key"+i);
		//x.setAttribute("placeholder", "Choose name/id/chargeid");
		
		
		var y = document.createElement("INPUT");
		tmpName = "listFields["+i+"].";
		y.setAttribute("type", "text");
		y.setAttribute("name", tmpName+"value");
		y.setAttribute("id","property-value"+i);
		//y.setAttribute("placeholder", "Enter name/id/chargeid of node")
		
		var elem = document.createElement('br');
		elem.setAttribute("id","property-br"+i); 
 
		var form = document.getElementById("formRelate");
		form.appendChild(x);
		form.appendChild(y);
		var newlabel = document.createElement("Label");
	    newlabel.innerHTML = "Delete";
	    newlabel.setAttribute("onclick","deleteField("+i+")");
	    newlabel.setAttribute("id","property-label"+i);
	    form.appendChild(newlabel);
		form.appendChild(elem);
		i++;
	}
	
	function deleteField(i) {
		
		document.getElementById("property-label"+i).remove();
		document.getElementById("property-key"+i).remove();
		document.getElementById("property-value"+i).remove();
		document.getElementById("property-br"+i).remove();
	}
	$(function () {
        $(".idClass").click(function () {
        	var my_id_value = $(this).data('id');
            var list = $(this).data('list');
            var type_node = $(this).data('type');
           
            $("#name-node").text(my_id_value + ' detail');

            var body = document.getElementById("modal-body");    	    
    	    body.innerHTML = '';
    	    // create a tag to link node info with viewProfile
    	    var link = document.createElement('a');
    	    link.setAttribute('href','viewProfile?nameNode='+my_id_value+'');
    	    link.innerHTML = 'Span Detail';
         	
    	    var tbl  = document.createElement('table');
    	    tbl.style.border = '1px solid gray';
    	    var i=0;
            while (list.length > 0){
            	var n = list.indexOf("*+*+");
				var rowText = list.substring(0, n);
            	
            	var tr = tbl.insertRow();
                var td = tr.insertCell();
                var m = list.indexOf(":");
                td.appendChild(document.createTextNode(rowText.substring(0, m)));
                td.style.border = '1px solid gray';
//              td.style.width  = '100px';
                rowText = rowText.substring(m+1, rowText.length);
                var td = tr.insertCell();
                td.appendChild(document.createTextNode(rowText));
                td.style.border = '1px solid gray';

				list = list.substring(n+4, list.length);
            }
            body.appendChild(tbl);
            body.appendChild(link);
        }) 
          
        // update node
       $(".updateClass").click(function () {
    	 
        	var my_id_value = $(this).data('id');
            var list = $(this).data('list');
            var type_node = $(this).data('type');
            
            $("#name-node").text(my_id_value + ' detail');

			var body = document.getElementById('modal-body');
			body.innerHTML = "";
			// create form update
			var form = document.createElement("form");
			form.setAttribute("id","formUpdate");
			form.setAttribute("action","updateNode");
			form.setAttribute("method","post");
			
			var br = document.createElement('br');
			// create submit button
			var submit = document.createElement("input");
			submit.setAttribute("type","submit");
			submit.setAttribute("value","Save");
			form.appendChild(submit);
			form.appendChild(br);
			
			var break_type = document.createElement('br');
			// get label node
			var type = document.createElement('input');
			type.setAttribute('name','typeNode');
			type.setAttribute('value',type_node);
			type.setAttribute("readonly","readonly");
			form.appendChild(type);
			form.appendChild(break_type);
			// create button link with event onclick
			var btn = document.createElement("button");
			btn.setAttribute("id","addBtn");
			btn.setAttribute("onclick","addUpdateField()");
			btn.innerHTML = "Add Field";
			
            while (list.length > 0){
            	var n = list.indexOf("*+*+");
				var rowText = list.substring(0, n);
				var elem = document.createElement('br');
				elem.setAttribute("id","property-br"+i); 
				
				form.appendChild(elem);
				
                var m = list.indexOf(":");
				var x = document.createElement("INPUT");
				x.setAttribute("value", "");
				// get key
				tmpName = "listFields["+i+"].";
				x.setAttribute("type", "text");
				x.setAttribute("name", tmpName+"key");
				x.setAttribute("id","property-key"+i);
				x.setAttribute("value",rowText.substring(0, m));
				x.setAttribute("readonly","readonly");
				console.log(x);
                rowText = rowText.substring(m+1, rowText.length);
				// get value
				var y = document.createElement("INPUT");
				y.setAttribute("value", "");
				tmpName = "listFields["+i+"].";
				y.setAttribute("type", "text");
				y.setAttribute("name", tmpName+"value");
				y.setAttribute("id","property-value"+i);
				y.setAttribute("value",rowText);
				
				form.appendChild(x);
				form.appendChild(y);
				
				var newlabel = document.createElement("Label");
			    newlabel.innerHTML = "Delete";
			    newlabel.setAttribute("onclick","deleteField("+i+")");
			    newlabel.setAttribute("id","property-label"+i);
			    form.appendChild(newlabel);
				form.appendChild(elem);
				
				list = list.substring(n+4, list.length);
				i++;
            }
            body.appendChild(form);
            body.appendChild(btn);
        })
        
        $(".deleteClass").click(function(){
        	var my_id_value = $(this).data('id');
            var list = $(this).data('list');
			var type_node = $(this).data('type');
            
            $("#name-node").text(my_id_value + ' detail');

			var body = document.getElementById('modal-body');
			body.innerHTML = "";
			// create form update
			var form = document.createElement("form");
			form.setAttribute("id","formDelete");
			form.setAttribute("action","deleteNode");
			form.setAttribute("method","post");
			
			var break_type = document.createElement('br');
			var type = document.createElement('input');
			type.setAttribute('name','typeNode');
			type.setAttribute('value',type_node);
			type.setAttribute("readonly","readonly");
			form.appendChild(type);
			form.appendChild(break_type);	    
			
            while (list.length > 0){
            	var n = list.indexOf("*+*+");
				var rowText = list.substring(0, n);
				
                var m = list.indexOf(":");
				var x = document.createElement("INPUT");
				tmpName = "listFields["+i+"].";
				x.setAttribute("type", "text");
				x.setAttribute("name", tmpName+"key");
				x.setAttribute("id","property-key"+i);
				x.setAttribute("value",rowText.substring(0, m));
				x.setAttribute("readonly","readonly");
				console.log(x);
                rowText = rowText.substring(m+1, rowText.length);

				var y = document.createElement("INPUT");
				tmpName = "listFields["+i+"].";
				y.setAttribute("type", "text");
				y.setAttribute("name", tmpName+"value");
				y.setAttribute("id","property-value"+i);
				y.setAttribute("value",rowText);
				y.setAttribute("readonly","readonly");
				
				var elem = document.createElement('br');
				elem.setAttribute("id","property-br"+i); 
				
				form.appendChild(x);
				form.appendChild(y);
				form.appendChild(elem);
				
				list = list.substring(n+4, list.length);
				i++;
            }
            var del = document.createElement("INPUT");
            del.setAttribute("type", "submit");
            del.setAttribute("value", "Delete");
            form.appendChild(del);
            body.appendChild(form);
        })
        
        // create relationship
        $(document).on('click','#btn-relate',function(event){
        	var j=1;
        	var form = document.getElementById("formRelate");
        	
        	var x = document.createElement("INPUT");
    		tmpName = "listFields["+j+"].";
    		x.setAttribute("type", "text");
    		x.setAttribute("name", tmpName+"key");
    		x.setAttribute("id","property-key"+j);
    		x.setAttribute("placeholder", "Choose name/id/chargeid")
    		
    		var y = document.createElement("INPUT");
    		tmpName = "listFields["+j+"].";
    		y.setAttribute("type", "text");
    		y.setAttribute("name", tmpName+"value");
    		y.setAttribute("id","property-value"+j);
        	y.setAttribute("placeholder", "Enter name/id/chargeid")
    		
    		var a = document.createElement("INPUT");
    		tmpName = "listFields["+i+"].";
    		a.setAttribute("type", "text");
    		a.setAttribute("name", tmpName+"key");
    		a.setAttribute("id","property-key"+i);
    		a.setAttribute("placeholder", "Choose name/id/chargeid")
    		
    		var b = document.createElement("INPUT");
    		tmpName = "listFields["+i+"].";
    		b.setAttribute("type", "text");
    		b.setAttribute("name", tmpName+"value");
    		b.setAttribute("id","property-value"+i);
    		b.setAttribute("placeholder", "Enter name/id/chargeid")
    		
    		var elem = document.createElement('br');
			elem.setAttribute("id","property-br"+i); 
    		
    		var source = document.getElementById("source");
    		source.appendChild(elem);
    		source.appendChild(a);
    		source.appendChild(b);
    		
    		var destination = document.getElementById("destination");
    		source.appendChild(elem);
    		destination.appendChild(x);
    		destination.appendChild(y);
    		j++;
    		i++;
        	$('#relateModal').modal('show');
        })
        
        // search person by experience
        $("#btn-experience").click(function (){
        	var form = document.getElementById("searchByExp");
        	
        	var yearExp = document.getElementById("yearExp");
        	var techName = document.getElementById("techName");
        	
        	var x = document.createElement("INPUT");
    		tmpName = "listFields["+i+"].";
    		x.setAttribute("type", "text");
    		x.setAttribute("name", tmpName+"key");
    		x.setAttribute("id","property-key"+i);
    		yearExp.appendChild(x);
    		
    		var y = document.createElement("INPUT");
    		tmpName = "listFields["+i+"].";
    		y.setAttribute("type", "text");
    		y.setAttribute("name", tmpName+"value");
    		y.setAttribute("id","property-value"+i);
			techName.appendChild(y);
    		
        	$('#expModal').modal('show');
        })
	})

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
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<!-- Modal create relationship -->
	<div class="modal fade" id="relateModal">
	  <div class="modal-dialog modal-md modal-dialog-centered">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 id="name-node" class="modal-title">Add Relationship</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      <!-- Modal body -->
	      <div id="relate-body" class="modal-body">
	      	<form id="formRelate" action="relation" method="get">
				<input class="btn-save" type="submit" value="Create Relationship"><br><br>
				<select name="typeNode">
					<option value="">Source</option>
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
				</select>
				<input type="text" name="relation" placeholder="Enter Relationship">
				<select name="typeNode">
					<option value="">Destination</option>
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
				</select>
				
				<p id="source">Source node: <br></p>
				<p id="destination">Destination node: <br></p>
				<p>Relationship properties</p>
			</form>
				<br><button id="addBtn" onclick="addRelationField()">Add properties</button>
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal search person by experience -->
	<div class="modal fade" id="expModal">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 id="name-node" class="modal-title">Search Person By Experience</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      <!-- Modal body -->
	      <div id="experience" class="modal-body">
	         <form id="searchByExp" action="personExperience" method="get">
	         	<p id="yearExp">Year Experience <br></p>
	         	<p id="techName">Technology <br></p>
	         	<input type="submit" value="Search">
	         </form>
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>