<%--
****************************************************************************
* DESC       �������������������������鱨��ҳ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-07
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
<%@include file="DAAPersonDamageInvesReportNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>�����������������������鱨���ӡ</title>
    
   <style type="text/css">
   INPUT.printline
{
    FONT-SIZE: 10pt;
    BORDER-TOP: #ececec 0px solid;
    WIDTH: 10px;
    COLOR: #000000;
    BORDER-BOTTOM: #400000 1px solid;
    BORDER-RIGHT-STYLE: none;
    BORDER-LEFT-STYLE: none;
    BACKGROUND-COLOR: #ffffff
    text-align:center
}
   </style> 
  </head>

  <body bgcolor="#FFFFFF">
  <div align="center">
    <table width="92%" border="0" align="center" cellpadding="0" cellspacing="0" style="font-family:����; font-size:10pt;">
      <tr height=30>
        <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
      </tr>
      <tr height=30>
        <td colspan="2" align=center style=" font-family:����; font-size:14pt;"> <B>
          <center>
        �����������������������鱨��
          <center>
            <B> </b>
          </center>
          </center>
        </b><br><br></td>
      </tr>
      <tr height=20>
        <td width="48%" height="25" align=left > �����ţ� <%=strRegistNo%></td>
        <td align=left width="52%" >&nbsp;&nbsp;�����ţ� <%=strClaimNo%></td>
      </tr>
      <tr height=20>
        <td height="25" colspan="2" align=left ><table width="100%" height="701" border="0" align="center" cellpadding="0" cellspacing="0" style="font-family:����; font-size:10pt;" >
            <tr>
              <td height="25" colspan="2"  align="left">�����������ƣ�<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:100px;text-align:center" value="<%=strInsuredName%>"></td>
              <td colspan="2"><div align="left">������<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:150px;text-align:center" value="<%=strPolicyNo%>"></div></td>
              <td colspan="2"><div align="left">��ĳ��ƺ��룺<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:90px;text-align:center" value="<%=strLicenseNo%>"></div></td>
            </tr>
            <tr>
              <td height="25" colspan="6"><div align="left">���������ձ�&nbsp;&nbsp;&nbsp;&nbsp;<!--����������������������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������Ա������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������--><%=strReferKindName%></div></td>
            </tr>
            <tr>
              <td height="25" colspan="2"><div align="left">����ʱ�䣺<ins><input type=text name="prplCommission"   readonly="true" class="printline" style=" width:auto;text-align:center" value="<%=strdamageStartDate+"  "+strdamageStartHour%>"></ins></div></td>
              <td height="25" colspan="4"><div align="left">���յص㣺<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:330px;text-align:center" value="<%=strDamageAddress%>"> </div></td>
            </tr>
            <tr>
              <td height="25" colspan="2"><div align="left">������Ա������<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:100px;text-align:center" value="<%=strD1%>"></div></td>
              <td width="96" height="25"><div align="left">�Ա�<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:40px;text-align:center" value="<%=strSexName%>"></div></td>
              <td width="108">���䣺<input type=text readonly="true" class="printline" style=" width:40px;text-align:center" value="<%=strD3%>">
              ��</td>
              <td height="25" colspan="2"><div align="left">&nbsp;ְҵ��
                <input name="text" type=text class="printline" style=" width:130px;text-align:center" value="<%=strD2%>" readonly="true">
              </div></td>
            </tr>
            <tr valign="top">
              <td height="205" colspan="6"><div align="left">
                  <p>����ԭ�򡢾����������</p>
                  &nbsp;&nbsp;&nbsp;&nbsp;
                  <%=tempContext%> </div></td>
            </tr>
            <tr valign="top">
              <td height="109" colspan="6"><div align="left">
                  <p>�����̶ȣ�</p>
                  &nbsp;&nbsp;&nbsp;&nbsp;<%=strWoundRemark%></div></td>
            </tr>
            <tr valign="top">
              <td height="237" colspan="6"><div align="left">
                  <p>���˵���������¹����ʡ�ʩ���������ҽ��λ����ȣ���</p>
                  <p>&nbsp;&nbsp;&nbsp;&nbsp;�¹�����:&nbsp;&nbsp;<%=strDamageTypeName%></p>
				  <p>&nbsp;&nbsp;&nbsp;&nbsp;ʩ��ҽԺ:&nbsp;&nbsp;<%=strHospital%></p>
                  </div></td>
            </tr>
            <tr>
              <td height="25" colspan="2"><div align="left">��ѯ���ˣ�<ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></div></td>
              <td height="25">&nbsp;</td>
              <td height="25">&nbsp;</td>
              <td width="171" height="25"><div align="right">ѯ���ˣ�<ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></div></td>
              <td width="50"><div align="left"></div></td>
            </tr>
            <tr>
              <td width="125" height="25"><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</div></td>
              <td width="96" height="25">&nbsp;</td>
              <td height="25">&nbsp;</td>
              <td height="25">&nbsp;</td>
              <td height="25"><div align="center">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</div></td>
              <td width="50" height="25"><div align="center"></div></td>
            </tr>
        </table></td>
      </tr>
    </table>
  </div>
  <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  <script language='javascript'>
    function printPage()
    {
      divButton.style.display = "none";
      window.print();
    }
  </script>
  </body>
</html>
