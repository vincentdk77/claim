<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="java.util.*"%>

<%
  HashMap hashMap = (HashMap)request.getAttribute("hashMap");
  String startDate = (String)request.getAttribute("startDate");
  String endDate = (String)request.getAttribute("endDate");
  int lineCount = 24;//每页行数
  int intPageNum = 0;//总页数
  int listingNum = 0;//总记录数
  int intPage = 0;//页数
  int intCount=0;
  Collection collection = new ArrayList();
  if(!hashMap.isEmpty()&&hashMap.size()>0)
  {
    listingNum = hashMap.size();
    intPageNum = listingNum/lineCount;
    if(listingNum%lineCount>0)
    {
      intPageNum = intPageNum + 1;
    }
    
    collection = hashMap.values();
  }
%>

<html>
	<head>
		<title>闵行区农村合作医疗大病住院补偿费用明细表</title>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/commonAcci/regist/js/AcciRegistEdit.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</head>
	<body>
		<form name="fm" method="post">
<%
	  intPage++;
%>
      <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="center" colspan="2" height=30 style="text-align:center; font-family:宋体; font-size:12pt;">
      			<b>闵行区农村合作医疗大病住院补偿费用明细表(第<%=intPage%>页)</b>
      		</td>
      	</tr>
      	<tr>
      		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=startDate%>日至<%=endDate%>日</td>
      		<td align="right">单位：元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      	</tr>
      </table>
      <table  align=center width="90%" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr>
      		<td align=center height="40" rowspan="2" width="2%">序<br>号</td>
      		<td align=center height="40" rowspan="2" width="14%">计算书号</td>
      		<td align=center height="40" rowspan="2" width="10%">地址</td>
      		<td align=center height="40" rowspan="2" width="4%">姓名</td>
      		<td align=center height="40" rowspan="2" width="10%">诊断</td>
      		<td align=center height="40" rowspan="2" width="10%">区合作医疗实际可报费用</td>
      		<td align=center colspan="3">闵行区新型合作医疗补偿标准</td>
      	</tr>
      	<tr>
      		<td align=center width="10%">合医25-90%</td>
      		<td align=center width="10%">安保35%</td>
      		<td align=center width="10%">合计</td>
      	</tr>
<%
    if(listingNum>0)
    {
      Iterator iterator = collection.iterator();
      int i = 0;
      while (iterator.hasNext())
      {
        HospTimeListingDto hospTimeListingDto = (HospTimeListingDto)iterator.next();
        intCount=i;
%>
        <tr>
        	<td align=center height="28"><%=i+1%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getCompensateNo()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getAddress()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getInsuredName()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getContent()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getFee()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getQuFee()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getAnxinFee()%></tr>
        	<td align=center height="28"><%=hospTimeListingDto.getPayFee()%></tr>
        </tr>
<%     
        if ((i+1)%lineCount == 0&&(i+1)!=listingNum)
        {
          intPage++;
%>
      </table>
      <table  align=center width="100%" style="font-family:宋体; font-size:10pt;">
      	<tr>
      		<td align=right>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      	</tr>
      </table>
      
      <br style="page-break-before:always" clear=all>
      
      <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="center" colspan="2" height=30 style="text-align:center; font-family:宋体; font-size:12pt;">
      			<b>闵行区农村合作医疗大病住院补偿费用明细表(第<%=intPage%>页)</b>
      		</td>
      	</tr>
      	<tr>
      		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=startDate%>日至<%=endDate%>日</td>
      		<td align="right">单位：元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      	</tr>
      </table>
      
      <table  align=center width="90%" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr>
      		<td align=center height="40" rowspan="2" width="2%">序<br>号</td>
      		<td align=center height="40" rowspan="2" width="14%">计算书号</td>
      		<td align=center height="40" rowspan="2" width="10%">地址</td>
      		<td align=center height="40" rowspan="2" width="4%">姓名</td>
      		<td align=center height="40" rowspan="2" width="10%">诊断</td>
      		<td align=center height="40" rowspan="2" width="10%">区合作医疗实际可报费用</td>
      		<td align=center height="40" colspan="3">闵行区新型合作医疗补偿标准</td>
      	</tr>
      	<tr>
      		<td align=center width="10%">合医25-90%</td>
      		<td align=center width="10%">安保35%</td>
      		<td align=center width="10%">合计</td>
      	</tr>
<%
        }
      i++;
      }
    }
    if((intCount+1)%lineCount!=0)
    {
      for(int i=(intCount+1)%lineCount;i<lineCount;i++)
      {
%>
        <tr>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
          <td height="28">&nbsp;</td>
        </tr>
<%
      }
    }
    if (intCount!=0)
    {
%>
      <tr>
      	<table  align=center width="100%" style="font-family:宋体; font-size:10pt;">
      	  <tr>
      		  <td align=right>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      	  </tr>
        </table>
      </tr>
<%
    }
%>
      </table>
		</form>
	</body>
	<jsp:include page="/common/print/PrintButton.jsp" />
</html>
