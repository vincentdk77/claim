<%--
****************************************************************************
* DESC       ：出险后抄单打印附加及特约信息页面
* AUTHOR     ： 项目组
* CREATEDATE ： 2005-09-15
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--初始化--%>
<%@include file="CopyNoneFormatPrintSub01Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr><td colspan="4"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="4">附加险：</td></tr>
<%
  if(strRiskCode.equals("0104") || strRiskCode.equals("0105")){
%>
      <tr>
        <td colspan="4">
          <table width="100%" align="center" style="font-family:宋体; font-size:11pt;">
<%
    if(strRiskCode.equals("0104")){
%>
            <tr><td colspan="4">财产损失部分：</td></tr>
<%
    }else if(strRiskCode.equals("0105")){
%>
            <tr><td colspan="4">机器损坏部分：</td></tr>
<%
    }
%>
            <tr>
              <td align="center" width="25%" > 名称 </td>
              <td align="left" width="25%" > 保额/限额  </td>
              <td align="left" width="25%" > 每次赔偿限额 </td>
              <td align="left" width="25%" > 说明 </td>
            </tr>
            <tr><td colspan="4"><hr align="center" width="90%" size="1"/></td></tr>
<%
    for(i=0 ;i<strKindName.length;i++){
    	//附加险

      if(strCalculateFlag!=null && strCalculateFlag[i].substring(2,3).equals("2") && strCalculateFlag[i].substring(4,5).equals("0") && strCalculateFlag[i].substring(5,6).equals("0")){
%>
            <tr>
              <td align="left">&nbsp;&nbsp;<%=strKindName[i]%></td>
              <td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
              <td align="left"><%=dbDeductible[i]%></td>
              <td align="left"></td>
            </tr>
<%
      }
    }//for
%>
      
      <tr>
        <td colspan="4">
          <table width="100%" align="center" style="font-family:宋体; font-size:11pt;">
            <tr><td colspan="4">利润损失部分：</td></tr>
            <tr>
              <td align="center" width="25%" > 名称 </td>
              <td align="left" width="25%" > 保额/限额  </td>
              <td align="left" width="25%" > 每次赔偿限额 </td>
              <td align="left" width="25%" > 说明 </td>
            </tr>
            <tr><td colspan="4"><hr align="center" width="90%" size="1"/></td></tr>
<%
    for(i=0 ;i<strKindName.length;i++){
    	//利损附加险
      if(strCalculateFlag!=null && strCalculateFlag[i].substring(2,3).equals("2") && strCalculateFlag[i].substring(4,5).equals("0") && strCalculateFlag[i].substring(5,6).equals("1")){
%>
            <tr>
              <td align="left">&nbsp;&nbsp;<%=strKindName[i]%></td>
              <td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
              <td align="left"><%=dbDeductible[i]%></td>
              <td align="left"></td>
            </tr>
<%
      }
    }//for
  }else if("03".equals(strClassCode))
  {
%>
      <tr>
        <td colspan="4">
          <table width="90%" align="center" style="font-family:宋体; font-size:11pt;">
            <tr>
              <td align="left" width="25%" > 被保险人名称 </td>
              <td align="left" width="25%" > 保额/限额  </td>
              <td align="left" width="25%" > 每次赔偿限额 </td>
              <td align="left" width="25%" > 说明 </td>
            </tr>
      <tr><td colspan="4"><hr align="left" width="90%" size="1"/></td></tr>
<%
    for(i=0 ;i<strKindName.length;i++){
    if(strItemKindFlag[i]!=null&&strItemKindFlag.length >= 2)
    {
      if(!strItemKindFlag[i].equals("")&&strItemKindFlag[i].substring(1,2).equals("2")){
%>
            <tr>
              <td align="left"><%=strFamilyName[i]%></td>
              <td align="left"><%=strKindName[i]%></td>
              <td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
              <td align="left"><%=dbDeductible[i]%></td>
              <td align="left"></td>
            </tr>
<%
      }
    }}//for
  }
  else{
%>
      <tr>
        <td colspan="4">
          <table width="90%" align="center" style="font-family:宋体; font-size:11pt;">
            <tr>
              <td align="left" width="25%" > 名称 </td>
              <td align="left" width="25%" > 保额/限额  </td>
              <td align="left" width="25%" > 每次赔偿限额 </td>
              <td align="left" width="25%" > 说明 </td>
            </tr>
      <tr><td colspan="4"><hr align="left" width="90%" size="1"/></td></tr>
<%
    for(i=0 ;i<strKindName.length;i++){
    if(strItemKindFlag[i]!=null&&strItemKindFlag.length >= 2)
    {
      if(!strItemKindFlag[i].equals("")&&strItemKindFlag[i].substring(1,2).equals("2")){
%>
            <tr>
              <td align="left"><%=strKindName[i]%></td>
              <td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
              <td align="left"><%=dbDeductible[i]%></td>
              <td align="left"></td>
            </tr>
<%
      }
    }}//for
  }
  if(strRiskCode.equals("0104") || strRiskCode.equals("0105")){
%>
            </table>
<%}%>            
          </table>
        </td>
      </tr>
    </table>
  </body>
</html>