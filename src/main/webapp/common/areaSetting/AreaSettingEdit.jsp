<%--
****************************************************************************
* DESC       ：区域设置主页面
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-11-23
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
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<%-- 页面样式  --%>
	<script src="/claim/common/areaSetting/js/AreaSettingEdit.js"></script>
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/js/showpage.js"> </script>
	<script src="/claim/common/js/layer.js"></script>
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<logic:notEqual name="editType" value="SHOW">
	<body>
</logic:notEqual>
<logic:equal name="editType" value="SHOW">
	<body onload="disabledAll()">
</logic:equal>
<form name=fm action="/claim/areaSettingSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
	<input type="hidden" id="editType" name="editType" value="${editType}" />
	<input type="hidden" id="handledept" name="handledept" value="${handledept}" />
	<input type="hidden" id="classCode" name="classCode" value="${classCode }" />
	<!--  加页签-->
	<div class="tab">
		<!--页签头-->
		<div class="formtitle">人员信息</div>

		<div class="tab_box">
			<div id="schedulMain">
				<logic:equal name="editType" value="ADD">
					<%@include file="/common/areaSetting/AreaSettingAddPage.jsp"%>
				</logic:equal>
				<logic:equal name="editType" value="EDIT">
					<%@include file="/common/areaSetting/AreaSettingUpdatePage.jsp"%>
				</logic:equal>
			</div>
		</div>
	</div>
	<!-- 区域设置修改时，用于删除表中老记录 begin -->
	<input type="hidden" name="prplareasettingDtoHandledept" id="prplareasettingDtoHandledept" value="${prplareasettingDtoHandledept}">
	<input type="hidden" name="prplareasettingDtoHandlercode" id="prplareasettingDtoHandlercode" value="${prplareasettingDtoHandlercode}">
	<input type="hidden" name="prplareasettingDtoClassCode" id="prplareasettingDtoClassCode" value="${prplareasettingDtoClassCode}">
	<!-- 区域设置修改时，用于删除表中老记录 end -->
	<!-- 蒙层 bigen -->
	<div id="divSpan" style="display:none">
		<input type="hidden" id="number" name="number" value=""/>
		<table width="100%" class="textc" style="">
			<tr>
				<td>
					<select size="10" id="oldSelect" onclick="createSelect(this,'newSelect')">
						<logic:iterate id="prpDcompanyDto" name="prpDcompanyDtoList">
							<option value="${prpDcompanyDto.comCode}">${prpDcompanyDto.comCName}</option>
						</logic:iterate>
					</select>
				</td>
				<td>
					<select size="10" id="newSelect" onclick="createSelect(this,'oldSelect')">

					</select>
				</td>
				
			</tr>
		</table>
		<div id="outcontainer" name="" class="textc">
			<input type="button" id="backButton" class="button" value="确定" onclick="setArea()">
			<input type="button" id="backButton" class="button" value="放弃" onclick="closeMsg()">
		</div>
	</div>
	<!-- 蒙层 end -->
	
	
	<div id="outcontainer" name="submitDiv" class="textc">
		<div id=content_basic>
			<table align="center" id="buttonTable">
				<tr>
					<td>
						<input type="button" id="backButton" class="button" value="保存" onclick="butForm('4');">
						<input type="button" id="backButton" class="button" value="放弃" onclick="areaListForm()">
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
<script type="text/javascript">
	var userDtoMap = new HashMap();
	<logic:present name="userMap">
		<logic:iterate id="userMap" name="userMap">
			userDtoMap.put('${userMap.key}','${userMap.value}');
		</logic:iterate>
	</logic:present>
	var comLevelMap = new HashMap();
	<logic:present name="prpDcompanyDtoList">
		<logic:iterate id="prpDcompanyDto" name="prpDcompanyDtoList">
			comLevelMap.put('${prpDcompanyDto.comCode}','${prpDcompanyDto.comLevel}');
		</logic:iterate>
	</logic:present>

	function butForm(id){
		//bug修改 采用fm.handlercode获取，只是单个对象，没有length方法，不会走for loop clause
		//故而采用 document.getElementsByName获取数组
		var handlercode = document.getElementsByName("handlercode");
		var handlername = document.getElementsByName("handlername");
		var area = document.getElementsByName("area");
		var tel = document.getElementsByName("tel");
		for(var i=0;i<handlercode.length;i++){
			var userCode = handlercode[i].value;
			if(userDtoMap.get(userCode)){
				alert(userDtoMap.get(userCode)+"已经添加作业区域。");
				return false;
			}
			for(var x=0;x<handlername.length;x++){
				if(handlercode[i] != handlercode[x]){
					if(handlercode[i].value == handlercode[x].value){
						//handlercode[i].focus();
						alert("作业区域中相同人不允许添加!");
						return false;
					}
				}
			}
			if(handlercode[i].value == ""){
				alert("工号不能为空");
				//handlercode[i].focus();
				return false;
			}
			if(handlername[i].value == ""){
				alert("查勘员不能为空");
				//handlername[i].focus();
				return false;
			}
			if(area[i].value == ""){
				alert(handlername[i].value+"的作业区域不能为空");
				return false;
			}
			if(tel[i].value == ""){
				alert("手机号码不能为空");
				//tel[i].focus();
				return false;
			}
		}
		fm.submit();
		return true;
	}
	
	function areaListForm(){
		 fm.action="/claim/common/areaSetting/AreaSettingQueryEdit.jsp";
		 fm.submit();
 	}
 	
 	function setUser(obj){
 		if(userDtoMap.get(obj.value)){
			alert(userDtoMap.get(obj.value)+"已经添加作业区域。");
			return false;
		}
 	}
</script>
</html:html>