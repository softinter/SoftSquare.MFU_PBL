<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<head>
<body>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
	<div class="panel panel-Primary">
		  <div class="panel-heading"><lable class="headPanal">Manage Patient</lable>
				
			  </div>
		 </div>
	
	
	
		 <div class="panel-body" style="margin-top:-25px;">

          <div class="row">
			 	<!-- <button type="button" class="btn btn-primary" onclick="backFunction()" >
					<span class="glyphicon glyphicon-menu-left"></span>Back
			 	</button>  -->
			 	
			 	 <button type="button" class="btn btn-primary" onclick="addRow()" >
					<span class="glyphicon glyphicon-plus"></span>New Patient
			 	 </button>		 	 
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					
					<div class="col-md-3">
						<label>Name</label>
						<input id="patientName" type="text" class="form-control" placeholder="Name" name="patientName" disabled>
					</div>
					<div class="col-md-3">
						<label>Birthday</label>
						<input type="date" class="form-control" placeholder="Birthday" name="patientBirthday" disabled>
					</div>
					<div class="col-md-3">
						<label>Address</label>
						<input type="text" class="form-control" placeholder="Address" name="patientAddress" disabled>
					</div>
					<div class="col-md-3">
						<label>Phone</label>
						<input type="text" class="form-control" placeholder="Phone" name="patientPhone" disabled>
					</div>
					<div class="col-md-3">
						<label>Email</label>
						<input type="text" class="form-control" placeholder="Email" name="patientEmail" disabled>
					</div>
					<div class="col-md-3">
						<label>Gender</label>
						<select class="selectpicker show-tick show-menu-arrow" disabled data-width="100%" name="patientGender">
  						<option>Male</option>
  						<option>Female</option>
						</select>
					</div>
					<div class="col-md-3">
						<label>Job</label>
						<input type="text" class="form-control" placeholder="Job" name="patientJob" disabled>
					</div>
					<div class="col-md-3">
						<label>BloodGroup</label>
						<select class="selectpicker show-tick show-menu-arrow" disabled data-width="100%" name="patientBloodGroup" >
						<option>A</option>
						<option>B</option>
						<option>AB</option>
						<option>O</option>
						</select>
					</div>			
					
					
				 	
					
				</div>
		<br>
						<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					
					&emsp;
					
					<button type="button" class="btn btn-Success " name="saveButton" onclick="saveFunction()">
						<span class="glyphicon glyphicon-save"></span>Save
					</button> 
				
					</div>
						
						
						
		        <div class="panel panel-primary filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Patient List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th>Manage</th>
		                        <th><input type="text" class="form-control" placeholder="Name" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Birthday" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Address" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Phone" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Email" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Gender" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Job" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="BloodGroup" disabled></th>
		                    </tr>
		                </thead>
		                <tbody>
		                </tbody>
		            </table>
		        </div>
		    </div>
		 </div>
	</div>
</div>
	
</body>
</head>


<!-- delete alert modal box -->
<div class="modal fade bs-example-modal-sm" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" rowId="">
  <div class="modal-dialog modal-xs" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Warning</h4>
      </div>
       <div class="modal-body" >
       <p>Do you really want to delete?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteRow()">Delete</button>
      </div>
    </div>
  </div>
</div>

<!-- alert box -->
  <div class="modal fade" id="required" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class=" modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Warning</h4>
        </div>
        <div class="modal-body">
          <p>Please, fill all of information!!!</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
          </div>
       
      </div>
      
    </div>
  </div>
  
  <div class="modal fade" id="save" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class=" modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Warning</h4>
        </div>
        <div class="modal-body">
          <p>Your information has been saved.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
          </div>
       
      </div>
      
    </div>
  </div>
</html>