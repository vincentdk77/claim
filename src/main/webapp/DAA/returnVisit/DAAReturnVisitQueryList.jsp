<%--
****************************************************************************
* DESC       ���طò�ѯ �б�ҳ��
* AUTHOR     ��chengyupeng
* CREATEDATE ��2011-12-28
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto"%>
<%@page import="com.sinosoft.reins.utility.ui.control.action.UICodeAction"%>
<%--
<!-- ҳǩ���� -->
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- ҳ����ʽ  --%>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/claim/css/tableType.css" rel="stylesheet" type="text/css">
<html:html locale="true">
<head>
	<app:css />

	<title>�طò�ѯ���ҳ</title>
	<script src="/claim/common/js/showpage.js"></script>
	<script language="Javascript" src="/claim/common/js/jquery-1.4.2.min.js" ></script> 
	<html:base />
<script type="text/javascript">
	function detailQuery(registNo,nodeType,state) {
		var strUrl = '/claim/returnDetailEdit.do?registNo='+registNo+'&nodeType='+nodeType+'&state='+state+'&flag=BUTTON';
		window.open(strUrl,'_blank','width=696,height=464,menubar=no,toolbar=no,scrollbars=yes,resizable=yes,status=no��');
	    
	}
	
	$(document).ready(function(){
    $("#showhide").click(function(){
    	$("td:eq(10)",$("tr")).toggle();
		$("td:eq(11)",$("tr")).toggle();
		$("td:eq(12)",$("tr")).toggle();
		$("td:eq(13)",$("tr")).toggle();
		
    })
  })
  </script>
</head>

<body>
	<form name="fm" action="" method="post">
		<input type="hidden" id="nodeType" name="nodeType" value="${nodeType}">
		<% 
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = (PrplreturnvisitswflogDto)request.getAttribute("prplreturnvisitswflogDto"); 
		  int curPage = prplreturnvisitswflogDto.getTurnPageDto().getPageNo(); 
		  UICodeAction uiCodeAction = new UICodeAction();
		  int total = prplreturnvisitswflogDto.getTurnPageDto().getTotalCount();
		%> 
		<table style="width:99%;" id="tb_table" class="listcommon" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" >
			<div id="my" style="display: none"></div>
			<tbody id="top9" style="">
				<tr class="listdragtitle">
					<td style="width:3%" align="center">���</td>
					<!-- �ɹ��ط� -->
					<c:if test="${nodeType eq 'sched'}">
						<td class="w12" align="center">��������</td>
						<td class="w12" align="center">��������</td>
						<td class="w5"  align="center">�ѻطô���</td>
						<td class="w9" align="center">��������</td>
						<td class="w6"  align="center">�����绰</td>
						<td class="w6"  align="center">�������˵绰</td>
						<!-- <td class="w5"  align="center" >���ƺ���</td>  -->
						<c:if test="${editType eq 'ADD'}">
							<td class="w9"  align="center">����ʱ��</td>
							<td class="w5"  align="center">�ӱ�����</td>
							<td class="w5"  align="center">�ط�����</td>
						</c:if>
						<c:if test="${editType eq 'SHOW'}">
							<td class="w9"  align="center">�б�����</td>
							<td class="w5"  align="center">�ط�ʱ��</td>
							<td class="w5"  align="center">�ط���Ա</td>
						</c:if>
						<td class="w6"  align="center">�طñ�־</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w5"  align="center">�������</td>
							<td class="w7"  align="center">��������</td>
						</c:if>	
							<td class="w7"  align="center">&nbsp;</td>
					</c:if>
					<!-- �᰸�ط� -->
					<c:if test="${nodeType eq 'endca'}">
						<td style="width:12%"><span class="resizeDivClass"><a>&nbsp;</a></span>��������</td>
						<td><span class="resizeDivClass"><a>&nbsp;</a></span>��������</td>
						<td>�⸶���(��������)</td>
						<td>���⸶���</td>
						<td>�ѻطô���</td>
						<td>��������</td>
						<td>�����绰</td>
						<td>�������˵绰</td>
