<%--
****************************************************************************
* DESC       �����պ󳭵���ӡҳ��
* AUTHOR     ��  ��Ŀ��
* CREATEDATE �� 2005-09-15
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintHead01Ini.jsp"%>
<html>
  <head></head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="5" align="center" style="font-size:14pt;"><b> 
      ��Ԫ���չ�˾
      <!--
      <img src="images/chaodanLogo.gif" > 
      -->
      <%=strRiskName%>��������</b></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="4"/></td></tr>
      <tr><td colspan="5">�����ţ�<%= strRegistNo %></td></tr>
      <tr><td colspan="5">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr><td colspan="5">�����������ƣ�<%= strPolicyName %></td></tr>
      <tr><td colspan="5">�������˵�ַ��<%= strPolicyAddress %></td></tr>
<%
	
  int j = 0;
  if(strRiskCode.equals("0104")||strRiskCode.equals("0105")||strRiskCode.equals("1101")){
 
  	if(strRiskCode.equals("0104")){
%>
      <tr><td colspan="5">������ʧ���֣�</td></tr>
      <tr>
        <td style="width:20%"> </td>
        <td style="width:20%">������Ŀ</td>
        <td style="width:20%">���ս��</td>
        <td style="width:20%">����</td>
        <td style="width:20%">���ձ�ĵ�ַ</td>
      </tr>
<%
      for(i=0;i<strKindName.length;i++){
    	//����
    	  if(strCalculateFlag[i]!=null && strCalculateFlag[i].substring(2,3).equals("1") && strCalculateFlag[i].substring(4,5).equals("0") && strCalculateFlag[i].substring(5,6).equals("0")){
  		    j = j + 1;
%>
      <tr>
        <td ><%=j%></td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=strAmount[i]%></td>
        <td ><%=strCurrency%></td>
        <td ><%=strKindAddress[i]%></td>
      </tr>
<%
        }
      }//for
    }else if(strRiskCode.equals("0105")){
%>
      <tr><td colspan="5">�����𻵲��֣�</td></tr>
      <tr>
        <td style="width:20%"> </td>
        <td style="width:20%">�����豸˵��</td>
        <td style="width:20%">���ս��</td>
        <td style="width:20%">����</td>
        <td style="width:20%">��ַ</td>
      </tr>
<%
      for(i=0;i<strKindName.length;i++){
    	//����
       	if(strKindCode[i].equals("001")){
       		j = j + 1;
%>
      <tr>
        <td ><%=j%></td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=strAmount[i]%></td>
        <td ><%=strCurrency%></td>
        <td ><%=strKindAddress[i]%></td>
      </tr>
<%
        }
      }//for
    }else if(strRiskCode.equals("1101")){
%>    
      <tr>
        <td colspan="1">����ס����ϸ��ַ</td>
        <td colspan="4"><%=strAddressName[0]%></td>
      </tr>
      <tr>
        <td colspan="1">��������</td>
        <td colspan="2"><%=strStructure[0]%><br><%=strLoanUsage%></td>
        <td colspan="1">�������</td>
        <td colspan="1"><%=dblBuildArear[0]%></td>
      </tr>   
      <tr>
        <td colspan="1">��������</td>
        <td colspan="2"><%=strLoanBank%></td>
        <td colspan="1">������</td>
        <td colspan="1"><%=strLoanBank%></td>
      </tr>
      <tr>
        <td colspan="1">������������</td>
        <td colspan="4"><%=strWarrantorCode%></td>
      </tr>
      <tr>
        <td colspan="1">���ݹ��ü�</td>
        <td colspan="2"><%=strLoanNo2%></td>
        <td colspan="1">������</td>
        <td colspan="1"><%=dblLoanAmount%></td>
      </tr>
      <tr>
        <td colspan="1">��������</td>
        <td colspan="4">��<%=loanStartDate%>��<%=loanEndDate%></td>
      </tr>
<%   
    }
%>
			<tr><td colspan="5">�ܱ��ս�<%=strCurrency%><%=strSumAmount%></td></tr>
			<tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency%><%=dbDeductible%></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="5">������ʧ���֣�</td></tr>
      <tr>
        <td></td>
        <td>������Ŀ     </td>
        <td>���ս��     </td>
        <td>����         </td>
        <td>���ձ�ĵ�ַ </td>
      </tr>
<%
    if(strRiskCode.equals("0104")){
    	j = 0;
      for(i=0;i<strKindName.length;i++){
    	//������
    	  if(strCalculateFlag[i]!=null && strCalculateFlag[i].substring(2,3).equals("1") && strCalculateFlag[i].substring(4,5).equals("1") && strCalculateFlag[i].substring(5,6).equals("0")){
    	  	j = j + 1;
%>
      <tr>
        <td ><%=j%></td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=dbAmount[i]%></td>
        <td ><%=strCurrency%></td>
        <td ><%=strKindAddress[i]%></td>
      </tr>
<%
        }
      }//for
    }else if(strRiskCode.equals("0105")){
    	j = 0;
      for(i=0;i<strKindName.length;i++){
      	//������(��������)
      	if(strKindCode[i].equals("100") ){
      		j = j + 1;
%>
      <tr>
        <td ><%=j%></td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=dbAmount[i]%></td>
        <td ><%=strCurrency%></td>
        <td ><%=strKindAddress[i]%></td>
      </tr>
<%
        }
      }//for
    }else
%>
      <tr><td colspan="5">�ܱ��ս�<%=strCurrency%><%=strAmount100%></td></tr>
      <tr><td colspan="5">�⳥���ޣ�ë����  <%=strGrossProfitMonths%>���� &nbsp;&nbsp;����  <%=strWageMonths%>����</td></tr>
      <tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency%><%=dbDeductible%></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
<%
  }else if("31".equals(strClassCode)||"32".equals(strClassCode)){
   
%>
      <tr>
        <td style="width:20%"> </td>
        <td style="width:20%">������Ŀ</td>
        <td style="width:20%">��λ����</td>
        <td style="width:20%">����</td>
        <td style="width:20%">���ս��</td>
      </tr>
<%

    for(i=0;i<strKindName.length;i++){
    if(strKindFlag[i]!=null&&strKindFlag[i].length() >= 2)
    {
      if(strKindFlag[i].substring(1,2).equals("1")){
%>
      <tr>
        <td ><%=i+1%></td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=strUnitAmount[i]%></td>
        <td ><%=strQuantity[i]%></td>
        <td ><%=strAmount[i]%></td>

      </tr>
<%
      }
    }}//for    
%>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="5">�ܱ��ս�<%=strCurrency%><%=strSumAmount%></td></tr>
      <tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency%><%=dbDeductible%></td></tr>
<%
  }else if("03".equals(strClassCode)){
	if("0313".equals(strRiskCode)){
%>
	  <tr>
        <td style="width:18%"> ������������</td>
        <td style="width:18%">������Ŀ</td>
        <td style="width:18%">IMEI��</td>
        <td style="width:18%">���ս��</td>
        <td style="width:10%">����</td>
        <td style="width:18%">���ձ�ĵ�ַ</td>
      </tr>
<%
	}else{
%>
      <tr>
        <td style="width:20%"> ������������</td>
<%
    if(strClassCode.equals("02")){
%>
        <td style="width:20%">���ձ��</td>
<%
    }else{
%>
        <td style="width:20%">������Ŀ</td>
<%
    }
%>
        <td style="width:20%">���ս��</td>
        <td style="width:20%">����</td>
        <td style="width:20%">���ձ�ĵ�ַ</td>
      </tr>
<%
	}
    for(i=0;i<strKindName.length;i++){
      if(strKindFlag[i]!=null&&strKindFlag.length >= 2)
      {
      
        if(!strKindFlag[i].equals("")&&strKindFlag[i].substring(1,2).equals("1")){
%>
      <tr>
        <td><%=strFamilyName[i]%></td>
        <td><%=strItemDetailName[i]%></td>
<%
			if("0313".equals(strRiskCode)){
%>
        <td><%=strIMEI[i]%></td>
<%
			}
%>
        <td><%=strAmount[i]%></td>
        <td><%=strCurrency%></td>
        <td><%=strKindAddress[i]%></td>
      </tr>
<%
        }
      }
    }//for 
%>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="5">�ܱ��ս�<%=strCurrency%><%=strSumAmount%></td></tr>
      <tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency%><%=dbDeductible%></td></tr>
      
<%
  }
  else{
   
%>
      <tr>
        <td style="width:20%"> </td>
<%
    if(strClassCode.equals("02")){
%>
        <td style="width:20%">���ձ��</td>
<%
    }else{
%>
        <td style="width:20%">������Ŀ</td>
<%
    }
%>
        <td style="width:20%">���ս��</td>
        <td style="width:20%">����</td>
        <td style="width:20%">���ձ�ĵ�ַ</td>
      </tr>
<%
    for(i=0;i<strKindName.length;i++){
    if(strKindFlag[i]!=null&&strKindFlag.length >= 2)
    {
      
      if(!strKindFlag[i].equals("")&&strKindFlag[i].substring(1,2).equals("1")){
%>
      <tr>
        <td ><%=i+1%></td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=strAmount[i]%></td>
        <td ><%=strCurrency%></td>
        <td ><%=strKindAddress[i]%></td>
      </tr>
<%
      }
    }}//for 
%>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="5">�ܱ��ս�<%=strCurrency%><%=strSumAmount%></td></tr>
      <tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency%><%=dbDeductible%></td></tr>
<%
  }
%>

      <tr><td colspan="2">Ͷ�����ڣ�<%=OperateDate %></td><td colspan="3">¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
      <tr><td colspan="2">ǩ�����ڣ�<%=SignDate %></td><td colspan="3">�������ڣ�<%=InputDate %></td></tr>
      <tr><td colspan="5">�����ڼ䣺�� <%=StartDate %> �� <%=EndDate %></td></tr>
      <tr><td colspan="2">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
      <tr><td colspan="1" valign="top">�ر�Լ����</td><td colspan="4"><%=strEngage%></td></tr>
    </table>
  </body>
</html>
