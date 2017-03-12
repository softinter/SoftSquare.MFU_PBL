		$(document).ready(function(){
   	    	var params = {method:'position'};
   	    	BSBaseComboBoxPosition.getPosition(params,
   	    			 function(data){
   	    			$("div select[name=positionList]").html(data).selectpicker('refresh');
   	    	});
   	    	searchAllFunction();
   	    	BSBaseTable.callFiterTable();
	    });
		$(document).ready(function(){
   	    	var params = {method:'login'};
   	    	BSBaseComboBoxLogin.getLogin(params,
   	    			 function(data){
   	    			$("div select[name=loginList]").html(data).selectpicker('refresh');
   	    	});
   	    	
   	    	BSBaseTable.callFiterTable();
	    });
	    
	    function searchFunction(){
	    	if(BeanUtils.isNotEmpty($('div#positionHeader select[name="positionList"] option:selected').val())){
	    		var params = {method: 'search', positionID: $('div#positionHeader select[name="positionList"] option:selected').val()};
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/manageEmployee.html"
		        	, data: params
		        	, success: function(result){
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr><td>'+
					                    	'<button type="button" class="btn btn-Success btn-xs" onclick=editRow("'+value.employeeID+'")> '+
												'<span class="glyphicon glyphicon-pencil"></span> Edit '+
											'</button> '+
											'<button type="button" id="btnDeleteEmployee" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.employeeID+'")> '+
											'<span class="glyphicon glyphicon-trash"></span> Delete '+
										'</button> '+
										'</td> '+
										'<td name=employeeName>'+value.employeeName+'</td> '+
				                        '<td name=employeeBirthday>'+value.employeeBirthday+'</td>'+
				                        '<td name=employeeAddress>'+value.employeeAddress+'</td> '+
				                        '<td name=employeePhone>'+value.employeePhone+'</td>'+
				                        '<td name=employeeEmail>'+value.employeeEmail+'</td> '+
				                        '<td name=employeeCost>'+value.employeeCost+'</td>'+
				                        '<td name=positionName>'+value.positionName+'</td>'+
				                        '<td name=username>'+value.username+'</td></tr>');
		            	});
		            	$('table.table tbody').html(data.join());		  
		        	}
		        });
	    	}
	    }
	    
	    function searchAllFunction(){
	    	var params = {method: 'search'};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/manageEmployee.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		
	            		  data.push('<tr roldId="'+value.employeeID+'"><td>'+
				                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.employeeID+'")> '+
											'<span class="glyphicon glyphicon-pencil"></span> Edit '+
										'</button> '+
										'<button type="button" id="btnDeleteEmployee" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.employeeID+'")> '+
										'<span class="glyphicon glyphicon-trash"></span> Delete '+
									'</button> '+
									'</td> '+
									'<td name=employeeName>'+value.employeeName+'</td> '+
			                        '<td name=employeeBirthday>'+value.employeeBirthday+'</td>'+
			                        '<td name=employeeAddress>'+value.employeeAddress+'</td> '+
			                        '<td name=employeePhone>'+value.employeePhone+'</td>'+
			                        '<td name=employeeEmail>'+value.employeeEmail+'</td> '+
			                        '<td name=employeeCost>'+value.employeeCost+'</td>'+
			                        '<td name=positionName>'+value.positionName+'</td>'+
			                        '<td name=username>'+value.username+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            	disAndEnInputField('');
	        	}
	        });
    }
	    
	    
	    function saveFunction() {
	    	var params = {};
	    	console.info(11)
//	    	if (BeanUtils.isNotEmpty($("div[name='statusSave']").attr('status'))) {
//	    		console.info(22)
	    		if (BeanUtils.equals($("div[name='statusSave']").attr('status'),'create')) {
	    			console.info(55)
	    			params.method = 'save';
	    			searchAllFunction();
	    		} else if (BeanUtils.equals($("div[name='statusSave']").attr('status'),'update')) {
	    			console.info(44)
	    			params.method = 'update';
	    			searchAllFunction();
	    			params.employeeID = $('div[name=addEditData] input[name=employeeName]').attr('employeeID');
	    		}
	    		var positionID = $("div[name='addEditData'] select[name='positionList']").val();
	    		var loginID = $("div[name='addEditData'] select[name='loginList']").val();
    			params.employeeName = $('div[name=addEditData] input[name=employeeName]').val();
				params.employeeBirthday = $('div[name=addEditData] input[name=employeeBirthday]').val();
				params.employeeAddress = $('div[name=addEditData] input[name=employeeAddress]').val();
				params.employeePhone = $('div[name=addEditData] input[name=employeePhone]').val();
				params.employeeEmail = $('div[name=addEditData] input[name=employeeEmail]').val();
				params.employeeCost = $('div[name=addEditData] input[name=employeeCost]').val();
    			params.positionID = positionID;
    			params.loginID = loginID;
//	    	};
	    	$.ajax({
	    		type : 'POST',
	    		url : application.contextPath + "/manageEmployee.html",
	    		data : params,
	    		success : function(result) {
	    			clearValue();
	    			searchFunction();
	    			searchAllFunction();
	    			disAndEnInputField();
	    			$("div#save").modal();
	    		}
	    	});
	    }
	    

	    function editRow(value){
	    	disAndEnInputField('update');
	    	var params = {method: 'search', employeeID: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/manageEmployee.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	console.info(value);
	            	$('div[name=addEditData] input[name=employeeName]').attr('employeeID',value);
	            	$("div[name='addEditData'] input[name='employeeName']").val(json[0].employeeName);
	            	$("div[name='addEditData'] input[name='employeeBirthday']").val(json[0].employeeBirthday);
	            	$("div[name='addEditData'] input[name='employeeAddress']").val(json[0].employeeAddress);
	            	$("div[name='addEditData'] input[name='employeePhone']").val(json[0].employeePhone);
	            	$("div[name='addEditData'] input[name='employeeEmail']").val(json[0].employeeEmail);
	            	$("div[name='addEditData'] input[name='employeeCost']").val(json[0].employeeCost);
	            	$("div[name='addEditData'] select[name='positionList']").val(json[0].positionID).selectpicker('refresh');
	            	$("div[name='addEditData'] select[name='loginList']").val(json[0].loginID).selectpicker('refresh');
	        	}
	        });
	    }
	    
	    /*delete function*/
		 $(document).on("click", "#btnDeleteEmployee", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'remove', employeeID : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/manageEmployee.html"
			    	, data: params
			    	, success: function(result){
			    		searchFunction();
			    		searchAllFunction();
			    	}
			    });
			
		 }
		
		function addRow(){
			disAndEnInputField('create');
		}
		
		function backFunction(){
			location.href = "home.html";
		}
		
		function disAndEnInputField(param){
//			clearValue();
			if(BeanUtils.equals(param, 'create')){
				createOrUpdateMode(param);
//				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='employeeName']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeBirthday']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeAddress']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeePhone']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeEmail']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeCost']").prop('disabled', false);
				$("div[name='addEditData'] select[name='positionList']").prop('disabled', false).selectpicker('refresh');
				$("div[name='addEditData'] select[name='loginList']").prop('disabled', false).selectpicker('refresh');
			}else if(BeanUtils.equals(param, 'update')){
				createOrUpdateMode(param);
//				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='employeeName']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeBirthday']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeAddress']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeePhone']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeEmail']").prop('disabled', false);
				$("div[name='addEditData'] input[name='employeeCost']").prop('disabled', false);
				$("div[name='addEditData'] select[name='positionList']").prop('disabled', false).selectpicker('refresh');
				$("div[name='addEditData'] select[name='loginList']").prop('disabled', false).selectpicker('refresh');
			}else{
//				$("div[name='statusSave']").attr('status', '');
				createOrUpdateMode(param);
				$("div[name='addEditData'] input[name='employeeName']").prop('disabled', true);
				$("div[name='addEditData'] input[name='employeeBirthday']").prop('disabled', true);
				$("div[name='addEditData'] input[name='employeeAddress']").prop('disabled', true);
				$("div[name='addEditData'] input[name='employeePhone']").prop('disabled', true);
				$("div[name='addEditData'] input[name='employeeEmail']").prop('disabled', true);
				$("div[name='addEditData'] input[name='employeeCost']").prop('disabled', true);
				$("div[name='addEditData'] select[name='positionList']").prop('disabled', true).selectpicker('refresh');
				$("div[name='addEditData'] select[name='loginList']").prop('disabled', true).selectpicker('refresh');
			}
		}
		
		function clearValue(){
//			$("div[name='statusSave']").attr('status', '');
			$("div[name='addEditData'] input[name='employeeName']").val('');
        	$("div[name='addEditData'] input[name='employeeBirthday']").val('');
        	$("div[name='addEditData'] input[name='employeeAddress']").val('');
        	$("div[name='addEditData'] input[name='employeePhone']").val('');
        	$("div[name='addEditData'] input[name='employeeEmail']").val('');
        	$("div[name='addEditData'] input[name='employeeCost']").val('');
        	$("div[name='addEditData'] select[name='positionList']").val('').selectpicker('refresh');
        	$("div[name='addEditData'] select[name='loginList']").val('').selectpicker('refresh');
		}
		
		function createOrUpdateMode(param){
			$("div[name='addEditData'] input[name='employeeName']").val('');
        	$("div[name='addEditData'] input[name='employeeBirthday']").val('');
        	$("div[name='addEditData'] input[name='employeeAddress']").val('');
        	$("div[name='addEditData'] input[name='employeePhone']").val('');
        	$("div[name='addEditData'] input[name='employeeEmail']").val('');
        	$("div[name='addEditData'] input[name='employeeCost']").val('');
        	$("div[name='addEditData'] select[name='positionList']").val('').selectpicker('refresh');
        	$("div[name='addEditData'] select[name='loginList']").val('').selectpicker('refresh');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('status', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('status', 'update');
			 }else{
				 $("div[name='statusSave']").attr('status', '');
			 }
		 }
