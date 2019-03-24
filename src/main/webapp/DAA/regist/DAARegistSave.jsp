<!--在不同状态下，    按钮的数量是不同的，-->
 <%-- (1)ADD,EDIT     "暂存" "提交/下一步" "取消"
      (2)SHOW 已提交  "返回"
 --%>

<script language='javascript'>
function printWindow(bizNo,strWindowName,bizType)
      {if(isEmptyField(fm.prpLregistDamageStartDate)){
           alert("出险时间不能为空！");
           return false;
        }else{
	        if(bizType == null ){
	            strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + bizNo; 
	        }else if(bizType == "P"){
	            var reportorName = fm.prpLregistReportorName.value;//报案人
	            var damageStartDate = fm.prpLregistDamageStartDate.value;//出险时间
	            var damageStartHour = fm.prpLregistDamageStartHour.value;//出险小时
	            var licenseNo = fm.prpLthirdPartyLicenseNo[1].value;//号牌号码
	            var mainPolicyNo = fm.mainPolicyNo.value;
	            strUrl = "/claim/DAA/print/DAARegistNoneFormatPrint.jsp?printType=Regist&PolicyNo=" + bizNo + "&bizType=" + bizType ;
	            strUrl += "&damageStartDate=" + damageStartDate;
	            strUrl += "&damageStartHour=" + damageStartHour;  
	            strUrl += "&licenseNo=" + licenseNo
	            strUrl += "&mainPolicyNo=" + mainPolicyNo; 
	        }else{
	            strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + bizNo;
	        }       
	        var pageWidth=screen.availWidth-10;
	        var pageHeight=screen.availHeight-30;
	        
	        if (pageWidth<100 )
	          pageWidth = 100;
	      
	        if (pageHeight<100 )
	          pageHeight = 100;
	      
	        var newWindow = window.open(strUrl,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
	        newWindow.focus();
	        return newWindow;
        }
      }
/*
    //下面这个函数用于提示已超时报案信息
    function info() {
        var date1 = fm.prpLregistDamageStartDate.value;
        var date2 = fm.prpLregistReportDate.value;
        
        var hour1 = parseInt(fm.prpLregistReportHour.value);
        var hour2 = parseInt(fm.prpLregistDamageStartHour.value);
        
        var strValue1 = date1.split(DATE_DELIMITER);
        var strValue2 = date2.split(DATE_DELIMITER);
        var msg = "";
        var sum = (parseInt(strValue2[2]) - parseInt(strValue1[2]))*24 + (hour1-hour2);
        
        if ((parseInt(strValue2[0]) - parseInt(strValue1[0])) > 1) {
           window.alert("请注意：报案时间已超过出险时间48小时。");
        } else if ((parseInt(strValue2[1]) - parseInt(strValue1[1])) > 1) {
           window.alert("请注意：报案时间已超过出险时间48小时。");
        } else if (sum > 48) {
            window.alert("请注意：报案时间已超过出险时间48小时。");
        }
        return true;
    }
*/

function submit1(){
        var vAction = fm.action;
        var vTarget = fm.target;
          fm.action="/claim/common/regist/RegistBeforeQueryEdit.jsp?nodeType=regis";
          fm.submit();
          fm.action=vAction
          fm.target=vTarget
}

</script>

<%  
  String editTypeTemp=request.getParameter("editType");
%>
<table id="buttonArea" cellpadding="5" cellspacing="1" class=common style="display:">
   <tr>
       <input type="hidden" name=buttonSaveType value="1">
       <html:select name="swfPathDto" property="nextNodeNoList" style="width:0px;height:0px" multiple="true" >
            <html:options collection="userSelectList" property="endNodeNo"  labelProperty="endNodeName" />          
       </html:select>  

<%
  if(!editTypeTemp.equals("ADD")){
%>
<%--增加打印报案记录代抄单的按钮即可实现报案记录带抄单从调度到查勘人员 
            <td class="button"  align="center" style="width:30%">
               <input type="button" name="print" class='bigbutton' value="打印报案记录代抄单"  onclick="printWindow('<bean:write name='prpLregistDto' property='registNo'/>', '打印1');">
            </td>--%> 
<%
  }
%>            
<%// 判断是不是为可以修改报案的状态，如是先增加相应的默认下个节点的选项%>
<logic:notEqual name="prpLregistDto" property="status" value="4">

 <td class=button style="width:20%" align="center">
           <!--保存按钮-->
            <input type="button" name=buttonSave class='button' value="暂 存" onclick=" return saveForm(this,'2');">
         </td>
       
<% //判断跳转的条件
  UserDto user = (UserDto) session.getAttribute("user");
  String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
  String comCodeTemp = user.getComCode().substring(0,4);
  System.out.println("------自动跳转判断-----"+strSchedule+"---comCode---"+comCodeTemp+"---index---"+strSchedule.indexOf(comCodeTemp));
  if(strSchedule.indexOf(comCodeTemp)>=0){
    //需要自动跳转  
%>
         <%-- 隐藏所按的保存按钮是哪个的标志--%>
        <input type="hidden" name=nextHandlerCode value="<%=user.getUserCode() %>" >
        <td class=button style="width:20%" align="center">
           <!--保存按钮-->
            <input type="button" name=buttonSave class='button' value="下一步" onclick="return saveForm(this,'4');">
         </td>
<%    
  }else{
    //不需要自动跳转
%>
        <td class=button style="width:20%" align="center"> 
          <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
        </td>
 
         <td class=button style="width:40%" align="center">
           <!--取消按钮-->
           <input type=button name=buttonCancel class='button' value="放弃" onclick=" return submit1();" >
         </td>
<%  
  } 
%> 
        </logic:notEqual> 
                            
        <logic:equal name="prpLregistDto" property="status" value="4">  
<% // 判断是不是显示更新补充说明
  String updateExt=request.getParameter("updateExt");
  if("true".equals(updateExt)){
%>                          
       <td class=button style="width:40%" align="center"> 
         <!--保存按钮-->      
         <%--modify by liujianbo modify 20050316 start--%>
         <%--resson:按钮太小--%>
          <%--<input type="button" name=buttonSave class='bigbutton' value="更新补充说明" onclick="return saveForm(this,'4');">--%>
         <%--modify by liujianbo modify 20050316 end--%>
       </td>
<%
  }
%>   
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="关 闭" onclick="window.close();">
            </td>
<%
  }else{
%>
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="返 回" onclick="history.go(-1);">
          </td>
<%
  }
%>
          </logic:equal>
        </tr>
      </table>