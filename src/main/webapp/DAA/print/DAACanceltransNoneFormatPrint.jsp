<%--
****************************************************************************
* DESC       ：机动车辆保险拒赔案件报告书打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

  <%-- 初始化 --%>
  <%@include file="DAACanceltransNoneFormatPrintIni.jsp"%>
  
<html>                                                                                 
  <head>                                                                               
    <title>机动车辆保险拒赔案件报告书打印</title>      
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">       
  </head>                                                                              

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- 标题部分 -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top align=center style="font-family:宋体; font-size:14pt;">            
          <center><B>机动车辆保险拒赔案件报告书<B></center>
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
      <br>
    <!-- 主体部分 -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr>
        <td align="center" height="28" width="10%">被保险人</td>
        <td height="28" width="35%" id="tdInsuredName">&nbsp;</td>
        <td align="center" height="28" width="10%">保险单号</td>
        <td height="28" width="45%" id="tdPolicyNo">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="25">号牌号码</td>
        <td height="28" id="tdLicenseNo">&nbsp;</td>
        <td align="center" height="28">厂牌型号</td>
        <td height="28" id="tdBrandName">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="28">保险金额</td>
        <td height="28" id="tdSumAmount1">&nbsp;</td>
        <td align="center" height="28" rowSpan=2>保险期间</td>
        <td height="28" rowSpan=2 id="tdInsuredDate"></td>
      </tr>
      <tr>
        <td align="center" height="28">责任限额</td>
        <td height="28" id="tdSumAmount2">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="28">出险险种</td>
        <td height="28" id="tdRiskName">&nbsp;</td>
        <td align="center" height="28">估损金额</td>
        <td height="28" colSpan=2 id="tdEstimateLoss">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="28">出险时间</td>
        <td height="28" id="tdDamageStartDate">&nbsp;</td>
        <td align="center" align="center" height="28">出险地点</td>
        <td height="28" id="tdDamageAddress">&nbsp;</td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=4 id="tdContext">&nbsp;</td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=4>&nbsp;被保险人意见及反映：</td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=4>
        
          <table width="100%" height="100%" border=0 style="font-family:宋体; font-size:10pt;">
            <tr height="80%">
              <td valign="top" colspan="4">&nbsp;注销、拒赔或赔偿意见：</td>
            </tr>          
            <tr height="10%">
              <td>经理签字：</td>
              <td>主管签字：</td>
              <td>核赔师签字：</td>
              <td>经办人签字：</td>
            </tr>
            <tr height="10%">
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
            </tr>
          </table>
                  
        </td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=4>
        
          <table width="100%" height="100%" border=0 style="font-family:宋体; font-size:10pt;">
            <tr height="80%">
              <td valign="top" colspan="4">&nbsp;上级公司审核意见：</td>
            </tr>         
            <tr height="10%">
              <td>主管总（副）经理签字：</td>
              <td>法律部门负责任签字：</td>
              <td>业务部门负责人签字：</td>
              <td>经办人签字：</td>
            </tr>
            <tr height="10%">
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
            </tr>
          </table>
                  
        </td>
      </tr>
    </table>
     
    <!-- 结尾部分 --> 
         
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr>
        <td width="50%" height="20" valign="bottom" colspan=2 id="tdUserName">填报人：</td>
        <td width="50%" height="20" valign="bottom" colspan=2 align="right" id="tdInputDate">填报时间：</td>
      </tr>
    </table>
    
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
