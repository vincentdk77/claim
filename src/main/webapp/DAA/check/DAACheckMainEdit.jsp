<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-03 
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%> 

<%
    //ȡ����ϵͳ�ĵ�ַ
    String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
    if(userDto == null){
        isShowButton = false;
    }
%>
 
<script language="javascript">
function showRegistInfo(){
    var win;
    //var registShowDo="/claim/NoEndCaseSumDetailList.do?conditions="+fm.conditions.value;
   
    var registShowDo="/claim/registFinishQueryList.do?prpLregistRegistNo=" +fm.prpLcheckRegistNo.value+"&editType=SHOW&riskCode="+fm.prpLcheckRiskCode.value
    
    
    var newWindow = window.open(registShowDo,"DAARegistEdit",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
    newWindow.focus();
  }
  
  /**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relatePolicy(){	 
		var policyNo = fm.prpLcheckPolicyNo.value; 
	  var linkURL = "http://192.168.60.12:8101/ddccallweb/DAA/tbcbpg/UIPrPoEnDAAShow.jsp?"
	                     + "BIZTYPE=POLICY"
	                     + "&BizNo=" + policyNo 
	                     + "&SHOWTYPE=SHOW";
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 
/**
 *@description ���������Ļ��� 
 *@param       �� 
 *@return      ͨ������true,�� �򷵻�false
 */
function relateRegist(){	 
		var registNo = fm.prpLcheckRegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskcode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

     
    /**
     *@description ���û���ĳ�ʼֵ
     *@param       ��
     *@return      ͨ������true,���򷵻�false
     */
  	  function loadCheckExt()
  	  {
  <%
  	      ArrayList checkExtArray = null; 
  			if(((PrpLcheckExtDto)request.getAttribute("prpLcheckExtDto")).getPrpLcheckExtList()!=null){		
    		  checkExtArray = (ArrayList)((PrpLcheckExtDto)request.getAttribute("prpLcheckExtDto")).getPrpLcheckExtList();
    		  int intValue = -1;
    			int indexCheckExt = 0;
    		  for(indexCheckExt=0;indexCheckExt<checkExtArray.size();indexCheckExt++){
    		    PrpLcheckExtDto prpLcheckExtDto1 = new PrpLcheckExtDto();
    		    prpLcheckExtDto1 = (PrpLcheckExtDto)checkExtArray.get(indexCheckExt);
    	
    		    intValue = -1;
    		    if(prpLcheckExtDto1.getColumnValue().trim().equals("1"))
    		    	intValue = 0;
    		    else if(prpLcheckExtDto1.getColumnValue().trim().equals("0"))
    		    	intValue = 1;
          //modify by lixiang add 20050311 start
          //reason:�鿱��չ��Ϣ����ɫ������֣�����һ����ȷ��ѡ��
                   else if(prpLcheckExtDto1.getColumnValue().trim().equals("2"))
    		    	intValue = 2;
    	  //modify by lixiang add 20050311 end
    	
    		   	if(intValue>-1)
    		   	{
  %>
    	    fm.<%=prpLcheckExtDto1.getColumnName()%>['<%=intValue%>'].checked = true;
  <%
    				}
    			}
  			}
  %>
  	  } 

</script>  
  
    <table class="common" align="center" width="100%"> 
    <tr>
       <td width="30%">  
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr>  
              <%--<td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>--%>
              <td   class="formtitle">�鿱�Ǽ�</td>
              <%--<td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>--%>
            </tr>
          </table>
      </td> 
      <%if(isShowButton){ %>
       <td><input type="button" name="prpLmessageSave" class="bigbutton" value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLcheckRegistNo.value,fm.prpLcheckPolicyNo.value,fm.prpLcheckRiskCode.value,'check','','registNo',fm.prpLcheckRegistNo.value);"></td>
      <%} %> 
       <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       <%--
       <td><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       
       <td><input type="button" name="prpLmessageSave" value="��������" onclick="openWinSave()"></td>
       <td><input type="button" name="prpLmessageView" value="�鿴����" onClick="openWinQuery()"></td>
       <td><input type="button" name="eCertify" value="���ӵ�֤" onClick="openCertify('<bean:write name='prpLcheckDto' property='registNo'/>')"></td>  
       --%>
        <!-- Modify By wangli add end 20050328-->
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLcheckDto' property='registNo'/>','check')"></td> 
       <td class=button><input class=button type="button" name="certifyDirectPrint" value="������֪" onClick="certifyDirectList('<bean:write name='prpLcheckDto' property='registNo'/>','certi')"></td> 
       <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table> 

     <table class="common" align="center" width="100%"> 
      <tr>
        <td class="title" colspan="4">�鿱�Ǽ�  
          <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
          <input type="hidden" name="referKind" value="<bean:write name='prpLcheckDto' property='referKind'/>">
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckCheckUnitName"  value="<bean:write name='prpLcheckDto' property='checkUnitName'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
   
          <input type="hidden" name="prpLcheckReferSerialNo" value="<bean:write name='prpLcheckDto' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag" value="<bean:write name='prpLcheckDto' property='insureCarFlag' filter='true' />">    
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          
          <input type="hidden" name="checkNature" value="<bean:write name='prpLcheckDto' property='checkNature' filter='true' />">      
          <input type="hidden" name="damageAddressType" value="<bean:write name='prpLcheckDto' property='damageAddressType' filter='true' />">    
          <input type="hidden" name="hasExtColumn" value="0">
          <%
             if(((PrpLcheckExtDto)request.getAttribute("prpLcheckExtDto")).getPrpLcheckExtList()!=null){
              if(((PrpLcheckExtDto)request.getAttribute("prpLcheckExtDto")).getPrpLcheckExtList().size()>0){
          %>
          <input type="hidden" name="hasExtColumn" value="1">
          <%
              }
            }
          %>          
        </td> 
      </tr>
      
      <tr>         
        <td class="title" style="width:15%" style="valign:bottom">�����ţ�</td>
        <td class="input" style="width:35%" style="valign:bottom">
          <input type="text" name="prpLcheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='policyNo'/>">
          <%---- Ӧ���ղ�������ʱ���α�����Ϣ
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcheckPolicyNo.value);return false;">
          ----%>
          <% 
            //add by zhaolu start at 2006-6-9
            //reason:ǿ����ʾ
             if(request.getAttribute("prpLregistRPolicyNo")!= null)
             {
          %>
       
         <input type="text" name="prpLRegistRPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistRPolicyNo' property='policyNo'/>">
       <%---- Ӧ���ղ�������ʱ���α�����Ϣ
         <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();"><logic:notEqual name="prpLregistRPolicyNo" property="policyNo" value="">&nbsp;&nbsp<input type=button class="bigbutton"  name="policyBackWard" value="ǿ�Ʊ�����Ϣ" onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>',fm.prpLcheckDamageStartDate.value);"></logic:notEqual></td>
         ----%>
         <%
             }
          	//add by zhaolu end at 2006-6-9
         %>
           
       
                
        <td class="title" >������:</td>
        <td class="input" >
          <input type=text name="prpLcheckRegistNo" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
          <img name=btshowRegistInfo src="/claim/images/bgmore.gif" title="��ʾ������Ϣ" border="0"	hspace="5" width="16" height="16"  onclick="relateRegist();return false;">    
          
        </td>
        <input type="hidden" name="damageDate" value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' />">
      </tr>
      <tr> 
        <td class="title" style="width:15%" style="valign:bottom">������:</td>
        <td class="input" style="width:35%" style="valign:bottom" >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
         <td class="title" >�ѳ��մ���:</td>
        <td class="input" >    
        <%-- ������Ϣ���� --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>  
        </td>
      </tr>
    
     <tr>         
        <td class="title" >����ʱ�䣺</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> ��">
        </td>

        <td class="title" style="width:15%">���յص㣺</td>
        <td class="input" >
          <input type="text" name="prpLcheckDamageAddress" class="input"  style="width:140px" value="<bean:write name='prpLcheckDto' property='damageAddress'/>">
        </td>
        
      
      </tr>
      
      
      <tr>
        <td class="title" >�鿱���ڣ�</td>
        <td class="input" >
          <input type="text" name="prpLcheckCheckDate" class="input" style="width:140px" value="<bean:write name='prpLcheckDto' property='checkDate'/>" onblur="checkFullDate(this)">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <td class="title" >�鿱�ص㣺</td>
        <td class="input" >
          <input type="text" name="prpLcheckCheckSite" class="input" style="width:85%" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr>
        <td class="title" >�Ƿ��һ�ֳ���</td>
        <td class="input"  >
        	<html:radio  name="prpLcheckDto" property="firstSiteFlag" value="0"/>��
        	<html:radio  name="prpLcheckDto" property="firstSiteFlag" value="1"/>��
        </td>
        
        <td class="title" >�鿱���ͣ�</td>
        <td class="input" >
          <html:select name="prpLcheckDto" property="checkType" >
            <html:option value="L" >�鿱</html:option>
            <html:option value="D">���鿱</html:option>
            <%--<html:option value="B">���鿱</html:option>--%>
           </html:select>
        </td>
      </tr>
      
      <tr>         
        <td class="title" >�鿱�� 1��</td>
        <td class="input" >
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
        <td class="title" style="width:15%">����ԭ��</td>
        <td class="input" style="width:35%" >
          <input name="prpLcheckDamageCode" class="codecode" style="width:40px" maxlength=3 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onchange="code_CodeChange(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');"
             onclick = "clearInput(this);">
          <input name="prpLcheckDamageName" class="codename"  style="width:110px" maxlength=20 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageName'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >�¹�ԭ��</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name="prpLcheckDamageTypeCode" class="codecode" style="width:40px" maxlength=3 description="�¹�ԭ��" value="<bean:write name='prpLcheckDto' property='damageTypeCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onchange="code_CodeChange(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');"
             onclick = "clearInput(this);">
          <input name="prpLcheckDamageTypeName" class="codename"  style="width:110px" maxlength=20 description="�¹�ԭ��" value="<bean:write name='prpLcheckDto' property='damageTypeName'/>"
            ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageTypeCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%" style="valign:middle">��������</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name="prpLcheckDamageAreaCode" class="codecode" style="width:40px" description="��������" value="<bean:write name='prpLcheckDto' property='damageAreaCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode');"
             onchange="code_CodeChange(this, 'DamageAreaCode');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');"
             onclick = "clearInput(this);">
          <input name="prpLcheckDamageAreaName" class="codename" style="width:110px" description="��������" value="<bean:write name='prpLcheckDto' property='damageAreaName'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageAreaCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      
    
      
       <td class="title" style="width:15%" style="valign:middle">���ƺ��룺</td>
        <td class="input" style="width:35%" style="valign:middle">
         <%-- modify by caopeng add 20051219 start --%>
          <input type="text" name="lossItemName" class="readonly" readonly="true" style="width:90%" value="<bean:write name='prpLcheckDto' property='lossItemName'/>">
         <%-- modify by caopeng add 20051219 end --%>
          <input type="hidden" name="lossItemCode" class="readonly" readonly="true"  value="<%=request.getParameter("lossItemCode")%>">
         
        </td>
        <!--
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
      --> 
      <tr>         
        <td class="title" style="width:15%">�¹����Σ�</td>
        <td class="input" style="width:35%" >
          <html:select name="prpLcheckDto" property="indemnityDuty" styleClass="three" onclick="changeIndemnityDuty();">
              <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        <!--td class="title" style="width:15%" style="valign:bottom" >�Ƿ����ڱ������Σ�</td>-->
        <!--td class="input" style="width:35%" style="valign:middle">
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="1"/>��
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="2"/>����
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="3"/>�޷�ȷ��
        </td-->
        <td class="title" style="width:15%">�ⰸ���</td>
        <td class="input" style="width:35%" >
        	<html:select name="prpLcheckDto" property="claimType" styleClass="three"  style="width:120px">
              <html:options collection="claimTypes" property="codeCode"   labelProperty="codeCName"/>
          </html:select>
         </td>
      </tr> 
      <!--Modify by chenrenda add begin 20050405-->
      <!--Reason:�ڲ鿱ҳ���������Ƿ����������չ�˾Ͷ����-->
