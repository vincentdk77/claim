<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��(�ǳ���)
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>
<%@ page import=" com.sinosoft.claimciplatform.dto.custom.*" %>
<%@ page import=" com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto" %>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";

		%>

<html:html locale="true">
  <!--��title����-->
  <title></title>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="/claim/DAA/compelcrash/js/CompelCrash.js"></script>
 	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
	<% 
	String nodeType=(String)request.getAttribute("nodeType");
	String saveType=(String)request.getAttribute("saveType");
	if(nodeType!=null && nodeType.equals("query")){
	%>
	<body onload="readonlyAllInput();disabledAllButton('buttonSave');">
	<% }else{ %>
	<body>
	<% } %>
	<form name="fm" method="post" action="/claim/compelCrashImportInfoUpload.do" onsubmit="">
			<table class="common" width="100%" id="JiaInfo">
				<input type="hidden" name="editType">
				<input type="hidden" name="saveType" value="<%=saveType%>">
			<TR>
					<td class="common" colspan="4" style="text-align:left;">

						<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="jiaExtImg" onclick="showPage(this,spanJiaExt)">
						�׷���Ϣ
						<BR>
					</TD>
					
					<TABLE class="common" id="spanJiaExt" style="display:none">
						<TR>
							<TD class="title" >
								����:
						   <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" name="JiaName" class="input"  description="����"
								 value="<bean:write name='aCiClaimCompelcrashDto' property='driverName' />" >
							</TD>
							<TD class="title"  >
								���֤����:
						  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input" >
								<INPUT type="text" name="jiaSelfCode" class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='idNo'/>"
									description="���֤����" >
							</TD>
						</TR>
						<TR>
							<TD class="title">
								���ƺ�:
								 <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" name="jiaCarCode" class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='carNo'/>"
									description="���ƺ�" >
							</TD>
							<TD class="title">
								��������:
								  <img src="/claim/images/bgMarkMustInput.jpg">
								<INPUT type="text" name="jiaCarCodeKind" class="input" style="width:50%" value="<bean:write name='aCiClaimCompelcrashDto' property='carKind' />"
									description="��������" >
							</TD>
							<TD class="title">
								����:
                <img src="/claim/images/bgMarkMustInput.jpg">
								<INPUT type="text" style="width:50%" name="jiaCarKind" class="input" 
								description="����" 
								value="<bean:write name='aCiClaimCompelcrashDto' property='carKind' />">
							</TD>
						<TR>

							<TD class="title">
								��ϵ�绰:
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" class="input" name="JiaAllPhone" 
								description="��ϵ�绰" 
								value="<bean:write name='aCiClaimCompelcrashDto' property='telNo' />">
							</TD>

							<TD class="title">
								���չ�˾:
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
 
     	<TD class="input">
   	    <input type=text class="codecode" name="jiaInsureCOM"  
		    value="<bean:write name='aCiClaimCompelcrashDto' property='comCode' filter='true'/>"
           ondblclick="code_CodeSelect(this, 'CompanyCode');"
                    onkeyup= "code_CodeSelect(this, 'CompanyCode','1','always','none','post');"
                    onblur= "code_CodeChange(this, 'CompanyCode','1','always','none','post');"
                    onchange=""
                   	description="���չ�˾" >
       <input type=text class=readonly readonly name=jiaInsureCOMName  value="<bean:write name='aCiClaimCompelcrashDto' property='comCode' filter='true'/>">
     </td>
						</TR>
						<TR>
							<TD class="title">
								�����ţ�
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" class="input" name="jiaInsureCode" 
								description="������"
								value="<bean:write name='aCiClaimCompelcrashDto' property='policyNo' />">
							</TD>
							<TD class="title">
								������:
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" class="input" name="jiaReportCode" 
								description="������"
								value="<bean:write name='aCiClaimCompelcrashDto' property='registNo' />">
							</TD>
						</TR>
					</TABLE>
			
				</TR>
			</TABLE>
			<table class="common" width="100%" id="YiInfo">
				<TR>
					<td class="common" colspan="4" style="text-align:left;">
						<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="yiExtImg" onclick="showPage(this,spanYiExt)">
						�ҷ���Ϣ
						<BR>
					</TD>
				</TR>
				<table class="common" width="100%"  id="spanYiExt"  style="display:none">
					<TR>
						<TD class="title">
							����:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" name="yiName" class="input" 
							description="����"
							value="<bean:write name='bCiClaimCompelcrashDto' property='driverName' />">
						</TD>
						<TD class="title"  >
							���֤����:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" name="yiSelfCode" class="input" 
							description="���֤����"
							value="<bean:write name='bCiClaimCompelcrashDto' property='idNo' />">
						</TD>
					</TR>
					<TR>
						<TD class="title">
							���ƺ�:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" name="yiCarCode" class="input" 
							description="���ƺ�"
							value="<bean:write name='bCiClaimCompelcrashDto' property='carNo' />">
						</TD>
						<TD class="title">
							��������:
							  <img src="/claim/images/bgMarkMustInput.jpg">
							<INPUT type="text" name="yiCarCodeKind" 
									description="��������"
							class="input" style="width:50%" value="<bean:write name='bCiClaimCompelcrashDto' property='carKind' />">
						</TD>

						<TD class="title">
							����:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						<INPUT type="text" style="width:50%" name="yiCarKind" class="input" 
								description="����"
								 value="<bean:write name='bCiClaimCompelcrashDto' property='carKind' />">
						</TD>
					</TR>
					<TR>

						<TD class="title">
							��ϵ�绰:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT class="input" name="yiAllPhone" 
								description="��ϵ�绰"
							value="<bean:write name='bCiClaimCompelcrashDto' property='telNo' />">
						</TD>

						<TD class="title">
							���չ�˾:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
     	<TD class="input">
  		    <input type=text class="codecode" name="yiInsureCOM"  
		    value="<bean:write name='bCiClaimCompelcrashDto' property='comCode' filter='true'/>"
           ondblclick="code_CodeSelect(this, 'CompanyCode');"
                    onkeyup= "code_CodeSelect(this, 'CompanyCode','1','always','none','post');"
                    onblur= "code_CodeChange(this, 'CompanyCode','1','always','none','post');"
                    onchange=""
                    	description="���չ�˾">
         <input type=text class=readonly readonly name=yiInsureCOMName value="<bean:write name='bCiClaimCompelcrashDto' property='comCode' filter='true'/>" >
     </td>
		</TR>
					<TR>
						<TD class="title">
							�����ţ�
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" class="input" name="yiInsureCode" 
								description="������"
							value="<bean:write name='bCiClaimCompelcrashDto' property='policyNo' />">
						</TD>
						<TD class="title">
							������:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" class="input" name="yiReportCode" 
							description="������"
							value="<bean:write name='bCiClaimCompelcrashDto' property='registNo' />">
						</TD>
					</TR>
				</table>
			 </TR>
			
			</TABLE>
			<TABLE width="100%" id="CommonInfo">
				<TR>
					<TD class="title" style="width:40%"  >
						  <img src="/claim/images/bgMarkMustInput.jpg">
						�׷���ײ�𻵲�λ�� <TEXTAREA name="jiaLossPart" rows="5"><bean:write name='aCiClaimCompelcrashDto' property='damagePart' /></TEXTAREA>
					</TD>
					<TD class="title" style="width:20%"></TD> 
 
					<TD class="title" style="width:40%"  >
						  <img src="/claim/images/bgMarkMustInput.jpg">
					 �ҷ���ײ�𻵲�λ�� <TEXTAREA name="yiLossPart" rows="5"><bean:write name='bCiClaimCompelcrashDto' property='damagePart' /></TEXTAREA>
					</TD>

				</TR>
			</TABLE>
			<table class="common" width="100%">
				<TR>
					<td class="common" colspan="4" style="text-align:left;">

						<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="jiaExtImg" onclick="showPage(this,spanOtherExt)">
						������Ϣ
						<BR>
					</TD>
					<TABLE class="common" id="spanOtherExt" width="100%" style="display:none">

				<TR>
					<TD class="title" >
						����:
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</td><td>
					<select name="faultSide" class=input value="<bean:write name='aCiClaimCompelcrashDto' property='faultParty' />"
							description="����">
				  <logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="">
						<option value="">��ѡ��</option>
					</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="1">
						<option value="1">�׷�����</option>
							</logic:equal>
						 <logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="2">
						<option value="2">�ҷ�����</option>
							</logic:equal>
						<logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="3">
						<option value="3">˫����ͬ����</option>
						</logic:equal>
		      	<logic:equal name="aCiClaimCompelcrashDto" property="accidentNo" value="" >
											<option value="1">�׷�����</option>
											<option value="2">�ҷ�����</option>
											<option value="3">˫����ͬ����</option>
					  </logic:equal>
					</select>
					</TD>
					<TD class="title">
						һ�������˹�����Ϊ��
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</TD>
					<TD class="input">
				<select name="faultAction" class=input description="һ�������˹�����Ϊ"
					value="<bean:write name='aCiClaimCompelcrashDto' property='faultBehavior' />">
						<logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="">
						<option value="">��ѡ��</option>
							</logic:equal>
					  <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="1">
						<option value="1">׷βǰ��</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="2">
						<option value="2">������ʻ��������ײ</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="3">
						<option value="3">Υ��ͣ�����б�־</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="4">
						<option value="4">Υ����ͨ�źŵ�ָʾ</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="5">
						<option value="5">���������������ײ</option>
				  	</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="6">
						<option value="6">�ﳵ�򵹳���������ײ</option>
							</logic:equal>
					<logic:equal name="aCiClaimCompelcrashDto" property="accidentNo" value="" >
							<option value="1">׷βǰ��</option>
							<option value="2">������ʻ��������ײ</option>
						  <option value="3">Υ��ͣ�����б�־</option>
						  <option value="4">Υ����ͨ�źŵ�ָʾ</option>
						  <option value="5">���������������ײ</option>
						  <option value="6">�ﳵ�򵹳���������ײ</option>
							</logic:equal>
					</select>
					
					</TD>
				</TR>
				<TR>
					<TD class="title">
						����ʱ�䣺
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</TD>
					<TD class="input" width="40%">
						<INPUT type="text" name="time" class="input"  description="����ʱ��"
						value="<bean:write name='aCiClaimCompelcrashDto' property='damageDate' />"
							onblur="return checkTime(this)">
							YYYYMMDDHHMM
					</TD>
					<TD class="title">
						�����ص㣺
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</TD>
					<TD class="input" width="40%">
						<INPUT type="text" name="address"   description="�����ص�"
						class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='damageAddress' />">
					</TD>
				</TR>
				<TR>
					<TD class="title" width="40%">
				 ����ʱ�� 
				   <img src="/claim/images/bgMarkMustInput.jpg">
				</td>
				<td class=input width="30%"> 
						<INPUT type="text" name="registTime"   description="����ʱ��"
						width="40%" class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='reportDate' />"
							onblur="return checkTime(this)">
							YYYYMMDDHHMM
					</TD>
					<TD class="title" width="40%">
						���붨��ʱ�䣺
						  <img src="/claim/images/bgMarkMustInput.jpg">
						<INPUT type="text" name="lossApplyTime" class="input"    description="���붨��ʱ��"
						style="width:100%" value="<bean:write name='aCiClaimCompelcrashDto' property='applyCertainTime' />"
							onblur="return checkTime(this)">
					YYYYMMDDHHMM
					</TD>
					<TD class="input" width="40%">
						������ʼʱ�䣺
						  <img src="/claim/images/bgMarkMustInput.jpg">
						<INPUT type="text" name="lossStartTime" class="input" description="������ʼʱ��"
						 style="width:100%" value="<bean:write name='aCiClaimCompelcrashDto' property='certainStartTime' />"
							onblur="return checkTime(this)">
					YYYYMMDDHHMM
					</TD>
				</TR>
				</TABLE></TR>
				
			</TABLE>
				<TABLE width="100%" id="buttonSave">
				<TR>
					<TD>
						<input type="submit" name="recodeSM" class="bigbutton"  value="�ϴ�ƽ̨" colspan="2" align="center" onclick="return saveAccidentInfo(this,'upload');" >
					</TD>
					<TD>
					</TD>
					<TD>
						<input type="button" name="stopSM" value="�ݴ�" class="bigbutton"  onclick=" return saveAccidentInfo(this,'save');" >
					</TD>
					<TD>
						<INPUT type="button" name="cancleSM" value="ȡ��" class="bigbutton" />

					</TD>
				</TR>

			</table>
		</form>
	</body>
</html:html>
