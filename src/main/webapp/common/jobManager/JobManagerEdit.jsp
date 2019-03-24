<%--
****************************************************************************
* DESC       ：班表登记录入/修改页面
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-11-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>

<html:html locale="true">
<head>
	<!--对title处理-->
	<title><bean:message key="title.registBeforeEdit.editRegist" /></title>
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/js/showpage.js"> </script>
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
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
		<!--  加页签-->
		<div class="tab">
			<!--页签头-->
			<div class="formtitle">班表信息</div>

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
									<input type="button" id="backButton" class="button" value="保存" onclick="saveForm('4');">
									<input type="button" id="backButton" class="button" value="放弃" onclick="jobManagerForm('${editType}')">
								</logic:equal>
								<logic:notEqual value="EDIT" name="editType">
									<input type="button" id="backButton" class="button" value="保存" onclick="saveForm('4');">
									<input type="button" id="backButton" class="button" value="放弃" onclick="jobManagerForm('${editType}')">
								</logic:notEqual>
							</logic:notEqual>
							<logic:equal value="SHOW" name="editType">
								<input type="button" id="button" name="button" class="button" value="返回" onclick="javascript:history.go(-1);">
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
		var userCode = obj.value;									//查勘人ID
		var comCName = comCNameMap.get(obj.value);					//所在机构
		var gradecodeID = gradecodeMap.get(obj.value);				//工作角色
		var userCode = document.getElementsByName('userCode');
		var comCNameSpan = document.getElementsByName('comCName');
		var handlercode = document.getElementsByName('handlercode');
		var gradecodeBox = $(obj).parent().parent().find("input");	//获取tr中的 input
		var jobRole = document.getElementsByName('jobRole');
		//alert(gradecodeID);
		//alert(obj.value);
		//判断是否 添加过该人
		var indexNo = "";		//获取当前select的序号
		var userCodeSelect = $("select[name="+obj.name+"]");
		for(var i=0;i<userCodeSelect.length;i++){
			if(obj != userCodeSelect[i]){
				//alert(obj.value+"-"+userCodeSelect[i].value);
				if(obj.value == userCodeSelect[i].value){
					alert("已添加过"+obj.options[obj.selectedIndex].text+"的班表信息。");
					//return false;
					//break;
					indexNo=i;
				}
			}else{
				indexNo=i;
			}
		}
		//值班人名
		var handlername = document.getElementsByName('handlername');
		handlername[indexNo].value = obj.options[obj.selectedIndex].text;
		
		if(gradecodeID != null){
			//工作角色赋值
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
			
			//所在机构赋值
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
	
	// 角色复选框筛选查勘人
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
	
	//删除
	function delTable(obj){
		$(obj).parent().parent().parent().remove();
	}
	
	//日期全选
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
						alert(handlername[i].value+"的班表信息添加重复。");
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
								//alert(handlername[i].value+"的班表信息添加重复。");
								//userCode[x].focus();
								//return false;
							//}
						//}
					//}
				//}
				if(userCode[i].value == ''){
					alert("查勘人员不能为空");
					userCodeSelect[i].focus();
					return false;
				}
				if(jobRole[i].value == ""){
					alert("工作角色不能为空");
					userCode[i].focus();
					return false;
				}
				if(comCName[i].value == ""){
					alert("所在机构不能为空");
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
					alert("日期不能为空");
					//userCodeSelect[i].focus();
					return false;
				}
			}
			//验证联系人信息
			<logic:notEqual value="individual" name="updateType">
			var staffPosition = fm.staffPosition;
			var staffType = fm.staffType;
			var staffName = fm.staffName;
			var staffPhone = fm.staffPhone;
			for(var i=0;i<staffPosition.length;i++){
				if(staffPosition[i].value!=""){
					if(staffType[i].value == ""){
						alert("请选择人员类型！");
						return false;
					}
					if(staffName[i].value == ""){
						alert("人员姓名不能为空！");
						return false;
					}
					if(staffPhone[i].value == ""){
						alert("请输入电话号码！");
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
		//添加第一行
		var userCode = document.getElementsByName('handlercode');
		var index = parseInt($("input[name=countNo]:last").val())+parseInt(1);
		var tab = document.getElementById('tab');
		$("#tab").append(
			"<tbody>"+
			"<tr>"+
			"<td class='centertitle' style='width: 10%'>班次名称<input type=\"hidden\" id=\"countNo\" name=\"countNo\" value=\""+index+"\"><input type=\"hidden\" id=\"flowinTimeDate\" name=\"flowinTimeDate\" value=''></td>"+
			"<td class='centertitle' style='width: 10%'>查勘人员</td>"+
			"<td class='centertitle' style='width: 10%'><select id='userCode' name='userCode' onchange='setUp(this);'><option value='0'>请选择</option><logic:iterate name='prpDuserDtoList' id='prpDuserDto' indexId='count'><option value='${prpDuserDto.userCode}'>${prpDuserDto.userName}</option></logic:iterate></select><input type='hidden' size='5' id='handlercode' name='handlercode' value=''><input type='hidden' id='handlername' name='handlername' /><input type='hidden' id='id' name='id' value=''/></td>"+
			"<td class='centertitle' style='width: 10%'>工作角色</td>"+
			"<td class='centertitle' style='width: 20%' colspan='2'><input type='hidden' name='jobRole' id='jobRole' value='' /><input type='checkbox' name='gradecodeBox' id='' value='3' onclick='checkboxFilter(this)'>非车查勘&nbsp;&nbsp;</td>"+
			"<td class='centertitle' style='width: 10%'>所在机构</td>"+
			"<td class='centertitle' style='width: 10%'><input type='text' id='comCName' name='comCName' value=''></td>"+
			"<td class='centertitle' style='width: 5%'>操作</td>"+
			"</tr>"+
			"<tr id='tr1' name='tr1'>"+
			"<td rowspan='5' class='align='center''>白班 8：00～18：00<br/>（含起点时间）</td>"+
			"<logic:iterate id='prpljobmanagertimeDto' name='prpljobmanagertimeDtoList' indexId='count' ><td><input type='checkbox' id='checkboxDayAm"+index+"' name='checkboxDayAm"+index+"' value='${prpljobmanagertimeDto.time}'>${prpljobmanagertimeDto.time}</td>"+
			"<bean:define id='tmpValue' value='${(count+1)/7 }' /><logic:equal value='1' name='tmpValue'><td rowspan='10' align='center'><a onclick='delTable(this)' id='jian' name='jian'><input type=\"button\" value=\"-\" class=\"smallbutton\"></a></td></logic:equal><bean:define id='tmpValue1' value='${(count+1)%7}'/><logic:equal value='0' name='tmpValue1'></tr><tr></logic:equal>"+
			"</logic:iterate >"+
			"<logic:equal value='31' name='day'><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"<logic:equal value='30' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"<logic:equal value='29' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"<logic:equal value='28' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayAm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"</tr>"+
			"<tr>"+
			"<td rowspan='5' align='center'>夜班 18：00～8：00<br/>（含起点时间）</td>"+
			"<logic:iterate id='prpljobmanagertimeDto' name='prpljobmanagertimeDtoList' indexId='count' ><td><input type='checkbox' id='checkboxDayPm"+index+"' name='checkboxDayPm"+index+"' value='${prpljobmanagertimeDto.time}'>${prpljobmanagertimeDto.time}</td>"+
			"<bean:define id='tmpValue' value='${(count+1)/7 }' /><logic:equal value='1' name='tmpValue'></logic:equal><bean:define id='tmpValue1' value='${(count+1)%7}' /><logic:equal value='0' name='tmpValue1'></tr><tr></logic:equal>"+
			"</logic:iterate>"+
			"<logic:equal value='31' name='day'><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"<logic:equal value='30' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"<logic:equal value='29' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
			"<logic:equal value='28' name='day'><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','pick')\"><input type=\"button\" class=\"button\" value=\"全部选择\"></td><td align='center' onclick=\"allPick(this,'checkboxDayPm"+index+"','Cancel')\"><input type=\"button\" class=\"button\" value=\"全部取消\"></td></logic:equal>"+
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