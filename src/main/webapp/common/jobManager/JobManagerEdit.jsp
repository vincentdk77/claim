<%--
****************************************************************************
* DESC       �����Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��chengyupeng
* CREATEDATE ��2011-11-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>

<html:html locale="true">
<head>
	<!--��title����-->
	<title><bean:message key="title.registBeforeEdit.editRegist" /></title>
	<%-- ҳ����ʽ  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/js/showpage.js"> </script>
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<logic:equal value="SHOW" name="editType" >
<body onload="disabledAll()">
</logic:equal>
<logic:notEqual value="SHOW" name="editType">
<body>
</logic:notEqual>
	<form name=fm action="/claim/jobManagerSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
		<input type="hidden" id="editType" name="editType" value="${editType}"/>
		<input type="hidden" id="month" name="month" value="${month}"/>
		<input type="hidden" id="handledept" name="handledept" value="${handledept}"/>
		<input type="hidden" id="classCode" name="classCode" value="${classCode}"/>
		<input type="hidden" id="systemCode" name="systemCode" value="${systemCode}"/>
		<!--  ��ҳǩ-->
		<div class="tab">
			<!--ҳǩͷ-->
			<div class="formtitle">�����Ϣ</div>

			<div class="tab_box">
				<div id="schedulMain">
					<logic:equal value="no" name="inputButtonType">
						<%@include file="/common/jobManager/JobManagerAddPage.jsp"%>
					</logic:equal>
					<bean:define id="tmpValue1" value="${inputButtonType eq 'yes' or editType eq 'EDIT'}" />
					<logic:equal value="true" name="tmpValue1" >
						<%@include file="/common/jobManager/JobManagerUpdatePage.jsp"%>
					</logic:equal>
					<logic:equal value="SHOW" name="editType">
						<%@include file="/common/jobManager/JobManagerUpdatePage.jsp"%>
					</logic:equal>
				</div>
			</div>
		</div>
		<div id="outcontainer" name="submitDiv">
			<div id=content_basic>
				<table align="center" id="buttonTable">
					<tr>
						<td>
							<logic:notEqual value="SHOW" name="editType">
								<logic:equal value="EDIT" name="editType">
									<input type="button" id="backButton" class="button" value="����" onclick="saveForm('4');">
									<input type="button" id="backButton" class="button" value="����" onclick="jobManagerForm('${editType}')">
								</logic:equal>
								<logic:notEqual value="EDIT" name="editType">
									<input type="button" id="backButton" class="button" value="����" onclick="saveForm('4');">
									<input type="button" id="backButton" class="button" value="����" onclick="jobManagerForm('${editType}')">
								</logic:notEqual>
							</logic:notEqual>
							<logic:equal value="SHOW" name="editType">
								<input type="button" id="button" name="button" class="button" value="����" onclick="javascript:history.go(-1);">
							</logic:equal>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<input type="hidden" name="prpljobmanagerDtoHandledept" value="${prpljobmanagerDtoSql.handledept}" >
		<input type="hidden" name="prpljobmanagerDtoMonth" value="${prpljobmanagerDtoSql.month}" >
		<input type="hidden" name="prpljobmanagerDtoHandlercode" value="${prpljobmanagerDtoSql.handlercode}" >
		<input type="hidden" name="prpljobmanagerDtoClassCode" value="${prpljobmanagerDtoSql.classcode}" >
	</form>
