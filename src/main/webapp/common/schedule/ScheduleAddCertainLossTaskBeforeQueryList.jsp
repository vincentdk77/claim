<%--
****************************************************************************
* DESC       ：新增定损调度查询结果显示页面
* AUTHOR     ：wangli
* CREATEDATE ：2005-04-12
* MODIFYLIST ：   id       Date            Reason/Contents
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
  <title>新增定损调度查询结果显示页面</title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
  <script language="javascript">
  <%--案件状态标志处理--%>
  <!--
    function submitForm() 
    {
      fm.submit();//提交
    }
  //--> 
  </script>
</head>

<body >
<form name="fm" >

  
<table  class="common" cellpadding="5" cellspacing="1" >
 <tr>

           <td colspan="8" class="formtitle">新增定损调度任务清单</td>

          </tr>
     <tr>
        <td class="centertitle" >案件状态</td>
        <td class="centertitle" >报案号</td>
        <td class="centertitle" >车牌号</td>
        <td class="centertitle" >操作员</td>
        <td class="centertitle" >流入时间</td> 
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
         新调度
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='1' >
         未处理
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='2' >
         正处理
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='3' >
         回退处理
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='4' > 
         已提交 
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='5' >
         已回退
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='6' >
        已撤消
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