<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDcustomerUnitDto" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDcompanyDto" %>
<%@page import="com.sinosoft.platform.bl.facade.*" %>
<%@ page import="java.util.*"%>
<html>
<head>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <script language="javascript">
    function submitFormToSave()
    {
      if(!validateForm(fm))
      {
        return false;
      }

      fm.submit();

      return true;
    }
  </script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();">
<form name="fm" method="post" action="/claim/processPrpDcustomerUnit.do" onsubmit="return validateForm(this,'CustomerUnit','');">
<input type="hidden" name="actionType" value="<%=request.getParameter("actionType")%>">
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0" id="CustomerUnit">

  <tr>
    <td align="center" valign="top"> <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr>
          <td colspan="4" align="center" class="top"><strong>�༭��ҵ�ͻ�����</strong></td>
        </tr>
<%
    if(request.getParameter("actionType").equals("insert")){
%>
        <tr>
          <td width="20%" class="page">�ͻ����룺</td>
          <td width="30%" class="page">

          </td>
          <td width="20%" class="page"></td>
          <td width="30%" class="page">
          </td>
        </tr>
<%
    }else{
%>
        <tr>
          <td width="20%" class="page">�ͻ����룺</td>
          <td width="30%" class="page">
            <bean:write name="prpDcustomerUnitDto" property="customerCode" />
            <input type="hidden" name="prpDcustomerUnitCustomerCode" value="<bean:write name="prpDcustomerUnitDto" property="customerCode" />">
          </td>
          <td width="20%" class="page"></td>
          <td width="30%" class="page">
          </td>
        </tr>
<%
    }
