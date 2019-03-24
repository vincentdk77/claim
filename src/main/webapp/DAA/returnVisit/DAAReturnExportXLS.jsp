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
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- 页面样式  --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 

	String excel = (String)request.getAttribute("excel");
	String nodeType = (String)request.getAttribute("nodeType");
	String filename="";
		 if("sched".equals(nodeType)){
		   filename="派工回访清单";
		 }else if("endca".equals(nodeType)){
		   filename="结案回访清单";
		 }else if("compl".equals(nodeType)){
		   filename="投诉回访清单";
		 }
	
	String name = new String(filename.getBytes("gb2312"),"8859_1"); 
	if(excel.equals("1"))
	{
		 response.setContentType("application/vnd.ms-excel;charset=GBK");
		 response.setHeader("Content-Disposition","attachment;filename=" + name + ".xls");
	}
	
%>



<html:html locale="true">
<head>
  <title>回访列表</title>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <script language="Javascript" src="/claim/js/jquery-1.4.2.min.js" ></script> 
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
					<td style="width:3%" align="center">序号</td>
					<!-- 派工回访 -->
					<c:if test="${nodeType eq 'sched'}">
						<td class="w12" align="center">报案号码</td>
						<td class="w12" align="center">保单号码</td>
						<td class="w5"  align="center">已回访次数</td>
						<td class="w15" align="center">被保险人</td>
						<td class="w6"  align="center">报案电话</td>
						<td class="w6"  align="center">被保险人电话</td>
						<td class="w5"  align="center">车牌号码</td>
						
						<td class="w9"  align="center">承保机构</td>
						<td class="w5"  align="center">回访时间</td>
						<td class="w5"  align="center">回访人员</td>
						
						<td class="w6"  align="center">回访标志</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w6"  align="center">满意与否</td>
							<td class="w6"  align="center">存在问题</td>
						</c:if>	
					</c:if>
					<!-- 结案回访 -->
					<c:if test="${nodeType eq 'endca'}">
						<td>回访日期</td>
						<td>报案号</td>
						<td>赔付金额</td>
						<td>已付金额</td>
						<td>被保险人</td>
						<td>电话号码</td>
						<td>车牌号码</td>
						<td>承保机构</td>
						<td>报案时间</td>
						<td>结案时间</td>
						<td>支付时间</td>
						<td>是否满意</td>
						<td>录音流水号</td>
						<td>存在问题</td>
						<td>回访意见</td>
					</c:if>
					<!-- 投诉回访 -->
					<c:if test="${nodeType eq 'compl'}">
						<td>投诉编号</td>
						<td>投诉人</td>
						<td>被投诉机构</td>
						<td>投诉时间</td>
						<td>回访标志</td>
						<c:if test="${nodeMark eq '4'}">
							<td >满意与否</td>
							<td>存在问题</td>
						</c:if>	
					</c:if>
				</tr>
				<c:forEach items="${prplreturnvisitswflogDtoList}" var="prplreturnvisitswflog" varStatus="count">
					<tr class="listodd">
						<td>${count.index+1}</td>	<!-- 序号 -->
						<c:if test="${nodeType eq 'sched'}">
							<td class="txt"><span>${prplreturnvisitswflog.registno}&nbsp;</span></td><!-- 报案号 -->
							<td class="txt"><span>${prplreturnvisitswflog.policyno}&nbsp;</span></td>	<!-- 保单号 -->
							<td>${prplreturnvisitswflog.serialno}</td>	<!-- 回访次数 -->
							<td>${prplreturnvisitswflog.insuredname}</td>	<!-- 被保险人 -->
							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	<!-- 报案电话 -->
							<td>${prplreturnvisitswflog.tel}</td>	<!-- 被保险人电话 -->
							<td>${prplreturnvisitswflog.licenseno}</td>	<!-- 车牌号码 -->
						    <td>${prplreturnvisitswflog.comcodename}</td>	<!-- 承保机构 -->
							<td>${prplreturnvisitswflog.enteringtime}</td>	<!-- 回访时间 -->
							<td>${prplreturnvisitswflog.enteringname}</td>	<!-- 回访人员 -->
							<td>${prplreturnvisitswflog.nodeMark}</td>	<!-- 回访标志 -->
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td>${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
						</c:if>
						<c:if test="${nodeType eq 'endca'}">
							<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.enteringtime}</td>	<!-- 回访日期 -->	
							<td class="txt" style="mso-number-format:'\@"><span>${prplreturnvisitswflog.registno}&nbsp;</span></td>	<!-- 报案号 -->
<!--							<td class="txt"><span>${prplreturnvisitswflog.policyno}&nbsp;</span></td>	 保单号 -->
							<td align="right" style="mso-number-format:'0\.00';">${prplreturnvisitswflog.sumpaid}</td>	<!-- 赔付金额（不含费用） -->
							<td align="right" style="mso-number-format:'0\.00';">${prplreturnvisitswflog.sumprepaid}</td>	<!-- 支付金额 -->
							<td align="left"><nobr>${prplreturnvisitswflog.insuredname}</nobr></td>	<!-- 被保险人 -->
							<td class="txt">${prplreturnvisitswflog.exltel}</td>	<!-- 电话号码 -->
<!--							<td>${prplreturnvisitswflog.serialno}</td>	 回访次数 -->
<!--							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	 报案电话 -->
							<td><nobr>${prplreturnvisitswflog.licenseno}</nobr></td>	<!-- 车牌号码 -->
<!--							<td class="txt"><span>${prplreturnvisitswflog.endcaseno}&nbsp;</span></td>	 结案号 -->
<!--							<td>${prplreturnvisitswflog.receivername}</td>	 接报案人 -->
<!--							<td>${prplreturnvisitswflog.flowintotime}</td>	 流入时间 -->
<!--							<td>结案回访</td>	 回访类型 -->
							<td>${prplreturnvisitswflog.comcodename}</td>	<!-- 承保机构 -->
<!--							<td>${prplreturnvisitswflog.enteringname}</td>	 回访人员 -->
<!--							<td>${prplreturnvisitswflog.nodeMark}</td>	 回访标志 -->
								<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.stReportDate }</td>	<!-- 报案时间 -->
								<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.endCaseDate }</td>	<!-- 结案时间 -->
								<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.payRefDate }</td>	<!-- 支付时间 -->
<!--								<td>${prplreturnvisitswflog.serviceSelect}</td>-->
								<td>${prplreturnvisitswflog.serviceName}</td>	<!-- 是否满意 -->
								<td  style="mso-number-format:'\@">${prplreturnvisitswflog.recorderNo}</td>	<!-- 录音流水号 -->
								<td  style="mso-number-format:'\@">${prplreturnvisitswflog.existIssue}</td>	<!-- 存在问题 -->
								<td  style="mso-number-format:'\@">${prplreturnvisitswflog.visitOpinion}</td>	<!-- 回访意见 -->
						</c:if>
						<c:if test="${nodeType eq 'compl'}">
							<td class="txt">
								<span>${prplreturnvisitswflog.businessno}&nbsp;</span>
							</td>
							<td>${prplreturnvisitswflog.bycomplaintcode}</td>
							<td>${prplreturnvisitswflog.bycomplaintcomcodeName}</td>
							<td>${prplreturnvisitswflog.complaintdate}</td>
							<td >${prplreturnvisitswflog.nodeMark}</td>
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td>${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html:html>