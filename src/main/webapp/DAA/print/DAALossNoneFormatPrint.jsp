<%--
****************************************************************************
* DESC       �������������ն��𱨸�/��ϸ���ӡҳ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
   <%-- ��ʼ�� --%>

<%@include file="DAALossNoneFormatPrintIni.jsp"%>

<html>
<!--<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">-->
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
  <script language='javascript'>
      function noticeShow()
      {
        initshow.style.display = "none";
		initdisplay.style.display = "";
		notice.style.display = "";
		list.style.display = "none";
		initlist.style.display = "none";
      }
	  function listShow()
      {
        initshow.style.display = "none";
		initdisplay.style.display = "";
		notice.style.display = "none";
		initlist.style.display = "";
      }
   </script>
  <body bgcolor="#FFFFFF" onload="loadForm()">
  <div id="initshow" style="display:">
    <table width="50%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td>
          <div align="center">
            <input name="loss" type="button" id="loss" class="button" value="���𱨸�" onClick="noticeShow()">
          </div></td>
        <td>
          <div align="center">
            <input name="list" type="submit" id="list" class="button" value="��ϸ��" onClick="listShow()">
          </div></td>
      </tr>
    </table>
  </div>
  <div id="initdisplay" style="display:none">
    <!-- ���ⲿ�� -->
    <table width="96%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="3" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="3" align=center style=" font-family:����; font-size:14pt;">
          <B><center>�����������ն��𱨸�<span id="initlist" style="display:none">��ϸ��</span><center><B>
        </td>
      </tr>
      <tr height=20>
        <td align=left id="tdRegistNo" width="25%" style="font-family:����; font-size:11pt;">
          �������ˣ�<%=strInsuredName%>
        </td>
        <td align=left id="tdRegistNo" width="43%" style="font-family:����; font-size:11pt;">�����ţ�<%=strRegistNo%></td>
        <td width="32%" align=right style="font-family:����; font-size:11pt;">��&nbsp;&nbsp;&nbsp;ҳ&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;ҳ</td>
      </tr>
    </table>

    <!-- ���岿�� -->
    <table border=1 width="96%" align="center" cellspacing="0" cellpadding="0" style=" border-collapse:collapse;font-family:����; font-size:11pt;" bordercolor="#111111">
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
        <!--
        <td height=20 colspan="1" >����</td>
        <td height=20 colspan="1"> �������� ��������</td>
        -->
        <% if ( k<2 ) {   %>
        <td width="22%" height=20 colspan="1" align="center"><%=strMainKindName[0]%></td>    
     <%}else if ( k > 1 ){   %>
        <td width="22%" height=20 colspan="1" align="center">
        <table  border=0 width="100%" align="center">
        <tr><td align="center" style="font-family:����; font-size:11pt;"><%=strMainKindName[0]%> </td></tr>
        <tr><td align="center" style="font-family:����; font-size:11pt;"><%=strMainKindName[1]%> </td></tr>
        </table>
        </td>    
         <%}%>
       <!-- <td width="17%" height=20 colspan="1" align="center"><%=strMainKindName%></td>                -->
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
        <td height=25 colspan="1" align="center">��������ʽ</td>
        <td height=25 colspan="1" align="center"><%=strGearboxName%></td>
        <td height=20 align="center">������</td>
        <!--        
        <td height=20 colspan="1">��������ʽ</td>
        <td height=20 colspan="1"> �� �Զ� �� �ֶ�</td>
        -->
        <td height=20 colspan="1" align="center"><%=strKindName[1]%></td>
      </tr>
      <tr>
        <!--
        <td height=25 colspan="1" align="center">��ȫװ��</td>
        <td height=25 colspan="3" align="center"><%=strSafeDevice%></td>      
        -->
        <td height=20 colspan="1" align="center">��ȫװ��</td>
        <td height=20 colspan="3" align="center"> �� ��ȫ���� �� ABSϵͳ ���ް�ȫװ��</td>
        <td height=20 align="center">������</td>
        <td height=20 colspan="1" align="center"><%=strKindName[2]%></td>
      </tr>
    </table>
      <table border=1 width="96%" align="center" cellspacing="0" cellpadding="2" style="font-family:����; font-size:11pt; border-collapse:collapse;display:none" bordercolor="#111111">
        <tr>
           <td height=20 colspan="1" width="8%"  align="center">�¹�����</td>
           <td height=20 colspan="1" width="38%" align="center"><%=strIndemnityDuty%></td>
           <td height=20 colspan="1" width="8%"  align="center">����ʱ��</td>
           <td height=20 colspan="1" width="18%" align="center"><%=strRepairStartDate%></td>
           <td height=20 colspan="1" width="10%" align="center">�޸�����ʱ��</td>
           <td height=20 colspan="1" align="center"><%=strRepairEndDate%></td>
        </tr>
    </table>
	   <div id="notice" style="display:none">
    <table  border=1 width="96%" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
      <tr>
	  	<td height=20 colspan="1" width="40%" valign="top">
			<table  border=1 width="100%" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse" bordercolor="#111111">
				<tr>
					<td height=20 colspan="1" width="50%" align="center">�����������</td>
					<td height=20 colspan="1" width="25%" align="center">����</td>
					<td height=20 colspan="1" width="25%" align="center">����۸�</td>
				</tr>
				<%if(intComponentCount<=17){ %> 
					<%for(int i=0;i<intComponentCount && i<17;i++){ %>
					<tr>
						<td height=20 colspan="1" align="center"><%=strCompName[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#").format(dblMaterialQuantity[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblMaterialUnitPrice[i])%></td>
				
					</tr>
					<%}%>
					<%for(int i=0;i<(17-intComponentCount);i++){ %>
					<tr>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
					</tr>
					<%}}else{%>
					<tr><td colspan="3">��������������𱨸���ϸ��������</td></tr>
					<%for(int i=0;i<16;i++){ %>
					<tr>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
						<td height=20 colspan="1" align="center"></td>
					</tr>
					<%}}%>
				<tr>
					<td height=20 colspan="2">���Ϸ�С�ƣ�</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumchangefee)%></td>
				</tr>
				
			</table>
		</td>
		<td height=20 colspan="1" width="60%" valign="top">
			<table  border=1 width="100%" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
				<tr>
					<td height=20 colspan="1" width="60%" align="center">������Ŀ</td>
					<td height=20 colspan="1" width="15%" align="center">��ʱ</td>
					<td height=20 colspan="1" width="25%" align="center">��ʱ��</td>
				</tr>
				<%if(count5<=2){ %>
					<tr>
						<td height=20 colspan="1">�¹ʲ�װ��</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%
					  for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("�¹ʲ�װ")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{ %>
					<tr>
						<td height=20 colspan="1">�¹ʲ�װ��</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour5)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee5)%></td>
				 	</tr>				
					  <tr>
						<td height=20 colspan="3">��������������𱨸���ϸ������</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}inttemp=0;%>
				   <%if(count1<=2){ %>
					<tr>
						<td height=20 colspan="1">�¹��ӽ�</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("�¹��ӽ�")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">�¹��ӽ�</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour1)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee1)%></td>
				 	</tr>				
					  <tr>
						<td height=20 colspan="3">��������������𱨸���ϸ������</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}inttemp=0;%>
				  <%if(count3<=2){ %>
					<tr>
						<td height=20 colspan="1">���ޣ�</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("�¹ʻ���")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">���ޣ�</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour3)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee3)%></td>
				 	</tr>
					  <tr>
						<td height=20 colspan="3">��������������𱨸���ϸ������</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					 <%}inttemp=0;%>
				   <%if(count4<=2){ %>
					<tr>
						<td height=20 colspan="1">�繤��</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%for(int i=0;i<intRepairFeeCount && inttemp<2;i++){
							if(strRepairType[i].equals("�¹ʵ繤")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<2-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">�繤��</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour4)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee4)%></td>
				 	</tr>
					  <tr>
						<td height=20 colspan="3">��������������𱨸���ϸ������</td>
					  </tr>
					  <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}inttemp=0;%>
				<%if(count2<=1){ %>
					<tr>
						<td height=20 colspan="1">�¹����᣺</td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
				 	</tr>
					  <%
					  for(int i=0;i<intRepairFeeCount && inttemp<1;i++){
							if(strRepairType[i].equals("�¹�����")){
							inttemp++;%>
					   <tr>
						<td height=20 colspan="1" align="center"><%=strCompName1[i]%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(dblManHour[i])%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblManHourFee[i])%></td>
					  </tr>
					  <%}}
					  for(int i=0;i<1-inttemp;i++){ %>
					   <tr>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
						<td height=20 colspan="1"></td>
					  </tr>
					  <%}
					  inttemp=0;
				}else{%>
					<tr>
						<td height=20 colspan="1">�¹����᣺</td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0").format(sumhour2)%></td>
						<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumhourfee2)%></td>
				 	</tr>
					  <tr>
						<td height=20 colspan="3">��������������𱨸���ϸ������</td>
					  </tr>
					  <%}inttemp=0;%>
				   <tr>
					<td height=20 colspan="2">��ʱ��С��:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(dblSumManHourFee[0])%></td>
				  </tr>
				  
				  <tr>
					<td height=20 colspan="2">�����:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumManager[0])%></td>
				  </tr>
				  <tr>
					<td height=20 colspan="2">�˷�:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumTransFee[0])%></td>
				  </tr>
				  <tr>
					<td height=20 colspan="2">˰��:</td>
					<td height=20 colspan="1" align="center"><%=new DecimalFormat("#,##0.00").format(sumTax[0])%></td>
				  </tr>
			</table>
		</td>
		  
		   
	  </tr>
    </table>
    <table  border=1 width="96%" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
      <tr>
        <td height=20 colspan="6"><p>��ҳδ��֮��Ŀ��������𱨸���ϸ��</P></td>
      </tr>
      <tr valign="top">
        <td colspan="6" height="80">
          1���ס��ҡ�������Э�̣���ȫͬ�ⰴ���Ϻ˶��ļ۸������ܼƹ��Ϸ�����ң���д)��<%=strSumAllFee%>(<%=new DecimalFormat("#,##0.00").format(dblSumManHourFee[0]+dblSumMaterialFee[0])%>)��<br>
          2���ҷ������Ϻ˶���Ŀ���ʱ����������������Ϻ˶�������������Ŀ������Υ�����׷���Ȩ���ҷ�׷�ؼ۸�� <br>
          3���ҷ���֤��_______���ڱ��ʱ������������ΥԼ��Ը���⳥������ʱ�����ɱ�����������ʧ�� <br>
          4�����������Ϻ˶���������Ŀ�ͼ۸����κ����顣���������������۸񳬱꣬���ҷ�����ȫ�����Ρ�<br>
          5������Լ����
        </td>
      </tr>
      <tr>
        <td colspan="2" height="100" align="center" valign="middle">
          <table width="100%" border="0" height="100%" style="font-family:����; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
            <tr>
              <td valign="top">
                �ҷ�(���޷�)ǩ�£�<br><br>
                <br>
             <br>
      <br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;
              </td>
            </tr>
          </table>
        </td>
        <td colspan="2" height="100" valign="middle" align="center">
          <table width="100%" border="0" height="100%" style="font-family:����; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
            <tr>
              <td valign="top">
                ����(�������˻�����Ȩί����)ǩ��:<br><br>
                <br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;
              </td>
            </tr>
          </table>
        </td>
        <td colspan="2" height="100" align="center" valign="middle" width="33%">
          <table  width="100%" border="0" height="100%" style="font-family:����; font-size:11pt;border-collapse: collapse" bordercolor="#111111">
          <tr>
              <td valign="top">
                �׷�(���չ�˾)ǩ��:<br>
                �鿱������:<%=strHandlerName%><br>
                �˼���:<%=strApproverName%><br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                <%=printDate.getYear()+1900%>��<%=printDate.getMonth()+1%>��<%=printDate.getDate()%>��&nbsp;
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table></div>
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </div>
  </body>
</html>
