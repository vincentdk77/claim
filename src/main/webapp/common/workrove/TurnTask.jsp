<%@ page contentType="text/html; charset=GBK"%> 
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<%--
****************************************************************************
* DESC       ：添加任务转交页面
* AUTHOR     ： zhangjs
* CREATEDATE ： 2011-05-07
* MODIFYLIST ：   Name       Date            Reason/Contents
*               
*          ------------------------------------------------------
****************************************************************************
--%>
<html>
	<head>
	<title>工作转交</title>	
	<META   HTTP-EQUIV="pragma"   CONTENT="no-cache"> 
  	<META   HTTP-EQUIV="Cache-Control"   CONTENT="no-cache,   must-revalidate"> 
 	<META   HTTP-EQUIV="expires"   CONTENT="Wed,   26   Feb   1997   08:21:57   GMT">  

 	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
 	<script src="/claim/common/js/showpage.js"> </script>
   	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<script type="text/javascript">

		var arguments = window.dialogArguments;
		function saveForm(){
			var handleName = fm.handleName.value;
			var handlerName = fm.handlerName.value;
			
			if( null == handleName ||trim(handleName)==''){
				alert("系统提示：\n\n请填写受理机构");	
					return false;
			}
			if(trim(fm.nextHandlerNameID.value)==''){//如果名字被删除了 , 那么代码页应该被删除！
				fm.nextHandlerCodeID.value ="";
			}
			fm.submit();

		}
		function initPage(){
			//1 移除不是当前工作转移的类型！
			var roveSelect = fm.roveType;
			for(var i= roveSelect.options.length -1;i>=0; i--){
				if(roveSelect.options[i].value != fm.roveTypeHidden.value){
					roveSelect.remove(i);
				}
			}

		}
		
		function dealRegistExt(field){
			var who = "";
			if(field.value!=undefined && trim(field.value)!=""){
				who = field.value;
			}
			fm.context.value  = fm.operatorName.value+"在"+
								fm.inputDate.value+" "+
								fm.inputHour.value+"把"+
								fm.taskName.value+"任务转交给"+
								who;
		}
		function delHandleCode(obj){
		  if(trim(obj.value)==''){
		   	fm.handleCode.value='';
		  }
		}
	</script>
<base target="_self" />
</head>
	<%			
		String context = (String) request.getAttribute("context");
		String saveRedirect = (String) request.getAttribute("saveRedirect");
		
		if ("success".equals(saveRedirect)) {
	%>
		<script type="text/javascript">
			var ret = new Array();
			ret[0] = "1";
			ret[1] = '<%=context%>';
			window.returnValue = ret;
			alert("工作转交成功");
			window.close();
		</script>
	<%
		} else if ("error".equals(saveRedirect)) {
			
	%>
	<script type="text/javascript">
			alert("转交失败");
			window.returnValue ="cancle"; 
			window.close();
	 </script>
	<%
		}
		if (saveRedirect != null) {
			return;
		}
		//初始化页面信息
		String str = request.getParameter("codecode");
		String swfLogFlowID = request.getParameter("swfLogFlowID");
		String swfLogLogNo = request.getParameter("swfLogLogNo");
		String registNo = request.getParameter("RegistNo");
		String PolicyNo = request.getParameter("PolicyNo");
		String roveType = request.getParameter("roveType");
		String riskcode = request.getParameter("riskcode");
		String comCode	= request.getParameter("comCode");
		String lossitemCode = request.getParameter("lossitemCode");
		String taskCode = "";
		String taskName ="";
	    taskName= "查勘" ;
	    taskCode= "claim.car.check" ;//得到任务代码

		UserDto user = (UserDto) session.getAttribute("user");
		String now = new Date().toString();
		String nowHour = now.substring(11, 13)+"时"
				+ now.substring(14, 16)+"分";
		//以前的时间不准，换用Java的时间 add by zhangwei 2007-03-22 end
		String time1 = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY).toString();
	//	String time2 = new DateTime(DateTime.current().toString(),
		//		DateTime.YEAR_TO_SECOND).getHour()
		////		+ UtiI18N.getMessage(pageContext, "platform.Hour")
		//		+ new DateTime(DateTime.current().toString(),
			///			DateTime.YEAR_TO_SECOND).getSecond()
			///	+ UtiI18N.getMessage(pageContext, "platform.Minute");
	
	%>
	<body>
	
