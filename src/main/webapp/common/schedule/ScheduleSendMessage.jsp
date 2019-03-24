<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLregistFacade" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLregistDto" %>
<%@page import="com.sinosoft.claim.bl.facade.BLScheduleFacade" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto" %>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCinsured" %>
<%@page import="com.sinosoft.prpall.schema.PrpCinsuredSchema" %>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDuser" %>
<%@page import="com.sinosoft.utiall.schema.PrpDuserSchema"%>
<%@page import="java.util.*" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLJobLinkerFacade" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLJobLinkerDto" %>
<%@page import="com.sinosoft.utility.SysConfig" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrplareasettingFacade" %>
<%@page import="com.sinosoft.claim.dto.domain.PrplareasettingDto" %>
<%
	String registNo = request.getParameter("registNo");
	BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
	PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
	
	BLScheduleFacade blScheduleFacade = new BLScheduleFacade();
	String isWhere = " registNo = '" + registNo + "'";
	ArrayList blScheduleDtoList = (ArrayList)blScheduleFacade.findByConditions(isWhere);
	PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
	if(blScheduleDtoList.size() > 0){
		prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)blScheduleDtoList.get(0);
	}
	BLPrpCinsured blPrpCinsured = new BLPrpCinsured();
	isWhere = " policyNo = '" + prpLregistDto.getPolicyNo() + "' and insuredflag ='1' ";
	blPrpCinsured.query(isWhere);
	PrpCinsuredSchema prpCinsuredSchema = new PrpCinsuredSchema();
	if(blPrpCinsured.getSize() > 0){
		prpCinsuredSchema = blPrpCinsured.getArr(0);
	}
	//modified by xia begin
	String checkerPhone = "";
	String areaClassCode="99";
	boolean isFalse = false;
	if("05".equals(prpLregistDto.getClassCode())){
		areaClassCode="05";
	}
	BLPrplareasettingFacade blPrplareasettingFacade = new BLPrplareasettingFacade();
	PrplareasettingDto prplareasettingDto = new PrplareasettingDto();
	isWhere = " classcode = '"+areaClassCode+"' and handlercode = '" + prpLscheduleMainWFDto.getNextHandlerCode().trim() + "' ";
	ArrayList PrplareasettingDtoList = (ArrayList)blPrplareasettingFacade.findByConditions(isWhere);
	if(PrplareasettingDtoList.size() > 0){
		prplareasettingDto = (PrplareasettingDto)PrplareasettingDtoList.get(0);
		if(!"".equals(prplareasettingDto.getTel())){
			checkerPhone = prplareasettingDto.getTel().trim();
		}else{
			isFalse = true;
		}
	}
	if(isFalse){
		BLPrpDuser blPrpDuser = new BLPrpDuser();
		isWhere = " userCode ='" + prpLscheduleMainWFDto.getNextHandlerCode() + "'";
		blPrpDuser.query(isWhere);
		PrpDuserSchema prpDuserSchema = new PrpDuserSchema();
		if(blPrpDuser.getSize() > 0){
			prpDuserSchema = blPrpDuser.getArr(0);
			checkerPhone = prpDuserSchema.getMobile().trim();
		}
	}
	//modified by xia end
	
	//查询直接上级核算单位
	BLPrpDcompanyFacade prpDcompany = new BLPrpDcompanyFacade();   
    String upperComCode = prpDcompany.getCenterCode(prpLregistDto.getComCode());
	//转接报案人和对接人
	String staffName0 = "";
	String staffName1 = "";
	String staffPhone0 = "";
	String staffPhone1 = "";
	boolean isDisplay = false;
	BLPrpLJobLinkerFacade blPrpLJobLinkerFacade = new BLPrpLJobLinkerFacade();
	String riskCode = prpLscheduleMainWFDto.getRiskCode();
	String conditions = "";
	Collection<PrpLJobLinkerDto> prpLJobLinkerDtoList = null;
	if("0310".equals(riskCode)||"0312".equals(riskCode)){
	conditions = " classcode = '99' and month='"+prpLscheduleMainWFDto.getInputDate().toString(DateTime.YEAR_TO_MONTH)+"' and handledept='"+prpLscheduleMainWFDto.getScheduleObjectID()+"'" ;
    prpLJobLinkerDtoList = blPrpLJobLinkerFacade.findByConditions(conditions);
	if(prpLJobLinkerDtoList.size()>0){
		Iterator itr = prpLJobLinkerDtoList.iterator();
		while(itr.hasNext()){
			PrpLJobLinkerDto prpLJobLinkerDto = (PrpLJobLinkerDto)itr.next();
			if("0".equals(prpLJobLinkerDto.getStaffPosition())){
				staffName0 = prpLJobLinkerDto.getStaffName();
				staffPhone0 = prpLJobLinkerDto.getStaffPhone();
			}else{
				staffName1 = prpLJobLinkerDto.getStaffName();
				staffPhone1 = prpLJobLinkerDto.getStaffPhone();
			}
		}
		isDisplay = true;
	}
	}else{
	conditions = " classcode = '"+ prpLscheduleMainWFDto.getRiskCode().substring(0,2) +"' and month='"+prpLscheduleMainWFDto.getInputDate().toString(DateTime.YEAR_TO_MONTH)+"' and handledept='"+prpLscheduleMainWFDto.getScheduleObjectID()+"'" ;
    prpLJobLinkerDtoList = blPrpLJobLinkerFacade.findByConditions(conditions);
	if(prpLJobLinkerDtoList.size()>0){
		Iterator itr = prpLJobLinkerDtoList.iterator();
		while(itr.hasNext()){
			PrpLJobLinkerDto prpLJobLinkerDto = (PrpLJobLinkerDto)itr.next();
			if("0".equals(prpLJobLinkerDto.getStaffPosition())){
				staffName0 = prpLJobLinkerDto.getStaffName();
				staffPhone0 = prpLJobLinkerDto.getStaffPhone();
			}else{
				staffName1 = prpLJobLinkerDto.getStaffName();
				staffPhone1 = prpLJobLinkerDto.getStaffPhone();
			}
		}
		isDisplay = true;
	}
	}
