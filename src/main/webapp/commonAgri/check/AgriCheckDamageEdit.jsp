<%--
****************************************************************************
* DESC       ：农险报案登记详细出险原因
* AUTHOR     ：
* CREATEDATE ：2010-11-1204
                 
****************************************************************************
--%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcheckDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcodeDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLregistTextDto" %>

<%	
	PrpLcheckDto  prpLchecktDto1 = (PrpLcheckDto)request.getAttribute("prpLcheckDto");
		String conditions = "select * from prpdcode where codecode in (select ss.codecode "+
	       "from prpdcoderisk ss "+
	       "where ss.riskcode = '"+prpLchecktDto1.getRiskCode()+"' "+
	         "and ss.codetype = 'DamageCode' )"+
				"and codetype = 'DamageCode' "+
				"and validstatus = '1'";
	UICodeAction uiCodeAction = new UICodeAction();
	ArrayList PrpDcodeDtoList = (ArrayList)uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);

%>
<style>
	span.damageMessageStyle{
		width:520; 
		display:none;
		position:absolute;
		top:; 
		background-color:#0000FF;
	}
	
</style>
<script type="text/javascript">
	function showDamageMessageSpan(spanID,leftMove,topMove){
		  document.getElementById("span_damageMessage").style.display = "";
		  var intLeftMove = (leftMove==null?0:leftMove);
		  var intTopMove = (topMove==null?0:topMove);
		  var span = eval(spanID);
		  var spanTop = document.body.offsetHeight;
		  spanTop = spanTop-topMove;
		  span.style.top=document.body.scrollTop+spanTop;
		  span.style.display ='';
		  tdLossesNumber.style.display="none";
		  tdKillQuantity.style.display="none";
	}
	function hideDamageMessageSpan(){
		document.getElementById("span_damageMessage").style.display = "none";
		tdLossesNumber.style.display="";
		tdKillQuantity.style.display="";
	}
	
</script>
<tr>
	<td class="title" >出险原因：</td>
        <td class="input">
          <input name="prpLcheckDamageCode" class="codecode" style="width:20%" maxlength=3 description="出险原因" value="<bean:write name='prpLcheckDto' property='damageCode'/>"
            ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1','code','post','clear');"
             onchange="code_CodeChange(this, 'DamageCode', '1','code','post','clear');">
          <input name="prpLcheckDamageName" class="codename" style="width:20%"  maxlength=20 description="出险原因" value="<bean:write name='prpLcheckDto' property='damageName'/>"
          ondblclick="code_CodeSelect(this, 'DamageCode','-1' ,'name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DamageCode', '-1','name','post','clear');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td> 
	<td class="title">详细出险原因：</td>
	<td class="common">
		<input type="hidden" name="damageMessageFlag" value="07">
		<%
			String strBr = "";
			String strZ = "";
			//出险原因条数大于15条时，不直接显示出险原因
			if(PrpDcodeDtoList.size() > 15){
				strBr = "<br>";
		%>
			<p><Input name="button_damageMessage_Open" class="button" type="button" value="详细出险原因" alt="详细出险原因" src=""
		          onclick="showDamageMessageSpan('span_damageMessage',0,500);"></p>
              <span id="span_damageMessage" style="width:520; display:none;position:absolute;right: 0; background-color:#0000FF;">
			<div style="width:520;height:500;overflow:scroll;">
			<table class="common"  cellspacing="1" cellpadding="5" border="1" style="background-color: #EFF1Fe;border-color: #6495ED">
				<tbody scroll=true >
				<tr class="" >
					<td align="left"  style="background-color: #EFF1Fe;">
			<%	
			}else{
				strZ = "<br>";
			}
			ArrayList prpLregistTextDtoList3 = (ArrayList)request.getAttribute("prpLregistTextDtoList3");
			PrpDcodeDto prpDcodeDto = null;
			String strDisabled = "";
			String strCheck = "";
			for(int i=0;i<PrpDcodeDtoList.size() ;i++){
				prpDcodeDto = (PrpDcodeDto)PrpDcodeDtoList.get(i);
					if(prpLregistTextDtoList3 != null){
						for(int k=0;k<prpLregistTextDtoList3.size();k++){
							PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList3.get(k);
							if(prpLregistTextDto.getContext().equals(prpDcodeDto.getCodeCode())){
								prpDcodeDto.setFlag("1");
							}
							if(prpLregistTextDto.getContext().equals("z999")){
								strCheck = "Y";
							}
				%>
					
				<%
						}
						if("SHOW".equals(editType)){
							strDisabled = "disabled";
						}
				%>
						<input type="checkbox" name="damageMessage" value="<%=prpDcodeDto.getCodeCode() %>" <%=(prpDcodeDto.getFlag().equals("1")) ? "checked":"" %> <%=strDisabled %>><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%
					}else{
				%>
					<input type="checkbox" name="damageMessage" value="<%=prpDcodeDto.getCodeCode() %>"><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%						
					}
			}
			
			%>
			<%
				if("Y".equals(strCheck)){
			%>
					<%=strZ %><input type="checkbox" name="damageMessage" value="z999" checked <%=strDisabled %>> 多种原因混合灾害
			<%
				}else{
			%>
					<%=strZ %><input type="checkbox" name="damageMessage" value="z999"  <%=strDisabled %>>多种原因混合灾害
			<%		
				}
			if(PrpDcodeDtoList.size() > 15){
			%>
					</td>
				</tr>
				<tr>
	                 <td align="center">
	                   <input type="button" name="button_damageMessage_Close" class="button" alt="确定" value="确 定"
	                     onclick="hideDamageMessageSpan();">
	                 </td>
	            </tr>
	            </tbody>	
			</table>
			</div>
			</span>
	<%
			}
	%>
	         
</tr>