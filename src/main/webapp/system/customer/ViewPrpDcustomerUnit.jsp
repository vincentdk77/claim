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
          <td width="20%" class="page">客户代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerCode" /></td>
          <td width="20%" class="page">速查索引码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="shortHandCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">客户中文名称：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerCName" /></td>
          <td width="20%" class="page">客户英文名称：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerEName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">地址中文名称：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="addressCName" /></td>
          <td width="20%" class="page">地址英文名称：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="addressEName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">占用性质代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="possessNature" /></td>
          <td width="20%" class="page">行业代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="businessSource" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">所有制代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="businessSort" /></td>
          <td width="20%" class="page">客户类型：</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="customerKind" styleClass="one" disabled="true">
         	    <html:options  collection="customerKindFList" property="value" labelProperty="label"/>
          </html:select></td>
        </tr>
        <tr>
          <td width="20%" class="page">客户标志：</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="customerFlag" styleClass="one" disabled="true">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select></td>
          <td width="20%" class="page">组织机构代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="organizeCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">资信等级：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="creditLevel" /></td>
          <td width="20%" class="page">法人代表：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="leaderName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">电话：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="phoneNumber" /></td>
          <td width="20%" class="page">传真：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="faxNumber" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">手机：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="mobile" /></td>
          <td width="20%" class="page">网址：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="netAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">电子信箱：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="emailAddress" /></td>
          <td width="20%" class="page">通信地址：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="postAddress" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">邮编：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="postCode" /></td>
          <td width="20%" class="page">联系人：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="linkerName" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">开户银行：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="bank" /></td>
          <td width="20%" class="page">开户帐号：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="account" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">工商局码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="industryCode" /></td>
          <td width="20%" class="page">经贸委码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="economyCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">标准计量码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="measureCode" /></td>
          <td width="20%" class="page">上级代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="fatherCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">主管人名称：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="sponsorName" /></td>
          <td width="20%" class="page">经营范围：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="businessRange" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">注册资金：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="registFund" /></td>
          <td width="20%" class="page">行政区划编码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="regionCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">黑名单标志：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="blackState" /></td>
          <td width="20%" class="page">新的客户代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="newCustomerCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">效力状态：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="validStatus" /></td>
          <td width="20%" class="page">专项代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="articleCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">客户简称：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="customerShortName" /></td>
          <td width="20%" class="page">在册员工人数：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="employSum" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">是否股东：</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="shareHolderFlag" styleClass="one" disabled="true">
         	    <html:options  collection="shareHolderList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">企业税务代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="revenueCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">职业风险等级：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="careerRiskGrade" /></td>
          <td width="20%" class="page">归属业务员代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="handlerCode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">操作员代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="operatorCode" /></td>
          <td width="20%" class="page">输入日期：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="inputDate" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">修改人：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="updaterCode" /></td>
          <td width="20%" class="page">修改日期：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="updateDate" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">是否一级法人：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="topLevelFlag" /></td>
          <td width="20%" class="page">归属机构代码：</td>
          <td width="30%" class="page"><bean:write name="prpDcustomerUnitDto" property="comcode" /></td>
        </tr>
        <tr>
          <td width="20%" class="page">下级允许查看：</td>
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
