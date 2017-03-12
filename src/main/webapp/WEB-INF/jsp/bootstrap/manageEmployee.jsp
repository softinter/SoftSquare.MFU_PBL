<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		<div class="panel panel-Primary">
		  <div class="panel-heading"><lable class="headPanal">Manage User</lable>
				<div class="row" id="positionHeader">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<label class="control-label-required">Position</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="positionList" data-live-search="true" data-size="5" data-header="Select Position" ></select>
					</div>
				  	<div class="col-md-6"></div>
				</div>
			  </div>
		 </div>
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">
		 		<button type="button" class="btn btn-Primary" onclick="addRow()">
					<span class="glyphicon glyphicon-plus"></span>New Employee
				</button> 
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					
					<div class="col-md-3">
					<label for="InputName1">Employee Name</label>
						<input type="text" class="form-control" placeholder="EmployeeName" name="employeeName" disabled>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Birthday</label>
						<input type="date" class="form-control" placeholder="EmployeeBirthday" name="employeeBirthday" disabled>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Address</label>
						<input type="text" class="form-control" placeholder="EmployeeAddress" name="employeeAddress" disabled>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Phone</label>
						<input type="text" class="form-control" placeholder="EmployeePhone" name="employeePhone" disabled>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Email</label>
						<input type="text" class="form-control" placeholder="EmployeeEmail" name="employeeEmail" disabled>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Employee Cost</label>
						<input type="text" class="form-control" placeholder="EmployeeCost" name="employeeCost" disabled>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Position</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="positionList" data-live-search="true" data-size="5" data-header="Select Position" disabled></select>
					</div>
					<div class="col-md-3">
					<label for="InputName1">Employee Log-in</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="loginList" data-live-search="true" data-size="5" data-header="Select Username" disabled></select>
					</div>
					
					
					
				</div>
		      <br>
					<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					
					&emsp;
					<button type="button" class="btn btn-Success " onclick="saveFunction()">
						<span class="glyphicon glyphicon-save"></span>Save
					</button> 
					
					
					
					<button type="button" class="btn btn-primary " onclick="searchFunction()">
						<span class="glyphicon glyphicon-refresh"></span>Refresh list
			</button>
					
			
					<button type="button" class="btn btn-primary " onclick="searchAllFunction()">
						<span class="glyphicon glyphicon-refresh"></span>Show all list
					</button> 
				
					</div>
		        <div class="panel panel-primary filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Employee List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th>Manage</th>
		                        <th><input type="text" class="form-control" placeholder="EmployeeName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="EmployeeBirthday" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="EmployeeAddress" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="EmployeePhone" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="EmployeeEmail" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="EmployeeCost" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="PositionName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Username" disabled></th>
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
          <h4 class="modal-title">Success!!!</h4>
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