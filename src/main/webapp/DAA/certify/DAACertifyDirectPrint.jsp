<%--
****************************************************************************
* DESC       ：索赔资料清单打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2005-03-25
* MODIFYLIST ：   Name       Date            Reason/Contents
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
    <!--对title处理-->
    <title>索赔资料清单</title>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  </head>


<body >
  <form name=fm action="/claim/certifySave.do" method="post">


  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr> <td class="formtitle" colspan=4>索赔资料清单</td></tr>
    <tr>
      <td class="title" >报案号码:</td>
      <td class="input"  >
        <input type="text" name="prpLcertifyCollectBusinessNo" class="readonly" readonly="true"  value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
      </td>
      <td class="title" >保单号码:</td>
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
      int thirdPartyCount = thirdPartyList.size();// 车的数量
%>

  <table cellpadding="5" cellspacing="1" border="0"  class="common" >

    <%
          //是否需要上传的标志 从PrpLcertifyDirect取得
          UICodeAction uiCodeAction = new UICodeAction();
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){
              PrpLcertifyDirectDto prpLcertifyDirectDtoTemp = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
              String lossItemName = "";
              for(int i=0;i < thirdPartyList.size(); i++){
                PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)thirdPartyList.get(i);
                if(String.valueOf(prpLthirdPartyDto.getSerialNo()).equals(prpLcertifyDirectDtoTemp.getLossItemCode())){
                  lossItemName = "  车牌号码: "+ prpLthirdPartyDto.getLicenseNo();
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
        <!--保存按钮-->
        <input type="button" name=buttonSave class='button' value="保存" onclick="return saveCertifyDirect();">
      </td>
      <td class=button style="width:34%" align="center">
        <!--保存按钮-->
        <input type="button" name=buttonSave class='button' value="打印" onclick="javascript:window.print();">
      </td>
      <td class=button style="width:33%" align="center">
        <!--保存按钮-->
        <input type="button" name=buttonSave class='button' value="关闭" onclick="javascript:window.close();">
      </td>
    </tr>
  </table>

  <input type="hidden" name="nodeType" value="CertifDirect">
  <input type="hidden" name="thirdPartyCount" value="<%= thirdPartyCount %>">
  <input type="hidden" name="classCount" value="<%= k-1 %>">

  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>
