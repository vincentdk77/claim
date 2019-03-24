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
          <td colspan="4" align="center" class="top"><strong>搜索PrpDcustomerUnit</strong></td>
        </tr>
        <tr>
          <td width="20%" class="page">客户代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerCode" type="text" class="common"></td>
          <td width="20%" class="page">速查索引码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitShortHandCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">客户中文名称：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerCName" type="text" class="common"></td>
          <td width="20%" class="page">客户英文名称：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerEName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">地址中文名称：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitAddressCName" type="text" class="common"></td>
          <td width="20%" class="page">地址英文名称：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitAddressEName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">占用性质代码：</td>
          <td width="30%" class="page">
           <input type="text" class="codecode" name="prpDcustomerUnitPossessNature"
              value="<bean:write name="prpDcustomerUnitDto" property="possessNature" />"
              ondblclick="code_CodeSelect(this,'PossessNature','0','Y');"
              onkeyup="code_CodeSelect(this,'PossessNature','0','Y');"
              onchange="code_CodeChange(this,'PossessNature','0','Y');">  </td>
          <td width="20%" class="page">行业代码：</td>
          <td width="30%" class="page">
          <input type="text" class="codecode" name="prpDcustomerUnitBusinessSource"
              value="<bean:write name="prpDcustomerUnitDto" property="businessSource" />"
              ondblclick="code_CodeSelect(this,'BusinessSource','0','Y');"
              onkeyup="code_CodeSelect(this,'BusinessSource','0','Y');"
              onchange="code_CodeChange(this,'BusinessSource','0','Y');">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">所有制代码：</td>
          <td width="30%" class="page">
          <input type="text" class="codecode" name="prpDcustomerUnitBusinessSort"
              value="<bean:write name="prpDcustomerUnitDto" property="businessSort" />"
              ondblclick="code_CodeSelect(this,'BusinessSort','0','Y');"
              onkeyup="code_CodeSelect(this,'BusinessSort','0','Y');"
              onchange="code_CodeChange(this,'BusinessSort','0','Y');">
          </td>
          <td width="20%" class="page">客户类型：</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="customerKind" styleClass="one">
         	    <html:options  collection="customerKindFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">客户标志：</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="customerFlag" styleClass="one">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">组织机构代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitOrganizeCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">资信等级：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCreditLevel" type="text" class="common"></td>
          <td width="20%" class="page">法人代表：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitLeaderName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">电话：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitPhoneNumber" type="text" class="common"></td>
          <td width="20%" class="page">传真：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitFaxNumber" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">手机：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitMobile" type="text" class="common"></td>
          <td width="20%" class="page">网址：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitNetAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">电子信箱：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitEmailAddress" type="text" class="common"></td>
          <td width="20%" class="page">通信地址：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitPostAddress" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">邮编：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitPostCode" type="text" class="common"></td>
          <td width="20%" class="page">联系人：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitLinkerName" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">开户银行：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitBank" type="text" class="common"></td>
          <td width="20%" class="page">开户帐号：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitAccount" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">工商局码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitIndustryCode" type="text" class="common"></td>
          <td width="20%" class="page">经贸委码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitEconomyCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">标准计量码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitMeasureCode" type="text" class="common"></td>
          <td width="20%" class="page">上级代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitFatherCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">主管人名称：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitSponsorName" type="text" class="common"></td>
          <td width="20%" class="page">经营范围：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitBusinessRange" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">注册资金：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitRegistFund" type="text" class="common"></td>
          <td width="20%" class="page">行政区划编码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitRegionCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">黑名单标志：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitBlackState" type="text" class="common"></td>
          <td width="20%" class="page">新的客户代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitNewCustomerCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">效力状态：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitValidStatus" type="text" class="common"></td>
          <td width="20%" class="page">专项代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitArticleCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">客户简称：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitCustomerShortName" type="text" class="common"></td>
          <td width="20%" class="page">在册员工人数：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitEmploySum" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">是否股东：</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="shareHolderFlag" styleClass="one">
         	    <html:options  collection="shareHolderList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">企业税务代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitRevenueCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">职业风险等级：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitWordRiskRank" type="text" class="common"></td>
          <td width="20%" class="page">归属业务员代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitHandlerCode" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">操作员代码：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitOperatorCode" type="text" class="common"></td>
          <td width="20%" class="page">输入日期：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitInputDate" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">修改人：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitUpdaterCode" type="text" class="common"></td>
          <td width="20%" class="page">修改日期：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitUpdateDate" type="text" class="common"></td>
        </tr>
        <tr>
          <td width="20%" class="page">是否一级法人：</td>
          <td width="30%" class="page"> <input name="prpDcustomerUnitFatherCodeFlag" type="text" class="common"></td>
          <td width="20%" class="page">归属机构代码：</td>
          <td width="30%" class="page">
           <input type="text" class="codecode" name="prpDcustomerUnitComcode"
              value="<bean:write name="prpDcustomerUnitDto" property="comcode" />"
              ondblclick="code_CodeSelect(this,'comCode','0,1','Y');"
              onkeyup="code_CodeSelect(this,'comCode','0,1','Y');"
              onchange="code_CodeChange(this,'comCode','0,1','Y');">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">下级允许查看：</td>
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
