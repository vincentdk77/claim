<%--
****************************************************************************
* DESC       ：索赔清单显示及打印页面
* AUTHOR     ： luqin
* CREATEDATE ： 2005-07-21 
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>

    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  <SCRIPT>
  	function exit()
  	{
      window.opener.location.reload();
  	}
  </SCRIPT>

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
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr height="40">
      <td align=top align=center style="font-family:宋体; font-size:14pt;">            
          <B>机动车辆保险索赔须知<B>
      </td>
    </tr>
  </table>
<%
      RegistDto registDto = (RegistDto)request.getAttribute("registDto");
      String registNo = "";
      registNo = registDto.getPrpLregistDto().getRegistNo();
      String policyNo = registDto.getPrpLregistDto().getPolicyNo();
      
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
      
      UICodeAction uiCodeAction = new UICodeAction();
      String strCode = "";
      String strName = "";
      strCode = StringConvert.encode(registDto.getPrpLregistDto().getComCode());
      strName = uiCodeAction.translateComCode(strCode,true); 
      
      PrpLcertifyDirectDto prpLcertifyDirectDto = null;
      String strTypeCode[] = new String[100];
      String strTypeName[] = new String[100];
      int certifyDtoCount = 0;
      int index = 1;
      CertifyDto certifyDto = (CertifyDto)request.getAttribute("certifyDto");
      if(certifyDto.getPrpLcertifyDirectDtoList()!=null){
        certifyDtoCount = certifyDto.getPrpLcertifyDirectDtoList().size();
      }
%>
<br>
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0"> 
  <tr> 
    <td colspan=4 height="20">
        <p><ins><%=prpCmainDto.getInsuredName()%></ins>：</p>
      </td>
	   </tr>
  <tr> 
    <td colspan=4 height="20"><p> &nbsp;&nbsp;&nbsp;&nbsp;由于您投保的机动车辆发生了事故，请您在向我公司提交《机动车辆保险索赔申请书》的同时，依照我公司的要求，提供以下 
        有关单证。如果您遇到困难，请随时拨打公司的服务专线电话 “__________”，我公司将竭诚为您提供优质、高效的保险服务。 谢谢您的合作！</p></td>
	   </tr>
	<tr> 
    <td colspan=4 height="20"><blockquote>
        <p>机动车辆索赔材料手续明细如下：</p>
      </blockquote></td>
	   </tr><br>
