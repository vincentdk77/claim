<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
<head>
<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<html:form action="/processPrpDcustomerIdv.do?actionType=query">
<html:hidden property="rowsPerPage"/>
<html:hidden property="taskCode"/>
<html:hidden property="groupCode"/>
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="35"><img src="/claim/images/imgPrpDcustomerIdv.gif">
    </td>
  </tr>
  <tr>
  <td align="center" valign="top">
      <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr>
          <td colspan="4" align="center" class="top"><strong>����PrpDcustomerIdv</strong></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvCustomerCode" type="text" class="common"></td>
          <td width="20%" class="page">�ٲ������룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvShortHandCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ��������ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvCustomerCName" type="text" class="common"></td>
          <td width="20%" class="page">�ͻ�Ӣ�����ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvCustomerEName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">��ַ�������ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvAddressCName" type="text" class="common"></td>
          <td width="20%" class="page">��ַӢ�����ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvAddressEName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">֤�����ͣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvIdentifyType" type="text" class="common"></td>
          <td width="20%" class="page">֤�����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvIdentifyNumber" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">���ŵȼ���</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvCreditLevel" type="text" class="common"></td>
          <td width="20%" class="page">�Ա�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvSex" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">���䣺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvAge" type="text" class="common"></td>
          <td width="20%" class="page">����״����</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvHealth" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">ְҵ���룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvOccupationCode" type="text" class="common"></td>
          <td width="20%" class="page">ѧ�����룺</td>
          <td width="30%" class="page">
           <input type="text" class="codecode" name="prpDcustomerIdvEducationCode"
              value="<bean:write name="prpDcustomerIdvDto" property="educationCode" />"
              ondblclick="code_CodeSelect(this,'EducationCode','0','Y');"
              onkeyup="code_CodeSelect(this,'EducationCode','0','Y');"
              onchange="code_CodeChange(this,'EducationCode','0','Y');">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">������λ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvUnit" type="text" class="common"></td>
          <td width="20%" class="page">��λ��ַ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvUnitAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����ͣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvCustomerKind" type="text" class="common"></td>
          <td width="20%" class="page">�ͻ���־��</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerIdvDto" property="customerFlag" styleClass="one">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�绰��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvPhoneNumber" type="text" class="common"></td>
          <td width="20%" class="page">���棺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvFaxNumber" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ֻ���</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvMobile" type="text" class="common"></td>
          <td width="20%" class="page">ͨ�ŵ�ַ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvLinkAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ʱࣺ</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvPostCode" type="text" class="common"></td>
          <td width="20%" class="page">������</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvPager" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������䣺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvEmail" type="text" class="common"></td>
          <td width="20%" class="page">�������У�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvBank" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�����ʺţ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvAccount" type="text" class="common"></td>
          <td width="20%" class="page">����ʱ�䣺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvDeathDate" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">��������־��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvBlackState" type="text" class="common"></td>
          <td width="20%" class="page">�µĿͻ����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvNewCustomerCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">Ч��״̬��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvValidStatus" type="text" class="common"></td>
          <td width="20%" class="page">ר����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvArticleCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvBirthday" type="text" class="common"></td>
          <td width="20%" class="page">��ַ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvNetAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">����ҵ��Ա���룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvHandlerCode" type="text" class="common"></td>
          <td width="20%" class="page">����Ա���룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvOperatorCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvInputDate" type="text" class="common"></td>
          <td width="20%" class="page">���һ���޸��ˣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvUpdaterCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�޸����ڣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvUpdateDate" type="text" class="common"></td>
          <td width="20%" class="page">�Ƿ�һ�����ˣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvFatherCodeFlag" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page">
           <input type="text" class="codecode" name="prpDcustomerIdvComcode"
              value="<bean:write name="prpDcustomerIdvDto" property="comcode" />"
              ondblclick="code_CodeSelect(this,'comCode','0,1','Y');"
              onkeyup="code_CodeSelect(this,'comCode','0,1','Y');"
              onchange="code_CodeChange(this,'comCode','0,1','Y');">
          </td>
          <td width="20%" class="page">�¼��鿴Ȩ�ޣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerIdvLowerViewFlag" type="text" class="common"></td>
        </tr>
      </table>
      &nbsp; <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td><a href="#" onclick="submitForm()"><img src="/claim/images/btnEnter.gif" width="75" height="20" border="0"></a></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<app:codeInput/>
</html:form>
 <jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
   function submitForm(){
      fm.submit();
   }
 </script>
</body>
</html>
