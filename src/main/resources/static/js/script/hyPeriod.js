searchFunction = function(){
	
	  period.grid.load({
          xaction: 'read',
          method: 'periodGrid',
          periodName  : period.periodName.getValue(),
//          periodDate  : (BeanUtils.isNotEmpty(period.periodDate.getValue()) ? period.periodDate.getValue().dateFormat(application.formatDate) : "")
          periodDate  : period.periodDate.getRawValue()
	  }, function () {});
	
//	var params = {'method':'periodGrid', 'xaction':'read'};
//	
//	$.ajax({
//	    type: 'POST',
//	    url: params.url,
//	    data: params,
//	    success: function(response){
//	    	var json = Ext.decode(response);
//	    	var img = 'data:image/jpeg;base64,'+json.records.imageString;
//	    	period.panel.update('<img src='+img+' />');
//	    },
//	    error: function (jqXHR, textStatus, errorThrown){
//	    	var messErr = 'Error System';
//	    	if(BeanUtils.isNull(params.messageError)){
//	    		messErr = params.messageError;
//	    	}
//	    	SSJs.component.MessageBox.alert('Error',messErr);
//	    	CalendarRender.loadMask.hide();
//	    }
//	});
	
}

period.save = function(){
//	if(period.grid.getStore().isValid()){
//		if(!!period.grid.isDirty()){
//			GridConvert.save(period.grid, {
//				 method: 'periodGrid',
//				 xaction: 'save'
//			},function(){
//				searchFunction();
//			});
//		}	
//	}else{
//		Ext.Msg.alert(__messages['title.warning'], __messages['message.manadatoryFieldIsRequired']);
//	}

//	 var blob = new Blob([json.records.image], {type: 'image/png'}),
//     url = window.URL.createObjectURL(blob),
//     img = document.createElement('img');
//     img.src = url;
	
//	var img = document.createElement('img');
//	img.src = 'data:image/png;base64,' + atob(json.records.imageString);
//	document.body.appendChild(img);
	
	var params = {'method':'upload', 'xaction':'upload'};
//	var reader = new FileReader();
//    reader.onload = function (e) {
//    	params.image = e.target.result;
//    }
//    console.log(params.image);
	
	
	var arstr = period.panel.el.dom.innerHTML.split('base64,');
	var arstr2 = arstr[1].split('</div>');
	var arstr3 = arstr2[0].split('">');
	var arstr4 = arstr3[0].split('" style');
	params.imageString = arstr4[0];
	params.hid = 4;
	params.did = 4;
	
	$.ajax({
	    type: 'POST',
	    url: params.url,
	    data: params,
	    success: function(response){
	    	var json = Ext.decode(response);
//	    	window.location.reload();
	    },
	    error: function (jqXHR, textStatus, errorThrown){
//	    	var messErr = 'Error System';
//	    	if(BeanUtils.isNull(params.messageError)){
//	    		messErr = params.messageError;
//	    	}
//	    	SSJs.component.MessageBox.alert('Error',messErr);
	    	CalendarRender.loadMask.hide();
	    }
	});
	
}

