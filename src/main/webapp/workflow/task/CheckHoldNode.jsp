<%--
****************************************************************************
* DESC       ������Ƿ�ռ��ʱ���ô�ҳ��
* AUTHOR     ��������Ŀ��
* CREATEDATE ��2004-09-10
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html; charset=GBK" %>
<%@page import="java.io.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*" %>
<%@page import="com.sinosoft.claim.dto.domain.SwfLogDto" %>
<%@page import="com.sinosoft.claim.dto.custom.*" %>
<%@page import="com.sinosoft.sysframework.common.util.*" %>
<%@page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.sysframework.exceptionlog.*" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%
 

        UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
        String flowID = request.getParameter("flowID");
        String logNo= request.getParameter("logNo");
        String bussinessNo=request.getParameter("bussinessNo");
        String bussinessOut=request.getParameter("bussinessOut");
        String nodeStatus=request.getParameter("nodeStatus");
        String nodeType=request.getParameter("nodeType");
        boolean retHoldNode=false;
        boolean executeResult=true;
        UserDto user = (UserDto)session.getAttribute("user");
        String userCode = user.getUserCode();
        String userName = user.getUserName();
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = null; 
         
        System.out.println(flowID+"|"+logNo+"|"+userCode+"|"+userName);
       try{
           swfLogDto = uiWorkFlowAction.holdNode(flowID,logNo,userCode,userName);
          System.out.println(swfLogDto.getHandlerCode()+"|"+swfLogDto.getHandlerName()+"|"+swfLogDto.getHoldNode());
          } catch (SecurityException ex)
       {
     
       } catch (Exception ex){
      out.println("��׽�����쳣");
      ex.printStackTrace() ;
    } finally {   
    
    }
        
   
%>
<%
 
%>

<html>
<title>
��鹤��������ռ�ŵ�����
    
</title>
<form name='fm' method='POST' >

   <input type="hidden" name=checkResult value='<%=swfLogDto.getHoldNode()%>'>
   <input type="hidden" name=userCode value='<%=swfLogDto.getHandlerCode()%>'>
   <input type="hidden" name=userName value='<%=swfLogDto.getHandlerName()%>'>
   <input type="hidden" name=executeResult value='<%=executeResult%>'>
   <input type="hidden" name="userLastAction" class="common" value="">
   <input type="hidden" name="editType" class="common" value="">
   <input type="hidden" name="RegistNo" class="common" value="">
   <input type="hidden" name="ClaimNo" class="common" value="">
 
   //ռ�źͺ�������,ҵ����û�취��Ϊʱ��Ĳ�ͬ��������
  <script language='javascript'>
    var retResult=false;
    var nodeType = <%=nodeType%>
    var bussinessNo=<%=bussinessNo%>
     var bussinessOut=<%=bussinessOut%>
     var nodeStatus=<%=nodeStatus%>;
      
         try
        {
           blnRet =fm.checkResult.value;
	         if (retResult=="false")
	         { 
  	          alert ("�ð����Ѿ�������:'"+otherUserCode+"',����:'"+otherUserName+"'���û���ռ��,��ѡ������������")
           }
           else
           {
	}
            
        }catch(E){
        }
    </script>
   
  
</form>
</html>

