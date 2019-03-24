<%--
****************************************************************************
* DESC       ：机动车辆保险预付赔款审批表打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16 
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- 初始化 --%>
  <%@include file="DAAPrepayNoneFormatPrintIni.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>                                                                                  
  <head>                                                                               
    <title>机动车辆保险预付赔款审批表打印</title>      
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">        
  </head>                                                                              

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- 标题部分 -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top  style=" font-family:宋体; font-size:14pt;">            
          <B>机动车辆保险预付赔款审批表<B>
        </td>
      </tr>
      <tr>
        <td align=left id="tdCompany" width="50%" style="font-family:宋体; font-size:10pt;">
          填报单位（签章）：
        </td>
        <td align=right id="tdClaimNo" width="50%" style="font-family:宋体; font-size:10pt;">
          立案编号：
        </td>
      </tr>
    </table>
      
    <!-- 主体部分 -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr>
        <td align="center" colspan="1" height="28" width="10%">被保险人</td>
        <td height="28" colspan="4" width="40%" id="tdInsuredName">&nbsp;</td>
        <td align="center" colspan="1" height="28" width="10%">保险单号</td>
        <td height="28" colspan="3" width="30%" id="tdPolicyNo">&nbsp;</td>
      </tr>
      <tr>
	    <td align="center" colspan="1" height="28" width="10%">厂牌型号</td>
        <td height="28" colspan="2" width="20%" id="tdBrandName">&nbsp;</td>
        <td align="center" colspan="1" height="25" width="10%">号牌号码</td>
        <td height="28" colspan="2" width="20%" id="tdLicenseNo">&nbsp;</td>
        <td align="center" colspan="1" height="28" width="10%">保险金额</td>
        <td height="28" colspan="2" width="30%" id="tdSumAmount">&nbsp;</td>
      </tr>
      <tr>
	    <td align="center" colspan="1" height="28">出险时间</td>
        <td height="28" colspan="2" id="tdDamageStartDate">&nbsp;</td>
		<td align="center" colspan="1" height="28">出险险种</td>
        <td height="28" colspan="2" id="tdRiskName">&nbsp;</td>
		<td align="center" colspan="1" height="28">出险地点</td>
        <td height="28" colspan="2" id="tdDamageAddress">&nbsp;</td>  
      </tr>
      <tr>
        <td align="center" height="28" >保险期间</td>
        <td height="28" colspan="4" id="tdInsuredDate"></td>
        <td align="center" height="28">估损金额</td>
        <td height="28"colspan="3" id="tdEstimateLoss">&nbsp;</td>
      </tr>
      <tr>
        <td align="left" height="28" colSpan=9 id="tdSumPrePaid">&nbsp;预付赔款金额（大写人民币）：</td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=9>&nbsp;事故概况：</td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=9>
        
          <table width="100%" height="100%" border=0 style="font-family:宋体; font-size:10pt;">
            <tr height="70%">
              <td valign="top" colspan="5">&nbsp;预付原因：</td>
            </tr>          
           
          </table>
                  
        </td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=9>
        
          <table width="100%" height="100%" border=0 style="font-family:宋体; font-size:10pt;">
            <tr height="70%">
              <td valign="top" colspan="5">&nbsp;三级机构意见：</td>
            </tr>          
            <tr height="20%">
              <td width="60%">&nbsp;</td>
              <td align="left" width="40%">经（副）理：</td>
            </tr>
            <tr height="10%">
              <td>&nbsp</td>
              <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</td>
            </tr>
          </table>
                  
        </td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=9>
        
          <table width="100%" height="100%" border=0 style="font-family:宋体; font-size:10pt;">
            <tr height="70%">
              <td valign="top" colspan="5">&nbsp;二级机构意见：</td>
            </tr>          
            <tr height="20%">
              <td width="60%">&nbsp;</td>
              <td align="left" width="40%">经（副）理或被授权人：</td>
            </tr>
            <tr height="10%">
              <td>&nbsp</td>
              <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日</td>
            </tr>
          </table>
                  
        </td>
      </tr>
    </table>
     
    <!-- 结尾部分 -->      
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr>
        <td width="50%" height="20" valign="bottom" colspan=5 id="tdUserName">填报人：</td>
        <td width="50%" height="20" valign="bottom" colspan=4 align="right" id="tdInputDate">填报时间：</td>
      </tr>
    </table>
    
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>

