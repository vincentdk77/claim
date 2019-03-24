<%--
****************************************************************************
* DESC       ：出险信息画面
* AUTHOR     ： Sinosoft 
* CREATEDATE ： 2004-12-09
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

//--> 
</SCRIPT>
<input type=text name="PerilCount" class="readonly" readonly="true" style="width:50%;text-align='center';color:'#9B009B'" value="<bean:write name='prpLregistDto1' property='perilCount' filter='true' />">

<input title="点击此处可获得已出险相关信息"  type=button ACCESSKEY="." value='...' class="smallbutton" name='button_Peril_Open_Context' onclick="buttonOnClick('span_Peril_Context');">
<span id="span_Peril_Context" style='width:800;display:none;position:absolute;background-color:FFFFFF;'> 
  <table class="prompt" style="width:400">
      <tr class="prompt">
        <td class="prompttitle">序号</td>
        <td class="prompttitle">报案号</td>
        
        <!--modify by wangwei add start 2005-06-04-->
        <!--原因：在界面上增加一些信息-->
        <td class="prompttitle">立案号</td>
        <td class="prompttitle">估损金额CNY</td>
        <td class="prompttitle">赔付金额CNY</td>
        <!--modify by wangwei add end 2005-06-04-->
        
        <td class="prompttitle">出险时间</td>
        <%--
        <td class="prompttitle">联系人</td> 
        <td class="prompttitle">操作代码</td>
        <td class="prompttitle">操作人姓名</td> 
        --%>
        
        <td class="prompttitle">出险地点</td> 
        <td class="prompttitle">出险原因</td>
        <td class="prompttitle">损失部位</td> 
        <td class="prompttitle">案件照片</td> 
        <td class="prompttitle">联系电话</td>   
        <td class="prompttitle">状态</td>  
      </tr> 
    
    
     <%-- <logic:notEmpty  name="prpLregistDto1"  property="registList"> 
        <logic:iterate id="registItem" name="prpLregistDto1" property="registList">--%>
        <!-- 插入出险次数详细信息-->  
        <%
            //modify by wangwei add start 2005-06-04
            //原因：从立案信息表中带出部分信息
            java.util.ArrayList registClaimDtoList = (java.util.ArrayList) request.getAttribute("registClaimDtoList");
            
            if (registClaimDtoList != null) {
            for (int count = 0; count < registClaimDtoList.size(); count++ ) {
                com.sinosoft.claim.dto.custom.RegistClaimInfoDto registClaimDto = (com.sinosoft.claim.dto.custom.RegistClaimInfoDto) registClaimDtoList.get(count);
                int sequenceNo = count + 1;
        %>
        <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <%--modify by liujianbo modify 20050321 start--%>
          <%--resson:在报案登记画面中，已出险次数的历次出险事故的清单中,可以点击报案号关联到相关案件信息--%>           
          <td class="prompt"><a href="javascript:showRegist('<%= registClaimDto.getRegistNo() %>"><%= registClaimDto.getRegistNo() %></a> </td> 
          <%--modify by liujianbo modify 20050321 end--%>

           <!--modify by wangwei add start 2005-06-04-->
           <!--原因：在界面上增加一些信息-->
           <td class="prompt"><%= registClaimDto.getClaimNo() %></td>
           <td class="prompt"><%= registClaimDto.getSumClaim() %></td>
           <td class="prompt"><%= registClaimDto.getSumPaidShow() %></td>
           <!--modify by wangwei add end 2005-06-04-->
           
          <td class="prompt"><%= registClaimDto.getDamageStartDate() %></td>
          <%--
          <td class="prompt"><%= registClaimDto.getLinkerName() %></td>
          <td class="prompt"><%= registClaimDto.getOperatorCode() %></td>
          <td class="prompt"><%= registClaimDto.getOperatorName() %></td>
           --%>
          <td class="prompt"><%= registClaimDto.getDamageAreaName() %></td>
          <td class="prompt"><%= registClaimDto.getDamageName() %></td>
          <td class="prompt"><%= registClaimDto.getCompName() %></td>
          <td class="prompt"><a href="javascript:showPicture('<%= registClaimDto.getRegistNo() %>')"><%= registClaimDto.getRegistNo() %></a> </td>
          <td class="prompt"><%= registClaimDto.getPhoneNumber() %></td>
          
          <td class="prompt"><%= registClaimDto.getStatus() %></td>
        </tr>       
        <%
              }
            }
            //modify by wangwei add end 2005-06-04
        %> 
       <%-- </logic:iterate> 
      </logic:notEmpty>           --%>
      <tr>  
        <td colspan=14 class="prompttitle" >
          <input type=button name = 'button_Peril_Close_Context' value='(O)关闭'  class="button" ACCESSKEY="O" onclick="hideSubPage(this,'span_Peril_Context')">  
        </td> 
      </tr>
  </table>        
</span>
    