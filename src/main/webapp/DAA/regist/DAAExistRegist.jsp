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

<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.ui.control.action.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<SCRIPT LANGUAGE="JavaScript">
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
    var linkURL = CoreWebUrl+'/common/pg/UIEndorsePtextShow.jsp?BizNo='+endorseNo;	  
    //var linkURL = '/prpall/'+riskCode+'/tbcbpg/UIPrPoEn'+riskCode+'Show.jsp?BIZTYPE=ENDORSE&zzBizNo='+endorseNo+'&SHOWTYPE=SHOW';	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    

}   

</SCRIPT>

<%
 
   //add by liuyanmei 20051111 start 
   //UIEndorseAction uiEndorseAction = new UIEndorseAction();
  
   //int checkFlag =0;
   //checkFlag = uiEndorseAction.checkStatus(policyNo);
   
   String checkFlag = (String)request.getAttribute("checkFlag");
   System.out.println("----批改交验-----"+checkFlag);
  
%>

<input type=text name="PerilCount" class="readonly" readonly="true" style="width:50%;text-align='center';color:'#9B009B'" value="<bean:write name='prpLregistDto1' property='perilCount' filter='true' />">
<input type="hidden" name="checkFlag" value="<%=checkFlag %>">


<%
   int endorestimes = 0;
   ArrayList prpPheadDtoList = (ArrayList) request.getAttribute("prpPheadDtoList");
      if (prpPheadDtoList != null) {
            for (int count = 0; count < prpPheadDtoList.size(); count++ ) {
                PrpPheadDto prpPheadDto = (PrpPheadDto) prpPheadDtoList.get(count);
                endorestimes = count + 1;
     }
   }
   System.out.println("endorestimes= "+endorestimes);
   if(endorestimes > 0){
%>
<input title="点击此处可获得历次批单相关信息"  type=button ACCESSKEY="." class="button" value='历次批单' name='button_Peril_Open_Context2' onclick="buttonOnClick2('span_Peril_Context');" style="display:none">
<%
   }
%>
    
<span id="span_Peril_Context" style='width:800;display:none;position:absolute;background-color:FFFFFF;'> 
  <table  class=common cellpadding="5" cellspacing="1">
      <tr>
       <td class="prompttitle">序号</td>
       <td class="prompttitle">批单号</td>
       <td class="prompttitle">批单生效日期</td>
      </tr> 
    
    
       <%
            //原因：从批改信息表中带出部分信息
            prpPheadDtoList = (ArrayList) request.getAttribute("prpPheadDtoList");
            
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
          <input type=button name = 'button_Peril_Close_Context' value='(O)关闭' class="button" ACCESSKEY="O" onclick="hideSubPage2(this,'span_Peril_Context')">  
        </td> 
      </tr>
  </table>        
</span>    
    
    