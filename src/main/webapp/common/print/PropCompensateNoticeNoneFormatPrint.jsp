<%--

****************************************************************************

* DESC       �����֪ͨ��

* AUTHOR     ��dongchengliang

* CREATEDATE ��2005-6-16

* MODIFYLIST ��   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>

<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 

<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto"%> 



<%-- ��ʼ�� --%>

<% 

    DateTime currentDate = new DateTime().current();

    DateTime damageStartDate = new DateTime();

    PrpLclaimDto prpLclaimDto =(PrpLclaimDto)request.getAttribute("prpLclaimDto");

    String damageStartYear = "";

    String damageStartMonth = "";

    String damageStartDay = "";

    String damageStartHour = "";

    String damageStartMinute = "";

    if(prpLclaimDto != null){

      damageStartDate = prpLclaimDto.getDamageStartDate();

      String strDamageStartDate = damageStartDate.toString();

      if(damageStartDate != null){

        damageStartYear = strDamageStartDate.substring(0,strDamageStartDate.indexOf("-")) ;

        strDamageStartDate = strDamageStartDate.substring(strDamageStartDate.indexOf("-")+1) ;

        damageStartMonth = strDamageStartDate.substring(0,strDamageStartDate.indexOf("-")) ;

        damageStartDay = strDamageStartDate.substring(strDamageStartDate.indexOf("-")+1) ;

        damageStartYear =String.valueOf(damageStartDate.getYear());

        damageStartMonth = String.valueOf(damageStartDate.getMonth());

        damageStartDay = String.valueOf(damageStartDate.getDay());

      }

    }





%>



<html>

  <head>

    <title>��  ��  ͨ  ֪  ��</title>

    <link rel="stylesheet" type="text/css" href="Standard.css">

  </head>



  <body bgcolor="#FFFFFF">

    <!-- ���ⲿ�� -->

    

    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:16pt;">

          <B> �Ʋ����չɷ����޹�˾ <B>

        </td>

      </tr>

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:12pt;">

          <B>��&nbsp;&nbsp;��&nbsp;&nbsp;ͨ&nbsp;&nbsp;֪&nbsp;&nbsp;�� <B>

        </td>

      </tr>

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:10pt;">

          �����տλ���棩

        </td>

      </tr>

    </table>                                                                                             

<table border=1 width="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;"> 

  <tr> 

    <td width="100%" colspan="3" >�𾴵ı������ˣ� <bean:write name='prpLclaimDto' property='insuredName' filter='true'/></td>

  </tr>

  <tr> 

    <td width="100%" colspan="3" >&nbsp;&nbsp;&nbsp;������λ�������� <bean:write name='prpLclaimDto' property='riskCode' filter='true'/> ���𰸣� ���յ���Ϊ<bean:write name='prpLclaimDto' property='policyNo' filter='true'/>

    ��������Ϊ <%= damageStartYear %> �� <%= damageStartMonth %> �� <%= damageStartDay %>   �գ����յص�Ϊ <bean:write name='prpLclaimDto' property='damageAddress' filter='true'/> ���˰���˾���������Ϊ <bean:write name='prpLclaimDto' property='claimNo' filter='true'/> ��

    ��˾�յ�ԭʼ��Ʊ��  <bean:write name='prpLclaimDto' property='sumQuantity' filter='true'/>  �ţ���Ʊ���ϼ�Ϊ<bean:write name='prpLclaimDto' property='sumClaim' filter='true'/>   �����ҹ�˾��ˣ����ѽ᰸��ȷ����������/��Ԫ��    <bean:write name='prpLclaimDto' property='sumPaid' filter='true'/>     ��/ $  

    �Ͽ�������������վ�ǩ�º�ǰ����ȡ��<br>

     &nbsp;&nbsp;&nbsp;<br>

     &nbsp;&nbsp;&nbsp;<br>  

  </tr>

  <tr> 

    <td width="100%" colspan="3" align='right' > ������ǩ��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br></td>

  </tr>

  <tr> 

    <td width="100%" colspan="3" align='right' > ���� <%= String.valueOf(currentDate.getYear()) %>   �� <%= String.valueOf(currentDate.getMonth()) %>    ��  <%= String.valueOf(currentDate.getDay()) %>   ��<br></td>

  </tr>

  </tr>

  </tr>

  <!--include��ӡ��ť-->

  <jsp:include page="/common/print/PrintButton.jsp" />   

  </body>

</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        

                        