<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAAVerifyLossRepairComponentEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    String editType=request.getParameter("editType");
    String nodeType=request.getParameter("nodeType");
    String swflogflowId = request.getParameter("swfLogFlowID");
    if(null==swflogflowId){
  	  swflogflowId = (String)request.getAttribute("swfLogFlowID");
    }
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
    if(userDto == null){
        isShowButton = false;
    }
    if (editType.equals("SHOW")) {
%>
    <body class="interface" onload="initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else {
    if (nodeType.equals("backc")) {
%>
  <body class="interface" onload="initSet();initReadonly();">
<%
    }else{
%>
  <body class="interface" onload="initSet();">
<%
    }
  }
%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
 <input type="hidden" name="nodeType" value="<%=nodeType%>">
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>
    <%if(isShowButton){ %>
      <td class=button ><input type="button" class =bigbutton name="message" class=button value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'verif',fm.prpLverifyLossClaimNo.value,'registNo',fm.RegistNo.value);"></td>
    <%} %> 
      <td class=button ><input type="button" class =bigbutton name="eCertify" class=bigbutton value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','verif')"></td>
     <%--
      <td><input type="button" name="message" value="��������" onclick="openWinSave()"></td>
      <td><input type="button" name="messageView" value="�鿴����" onclick="openWinQuery()"></td>
      <td><input type="button" name="eCertify" value="���ӵ�֤" onClick="openCertify('<bean:write name='prpLcheckDtoTemp' property='registNo'/>')"></td>
      --%>
       <!-- Modify By wangli add end 20050328-->
       <td><input type="button" class =bigbutton name="buttonCertifyDirect" class=bigbutton value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLregistDto' property='registNo'/>','verif')"></td>
	   <td><input type="button" class="bigbutton" name="buttonswfFlow" value="���̲�ѯ" onClick="doswfFlowQuery('<%=swflogflowId%>')"></td>
    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
      int repairFeeNo = 0;
      int componentNo = 0;
    %>
      <%-- ��������Ļ��� --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
    <%-- 1.���𻷽ڹ��̵�����/�����嵥ҳ�� --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossRepairComponentEdit.jsp"%>
    <%-- ���Ǻ����ʱ����ʾ��ע,������� --%>
   <%-- 3. �˼ۡ������������ע --%>
        <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
      
      <%-- 4. ��������Ϣ����˵�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>

      <%-- ���Ǻ����ʱ����ʾ��ע,������� --%>
  <table cellpadding="5" cellspacing="1" class="common" >
        <%-- 4.������Ϣ����˵�� --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
  </table>
  
      <%-- ����ͨ�ð�ť --%>
            <%if (editType.equals("SHOW")){%>
        <table cellpadding="5" cellspacing="1" class=common  id="buttonArea">
	 		<tr><%-- ֻ��ʾ���ذ�ť--%>
				<td>
	        <input  type="hidden" name=buttonSaveType value="1"> 
		    </td>
			</tr>  
  		<tr>  
     	 	<td class=button style="width:33%" align="center">
			  <!--ȡ����ť-->
			    <input type=button name=buttonBack class='button' value="����" onclick="javascript:history.go(-1);" >
			  </td> 
			</tr>
		</table>  
	<%
	  }else{
	%> 
      <%@include file="/DAA/verifyLoss/DAAVerifyLossSave.jsp"%>
   <%
  	}
   %>
      <!--modified by wangli add start 20050329-->
      <%-- ��ӡ�����嵥����ʧȷ���� �����鶨�𱨸� --%>
     <%//@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"%>
      <!--modified by wangli add end 20050329-->
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
