<%--
****************************************************************************
* DESC       ：回访查询 列表页面
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-12-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto"%>
<%@page import="com.sinosoft.reins.utility.ui.control.action.UICodeAction"%>
<%--
<!-- 页签控制 -->
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- 页面样式  --%>
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

	<title>回访查询结果页</title>
	<script src="/claim/common/js/showpage.js"></script>
	<script language="Javascript" src="/claim/common/js/jquery-1.4.2.min.js" ></script> 
	<html:base />
<script type="text/javascript">
	function detailQuery(registNo,nodeType,state) {
		var strUrl = '/claim/returnDetailEdit.do?registNo='+registNo+'&nodeType='+nodeType+'&state='+state+'&flag=BUTTON';
		window.open(strUrl,'_blank','width=696,height=464,menubar=no,toolbar=no,scrollbars=yes,resizable=yes,status=no，');
	    
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
					<td style="width:3%" align="center">序号</td>
					<!-- 派工回访 -->
					<c:if test="${nodeType eq 'sched'}">
						<td class="w12" align="center">报案号码</td>
						<td class="w12" align="center">保单号码</td>
						<td class="w5"  align="center">已回访次数</td>
						<td class="w9" align="center">被保险人</td>
						<td class="w6"  align="center">报案电话</td>
						<td class="w6"  align="center">被保险人电话</td>
						<!-- <td class="w5"  align="center" >车牌号码</td>  -->
						<c:if test="${editType eq 'ADD'}">
							<td class="w9"  align="center">流入时间</td>
							<td class="w5"  align="center">接报案人</td>
							<td class="w5"  align="center">回访类型</td>
						</c:if>
						<c:if test="${editType eq 'SHOW'}">
							<td class="w9"  align="center">承保机构</td>
							<td class="w5"  align="center">回访时间</td>
							<td class="w5"  align="center">回访人员</td>
						</c:if>
						<td class="w6"  align="center">回访标志</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w5"  align="center">满意与否</td>
							<td class="w7"  align="center">存在问题</td>
						</c:if>	
							<td class="w7"  align="center">&nbsp;</td>
					</c:if>
					<!-- 结案回访 -->
					<c:if test="${nodeType eq 'endca'}">
						<td style="width:12%"><span class="resizeDivClass"><a>&nbsp;</a></span>报案号码</td>
						<td><span class="resizeDivClass"><a>&nbsp;</a></span>保单号码</td>
						<td>赔付金额(不含费用)</td>
						<td>已赔付金额</td>
						<td>已回访次数</td>
						<td>被保险人</td>
						<td>报案电话</td>
						<td>被保险人电话</td>
<!-- 						<td>车牌号码</td> -->
						<td Style="display:none">结案号</td>
						<td Style="display:none">接报案人</td>
						<td Style="display:none">流入时间</td>
						<td Style="display:none">回访类型</td>
						<c:if test="${editType eq 'ADD'}">
							<td style="width:4%">报案时间</td>
							<td>结案时间</td>
							<td>支付时间</td>
						</c:if>
						<c:if test="${editType eq 'SHOW'}">
							<td>承保机构</td>
							<td>回访时间</td>
							<td>回访人员</td>
						</c:if>
						<td>回访标志</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w5"  align="center">满意与否</td>
							<td class="w8"  align="center">存在问题</td>
						</c:if>	
						<td align="center"><input type="button" class='button_four' id="showhide" value="显示/隐藏"></td>
					</c:if>
					<!-- 投诉回访 -->
					<c:if test="${nodeType eq 'compl'}">
						<td class="w10"   align="center">投诉编号</td>
						<td class="title" align="center">投诉人</td>
						<td class="w10"   align="center">被投诉机构</td>
						<td class="w10"   align="center">投诉时间</td>
						<td class="w6"    align="center">回访标志</td>
						<c:if test="${nodeMark eq '4'}">
							<td class="w5"  align="center">满意与否</td>
							<td class="w8"  align="center">存在问题</td>
						</c:if>	
					</c:if>
				</tr>
				<c:forEach items="${prplreturnvisitswflogDtoList}" var="prplreturnvisitswflog" varStatus="count">
					<tr class="listodd">
						<td>${count.index+1}</td>	<!-- 序号 -->
						<c:if test="${nodeType eq 'sched'}">
							<td><!-- 报案号 -->
								<c:if test="${editType eq 'ADD'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
								<c:if test="${editType eq 'SHOW'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
							</td>
							<td>${prplreturnvisitswflog.policyno}</td>	<!-- 保单号 -->
							<td>${prplreturnvisitswflog.serialno}</td>	<!-- 回访次数 -->
							<td>${prplreturnvisitswflog.insuredname}</td>	<!-- 被保险人 -->
							<td>${prplreturnvisitswflog.tel}</td>	<!-- 报案号码 -->
							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	<!-- 被保险人电话 -->
<!-- 							<td>${prplreturnvisitswflog.licenseno}</td>	车牌号码 -->
							<c:if test="${editType eq 'ADD'}">
								<td>${prplreturnvisitswflog.flowintotime}</td>	<!-- 流入时间 -->
								<td>${prplreturnvisitswflog.receivername}</td>	<!-- 接报案人 -->
								<td>派工回访</td>	<!-- 回访类型 -->
							</c:if>
							<c:if test="${editType eq 'SHOW'}">
								<td>${prplreturnvisitswflog.comcodename}</td>	<!-- 承保机构 -->
								<td>${prplreturnvisitswflog.enteringtime}</td>	<!-- 回访时间 -->
								<td>${prplreturnvisitswflog.enteringname}</td>	<!-- 回访人员 -->
							</c:if>
							<td>${prplreturnvisitswflog.nodeMark}</td>	<!-- 回访标志 -->
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td align="left">${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
							<td class="w4" >
								<input type="button" class="bobu" value="明细" 
								onclick="detailQuery('${prplreturnvisitswflog.registno}','${nodeType}','${prplreturnvisitswflog.state}')" >
							</td>
						</c:if>
						<!-- ---------------------------------------------------------------------- -->
						<c:if test="${nodeType eq 'endca'}">	
							<td><!-- 报案号 -->
								<c:if test="${editType eq 'ADD'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
								<c:if test="${editType eq 'SHOW'}">
									<a href="/claim/returnVisitEdit.do?editType=${editType}&registNo=${prplreturnvisitswflog.registno}&nodeType=${prplreturnvisitswflog.nodetype}" target="_parent">${prplreturnvisitswflog.registno}</a>
								</c:if>
							</td>
							<td>${prplreturnvisitswflog.policyno}</td>	<!-- 保单号 -->
							<td align="right">${prplreturnvisitswflog.sumpaid}</td>	<!-- 赔付金额（不含费用） -->
							<td align="right">${prplreturnvisitswflog.sumprepaid}</td>	<!-- 支付金额 -->
							<td>${prplreturnvisitswflog.serialno}</td>	<!-- 回访次数 -->
							<td align="left"><nobr>${prplreturnvisitswflog.insuredname}</nobr></td>	<!-- 被保险人 -->
							<td>${prplreturnvisitswflog.tel}</td>	<!-- 报案号码 -->
							<td>${prplreturnvisitswflog.reportorPhoneNumber}</td>	<!-- 被保险人电话 -->
							<!-- <td><nobr>${prplreturnvisitswflog.licenseno}</nobr></td>	车牌号码 -->
							
							<td Style="display:none">${prplreturnvisitswflog.endcaseno}</td>	<!-- 结案号 -->
							<td Style="display:none">${prplreturnvisitswflog.receivername}</td>	<!-- 接报案人 -->
							<td Style="display:none"><nobr>${prplreturnvisitswflog.flowintotime}</nobr></td>	<!-- 流入时间 -->
							<td Style="display:none">结案回访</td>	<!-- 回访类型 -->
							<c:if test="${editType eq 'ADD'}">
								<td>${prplreturnvisitswflog.stReportDate }<br>${prplreturnvisitswflog.stReportHour }</td>	<!-- 报案时间 -->
								<td>${prplreturnvisitswflog.endCaseDate }</td>	<!-- 结案时间 -->
								<td>${prplreturnvisitswflog.payRefDate }</td>	<!-- 支付时间 -->
							</c:if>
							<c:if test="${editType eq 'SHOW'}">
								<td>${prplreturnvisitswflog.comcodename}</td>	<!-- 承保机构 -->
								<td>${prplreturnvisitswflog.enteringtime}</td>	<!-- 回访时间 -->
								<td>${prplreturnvisitswflog.enteringname}</td>	<!-- 回访人员 -->
							</c:if>
							<td>${prplreturnvisitswflog.nodeMark}</td>	<!-- 回访标志 -->
							<c:if test="${nodeMark eq '4'}">
								<td>${prplreturnvisitswflog.serviceSelect}</td>
								<td align="left">${prplreturnvisitswflog.existIssue}</td>
							</c:if>	
							<td>
								<input type="button" class="bobu" value="明细" 
								onclick="detailQuery('${prplreturnvisitswflog.registno}','${nodeType}','${prplreturnvisitswflog.state}')" >
							</td>
						</c:if>
						<!-- ---------------------------------------------------------------------- -->
							<!-- 
							<c:if test="${editType eq 'ADD'}">
								<td>${prplreturnvisitswflog.flowintotime}</td>
								<td>${prplreturnvisitswflog.receivername}</td>
								<td><c:if test="${prplreturnvisitswflog.nodetype eq 'sched'}">派工回访</c:if>
									<c:if test="${prplreturnvisitswflog.nodetype eq 'endca'}">结案回访</c:if>
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
		          <input  name="buttonUnderwrite" class="button"  type="button"  value="导出Excel" onclick="exp();">
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
	       alert("当前结果超过2000条，请精确查询后导出");
	       return false;
	      }else{
	         var editType=document.getElementById("editType");
	         editType.value="EXP";
		     fm.action="/claim/returnVisitQueryEdit.do?excel=1";
	  		 fm.submit();	      
	     }              
	    }
	
	//ifrom 自适应高度 showlist ifrom 名字 begin
	<%--parent.document.all("showlist").style.width=document.body.scrollWidth; 
	parent.document.all("showlist").style.height=document.body.scrollHeight; 

	var iframe = parent.document.getElementById("showlist");
	var bHeight = iframe.contentWindow.document.body.scrollHeight;
	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	//ifrom 自适应高度 showlist ifrom 名字 end--%>
</script>
</html:html>