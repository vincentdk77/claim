<%--
****************************************************************************
* DESC       �������������ճ�����ʧ���ȷ����������Ŀ�嵥��ӡҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@include file="DAALossNoneFormatPrintIni.jsp"%>
<%
  double  totalManHour=0.00;
  double  totalManHourFee=0.00;
  double  totalMaterialFee=0.00;
    
    %>
  
<html>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="3" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="3" align=center style=" font-family:����; font-size:14pt;">
          <B><center>�����������ն��𱨸���ϸ������</span><center><B>
        </td>
      </tr>
      <tr height=20>
        <td align=left width="48%" id ="tdInsuredName" style="font-family:����; font-size:10pt;">�������ˣ�<%=strInsuredName%>
        </td>
        <td align=left id="tdRegistNo" width="35%" style="font-family:����; font-size:10pt;">�����ţ�<%=strRegistNo%></td>
        <td width="17%" align=right style="font-family:����; font-size:10pt;">��<%=pageTotal%>ҳ&nbsp;&nbsp;&nbsp;��1ҳ</td>
      </tr>
    </table>
   
  
      
    <!-- ���岿�� -->  
    <table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td height=20 colspan="1" width="12%" align="center">���ƺ���</td>
        <td height=20 colspan="1" width="22%" align="center"><%=licenseNo%></td>
        <td height=20 colspan="2" align="center">��������</td>
        <td height=20 colspan="2" align="center"><%=strPolicyNo%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">��������</td>
        <td height=20 colspan="1" align="center" ><%=engineNo%></td>
        <td height=20 colspan="2" align="center" >�� �� ��</td>
        <td height=20 colspan="2" align="center"><%=frameNo%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">�����ͺ�</td>
        <td height=20 colspan="1" align="center"><%=brandName%></td>
        <td width="12%" height=20 colspan="1" align="center">����ʱ��</td>
        <td height=20 colspan="1" width="22%" align="center"><%=strDamageStartDate%></td>
        <td width="10%" height=20 align="center">�� ��</td>
       
     <% if ( k<2 ) {   %>
        <td width="22%" height=20 colspan="1" align="center"><%=strMainKindName[0]%></td>    
     <%}else if ( k > 1 ){   %>
        <td width="22%" height=20 colspan="1" align="center">
        <table  border=0 width="100%" align="center">
        <tr><td align="center"><%=strMainKindName[0]%> </td></tr>
        <tr><td align="center"><%=strMainKindName[1]%> </td></tr>
        </table>
        </td>    
         <%}%>
     </tr>
      <tr>
        <td height=20 colspan="1" align="center">��������</td>
        <td height=20 colspan="1" align="center"><%=strEnrollDate%></td>
        <td height=20 colspan="1" align="center">�� �� ��(L)</td>
        <td height=20 colspan="1" align="center"><%=douExhaustScale%></td>
        <td height=20 align="center">������</td>
        <td height=20 colspan="1" align="center"><%=strKindName[0]%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">��������ʽ</td>
        <td height=20 colspan="1" align="center"> �� ������ �� ����</td>
        <td height=20 colspan="1" align="center">��������ʽ</td>
        <td height=20 colspan="1" align="center">�� �Զ� �� �ֶ�</td>
        <td height=20 align="center">������</td>
        <td height=20 colspan="1" align="center"><%=strKindName[1]%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">��ȫװ��</td>
        <td height=20 colspan="3" align="center"> �� ��ȫ���� �� ABSϵͳ ���ް�ȫװ��</td>
        <td height=20 align="center">������</td>
        <td height=20 colspan="1" align="center"><%=strKindName[2]%></td>
      </tr>
    </table>
 
  <table  border=1 width="100%" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
  	  <tr><td width="50%" valign="top"><table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr>
			  <%
			  if(repairListInfo.size()<=23){
			  	for(int i=0;i<repairListInfo.size();i++){			  		
			  		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%"></td>
               	 		<td width="30%"></td>
               	 		</tr>
			  	  <%}else{%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>
			  	<%}
			  }
			  %>
			  <%for(int i=0;i<23-repairListInfo.size();i++){%>
			  	<tr align="center" height="25" >
			  	<td width="10%" colspan="1" ></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
               	</tr>
			  <%}%>
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(sumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee)%></td>
              </tr>
              </table>
          </td>
          <td width="50%" valign="top"><table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr>
              <%
              for(int i=0;i<23;i++){
              %>
              <tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
              </tr>
              <%}%>           
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%"></td>
                <td width="30%"></td>
              </tr>
              </table>	
          </td>
      </tr>
      <%}else if(repairListInfo.size()<=46){
      			for(int i=0;i<23;i++){
      				firstsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				firstsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();
			  		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" align="center" height="25"></td>
               	 		<td width="30%" align="center" height="25"></td>
               	 		</tr>
			  	  <%}else{%>
			  	 	 	<tr height="25" height="25">
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>
			  	<%}
			  }
			  %>
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(firstsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(firstsumhourfee)%></td>
              </tr>
              </table>
              </td>
              <td width="50%" valign="top">
			  <table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr>
              <%for(int i=23;i<repairListInfo.size();i++){
              		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" height="25"></td>
               	 		<td width="30%" height="25"></td>
               	 		</tr>
			  	  <%}else{%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>     
              <%}}%>
              <%for(int i=0;i<46-repairListInfo.size();i++){ %>
			  	<tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
               	</tr>
			  <%}%>       
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(sumhour-firstsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee-firstsumhourfee)%></td>
              </tr>
              </table>
              </td>
              </tr>	
      <%}else{
      			for(int i=0;i<23;i++){	
      				firstsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				firstsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();		  		
			  		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" height="25"></td>
               	 		<td width="30%" height="25"></td>
               	 		</tr>
			  	  <%}else{%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>
			  	<%}
			  }%> 
			  <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(firstsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(firstsumhourfee)%></td>
              </tr>
              </table>
              </td> 
              <td width="50%" valign="top">
              <table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr> 
              <%for(int i=23;i<46;i++){
              		secondsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				secondsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();
              		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" height="25"></td>
               	 		<td width="30%" height="25"></td>
               	 		</tr>
			  	  <%}else{%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>     
              <%}}%>
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(secondsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(secondsumhourfee)%></td>
              </tr>
              </table>
              </td>
              </tr>
              </table>
              
                  
    <!-- ��β���� -->
    <table width="100%" align="center" cellspacing="0" bordercolor="#111111" cellpadding="2" border="1" style="font-family:����; font-size:10pt;">
      <tr align="left"> 
        <td width="30%" id="tdSanctioner"><B>�鿱�����ˣ�<B><%=strHandlerName%></td>
        <td width="35%"><B>�˼��ˣ�<B><%=strApproverName%></td>
        <%if(strApproverName == ""){%>
			<td width="35%" align="left"><B><%--=verpDate.getYear()--%>��<%--=verpDate.getMonth()--%>��<%--=verpDate.getDay()--%>��<B></td>	
      	<%}%>
      	<%if(strApproverName != ""){%>
      		<td width="35%" align="left"><B><%=verpDate.getYear()%>��<%=verpDate.getMonth()%>��<%=verpDate.getDay()%>��<B></td>	
      	<%}%>
      </tr>
    </table>
    <table width="100%" align="center" cellspacing="0" cellpadding="2" border="0" style="font-family:����; font-size:10pt;">
      <tr align="left"> 
        <td colspan="2">
          ע: 1�����ᡢ����Һ�ͷ��㲿��������Ŀ���뱾��������Ŀ�У�<br>
              &nbsp;&nbsp;&nbsp;&nbsp;2���㲿��������Ŀ�Ĺ�ʱ�Ѳ����뱾��������Ŀ�С�<br>
        </td>
      </tr>
    </table>
    <%}%>
    
    
    <!-- ����ҳ-->
    <%
    int p=0;
    String table1Style="display:none";
    if (pageTotal>1) table1Style="";   
    for(p=0;p<pageTotal-1;p++){
    %>
    <table style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="3" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="3" align=center style=" font-family:����; font-size:14pt;">
          <B><center>�����������ն��𱨸���ϸ������-��ҳ��</span><center><B>
        </td>
      </tr>
      <tr height=20>
        <td align=left width="48%" id ="tdInsuredName" style="font-family:����; font-size:10pt;">�������ˣ�<%=strInsuredName%>
        </td>
        <td align=left id="tdRegistNo" width="35%" style="font-family:����; font-size:10pt;">�����ţ�<%=strRegistNo%></td>
        <td width="17%" align=right style="font-family:����; font-size:10pt;">��<%=pageTotal%>ҳ&nbsp;&nbsp;&nbsp;��<%=p+2%>ҳ</td>
      </tr>
    </table>

   <table  border=1 style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">  
      
      <tr height="25" border=1> 
        <td width="15%" align=center id="tdLicenseNo" style="font-family:����; font-size:10pt;">
          ���ƺ���:
        </td>
        <td width="35%" align=center ><%=licenseNo%></td>
        <td width="15%" align=center id="tdPolicyNo" style="font-family:����; font-size:10pt;">
          ���յ���: 
        </td>
        <td width="35%" align=center ><%=strPolicyNo%></td>
      </tr>
      <tr height="25"> 
        <td width="15%" align=center id="" style="font-family:����; font-size:10pt;">
          ��������: 
        </td>
         <td width="35%" align=center ><%=engineNo%></td>
        <td width="15%" align=center id="" style="font-family:����; font-size:10pt;">
          ���ܺ�:
        </td>
         <td width="35%" align=center ><%=frameNo%> </td>
      </tr>
    </table>
    <table  border=1 style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
  	  <tr><td width="50%" valign="top"><table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr>
			  <%
			  int sizeResult=(repairListInfo.size()-46) % 54;
			  //ֱ���жϵ�����
			  if((repairListInfo.size()<=73+54*p)||((repairListInfo.size()>(100+54*p))&&(sizeResult <=27))){
			  	firstsumhour = 0;
			  	firstsumhourfee = 0;
			  	for(int i=46+54*p;i<73+54*p;i++){
			  		firstsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				firstsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();			  		
			  		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){ %>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" height="25"></td>
               	 		<td width="30%" height="25"></td>
               	 		</tr>
			  	  <%}else{ %>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>
			  	<%}
			  	if(i == repairListInfo.size()-1){
			  		for(int j=0;j<27-sizeResult;j++){ %>
			  		<tr align="center" height="25" >
			  		<td width="10%" colspan="1"></td>
                	<td width="50%"></td>
                	<td width="10%"></td>
               		<td width="30%"></td>
               		</tr>
			  		<%}
			  		break;
			    }
			 }
			  %>
			  
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(firstsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(firstsumhourfee)%></td>
              </tr>
              </table>
          </td>
          <td width="50%" valign="top"><table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr>
              <%
              if(p != pageTotal-2){
              	secondsumhour = 0;
              	secondsumhourfee = 0;
              	for(int i=73+54*p;i<100+54*p;i++){
              		secondsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				secondsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();			  		
			  		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){ %>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" height="25"></td>
               	 		<td width="30%" height="25"></td>
               	 		</tr>
			  	  <%}else{ %>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>
			  	<%}}}else{
			  	secondsumhour = 0;
              	secondsumhourfee = 0;
			  	for(int i=0;i<27;i++){
              %>
              <tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
              </tr>
              <%}}%>           
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(secondsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(secondsumhourfee)%></td>
              </tr>
              </table>	
          </td>
      </tr>
      
      <%}else if((repairListInfo.size()<=100+54*p||(repairListInfo.size()>(100+54*p)))){
      			firstsumhour = 0;
      			secondsumhour = 0;
      			secondsumhourfee = 0;
      			firstsumhourfee = 0;
      			for(int i=46+54*p;i<73+54*p;i++){
      				firstsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				firstsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();
			  		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" align="center" height="25"></td>
               	 		<td width="30%" align="center" height="25"></td>
               	 		</tr>
			  	  <%}else{%>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>
			  	<%}
			  }
			  %>
              <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(firstsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(firstsumhourfee)%></td>
              </tr>
              </table>
              </td>
              <td width="50%" valign="top">
			  <table width="100%" border=1 align="top" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
              <tr align="center" bgcolor="#CCCCCC" height="25" > 
                <td width="10%" colspan="1"><B>���<B></td>
                <td width="50%"><B>������Ŀ����<B></td>
                <td width="10%"><B>��ʱ<B></td>
                <td width="30%"><B>��ʱ��<B></td>
              </tr>
              <%for(int i=73+54*p;i<100+54*p;i++){
              		secondsumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
      				secondsumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();
              		if(((RepairContentDto)repairListInfo.get(i)).getIsType()){%>
			  			<tr height="25" >			  			  			  
			  			<td width="10%" colspan="1" height="25"></td>
                		<td width="50%" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairType()%></td>
                		<td width="10%" height="25"></td>
               	 		<td width="30%" height="25"></td>
               	 		</tr>
			  	  <%}else{ %>
			  	 	 	<tr height="25" >
			  	  		<td width="10%" colspan="1" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getNo()%></td>
                		<td width="50%" align="center" height="25"><%=((RepairContentDto)repairListInfo.get(i)).getRepairName()%></td>
                		<td width="10%" align="center" height="25"><%=new DecimalFormat("#,##0").format(((RepairContentDto)repairListInfo.get(i)).getRepairHour())%></td>
               	 		<td width="30%" align="center" height="25"><%=new DecimalFormat("#,##0.00").format(((RepairContentDto)repairListInfo.get(i)).getRepairHourFee())%></td>
			  			</tr>     
              			<%}
              			if(i == repairListInfo.size()-1)
              				break;
              }%>
              <%for(int i=0;i<100+54*p-repairListInfo.size();i++){ %>
			  	<tr align="center" height="25" >
			  	<td width="10%" colspan="1"></td>
                <td width="50%"></td>
                <td width="10%"></td>
               	<td width="30%"></td>
               	</tr>
			  <%}%>
			  <tr bgcolor="#CCCCCC" height="25">
                <td width="60%" colspan="2" align="center"><B>С��<B></td>
                <td width="10%" align="center"><%=new DecimalFormat("#,##0").format(secondsumhour)%></td>
                <td width="30%" align="center"><%=new DecimalFormat("#,##0.00").format(secondsumhourfee)%></td>
              </tr>
              </table>
              </td>
              </tr>
              <%}%>       
              
              </table>      
    <!-- ��β���� -->
    <table style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" bordercolor="#111111" cellpadding="2" border="1" style="font-family:����; font-size:10pt;">
      <tr align="left"> 
        <td width="30%" id="tdSanctioner"><B>�鿱�����ˣ�<B><%=strHandlerName%></td>
        <td width="35%"><B>�˼��ˣ�<B><%=strApproverName%></td>
        <%if(strApproverName == ""){ %>
			<td width="35%" align="left"><B><%--=verpDate.getYear()--%>��<%--=verpDate.getMonth()--%>��<%--=verpDate.getDay()--%>��<B></td>	
      	<%}%>
      	<%if(strApproverName != ""){ %>
      		<td width="35%" align="left"><B><%=verpDate.getYear()%>��<%=verpDate.getMonth()%>��<%=verpDate.getDay()%>��<B></td>	
      	<%}%>
      </tr>
    </table>
    <table style="width:100%;align:center;<%=table1Style%>" align="center" cellspacing="0" cellpadding="2" border="0" style="font-family:����; font-size:10pt;">
      <tr align="left"> 
        <td colspan="2">
          ע: 1�����ᡢ����Һ�ͷ��㲿��������Ŀ���뱾��������Ŀ�У�<br>
              &nbsp;&nbsp;&nbsp;&nbsp;2���㲿��������Ŀ�Ĺ�ʱ�Ѳ����뱾��������Ŀ�С�<br>
        </td>
      </tr>
    </table>
    <%}%>
    
    <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>
    
    <!-- ��ť���� -->
    <table id="tbButton" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <tr>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonPrint value=" �� ӡ " class="button" onclick="return printPage()">
        </td>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonClose value=" �� �� " class="button" onclick="javascript:window.close()">
        </td>
      </tr>
    </table>   
  </body>

</html>
 