<%--
****************************************************************************
* DESC       �����������嵥��ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2005-03-25
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.*"%>

<html>
  <head>
    <!--��title����-->
    <title>���������嵥</title>
    <%-- ҳ����ʽ  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  </head>


<body >
  <form name=fm action="/claim/certifySave.do" method="post">


  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr> <td class="formtitle" colspan=4>���������嵥</td></tr>
    <tr>
      <td class="title" >��������:</td>
      <td class="input"  >
        <input type="text" name="prpLcertifyCollectBusinessNo" class="readonly" readonly="true"  value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
      </td>
      <td class="title" >��������:</td>
      <td class="input"  >
        <input type="text" name="prpLcertifyCollectPolicyNo" class="readonly" readonly="true"  value="<bean:write name='prpLcertifyCollectDto' property='policyNo'/>">
      </td>
    </tr>
  </table>
    <%

      PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto)request.getAttribute("prpLcertifyImgDto");
      List prpLcertifyImgDtoList =  (ArrayList)prpLcertifyImgDto.getCertifyImgList();

      PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)request.getAttribute("prpLcertifyDirectDto");
      List prpLcertifyDirectDtoList =  (ArrayList)prpLcertifyDirectDto.getCertifyDirectList();

      List imageTypeList = (ArrayList)request.getAttribute("imageTypeList");
      ArrayList thirdPartyList = (ArrayList)request.getAttribute("thirdPartyList");
      PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)request.getAttribute("prpLcertifyCollectDto");
      int thirdPartyCount = thirdPartyList.size();// ��������
%>

  <table cellpadding="5" cellspacing="1" border="0"  class="common" >

    <%
          //�Ƿ���Ҫ�ϴ��ı�־ ��PrpLcertifyDirectȡ��
          UICodeAction uiCodeAction = new UICodeAction();
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){
              PrpLcertifyDirectDto prpLcertifyDirectDtoTemp = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
              String lossItemName = "";
              for(int i=0;i < thirdPartyList.size(); i++){
                PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)thirdPartyList.get(i);
                if(String.valueOf(prpLthirdPartyDto.getSerialNo()).equals(prpLcertifyDirectDtoTemp.getLossItemCode())){
                  lossItemName = "  ���ƺ���: "+ prpLthirdPartyDto.getLicenseNo();
                }
              }
              String typeName= uiCodeAction.translateCodeCode("ImageType",prpLcertifyDirectDtoTemp.getTypeCode(),true);

    %>

        <tr>
          <td class="input" ><input type="text" name="prpLcertifyDirectTypeName" class="readonly" readonly="true" value="<%= typeName %><%= lossItemName %>"></td>
        </tr>
    <%
            }
          }
    %>


  </table>

  <table cellpadding="0" cellspacing="0" width="100%" class="common">
    <tr>
      <td class=button style="width:33%" align="center">
        <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="����" onclick="return saveCertifyDirect();">
      </td>
      <td class=button style="width:34%" align="center">
        <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="��ӡ" onclick="javascript:window.print();">
      </td>
      <td class=button style="width:33%" align="center">
        <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="�ر�" onclick="javascript:window.close();">
      </td>
    </tr>
  </table>

  <input type="hidden" name="nodeType" value="CertifDirect">
  <input type="hidden" name="thirdPartyCount" value="<%= thirdPartyCount %>">
  <input type="hidden" name="classCount" value="<%= k-1 %>">

  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>
