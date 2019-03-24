<%--
****************************************************************************
* DESC       ������ע��/���⴦��ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-06-07
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<html:html locale="true">
 <head>
    <!--��title����-->
 <!--����ע��/���⴦�����-->
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/claim/js/DAAClaimEdit.js"></script>
  <script src="/claim/src/main/webapp/common/js/jquery-1.4.2.min.js"></script>

  <script language=javascript>
      //ȷ��

      //ȷ��

      function submitForm(submitType)
      {
        if(submitType!=null&&submitType!='5'){
         if(document.getElementById("caseType").value == '0'){
             if(document.getElementById("prpCancelReson").value == ''){
                 alert("ע��/����ԭ������Ϊ��!");
         	     return false;
             }
         }
        } 
         if(isEmptyField(fm.prpLclaimContext)){
         	alert("ע��/����˵��������Ϊ��!");
         	return false;
         }
         //alert(document.getElementById("caseType").value);
         //ajax�ж���Ƭ�Ƿ��ϴ�
        var checkMsg = true;
        if(submitType!=null&&submitType=='4'){
            $.ajax({
				   type: "POST",
				   url: "/claim/claimCancelCheckCertify.do",
				   data: "&type=1&registNo="+fm.prpLclaimRegistNo.value+"&caseType="+document.getElementById("caseType").value,
				   async: false,
				   success: function(msg){
				     if(msg.trim()=="1"){
   					 	alert("�����ϴ�һ��ע����Ƭ��");
   					 	checkMsg = false;
   					 }
				   }
			 }); 
        }
        if(!checkMsg){
            return false;
        }
        
        if(!validateForm(fm))
        {
         return false;
        }

        //�ж���������ע��/�����ʱ��һ��Ҫ��ѡ��һ����Ҫ���в������������롣
        if (fm.editType.value=="ADD"){
           //�ж�ѡ��ı�������
           var claimCount =parseInt(fm.txtClaimCount.value);
           if (claimCount>1){
         
           for (i=0;i<claimCount;i++){
           
               if (fm.txtcheckadd[i].checked==true) {
                  //������Ҫ����ע���������������
                  fm.prpLclaimClaimNo.value=fm.txtcheckadd[i].value;
                  }
              }
            }
        }
        //alert("���� "+fm.prpLclaimClaimNo.value)
         fm.submitType.value = submitType;
    // ������������
    
      if (fm.prpLclaimClaimNo.value==""){
      
      //alert("�����������󣬲��ܽ���ע�����������");
      //  return false;
      }
    
       if (fm.editType.value=="CANCELEDIT" && submitType != '5'){
		   if(window.confirm("��Ҫ��ӡ����/ע��������?")) {
		    fm.prpLcancelclaimPrintFlag.value="1";
			}
	   }
	   
	    if (submitType == '5'){
		   if(!window.confirm("��ȷ��Ҫ����ע������������в���?")) {
		    return false;
			}
	   }
	  if(fm.editTypeFlag.value!="CANCELEDIT" && fm.editTypeFlag.value!="CANCELSHOW"){
	   		var txtcheckaddCount = getElementCount("txtcheckadd");
	   		if(txtcheckaddCount > 1){
		   		for(var i = 0 ; i < txtcheckaddCount ;i++){
			   		if(fm.txtcheckadd[i].checked == true){
			   			var riskCode = fm.txtcheckadd[i].value.substr(1,4);
			   			if(riskCode == "0506" || riskCode == "0576" || riskCode == "0586"){
			   				if(!isEmptyField(fm.DAAFlag) && fm.DAAFlag .value== "Y"){
			   					alert("���������Ѿ�����ע��/����ڵ㣬�����ظ�ע��/���⣡");
			   					return false;
			   				}
			   			}else{
			   				if(!isEmptyField(fm.BZFlag) && fm.BZFlag.value == "Y"){
			   					alert("���������Ѿ�����ע��/����ڵ㣬�����ظ�ע��/���⣡");
			   					return false;
			   				}
			   			}
			   		}
		   		}
	   		}else{
	   			if(fm.txtcheckadd.checked == true){
			   			var riskCode = fm.txtcheckadd.value.substr(1,4);
			   			if(riskCode == "0506" || riskCode == "0576" || riskCode == "0586"){
			   				if(!isEmptyField(fm.DAAFlag) && fm.DAAFlag .value== "Y"){
			   					alert("���������Ѿ�����ע��/����ڵ㣬�����ظ�ע��/���⣡");
			   					return false;
			   				}
			   			}else{
			   				if(!isEmptyField(fm.BZFlag) && fm.BZFlag.value == "Y"){
			   					alert("���������Ѿ�����ע��/����ڵ㣬�����ظ�ע��/���⣡");
			   					return false;
			   				}
			   			}
			   		}
	   		}
	   }
	   
		fm.submit();
      }

     function changeCaseType(field){
         var caseType = field.value;
         if(caseType == '1'){
             document.getElementById("prpCancel").style.display="none";
             document.getElementById("prpExclusions").style.display="";
             fm.caseType.value='1';
         }else{
             document.getElementById("prpCancel").style.display="";
             document.getElementById("prpExclusions").style.display="none";
             fm.caseType.value='0';
         }
     }
    function onloadChangeCaseType(){
         var caseType = document.getElementById("caseType").value;
         if(caseType == '1'){
             document.getElementById("prpCancel").style.display="none";
             document.getElementById("prpExclusions").style.display="";
             fm.caseType.value='1';
         }else{
             document.getElementById("prpCancel").style.display="";
             document.getElementById("prpExclusions").style.display="none";
             fm.caseType.value='0';
         }
     }
    </script>
  </head>
  
