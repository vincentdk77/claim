<%--
****************************************************************************
* DESC       : δ����������Ϣ��ѯ���ҳ��
* AUTHOR     : qianxiantao
* CREATEDATE ��2011-08-12
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.gyic.claim.dto.domain.*" %>
<%@page import="java.util.*"%>
<html:html locale="true">
<head>
    <app:css />
  <title>
    <!-- ���ݽڵ��������ʾ���� -->
    �������ڵ�״̬
  </title>
  <script src="/claim/workflow/task/js/WfLogStatusList.js"> </script>
  <script src="/claim/common/js/showpage.js"> </script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  function submitForm()
  {
    progressStart();
    fm.action="/claim/compensateQueryList.do?Flag=N";
    fm.searchFlag.value="true";
    fm.submit();//�ύ
  }
  </script>
   <html:base/>
</head>
<body onload="progressStop();">
<%
     int index=0;
     String strTitle="";
     String subTitleTime="";
     String subTitleColName="";
     String nodeStatus=request.getParameter("status");
     System.err.println(nodeStatus); 
     String policyNo=request.getParameter("PolicyNo");
     String comBineNo=request.getParameter("ComBineNo");
     String registNo=request.getParameter("RegistNo");
     String editType=request.getParameter("editType");
     String isFirst = request.getParameter("isFirst");
     String flowStr="";
     String EditLastType="";
     String dealHref="";
     PrplcombineSwfLogDto swfLogDto = null;
     PrplcombineSwfLogDto swfLogDto1 = (PrplcombineSwfLogDto)request.getAttribute("swfLogDto");
     String riskCode="";
     String nowNodeStatus=""; //��ÿ��״̬�ж��õ�
     int colNumber=9;         //���������� ������ʾ��7��
     String strClaimRiskType = request.getParameter("RiskClaimType");
    // String strClaimRiskType = "H";
     String checkStr="";
     if (nodeStatus.equals("2")){
    	    strTitle="���ڴ���";
    	    subTitleTime="����ʱ��";    
    	    if(editType.equals("DELETE")){
    	      editType="DELETE";
    	    }else{
    	      editType="EDIT";
    	    }
    	  }
    	  if (nodeStatus.equals("3")){
    	    strTitle="���˻�";
    	    subTitleTime="�˻�ʱ��";
    	    editType="EDIT";
    	  }
    	  if (nodeStatus.equals("4")){
    	    strTitle="�Ѵ���";
    	    subTitleTime="����ʱ��";
    	    editType="SHOW";
    	  }
    	  if (nodeStatus.equals("0")){
    	    strTitle="δ����";
    	    subTitleTime="����ʱ��";
    	    editType="ADD";
    	  }
    	  if (nodeStatus.equals("-1")){
    	    strTitle="";
    	    subTitleTime="����ʱ��";
    	    editType="CANCEL";
    	  }
    	  if (nodeStatus.equals("99")){
    	    strTitle="";
    	    subTitleTime="����ʱ��";
    	    editType="SHOW";
    	    colNumber=6;
    	  }
