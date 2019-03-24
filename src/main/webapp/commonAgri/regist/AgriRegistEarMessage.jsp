<%@page import="com.sinosoft.claim.dto.domain.PrpLearDto" %>
<%@page import="com.sinosoft.utility.database.DbPool" %>
<%@page import="com.sinosoft.utility.SysConfig" %>
<%@page import="com.sinosoft.claim.bl.action.domain.BLPrpLearAction" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLearFacade" %>
<%@page import="java.util.*" %>

<%
	String[] strEarNo = request.getParameterValues("prpLearNo");
	String registNo = request.getParameter("prpLregistRegistNo");
	String riskcode = request.getParameter("prpLregistRiskCode");
    String[] arrEarNo;
    String strEarnoIn = "";
	arrEarNo = strEarNo;
	for(int i = 0 ;i < arrEarNo.length; i++){
		strEarnoIn += "'" + arrEarNo[i] + "',";
	}
	strEarnoIn = strEarnoIn.substring(0,strEarnoIn.length()-1);
	
	BLPrpLearFacade blPrpLearFacade = new BLPrpLearFacade();
	Collection earCollection = null;
		earCollection = blPrpLearFacade.checkEarNo(registNo,strEarnoIn);
	
	if(earCollection.size()>0){
%>

			
<html:html>
  <head>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script type="text/javascript">
   function fraInterfaceSubmit(){
   		parent.fraInterface.fm.action="/claim/registSave.do";
   		parent.fraInterface.fm.target="fraInterface";
   		parent.fraInterface.fm.submit();
   }        
   function fraInterfaceCancel(){
       parent.fraInterface.fm.buttonSaveFinishSubmit.disabled = "";
       parent.fraInterface.fm.buttonSave.disabled = "";
   }
  </script>
 <jsp:include page="/common/pub/StaticJavascript.jsp" />
  </head>
  <body >
  <form action="" name="fm" >
  <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title">
   <tr >
    <td align="" colspan="2" style="color:white">
    	以下耳标号已报案,是否继续提交本次报案信息？
    	<input type="hidden" name="riskcode" value="<%=riskcode %>" onblur="fraInterfaceSubmit()" >
    </td>
   </tr>
  <tr>
    <td align="center" class="input">
    	报案号
    </td>
    <td align="center" class="input">
        耳标号
    </td>
     
   </tr>
<%int i = 0;
	for(Iterator iter = earCollection.iterator(); iter.hasNext();){
		PrpLearDto prpLearDto = new PrpLearDto();
		prpLearDto = (PrpLearDto)iter.next();
		String strEardNo = "";
		String strRegistNo = "";
		strEardNo = prpLearDto.getEarNo();
		strRegistNo = prpLearDto.getRegistNo();
%>
  <tr>
     <td>
        <input type="hidden" name="serialNo" value="<%=++i %>" >
     </td>
    <td align="center" class="input">
    <input name="registno" value="<%=strRegistNo %>">
    </td>
    <td align="center" class="input">
       <input name="earNo" value=" <%=strEardNo %>">
    </td>
   </tr>
<%
	}
%>
    </table>
    </form>
  </body>
  
<script>
    var serialNo;
   if(fm.serialNo.value == 1){
        serialNo = 1;
   }else{
   	    serialNo = fm.serialNo.length;
   	}
   window.open("/claim/commonAgri/regist/AgriRegistEarList.jsp?serialNo="+serialNo,'message','width=300,height=250,top=200,left=300,toolbar=0,location=0,directories=0,menubar=0,scrollbars=0,resizable=1,status=0');
</script>
</html:html>
<%			
		}else{
		
%>
<script>
        parent.fraInterface.fm.action="/claim/registSave.do";
   		parent.fraInterface.fm.target="fraInterface";
   		parent.fraInterface.fm.submit();

</script>
<% 
		}
	
	
%>

