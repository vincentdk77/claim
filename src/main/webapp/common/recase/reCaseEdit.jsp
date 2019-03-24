<%--
****************************************************************************
* DESC       �������ؿ��ⰸ������
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-26
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>
<%@page  import="com.sinosoft.sysframework.common.datatype.DateTime"%>

<%
 
    
   PrpLclaimDto prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
   UIClaimAction   uiClaimAction  =new  UIClaimAction ();   
   ClaimDto claimDto= uiClaimAction.findByPrimaryKey(prpLclaimDto.getClaimNo());
   UserDto   user      = (UserDto)session.getAttribute("user");
   String editType = (String)request.getAttribute("editType");
   PrpLrecaseDto prpLrecaseDto = (PrpLrecaseDto)request.getAttribute("prpLrecaseDto");
   
   String ended="";
    String recaseend="";
   if (!prpLclaimDto.getEndCaseDate().toString().equals("")){
        ended ="y";  //�ѽ᰸
      }
      else{
        ended ="n";
      }
   if(prpLrecaseDto!=null){
   if (!prpLrecaseDto.getCloseCaseDate().toString().equals("")){
        recaseend ="y";//�ؿ��ⰸ�ѽ���
      }else{
        recaseend ="n";
      }
   }else{recaseend ="y";}  
%>


<html:html locale="true">
<head>
   <title>�ؿ��ⰸ</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <script language='javascript'>
  
   function checkendCase()
   {
   
     var ended="<%=ended%>";
     var recaseend="<%=recaseend%>";
     if (recaseend=="n"){
    	alert("�˰����ϴ��ؿ��ⰸ��δ�᰸,�����ٴ��ؿ��ⰸ");
     	fm.buttonSave.disabled = true;
        return false;
     }
   	 if (ended=="n"){
     	alert("�˰���δ�᰸�����ؿ��ⰸ");
     	fm.buttonSave.disabled = true;
        return false;
     }
     return true;
   }
  
   function submitForm()
    {
        //ajax�ж���Ƭ�Ƿ��ϴ�
        //var checkMsg = true;
        //$.ajax({
				   //type: "POST",
				   //url: "/claim/claimCancelCheckCertify.do",
				   //data: "&type=2&ClaimNo="+fm.ClaimNo.value,
				  // async: false,
				   //success: function(msg){
				     //if(msg.trim()=="1"){
   					 	//alert("�����ϴ�һ���ؿ��ⰸ��Ƭ��");
   					 	//checkMsg = false;
   					 //}
				   //}
			 //}); 
       // if(!checkMsg){
            //return false;
        //}
    
    if(checkendCase()==true)
	  	{
        fm.submit();
      }
   
    }

    function resetForm()
    {
      fm.reset();
    }
  </script>
</head>

<body  class="interface" onload="initPage();">

<%-- ����loadForm ��ʼ��ҳ�� --%>
<body class="interface" onload="initPage();">
  <form name=fm action="/claim/appRecase.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <table class="common" cellpadding="5" cellspacing="1">
  	  <tr>
  	  		  	<td class=formtitle colspan="4">�ؿ��ⰸ</td>
  	  </tr>
  	    <%if("UWTSHOW".equals(editType)){ %>
	    <tr>
	      <td>
	        <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
	      </td>
	    </tr>
	  <%} %>
      <tr>
        <td class="title">�����ţ�</td>
        <td class="input">
          <input type='hidden' name='RiskCode' value="<bean:write name='prpLclaimDto' property='riskCode' />">
          <input name="ClaimNo" class="readonly" readonly value="<bean:write name='prpLclaimDto' property='claimNo' />">
        </td>
        <td class="title">�����ţ�</td>
        <td class="input">
          <input name="PolicyNo" class="readonly" readonly value="<bean:write name='prpLclaimDto' property='policyNo' />">
        </td>
      </tr>
      <tr>
        <td class="title">�ϴν᰸ʱ�䣺</td>
        <td class="input">
           <input name=endCaseDate class="readonly" readonly value="<bean:write name='prpLclaimDto' property='endCaseDate' />">
        </td>
        <td class="title">�ϴν᰸����Ա��</td>
        <td class="input">
           <input name="ItemCode" class="readonly" readonly value="<bean:write name='prpLclaimDto' property='endCaserCode' />">
        </td>
      </tr>
      <tr>
        <td class="title">�ؿ��ⰸʱ�䣺</td>
        <td class="input"> 
    <input name=reCaseDate type="input" class="readonly" value="<%=new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString()%>">
        </td>
        <td class="title">����Ա��</td>
        <td class="input">
             <input name="reCasehandleCode" type="input" class="readonly" value="<%= user.getUserCode() %>">
        </td>
      </tr>
      <tr>
          <td class="title" colspan=4>�ؿ��ⰸԭ��</td>
      </tr>
      <tr>
           <td class="input" colspan="4" align="center">
            <input type='hidden' name="riskCode"  value="<bean:write name='prpLclaimDto' property='riskCode' />">
             <textarea name='appRecaseReason' wrap="hard" rows=15 cols=80 class=common ><logic:notEmpty name="prpLrecaseDto"><bean:write name='prpLrecaseDto' property='reCaseReason' /></logic:notEmpty></textarea>
            </td>
     </tr>
    </table>
  <%if(!"SHOW".equals(editType) && !"UWTSHOW".equals(editType)){ %>
  <input type="hidden" name="editType" value="SAVE">
  <table class="common" align="center">
    <tr>
      <td class="button" >
        <input type="button" name="buttonSave" value=" ȷ �� " class="button" onclick="submitForm();">
      </td>
      <td class="button" >
        <input type="button" name="buttonCancel" value=" ȡ �� " class="button" onclick="resetForm();">
      </td>
      <td>
        <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
      </td>
    </tr>
  </table>
  <%} %>
</form>
</body>
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
