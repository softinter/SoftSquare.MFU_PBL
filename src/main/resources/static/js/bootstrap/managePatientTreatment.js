		$(document).ready(function(){
			searchFunction();
   	    	BSBaseTable.callFiterTable();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search', patientId: headerId};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/managePatientTreatment.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr patienttreatmentId="'+value.patienttreatmentId+'"><td>'+
						                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.patienttreatmentId+'")> '+
													'<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" id="btnDeletePatientTreatment" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.patienttreatmentId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> Delete '+
												'</button> '+
												'<a href='+domainSystem+'/managePatientTreatment.html?patientId='+value.patientId+' class="btn btn-info btn-xs"> '+
												  '<span class="glyphicon glyphicon-share-alt"></span>  Appointment '+
												'</a> '+
												
											'</td> '+
					                        '<td name=patienttreatmentDiseaseName>'+value.patienttreatmentDiseaseName+'</td> '+
					                        '<td name=patienttreatmentDate>'+value.patienttreatmentDate+'</td>'+
					                        '<td name=patienttreatmentHeartRate>'+value.patienttreatmentHeartRate+'</td> '+
					                        '<td name=patienttreatmentPressure>'+value.patienttreatmentPressure+'</td>'+
					                        '<td name=patienttreatmentAge>'+value.patienttreatmentAge+'</td> '+
					                        '<td name=patienttreatmentWeight>'+value.patienttreatmentWeight+'</td>'+
					                        '<td name=patienttreatmentHeight>'+value.patienttreatmentHeight+'</td> '+
					                        '<td name=patienttreatmentStatus>'+value.patienttreatmentStatus+'</td> </tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentDiseaseName]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentDate]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentHeartRate]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentPressure]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentAge]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentWeight]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentHeight]').val())
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=patienttreatmentStatus]').val())
			 ){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'create';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'update';
					params.patienttreatmentId = $('div[name=addEditData] input[name=patienttreatmentDiseaseName]').attr('patienttreatmentId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.patientId = headerId;
					params.patienttreatmentDiseaseName = $('div[name=addEditData] input[name=patienttreatmentDiseaseName]').val();
					params.patienttreatmentDate = $('div[name=addEditData] input[name=patienttreatmentDate]').val();
					params.patienttreatmentHeartRate = $('div[name=addEditData] input[name=patienttreatmentHeartRate]').val();
					params.patienttreatmentPressure = $('div[name=addEditData] input[name=patienttreatmentPressure]').val();
					params.patienttreatmentAge = $('div[name=addEditData] input[name=patienttreatmentAge]').val();
					params.patienttreatmentWeight = $('div[name=addEditData] input[name=patienttreatmentWeight]').val();
					params.patienttreatmentHeight = $('div[name=addEditData] input[name=patienttreatmentHeight]').val();
					params.patienttreatmentStatus = $('div[name=addEditData] input[name=patienttreatmentStatus]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/managePatientTreatment.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=patienttreatmentDiseaseName]').attr('patienttreatmentId', '')
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
			 $('div[name=addEditData] input[name=patienttreatmentDiseaseName]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentDiseaseName]').html());
			 $('div[name=addEditData] input[name=patienttreatmentDate]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentDate]').html());
			 $('div[name=addEditData] input[name=patienttreatmentHeartRate]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentHeartRate]').html());
			 $('div[name=addEditData] input[name=patienttreatmentPressure]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentPressure]').html());
			 $('div[name=addEditData] input[name=patienttreatmentAge]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentAge]').html());
			 $('div[name=addEditData] input[name=patienttreatmentWeight]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentWeight]').html());
			 $('div[name=addEditData] input[name=patienttreatmentHeight]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentHeight]').html());
			 $('div[name=addEditData] input[name=patienttreatmentStatus]').val($('tbody tr[patienttreatmentId="'+value+'"] td[name=patienttreatmentStatus]').html());
			 $('div[name=addEditData] input[name=patienttreatmentDiseaseName]').attr('patienttreatmentId', value);
		 }
		 
		 
		 /*delete function*/
		 $(document).on("click", "#btnDeletePatientTreatment", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', patienttreatmentId : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/managePatientTreatment.html"
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
					$("div[name='addEditData'] input[name='patienttreatmentDiseaseName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentDate']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentHeartRate']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentPressure']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentAge']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentWeight']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentHeight']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentStatus']").prop('disabled', false);
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', false);
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='patienttreatmentDiseaseName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentDate']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentHeartRate']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentPressure']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentAge']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentWeight']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentHeight']").prop('disabled', false);
					$("div[name='addEditData'] input[name='patienttreatmentStatus']").prop('disabled', false);
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='patienttreatmentDiseaseName']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentDate']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentHeartRate']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentPressure']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentAge']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentWeight']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentHeight']").prop('disabled', true);
					$("div[name='addEditData'] input[name='patienttreatmentStatus']").prop('disabled', true);
					$("div[name='addEditData'] button[name='saveButton']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='patienttreatmentDiseaseName']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentDate']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentHeartRate']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentPressure']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentAge']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentWeight']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentHeight']").val('');
			 $("div[name='addEditData'] input[name='patienttreatmentStatus']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	