<!-- 						<td>���ƺ���</td> -->
						<td Style="display:none">�᰸��</td>
						<td Style="display:none">�ӱ�����</td>
						<td Style="display:none">����ʱ��</td>
						<td Style="display:none">�ط�����</td>
						<c:if test="${editType eq 'ADD'}">
							<td style="width:4%">����ʱ��</td>
							<td>�᰸ʱ��</td>
							<td>֧��ʱ��</td>
						</c:if>
						<c:if test="${editType eq 'SHOW'}">
							<td>�б�����</td>
							<td>�ط�ʱ��</td>
							<td>�ط���Ա</td>
						</c:if>
						<td>�طñ�־</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w5"  align="center">�������</td>
							<td class="w8"  align="center">��������</td>
						</c:if>	
						<td align="center"><input type="button" class='button_four' id="showhide" value="��ʾ/����"></td>
					</c:if>
					<!-- Ͷ�߻ط� -->
					<c:if test="${nodeType eq 'compl'}">
						<td class="w10"   align="center">Ͷ�߱��</td>
						<td class="title" align="center">Ͷ����</td>
						<td class="w10"   align="center">��Ͷ�߻���</td>
						<td class="w10"   align="center">Ͷ��ʱ��</td>
						<td class="w6"    align="center">�طñ�־</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w5"  align="center">�������</td>
							<td class="w8"  align="center">��������</td>
						</c:if>	
					</c:if>
				</tr>
				<c:forEach items="${prplreturnvisitswflogDtoList}" var="prplreturnvisitswflog" varStatus="count">
					<tr class="listodd">
						<td>${count.index+1}</td>	<!-- ��� -->
						<c:if test="${nodeType eq 'sched'}">
							<td><!-- ������ -->
								<c:if test="${editType eq 'ADD'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
								<c:if test="${editType eq 'SHOW'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
							</td>
							<td>${prplreturnvisitswflog.policyno}</td>	<!-- ������ -->
							<td>${prplreturnvisitswflog.serialno}</td>	<!-- �طô��� -->
							<td>${prplreturnvisitswflog.insuredname}</td>	<!-- �������� -->
							<td>${prplreturnvisitswflog.tel}</td>	<!-- �������� -->
							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	<!-- �������˵绰 -->
