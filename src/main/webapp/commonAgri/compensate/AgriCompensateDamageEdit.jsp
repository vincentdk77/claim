<%--
****************************************************************************
* DESC       ��ũ�ձ����Ǽ���ϸ����ԭ��
* AUTHOR     ��
* CREATEDATE ��2010-11-1204
                 
****************************************************************************
--%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcodeDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLltextDto" %>

<%
		String damageConditions = "select * from prpdcode where codecode in (select ss.codecode "+
		    "from prpdcoderisk ss "+
		    "where ss.riskcode = '"+prpLcompensateDto.getRiskCode()+"' "+
		      "and ss.codetype = 'DamageCode' )"+
				"and codetype = 'DamageCode' "+
				"and validstatus = '1'";
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList PrpDcodeDtoList = (ArrayList)uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,damageConditions,0,0);
		String strClassCode = prpLcompensateDto.getClassCode();
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
		  if(fm.prpLcompensateClassCode.value == "32"){
		  	tdDeathQuantity.style.display="none";
		  }
	}
	function hideDamageMessageSpan(){
		document.getElementById("span_damageMessage").style.display = "none";
		if(fm.prpLcompensateClassCode.value == "32"){
			tdDeathQuantity.style.display="";
		}
		
	}
	
</script>
<tr>
	<td class="title"> ����ԭ��: </td>
    <td class="input" <%=strColspan %>>
	    <bean:write name='prpLcompensateDto' property='damageCode' filter='true' />
	    <bean:write name='prpLcompensateDto' property='damageName' filter='true' />
    </td>
   <%=strTrEnd %>
   <%=strTr %>
	<td class="title">��ϸ����ԭ��</td>
	<td class="common" <%=strColspan %>>
		<input type="hidden" name="damageMessageFlag" value="06">
		<%
			String strBr = "";
			String strZ = "";
			if(PrpDcodeDtoList.size() > 15){
				strBr = "<br>";
		%>
			<p><Input name="button_damageMessage_Open" class="button" type="button" value="��ϸ����ԭ��" alt="��ϸ����ԭ��" src=""
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
			 ArrayList prpLltextDto3 = (ArrayList)request.getAttribute("prpLltextDto3");
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
				%>
						<input type="checkbox" name="damageMessage" value="<%=prpDcodeDto.getCodeCode() %>" <%=(prpDcodeDto.getFlag().equals("1")) ? "checked":"" %> disabled><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%
					}else{
				%>
					<input type="checkbox" name="damageMessage" value="<%=prpDcodeDto.getCodeCode() %>" disabled><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%						
					}
			}
			%>
			<%
					if("Y".equals(strCheck)){
			%>
					<%=strZ %><input type="checkbox" name="damageMessage" value="z999" checked disabled> ����ԭ�����ֺ�
			<%
				}else{
			%>
					<%=strZ %><input type="checkbox" name="damageMessage" value="z999"  disabled>����ԭ�����ֺ�
			<%		
				}
			if(PrpDcodeDtoList.size() > 15){
			%>
					</td>
				</tr>
				<tr>
	                 <td align="center">
	                   <input type="button" name="button_damageMessage_Close" class="button" alt="ȷ��" value="ȷ ��"
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