</body>
<script>
	var comCNameMap = new HashMap();
	var gradecodeMap = new HashMap();
	var gradecodeMapCheck = new HashMap();
	var gradecodeMapSurve = new HashMap();
	var gradecodeMapAll = new HashMap();
	
	<logic:iterate id="prpDuserDto" name="prpDuserDtoList" >
		comCNameMap.put('${prpDuserDto.userCode}','${prpDuserDto.comCName}');
		gradecodeMap.put('${prpDuserDto.userCode}','${prpDuserDto.gradecode}')
		<logic:equal value="1" name="prpDuserDto" property="gradecode" >
			gradecodeMapCheck.put('${prpDuserDto.userCode}','${prpDuserDto.gradecode}');
		</logic:equal>
		<logic:equal value="2" name="prpDuserDto" property="gradecode" >
			gradecodeMapSurve.put('${prpDuserDto.userCode}','${prpDuserDto.gradecode}');
		</logic:equal>
		<logic:equal value="1;2" name="prpDuserDto" property="gradecode" >
			gradecodeMapAll.put('${prpDuserDto.userCode}','${prpDuserDto.gradecode}');
		</logic:equal>
	</logic:iterate>
	
	function setUp(obj){
		var userCode = obj.value;									//�鿱��ID
		var comCName = comCNameMap.get(obj.value);					//���ڻ���
		var gradecodeID = gradecodeMap.get(obj.value);				//������ɫ
		var userCode = document.getElementsByName('userCode');
		var comCNameSpan = document.getElementsByName('comCName');
		var handlercode = document.getElementsByName('handlercode');
		var gradecodeBox = $(obj).parent().parent().find("input");	//��ȡtr�е� input
		var jobRole = document.getElementsByName('jobRole');
		//alert(gradecodeID);
		//alert(obj.value);
		//�ж��Ƿ� ��ӹ�����
		var indexNo = "";		//��ȡ��ǰselect�����
		var userCodeSelect = $("select[name="+obj.name+"]");
		for(var i=0;i<userCodeSelect.length;i++){
			if(obj != userCodeSelect[i]){
				//alert(obj.value+"-"+userCodeSelect[i].value);
				if(obj.value == userCodeSelect[i].value){
					alert("����ӹ�"+obj.options[obj.selectedIndex].text+"�İ����Ϣ��");
					//return false;
					//break;
					indexNo=i;
				}
			}else{
				indexNo=i;
			}
		}
		//ֵ������
		var handlername = document.getElementsByName('handlername');
		handlername[indexNo].value = obj.options[obj.selectedIndex].text;
		
		if(gradecodeID != null){
			//������ɫ��ֵ
			jobRole[indexNo].value = "";
			for(var i=0;i<gradecodeBox.length;i++){
				gradecodeBox[i].checked="";
				gradecodeBox[i].disabled="";
				if(gradecodeBox[i].type == "checkbox"){
					gradecodeID.indexOf(gradecodeBox[i].value);
					if(gradecodeID.indexOf(gradecodeBox[i].value) >= 0){
						gradecodeBox[i].checked=true;
						var numberNo = "";
						if(gradecodeBox[i].value == '2'){
							numberNo = '2';
						}else if(gradecodeBox[i].value == '1'){
							numberNo = '1';
						}else if(gradecodeBox[i].value == '3'){
							numberNo = '3';
						}
						jobRole[indexNo].value = jobRole[indexNo].value+""+numberNo;
					}else{
						gradecodeBox[i].disabled=true;
					}
				}
				if(gradecodeBox[i].name == 'handlercode'){
					gradecodeBox[i].value = obj.value;
				}
			}
			
			//���ڻ�����ֵ
			for(var i=0 ; i<userCode.length ; i++){
				if(userCode[i] == obj){
					comCNameSpan[i].value = comCName;
				}
			}
		}else{
			for(var i=0;i<gradecodeBox.length;i++){
				gradecodeBox[i].checked="";
				gradecodeBox[i].disabled="";
			}
			jobRole[indexNo].value = "";
			for(var i=0 ; i<userCode.length ; i++){
				if(userCode[i] == obj){
					comCNameSpan[i].value = "";
				}
			}
		}
	}
	
	// ��ɫ��ѡ��ɸѡ�鿱��
	function checkboxFilter(obj){
		var gradecodeBox = $(obj).parent().find("input");
		var jobRole =  "";
		for(var i=0;i<gradecodeBox.length;i++){
			if(gradecodeBox[i].type == 'checkbox'){
				if(gradecodeBox[i].checked == true){
					if(gradecodeBox[i].value == '2'){
						jobRole += '2';
					}else if(gradecodeBox[i].value == '1'){
						jobRole += '1';
					}else if(gradecodeBox[i].value == '3'){
						jobRole += '3';
					}
				}
			}
		}
		for(var i=0;i<gradecodeBox.length;i++){
			if(gradecodeBox[i].name == 'jobRole'){
				gradecodeBox[i].value = jobRole;
			}
		}
		
		
	}
	
	//ɾ��
	function delTable(obj){
		$(obj).parent().parent().parent().remove();
	}
	
	//����ȫѡ
	function allPick(obj,checkboxDay,type){
		var allCheckBox = $(obj).parent().parent().find("input");
		if(type == 'pick'){
			for(var i=0;i<allCheckBox.length;i++){
				if(allCheckBox[i].name == checkboxDay){
					allCheckBox[i].checked=true;
				}
			}
		}else if(type == 'Cancel'){
			for(var i=0;i<allCheckBox.length;i++){
				if(allCheckBox[i].name == checkboxDay){
					allCheckBox[i].checked='';
				}
			}
		}
		else{
			for(var i=0;i<allCheckBox.length;i++){
				if(allCheckBox[i].name == checkboxDay){
					allCheckBox[i].checked='';
				}
			}
		}
	}
	
	function saveForm(id){
		if(id == '4'){
			var jobRole  = $("input[name=jobRole]");
			var userCode = $("input[name=handlercode]");
			var handlername = $("input[name=handlername]");
			var comCName = $("input[name=comCName]");
			var userCodeSelect = $("select[name=userCode]");
			var userCodeHacMap = new HashMap();
			var codeHacMap = new HashMap();
			for(var i=0;i<userCode.length;i++){
				var userid = userCode[i].value;
				if(userCodeHacMap.containsKey(userid)){
					var a = jobRole[codeHacMap.get(userid)].value;
					var b = jobRole[i].value;
					if(a.indexOf(b) >= 0 || b.indexOf(a) >= 0){
						alert(handlername[i].value+"�İ����Ϣ����ظ���");
						return false;
					}
				}else{
					codeHacMap.put(userid,i);
					userCodeHacMap.put(userid,userid);
				}
				//for(var x=0;x<userCode.length;x++){
					//if(userCode[i] != userCode[x]){
						//if(userCode[i].value == userCode[x].value){
							//if(jobRole[i].value.indexOf(jobRole[x].value) >= 0 || jobRole[x].value.indexOf(jobRole[i].value) >= 0){
								//alert(handlername[i].value+"�İ����Ϣ����ظ���");
								//userCode[x].focus();
								//return false;
							//}
						//}
					//}
				//}
				if(userCode[i].value == ''){
					alert("�鿱��Ա����Ϊ��");
					userCodeSelect[i].focus();
					return false;
				}
				if(jobRole[i].value == ""){
					alert("������ɫ����Ϊ��");
					userCode[i].focus();
					return false;
				}
				if(comCName[i].value == ""){
					alert("���ڻ�������Ϊ��");
					comCName[i].focus();
					return false;
				}
				var obj = userCode[i];
				var tbodyObj = $(obj).parent().parent().parent().find("input");
				var x=0;
				for(var a=0;a<tbodyObj.length;a++){
					if(tbodyObj[a].type=='checkbox' && tbodyObj[a].name != 'gradecodeBox'){
						if(tbodyObj[a].checked==true){
							x=x+1;
						}
					}
				}
				if(x==0){
					alert("���ڲ���Ϊ��");
					//userCodeSelect[i].focus();
					return false;
				}
			}
			//��֤��ϵ����Ϣ
			<logic:notEqual value="individual" name="updateType">
			var staffPosition = fm.staffPosition;
			var staffType = fm.staffType;
			var staffName = fm.staffName;
			var staffPhone = fm.staffPhone;
			for(var i=0;i<staffPosition.length;i++){
				if(staffPosition[i].value!=""){
					if(staffType[i].value == ""){
						alert("��ѡ����Ա���ͣ�");
						return false;
					}
					if(staffName[i].value == ""){
						alert("��Ա��������Ϊ�գ�");
						return false;
					}
					if(staffPhone[i].value == ""){
						alert("������绰���룡");
						return false;
					}
				}
			}
			</logic:notEqual>
			
			fm.submit();
			return true;
		}
	}
	
	function addTable(){
		//��ӵ�һ��
		var userCode = document.getElementsByName('handlercode');
		var index = parseInt($("input[name=countNo]:last").val())+parseInt(1);
		var tab = document.getElementById('tab');
		$("#tab").append(
			"<tbody>"+
			"<tr>"+
			"<td class='centertitle' style='width: 10%'>�������<input type=\"hidden\" id=\"countNo\" name=\"countNo\" value=\""+index+"\"><input type=\"hidden\" id=\"flowinTimeDate\" name=\"flowinTimeDate\" value=''></td>"+
			"<td class='centertitle' style='width: 10%'>�鿱��Ա</td>"+
			"<td class='centertitle' style='width: 10%'><select id='userCode' name='userCode' onchange='setUp(this);'><option value='0'>��ѡ��</option><logic:iterate name='prpDuserDtoList' id='prpDuserDto' indexId='count'><option value='${prpDuserDto.userCode}'>${prpDuserDto.userName}</option></logic:iterate></select><input type='hidden' size='5' id='handlercode' name='handlercode' value=''><input type='hidden' id='handlername' name='handlername' /><input type='hidden' id='id' name='id' value=''/></td>"+
			"<td class='centertitle' style='width: 10%'>������ɫ</td>"+
			"<td class='centertitle' style='width: 20%' colspan='2'><input type='hidden' name='jobRole' id='jobRole' value='' /><input type='checkbox' name='gradecodeBox' id='' value='3' onclick='checkboxFilter(this)'>�ǳ��鿱&nbsp;&nbsp;</td>"+
			"<td class='centertitle' style='width: 10%'>���ڻ���</td>"+
			"<td class='centertitle' style='width: 10%'><input type='text' id='comCName' name='comCName' value=''></td>"+
			"<td class='centertitle' style='width: 5%'>����</td>"+
			"</tr>"+
			"<tr id='tr1' name='tr1'>"+
			"<td rowspan='5' class='align='center''>�װ� 8��00��18��00<br/>�������ʱ�䣩</td>"+
			"<logic:iterate id='prpljobmanagertimeDto' name='prpljobmanagertimeDtoList' indexId='count' ><td><input type='checkbox' id='checkboxDayAm"+index+"' name='checkboxDayAm"+index+"' value='${prpljobmanagertimeDto.time}'>${prpljobmanagertimeDto.time}</td>"+
			"<bean:define id='tmpValue' value='${(count+1)/7 }' /><logic:equal value='1' name='tmpValue'><td rowspan='10' align='center'><a onclick='delTable(this)' id='jian' name='jian'><input type=\"button\" value=\"-\" class=\"smallbutton\"></a></td></logic:equal><bean:define id='tmpValue1' value='${(count+1)%7}'/><logic:equal value='0' name='tmpValue1'></tr><tr></logic:equal>"+
			"</logic:iterate >"+
			"<logic:equal value='31' name='day'><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"<logic:equal value='30' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"<logic:equal value='29' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"<logic:equal value='28' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"</tr>"+
			"<tr>"+
			"<td rowspan='5' align='center'>ҹ�� 18��00��8��00<br/>�������ʱ�䣩</td>"+
			"<logic:iterate id='prpljobmanagertimeDto' name='prpljobmanagertimeDtoList' indexId='count' ><td><input type='checkbox' id='checkboxDayPm"+index+"' name='checkboxDayPm"+index+"' value='${prpljobmanagertimeDto.time}'>${prpljobmanagertimeDto.time}</td>"+
			"<bean:define id='tmpValue' value='${(count+1)/7 }' /><logic:equal value='1' name='tmpValue'></logic:equal><bean:define id='tmpValue1' value='${(count+1)%7}' /><logic:equal value='0' name='tmpValue1'></tr><tr></logic:equal>"+
			"</logic:iterate>"+
			"<logic:equal value='31' name='day'><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"<logic:equal value='30' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"<logic:equal value='29' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"<logic:equal value='28' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"ȫ��ѡ��\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"ȫ��ȡ��\"></td></logic:equal>"+
			"</tr>"+
			"</tbody>"
			);
     }
     
     function disabledAll(){
     	$("input").attr("disabled","true");
     	$("select").attr("disabled","true");
     	$("input[name=button]").attr("disabled","");
     }
     function jobManagerForm(editType){
     	if(editType == 'EDIT'){
	     	fm.action="/claim/common/jobManager/JobManagerQueryEdit.jsp";
     	}else{
			fm.action="/claim/jobManagerEdit.do?editType=choiceComCode";
     	}
		fm.submit();
 	}
	
</script>
</html:html>