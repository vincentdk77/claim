<%--
****************************************************************************
* DESC       ：机动车辆保险报案记录(代抄单)打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">  
  <%-- 初始化 --%>
  <%@include file="DAARegistNoneFormatPrintIni.jsp"%>
 <style>
TD.registPrint
{
    font-size: 9pt;   
}
</style>
<html>
  
  <body bgcolor="#FFFFFF" onLoad="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      	 <tr>
          <td colspan="3" height="40" align=center style="font-family:宋体; font-size:14pt;">
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr> 
        <tr>
          <td colspan="2" height="40" style="text-align:left; font-family:宋体; font-size:16pt;">
            <p align=center><B>机动车辆保险报案记录（代抄单）<B></p>                      
          </td>
          
        <tr>
          <td colspan="2" height="10" ></td>
        </tr>

        <tr>
<!-- 交强险保单号 -->
            <td valign="left"   id="tdDAZPolicyNo" style="font-family:宋体; font-size:9pt;" colspan="2">&nbsp;</td>
        </tr>        
        <tr>
<!-- 商业险保单号 -->        
          <td valign="left"   id="tdPolicyNo" style="font-family:宋体; font-size:9pt;" >&nbsp;</td>
<!-- 报案号 --> 
          <td align=left id="tdRegistNo" style="font-family:宋体; font-size:9pt;">&nbsp;</td>
        </tr>
      </table>

      <!-- 主体部分 -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2"  style="font-size: 9pt;border-collapse:collapse; bordercolor:#111111;">
        <tr>
<!-- 被保险人-->
          <td valign="middle" colspan="2" height="24" id="tdInsuredName" class="registPrint">&nbsp;</td>
<!--号牌号码 -->          
          <td valign="middle" colspan="3" height="24" id="tdLicenseNo" class="registPrint">&nbsp;</td>
<!-- 号牌颜色 -->
          <td valign="middle" colspan="1" height="24" id="tdColorCode" class="registPrint">&nbsp;</td>
        </tr>
        <tr>
<!-- 厂牌型号名称 -->
          <td valign="middle" colspan="2" height="24" id="tdBrandName" class="registPrint">&nbsp;</td>
