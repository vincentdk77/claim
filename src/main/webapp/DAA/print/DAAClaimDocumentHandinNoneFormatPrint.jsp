<%--
modify by caopeng at 2005-12-2
�����޸�
--%>
<%@include file="DAAClaimDocumentHandinNoneFormatPrintIni.jsp"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>
<html>
  <head>
    <title>������������������Ͻ��ӵ���ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF">
    <!-- ���ⲿ�� -->
    
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:8pt;">
      <tr height="40">
        <td colspan="2" align=center style="text-align:center; font-family:����; font-size:18pt;">
          <B>������������������Ͻ��ӵ�<B><br><br>
        </td>
      </tr>
      <tr height="30">
        <td width="62%"></td>
        <td align="left">�����ţ�<%=strRegistNo%></td>
      <tr height="30">
        <td width=""62%></td><td align="left">�����ţ�<%=strPolicyNo%></td>
      </tr>
      <tr height="30">
        <td align="left" colspan="2">�𾴵�<ins>&nbsp;&nbsp;&nbsp;&nbsp;<%=strInsuredName%>&nbsp;&nbsp;&nbsp;&nbsp;</ins></td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;���ݡ�������������������֪���е�Ҫ�����յ����ṩ������������ϣ���"��"�Ų��֣���<br><br></td>
      </tr>
      <tr height="30">
        <td colspan="2"align="left">1.�¹ʴ����ų��ߵģ�</td>
      </tr>      
      <!--<tr height="30">
       <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� ��ͨ�¹��϶��� �� ������ �������¹ʴ����顡�� �����¹�֤��_______<br><br></td>
      </tr>-->
      <tr height="30">
      	<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;
      <%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("03")){
      		if("0301".equals(strTypeCode[index])){%>��ͨ�¹��϶���&nbsp;&nbsp;&nbsp;&nbsp<%}else{%>
		<%=strTypeName[index]%>&nbsp;&nbsp;&nbsp;&nbsp
	  <%inttemp++;}}}
	  if(inttemp==0){%>
		���������ύ����
	  <%}}else{%>
	  	���������ύ����
	  <%}%>
		<br><br></td>
      </tr>
      <tr height="30">
       <td colspan="2">2.��Ժ�ٲû������ߵģ�</td>
      </tr>
      <tr height="30">
        <!--<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� �ö��� �� �þ��� �������顡�� �о��顡�� �ٲ���<br><br></td>-->
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;
      <%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("04")){%>
		<%=strTypeName[index]%>&nbsp;&nbsp;&nbsp;&nbsp
	  <%inttemp++;}}
	  if(inttemp==0){%>
		���������ύ����
	  <%}}else{%>
	  	���������ύ����
	  <%}%>
		<br><br></td>
      </tr>
      <tr height="30">
       <td colspan="2">3.�漰������ʧ</td>
      </tr>
      <tr height="30">
        <!--<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� �����������ʽ��Ʊ���������� ���ܽ�����������Ԫ���� ��������嵥 ��������Э��<br>&nbsp;&nbsp;&nbsp;&nbsp;�� ʩ�ȷѷ�Ʊ��   ���� �ܽ�        ��Ԫ<br><br></td>-->
        <td colspan="2">
        <table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
			UICodeAction uicodeAction = new UICodeAction();
      		for(index=0,inttemp=0;index<intSize;index++){
			String configCode = uicodeAction.translateRiskCodetoConfigCode(strTypeCode[index]);
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("05") && !"RISKCODE_DAA".equals(configCode)&& !"RISKCODE_DAX".equals(configCode)&& !"RISKCODE_DAT".equals(configCode) && !strTypeCode[index].equals("0504")){%>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;
		<%if(strTypeCode[index].equals("0502")){%>�����������ʽ��Ʊ<%}else{%>
		<%=strTypeName[index]%><%}if(strTypeCode[index].equals("0502")||strTypeCode[index].equals("0506")||strTypeCode[index].equals("0576")||strTypeCode[index].equals("0586")){%>���������� �ܽ�����������Ԫ
		<%}%></td>
	  <%inttemp++;
	  if(inttemp%3==0){%></tr><tr height="25"><%}}}
	  if(inttemp==0){%>
		<td>���������ύ����
	  <%}}else{%>
	  	<td>���������ύ����
	  <%}%>
		</td>
           </tr>                                                                       
         </table>
		<br><br></td>
      </tr>      
      <tr height="30">
       <td colspan="2">4.�漰�Ʋ���ʧ</td>
      </tr>
      <tr height="30">
        <!--<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� �豸�����켰��ʧ֤������ �豸�ָ��Ĺ���Ԥ�� �� ʩ�ȷѷ�Ʊ��   ���� �ܽ�      ��Ԫ<br>&nbsp;&nbsp;&nbsp;&nbsp;�� �Ʋ���ʧ�嵥&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�� ���á��޸�����Ʋ����йط��õ��ݣ�   ���� �ܽ�      ��Ԫ<br><br></td>-->
        <td colspan="2"><table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("06")){%>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=strTypeName[index]%><%if(strTypeCode[index].equals("0605")||strTypeCode[index].equals("0606")){%>���������� ���ܽ�����������Ԫ
		<%}%></td>
	  <%inttemp++;
	  if(inttemp%3==0){%></tr><tr height="25"><%}}}
	  if(inttemp==0){%>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
	  <%}}else{%>
	  	<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
	  <%}%>
		</td>
           </tr>                                                                       
         </table><br>
        </td>
      </tr>
      <tr height="30">
       <td colspan="2">5.�漰�����ˡ��С�����ʧ</td>
      </tr>
      <tr height="30">
        <td colspan="2">
             <!--
         <table style="font-family:����; font-size:8pt;">
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� �ؼ�����ҽԺ���֤��</td><td>�� ��Ժ֪ͨ��</td><td>�� ��Ҫ������Ա֤��</td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� ������Ա��֤�����������֤��</td><td>�� �ˡ��С�����֤�����������֤��</td><td>�� ��������֤������</td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� �������ṩ��ҽ�˲м�����</td><td>�� �������ṩ����֤������֤��������ע��֤��</td><td>�� ɥʧ�Ͷ�����֤��</td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� ����֤��</td><td>�� �����ɳ��������ߵ��ܺ��߼�ͥ���֤��</td><td>�� ������ӡ���� ��ҳ</td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� ���������ߵ��⳥֤��</td><td>�� �в��������߷�Ʊ����������֤��</td><td>�� ҽ���ֲ�</td>
           </tr> 
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� ҽ�ɷѽ�����ϸ��</td><td>�� ����ҽ�Ʒ��þ���ҽԺ֤��</td><td>�� תԺҽ��֤��</td>
           </tr>       
           <tr height="25">
             <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;�� ҽ�Ʒѱ���ƾ֤��   ���ݣ��ܽ�     ��Ԫ</td>-->
     	<table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("07")){%>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=strTypeName[index]%><%if(strTypeCode[index].equals("0717")){%>���������� ���ܽ�����������Ԫ
		<%}if(strTypeCode[index].equals("0716")){%>����������<%}%></td>
	  <%inttemp++;
	  if(inttemp%3==0){%></tr><tr height="25"><%}}}
	  if(inttemp==0){%>
		<td>���������ύ����
	  <%}}else{%>
	  	<td>���������ύ����
	  <%}%>
		</td>
           </tr>                                                                       
         </table><br>
        </td>
      </tr>
      <tr height="30">
       <td colspan="2">6.�漰������������:</td>
      </tr>      
      <tr height="30">
        <td colspan="2">
         <!--<table style="font-family:����; font-size:8pt;">
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� ���յ��ؼ��������첿�ų��ߵĵ�����������֤��</td><td>�� �ѵǱ���ʡ����ֽ��������֤��</td><td>�� �������ø��ӷ�ƾ֤</td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� �������Ǽ�֤�飨ԭ����</td><td>�� ����ͣʻ����֤��</td><td>�� ������ԭʼ��Ʊ</td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;�� ȫ�׳�Կ�ף�ԭ���䣩</td><td>�� ����ͣ�ŵ����˼�ʻ֤</td><td>�� Ȩ��ת����</td>
           </tr>      
           <tr height="25">
             <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;�� ��������Ӫҵִ�ո�ӡ�� �� �����������֤��ӡ��</td>
           </tr>                                                                       
         </table><br>-->
         <table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("08")){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=strTypeName[index]%></td>
			  <%inttemp++;
			  if(inttemp%3==0){%></tr><tr height="25"><%}}}
			  if(inttemp==0){%>
				<td>���������ύ����
			  <%}}else{%>
			  	<td>���������ύ����
			  <%}%>
		</td>
           </tr>                                                                       
         </table><br>
        </td>
      </tr>    
      <tr height="30">
       <td colspan="2">7.������������ʱ���ṩ����֤��ԭ���������չ�˾��֤�����渴ӡ��</td>
      </tr>
      <tr height="30">
        <!--<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� ���ճ�������������ʻ֤������ �D�¼�ʻ��Ա�Ļ�������ʻ֤<br><br></td>-->
		<td colspan="2"><table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].substring(0,2).equals("10")){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=strTypeName[index]%></td>
			  <%inttemp++;
			  if(inttemp%3==0){%></tr><tr height="25"><%}}}
			  if(inttemp==0){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
			  <%}}else{%>
			  	<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
			  <%}%>
		</td>
           </tr>                                                                       
         </table><br></td>
      </tr>   
      <tr height="30">
       <td colspan="2">8.��������ί�����˴�����������ʱ�ṩ��</td>
      </tr>
      <tr height="30">
        <!--<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� ��������������Ȩί����<br><br></td>-->
        <td colspan="2">        
	  <table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && strTypeCode[index].equals("Y02")){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=strTypeName[index]%></td>
			  <%inttemp++;
			  if(inttemp%3==0){%></tr><tr height="25"><%}}}
			  if(inttemp==0){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
			  <%}}else{%>
			  	<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
			  <%}%>
		</td>
           </tr>                                                                       
         </table><br>
        </td>
      </tr>
      <tr height="30">
       <td colspan="2">9.����������ȡ���ʱ�����ṩ���²��Ϻ�֤�����������չ�˾��֤�����棺</td>
      </tr>
      <tr height="30">
        <td colspan="2">
         <table style="font-family:����; font-size:8pt;">
           <tr height="25">
             <td >&nbsp;&nbsp;&nbsp;&nbsp;��������Ϊ��λ�ģ�</td><td>�� �������˿��ߵĽ����Ż�ί����</td><td>�� ��ȡ�����Ա���֤����ӡ��</td>
           </tr>
           <tr height="25">
             <td></td><td>�� �ӸǱ������˹��»�����µġ�����վݡ�</td><td></td>
           </tr>
           <tr height="25">
             <td>&nbsp;&nbsp;&nbsp;&nbsp;��������Ϊ���˵ģ�</td><td></td><td></td>
           </tr>                                                                           
         </table>
        </td>
      </tr>   
      <tr height="30">
        <td colspan="2">
         <table style="font-family:����; font-size:8pt;">
           <tr height="25">
             <td >&nbsp;&nbsp;&nbsp;&nbsp;�������˱�����ȡ���:</td><td>�� �����������֤ԭ������ӡ��</td><td>�� ��������������������֪��ԭ��</td>
           </tr>                                                                         
         </table>
        </td>
      </tr> 
      <tr height="30">
        <td colspan="2">
         <table width="100%" style="font-family:����; font-size:8pt;">
           <tr height="25">
             <td colspan="3" >&nbsp;&nbsp;&nbsp;&nbsp;�������˵�������Ϊ��������������</td>
           </tr>
           <tr height="25">
             <td width="10%"></td>
             <td>�� �����������֤��ӡ��</td>
             <td>�� �����ˣ���Ϊ�������˵����������֤ԭ������ӡ��</td>
           </tr>
           <tr height="25">
             <td ></td><td>�� �뱻�����˹�ϵ֤��</td><td>�� ��������������������֪��ԭ��</td>
           </tr>                                                                                     
         </table>
        </td>
      </tr> 
      <tr height="30">
        <td colspan="2">
         <table style="font-family:����; font-size:8pt;">
           <tr height="25">
             <td >&nbsp;&nbsp;&nbsp;&nbsp;ί��������ȡ��</td><td>�� ��������������Ȩί����</td><td>�� �����������֤ԭ������ӡ��</td>
           </tr>
           <tr height="25">
             <td ></td><td>�� ��ί�������֤ԭ������ӡ��</td><td>�� ��������������������֪��ԭ��</td>
           </tr>                                                                                     
         </table><br>
        </td>
      </tr>       
      <tr height="30">
       <td colspan="2">10.���а�������Ҫ�ĵ�֤��</td>
      </tr>
      <tr height="30">
        <!--<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;�� ���������������������� �� �����������յ���������ӡ�� �� ���չ�˾���ߵĶ��𱨸漰��ظ���<br><br></td>-->
        <td colspan="2">
        <table style="font-family:����; font-size:8pt;">
           <tr height="25">
			<%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && (strTypeCode[index].equals("Y01")||strTypeCode[index].equals("Y04")||strTypeCode[index].equals("Y24"))){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<%=strTypeName[index]%></td>
			  <%inttemp++;
			  if(inttemp%3==0){%></tr><tr height="25"><%}}}
			  if(inttemp==0){%>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
			  <%}}else{%>
			  	<td>&nbsp;&nbsp;&nbsp;&nbsp;���������ύ����
			  <%}%>
		</td>
           </tr>                                                                       
         </table><br>
      </tr> 
      <tr height="30">
       <td colspan="2">11.�ṩ����������֤���͵��ݣ�</td>
      </tr>
      <tr height="30">
      <%if(intSize>0){
      		for(index=0,inttemp=0;index<intSize;index++){
      		if(strTypeCode[index] != null && (strTypeCode[index].substring(0,2).equals("99")||strTypeCode[index].substring(0,2).equals("12"))){%>
		<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��<%=inttemp+1%>��<%=strTypeName[index]%></td></tr><tr>
	  <%inttemp++;}}%><%
	  if(inttemp==0){%>
		<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��1��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��2��
	  <%}}else{%>
	  	<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��1��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��2��
	  <%}%>
        <br><br></td>
      </tr>        
      <tr height="30">
        <td colspan="2">12.���ݡ���������������������֪����Ҫ�������貹���ύ�������ϣ�</td>
      </tr>
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��1��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��2��</td>
      </tr> 
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��3��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��4��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��5��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��6��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��7��</td>
      </tr>  
      <tr height="30">
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;��8��<br><br></td>
      </tr>                                                                                                                    
 </table>    
 <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:8pt;">
      <%if(strCollectFlag == null || "0".equals(strCollectFlag)){%><tr height="30">
        <td><span style="font-size:10pt; font-weight: bold;"></span><strong>�����������貹���ύ�ĵ�֤��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��ǰ�ͽ�������ע��������ص㣬��л������ϡ�</strong><br>
        <br></td>
      </tr> <%}else if("1".equals(strCollectFlag)){%> 
      <tr height="30">
        <td><span style="font-size:10pt; font-weight: bold;"></span><strong>���ṩ��������������ȫ����˾������Ϊ���������������������,������  &nbsp;&nbsp;&nbsp;&nbsp;��������������ȡ����ϵ����֪�Ƿ��⸶���⸶����л������ϡ�<br>
        </strong><br></td>
      </tr>  <%}%>
      <tr height="30">
        <td><strong>����ص�ָ�ϣ�</strong><br>
        <br></td>
      </tr>  
      <tr height="30">
        <td><strong> �Ʋ����չɷ����޹�˾�����绰��</strong><br>
        <br></td>
      </tr> 
 </table>
 <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:8pt;">
      <tr height="30">
        <td><strong>�������ˣ�</strong></td><td><strong>���չ�˾��</strong></td>
      </tr>  
      <tr height="30">
        <td>�ύ����������ڣ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</td><td>�յ�����������ڣ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</td>
      </tr>  
      <tr height="30">
        <td>ǩ�£�</td><td>������ǩ�֣�</td>
      </tr>  
 </table> 
