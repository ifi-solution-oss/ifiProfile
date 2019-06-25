<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Update</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
	<h2>Update form</h2>
		<div class="row">
			<div class="col-sm-6">
				<form id="form" action="update" method="post">
					<input type="submit" value="Save"><br>
					<p>Type Node:</p>
					<input type="text" name="typeNode" id="type-node"><br>
					<p>Label Node:</p>
					<input type="text" name="labelNode" id="label-node"><br>
					<p>Properties:</p>
				</form>
				<button id="addBtn" onclick="addField()">Add Field</button><br>
			</div>
			<div class="col-sm-6">
				<table class="table table-hover table-bordered table-striped">
					<thead>
				      <tr>
				        <th>No</th>
				        <th class="col-md-1">Name</th>
				      </tr>
				    </thead>
				    <tbody>
				    <!-- use two-dimensional array to get value of node and field -->
				      <c:forEach var="listValue" items="${listUpdate}" varStatus="count">
				      <tr data-toggle="modal" data-target="#ifiModal" class="idClass" data-id="${listValue.labelNode}" 
	      					data-list="<c:forEach var="field" items="${listValue.listFields}">${field.key}:${field.value}*+*+</c:forEach>">
						  <td>${count.index+1}</td>
						  <td>${field.key}</td>
						  <td>${field.value}</td>
				      </tr>
				      </c:forEach>
				    </tbody>
					
				</table>
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
            console.log(list);
            console.log(my_id_value);
            $("#name-node").text(my_id_value);

            
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
</body>
</html>