<!-- VIN码/车架号 -->
          <td valign="middle" colspan="3" height="24" id="tdVINorFramNo" class="registPrint">&nbsp;</td>
          <td valign="middle" colspan="1" height="24" id="tdEngineNo" class="registPrint">&nbsp;</td>   <!-- 发动机号 -->
        </tr>
        <tr>
          <td valign="middle" colspan="3" height="20" id="tdInsuredAddress" class="registPrint">&nbsp;</td><!-- 被保险人地址 -->
          <td valign="middle" colspan="2" height="20" id="tdInsuredPostCode" class="registPrint">&nbsp;</td><!-- 邮编 -->
          <td valign="middle" colspan="1" height="24" id="tdMobile" class="registPrint">&nbsp;</td><!-- 被保险人联系电话 -->
        </tr>
        <tr>
          <td valign="middle" colspan="2" height="24" id="tdReportType" class="registPrint">&nbsp;</td><!-- 报案方式 -->
          <td valign="middle" colspan="1" height="24" id="tdReportorName" class="registPrint">&nbsp;</td><!-- 报案人 -->
          <td valign="middle" colspan="2" height="24" id="tdLinkerName" class="registPrint">&nbsp;</td><!-- 联系人 -->
          <td valign="middle" colspan="1" height="24" id="tdPhoneNumber" class="registPrint">&nbsp;</td><!-- 联系电话 -->
        </tr>
        <tr>
          <td valign="middle" colspan="2" height="24" id="tdReportDate"  class="registPrint">&nbsp;</td><!-- 报案时间 -->
          <td valign="middle" colspan="1" height="24" id="tdFirstSiteFlag" class="registPrint">&nbsp;</td><!-- 是否第一现场报案 -->
          
          <td valign="middle" colspan="2" height="24" id="tdCustomerType" class="registPrint">&nbsp;</td><!-- 客户类别 -->
          <td valign="middle" colspan="1" height="24" id="tdInsuredCompany" class="registPrint">&nbsp;</td><!-- 被保险人单位性质 -->
        </tr>
        <tr>
          <td valign="middle" colspan="2" height="24" id="tdDamageStartDate" class="registPrint">&nbsp;</td><!-- 出险时间 -->
          <td valign="middle" colspan="1" height="24" id="tdDamageName" class="registPrint">&nbsp;</td><!-- 出险原因 -->
          <td valign="middle" colspan="2" height="24" id="tdDriverName" class="registPrint">&nbsp;</td><!-- 驾驶员 -->
          <td valign="middle" colspan="1" height="24" id="tdDrivingCarType" class="registPrint">&nbsp;</td><!-- 准驾车型 -->
        </tr>
        <tr>
          <td valign="middle" colspan="3" height="24" id="tdDriverFirstTime" class="registPrint">&nbsp;</td><!-- 驾驶证初次领证日期 -->
          <td valign="middle" colspan="3" height="24" id="tdDrivingLicenseNo" class="registPrint">&nbsp;</td><!-- 驾驶证号码 --> 
        </tr>
        <tr>
          <td valign="middle" colspan="3" height="24" id="tdDamageAddress" class="registPrint">&nbsp;</td><!-- 出险地点 -->
          
          <td valign="middle" colspan="2" height="24" id="tdCarRegistFirst" class="registPrint">&nbsp;</td><!-- 初次登记日期 -->
          <td valign="middle" colspan="1" height="24" id="tdUseYears" class="registPrint">&nbsp;</td><!-- 已使用年限 -->
        </tr>
        
        <tr>
          <td valign="middle" colspan="3" height="24" id="tdHandleUnit" class="registPrint">&nbsp;</td><!-- 事故处理单位 -->
          <td valign="middle" colspan="3" height="24" id="tdHandleUnit1" class="registPrint">&nbsp;</td><!-- 承保公司 -->          
        </tr>
        <tr style="display:none">
          <td valign="middle" colspan="3" height="24" id="tdVinCode" class="registPrint"></td>
          <td valign="middle" colspan="2" height="24" id="" class="registPrint">&nbsp;</td>
          <td valign="middle" colspan="1" height="24" id="tdFrameNo" class="registPrint">&nbsp;</td>
        </tr>        
        <tr>
          <td valign="middle" colspan="2" height="24" id="tdPurchasePrice" class="registPrint">&nbsp;</td><!-- 新车购置价 -->
          <td valign="middle" colspan="3" height="24" id="tdUseNatureCode" class="registPrint">&nbsp;</td><!-- 使用性质 -->
          <td valign="middle" colspan="1" height="24" id="tdCarType" class="registPrint">&nbsp;</td><!-- 车辆种类 -->
        </tr>
        <tr>
          <td valign="middle" colspan="2" height="24" id="tdSumPremium" class="registPrint">&nbsp;</td><!-- 保险费 -->
          <td valign="middle" colspan="3" height="24" id="tdSeatCount" class="registPrint">&nbsp;</td><!-- 核定载客 -->
          <td valign="middle" colspan="1" height="24" id="tdRunAreaName" class="registPrint">&nbsp;</td><!-- 车辆行驶区域 -->
        </tr>
        <tr>
          <td valign="middle" colspan="5" height="24" id="tdDAZInsureDate" class="registPrint">&nbsp;</td><!-- 交强险保险期间 -->          
          <td valign="middle" colspan="1" height="24" rowspan="2" id="tdArgue" class="registPrint">&nbsp;</td><!-- 争议解决方式 -->
        </tr>
        <tr>
            <td valign="middle" colspan="5" height="24" id="tdDAAInsureDate" class="registPrint">&nbsp;</td><!-- 商业险保险期间 -->  
        </tr>
        <!--<tr style="display:none">
          <td valign="middle" colspan="2" height="24" id="tdCarClause" class="registPrint">&nbsp;</td>
          <td valign="middle" colspan="1" height="24" id="" class="registPrint">&nbsp;</td>
          <td valign="middle" colspan="3" height="24" id="tdInsuredTerm" class="registPrint">&nbsp;</td>
        </tr>
        --><tr  height="0">
          <td valign="middle" width="4%" height="0" style="border:none"></td>
          <td valign="middle" width="24%" height="0" style="border:none"></td>
          <td valign="middle" width="24%" height="0" style="border:none"></td>
          <td valign="middle" width="4%" height="0" style="border:none"></td>
          <td valign="middle" width="23%" height="0" style="border:none"></td>
          <td valign="middle" width="21%" height="0" style="border:none"></td>
        </tr>
<!--     
         <tr>
          <td valign="middle" colspan="3" height="24" id="tdDamageAddressType"></td>
         
          <td valign="middle" colspan="2" height="24" id="tdPersonInjure">&nbsp;</td>
          <td valign="middle" colspan="2" height="24" id="tdDamageAreaName"></td>
        </tr> 
