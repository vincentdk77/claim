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

<%@page import="java.util.*"%>

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
  
   
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
        <td class="title" colspan="4">�鿱�Ǽ�  
          <input type="hidden" name="referKind" value="<bean:write name='prpLcheckDto' property='referKind'/>">
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckCheckUnitName"  value="<bean:write name='prpLcheckDto' property='checkUnitName'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
   
          <input type="hidden" name="prpLcheckReferSerialNo" value="<bean:write name='prpLcheckDto' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag" value="<bean:write name='prpLcheckDto' property='insureCarFlag' filter='true' />">    
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          
          <input type="hidden" name="checkNature" value="<bean:write name='prpLcheckDto' property='checkNature' filter='true' />">    
          <input type="hidden" name="claimType" value="<bean:write name='prpLcheckDto' property='claimType' filter='true' />">    
          <input type="hidden" name="damageAddressType" value="<bean:write name='prpLcheckDto' property='damageAddressType' filter='true' />">    
          <input type="hidden" name="prpLcheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='policyNo'/>">
          <input type="hidden" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
          
          <input type="hidden" name="prpLcheckRegistNo" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
          <input type="hidden" name="prpLcheckCheckDate" class="input" style="width:140px" value="<bean:write name='prpLcheckDto' property='checkDate'/>">
          <input type="hidden" name="prpLcheckCheckSite" class="input" style="width:85%" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <input type="hidden" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> ��">
          <input type="hidden" name="prpLcheckDamageAddress" class="readonly"  readonly="true"  style="width:140px" value="<bean:write name='prpLcheckDto' property='damageAddress'/>">
          <input type="hidden" name='prpLcheckChecker1' class='input' maxlength=20 style="width:140px" description="�鿱��1" value="<bean:write name='prpLcheckDto' property='checker1'/>">        
          <input type="hidden" name='prpLcheckChecker2' class='input' maxlength=20 style="width:140px" description="�鿱��2" value="<bean:write name='prpLcheckDto' property='checker2'/>">          
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
            <html:option value="B">���鿱</html:option>
           </html:select>
        </td> 
      </tr>
  
      <tr>         
        <td class="title">����ԭ��</td>
        <td class="input"  >
          <input name="prpLcheckDamageCode" class="codecode" style="width:40px" maxlength=3 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onchange="code_CodeChange(this,'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
          <input name="prpLcheckDamageName" class="codename"  style="width:110px" maxlength=20 description="����ԭ��" value="<bean:write name='prpLcheckDto' property='damageName'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="valign:bottom" >�¹�ԭ��</td>
        <td class="input"  style="valign:middle">
          <input name="prpLcheckDamageTypeCode" class="codecode" style="width:40px" maxlength=3 description="�¹�ԭ��" value="<bean:write name='prpLcheckDto' property='damageTypeCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onchange="code_CodeChange(this,'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');">
          <input name="prpLcheckDamageTypeName" class="codename"  style="width:110px" maxlength=20 description="�¹�ԭ��" value="<bean:write name='prpLcheckDto' property='damageTypeName'/>"
            ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','name','none','post');"
            onchange="code_CodeChange(this, 'DamageTypeCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','name','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="valign:middle">��������</td>
        <td class="input"  style="valign:middle">
          <input name="prpLcheckDamageAreaCode" class="codecode" style="width:40px" description="��������" value="<bean:write name='prpLcheckDto' property='damageAreaCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode');"
             onchange="code_CodeChange(this,'DamageAreaCode');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');">
          <input name="prpLcheckDamageAreaName" class="codename" style="width:110px" description="��������" value="<bean:write name='prpLcheckDto' property='damageAreaName'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageAreaCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      
    
      
       <td class="title" style="valign:middle">���ƺ��룺</td>
        <td class="input"  style="valign:middle">
          <input type="text" name="lossItemName" class="readonly" readonly="true" style="width:90%" value="<%=request.getParameter("lossItemName")%>">
          <input type="hidden" name="lossItemCode" class="readonly" readonly="true"  value="<%=request.getParameter("lossItemCode")%>">
         
        </td>
      <tr>         
        <td class="title">�¹��⳥���Σ�</td>
        <td class="input"  >
          <html:select name="prpLcheckDto" property="indemnityDuty" styleClass="three" onchange="changeIndemnityDuty();">
              <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        <td class="title" style="valign:bottom" >�Ƿ����ڱ������Σ�</td>
        <td class="input"  style="valign:middle">
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="1"/>��
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="2"/>����
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="3"/>�޷�ȷ��
        </td>
      </tr>     
      
        <%--modify by wangli add start 20050407--%>    
      <tr>         
        <td class="title">�����ţ�</td>
        <td class="input" style="width:85%" colspan="3">
        <input type ="input" name="prpLcheckHandleUnit" class="codecode" style="width:40%" description="�����Ŵ���" value="<bean:write name='prpLcheckDto' property='handleUnit'/>"
             ondblclick="code_CodeSelect(this, 'ComCode');"
             onchange="code_CodeChange(this,'ComCode');"
             onkeyup= "code_CodeSelect(this, 'ComCode');">
             
        <input name='prpLcheckHandleUnitName' class='codename' maxlength=60  style="width:45%" description="������"  value="<bean:write name='prpLcheckDto' property='handleUnitName'/>"
             ondblclick="code_CodeSelect(this, 'ComCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'ComCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'ComCode','-1','name','none','post');">
             <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        </td>
      </tr>      
        <tr>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerName" title="��ϵ��" class="input"  value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
        </td>
        <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
          <input type=text name="prpLregistPhoneNumber" title="��ϵ�绰" class="input"  value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">       
          <img src="/claim/images/bgMarkMustInput.jpg"> 
        </td> 
      </tr>
        <tr>									  
        <td class="title">��ϵ�˵�ַ:</td>
        <td class="input" >
          <input type=text name="prpLregistInsuredAddress"  class="input" value="<bean:write name='prpLregistDto' property='insuredAddress' filter='true' />">
        </td>   
        
        <td class="title">��ϵ���ʱ�:</td>   
        <td class="input" >
          <input type=text name="prpLregistDamageAreaPostCode" class="input" maxlength=6  description="���յ���������" value="<bean:write name='prpLregistDto' property='damageAreaPostCode' filter='true' />">
        </td>
      </tr>
      <%--modify by wangli add end 20050407--%>       
      
      <tr>         
        <td class="title">��ע��</td>
        <td class="input" colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength=80  value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
      </tr>        
    </table>
