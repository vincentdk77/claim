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
	function showDamageMessageSpan(spanID,leftMove,topMove){
		  document.getElementById("span_damageMessage").style.display = "";
		  var intLeftMove = (leftMove==null?0:leftMove);
		  var intTopMove = (topMove==null?0:topMove);
		  var span = eval(spanID);
		  var spanTop = document.body.offsetHeight;
		  spanTop = spanTop-topMove;
		  span.style.top=document.body.scrollTop+spanTop;
		  span.style.display ='';
		  tdThirdComFlag.style.display="none";
		  if(fm.prpLclaimClassCode.value == "32"){
		  	tdKillQuantity.style.display="none";
		  }
	}
	function hideDamageMessageSpan(){
		document.getElementById("span_damageMessage").style.display = "none";
		tdThirdComFlag.style.display="";
		if(fm.prpLclaimClassCode.value == "32"){
		  	tdKillQuantity.style.display="";
		  }
	}
	
</script>
<tr>
		<td class="title"><bean:message key="db.prpLclaim.damageName" />:</td>
        <td class="input" <%=strColspan %>>
            <input type=text class="codecode" name="prpLclaimDamageCode"  style="width:15%" title="����ԭ��" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','1' ,'code','','clear','change');">
           <input type=text class="codecode" name="prpLclaimDamageName"  title="����ԭ��" style="width:110px" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1' ,'name','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onblur="code_CodeChange(this, 'DamageCode', '-1','name','','clear','change');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
          <img src="/claim/images/bgMarkMustInput.jpg">
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
					<%=strZ %><input type="checkbox" name="damageMessage" value="z999" checked <%=strDisabled %>> ����ԭ�����ֺ�
			<%
				}else{
			%>
					<%=strZ %><input type="checkbox" name="damageMessage" value="z999"  <%=strDisabled %>>����ԭ�����ֺ�
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