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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>

<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
		<!-- Home page -->
	<div id="Home" class="tabcontent">
		<div class="container">
		<h1>IFI Profile</h1>
			<div class="row">
			<!-- Search function -->
				<div class="col-sm-6">
				<!-- Search person by name -->
				<form autocomplete="off" action="search" id="search" method="post">
					<div class="autocomplete">
						<input id="myInput" type="text" name="nameNode">
					</div>
					<input type="submit" value="Search">
				</form><br>
				
				<!-- View profile -->
				<form action="viewProfile" method="get" id="profile">
					<input type="text" name="nameNode">
					<input type="submit" value="View Profile">
				</form>
				
				<!-- Search person by experience -->
				<button id="btn-experience">Search Person By Experience</button><br><br>
			</div>
				
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
				<div class="col-sm-6">
				<!-- Create relationship -->
				<button id="btn-relate">Create Relationship</button>
				
				<!-- Add a new node -->
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
				<div class="col-sm-6">
				<c:if test="${not empty lists}">
					<h4>List Nodes:</h4>
					<table class="table table-hover table-bordered table-striped">
					<thead>
				      <tr>
				        <th>No</th>
				        <th class="col-md-1">Name</th>
				      </tr>
				    </thead>
				    <tbody>
				    <!-- use two-dimensional array to get value of node and field -->
				      <c:forEach var="listValue" items="${lists}" varStatus="count">
				      <tr>
						  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
	      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${count.index+1}</td>
						  <td data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
	      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">${listValue.labelNode}</td>
						 <!-- delete function -->
						  <td data-toggle="modal" data-target="#deleteModal" class="deleteClass" data-id="${listValue.labelNode}"
						  data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-remove"><i class="fas fa-trash-alt"></i></button></td>
						  <!-- update function -->
						  <td data-toggle="modal" data-target="#updateModal" class="updateClass" data-id="${listValue.labelNode}" data-labels="${listValue.typeNode }" 
	      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>"><button class="btn-update" ><i class="fas fa-pen"></i></button></td>		
				      </tr>
				      </c:forEach>
				    </tbody>
					</table>
				</c:if>
				</div>
			</div>
		</div>
	</div>
	
	<div id="Department" class="tabcontent">
	</div>
	
	<div id="Projects" class="tabcontent">
	</div>
	
	<div id="Staff" class="tabcontent">
	</div>
	
	<div id="Technology" class="tabcontent">
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
           
            $("#name-node").text(my_id_value + ' detail');

            var body = document.getElementById("modal-body");    	    
    	    body.innerHTML = '';
            
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
//                 td.style.width  = '100px';
                rowText = rowText.substring(m+1, rowText.length);
                var td = tr.insertCell();
                td.appendChild(document.createTextNode(rowText));
                td.style.border = '1px solid gray';

				list = list.substring(n+4, list.length);
            }
            body.appendChild(tbl);
        }) 
          
        // update node
       $(".updateClass").click(function () {
    	 
        	var my_id_value = $(this).data('id');
            var list = $(this).data('list');
       //     var label = $(this).data('label');
         //   console.log(label);
           console.log(my_id_value);
           console.log(list);
            $("#name-update-node").text(my_id_value + ' detail');

            var form = document.getElementById("formUpdate");    	    
          	
 //           var typeNode = document.createElement("input");
	//		typeNode.setAttribute("type", "text");
	//		typeNode.setAttribute("name", "typeNode");
	//		typeNode.setAttribute("id", "typeNode");
			
			
            while (list.length > 0){
            	var n = list.indexOf("*+*+");
				var rowText = list.substring(0, n);
				
                var m = list.indexOf(":");
				var x = document.createElement("INPUT");
				x.setAttribute("value", "");
				
				tmpName = "listFields["+i+"].";
				x.setAttribute("type", "text");
				x.setAttribute("name", tmpName+"key");
				x.setAttribute("id","property-key"+i);
				x.setAttribute("value",rowText.substring(0, m));
				x.setAttribute("readonly","readonly");
				console.log(x);
                rowText = rowText.substring(m+1, rowText.length);

				var y = document.createElement("INPUT");
				y.setAttribute("value", "");
				tmpName = "listFields["+i+"].";
				y.setAttribute("type", "text");
				y.setAttribute("name", tmpName+"value");
				y.setAttribute("id","property-value"+i);
				y.setAttribute("value",rowText);
				
				
				var elem = document.createElement('br');
				elem.setAttribute("id","property-br"+i); 
				
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
        })
        
        $(".deleteClass").click(function(){
        	var my_id_value = $(this).data('id');
            var list = $(this).data('list');
     
            $("#name-delete-node").text(my_id_value + ' detail');

            var form = document.getElementById("formDelete");    	    
			
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
	
	<!-- Autocomplete javascript -->

	<script>
	function autocomplete(inp, arr) {
	  /*the autocomplete function takes two arguments,
	  the text field element and an array of possible autocompleted values:*/
	  var currentFocus;
	  /*execute a function when someone writes in the text field:*/
	  inp.addEventListener("input", function(e) {
	      var a, b, i, val = this.value;
	      /*close any already open lists of autocompleted values*/
	      closeAllLists();
	      if (!val) { return false;}
	      currentFocus = -1;
	      /*create a DIV element that will contain the items (values):*/
	      a = document.createElement("DIV");
	      a.setAttribute("id", this.id + "autocomplete-list");
	      a.setAttribute("class", "autocomplete-items");
	      /*append the DIV element as a child of the autocomplete container:*/
	      this.parentNode.appendChild(a);
	      /*for each item in the array...*/
	      for (i = 0; i < arr.length; i++) {
	        /*check if the item starts with the same letters as the text field value:*/
	        if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
	          /*create a DIV element for each matching element:*/
	          b = document.createElement("DIV");
	          /*make the matching letters bold:*/
	          b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
	          b.innerHTML += arr[i].substr(val.length);
	          /*insert a input field that will hold the current array item's value:*/
	          b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
	          /*execute a function when someone clicks on the item value (DIV element):*/
	          b.addEventListener("click", function(e) {
	              /*insert the value for the autocomplete text field:*/
	              inp.value = this.getElementsByTagName("input")[0].value;
	              /*close the list of autocompleted values,
	              (or any other open lists of autocompleted values:*/
	              closeAllLists();
	          });
	          a.appendChild(b);
	        }
	      }
	  });
	  /*execute a function presses a key on the keyboard:*/
	  inp.addEventListener("keydown", function(e) {
	      var x = document.getElementById(this.id + "autocomplete-list");
	      if (x) x = x.getElementsByTagName("div");
	      if (e.keyCode == 40) {
	        /*If the arrow DOWN key is pressed,
	        increase the currentFocus variable:*/
	        currentFocus++;
	        /*and and make the current item more visible:*/
	        addActive(x);
	      } else if (e.keyCode == 38) { //up
	        /*If the arrow UP key is pressed,
	        decrease the currentFocus variable:*/
	        currentFocus--;
	        /*and and make the current item more visible:*/
	        addActive(x);
	      } else if (e.keyCode == 13) {
	        /*If the ENTER key is pressed, prevent the form from being submitted,*/
	        e.preventDefault();
	        if (currentFocus > -1) {
	          /*and simulate a click on the "active" item:*/
	          if (x) x[currentFocus].click();
	        }
	      }
	  });
	  function addActive(x) {
	    /*a function to classify an item as "active":*/
	    if (!x) return false;
	    /*start by removing the "active" class on all items:*/
	    removeActive(x);
	    if (currentFocus >= x.length) currentFocus = 0;
	    if (currentFocus < 0) currentFocus = (x.length - 1);
	    /*add class "autocomplete-active":*/
	    x[currentFocus].classList.add("autocomplete-active");
	  }
	  function removeActive(x) {
	    /*a function to remove the "active" class from all autocomplete items:*/
	    for (var i = 0; i < x.length; i++) {
	      x[i].classList.remove("autocomplete-active");
	    }
	  }
	  function closeAllLists(elmnt) {
	    /*close all autocomplete lists in the document,
	    except the one passed as an argument:*/
	    var x = document.getElementsByClassName("autocomplete-items");
	    for (var i = 0; i < x.length; i++) {
	      if (elmnt != x[i] && elmnt != inp) {
	        x[i].parentNode.removeChild(x[i]);
	      }
	    }
	  }
	  var data = document.getElementById();
	  /*execute a function when someone clicks in the document:*/
	  	document.addEventListener("click", function (e) {
	  	    closeAllLists(e.target);
	  	});
		}
	autocomplete(document.getElementById("myInput"), data);
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
	
		<!-- Modal update -->
	<div class="modal fade" id="updateModal">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 id="name-update-node" class="modal-title">Node Detail</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      <!-- Modal body -->
	      <div id="update-body" class="modal-body">
	        	<form id="formUpdate" action="updateNode" method="post">
					<input type="submit" value="Save"><br>
					<p>Label</p>
					<select name="typeNode">
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
					</select><br><br>
				</form>
				<button id="addBtn" onclick="addUpdateField()">Add Field</button><br>
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- Modal delete -->
	<div class="modal fade" id="deleteModal">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 id="name-delete-node" class="modal-title">Node Detail</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      <!-- Modal body -->
	      <div id="delete-body" class="modal-body">
	        <form id="formDelete" action="deleteNode" method="post">
	        	<p>Do you want to delete?</p>
				<p>Label</p>
					<select name="typeNode">
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
					</select><br><br>
				
			</form>
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