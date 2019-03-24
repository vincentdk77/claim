<%--
****************************************************************************
* DESC       ������������ҳ��
* AUTHOR     ��chengyupeng
* CREATEDATE ��2011-11-23
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
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<%-- ҳ����ʽ  --%>
	<script src="/claim/common/areaSetting/js/AreaSettingEdit.js"></script>
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/js/showpage.js"> </script>
	<script src="/claim/common/js/layer.js"></script>
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
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
	<!--  ��ҳǩ-->
	<div class="tab">
		<!--ҳǩͷ-->
		<div class="formtitle">��Ա��Ϣ</div>

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
	<!-- ���������޸�ʱ������ɾ�������ϼ�¼ begin -->
	<input type="hidden" name="prplareasettingDtoHandledept" id="prplareasettingDtoHandledept" value="${prplareasettingDtoHandledept}">
	<input type="hidden" name="prplareasettingDtoHandlercode" id="prplareasettingDtoHandlercode" value="${prplareasettingDtoHandlercode}">
	<input type="hidden" name="prplareasettingDtoClassCode" id="prplareasettingDtoClassCode" value="${prplareasettingDtoClassCode}">
	<!-- ���������޸�ʱ������ɾ�������ϼ�¼ end -->
	<!-- �ɲ� bigen -->
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
			<input type="button" id="backButton" class="button" value="ȷ��" onclick="setArea()">
			<input type="button" id="backButton" class="button" value="����" onclick="closeMsg()">
		</div>
	</div>
	<!-- �ɲ� end -->
	
	
	<div id="outcontainer" name="submitDiv" class="textc">
		<div id=content_basic>
			<table align="center" id="buttonTable">
				<tr>
					<td>
						<input type="button" id="backButton" class="button" value="����" onclick="butForm('4');">
						<input type="button" id="backButton" class="button" value="����" onclick="areaListForm()">
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
		//bug�޸� ����fm.handlercode��ȡ��ֻ�ǵ�������û��length������������for loop clause
		//�ʶ����� document.getElementsByName��ȡ����
		var handlercode = document.getElementsByName("handlercode");
		var handlername = document.getElementsByName("handlername");
		var area = document.getElementsByName("area");
		var tel = document.getElementsByName("tel");
		for(var i=0;i<handlercode.length;i++){
			var userCode = handlercode[i].value;
			if(userDtoMap.get(userCode)){
				alert(userDtoMap.get(userCode)+"�Ѿ������ҵ����");
				return false;
			}
			for(var x=0;x<handlername.length;x++){
				if(handlercode[i] != handlercode[x]){
					if(handlercode[i].value == handlercode[x].value){
						//handlercode[i].focus();
						alert("��ҵ��������ͬ�˲��������!");
						return false;
					}
				}
			}
			if(handlercode[i].value == ""){
				alert("���Ų���Ϊ��");
				//handlercode[i].focus();
				return false;
			}
			if(handlername[i].value == ""){
				alert("�鿱Ա����Ϊ��");
				//handlername[i].focus();
				return false;
			}
			if(area[i].value == ""){
				alert(handlername[i].value+"����ҵ������Ϊ��");
				return false;
			}
			if(tel[i].value == ""){
				alert("�ֻ����벻��Ϊ��");
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
			alert(userDtoMap.get(obj.value)+"�Ѿ������ҵ����");
			return false;
		}
 	}
</script>
</html:html>