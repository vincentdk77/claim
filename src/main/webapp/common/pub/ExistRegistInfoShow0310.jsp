<%--
****************************************************************************
* DESC       ���ѳ�����Ϣ��ʾ���棨�ǳ��գ�
* AUTHOR     �� Sinosoft
* CREATEDATE �� 2005-09-26
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>

<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>

<html>
<head>
<title>�����α�����Ϣ��ʾ</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<SCRIPT LANGUAGE="JavaScript">
//��ť�����¼���������ͬ��������౨������ʾ

<!--
//modify by liujianbo modify 20050321 start
//reason:�ڱ����Ǽǻ����У��ѳ��մ��������γ����¹ʵ��嵥��,���Ե�������Ź�������ذ�����Ϣ  
/**
 *@description ��������������Ϣҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function showRegist(registNo){	       
	     
    var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="+registNo+"&editType=SHOW";	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   


//modify by liujianbo modify 20050321 end

//--> 
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0">
<form name="fm">
<table class="common" cellpadding="5" cellspacing="1">
	<tr>
		<td class="prompttitle">���</td>
		<td class="prompttitle">������</td>
		<td class="prompttitle">����ʱ��</td>
		<td class="prompttitle">���յص�</td>
		<td class="prompttitle">״̬</td>
	</tr>


	<!-- ������մ�����ϸ��Ϣ-->
	<%
		//String curRegistNo = (String)request.getAttribute("curRegistNo");

		//ԭ�򣺴�������Ϣ���д���������Ϣ
		ArrayList registClaimDtoList = (ArrayList) request
				.getAttribute("registClaimDtoList");

		if (registClaimDtoList != null) {
			for (int count = 0; count < registClaimDtoList.size(); count++) {
				RegistClaimInfoDto registClaimDto = (RegistClaimInfoDto) registClaimDtoList
				.get(count);
				System.out.println("fasdfjasdf");
				//���˱�����
				//if(registClaimDto.getRegistNo().equals(curRegistNo))
				//continue;

				int sequenceNo = count + 1;
	%>
	<tr>
		<td class="prompt"><%=sequenceNo%></td>
		<td class="prompt"><a
			href="javascript:showRegist('<%= registClaimDto.getRegistNo() %>')"><%=registClaimDto.getRegistNo()%></a>
		</td>
		<td class="prompt"><%=registClaimDto.getDamageStartDate()%></td>
		<td class="prompt"><%=registClaimDto.getDamageAreaName()%></td>
		<td class="prompt"><%=registClaimDto.getStatus()%></td>
	</tr>
	<%
		}
		}
	%>
	<tr>
		<td colspan=14 class="common" align="center"><input type=button
			name='button_Peril_Close_Context' class=button value='(O)�ر�'
			ACCESSKEY="O" onclick="window.close()"></td>
	</tr>
</table>
</form>
</body>
</html>