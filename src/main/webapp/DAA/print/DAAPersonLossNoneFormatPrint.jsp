<%--
****************************************************************************
* DESC       �����������ֳ��鿱��¼��ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%
   //Ŀǰ��ȷ��ȡֵ����ȷ�Ϻ���Ե�����һ��ȡֵ��INIҳ��
   String strClaimNo         = request.getParameter("ClaimNo"); //������
%>
  
<html>    
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <body bgcolor="#FFFFFF" >
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height=40>
        <td colspan="2" height="40" align=top align=center style=" font-family:����; font-size:14pt;">            
          <B>��������������Ա���������嵥<B>
        </td>
      </tr>
      <tr height=25>
        <td align=left  style="font-family:����; font-size:10pt;">
          ������ţ�<%=strClaimNo%>
        </td>
        <td align=left  style="font-family:����; font-size:10pt;">
          ��λ��Ԫ������ң�
        </td>
        <td align=left  style="font-family:����; font-size:10pt;">
          ������Ա��ţ�
        </td>
        <td>&nbsp;</td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr> 
        <td height=25 rowspan=7 colspan="1" width="2%">��<br>��<br>��<br>��<br></td>
        <td height=25 colspan="1" width="10%">����</td>
        <td height=25 colspan="1" width="12%"></td>
        <td height=25 colspan="1" width="8%">�Ա�</td>
        <td height=25 colspan="1" width="8%"></td>
        <td height=25 colspan="1" width="10%">����</td>
        <td height=25 colspan="1" width="10%">�¹�����</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" width="10%">�⳥������%��</td>
        <td height=25 colspan="1" width="10%"></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >���֤����</td>
        <td height=25 colspan="3" ></td>
        <td height=25 colspan="1" >���Ƴ̶�</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="1" >��������</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >����ҽԺ</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >��Ͻ��</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="1" >�˲м�������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >����������˾���֧������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >ְ����ƽ��</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >����������˾�������֧��</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >ũ��������˾�������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >סԺ��ʳ�������ձ�׼���</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >ũ��������˾�����֧��</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >��ͨ���ձ�׼</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >ס�޷��ձ�׼</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="10" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >��<br>��</td>
        <td height=25 colspan="9" align=center>�⳥��Ŀ����ʽ</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=3>1</td>
        <td height=25 colspan="1" rowspan=3>ҽ�Ʒ�</td>
        <td height=25 colspan="1" >ҽҩ��</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >����ҽ�Ʒ�</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >���Ʒ�</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >����</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=3>2</td>
        <td height=25 colspan="1" rowspan=3>����<br>�󹤷�</td>
        <td height=25 colspan="1" >�¹�������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >�������ƽ��������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >סԺ����</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >������������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=8>3</td>
        <td height=25 colspan="1" rowspan=8>�����</td>
        <td height=25 colspan="1" >����������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >�¹�������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >��������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >�������ƽ��������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >����������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >�¹�������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >��������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >�������ƽ��������</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >���������</td>
        <td height=25 colspan="2" ></td>
        <td height=25 colspan="2" >���������ñ�׼</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="5" >�⳥���㹫ʽ:</td>
        <td height=25 colspan="1" >�����С��</td>
        <td height=25 colspan="2" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >4</td>
        <td height=25 colspan="1" >�м�������</td>
        <td height=25 colspan="1" >�˲еȼ�</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="6" >�⳥���㹫ʽ��</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=2>5</td>
        <td height=25 colspan="1" rowspan=2>�м��þ߷�</td>
        <td height=25 colspan="2" >�˲��þߵ��ۣ�</td>
        <td height=25 colspan="1" >����</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�м�������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�������</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1">6</td>
        <td height=25 colspan="1">����������</td>
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1">7</td>
        <td height=25 colspan="1">ɥ���</td>
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=7>8</td>
        <td height=25 colspan="1" rowspan=7>������</td>
        <td height=25 colspan="1" >������������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�ܸ�������</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >������������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�ܸ�������</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >������������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�ܸ�������</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >������С��</td>
        <td height=25 colspan="7" >������С��</td>
      </tr>
      <tr> 
        <td height=25 colspan="1">9</td>
        <td height=25 colspan="1">��ʳ������</td>
        <td height=25 colspan="8" >�⳥���㹫ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=2>10</td>
        <td height=25 colspan="1" rowspan=2>ס�޷�</td>
        <td height=25 colspan="1" >ס������</td>
        <td height=25 colspan="3" ></td>
        <td height=25 colspan="2" >ס�޷�ʵ���⳥���</td>
        <td height=25 colspan="2" ></td>
      </tr>
       <tr> 
        <td height=25 colspan="8" >ס�޷��⳥��׼��ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=2>11</td>
        <td height=25 colspan="1" rowspan=2>��ͨ��</td>
        <td height=25 colspan="1" >�ۼ�����</td>
        <td height=25 colspan="3" ></td>
        <td height=25 colspan="2" >��ͨ��ʵ���⳥���</td>
        <td height=25 colspan="2" ></td>
      </tr>
       <tr> 
        <td height=25 colspan="8" >��ͨ���⳥��׼��ʽ:</td>
      </tr>
      <tr> 
        <td height=25 colspan="1">12</td>
        <td height=25 colspan="1">Ӫ����</td>
        <td height=25 colspan="8" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1">13</td>
        <td height=25 colspan="1">�����𺦷�</td>
        <td height=25 colspan="8" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=4>14</td>
        <td height=25 colspan="1" rowspan=4>�μ�ɥ�´�<br>����Ա����</td>
        <td height=25 colspan="1" >ס�޷�</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >��ͨ��</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >ɥ�´�������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >����</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >ɥ�´���������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�¹���</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�󹤷ѹ�ʽ</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >ɥ�´���������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�¹���</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�󹤷ѹ�ʽ</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >ɥ�´���������</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�¹���</td>
        <td height=25 colspan="1" ></td>
        <td height=25 colspan="1" >�󹤷ѹ�ʽ</td>
        <td height=25 colspan="3" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1">15</td>
        <td height=25 colspan="1">��������</td>
        <td height=25 colspan="8" ></td>
      </tr>
      <tr> 
        <td height=25 colspan="1">16</td>
        <td height=25 colspan="2">��Ա����������úϼ�</td>
        <td height=25 colspan="7" ></td>
      </tr>
    </table>
    
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body> 
</html>
