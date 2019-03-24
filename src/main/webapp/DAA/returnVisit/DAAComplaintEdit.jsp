<%--
****************************************************************************
* DESC       ��Ͷ�߻ط�
* AUTHOR     ��zhangxuepeng
* CREATEDATE ��2011-12-28
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<html>
	<head>
		<title>�طù���</title>
		<%-- ҳ����ʽ  --%>
		<link rel="stylesheet" type="text/css"
			href="/claim/css/StandardCar.css">
		<link href="/claim/css/Toolbar.css" rel="stylesheet" type="text/css" />
		<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
		<link href="/claim/css/tableType.css" rel="stylesheet" type="text/css">
		<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
		<script type="text/javascript" src="/claim/js/Toolbar.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</head>

	<body>
		<form name=fm action="/claim/complaintSaveEdit.do" method="post"
			onsubmit="return validateForm(this,'Driver','');">
			<!--  ��ҳǩ-->
			<div class="tab">
				<!--ҳǩͷ-->
				<div class="tab_menu">
					<ul>
						<li class="selected">
							Ͷ����Ϣ
							<input type="hidden" name="nodeTypes" id="nodeTypes" value="${nodeTypes}">
							<input type="hidden" name="prplreturnvisitswflogDtoNodeType" id="prplreturnvisitswflogDtoNodeType" value="${nodeType}">
						</li>
					</ul>
				</div>

				<div class="tab_box">
					<div id="schedulMain">
						<%@include file="/DAA/returnVisit/DAAComplaintMessage.jsp"%>
						<c:if test="${prplcomplaintDto.whethertrack ne '2'}">
							<c:if test="${nodeTypes ne 'complaint'}">
								<c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">
									<%@include file="/DAA/returnVisit/DAAComplaintHandle.jsp"%>
								</c:if>
								<c:if test="${nodeTypes ne 'dealWith'}">
									<%@include file="/DAA/returnVisit/DAAComplaintShadow.jsp"%>
								</c:if>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
			<!-- ��ť -->
			<div id="outcontainer" name="submitDiv">
				<div id=content_basic>
					<table align="center" id="buttonTable">
						<tr>
							<td>
								<c:if test="${editType ne 'SHOW'}">
									<input type="button" id="backButton" class="bobu" value="����"
										onclick="saveForm('4');">
									<c:if test="${nodeTypes eq 'complaint'}">
										<input type="button" id="backButton" class="bobu" value="����"
										onclick="saveForm('5');">
									</c:if>
									<c:if test="${nodeTypes eq 'dealWith'}">
										<input type="button" id="backButton" class="bobu" value="����" onclick="saveForm('6');">
									</c:if>
									<c:if test="${nodeTypes eq 'compl'}">
										<input type="button" id="backButton" class="bobu" value="����" onclick="saveForm('3');">
									</c:if>
								</c:if>
								<c:if test="${editType eq 'SHOW'}">
									<input type="button" id="backButton" class="bobu" value="����" onclick="saveForm('2');">
								</c:if>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</body>
	<script>  

   //�Ƿ�
		function radioBut(obj){
			if(obj.value == '1'){
				trackingValue.disabled='disabled';
			    document.getElementById('tracking').value='';
			   
				}else{
			    trackingValue.disabled='';
			}
						var varlidComplaintTdObj = $(obj).parent().find("input");
						for(var i=0;i<varlidComplaintTdObj.length;i++){
							if(varlidComplaintTdObj[i].name == 'varlidComplaint'){
								varlidComplaintTdObj[i].value = obj.value;
							}
						}
			
				}
		function trackingBut(obj,name){
			var objTd = $(obj).parent().find("input");
			for(var i=0;i<objTd.length;i++){
				if(objTd[i].name == name){
					objTd[i].value = obj.value;
				}
			}
			
		}
			//�������� JS
	function checkboxBut(obj){
		var inputObj = $(obj).parent().find("input");
		var inputvalue = "";
		inputObj.each(function(i){
			if(inputObj[i].name == 'existissueBox' && inputObj[i].checked == true){
				if(inputvalue == ""){
					inputvalue = inputObj[i].value;
				}else{
					inputvalue = inputvalue+";"+inputObj[i].value;
				}
			}
		});
		inputObj.each(function(i){
			if(inputObj[i].name == 'complaintcause'){
				inputObj[i].value = inputvalue;
			}
		});
	}
	function saveForm(id){
		if(id == '4'){
			var nodeTypes = document.getElementById('nodeTypes');
			if(nodeTypes.value == "complaint"){
				var cnameObj = $("input[cname]");
				for(var i=0;i<cnameObj.length;i++){
					var nameObj = cnameObj[i].name;
					var objValue = $("input[name="+nameObj+"]");
					if(objValue.val() == ""){
						alert(cnameObj[i].cname+"����Ϊ�գ�");
						return false;
					}
				}
			}
			if(nodeTypes.value == "dealWith"){
				var cnameObj = $("input[ccname]");
				for(var i=0;i<cnameObj.length;i++){
					var nameObj = cnameObj[i].name;
					var objValue = $("input[name="+nameObj+"]");
					if(objValue.val() == ""){
						alert(cnameObj[i].ccname+"����Ϊ�գ�");
						return false;
					}
				}
			}
			if(nodeTypes.value == "compl"){
				var cnameObj = $("input[tname]");
				for(var i=0;i<cnameObj.length;i++){
					var nameObj = cnameObj[i].name;
					var objValue = $("input[name="+nameObj+"]:last");
					if(objValue.val() == ""){
						alert(cnameObj[i].tname+"����Ϊ�գ�");
						return false;
					}
				}
				
				var visitsuccess = $("input[name=visitsuccess]:last").val();
				if(visitsuccess == '0'){
					var visitnocause = $("input[name=visitnocause]:last").val();
					if(visitnocause == ""){
						alert("���ɹ�ԭ����Ϊ�գ�");
						return false;
					}
				}
			}
			if(nodeTypes.value == 'compl'){
				fm.action = "/claim/returnVisitSaveEdit.do";
			}
			
			var cmaxObj = $("input[cmax]");
			for(var i=0;i<cmaxObj.length;i++){
				var naxName = cmaxObj[i].name;
				var objValue = $("input[name="+naxName+"]");
				for(var x=0;x<objValue.length;x++){
					if(cmaxObj[i] == objValue[x]){
						var valno = objValue[x].value;
						if(valno.length > parseInt(objValue[x].cmax)){
							alert(objValue[x].cname+"���Ȳ��ܴ���"+objValue[x].cmax+"!");
							return false;
						}
					}
				}
			}
		}
		if(id == '3'){
	
			fm.action = "/claim/complaintAddEdit.do?editType=SHOW";
		}
		if(id == '2'){
		
			fm.action = "/claim/returnVisitQueryEdit.do?editType=ADD";
		}
		if(id == '5'){
		
			fm.action = "/claim/returnVisitEdit.do?editType=SHOW";
		}
		if(id == '6'){
		
			fm.action = "/claim/returnVisitEdit.do?editType=dealWith";
		}
		fm.submit();
	}
	//��ѡ��ť������������������ֵ
	function selectBut(obj,inputName){
		var inputObj = $(obj).parent().find("input");
		inputObj.each(function(i){
			if(inputObj[i].name == inputName){
				inputObj[i].value = obj.value;
			}
		});
		if(inputName == 'visitsuccess'){
			if(obj.value == '1'){
				document.getElementById('visitsuccessState').value='1';
			}else{
				document.getElementById('visitsuccessState').value='0';
			}
		}
	}
	//�������ں��� ��ȡ���л���
		function open_CodeSelectWorkRove(field,codeType,treeTitle){
			var elements = fm.elements;	
			var index = 0;
			for(var i = 0;i < elements.length;i++){
				if(elements[i] == field){
					index = i; 
					break;
				}
			}
			
			var provinceCode = "";
			var strUrl = "/claim/common/workrove/CodeTree.jsp?";
			strUrl += "treeTitle=" + treeTitle;
			strUrl += "&codeType=" + codeType;
			
            var result = window.showModalDialog(strUrl,window,'DialogWidth=300px;DialogHeight=350px;help=no;status=no');
			if(typeof(result) != 'undefined' && result != null && result != ""){
				var temp = result.split("#");
				fm.elements[i - 1].value = temp[0];
				field.value = temp[1];
			}
		}	
		
		
		//�Ƿ�طóɹ� ���ɹ�ԭ�򲻿ɲ���
	function defeatedBut(obj){
		var inputObj = $(obj).parent().parent().find("input");
		var selectObj = $(obj).parent().parent().find("select");
		inputObj.each(function(i){
			if(obj.value == 1 && inputObj[i].name == 'visitnocause'){
				inputObj[i].value = "";
			}
		});
		selectObj.each(function(i){
			if(selectObj[i].name == 'visitnocauseSelect'){
				if(obj.value == '1'){
					selectObj[i].disabled="disabled";
					selectObj[i].value = '0';
					document.getElementById('visitsuccessState').value='1';
				}else{
					selectObj[i].disabled="";
					document.getElementById('visitsuccessState').value='0';
				}
			}
		});
		
	}
	function textareaValue(obj){
		var inputObj = $(obj).parent().find("input");
		inputObj[0].value = obj.innerHTML;
	}
	
	function setSeclectdValue(obj){
	
	}
</script>
</html>