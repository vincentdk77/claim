<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��
* AUTHOR     : liubvo
* CREATEDATE : 2004-06-03 
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
%> 
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
       <td><input type="button" name="prpLmessageSave" class="bigbutton" value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLcheckRegistNo.value,fm.prpLcheckPolicyNo.value,fm.prpLcheckRiskCode.value,'check','','registNo',fm.prpLcheckRegistNo.value);"></td>
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLcheckDto' property='registNo'/>','check')"></td>
       <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       <td width="70%" align="right"><font color="#666666">��ע:��<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>

    <table  border="0" align="center" cellpadding="4" cellspacing="1"  class="title" width="100%">
      <tr>
        <td class="title" colspan="2">�鿱�Ǽ�
          <input type="hidden" name="referKind">
          <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="riskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
          <input type="hidden" name="prpLcheckReferSerialNo" value="<bean:write name='prpLcheckDto' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag" value="">    
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDto' property='policyNo'/>">  
          <input type="hidden" name="registno" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
        </td> 
        <td class="title">��������:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr>
      
      <tr>        
        <td class="title"  style="valign:bottom" >������:</td>
        <td class="input"  style="valign:middle">
          <input type=text name="prpLcheckRegistNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
        </td> 
        <td class="title" >������:</td>
        <td class="input"  >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
      </tr>
        
      <tr>         
        <td class="title" >������:</td>
        <td class="input" style="width:55%" colspan="3">
          <input type="text" name="prpLcheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='policyNo'/>"><input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcheckPolicyNo.value);return false;">         
          <img src="/claim/images/bgMarkMustInput.jpg">
           <input type="hidden" name="damageDate" value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' />">
          <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
        </td>
      </tr>
      
      
      <tr>         
        <td class="title" >�鿱����:</td>
        <td class="input"  >
          <html:select name='prpLcheckDto' property='checkType' >
            <html:option value="L">�鿱</html:option>
            <html:option value="D">���鿱</html:option>
            <html:option value="P">�������</html:option>
            <html:option value="G">����</html:option>
            <html:option value="Q">����</html:option>
         </html:select>
        </td>
        
         <td class="title" >�鿱����:</td>
        <td class="input"  >
          <input type="text" name="prpLcheckCheckDate" class="input" onblur="checkFullDate(this)" style="width:140px" value="<bean:write name='prpLcheckDto' property='checkDate'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
       
      </tr>
      
      <%--
      <tr>         
        <td class="title"  style="valign:bottom" >�鿱����:</td>
        <td class="input"  style="valign:middle">
          <html:select name="prpLcheckDto" property="checkNature" styleClass="three">
              <html:options collection="checkNatures" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        
        <td class="title" >�ѳ��մ���:</td>
        <td class="input" >
        <%-- ������Ϣ���� 
           <%@include file="/commonShip/regist/ShipExistRegist.jsp"%>                
        </td>
      </tr>
      --%>
      
    
     <tr>         
        <td class="title" >����ʱ��:</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> "> 
          <%--
            <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> ��
          --%>
        </td>

        <td class="title" >���յص�:</td>
        <td class="input" >
          <input type="text" name="prpLcheckDamageAddress" class="input"  style="width:140px" value="<bean:write name='prpLcheckDto' property='damageAddress'/>">
        </td>      
      </tr>
      
      <tr>         
        <td class="title" >�鿱�ص�:</td>
        <td class="input"  colspan="3">
          <input type="text" name="prpLcheckCheckSite" class="input" style="width:440px" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" >�鿱�� 1:</td>
        <td class="input"  >
          <input name='prpLcheckChecker1' class='input' maxlength=20 style="width:140px" description="�鿱��1" value="<bean:write name='prpLcheckDto' property='checker1'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </select>
        </td>
        <td class="title"  style="valign:bottom" >�鿱�� 2:</td>
        <td class="input"  style="valign:middle">
          <input name='prpLcheckChecker2' class='input' maxlength=20 style="width:140px" description="�鿱��2" value="<bean:write name='prpLcheckDto' property='checker2'/>">
        </td>
      </tr>
      <tr>         
        <td class="title" >����ԭ��:</td>
        <td class="input"  >
           <select name= "theMain" style="width:80px">
               <option value="9000">����</option>
               <option value="9500">��Ȼ�ֺ���</option>
               <option value="9600">�����¹���</option>
               <option value="9700">������</option>
           </select>
          <input name="prpLcheckDamageCode" class="codecode" style="width:100px"  maxlength=3 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
        </td>         
        <td class="title" >
          <input name="prpLcheckDamageName" class="codename"   maxlength=20 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageName'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg"></td>
        <td class="input"  ></td>
      </tr>
     

      <tr>
      <td class='title' id='tdTitleCheckUnitName'>�鿱����λ:</td>
      <td class='input' colspan='3'>
        <input name='prpLcheckCheckUnitName' class='input' style="width:93%" maxlength=30 description="�鿱����λ" value="<bean:write name='prpLcheckDto' property='checkUnitName'/>">
        <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
      </td>    
      </tr>