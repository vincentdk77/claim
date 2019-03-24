<%--
 *************************************************************************
 * 程序名称: Welcome.jsp
 * 程序功能: 欢迎页面
 * 最近更新人: weishixin
 * 最近更新日期: 2004-03-29
 ****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html>
    <head>
        <title>        </title>
       
        <link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
    </head>
    <body >
         
<!--
              <table border="0" class=common cellpadding="5" cellspacing="1" align=center style="width:70%">
                <tr class=listtitle>
                    <td colspan="2" >信息项</td>
                </tr>
                <tr > 
                  <td  align="left" class="title2">待处理(包括回退处理)：<br> 
                  </td>
                  <td   class="input2">目前您有<strong>　<a href="/claim/wfLogQuery.do?status=0&editType=welcome"><font color="#FF0000"><bean:write name="statStatusDto"  property="waitStatusCount"/></font></a></strong>　项目待处理！</td>
                </tr>
                <tr > 
                  <td  align="left" class="title2">正在处理：<br>
                  </td>
                  <td   class="input2">目前您有<strong>　<a href="/claim/wfLogQuery.do?status=2&editType=welcome"><font color="#FF0000"><bean:write name="statStatusDto"  property="procStatusCount"/></font></a></strong>　项目正在处理！</td>
                </tr>
                <tr > 
                  <td  align="left" class="title2">回退处理：<br>
                  </td>
                  <td   class="input2">目前您有<strong>　<a href="/claim/wfLogQuery.do?status=3&editType=welcome"><font color="#FF0000"><bean:write name="statStatusDto"  property="noSubmitStatusCount"/></font></a></strong>　项目已处理未提交！</td>
                </tr>
                <tr > 
                  <td  align="left" class="title2">已提交：<br>
                  </td>
                  <td   class="input2">目前您有<strong>　<a href="/claim/wfLogQuery.do?status=4&editType=welcome"><font color="#FF0000"><bean:write name="statStatusDto"  property="submitStatusCount"/></font></a></strong>　项目已提交！</td>
                </tr>
                <tr > 
                  <td  align="left" class="title2">已回退：<br>
                  </td>
                  <td   class="input2">目前您有<strong>　<a href="/claim/wfLogQuery.do?status=5&editType=welcome"><font color="#FF0000"><bean:write name="statStatusDto"  property="backStatusCount"/></font></a></strong>　项目处于回退！</td>
                </tr>
                
                </table>
-->              
        
    </body>
</html>
