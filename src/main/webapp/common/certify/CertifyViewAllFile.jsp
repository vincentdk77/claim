
<%--
****************************************************************************
* DESC       ： 单证查看单证图片页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.claim.ui.control.action.*" %>
<%@ page import="com.sinosoft.claim.ui.model.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.sysframework.common.util.StringUtils"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLCertifyImgFacade"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.PageRecord" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UIRegistAction" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sinosoft.claim.ui.model.PrpLclaimFindByConCommand" %>
<%@ page import="java.util.Collection" %>
<%!
private boolean isImageFile(String fileName){
    fileName = fileName.toLowerCase().trim();
    if(fileName.endsWith("jpg") || fileName.endsWith("jpeg") ||
        fileName.endsWith("gif") || fileName.endsWith("bmp")){
        return true;
    }else{
        return false;
    }
}
%>

<html:html locale="true">
<head>
  <title>查看单证信息</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script language="javascript">
    function downloadFile(fileURL){
      window.open(fileURL,"downloaFile",'width=10,height=10,top=500,left=380,toolbar=0,location=0,directories=0,menubar=0,scrollbars=0,resizable=0,status=0');
    }
  </script>
</head>



<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();">
<form name=fm method="post" action="/claim/common/certify/CertifyViewAllFile.jsp"> 
<%
  String editType = request.getParameter("editType");  //add by liyanjie 20051103 
  String directType = request.getParameter("directType");
  String display = request.getParameter("display");
  String businessNo = request.getParameter("businessNo");//可能为预赔号或实配号，需要变为报案号
  String strLossItemName = request.getParameter("itemcode");
  String pageNo = request.getParameter("pageNo");
  String rowsPerPage = "20";
  int curPage=0;
  UserDto userDto = (UserDto)session.getAttribute("user");      // add by liyanjie 20051103
//modify by mengdongdong at 20060314 start
//resion:双核系统调用时session中无此对象
//  if(userDto==null){
//  		response.sendRedirect("/claim/common/pub/SessionErrorpage.jsp");
//  		return;
//  }
//modify by mengdongdong at 20060314 end

//  FileUploadUtils fileUploadUtils = new FileUploadUtils();
//  fileUploadUtils.getcollect(businessNo,Url); 
  
  //UICertifyAction uiCertifyAction = new UICertifyAction();
  //CertifyDto certifyDto = uiCertifyAction.findByPrimaryKey(businessNo.trim());
  
  BLCertifyImgFacade blCertifyImgFacade= new BLCertifyImgFacade();
  java.util.ArrayList prpLCertifyImgList =new  java.util.ArrayList();

//optimize(someday)-now only can see.
  String strFileName ="";  
  String registNo="";
  String conditions = " (ClaimNo IN (SELECT ClaimNo FROM PrpLcompensate WHERE CompensateNo = '" + 
  										businessNo + "') OR " +
  										" ClaimNo IN (SELECT ClaimNo FROM PrpLprepay WHERE PreCompensateNo = '" + 
  										businessNo + "') )";
  PrpLclaimFindByConCommand command = new PrpLclaimFindByConCommand(conditions);
  
  
  Collection result = (Collection)command.executeCommand();
  if(result.size()>0){
  	PrpLclaimDto prpLclaimDto = (PrpLclaimDto)result.iterator().next();
  	registNo = prpLclaimDto.getRegistNo();
  }
  if(registNo.equals("")){
	  registNo = businessNo;
  }
	PageRecord  pageRecord =  blCertifyImgFacade.findByQueryConditions("businessno='"+ registNo.trim() +"' and ValidStatus ='1'  order by typecode",pageNo,rowsPerPage);
        TurnPageDto turnPageDto= new TurnPageDto();
        turnPageDto.setResultList((List)pageRecord.getResult());
        turnPageDto.setPageNo(pageRecord.getPageNo());
        turnPageDto.setRecordPerPage(20);
        turnPageDto.setTotalCount(pageRecord.getCount());
        turnPageDto.setCondition("businessno='"+ registNo.trim() +"'");
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
        request.setAttribute("turnPageDto", turnPageDto);
        curPage=turnPageDto.getPageNo();
        prpLCertifyImgList=(ArrayList)pageRecord.getResult();

  	
%>
  <input type="hidden" name="editType" value="<%=editType%>"/>
  <input type="hidden" name="directType" value="<%=directType%>"/>
  <input type="hidden" name="businessNo" value="<%=businessNo%>"/>
  <input type="hidden" name="itemcode" value="<%=strLossItemName%>"/>
  
  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >
    <tr>
     	<input type="hidden" name="BusinessNo" value="<%=businessNo %>">
    
<!--      <td class="subformtitle" style="width:20%">单证清单类型</td>-->
      <td class="subformtitle" style="width:20%">单证清单类型</td>
      <td class="subformtitle" style="width:20%">说明</td>
      <td class="subformtitle" style="width:60%">图片</td>
    </tr>
<%
    if(prpLCertifyImgList!=null){
      for(int i=0;i<prpLCertifyImgList.size();i++){
        PrpLcertifyImgDto prpLcertifyImgDto =(PrpLcertifyImgDto)prpLCertifyImgList.get(i);
%>
    <tr>
      <td class="prompt"><%= prpLcertifyImgDto.getPicName() %></td>
      <td class="prompt"><%= prpLcertifyImgDto.getDisplayName() %></td>
<%

            strFileName = "/claim/uiviewimg?BusinessNo=" + 
                      prpLcertifyImgDto.getBusinessNo() + 
                      "&SerialNo=" + prpLcertifyImgDto.getSerialNo();

  if(isImageFile(prpLcertifyImgDto.getImgFileName())){
%>
      <td class="prompt">
<!--      <img src="<%= AppConfig.get("sysconst.CertifyVirtualPath") %><%= prpLcertifyImgDto.getPicPath().substring(1) %>/<%= prpLcertifyImgDto.getImgFileName() %>">-->
        <a href="/claim/DAA/certify/DAAShowFile.jsp?FileName=<%=strFileName%>"  target="_blank"><img src="<%=strFileName%>" ></a>      
      </td>

<%
  }else{
%>
      <td class="prompt">

      <!--<a href="<%= AppConfig.get("sysconst.CertifyVirtualPath") %><%= prpLcertifyImgDto.getPicPath().substring(1) %>/<%= prpLcertifyImgDto.getImgFileName() %>"><%= prpLcertifyImgDto.getImgFileName() %></a>-->
        <img src="/claim/images/word.gif" > <a href="<%=strFileName%>" target="_blank"><%=prpLcertifyImgDto.getUploadFileName() %></a>              
</td>        
<%
  }
%>
    </tr>
<%
        }
    }
%>

      <tr>
        <td colspan=3 class="button">
          <input type="button" class=button name="buttonClose" value="关 闭" onclick="javascript:window.close()">
        </td>
      </tr>
  </table>
        <tr>
        <td colspan="7">
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>
                  <bean:define id="pageview" name="turnPageDto"/>
                  <%@include file="/common/pub/TurnOverPage.jsp" %>
              </tr>
          </table>
        </td>
      </tr>
 </form>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>