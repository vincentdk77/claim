<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��(�ǳ���)
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>
<%@ page import=" com.sinosoft.claimciplatform.dto.custom.*" %>
<%@ page import=" com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto" %>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<html:html locale="true">
  <!--��title����-->
  <title></title>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 <script src="/claim/DAA/compelcrash/js/CompelCrash.js"></script>
</head>
<body>
		<%
		String nodeType=(String)request.getAttribute("nodeType");
 
	 	if(nodeType==null){
		  nodeType=(String)request.getParameter("nodeType");
		  if(nodeType==null){
		    nodeType="";
		  }
		}

			%>
		<FORM name="fm" method="post" action="/claim/compelCrashImportInfo.do"  onsubmit="return submitValidate();">	
      <input type="hidden" name="nodeType" value="<%=nodeType%>" >
			<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" class="common" >
				<tr>

					<td colspan="4" class="formtitle">
						�¹���Ϣ��ѯ
					</td>
			</tr>
	   	 <tr>
					<td  width="15%">
						�ҷ�������
		��
					</td>
					<td width="35%">

						<select class=tag name="reportMySign">
    				<option value="=">
								=
							</option>
							<option value="*">
								*
							</option>
						</select>
						<input type=text name="ownRegistNo" class="query">
					</td>
					<td width="15%">
						���������ţ�
					</td>
					<td width="35%">
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
			<% if(nodeType.equals("query")){ %>
			<input type="submit" align="middle" value="��ѯ" ��name="querySM" class="bigbutton" ��>
		<%}else{%>
			<input type="submit" align="middle" value="�����¹���Ϣ" ��name="querySM" class="bigbutton" ��>
    <%}%>
				<td>
				</tr>
			</TABLE>
			<%
			String editType=(String)request.getAttribute("editType");
    	CiClaimCompelcrashDto aCiClaimCompelcrashDto=(CiClaimCompelcrashDto)request.getAttribute("aCiClaimCompelcrashDto");
			if(aCiClaimCompelcrashDto==null && "query".equals(editType)){
			if("query".equals(nodeType)){
			%>
			<TABLE>
				<tr>
					<td>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</td>
				  <td colspan="3" >
				  	ƽ̨û�������������Ϣ!
					</td>
				</tr>
			</TABLE>
			<%}else{%>
			<TABLE>
				<tr>
					<td>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</td>
				  <td colspan="3" >
				  	ƽ̨û�������������Ϣ�Ƿ�����¼�룿
					</td>
					<td>
						<input type="button" name="importInfo" value="¼���¹���Ϣ" class="bigbutton"  onclick="importAccidentInfo();"/>
			  	</td>
				</tr>
			</TABLE>
			<%
			 }
			 }
			 %>
		</form>
	</body>
</html:html>
