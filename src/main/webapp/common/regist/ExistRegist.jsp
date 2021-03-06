<%--
****************************************************************************
* DESC       ： 出险信息画面
* AUTHOR     ： wangli 
* CREATEDATE ： 2005-05-28
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 

<SCRIPT LANGUAGE="JavaScript">
<!--
//modify by liujianbo modify 20050321 start
//reason:在报案登记画面中，已出险次数的历次出险事故的清单中,可以点击报案号关联到相关案件信息  
/**
 *@description 弹出关联报案信息页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function showRegist(registNo){	       
	     
    var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="+registNo+"&editType=SHOW";	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   
function showPicture(registNo){	    
    var linkURL = "/claim/DAA/certify/DAACertifyViewFile.jsp?businessNo="+registNo+"&display=all";	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   
//modify by liujianbo modify 20050321 end

function showCompensateFee(registNo){	       
	     
    var linkURL = "/claim/uiCompensateFee.do?prpLregistRegistNo="+registNo;	  
    var newWindow = window.open(linkURL,"NewWindow","width=300,height=100,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}  

//已出险次数页面"..."按钮单击事件，用于相同保单号码多报案的显示 add by xuecheng
function buttonOnClickAgriCheck(actionName,policyNo,curRegistNo)
{
  var allPerilCount = document.getElementsByName("PerilCount");
  var sameCount = parseInt(allPerilCount[0].value);
  if (sameCount <1)
  {
  	var buttonPerilOpenContext = document.getElementsByName("button_Peril_Open_Context");
  	buttonPerilOpenContext[0].disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}
//--> 
</SCRIPT>
<input type=text name="PerilCount" class="readonly" readonly="true" style="width:50%;text-align='center';color:'#9B009B'" value="<bean:write name='prpLregistDto1' property='perilCount' filter='true' />">

<input type=button ACCESSKEY="." value='...' name='button_Peril_Open_Context' class="smallbutton" onclick="buttonOnClickAgriCheck('perilInfoShow',fm.policyno.value,fm.registno.value);">
<!--
<logic:present name="prpLclaimDto" property="registNo">
<input type=hidden name="curRegistNo" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
</logic:present>
-->
<span id="span_Peril_Context" style='width:700;display:none;position:absolute;background-color:FFFFFF;'> 
  <table class="prompt" style="width:600">
      <tr class="prompt">
        <td class="prompttitle">序号</td>
        <td class="prompttitle">报案号</td>
        <td class="prompttitle">出险时间</td>
        <!--
        <td class="prompttitle">已决赔款</td> 
        <td class="prompttitle">未决赔款</td>
        -->
        <td class="prompttitle">已决未决赔款显示</td> 
        <td class="prompttitle">案件状态</td>  
        <td class="prompttitle">操作员</td>      
        <!--
        <td class="prompttitle">联系人</td> 
        <td class="prompttitle">操作代码</td>
        <td class="prompttitle">操作人姓名</td> 
        <td class="prompttitle">出险地点</td> 
        <td class="prompttitle">损失部位</td> 
        <td class="prompttitle">案件照片</td> 
        <td class="prompttitle">联系电话</td>   
        <td class="prompttitle">状态</td>  
        -->
      </tr> 
      
      <logic:notEmpty  name="prpLregistDto1"  property="registList"> 
        <logic:iterate id="registItem" name="prpLregistDto1" property="registList">
        <!-- 插入出险次数详细信息-->  
        <tr>        
          <td class="prompt"><bean:write name="registItem" property="serialNo"/></td> 
          <%--modify by liujianbo modify 20050321 start--%>
          <%--resson:在报案登记画面中，已出险次数的历次出险事故的清单中,可以点击报案号关联到相关案件信息--%>           
          <td class="prompt"><a href="javascript:showRegist('<bean:write name='registItem' property='registNo'/>')"><bean:write name='registItem' property='registNo'/></a> </td> 
          <%--modify by liujianbo modify 20050321 end--%>
          <td class="prompt"><bean:write name="registItem" property="damageStartDate"/></td>         
          <td class="prompt"><a href="javascript:showCompensateFee('<bean:write name='registItem' property='registNo'/>')">已决未决赔款显示</a></td>                             
          <td class="prompt"><bean:write name="registItem" property="status"/></td>   
          <td class="prompt"><bean:write name="registItem" property="operatorName"/></td>
          <!--
          <td class="prompt"><bean:write name="registItem" property="linkerName"/></td>
          <td class="prompt"><bean:write name="registItem" property="operatorCode"/></td>
          <td class="prompt"><bean:write name="registItem" property="operatorName"/></td>
          <td class="prompt"><bean:write name="registItem" property="damageAddress"/></td>
          <td class="prompt"><bean:write name="registItem" property="brandName"/></td>
          <td class="prompt"><a href="javascript:showPicture('<bean:write name='registItem' property='registNo'/>')"><bean:write name='registItem' property='registNo'/></a> </td>
          <td class="prompt"><bean:write name="registItem" property="phoneNumber"/></td>
          <td class="prompt"><bean:write name="registItem" property="status"/></td>
          -->
        </tr>        
        </logic:iterate> 
      </logic:notEmpty>           
      <tr>  
        <td colspan=10 class="prompttitle" >
          <input type=button name = 'button_Peril_Close_Context' value='(O)关闭'  class="button" ACCESSKEY="O" onclick="hideSubPage(this,'span_Peril_Context')">  
        </td> 
      </tr>
  </table>        
</span>
    