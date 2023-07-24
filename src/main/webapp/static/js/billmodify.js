var billCode = null;
var productName = null;
var productUnit = null;
var productCount = null;
var totalPrice = null;
var providerId = null;
var saveBtn = null;
var backBtn = null;

function priceReg (value){
	value = value.replace(/[^\d.]/g,"");  //only keep numbers and .
		value = value.replace(/^\./g,"");  //check first character is number or not
    value = value.replace(/\.{2,}/g,"."); //keep first
    value = value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");//remove ￥/$
	if(value.indexOf(".")>0){
		value = value.substring(0,value.indexOf(".")+3);
	}
	return value;
}


$(function(){
	billCode = $("#billCode");
	productName = $("#productName");
	productUnit = $("#productUnit");
	productCount = $("#productCount");
	totalPrice = $("#totalPrice");
	providerId = $("#providerId");
	addBtn = $("#save");
	backBtn = $("#back");

	billCode.next().html("*");
	productName.next().html("*");
	productUnit.next().html("*");
	productCount.next().html("*");
	totalPrice.next().html("*");
	providerId.next().html("*");
	
	$.ajax({
		type:"GET",
		url:path+"/jsp/bill.do",
		data:{method:"getproviderlist"},
		dataType:"json",
		success:function(data){
			if(data != null){
				var pid = $("#pid").val();
				$("select").html("");
				var options = "<option value=\"0\">please select</option>";
				for(var i = 0; i < data.length; i++){
					//alert(data[i].id);
					//alert(data[i].proName);
					if(pid != null && pid != undefined && data[i].id == pid ){
						options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].proName+"</option>";
					}else{
						options += "<option value=\""+data[i].id+"\" >"+data[i].proName+"</option>";
					}
					
				}
				$("select").html(options);
			}
		},
		error:function(data){
			validateTip(providerId.next(),{"color":"red"},imgNo+" get provider list error",false);
		}
	});
	
	productName.on("focus",function(){
		validateTip(productName.next(),{"color":"#666666"},"* please input product name",false);
	}).on("blur",function(){
		if(productName.val() != null && productName.val() != ""){
			validateTip(productName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(productName.next(),{"color":"red"},imgNo+" invalid product name, please input again",false);
		}
		
	});
	
	productUnit.on("focus",function(){
		validateTip(productUnit.next(),{"color":"#666666"},"* please input product unit",false);
	}).on("blur",function(){
		if(productUnit.val() != null && productUnit.val() != ""){
			validateTip(productUnit.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(productUnit.next(),{"color":"red"},imgNo+" invalid product unit, please input again",false);
		}
		
	});
	
	providerId.on("focus",function(){
		validateTip(providerId.next(),{"color":"#666666"},"* please select provider",false);
	}).on("blur",function(){
		if(providerId.val() != null && providerId.val() != "" && providerId.val() != 0){
			validateTip(providerId.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(providerId.next(),{"color":"red"},imgNo+" invalid provider, please select again",false);
		}
		
	});
	
	productCount.on("focus",function(){
		validateTip(productCount.next(),{"color":"#666666"},"* please input positive number with two decimals",false);
	}).on("keyup",function(){
		this.value = priceReg(this.value);
	}).on("blur",function(){
		this.value = priceReg(this.value);
	});
	
	totalPrice.on("focus",function(){
		validateTip(totalPrice.next(),{"color":"#666666"},"* please input positive number with two decimals",false);
	}).on("keyup",function(){
		this.value = priceReg(this.value);
	}).on("blur",function(){
		this.value = priceReg(this.value);
	});
	
	addBtn.on("click",function(){
		productName.blur();
		productUnit.blur();
		providerId.blur();
		if(productName.attr("validateStatus") == "true" 
			&& productUnit.attr("validateStatus") == "true" 
			&& providerId.attr("validateStatus") == "true"){
			if(confirm("Are you sure to submit?")){
				$("#billForm").submit();
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