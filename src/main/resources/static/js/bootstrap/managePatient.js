		$(document).ready(function(){
			searchFunction();
   	    	BSBaseTable.callFiterTable();
	    });

////// Start Patient Tab
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/managePatient.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr patientId="'+value.patientId+'"><td>'+
						                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.patientId+'")> '+
													'<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" id="btnDeletePatient" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.patientId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span> Delete '+
												'</button> '+
												'<ul> <li> <a href='+domainSystem+'/manageAllergic.html?patientId='+value.patientId+' class="btn btn-info btn-xs"> '+
												  '<span class="glyphicon glyphicon-share-alt"></span>Allergic '+
												'</a> </li> '+
												
												'<a href='+domainSystem+'/managePatientTreatment.html?patientId='+value.patientId+' class="btn btn-info btn-xs"> '+
												  '<span class="glyphicon glyphicon-share-alt"></span> Patient Treatment '+
												'</a>'+
											
											'</td> '+
					                        '<td name=patientName>'+value.patientName+'</td> '+
					                        '<td name=patientBirthday>'+value.patientBirthday+'</td>'+
					                        '<td name=patientAddress>'+value.patientAddress+'</td> '+
					                        '<td name=patientPhone>'+value.patientPhone+'</td>'+
					                        '<td name=patientEmail>'+value.patientEmail+'</td> '+
					                        '<td name=patientGender>'+value.patientGender+'</td>'+
					                        '<td name=patientJob>'+value.patientJob+'</td> '+
					                        '<td name=patientBloodGroup>'+value.patientBloodGroup+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patientName]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patientBirthday]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patientAddress]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patientPhone]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patientEmail]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] select[name=patientGender]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patientJob]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] select[name=patientBloodGroup]').val())
			 ){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'create';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'update';
					params.patientId = $('div[name=addEditData] input[name=patientName]').attr('patientId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.patientName = $('div[name=addEditData] input[name=patientName]').val();
					params.patientBirthday = $('div[name=addEditData] input[name=patientBirthday]').val();
					params.patientAddress = $('div[name=addEditData] input[name=patientAddress]').val();
					params.patientPhone = $('div[name=addEditData] input[name=patientPhone]').val();
					params.patientEmail = $('div[name=addEditData] input[name=patientEmail]').val();
					params.patientGender = $('div[name=addEditData] select[name=patientGender]').val();
					params.patientJob = $('div[name=addEditData] input[name=patientJob]').val();
					params.patientBloodGroup = $('div[name=addEditData] select[name=patientBloodGroup]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/managePatient.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=patientName]').attr('patientId', '')
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
			 $('div[name=addEditData] input[name=patientName]').val($('tbody tr[patientId="'+value+'"] td[name=patientName]').html());
			 $('div[name=addEditData] input[name=patientBirthday]').val($('tbody tr[patientId="'+value+'"] td[name=patientBirthday]').html());
			 $('div[name=addEditData] input[name=patientAddress]').val($('tbody tr[patientId="'+value+'"] td[name=patientAddress]').html());
			 $('div[name=addEditData] input[name=patientPhone]').val($('tbody tr[patientId="'+value+'"] td[name=patientPhone]').html());
			 $('div[name=addEditData] input[name=patientEmail]').val($('tbody tr[patientId="'+value+'"] td[name=patientEmail]').html());
			 $('div[name=addEditData] select[name=patientGender]').val($('tbody tr[patientId="'+value+'"] td[name=patientGender]').html());
			 $('div[name=addEditData] input[name=patientJob]').val($('tbody tr[patientId="'+value+'"] td[name=patientJob]').html());
			 $('div[name=addEditData] select[name=patientBloodGroup]').val($('tbody tr[patientId="'+value+'"] td[name=patientBloodGroup]').html());
			 $('div[name=addEditData] input[name=patientName]').attr('patientId', value);
		 }
		 
		 
		 /*delete function*/
		 $(document).on("click", "#btnDeletePatient", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', patientId : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/managePatient.html"
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
					$("div[name='addEditData'] input[name='patientName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientBirthday']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientAddress']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientPhone']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientEmail']").prop('disabled', false);
					$("div[name='addEditData'] select[name='patientGender']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='patientJob']").prop('disabled', false);
					$("div[name='addEditData'] select[name='patientBloodGroup']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', false);
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='patientName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientBirthday']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientAddress']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientPhone']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patientEmail']").prop('disabled', false);
					$("div[name='addEditData'] select[name='patientGender']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='patientJob']").prop('disabled', false);
					$("div[name='addEditData'] select[name='patientBloodGroup']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='patientName']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patientBirthday']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patientAddress']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patientPhone']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patientEmail']").prop('disabled', true);
					$("div[name='addEditData'] select[name='patientGender']").prop('disabled', true).selectpicker('refresh');
					$("div[name='addEditData'] input[name='patientJob']").prop('disabled', true);
					$("div[name='addEditData'] select[name='patientBloodGroup']").prop('disabled', true).selectpicker('refresh');
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='patientName']").val('');
			 $("div[name='addEditData'] input[name='patientBirthday']").val('');
			 $("div[name='addEditData'] input[name='patientAddress']").val('');
			 $("div[name='addEditData'] input[name='patientPhone']").val('');
			 $("div[name='addEditData'] input[name='patientEmail']").val('');
			 $("div[name='addEditData'] select[name='patientGender']").val('');
			 $("div[name='addEditData'] input[name='patientJob']").val('');
			 $("div[name='addEditData'] select[name='patientBloodGroup']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
		 
////// End Patient Tab
	