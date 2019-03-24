<%--
 *************************************************************************
 * ��������: LeftMenu.jsp
 * ������: ��߲˵�ҳ��
 * ���������: lixiang
 * �����������: 2004-06-14 
 ****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>
<%@ page import="com.sinosoft.claim.ui.control.action.UIPowerInterface"%>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@ page import="com.sinosoft.claim.util.BusinessRuleUtil"%>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%
    //modify by weishixin add start 20041112
	//ԭ�򣺼����˲���Ȩ��У��
	UserDto       userDto      = (UserDto)session.getAttribute("user");
    String        riskCode     = userDto.getRiskCode();
    String        comCode      = userDto.getComCode();
    if (riskCode==null) riskCode=BusinessRuleUtil.getOuterCode(request,"RISKCODE_DAA");	
	String        userCode     = userDto.getUserCode();  //�û�����
	String        checkCode    = "" ;//У�����
	String        taskCode     = "" ;//�õ��������
	UIPowerInterface uiPowerInterface= new UIPowerInterface();   //Ȩ��У��
	boolean       checkPower = false ;           //�Ƿ�ͨ��У��
	//modify by weishixin add end 20041112
%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
	<head>
		<app:css />

		<STYLE>v\:* {
			BEHAVIOR: url(#default#VML)
		    }
	    </STYLE>
		<%-- JavaScript�ű�--%>
		<script language="javaScript">
		
           function showMenu(elementId){
           		var obj = document.getElementById(elementId);
            	if (obj.style.display == "")
               		obj.style.display="none";
             	else
               		obj.style.display="";
           }
           function clickme() { parent.fraSet.cols = "134,*,0%";}
	   	   function relogon(){	
      			top.location="/claim/index.jsp";
	       }
		</script>
		<script language="JavaScript" type="text/javascript" src="/claim/common/js/leftMenu.js">
		</script>
	</head>
	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#EFF1Fe" height="100%">
			<tr>
				<td id="menuTreeTD" valign="top" bgcolor="#EFF1Fe">

<%
    //�Ƿ���Ȩ��
    checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
	taskCode      = AppConfig.get("sysconst.TASKCODE_LP"); 
	checkPower    = false;
	checkPower    = uiPowerInterface.checkPower(userCode,taskCode,checkCode,riskCode);
	if(checkPower){         
%>
		<%@include file="/common/pub/testMenu.jsp"%>

					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<!--����޸����빦�� 2005-08-27-->
						<tr>
							<td width="15%" height=25 align="center" valign="middle">
								<img src="/claim/images/cpArrowFunction.gif">
							</td>
							<td width="85%" class="menu1">
								<html:link page="/common/pub/UIUpdatePwd.jsp" target="fraInterface">
									<font color=000000> �޸�����</font>
								</html:link>
							</td>
						</tr>

						<tr>
							<td width="15%" height=25 align="center" valign="middle">
								<img src="/claim/images/cpArrowFunction.gif">
							</td>
							<td width="85%" class="menu1">
								<html:link page="/common/logout.jsp" target="_top">
									<font color=000000> ���µ�¼</font>
								</html:link>
							</td>
						</tr>

					</table>
				</td>
				<td width="3" background="/claim/images/menuVerticalLine.gif">
					<input type="hidden" id="checkedId" name="checkedId" title="122" value="1">
					<input type="hidden" id="checkedName" name="checkedName" value="">
				</td>
			</tr>
	<%}%>
		</table>
	</body>
</html>