<%//modify by qinyongli 
     String editType=request.getParameter("editType");
	 String type=(String)request.getAttribute("type");
	 if("claim".equals(type)){
		 editType = "CANCELSHOW";
	 }
     String strCancelFlag = (String)request.getAttribute("strCancel");
     PrpLclaimDto prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
     String colspan = "4";
     String display = "none";
     if("05".equals(prpLclaimDto.getClassCode())){
         colspan = "1";
         display = "";
     }
     //reason: ��ֹ�ظ��ύ
     session.setAttribute("oldCancelAccessedTime","");
     if(editType.equals("CANCELEDIT")||editType.equals("CANCELSHOW")){
%>
     <body class=interface onload="initPage();readonlyAllInput();onloadChangeCaseType();">
<%}else{%>
     <body class=interface onload="initPage();onloadChangeCaseType();">
<%} //end%>



<form name=fm action="/claim/claimCancel.do" method="post" onsubmit="return validateForm(this);">
      <%
          String strRiskClass = request.getAttribute("com.sinosoft.type").toString(); //�õ����� 2005-08-09
      %>
      <table  cellpadding="5" cellspacing="1" class=common>
         <tr class=listtitle>
            <td  colspan="4">����ע��/���⴦��
                <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
                <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
           		<input type="hidden" name="BZFlag" class="common" value="<%=request.getAttribute("BZFlag") %>">
           		<input type="hidden" name="DAAFlag" class="common" value="<%=request.getAttribute("DAAFlag") %>">
           </td>

         </tr>
         <%if ("UNCANCEL".equals(editType)){ %>
          <tr>
      	   <td>
               <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
          </td>
         </tr>
          
          <%} %>
          <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" colspan=3>
               <input type="text" name="prpLclaimRegistNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
               <input type="hidden" name="classCode" value="<bean:write name='prpLclaimDto' property='classCode' filter='true' />">
            </td>
            
         </tr>
         
        
         
         <%  
         String CancelEditStyle="";
         int rowcount=0;
         
          if ("CANCELEDIT".equals(editType)||"CANCELSHOW".equals(editType)||"UNCANCEL".equals(editType)){
          }else{
          CancelEditStyle="Style='display:none'";
          
          String selectToCancle="0";          //�Ƿ����ѡ����������ע���ı���
          String haveCheck="checked='checked'";                //Ĭ�ϲ���ѡ��
          String haveCheckdisable="disabled";         //�Ƿ��������ѡ��
          String haveCancled="";              //�Ѿ�ע�����ˡ� 
          //˵��������ֻ��һ��һ�������룬����Ǻͱ�����ע���ǲ�һ���ġ���
          
          
          
          %>
        
          <logic:iterate id="claimList1"  name="prpLclaimDto"  property="claimList">  
          
            <%  haveCheckdisable=""; //Ĭ�ϲ���ѡ��check
                rowcount= rowcount+1;        //��¼����������
                haveCancled="";              //û��ע����
             %>
                       
            <logic:equal name="claimList1"  property="endCaseDate" value="">
            <% haveCheckdisable=""; 
               haveCancled="";
            %>
            </logic:equal>
          
          <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.claimNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" >
              <input type="hidden" name="selectToCancle" value="">
              <input type="hidden" name="haveCancled" value="<%=haveCancled%>">
              <input type="radio"  class="" name="txtcheckadd" style="width:20px" value='<bean:write name='claimList1' property='claimNo' filter='true' />' <%=haveCheck%> <%=haveCheckdisable%>>&nbsp;
              <input type="text" name="prpLclaimClaimNo1" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='claimList1' property='claimNo' filter='true' />">
            </td>
            <td class="title" style="width:15%"><bean:message key="db.prpLclaim.policyNo" />:</td>
            <td class="input" style="width:35%">
                <input type="text" name="prpLclaimPolicyNo1" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='claimList1' property='policyNo' filter='true' />">
                          
         </tr>
         <% haveCheck="0";   %>
         </logic:iterate>
         <%
        
         }%>
         <input type="hidden" name="editTypeFlag" value="<%=editType%>">
         <input type="hidden" name="txtClaimCount" value="<%=rowcount%>"> 
         <tr <%=CancelEditStyle%>>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.claimNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" colspan=3>
               <input type="text" name="prpLclaimClaimNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
            </td>
         </tr>
       
         <tr>
            <td class="title" >�鵵��:</td>
            <td class="input">
                <input type=text name="prpLclaimCaseNo" title="�鵵��" class="readonly" readonly="true"  maxlength="22" style="width:140px" value="<bean:write name='prpLclaimDto' property='caseNo' filter='true' />">
            </td>
            <td class="title" ></td>
            <td class="input"></td> 
         </tr>
         <tr>
            <td class="title" > ע��/���⣺
            </td>
            <td class="input">
            <html:select style="width:30%" name="prpLclaimDto" property="caseType" onchange="changeCaseType(this)">
             <%if ("CANCELEDIT".equals(editType)||"CANCELSHOW".equals(editType)||"UNCANCEL".equals(editType)){%>
                 <logic:equal name="prpLclaimDto" property="caseType" value="0">
                   <html:option value="0" >ע��</html:option>
                 </logic:equal>
                 <logic:equal name="prpLclaimDto" property="caseType" value="1">
                   <html:option value="1" >����</html:option>
                 </logic:equal>
                 <input type="hidden" name="caseType" id="caseType" value="<bean:write name="prpLclaimDto" property="caseType"/>" />
             <%}else{%>
               	<html:option value="0" >ע��</html:option>
                <html:option value="1" >����</html:option>
                <input type="hidden" name="caseType" id="caseType" value="" />
             <%}%>
             </html:select>
            </td>
            <td class="title" >ע��/����ԭ��</td>
            <td class="input" id="prpCancel" colspan="3">
                <select style="width:60%" name="prpCancel" id="prpCancelReson">
                    <option value="">----- ��ѡ�� -----</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="1">selected</logic:equal> value="1">�ͻ�����</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="2">selected</logic:equal> value="2">�ͻ��ظ�����</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="3">selected</logic:equal> value="3">������Ͷ���ձ����</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="4">selected</logic:equal> value="4">������Ͷ�����ֳ���</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="5">selected</logic:equal> value="5">ҵ��Ա��������</option>
                </select>
            </td> 
            <td class="input" id="prpExclusions" colspan="3" style="display:none">
                <select style="width:60%" name="prpExclusions">
                    <option value="0">�����ڱ�������</option>
                </select>
            </td> 
         </tr>
          <tr>
            <td class="title" >��������:</td>
            <td class="input">
               <input type=text name="prpLclaimInsuredName" title="��������" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">

            </td>

            <td class="title" >�����ţ�
            </td>
            <td class="input">
                <input type=text name="prpLclaimPolicyNo" title="������" readOnly class="readonly"  value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
            </td>
         </tr>

        <!--ԭ�򣺷ǳ��ղ�Ҫ������Ϣ-->
        <logic:equal name="com.sinosoft.type" value="05">
          <tr>
            <td class="title" >���ƺ�:</td>
            <td class="input">
               <input type=text name="prpLregistLicenseNo" title="���ƺ�" readOnly class="readonly" value="<bean:write name='prpLregistDto' property='licenseNo' filter='true' />">

            </td>

            <td class="title" >�����ͺţ�
            </td>
            <td class="input">
                <input type=text name="prpLregistBrandName" title="�����ͺ�" readOnly class="readonly"  value="<bean:write name='prpLregistDto' property='brandName' filter='true' />">

            </td>
         </tr>
       </logic:equal>

          <tr>
            <td class="title" >����ʱ��:</td>
            <td class="input">
               <input type=text name="prpLclaimDealerName" title="����ʱ��" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">

            </td>

            <td class="title" >���յص㣺
            </td>
            <td class="input">
                <input type=text name="prpLclaimDamageAddress" title="���յص�" readOnly class="readonly"  value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />">

            </td>
         </tr>
         <tr>
            <td class="title" ><%if ("CANCELSHOW".equals(editType)){%>
              �����ˣ�
            <%}else{%>
              ������:
            <%}%>
            
            </td>
            <td class="input">
               <input type="hidden" name="prpLclaimDealerCode" title="ע���ⰸ������" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='dealerCode' filter='true' />">
               <input type=text name="prpLclaimDealerName" title="ע���ⰸ������" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='dealerName' filter='true' />">

            </td>

            <td class="title" >
            <%if ("CANCELSHOW".equals(editType)){%>
              ����ʱ�䣺
            <%}else{%>
              ����ʱ�䣺
            <%}%>
            </td>
            <td class="input">
                <input type=text name="prpLclaimCancelDate" title="����ʱ��" readOnly class="readonly"  value="<bean:write name='prpLclaimDto' property='cancelDate' filter='true' />">

            </td>
         </tr>
         

         <tr>
             <td class="title" colspan="<%=colspan %>">
              ע��/����˵����
             </td>
             <td class="title" colspan="3" style="display: <%=display %>">
                 <input type="text" class="codecode" name="CancelReason"  style="width:40px"  value="<bean:write name='prpLregistRPolicyDto' property='cancelReason' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'CancelReason');"
                    onchange="code_CodeChange(this, 'CancelReason');"
                    onkeyup= "code_CodeSelect(this, 'CancelReason');"
                 >
                 <input type="text"  class="codecode" name="CancelReasonName"  style="width:185px" value="<bean:write name='prpLregistRPolicyDto' property='cancelReasonName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'CancelReason','-1','name','post','clear');"
                    onchange="code_CodeChange(this, 'CancelReason','-1','name','post','clear');"
                    onkeyup= "code_CodeSelect(this, 'CancelReason','-1','name','post','clear');"
                 >
             </td>
         </tr>
         <tr>
           <td class="input" colspan="4" align="center">
             <textarea name='prpLclaimContext' wrap="hard" rows=15 cols=80 class=common ><bean:write name='prpLclaimDto' property='cancelReason' filter='true' /></textarea>
             <!--<%
                 if (strRiskClass.equals("27") || strRiskClass.equals("26")) {  //�⽡����Ҫ����ģ�����ɲ��������ı� 2005-08-09
             %>
             <input type="button" name="btnRegistText" class=bigbutton value="���ɲ��������ı�" onclick="return generateNoClaimText();">
             <%
                 }
             %>-->
           </td>
         </tr>
     </table>

     <table class="common" align="center">
     <input type=hidden name=submitType value=0 />
     <% if ("CANCELSHOW".equals(editType)){
     		if(!"claim".equals(type)){
     %>
          <!--ȡ����ť-->
	    <td class=button style="width:25%" align="center">
	      <input type=button name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >
        </td>
     <%		}
     }else{%>
        <tr >
           <%if (!"UNCANCEL".equals(editType)){ %>
      	   <td class=button style="width:25%" align="center">
              <!--ȷ ����ť-->
              <input type=button name=buttonSave class='button' value="<bean:message key='button.submit.value' />" onClick="submitForm('4');">
           </td>
	   
	      <!--ȡ����ť-->
	       <td class=button style="width:25%" align="center">
	      <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="javascript:history.go(-1);" >
        </td>
        
        
        <!--Modify by ww add start 2005-11-24
          //Reason: ���ע��/�����˻ع���-->
          <%
          if ("CANCELEDIT".equals(editType)) {
          %>
           <td class=button style="width:25%" align="center">
              <!--�˻ذ�ť-->
              <input type=button name=buttonBack class='button' value="�˻�����" onClick="return submitForm('5');">
           </td>
          <%
          }
          %>
          
          <%} %>
          
          <td>
               <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
          </td>
        <!--Modify by ww add end 2005-11-24-->
     <%}%>   
        
	      <input type=hidden name="editType" title="��������" class="readonly" value="<bean:write name='prpLclaimDto' property='editType' filter='true' />">
        <input type=hidden name="nodeType" title="�ڵ�����" class="readonly" value="<%=request.getParameter("nodeType")%>">
        <input type=hidden name="businessNo" title="ҵ�����" class="readonly" value="<%=request.getParameter("bussinessNo")%>">
        <input type=hidden name="prpLcancelclaimPrintFlag" title="ҵ�����" class="readonly" value='0'>

 </tr>
     </table>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
