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
   <%-- ��ʼ�� --%>
<%@include file="DAACheckNoneFormatPrintIni.jsp"%>
  
<html>    
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <body bgcolor="#FFFFFF" >
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height=40>
        <td colspan="2" height="40" align=top align=center style=" font-family:����; font-size:14pt;">            
          <B>�������������¹��ֳ��鿱��¼<B>
        </td>
      </tr>
      <tr height=25>
        <td align=left  style="font-family:����; font-size:10pt;">
          ���յ����룺<%=strPolicyNo%>
        </td>
        <td align=left  style="font-family:����; font-size:10pt;">
          ������ţ�<%=strRegistNo%>
        </td>
        <td align=left  style="font-family:����; font-size:10pt;">
          ������ţ�<%=strClaimNo%>
        </td>
        <td>&nbsp;</td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr> 
        <td height=25 rowspan=2 colspan="1" width="4%">���ճ���</td>
        <td height=25 colspan="1" >�����ͺţ�<%=strBrandName%></td>
        <td height=25 colspan="1" >�������ţ�<%=strEngineNo%></td>
        <td height=25 colspan="1" >��������ʻ�<%=strRunDistance%></td>
        <td height=25 colspan="2" >��ʹ�����ޣ�<%=strUseYears%></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >���ƺ��룺<%=strLicenseNo%></td>
        <td height=25 colspan="2" >���ܺţ�<%=strFrameNo%></td>
        <td height=25 colspan="2" >���εǼ����ڣ�</td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >��ʻ��Ա������</td>
        <td height=25 colspan="1" >�Ա𣺡��С���Ů</td>
        <td height=25 colspan="1" >���䣺</td>
        <td height=25 colspan="2" >׼�ݳ��ͣ���A&nbsp;&nbsp;��B&nbsp;&nbsp;��C&nbsp;&nbsp;������<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >������֤���ڣ�</td>
        <td height=25 colspan="4" >��ʻ֤���룺��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;</td>
      </tr>
      <tr> 
        <td height=25 rowspan=2 colspan="1" width="4%">ְҵ���</td>
        <td height=25 colspan="3" >��ְҵ��ʻԱ���������������ߡ�����ҵ������Ա����˽Ӫ��ҵ������רҵ������Ա��������</td>
        <td height=25 colspan="2" >�Ļ��̶ȣ����о��������ϡ�����ѧ���ơ�</td>
      </tr>
      <tr> 
        <td height=25 colspan="3" >�����幤�̻�������ҵ����ҵԱ��������ҵ���ˡ���ũҵ�Ͷ��ߡ���������Ա��������</td>
        <td height=25 colspan="2" >����ר������ר�������С������м�����</td>
      </tr>
      <tr> 
        <td height=25 colspan="2" >�鿱ʱ�䣺�ꡡ���¡����ա�����ʱ</td>
        <td height=25 colspan="2" >�鿱�ص㣺</td>
        <td height=25 colspan="2" >�Ƿ��ǵ�һ�ֳ������ǡ�����</td>
      </tr>
      <tr> 
        <td height=25 colspan="6" >�ⰸ��𣺡�һ�㡡�����⣨�����ٴ�����������������������˫������ί����ز鿱�������ί�в鿱��</td>
      </tr>
      <tr> 
        <td height=25 colspan="3" >����ʱ�䣺�ꡡ���¡����ա�����ʱ</td>
        <td height=25 colspan="3" >���յص㣺ʡ�����С�����</td>
      </tr>
      <tr> 
        <td height=25 rowspan=3 colspan="1" width="4%">����������</td>
        <td height=25 colspan="1" >�����ͺţ�<%=strBrandNamethird%></td>
        <td height=25 colspan="2" >���ƺ��룺<%=strLicenseNothird%></td>
        <td height=25 colspan="1" >�Ƿ��գ����ǡ�����</td>
        <td height=25 colspan="1" width="24%">��������ʻ��̣�<%=strRunDistancethird%></td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >��ʻ��Ա����:</td>
        <td height=25 colspan="3" >��ʻ֤�ţ��� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��</td>
        <td height=25 colspan="1" width="24%">�������εǼ����ڣ�</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" >������֤����:</td>
        <td height=25 colspan="2" >׼�ݳ��ͣ���A&nbsp;&nbsp;��B&nbsp;&nbsp;��C&nbsp;&nbsp;������</td>
        <td height=25 colspan="1" >ְҵ��</td>
        <td height=25 colspan="1" width="24%">������ʹ�����ޣ�</td>
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=2 align=center>��<br>��<br>��<br>��<br>ʱ<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>ϸ<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>д<br></td>
        <td height=25 colspan="5" >
        &nbsp;1������ԭ��:  ����ײ�����㸲����Ϊ�֡�����ը������ȼ����������嵹�������������׹�䡡<br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ���׻��������硡�����ꡡ����ˮ�������֡���������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��<br>
        &nbsp;2���¹�ԭ��:  ���ƶ�ʧ�顡��ת��ʧ�顡��������е���ϡ���ƣ�ͼ�ʻ����������ʻ����Υ�²���<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������ʻ������ȫ��಻������Υ��װ�ء�������Υ����ʻ����������⡢��ʩ������������<br>
        &nbsp;3���¹����漰����: �������ա��������ա��������ա����������������ա�����ȼ��ʧ�� <br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������Ա�����ա������ϻ��������ա���������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��<br>
        &nbsp;4�����ճ������ƺ��롢�������š����ܺ��뱣�յ������������Ƿ���� ���ǡ�������<br>
        &nbsp;5������ʱ���Ƿ��ڱ�����Ч���� ���ǡ�������<br>
        &nbsp;6���Ƿ������쵼׷������ �����ǡ�������<br>
        &nbsp;7������ʱ��ӽ����������ڵģ�������Ӧʱ��֤��  ���ǡ�������<br>
        &nbsp;8�����յص㣺(1)���ࣺ �����ٹ�·������ͨ��·�������е�·����������ͻ���·������Ժ������<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)�뱨���������Ƿ�һ�£� ���ǡ�������<br>
        &nbsp;9��ʵ��ʹ�������뱣�յ������������Ƿ�һ�� ���ǡ�����<br>
        &nbsp;10�����ճ�����ʻ��Ա����뱨���������Ƿ�һ�� �����ǡ�������<br>
        &nbsp;11�����ճ�����ʻ��Ա�ļ�ʻ֤�Ƿ���Ч �����ǡ�������<br>
        &nbsp;12�����ճ�����ʻ��Ա׼�ݳ�����ʵ�ʼ�ʻ�����Ƿ���� ���ǡ�������<br>
        &nbsp;13��ʹ�ø���ר�û�е�������ֳ�����Ա�Ƿ��й����йز��ź˷�����Ч����֤ �����ǡ���������<br>
        &nbsp;14����ʻӪҵ�Կͳ��ļ�ʻ��Ա�Ƿ��й����йز��ź˷�����Ч�ʸ�֤�� �����ǡ�������<br>
        &nbsp;15�����ճ�����ʻ��Ա�Ƿ�Ϊ������������ļ�ʻ��Ա �����ǡ�����������<br>
        &nbsp;16�����ճ�����ʻ��Ա�Ƿ�Ϊ���պ�ͬԼ���ļ�ʻ��Ա �����ǡ�����������<br>
        &nbsp;17�����ճ�����ǿ��Ա�Ƿ�Ϊ�ƺ�ݳ� ���ǡ���������<br>
        &nbsp;18���¹ʳ�����ʧ�ۼ����¹��¹��ֳ��ۼ��Ƿ��Ǻ� �����ǡ���������<br>
        &nbsp;19�����ճ�����ȫ��������� ����ȫ���ҡ�����ABS���������״�����Ƕ�λ������������װ�ã�������ͣ����<br>
        &nbsp;20�������߳����Ƿ�������б���˾���������� �����ǡ���������<br>
        &nbsp;21���¹��Ƿ��漰�������������� ���ǣ���<u>&nbsp;&nbsp;</u>�ˣ���<u>&nbsp;&nbsp;</u>�ˣ�����������<br>
        &nbsp;22���¹��Ƿ��漰�������Ʋ���ʧ�����ǡ���������<br>
        &nbsp;23���¹��Ƿ��漰��������Ա����  ���ǣ���<u>&nbsp;&nbsp;</u>�ˣ���<u>&nbsp;&nbsp;</u>�ˣ�����������<br>
        &nbsp;24��ȷ����Ԥ�����λ��֣� ��ȫ����������Ҫ����ͬ�ȡ�����Ҫ���������Ρ�����������<br>
        &nbsp;25�����ճ�����ʧ�̶ȣ� ��ȫ����ʧ������������ʧ<br>
        &nbsp;26��������Ҫ˵�������ݣ� <br>
        <br>                      
        </td>
      </tr>
      <tr>
          <td colspan=5>�Ƿ����ڱ������Σ����ǡ��������ǡ�������ȷ����ԭ���ǣ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�� 
              
          </td>
      </tr>
     </table>
     <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr> 
        <td height=25 rowspan=4 colspan="1" width="4%">�¹ʹ�����</td>
        <td height=25 colspan="7" >�¹���ʧ������:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���У�������ʧ����ʧ��&nbsp;&nbsp;&nbsp;&nbsp;��������ʧ��&nbsp;&nbsp;&nbsp;&nbsp;������ʧ��&nbsp;&nbsp;&nbsp;&nbsp;</td>        
      </tr>
      <tr> 
        <td height=25 colspan="1" rowspan=3 width="4%">������ʧ���</td>
        <td height=25 colspan="1" rowspan=3 align=center width="6%">������ʧ��</td>
        <td height=25 colspan="1" rowspan=3>�����ʧ�� <br> ʩ�ȷѣ�<br>������&nbsp;&nbsp;&nbsp;&nbsp;�ϳ���&nbsp;&nbsp;&nbsp;&nbsp;������&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td height=25 colspan="1" rowspan=3 align=center width="6%">������������</td>
        <td height=25 colspan="1" width="16%">������</td>
        <td height=25 colspan="1" rowspan=3 align=center width="6%">������</td>
        <td height=25 colspan="1" ></td>
      </tr>
      <tr>
      <td height=25 colspan="1" width="16%">��Ա��</td>
      <td height=25 colspan="1" ></td>
      </tr>
      <tr>
      <td height=25 colspan="1" width="16%">�Ʋ���</td>
      <td height=25 colspan="1" ></td>
      </tr>
      <tr> 
       <td valign="top" rowspan=2 colspan=7>
         �鿱������������¹ʾ����������ͳ��������϶���<br><br>
         <br>
       </td>
       <td colspan="1" height="60" valign="middle" align="center">ѯ�ʱ�¼&nbsp;&nbsp;&nbsp;&nbsp;��          
       </td>
      </tr>
      <tr>
       <td colspan="1" height="60" valign="middle" align="center">�¹���Ƭ&nbsp;&nbsp;&nbsp;&nbsp;��          
       </td> 
      </tr>
    </table>
    <table border=0 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
       <td colspan="1">&nbsp;&nbsp;˵����1��������ʧ��λΪ����ҡ�����2�� ������������ֹһ���ģ������ӡ����������ֳ��鿱��¼����ֽ��        
       </td> 
    </table>
    
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body> 
</html>
