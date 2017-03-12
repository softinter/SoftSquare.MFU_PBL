var BSBaseComboBox = function () {   
    return { getRole: function (params, callBack) {
    		$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.roleCode+" value="+value.roleId+" data-subtext="+value.roleName+">"+value.roleCode+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        }
    };	
}();

var BSBaseComboBoxType = function () {   
    return { getType: function (params, callBack) {
    		$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.typeCode+" value="+value.typeID+" data-subtext="+value.typeName+">"+value.typeCode+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        }
    };	
}();

var BSBaseComboBoxPosition = function () {   
    return { getPosition: function (params, callBack) {
    		$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.positionCode+" value="+value.positionID+" data-subtext="+value.positionName+">"+value.positionDetail+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        }
    };	
}();

var BSBaseComboBoxLogin = function () {   
    return { getLogin: function (params, callBack) {
    		$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.username+" value="+value.id+" data-subtext="+value.username+">"+value.username+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        }
    };	
}();