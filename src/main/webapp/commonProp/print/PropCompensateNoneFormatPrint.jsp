<%--
****************************************************************************
* DESC       ���Ʋ����������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��22004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- ��ʼ�� --%>
  <%@include file="PropCompensateNoneFormatPrintIni.jsp"%>
<html>

<body onload="loadForm();">
<p align="center"><strong><font size="5" face="����">( )����������</font></strong></p>
<br>
<tr>
  <td id="tdCompensateNo">�ⰸ��ţ�</td>
</tr>  </p>
<table width="96%" height="661" border="1" cellspacing="0" >
  <tr> 
    <td width="23%"><div align="center">�� �� �� ��</div></td>
    <td width="27%" id="tdInsuredName">&nbsp;</td>
    <td width="11%"><div align="center">���ձ��</div></td>
    <td width="39%" id="tdLossName">&nbsp;</td>
  </tr>
  <tr> 
    <td><div align="center">���յ� ����</div></td>
    <td id="tdPolicyNo">&nbsp;</td>
    <td><div align="center">�����ڼ�</div></td>
    <td id="tdInsuredDate">&nbsp;</td>
  </tr>
  <tr> 
    <td><div align="center">�� �� �� ��</div></td>
    <td id="tdSumAmount">&nbsp;</td>
    <td><div align="center">��������</div></td>
    <td id="tdDamageStartDate">&nbsp;</td>
  </tr>
  <tr> 
    <td><div align="center">�� �� �� ��</div></td>
    <td>&nbsp;</td>
    <td><div align="center">���յص�</div></td>
    <td id="tdDamageAddress">&nbsp;</td>
  </tr>
  <tr> 
    <td height="190"><div align="center">�����㷽ʽ</div></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr> 
    <td colspan="4"><div align="left">�����ϼƣ���д�������</div></td>
  </tr>
  <tr> 
    <td><div align="center">�� �� �� ��</div></td>
    <td><div align="center">���</div></td>
    <td><div align="center">����</div></td>
    <td><div align="center">����˵��</div></td>
  </tr>
  <tr> 
    <td><div align="center">�� Ʒ �� ʧ</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�뽫��� ����</td>
  </tr>
  <tr> 
    <td><div align="center">������ �⸶</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>��λ��</td>
  </tr>
  <tr> 
    <td><div align="center">ʩ���������</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�����У�</td>
  </tr>
  <tr> 
    <td><div align="center">�� �� ��</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�ʺţ�</td>
  </tr>
  <tr> 
    <td><div align="center">�� �� ��</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�������ڼ���ʽ��</td>
  </tr>
  <tr> 
    <td><div align="center">�� �� ��</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�뽫��� ����</td>
  </tr>
  <tr> 
    <td><div align="center"></div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>��λ��</td>
  </tr>
  <tr> 
    <td><div align="center"></div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�����У�</td>
  </tr>
  <tr> 
    <td><div align="center"></div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�ʺţ�</td>
  </tr>
  <tr> 
    <td><div align="center">�� ��</div></td>
    <td>&nbsp;</td>
    <td><div align="center"></div></td>
    <td>�������ڼ���ʽ��</td>
  </tr>
</table>
<table width="96%" height="100" border="0" cellspacing="0">
  <tr> 
    <td width="7%">���죺</td>
    <td width="16%">___________</td>
    <td width="9%">���ˣ�</td>
    <td width="18%">____________</td>
    <td width="8%">����</td>
    <td width="15%">___________</td>
    <td width="14%">�ֹ��ܾ���</td>
    <td width="13%">___________</td>
  </tr>
  <tr> 
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td colspan="2"><div align="right">�� �� ��</div></td>
    <td colspan="2"><div align="right">�� �� ��</div></td>
    <td colspan="2"><div align="right">�� �� ��</div></td>
    <td colspan="2"><div align="right">�� �� ��</div></td>
  </tr>
</table>
<p>&nbsp;</p>
</body>
</html>