%>
        <tr>
          <td width="20%" class="page">�ٲ������룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitShortHandCode" value="<bean:write name="prpDcustomerUnitDto" property="shortHandCode" />">
          </td>
          <td width="20%" class="page">�ͻ��������ƣ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitCustomerCName" value="<bean:write name="prpDcustomerUnitDto" property="customerCName" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ�Ӣ�����ƣ�</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitCustomerEName" value="<bean:write name="prpDcustomerUnitDto" property="customerEName" />">
          </td>
          <td width="20%" class="page">��ַ�������ƣ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitAddressCName" value="<bean:write name="prpDcustomerUnitDto" property="addressCName" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��ַӢ�����ƣ�</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitAddressEName" value="<bean:write name="prpDcustomerUnitDto" property="addressEName" />">
          </td>
          <td width="20%" class="page">ռ�����ʴ��룺</td>
          <td width="30%" class="page">
          <input type="text" class="codecode" name="prpDcustomerUnitPossessNature" style="width:30%"
              value="<bean:write name='prpDcustomerUnitDto' property='possessNature' />"
              ondblclick="code_CodeSelect(this,'PossessNature');"
              onkeyup="code_CodeSelect(this,'PossessNature');"
              >&nbsp;&nbsp;<input class='readonly' value="<bean:write name="prpDcustomerUnitDto" property="possessNatureName" />"  
                                        name="prpDcustomerUnitPossessNatureName" style="width:50%">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��ҵ���룺</td>
          <td width="30%" class="page">
          <input type="text" class="codecode" name="prpDcustomerUnitBusinessSource" style="width:30%"
              value="<bean:write name="prpDcustomerUnitDto" property="businessSource" />"
              ondblclick="code_CodeSelect(this,'BusinessSource');"
              onkeyup="code_CodeSelect(this,'BusinessSource');"
          >&nbsp;&nbsp;<input class='readonly'  name="prpDcustomerUnitBusinessSourceName" 
               value="<bean:write name="prpDcustomerUnitDto" property="businessSourceName" />" style="width:50%">
          </td>
          <td width="20%" class="page">�����ƴ��룺</td>
          <td width="30%" class="page">
            <input type="text" class="codecode" name="prpDcustomerUnitBusinessSort" style="width:30%"
              value="<bean:write name="prpDcustomerUnitDto" property="businessSort" />"
              ondblclick="code_CodeSelect(this,'BusinessSort');"
              onkeyup="code_CodeSelect(this,'BusinessSort');"
            >&nbsp;&nbsp;<input class='readonly'  name="businessSortName" 
                         value="<bean:write name="prpDcustomerUnitDto" property="businessSortName" />" style="width:50%">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�ͻ����ͣ�</td>
          <td width="30%" class="page">
          <html:select name="prpDcustomerUnitDto" property="customerKind" styleClass="one">
         	    <html:options  collection="customerKindFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
          <td width="20%" class="page">�ͻ���־��</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="customerFlag" styleClass="one">
         	    <html:options  collection="customerFlagFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��֯�������룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitOrganizeCode" value="<bean:write name="prpDcustomerUnitDto" property="organizeCode" />">
          </td>
          <td width="20%" class="page">���ŵȼ���</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitCreditLevel" value="<bean:write name="prpDcustomerUnitDto" property="creditLevel" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">���˴���</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitLeaderName" value="<bean:write name="prpDcustomerUnitDto" property="leaderName" />">
          </td>
          <td width="20%" class="page">�绰��</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitPhoneNumber" value="<bean:write name="prpDcustomerUnitDto" property="phoneNumber" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">���棺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitFaxNumber" value="<bean:write name="prpDcustomerUnitDto" property="faxNumber" />">
          </td>
          <td width="20%" class="page">�ֻ���</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitMobile" value="<bean:write name="prpDcustomerUnitDto" property="mobile" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��ַ��</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitNetAddress" value="<bean:write name="prpDcustomerUnitDto" property="netAddress" />">
          </td>
          <td width="20%" class="page">�������䣺</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitEmailAddress" value="<bean:write name="prpDcustomerUnitDto" property="emailAddress" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">ͨ�ŵ�ַ��</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitPostAddress" value="<bean:write name="prpDcustomerUnitDto" property="postAddress" />">
          </td>
          <td width="20%" class="page">�ʱࣺ</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitPostCode" value="<bean:write name="prpDcustomerUnitDto" property="postCode" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��ϵ�ˣ�</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitLinkerName" value="<bean:write name="prpDcustomerUnitDto" property="linkerName" />">
          </td>
          <td width="20%" class="page">�������У�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitBank" value="<bean:write name="prpDcustomerUnitDto" property="bank" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�����ʺţ�</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitAccount" value="<bean:write name="prpDcustomerUnitDto" property="account" />">
          </td>
          <td width="20%" class="page">���̾��룺</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitIndustryCode" value="<bean:write name="prpDcustomerUnitDto" property="industryCode" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��óί�룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitEconomyCode" value="<bean:write name="prpDcustomerUnitDto" property="economyCode" />">
          </td>
          <td width="20%" class="page">��׼�����룺</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitMeasureCode" value="<bean:write name="prpDcustomerUnitDto" property="measureCode" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�ϼ����룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitFatherCode" value="<bean:write name="prpDcustomerUnitDto" property="fatherCode" />">
          </td>
          <td width="20%" class="page">���������ƣ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitSponsorName" value="<bean:write name="prpDcustomerUnitDto" property="sponsorName" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��Ӫ��Χ��</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitBusinessRange" value="<bean:write name="prpDcustomerUnitDto" property="businessRange" />">
          </td>
          <td width="20%" class="page">ע���ʽ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitRegistFund" value="<bean:write name="prpDcustomerUnitDto" property="registFund" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�����������룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitRegionCode" value="<bean:write name="prpDcustomerUnitDto" property="regionCode" />">
          </td>
          <td width="20%" class="page">��������־��</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitBlackState" value="<bean:write name="prpDcustomerUnitDto" property="blackState" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�µĿͻ����룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitNewCustomerCode" value="<bean:write name="prpDcustomerUnitDto" property="newCustomerCode" />"><img src="/claim/images/imgMustInput.gif"/>
          </td>
          <td width="20%" class="page">Ч��״̬��</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitValidStatus" value="<bean:write name="prpDcustomerUnitDto" property="validStatus" />"><img src="/claim/images/imgMustInput.gif"/>
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">ר����룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitArticleCode" value="<bean:write name="prpDcustomerUnitDto" property="articleCode" />">
          </td>
          <td width="20%" class="page">�ͻ���ƣ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitCustomerShortName" value="<bean:write name="prpDcustomerUnitDto" property="customerShortName" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�ڲ�Ա��������</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitEmploySum" value="<bean:write name="prpDcustomerUnitDto" property="employSum" />">
          </td>
          <td width="20%" class="page">�Ƿ�ɶ���</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="shareHolderFlag" styleClass="one">
         	    <html:options  collection="shareHolderList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">��ҵ˰����룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitRevenueCode" value="<bean:write name="prpDcustomerUnitDto" property="revenueCode" />">
          </td>
          <td width="20%" class="page">ְҵ���յȼ���</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitWordRiskRank" value="<bean:write name="prpDcustomerUnitDto" property="careerRiskGrade" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">����ҵ��Ա���룺</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitHandlerCode" value="<bean:write name="prpDcustomerUnitDto" property="handlerCode" />">
          </td>
          <td width="20%" class="page">����Ա���룺</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitOperatorCode" value="<bean:write name="prpDcustomerUnitDto" property="operatorCode" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�������ڣ�</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitInputDate" value="<bean:write name="prpDcustomerUnitDto" property="inputDate" />">
          </td>
          <td width="20%" class="page">�޸��ˣ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitUpdaterCode" value="<bean:write name="prpDcustomerUnitDto" property="updaterCode" />">
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�޸����ڣ�</td>
          <td width="30%" class="page">
             <input type="text" class="common" name="prpDcustomerUnitUpdateDate" value="<bean:write name="prpDcustomerUnitDto" property="updateDate" />">
          </td>
          <td width="20%" class="page">�Ƿ�һ�����ˣ�</td>
          <td width="30%" class="page">
            <input type="text" class="common" name="prpDcustomerUnitTopLevelFlag" value="<bean:write name="prpDcustomerUnitDto" property="topLevelFlag" />">            
          </td>
        </tr>
        <tr>
          <td width="20%" class="page">�����������룺</td>
          <td width="35%" class="input">
             <select class="common" name="prpDcustomerUnitComcode">
             <%
             PrpDcustomerUnitDto prpDcustomerUnitDto = (PrpDcustomerUnitDto)request.getAttribute("prpDcustomerUnitDto");
             BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
             Collection comCodeCollection = blPrpDcompanyFacade.findByConditions( " 1=1 ");
             if(comCodeCollection !=null){
               for(Iterator iterator = comCodeCollection.iterator();iterator.hasNext();){
                   PrpDcompanyDto prpDcompanyDto= (PrpDcompanyDto)iterator.next();
                %>
                   <option value="<%=prpDcompanyDto.getComCode()%>"     
                 <%
                    if(prpDcompanyDto.getComCode().equals(prpDcustomerUnitDto.getComcode())){out.print("selected");}
                  %>
                     ><%= prpDcompanyDto.getComCode()%>-<%= prpDcompanyDto.getComCName()%></option>
                 <%
                 }
               }
            %>
             </select>
          </td>
          <td width="20%" class="page">�¼�����鿴��</td>
          <td width="30%" class="page">
           <html:select name="prpDcustomerUnitDto" property="lowerViewFlag" styleClass="one">
         	    <html:options  collection="lowerViewFList" property="value" labelProperty="label"/>
          </html:select>
          </td>
        </tr>
      </table>

     <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td><input type="button" class="button" value="�� ��" src="/claim/images/btnSave.gif" onclick="return submitFormToSave(fm,'','')" width="75" height="20" border="0">
          </td>
        </tr>
      </table></td>
  </tr>
</table>
<app:codeInput/>

</form>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html>