%>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
 <script>
 	function sendMessage(){
 		var message = "";
 		if(!fm.checkUserName.checked && !fm.reportorName.checked && !fm.insuredName.checked && !fm.staffName0Flag.checked && !fm.staffName1Flag.checked){
 			alert("请选择短信接收人!");
 			return false;
 		}
 		var Vreportor = true;
 		var Vinsured = true;
 		if(fm.checkUserName.checked){
 			if(fm.checkPhone.value == "" || fm.checkPhone.value == null ){
 				message = message + "查勘人员手机号不能为空!\n";
 			}
 		}
 		if(fm.reportorName.checked){
 			if((fm.reportorPhone.value == "" || fm.reportorPhone.value == null) && Vreportor){
 				message = message + "报案人员手机号不能为空!\n";
 			}
 			
 		}
 		if(fm.insuredName.checked){
 			if((fm.insuredPhone.value == "" || fm.insuredPhone.value == null) && Vinsured){
 				message = message + "被保险人手机号不能为空!\n";
 			}
 		}
 		if(fm.staffName0Flag.checked){
 			if((fm.staffPhone0.value == "" || fm.staffPhone0.value == null) && Vinsured){
 				message = message + "转接报案人手机号不能为空!\n";
 			}
 		}
 		if(fm.staffName1Flag.checked){
 			if((fm.staffPhone1.value == "" || fm.staffPhone1.value == null) && Vinsured){
 				message = message + "对接人手机号不能为空!\n";
 			}
 		}
 		if(message != ""){
 			alert(message);
 			return false;
 		}
 		fm.submit();
 		window.close();
 		
 	}
 	function closeWindow(){
 		window.close();
 	}
 </script>
 <title>短信发送</title>
 <script type="text/javascript">
 	function init(){
 		var inputs = document.getElementsByTagName("input");
 		//for(var i=0;i<inputs.length;i++){
 		//	if(inputs[i].type=="checkbox")
 		//		inputs[i].checked = true;
 		//}
 		<%if(!isDisplay){%>
 		fm.staffName0Flag.checked = false;
 		fm.staffName1Flag.checked = false;
 		var linkerBody = document.getElementById("jobManager_Linker");
 		linkerBody.style.cssText="display:none;";
 		<%}%>
 	}
 </script>
