<%--
****************************************************************************
* DESC       ：添加立案号列表[ 实赔 ]
* AUTHOR     :qianxiantao
* CREATEDATE :2011-08-16
* MODIFYLIST :  Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.gyic.claim.dto.domain.*" %>
<%@page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.claim.bl.facade.*"%>
<%
     int index=0;
     String flowStr="";
     String EditLastType=request.getParameter("editType");
     String flag1=request.getParameter("flag1");
     String dealHref="";
     PrplcombineSwfLogDto swfLogDto = null;
     PrplcombineSwfLogDto swfLogDto1 = (PrplcombineSwfLogDto)request.getAttribute("swfLogDto");
     PrpLcompensateDto prpLcompensateDto1 = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto"); 
%>
<script>
 function checkSumThisPaid(){
 if(""!=fm.SumThisPaid.value){
 alert("该理算书已生成，请不要重复操作！");
 return false;
 }else{
 return true;
 }
 }
</script>
 <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" colspan="4" style="text-align:left">
      </td>    
    </tr>
  </table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <input type="hidden" name="compensateSumThisPaid" value="<bean:write name='prpLcompensateDto' property='sumThisPaid'/>">
  <tr>
  <td class="title"  align="center"  style="width:10%"> 序号</td>
  <%if("ADD".equals(EditLastType)){ %>
  <td class="title"  align="center"  style="width:45%"> 立案号:</td>
  <%}else{ %>
  <td class="title"  align="center"  style="width:45%"> 计算书号:</td>
  <% }%>
  <td class="title" name="SumThisPaid" align="center" style="width:45%"> 赔款金额:</td>
  </tr>
    <logic:notEmpty  name="swfLogDto"  property="swfLogList">
    <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">
      <tr> 
         <td align="center" class="title" style="width:10%">
             <%=index+1%>
         </td>
     <%
      swfLogDto = (PrplcombineSwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
      %>
     <%
     flowStr="swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
     +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
     +"&nodeType="+swfLogDto.getNodeType()
     +"&prpLcompensateCompensateNo="+swfLogDto.getBusinessNo()
     +"&keyIn="+swfLogDto.getKeyIn()
     +"&policyNo="+swfLogDto.getPolicyNo()
     +"&modelNo="+swfLogDto.getModelNo()
     +"&nodeNo="+swfLogDto.getNodeNo()
     +"&dfFlag="+swfLogDto.getDfFlag()
     +"&comBineNo="+swfLogDto.getCombineno()
     +"&ClaimNo="+swfLogDto.getKeyIn()
     +"&caseType="+swfLogDto.getTypeFlag()
     +"&compeCount=" + swfLogDto.getCompeCount(); %>
     <%
     if("0".equals(swfLogDto.getNodeStatus())){
       dealHref="/claim/combineCompensateEditeADD.do?"+flowStr;
     }else{
    	 dealHref="/claim/combineCompensateEdite.do?"+flowStr;
     }%>
     <%
     BLCompensateFacade blComoensateFacade=new BLCompensateFacade();
     BLPrpLcompensateFacadeBase compensateFacade=new BLPrpLcompensateFacadeBase();
     PrpLcompensateDto  compensateDto1= new PrpLcompensateDto();
     compensateDto1=(PrpLcompensateDto)compensateFacade.findByPrimaryKey(swfLogDto.getBusinessNo());
     %>
    <td align="center" class="input">     
       <%if("Y".equals(request.getAttribute("flag1"))){ %>
        <a href="<%=dealHref%>" onclick="checkSumThisPaid()"><bean:write name="swfLogList1" property="claimNo"/></a>
        <input type="hidden" name="combineBusinessNo" value="<bean:write name="swfLogList1" property="claimNo"/>"/>  
       <%}else{ %>
        <a href="<%=dealHref%>" onclick="checkSumThisPaid()"><bean:write name="swfLogList1" property="businessNo"/></a>
        <input type="hidden" name="combineBusinessNo" value="<bean:write name="swfLogList1" property="businessNo"/>"/> 
       <%} %>
        <input type="hidden" name="combineUrl" value="<%=dealHref%>">      
       </td>
       <%if("EDIT".equals(EditLastType)){ %>
      <td align="center" class="input"><%=compensateDto1.getSumThisPaid()%></td>
       <%}else{ %>
      <td align="center" class="input"><%=("Y".equals(request.getAttribute("flag1"))?request.getAttribute("SumThisPaid"):"")%></td>      
       <%} %>
  </tr>
  <%index++;%>
     </logic:iterate>
     </logic:notEmpty>
</table> 
