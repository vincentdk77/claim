<%--
****************************************************************************
* DESC       ��ʵ��¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*                chenrd      20070718        ũ���ŵ����������
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>

<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLclaimLoss"%>
<%@page import="com.sinosoft.prpall.schema.PrpLclaimLossSchema"%>
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLloss"%>
<%@page import="com.sinosoft.prpall.schema.PrpLlossSchema"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/compensate/js/PropCompensateEdit.js"></script>
  <script src="/claim/commonAgri/compensate/js/PropPersonLossEdit.js"></script>
  
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<%

  //modify by ww add begin 2005-11-15
  //reason: ��ֹ�ظ��ύ
  session.setAttribute("oldCompensateLastAccessedTime","");
  //modify by ww add end 2005-11-15
  
   String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  UserDto   user     = (UserDto)session.getAttribute("user");
  String riskCode = "";
  String editType=request.getParameter("editType");
  if(user==null||user.equals("")){
      riskCode = request.getParameter("riskCode");
  }else{
      riskCode = user.getRiskCode();
  }
  HashMap map = new HashMap();
  if("31".equals(riskCode.substring(0,2))){
  //������
  String  strClaimNo = request.getParameter("ClaimNo");
  String strCompensateCompensateNo = request.getParameter("prpLcompensateCompensateNo");
  BLPrpLloss loss1 = new BLPrpLloss();
  PrpLlossSchema schema1 = new PrpLlossSchema();
  BLPrpLclaimLoss loss = new BLPrpLclaimLoss();
  PrpLclaimLossSchema schema = new PrpLclaimLossSchema();
  
  if((strClaimNo == null) ||("".equals(strClaimNo))){
	  loss1.query(" compensateno = '"+strCompensateCompensateNo+"'");
  }else{
	  loss.query(" ClaimNo = '"+strClaimNo+"'");
  }
%>
 <script>
	var map = new Array();
	Array.prototype.get = function(key){
		for(var i = 0;i< this.length;i++){
			 var temp = this[i];
			 if(temp.kindCode == key){
				return temp.lossValue;
			}
		}
	}
  <%
  if((strClaimNo == null) ||("".equals(strClaimNo))){
    for(int i=0; i <loss1.getSize();i++ ){
	  String key   = "";
	  String value = "";
	  schema1 =loss1.getArr(i);
      key  = schema1.getKindCode();
      value = schema1.getSumLoss();
  %>    
  	var obj = Object();
	obj.kindCode  ="<%=key%>";
	obj.lossValue ="<%=value%>";
	map.push(obj);
  <%
    }
  }else{
	    for(int i=0; i <loss.getSize();i++ ){
	  	  String key   = "";
	  	  String value = "";
	  	  schema =loss.getArr(i);
	      key  = schema.getKindCode();
	      value = schema.getSumClaim();
	    %>    
	    var obj = Object();
	  	obj.kindCode  ="<%=key%>";
	  	obj.lossValue ="<%=value%>";
	  	map.push(obj);
	    <%
	      }  
  }
  }
%>
</script>
<%
//�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  }else {
%>
<body class="interface" onload="initPage();initSet();calFund();">
<%
  }
%>
 
    <form name=fm action="/claim/combinecompensatePrivateSave.do" method="post" onsubmit="return validateForm(this);">
      <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
    <input type="hidden" name="editType" value="<%=editType%>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
    <input type="hidden" name="riskType" value="<%= request.getAttribute("riskType") %>">
    <input type="hidden" name="combineNo" value="<%= request.getParameter("comBineNo") %>">
    <input type="hidden" name="riskCode" value="<%= request.getParameter("riskCode") %>">
    <input type="hidden" name="ClaimNo" value="<%= request.getParameter("ClaimNo") %>">
    <input type="hidden" name="caseType" value="<%= request.getParameter("caseType") %>">
    <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
    <input type="hidden" name="policyNo" value="<%= request.getParameter("policyNo") %>">
    <input type="hidden" name="earPolicyNo" value="<%= request.getParameter("policyNo") %>">
    <input type="hidden" name="status" value="<%= request.getParameter("status") %>">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
    <input type="hidden" name="businessNo" value="<%= request.getParameter("businessNo") %>">
    <input type="hidden" name="keyIn" value="<%= request.getParameter("keyIn") %>">
    <input type="hidden" name="modelNo" value="<%= request.getParameter("modelNo") %>">
    <input type="hidden" name="nodeNo" value="<%= request.getParameter("nodeNo") %>">
    <input type="hidden" name="dfFlag" value="<%= request.getParameter("dfFlag") %>">
    <input type="hidden" name="compeCount" value="<%= request.getParameter("compeCount") %>"> 
    <%-- 1.��������Ϣ --%>
        <%@include file="/combineAgri/compensate/AgriCombineCompensateMainHeadPrivateEdit.jsp" %>
    <%-- 3.�⸶�����Ϣ --%>
        <%@include file="/combineAgri/compensate/AgriCombineCompensateLlossEdit.jsp"%>
        <logic:equal name='prpLcompensateDto' property="riskCode" value="3220">
           <%@include file="/commonAgri/compensate/AgriCompensateEarNoEdit.jsp"%>
       </logic:equal>
    <%-- 4.������ --%>
        <%@include file="/commonAgri/compensate/AgriCompensateChargeEdit.jsp"%>
    <%-- 5.����β��Ϣ --%>
        <%@include file="/commonAgri/compensate/AgriCompensateMainTailEdit.jsp" %>
    <%-- 6.���㱨�� --%>
        <%@include file="/commonAgri/compensate/AgriEndCaseCompensateTextEdit.jsp"%>
    <%-- 7.��������� --%>
        <%@include file="/commonAgri/compensate/AgriCompensateTextEdit.jsp"%>
    <%-- 8.����˵�� --%>
        <%@include file="/common/compensate/CompensatePayTextEdit.jsp" %>
    <%-- 9.ָ��Σ�յ�λ��Ϣ --%>
       <%
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	    //�þɵ�Σ�յ�λ��Ϣҳ��	
	   %>
	      <%@include file="/common/claim/ClaimRiskUnit.jsp"%>
	   <%
	   }else{
		 //���µ�Σ�յ�λ��Ϣҳ��
	    %> 
	      <%@include file="/common/compensate/CompensateNewRiskUnit.jsp"%>
	    <%
	   }	    
	    %>
    <%-- 10.����ͨ�ð�ť --%>
        <%@include file="/combineAgri/compensate/AgriCombineCompensatePrivateSave.jsp"%>

     </form>
</body>
</html:html>