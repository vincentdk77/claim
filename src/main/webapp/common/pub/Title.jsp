<%--
****************************************************************************
* DESC       ：车险理赔TITLE页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-03-23
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%@page import="javax.servlet.http.*"%>

<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%

      UserDto   user     = (UserDto)session.getAttribute("user");
      String userName = user.getUserName();


%>

<html:html>
    <head>
        <app:css />
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

        <script language="JavaScript">
          function query()
          {
            var strURL = "/workflow/common/QueryIndex.jsp";
            var newWindow = window.open(strURL,"aa",'width=650,height=450,top=0,left=0,toolbar=1,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=1');
            newWindow.focus();
          }

          function queryAuLaw()
          {
            var strURL = "/workflow/overall/function/QueryLawOverview.jsp";
            if(fm.auLawRgrade.value=="1"&&fm.auLawXgrade.value=="1"){
              var newWindow = window.open(strURL,"aa",'width=650,height=450,top=0,left=0,toolbar=1,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=1');
              newWindow.focus();
            }
          }

          function queryAuKnowledge()
          {
            var strURL = "/workflow/overall/function/QueryKnowledgeOverview.jsp";
            if(fm.auKnowledgeRgrade.value=="1"&&fm.auKnowledgeXgrade.value=="1"){
              var newWindow = window.open(strURL,"aa",'width=650,height=450,top=0,left=0,toolbar=1,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=1');
              newWindow.focus();
            }
          }

          function editPaper()
          {
            if(fm.auPaperRgrade.value=="1"&&fm.auPaperXgrade.value=="1"){
              parent.fraInterface.window.location="/workflow/audit/project/QueryPaperNature.jsp";
            }
          }

          function showHideFrame()
          {
            try
            {
                 if(parent.fraSet.cols==    "0%,*")
                 {
              parent.fraSet.cols = "180,*";
              menuPowerImage.src = "/claim/images/butHide.gif";
              }
              else if(parent.fraSet.cols=="180,*")
              {
                parent.fraSet.cols = "0%,*";
                menuPowerImage.src = "/claim/images/butShow.gif";
              }
            }
          catch(re){}
          }
          //链接到首页
          function showFirstPage()
          {

          }

          function menuSwitch(menuSwitchInput)
         {
             if(menuSwitchInput.value=="close")
             {
                 menuSwitchInput.src="/claim/images/cpClaimTitleShow.gif";
                 menuSwitchInput.value="open";
                 //parent.fraMenuReport.cols = "0,*";
                 parent.fraSet.cols = "1,*";
                 return;
             }
             if(menuSwitchInput.value=="open")
             {
                 menuSwitchInput.src="/claim/images/cpClaimTitleHidden.gif";
                 menuSwitchInput.value="close";
                 //parent.fraMenuReport.cols = "180,*";
                 parent.fraSet.cols = "180,*";
                 return;
             }
         }
    	function setCommand(text){
    	    document.all("command").innerText="　"+text;
    	}

        </script>
          <script language="JavaScript"
             type="text/javascript" src="/claim/common/js/leftMenu.js">
          </script>
    </head>

  <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="60%" background="/claim/images/BgVisaTop.gif"><img src="/claim/images/cpClaimTitle.gif"><img src="/claim/images/ImgClaimFlowSystem.gif"></td>
    <td width="15%" background="/claim/images/BgVisaTop.gif" class=common aglin=right> <span id="spanUserName"><img src="/claim/images/ImgIcon_1.gif" align="absmiddle" > <%=userName%></span></td>
    <td width="15%" background="/claim/images/BgVisaTop.gif" class=common aglin=right> <span id="spanUserName"><img src="/claim/images/ImgIcon_1.gif" align="absmiddle" > </span><span id="spanProjectName">当前项目</span> </td>
    <td width="10%" background="/claim/images/BgVisaTop.gif" class=common aglin=center> <span id="spanUserName"><img src="/claim/images/ImgIcon_1.gif" align="absmiddle" > </span>
                                                  <span id="spanDate"><%=new SimpleDateFormat("yyyy年MM月dd日").format(new Date())%></span>
    </td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="17%" align=center background="/claim/images/bgTitle2.gif"><img src="/claim/images/cpClaimTitleHidden.gif" align="absmiddle" onclick="menuSwitch(this)" value="close" style="CURSOR:hand"></td>
    <td width="83%" background="/claim/images/bgTitle2.gif" class=white><img src="/claim/images/ImgPlace.gif" align="absmiddle"><span id="command"/></td>
  </tr>
</table>
<MARQUEE align="right"  behavior="scroll" scrollAmount=3 contenteditable="true" onmouseover=this.stop() onmouseout=this.start() onstart="this.firstChild.innerHTML+=this.firstChild.innerHTML;"   width="100%"><SPAN style="color:red" unselectable="on">
	信息技术部硬件维修报修电话：0551-65197906； &nbsp;&nbsp;&nbsp;&nbsp; 网络故障报修电话：0551-65197938； &nbsp;&nbsp;&nbsp;&nbsp;    系统咨询及缺陷电话：0551-65197957&nbsp;0551-65197936； &nbsp;&nbsp;&nbsp;&nbsp;
	</SPAN>
</MARQUEE>
</body>
</html:html>
