<%--
****************************************************************************
* DESC       �������������ռ��鶨�𱨸��ӡҳ��
* AUTHOR     ��wangli
* CREATEDATE ��2005-03-30
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="DAACheckCertainLossNoneFormatPrintIni.jsp"%>

<html>                                                                                 
  <head>                                                                               
    <title>�����������ռ��鶨�𱨸��ӡ</title>      
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">        
  </head>                                                                              

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">            
          <B>�����������ռ��鶨�𱨸�<B>
        </td>
      </tr>
      
     <%--
      <tr>
        <td align=left id="tdCompany" width="50%" style="font-family:����; font-size:10pt;">
          ���λ��ǩ�£���
        </td>
        <td align=right id="tdClaimNo" width="50%" style="font-family:����; font-size:10pt;">
          ������ţ�
        </td>
      </tr>
      --%>
     </table>
     
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">     
        <tr>           
         <td colspan=2 align="left" height="28" width="10%">���𾴵�:<input type=text name="prplInsuredName"  readonly="true" style="width:60px" value="<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>"></td>
       <%-- <td height="28" width="35%" id="tdInsuredName">&nbsp;</td> --%>
      </tr>
      <br>
      &nbsp;&nbsp;   
      <tr>           
      <td colspan=2 align="left" height="28" width="10%">
         ���� <input type=text name="prplInsuredAddress"   style="width:100px" value="">Ͷ���Ļ�������<input type=text name="prplInsuredAddress"   style="width:100px" value="">  �� <input type=text name="prplAccidentDate"   style="width:60px" value=""> �� <input type=text name="prplAccidentAddress"   style="width:100px" value=""> �����ı����¹ʣ��ұ��չ�˾�ӵ���������ί��<input type=text name="prplCommission"   style="width:100px" value="">   �����ĳ����¹ʽ��д���Ϊ��ֱ�������Ȩ�棬�����������Ĵ˱��档 </td>      
      </tr>
      </table>
    
    <!-- ���岿�� -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111"  style="font-family:����; font-size:10pt;">

    <tr>
    <td colspan=5 align="center" height="28" width="100%">
    <B> ��һ���֣������б���������ղ鿱ժҪ</B>
    </td>
    <tr>

      <tr>
        <td colspan=2 align="center" height="28" width="10%">��������</td>
        <td height="28" width="35%" id="tdInsuredName">&nbsp;</td>
        <td align="center" height="28" width="10%">���պ���</td>
        <td height="28" width="45%" id="tdPolicyNo">&nbsp;</td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="25">���պ���</td>
        <td height="28" id="tdLicenseNo">&nbsp;</td>
        <td align="center" height="28">���Ƴ���</td>
        <td height="28" id="tdBrandName">&nbsp;</td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="25">���ܺ���</td>
        <td height="28" id="tdLicenseNo">&nbsp;</td> 
        <td align="center" height="28">ʹ������</td>
        <td height="28" id="tdBrandName">&nbsp;</td> 
      </tr>
       
        <tr>
        <td  colspan=2 align="center" height="25">�е�����</td>    
        <td  colspan=3 align="left" height="28">
        <input type="checkbox" name="thirdperson"> ������������&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="others"> ǰ�󵲷粣������������
        </td>         
      </tr>
      
      <tr>
        <td colspan=2 align="center" height="28">�����ڼ�</td>
        <td colspan=3 height="28"    id="tdInsuredDate">&nbsp;</td>
      </tr>  
      <tr>
        <td colspan=2 align="center" height="28">����ʱ��</td>
        <td height="28" id="tdDamageStartDate">&nbsp;</td>
        <td align="center" height="28">���յص�</td>
        <td height="28" id="tdDamageAddress">&nbsp;</td>
      </tr>
       <tr>
        <td colspan=2 align="center" height="28">��������</td>
        <td colspan=3 align="left" height="28">       
        <input type="checkbox" name="belongto"> ����&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="notbelongto"> ������
        </td>
      </tr></table>
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">     
     <tr>
     <td colspan=5 align="center" height="28" width="100%">
     <B>�ڶ����֣���ĿǰΪֹ���������Ĺ���</B>
     </td>
    </tr>
     <br> 
        <tr>  
        <td  colspan=5 align="left" height="28">
        <p> 
        <input type="checkbox" name="secondpart1">
        �ұ��չ�˾�ѽ��������ı��������ѽ���ر�����Ϣ��¼�ڰ��� <br>
        <br>
        <input type="checkbox" name="secondpart2">
        �����Ѿ��Գ����ֳ������˲鿱���������������ˡ��ֳ��鿱���桱�� <br>
        <br>
        <input type="checkbox" name="secondpart3">
        �����Ѿ����¹ʳ��޳���<input type=text name="prplCarryFactory"   style="width:100px" value=""> ���ԣ� 
        <input type="checkbox" name="targetcar">
        ��ĳ� 
        <input type="checkbox" name="thirdcar">
        ���߳��������˲鿱��������ʧ��������˺�ʵ�� <br>
        <br>
        &nbsp;&nbsp; ��ĳ���ʧ��������Ϸ�<input type=text name="prplMaterialCost"   style="width:60px" value="">  Ԫ����ʱ�� <input type=text name="prplWorkCost"   style="width:60px" value=""> Ԫ �ϼƽ��<input type=text name="prplToltalCost"   style="width:60px" value="">
        Ԫ ��
        <p> ���߳���ʧ��������Ϸ�<input type=text name="prplMaterialCost2"   style="width:60px" value=""> Ԫ����ʱ�� <input type=text name="prplWorkCost2"   style="width:60px" value=""> Ԫ �ϼƽ�� <input type=text name="prplToltalCost2"   style="width:60px" value=""> Ԫ 
        �� <br>
        <br>
        <input type="checkbox" name="secondpart3">
        �����Ѿ����¹��ֳ��� <input type=text name="prplAccidentLocal"   style="width:100px" value="">���Ա����¹���ɵĵ����߲�����ʧ�����˲鿱��������ʧ��������˺�ʵ���˶������߲�����ʧ����<input type=text name="prplTotalCost3"   style="width:60px" value="">Ԫ�� 
        <br>
        <br>
        <input type="checkbox" name="secondpart4">
        �����Ѿ���ҽԺ�� <input type=text name="prplHospital"   style="width:100px" value="">���Ա����¹ʵ����ߣ�<input type=text name="prplInjuredPerson"   style="width:60px" value=""> ����ҽ����������˲鿱����������������ҽ�Ʒ����ܼ�<input type=text name="prplTotalCost4"   style="width:60px" value="">Ԫ �� <br>
        <br><p>
        Ϊ��ʹ������˽Ȿ���¹ʵ���ʧ�����������˳�������ұ��չ�˾������⣬ �����Ķ��鿱���𱨸����ļ���ظ�����������ز��ŵĽ᰸������</p>
      <p>����������֪��ָ�����ռ���������Ĳ��ϣ��ݽ����չ�˾���Ի�ú����⳥�� </p>
      <p><br>
        ������ڴ������¹ʵĹ��������κ����ʣ�������ʱ�µ����Ŀͻ���������ˣ���֮��ͨ�� </p>
      </td>         
      </tr>
     </table>
      <br> <br><p>
   <table width="92%">
   <tr> 
    <td width="92%" colspan=5 align="center"> 
      <p> &nbsp;&nbsp; &nbsp;  ��ϵ�� <input type=text name="prplLinkerName"   style="width:60px" value=""> &nbsp; &nbsp;��ϵ�绰 <input type=text name="prplLinkerPhone"   style="width:60px" value=""> 
    &nbsp; &nbsp;    ���� <input type=text name="prplLinkerFax"   style="width:60px" value=""></p></td>
   </tr>
   </table>
   <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">     
     <tr>
     <td colspan=5 align="center" width="100%">
     <B>�������֣��鿱���𱨸�����</B>
     </td>
     </tr>
     <br>
        <tr>  
        <td  align="left" >
       <B> �¹ʾ���</B>
        <td>
         </tr>
         <br><br>
     <tr>
     <td colspan="4" align="center"><textarea name="accidentcourse" cols="70" rows="5"></textarea></td>
    </tr>
     <tr>  
        <td  align="left" height="28">
        <B>�鿱���</B>
        <td>
         </tr>
         <br> <br>
     <tr>
    <td colspan="4" align="center"><textarea name="accidentcourse" cols="70" rows="5"></textarea></td>
    </tr>
    
      <tr>    
      <td  align="left" height="28">
      <B> ��ʧ��� </B>
      </td>
      </tr>
      <br> <br>
      
      <tr>  
      <td  align="left" width="10%"> ��ĳ���ʧ���: </td>
      <td  colspan="3" align="left" width="90%"><textarea name="targetcarContext" cols="60" rows="5"></textarea></td>
      </tr>
      <br> <br>
      <tr>  
      <td  align="left" width="10%"> ���߳���ʧ���: </td>
      <td  colspan="3" align="left" width="90%"><textarea name="thirdcarContext" cols="60" rows="5"></textarea></td>
      </tr>
      <br> <br>
      <tr>  
      <td  align="left" width="10%"> �������������: </td>
      <td  colspan="3" align="left" width="90%"><textarea name="thirdlosscarContext" cols="60" rows="5"></textarea></td>
      </tr>
     <br> <br>
      <tr>  
      <td  align="left" width="10%"> ��Ա�������: </td>
      <td  colspan="3" align="left" width="90%"><textarea name="personlosscarContext" cols="60" rows="5"></textarea></td>
      </tr>
       <br>
        <tr>  
        <td  align="left" height="28">
       <B> �����϶�</B>
        <td>
         </tr>
         <br><br>&nbsp;&nbsp;  
      <tr>
      <td colspan="4" align="left" height="28">
       �ұ��չ�˾���ݣ� <input type="checkbox" name="check"> �ֳ��鿱 <input type="checkbox" name="describe"> ˾������ ��������϶���ĳ�����<input type="radio" name="full">  ȫ������ <input type="radio" name="subordination">  ��Ҫ����  <input type="radio" name="noresponsiblity"> ������  <input type="radio" name="nodefinitude"> ����ȷ���� ������ <input type="radio" name="yes">  �ѱ� <input type="radio" name="no">  δ�� ����������
      </td>
      </tr>
      
        <tr>  
        <td  align="left" height="28">
       <B> ��ע</B>
        <td>
         </tr>
     <tr>
    <td colspan="4" align="center"><textarea name="remark" cols="70" rows="5"></textarea></td>
    </tr>
          <tr>  
        <td  align="left" height="28"> &nbsp;&nbsp;  ˳ף:<td>
         </tr><br>
         
         <tr>  
        <td  align="left" height="28"> ������ <td>
         </tr>
         <br><br><p>
       <tr>  
       <td  align="left" height="28">
       ���չ���ʦ:
       </td>
        <td  height="28">
       <input type=text name="prplInsuranceEngineer"   style="width:60px" value="">
        </td>
        
        <td  align="center" height="28">
        ����ˣ� 
        </td>
        </tr>
        <br><br>
        
        <tr>
        <td colspan="4" align="right">
       <input type=text name="prplCompanyName"   style="width:100px" value="">���չ������޹�˾
        </td>
        </tr>
        <br><br><br>
        <tr>
        <td colspan="4" align="right">
        �� &nbsp;&nbsp;�� &nbsp;&nbsp;��		
        </td>
         </tr>      
     </table>
     
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
