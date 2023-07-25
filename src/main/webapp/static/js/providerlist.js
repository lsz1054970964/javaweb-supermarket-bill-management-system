var providerObj;

function deleteProvider(obj){
	$.ajax({
		type:"GET",
		url:path+"/jsp/provider.do",
		data:{method:"delprovider",proid:obj.attr("proid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//deleting succeed
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//deleting fialed
				changeDLGContent("sorry, deleting provider【"+obj.attr("proname")+"】failed");
			}else if(data.delResult == "notexist"){
				changeDLGContent("sorry，provider【"+obj.attr("proname")+"】doesn't exist");
			}else{
				changeDLGContent("sorry，provider【"+obj.attr("proname")+"】has【"+data.delResult+"】orders，cannot delete");
			}
		},
		error:function(data){
			changeDLGContent("sorry，error occurs");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeProv').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
$(function(){
	$(".viewProvider").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/provider.do?method=view&proid="+ obj.attr("proid");
	});
	
	$(".modifyProvider").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/jsp/provider.do?method=modify&proid="+ obj.attr("proid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteProvider(providerObj);
	});

	$(".deleteProvider").on("click",function(){
		providerObj = $(this);
		changeDLGContent("Are you sure to delete【"+providerObj.attr("proname")+"】？");
		openYesOrNoDLG();
	});

});