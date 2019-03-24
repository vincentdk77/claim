<%--
****************************************************************************
* DESC       ：立案注销/拒赔处理页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-06-07
* MODIFYLIST ：   Name       Date            Reason/Contents
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
    <!--对title处理-->
 <!--立案注销/拒赔处理入口-->
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/claim/js/DAAClaimEdit.js"></script>
  <script src="/claim/src/main/webapp/common/js/jquery-1.4.2.min.js"></script>

  <script language=javascript>
      //确定

      //确定

      function submitForm(submitType)
      {
        if(submitType!=null&&submitType!='5'){
         if(document.getElementById("caseType").value == '0'){
             if(document.getElementById("prpCancelReson").value == ''){
                 alert("注销/拒赔原因不允许为空!");
         	     return false;
             }
         }
        } 
         if(isEmptyField(fm.prpLclaimContext)){
         	alert("注销/拒赔说明不允许为空!");
         	return false;
         }
         //alert(document.getElementById("caseType").value);
         //ajax判断照片是否上传
        var checkMsg = true;
        if(submitType!=null&&submitType=='4'){
            $.ajax({
				   type: "POST",
				   url: "/claim/claimCancelCheckCertify.do",
				   data: "&type=1&registNo="+fm.prpLclaimRegistNo.value+"&caseType="+document.getElementById("caseType").value,
				   async: false,
				   success: function(msg){
				     if(msg.trim()=="1"){
   					 	alert("至少上传一组注销照片！");
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

        //判断申请立案注销/拒赔的时候，一定要先选择一个需要进行操作的立案号码。
        if (fm.editType.value=="ADD"){
           //判断选择的保单号码
           var claimCount =parseInt(fm.txtClaimCount.value);
           if (claimCount>1){
         
           for (i=0;i<claimCount;i++){
           
               if (fm.txtcheckadd[i].checked==true) {
                  //设置需要申请注销拒赔的立案号码
                  fm.prpLclaimClaimNo.value=fm.txtcheckadd[i].value;
                  }
              }
            }
        }
        //alert("申请 "+fm.prpLclaimClaimNo.value)
         fm.submitType.value = submitType;
    // 必须先立案的
    
      if (fm.prpLclaimClaimNo.value==""){
      
      //alert("必须先立案后，才能进行注销拒赔操作！");
      //  return false;
      }
    
       if (fm.editType.value=="CANCELEDIT" && submitType != '5'){
		   if(window.confirm("需要打印拒赔/注销报告吗?")) {
		    fm.prpLcancelclaimPrintFlag.value="1";
			}
	   }
	   
	    if (submitType == '5'){
		   if(!window.confirm("请确认要将此注销拒赔申请进行驳回?")) {
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
			   					alert("此立案号已经生成注销/拒赔节点，不能重复注销/拒赔！");
			   					return false;
			   				}
			   			}else{
			   				if(!isEmptyField(fm.BZFlag) && fm.BZFlag.value == "Y"){
			   					alert("此立案号已经生成注销/拒赔节点，不能重复注销/拒赔！");
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
			   					alert("此立案号已经生成注销/拒赔节点，不能重复注销/拒赔！");
			   					return false;
			   				}
			   			}else{
			   				if(!isEmptyField(fm.BZFlag) && fm.BZFlag.value == "Y"){
			   					alert("此立案号已经生成注销/拒赔节点，不能重复注销/拒赔！");
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
     //reason: 防止重复提交
     session.setAttribute("oldCancelAccessedTime","");
     if(editType.equals("CANCELEDIT")||editType.equals("CANCELSHOW")){
%>
     <body class=interface onload="initPage();readonlyAllInput();onloadChangeCaseType();">
<%}else{%>
     <body class=interface onload="initPage();onloadChangeCaseType();">
<%} //end%>



<form name=fm action="/claim/claimCancel.do" method="post" onsubmit="return validateForm(this);">
      <%
          String strRiskClass = request.getAttribute("com.sinosoft.type").toString(); //得到险类 2005-08-09
      %>
      <table  cellpadding="5" cellspacing="1" class=common>
         <tr class=listtitle>
            <td  colspan="4">立案注销/拒赔处理
                <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
                <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
           		<input type="hidden" name="BZFlag" class="common" value="<%=request.getAttribute("BZFlag") %>">
           		<input type="hidden" name="DAAFlag" class="common" value="<%=request.getAttribute("DAAFlag") %>">
           </td>

         </tr>
         <%if ("UNCANCEL".equals(editType)){ %>
          <tr>
      	   <td>
               <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
          </td>
         </tr>
          
          <%} %>
          <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" colspan=3>
               <input type="text" name="prpLclaimRegistNo" class="readonly"  title="报案号" maxlength="22"  readonly="true"  value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
               <input type="hidden" name="classCode" value="<bean:write name='prpLclaimDto' property='classCode' filter='true' />">
            </td>
            
         </tr>
         
        
         
         <%  
         String CancelEditStyle="";
         int rowcount=0;
         
          if ("CANCELEDIT".equals(editType)||"CANCELSHOW".equals(editType)||"UNCANCEL".equals(editType)){
          }else{
          CancelEditStyle="Style='display:none'";
          
          String selectToCancle="0";          //是否可以选择用来进行注销的保单
          String haveCheck="checked='checked'";                //默认不能选中
          String haveCheckdisable="disabled";         //是否允许进行选择
          String haveCancled="";              //已经注销过了。 
          //说明：立案只能一个一个的申请，这点是和报案的注销是不一样的。。
          
          
          
          %>
        
          <logic:iterate id="claimList1"  name="prpLclaimDto"  property="claimList">  
          
            <%  haveCheckdisable=""; //默认不能选择check
                rowcount= rowcount+1;        //记录保单的条数
                haveCancled="";              //没有注销过
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
              <input type="text" name="prpLclaimClaimNo1" class="readonly"  title="立案号" maxlength="22"  readonly="true"  value="<bean:write name='claimList1' property='claimNo' filter='true' />">
            </td>
            <td class="title" style="width:15%"><bean:message key="db.prpLclaim.policyNo" />:</td>
            <td class="input" style="width:35%">
                <input type="text" name="prpLclaimPolicyNo1" class="readonly"  title="保单号" maxlength="22"  readonly="true"  value="<bean:write name='claimList1' property='policyNo' filter='true' />">
                          
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
               <input type="text" name="prpLclaimClaimNo" class="readonly"  title="立案号" maxlength="22"  readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
            </td>
         </tr>
       
         <tr>
            <td class="title" >归档号:</td>
            <td class="input">
                <input type=text name="prpLclaimCaseNo" title="归档号" class="readonly" readonly="true"  maxlength="22" style="width:140px" value="<bean:write name='prpLclaimDto' property='caseNo' filter='true' />">
            </td>
            <td class="title" ></td>
            <td class="input"></td> 
         </tr>
         <tr>
            <td class="title" > 注销/拒赔：
            </td>
            <td class="input">
            <html:select style="width:30%" name="prpLclaimDto" property="caseType" onchange="changeCaseType(this)">
             <%if ("CANCELEDIT".equals(editType)||"CANCELSHOW".equals(editType)||"UNCANCEL".equals(editType)){%>
                 <logic:equal name="prpLclaimDto" property="caseType" value="0">
                   <html:option value="0" >注销</html:option>
                 </logic:equal>
                 <logic:equal name="prpLclaimDto" property="caseType" value="1">
                   <html:option value="1" >拒赔</html:option>
                 </logic:equal>
                 <input type="hidden" name="caseType" id="caseType" value="<bean:write name="prpLclaimDto" property="caseType"/>" />
             <%}else{%>
               	<html:option value="0" >注销</html:option>
                <html:option value="1" >拒赔</html:option>
                <input type="hidden" name="caseType" id="caseType" value="" />
             <%}%>
             </html:select>
            </td>
            <td class="title" >注销/拒赔原因</td>
            <td class="input" id="prpCancel" colspan="3">
                <select style="width:60%" name="prpCancel" id="prpCancelReson">
                    <option value="">----- 请选择 -----</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="1">selected</logic:equal> value="1">客户报错案</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="2">selected</logic:equal> value="2">客户重复报案</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="3">selected</logic:equal> value="3">不属于投保险别出险</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="4">selected</logic:equal> value="4">不属于投保险种出险</option>
                    <option <logic:equal name="prpLclaimDto" property="cancelReasonExplan" value="5">selected</logic:equal> value="5">业务员操作错误</option>
                </select>
            </td> 
            <td class="input" id="prpExclusions" colspan="3" style="display:none">
                <select style="width:60%" name="prpExclusions">
                    <option value="0">不属于保险责任</option>
                </select>
            </td> 
         </tr>
          <tr>
            <td class="title" >被保险人:</td>
            <td class="input">
               <input type=text name="prpLclaimInsuredName" title="被保险人" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">

            </td>

            <td class="title" >保单号：
            </td>
            <td class="input">
                <input type=text name="prpLclaimPolicyNo" title="保单号" readOnly class="readonly"  value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
            </td>
         </tr>

        <!--原因：非车险不要以下信息-->
        <logic:equal name="com.sinosoft.type" value="05">
          <tr>
            <td class="title" >车牌号:</td>
            <td class="input">
               <input type=text name="prpLregistLicenseNo" title="车牌号" readOnly class="readonly" value="<bean:write name='prpLregistDto' property='licenseNo' filter='true' />">

            </td>

            <td class="title" >厂牌型号：
            </td>
            <td class="input">
                <input type=text name="prpLregistBrandName" title="厂牌型号" readOnly class="readonly"  value="<bean:write name='prpLregistDto' property='brandName' filter='true' />">

            </td>
         </tr>
       </logic:equal>

          <tr>
            <td class="title" >出险时间:</td>
            <td class="input">
               <input type=text name="prpLclaimDealerName" title="出险时间" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">

            </td>

            <td class="title" >出险地点：
            </td>
            <td class="input">
                <input type=text name="prpLclaimDamageAddress" title="出险地点" readOnly class="readonly"  value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />">

            </td>
         </tr>
         <tr>
            <td class="title" ><%if ("CANCELSHOW".equals(editType)){%>
              操作人：
            <%}else{%>
              申请人:
            <%}%>
            
            </td>
            <td class="input">
               <input type="hidden" name="prpLclaimDealerCode" title="注销赔案申请人" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='dealerCode' filter='true' />">
               <input type=text name="prpLclaimDealerName" title="注销赔案申请人" readOnly class="readonly" value="<bean:write name='prpLclaimDto' property='dealerName' filter='true' />">

            </td>

            <td class="title" >
            <%if ("CANCELSHOW".equals(editType)){%>
              操作时间：
            <%}else{%>
              申请时间：
            <%}%>
            </td>
            <td class="input">
                <input type=text name="prpLclaimCancelDate" title="申请时间" readOnly class="readonly"  value="<bean:write name='prpLclaimDto' property='cancelDate' filter='true' />">

            </td>
         </tr>
         

         <tr>
             <td class="title" colspan="<%=colspan %>">
              注销/拒赔说明：
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
                 if (strRiskClass.equals("27") || strRiskClass.equals("26")) {  //意健险需要根据模板生成不予立案文本 2005-08-09
             %>
             <input type="button" name="btnRegistText" class=bigbutton value="生成不予立案文本" onclick="return generateNoClaimText();">
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
          <!--取消按钮-->
	    <td class=button style="width:25%" align="center">
	      <input type=button name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-1);" >
        </td>
     <%		}
     }else{%>
        <tr >
           <%if (!"UNCANCEL".equals(editType)){ %>
      	   <td class=button style="width:25%" align="center">
              <!--确 定按钮-->
              <input type=button name=buttonSave class='button' value="<bean:message key='button.submit.value' />" onClick="submitForm('4');">
           </td>
	   
	      <!--取消按钮-->
	       <td class=button style="width:25%" align="center">
	      <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="javascript:history.go(-1);" >
        </td>
        
        
        <!--Modify by ww add start 2005-11-24
          //Reason: 添加注销/拒赔退回功能-->
          <%
          if ("CANCELEDIT".equals(editType)) {
          %>
           <td class=button style="width:25%" align="center">
              <!--退回按钮-->
              <input type=button name=buttonBack class='button' value="退回申请" onClick="return submitForm('5');">
           </td>
          <%
          }
          %>
          
          <%} %>
          
          <td>
               <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
          </td>
        <!--Modify by ww add end 2005-11-24-->
     <%}%>   
        
	      <input type=hidden name="editType" title="操作类型" class="readonly" value="<bean:write name='prpLclaimDto' property='editType' filter='true' />">
        <input type=hidden name="nodeType" title="节点类型" class="readonly" value="<%=request.getParameter("nodeType")%>">
        <input type=hidden name="businessNo" title="业务号码" class="readonly" value="<%=request.getParameter("bussinessNo")%>">
        <input type=hidden name="prpLcancelclaimPrintFlag" title="业务号码" class="readonly" value='0'>

 </tr>
     </table>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
