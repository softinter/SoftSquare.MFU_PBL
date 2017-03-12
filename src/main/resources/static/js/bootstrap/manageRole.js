		$(document).ready(function(){
			searchFunction();
   	    	BSBaseTable.callFiterTable();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageRole.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr roldId="'+value.roleId+'"><td>'+
						                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.roleId+'")> '+
													'<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" id="btnDeleteRole" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.roleId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> Delete '+
											'</button> '+
											'</td> '+
					                        '<td name=roleCode>'+value.roleCode+'</td> '+
					                        '<td name=roleName>'+value.roleName+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=roleCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=roleName]').val())){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'create';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'update';
					params.roleId = $('div[name=addEditData] input[name=roleCode]').attr('roleId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.roleCode = $('div[name=addEditData] input[name=roleCode]').val();
					params.roleName = $('div[name=addEditData] input[name=roleName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageRole.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=roleCode]').attr('roleId', '')
			        		$("div#save").modal();
			        	}
			        });
				}
			 }else{
				 $("div#required").modal();
			 }
		 }
		 
		 function addRow(){
			 disAndEnInputField('create');
		 }
		 
		 function editRow(value){
			 disAndEnInputField('update');
			 $('div[name=addEditData] input[name=roleCode]').val($('tbody tr[roldId="'+value+'"] td[name=roleCode]').html());
			 $('div[name=addEditData] input[name=roleName]').val($('tbody tr[roldId="'+value+'"] td[name=roleName]').html());
			 $('div[name=addEditData] input[name=roleCode]').attr('roleId', value);
		 }
		 
		 /*delete function*/
		 $(document).on("click", "#btnDeleteRole", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 function deleteRow(value){
			 if(BeanUtils.isNotEmpty(value)){
				 var params = {method: 'delete', roleId: $("div #modalDelete").attr("rowId")};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageRole.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        	}
			        });
			 }
		 }
		 
		 function backFunction(){
				location.href = "home.html";
		 }
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param, 'create')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='roleCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='roleName']").prop('disabled', false);
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='roleCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='roleName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='roleCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='roleName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='roleCode']").val('');
			 $("div[name='addEditData'] input[name='roleName']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	