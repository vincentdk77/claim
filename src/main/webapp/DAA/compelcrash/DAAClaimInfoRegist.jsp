<%--
****************************************************************************
* DESC       ：立案登记录入/修改页面(非车险)
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-14
* MODIFYLIST ：   Name       Date            Reason/Contents
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
  <!--对title处理-->
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
						甲方信息
						<BR>
					</TD>
					
					<TABLE class="common" id="spanJiaExt" style="display:none">
						<TR>
							<TD class="title" >
								姓名:
						   <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" name="JiaName" class="input"  description="姓名"
								 value="<bean:write name='aCiClaimCompelcrashDto' property='driverName' />" >
							</TD>
							<TD class="title"  >
								身份证号码:
						  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input" >
								<INPUT type="text" name="jiaSelfCode" class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='idNo'/>"
									description="身份证号码" >
							</TD>
						</TR>
						<TR>
							<TD class="title">
								车牌号:
								 <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" name="jiaCarCode" class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='carNo'/>"
									description="车牌号" >
							</TD>
							<TD class="title">
								号牌种类:
								  <img src="/claim/images/bgMarkMustInput.jpg">
								<INPUT type="text" name="jiaCarCodeKind" class="input" style="width:50%" value="<bean:write name='aCiClaimCompelcrashDto' property='carKind' />"
									description="号牌种类" >
							</TD>
							<TD class="title">
								车型:
                <img src="/claim/images/bgMarkMustInput.jpg">
								<INPUT type="text" style="width:50%" name="jiaCarKind" class="input" 
								description="车型" 
								value="<bean:write name='aCiClaimCompelcrashDto' property='carKind' />">
							</TD>
						<TR>

							<TD class="title">
								联系电话:
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" class="input" name="JiaAllPhone" 
								description="联系电话" 
								value="<bean:write name='aCiClaimCompelcrashDto' property='telNo' />">
							</TD>

							<TD class="title">
								保险公司:
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
 
     	<TD class="input">
   	    <input type=text class="codecode" name="jiaInsureCOM"  
		    value="<bean:write name='aCiClaimCompelcrashDto' property='comCode' filter='true'/>"
           ondblclick="code_CodeSelect(this, 'CompanyCode');"
                    onkeyup= "code_CodeSelect(this, 'CompanyCode','1','always','none','post');"
                    onblur= "code_CodeChange(this, 'CompanyCode','1','always','none','post');"
                    onchange=""
                   	description="保险公司" >
       <input type=text class=readonly readonly name=jiaInsureCOMName  value="<bean:write name='aCiClaimCompelcrashDto' property='comCode' filter='true'/>">
     </td>
						</TR>
						<TR>
							<TD class="title">
								保单号：
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" class="input" name="jiaInsureCode" 
								description="保单号"
								value="<bean:write name='aCiClaimCompelcrashDto' property='policyNo' />">
							</TD>
							<TD class="title">
								报案号:
								  <img src="/claim/images/bgMarkMustInput.jpg">
							</TD>
							<TD class="input">
								<INPUT type="text" class="input" name="jiaReportCode" 
								description="报案号"
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
						乙方信息
						<BR>
					</TD>
				</TR>
				<table class="common" width="100%"  id="spanYiExt"  style="display:none">
					<TR>
						<TD class="title">
							姓名:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" name="yiName" class="input" 
							description="姓名"
							value="<bean:write name='bCiClaimCompelcrashDto' property='driverName' />">
						</TD>
						<TD class="title"  >
							身份证号码:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" name="yiSelfCode" class="input" 
							description="身份证号码"
							value="<bean:write name='bCiClaimCompelcrashDto' property='idNo' />">
						</TD>
					</TR>
					<TR>
						<TD class="title">
							车牌号:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" name="yiCarCode" class="input" 
							description="车牌号"
							value="<bean:write name='bCiClaimCompelcrashDto' property='carNo' />">
						</TD>
						<TD class="title">
							号牌种类:
							  <img src="/claim/images/bgMarkMustInput.jpg">
							<INPUT type="text" name="yiCarCodeKind" 
									description="号牌种类"
							class="input" style="width:50%" value="<bean:write name='bCiClaimCompelcrashDto' property='carKind' />">
						</TD>

						<TD class="title">
							车型:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						<INPUT type="text" style="width:50%" name="yiCarKind" class="input" 
								description="车型"
								 value="<bean:write name='bCiClaimCompelcrashDto' property='carKind' />">
						</TD>
					</TR>
					<TR>

						<TD class="title">
							联系电话:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT class="input" name="yiAllPhone" 
								description="联系电话"
							value="<bean:write name='bCiClaimCompelcrashDto' property='telNo' />">
						</TD>

						<TD class="title">
							保险公司:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
     	<TD class="input">
  		    <input type=text class="codecode" name="yiInsureCOM"  
		    value="<bean:write name='bCiClaimCompelcrashDto' property='comCode' filter='true'/>"
           ondblclick="code_CodeSelect(this, 'CompanyCode');"
                    onkeyup= "code_CodeSelect(this, 'CompanyCode','1','always','none','post');"
                    onblur= "code_CodeChange(this, 'CompanyCode','1','always','none','post');"
                    onchange=""
                    	description="保险公司">
         <input type=text class=readonly readonly name=yiInsureCOMName value="<bean:write name='bCiClaimCompelcrashDto' property='comCode' filter='true'/>" >
     </td>
		</TR>
					<TR>
						<TD class="title">
							保单号：
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" class="input" name="yiInsureCode" 
								description="保单号"
							value="<bean:write name='bCiClaimCompelcrashDto' property='policyNo' />">
						</TD>
						<TD class="title">
							报案号:
							  <img src="/claim/images/bgMarkMustInput.jpg">
						</TD>
						<TD class="input">
							<INPUT type="text" class="input" name="yiReportCode" 
							description="报案号"
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
						甲方碰撞损坏部位： <TEXTAREA name="jiaLossPart" rows="5"><bean:write name='aCiClaimCompelcrashDto' property='damagePart' /></TEXTAREA>
					</TD>
					<TD class="title" style="width:20%"></TD> 
 
					<TD class="title" style="width:40%"  >
						  <img src="/claim/images/bgMarkMustInput.jpg">
					 乙方碰撞损坏部位： <TEXTAREA name="yiLossPart" rows="5"><bean:write name='bCiClaimCompelcrashDto' property='damagePart' /></TEXTAREA>
					</TD>

				</TR>
			</TABLE>
			<table class="common" width="100%">
				<TR>
					<td class="common" colspan="4" style="text-align:left;">

						<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="jiaExtImg" onclick="showPage(this,spanOtherExt)">
						其他信息
						<BR>
					</TD>
					<TABLE class="common" id="spanOtherExt" width="100%" style="display:none">

				<TR>
					<TD class="title" >
						过错方:
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</td><td>
					<select name="faultSide" class=input value="<bean:write name='aCiClaimCompelcrashDto' property='faultParty' />"
							description="过错方">
				  <logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="">
						<option value="">请选择</option>
					</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="1">
						<option value="1">甲方过错</option>
							</logic:equal>
						 <logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="2">
						<option value="2">乙方过错</option>
							</logic:equal>
						<logic:equal name="aCiClaimCompelcrashDto" property="faultParty" value="3">
						<option value="3">双方共同过错</option>
						</logic:equal>
		      	<logic:equal name="aCiClaimCompelcrashDto" property="accidentNo" value="" >
											<option value="1">甲方过错</option>
											<option value="2">乙方过错</option>
											<option value="3">双方共同过错</option>
					  </logic:equal>
					</select>
					</TD>
					<TD class="title">
						一方当事人过错行为：
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</TD>
					<TD class="input">
				<select name="faultAction" class=input description="一方当事人过错行为"
					value="<bean:write name='aCiClaimCompelcrashDto' property='faultBehavior' />">
						<logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="">
						<option value="">请选择</option>
							</logic:equal>
					  <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="1">
						<option value="1">追尾前车</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="2">
						<option value="2">逆向行驶与他车碰撞</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="3">
						<option value="3">违反停车让行标志</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="4">
						<option value="4">违反交通信号灯指示</option>
							</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="5">
						<option value="5">变道与他车发生碰撞</option>
				  	</logic:equal>
					 <logic:equal name="aCiClaimCompelcrashDto" property="faultBehavior" value="6">
						<option value="6">溜车或倒车与他车碰撞</option>
							</logic:equal>
					<logic:equal name="aCiClaimCompelcrashDto" property="accidentNo" value="" >
							<option value="1">追尾前车</option>
							<option value="2">逆向行驶与他车碰撞</option>
						  <option value="3">违反停车让行标志</option>
						  <option value="4">违反交通信号灯指示</option>
						  <option value="5">变道与他车发生碰撞</option>
						  <option value="6">溜车或倒车与他车碰撞</option>
							</logic:equal>
					</select>
					
					</TD>
				</TR>
				<TR>
					<TD class="title">
						发生时间：
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</TD>
					<TD class="input" width="40%">
						<INPUT type="text" name="time" class="input"  description="发生时间"
						value="<bean:write name='aCiClaimCompelcrashDto' property='damageDate' />"
							onblur="return checkTime(this)">
							YYYYMMDDHHMM
					</TD>
					<TD class="title">
						发生地点：
						  <img src="/claim/images/bgMarkMustInput.jpg">
					</TD>
					<TD class="input" width="40%">
						<INPUT type="text" name="address"   description="发生地点"
						class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='damageAddress' />">
					</TD>
				</TR>
				<TR>
					<TD class="title" width="40%">
				 报案时间 
				   <img src="/claim/images/bgMarkMustInput.jpg">
				</td>
				<td class=input width="30%"> 
						<INPUT type="text" name="registTime"   description="报案时间"
						width="40%" class="input" value="<bean:write name='aCiClaimCompelcrashDto' property='reportDate' />"
							onblur="return checkTime(this)">
							YYYYMMDDHHMM
					</TD>
					<TD class="title" width="40%">
						申请定损时间：
						  <img src="/claim/images/bgMarkMustInput.jpg">
						<INPUT type="text" name="lossApplyTime" class="input"    description="申请定损时间"
						style="width:100%" value="<bean:write name='aCiClaimCompelcrashDto' property='applyCertainTime' />"
							onblur="return checkTime(this)">
					YYYYMMDDHHMM
					</TD>
					<TD class="input" width="40%">
						定制起始时间：
						  <img src="/claim/images/bgMarkMustInput.jpg">
						<INPUT type="text" name="lossStartTime" class="input" description="定制起始时间"
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
						<input type="submit" name="recodeSM" class="bigbutton"  value="上传平台" colspan="2" align="center" onclick="return saveAccidentInfo(this,'upload');" >
					</TD>
					<TD>
					</TD>
					<TD>
						<input type="button" name="stopSM" value="暂存" class="bigbutton"  onclick=" return saveAccidentInfo(this,'save');" >
					</TD>
					<TD>
						<INPUT type="button" name="cancleSM" value="取消" class="bigbutton" />

					</TD>
				</TR>

			</table>
		</form>
	</body>
</html:html>
