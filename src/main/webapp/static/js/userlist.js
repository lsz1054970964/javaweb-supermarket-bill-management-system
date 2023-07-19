var userObj;

function deleteUser(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/user.do",
		data:{method:"deluser",uid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//delete successfully
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//fail to delete
				changeDLGContent("sorry，deleting user【"+obj.attr("username")+"】failed");
			}else if(data.delResult == "notexist"){
				changeDLGContent("sorry，user【"+obj.attr("username")+"】doesn't exist");
			}
		},
		error:function(data){
			changeDLGContent("sorry，deleting failed");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewUser").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/user.do?method=view&uid="+ obj.attr("userid");
	});
	
	$(".modifyUser").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/user.do?method=modify&uid="+ obj.attr("userid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteUser(userObj);
	});

	$(".deleteUser").on("click",function(){
		userObj = $(this);
		changeDLGContent("Are you sure to delete【"+userObj.attr("username")+"】？");
		openYesOrNoDLG();
	});
	
	$(".deleteUser").on("click",function(){
		var obj = $(this);
		if(confirm("Are you sure to delete【"+obj.attr("username")+"】？")){
			$.ajax({
				type:"GET",
				url:path+"/jsp/user.do",
				data:{method:"deluser",uid:obj.attr("userid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){
						alert("deleting succeed");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){
						alert("sorry，deleting user【"+obj.attr("username")+"】failed");
					}else if(data.delResult == "notexist"){
						alert("sorry，user【"+obj.attr("username")+"】doesn't exist");
					}
				},
				error:function(data){
					alert("sorry, deleting failed");
				}
			});
		}
	});
});