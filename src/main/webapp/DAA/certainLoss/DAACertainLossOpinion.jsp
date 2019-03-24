<%--
****************************************************************************
* DESC       ：
* AUTHOR     ：lijiyuan
* CREATEDATE ：2006-03-09
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               
****************************************************************************
--%>

<%  %>

    <table class="common" cellpadding="5" cellspacing="1" id="Lloss" style="display">
      <tr>         
        <td class="title" style="width:20%" >核损意见：</td>
        <td class="input" style="width:80%" colspan='5'>
        <%
          String nodeTypeO = request.getParameter("nodeType");
    if(  nodeTypeO!=null && !nodeTypeO.equals("") && (nodeTypeO.equals("verif") || nodeTypeO.equals("propv"))){    
  %>                          
            <html:select name='prpLverifyLossDto' property='verifyOpinion' style='width:160px' onclick="change();" onchange="change();">                              
              <html:options collection="verifyOpinionList" property="value" labelProperty="label"/>                  
            </html:select>
  <%
    }else{    
  %>                          
          <input name="verifyOpinion" type='hidden' value="<bean:write name='prpLverifyLossDto' property='verifyOpinion'/>">
          <input name="prpLverifyLossVerifyRemark" type='hidden' value="<bean:write name='prpLverifyLossDto' property='verifyRemark'/>" >
          <logic:notEmpty name='prpLverifyLossDto' property='verifyOpinion'>                        
              <logic:equal name='prpLverifyLossDto' property='verifyOpinion' value="01">                        
                 <input name="verifyOpinionName" class="readOnly" readOnly value="同意定损">
              </logic:equal>   
              <logic:equal name='prpLverifyLossDto' property='verifyOpinion' value="02">                        
                 <input name="verifyOpinionName" class="readOnly" readOnly value="价格异议">
              </logic:equal>   
              <logic:equal name='prpLverifyLossDto' property='verifyOpinion' value="03">                        
                 <input name="verifyOpinionName" class="readOnly" readOnly value="信息不充分">
              </logic:equal>   
              <logic:equal name='prpLverifyLossDto' property='verifyOpinion' value="04">                        
                 <input name="verifyOpinionName" class="readOnly" readOnly value="出具检验报告">
              </logic:equal>   
              <logic:equal name='prpLverifyLossDto' property='verifyOpinion' value="05">                        
                 <input name="verifyOpinionName" class="readOnly" readOnly value="其它">
              </logic:equal>                         
          </logic:notEmpty>                        
          
  <%
    }
  %>   
        </td>                                
      </tr>
   </table>  
