<%--
****************************************************************************
* DESC       ���鿱/�����ѯ�����ʾҳ��
* AUTHOR     ��lijiyuan
* CREATEDATE ��2004-03-01
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.SwfLogDto" %>
<%@ page import="java.util.*"%>
<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
  <script language="javascript">
  <%--����״̬��־����--%>
  <!--
    function submitForm()
    {
      fm.submit();//�ύ
    }
  //-->
  </script>
</head>

<body  >

<%
    SwfLogDto swfLogDto = null;
    SwfLogDto swfLogDtoTemp1 = (SwfLogDto)request.getAttribute("swfLogDto");
    String typeFlag ="2"; //Ĭ�϶���
    String dealHref="";      //�����ܣ���ť�ϵ�����
    String flowStr="";       //��������flowid��logNo�ĺ���ִ������ּ���riskCode��editType,��Ϊÿ�������ݵ�
%>
<logic:equal  name="swfLogDto"  property="nodeType" value="check"><%  typeFlag="1";%></logic:equal>

  <table  class="common" cellpadding="5" cellspacing="1" >
   <tr><td colspan=7 class="formtitle">
                 <bean:write name="swfLogDto" property="nodeName"/>�����嵥
            </td>
    </tr>
     <tr>
        <td class="centertitle" >���</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" ><bean:write name="swfLogDto" property="nodeName"/>���</td>
        <td class="centertitle" ><bean:write name="swfLogDto" property="nodeName"/>Ա</td>
        <td class="centertitle" >����ʱ��</td>
        <td class="centertitle" >����(�ط�)</td>
     </tr>
     <%int index=0;%>

     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogDto1"  name="swfLogDto"  property="swfLogList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
       <tr class=common>
       <td align="center"><%=index+1%></td>
<% swfLogDto = (SwfLogDto) ((ArrayList)swfLogDtoTemp1.getSwfLogList()).get(index); %>
        <td align="center">
        <a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<bean:write name='swfLogDto1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name="swfLogDto1" property="riskCode"/>"><bean:write name="swfLogDto1" property="keyIn"/></a></td>
        <td align="center"><bean:write name="swfLogDto1" property="policyNo"/></td>
        <td align="center"><bean:write name="swfLogDto1" property="lossItemName"/></td>
        <td align="center"><bean:write name="swfLogDto1" property="handlerName"/></td>
        <td align="center"><bean:write name="swfLogDto1" property="handleTime"/></td>
        <td align="center">
<%      flowStr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
              +"&riskCode="+swfLogDto.getRiskCode()+"&editType=ADD"
              +"&nodeType="+swfLogDto.getNodeType()
              +"&businessNo="+swfLogDto.getBusinessNo()
              +"&keyIn="+swfLogDto.getKeyIn()
              +"&policyNo="+swfLogDto.getPolicyNo()
              +"&modelNo="+swfLogDto.getModelNo()
              +"&nodeNo="+swfLogDto.getNodeNo();

         dealHref="/claim/backVisitBeforeEdit.do?RegistNo=" + swfLogDto.getKeyIn()
                 +"&lossTypeFlag="+typeFlag
                 +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                 +"&lossItemCode="+swfLogDto.getLossItemCode()
                 +"&lossItemName="+swfLogDto.getLossItemName()
                 +"&newNode=true"
                 +flowStr;


%>
          <A href="<%=dealHref%>">�ط�</A>


        </td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="7">
	       ����ѯ��<%= index %>�����������ļ�¼
	      </td>
      </tr>
    </table>
    

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>