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
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcodeDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLltextDto" %>

<%
		PrpLclaimDto  prpLclaimDto1 = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
		String conditions = "select * from prpdcode where codecode in (select ss.codecode "+
		    "from prpdcoderisk ss "+
		    "where ss.riskcode = '"+prpLclaimDto1.getRiskCode()+"' "+
		      "and ss.codetype = 'DamageCode' )"+
				"and codetype = 'DamageCode' "+
				"and validstatus = '1'";
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList PrpDcodeDtoList = (ArrayList)uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
		String strClassCode = prpLclaimDto1.getClassCode();
		String strColspan = "";
		String strTr ="";
		String strTrEnd = "";
		if(strClassCode.equals("31")){
			strColspan = "colspan='3'";
			strTr = "<tr>";
			strTrEnd = "</tr>";
		}
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
	}
	function hideDamageMessageSpan(){
		document.getElementById("span_damageMessage").style.display = "none";
	}
	
</script>
<tr>
		<td class="title"> 出险原因：</td>
	    <td class="title" <%=strColspan %>>
	      <input type="text" name="prpLclaimDamageName"  style="width:380px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"> 
	    </td>
    <%=strTrEnd %>
    <%=strTr %>
	<td class="title">详细出险原因：</td>
	<td class="common" <%=strColspan %>>
		<input type="hidden" name="damageMessageFlag" value="07">
		<%
			String strBr = "";
			String strZ = "";
			if(PrpDcodeDtoList.size() > 15){
				strBr = "<br>";
		%>
			<p><Input name="button_damageMessage_Open" class="button" type="button" value="详细出险原因" alt="详细出险原因" src=""
		          onclick="showDamageMessageSpan('span_damageMessage',0,500);"></p>
              <span id="span_damageMessage" style="width:520; display:none;position:absolute ;right: 0; background-color:#0000FF;">
			<div style="width:520;height:500;overflow:scroll;">
			<table class="common"  cellspacing="1" cellpadding="5" border="1" style="background-color: #EFF1Fe;border-color: #6495ED">
				<tbody scroll=true >
				<tr class="" >
					<td align="left"  style="background-color: #EFF1Fe;">
		<%	
			}else{
				strZ = "<br>";
			}
			ArrayList prpLltextDtoList3 = (ArrayList)request.getAttribute("prpLltextDtoList3");
			PrpDcodeDto prpDcodeDto = null;
			String strDisabled = "";
			String strCheck = "";
			for(int i=0;i<PrpDcodeDtoList.size() ;i++){
				prpDcodeDto = (PrpDcodeDto)PrpDcodeDtoList.get(i);
					if(prpLltextDtoList3 != null){
						for(int k=0;k<prpLltextDtoList3.size();k++){
							PrpLltextDto prpLlTextDto = (PrpLltextDto)prpLltextDtoList3.get(k);
							if(prpLlTextDto.getContext().equals(prpDcodeDto.getCodeCode())){
								prpDcodeDto.setFlag("1");
							}
							if(prpLlTextDto.getContext().equals("z999")){
								strCheck = "Y";
							}
		%>
					
				<%
						}
				%>
						<input type="checkbox" style="" name="damageMessage" value="<%=prpDcodeDto.getCodeCode() %>" <%=(prpDcodeDto.getFlag().equals("1")) ? "checked":"" %> onclick="return false"><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%
					}else{
				%>
					<input type="checkbox" name="damageMessage"  value="<%=prpDcodeDto.getCodeCode() %>" onclick="return false"><%=prpDcodeDto.getCodeCName() %><%=strBr %>
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
