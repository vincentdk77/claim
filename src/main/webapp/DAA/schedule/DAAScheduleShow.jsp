<%--
****************************************************************************
* DESC       ��������ʾҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-08-05
* MODIFYLIST ��   Name       Date            Reason/Contents
                
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>

<html:html locale="true">
  <!--��title����-->  
  <title>���ȴ���</title>
  <app:css />  
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/schedule/js/DAAScheduleEdit.js"></script>
</head> 

<body class=interface onload="initPage();initSet();">
    <form name=fm action="/claim/scheduleSave.do" method="post" >
      
      <%-- 1.��������Ϣͷ��Ϣ --%>
      
      <%@include file="/DAA/schedule/DAAScheduleMainEdit.jsp" %>
      <%-- 2.���ȱ������ --%>
      
      
          �永����Ҫ���ȳ���
          <%-- ��������չ���� --%>
             <table id="ScheduleItem"  align="center" cellspacing="1" cellpadding="4" border="0" bgcolor="#2D8EE1" class="title" style="width:100%" >
                <thead>
                 <tr>
                 <td class="title" colspan=7>
                 <bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />
                 <bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />
                 </td>
                 </tr>
      
                  <tr>
                       <td class="title" style="width:10%;text-align:center" >���</td>
                     <td class="title" style="width:90%;text-align:center" colspan="6">����</td>
                  </tr>
                </thead>
                <tbody>
                <%int index=0;%>
                <%String checkValue=""; %>
                 
                <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
                <logic:iterate id="scheduleItem" name="prpLscheduleItemDto" property="scheduleItemList">
             <!-- �����永��������-->        
                
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
                <td class="title" style="width:11%">���ƺ���:</td>
                <td class="input" style="width:20%" style="valign:bottom" >
                    <bean:write name='scheduleItem' property='licenseNo'/>
                     
                </td>
                 <td class="title" style="width:16%" >�鿱��ַ����:</td>
                <td class="input" style="width:16%">
                
                <logic:equal name='scheduleItem' property='surveyType' value="1">
                         ��һ�ֳ�
                </logic:equal>  
                      
                <logic:notEqual name='scheduleItem' property='surveyType' value="1">
                         �ǵ�һ�ֳ�
                </logic:notEqual>
                </td>
                
                  <td class="title" style="width:19%">�Ƿ�Ϊ����������:</td>
                 <td class="input" style="width:10%">
                     <logic:equal name='scheduleItem' property='insureCarFlag' value="1">
                         ��
                     </logic:equal>  
                     
                     <logic:notEqual name='scheduleItem' property='insureCarFlag' value="1">
                         ��
                     </logic:notEqual>  
                     
                  </td>
                         
            </tr>
            
          
             
             <tr>   
                 <td class="title" >�鿱��ַ:</td>
                 <td class="input" colspan=5>
                  <bean:write name='scheduleItem' property='checkSite'/>
                 </td>
             </tr>
           
              <tr>
                <td class="title" >������Ϣ:</td>
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
            <!--ȡ����ť-->
            <input type="button" name=buttonCancel class='button' value="����" onclick="history.back();" >
          </td>
      </tr>
    </table>
 </form>   

</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
