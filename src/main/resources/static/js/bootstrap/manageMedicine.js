

$(document).ready(function(){
	searchAllFunction();
   	    	var params = {method:'type'};
   	    	BSBaseComboBoxType.getType(params,
   	    			 function(data){
   	    			$("div select[name=typeList]").html(data).selectpicker('refresh');
   	    	});
   	    	
   	    	BSBaseTable.callFiterTable();
	    });
	    
	    function searchFunction(){
	    	console.info(9);
	    	
	    	if(BeanUtils.isNotEmpty($('div#typeHeader select[name="typeList"] option:selected').val())){
	    		
	    		var params = {method: 'search', typeID: $('div#typeHeader select[name="typeList"] option:selected').val()};
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/manageMedicine.html"
		        	, data: params
		        	, success: function(result){
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr><td>'+
					                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.medicineID+'")> '+
												'<span class="glyphicon glyphicon-pencil"></span> Edit '+
											'</button> '+
											'<button type="button" id="btnDeleteMedicine" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.medicineID+'")> '+
											'<span class="glyphicon glyphicon-trash"></span> Delete '+
										'</button> '+
										'</td> '+
										'<td name=medicineName>'+value.medicineName+'</td> '+
				                        '<td name=medicineCost>'+value.medicineCost+'</td> '+
				                        '<td name=typeName>'+value.typeName+'</td> '
				                        );
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
	        	, url: application.contextPath+"/manageMedicine.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		
	            		  data.push('<tr roldId="'+value.medicineID+'"><td>'+
				                    	'<button type="button" class="btn btn-success btn-xs" onclick=editRow("'+value.medicineID+'")> '+
											'<span class="glyphicon glyphicon-pencil"></span> Edit '+
										'</button> '+
										'<button type="button" id="btnDeleteMedicine" class="btn btn-danger btn-xs" data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.medicineID+'")> '+
										'<span class="glyphicon glyphicon-trash"></span> Delete '+
									'</button> '+
									'</td> '+
			                        '<td name=typeCode>'+value.medicineName+'</td> '+
			                        '<td name=typeName>'+value.medicineCost+'</td> '+
			                        '<td name=typeName>'+value.typeName+'</td> '
			                        );
	            	});
	            	$('table.table tbody').html(data.join());	
	            	disAndEnInputField('');
	        	}
	        });
    }
	    
	    
	    
	    
	    
	    
	    
	    function saveFunction(){
	    	console.info(9);
	    	var params = {};
	    	if (BeanUtils.isNotEmpty($('div[name=addEditData] input[name=medicineName]').val()) 
					 && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=medicineCost]').val())
					 ){
	    		if(BeanUtils.isNotEmpty($("div[name='statusSave']").attr('status'))){
	    			console.log(4);
	    			if(BeanUtils.equals($("div[name='statusSave']").attr('status'), 'create')){
	    				console.log(55);
	    				params.method = 'create';
	    				/*alert("Save success");*/
	    				searchAllFunction();
	    			}else if(BeanUtils.equals($("div[name='statusSave']").attr('status'), 'update')){
	    				console.log(66);
	    				params.method = 'update';
	    				/*alert("Update success");*/
	    				searchAllFunction();
	    				
		    		}
	    			var typeID = $("div[name='addEditData'] select[name='typeList']").val();
	    			params.medicineName = $('div[name=addEditData] input[name=medicineName]').val();
					params.medicineCost = $('div[name=addEditData] input[name=medicineCost]').val();
	    			params.typeID = typeID;
	    			};
		    		$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/manageMedicine.html"
			        	, data: params
			        	, success: function(result){
			        		$('div#typeHeader select[name="typeList"]').val(typeID).selectpicker('refresh');
			        		clearValue();
   		        		    searchFunction();
			        		disAndEnInputField();
			        		console.info($('div[name=addEditData] input[name=typeName]').val());
			        		$("div#save").modal();
			        		searchAllFunction();
			        	}
			        });
		    		
	    		}else{
	    			$("div#required").modal();
	    		}
	    }
	    
	    
	    
	    
	    
	    function editRow(value){
	    	disAndEnInputField('update');
	    	var params = {method: 'search', medicineID: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/manageMedicine.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	$("div[name='addEditData'] input[name='medicineName']").val(json[0].medicineName);
	            	$("div[name='addEditData'] input[name='medicineCost']").val(json[0].medicineCost);
	            	$("div[name='addEditData'] select[name='typeList']").val(json[0].typeID).selectpicker('refresh');
	        	}
	    	
	        });
	    }
	    
	    /*delete function*/
		 $(document).on("click", "#btnDeleteMedicine", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
			 var params = {method: 'delete', medicineID : $("div #modalDelete").attr("rowId")};
				$.ajax({
			    	type: 'POST'
			    	, url: application.contextPath+"/manageMedicine.html"
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
			clearValue();
			if(BeanUtils.equals(param, 'update')){
				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='medicineName']").prop('disabled', true);
				$("div[name='addEditData'] input[name='medicineCost']").prop('disabled', false);
				$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			}else if(BeanUtils.equals(param, 'create')){
				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='medicineName']").prop('disabled', false);
				$("div[name='addEditData'] input[name='medicineCost']").prop('disabled', false);
				$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			}else{
				$("div[name='statusSave']").attr('status', '');
				$("div[name='addEditData'] input[name='medicineName']").prop('disabled', true);
				$("div[name='addEditData'] input[name='medicineCost']").prop('disabled', true);
				$("div[name='addEditData'] select[name='typeList']").prop('disabled', true).selectpicker('refresh');
			}
		}
		
		function clearValue(){
			$("div[name='statusSave']").attr('status', '');
			$("div[name='addEditData'] input[name='medicineName']").val('');
			$("div[name='addEditData'] input[name='medicineCost']").val('');
        	$("div[name='addEditData'] select[name='typeList']").val('').selectpicker('refresh');
		}
