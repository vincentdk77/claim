<%--
****************************************************************************
* DESC       ：调度查勘内容
* AUTHOR     ：
* CREATEDATE ：2004-08-04
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.SwfLogDto" %>    
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.*" %>
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
  <title>
    查勘任务处理清单
  </title>
  <script src="/claim/common/js/showpage.js"> </script>

  </script>

  <html:base/>
</head>

<body >
<form name="fm" >
  
 <table  class="common" cellpadding="5" cellspacing="1" >
 <tr>

            <td colspan="8" class="formtitle"><bean:write name="swfLogDto" property="nodeName"/>任务处理清单</td>

          </tr>
  
     <tr>

        <td class="centertitle"  style="width:6%">序号</td>
        <td class="centertitle"  style="width:10%">处理状态</td>
        <td class="centertitle" style="width:18%">报案登记号</td>
        <td class="centertitle" style="width:22%">调度时间</td>
        <td class="centertitle" style="width:10%">调度员</td>
        <td class="centertitle" style="width:10%">查勘人员</td>
        <td class="centertitle" style="width:24%">调度对象名称</td>
        
   <%--     <td class="centertitle" style="width:20%">处理时间</td>--%>
     </tr>

  <%int index=0;%>
  <% String dealHref="";      //处理功能，按钮上的联接%>
  <%SwfLogDto swfLogDto = null;
  SwfLogDto swfLogDto1 = (SwfLogDto)request.getAttribute("swfLogDto");
  String flowStr="";
  %>  
  
     <logic:notEmpty  name="swfLogDto"  property="swfLogList" >
     <logic:iterate id="prpLcheckTaskList"  name="swfLogDto"  property="swfLogList">
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
   //取得该行的DTO的数据 判断节点类型和状态，根据不同的状态，实现不同的按扭内容
      swfLogDto = (SwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index); 
       flowStr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
              +"&riskCode="+swfLogDto.getRiskCode()+"&editType=SHOW"
              +"&nodeType="+swfLogDto.getNodeType()
              +"&businessNo="+swfLogDto.getBusinessNo()
              +"&policyNo="+swfLogDto.getPolicyNo()
              +"&modelNo="+swfLogDto.getModelNo()
              +"&nodeNo="+swfLogDto.getNodeNo();
 
 %>     
        <td >
        <logic:equal name="prpLcheckTaskList" property="nodeStatus" value='0' > 新调度</logic:equal>
        <logic:equal name="prpLcheckTaskList" property="nodeStatus" value='2' > 正处理</logic:equal>
        <logic:equal name="prpLcheckTaskList" property="nodeStatus" value='4' > 已提交</logic:equal>
        </td>
        <% if (swfLogDto.getNodeStatus().equals("0")){
        dealHref ="javascript:alert('该任务目前还没有可以查看的"+swfLogDto.getNodeName() +"信息！');";
        }else{
            if (swfLogDto.getNodeType().equals("check")){
               dealHref ="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+swfLogDto.getKeyIn()
                                    +"&lossItemCode="+swfLogDto.getLossItemCode()
                                    +"&lossItemName="+swfLogDto.getLossItemName()
                                    +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                    +"&commiFlag=0"//+swfLogDto.getCommiFlag()    //add commiFlag by liyanjie 205-12-17
                                    +flowStr;
            }else{
               dealHref="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&commiFlag=0"//+swfLogDto.getCommiFlag()    //add commiFlag by liyanjie 205-12-17
                                      +flowStr;
            
            }
        }
        %>
          <td ><a href="<%=dealHref%>"> <bean:write name="prpLcheckTaskList" property="keyIn"/>
        </a></td>
        <td ><bean:write name="prpLcheckTaskList" property="flowInTime"/></td>         <%// 是否被调度使用   %>
        <td ><bean:write name="prpLcheckTaskList" property="beforeHandlerName"/></td>            <%// 预约查勘(定损)   %>
        <td ><bean:write name="prpLcheckTaskList" property="handlerName"/></td>
        <td ><bean:write name="prpLcheckTaskList" property="lossItemName"/></td>
   
       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>

      <tr class="listtail">
	      <td colspan="15">
	       	          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                  <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>  
<%
 // SwfLogDto swfLogDto = (SwfLogDto)request.getAttribute("swfLogDto"); 
  int curPage = swfLogDto1.getTurnPageDto().getPageNo(); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
	      </td>
      </tr>
    </table>
  </tr>

  <table class="common" cellpadding="4" cellspacing="20">
    <tr>
    </tr>
    <tr>

    </tr>
  <table>
<input type="hidden" name="editType" value="<bean:write name="swfLogDto" property="editType"/>"> 
<input type="hidden" name="nodeType" value="<bean:write name="swfLogDto" property="nodeType"/>"> 

  </table>
 </form>
 </body>
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>