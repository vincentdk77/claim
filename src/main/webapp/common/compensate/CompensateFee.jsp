<%--
****************************************************************************
* DESC       ���Ѿ�δ������
* AUTHOR     �� wangli 
* CREATEDATE �� 2005-05-31
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <title>
      �Ѿ�δ�����
    </title>
     <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>
<body>
  <table  class="common">
      <tr class=listtitle>
        <td>������</td>
        <td>�Ѿ����</td> 
        <td>δ�����</td>
      </tr> 


        <tr class=common>   
          <td align=right><bean:write name="compensateFeeDto" property="registNo"/></td>             
          <td align=right><bean:write name="compensateFeeDto" property="sumPaid"/></td>
          <td align=right><bean:write name="compensateFeeDto" property="sumNoPaid"/></td>
        </tr>              
  </table>        
  <table class=common> 
    <tr>
      <td align=center>
       <input type="button" value="�� ��" name = 'button_Peril_Close_Context' class="button" alt="�ر�" onclick="window.close();">  
      </td>
    </tr>
  </table> 
  </body>
  </html:html>  
 