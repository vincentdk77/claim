/**
 * personNo ��ǰ��������Ա���
 * ���ܣ�һ������һ���������
 * �������˲��֮ǰ�����ݣ����е�������һ���������˲��֮��һ����������һ������
 * ������ʷ����ʹ�ò��֮���ҳ�棬��һ������һ�����������Ϊ�����ʷ������������һ������������������е����˴����������һ������̨��ȡֻ��ȡ��һ�����˴������
 * */
function setOpinion(personNo){
	//�ȴ���personNo
	var thisOpinionCode = $("input:radio[name='opinionCode"+personNo+"']:checked").val();
	$("input[name='personKey']").each(function(i,pno){
		$("input:radio[name='opinionCode"+pno.value+"']").each(function(j,oc){
			if(oc.value==thisOpinionCode){
				oc.checked = "checked";
			}
		});
		if(thisOpinionCode == "0"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("�ύ���");
		}
		if(thisOpinionCode == "2"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("����ͨ��");
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
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("������Ϣ");
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
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("ͬ�ⶨ��");
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
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("������Ϣ");
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
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("����һ����Э���⳥");
		}
		if(thisOpinionCode == "8"){
			$("input[name='prpLverifyLossExtTitle"+pno.value+"']:last").val(thisOpinionCode);
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("ͬ��һ����Э���⳥");
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
			$("input[name='prpLverifyLossExtTitleName"+pno.value+"']:last").val("ͬ��һ����Э���⳥");
		}
	});
}
/**���ڶ���һ�������ʱ����Ҫ�����е�һ����Ϣ��������������һ����һ������ʱ*/
function setContext(field){
	var personKey = $("input[name='personKey']");
	for(var i=0;i<personKey.length;i++){
		//��textarea�е���Ϣ���Ƶ�������textarea��
		var newContext = $("textarea[name='prpLverifyLossExtNewContext"+personKey[i].value+"']");
		if(newContext!=field){
			$(newContext).text($(field).text());
		}
	}
}


