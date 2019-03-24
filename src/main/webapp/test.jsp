<%--
****************************************************************************
* DESC       ：测试零配件页面
* AUTHOR     ：
* CREATEDATE ：2004-03-23
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<html:html locale="true">
<head>
    <title>理赔工作流系统</title>
        <app:css />
    <html:base/>
    
    
    <script language="Javascript" src="/claim/common/js/CodeSelect.js" ></script>
    <script language="Javascript" src="/claim/common/js/Common.js" ></script>
    <script language="Javascript" src="/claim/common/js/Application.js" ></script>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossRepairComponentEdit.js"></script>
    <META   http-equiv="Content-Type"   content="text/html; charset=GB2312">
    <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
</head>

<%--//modify by wangli add start 20050422 --%>

<body class=logon leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
 <frame name="test">  
  <form name=fm action="" target="test">
    <input name="queryType" type="hidden" value="Compent">
    <input name="RegistNo" type="hidden" value="405060000002008000018">
    <input name="policyno" type="hidden" value="205060000002008000009">
    <input name="prpLverifyLossInsuredName" type="hidden" value="张三">
    <input name="prpLcarLossLossItemCode" type="hidden" value="1">
    <input name="prpLcarLossLossItemName" type="hidden" value="1">
    <input name="prpLrepairFeeRepairFactoryName" type="hidden" value="1">
    <input name="licenseNo" type="hidden" value="沪2314">
    <input name="SysAreaCode" type="hidden" value="31">
    <input name="LocalAreaCode" type="hidden" value="0000000000">
    <input name="prpLcarLossModelCode" type="hidden" value="AAKAJ0034">
    <input name="prpLcarLossBrandName" type="hidden" value="宝马BMW7301AA(BMW530i)">
    <input name="selectCarFittings" type="hidden" value="">
    <input name="showpriceflag" type="hidden" value="0">
    <input name="repairfactorytype" type="hidden" value="405060000002008000018">
    <form name=fm action="/claim/logonin.do" focus="prpDuserUserCode" method="post" >
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
      <div align="center"><input type="button" name="loginMessage" class="bigbutton" value=零配件寻价测试 onclick="getFittingsInfo('Compent');"></div>
             <%--// modify by wangli add end 20050421  --%>
  
 <%@ page import="java.util.*"%>

   <table class="common" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4">  
        <span  id="spanComponent" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Component" >
          <thead>
            <tr>
              <td class="subformtitle" colspan=12>
                零部件更换项目费用清单
              </td>
            </tr>
            <tr>
              <td style="display:none" class="centertitle" style="width:8%">险别代码</td> 
              <td class="centertitle" style="width:10%">险别名称</td>
              
              <!--Modify by chenrenda update begin 20050413-->
               <!--                  
             <td class="centertitle" style="width:10%">损失部位</td>
              <td class="centertitle" style="width:10%">零件(项目)名称</td>
              <td class="centertitle" style="width:8%">部件代码</td>
              -->
              <!--  <td class="centertitle" style="width:10%">部件部位</td>-->
              <td class="centertitle" style="width:10%">部件名称</td>
              <!--Modify by chenrenda update end 20050413-->
              
              
              <td class="centertitle" style="width:8%">数量</td>
              <td  style="display:none" class="centertitle" style="width:8%">工时费</td>  
              <td class="centertitle" style="width:8%">上报价格</td>  
              <td class="centertitle" style="width:8%">系统价</td>                   
              <td class="centertitle" style="width:8%">残值</td>
              <td class="centertitle" style="width:8%">定损金额</td>                     
              <td class="centertitle" style="width:10%">备注</td>
              <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
        </table>  
        
        </span>    
      </td>
    </tr>
  </table>         
           <table class="common" style=" " id="Component_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>  
                <td class="input" style="display:none">               
     
                  <input type="hidden" name="carLossComponentLossItemCode" style="width:20px">              
                  <input  type="text" name="prpLcomponentKindCode" class="codecode" style='width:40px'             
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">          
                </td>

               
                <td class="input">   
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:70px'       
                         ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
                         onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
                         onblur="checkKindCodeForRepair(this);">        
                </td>                
  
               
                 
                <!--Modify by chenrenda update begin 20050413-->
                <!--<td class="input" style="display:none;">
                 
                    <select name="prpLcomponentPartCode" styleClass="three" style='width:50px' >
                  
                      <option value=" "> </option>
                  
                    </select>           
                   <input type="hidden" name="prpLcomponentPartName" value="前部">
                </td>    
                
                --><!--<input type="hidden" name="prpLcomponentPartName" value="前部">
                <input type="hidden" name="prpLcomponentPartCode" value="">
                --><td class="input" >
                  <input name="prpLcomponentCompName" class="codename" readonly style='width:120px'>                 
                      <!-- 有零配件系统后，去掉双击域事件 ondblclick="return openPrplComponentCompWin(Component_Data,this);" -->
                     <input type="hidden" name="prpLcomponentCompCode" value="9999">
                </td>
                <!--
                 <td class="input">                
                  <input name="prpLcomponentPartDesc" class=common style='width:70px'  
                </td>
                 
                <td class="input">   
                  <input type="text" name="prpLcomponentCompCode" class="codecode" style='width:40px'             
                      ondblclick= "code_CodeSelect(this,'CompCode');"
                      onkeyup= "code_CodeSelect(this,'CompCode');">         
                </td>
                <td class="input">   
                  <input type="text" name="prpLcomponentCompName" class="codecode" style='width:70px'
                         ondblclick="code_CodeSelect(this, 'CompCode','-1','always','none','post');"
                         onkeyup= "code_CodeSelect(this, 'CompCode','-1','always','none','post');">      
                </td>
                 -->
                <!--Modify by chenrenda update end 20050413-->
                
              
 
                <td class="input">               
                  <input name="prpLcomponentQuantity"  value="1" class=common style='width:60px' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLcomponentManHourFee" value="0" class=common style='width:60px' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input">                
                  <input name="prpLcomponentMaterialFee" class=common style='width:60px' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input">           
                  <input name="prpLcomponentSys4SPrice" type="password" class=common style='width:60px' >
                  <input name="prpLcomponentQuotedPrice" type="hidden" >
                </td>
                
                <!--Modify by chenrenda add begin 增加残值列 20050414-->
                <td class="input">                
                  <input name="prpLcomponentRestFee" class=common style='width:50px'  onBlur="getSumDefLoss(this,2);calculateSumRestFee(this);">
                </td> 
                <!--Modify by chenrenda add end 增加残值列 20050414-->
                
                <td class="input">                
                  <input name="prpLcomponentSumDefLoss" class="readonly" readonly style='width:60px' >
                </td>
                <td class="input">                
                  <input name="prpLcomponentRemark" class=common style='width:60px'>
                </td> 
                  <input type="hidden" name="prpLcomponentOriginalId">
                  <input type="hidden" name="prpLcomponentIndId">
                  <input type="hidden" name="prpLcomponentSysMatchPrice">
                  <input type="hidden" name="prpLcomponentNative4SPrice">
                  <input type="hidden" name="prpLcomponentNativeMarketPrice">
                  <input type="hidden" name="prpLcomponentNativeMatchPrice">
                  <input type="hidden" name="prpLcomponentVerpCompPrice">                  
                  <input type="hidden" name="prpLcomponentSysMarketPrice"> 
              
                   
                  <input type="hidden" name="prpLcomponentSerialNo">                 
                  <input type="hidden" name="prpLcomponentItemKindNo">               
                  <input type="hidden" name="prpLcomponentLossItemCode">             
                  <input type="hidden" name="prpLcomponentLicenseNo">                
                  <input type="hidden" name="prpLcomponentLicenseColorCode">         
                  <input type="hidden" name="prpLcomponentCarKindCode">              
                  <input type="hidden" name="prpLcomponentMakeYear">                 
                  <input type="hidden" name="prpLcomponentGearboxType">              
                  <input type="hidden" name="prpLcomponentQuoteCompanyGrade">        
                  <input type="hidden" name="prpLcomponentManageFeeRate">            
                  <input type="hidden" name="prpLcomponentRepairFactoryCode">        
                  <input type="hidden" name="prpLcomponentRepairFactoryName">        
                  <input type="hidden" name="prpLcomponentHandlerCode">              
                  <input type="hidden" name="prpLcomponentRepairStartDate">          
                  <input type="hidden" name="prpLcomponentRepairEndDate">                  
                  <input type="hidden" name="prpLcomponentSanctioner">               
                  <input type="hidden" name="prpLcomponentApproverCode">             
                  <input type="hidden" name="prpLcomponentOperatorCode">                
                  <input type="hidden" name="prpLcomponentQueryPrice">               
                  <input type="hidden" name="prpLcomponentLossRate">                 
                  <input type="hidden" name="prpLcomponentCurrency">                 
                  <input type="hidden" name="prpLcomponentVeriRemark">                   
                  <input type="hidden" name="prpLcomponentVeriQuantity">              
                  <input type="hidden" name="prpLcomponentVeriManHourFee">           
                  <input type="hidden" name="prpLcomponentVeriMaterFee">             
                  <input type="hidden" name="prpLcomponentVeriLossRate">              
                  <input type="hidden" name="prpLcomponentVeriRestFee">       
                  <input type="hidden" name="prpLcomponentSumVeriLoss">               
                  <input type="hidden" name="prpLcomponentFlag">   
                  <input type="hidden" name="prpLcomponentCompensateBackFlag"> 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonComponentDelete"  class="smallbutton" onclick="deleteRowTableComponent(this,'Component',1,1)" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>         
            </tbody>
          </table>
          
        </span>      
</form>
</frame>
</body>
</html:html>
