<%--
****************************************************************************
* DESC       �����������ؿ���¼��ӡ��ӡҳ��
* AUTHOR     ��zhaozhuo
* CREATEDATE ��2005-04-13
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>


<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">
  <head>
    <title>���������ؿ���¼��ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
     <script LANGUAGE="JavaScript">
     <!--
      /**
       *@description ��ֵҳ���һЩ��ʼ����Ϣ
       *@param       ��
       *@return      ͨ������true,���򷵻�false
       */
      function initSet()
      {
        return true;
      }
     //-->
     </script>
  </head>


<body bgcolor="#FFFFFF" onload="initSet();">
    <form name="fm">
          </form>


          <p height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B> ���������ؿ���¼ </b></p>



    <table border="1" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" height="660" >
      <tr>
        <td width="50%" colspan="2" height="50">�������ˣ�
        <font width="50%" colspan="2" height="50" id="tdInsuredName">&nbsp;</font>
        </td>
               <td width="50%" height="50">�ؿ�ʱ�䣺&nbsp;&nbsp;&nbsp; ��&nbsp;&nbsp;&nbsp; ��&nbsp;&nbsp;&nbsp;
               ��</td>
      </tr>
      <tr>
        <td width="25%" height="50">���ƺţ�
          <font width="25%" height="50" id="tdLicenseNo">&nbsp;</td>
        <td width="25%" height="50">����
           <font width="25%" height="50" id="tdBrandName">&nbsp;</td>
        <td width="50%" height="50">��ĳ�&nbsp;&nbsp;
        <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        �����߳�&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"> </td>
      </tr>
      <tr>
        <td width="100%" colspan="3" height="261">��<p>�ؿ������ </p>
          <p>A�����ް���ͬԼ�����������Ŀ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          ȫ��&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          ����&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"></p>
          <p>B: ���ް���ͬԼ�����������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          ����&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          ��ͬ�涨&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          ����&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"></p>
          <p>C:&nbsp; ���ް���ͬԼ��ά����Ŀά��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          ȫ��&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          ����&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"> </p>
          <p>D:&nbsp; δ����ͬԼ��������������Ƽ����</p>
          <p>E:&nbsp; δ����ͬԼ��ά�޵���Ŀ���Ƽ����</p>
          <p>��
         </td>
      </tr>
      <tr>
         <td width="100%" colspan="3" height="156">
           ��<p>������Ա��������� </p>
           <p>��</p>
           <p>�ؿ���Աǩ�֣�</p>
           <p style="text-align:right">��&nbsp;&nbsp;&nbsp; ��&nbsp;&nbsp;&nbsp; ��
         </td>
      </tr>
      <tr>
        <td width="100%" colspan="3" height="156">��<p>���޳�ȷ������� </p>
          <p>��</p>
          <p>ǩ�£�</p>
          <p style="text-align:right">��&nbsp;&nbsp;&nbsp; ��&nbsp;&nbsp;&nbsp; ��
        </td>
      </tr>
    </table>

    <p>����¼���ڲ���ת����Ϊ�������ݹ鵵��</p>



 <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </form>
  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />

    </b>
</html>