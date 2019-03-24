<%--
****************************************************************************
* DESC       ：调度显示页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-08-05
* MODIFYLIST ：   Name       Date            Reason/Contents
                
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>

<html:html locale="true">
  <!--对title处理-->  
  <title>调度处理</title>
  <app:css />  
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/schedule/js/DAAScheduleEdit.js"></script>
</head> 

<body class=interface onload="initPage();initSet();">
    <form name=fm action="/claim/scheduleSave.do" method="post" >
      
      <%-- 1.调度主信息头信息 --%>
      
      <%@include file="/DAA/schedule/DAAScheduleMainEdit.jsp" %>
      <%-- 2.调度标的内容 --%>
      
      
          涉案所需要调度车辆
          <%-- 多行输入展现域 --%>
             <table id="ScheduleItem"  align="center" cellspacing="1" cellpadding="4" border="0" bgcolor="#2D8EE1" class="title" style="width:100%" >
                <thead>
                 <tr>
                 <td class="title" colspan=7>
                 <bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />
                 <bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />
                 </td>
                 </tr>
      
                  <tr>
                       <td class="title" style="width:10%;text-align:center" >序号</td>
                     <td class="title" style="width:90%;text-align:center" colspan="6">内容</td>
                  </tr>
                </thead>
                <tbody>
                <%int index=0;%>
                <%String checkValue=""; %>
                 
                <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
                <logic:iterate id="scheduleItem" name="prpLscheduleItemDto" property="scheduleItemList">
             <!-- 插入涉案车辆内容-->        
                
                 <tr>
                   <td class="title" style="width:8%" rowspan="3">
                    <div align="center">
                    <input class="readonlyno" readonly name="prpLscheduleItemItemNo" value="<bean:write name='scheduleItem' property='itemNo'/>">
                        <logic:equal name='scheduleItem' property='selectSend' value="1">
                         <input type="checkbox" class="readonly"  name="checkYesNo" style="1px" value="ON" checked disabled>&nbsp;
                     </logic:equal>  
                      
                     <logic:notEqual name='scheduleItem' property='selectSend' value="1">
                         <input type="checkbox" class="readonly"  name="checkYesNo" style="1px" value="ON"  disabled>&nbsp;
                     </logic:notEqual>
                    
                    </div>
                   </td>          
                <td class="title" style="width:11%">号牌号码:</td>
                <td class="input" style="width:20%" style="valign:bottom" >
                    <bean:write name='scheduleItem' property='licenseNo'/>
                     
                </td>
                 <td class="title" style="width:16%" >查勘地址类型:</td>
                <td class="input" style="width:16%">
                
                <logic:equal name='scheduleItem' property='surveyType' value="1">
                         第一现场
                </logic:equal>  
                      
                <logic:notEqual name='scheduleItem' property='surveyType' value="1">
                         非第一现场
                </logic:notEqual>
                </td>
                
                  <td class="title" style="width:19%">是否为本保单车辆:</td>
                 <td class="input" style="width:10%">
                     <logic:equal name='scheduleItem' property='insureCarFlag' value="1">
                         是
                     </logic:equal>  
                     
                     <logic:notEqual name='scheduleItem' property='insureCarFlag' value="1">
                         否
                     </logic:notEqual>  
                     
                  </td>
                         
            </tr>
            
          
             
             <tr>   
                 <td class="title" >查勘地址:</td>
                 <td class="input" colspan=5>
                  <bean:write name='scheduleItem' property='checkSite'/>
                 </td>
             </tr>
           
              <tr>
                <td class="title" >调度信息:</td>
          <td class="input" colspan=6>
              <bean:write name='scheduleItem' property='resultInfo'/>
           </td>
                </tr>
         
        <%    index++;%>
        </logic:iterate>
      </logic:notEmpty>  
       
                </tbody>
              <input type=hidden name=maxrow value=<%=index%>>   
             </table>
      
     <table cellpadding="0" cellspacing="10" width="80%" style="display:">
      
      <%-- 
      --%>
      <tr>
         <td class="button" style="width:50%" align="center">
            <!--取消按钮-->
            <input type="button" name=buttonCancel class='button' value="返回" onclick="history.back();" >
          </td>
      </tr>
    </table>
 </form>   

</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