<!--      
       <tr>         
        <td class="title">�Ƿ����������չ�˾Ͷ��:</td>
        <td class="input">
          <html:radio  name="prpLcheckDto" property="repeatInsureFlag" value="Y"/>��
          <html:radio  name="prpLcheckDto" property="repeatInsureFlag" value="N"/>��   
          <img src="/claim/images/bgMarkMustInput.jpg">      
        </td>
        <td  class="title" colspan="2">
        </td>
      </tr> 
-->      
      <!--Modify by chenrenda add end 20050405-->
      
        <%--modify by wangli add start 20050407--%>    
      <!--<tr>         
        <td class="title" style="width:15%">�����ţ�</td>
        <td class="input" style="width:85%" colspan="3">
        <input type ="input" name="prpLcheckHandleUnit" class="codecode" style="width:40%" description="�����Ŵ���" value="<bean:write name='prpLcheckDto' property='handleUnit'/>"
             ondblclick="code_CodeSelect(this, 'ComCode');"
             onkeyup= "code_CodeSelect(this, 'ComCode');">
             
        <input name='prpLcheckHandleUnitName' class='codename' maxlength=60  style="width:45%" description="������"  value="<bean:write name='prpLcheckDto' property='handleUnitName'/>"
             ondblclick="code_CodeSelect(this, 'ComCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'ComCode','-1','always','none','post');">
             <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        </td>
      </tr> 
      -->     
        <tr>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerName" title="��ϵ��" class="ReadOnly" ReadOnly style="width:120px" value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
        </td>
        <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
          <input type=text name="prpLregistPhoneNumber" title="��ϵ�绰" class="ReadOnly" ReadOnly style="width:120px" value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">       
          <img src="/claim/images/bgMarkMustInput.jpg"> 
        </td> 
      </tr>
        <tr>									  
        <td class="title" style="width:15%">��ϵ�˵�ַ:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLregistInsuredAddress"  class="ReadOnly" ReadOnly value="<bean:write name='prpLregistDto' property='insuredAddress' filter='true' />">
        </td>   
        
        <td class="title" style="width:15%">��ϵ���ʱ�:</td>   
        <td class="input" style="width:35%">
          <input type=text name="prpLregistDamageAreaPostCode" class="ReadOnly" ReadOnly maxlength=6 style="width:120px" description="���յ���������" value="<bean:write name='prpLregistDto' property='linkerPostCode' filter='true' />">
        </td>
      </tr>
      <%--modify by wangli add end 20050407--%>       
      
      <tr>         
        <td class="title" style="width:15%">��ע��</td>
        <td class="input" style="width:85%" colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength=80 style="width:440px" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
      </tr>      
      <%
      if (!editType.equals("SHOW")&&!editType.equals("DELETE"))
      {
      %>  
      <tr>         
        <td class="title" style="width:15%">�Զ����ȣ�</td>
        <td class="input" style="width:85%" colspan="3">
          <input type="radio" name="autoScheduleFlag" value="1" checked="checked">��
          <input type="radio" name="autoScheduleFlag" value="0">��
        </td>
      </tr> 
      <%} %>
    </table>
