<%--
****************************************************************************
* DESC       �����������������֪ͨ���ӡҳ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-09
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
  <%-- ��ʼ�� --%>
  <%@include file="DAAIndemnityNoticeNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>���������������֪ͨ��/�վݴ�ӡ</title>
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
    <td colspan="2" align=center style=" font-family:����; font-size:14pt;"> <B>
      <center>             
            <B> ��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</b>            
      </center>
    </b></td>
  </tr>
    <tr>
    <td height="10"></td>
  </tr>
  
  <!--
  <tr height=20>
    <td align=left id="tdRegistNo" width="48%" style="font-family:����; font-size:10pt;">&nbsp; </td>
    <td width="52%">&nbsp;&nbsp;&nbsp;&nbsp;<strong>��������ţ�<span id="spCompensateNo"><%=strCompensateNo%></span></strong></td>
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
				<p><strong>&nbsp;&nbsp;&nbsp;&nbsp;��������<ins>&nbsp;<span
					id="spInsuredName"></span>&nbsp;</font></ins> <br>
				��������<ins>&nbsp;&nbsp;<%=strPolicyNo%>&nbsp;&nbsp;</ins>������������롣����˾��ˣ����ѽ᰸��</strong></p>
				</td>
			</tr>
			<tr>
				<td height="40" colspan="2"><strong>&nbsp;&nbsp;&nbsp;&nbsp;���������յ�
				<ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>��Ԫũҵ���չɷ����޹�˾</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins>ǩ����
				<br>
				(����)<ins><span id="spRiskName"></span></ins>��<span id="spBr"></span>�������Ϊ<ins><font
					id="" height="25" width="23%">&nbsp;&nbsp;<span
					id="spClaimNo"><%=strCompensateNo%></span>&nbsp;&nbsp;</font></ins>�ⰸ����</strong></td>
			</tr>
			<tr>
				<!--<td width="61%" height="65"><strong>�ⰸ��� (��д):&nbsp;&nbsp;<ins><span id="spCSumPaid"><%=strCSumPaid%></span></ins></strong>
				 <br><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (Сд):&nbsp;&nbsp;<ins><span
					id="spSumPaid"></span></ins>Ԫ</strong>
				</td>
				-->
				<td>
                 <table width="100%" border="0">
                 <tr>
                    <td height="25"></td>
                 </tr>
                    <tr>
                        <td heigh="5" align="right" width="127">
                            <strong>�ⰸ��� (��д)��&nbsp;&nbsp;</strong>                           
                        </td>  
                        <td>
                             <strong><ins><span id="spCSumPaid"><%=strCSumPaid%></span></ins></strong>  
                        </td>
                    </tr>
                    <tr>                  
                        <td heigh="5" align="right" width="127">
                            <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (Сд)��&nbsp;&nbsp;</strong>
                        </td>
                        <td>
                            <strong><ins><span id="spSumPaid"></span></ins>Ԫ</strong>                            
                        </td>
                    </tr>
                    <tr>
                        <td height="50"></td>
                    </tr>
                </table>
                </td>
			</tr>
			<!--<tr>
        <td width="61%" height="10"><strong>�ⰸ��Сд��:&nbsp;&nbsp;<ins><span id="spSumPaid"></span></ins>Ԫ</strong></td>
        
      </tr>
      
      -->
			<tr>
				<td height="45">
				<table width="100%" border="0">
					<tr>
						<td><strong>�տ��˿������У�<span id="spBank"></span></strong>
						<br>
						<strong>�տ����ʻ����ƣ�<span id="spReceiverName"></span></strong>
						<br>
						<strong>�տ��������˺ţ�<span id="spAccount"></span></strong></td>
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
                        <td><strong>��Ԫũҵ���չɷ����޹�˾</strong>
                            <br><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(����ר����)</strong>    
                        </td>                    
                        <td>
                            <strong>�տλ (ǩ��)</strong>
                            <br><strong>��&nbsp;&nbsp;��&nbsp;&nbsp;��</strong>    
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
    <td width="33%"><strong>�����ˣ�&nbsp;<%=underWriteName%></strong></td>
    <td width="33%"><strong>�����ˣ�&nbsp;<%=handlerName %></strong></td>
    <td width="34%" align="right"><strong>��ӡ���ڣ�&nbsp;&nbsp;<span id="spYear"><%=strYear%></span>&nbsp;��&nbsp;<span id="spMonth"><%=strMonth%></span>&nbsp;��&nbsp;<span id="spDate"><%=strDate%>&nbsp;��</strong></td>
  </tr>
</table>
<jsp:include page="/common/print/PrintButton.jsp" />      
      <%--<jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
</body>
</html>
