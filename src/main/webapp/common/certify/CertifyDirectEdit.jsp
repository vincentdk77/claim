<%--
****************************************************************************
* DESC       ：索赔资料清单修改页面
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
<%@ page import="java.util.*" %>

<html>
  <head>
    <!--对title处理-->
    <title>索赔资料清单</title>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  <SCRIPT>
  	function exit()
  	{
      //window.opener.location.reload();
  	}
  </SCRIPT>
  </head>
<%
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("certi")){
%>
<body  onunload="exit();">
<%
  }else{
%>
<body >
<%
  }
%>
  <form name=fm action="/claim/certifySave.do" method="post">
<input type="hidden" name="riskCode" value="<%=request.getAttribute("riskCode")%>">

  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr> <td colspan=4 class="formtitle">索赔资料清单</td></tr>

    <tr>
      <td class="title">报案号码:</td>
      <td class="input" >
        <input type="text" name="prpLcertifyCollectBusinessNo" class="readonly" readonly="true"  value="<bean:write name='prpLcertifyCollectDto' property='businessNo'/>">
      </td>
      <td class="title">保单号码:</td>
      <td class="input" >
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
      int k= 0;
%>
<% 
      String strTitle="索赔申请";

      int intThirdParty = 0;//标的lossitemcode
%>

  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >
    <tr>
      <td class="centertitle" style="width:100%" colspan="6"><%= strTitle %></td>
    </tr>
    <tr>
      <td class="subformtitle" style="width:10%">需要标志</td>
      <td class="subformtitle" style="width:60%">清单类型</td>
    </tr>

    <%

      for(int i=0;i<imageTypeList.size();i++){
        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)imageTypeList.get(i);

          //是否需要上传CheckBox
          String requireUploadFlag = "";
          //是否把checkbox变成不可用
          String requireDisabledFlag = "";
          //取得隐含域的值，需要上传时为1，否则为0
          String requireTxt = "0";
          //取得code的值
          String codeCode = prpDcodeDto.getCodeCode();
          //是否需要上传的标志 从PrpLcertifyDirect取得
          if(prpLcertifyDirectDtoList!=null&&prpLcertifyDirectDtoList.size()>0){
            for(int j=0;j < prpLcertifyDirectDtoList.size(); j++){
              PrpLcertifyDirectDto prpLcertifyDirectDtoTemp = (PrpLcertifyDirectDto)prpLcertifyDirectDtoList.get(j);
              if(prpLcertifyDirectDtoTemp.getTypeCode().equals(prpDcodeDto.getCodeCode())){
                requireUploadFlag = "checked";
                requireDisabledFlag = "disabled";
                requireTxt = prpDcodeDto.getCodeCode();
                System.out.println("----此单证需要上传-------"+requireUploadFlag+prpDcodeDto.getCodeCode());
                break;
              }
            }
          }
    %>
        <tr>
          <td class="input" style="width:10%">
            <input type="checkbox" name="prpLcertifyDirect"  <%= requireUploadFlag %> onClick="return fcDirectCodeChange(this);">
            <input type="hidden" name="prpLcertifyDirectCode" value="<%= requireTxt %>">
            <input type="hidden" name="code" value="<%=codeCode%>">
            <input type="hidden" name="prpLcertifyDirectLossItemCode" value="<%=i+1%>">
          </td>
          <td class="input" style="width:90%"><input type="text" name="prpLcertifyDirectTypeName" class="readonly" readonly="true" value="<%= prpDcodeDto.getCodeCName() %>"></td>
        </tr>
    <%
        }
    %>
  </table>
  <table cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td class=button style="width:50%" align="center">
        <!--保存按钮-->
        <input type="button" name=buttonSave class='button' value="保存" onclick="return saveCertifyDirect();">
      </td>
   <!--   <td class=button style="width:34%" align="center"> -->
        <!--保存按钮-->
   <!--     <input type="button" name=buttonSave class='button' value="打印" onclick="javascript:window.print();">
      </td>-->
      <td class=button style="width:50%" align="center">
        <!--保存按钮-->
        <input type="button" name=buttonClose class='button' value="关闭" onclick="javascript:window.close();">
      </td>
    </tr>
  </table>
  <input type="hidden" name="classCount" value="1">
  <input type="hidden" name="nodeType"   value="CertifDirect">

 <%
  System.out.println("-----thirdPartyCount----"+thirdPartyCount);
 %>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>
