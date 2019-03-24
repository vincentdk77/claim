
<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade"%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>     
<html:html locale="true">
<head>
    <!--��title����-->
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossPropEdit.js"></script>
  <script>
  	javascript:window.history.forward(1);
  </script>
  <META http-equiv="Content-Type" content="text/html; charset=GB2312">
</head>

<%

   //start ��ֹ�ظ��ύ---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
   //end---------------------------------------------
   
    String editType=request.getParameter("editType");
    //String nodetype = request.getParameter("nodeType");
    String nodestatusForTemp = request.getParameter("status");
    PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)request.getAttribute("prpLverifyLossDto");
    String riskcodeorigin = prpLverifyLossDto.getRiskCode();
    
	//��89��ģ������� start==
	BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
    ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
    String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
    String riskcodeStr = "";//��89��ģ������ֵ��ַ���
    String[] classCodeArr = classCodeStr.split(",");
    String conditions = "";
    if(classCodeArr != null){
    	conditions += " classcode in('";
    	for(int i=0;i<classCodeArr.length;i++){
    		conditions += classCodeArr[i]+"',";
    	}
    	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
    	conditions += ")";
    	
    	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
    }
    if(prpDriskDtos != null && prpDriskDtos.size()>0){
    	for(int i=0;i<prpDriskDtos.size();i++){
    		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
    		riskcodeStr += prpDriskDto.getRiskCode()+";";
    	}
    }
    //��89��ģ�������  end===
    
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();setreadonlyforhouse();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else if (editType.equals("ADD")){
%>
    <body  onload="initPage();initSet();onload0310();onload0310cal();initForAdd();">
<%
    }
  else{
%>
      <body  onload="initPage();initSet();onload0310edit();onload0310cal();initForAdd();">
<%} %>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="riskcode" value="<bean:write name='prpLregistDto' property='riskCode'/>">
  <input type="hidden" name="policyno" value="<bean:write name='prpLregistDto' property='policyNo'/>">
  <input type="hidden" name="nodeType" value="propc">
  <input type="hidden" name="status" value="<%= nodestatusForTemp%>">
  <input type="hidden" name="riskcodeStr" value="<%= riskcodeStr%>">

        <table width="100%" class=common cellpadding="5" cellspacing="1">
          <tr>

            <td class="formtitle">����Ǽ�</td>

          </tr>
        </table>
    <table cellpadding="5" cellspacing="1" class=common>
    <tr>
 
    
     <td class=button >
	      <input type="button" name="message" class=bigbutton  value="���⹵ͨ" onclick="return openWinSaveQuery('<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.policyno.value,fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value,'registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />');">
	 </td>

     <td class=button >
             <input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','certa');">
           </td>
           
      
       </tr>
  </table>

    <%!
      int indexCertainLoss = 0;
      String flag = null;
    %>
    <%
      flag = request.getParameter("flag");
    %>

    <%-- 1��������Ļ��� --%>
      <%@include file="/commonProp/certainLoss/PropCertainLossMainEdit.jsp"%>
      
      <%if(riskcodeorigin != null && nodestatusForTemp != null && ("0310".equals(riskcodeorigin)||"0312".equals(riskcodeorigin) ) && "3".equals(nodestatusForTemp)){ %>
    <%-- 2 ������ԭ��ҳ�� --%>  
     <%@include file="/DAA/certainLoss/DAACertainLossOpinionForCertain.jsp"%>
     <%} %>
    <%-- 3.�Ʋ���ʧ�嵥ҳ�� --%>
            <%@include file="/commonProp/certainLoss/PropCertainLossPropEdit.jsp"%>
     <%if(riskcodeorigin != null  && riskcodeStr.indexOf(riskcodeorigin)>0 ){ %>  <!-- ����Ϊ01����ҵ�Ʋ������� -->
    <%-- 3. ��������� --%>  
     <%@include file="/commonProp/verifyLoss/PropVerifyLossOpinion.jsp"%>
     <%-- 4. ��������Ϣ����˵�� --%>
      <%@include file="/commonProp/verifyLoss/PropVerifyLossExtEdit.jsp"%>
     <%} %>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
      <%if(riskcodeorigin != null && ("0310".equals(riskcodeorigin)||"0312".equals(riskcodeorigin))){ %>
      
      <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
      
      <%} %>
    
    <%-- 4.����ͨ�ð�ť --%>
      <%@include file="/commonProp/certainLoss/PropCertainLossSave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>