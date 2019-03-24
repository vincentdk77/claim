<%--
****************************************************************************
* DESC       ：机动车辆保险赔款通知书打印页面
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-09
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
  <%-- 初始化 --%>
  <%@include file="DAAIndemnityNoticeNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>机动车辆保险赔款通知书/收据打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<html>

<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<body onLoad="loadForm();">
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
  <tr height=30>
    <td colspan="2" align="center"> <img src="/claim/images/LOGO.jpg"/> </td>
  </tr>
  <tr>
    <td height="10"></td>
  </tr>
  <tr height=30>
    <td colspan="2" align=center style=" font-family:宋体; font-size:14pt;"> <B>
      <center>             
            <B> 赔&nbsp;&nbsp;款&nbsp;&nbsp;收&nbsp;&nbsp;据</b>            
      </center>
    </b></td>
  </tr>
    <tr>
    <td height="10"></td>
  </tr>
  
  <!--
  <tr height=20>
    <td align=left id="tdRegistNo" width="48%" style="font-family:宋体; font-size:10pt;">&nbsp; </td>
    <td width="52%">&nbsp;&nbsp;&nbsp;&nbsp;<strong>赔款计算书号：<span id="spCompensateNo"><%=strCompensateNo%></span></strong></td>
  </tr>
  -->
</table>
<table width="92%" border="1" align="center" bordercolor="#111111"
	cellspacing="0" cellpadding="0">
	<tr>
		<td bordercolor="#000000">
		<p>&nbsp;</p>
		<table width="90%" border="0" align="center" valign="middle">
			<tr>
				<td height="40" colspan="2">
				<p><strong>&nbsp;&nbsp;&nbsp;&nbsp;被保险人<ins>&nbsp;<span
					id="spInsuredName"></span>&nbsp;</font></ins> <br>
				（保单号<ins>&nbsp;&nbsp;<%=strPolicyNo%>&nbsp;&nbsp;</ins>）提出索赔申请。经我司审核，现已结案。</strong></p>
				</td>
			</tr>
			<tr>
				<td height="40" colspan="2"><strong>&nbsp;&nbsp;&nbsp;&nbsp;被保险人收到
				<ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>国元农业保险股份有限公司</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins>签发的
				<br>
				(险种)<ins><span id="spRiskName"></span></ins>的<span id="spBr"></span>计算书号为<ins><font
					id="" height="25" width="23%">&nbsp;&nbsp;<span
					id="spClaimNo"><%=strCompensateNo%></span>&nbsp;&nbsp;</font></ins>赔案的赔款。</strong></td>
			</tr>
			<tr>
				<!--<td width="61%" height="65"><strong>赔案金额 (大写):&nbsp;&nbsp;<ins><span id="spCSumPaid"><%=strCSumPaid%></span></ins></strong>
				 <br><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (小写):&nbsp;&nbsp;<ins><span
					id="spSumPaid"></span></ins>元</strong>
				</td>
				-->
				<td>
                 <table width="100%" border="0">
                 <tr>
                    <td height="25"></td>
                 </tr>
                    <tr>
                        <td heigh="5" align="right" width="127">
                            <strong>赔案金额 (大写)：&nbsp;&nbsp;</strong>                           
                        </td>  
                        <td>
                             <strong><ins><span id="spCSumPaid"><%=strCSumPaid%></span></ins></strong>  
                        </td>
                    </tr>
                    <tr>                  
                        <td heigh="5" align="right" width="127">
                            <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (小写)：&nbsp;&nbsp;</strong>
                        </td>
                        <td>
                            <strong><ins><span id="spSumPaid"></span></ins>元</strong>                            
                        </td>
                    </tr>
                    <tr>
                        <td height="50"></td>
                    </tr>
                </table>
                </td>
			</tr>
			<!--<tr>
        <td width="61%" height="10"><strong>赔案金额（小写）:&nbsp;&nbsp;<ins><span id="spSumPaid"></span></ins>元</strong></td>
        
      </tr>
      
      -->
			<tr>
				<td height="45">
				<table width="100%" border="0">
					<tr>
						<td><strong>收款人开户银行：<span id="spBank"></span></strong>
						<br>
						<strong>收款人帐户名称：<span id="spReceiverName"></span></strong>
						<br>
						<strong>收款人银行账号：<span id="spAccount"></span></strong></td>
					</tr>
					<tr>
						<td height="50"></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
                <td height="45">
                <table width="100%" border="0">
                    <tr>
                        <td><strong>国元农业保险股份有限公司</strong>
                            <br><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(理赔专用章)</strong>    
                        </td>                    
                        <td>
                            <strong>收款单位 (签章)</strong>
                            <br><strong>年&nbsp;&nbsp;月&nbsp;&nbsp;日</strong>    
                        </td>
                    </tr>
                    <tr>
                        <td height="50"></td>
                    </tr>
                </table>
                </td>
            </tr>
			
		</table>
		</td>
	</tr>

</table>
<table width="92%"  border="0" align="center">
  <tr>
    <td width="33%"><strong>核赔人：&nbsp;<%=underWriteName%></strong></td>
    <td width="33%"><strong>经办人：&nbsp;<%=handlerName %></strong></td>
    <td width="34%" align="right"><strong>打印日期：&nbsp;&nbsp;<span id="spYear"><%=strYear%></span>&nbsp;年&nbsp;<span id="spMonth"><%=strMonth%></span>&nbsp;月&nbsp;<span id="spDate"><%=strDate%>&nbsp;日</strong></td>
  </tr>
</table>
<jsp:include page="/common/print/PrintButton.jsp" />      
      <%--<jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
</body>
</html>
