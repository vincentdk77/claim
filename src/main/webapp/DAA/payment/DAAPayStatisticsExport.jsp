<%--
****************************************************************************
* DESC       ：导出回访查询清单 派工回访清单 结案回访清单 投诉回访清单
* AUTHOR     ：zhangzhiqiang
* CREATEDATE ：2012-09-13
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%--
<!-- 页签控制 -->
<link href="/newclaim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- 页面样式  --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	String filename="支付情况统计表";
	String name = new String(filename.getBytes("gb2312"),"8859_1"); 
	response.setContentType("application/vnd.ms-excel;charset=GBK");
	response.setHeader("Content-Disposition","attachment;filename=" + name + ".xls");
%>



<html:html locale="true">
<head>
  <title>回访列表</title>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <script language="Javascript" src="/newclaim/js/jquery-1.4.2.min.js" ></script> 
<style type="text/css"> 


	.th{
	
	    background:#ffa500;
	}
	.txt{
		padding-top:1px; 
		padding-right:1px; 
		padding-left:1px; 
		mso-ignore:padding; 
		color:black; 
		font-size:11.0pt; 
		font-weight:400; 
		font-style:normal; 
		text-decoration:none; 
		font-family:宋体; 
		mso-generic-font-family:auto; 
		mso-font-charset:134; 
		mso-number-format:"\@"; //关键是这里 
		text-align:general; 
		vertical-align:middle; 
		mso-background-source:auto; 
		mso-pattern:auto; 
		white-space:nowrap;
	}
	.number{
	
	}

	</style> 
</head>

<body>
		<table style="width:100%;" id="tb_table" class="listcommon" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" >
			<div id="my" style="display: none"></div>
			<tbody id="top9" style="">
				<tr class="listdragtitle">
<!--					<td style="width:3%" align="center">序号</td>-->
					<!-- 派工回访 -->
						<td class="w12" align="center">机构</td>
						<td class="w12" align="center">支付录入时间</td>
						<td class="w12" align="center">支付时间</td>
						<td class="w5"  align="center">支付状态</td>
						<td class="w12" align="center">报案号</td>
						<td class="w15" align="center">被保险人</td>
						<td class="w5"  align="center">计算书号</td>
						<td class="w6"  align="center">核赔日期</td>
						<td class="w6"  align="center">结案时间</td>
						<td class="w5"  align="center">理算操作人员代码</td>
						<td class="w5"  align="center">总赔款</td>
						<td class="w6"  align="center">赔款不含费用</td>
						<td class="w6"  align="center">实付金额(不含费用)</td>
						<td class="w15" align="center">领款人</td>
						<td class="w12" align="center">证件号</td>
				</tr>
				<c:forEach items="${paymainList}" var="payStatisticsDto" varStatus="count">
					<tr class="listodd">
<!--						<td>${count.index+1}</td>	 序号 -->
							<td class="txt"><span>${payStatisticsDto.comName}&nbsp;</span></td><!-- 承保机构 -->
							<td class="txt"><span>${payStatisticsDto.inputDate}&nbsp;</span></td>	<!-- 支付录入时间-->
							<td>${payStatisticsDto.payDate}</td>	<!-- 支付时间 -->
							<td>${payStatisticsDto.payStatusName}</td>	<!-- 支付状态 -->
							<td class="txt">${payStatisticsDto.registNo}</td>	<!-- 报案号 -->
							<td>${payStatisticsDto.insuredName}</td>	<!-- 被保险人 -->
							<td>${payStatisticsDto.compensateNo}</td>	<!-- 理算书号 -->
						    <td>${payStatisticsDto.underWriteEnddate}</td>	<!-- 核赔时间 -->
						    <td>${payStatisticsDto.endCaseDate}</td>	<!-- 结案时间 -->
							<td>${payStatisticsDto.userName}</td>	<!-- 理算处理人 -->
							<td>${payStatisticsDto.sumPaid}</td>	<!-- 总赔款 -->
							<td>${payStatisticsDto.sumDutyPaid}</td>	<!-- 赔款金额（不含费用） -->
							<td>${payStatisticsDto.payPaid}</td> <!-- 实付金额 -->
							<td>${payStatisticsDto.receiverfullname}</td>	<!-- 领款人 -->
							<td class="txt">${payStatisticsDto.certifno}</td> <!-- 证件号 -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html:html>