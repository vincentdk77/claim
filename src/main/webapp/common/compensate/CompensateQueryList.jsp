<%--
****************************************************************************
* DESC       �������ѯ���ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-07
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<!--- add by zhaolu 20060803  start --->
<%@ page import="com.sinosoft.claim.dto.domain.PrpLcompensateDto" %>
<!--- add by zhaolu 20060803 end --->
<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >
   <!--- add by zhaolu 20060803 start --->
   <form name="fm" action="/claim/compensateQuery.do"  method="post">
   <!--- add by zhaolu 20060803 end ---> 
  <table  class="common" cellpadding="6" cellspacing="1" >
  <tr>  <td colspan=6 class="formtitle">��ѯ������Ϣ</td></tr>
     <tr>
        <td class="centertitle" >ѡ��</td>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" >���������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >���⸶���(��CNY)</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLcompensateDto"  property="compensateList">
     <logic:iterate id="prpLcompensate1"  name="prpLcompensateDto"  property="compensateList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
    <tr class=common>  
    
    <td align="center"><input type="checkbox" name="check"  onClick="setCheckFlag(<%=index%>);">
                       <input type="hidden" name="CheckFlag" value="N">   
    </td>
    <td align="center">
        <logic:equal name="prpLcompensate1" property="status" value='1' >
         δ����
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="status" value='2' >
         ������
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="status" value='3' >
         �Ѵ���
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="status" value='4' >
         ���ύ
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="status" value='5' >
         �ѳ���
        </logic:equal>
      </td>
        <td align="center"> <a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='prpLcompensate1' property='compensateNo'/>&editType=<bean:write name='prpLcompensateDto' property='editType'/>&riskCode=<bean:write name="prpLcompensate1" property="riskCode"/>"> <bean:write name="prpLcompensate1" property="compensateNo"/></a></td>
        <td align="center"><bean:write name="prpLcompensate1" property="claimNo"/></td>
        <td align="center"><bean:write name="prpLcompensate1" property="policyNo"/></td>
        <td align="center"><bean:write name="prpLcompensate1" property="sumPaid"/></td>
        <input type="hidden" name="CompensateNo" value="<bean:write name='prpLcompensate1' property='compensateNo'/>">     
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
   <tr class="listtail">
     <td align="center" colspan="5">
         <input class="button" type="button" name= "deleteButton" alt=" ɾ�� " value="ɾ ��" onclick="deleteLS()">
         <input class="button" type="button" alt=" ���� " value="�� ��" onclick="history.back()">
     <!--- add by zhaolu 20060803 start --->
      <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLcompensateDto" property="turnPageDto"/>  
<% 
  PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto"); 
  int curPage = prpLcompensateDto.getTurnPageDto().getPageNo(); 
%>                   
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
      <!--- add by zhaolu 20060803 end --->
     </td>
   </tr>
    </table>
    </tr>
  </table>
  
  <!--- add by zhaolu 20060803 start --->
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
<input type="hidden" name="deleteFlag" value="0">
</form>
    <div id="doing" style="position:absolute; top:295px; left:8px; visibility:hidden; z-index:0; width: 772px; height: 40px;"> 
        <TABLE WIDTH=100% BORDER=0 CELLSPACING=0 CELLPADDING=0>

            <TR>
                <td width=30%></td>

                <TD bgcolor=#2D8EE1>

                    <TABLE WIDTH=100% height=40 BORDER=0 CELLSPACING=2 CELLPADDING=0>

                        <TR>

                            <td bgcolor=#eeeeee align=center>����ִ�в���, ���Ժ�...</td>

                        </tr>

                    </table>
                </td>
                <td width=30%></td>
           </tr>
        </table>

    </div>
<!--- add by zhaolu 20060803 end --->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>