var proCode = null;
var proName = null;
var proContact = null;
var proPhone = null;
var addBtn = null;
var backBtn = null;

$(function(){
	proCode = $("#proCode");
	proName = $("#proName");
	proContact = $("#proContact");
	proPhone = $("#proPhone");
	addBtn = $("#add");
	backBtn = $("#back");
	proCode.next().html("*");
	proName.next().html("*");
	proContact.next().html("*");
	proPhone.next().html("*");
	

	proCode.on("blur",function(){
		if(proCode.val() != null && proCode.val() != ""){
			validateTip(proCode.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proCode.next(),{"color":"red"},imgNo+" invalid provider code, please input again",false);
		}
	}).on("focus",function(){
		validateTip(proCode.next(),{"color":"#666666"},"* please input provider code",false);
	}).focus();
	
	proName.on("focus",function(){
		validateTip(proName.next(),{"color":"#666666"},"* please input provider name",false);
	}).on("blur",function(){
		if(proName.val() != null && proName.val() != ""){
			validateTip(proName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proName.next(),{"color":"red"},imgNo+" invalid provider name, please input again",false);
		}
		
	});
	
	proContact.on("focus",function(){
		validateTip(proContact.next(),{"color":"#666666"},"* please input contact",false);
	}).on("blur",function(){
		if(proContact.val() != null && proContact.val() != ""){
			validateTip(proContact.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proContact.next(),{"color":"red"},imgNo+" invalid contact, please input again",false);
		}
		
	});
	
	proPhone.on("focus",function(){
		validateTip(proPhone.next(),{"color":"#666666"},"* please input phone",false);
	}).on("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(proPhone.val().match(patrn)){
			validateTip(proPhone.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proPhone.next(),{"color":"red"},imgNo + " invalid phone, please input again",false);
		}
	});
	
	addBtn.bind("click",function(){
		if(proCode.attr("validateStatus") != "true"){
			proCode.blur();
		}else if(proName.attr("validateStatus") != "true"){
			proName.blur();
		}else if(proContact.attr("validateStatus") != "true"){
			proContact.blur();
		}else if(proPhone.attr("validateStatus") != "true"){
			proPhone.blur();
		}else{
			if(confirm("Are you sure to submit?")){
				$("#providerForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});