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
 
<%@include file="DAACheckReportNoneFormatPrintIni.jsp"%>
 
<html>    
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <body bgcolor="#FFFFFF" >
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;"><img src="/claim/images/LOGO.JPG"/></td>
        </tr>      
      <tr>
        <td colspan="3" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>�������������¹��ֳ��鿱��¼<br>        </td>
      </tr>
      <tr height=25>
        <td align=left  style="font-family:����; font-size:10pt;">
          ���պţ�<%=strPolicyNo%>        </td>
        <td align=center  style="font-family:����; font-size:10pt;">
          �����ţ�<%=strRegistNo%>        </td>
          <%
            if(strClaimNo == "" || strClaimNo.equals(""))
            {
          %>
        <td align=right  style="font-family:����; font-size:10pt;">
          ������:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
          <%
            }
          else
          	{ 
          %>
           <td align=right  style="font-family:����; font-size:10pt;">
          �����ţ�<%=strClaimNo%>        </td>
          <%
            }
          %>
       
      </tr>
    </table>  
    
   
      
   
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111">
      <tr> 
        <td height=25 colspan="3">����ʱ��:<%=strdamageStartDate%></td>
          
        <td width="170" height=25>���յص�:<%=strPrpLregistDamageAddress%></td>               
       
        <td width="244" height=25 colspan="1" >��������: &nbsp����������������	</td>                
           
      </tr>
      
      <tr>
        <td height=25 colspan="3 width="40%">�鿰ʱ��:<%=strgetCheckDate%></td>
      
        <td height=25>�鿰�ص�:<%=strCheckSite%></td>
      
        <td height=25 colspan="1" >�Ƿ��һ�ֳ�:<%=strFirstSite%></td>
       
      </tr>
      
      
   
      <tr>
   		<td  rowspan=4 colspan=1 width="28"><div align="center">���ճ���</div></td>
    		<td height=24 colspan=2 >�����ͺţ�<%=strBrandName%></td>
    		<td  width="170" height=24 colspan=1 >��������: <%=strEngineNo%></td>
    	  <td  colspan=1 width="244" height=24>���Ƶ�ɫ:  <%=strLicenseColor%></td>
     </tr>
     <tr>
     	  <td height=24 colspan=2 >���ƺ��룺<%=strLicenseNo%></td>
     	  <td  width="170" height=24 colspan=1 >���ܺţ�<%=strFrameNo%></td>
     	  <td  colspan=1 width="244" >���εǼ�����:</td>
     </tr>
     <tr>
     	  <td height=24 colspan=2 >��ʻԱ������<%=strPrpLdriverName%></td>
     	  <td  width="170" height=24 colspan=1 >��ʻ֤���룺<%=strPrpLdriverLicenseNo%></td>
     	  <td  colspan=1 width="244" aligh="center">׼�ݳ���:</td>
     </tr>
     <tr>
     	   <td height=24 colspan=2 >������֤����:</td>
     	   <td  colspan=1 width="170">�Ա�:���С�Ů</td>
     	    <td  colspan=1 width="244" aligh="center">��ϵ��ʽ:<%=strPrpLregistPhoneNumber%></td>
     </tr>	
  
     
     <!---<tr>
      <td  rowspan=3 colspan=1 width="28"><div align="center">���߳��� </div></td>
     	<td></td>
     	</tr>
     	<tr>
     	</tr>
     	<tr>
     	<tr>--->
     
   
     <%
    	for(int m=1; m < registDto.getPrpLthirdPartyDtoList().size();m++ )
    	{ 
    	    String strDriverName = "";
    	    String strDriverLicenseNo = "";
    	    String strDriverPhoneNo = "";
    %>
      
    	<tr>
    
   		  <td  rowspan=3 colspan=1 width="30"><div align="center">���߳���</div></td>
    		<td  width="235" height=26 colspan=1 >�����ͺţ�<%=strBrandNamethird[m]%></td>
    		<td  width="199" height=26 colspan=1 >���ƺ���: <%=strLicenseNothird[m]%></td>
    	  <td  colspan=2 height=26>��ǿ�ձ�����:<%=prpLRegistRPolicyNo%></td>
     </tr>
     <%
        if(strThirdPrpLdriverName.length > m)
        {
           strDriverName = strThirdPrpLdriverName[m];
           strDriverLicenseNo = strThirdPrpLdriverLicenseNo[m];
           strDriverPhoneNo = strThirdPrpLregistPhoneNumber[m];
        }
     %>
     <tr>
     	  <td width="235" height="33"  colspan=1 aligh="center">��ʻԱ����:<%=strDriverName%></td>
     	  <td  colspan=1 width="199" aligh="center">��ʻ֤���룺<%=strDriverLicenseNo%></td>
     	  <td  colspan=2 aligh="center">������:</td>
     </tr>
     <tr>
     	   <td width="235" height="28"  colspan=1 aligh="center">������֤����:</td>
     	   <td  colspan=1 width="199" aligh="center">�Ա�:���С�Ů</td>
     	    <td  colspan=1 width="68" aligh="center">׼�ݳ���:</td>
     	   <td  colspan=1 width="126" aligh="center">��ϵ��ʽ:<%=strDriverPhoneNo%></td>
     </tr>	
  
   <%
    }
   %>
     
     
     
   
    	<tr>
   		  <td  rowspan=5 colspan=1 width="28"><div align="center">�¹���Ϣ</div></td>
    		<td  width="190" height=27 colspan=1 >����ԭ��</td>
    		<td height=27 colspan=3 ><%=strDamageClause%></td>
    	</tr>
     <tr>
     	  <td width="190" height="24"  colspan=1 aligh="center">�¹�����</td>
     	 <td height=27 colspan=3 >����������&nbsp��˫���¹�&nbsp���෽�¹�&nbsp�����漰�Ʋ���ʧ&nbsp���漰��Ա����</td>
     	 
     </tr>
     <tr>
     	   <td width="190" height="28"  colspan=1 aligh="center">�¹��漰�ĵ�������������:<%=registDto.getPrpLthirdPartyDtoList().size() - 1%></td>
     	   <td  colspan=2 aligh="center">��������������:��<%=personInjureB%>�ˣ���<%=personDeathB%>��</td>
     	    <td  colspan=1 width="244" aligh="center">������Ա��������:��<%=personInjureD1%>�ˣ���<%=personDeathD1%>��</td>
     </tr>
     
     <tr>
     	   <td width="190" height="28"  colspan=1 aligh="center">�¹ʴ���ʽ:<%=handleUnit%></td>
     	   <td  colspan=3 aligh="center">�Ƿ���Ҫʩ��:���ǡ�����</td>
      </tr>
   	   <tr>
     	   <td width="190" height="28"  colspan=1 aligh="center">Ԥ���¹����λ���:<%=indemnityDuty%></td>
     	   <td  colspan=3 aligh="center">�˶�ʩ�ȷѽ��:</td>
   	   </tr>
     	
  
    	<tr>
    		<td  rowspan=3 colspan=1 width="28"><p align="center">�鿰<br></p>
    		  <p align="center">&nbsp;</p>
    		  <p align="center"><br>
	      ��Ϣ</p>
   		  </td>
    	  <td height=100 colspan=4 >
    	  	<%
    	  	  for(int j = 0;j < prpLcheckExtDtoList.size();j++)
    	  	  {
    	  	     PrpLcheckExtDto prpLcheckExtDto = (PrpLcheckExtDto)prpLcheckExtDtoList.get(j);
    	  	%>
    	  	    <%=prpLcheckExtDto.getDisplayName()+" ����    ���� " + "<br>"%>
    	  	<%
    	  	  }
    	  	%>
   	  	  </td>
   	  </tr>
    	 <tr>
    		<td height=90 colspan=4><h6 align="justify">�鿰���(�¹ʾ�����ʩ�ȹ��̡��鿰����������ͳ��������ж�):<br>
    			<br>
    			<br>
    			<br>
    			<br>
    			<br>
    			
    		
   		   </h6></td>
    	 </tr>
    	 	<tr>
    	 		<td height=23 colspan=2 >��������ȼ�:</td>
    	 		<td width="170">����˳��:</td>
    	 		<td width="244">ѯ�ʱ�¼&nbsp&nbsp��,�ֳ���ͼ&nbsp&nbsp ��,�¹���Ƭ&nbsp&nbsp ��</td>
    	 </tr>
    	 <tr>
    	 	<td  rowspan=5 colspan=1 width="28">�����жϼ���ʧ����</td>
    	 <td  width="190" height=27 colspan=1 >����ԭ��</td>
    	 	<td height=27 colspan=3 ><%
   		  	  for(int count = 0;count < intItemKindCount;count++)
   		  	  {
   		    %>
   		    <%=strKindCode[count]%>&nbsp<%=strKindName[count]%>
   		    <%
   		      }
   		    %></td>
   		   
    	</tr>
    	<tr>
    		<td  width="190" height=27 colspan=1 >��������</td>
    		<td height=27 colspan=3 >�� ǿ ��:&nbsp&nbsp&nbsp������&nbsp&nbsp&nbsp��������(ע��/����)&nbsp&nbsp&nbsp����ȷ��(ԭ��:                 )<br>
    	  	  <br>
          ��ҵ����:&nbsp&nbsp&nbsp������&nbsp&nbsp&nbsp��������(ע��/����)&nbsp&nbsp&nbsp����ȷ��(ԭ��:            
    			</td>
    </tr>
    <tr>
    	<td  width="190" height=27 colspan=1 rowspan=3>�¹ʹ�����</td>
    	<td>�ܼ�:<%=new DecimalFormat("#,##0.00").format(lossFee+lossFeeThird)%></td>
    	<td>��������:<%=new DecimalFormat("#,##0.00").format(lossFee)%></td>
    	<td>�����߳���:<%=new DecimalFormat("#,##0.00").format(lossFeeThird)%></td>
    </tr>
    <tr>
    	<td width="125">����������Ա����:</td>
    	  <td width="177">��������Ա����:</td>
    	  <td width="242">�����ϲƲ���ʧ:</td>
    	</tr>
    	<tr>
    		<td width="125">�����߳��ϲƲ���ʧ:</td>
    	  <td width="177">�����������Ʋ���ʧ:</td>
    	  <td width="242">����:</td>
    </tr>
    </table>
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111">
    	<tr>
   	<td width="50%" height="50">�鿰��Աǩ��:<br>
   		<br>
	 <br></td>
   	<td width="50%">��������(������)ǩ��:<br>
   		<br>
	 <br></td>
  </tr>
  </table>
   
    
     
  
       
     
  <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body> 
</html>
