		$(document).ready(function(){
   	    	var params = {method:'role'};
   	    	BSBaseComboBox.getRole(params,
   	    			 function(data){
   	    			$("div select[name=roleList]").html(data).selectpicker('refresh');
   	    	});
   	    	
   	    	BSBaseTable.callFiterTable();
	    });
	    
	    function searchFunction(){
	    	if(BeanUtils.isNotEmpty($('div#roleHeader select[name="roleList"] option:selected').val())){
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
					                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.userId+'")> '+
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
	    }
	    
	    function searchAllFunction(){
	    	var params = {method: 'search'};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/register.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		
	            		  data.push('<tr roldId="'+value.userId+'"><td>'+
				                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.userId+'")> '+
											'<span class="glyphicon glyphicon-pencil"></span> Edit '+
										'</button> '+
										'<button type="button" id="btnDeleteRegister" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.userId+'")> '+
										'<span class="glyphicon glyphicon-trash"></span> Delete '+
									'</button> '+
									'</td> '+
									'<td>'+value.userName+'</td> '+
			                        '<td>'+value.role+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            	disAndEnInputField('');
	        	}
	        });
    }
	    
	    function saveFunction(){
	    	var params = {};
	    	if(BeanUtils.equals($("div[name='addEditData'] input[name='password']").val(), $("div[name='addEditData'] input[name='rePassword']").val())){
	    		if(BeanUtils.isNotEmpty($("div[name='statusSave']").attr('status'))){
	    			if(BeanUtils.equals($("div[name='statusSave']").attr('status'), 'create')){
	    				params.method = 'save';
	    			}else if(BeanUtils.equals($("div[name='statusSave']").attr('status'), 'update')){
	    				params.method = 'edit';
		    		}
	    			var roleId = $("div[name='addEditData'] select[name='roleList']").val();
	    			params.userName = $("div[name='addEditData'] input[name='name']").val();
	    			params.password = $("div[name='addEditData'] input[name='password']").val();
	    			params.roleId = roleId;
	    			};
		    		$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/register.html"
			        	, data: params
			        	, success: function(result){
			        		$('div#roleHeader select[name="roleList"]').val(roleId).selectpicker('refresh');
			        		clearValue();
			        		searchFunction();
			        		disAndEnInputField();
			        		$("div#save").modal();
			        	}
			        });
	    		}else{
	    			$("div#required").modal();
	    		}
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
	    
	    /*delete function*/
		 $(document).on("click", "#btnDeleteRegister", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', userId : $("div #modalDelete").attr("rowId")};
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
		
		function backFunction(){
			location.href = "home.html";
		}
		
		function disAndEnInputField(param){
			clearValue();
			if(BeanUtils.equals(param, 'update')){
				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='name']").prop('disabled', true);
				$("div[name='addEditData'] input[name='password']").prop('disabled', false);
				$("div[name='addEditData'] input[name='rePassword']").prop('disabled', false);
				$("div[name='addEditData'] select[name='roleList']").prop('disabled', false).selectpicker('refresh');
			}else if(BeanUtils.equals(param, 'create')){
				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='name']").prop('disabled', false);
				$("div[name='addEditData'] input[name='password']").prop('disabled', false);
				$("div[name='addEditData'] input[name='rePassword']").prop('disabled', false);
				$("div[name='addEditData'] select[name='roleList']").prop('disabled', false).selectpicker('refresh');
			}else{
				$("div[name='statusSave']").attr('status', '');
				$("div[name='addEditData'] input[name='name']").prop('disabled', true);
				$("div[name='addEditData'] input[name='password']").prop('disabled', true);
				$("div[name='addEditData'] input[name='rePassword']").prop('disabled', true);
				$("div[name='addEditData'] select[name='roleList']").prop('disabled', true).selectpicker('refresh');
			}
		}
		
		function clearValue(){
			$("div[name='statusSave']").attr('status', '');
			$("div[name='addEditData'] input[name='name']").val('');
        	$("div[name='addEditData'] input[name='password']").val('');
        	$("div[name='addEditData'] input[name='rePassword']").val('');
        	$("div[name='addEditData'] select[name='roleList']").val('').selectpicker('refresh');
		}
