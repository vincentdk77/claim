
<%--
****************************************************************************
* DESC       ���鿱�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-03
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
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.gyic.claim.dto.domain.PrplcombineDto"%> 
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �鿱�Ǽ�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/combineAgri/check/js/PropCheckEdit.js"></script>
  <script src="/claim/commAgri/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/combineAgri/check/js/DAACertainLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    int idxMain =0;
    int idxVerifyLoss =0;
    int idxProp =0;
    int idxEar =0;
    int idxTextEdit =0;
    String familySplittingFlag = "";
  String editType=request.getParameter("editType");
  String riskCode=request.getParameter("riskCode");
//start��ô���汾��
	String  versionType = "";
	String  versionNo = "";
	BLPrpCmain blPrpCmain= new BLPrpCmain();
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
	blPrpCmain.getData(request.getParameter("policyNo"));
	if(blPrpCmain.getSize() == 1){
		prpCmainSchema = blPrpCmain.getArr(0);
		 if(!(prpCmainSchema.getVersionNo()==null ||prpCmainSchema.getVersionNo()==""))
		  {
			  versionType = prpCmainSchema.getVersionNo().substring(0,1);
			  versionNo = prpCmainSchema.getVersionNo();
		  }
	}
//end��ô���汾��
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  session.setAttribute("oldCheckLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initCombinePage();initSet();readonlyAllInput();disabledAllButton('buttonArea');initSpan();">
<%
}else
{
%>
<body  onload="initCombinePage();initSet();initSpan();">
<%
}

%>

    <form name=fm action="/claim/combineCheckSave.do" method="post" >
    
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <table  class="common" cellpadding="1" cellspacing="1" >
   <tr><td colspan=13 class="formtitle">�����б�</td></tr>
    <tr>
		<td class="centertitle" style="width:1%">��ʾ</td>
		<td class="centertitle" style="width:4%">������</td>
		<td class="centertitle" style="width:1%">��ʾ</td>
		<td class="centertitle" style="width:4%">������</td>
		<td class="centertitle" style="width:1%">��ʾ</td>
		<td class="centertitle" style="width:4%">������</td>
		<td class="centertitle" style="width:1%">��ʾ</td>
		<td class="centertitle" style="width:4%">������</td>
    </tr>
    <%
   		Collection PrplcombineDtos = (Collection)request.getAttribute("combineDtos");
		Iterator iterator = PrplcombineDtos.iterator();
		PrplcombineDto prplcombineDto;
		while(iterator.hasNext()){%>
		<%	prplcombineDto = (PrplcombineDto)iterator.next();%>
		<tr>
		<td align="center">
			<input type="radio" name="registNoShow" onclick="spanShow();"  >
		</td>
		<td align="left">
			<a title="������"><%= prplcombineDto.getRegistno() %></a>
			<input type="hidden" name="combineRegistNo" value="<%= prplcombineDto.getRegistno() %>">
		</td>
		<%for(int i=0;i<3;i++){%>
		   <%if(iterator.hasNext()){
			 prplcombineDto = (PrplcombineDto)iterator.next();%>
			<td align="center">
				<input type="radio" name="registNoShow" onclick="spanShow();"  >
			</td>
			<td align="left">
				<a title="������"><%= prplcombineDto.getRegistno() %></a>
				<input type="hidden" name="combineRegistNo" value="<%= prplcombineDto.getRegistno() %>">
			</td>
			<%}%>
			<%}%>
			</tr>   
       <%}%>
 </table>
    
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
    <!-- ��������б����� -->
	<input type="hidden" name= "riskCode"  value="<%= request.getParameter("riskCode")%>">
	<input type="hidden" name= "nodeType"  value="<%= request.getParameter("nodeType")%>">
	<input type="hidden" name="policyno" value="<%= request.getParameter("policyNo") %>">
	<input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo") %>">
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">  
    <input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">   
       
        <%-- 1.�鿱/���鿱ͷ��Ϣ --%>
          <%@include file="/combineAgri/check/AgriCheckMainHeadEdit.jsp" %>
       
         <%-- 2.�鿱����Ϣ --%>
          <%--@include file="/commonAgri/check/AgriCheckMainMiddleEdit.jsp" --%>
         <%-- 3.�鿱β��Ϣ --%>
        
         <%-- ��Ԫ��Ŀ�鶨����Ϣ --%>
          <%@include file="/combineAgri/check/AgriCheckVerifyLossEdit.jsp" %>
             <%-- 3.�Ʋ���ʧ�嵥ҳ�� --%>
        <%@include file="/combineAgri/check/AgriCheckCertainLossPropEdit.jsp"%>

       
        <%@include file="/combineAgri/certainLoss/CombineAgriCertainLossPropEdit.jsp"%>
       
         <%-- 4.�鿱��ע��Ϣ --%>
          <%@include file="/combineAgri/regist/AgriRegistTextEdit.jsp"%>
          <%--5.��������Ϣ --%>
         <%--@include file="/commonAgri/claim/AgriClaimFeeEdit.jsp"--%>
          <%--5.����ͨ�ð�ť --%>
          <%@include file="/combineAgri/check/AgriCheckSave.jsp" %>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/CombineStaticJavascript.jsp" />

</html:html>
