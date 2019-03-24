<%--
****************************************************************************
* DESC       ：立案登记录入/修改页面(非车险)
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import=" com.sinosoft.claimciplatform.dto.custom.*" %>
<%@ page import=" com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto" %>
<%@ page import="java.util.*"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";

		%>

<html:html locale="true">
<head>
  <!--对title处理-->
  <title></title>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="/claim/DAA/compelcrash/js/CompelCrash.js"></script>
 	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<body>
		<%
		String nodeType=(String)request.getAttribute("nodeType");
		if(nodeType==null || nodeType.equals("")){
		    nodeType=(String)request.getParameter("nodeType");
		}
		%>
		<FORM name="fm" method="post" action="/claim/accidentInfoQuery.do">
     <input type="hidden" name="nodeType" value="<%=nodeType%>" >
			<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
			<td colspan="4" class="formtitle">
						事故信息查询
					</td>

				</tr>
				<tr>
					<td class='title'>
						事故号：
					</td>
					<td class='input'>
						<select class="tag" name="accidentSign">
							<option value="=">
								=
							</option>
							<option value="*">
								*
							</option>
						</select>
						<input type=text name="accidentNo" class="query">
					</td>
					<td class='title'>
					 
					</td>

					<td class='title'>
					 
					</td>
				</tr>
				<tr>
					<td class='title'>
						我方报案号：
		　
					</td>
					<td class='input'>
						<select class=tag name="reportMySign">

							<option value="=">
								=
							</option>
							<option value="*">
								*
							</option>
						</select>
						<input type=text name="myRegistNo" class="query">
					</td>
					<td class='title'>
						其它报案号：
					</td>
					<td class='input'>
						<select class=tag name="otherSign">

							<option value="=">
								=
							</option>
							<option value="*">
								*
							</option>
						</select>
						<input type=text name="otherRegistNo" class="query">
					</td>
				</tr>
				<tr>
				<td align="center" colspan="4">
			<input type="submit" align="middle" value="查询" 　name="querySM" class="bigbutton" ／>
				<td>
				</tr>
			</TABLE>
			
			<%
			String editType=(String)request.getAttribute("editType");
			if(editType!=null && editType.equals("query")){
			
			%>
			<table class="common" width="100%" align="center">
				<tr>
					<td colspan="7" align="center" class="formtitle">
						车车互碰查询结果
					</td>
				</tr>
				<input type="hidden" name="editAccidentInfo" value="">
				<tr class=common>
					<td class="centertitle">
						序号
					</td>
					<td class="centertitle">
						事故号
					</td>
					<td class="centertitle">
						甲方报案号
					</td>
					<td class="centertitle">
						乙方报案号
					</td>
					<td class="centertitle">
						甲方车牌号
					</td>
				<!--	<td class="centertitle">
						乙方车牌号
					</td>-->
					<td class="centertitle">
						过错方
					</td>
				</tr>
		
			<%
			Collection ciClaimCompelcrashCollection=(Collection)request.getAttribute("ciClaimCompelcrashCollection");
			if(ciClaimCompelcrashCollection.size()>0){
			int i=0;
			  for(Iterator it=ciClaimCompelcrashCollection.iterator();it.hasNext();){
			CiClaimCompelcrashDto ciClaimCompelcrashDto=(CiClaimCompelcrashDto)it.next();
			i++;
			  
			%>
			<tr  >
			<td >
					<%=i%>
			</td>
			<td >
					<%if(ciClaimCompelcrashDto.getAccidentNo()==null || ciClaimCompelcrashDto.getAccidentNo().equals("")){
					String str="/claim/accidentInfoQuery.do?myRegistNo="+ciClaimCompelcrashDto.getRegistNo()+"&otherRegistNo="+ciClaimCompelcrashDto.getRelatedRegistNo()+"&editAccidentInfo=edit&nodeType="+nodeType;
					String str2="无事故号";
					 %>
					<a href="<%=str%>"><%=str2%></a>
					<%}else{
						String str="/claim/accidentInfoQuery.do?myRegistNo="+ciClaimCompelcrashDto.getRegistNo()+"&otherRegistNo="+ciClaimCompelcrashDto.getRelatedRegistNo()+"&accidentNo="+ciClaimCompelcrashDto.getAccidentNo()+"&editAccidentInfo=edit&nodeType="+nodeType;
						%>	
					<a href="<%=str%>"><%=ciClaimCompelcrashDto.getAccidentNo()%></a>
					<%}%>
			</td>
			<td >
					<%=ciClaimCompelcrashDto.getRegistNo()%>
			</td>
			<td >
					<%=ciClaimCompelcrashDto.getRelatedRegistNo()%>
			</td>
			<td>
					<%=ciClaimCompelcrashDto.getCarNo()%>
			</td>
			
			<td >
					<%=ciClaimCompelcrashDto.getFaultParty()%>
			</td>
		</tr>
			<%
			  }
			 }
			}
			%>
				</table>
	</body>

</html:html>