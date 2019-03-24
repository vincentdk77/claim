<%--
****************************************************************************
* DESC       ：机动车辆保险拒赔/注销案件通知书打印页面
* AUTHOR     ：zhulianyu
* CREATEDATE ：2005-11-15
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- 初始化 --%>
  <%@include file="DAAPressnoticeNoneFormatPrintIni.jsp"%>

<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                    
   <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- 标题部分 -->                                                                  
    <table width="98%" align="center" cellspacing="0" cellpadding="0" border="0"> 
      <tr height="40">
        <td align="center"colspan="2" height="40" style="font-family:宋体; font-size:14pt;">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>     
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <B>机动车辆保险拒赔/注销案件通知书<B>
        </td>
      </tr>
      <tr height="30">
        <td align=left id="tdRegistNo" width="50%" style="font-family:宋体; font-size:10pt;">
          报案号：
        </td>
        <td align=left id="tdClaimNo" width="50%" style="font-family:宋体; font-size:10pt;">
          立案号：
        </td>
      </tr>      
    </table>
      
    <!-- 主体部分 -->
    <table border=1 width="98%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr height="25">
        <td colspan=1 width="15%" align="center">被保险人</td>
        <td colspan=2 id="tdInsuredName" width="45%" align="center">&nbsp;</td>
        <td width="10%" align="center">保险单号</td>
        <td colspan=2 id="tdPolicyNo" width="22%" align="center">&nbsp;</td>
      </tr>
      <tr height="25">
        <td width="15%" align="center">保险期限</td>
        <td colspan=2 id="tdInsuredDate" width="45%" align="center"></td>  
        <td width="10%" align="center">出险时间</td>
        <td colspan=2 id="tdDamageStartDate" width="22%" align="center">&nbsp;</td>        
      </tr>
      <tr height="25">
        <td colspan=1 width="15%" align="center">出险险别及损失金额</td>
        <td colspan=2  id="tdRiskNameAndEstimateLoss" width="45%" align="center">&nbsp;</td>
        <td colspan=1 width="10%" align="center">号牌号码</td>
        <td colspan=2 id="tdLicenseNo" width="22%" align="center">&nbsp;</td>   
      </tr>     
      <tr height="170">
      <td colspan="6" valign=top id="tdDamageCause">
      出险原因：
      </td>
      </tr>
      <tr height="170">
      <td colspan="6" valign=top id="tdCancelReason">
      拒赔/注销理由：
      </td>
      </tr>      
      <tr height="170">
      <td colspan="6" valign=top>
      附件目录：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、
      </td>
      </tr>    
      <tr height="140">
      <td colspan="2" valign=top >
      <br>
      特别提示：<br>
      &nbsp;&nbsp;&nbsp;&nbsp;被保险人如有异议，在接到本通知书后十五日内，向本公司或本公司上级主管部门提出书面复议。逾期作自动放弃处理。<br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;被保险人签收：
      <br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
      </td>
      <td colspan="4" valign=top>
      <br>
      &nbsp;本公司地址：<%=strCompanyAdd%><br><br>
      &nbsp;邮政编码：<%=strPostCode%><br><br>
      &nbsp;联系人：<br><br>
      &nbsp;联系电话：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保险人盖章：<br>
      <br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
      </td>      
      </tr>
      </table>
             
      <!--
      <tr height="360">
        <td width="5%">
          保险公司赔案注销通知
        </td>
        <td colspan=4>
          <table border=0 width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">  
            <tr>  
              <td colspan=2 id="tdInsuredName1">
                （被保险人名称）：
              </td>
            </tr>
            <tr>
              <td colspan=2>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;
                    非常遗憾地通知您，由于您没有按我公司的催收通知约定的期限，提供结案所要求的有
关材料，您所发生的以上保险事故，已超过规定的索赔期限。根据《保险法》和有关法律法
规的规定，您的索赔权已经消失，因而您的车辆保险立案已被注销，希望能够得到您的理解。 
              </td>
            </tr>
            <tr>
              <td colspan=2>
                &nbsp;&nbsp;&nbsp;&nbsp;谢谢您的理解与合作。<br>
                &nbsp;&nbsp;&nbsp;&nbsp;此致
              </td>
            </tr>
            <tr>
              <td width="70%">&nbsp;</td>
              <td width="30%">
                经办人：
              </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
            </tr>
          </table>          
        </td>
      </tr>
      <tr height="350">
        <td width="5%">
          被保险人接到赔案注销通知书签署的意见
        </td>
        <td colspan=4>
          <table border=0 width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">  
            <tr height="80%">
              <td colspan=2>&nbsp;</td>
            </tr>
            <tr height="28%">
              <td width="70%">&nbsp;</td>
              <td width="30%">
                被保险人签章：
              </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日
              </td>
            </tr>
          </table>          
        </td>
      </tr>-->
    </table>
    <table border="0">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;注：本单由被保险人签收或保险人以挂号信邮寄。挂号信邮局回执存入卷宗</td>
      </tr>      
    </table>
     
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
