 application.toolbar.fn.Gennarate = function(){
	 var prams = {};
	 if(!BeanUtils.isEmpty(report01.orderListComboBox.getValue())){
		 prams.orderHeaderId = report01.orderListComboBox.getValue();
		 ReportGen.generate(prams, 'report1');
	 }else{
		 Ext.Msg.alert(__messages['title.warning'], __messages['message.manadatoryFieldIsRequired']);
	 }
 }
 
 
 
// 	function loadMail(){
//	   console.log('aaaaaaaaaaaaaaaaaaaa');
//	}
//
// 	loadMail(); // This will run on page load
//	setInterval(function(){
//		loadMail() // this will run after every 5 seconds
//	}, 5000);