<%--
****************************************************************************
* DESC       �����ڻ������䱣������������ӡҳ��
* AUTHOR     ��zhuly
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
<%@include file="FreightInportCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>
    	<%=riskCName %>���������
    </title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align=center style="font-family:����; font-size:14pt;">
            <B><%=riskCName %>���������<B>
          </td>
        </tr>
      </table>

     <!-- ���岿�� -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
        <tr height="25">
          <td width="20%"  align="center" colspan="2">�� �� �� �� ��</td>
          <td id="tdPolicyNo" width="39%"align="center" colspan="3">&nbsp;</td>    
          <td width="15%"  colspan="2"align="center" >��&nbsp; ��&nbsp; ��</td>     
          <td align=center id="tdClaimNo" width="26%"align="center" colspan="3"></td>          
        </tr>
        <tr height="25">
          <td width="15%" align="center" colspan="2">��&nbsp; ��&nbsp; ��&nbsp; ��</td>
          <td id="tdInsuredName"align="center" colspan="3">&nbsp;</td>    
          <td width="15%"colspan="2"align="center">��&nbsp; ��&nbsp; ��&nbsp; ��</td>     
          <td id="tdDamageStartDate"align="center" colspan="3"></td>          
        </tr>   
        <tr height="25">
           <td width="15%" align="center"  colspan="2">��&nbsp;&nbsp;&nbsp; ��&nbsp;&nbsp;&nbsp; ��</td>
          <td id="tdLadingNo" colspan="3" align="center">&nbsp;</td>   
          <td width="15%" align="center" colspan="2">��&nbsp; ��&nbsp; ��&nbsp; ��</td>     
          <td align="center" id="tdSumAmount" colspan="3"></td>          
        </tr>
        <tr height="25">   
           <td width="12%" align="center" colspan="2" >��&nbsp; ˾&nbsp; ��&nbsp; ͬ<br>��&nbsp; ��&nbsp; Ʊ&nbsp; ��</td>
          <td id="tdInvoiceNo" width="39%"align="center" colspan="3">&nbsp;</td> 
          <td width="15%" align="center" colspan="2">��&nbsp; ��&nbsp; ��&nbsp; ��</td>     
          <td align=center id="tdRiskName" colspan="3"></td>           
        </tr>   
        <tr height="25">
          <td width="15%" align="center"  colspan="2">��&nbsp; ��&nbsp; ��&nbsp; ��</td>
          <td id="tdBLNo"align="center" colspan="3">&nbsp;</td>     
          <td width="3%" align="center" rowspan="5">��ļ�����</td>     
          <td align="center" id="tdValue1" rowspan="5" width="35%" colspan="4" valign="top"></td>          
        </tr> 
        <tr height="25">
          <td width="15%" align="center"  colspan="2">��&nbsp; ��&nbsp; ·&nbsp; ��</td>
          <td id="tdSiteName"align="center" colspan="3">&nbsp;</td> 
        </tr>
        <tr height="25">  
          <td width="15%" align="center"  colspan="2">��&nbsp; ��&nbsp; ��&nbsp; ��</td>     
          <td align="center"id="tdSailStartDate"align="center"  colspan="3"></td>          
        </tr> 
        <tr height="25">
          <td width="15%" align="center"  colspan="2">��&nbsp; ��&nbsp; ��&nbsp; ��</td>
          <td id="tdCheckAgentCode"align="center" colspan="3">&nbsp;</td>            
        </tr>                    
       
        <tr height="25">
          <td width="15%" align="center" colspan="2">�������˿�������</td>
          <td id="bank"align="center" colspan="3">&nbsp;<%=prpLcompensateDto.getBank()%></td>              
        </tr>
        <tr height="25">
          <td width="15%" align="center" colspan="2">�տ���ȫ��</td>
          <td id="bank"align="center" colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>    
          <td width="15%"colspan="2"align="center">֧&nbsp; ��&nbsp; ��&nbsp; ��</td>     
          <td id="account"align="center" colspan="3">&nbsp;<%=prpLcompensateDto.getAccount()%></td>          
        </tr>    
        <tr>
          <td id="tdContext" colspan="10" height="200" valign="top">
            ������㣺<br>
            <!--<input type=text rows=18 cols=95 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">-->
          </td>
        </tr>
		  <tr>
			<td colspan="2"> <div align="center">�� Ʒ �� �� </div></td>
			<td colspan="3"><div align="center"> �� �� �� �� </div></td>
			<td colspan="4" rowspan="6"width="20%"> <p>����������� </p>
			<p><input type="text" name="ksjsks" class="readonly"  readonly="true"  style="width:140px" value=""></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��</p>
			</td>
			<td width="129" rowspan="6"><p>�ֹ�˾����������� </p>  
			<p>&nbsp;</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��</p>
			</td>
		  </tr>
		  <tr>
			<td colspan="2"><div align="center"> �� �� �� �� </div></td>
			<td width="90"><div align="center"> �� �� �� </div></td>
			<td width="37"><div align="center"></div></td>
			<td width="122"><div align="center"> ԭ �� </div></td>
		  </tr>
		  
		  <%
		  	String strKindName2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  	String strRealPay = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  for(int i=0;i<prplLossList.size();i++){
		  	PrpLlossDto lossDto = (PrpLlossDto)prplLossList.get(i);
		  	if(lossDto.getKindName()!=null&&lossDto.getKindName().trim().length()>0){
			  	strKindName2 =lossDto.getKindName();
			  	strRealPay = new DecimalFormat("#,##0.00").format(lossDto.getSumRealPay());
			  	//lossDto.getSumRealPay()
		  	}else{
		  	 	strKindName2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  	 	strRealPay = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		  	}
		  	
		  %>
		  <tr>
			<td colspan="2"><div align="center"> <%=strKindName2%> </div></td>
			<td><div align="center"><%=strRealPay%></div></td>
			<td/>
			<td/>
		  </tr>
		  <%}%>		  

		  <tr>
			<td colspan="2"><div align="center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
			<td><div align="center"></div></td>
			<td><div align="center"></div></td>
			<td><div align="center"></div></td>
			<td colspan="4" rowspan="9"> <p>�ֹ�˾��ϯ����������� </p>
			 <p>&nbsp;</p>
			 <p>&nbsp;</p>
			 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��</p>
			
			</td>
			<td rowspan="9"> <p>�ܹ�˾����������� </p> 
			 <p>&nbsp;</p>
			 <p>&nbsp;</p>
			 <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��</p>
			</td>
		  </tr>
		  <tr>
			<td  rowspan="7" align="center">�� ��</td>
			<td ><div align="center">ʩ�ȷ�</div></td>
			<td id="tdRescueFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">�鿱��</div></td>
			<td id="tdCheckFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">���������</div></td>
			<td  id="tdJudgeFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">���������</div></td>
			<td  id="tdGsjzFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td><div align="center">������</div></td>
			<td  id="tdAssessFee" align="center"></td>
			<td/>
			<td/>
		  </tr>		  		  
		  <tr>
			<td><div align="center">���ɷ�</div></td>
			<td  id="tdFlFee" align="center"></td>
			<td/>
			<td/>
		  </tr>		  
		  <tr>
			<td><div align="center">����</div></td>
			<td id="tdElseFee" align="center"></td>
			<td/>
			<td/>
		  </tr>
		  <tr>
			<td colspan="2"><div align="center"> ������ʧ�ϼ� </div></td>
			<td id="tdSSumPaid" align="center"></td>
			<td/>
			<td/>
		  </tr>
       </table>        
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
