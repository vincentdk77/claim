<%--
****************************************************************************
* DESC       �������������ս᰸�������ӡҳ��
* AUTHOR     ��zhaozhuo
* CREATEDATE ��2005-04-13
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
<%@include file="DAAEndcaseNoneFormatPrintIni.jsp"%>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">

<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
          </form>
          <p height="40" align=center style="font-family:����; font-size:14pt;">
          <B> �����������ս᰸������ </b></p>
      <br>
      <div align="left">
      <table border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="92%" id="AutoNumber1">
        <tr>
          <td  width="33%" id="tdComName" ></td>
          <td  width="33%" ></td>
          <td  width="33%" id="tdClaimNo" ></td>
        </tr>
        <tr>
          <td  width="33%" id="tdInsuredName" ></td>
          <td  width="33%" id="tdPolicyNo" ></td>
          <td  width="33%" id="tdCaseNo" ></td>
        </tr>
      </table>
      </div>

         <hr>
         <br>
         <br>
         &nbsp;&nbsp;&nbsp;
         <ins>&nbsp;<font id="tdDamageStartDate" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">����ʻ��Ա����������</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdDriverName">&nbsp;</font></ins>
         <font text-align:center">����ʻ֤���룺</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdDrivingLicenseNo">&nbsp;</font></ins>
         <font text-align:center">�����䣺</font>
         <ins>&nbsp;</ins>
         <font text-align:center">��׼�ݳ��ͣ�</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdDrivingCarType">&nbsp;</font></ins>
         <font text-align:center">����ʻ(���ƺ��룺</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdLicenseNo">&nbsp;</font></ins>
         <font text-align:center">�������ͺţ�</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdBrandName">&nbsp;</font></ins>
         <font text-align:center">)��������</font>
         <ins>&nbsp;<font id="tdDamageTypeName" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">ԭ����</font>
         <ins>&nbsp;<font id="tdDamageName" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">������ԭ���¹ʣ���ɱ�����ʧ��</font>
         <br><br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">�ӵ���������</font>
         <ins>&nbsp;<font id="tdChecker1" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">��</font>
         <ins>&nbsp;<font id="tdChecker2" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">ͬ־��</font>
         <ins>&nbsp;<font id="tdCheckDate" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">��</font>
         <ins>&nbsp;<font id="tdDamageAddress" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">���ص㣩�����˲鿱�����ݲ鿱����Լ��й�֤�����ϣ��϶����¹���</font>
         <ins>&nbsp;<font id="tdRiskCode" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">�����֣��������Ρ��˴��¹ʾ�</font>
         <ins>&nbsp;<font id="tdCheckUnitName" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">�϶������˸�</font>
         <ins>&nbsp;<font id="tdIndemnityDuty" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">���Σ�������Ӧ�е�</font>
         <ins>&nbsp;<font id="tdIndemnityDutyRate" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">�������Ρ�</font>
         <br><br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">�����б�������£�</font>
         <br>
         <table border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="92%">
           <tr>
             <td width="20%">Ͷ���ˣ�</td>
             <td width="30%" id="tdAppliName"></td>
             <td width="20%">�������ˣ�</td>
             <td width="30%" id="tdInsuredName1"></td>
           </tr>
           <tr>
             <td>ǩ�����ڣ�</td>
             <td id="tdOperateDate"></td>
             <td>�������ޣ�</td>
             <td id="tdStartTime"></td>
           </tr>
           <tr>
             <td>�ܱ��ս�</td>
             <td id="tdSumAmount1"></td>
             <td>�������޶</td>
             <td id="tdSumAmount2"></td>
           </tr>
           <tr>
             <td>Լ�����ڽ��Ѵ�����</td>
             <td id="tdPayTimes"></td>
             <td>���������</td>
             <td id="tdSumPremium"></td>
           </tr>
           <tr>
             <td>�б�����</td>
             <td colspan=3></td>
           </tr>
           <tr>
             <td colspan=4 id="tdItemKindInfo"></td>
           </tr>
         </table>
         
         <br>
         &nbsp;&nbsp;&nbsp;
         <font text-align:center">��������Ӧ�����ѣ�</font>
         <ins>&nbsp;<font id="tdPlanFee" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">Ԫ���ѽɸ���</font>
         <ins>&nbsp;<font id="tdFinishFee" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">Ԫ��</font>
         <br><br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">��������һ�ֳ�  �ڶ��ֳ������𣬱����¹ʺ˶���ʧ���£���������������</font><br>
         <table border="0" cellspacing="0" style="border-collapse: collapse" width="92%">
           <tr height="210" valign=top>
             <td id="tdContext1"></td>
           </tr>
         </table>
         <br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">�����㣬�������£���������������</font>
         <table border="0" cellspacing="0" style="border-collapse: collapse" width="92%">
           <tr height="80" valign=top>
             <td id="tdContext2"></td>
           </tr>
         </table>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">&nbsp;&nbsp;&nbsp;&nbsp;����ܼƣ�</font>
         <ins><font id=tdSumPaid>&nbsp;</font></ins>
         <font text-align:center">Ԫ��</font>
         <br>
         <hr>
 
         &nbsp;&nbsp;&nbsp;
         <p style="text-align: right">
           <font text-align:center">�����ˣ�<%=operatorName%></font>
         </p>

        <p style="text-align: right">
          <font  align=left ><%=operateTime%></font>
        </p>
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </form>
  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
    </b>
</html>
