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
<%@page import="com.sinosoft.claim.dto.domain.PrpLcheckDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcodeDto" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLregistTextDto" %>

<%	
	PrpLcheckDto  prpLchecktDto1 = (PrpLcheckDto)request.getAttribute("prpLcheckDto_"+idxMain);
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
	
	
</script>
<tr>
	<td class="title" >����ԭ��</td>
        <td class="input">
          <input name="prpLcheckDamageCode_<%=idxMain%>" class="codecode" style="width:20%" maxlength=3 description="����ԭ��" value="<bean:write name='<%=prpLcheckDto%>' property='damageCode'/>"
            ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','post','clear','<%=idxMain%>');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1','code','post','clear','<%=idxMain%>');"
             onchange="code_CodeChange(this, 'DamageCode', '1','code','post','clear','<%=idxMain%>');">
          <input name="prpLcheckDamageName_<%=idxMain%>" class="codename" style="width:20%"  maxlength=20 description="����ԭ��" value="<bean:write name='<%=prpLcheckDto%>' property='damageName'/>"
          ondblclick="code_CodeSelect(this, 'DamageCode','-1' ,'name','post','clear','<%=idxMain%>');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','post','clear','<%=idxMain%>');"
             onchange="code_CodeChange(this, 'DamageCode', '-1','name','post','clear','<%=idxMain%>');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td> 
	<td class="title">��ϸ����ԭ��</td>
	<td class="common">
		<input type="hidden" name="damageMessageFlag_<%=idxMain%>" value="07">
		<%
			String strBr = "";
			String strZ = "";
			//����ԭ����������15��ʱ����ֱ����ʾ����ԭ��
			if(PrpDcodeDtoList.size() > 15){
				strBr = "<br>";
		%>
			<p><Input name="button_damageMessage_Open_<%=idxMain%>" class="button" type="button" value="��ϸ����ԭ��" alt="��ϸ����ԭ��" src="/prpall/common/images/butInputCoins.gif"
		          onclick="showDamageMessageSpan('span_damageMessage_<%=idxMain%>',0,500,'<%=idxMain%>');"></p>
              <span id="span_damageMessage_<%=idxMain%>" style="width:520; display:none;position:absolute;right: 0; background-color:#0000FF;">
			<div style="width:520;height:500;overflow:scroll;">
			<table class="common"  cellspacing="1" cellpadding="5" border="1" style="background-color: #EFF1Fe;border-color: #6495ED">
				<tbody scroll=true >
				<tr class="" >
					<td align="left"  style="background-color: #EFF1Fe;">
			<%	
			}else{
				strZ = "<br>";
			}
			ArrayList prpLregistTextDtoList3 = (ArrayList)request.getAttribute("prpLregistTextDtoList3_"+idxMain);
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
						<input type="checkbox" name="damageMessage_<%=idxMain%>" value="<%=prpDcodeDto.getCodeCode() %>" <%=(prpDcodeDto.getFlag().equals("1")) ? "checked":"" %> <%=strDisabled %>><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%
					}else{
				%>
					<input type="checkbox" name="damageMessage_<%=idxMain%>" value="<%=prpDcodeDto.getCodeCode() %>"><%=prpDcodeDto.getCodeCName() %><%=strBr %>
				<%						
					}
			}
			
			%>
			<%
				if("Y".equals(strCheck)){
			%>
					<%=strZ %><input type="checkbox" name="damageMessage_<%=idxMain%>" value="z999" checked <%=strDisabled %>> ����ԭ�����ֺ�
			<%
				}else{
			%>
					<%=strZ %><input type="checkbox" name="damageMessage_<%=idxMain%>" value="z999"  <%=strDisabled %>>����ԭ�����ֺ�
			<%		
				}
			if(PrpDcodeDtoList.size() > 15){
			%>
					</td>
				</tr>
				<tr>
	                 <td align="center">
	                   <input type="button" name="button_damageMessage_Close_<%=idxMain%>" class="button" alt="ȷ��" value="ȷ ��"
	                     onclick="hideDamageMessageSpan('<%=idxMain%>');">
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