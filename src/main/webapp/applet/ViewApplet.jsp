<%--
****************************************************************************
* DESC       ������applet
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-05
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>
<%@ page import="com.sinosoft.claim.util.*" %>
<%@ page import="com.sinosoft.claim.ui.control.action.*" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>

<%
  UserDto   user     = (UserDto)session.getAttribute("user");
  
  //��Ϊ��session��ȡ�õ�ֵΪ��,��Ҫ���.��ʱ�����ȴ�һ���ַ���.
  //String userCode = user.getUserCode();
  //modify by lixiang start at 2006-1-19 
  //reason:�ϴ����û����Ǵ���Ӧ�ô�ҳ����ȡ�á� 
  String userCode = request.getParameter("operatorCode");
  
  String strImageTypeList = request.getParameter("imageTypeList"); 
  String titleName = request.getParameter("titleName");
  String  strTitleList=titleName;
  String JRE_DOWNLOAD_URL = (String)AppConfig.get("sysconst.JRE_DOWNLOAD_URL");

%>

<html>
	<script langauge='javascript'>
	<!--
	  //��ʼ����ʱ��Ĳ��Է���������applet����Ĳ���
	  function submitForm(datas){
	      alert(imageTransfer.getUploadData());
	  }
	//-->
	</script>
	<body>
		<form name="fm">
		    <input type="text" name="testField">
	    	<input type="button" name="submitme" value="submit" onclick="submitForm()">
	    </form>
	  	<br><br><br><br><br><br><br><br><br><br>
	  	<center>
			<OBJECT
			    classid = "clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			    codebase = "<%=JRE_DOWNLOAD_URL%>"
			    WIDTH = "150" HEIGHT = "50" NAME = imageTransfer >
			    <PARAM NAME = CODE VALUE = com.sinosoft.imagetrans.ImageTransferApplet.class >
			    <PARAM NAME = ARCHIVE VALUE = "claimjavaimage.jar,servlet.jar,jdom.jar" >
			    <PARAM NAME = NAME VALUE = imageTransfer >
			    <PARAM NAME = "type" VALUE = "application/x-java-applet;version=1.4">
			    <PARAM NAME = "scriptable" VALUE = "false">
			
			    <PARAM NAME = "title" VALUE="<%= request.getParameter("titleName") %>">
			    <PARAM NAME = "certiType" VALUE="<%= request.getParameter("directType") %>">
			    <PARAM NAME = "certifyPath" VALUE="<%= AppConfig.get("sysconst.CertifyPath") %>">
			    <PARAM NAME = "lossItemCode" VALUE="<%= request.getParameter("lossItemCode") %>">
			    <PARAM NAME = "lossItemName" VALUE="<%= request.getParameter("lossItemName") %>">
			    <PARAM NAME = "uploadYear" VALUE="<%= request.getParameter("uploadYear") %>">
			    <PARAM NAME = "riskCode" VALUE="<%= request.getParameter("riskCode") %>">
			    <PARAM NAME = "nodeType" VALUE="<%= request.getParameter("nodeType") %>">
			    <PARAM NAME = "registNo" VALUE="<%= request.getParameter("businessNo") %>">
			    <PARAM NAME = "maxImageWidth" VALUE="<%= AppConfig.get("sysconst.MaxImageWidth") %>">
			    <PARAM NAME = "maxImageHeight" VALUE="<%= AppConfig.get("sysconst.MaxImageHeight") %>">
			    <PARAM NAME = "compressionQuality" VALUE="<%= AppConfig.get("sysconst.CompressionQuality") %>">
			    <PARAM NAME = "collectorName" VALUE="<%= userCode %>">
			    <PARAM NAME = "ftpUrl" VALUE="<%= AppConfig.get("sysconst.FTP_URL") %>">
			    <PARAM NAME = "webUrl" VALUE="<%= AppConfig.get("sysconst.UP_URL") %>">
			    <PARAM NAME = "imgUrl" VALUE="<%= AppConfig.get("sysconst.IMGURL") %>">          
			    <PARAM NAME = "ftpUser" VALUE="<%= AppConfig.get("sysconst.FTP_USER") %>">
			    <PARAM NAME = "ftpPass" VALUE="<%= AppConfig.get("sysconst.FTP_PASS") %>">
			    <PARAM NAME = "strImageTypeList" VALUE="<%= strImageTypeList %>">
			
			
			    <PARAM NAME = "imgFileCount" VALUE="10">     
			    <PARAM NAME = "imgFileCapabillity" VALUE="1048576">
			    <PARAM NAME = "strTitleList" VALUE="<%= strTitleList %>">
			    
			    <!--Modify by wangwei add start 2005-12-12
			        Reason: ��ӱ�����/ǩ������/�޸����Ϊ��ǰ����-->
			    <PARAM NAME = "PolicyNo"   VALUE="<%= request.getParameter("PolicyNo") %>"> 
			    <PARAM NAME = "SignInDate" VALUE="<%= new DateTime(DateTime.current().toString()) %>">
			    <PARAM NAME = "uploadYear" VALUE="<%= new DateTime(DateTime.current().toString()).getYear() %>">
			    <!--Modify by wangwei add end 2005-12-12-->   
			
			      alt="Your browser understands the &lt;APPLET&gt; tag but isn't running the applet, for some reason. "
			        Your browser is completely ignoring the &lt;APPLET&gt; tag!
			</OBJECT>
		</center>
	</body>
</html>


