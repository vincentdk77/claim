<%--
****************************************************************************
* DESC       ��δ�������ܲ�ѯ�����ʾ
* AUTHOR     ��lixiang
* CREATEDATE ��2004-09-28
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.text.*" %>
<%@page import="java.util.*"%>

<html:html locale="true">

<head>
    <app:css />

  <title>
  δ���������嵥
  </title>
  <script src="/claim/common/js/showpage.js"> </script>

  <script language=javascript>
  function reLoadList(){
     document.location.reload()
  }
  </script>

  <html:base/>
</head>

<body  onkeydown="if (event.keyCode==116){ reLoadList()}" >

<base target="_self">
<form name="fm"  method="post">

<table  class="common" cellpadding="5" cellspacing="1" >
<tr> <td colspan=12 class="formtitle">δ�������ʾ�б�</td></tr>
   <tr>
      <td class="centertitle" style="width:5%">���ִ���</td>
		  <td class="centertitle" style="width:8%">������</td>
		  <td class="centertitle" style="width:8%">������</td>
		  <td class="centertitle" style="width:19%">��������</td>
		  <td class="centertitle" style="width:8%">������</td>
		  <td class="centertitle" style="width:8%">��������</td>
		  <td class="centertitle" style="width:8%">�᰸����</td>
		  <td class="centertitle" style="width:4%">�ұ�</td>
		  <td class="centertitle" style="width:8%">������</td>
		  <td class="centertitle" style="width:8%" >�Ը�����</td>
		  <td class="centertitle" style="width:8%">��������</td>
		  <td class="centertitle"  style="width:8%">������</td>
		  <input type="hidden" name="sumClaim" value=0 >
		  <input type="hidden" name="sumDefLoss" value=0 >
   </tr>
   <%int index=0;%>
   <% double sumClaim=0;
      double sumDefLoss=0;

     PrpLclaimDto prpLclaimDto= null;
     PrpLclaimDto prpLclaimDto1 = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
      %>
   <logic:notEmpty  name="prpLclaimDto"  property="claimList">
   <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
     <tr class=common>
      <td align="center"><bean:write name="prpLclaim1" property="riskCode"/></a></td>
      <td align="center"><bean:write name="prpLclaim1" property="claimNo"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="policyNo"/></td>
      <td align="left"><bean:write name="prpLclaim1" property="insuredName"/></a></td>
      <td align="center"><bean:write name="prpLclaim1" property="startDate"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="claimDate"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="endCaseDate"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="currency"/></td>

      <td align="right"><bean:write name="prpLclaim1" property="sumClaim" format="###,###.00"/></td>
      <td align="right"><bean:write name="prpLclaim1" property="sumDefLoss" format="###,###.00" /></td>
   <%

            prpLclaimDto = (PrpLclaimDto) ((ArrayList)prpLclaimDto1.getClaimList()).get(index);
            sumClaim = sumClaim+prpLclaimDto.getSumClaim();
            sumDefLoss =sumDefLoss+ prpLclaimDto.getSumDefLoss();

   %>
      <td align="center"><bean:write name="prpLclaim1" property="makeCom"  /></td>
      <td align="center"><bean:write name="prpLclaim1" property="handlerCode"  /></td>

    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
        <td colspan="12">
        <% DecimalFormat nf = new DecimalFormat("###,##0.00");%>
         �ܼƣ���<%= index %>�ʱ���  �ܹ������<%= nf.format(sumClaim)%>Ԫ  ���Ը����ν���<%= nf.format(sumDefLoss)%>Ԫ
         <input type="hidden" name="conditions" value=<bean:write name="prpLclaimDto" property="remark"/>>
        </td>
         <tr>
		<td  colspan=12 class=button ><input type=button value=" ��  �� " class="button" onclick="window.close()"></td>
	  </tr>
      </tr>
  </table>


  </tr>
</table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</form>
</body>
</html:html>