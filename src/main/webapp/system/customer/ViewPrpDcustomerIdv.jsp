<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
<head>
<title>PrpDcustomerIdv</title>
</head>
<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="35"><img src="/claim/images/imgPrpDcustomerIdv.gif">
    </td>
  </tr>
  <tr>
    <td align="center" valign="top">
       <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr>
          <td colspan="4" align="center" class="top"><strong>PrpDcustomerIdv</strong></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="customerCode" /></td>
          <td width="20%" class="page">�ٲ������룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="shortHandCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ��������ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="customerCName" /></td>
          <td width="20%" class="page">�ͻ�Ӣ�����ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="customerEName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">��ַ�������ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="addressCName" /></td>
          <td width="20%" class="page">��ַӢ�����ƣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="addressEName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">֤�����ͣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="identifyType" /></td>
          <td width="20%" class="page">֤�����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="identifyNumber" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">���ŵȼ���</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="creditLevel" /></td>
          <td width="20%" class="page">�Ա�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="sex" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">���䣺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="age" /></td>
          <td width="20%" class="page">����״����</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="health" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">ְҵ���룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="occupationCode" /></td>
          <td width="20%" class="page">ѧ�����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="educationCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">������λ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="unit" /></td>
          <td width="20%" class="page">��λ��ַ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="unitAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����ͣ�</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerIdvDto" property="customerKind" styleClass="one" disabled="true">
         	    <html:options  collection="customerKindFList" property="value" labelProperty="label"/>
          </html:select></td>
          <td width="20%" class="page">�ͻ���־��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="customerFlag" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�绰��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="phoneNumber" /></td>
          <td width="20%" class="page">���棺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="faxNumber" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ֻ���</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="mobile" /></td>
          <td width="20%" class="page">ͨ�ŵ�ַ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="linkAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�ʱࣺ</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="postCode" /></td>
          <td width="20%" class="page">������</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="pager" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������䣺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="email" /></td>
          <td width="20%" class="page">�������У�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="bank" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�����ʺţ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="account" /></td>
          <td width="20%" class="page">����ʱ�䣺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="deathDate" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">��������־��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="blackState" /></td>
          <td width="20%" class="page">�µĿͻ����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="newCustomerCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">Ч��״̬��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="validStatus" /></td>
          <td width="20%" class="page">ר����룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="articleCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="birthDate" /></td>
          <td width="20%" class="page">��ַ��</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="netAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">����ҵ��Ա���룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="handlerCode" /></td>
          <td width="20%" class="page">����Ա���룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="operatorCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="inputDate" /></td>
          <td width="20%" class="page">���һ���޸��ˣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="updaterCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�޸����ڣ�</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="updateDate" /></td>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerIdvDto" property="comcode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">�¼��鿴Ȩ�ޣ�</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerIdvDto" property="lowerViewFlag" styleClass="one" disabled="true">
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
