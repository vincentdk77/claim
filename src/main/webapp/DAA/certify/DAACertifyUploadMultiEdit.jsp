<%--
****************************************************************************
* DESC       �� ��Ψһ�����ϴ�����
* AUTHOR     �� liubvo
* CREATEDATE �� 2005-03-23
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>

<html>
  <head>
    <!--��title����-->
    <title>�ļ��ϴ�����</title>
    <%-- ҳ����ʽ  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  </head>

<body class=interface  onload="initPage();">
  <form name=fm action="/claim/certifySave.do" method="post" encType="multipart/form-data" onsubmit="return validateForm(this);">
  <table class="common" style="display:none" id="Certify_Data" cellspacing="1" cellpadding="5">
    <tbody>
      <tr>
        <td class="input">
          <input type="hidden" name="prpLcertifyImgBusinessNo">
          <input type="hidden" name="prpLcertifyImgSerialNo">
          <input type="hidden" name="prpLcertifyImgLossItemCode">
          <input type="hidden" name="prpLcertifyImgLossItemName">
          <input type="hidden" name="prpLcertifyImgTypeCode">
          <input type="hidden" name="prpLcertifyImgPicName">
          <input type="hidden" name="prpLcertifyImgSignInDate">
          <input type="hidden" name="prpLcertifyImgThirdPartyCode">
          <input type="hidden" name="prpLcertifyImgUploadFileName">
          <input type="hidden" name="prpLcertifyImgImgFileName">
          <input type="hidden" name="prpLcertifyImgPicPath">
          <input type="hidden" name="prpLcertifyImgCollectorName">
          <input type="hidden" name="prpLcertifyImgReceiveStatus">
          <input type="hidden" name="prpLcertifyImgFlag">
          <input type="hidden" name="prpLcertifyImgImgSize">
          <input type="hidden" name="prpLcertifyImgUploadNodeFlag">
          <input type="hidden" name="prpLcertifyImgPolicyNo">
        <td class="input">
          <input type="text" name="prpLcertifyImgDisplayName" style="width:240px">
        </td>
        <td class="input">
          <input name="fileUploadField" type="file" style="width:240px">
        </td>
        <td class="input">
          <input type="button" class=button name=buttonSave value="�鿴" onclick="">
        </td>
        <td class="input">
          <input type="button" class=button name=buttonSave value="�鿴" onclick="alert('�鿴�ļ�');return false;">
        </td>
        <td class="input" style='width:4%'  align="center">
        <div>
          <input type=button name="buttonCertifyDelete"  class=smallbutton onclick="deleteRow(this,'Certify')" value="-" style="cursor: hand">
        </div>
        </td>
      </tr>
    </tbody>
  </table>

  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >

    <tr>
      <td class="title" >��������:</td>
      <td class="input"  >
        <input type="text" name="RegistNo" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLcertifyImgDto' property='businessNo'/>">
      </td>
      <td class="title" >��������:</td>
      <td class="input"  >
        <input type="text" name="PolicyNo" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLcertifyImgDto' property='policyNo'/>">
      </td>
  </table>

  <span  id="spanCertify" style="display:" cellspacing="1" cellpadding="0">
     <%-- ��������չ���� --%>
     <table class="common" style="width:100%" id="Certify" cellspacing="1" cellspacing="1" >
       <thead>
         <tr>
           <td class="subformtitle" style="width:40%">��ص�֤˵��</td>
           <td class="subformtitle" style="width:40%">�ϴ�</td>
           <td class="subformtitle" style="width:6%">�鿴</td>
           <td class="subformtitle" style="width:4%" >&nbsp;</td>
         </tr>
       </thead>
       <tfoot>
         <tr>
            <td class="title" colspan=3 style="width:96%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
            <td class="title" align="right" style="width:4%">
               <div align="center">
                  <input type="button" class=smallbutton value="+" onclick="insertRow('Certify')" name="buttonCertifyInsert" style="cursor: hand">
               </div>
            </td>
        </tr>
      </tfoot>
      <tbody>
<logic:notEmpty  name="prpLcertifyImgDto"  property="certifyImgList">
  <logic:iterate id="ciList" name="prpLcertifyImgDto" property="certifyImgList">
    <logic:equal name="ciList" property="uploadNodeFlag" value="certi">
        <tr>
          <td class="input">
            <input type="hidden" name="prpLcertifyImgBusinessNo" value="<bean:write name='ciList' property='businessNo'/>">
            <input type="hidden" name="prpLcertifyImgSerialNo" value="<bean:write name='ciList' property='serialNo'/>">
            <input type="hidden" name="prpLcertifyImgLossItemCode" value="<bean:write name='ciList' property='lossItemCode'/>">
            <input type="hidden" name="prpLcertifyImgLossItemName" value="<bean:write name='ciList' property='lossItemName'/>">
            <input type="hidden" name="prpLcertifyImgTypeCode" value="<bean:write name='ciList' property='typeCode'/>">
            <input type="hidden" name="prpLcertifyImgPicName" value="<bean:write name='ciList' property='picName'/>">
            <input type="hidden" name="prpLcertifyImgSignInDate" value="<bean:write name='ciList' property='signInDate'/>">
            <input type="hidden" name="prpLcertifyImgThirdPartyCode" value="<bean:write name='ciList' property='thirdPartyCode'/>">
            <input type="hidden" name="prpLcertifyImgUploadFileName" value="<bean:write name='ciList' property='uploadFileName'/>">
            <input type="hidden" name="prpLcertifyImgImgFileName" value="<bean:write name='ciList' property='imgFileName'/>">
            <input type="hidden" name="prpLcertifyImgPicPath" value="<bean:write name='ciList' property='picPath'/>">
            <input type="hidden" name="prpLcertifyImgCollectorName" value="<bean:write name='ciList' property='collectorName'/>">
            <input type="hidden" name="prpLcertifyImgReceiveStatus" value="<bean:write name='ciList' property='receiveStatus'/>">
            <input type="hidden" name="prpLcertifyImgFlag" value="<bean:write name='ciList' property='flag'/>">
            <input type="hidden" name="prpLcertifyImgImgSize" value="<bean:write name='ciList' property='imgSize'/>">
            <input type="hidden" name="prpLcertifyImgUploadNodeFlag" value="<bean:write name='ciList' property='uploadNodeFlag'/>">
            <input type="hidden" name="prpLcertifyImgPolicyNo" value="<bean:write name='ciList' property='policyNo'/>">
            <input type="text" class="input" name="prpLcertifyImgDisplayName" style="width:300px" value="<bean:write name='ciList' property='displayName'/>">
          </td>
          <td class="input">
            <input name="fileUploadField" type="file" style="width:300px">
          </td>
          <td class="input">
            <input type="button" name=buttonSave class=button value="�鿴" onclick="">
          </td>
          <td class="input" style='width:4%'  align="center">
          <div>
            <input type=button name="buttonCertifyDelete"  class=smallbutton onclick="deleteRow(this,'Certify')" value="-" style="cursor: hand">
          </div>
          </td>
        </tr>
    </logic:equal>
  </logic:iterate>
</logic:notEmpty>
      </tbody>
    </table>
  </span>


  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>