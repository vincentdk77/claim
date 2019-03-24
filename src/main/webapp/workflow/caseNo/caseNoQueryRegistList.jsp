<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.CaseNoQueryDto"%>
<%@page import="com.sinosoft.claim.dto.custom.TurnPageDto"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%
  TurnPageDto turnPageDto = (TurnPageDto)request.getAttribute("turnPageDto");
  ArrayList<CaseNoQueryDto> list =  (ArrayList<CaseNoQueryDto>)turnPageDto.getResultList();
%>
<html xmlns:v="urn:schemas-microsoft-com:vml">

<head>
    <app:css />

  <title>案件号互查表</title>
  <script src="/claim/workflow/caseNo/js/caseNoQueryRegistList.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <html:base/>
</head>

<body  >
<form name="fm1" action="/claim/caseNoQueryDxfl.do?editType=query"  method="post">
      

	<input type="hidden" name="condition" value="<%=turnPageDto.getCondition()%>"/>
  <table class=common style="width=100%" >
  	<tr><td class="formtitle" colspan="6">案件号互查表</td></tr>
  	<tr>
  	 <td class="formtitle" style="width=17%">保单号</td>
  	 <td class="formtitle" style="width=17%">报案号</td>
  	 <td class="formtitle" style="width=17%">立案号</td>
  	 <td class="formtitle" style="width=17%">计算书号</td>
  	 <td class="formtitle" style="width=17%">结案号</td>
  	 <td class="formtitle" style="width=17%">流程查询</td>
  	</tr>
  	<%
  	 for(CaseNoQueryDto dto:list){
  	%>
  	<tr>
  	
  	 <td align="center">
  	 <input type="hidden" value="/prpall/<%= dto.getPolicyno().substring(1,5)%>/tbcbpg/UIPrPoEn<%= dto.getPolicyno().substring(1,5)%>Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo=<%= dto.getPolicyno()%>&RiskCode=<%= dto.getPolicyno().substring(1,5)%>"/>
  	 <a href="javascript:void(0);" onclick="openWindow1(this);">
  	 <%= dto.getPolicyno()==null?"":dto.getPolicyno()%>
  	 </a>
  	 </td>
  	 <td align="center">
  	 <input type="hidden" value="/claim/registFinishQueryList.do?prpLregistRegistNo=<%= dto.getRegistno()%>&editType=SHOW&riskCode=<%= dto.getPolicyno().substring(1,5)%>&caseNoQuery1=caseNoQuery1" />
  	 <a href="javascript:void(0);" onclick="openWindow1(this);"> 
  	 <%= dto.getRegistno()==null?"":dto.getRegistno()%></a></td>
  	 <td align="center">
  	 <input type="hidden" value="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<%=dto.getClaimno() %>&editType=SHOW&riskCode=<%= dto.getPolicyno().substring(1,5)%>&caseNoQuery1=caseNoQuery1" />
  	 <a href="javascript:void(0);" onclick="openWindow1(this);">
  	 <%= dto.getClaimno()==null?"":dto.getClaimno()%>
  	 </a>
  	 </td>
  	 <td align="center">
  	 <input type="hidden" value="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<%=dto.getCompensateno() %>&editType=SHOW&riskCode=<%= dto.getPolicyno().substring(1,5)%>&caseNoQuery1=caseNoQuery1" />
  	 <a href="javascript:void(0);" onclick="openWindow1(this);">
  	 	<%= dto.getCompensateno()==null?"":dto.getCompensateno()%>
  	 </a>
  	 </td>
  	 <td align="center">
  	 <input type="hidden" value="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo=<%=dto.getClaimno() %>&editType=SHOW&riskCode=<%= dto.getPolicyno().substring(1,5)%>&ClaimNoSign=*&caseNoQuery1=caseNoQuery1" />
  	 <a href="javascript:void(0);" onclick="openWindow1(this);">
  	 <%= dto.getCaseno()==null?"":dto.getCaseno()%>
  	 </a>
  	 </td>
  	 <td align="center">
  	 <input type="hidden" value="/claim/swfFlowBeforeQueryDxfl.do?swfLogFlowID=<%= dto.getFlowid()%>&caseNoQuery1=caseNoQuery1" />
  	 	<a href="javascript:void(0);" onclick="openLink(this);" title="<%= dto.getFlowid()%>">
  	 		<%= dto.getFlowid()==""?"":"查看"%>
  	 	</a>
  	 </td>
  	</tr>	
  	<% 
  	 }
  	%>
  	
  	<tr class="listtail">
        <td colspan="7">
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                  <bean:define id="pageview" name="turnPageDto"/>  
<%
  int curPage = turnPageDto.getPageNo(); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
        </td> 
      </tr> 
  </table>
</form>  

<script language="javascript">

</script>
</body>
</html>