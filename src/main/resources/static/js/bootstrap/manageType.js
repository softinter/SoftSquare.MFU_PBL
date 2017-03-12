		$(document).ready(function(){
   	    	BSBaseTable.callFiterTable();
   	    	searchFunction();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageType.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		
			            		  data.push('<tr roldId="'+value.typeID+'"><td>'+
						                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.typeID+'")> '+
													'<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" id="btnDeleteType" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.typeID+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> Delete '+
											'</button> '+
											'</td> '+
					                        '<td name=typeCode>'+value.typeCode+'</td> '+
					                        '<td name=typeName>'+value.typeName+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
//			 console.info("aaaaa");
//			 console.info($('div[name=addEditData] input[name=typeName]').val());
			    if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=typeCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=typeName]').val())){
				 var params = {};
				
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'create';
					
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					
					params.method = 'update';
					params.typeID = $('div[name=addEditData] input[name=typeCode]').attr('typeID');
					
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.typeCode = $('div[name=addEditData] input[name=typeCode]').val();
					params.typeName = $('div[name=addEditData] input[name=typeName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageType.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=typeCode]').attr('typeID', '')
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
			 $('div[name=addEditData] input[name=typeCode]').val($('tbody tr[roldId="'+value+'"] td[name=typeCode]').html());
			 $('div[name=addEditData] input[name=typeName]').val($('tbody tr[roldId="'+value+'"] td[name=typeName]').html());
			 $('div[name=addEditData] input[name=typeCode]').attr('typeID', value);
		 }
		 
		 
		 /*delete function*/
		 $(document).on("click", "#btnDeleteType", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', typeID : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/manageType.html"
			    	, data: params
			    	, success: function(result){
			    		searchFunction();
			    	}
			    });
			
		 }
		 
		 function backFunction(){
				location.href = "home.html";
		 }
		 
		 function backFunction(){
				location.href = "home.html";
		 }
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param, 'create')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='typeCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='typeName']").prop('disabled', false);
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='typeCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='typeName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='typeCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='typeName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='typeCode']").val('');
			 $("div[name='addEditData'] input[name='typeName']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	