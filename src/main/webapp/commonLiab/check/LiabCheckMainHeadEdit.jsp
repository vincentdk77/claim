<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��
* AUTHOR     : liubvo
* CREATEDATE : 2004-06-03 
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<!--add by liuyanmei 20051206 start -->
<%
 String comCode = "";
 String comName = "";
 UserDto  user   = (UserDto)session.getAttribute("user");
 if (user==null){
     comCode = "";
     comName = "";
 	}else{
     comCode = user.getComCode();
     comName = user.getComName(); 
     }%>
 
<!--add by liuyanmei 20051206 end reason:�Զ���������Ա�������Ż���������-->
  
<%--//add by wangli 20050601 reason:ϵͳ�ڴ�prpdcompany������ϵͳ����ӿͻ����ϱ�prpdcustomer_unit��ȡֵ--%>
<script language="javascript">
 function selectHandleCodeByUnitType(fieldObject){
   
   var unitType = fm.unitType.value;
  // alert(fieldObject);
  // alert(unitType);  
  // fm.prpLcheckHandleUnitCode.value = ""; 
    if(unitType==1){
    code_CodeSelect(fieldObject, 'ComCode');
    }else{
    code_CodeSelect(fieldObject, 'CustomerUnit');
    }      
 }
     
      function clearHandleUnitCode(){
       fm.prpLcheckHandleUnitCode.value = ""; 
       fm.prpLcheckHandleUnitName.value = "";
      }
