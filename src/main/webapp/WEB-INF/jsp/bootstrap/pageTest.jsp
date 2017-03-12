<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
s
<html>
<div class="container">
	<div class="form-group">
		<div class="panel panel-default">
		  <div class="panel-heading"><lable class="headPanal">Manage User</lable>
				<div class="row" id="roleHeader">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<label class="control-label-required">Role</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="roleList" data-live-search="true" data-size="5" data-header="Select Role" ></select>
					</div>
				  	<div class="col-md-6"></div>
				</div>
			  </div>
		 </div>
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">
		 		<button type="button" class="btn btn-success" onclick="addRow()">
					<span class="glyphicon glyphicon-plus"></span>Add
				</button> 
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					<div class="col-md-3">
						<input type="text" class="form-control" placeholder="Name" name="name" disabled>
					</div>
					<div class="col-md-3">
						<input type="password" class="form-control" placeholder="Password" name="password" disabled>
					</div>
					<div class="col-md-3">
						<input type="password" class="form-control" placeholder="Re-Password" name="rePassword" disabled>
					</div>
					<div class="col-md-3">
						<select class="selectpicker show-tick show-menu-arrow"  name="roleList" data-live-search="true" data-size="5" data-header="Select Role" disabled></select>
					</div>
				</div>
		        <div class="panel panel-primary filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Role List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th>Manage</th>
		                        <th><input type="text" class="form-control" placeholder="Name" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Role" disabled></th>
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
    
    <script type="text/javascript">
	    $(document).ready(function(){
   	    	var params = {method:'role'};
   	    	BSBaseComboBox.getRole(params,
   	    			 function(data){
   	    			$("div select[name=roleList]").html(data).selectpicker('refresh');
   	    	});
   	    	
   	    	BSBaseTable.callFiterTable();
	    });
	    
	    function searchFunction(){
	    	var params = {method: 'search', roleId: $('div#roleHeader select[name="roleList"] option:selected').val()};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/register.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		  data.push('<tr><td>'+
				                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.userId+'")> '+
											'<span class="glyphicon glyphicon-pencil"></span> Edit '+
										'</button> '+
										'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.userId+'")> '+
											'<span class="glyphicon glyphicon-trash"></span> Delete '+
										'</button> '+
									'</td> '+
			                        '<td>'+value.userName+'</td> '+
			                        '<td>'+value.role+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());		  
	        	}
	        });
	    }
	    
	    function editRow(value){
	    	disAndEnInputField('update');
	    	var params = {method: 'search', userId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/register.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	$("div[name='addEditData'] input[name='name']").val(json[0].userName);
	            	$("div[name='addEditData'] input[name='password']").val(json[0].password);
	            	$("div[name='addEditData'] input[name='rePassword']").val(json[0].password);
	            	$("div[name='addEditData'] select[name='roleList']").val(json[0].roleId).selectpicker('refresh');
	        	}
	        });
	    }
	    
		function deleteRow(value){
			var params = {method: 'delete', userId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/register.html"
	        	, data: params
	        	, success: function(result){
	        		searchFunction();
	        	}
	        });
	    }
		
		function addRow(){
			disAndEnInputField('create');
		}
		
		function disAndEnInputField(param){
			clearValue();
			if(BeanUtils.equals(param, 'update')){
				$("div[name='addEditData'] input[name='name']").prop('disabled', true);
				$("div[name='addEditData'] input[name='password']").prop('disabled', false);
				$("div[name='addEditData'] input[name='rePassword']").prop('disabled', false);
				$("div[name='addEditData'] select[name='roleList']").prop('disabled', false).selectpicker('refresh');
			}else if(BeanUtils.equals(param, 'create')){
				$("div[name='addEditData'] input[name='name']").prop('disabled', false);
				$("div[name='addEditData'] input[name='password']").prop('disabled', false);
				$("div[name='addEditData'] input[name='rePassword']").prop('disabled', false);
				$("div[name='addEditData'] select[name='roleList']").prop('disabled', false).selectpicker('refresh');
			}
		}
		
		function clearValue(){
			$("div[name='addEditData'] input[name='name']").val('');
        	$("div[name='addEditData'] input[name='password']").val('');
        	$("div[name='addEditData'] input[name='rePassword']").val('');
        	$("div[name='addEditData'] select[name='roleList']").val('').selectpicker('refresh');
		}
    </script>
    
</html>