<table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;display:none" bordercolor="#111111" >
  <tr height="30">
    <td colspan="1" width="15%">�������룺</td>
    <td colspan="2" width="31%">&nbsp;</td>
    <td colspan="1" width="15%"> ���ƺ��룺</td>
    <td colspan="2" width="31">&nbsp;</td>
  </tr>
  <tr height="30"> 
    <td colspan="1">��������</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="1">�����ձ�</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr height="30">
    <td colspan="1">�����ͺ�</td>
    <td colspan="1" width="15%">&nbsp;</td>
    <td colspan="1">ʹ������</td>
    <td colspan="1"> ��Ӫҵ �ڷ�Ӫҵ</td>
    <td colspan="1">������</td>
    <td colspan="1"width="15%">&nbsp;</td>
  </tr>
  <tr height="30">
    <td colspan="1">��������</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1">��/��λ</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1" width="10%">������</td>
    <td colspan="1">&nbsp;</td>
  </tr>  
  <tr height="30">
    <td colspan="1">�����ձ���</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1">�����������޶�</td>
    <td colspan="1">&nbsp;</td>
    <td colspan="1">������</td>
    <td colspan="1"width="15%">&nbsp;</td>
  </tr>
  <tr height="30" > 
    <td colspan="1">��������</td>
    <td colspan="5"><p>�� �������꣠ �� ������ʱ��  �� �������꣠ �£� �ն�ʮ��ʱֹ</p></td>
  </tr>      
  <tr height="30"> 
    <td colspan="1">��������</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="1">���յص�</td>
    <td colspan="2">&nbsp;</td>
  </tr>  
  <tr height="30">
    <td colspan="1"> ����ʱ��</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="1">����ʱ��</td>
    <td colspan="2">&nbsp;</td>
  </tr>    
  <tr height="30">
    <td colspan="1">����ԭ��</td>
    <td colspan="5">&nbsp;</td>
  </tr>  
  </table>
  <!--<table sytle="display:none">
  <tr height="30"> 
    <td height="44" colspan="2">�������������޶�</td>
    <td>&nbsp;</td>
  </tr>
  <tr height="125" > 
    <td height="75"  colspan="2" align=center> <p>�����ձ���</p></td>
    <td height="75" align=center>_____________</td>
    <td width="121" height="75" align=center>_____________</td>
    <td width="121" height="75" align=center>_____________</td>
    <td height="75" align=center>_____________</td>
    <td height="75" align=center>_____________</td>
  </tr>
  <tr height="125" > 
    <td height="65"  colspan="2" align=center>�����ձ��� </td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
    <td height="65" align=center>_____________</td>
  </tr>
  <tr height="125" > 
    <td height="44"  colspan="2" align=center> <p>ί������</p></td>
    <td height="44" colspan="5" ><p>1������Ϊǰ���ֳ���������Ƭ���鿱�ֳ��� </p>
      <p>2�� ��Ϊ�� �����ڴ򡰡̡�����Ŀ���鿱������</p>
      <p>
        �������˶���ĳ�������ʧ�� ���˶���ĳ��ϻ�����ʧ��ʩ�ȴ��� ���˶������߲�����ʧ��</p>
      <p> ������Э���������� �����㳵����������ʧ��Ƭ�� ����ʵ��Ա��������� </p>
      <p>������������������ʧ���� Ԫʱ���뼰ʱ���ҹ�˾�˶��� </p>
      <p>
        �����������������ճ��ձ�����¼�� </p>
      </td>
  </tr>
