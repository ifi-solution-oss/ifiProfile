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

<style>
* {box-sizing: border-box}

body {
  font-family: "Lato", sans-serif;
  height: 100%;
  margin: 0px;

}

/* Style the tab */
.tab {
  float: left;
  border: 1px solid white;
  background-color: #003333;
  width: 20%;
  height: 100%;
  position: fixed;
}

/* Style the buttons inside the tab */
.tab button {
  display: block;
  background-color: #003333;
  color: white;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 17px;
  
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #00cccc;
}

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #00cccc;
}

/* Style the tab content */
.tabcontent {
  float: right;
  margin: 0;
  background-color: #e6e6e6;
  padding: 0;
  width: 80%;
 /* overflow: auto; */
  border-left: none;
  height: 100%;
}
</style>
</head>

<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<div class="tab">
		<button class="tablinks" onclick="openTab(event, 'Home')" id="defaultOpen">Home</button>
		<button class="tablinks" onclick="openTab(event, 'Department')" >Department</button>
		<button class="tablinks" onclick="openTab(event, 'Projects')" >Projects</button>
		<button class="tablinks" onclick="openTab(event, 'Staff')">Staff</button>
		<button class="tablinks" onclick="openTab(event, 'Technologies')">Technologies</button>
	</div>
	
		<!-- Home page -->
	<div id="Home" class="tabcontent">
		<div class="container">
		<h1>IFI Profile</h1>
			<div class="row">
				<div class="col-sm-6">
				<form action="search" id="search" method="post">
					<input id="autocomplete" type="text" name="labelNode">
					<input type="submit" value="Search">
				</form>
				</div>
				
				<div class="col-sm-6">
				<form action="searchByRelation" method="post" id="searchRelation">
					<select name="typeNode">
						<option value="">----Node Source----</option>
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
					</select>
					<input type="text" name="relation" placeholder="Enter Relationship" style="width: 30%">
					<select name="typeNode" id="show-input" onclick="addSearchField()">
						<option value="">----Destination----</option>
						<c:forEach var="list" items="${listLabels}">
							<option value="${list.typeNode }" >${list.typeNode }</option>
						</c:forEach>
					</select>
					<br><input type="submit" value="Search">
				</form>
				</div>
				<div class="col-sm-6">
				<button id="btn-relate">Create Relationship</button>
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
	
function addSearchField() {
		
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
	})

// suggestion for search function
function autocomplete(inp, arr){
	var currentFocus;
	inp.addEventListener("input",function(e){
		var a, val = this.value;
		closeAllLists();
		if(!val){return false;}
		currentFocus = -1;
		a = document.createElement("DIV");
		a.setAttribute("id", this.id + "autocomplete-list");
		a.setAttribute("class", "autocomplete-items");
		this.parentNode.appendChild(a);
		for(var i = 0; i < arr.length; i++){
			if(arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()){
				var b = document.createElement("DIV");
				b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
				b.innerHTML += arr[i].substr(0, val.length);
				b.innerHTML += "<input type='hiden' value='" + arr[i] + "'>";
				b.addEventListener("click", function(e){
					inp.value = this.getElementsByTagName("input")[0].value;
					closeAllLists();
				});
				a.appendChild(b);
			}
		}
	});
	
	inp.addEventListener("keydown", function(e){
		var x = document.getElementById(this.id + "autocomplete-list");
		if(x) x = x.getElementsByTagName("div");
		if(e.keyCode == 40){
			currentFocus++;
			addActive(x);
		} else if(e.keyCode == 38){
			currentFocus--;
			addActive(x);
		} else if(e.keyCode == 13){
			e.preventDefault();
			if(currentFocus>-1){
				if(x) x[currentFocus].click();
			}
		}
	});
	
	function removeActive(x){
		for(var i = 0; i < x.length; i++){
			x[i].classList.remove("autocomplete-active");
		}
	}
	
	function closeAllLists(element){
		var x = document.getElementsByClassName("autocomplete-items");
		for(var i = 0; i< x.length; i++){
			if(element != x[i] && element != inp){
				x[i].parentNode.removeChild(x[i]);
			}
		}
	}
	document.addEventListener("click", function (e) {
	      closeAllLists(e.target);
	  });	
}

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
	
	<script>
		function openTab(evt, tabName){
 		 var i, tabcontent, tablinks;
 		 tabcontent = document.getElementsByClassName("tabcontent");
 		 for (i = 0; i < tabcontent.length; i++) {
  		  tabcontent[i].style.display = "none";
 		 }
  		tablinks = document.getElementsByClassName("tablinks");
  		for (i = 0; i < tablinks.length; i++) {
   		 tablinks[i].className = tablinks[i].className.replace(" active", "");
  		}
  		document.getElementById(tabName).style.display = "block";
  		evt.currentTarget.className += " active";
		}

	document.getElementById("defaultOpen").click();
	</script>
</body>
</html>