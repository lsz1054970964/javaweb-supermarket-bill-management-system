var proContact = null;
var proPhone = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	proContact = $("#proContact");
	proPhone = $("#proPhone");
	saveBtn = $("#save");
	backBtn = $("#back");

	proContact.next().html("*");
	proPhone.next().html("*");
	

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
	
	saveBtn.on("click",function(){
		proContact.blur();
		proPhone.blur();
		if(proContact.attr("validateStatus") == "true" && 
				proPhone.attr("validateStatus") == "true"){
			if(confirm("Are you sure to submit?")){
				$("#providerForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
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