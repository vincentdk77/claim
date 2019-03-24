<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-03 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 

<%
    //取核心系统的地址
    String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
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
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
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
 *@description 弹出报案的画面 
 *@param       无 
 *@return      通过返回true,否 则返回false
 */
function relateRegist(){	 
		var registNo = fm.prpLcheckRegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskcode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

     
    /**
     *@description 设置画面的初始值
     *@param       无
     *@return      通过返回true,否则返回false
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
          //reason:查勘扩展信息用颜色间隔区分，增加一个不确定选项
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
              <td   class="formtitle">查勘登记</td>
              <%--<td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>--%>
            </tr>
          </table>
      </td> 
      <%if(isShowButton){ %>
       <td><input type="button" name="prpLmessageSave" class="bigbutton" value="理赔沟通" onclick="openWinSaveQuery(fm.prpLcheckRegistNo.value,fm.prpLcheckPolicyNo.value,fm.prpLcheckRiskCode.value,'check','','registNo',fm.prpLcheckRegistNo.value);"></td>
      <%} %> 
       <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       <%--
       <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       
       <td><input type="button" name="prpLmessageSave" value="讨论留言" onclick="openWinSave()"></td>
       <td><input type="button" name="prpLmessageView" value="查看留言" onClick="openWinQuery()"></td>
       <td><input type="button" name="eCertify" value="电子单证" onClick="openCertify('<bean:write name='prpLcheckDto' property='registNo'/>')"></td>  
       --%>
        <!-- Modify By wangli add end 20050328-->
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLcheckDto' property='registNo'/>','check')"></td> 
       <td class=button><input class=button type="button" name="certifyDirectPrint" value="索赔须知" onClick="certifyDirectList('<bean:write name='prpLcheckDto' property='registNo'/>','certi')"></td> 
       <td width="70%" align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">” 
      为双击选择项。</font></td>
    </tr>
    </table> 

     <table class="common" align="center" width="100%"> 
      <tr>
        <td class="title" colspan="4">查勘登记  
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
        <td class="title" style="width:15%" style="valign:bottom">保单号：</td>
        <td class="input" style="width:35%" style="valign:bottom">
          <input type="text" name="prpLcheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDto' property='policyNo'/>">
          <%---- 应车险部需求，暂时屏蔽保单信息
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcheckPolicyNo.value);return false;">
          ----%>
          <% 
            //add by zhaolu start at 2006-6-9
            //reason:强三显示
             if(request.getAttribute("prpLregistRPolicyNo")!= null)
             {
          %>
       
         <input type="text" name="prpLRegistRPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistRPolicyNo' property='policyNo'/>">
       <%---- 应车险部需求，暂时屏蔽保单信息
         <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();"><logic:notEqual name="prpLregistRPolicyNo" property="policyNo" value="">&nbsp;&nbsp<input type=button class="bigbutton"  name="policyBackWard" value="强制保单信息" onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>',fm.prpLcheckDamageStartDate.value);"></logic:notEqual></td>
         ----%>
         <%
             }
          	//add by zhaolu end at 2006-6-9
         %>
           
       
                
        <td class="title" >报案号:</td>
        <td class="input" >
          <input type=text name="prpLcheckRegistNo" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLcheckDto' property='registNo'/>">          
          <img name=btshowRegistInfo src="/claim/images/bgmore.gif" title="显示报案信息" border="0"	hspace="5" width="16" height="16"  onclick="relateRegist();return false;">    
          
        </td>
        <input type="hidden" name="damageDate" value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' />">
      </tr>
      <tr> 
        <td class="title" style="width:15%" style="valign:bottom">立案号:</td>
        <td class="input" style="width:35%" style="valign:bottom" >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
         <td class="title" >已出险次数:</td>
        <td class="input" >    
        <%-- 出险信息画面 --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>  
        </td>
      </tr>
    
     <tr>         
        <td class="title" >出险时间：</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> 时 <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> 分">
        </td>

        <td class="title" style="width:15%">出险地点：</td>
        <td class="input" >
          <input type="text" name="prpLcheckDamageAddress" class="input"  style="width:140px" value="<bean:write name='prpLcheckDto' property='damageAddress'/>">
        </td>
        
      
      </tr>
      
      
      <tr>
        <td class="title" >查勘日期：</td>
        <td class="input" >
          <input type="text" name="prpLcheckCheckDate" class="input" style="width:140px" value="<bean:write name='prpLcheckDto' property='checkDate'/>" onblur="checkFullDate(this)">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <td class="title" >查勘地点：</td>
        <td class="input" >
          <input type="text" name="prpLcheckCheckSite" class="input" style="width:85%" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr>
        <td class="title" >是否第一现场：</td>
        <td class="input"  >
        	<html:radio  name="prpLcheckDto" property="firstSiteFlag" value="0"/>否
        	<html:radio  name="prpLcheckDto" property="firstSiteFlag" value="1"/>是
        </td>
        
        <td class="title" >查勘类型：</td>
        <td class="input" >
          <html:select name="prpLcheckDto" property="checkType" >
            <html:option value="L" >查勘</html:option>
            <html:option value="D">代查勘</html:option>
            <%--<html:option value="B">被查勘</html:option>--%>
           </html:select>
        </td>
      </tr>
      
      <tr>         
        <td class="title" >查勘人 1：</td>
        <td class="input" >
          <input name='prpLcheckChecker1' class='input' maxlength=20 style="width:140px" description="查勘人1" value="<bean:write name='prpLcheckDto' property='checker1'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </select>
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >查勘人 2：</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name='prpLcheckChecker2' class='input' maxlength=20 style="width:140px" description="查勘人2" value="<bean:write name='prpLcheckDto' property='checker2'/>">
        </td>
      </tr>
      <tr>         
        <td class="title" style="width:15%">出险原因：</td>
        <td class="input" style="width:35%" >
          <input name="prpLcheckDamageCode" class="codecode" style="width:40px" maxlength=3 description="出险原因" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onchange="code_CodeChange(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');"
             onclick = "clearInput(this);">
          <input name="prpLcheckDamageName" class="codename"  style="width:110px" maxlength=20 description="出险原因" value="<bean:write name='prpLcheckDto' property='damageName'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%" style="valign:bottom" >事故原因：</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name="prpLcheckDamageTypeCode" class="codecode" style="width:40px" maxlength=3 description="事故原因" value="<bean:write name='prpLcheckDto' property='damageTypeCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onchange="code_CodeChange(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');"
             onclick = "clearInput(this);">
          <input name="prpLcheckDamageTypeName" class="codename"  style="width:110px" maxlength=20 description="事故原因" value="<bean:write name='prpLcheckDto' property='damageTypeName'/>"
            ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageTypeCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%" style="valign:middle">出险区域：</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input name="prpLcheckDamageAreaCode" class="codecode" style="width:40px" description="出险区域" value="<bean:write name='prpLcheckDto' property='damageAreaCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode');"
             onchange="code_CodeChange(this, 'DamageAreaCode');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');"
             onclick = "clearInput(this);">
          <input name="prpLcheckDamageAreaName" class="codename" style="width:110px" description="出险区域" value="<bean:write name='prpLcheckDto' property='damageAreaName'/>"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageAreaCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','post','clear');"
             onclick = "clearInput(this);">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      
    
      
       <td class="title" style="width:15%" style="valign:middle">车牌号码：</td>
        <td class="input" style="width:35%" style="valign:middle">
         <%-- modify by caopeng add 20051219 start --%>
          <input type="text" name="lossItemName" class="readonly" readonly="true" style="width:90%" value="<bean:write name='prpLcheckDto' property='lossItemName'/>">
         <%-- modify by caopeng add 20051219 end --%>
          <input type="hidden" name="lossItemCode" class="readonly" readonly="true"  value="<%=request.getParameter("lossItemCode")%>">
         
        </td>
        <!--
         </tr> 
       <tr>         
        <td class="title" style="width:15%" rowspan="6">事故所涉及险种：</td>
        <td class="input" style="width:35%" >
          <input type="checkbox" name="prpLcheckReferKind" value="A">车辆损失险
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >        
          <input type="checkbox" name="prpLcheckReferKind" value="B">第三者责任险
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="D1">车上人员责任险
        </td>
      </tr>
      <tr>         
        <td class="input" style="width:35%" >
          <input type="checkbox" name="prpLcheckReferKind" value="D2">车上货物责任险
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >       
        <input type="checkbox" name="prpLcheckReferKind" value="E">火灾、爆炸、自燃损失险
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="F">玻璃单独破碎险
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="G">盗抢险
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >     
        <input type="checkbox" name="prpLcheckReferKind" value="J">救助特约条款
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        &nbsp
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="K1">起重、装卸、挖掘车辆损失险
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >     
        <input type="checkbox" name="prpLcheckReferKind" value="K2">特种车辆固定设备、仪器损坏险
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="L">车身划痕损失险
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="M">不计免赔特约条款
        </td>
        <td class="input" style="width:15%" style="valign:bottom" >     
        <input type="checkbox" name="prpLcheckReferKind" value="T">车辆停驶损失险
        </td>
        <td class="input" style="width:35%" style="valign:middle">
        <input type="checkbox" name="prpLcheckReferKind" value="W">无过失责任险
        </td>
      </tr>
           
      <tr>         
        <td class="input" style="width:35%" >
        <input type="checkbox" name="prpLcheckReferKind" value="Z">自燃损失险
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
        <td class="title" style="width:15%">事故责任：</td>
        <td class="input" style="width:35%" >
          <html:select name="prpLcheckDto" property="indemnityDuty" styleClass="three" onclick="changeIndemnityDuty();">
              <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        <!--td class="title" style="width:15%" style="valign:bottom" >是否属于保险责任：</td>-->
        <!--td class="input" style="width:35%" style="valign:middle">
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="1"/>是
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="2"/>不是
        	<html:radio  name="prpLcheckDto" property="claimFlag" value="3"/>无法确定
        </td-->
        <td class="title" style="width:15%">赔案类别：</td>
        <td class="input" style="width:35%" >
        	<html:select name="prpLcheckDto" property="claimType" styleClass="three"  style="width:120px">
              <html:options collection="claimTypes" property="codeCode"   labelProperty="codeCName"/>
          </html:select>
         </td>
      </tr> 
      <!--Modify by chenrenda add begin 20050405-->
      <!--Reason:在查勘页面中增加是否向其它保险公司投保项-->
<!--      
       <tr>         
        <td class="title">是否向其它保险公司投保:</td>
        <td class="input">
          <html:radio  name="prpLcheckDto" property="repeatInsureFlag" value="Y"/>是
          <html:radio  name="prpLcheckDto" property="repeatInsureFlag" value="N"/>否   
          <img src="/claim/images/bgMarkMustInput.jpg">      
        </td>
        <td  class="title" colspan="2">
        </td>
      </tr> 
-->      
      <!--Modify by chenrenda add end 20050405-->
      
        <%--modify by wangli add start 20050407--%>    
      <!--<tr>         
        <td class="title" style="width:15%">处理部门：</td>
        <td class="input" style="width:85%" colspan="3">
        <input type ="input" name="prpLcheckHandleUnit" class="codecode" style="width:40%" description="处理部门代码" value="<bean:write name='prpLcheckDto' property='handleUnit'/>"
             ondblclick="code_CodeSelect(this, 'ComCode');"
             onkeyup= "code_CodeSelect(this, 'ComCode');">
             
        <input name='prpLcheckHandleUnitName' class='codename' maxlength=60  style="width:45%" description="处理部门"  value="<bean:write name='prpLcheckDto' property='handleUnitName'/>"
             ondblclick="code_CodeSelect(this, 'ComCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'ComCode','-1','always','none','post');">
             <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        </td>
      </tr> 
      -->     
        <tr>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerName" title="联系人" class="ReadOnly" ReadOnly style="width:120px" value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
        </td>
        <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
          <input type=text name="prpLregistPhoneNumber" title="联系电话" class="ReadOnly" ReadOnly style="width:120px" value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">       
          <img src="/claim/images/bgMarkMustInput.jpg"> 
        </td> 
      </tr>
        <tr>									  
        <td class="title" style="width:15%">联系人地址:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLregistInsuredAddress"  class="ReadOnly" ReadOnly value="<bean:write name='prpLregistDto' property='insuredAddress' filter='true' />">
        </td>   
        
        <td class="title" style="width:15%">联系人邮编:</td>   
        <td class="input" style="width:35%">
          <input type=text name="prpLregistDamageAreaPostCode" class="ReadOnly" ReadOnly maxlength=6 style="width:120px" description="出险地邮政编码" value="<bean:write name='prpLregistDto' property='linkerPostCode' filter='true' />">
        </td>
      </tr>
      <%--modify by wangli add end 20050407--%>       
      
      <tr>         
        <td class="title" style="width:15%">备注：</td>
        <td class="input" style="width:85%" colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength=80 style="width:440px" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
      </tr>      
      <%
      if (!editType.equals("SHOW")&&!editType.equals("DELETE"))
      {
      %>  
      <tr>         
        <td class="title" style="width:15%">自动调度：</td>
        <td class="input" style="width:85%" colspan="3">
          <input type="radio" name="autoScheduleFlag" value="1" checked="checked">是
          <input type="radio" name="autoScheduleFlag" value="0">否
        </td>
      </tr> 
      <%} %>
    </table>
