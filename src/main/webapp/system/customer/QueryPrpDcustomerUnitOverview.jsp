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
<html:form action="/processPrpDcustomerUnit.do?actionType=query">
<html:hidden property="rowsPerPage"/>
<html:hidden property="taskCode"/>
<html:hidden property="groupCode"/>
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="35"><img src="/claim/images/imgPrpDcustomerUnit.gif">
    </td>
  </tr>
  <tr>
  <td align="center" valign="top">
      <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr>
          <td colspan="4" align="center" class="top"><strong>����PrpDcustomerUnit</strong></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerCode" type="text" class="common"></td>
          <td width="20%" class="page">�ٲ������룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitShortHandCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ��������ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerCName" type="text" class="common"></td>
          <td width="20%" class="page">�ͻ�Ӣ�����ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerEName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">��ַ�������ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitAddressCName" type="text" class="common"></td>
          <td width="20%" class="page">��ַӢ�����ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitAddressEName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">ռ�����ʴ��룺</td>
          <td width="30%" class="page">
           <input type="text" class="codecode" name="prpDcustomerUnitPossessNature"
              value="<bean:write name="prpDcustomerUnitDto" property="possessNature" />"
              ondblclick="code_CodeSelect(this,'PossessNature','0','Y');"
              onkeyup="code_CodeSelect(this,'PossessNature','0','Y');"
              onchange="code_CodeChange(this,'PossessNature','0','Y');">  </td>
          <td width="20%" class="page">��ҵ���룺</td>
          <td width="30%" class="page">
          <input type="text" class="codecode" name="prpDcustomerUnitBusinessSource"
              value="<bean:write name="prpDcustomerUnitDto" property="businessSource" />"
              ondblclick="code_CodeSelect(this,'BusinessSource','0','Y');"
              onkeyup="code_CodeSelect(this,'BusinessSource','0','Y');"
              onchange="code_CodeChange(this,'BusinessSource','0','Y');">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�����ƴ��룺</td>
          <td width="30%" class="page">
          <input type="text" class="codecode" name="prpDcustomerUnitBusinessSort"
              value="<bean:write name="prpDcustomerUnitDto" property="businessSort" />"
              ondblclick="code_CodeSelect(this,'BusinessSort','0','Y');"
              onkeyup="code_CodeSelect(this,'BusinessSort','0','Y');"
              onchange="code_CodeChange(this,'BusinessSort','0','Y');">
          </td>
          <td width="20%" class="page">�ͻ����ͣ�</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="customerKind" styleClass="one">
         	    <html:options  collection="customerKindFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ���־��</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="customerFlag" styleClass="one">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">��֯�������룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitOrganizeCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">���ŵȼ���</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCreditLevel" type="text" class="common"></td>
          <td width="20%" class="page">���˴���</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitLeaderName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�绰��</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitPhoneNumber" type="text" class="common"></td>
          <td width="20%" class="page">���棺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitFaxNumber" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ֻ���</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitMobile" type="text" class="common"></td>
          <td width="20%" class="page">��ַ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitNetAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������䣺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitEmailAddress" type="text" class="common"></td>
          <td width="20%" class="page">ͨ�ŵ�ַ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitPostAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ʱࣺ</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitPostCode" type="text" class="common"></td>
          <td width="20%" class="page">��ϵ�ˣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitLinkerName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������У�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitBank" type="text" class="common"></td>
          <td width="20%" class="page">�����ʺţ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitAccount" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">���̾��룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitIndustryCode" type="text" class="common"></td>
          <td width="20%" class="page">��óί�룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitEconomyCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">��׼�����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitMeasureCode" type="text" class="common"></td>
          <td width="20%" class="page">�ϼ����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitFatherCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">���������ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitSponsorName" type="text" class="common"></td>
          <td width="20%" class="page">��Ӫ��Χ��</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitBusinessRange" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">ע���ʽ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitRegistFund" type="text" class="common"></td>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitRegionCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">��������־��</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitBlackState" type="text" class="common"></td>
          <td width="20%" class="page">�µĿͻ����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitNewCustomerCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">Ч��״̬��</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitValidStatus" type="text" class="common"></td>
          <td width="20%" class="page">ר����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitArticleCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ���ƣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerShortName" type="text" class="common"></td>
          <td width="20%" class="page">�ڲ�Ա��������</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitEmploySum" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�Ƿ�ɶ���</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="shareHolderFlag" styleClass="one">
         	    <html:options  collection="shareHolderList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">��ҵ˰����룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitRevenueCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">ְҵ���յȼ���</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitWordRiskRank" type="text" class="common"></td>
          <td width="20%" class="page">����ҵ��Ա���룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitHandlerCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">����Ա���룺</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitOperatorCode" type="text" class="common"></td>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitInputDate" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�޸��ˣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitUpdaterCode" type="text" class="common"></td>
          <td width="20%" class="page">�޸����ڣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitUpdateDate" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">�Ƿ�һ�����ˣ�</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitFatherCodeFlag" type="text" class="common"></td>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page">
           <input type="text" class="codecode" name="prpDcustomerUnitComcode"
              value="<bean:write name="prpDcustomerUnitDto" property="comcode" />"
              ondblclick="code_CodeSelect(this,'comCode','0,1','Y');"
              onkeyup="code_CodeSelect(this,'comCode','0,1','Y');"
              onchange="code_CodeChange(this,'comCode','0,1','Y');">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�¼�����鿴��</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="lowerViewFlag" styleClass="one">
         	    <html:options  collection="lowerViewFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page"></td>
          <td width="30%" class="page"></td>
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
