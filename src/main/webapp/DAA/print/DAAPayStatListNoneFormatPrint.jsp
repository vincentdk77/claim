<%--
****************************************************************************
* DESC       �����������������ͳ����ϸ���ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@page errorPage="/UIErrorPage"%>

  <%-- ��ʼ�� --%>
  <%@include file="DAAPayStatListNoneFormatPrintIni.jsp"%>


<html>
  <head>
    <title>���������������ͳ����ϸ���ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">            
          <B>���������������ͳ����ϸ��<B>
        </td>
      </tr>
      <tr>
        <td width="50%" align=left id="tdInsuredName" style="font-family:����; font-size:10pt;">
          �������ˣ�
        </td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td width="50%" align=left id="tdPolicyNo" style="font-family:����; font-size:10pt;">
          ���յ��ţ�
        </td>
        <td width="50%" align=left id="tdClauseType" style="font-family:����; font-size:10pt;">
          �������
        </td>
      </tr>
      <tr> 
        <td width="50%" align=left id="tdClaimNo" style="font-family:����; font-size:10pt;">
          ������ţ�
        </td>
        <td width="50%" align=left id="tdCaseNo" style="font-family:����; font-size:10pt;">
          �ⰸ��ţ� 
        </td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr align="center"> 
        <td width="4%" align="center">�ձ�</td>
        <td colspan="2">�����Ŀ</td>
        <td width="10%">��ʧ���</td>
        <td width="10%">�⳥���</td>
        <td width="4%" align="center">�ձ�</td>
        <td width="25%">�����Ŀ</td>
        <td width="10%">��ʧ���</td>
        <td width="10%">�⳥���</td>
      </tr>
      <tr> 
        <td rowspan="6" width="4%" align="center">������ʧ�����</td>
        <td colspan="2" height="25">���Ϸ�</td>
        <td width="10%" height="25"><%=strCarCaiLiaoLoss%></td>
        <td width="10%" height="25"><%=strCarCaiLiaoRealpay%></td>
        <td rowspan="14" align="center" width="4%"> 
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>Ա</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
        </td>
        <td width="25%" height="25">ҽ�Ʒѣ������η��ã�</td>
        <td width="10%" height="25"><%=strPersonYiliaoLoss%></td>
        <td width="10%" height="25"><%=strPersonYiliaoRealpay%></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">��ʱ��</td>
        <td width="10%" height="25"><%=strCarGongshiLoss%></td>
        <td width="10%" height="25"><%=strCarGongshiRealpay%></td>
        <td width="25%" height="25">�󹤷�</td>
        <td width="10%" height="25"><%=strPersonWugongLoss%></td>
        <td width="10%" height="25"><%=strPersonWugongRealpay%></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">ʩ�ȷ�</td>
        <td width="10%" height="25"><%=strCarShijiuLoss%></td>
        <td width="10%" height="25"><%=strCarShijiuRealpay%></td>
        <td width="25%" height="25">סԺ��ʳ������</td>
        <td width="10%" height="25"><%=strPersonZhuyuanLoss%></td>
        <td width="10%" height="25"><%=strPersonZhuyuanRealpay%></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">��ֵ</td>
        <td width="10%" height="25"><%=strCarSumRest%></td>
        <td width="10%" height="25"></td>
        <td width="25%" height="25">�����</td>
        <td width="10%" height="25"><%=strPersonHuliLoss%></td>
        <td width="10%" height="25"><%=strPersonHuliRealpay%></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">��������</td>
        <td width="10%" height="25"><%=strCarCarElseLoss%></td>
        <td width="10%" height="25"><%=strCarCarElseRealpay%></td>
        <td width="25%" height="25">ҽ�ƻ���Ѻϼ�</td>
        <td width="10%" height="25"><%=strPersonYiliaoSumLoss%></td>
        <td width="10%" height="25"><%=strPersonYiliaoSumRealpay%></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">С��</td>
        <td width="10%" height="25"><%=strCarCarSumLoss%></td>
        <td width="10%" height="25"><%=strCarCarSumRealpay%></td>
        <td width="25%" height="25">�м����������</td>
        <td width="10%" height="25"><%=strPersonCanshengLoss%></td>
        <td width="10%" height="25"><%=strPersonCanshengRealpay%></td>
      </tr>
      <tr> 
        <td rowspan="26" align="center" width="4%"> 
          <p>��</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>��</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>��</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>��</p>
        </td>
        <td rowspan="6" width="4%" align="center">
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
          </td>
        <td width="23%" height="25">���Ϸ�</td>
        <td width="10%" height="25"><%=strThirdCailiaoLoss%></td>
        <td width="10%" height="25"><%=strThirdCailiaoRealpay%></td>
        <td width="25%" height="25">�м��þ߷�</td>
        <td width="10%" height="25"><%=strPersonCanjuLoss%></td>
        <td width="10%" height="25"><%=strPersonCanjuRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��ʱ��</td>
        <td width="10%" height="25"><%=strThirdGongshiLoss%></td>
        <td width="10%" height="25"><%=strThirdGongshiRealpay%></td>
        <td width="25%" height="25">����������</td>
        <td width="10%" height="25"><%=strPersonSiwangLoss%></td>
        <td width="10%" height="25"><%=strPersonSiwangRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">ʩ�ȷ�</td>
        <td width="10%" height="25"><%=strThirdShijiuLoss%></td>
        <td width="10%" height="25"><%=strThirdShijiuRealpay%></td>
        <td width="25%" height="25">ɥ���</td>
        <td width="10%" height="25"><%=strPersonSangzangLoss%></td>
        <td width="10%" height="25"><%=strPersonSangzangRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��ֵ</td>
        <td width="10%" height="25"><%=strThirdSumRest%></td>
        <td width="10%" height="25"></td>
        <td width="25%" height="25">�С�������С��</td>
        <td width="10%" height="25"><%=strPersonCanwangSumLoss%></td>
        <td width="10%" height="25"><%=strPersonCanwangSumRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��������</td>
        <td width="10%" height="25"><%=strThirdCarElseLoss%></td>
        <td width="10%" height="25"><%=strThirdCarElseRealpay%></td>
        <td width="25%" height="25">�������������</td>
        <td width="10%" height="25"><%=strPersonFuyangLoss%></td>
        <td width="10%" height="25"><%=strPersonFuyangRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">С��</td>
        <td width="10%" height="25"><%=strThirdCarSumLoss%></td>
        <td width="10%" height="25"><%=strThirdCarSumRealpay%></td>
        <td width="25%" height="25">��ͨ��</td>
        <td width="10%" height="25"><%=strPersonJiaotongLoss%></td>
        <td width="10%" height="25"><%=strPersonJiaotongRealpay%></td>
      </tr>
      <tr> 
        <td rowspan="17" width="4%" align="center">
          <p>��</p>
          <p>Ա</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
          <p>��</p>
        </td>
        <td width="23%" height="25">ҽ�Ʒѣ������η��ã�</td>
        <td width="10%" height="25"><%=strThirdYiliaoLoss%></td>
        <td width="10%" height="25"><%=strThirdYiliaoRealpay%></td>
        <td width="25%" height="25">ס�޷�</td>
        <td width="10%" height="25"><%=strPersonZhusuLoss%></td>
        <td width="10%" height="25"><%=strPersonZhusuRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">�󹤷�</td>
        <td width="10%" height="25"><%=strThirdWugongLoss%></td>
        <td width="10%" height="25"><%=strThirdWugongRealpay%></td>
        <td width="25%" height="25">С��</td>
        <td width="10%" height="25"><%=strPersonSumLoss%></td>
        <td width="10%" height="25"><%=strPersonSumRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">סԺ��ʳ������</td>
        <td width="10%" height="25"><%=strThirdZhuyuanLoss%></td>
        <td width="10%" height="25"><%=strThirdZhuyuanRealpay%></td>
        <td colspan="2" height="25">���������</td>
        <td width="10%" height="25"><%=strDaoqiangLoss%></td>
        <td width="10%" height="25"><%=strDaoqiangRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">�����</td>
        <td width="10%" height="25"><%=strThirdHuliLoss%></td>
        <td width="10%" height="25"><%=strThirdHuliRealpay%></td>
        <td colspan="2" height="25">���֡���ը����Ȼ��ʧ�����</td>
        <td width="10%" height="25"><%=strHuozaiLoss%></td>
        <td width="10%" height="25"><%=strHuozaiRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">ҽ�ƻ����С��</td>
        <td width="10%" height="25"><%=strThirdYiliaoSumLoss%></td>
        <td width="10%" height="25"><%=strThirdYiliaoSumRealpay%></td>
        <td colspan="2" height="25">��Ȼ��ʧ�����</td>
        <td width="10%" height="25"><%=strZiranLoss%></td>
        <td width="10%" height="25"><%=strZiranRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">�м����������</td>
        <td width="10%" height="25"><%=strThirdCanshengLoss%></td>
        <td width="10%" height="25"><%=strThirdCanshengRealpay%></td>
        <td colspan="2" height="25">�����������������</td>
        <td width="10%" height="25"><%=strPoliLoss%></td>
        <td width="10%" height="25"><%=strPoliRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">�м��þ߷�</td>
        <td width="10%" height="25"><%=strThirdCanjuLoss%></td>
        <td width="10%" height="25"><%=strThirdCanjuRealpay%></td>
        <td colspan="2" height="25">���ϻ������������</td>
        <td width="10%" height="25"><%=strHuowuLoss%></td>
        <td width="10%" height="25"><%=strHuowuRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">�в���С��</td>
        <td width="10%" height="25"><%=strThirdCanbuSumLoss%></td>
        <td width="10%" height="25"><%=strThirdCanbuSumRealpay%></td>
        <td colspan="2" height="25">ͣʻ��ʧ�����</td>
        <td width="10%" height="25"><%=strTingshiLoss%></td>
        <td width="10%" height="25"><%=strTingshiRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">����������</td>
        <td width="10%" height="25"><%=strThirdSiwangLoss%></td>
        <td width="10%" height="25"><%=strThirdSiwangRealpay%></td>
        <td colspan="2" height="25">�޹�ʧ���������</td>
        <td width="10%" height="25"><%=strWuguoshiLoss%></td>
        <td width="10%" height="25"><%=strWuguoshiRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">ɥ���</td>
        <td width="10%" height="25"><%=strThirdSangzangLoss%></td>
        <td width="10%" height="25"><%=strThirdSangzangRealpay%></td>
        <td colspan="2" height="25">��������ʧ��</td>
        <td width="10%" height="25"><%=strHuahenLoss%></td>
        <td width="10%" height="25"><%=strHuahenRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">������С��</td>
        <td width="10%" height="25"><%=strThirdWangbuSumLoss%></td>
        <td width="10%" height="25"><%=strThirdWangbuSumRealpay%></td>
        <td colspan="2" height="25">����������Լ���</td>
        <td width="10%" height="25"><%=strMianpeiLoss%></td>
        <td width="10%" height="25"><%=strMianpeiRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">�������������</td>
        <td width="10%" height="25"><%=strThirdFuyangLoss%></td>
        <td width="10%" height="25"><%=strThirdfuyangRealpay%></td>
        <td colspan="2" height="25">������Լ���</td>
        <td width="10%" height="25"><%=strJiuzhuLoss%></td>
        <td width="10%" height="25"><%=strJiuzhuRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��ͨ��</td>
        <td width="10%" height="25"><%=strThirdJiaotongLoss%></td>
        <td width="10%" height="25"><%=strThirdJiaotongRealpay%></td>
        <td colspan="2" height="25">���������ϼ�</td>
        <td width="10%" height="25"><%=strElseRiskLoss%></td>
        <td width="10%" height="25"><%=strElseRiskRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">ס�޷�</td>
        <td width="10%" height="25"><%=strThirdZhusuLoss%></td>
        <td width="10%" height="25"><%=strThirdZhusuRealpay%></td>
        <td colspan="2" height="25">���鿱��</td>
        <td width="10%" height="25"><%=strChakanLoss%></td>
        <td width="10%" height="25"><%=strChakanRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��ͨס�޷�С��</td>
        <td width="10%" height="25"><%=strThirdJiaotongSumLoss%></td>
        <td width="10%" height="25"><%=strThirdJiaotongSumRealpay%></td>
        <td colspan="2" height="25">������</td>
        <td width="10%" height="25"><%=strJiandingLoss%></td>
        <td width="10%" height="25"><%=strJiandingRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��������</td>
        <td width="10%" height="25"><%=strThirdPersonElseLoss%></td>
        <td width="10%" height="25"><%=strThirdPersonElseRealpay%></td>
        <td colspan="2" height="25">�������ϡ��ٲ÷�</td>
        <td width="10%" height="25"><%=strElseSusongLoss%></td>
        <td width="10%" height="25"><%=strElseSusongRealpay%></td>
      </tr>
      <tr> 
        <td width="23%" height="25">��Ա�����Ѻϼ�</td>
        <td width="10%" height="25"><%=strThirdPersonSumLoss%></td>
        <td width="10%" height="25"><%=strThirdPersonSumRealpay%></td>
        <td colspan="2" height="25">��������/��ֵ���</td>
        <td width="10%" height="25"><%=strElseSumRest%></td>
        <td width="10%" height="25"></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">&nbsp;&nbsp;&nbsp;�����Ʋ����</td>
        <td width="10%" height="25"><%=strThirdPropElseLoss%></td>
        <td width="10%" height="25"><%=strThirdPropElseRealpay%></td>
        <td colspan="2" height="25">Ԥ�����</td>
        <td width="10%" height="25"><%=strSumPrepaid%></td>
        <td width="10%" height="25"></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">&nbsp;&nbsp;&nbsp;���ϡ��ٲ÷���</td>
        <td width="10%" height="25"><%=strSusongLoss%></td>
        <td width="10%" height="25"><%=strSusongRealpay%></td>
        <td colspan="2" height="25">��������</td>
        <td width="10%" height="25"><%=strChargeElseLoss%></td>
        <td width="10%" height="25"><%=strChargeElseRealpay%></td>
      </tr>
      <tr> 
        <td colspan="2" height="25">&nbsp;&nbsp;&nbsp;С��</td>
        <td width="10%" height="25"><%=strThirdSumLoss%></td>
        <td width="10%" height="25"><%=strThirdSumRealpay%></td>
        <td colspan="2" height="25">���ϼ�</td>
        <td colspan="2" width="10%" height="25"><%=strSumPaid%></td>
      </tr>
    </table>
    
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />       
    
  </body>
</html>