<form name='fm' action="<%=request.getContextPath()%>/workrove.do" method="post" target="target">  
	<input type="hidden" name="swfLogFlowID" value="<%=swfLogFlowID%>" />
	<input type="hidden" name="swfLogLogNo" value="<%=swfLogLogNo%>" />
	<input type="hidden" name="roveTypeHidden" value="<%=roveType%>" />
	<input type="hidden" name="riskcode" value="<%=riskcode%>">
	<input type="hidden" name="comCode" value="<%=comCode %>" />
	<input type="hidden" name="taskName" value="<%=taskName %>" />
	<input type="hidden" name="taskCode" value="<%=taskCode %>" />
	<input type="hidden" name="lossitemCode" value="<%=lossitemCode %>" />
	
	<table width="90%" id="turnTask" border="1" align="center" cellpadding="0" bordercolor="#3A81C8" cellspacing="0"  class="common">
	<tr>
		<td colspan="6" class="subformtitle" ondblclick="showPage(img1,tab1)"> 
			<img id="img1"  onclick="showPage(this,tab1)" src="/claim/images/butExpandBlue.gif">
			任务转交
		</td>
	</tr>
	<tbody id="tab1">
		<tr>
			<td class="title" style="text-align: left;">报案号:</td>
			<td class="title" style="text-align: left;"><input type="text" class="readonly" readonly="readonly"  name="registNo" value="<%=registNo%>" /></td>
			<td class="title" style="text-align: left">转交类型:</td>
			<td class="title" style="text-align: left">
				查勘转交
			</td>
		</tr>
		<tr>
			<td class="title" style="text-align: left;width:15%">受理机构:</td>
			<td class="input"  style="text-align: left;width:35%">
					<input type=hidden class="codecode" name="handleCode"  num=-1 style="width:20%" title="具体单位" value=""
                     ondblclick="open_CodeSelectWorkRove(this, 'ComCodeByProvinceCode');"
                     onkeyup= "open_CodeSelectWorkRove(this, 'ComCodeByProvinceCode');"
                     onblur="open_CodeSelectWorkRove(this, 'ComCodeByProvinceCode','1','code','post','clear');"  >
                	 <input type=text class="codecode" name="handleName"  title="具体单位" style="width:100%" maxLength="50" description="查勘处理单位" value=""
                     ondblclick = "open_CodeSelectWorkRove(this,'ComCode','查勘转交受理机构');"  onblur= "delHandleCode(this)"/>
			</td>
			<td class="title"  style="text-align: left;width:15%">受理人:</td>
			<td class="input" colspan="3"  style="text-align: left;width:35%">
				<input type="hidden" id="nextHandlerCodeID" name="handlerCode" class="codecode"  style="width:100px" maxlength="10" title="操作员" description="操作员" value=""
                	 onchange="setNewHandlerCode(this);"
                	 ondblclick="open_CodeSelectWorkRove(this, 'CheckPerson');"
                	 onkeyup= "open_CodeSelectWorkRove(this, 'CheckPerson');"
                	 onblur="open_CodeSelectWorkRove(this, 'CheckPerson','1','code','post','clear');"  >
           		 <input type=text id="nextHandlerNameID" name="handlerName" class="codecode" style="width:100%"  title="操作员" maxLength="30" description="操作员" value=""
           	  		ondblclick = "open_CodeSelectWorkRove(this,'TurnPerson','查勘转交受理人');"
                	onblur   = "dealRegistExt(this)">
             </td>
		</tr>

		<tr>
             <td class="title"  style="width:5%">
               转交时间：	
             </td>
             <td class="input"  style="width:14%">
               <input  type="text" name="inputDate" class="readonly" readonly style="width:45%" value="<%=time1%>">
               <input  type="text" name="inputHour" class="readonly" readonly style="width:45%" value="<%=nowHour%>">
             </td>
             <td class="title"  style="width:5%">
               	转交人	
             </td>
             <td class="input"  style="width:8%">
             	<!-- 操作员显示姓名，不显示工号 -->
               <input  type="hidden" name="operatorCode" class="readonly" readonly style="width:90%" value="<%=user.getUserCode()%>">
               <input type="text"  name="operatorName" class="readonly" readonly style="width:90%" value="<%=new UICodeAction().translateUserCode(user.getUserCode(),
							true)%>">
             </td>
          </tr>
          <tr>
			<td class="title">转交描述:</td>
			<td class="sysinput" colspan="6">
				<textarea name="context" title="" class="input" style="width: 400px"></textarea>
		</tr>
	</tbody>
	<table align="center">
	           <tr>
	        	 <td>
					<input type="button" class="button" value="<bean:message key="button.submit.value"/>" onclick="saveForm()">
					<input type="button" class="button" value="放  弃" onclick="window.close();">
					
	        	 </td>
	        	</tr>
	        </table>
</table>
</form>
<iframe name="target" height="0" width="0px" src="" >
</iframe>
</body>
</html>