%>
<form name="fm" action="/claim/compensateQueryList.do?Flag=Y"  method="post">
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=4 class="formtitle">��ѯ����</td></tr>
      <tr>
      <td class='title'>�����ţ�</td>
        <td class='input' >
          <select class=tag name="PolicyNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query"  style="width:60%">
        </td>
        <td class='title'>���֣�</td>
        <td class='input' >
          <select class='input' name="riskCode" style="width:160">
            <option value="3220">�ܷ�ĸ����ֳ����</option>
            <option value="3202">��ţ��ֳ����</option>
            <option value="3223">�ܷ�ĸ����ֳ����</option>
            <option value="3227">������ֳ����</option>
            <option value="3233">����ĸţ����</option>
            <option value="3234">ţ��ֳ����</option>
            <option value="3240">�Ƽ���������</option>
          </select>
        </td> 
      </tr>
      <tr> 
      <td class='title'>
             �¹ʺ�
        </td>
        <td class='input'>
          <select class=tag name="BusinessNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ComBineNo" class="query"  style="width:60%">
        </td>       

         <td class='title' colspan=2>����ʱ��:
          <input type=text style="width:85" width="30%" name="statStartDate" class="Wdate" value="" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
          ����
          <input type=text style="width:85" name="statEndDate" class="Wdate" value="" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
       </td> 
      </tr>
      <!--------------------���ӱ������ˣ������Ų�ѯ-start---------------------------------------------->
      <tr>
        <td class='title'>������</td>
        <td class='input'>
          <select class=tag name="comBineNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query"  style="width:60%">
        <td class='title'>�������ˣ�</td>
        <td class='input' >
          <select class=tag name="insuredNameSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="insuredName" class="query" style="width: 60%">
        </td> 

       </tr>
       <tr>
        <td class='title'>������</td>
        <td class='input'>
          <select class=tag name="comBineNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query"  style="width:60%">
          </td>
        <td class='title'></td>
        <td class='input'></td>
       </tr>
      <!--------------------���ӱ������˲�ѯ----end------------------------------------------->
      <tr>
       <td class='button' colspan="4">
          <input type=button name="queryButton" class='button' value="��ѯ" onClick="submitForm();">
        </td>
        </tr>   
 </table>
 <app:processBar/>
      <%
          if("N".equals(isFirst)){
     %>
     <table  class="common" cellpadding="5" cellspacing="1" >
     <tr><td colspan=12 class="formtitle">δ����������Ϣ</td>
     </tr>
     <tr>
         <td class="centertitle" >���</td>
         <td class="centertitle" >״̬</td>
         <td class="centertitle" >������</td>
         <td class="centertitle" >�¹ʺ�</td>
         <td class="centertitle" >��������</td>
         <td class="centertitle" >����</td>
         <td class="centertitle" >��������</td>
         <td class="centertitle" >�ڵ�����</td>
     </tr>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">

     <%
     if(index %2== 0)
          out.print("<tr class=listodd>");
     else
          out.print("<tr class=listeven>");
      %>
         <td align="center">
             <%=index+1%>
         </td>
         <%
      swfLogDto = (PrplcombineSwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
      nowNodeStatus=swfLogDto.getNodeStatus();
      EditLastType=editType;
      %>
       <td align="center">
      <%
             if (nowNodeStatus.equals("2")){ %> ���ڴ���
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("4")){ %> ���ύ
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("0")){ %> �´���
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("5")){ %> ��ͨ���˻�
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("3")){ %> ���˴���
      <%
             }
      %>
           <%
     flowStr="swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
     +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
     +"&nodeType="+swfLogDto.getNodeType()
     +"&businessNo="+swfLogDto.getBusinessNo()
     +"&keyIn="+swfLogDto.getKeyIn()
     +"&policyNo="+swfLogDto.getPolicyNo()
     +"&modelNo="+swfLogDto.getModelNo()
     +"&nodeNo="+swfLogDto.getNodeNo()
     +"&dfFlag="+swfLogDto.getDfFlag()
     +"&comBineNo="+swfLogDto.getCombineno()
     +"&ClaimNo="+swfLogDto.getKeyIn()
     +"&caseType="+swfLogDto.getTypeFlag() 
     +"&compeCount=" + swfLogDto.getCompeCount();  %>
     <%dealHref="/claim/combineCompensateBeforeEditeADD.do?"+flowStr;%>
        </td>
         <td align="center">
            <a href="<%=dealHref%>"><bean:write name="swfLogList1" property="claimNo"/></a></td>
        </td>
        <td align="center" width="12%">
        <bean:write name="swfLogList1" property="combineno"/>
        </td>
        <td align="center">
        <bean:write name="swfLogList1" property="policyNo"/>
        </td>
        <td align="center"><bean:write name="swfLogList1" property="riskCodeName"/></td>
        <td align="center" width="12%"><bean:write name="swfLogList1" property="insuredName"/></td>
        <td align="center"><bean:write name="swfLogList1" property="nodeName"/></td>
         </tr>
        <%index++;%>
     </logic:iterate>
     </logic:notEmpty>
        <tr class="listtail" align="center">
         <td colspan='16' align="center">
           <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr align="center">
             <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>
      <%int curPage = swfLogDto1.getTurnPageDto().getPageNo(); %>
      <%@include file="/common/pub/TurnOverPage.jsp"  %>
              </tr>
          </table>
         </td>
     </tr>
    </table>
<%
  }//�Ƿ��һ�ν�������һ�ν�������ѯ���End
%>
   </tr>
</table>
 <table>
 <tr>
  <input type="hidden" name="checkBox" value="<%=request.getAttribute("checkBox")==null?"":request.getAttribute("checkBox")%>">
  <input type="hidden" name="comBineNo" value="<%=request.getAttribute("ComBineNo")%>">
  <input type="hidden" name="policyNo" value="<%=request.getAttribute("PolicyNo")%>">
  <input type="hidden" name="StartDate" value="<%=request.getAttribute("StartDate")%>">
  <input type="hidden" name="EndDate" value="<%=request.getAttribute("EndDate")%>">
  <input type="hidden" name="claimNo" value="<%=request.getAttribute("ClaimNo")%>">
  <input type="hidden" name="status" value="<%=request.getAttribute("status")%>">  
  <input type="hidden" name="RiskCode"  value=""/>
  <input type="hidden" name="combineUrl"  value="<%=flowStr%>"/>
  <input type="hidden" name="searchFlag"  value=""/>
  <input type="hidden" name="alertMessage" class="common" value=""/>
  <input type="hidden" name="editType"  value="SHOW"/>
  <input type="hidden" name="isFirst" value="N"/>
  </tr>
  </table>
</form> 
</body>
</html:html>
  <script language="javascript">
     fm.queryButton.disabled = false;
  </script>