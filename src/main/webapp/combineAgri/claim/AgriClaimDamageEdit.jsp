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
		String conditions = "select * from prpdcode where codecode in (select ss.codecode "+
		    "from prpdcoderisk ss "+
		    "where ss.riskcode = '"+prpLclaimDto.getRiskCode()+"' "+
		      "and ss.codetype = 'DamageCode' )"+
				"and codetype = 'DamageCode' "+
				"and validstatus = '1'";
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList PrpDcodeDtoList = (ArrayList)uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
		String strClassCode = prpLclaimDto.getClassCode();
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
	function showDamageMessageSpan(spanID,leftMove,topMove,index){
		  document.getElementById("span_damageMessage_"+index).style.display = "";
		  var intLeftMove = (leftMove==null?0:leftMove);
		  var intTopMove = (topMove==null?0:topMove);
		  var span = eval(spanID+"_"+index);
		  var spanTop = document.body.offsetHeight;
		  spanTop = spanTop-topMove;
		  span.style.top=document.body.scrollTop+spanTop;
		  span.style.display ='';
		  var eleTdThirdComFlag = document.getElementById("tdThirdComFlag_"+index);
		  eleTdThirdComFlag.style.display="none";
		  var elePrpLclaimClassCode = document.getElementsByName("prpLclaimClassCode_"+index);
		  if(elePrpLclaimClassCode[0].value == "32"){
		  	var eleTdKillQuantity = document.getElementById("tdKillQuantity_"+index);
		  	eleTdKillQuantity.style.display="none";
		  }
	}
	function hideDamageMessageSpan(index){
		document.getElementById("span_damageMessage_"+index).style.display = "none";
		var eleTdThirdComFlag = document.getElementById("tdThirdComFlag_"+index);
		eleTdThirdComFlag.style.display="";
		var elePrpLclaimClassCode = document.getElementsByName("prpLclaimClassCode_"+index);
	    if(elePrpLclaimClassCode[0].value == "32"){
	  	  var eleTdKillQuantity = document.getElementById("tdKillQuantity_"+index);
	  	  eleTdKillQuantity.style.display="";
	    }
	}
	
</script>
<tr>
		<td class="title"><bean:message key="db.prpLclaim.damageName" />:</td>
        <td class="input" <%=strColspan %>>
            <input type=text class="codecode" name="prpLclaimDamageCode_<%=indexMainHead%>"  style="width:15%" title="出险原因" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','1' ,'code','','clear','change');">
           <input type=text class="codecode" name="prpLclaimDamageName_<%=indexMainHead%>"  title="出险原因" style="width:110px" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1' ,'name','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onblur="code_CodeChange(this, 'DamageCode', '-1','name','','clear','change');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
     <%=strTrEnd %>
     <%=strTr %>
	<td class="title">详细出险原因：</td>
	<td class="common" <%=strColspan %>>
		<input type="hidden" name="damageMessageFlag_<%=indexMainHead%>" value="06">
		<%
			String strBr = "";
			String strZ = "";
			if(PrpDcodeDtoList.size() > 15){
				strBr = "<br>";
		%>
			<p><Input name="button_damageMessage_Open_<%=indexMainHead%>" class="button" type="button" value="详细出险原因" alt="详细出险原因" src="/prpall/common/images/butInputCoins.gif"
		          onclick="showDamageMessageSpan('span_damageMessage',0,500,'<%=indexMainHead%>');"></p>
              <span id="span_damageMessage_<%=indexMainHead%>" style="width:520; display:none;position:absolute ;right: 0; background-color:#0000FF;">
			<div style="width:520;height:500;overflow:scroll;">
			<table class="common"  cellspacing="1" cellpadding="5" border="1" style="background-color: #EFF1Fe;border-color: #6495ED">
				<tbody scroll=true >
				<tr class="" >
					<td align="left"  style="background-color: #EFF1Fe;">
			<%	
			}else{
				strZ = "<br>";
			}
			 ArrayList prpLltextDto3 = (ArrayList)request.getAttribute("prpLltextDto3_"+indexMainHead);
			PrpDcodeDto prpDcodeDto = null;
			String strDisabled = "";
			String strCheck = "";
			for(int i=0;i<PrpDcodeDtoList.size() ;i++){
				prpDcodeDto = (PrpDcodeDto)PrpDcodeDtoList.get(i);
					if(prpLltextDto3 != null){
						for(int k=0;k<prpLltextDto3.size();k++){
							PrpLltextDto prpLltextDto = (PrpLltextDto)prpLltextDto3.get(k);
							if(prpLltextDto.getContext().equals(prpDcodeDto.getCodeCode())){
								prpDcodeDto.setFlag("1");
							}
							if(prpLltextDto.getContext().equals("z999")){
								strCheck = "Y";
							}
				%>
					
				<%
						}
						if("SHOW".equals(editType)){
							strDisabled = "disabled";
						}
				%>
						<input type="checkbox" name="damageMessage_<%=indexMainHead%>" value="<%=prpDcodeDto.getCodeCode() %>" <%=(prpDcodeDto.getFlag().equals("1")) ? "checked":"" %> <%=strDisabled %>><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%
					}else{
				%>
					<input type="checkbox" name="damageMessage_<%=indexMainHead%>" value="<%=prpDcodeDto.getCodeCode() %>"><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%						
					}
			}
			%>
			<%
					if("Y".equals(strCheck)){
			%>
					<%=strZ %><input type="checkbox" name="damageMessage_<%=indexMainHead%>" value="z999" checked <%=strDisabled %>> 多种原因混合灾害
			<%
				}else{
			%>
					<%=strZ %><input type="checkbox" name="damageMessage_<%=indexMainHead%>" value="z999"  <%=strDisabled %>>多种原因混合灾害
			<%		
				}
			if(PrpDcodeDtoList.size() > 15){
			%>
					</td>
				</tr>
				<tr>
	                 <td align="center">
	                   <input type="button" name="button_damageMessage_Close_<%=indexMainHead%>" class="button" alt="确定" value="确 定"
	                     onclick="hideDamageMessageSpan('<%=indexMainHead%>');">
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