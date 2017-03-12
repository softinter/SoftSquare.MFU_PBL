$(document).ready(function(){
			searchFunction(headerId);
   	    	BSBaseTable.callFiterTable();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/managePosition.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr positionID="'+value.positionID+'"><td>'+
						                    	'<button type="button" class="btn btn-Success btn-xs" onclick=editRow("'+value.positionID+'")> '+
													'<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" id="btnDeletePosition" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.positionID+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> Delete '+
											'</button> '+
											'</td> '+
					                        '<td name=positionCode>'+value.positionCode+'</td> '+
					                        '<td name=positionName>'+value.positionName+'</td>'+
					                        '<td name=positionDetail>'+value.positionDetail+'</td>'+'</tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
	
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=positionCode]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=positionName]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=positionDetail]').val())
					
					
			 ){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'create';
					$("div#save").modal();
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'update';
					params.positionID = $('div[name=addEditData] input[name=positionCode]').attr('positionID');
					
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.positionCode = $('div[name=addEditData] input[name=positionCode]').val();
					params.positionName = $('div[name=addEditData] input[name=positionName]').val();
					params.positionDetail = $('div[name=addEditData] input[name=positionDetail]').val();
				
					
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/managePosition.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=positionName]').attr('positionID', '')
			        		
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
			 $('div[name=addEditData] input[name=positionCode]').attr('positionID', value);
			 $('div[name=addEditData] input[name=positionCode]').val($('tbody tr[positionID="'+value+'"] td[name=positionCode]').html());
			 $('div[name=addEditData] input[name=positionName]').val($('tbody tr[positionID="'+value+'"] td[name=positionName]').html());
			 $('div[name=addEditData] input[name=positionDetail]').val($('tbody tr[positionID="'+value+'"] td[name=positionDetail]').html());
			
			 
		 }
		 
		 
		 /*delete function*/
		 $(document).on("click", "#btnDeletePosition", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', positionID : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/managePosition.html"
			    	, data: params
			    	, success: function(result){
			    		searchFunction();
			    	}
			    });
			
		 }
		 
		 function backFunction(){
				location.href = "home.html";
		 }
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param, 'create')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='positionCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='positionName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='positionDetail']").prop('disabled', false);
			

				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='positionCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='positionName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='positionDetail']").prop('disabled', false);
	
		
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='positionCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='positionName']").prop('disabled', true);
					$("div[name='addEditData'] input[name='positionDetail']").prop('disabled', true);
				
				
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='positionCode']").val('');
			 $("div[name='addEditData'] input[name='positionName']").val('');
			 $("div[name='addEditData'] input[name='positionDetail']").val('');
		

			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
