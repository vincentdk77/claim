<%--
****************************************************************************
* DESC       ：货运险保险拒赔/注销案件通知书打印页面
* AUTHOR     ：zhulianyu
* CREATEDATE ：2005-11-14
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%> 
<%@ page contentType="text/html; charset=GBK" %>
  <%-- 初始化 --%>
  <%@include file="ClaimRefuseNoticeNoneFormatPrintIni.jsp"%>
 
<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                    

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- 第一联部分 --> 
    <!-- 标题部分 --> 
    </br></br>
    <table width="85%" align="center"><tr><td width="99%">
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height="42">
        <td colspan="2" height="42" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      </br></br>
      <tr height="40">
        <td colspan="2" id="tdTitleName" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <B>保险拒赔(注销)案件通知书<B>
        </td>
      </tr>
     
    </table>
      
    <!-- 主体部分 -->

	<table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr height="42">
        <td colspan=1 width="12%" align="center">被保险人</td>
        <td colspan=2 id="tdInsuredName" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">报案号码</td>
        <td colspan=2 id="tdRegistNo" width="34%"align="center">&nbsp;</td>
      </tr>
      <tr height="42">
        <td colspan=1 width="12%"align="center">标的地址</td>
        <td colspan=2 id="tdDamageAddress" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">报损金额</td>
        <td colspan=2 id="tdSumAmount" width="34%"align="center">&nbsp;</td>
      </tr> 
      <tr height="42">
        <td colspan=1 width="12%"align="center">保单号码</td>
        <td colspan=2 id="tdPolicyNo" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">保险期间</td>
        <td colspan=2 id="tdInsuredDate" width="34%"align="center">&nbsp;</td>
      </tr>              
      <tr height="42">
        <td width="12%"align="center">出险时间</td>
        <td colspan=2 id="tdDamageStartDate" width="34%"align="center"></td>  
        <td width="12%"align="center">出险原因</td>
        <td colspan=2 id="tdDamageCause" width="34%"align="center">&nbsp;</td>        
      </tr>

      <tr height="200">
      <td colspan="7" valign=top id="tdDamageProcess">
      出险经过：
      </td>
      </tr>
      <tr height="200">
      <td colspan="7" valign=top id="tdCancelReason">
      拒赔(注销)理由：
      </td>
      </tr>      
      <tr height="140">
      <td colspan="3" valign=top width="46%">
          <br><br>&nbsp;&nbsp;&nbsp;&nbsp;被保险人如有异议，在接到本通知书十五天内，向本公司或本公司上级部门提出复议。超过十五天不提出复议的，作自动放弃。<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;被保险人签字：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;农户拒绝或不能到场签字的，由乡镇、民政干部签字。<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签字人：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
      

	  </td>
      <td colspan="4" valign=top><br><br><br>
      
      本公司地址：</br>&nbsp;&nbsp;&nbsp;&nbsp;<%=addressCName%><br><br>
      邮政编码：<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=postCode%><br><br>
      联系电话：<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=phoneNumber%><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保险人盖章：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=new SimpleDateFormat("yyyy 年 MM 月 dd 日").format(new Date())%>
      </td>      
      </tr>
            
    </table>
    <table border="0"style="font-family:宋体; font-size:10pt;">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;注：回执存入档案。</td>
      </tr>      
    </table>
        </td>
		<td width="1%" style="font-family:宋体; font-size:10pt;"><br><br><br><br><br>公<br>司<br>统<br>一<br>客<br>户<br>服<br>务<br>电<br>话<br>:<br>9<br>6<br>9<br>9<br>9<br><br><br><br><br><br><br>第<br>一<br>联<br>:<br>保<br>险<br>公<br>司<br>留<br>存<br>联</td>
      </tr>      
    </table>
    
    <p style="page-break-after:always"></p>
    
     <!-- 紧跟第二联 -->
     </br></br>
     <table width="85%" align="center"><tr><td width="99%">
     <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height="42">
        <td colspan="2" height="42" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      </br></br>
      <tr height="40">
        <td colspan="2" id="tdTitleName2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <B>保险拒赔(注销)案件通知书<B>
        </td>
      </tr>
     
    </table>
      
    <!-- 主体部分 -->

	<table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      <tr height="42">
        <td colspan=1 width="12%" align="center">被保险人</td>
        <td colspan=2 id="tdInsuredName2" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">报案号码</td>
        <td colspan=2 id="tdRegistNo2" width="34%"align="center">&nbsp;</td>
      </tr>
      <tr height="42">
        <td colspan=1 width="12%"align="center">标的地址</td>
        <td colspan=2 id="tdDamageAddress2" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">报损金额</td>
        <td colspan=2 id="tdSumAmount2" width="34%"align="center">&nbsp;</td>
      </tr> 
      <tr height="42">
        <td colspan=1 width="12%"align="center">保单号码</td>
        <td colspan=2 id="tdPolicyNo2" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">保险期间</td>
        <td colspan=2 id="tdInsuredDate2" width="34%"align="center">&nbsp;</td>
      </tr>              
      <tr height="42">
        <td width="12%"align="center">出险时间</td>
        <td colspan=2 id="tdDamageStartDate2" width="34%"align="center"></td>  
        <td width="12%"align="center">出险原因</td>
        <td colspan=2 id="tdDamageCause2" width="34%"align="center">&nbsp;</td>        
      </tr>

      <tr height="200">
      <td colspan="7" valign=top id="tdDamageProcess2">
      出险经过：
      </td>
      </tr>
      <tr height="200">
      <td colspan="7" valign=top id="tdCancelReason2">
      拒赔(注销)理由：
      </td>
      </tr>      
      <tr height="140">
      <td colspan="3" valign=top width="46%">
          <br><br>&nbsp;&nbsp;&nbsp;&nbsp;被保险人如有异议，在接到本通知书十五天内，向本公司或本公司上级部门提出复议。超过十五天不提出复议的，作自动放弃。<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;被保险人签字：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;农户拒绝或不能到场签字的，由乡镇、民政干部签字。<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签字人：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
      

	  </td>
      <td colspan="4" valign=top><br><br><br>
      
      本公司地址：</br>&nbsp;&nbsp;&nbsp;&nbsp;<%=addressCName2%><br><br>
      邮政编码：<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=postCode2%><br><br>
      联系电话：<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=phoneNumber2%><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;保险人盖章：<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=new SimpleDateFormat("yyyy 年 MM 月 dd 日").format(new Date())%>
      </td>      
      </tr>
            
    </table>
    <table border="0"style="font-family:宋体; font-size:10pt;">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;注：回执存入档案。</td>
      </tr>      
    </table>
        </td>
		<td width="1%" style="font-family:宋体; font-size:10pt;"><br><br><br><br><br>公<br>司<br>统<br>一<br>客<br>户<br>服<br>务<br>电<br>话<br>:<br>9<br>6<br>9<br>9<br>9<br><br><br><br><br><br><br>第<br>二<br>联<br>:<br>客<br>户<br>留<br>存<br>联</td>
      </tr>      
    </table>
     
     
     
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