</head>
<body style="background-image: url(/claim/images/Bg.gif);" onload="init();">
	<form  action="/claim/SendMessage.do" name="fm" method="post">
		<table border="1" align="center" cellpadding="0" cellspacing="0" class="common" bordercolor="white">
			<input type="hidden" name="registNo" value="<%=registNo %>">
			<tr>
				<td class="input" style="width: 20%">
					<input type="checkbox" checked name="checkUserName">查勘人员:
				</td>
				<td style="width: 30%">
					<input style="BORDER: #799AE1 1px solid;BACKGROUND-COLOR: #ffffff;color:#000000;"  type="text" name="checkUser1" value="<%=prpLscheduleMainWFDto.getNextHandlerName() %>" >
				</td>
				<td class="input" style="width: 25%">查勘人员手机号:</td>
				<td style="width: 25%">
					<input class="input" type="text" name="checkPhone" value="<%=checkerPhone %>" >
				</td>
			</tr>
			<tr>
				<td class="input" style="width: 20%">
					<input type="checkbox" checked name="reportorName" >报案人员:
				</td>
				<td style="width: 30%">
					<input style="BORDER: #799AE1 1px solid;BACKGROUND-COLOR: #ffffff;color:#000000;" align="right" type="text" name="reportorName1" value="<%=prpLregistDto.getReportorName() %>">
				</td>
				<td class="input" style="width: 25%">报案人员手机号:</td>
				<td style="width: 25%">
					<input class="input" type="text" name="reportorPhone" value="<%=prpLregistDto.getPhoneNumber() %>">
				</td>
			</tr>
			<tr>
				<td class="input" style="width: 20%">
					<input type="checkbox" name="insuredName">被保险人:
				</td>
				<td style="width: 30%"> 
					<input style="BORDER: #799AE1 1px solid;BACKGROUND-COLOR: #ffffff;color:#000000;" align="right" type="text" name="insuredName1" value="<%=prpCinsuredSchema.getInsuredName() %>">
				</td>
				<td class="input" style="width: 25%">被保险人手机号:</td>
				<td style="width: 25%">
					<input class="input" type="text" name="insuredPhone" value="<%=prpCinsuredSchema.getMobile()%>">
				</td>
			</tr>
			<tbody id="jobManager_Linker">
				<tr>
					<td class="input" style="width: 20%">
						<input type="checkbox" checked name="staffName0Flag">转接报案人:
					</td>
					<td style="width: 30%"> 
						<input style="BORDER: #799AE1 1px solid;BACKGROUND-COLOR: #ffffff;color:#000000;" align="right" type="text" name="staffName0" value="<%=staffName0 %>">
					</td>
					<td class="input" style="width: 25%">转接报案人手机号:</td>
					<td style="width: 25%">
						<input class="input" type="text" name="staffPhone0" value="<%=staffPhone0 %>">
					</td>
				</tr>
				<tr>
					<td class="input" style="width: 20%">
						<input type="checkbox" checked name="staffName1Flag">对接人:
					</td>
					<td style="width: 30%"> 
						<input style="BORDER: #799AE1 1px solid;BACKGROUND-COLOR: #ffffff;color:#000000;" align="right" type="text" name="staffName1" value="<%=staffName1 %>">
					</td>
					<td class="input" style="width: 25%">对接人手机号:</td>
					<td style="width: 25%">
						<input class="input" type="text" name="staffPhone1" value="<%=staffPhone1 %>">
					</td>
				</tr>
			</tbody>
			<tr>
				<td align="center" colspan="4" class="input">
					<input class="button" type="button" name="buttonSave" value="确定" onclick="sendMessage()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button" type="button" name="buttonCancel" value="取消" onclick="closeWindow()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>