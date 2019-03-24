<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
<head>
<title>PrpDcustomerUnit</title>
</head>
<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="35"><img src="/claim/images/imgPrpDcustomerUnit.gif">
    </td>
  </tr>
  <tr>
    <td align="center" valign="top">
       <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr>
          <td colspan="4" align="center" class="top"><strong>PrpDcustomerUnit</strong></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerCode" /></td>
          <td width="20%" class="page">�ٲ������룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="shortHandCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ��������ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerCName" /></td>
          <td width="20%" class="page">�ͻ�Ӣ�����ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerEName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">��ַ�������ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="addressCName" /></td>
          <td width="20%" class="page">��ַӢ�����ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="addressEName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">ռ�����ʴ��룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="possessNature" /></td>
          <td width="20%" class="page">��ҵ���룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="businessSource" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�����ƴ��룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="businessSort" /></td>
          <td width="20%" class="page">�ͻ����ͣ�</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="customerKind" styleClass="one" disabled="true">
         	    <html:options  collection="customerKindFList" property="value" labelProperty="label"/>
          </html:select></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ���־��</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="customerFlag" styleClass="one" disabled="true">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select></td>
          <td width="20%" class="page">��֯�������룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="organizeCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">���ŵȼ���</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="creditLevel" /></td>
          <td width="20%" class="page">���˴���</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="leaderName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�绰��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="phoneNumber" /></td>
          <td width="20%" class="page">���棺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="faxNumber" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ֻ���</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="mobile" /></td>
          <td width="20%" class="page">��ַ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="netAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������䣺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="emailAddress" /></td>
          <td width="20%" class="page">ͨ�ŵ�ַ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="postAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ʱࣺ</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="postCode" /></td>
          <td width="20%" class="page">��ϵ�ˣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="linkerName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������У�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="bank" /></td>
          <td width="20%" class="page">�����ʺţ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="account" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">���̾��룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="industryCode" /></td>
          <td width="20%" class="page">��óί�룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="economyCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">��׼�����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="measureCode" /></td>
          <td width="20%" class="page">�ϼ����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="fatherCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">���������ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="sponsorName" /></td>
          <td width="20%" class="page">��Ӫ��Χ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="businessRange" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">ע���ʽ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="registFund" /></td>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="regionCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">��������־��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="blackState" /></td>
          <td width="20%" class="page">�µĿͻ����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="newCustomerCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">Ч��״̬��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="validStatus" /></td>
          <td width="20%" class="page">ר����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="articleCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ���ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerShortName" /></td>
          <td width="20%" class="page">�ڲ�Ա��������</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="employSum" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�Ƿ�ɶ���</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="shareHolderFlag" styleClass="one" disabled="true">
         	    <html:options  collection="shareHolderList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">��ҵ˰����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="revenueCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">ְҵ���յȼ���</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="careerRiskGrade" /></td>
          <td width="20%" class="page">����ҵ��Ա���룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="handlerCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">����Ա���룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="operatorCode" /></td>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="inputDate" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�޸��ˣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="updaterCode" /></td>
          <td width="20%" class="page">�޸����ڣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="updateDate" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�Ƿ�һ�����ˣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="topLevelFlag" /></td>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="comcode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�¼�����鿴��</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="lowerViewFlag" styleClass="one" disabled="true">
         	    <html:options  collection="lowerViewFList" property="value" labelProperty="label"/>
          </html:select></td>
          <td width="20%" class="page"></td>
          <td width="30%" class="page"></td>
        </tr>
      </table>
       &nbsp; <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td><a href="#" onclick="javascript:history.back();"><img src="/claim/images/btnBack.gif" width="75" height="20" border="0"></a></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html>
