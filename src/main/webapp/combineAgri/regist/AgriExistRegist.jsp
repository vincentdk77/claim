<%--
****************************************************************************
* DESC       ：出险信息画面
* AUTHOR     ： Sinosoft 
* CREATEDATE ： 2004-12-09
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 

<%@ page import="java.util.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpPheadDto" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UIEndorseAction" %>


<%
   String policyNo = (String)request.getAttribute("policyNo_"+idxMain);
   //String curRegistNo = (String)request.getAttribute("curRegistNo_"+idxMain);
   //add by liuyanmei 20051111 start 
   UIEndorseAction uiEndorseAction = new UIEndorseAction();
  
   int checkFlag =0;
   checkFlag = uiEndorseAction.checkStatus(policyNo);
   //取核心系统的地址
   
%>

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
    //var linkURL = "/claim/DAA/certify/DAACertifyViewFile.jsp?businessNo="+registNo+"&display=all";
    var linkURL = "/claim/common/certify/CertifyViewAllFile.jsp?businessNo=" + registNo; 	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   
//modify by liujianbo modify 20050321 end

function hideSubPage2(field,tableName)
{
  var order = parseInt(getElementOrder(field));
  var obj = document.getElementsByName(tableName)[order-1];
  obj.style.display ='none';
}
function buttonOnClick2(strSubPageCode)
{
  showSubPage2(strSubPageCode);

}
function showSubPage2(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //得到事件的坐标x
  var ey=window.event.clientY+document.body.scrollTop;   //得到事件的坐标y

  ex = ex - 520;

  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;

  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
}
function getElementOrder(field)
{
    var i = 0;
    var order = 0;
    var elements = document.getElementsByName(field.name);
    for(i=0;i<elements.length;i++)
    {
        order++;
        if(elements[i]==field)
        {
            break;
        }
    }

    return order;
}
function showEndorse(endorseNo,riskCode){
	  var CoreWebUrl=fm.txtCoreWebUrl.value;
    var linkURL = CoreWebUrl +'/common/pg/UIEndorsePtextShow.jsp?BizNo='+endorseNo;	  
    //var linkURL = '/prpall/'+riskCode+'/tbcbpg/UIPrPoEn'+riskCode+'Show.jsp?BIZTYPE=ENDORSE&zzBizNo='+endorseNo+'&SHOWTYPE=SHOW';	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    

}   
//--> 
</SCRIPT>
<input type=text name="PerilCount_<%=idxMain%>" class="readonly" readonly="true" style="width:50%;text-align='center';color:'#9B009B'" value="<bean:write name='<%=prpLregistDto1%>' property='perilCount' filter='true' />">
<input type="hidden" name="checkFlag_<%=idxMain%>" value="<%=checkFlag %>">
<input title="点击此处可获得已出险相关信息"  type=button ACCESSKEY="." value='...' class="smallbutton" name='button_Peril_Open_Context_<%=idxMain%>' onclick="buttonOnClick('perilInfoShow',fm.policyno_<%=idxMain%>.value,fm.RegistNo_<%=idxMain%>.value,<%=idxMain%>);">
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
        <td class="prompttitle">联系人</td> 
        <td class="prompttitle">操作代码</td>
        <td class="prompttitle">操作人姓名</td> 
        <td class="prompttitle">出险地点</td> 
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
            java.util.ArrayList registClaimDtoList = (java.util.ArrayList) request.getAttribute("registClaimDtoList_"+idxMain);
            
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
          <td class="prompt"><%= registClaimDto.getLinkerName() %></td>
          <td class="prompt"><%= registClaimDto.getOperatorCode() %></td>
          <td class="prompt"><%= registClaimDto.getOperatorName() %></td>
          <td class="prompt"><%= registClaimDto.getDamageAddress() %></td>
          <td class="prompt"><%= registClaimDto.getBrandName() %></td>
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
          <input type=button name = 'button_Peril_Close_Context_<%=idxMain%>' value='(O)关闭' class="button"  ACCESSKEY="O" onclick="hideSubPage(this,'span_Peril_Context_<%=idxMain%>')">  
        </td> 
      </tr>
  </table>        
</span>

<%
   int endorestimes = 0;
   ArrayList prpPheadDtoList = (ArrayList) request.getAttribute("prpPheadDtoList_"+idxMain);
      if (prpPheadDtoList != null) {
            for (int count = 0; count < prpPheadDtoList.size(); count++ ) {
                PrpPheadDto prpPheadDto = (PrpPheadDto) prpPheadDtoList.get(count);
                endorestimes = count + 1;
     }
   }
   if(endorestimes > 0){
%>
<input title="点击此处可获得历次批单相关信息"  type=button ACCESSKEY="." class="button" value='历次批单' name='button_Peril_Open_Context2_<%=idxMain%>' onclick="buttonOnClick2('span_Peril_Context2_<%=idxMain%>');">
<%
   }
%>
    
<span id="span_Peril_Context2_<%=idxMain%>" style='width:800;display:none;position:absolute;background-color:FFFFFF;'> 
  <table  class=common cellpadding="5" cellspacing="1">
      <tr>
       <td class="prompttitle">序号</td>
       <td class="prompttitle">批单号</td>
       <td class="prompttitle">批单生效日期</td>
      </tr> 
    
    
       <%
            //原因：从批改信息表中带出部分信息
            prpPheadDtoList = (ArrayList) request.getAttribute("prpPheadDtoList_"+idxMain);
            
            if (prpPheadDtoList != null) {
            for (int count = 0; count < prpPheadDtoList.size(); count++ ) {
                PrpPheadDto prpPheadDto = (PrpPheadDto) prpPheadDtoList.get(count);
                int sequenceNo = count + 1;
        %>
        <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <%--modify by liujianbo modify 20050321 start--%>
          <%--resson:在报案登记画面中，已出险次数的历次出险事故的清单中,可以点击报案号关联到相关案件信息--%>           
          <td class="prompt"><a href="javascript:showEndorse('<%= prpPheadDto.getEndorseNo() %>','<%=prpPheadDto.getRiskCode()%>')"><%= prpPheadDto.getEndorseNo() %></a></td> 
           <td class="prompt"><%= prpPheadDto.getValidDate() %></td>

        </tr>       
        <%
              }
           }
        %> 
      <tr>  
        <td colspan=14 class="common" >
          <input type=button name = 'button_Peril_Close_Context2_<%=idxMain%>' value='(O)关闭' class="button" ACCESSKEY="O" onclick="hideSubPage2(this,'span_Peril_Context2_<%=idxMain%>')">  
        </td> 
      </tr>
  </table>        
</span>    
    
    