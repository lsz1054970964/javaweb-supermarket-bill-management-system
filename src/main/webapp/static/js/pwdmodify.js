var oldpassword = null;
var newpassword = null;
var rnewpassword = null;
var saveBtn = null;

$(function(){
	oldpassword = $("#oldpassword");
	newpassword = $("#newpassword");
	rnewpassword = $("#rnewpassword");
	saveBtn = $("#save");

	oldpassword.next().html("*");
	newpassword.next().html("*");
	rnewpassword.next().html("*");

	oldpassword.on("blur",function(){
		$.ajax({
			type:"GET",
			url:path+"/jsp/user.do",
			data:{method:"pwdmodify",oldpassword:oldpassword.val()},
			dataType:"json",
			success:function(data){
				if(data.result == "true"){//correct old password
					validateTip(oldpassword.next(),{"color":"green"},imgYes,true);
				}else if(data.result == "false"){//incorrect inputted old password
					validateTip(oldpassword.next(),{"color":"red"},imgNo + " Old password is incorrect",false);
				}else if(data.result == "sessionerror"){//Session is expired
					validateTip(oldpassword.next(),{"color":"red"},imgNo + " Please login again",false);
				}else if(data.result == "error"){//no inputted old password
					validateTip(oldpassword.next(),{"color":"red"},imgNo + " Please input new password",false);
				}
			},
			error:function(data){
				//Request error
				validateTip(oldpassword.next(),{"color":"red"},imgNo + " Request error",false);
			}
		});


	}).on("focus",function(){
		validateTip(oldpassword.next(),{"color":"#666666"},"* please input old password",false);
	});

	newpassword.on("focus",function(){
		validateTip(newpassword.next(),{"color":"#666666"},"* password length: 6-19",false);
	}).on("blur",function(){
		if(newpassword.val() != null && newpassword.val().length > 5
			&& newpassword.val().length < 20 ){
			validateTip(newpassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(newpassword.next(),{"color":"red"},imgNo + " invalid password, type again",false);
		}
	});


	rnewpassword.on("focus",function(){
		validateTip(rnewpassword.next(),{"color":"#666666"},"* please input same password",false);
	}).on("blur",function(){
		if(rnewpassword.val() != null && rnewpassword.val().length > 5
			&& rnewpassword.val().length < 20 && newpassword.val() == rnewpassword.val()){
			validateTip(rnewpassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(rnewpassword.next(),{"color":"red"},imgNo + " two passwords are not same, type again",false);
		}
	});


	saveBtn.on("click",function(){
		oldpassword.blur();
		newpassword.blur();
		rnewpassword.blur();
		if(oldpassword.attr("validateStatus") == "true"
			&& newpassword.attr("validateStatus") == "true"
			&& rnewpassword.attr("validateStatus") == "true"){
			if(confirm("Are you sure to revise password？")){
				$("#userForm").submit();
			}
		}

	});
});