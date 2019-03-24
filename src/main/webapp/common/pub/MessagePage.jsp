<%--
 *************************************************************************
 * 程序名称: MessagePage.jsp
 * 程序功能: 信息反馈页面
 * 最近更新人: weishixin
 * 最近更新日期: 2004-03-29
 ****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claimciplatform.bl.action.custom.CIPlatFormInterface" %>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>

<%
    String compensateNo   = (String)request.getAttribute("compensateNo");
	String isCompensate   = (String)request.getAttribute("isCompensate");
	String isNew          = (String)request.getAttribute("isNew");
	String buttonSaveType = (String)request.getAttribute("buttonSaveType");
	String isCombine      = (String)request.getAttribute("isCombine");
	String dealHref       = (String)request.getAttribute("dealHref");
	String nodeType1	  = (String)request.getAttribute("nodeType1");
	String isSave		  = (String)request.getAttribute("isSave");
	String registNoNumber = (String)request.getAttribute("registNo");
%>
<html>
<head>
  <title><bean:message key="db.prpLregist.registNo"/></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>
<body class="interface">

 <!--原因：在提交报案信息时要提示是否需要抄单打印-->
   <script language='javascript'> 
   	
   	//显示打印窗口
      function printWindow(strURL,strWindowName)
      {
        var pageWidth=screen.availWidth-10;
        var pageHeight=screen.availHeight-30;
        
        if (pageWidth<100 )
          pageWidth = 100;
      
        if (pageHeight<100 )
          pageHeight = 100;
      
        var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      } 
      //显示错误信息
      function showErrorInfo(type){
        if(type == 'info'){
            trCIExceptionInfo.style.display = "";
            trCIExceptionDetailInfo.style.display = "none";
            messageTable.style.width="";
        }else if(type == 'detailInfo'){
            trCIExceptionInfo.style.display = "none";
            trCIExceptionDetailInfo.style.display = "";
            messageTable.style.width="60%";
        }
      }
      //隐蒇错误信息
      function closeErrorInfo(){
         try{
            messageTable.style.width="";
            trCIExceptionInfo.style.display = "none";
            trCIExceptionDetailInfo.style.display = "none";
         }catch(e){
            
         }
      }
      
      
      function reduceAmount()
      {
      	strUrl = "/claim/endor.do?editType=reducePre&CompensateNo=<%=compensateNo%>";
      	printWindow(strUrl,"冲减保额");
      }
      function addPre()
      {
      	strUrl = "/claim/endor.do?editType=addPre&CompensateNo=<%=compensateNo%>";
      	printWindow(strUrl,"补收保费");
      } 
      function dealCombine()
      {
        
        strUrl = "<%=dealHref%>";
        printWindow(strUrl,"继续处理立案");
      }
 <%
     if (request.getAttribute("com.sinosoft.registno") != null) {
 %>      
         
   if (confirm("是否进行抄单打印")) {
   		<% 
   		//moidfy by lixiang start at 2006-6-13
   		//reason:此处报错误
   		String riskCode1 = (String) request.getAttribute("riskCode");
   		UICodeAction uicodeAction = new UICodeAction();
   		String strRiskType = uicodeAction.translateRiskCodetoRiskType(riskCode1);
   		//moidfy by lixiang end at 2006-6-13
		  if("D".equals(strRiskType)){
		  %>
        strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=<%= request.getAttribute("com.sinosoft.registno") %> ";       
      <%}else{%>
        strUrl = "/claim/ClaimPrint.do?printType=CopyPrint&CompensateNo=<%= request.getAttribute("com.sinosoft.registno") %> "; 
      <%}%>
      printWindow(strUrl,"打印1");
   }
  <%
      }
  %>
  <%
     //再保中的现金赔款、共同理赔处理: 需要给予提示. 2005-9-28
      if (request.getAttribute("com.sinosoft.flag") != null 
          && !"".equals(request.getAttribute("com.sinosoft.flag").toString())) {
  %>
          alert('<%= request.getAttribute("com.sinosoft.flag")%>');
   <%
      }
   %>
   
    <% 
      String riskcode     = (String)request.getAttribute("riskCode");
      if(riskcode==null){
      	riskcode="0000";
      }
      String riskcode2    = riskcode.substring(0,2);
      String registNo     = "";
      String businessNo   = "";
      String policyNo     = "";
      String swfLogFlowID = (String)request.getAttribute("swfLogFlowID");
      String handleDept = (String)request.getAttribute("handleDept");
      if(handleDept == null || "".equals(handleDept)){
      	handleDept = "0000";
      }
     //报案后直接调度
     if((riskcode2.equals("05")&&registNo!=null)||(riskcode.equals("3220")&&registNo!=null) ||(riskcode2.equals("31")&&registNo!=null) 
    		 ||(riskcode2.equals("27")&&registNo!=null) ||(riskcode2.equals("26")&&registNo!=null) ){//目前，只有车险需要调度
         //以下为需要的几个参数
         registNo = (String)request.getAttribute("registNo");
         String prpLscheduleMainWFSurveyNo = "0";//以前程序中写死为0，这里也写死，具体含义不清楚。
         String scheduleType = "sched";//调度类型，目前应该就一个调度
         swfLogFlowID = (String)request.getAttribute("swfLogFlowID");
         String swfLogLogNo  = "2";//工作流表中的节点顺序，调度是第二个节点
         String status       = "0";//报案后，状态都为0；
         //riskCode，上面已经获取了
         String editType     = "ADD";//编辑类型，报案后，直接进肯定是ADD
         String nodeType     = "sched";//节点类型，调度
         businessNo   = registNo;//业务号。报案号
         String keyIn        = registNo;//流入业务号，和报案相同
         policyNo     = (String)request.getAttribute("policyNo");//保单号码
         String modelNo      = "";//模版号，车险模版为1
         String nodeNo       = "";//节点号，到调度后，节点号为2
      
      }

      %>
      <%
        String combineUrl=(String)request.getAttribute("combineUrl");
        System.err.println(combineUrl);
        String isEnd=request.getParameter("isEnd");
        String combineNo=request.getParameter("combineNo");
        String nodeType=request.getParameter("nodeType");
      %>