-->
    </table>
	
		<table width="92%" align="center" border="1" cellspacing="0"
			cellpadding="2"
			style="font-size: 10pt; border-collapse: collapse; bordercolor: #111111;">
			<tr>
				<td valign="middle" width="4%" align="center" height="24" id="" class="registPrint">序号</td>
				<td valign="middle" width="24%" align="center" height="24" id="" class="registPrint">&nbsp;约定驾驶员姓名</td>
				<td valign="middle" width="6%" align="center" height="24" id="" class="registPrint">&nbsp;性别</td>
				<td valign="middle" width="22%" align="center" height="24" id="" class="registPrint">&nbsp;初次领证日期</td>
				<td valign="middle" width="23%" align="center" height="24" id="" class="registPrint">&nbsp;准驾车型</td>
				<td valign="middle" width="21%" align="center" height="24" id="" class="registPrint">&nbsp;驾驶证号码</td>
			</tr>
			<tr>
				<td valign="middle"  align="center" height="24" id="" class="registPrint">1</td>
				<td valign="middle"  align="center" height="24" id="tdArgumentName1" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24"  id="tdArgumentSex1" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id=tdArgumentFirst1 class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id="tdDrivingCarType1" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id="tdArgumentNumber1" class="registPrint">&nbsp;</td>
			</tr>
			<tr>
				<td valign="middle"  align="center" height="24" id="" class="registPrint">2</td>
				<td valign="middle"  align="center" height="24" id="tdArgumentName2" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id="tdArgumentSex2" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id="tdArgumentFirst2" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id="tdDrivingCarType2" class="registPrint">&nbsp;</td>
				<td valign="middle"  align="center" height="24" id="tdArgumentNumber2" class="registPrint">&nbsp;</td>
			</tr>
		</table>
	 <table width="92%" align="center" border="1" cellspacing="0"
            cellpadding="2"
            style="font-size: 10pt; border-collapse: collapse; bordercolor: #111111;">
        <tr>
          <td valign="middle" width="4%" height="24" align=center class="registPrint">序号</td>
          <td valign="middle" width="24%" height="24" align=center class="registPrint">&nbsp;承保险种（代码）</td>
          <td valign="middle" width="6%" height="24" align=center class="registPrint">&nbsp;不计免赔</td>
          <td valign="middle" width="18%" height="24" align=center class="registPrint">&nbsp;保险金额/责任金额</td>
          <td valign="middle" width="4%" height="24" align=center class="registPrint">序号</td>
          <td valign="middle" width="23%" height="24" align=center class="registPrint">&nbsp;承保险种（代码）</td>
          <td valign="middle" width="6%" height="24" align=center class="registPrint">&nbsp;不计免赔</td>
          <td valign="middle" width="18%" height="24" align=center class="registPrint">&nbsp;保险金额/责任金额</td>
        </tr>
<%
   if(intItemKindCount%2 != 0)
     intItemKindCount = intItemKindCount + 1;
   for(int i=0;i<22;i=i+2){
     if(strKindCode[i] == null){
       strKindCode[i] = "";
       strKindName[i] = "";
     }
     if(strKindCode[i+1] == null){
       strKindCode[i+1] = "";
       strKindName[i+1] = "";
     }
     if(strItemKindFlag5[i] == null)
     {
    	 strItemKindFlag5[i] = "";
     }
     if(strItemKindFlag5[i+1] == null)
     {
    	 strItemKindFlag5[i+1] = "";
     }
     if(douAmount[i] == null){
       douAmount[i] = "";
     }
     if(douAmount[i+1] == null){
       douAmount[i+1] = "";
     }
     if(strDangerLevel[i] == null){
       strDangerLevel[i] = "";
     }
     if(strDangerLevel[i+1] == null){
       strDangerLevel[i+1] = "";
     }
%>
        <tr>
          <td valign="middle" height="24" align=center class="registPrint"><%=i+1%></td>
          <td valign="middle" height="24"  class="registPrint"><%=strKindName[i]%>&nbsp;<%=strKindCode[i]%>&nbsp;&nbsp;<%=strDangerLevel[i]%></td>
          <td valign="middle" height="24" align="center" class="registPrint"><%=strItemKindFlag5[i]%></td>
          <td valign="middle" height="24" align=right class="registPrint"><%=douAmount[i]%></td>
          <td valign="middle" height="24" align=center class="registPrint"><%=i+2%></td>
          <td valign="middle" height="24" class="registPrint" ><%=strKindName[i+1]%>&nbsp;<%=strKindCode[i+1]%>&nbsp;&nbsp;<%=strDangerLevel[i+1]%></td>
          <td valign="middle" height="24" align="center" class="registPrint"><%=strItemKindFlag5[i+1]%></td>
          <td valign="middle" height="24" align=right class="registPrint"><%=douAmount[i+1]%></td>
        </tr>
<%
  }