</table >-->
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="display:none">
<tr>
 <td colspan="2">
<p> ��ί���㹫˾���������ˣ�<br>
 &nbsp;&nbsp;&nbsp;1���������������鿱���桢���𱨸桢���˵��鱨�桢�ֳ���Ƭ����������Ƭ �鿱�����վݵ����в鿱�����ʼ��ҹ�˾��
 �ҹ�˾��ƾ�ݻ����鿱���á�<br>
 &nbsp;&nbsp;&nbsp;2��������<br>
 &nbsp;&nbsp;&nbsp;3��<br>
 &nbsp;&nbsp;&nbsp;4��<br>
 &nbsp;&nbsp;&nbsp;��Ԥ�����𳬹���������Ԫ��������������ʧ����������Ԫ�������֮��˾����������<br><br>  
 ��л��</p>     
 </td>
 </tr>
 <tr height="30">
    <td width="46">&nbsp; </td>
    <td>ί�й�˾:____________________________________��˾���£�</td>
 </tr>
 <tr height="30">
 ��<td width="46%">&nbsp;</td>
   <td>�ء���ַ:_____________________________________________</td>
 </tr>
 <tr height="30">
   <td>����������ϵ�绰:    _________________________________</td>
   <td>��������:_____________________________________________</td>
 </tr>
 <tr height="30">��
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_________________________________ </td>
   <td>��������:_____________________________________________</td>
 </tr>
 <tr height="30">��
   <td>��ϵ�ˣ�___________________________________________</td>
   <td>��ϵ�绰:_____________________________________________</td>
 <tr height="30">  
   <td>&nbsp;</td>
   <td>��&nbsp;ϵ&nbsp;��:_____________________________________________</td>
 </tr>
 <tr height="30">
   <td>&nbsp;</td>
   <td>ί������___________________________��_______��_______��</td>
 </tr>
</table>   
  	<!-- ��ť���� -->
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