</script>
  
   <table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center" id="messageTable">
     <tr>
       <td class=formtitle colspan="2"><bean:message key="prompt.system.title"/></td>
     </tr>

    <tr>
      <td  class="common">
        <img src='/claim/images/bgClaimSuccess.gif' onclick="closeErrorInfo()">
      </td>
      <td class="common">
		<logic:messagesPresent message="true">
       	<html:messages id="message" message="true">
        <%--
         <span id="success"><c:out value="${message}"/><c:out value="${prpLregistDto.registNo}"/></span><br>
       	--%>
       	<span id="success"><c:out value="${message}"/> </span><br>
       	</html:messages>
		</logic:messagesPresent>
     <logic:notEmpty  name="user"  property="userMessage"> 
     	 <bean:define id="userMessage"  name="user" property="userMessage" type="String" />
     	 <%=userMessage %>
     </logic:notEmpty>
      </td>
    </tr>
    <% 
     //报案后直接调度
     if(riskcode2.equals("05")){//目前，只有车险需要调度
       if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
      
     %>
        <tr>
           <td class=common colspan="2">
             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=3&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=1&nodeNo=2" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp处理调度任务</a></div>
           </td>
        </tr>  
         <%
         
         }
     } 
     else if(riskcode2.equals("32")){
      if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
      if("3220".equals(riskcode)){
     %>
        <tr>
           <td class=common colspan="2">
             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=2&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=2&nodeNo=12" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp处理调度任务</a></div>
           </td>
        </tr>  
         <%
         }
         }
     }
     //add by xiatian 种植调度
     else if(riskcode2.equals("31")) 
     {
    	if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
   	     %>
   	        <tr>
   	           <td class=common colspan="2">
   	             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=2&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=4&nodeNo=14" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp处理调度任务</a></div>
   	           </td>
   	        </tr>  
   	         <%
    	}
    	}
    //add by xiatian 意健调度
     else if(riskcode2.equals("26")||riskcode2.equals("27")) 
     {
    	if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
   	     %>
   	        <tr>
   	           <td class=common colspan="2">
   	             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=2&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=12&nodeNo=14" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp处理调度任务</a></div>
   	           </td>
   	        </tr>  
   	         <%
    	}
    	}
    %> 
    <% 
     if(!"".equals(combineNo)&&combineNo!=null&&!"Y".equals(isEnd)){//理算合并案件  
     %>
        <tr>
           <td class=common colspan="2">
             <% if("compe".equals(nodeType)||"compp".equals(nodeType)){%>
           <div align="center"><a href="/claim/combineCompensateBeforeEditeADD.do?<%=combineUrl%>&flag1=Y">继续处理</a></div>    
             	<% }
             	%>
                     
           </td>
        </tr>  
         <%
     } 
    %> 
    <tr id="trCIExceptionInfo" style="display:none">
    <logic:present name="ciClaimException" scope="request" >
        <bean:define id="e"  name="ciClaimException" type="Exception" scope="request"/>
            <td class=common colspan="2">
                <%=CIPlatFormInterface.getStackTraceMessageForHTML(e) %>
                <br>……<a href="javascript:showErrorInfo('detailInfo')">更多信息</a>
            </td>
    </logic:present>
    </tr>
    <tr id="trCIExceptionDetailInfo" style="display:none" >
    <logic:present name="ciClaimException" scope="request" >
        <bean:define id="e"  name="ciClaimException" type="Exception" scope="request"/>
            <td class=common colspan="2" width="70%">
                <%e.printStackTrace(response.getWriter()); %>
            </td>
    </logic:present>
    </tr>
