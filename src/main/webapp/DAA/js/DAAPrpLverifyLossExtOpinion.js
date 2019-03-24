/**
 * personNo 当前触发的人员编号
 * 功能：一个任务一个处理意见
 * 对于人伤拆分之前的数据，所有的人伤是一个任务，人伤拆分之后，一个人伤任务一个任务
 * 对于历史数据使用拆分之后的页面，故一个人伤一个处理意见，为兼顾历史数据所有人伤一个处理意见，所以所有的人伤处理意见都是一样，后台获取只获取第一个人伤处理意见
 * */
function setOpinion(personNo){
	//先处理personNo
	var thisOpinionCode = $("input:radio[name='opinionCode"+personNo+"']:checked").val();
	$("input[name='personKey']").each(function(i,pno){
		$("input:radio[name='opinionCode"+pno.value+"']").each(function(j,oc){
			if(oc.value==thisOpinionCode){
				oc.checked = "checked";
			}
		});
		if(thisOpinionCode == "0"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("提交审核");
		}
		if(thisOpinionCode == "2"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("复核通过");
			$("#buttonAll").find("input:[type=button]").each(function (){
				if($(this).attr('name')=="buttonBack"){
					$(this).attr("disabled","disabled");
				}
				if($(this).attr('name')=="buttonSave"){
					$(this).removeAttr("disabled");
				}
			});
		}
		if(thisOpinionCode == "3"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("补充信息");
			$("#buttonAll").find("input:[type=button]").each(function (){
				if($(this).attr('name')=="buttonBack"){
					$(this).removeAttr("disabled");
				}
				if($(this).attr('name')=="buttonSave"){
					$(this).attr("disabled","disabled");
				}
			});
		}
		if(thisOpinionCode == "4"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("同意定损");
			$("#buttonAll").find("input:[type=button]").each(function (){
				if($(this).attr('name')=="buttonBack"){
					$(this).attr("disabled","disabled");
				}
				if($(this).attr('name')=="buttonSave"){
					$(this).removeAttr("disabled");
				}
			});
		}
		if(thisOpinionCode == "6"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("补充信息");
			$("#buttonAll").find("input:[type=button]").each(function (){
				if($(this).attr('name')=="buttonBack"){
					$(this).removeAttr("disabled");
				}
				if($(this).attr('name')=="buttonSave"){
					$(this).attr("disabled","disabled");
				}
				
			});
		}
		if(thisOpinionCode == "7"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("申请一次性协议赔偿");
		}
		if(thisOpinionCode == "8"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("同意一次性协议赔偿");
			$("#buttonAll").find("input:[type=button]").each(function (){
				if($(this).attr('name')=="buttonBack"){
					$(this).attr("disabled","disabled");
				}
				if($(this).attr('name')=="buttonSave"){
					$(this).removeAttr("disabled");
				}
				
			});
		}
		if(thisOpinionCode == "9"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("同意一次性协议赔偿");
		}
	});
}
/**对于多人一个任务的时候，需要将其中的一个信息与其他共享，对于一个人一个任务时*/
function setContext(field){
	var personKey = $("input[name='personKey']");
	for(var i=0;i<personKey.length;i++){
		//将textarea中的信息复制到其他的textarea中
		var newContext = $("textarea[name='prpLverifyLossExtNewContext"+personKey[i].value+"']");
		if(newContext!=field){
			$(newContext).text($(field).text());
		}
	}
}


