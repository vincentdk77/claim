<%--
****************************************************************************
* DESC       �������������ߵ�����Ϣ�ӿ����ҳ��
* AUTHOR     �� lixiang
* CREATEDATE �� 2004-12-23 
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%> 
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
              <!-- Modify By wangli add begin 20050328-->
       <td><input type="button" name="prpLmessageSave" class="bigbutton" value="��������" onclick="openWinSave(fm.prpLcheckRegistNo.value,fm.prpLcheckPolicyNo.value,fm.prpLcheckRiskCode.value,'check','');"></td>
       <td><input type="button" name="prpLmessageView" class="bigbutton" value="�鿴����" onClick="openWinQuery('registNo',fm.prpLcheckRegistNo.value);"></td>
        <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>');"></td> 
        <%--
       <td><input type="button" name="prpLmessageSave" class="bigbutton" value="��������" onclick="openWinSave()"></td>
       <td><input type="button" name="prpLmessageView" value="�鿴����" onClick="openWinQuery()"></td>
       <td><input type="button" name="eCertify" value="���ӵ�֤" onClick="openCertify()"></td> 
       --%>
       <!-- Modify By wangli add end 20050328-->
       <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>

    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title">
      <tr>
        <td class="title" colspan="4">�鿱�Ǽ�
          <input type="hidden" name="referKind">
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckCheckUnitName"  value="<bean:write name='prpLcheckDto' property='checkUnitName'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
          <input type="hidden" name="riskcode" value="<bean:write name='prpLcheckDto' property='riskCode' filter='true' />"> 
          <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDto' property='policyNo' filter='true' />">    
        </td> 
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">������:</td>
        <td class="input" style="width:35%" >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >������:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input type=text name="prpLcheckRegistNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
        </td>
      </tr>
        
      <tr>         
        <td class="title" style="width:15%">�����ţ�</td>
        <td class="input" style="width:55%" colspan="3">
          <input type="text" name="prpLcheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='policyNo'/>"><input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcheckPolicyNo.value);return false;">         
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">������� </td>
        <td class="input" style="width:85%" colspan="3">
          <input type="text" name="prpLcheckClauseName" class="readonly" readonly="true" style="width:440px" value="<bean:write name='prpLcheckDto' property='clauseName'/>">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">�鿱���ͣ�</td>
        <td class="input" style="width:35%" >
          <html:select name="prpLcheckDto" property="checkType" >
            <html:option value="L">�鿱</html:option>
            <html:option value="D">���鿱</html:option>
            <html:option value="B">���鿱</html:option>
           </html:select>
        </td>
        
        
        <td class="title" style="width:15%" style="valign:bottom" >�鿱���ʣ�</td>
        <td class="input" style="width:35%" style="valign:middle">
          <html:select name="prpLcheckDto" property="checkNature" styleClass="three">
              <html:options collection="checkNatures" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
      </tr>
      <tr>
        <td class="title" style="width:15%" style="valign:bottom" >�ⰸ���</td>
        <td class="input" style="width:35%" style="valign:middle">
          <html:select name="prpLcheckDto" property="claimType" styleClass="three">
              <html:options collection="caseCodes" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >���յص���ࣺ</td>
        <td class="input" style="width:35%" style="valign:middle">
          <html:select name="prpLcheckDto" property="damageAddressType" styleClass="three">
              <html:options collection="damageAddresss" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
      </tr>
      <tr>         
        <td class="title" style="width:15%">�鿱���ڣ�</td>
        <td class="input" style="width:35%">
          <input type="text" name="prpLcheckCheckDate" class="input" style="width:140px" value="<bean:write name='prpLcheckDto' property='checkDate'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">�ѳ��մ���:</td>
        <td class="input" style="width:35%">    
        <%-- ������Ϣ���� --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>  
        </td>
      </tr>

      <tr>         
        <td class="title" style="width:15%">�鿱�ص㣺</td>
        <td class="input" style="width:35%" colspan="3">
          <input type="text" name="prpLcheckCheckSite" class="input" style="width:440px" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">����ʱ�䣺</td>
        <td class="input" style="width:35%" colspan="3"><input type="text" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> ��">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">����ԭ��</td>
        <td class="input" style="width:35%" >
          <input name="prpLcheckDamageCode" class="codecode" style="width:40px" maxlength=3 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onchange="code_CodeChange(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
          <input name="prpLcheckDamageName" class="codename"  style="width:110px" maxlength=20 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageName'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >�¹�ԭ��</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name="prpLcheckDamageTypeCode" class="codecode" style="width:40px" maxlength=3 description="�¹�ԭ��" value="<bean:write name='prpLcheckDto' property='damageTypeCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onchange="code_CodeChange(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');">
          <input name="prpLcheckDamageTypeName" class="codename"  style="width:110px" maxlength=20 description="�¹�ԭ��" value="<bean:write name='prpLcheckDto' property='damageTypeName'/>"
            ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','name','none','post');"
            onchange="code_CodeChange(this, 'DamageTypeCode','-1','name','none','post');"
            onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','name','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">��������</td>
        <td class="input" style="width:35%" >
          <input name="prpLcheckDamageAreaCode" class="codecode" style="width:40px" description="��������" value="<bean:write name='prpLcheckDto' property='damageAreaCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode');"
             onchange="code_CodeChange(this, 'DamageAreaCode');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');">
          <input name="prpLcheckDamageAreaName" class="codename" style="width:110px" description="��������" value="<bean:write name='prpLcheckDto' property='damageAreaName'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageAreaCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">�Ƿ��һ�ֳ���</td>
        <td class="input" style="width:35%" >
        	<html:radio  name="prpLcheckDto" property="firstSiteFlag" value="0"/>��
        	<html:radio  name="prpLcheckDto" property="firstSiteFlag" value="1"/>��
        </td>
       
      </tr>
      
      <tr>         
        <td class="title" style="width:15%" rowspan="6">�¹����漰���֣�</td>
        <td class="input" style="width:35%" >
          <input type="checkbox" name="prpLcheckReferKind" value="A">������ʧ��
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >        
          <input type="checkbox" name="prpLcheckReferKind" value="B">������������
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="D1">������Ա������
        </td>
      </tr>
      <tr>         
        <td class="input" style="width:35%" >
          <input type="checkbox" name="prpLcheckReferKind" value="D2">���ϻ���������
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >       
        <input type="checkbox" name="prpLcheckReferKind" value="E">���֡���ը����ȼ��ʧ��
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="F">��������������
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="G">������
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >     
        <input type="checkbox" name="prpLcheckReferKind" value="J">������Լ����
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        &nbsp
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="K1">���ء�װж���ھ�����ʧ��
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >     
        <input type="checkbox" name="prpLcheckReferKind" value="K2">���ֳ����̶��豸����������
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="L">��������ʧ��
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="M">����������Լ����
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >     
        <input type="checkbox" name="prpLcheckReferKind" value="T">����ͣʻ��ʧ��
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="W">�޹�ʧ������
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="Z">��ȼ��ʧ��
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >        
          &nbsp;
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">�¹����Σ�</td>
        <td class="input" style="width:35%" >
          <html:select name="prpLcheckDto" property="indemnityDuty" styleClass="three">
              <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >�Ƿ����ڱ������Σ�</td>
        <td class="input" style="width:35%" style="valign:middle">
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="1"/>��
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="2"/>����
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="3"/>�޷�ȷ��
        </td>
      </tr> 
      
      <tr>         
        <td class="title" style="width:15%">�鿱�� 1��</td>
        <td class="input" style="width:35%" >
          <input name='prpLcheckChecker1' class='input' maxlength=20 style="width:140px" description="�鿱��1" value="<bean:write name='prpLcheckDto' property='checker1'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </select>
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >�鿱�� 2��</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name='prpLcheckChecker2' class='input' maxlength=20 style="width:140px" description="�鿱��2" value="<bean:write name='prpLcheckDto' property='checker2'/>">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">�����ţ�</td>
        <td class="input" style="width:85%" colspan="3">
        <input type ="input" name="prpLcheckHandleUnit" class="codecode" style="width:40%" description="�����Ŵ���" value="<bean:write name='prpLcheckDto' property='handleUnit'/>"
             ondblclick="code_CodeSelect(this, 'ComCode');"
             onchange="code_CodeChange(this, 'ComCode');"
             onkeyup= "code_CodeSelect(this, 'ComCode');">
             
        <input name='prpLcheckHandleUnitName' class='codename' maxlength=60  style="width:45%" description="������"  value="<bean:write name='prpLcheckDto' property='handleUnitName'/>"
             ondblclick="code_CodeSelect(this, 'ComCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'ComCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'ComCode','-1','name','none','post');">
             <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        </td>
      </tr>       
      
      <tr>         
        <td class="title" style="width:15%">��ע��</td>
        <td class="input" style="width:85%" colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength=80 style="width:440px" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
      </tr>        
    </table>