<!-- 							<td>${prplreturnvisitswflog.licenseno}</td>	���ƺ��� -->
							<c:if test="${editType eq 'ADD'}">
								<td>${prplreturnvisitswflog.flowintotime}</td>	<!-- ����ʱ�� -->
								<td>${prplreturnvisitswflog.receivername}</td>	<!-- �ӱ����� -->
								<td>�ɹ��ط�</td>	<!-- �ط����� -->
							</c:if>
							<c:if test="${editType eq 'SHOW'}">
								<td>${prplreturnvisitswflog.comcodename}</td>	<!-- �б����� -->
								<td>${prplreturnvisitswflog.enteringtime}</td>	<!-- �ط�ʱ�� -->
								<td>${prplreturnvisitswflog.enteringname}</td>	<!-- �ط���Ա -->
							</c:if>
							<td>${prplreturnvisitswflog.nodeMark}</td>	<!-- �طñ�־ -->
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td align="left">${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
							<td class="w4" >
								<input type="button" class="bobu" value="��ϸ" 
								onclick="detailQuery('${prplreturnvisitswflog.registno}','${nodeType}','${prplreturnvisitswflog.state}')" >
							</td>
						</c:if>
						<!-- ---------------------------------------------------------------------- -->
						<c:if test="${nodeType eq 'endca'}">	
							<td><!-- ������ -->
								<c:if test="${editType eq 'ADD'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
								<c:if test="${editType eq 'SHOW'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
							</td>
							<td>${prplreturnvisitswflog.policyno}</td>	<!-- ������ -->
							<td align="right">${prplreturnvisitswflog.sumpaid}</td>	<!-- �⸶���������ã� -->
							<td align="right">${prplreturnvisitswflog.sumprepaid}</td>	<!-- ֧����� -->
							<td>${prplreturnvisitswflog.serialno}</td>	<!-- �طô��� -->
							<td align="left"><nobr>${prplreturnvisitswflog.insuredname}</nobr></td>	<!-- �������� -->
							<td>${prplreturnvisitswflog.tel}</td>	<!-- �������� -->
							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	<!-- �������˵绰 -->
							<!-- <td><nobr>${prplreturnvisitswflog.licenseno}</nobr></td>	���ƺ��� -->
							
							<td Style="display:none">${prplreturnvisitswflog.endcaseno}</td>	<!-- �᰸�� -->
							<td Style="display:none">${prplreturnvisitswflog.receivername}</td>	<!-- �ӱ����� -->
							<td Style="display:none"><nobr>${prplreturnvisitswflog.flowintotime}</nobr></td>	<!-- ����ʱ�� -->
							<td Style="display:none">�᰸�ط�</td>	<!-- �ط����� -->
							<c:if test="${editType eq 'ADD'}">
								<td>${prplreturnvisitswflog.stReportDate }<br>${prplreturnvisitswflog.stReportHour }</td>	<!-- ����ʱ�� -->
								<td>${prplreturnvisitswflog.endCaseDate }</td>	<!-- �᰸ʱ�� -->
								<td>${prplreturnvisitswflog.payRefDate }</td>	<!-- ֧��ʱ�� -->
							</c:if>
							<c:if test="${editType eq 'SHOW'}">
								<td>${prplreturnvisitswflog.comcodename}</td>	<!-- �б����� -->
								<td>${prplreturnvisitswflog.enteringtime}</td>	<!-- �ط�ʱ�� -->
								<td>${prplreturnvisitswflog.enteringname}</td>	<!-- �ط���Ա -->
							</c:if>
							<td>${prplreturnvisitswflog.nodeMark}</td>	<!-- �طñ�־ -->
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td align="left">${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
							<td>
								<input type="button" class="bobu" value="��ϸ" 
								onclick="detailQuery('${prplreturnvisitswflog.registno}','${nodeType}','${prplreturnvisitswflog.state}')" >
							</td>
						</c:if>
						<!-- ---------------------------------------------------------------------- -->
							<!-- 
							<c:if test="${editType eq 'ADD'}">
								<td>${prplreturnvisitswflog.flowintotime}</td>
								<td>${prplreturnvisitswflog.receivername}</td>
								<td><c:if test="${prplreturnvisitswflog.nodetype eq 'sched'}">�ɹ��ط�</c:if>
									<c:if test="${prplreturnvisitswflog.nodetype eq 'endca'}">�᰸�ط�</c:if>
								</td>
							</c:if>
							<c:if test="${editType eq 'SHOW'}">
								<td>${prplreturnvisitswflog.comcodename}</td>
								<td>${prplreturnvisitswflog.enteringtime}</td>
								<td>${prplreturnvisitswflog.enteringname}</td>
							</c:if>
							 -->
						<c:if test="${nodeType eq 'compl'}">
							<td>
								<a href="/claim/complaintEdit.do?editType=${editType}&nodeTypes=${nodeType}&complaintno=${prplreturnvisitswflog.businessno}" target="_parent">${prplreturnvisitswflog.businessno}</a>
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
		<br>
		<c:if test="${editType eq 'SHOW'}">
		    <table class="common" align="center">
		      <tr>
		        <td class="button" type="button" >
		          <input  name="buttonUnderwrite" class="button"  type="button"  value="����Excel" onclick="exp();">
		        </td>
		      </tr>
		    </table>	
		</c:if>
		<table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prplreturnvisitswflogDto" property="turnPageDto"/>
                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
		
		<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
		<input type="hidden" name="nodeMark" value="${nodeMark}">
	</form>
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
<script>
	 //add by zhangzhiqiang 20120911
	 function exp(){
	      var total=<%=total%>;
	      //alert(total);   
	      if(total>2000){
	       alert("��ǰ�������2000�����뾫ȷ��ѯ�󵼳�");
	       return false;
	      }else{
	         var editType=document.getElementById("editType");
	         editType.value="EXP";
		     fm.action="/claim/returnVisitQueryEdit.do?excel=1";
	  		 fm.submit();	      
	     }              
	    }
	
	//ifrom ����Ӧ�߶� showlist ifrom ���� begin
	<%--parent.document.all("showlist").style.width=document.body.scrollWidth; 
	parent.document.all("showlist").style.height=document.body.scrollHeight; 

	var iframe = parent.document.getElementById("showlist");
	var bHeight = iframe.contentWindow.document.body.scrollHeight;
	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	//ifrom ����Ӧ�߶� showlist ifrom ���� end--%>
</script>
</html:html>