<%if(certifyDtoCount > 25){
    certifyDtoCount = 25;
  }  
  for(int i=0;i<certifyDtoCount;i++){
    prpLcertifyDirectDto = (PrpLcertifyDirectDto)certifyDto.getPrpLcertifyDirectDtoList().get(i); 
    String typeName = "";
    strTypeCode[i] = prpLcertifyDirectDto.getTypeCode().substring(0,2);
    strTypeName[i] = prpLcertifyDirectDto.getTypeName();
    if(!strTypeName[i].equals("")){
      if(strTypeCode[i].equals("01")){  
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 《机动车辆保险索赔申请书》</p>
      </blockquote></td>
	   </tr>
<%
  }if(strTypeCode[i].equals("02")){
%> 
  <tr height="20">  
    <td colspan=4><blockquote>
        <p><%=index++%>. 机动车辆保险单正本</p>
      </blockquote></td>
	   </tr>
<%
  }if(strTypeCode[i].equals("03")){
    if(i > 0 && !strTypeCode[i-1].equals("03")){
%>	   
  <tr height="20">  
    <td colspan=4><blockquote>
        <p><%=index++%>. 事故处理部门出具的： </p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("04")){
    if(i > 0 && !strTypeCode[i-1].equals("04")){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 法院、仲裁机构出具的：</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("05")){
    if((i > 0 && !strTypeCode[i-1].equals("05"))){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 涉及车辆损失还需提供： </p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("06")){
    if(i > 0 && !strTypeCode[i-1].equals("06")){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 涉及财产损失还需提供：</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("07")){
    if(i > 0 && !strTypeCode[i-1].equals("07")){
%>	    
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 涉及人身伤、残、亡损失还需提供：</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("08")){
    if(i > 0 && !strTypeCode[i-1].equals("08")){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 涉及车辆盗抢案件还需提供： </p>
      </blockquote></td>
     </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>     
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("09")){
    if(i > 0 && !strTypeCode[i-1].equals("09")){
%>     
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 涉及车辆自燃的案件还需提供：</p>
      </blockquote></td>
    </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>    
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("10")){
    if(i > 0 && !strTypeCode[i-1].equals("10")){
%>    
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 被保险人索赔时，还须提供以下证件原件，经保险公司验证后留存复印件：</p>
      </blockquote></td>
    </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>    
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("11")){
    if(i > 0 && !strTypeCode[i-1].equals("11")){
%>
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 被保险人领取赔款时，须提供以下材料和证件，经保险公司验证后留存复印件：</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("99")){
    if(i > 0 && !strTypeCode[i-1].equals("99")){
%>
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. 需要提供的其它索赔证明和单据：</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
    }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
      }
    }
    else if(i==24){
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p>(内容过多，其余内容见下一页)</p>
      </blockquote></blockquote></td>
	   </tr>
<%  }  
  }
}
    if(certifyDtoCount < 25 ){
      for(int j=0;j<30-certifyDtoCount;j++){
%>
	  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p></p>
      </blockquote></blockquote></td>
	   </tr> 
<%
    }
  }
%>  	     
  <tr> 
    <td colspan=4 height="20"><p>&nbsp;&nbsp;&nbsp;&nbsp;敬请注意：为确保您能够获得更加全面、合理的保险赔偿，我公司在理赔过程中，可能需要您进一步提供上述所列单证 以外的其他证明材料。届时，我公司将及时通知您。感谢您对我们工作的理解与支持！</p></td>
	   </tr>
	   <tr>
	     <td  colspan=4><hr></td>
	   </tr>
  </table>
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0"> 	   
     <tr height="30">
	     <td width="30%">被保险人： </td>
		   <td width="20%"><%=prpCmainDto.getInsuredName()%></td>
		   <td width="30%">保险公司：</td>
		   <td width="20%"><%=strName%></td>
	   </tr> 
	   <tr height="30">
	     <td>领到《索赔须知》日期：</td>
		   <td>____年____月____日</td>
		   <td>交付《索赔须知》日期：</td>
		   <td>____年____月____日</td>
	   </tr> 
	   <tr height="30">
	     <td>确认签字：</td>
		   <td></td>
		   <td>经办人签字：</td>
		   <td></td>
	   </tr> 
	   <tr height="30">
	     <td>提交索赔材料日期：</td>
		   <td>____年____月____日</td>
		   <td>收到索赔材料日期：</td>
		   <td>____年____月____日</td>
	   </tr> 
	   <tr height="30">
	     <td>确认签字：</td>
		   <td></td>
		   <td>经办人签字：</td>
		   <td></td>
	   </tr> 
  </table>
  <br>


  <input type="hidden" name="nodeType" value="CertifDirect">
  <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>    
      <%-- include打印按钮 --%>
      <!--<jsp:include page="/common/print/PrintButton.jsp" />     -->
   <table id="tbButton" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <tr>
        <td class=button style="width:33%" align="center">
          <input type=button name=buttonPrint value=" 打 印 " class="button" onclick="return printPage()">
        </td>
<%
  if(certifyDto.getPrpLcertifyDirectDtoList().size()>24){
%> 
  <td class=button style="width:33%" align="center">
          <input type=button name=buttonPage value=" 附 页 " class="button" onclick="return certifyDirectAdd('<%=registNo%>','certi','<%=index%>')">
        </td>
<%
  }
%>       
        <td class=button style="width:33%" align="center">
          <input type=button name=buttonClose value=" 关 闭 " class="button" onclick="javascript:window.close()">
        </td>
      </tr>
    </table>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>