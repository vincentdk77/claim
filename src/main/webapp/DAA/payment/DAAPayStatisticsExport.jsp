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
<link href="/newclaim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- ҳ����ʽ  --%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	String filename="֧�����ͳ�Ʊ�";
	String name = new String(filename.getBytes("gb2312"),"8859_1"); 
	response.setContentType("application/vnd.ms-excel;charset=GBK");
	response.setHeader("Content-Disposition","attachment;filename=" + name + ".xls");
%>



<html:html locale="true">
<head>
  <title>�ط��б�</title>
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
<!--					<td style="width:3%" align="center">���</td>-->
					<!-- �ɹ��ط� -->
						<td class="w12" align="center">����</td>
						<td class="w12" align="center">֧��¼��ʱ��</td>
						<td class="w12" align="center">֧��ʱ��</td>
						<td class="w5"  align="center">֧��״̬</td>
						<td class="w12" align="center">������</td>
						<td class="w15" align="center">��������</td>
						<td class="w5"  align="center">�������</td>
						<td class="w6"  align="center">��������</td>
						<td class="w6"  align="center">�᰸ʱ��</td>
						<td class="w5"  align="center">���������Ա����</td>
						<td class="w5"  align="center">�����</td>
						<td class="w6"  align="center">��������</td>
						<td class="w6"  align="center">ʵ�����(��������)</td>
						<td class="w15" align="center">�����</td>
						<td class="w12" align="center">֤����</td>
				</tr>
				<c:forEach items="${paymainList}" var="payStatisticsDto" varStatus="count">
					<tr class="listodd">
<!--						<td>${count.index+1}</td>	 ��� -->
							<td class="txt"><span>${payStatisticsDto.comName}&nbsp;</span></td><!-- �б����� -->
							<td class="txt"><span>${payStatisticsDto.inputDate}&nbsp;</span></td>	<!-- ֧��¼��ʱ��-->
							<td>${payStatisticsDto.payDate}</td>	<!-- ֧��ʱ�� -->
							<td>${payStatisticsDto.payStatusName}</td>	<!-- ֧��״̬ -->
							<td class="txt">${payStatisticsDto.registNo}</td>	<!-- ������ -->
							<td>${payStatisticsDto.insuredName}</td>	<!-- �������� -->
							<td>${payStatisticsDto.compensateNo}</td>	<!-- ������� -->
						    <td>${payStatisticsDto.underWriteEnddate}</td>	<!-- ����ʱ�� -->
						    <td>${payStatisticsDto.endCaseDate}</td>	<!-- �᰸ʱ�� -->
							<td>${payStatisticsDto.userName}</td>	<!-- ���㴦���� -->
							<td>${payStatisticsDto.sumPaid}</td>	<!-- ����� -->
							<td>${payStatisticsDto.sumDutyPaid}</td>	<!-- �����������ã� -->
							<td>${payStatisticsDto.payPaid}</td> <!-- ʵ����� -->
							<td>${payStatisticsDto.receiverfullname}</td>	<!-- ����� -->
							<td class="txt">${payStatisticsDto.certifno}</td> <!-- ֤���� -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html:html>