</script>

    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
       <td width="30%">  
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr> 
              <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
              <td class="formtitle">�鿱�Ǽ�</td>
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
       <td><input type="button" name="prpLmessageSave" class="bigbutton" value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLcheckRegistNo.value,fm.prpLcheckPolicyNo.value,fm.prpLcheckRiskCode.value,'check',fm.prpLcheckClaimNo.value,'registNo',fm.prpLcheckRegistNo.value);"></td>
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLcheckDto' property='registNo'/>','check')"></td>
       <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       <td width="70%" align="right"><font color="#666666">��ע:��<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>

    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
      <tr>
        <td class="title" colspan="2">�鿱�Ǽ�
          <input type="hidden" name="referKind">
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="riskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
          <input type="hidden" name="prpLcheckReferSerialNo" value="<bean:write name='prpLcheckDto' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag" value="<bean:write name='prpLcheckDto' property='insureCarFlag' filter='true' />">    
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          <input type="hidden" name="registno" value="<bean:write name='prpLcheckDto' property='registNo'/>">
          <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDto' property='policyNo'/>">
        </td> 
         <td class="title">��������:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr>
      
      <tr> 
        <td class="title" style="width:15%" style="valign:bottom" >������:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input type=text name="prpLcheckRegistNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
        </td>        
        <td class="title" style="width:15%">������:</td>
        <td class="input" style="width:35%" >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
      </tr>
        
      <tr>         
        <td class="title" style="width:15%">������:</td>
        <td class="input" style="width:55%" colspan=3>
          <input type="text" name="prpLcheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='policyNo'/>"><input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcheckPolicyNo.value);return false;">         
          <img src="/claim/images/bgMarkMustInput.jpg">

          <input type="hidden" name="damageDate" value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> ">
          <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
        </td>
      </tr>
      <tr>         
        <td class="title" >�������ˣ�</td>
        <td class="input"  colspan="3">
          <input type="text" name="insuredName" style="width:40%" class="readonly" readonly="true"  value="<bean:write name='prpLcheckDto' property='insuredName'/>">
        </td>
      </tr>
      <tr>         
        <td class="title" >����ʱ�䣺</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> ��">
        </td>

        <td class="title" style="width:15%">���յص㣺</td>
        <td class="input" >
          <input type="text" name="prpLcheckDamageAddress" class="input" style="width:140px" value="<bean:write name='prpLcheckDto' property='damageAddress'/>">
        </td>      
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">�鿱����:</td>
        <td class="input" style="width:35%" >
          <html:select name='prpLcheckDto' property='checkType' >
            <html:option value="L">�鿱</html:option>
            <html:option value="D">���鿱</html:option>
           </html:select>
        </td>
        
         <td class="title" style="width:15%">�鿱����:</td>
        <td class="input" style="width:35%" >
          <input type="text" name="prpLcheckCheckDate" class="input" onblur="checkFullDate(this)" style="width:140px" value="<bean:write name='prpLcheckDto' property='checkDate'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
       
      </tr>
      
      <tr>         
        <td class="title" style="width:15%" style="valign:bottom" >�鿱����:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <html:select name="prpLcheckDto" property="checkNature" styleClass="three">
              <html:options collection="checkNatures" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        
        <td class="title" style="width:15%">�ѳ��մ���:</td>
        <td class="input" style="width:35%">
        <%-- ������Ϣ���� --%>
           <%@include file="/commonLiab/regist/LiabExistRegist.jsp"%>                
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">�鿱�ص�:</td>
        <td class="input" style="width:35%" colspan="3">
          <input type="text" name="prpLcheckCheckSite" class="input" style="width:440px" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">�鿱�� 1:</td>
        <td class="input" style="width:35%" >
          <input name='prpLcheckChecker1' class='input' maxlength=20 style="width:140px" description="�鿱��1" value="<bean:write name='prpLcheckDto' property='checker1'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </select>
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >�鿱�� 2:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name='prpLcheckChecker2' class='input' maxlength=20 style="width:140px" description="�鿱��2" value="<bean:write name='prpLcheckDto' property='checker2'/>">
         
        </td>
      </tr>
      <tr>         
        <td class="title" style="width:15%">����ԭ��</td>
        <td class="input" style="width:35%" >
          <input name="prpLcheckDamageCode" class="codecode" style="width:40px" maxlength=3 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
          <input name="prpLcheckDamageName" class="codename"  style="width:110px" maxlength=20 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageName'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>         
        <td class="title" style="width:15%"></td>
        <td class="input" style="width:35%" ></td>
       </tr>
      
      <tr>
      <td class='title' id='tdTitleCheckUnitName'>�鿱����λ:</td>
        <td class="input" >
          <html:select name='prpLcheckDto' property='unitType' onchange="clearHandleUnitCode();">
            <html:option value="1">ϵͳ��</html:option>
            <html:option value="0">ϵͳ��</html:option>
           </html:select>     
           </td>
          <td class="input" colspan='2'>
            <!--add by liuyanmei 20051206 start  reason:�Զ���������Ա�������Ż���������-->      
       <logic:notEmpty name='prpLcheckDto' property='handleUnitCode' >    
          <input name="prpLcheckHandleUnitCode" class="codecode" style="width:100px" maxlength=20 description="�鿱����λ����" value="<bean:write name='prpLcheckDto' property='handleUnitCode'/>"
             ondblclick="selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);"
             onkeyup= "selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);">
          <input name="prpLcheckHandleUnitName" class="readonly"  style="width:200px" maxlength=60 description="�鿱����λ" value="<bean:write name='prpLcheckDto' property='handleUnit'/>">
      </logic:notEmpty>     
      <logic:empty name='prpLcheckDto' property='handleUnitCode' > 
            <input name="prpLcheckHandleUnitCode" class="codecode" style="width:100px" maxlength=20 description="�鿱����λ����" value="<%=comCode%>" 
               ondblclick="selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);"
               onkeyup= "selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);">
            <input name="prpLcheckHandleUnitName" class="readonly"  style="width:200px" maxlength=60 description="�鿱����λ" value="<%= comName%>">  
      </logic:empty>
<!--add by liuyanmei 20051206 end -->
  <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
          </td>        
        <input type=hidden name='prpLcheckCheckUnitName'  style="width:93%" maxlength=30 description="�鿱����λ" value="<bean:write name='prpLcheckDto' property='checkUnitName'/>">
      </tr>
