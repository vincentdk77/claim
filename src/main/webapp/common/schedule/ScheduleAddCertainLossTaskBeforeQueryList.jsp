<%--
****************************************************************************
* DESC       ������������Ȳ�ѯ�����ʾҳ��
* AUTHOR     ��wangli
* CREATEDATE ��2005-04-12
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

<html:html locale="true">
<head>
    <app:css />
    <STYLE>BODY {
                 SCROLLBAR-FACE-COLOR:#EFFAFF;
                 SCROLLBAR-HIGHLIGHT-COLOR:#4D9AC4;
                 SCROLLBAR-SHADOW-COLOR:#4D9AC4;
                 SCROLLBAR-3DLIGHT-COLOR:#EFFAFF;
                 SCROLLBAR-ARROW-COLOR:#EFFAFF;
                 SCROLLBAR-TRACK-COLOR:#EFFAFF;
                 SCROLLBAR-DARKSHADOW-COLOR:#EFFAFF;
                }
                </STYLE>  
  <title>����������Ȳ�ѯ�����ʾҳ��</title>
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

<body >
<form name="fm" >

  
<table  class="common" cellpadding="5" cellspacing="1" >
 <tr>

           <td colspan="8" class="formtitle">����������������嵥</td>

          </tr>
     <tr>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >���ƺ�</td>
        <td class="centertitle" >����Ա</td>
        <td class="centertitle" >����ʱ��</td> 
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

        <td align="center">
        <logic:equal name="swfLogDto1" property="nodeStatus" value='0' >
         �µ���
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='1' >
         δ����
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='2' >
         ������
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='3' >
         ���˴���
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='4' > 
         ���ύ 
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='5' >
         �ѻ���
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='6' >
        �ѳ���
       </logic:equal>
        </td>
        <td align="center">
        <a href="/claim/scheduleAddCertainLossTask.do?businessNo=<bean:write name='swfLogDto1' property='keyIn'/>&editType=ADDSHOW&swfLogFlowID=<bean:write name='swfLogDto1' property='flowID'/>&swfLogLogNo=<bean:write name='swfLogDto1' property='logNo'/>&policyNo=<bean:write name='swfLogDto1' property='policyNo'/>&nodeStatus=<bean:write name='swfLogDto1' property='nodeStatus'/>"><bean:write name="swfLogDto1" property="businessNo"/></a>
        
        </td>    
        <td align="center"><bean:write name="swfLogDto1" property="lossItemName"/></td>
        <td align="center"><bean:write name="swfLogDto1" property="handlerName"/></td>
        <td align="center"><bean:write name="swfLogDto1" property="flowInTime"/></td>     
      </tr>   
<%        index++;%>       
      </logic:iterate> 
      </logic:notEmpty>
      <tr class="listtail"> 
	      <td colspan="5">
	     	          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                 <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>  
<%
  SwfLogDto swfLogDto = (SwfLogDto)request.getAttribute("swfLogDto"); 
  int curPage = swfLogDto.getTurnPageDto().getPageNo(); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
	      </td>
      </tr>
    </table>  
    
    
     <input type="hidden" name="editType" value="ADDQUERY">   
    
    
    </tr>  
  </table>
  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html> 