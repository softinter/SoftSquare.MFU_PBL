		$(document).ready(function(){
			searchFunction();
   	    	BSBaseTable.callFiterTable();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search', patientId: headerId};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageAllergic.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr allergicId="'+value.allergicId+'"><td>'+
						                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.allergicId+'")> '+
													'<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" id="btnDeleteAllergic" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.allergicId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> Delete '+
											'</button> '+
												
											'</td> '+
					                        '<td name=allergicCode>'+value.allergicCode+'</td> '+
					                        '<td name=allergicName>'+value.allergicName+'</td>'+
					                        '<td name=allergicDetail>'+value.allergicDetail+'</td> </tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=allergicCode]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=allergicName]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=allergicDetail]').val())
			 ){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'create';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'update';
					params.allergicId = $('div[name=addEditData] input[name=allergicCode]').attr('allergicId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.patientId = headerId;
					params.allergicCode = $('div[name=addEditData] input[name=allergicCode]').val();
					params.allergicName = $('div[name=addEditData] input[name=allergicName]').val();
					params.allergicDetail = $('div[name=addEditData] input[name=allergicDetail]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageAllergic.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=allergicCode]').attr('allergicId', '')
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
			 $('div[name=addEditData] input[name=allergicCode]').val($('tbody tr[allergicId="'+value+'"] td[name=allergicCode]').html());
			 $('div[name=addEditData] input[name=allergicName]').val($('tbody tr[allergicId="'+value+'"] td[name=allergicName]').html());
			 $('div[name=addEditData] input[name=allergicDetail]').val($('tbody tr[allergicId="'+value+'"] td[name=allergicDetail]').html());
			 $('div[name=addEditData] input[name=allergicCode]').attr('allergicId', value);
			 console.info(value)
		 }
		 
		 
		 /*delete function*/
		 $(document).on("click", "#btnDeleteAllergic", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', allergicId : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/manageAllergic.html"
			    	, data: params
			    	, success: function(result){
			    		searchFunction();
			    	}
			    });
			
		 }
		 
		 function backFunction(){
				location.href = "managePatient.html";
		 }
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param, 'create')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='allergicCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='allergicName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='allergicDetail']").prop('disabled', false);
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', false);
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='allergicCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='allergicName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='allergicDetail']").prop('disabled', false);
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='allergicCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='allergicName']").prop('disabled', true);
					$("div[name='addEditData'] input[name='allergicDetail']").prop('disabled', true);
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='allergicCode']").val('');
			 $("div[name='addEditData'] input[name='allergicName']").val('');
			 $("div[name='addEditData'] input[name='allergicDetail']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	