<%
  if(null!=isCombine&&"certi".equals(isCombine)){
%>
  
  	<tr class="common">
  		<td class="common" colspan="2">
  		<a href="<%=dealHref%>">继续处理并案单证</a>
  		</td>
  	</tr>
  
<%}
  if(null!=isCombine&&"claim".equals(isCombine)){
%>
  	<tr class="common">
  		<td  class="common" colspan="2">
  		<a href="<%=dealHref%>">继续处理并案立案</a>
  		</td>
  	</tr>
 <%}
  %>
  </table>
  
<%
  String riskCode3 = (String) request.getAttribute("riskCode");
  UICodeAction uicodeAction1 = new UICodeAction();
  String strRiskType1 = uicodeAction1.translateRiskCodetoRiskType(riskCode3);
  if("Y".equals(isCompensate) && !"D".equals(strRiskType1) && "4".equals(buttonSaveType))
  {
%>
  <table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center">
  	<tr>
  		<td>
  			<input type=button value="冲减保额" class='button' name="reduce" onclick="reduceAmount();">
  		</td>
  		<td>
  			<input type=button value="补收保费" class='button' name="add" onclick="addPre();">
  		</td>
  	</tr>
  </table>
<%  
  }
  UserDto user = (UserDto) session.getAttribute("user");
  user.setUserMessage(""); 
%>  

<%
	if("sched".equals(nodeType1) && "1".equals(isSave)){
%>
<form name=fm>
	<input type="hidden" name="registNoNumber" value="<%=registNoNumber %>">
	<script>
		var linkURL = "/claim/common/schedule/ScheduleSendMessage.jsp?registNo="+fm.registNoNumber.value;
		window.showModalDialog(linkURL,"NewWindow","scroll=0;status=0;dialogWidth=500px;dialogHeight=300px;dialogTop=387px;dialogLeft=390px");
		//window.open(linkURL,"NewWindow","width=500,height=150,top=387,left=390,toolbar=no,location=no,directories=no,menubar=no,scrollbars=no,resizable=no,status=no");
	</script>
</form>
<%
	}
%>
</body>
</html>
