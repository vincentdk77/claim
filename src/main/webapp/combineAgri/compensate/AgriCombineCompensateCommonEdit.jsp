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
  <script src="/claim/combineAgri/compensate/js/PropCompensateEdit.js">
  </script>
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
  String ComBineNo=request.getParameter("combineNo");
  String status=request.getParameter("status");
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
<body class="interface">
<%
  }else {
%>
<body class="interface">
<%
  }
%>
 
    <form name=fm action="/claim/CombinecompensateSave.do?isEnd=Y&status=<%=status%>&combineNo=<%=("0".equals(status)?request.getAttribute("comBineNo"):ComBineNo)%>" method="post" onsubmit="return validateForm(this);">
      <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">  
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
    <input type="hidden" name="combineUrl" value="<%=request.getAttribute("combineUrl")%>">
    <input type="hidden" name="riskType" value="<%= request.getAttribute("riskType") %>">
    <input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo") %>">
    <%-- 1.��������Ϣ --%>
         <%@include file="/combineAgri/compensate/AgriCombineCompensateMainHeadEdit.jsp" %>
    <%-- 2.�ر�Լ�� --%>
         <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 3.����������Ϣ --%>
        <%@include file="/combineAgri/compensate/AgriCombineCompensateMainTailEdit.jsp" %>
    <%-- 10.����ͨ�ð�ť --%>
        <%@include file="/combineAgri/compensate/AgriCombineCompensateSave.jsp"%>
     </form>
</body>
</html:html>