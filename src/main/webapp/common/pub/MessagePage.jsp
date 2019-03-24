<%--
 *************************************************************************
 * ��������: MessagePage.jsp
 * ������: ��Ϣ����ҳ��
 * ���������: weishixin
 * �����������: 2004-03-29
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

 <!--ԭ�����ύ������ϢʱҪ��ʾ�Ƿ���Ҫ������ӡ-->
   <script language='javascript'> 
   	
   	//��ʾ��ӡ����
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
      //��ʾ������Ϣ
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
      //���۴�����Ϣ
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
      	printWindow(strUrl,"�������");
      }
      function addPre()
      {
      	strUrl = "/claim/endor.do?editType=addPre&CompensateNo=<%=compensateNo%>";
      	printWindow(strUrl,"���ձ���");
      } 
      function dealCombine()
      {
        
        strUrl = "<%=dealHref%>";
        printWindow(strUrl,"������������");
      }
 <%
     if (request.getAttribute("com.sinosoft.registno") != null) {
 %>      
         
   if (confirm("�Ƿ���г�����ӡ")) {
   		<% 
   		//moidfy by lixiang start at 2006-6-13
   		//reason:�˴�������
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
      printWindow(strUrl,"��ӡ1");
   }
  <%
      }
  %>
  <%
     //�ٱ��е��ֽ�����ͬ���⴦��: ��Ҫ������ʾ. 2005-9-28
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
     //������ֱ�ӵ���
     if((riskcode2.equals("05")&&registNo!=null)||(riskcode.equals("3220")&&registNo!=null) ||(riskcode2.equals("31")&&registNo!=null) 
    		 ||(riskcode2.equals("27")&&registNo!=null) ||(riskcode2.equals("26")&&registNo!=null) ){//Ŀǰ��ֻ�г�����Ҫ����
         //����Ϊ��Ҫ�ļ�������
         registNo = (String)request.getAttribute("registNo");
         String prpLscheduleMainWFSurveyNo = "0";//��ǰ������д��Ϊ0������Ҳд�������庬�岻�����
         String scheduleType = "sched";//�������ͣ�ĿǰӦ�þ�һ������
         swfLogFlowID = (String)request.getAttribute("swfLogFlowID");
         String swfLogLogNo  = "2";//���������еĽڵ�˳�򣬵����ǵڶ����ڵ�
         String status       = "0";//������״̬��Ϊ0��
         //riskCode�������Ѿ���ȡ��
         String editType     = "ADD";//�༭���ͣ�������ֱ�ӽ��϶���ADD
         String nodeType     = "sched";//�ڵ����ͣ�����
         businessNo   = registNo;//ҵ��š�������
         String keyIn        = registNo;//����ҵ��ţ��ͱ�����ͬ
         policyNo     = (String)request.getAttribute("policyNo");//��������
         String modelNo      = "";//ģ��ţ�����ģ��Ϊ1
         String nodeNo       = "";//�ڵ�ţ������Ⱥ󣬽ڵ��Ϊ2
      
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
     //������ֱ�ӵ���
     if(riskcode2.equals("05")){//Ŀǰ��ֻ�г�����Ҫ����
       if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
      
     %>
        <tr>
           <td class=common colspan="2">
             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=3&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=1&nodeNo=2" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp�����������</a></div>
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
             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=2&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=2&nodeNo=12" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp�����������</a></div>
           </td>
        </tr>  
         <%
         }
         }
     }
     //add by xiatian ��ֲ����
     else if(riskcode2.equals("31")) 
     {
    	if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
   	     %>
   	        <tr>
   	           <td class=common colspan="2">
   	             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=2&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=4&nodeNo=14" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp�����������</a></div>
   	           </td>
   	        </tr>  
   	         <%
    	}
    	}
    //add by xiatian �⽡����
     else if(riskcode2.equals("26")||riskcode2.equals("27")) 
     {
    	if(swfLogFlowID!=null && "4".equals(buttonSaveType)){
   	     %>
   	        <tr>
   	           <td class=common colspan="2">
   	             	 <div align="center"><a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<%=registNo%>&prpLscheduleMainWFSurveyNo=0&scheduleType=sched&handleDept=<%=handleDept%>&&endflag=0&commiFlag=0&swfLogFlowID=<%=swfLogFlowID%>&swfLogLogNo=2&status=0&riskCode=<%=riskcode%>&editType=ADD&nodeType=sched&businessNo=<%=businessNo%>&keyIn=<%=businessNo%>&policyNo=<%=policyNo%>&modelNo=12&nodeNo=14" ><img src='/claim/images/ImgVisaMenu_2.gif' border="0">&nbsp�����������</a></div>
   	           </td>
   	        </tr>  
   	         <%
    	}
    	}
    %> 
    <% 
     if(!"".equals(combineNo)&&combineNo!=null&&!"Y".equals(isEnd)){//����ϲ�����  
     %>
        <tr>
           <td class=common colspan="2">
             <% if("compe".equals(nodeType)||"compp".equals(nodeType)){%>
           <div align="center"><a href="/claim/combineCompensateBeforeEditeADD.do?<%=combineUrl%>&flag1=Y">��������</a></div>    
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
                <br>����<a href="javascript:showErrorInfo('detailInfo')">������Ϣ</a>
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
  		<a href="<%=dealHref%>">������������֤</a>
  		</td>
  	</tr>
  
<%}
  if(null!=isCombine&&"claim".equals(isCombine)){
%>
  	<tr class="common">
  		<td  class="common" colspan="2">
  		<a href="<%=dealHref%>">��������������</a>
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
  			<input type=button value="�������" class='button' name="reduce" onclick="reduceAmount();">
  		</td>
  		<td>
  			<input type=button value="���ձ���" class='button' name="add" onclick="addPre();">
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
