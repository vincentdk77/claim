<%--
****************************************************************************
* DESC       ：出险后抄单打印页面
* AUTHOR     ：  项目组
* CREATEDATE ： 2005-09-15
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--初始化--%>
<%@include file="CopyNoneFormatPrintHead01Ini.jsp"%>
<html>
  <head></head>
  <body>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr><td colspan="5" align="center" style="font-size:14pt;"><b> 
      国元保险公司
      <!--
      <img src="images/chaodanLogo.gif" > 
      -->
      <%=strRiskName%>保单抄件</b></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="4"/></td></tr>
      <tr><td colspan="5">报案号：<%= strRegistNo %></td></tr>
      <tr><td colspan="5">保险单号：<%= strPolicyNo %></td></tr>
      <tr><td colspan="5">被保险人名称：<%= strPolicyName %></td></tr>
      <tr><td colspan="5">被保险人地址：<%= strPolicyAddress %></td></tr>
<%
	
  int j = 0;
  if(strRiskCode.equals("0104")||strRiskCode.equals("0105")||strRiskCode.equals("1101")){
 
  	if(strRiskCode.equals("0104")){
%>
      <tr><td colspan="5">物质损失部分：</td></tr>
      <tr>
        <td style="width:20%"> </td>
        <td style="width:20%">保险项目</td>
        <td style="width:20%">保险金额</td>
        <td style="width:20%">币种</td>
        <td style="width:20%">保险标的地址</td>
      </tr>
<%
      for(i=0;i<strKindName.length;i++){
    	//主险
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
      <tr><td colspan="5">机器损坏部分：</td></tr>
      <tr>
        <td style="width:20%"> </td>
        <td style="width:20%">机器设备说明</td>
        <td style="width:20%">保险金额</td>
        <td style="width:20%">币种</td>
        <td style="width:20%">地址</td>
      </tr>
<%
      for(i=0;i<strKindName.length;i++){
    	//主险
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
        <td colspan="1">保险住房详细地址</td>
        <td colspan="4"><%=strAddressName[0]%></td>
      </tr>
      <tr>
        <td colspan="1">房屋类型</td>
        <td colspan="2"><%=strStructure[0]%><br><%=strLoanUsage%></td>
        <td colspan="1">建筑面积</td>
        <td colspan="1"><%=dblBuildArear[0]%></td>
      </tr>   
      <tr>
        <td colspan="1">贷款银行</td>
        <td colspan="2"><%=strLoanBank%></td>
        <td colspan="1">受益人</td>
        <td colspan="1"><%=strLoanBank%></td>
      </tr>
      <tr>
        <td colspan="1">贷款审批表编号</td>
        <td colspan="4"><%=strWarrantorCode%></td>
      </tr>
      <tr>
        <td colspan="1">房屋购置价</td>
        <td colspan="2"><%=strLoanNo2%></td>
        <td colspan="1">贷款金额</td>
        <td colspan="1"><%=dblLoanAmount%></td>
      </tr>
      <tr>
        <td colspan="1">贷款期限</td>
        <td colspan="4">自<%=loanStartDate%>至<%=loanEndDate%></td>
      </tr>
<%   
    }
%>
			<tr><td colspan="5">总保险金额：<%=strCurrency%><%=strSumAmount%></td></tr>
			<tr><td colspan="5">每次事故绝对免赔：<%=strCurrency%><%=dbDeductible%></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="5">利润损失部分：</td></tr>
      <tr>
        <td></td>
        <td>保险项目     </td>
        <td>保险金额     </td>
        <td>币种         </td>
        <td>保险标的地址 </td>
      </tr>
<%
    if(strRiskCode.equals("0104")){
    	j = 0;
      for(i=0;i<strKindName.length;i++){
    	//利损险
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
      	//利损险(机器损坏险)
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
      <tr><td colspan="5">总保险金额：<%=strCurrency%><%=strAmount100%></td></tr>
      <tr><td colspan="5">赔偿期限：毛利润  <%=strGrossProfitMonths%>个月 &nbsp;&nbsp;工资  <%=strWageMonths%>个月</td></tr>
      <tr><td colspan="5">每次事故绝对免赔：<%=strCurrency%><%=dbDeductible%></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
<%
  }else if("31".equals(strClassCode)||"32".equals(strClassCode)){
   
%>
      <tr>
        <td style="width:20%"> </td>
        <td style="width:20%">保险项目</td>
        <td style="width:20%">单位保额</td>
        <td style="width:20%">数量</td>
        <td style="width:20%">保险金额</td>
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
      <tr><td colspan="5">总保险金额：<%=strCurrency%><%=strSumAmount%></td></tr>
      <tr><td colspan="5">每次事故绝对免赔：<%=strCurrency%><%=dbDeductible%></td></tr>
<%
  }else if("03".equals(strClassCode)){
	if("0313".equals(strRiskCode)){
%>
	  <tr>
        <td style="width:18%"> 被保险人名称</td>
        <td style="width:18%">保险项目</td>
        <td style="width:18%">IMEI码</td>
        <td style="width:18%">保险金额</td>
        <td style="width:10%">币种</td>
        <td style="width:18%">保险标的地址</td>
      </tr>
<%
	}else{
%>
      <tr>
        <td style="width:20%"> 被保险人名称</td>
<%
    if(strClassCode.equals("02")){
%>
        <td style="width:20%">保险标的</td>
<%
    }else{
%>
        <td style="width:20%">保险项目</td>
<%
    }
%>
        <td style="width:20%">保险金额</td>
        <td style="width:20%">币种</td>
        <td style="width:20%">保险标的地址</td>
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
      <tr><td colspan="5">总保险金额：<%=strCurrency%><%=strSumAmount%></td></tr>
      <tr><td colspan="5">每次事故绝对免赔：<%=strCurrency%><%=dbDeductible%></td></tr>
      
<%
  }
  else{
   
%>
      <tr>
        <td style="width:20%"> </td>
<%
    if(strClassCode.equals("02")){
%>
        <td style="width:20%">保险标的</td>
<%
    }else{
%>
        <td style="width:20%">保险项目</td>
<%
    }
%>
        <td style="width:20%">保险金额</td>
        <td style="width:20%">币种</td>
        <td style="width:20%">保险标的地址</td>
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
      <tr><td colspan="5">总保险金额：<%=strCurrency%><%=strSumAmount%></td></tr>
      <tr><td colspan="5">每次事故绝对免赔：<%=strCurrency%><%=dbDeductible%></td></tr>
<%
  }
%>

      <tr><td colspan="2">投保日期：<%=OperateDate %></td><td colspan="3">录入日期：<%=UnderWriteEndDate %></td></tr>
      <tr><td colspan="2">签单日期：<%=SignDate %></td><td colspan="3">出单日期：<%=InputDate %></td></tr>
      <tr><td colspan="5">保险期间：从 <%=StartDate %> 到 <%=EndDate %></td></tr>
      <tr><td colspan="2">是否涉及再保临分、联保、共保：<%= strCoinsFlag %></td></tr>
      <tr><td colspan="1" valign="top">特别约定：</td><td colspan="4"><%=strEngage%></td></tr>
    </table>
  </body>
</html>
