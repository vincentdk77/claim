<%--
****************************************************************************
* DESC       �������طò�ѯ�嵥 �ɹ��ط��嵥 �᰸�ط��嵥 Ͷ�߻ط��嵥
* AUTHOR     ��zhangzhiqiang
* CREATEDATE ��2012-09-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%--
<!-- ҳǩ���� -->
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- ҳ����ʽ  --%>
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
		   filename="�ɹ��ط��嵥";
		 }else if("endca".equals(nodeType)){
		   filename="�᰸�ط��嵥";
		 }else if("compl".equals(nodeType)){
		   filename="Ͷ�߻ط��嵥";
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
  <title>�ط��б�</title>
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
		font-family:����; 
		mso-generic-font-family:auto; 
		mso-font-charset:134; 
		mso-number-format:"\@"; //�ؼ������� 
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
					<td style="width:3%" align="center">���</td>
					<!-- �ɹ��ط� -->
					<c:if test="${nodeType eq 'sched'}">
						<td class="w12" align="center">��������</td>
						<td class="w12" align="center">��������</td>
						<td class="w5"  align="center">�ѻطô���</td>
						<td class="w15" align="center">��������</td>
						<td class="w6"  align="center">�����绰</td>
						<td class="w6"  align="center">�������˵绰</td>
						<td class="w5"  align="center">���ƺ���</td>
						
						<td class="w9"  align="center">�б�����</td>
						<td class="w5"  align="center">�ط�ʱ��</td>
						<td class="w5"  align="center">�ط���Ա</td>
						
						<td class="w6"  align="center">�طñ�־</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w6"  align="center">�������</td>
							<td class="w6"  align="center">��������</td>
						</c:if>	
					</c:if>
					<!-- �᰸�ط� -->
					<c:if test="${nodeType eq 'endca'}">
						<td>�ط�����</td>
						<td>������</td>
						<td>�⸶���</td>
						<td>�Ѹ����</td>
						<td>��������</td>
						<td>�绰����</td>
						<td>���ƺ���</td>
						<td>�б�����</td>
						<td>����ʱ��</td>
						<td>�᰸ʱ��</td>
						<td>֧��ʱ��</td>
						<td>�Ƿ�����</td>
						<td>¼����ˮ��</td>
						<td>��������</td>
						<td>�ط����</td>
					</c:if>
					<!-- Ͷ�߻ط� -->
					<c:if test="${nodeType eq 'compl'}">
						<td>Ͷ�߱��</td>
						<td>Ͷ����</td>
						<td>��Ͷ�߻���</td>
						<td>Ͷ��ʱ��</td>
						<td>�طñ�־</td>
						<c:if test="${nodeMark eq '4'}">
							<td >�������</td>
							<td>��������</td>
						</c:if>	
					</c:if>
				</tr>
				<c:forEach items="${prplreturnvisitswflogDtoList}" var="prplreturnvisitswflog" varStatus="count">
					<tr class="listodd">
						<td>${count.index+1}</td>	<!-- ��� -->
						<c:if test="${nodeType eq 'sched'}">
							<td class="txt"><span>${prplreturnvisitswflog.registno}&nbsp;</span></td><!-- ������ -->
							<td class="txt"><span>${prplreturnvisitswflog.policyno}&nbsp;</span></td>	<!-- ������ -->
							<td>${prplreturnvisitswflog.serialno}</td>	<!-- �طô��� -->
							<td>${prplreturnvisitswflog.insuredname}</td>	<!-- �������� -->
							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	<!-- �����绰 -->
							<td>${prplreturnvisitswflog.tel}</td>	<!-- �������˵绰 -->
							<td>${prplreturnvisitswflog.licenseno}</td>	<!-- ���ƺ��� -->
						    <td>${prplreturnvisitswflog.comcodename}</td>	<!-- �б����� -->
							<td>${prplreturnvisitswflog.enteringtime}</td>	<!-- �ط�ʱ�� -->
							<td>${prplreturnvisitswflog.enteringname}</td>	<!-- �ط���Ա -->
							<td>${prplreturnvisitswflog.nodeMark}</td>	<!-- �طñ�־ -->
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td>${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
						</c:if>
						<c:if test="${nodeType eq 'endca'}">
							<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.enteringtime}</td>	<!-- �ط����� -->	
							<td class="txt" style="mso-number-format:'\@"><span>${prplreturnvisitswflog.registno}&nbsp;</span></td>	<!-- ������ -->
<!--							<td class="txt"><span>${prplreturnvisitswflog.policyno}&nbsp;</span></td>	 ������ -->
							<td align="right" style="mso-number-format:'0\.00';">${prplreturnvisitswflog.sumpaid}</td>	<!-- �⸶���������ã� -->
							<td align="right" style="mso-number-format:'0\.00';">${prplreturnvisitswflog.sumprepaid}</td>	<!-- ֧����� -->
							<td align="left"><nobr>${prplreturnvisitswflog.insuredname}</nobr></td>	<!-- �������� -->
							<td class="txt">${prplreturnvisitswflog.exltel}</td>	<!-- �绰���� -->
<!--							<td>${prplreturnvisitswflog.serialno}</td>	 �طô��� -->
<!--							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	 �����绰 -->
							<td><nobr>${prplreturnvisitswflog.licenseno}</nobr></td>	<!-- ���ƺ��� -->
<!--							<td class="txt"><span>${prplreturnvisitswflog.endcaseno}&nbsp;</span></td>	 �᰸�� -->
<!--							<td>${prplreturnvisitswflog.receivername}</td>	 �ӱ����� -->
<!--							<td>${prplreturnvisitswflog.flowintotime}</td>	 ����ʱ�� -->
<!--							<td>�᰸�ط�</td>	 �ط����� -->
							<td>${prplreturnvisitswflog.comcodename}</td>	<!-- �б����� -->
<!--							<td>${prplreturnvisitswflog.enteringname}</td>	 �ط���Ա -->
<!--							<td>${prplreturnvisitswflog.nodeMark}</td>	 �طñ�־ -->
								<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.stReportDate }</td>	<!-- ����ʱ�� -->
								<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.endCaseDate }</td>	<!-- �᰸ʱ�� -->
								<td style="mso-number-format:'yyyy-mm-dd">${prplreturnvisitswflog.payRefDate }</td>	<!-- ֧��ʱ�� -->
<!--								<td>${prplreturnvisitswflog.serviceSelect}</td>-->
								<td>${prplreturnvisitswflog.serviceName}</td>	<!-- �Ƿ����� -->
								<td  style="mso-number-format:'\@">${prplreturnvisitswflog.recorderNo}</td>	<!-- ¼����ˮ�� -->
								<td  style="mso-number-format:'\@">${prplreturnvisitswflog.existIssue}</td>	<!-- �������� -->
								<td  style="mso-number-format:'\@">${prplreturnvisitswflog.visitOpinion}</td>	<!-- �ط���� -->
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