%>
        </table>
        
       <table width="92%" align="center" border="0">
        <tr>
            <td valign="middle" width="4%" height="24" align=center class="registPrint">&nbsp;</td>
        </tr>
        <tr>
            <td valign="middle" width="4%" height="24" align=center class="registPrint">&nbsp;</td>
        </tr>
        <tr>
            <td valign="middle" width="4%" height="24" align=center class="registPrint">&nbsp;</td>
        </tr>
       </table>
<%
	String strEngage = "";
	String strEngageMainSub = "";
	if("0507".equals(prpLregistDto.getRiskCode())||"0577".equals(prpLregistDto.getRiskCode())||"0587".equals(prpLregistDto.getRiskCode()))
	{
		strEngage = "交强险特别约定";
		strEngageMainSub = "商业险特别约定";
	}else{
		strEngage = "商业险特别约定";
		strEngageMainSub = "交强险特别约定";
	}
%>       

        <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="font-size: 10pt;border-collapse: collapse; bordercolor:#111111;">
        <tr >
          <td valign="middle" width="4%" height="100" align=center class="registPrint"><%=strEngage %></td>
          <td valign="middle" align="left" width="92%" height="22" id="tdEngage" class="registPrint">
            <input type=text rows=5 cols=97 class=readonlyWhite readonly >
          </td>
        </tr>
       <tr >
          <td valign="middle" width="4%" height="100" align=center class="registPrint"><%=strEngageMainSub %></td>
          <td valign="middle" align="left" width="92%" height="22" id="tdEngageMainSub" class="registPrint">
            <input type=text rows=5 cols=97 class=readonlyWhite readonly >
          </td>
        </tr>
       
       
        <tr>
          <td valign="middle" width="4%" height="100" align=center class="registPrint">事故经过</td>
          <td valign="middle" align="left" colspan="6" height="19" id="tdContext" class="registPrint">          </td>
        </tr>
        </table>
    
        <table width="92%" align="center" border="1" cellspacing="0"  cellpadding="2"  style="font-size: 10pt; border-collapse: collapse; bordercolor: #111111;">
            <tr>
                <td valign="middle"  align="center" height="24" id="" rowspan="7" class="registPrint">历史批改信息</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;批单号码</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;批改时间</td>
                <td valign="middle"  align="center" height="24" id="" colspan="4" class="registPrint">&nbsp;批改类型</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;保费变化量</td>                
            </tr>
            <%for(int i = 0;i < 5;i++){ %>
            <tr id="trEndorInfoLine<%=i %>>">                
                <td valign="middle"  align="center" height="24" id="tdEndorseNo<%=i %>" colspan="1" class="registPrint">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdEndorDate<%=i %>" colspan="1" class="registPrint">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdEndorType<%=i %>" colspan="4" class="registPrint">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdChgPremium<%=i %>" colspan="1" class="registPrint">&nbsp;</td>                
            </tr>
            <%} %>
            <tr style="display:" id="trEndorInfoLine5" >                
                <td valign="middle"  align="center" height="24" id="tdEndorseNo5" colspan="1" class="registPrint">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdEndorDate5" colspan="1" class="registPrint">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdEndorType5" colspan="4" class="registPrint">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdChgPremium5" colspan="1" class="registPrint">&nbsp;</td>                
            </tr><!--
            <tr style="display:none" id="trEndorLast" class="registPrint">
                
                <td valign="middle"  align="left" height="24" id="" colspan="7">
                    &nbsp;……数据过多，请查看历次批改信息……      
                </td>
            </tr>
            -->
            <tr>
                <td valign="middle"  align="center" height="24" id="" rowspan="7" class="registPrint">历史出险信息</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;报案号码</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;报案时间</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;出险时间</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;赔付金额</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;涉及人伤</td>
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;案件状态</td> 
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;标志</td>               
            </tr>
             <%for(int i = 0;i < 5;i++){ %>
            <tr id="trDamageInfoLine<%=i %>>">                
                <td valign="middle"  align="center" height="24" id="trHistoryRegistNo<%=i %>" colspan="1" class="registPrint">&nbsp;<%=damageInfoRegistno[i] %></td>
                <td valign="middle"  align="center" height="24" id="trHistoryReportDate<%=i %>" colspan="1" class="registPrint">&nbsp;<%=damageInfoReportDate[i] %></td>
                <td valign="middle"  align="center" height="24" id="trHistoryDamageStartDate<%=i %>" colspan="1" class="registPrint">&nbsp;<%=damageInfoStartDate[i] %></td>
                <td valign="middle"  align="center" height="24" id="trHistorySumPay<%=i %>" colspan="1" class="registPrint">&nbsp;<%=damageInfoSumPay[i] %></td>
                <td valign="middle"  align="center" height="24" id="trHistoryIsPersonInjure<%=i %>" colspan="1" class="registPrint">&nbsp;<%=damageInfoIsPersonInjure[i] %></td> 
                <td valign="middle"  align="center" height="24" id="trHistoryCaseType<%=i %>" colspan="1" class="registPrint">&nbsp;<%=damageInfoCaseTypeName[i] %></td> 
                <td valign="middle"  align="center" height="24" id="" colspan="1" class="registPrint">&nbsp;<%=damageInfoFlag[i] %></td>                              
            </tr>
            <%} %>
            <tr style="display:" id="trDamageInfoLine6" >                
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine61" colspan="1">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine62" colspan="1">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine63" colspan="1">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine64" colspan="1">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine65" colspan="1">&nbsp;</td>
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine66" colspan="1">&nbsp;</td>  
                <td valign="middle"  align="center" height="24" id="tdDamageInfoLine67" colspan="1">&nbsp;</td>                
            </tr>
            <!--<tr style="display:none" id="trDamageLast" class="registPrint">
                
                <td valign="middle"  align="left" height="24" id="" colspan="8" class="registPrint">
                    &nbsp;……数据过多，请查看历次出险信息……      
                </td>
            </tr>
            --><tr height="0">
	                <td width="4%"  height="0" style="border:none"></td>
	                <td width="27%" height="0" style="border:none"></td>
	                <td width="12%" height="0" style="border:none"></td>
	                <td width="12%" height="0" style="border:none"></td>
	                <td width="15%" height="0" style="border:none"></td>
	                <td width="10%" height="0" style="border:none"></td>
	                <td width="10%" height="0" style="border:none"></td>
	                <td width="10%"  height="0" style="border:none"></td>
            </tr>
            <tr>
          <td valign="middle"  height="35" colspan="2" align=center class="registPrint">涉及损失险别</td>
          <td valign="middle" align="left" colspan="6" height="60" id="tdRefKind" class="registPrint">          </td>
        </tr>
        <tr>
          <td valign="middle"  class="registPrint" colspan="2" height="20" id="tdPheadCount">&nbsp;</td>
          <td valign="middle"  class="registPrint" colspan="2" height="20" id="tdClaimCount">&nbsp;</td>
          <td valign="middle"  class="registPrint" colspan="1" height="20" id="tdCompensateCount">&nbsp;</td>
          <td valign="middle"  class="registPrint" colspan="3" height="20" id="tdSumPaid">&nbsp;</td>
        </tr>
        </table>
           
    <!--    <tr>
          <td valign="middle" height="24" align=center>查勘信息<br>回复</td>           
          <td valign="middle" align="left" height="60"><%=checkInfo%></td>
        </tr>   -->
        
        </table>
        <!--
        <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="font-size:10pt;border-collapse:collapse; bordercolor:#111111;">
        
        
        <tr>
          <td valign="middle" colspan="3" height="20" id="tdLinkerName1">&nbsp;</td>
          <td valign="middle" colspan="2" height="20" id="tdPhoneNumber1">&nbsp;</td>
          <td valign="middle" colspan="1" height="20" id="">&nbsp;</td>
        </tr>
      </table>
      --><table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-size: 10pt">
     <tr>
     <td align="left"  height="13" class="registPrint" id="tdOperatorName">&nbsp;</td>
     <td align="left"  height="13" class="registPrint" id="tdHandlerName">&nbsp;</td>
     <td align="left"  height="13" class="registPrint" id="tdUnderwriteName">&nbsp;</td>
     </tr>
      <tr>
          <td align=left width="50%" class="registPrint" height="14" id="tdUserName"></td>
          <td colspan="2" align=left class="registPrint" width="50%" id="tdInputDate"></td>
     </tr>
        </table>
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />

    </form>
  </body>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>
