<%@page import="com.sinosoft.claim.dto.domain.PrpLverifyLossDto"%>
<%@ page contentType="text/html; charset=GBK" %>
<table class="common" cellpadding="5" cellspacing="1" id="Lloss" style="display">
      <tr>         
        <td class="title" style="width:20%" >定核损意见：</td>
        <td class="input" style="width:80%" colspan='5'>
        <%
          String nodeTypeO = request.getParameter("nodeType");
        System.err.println("nodeTypeO = "+nodeTypeO);
    if(  nodeTypeO!=null && !nodeTypeO.equals("") && (nodeTypeO.equals("verif") || nodeTypeO.equals("propv"))){    
  %>            
   
  
            <html:select name='prpLverifyLossDto' property='verifyOpinion' style='width:160px' onclick="change();" onchange="change();">                              
              <html:options collection="verifyOpinionList" property="value" labelProperty="label"/>                  
            </html:select>
                
            
         <%--   
            <SELECT onchange=change(); onclick=change(); style="WIDTH: 160px" name="verifyOpinion">
	            <OPTION selected value="01">同意定损</OPTION> 
	            <OPTION value="02">价格异议</OPTION> 
	            <OPTION value="03">信息不充分</OPTION> 
	            <OPTION value="04">出具检验报告</OPTION> 
	            <OPTION value="99">其它</OPTION>
            </SELECT>
           --%>      
  <%
    }else{    
  %>                          
  <%
  PrpLverifyLossDto prpLverifyLossDto1 = (PrpLverifyLossDto)request.getAttribute("prpLverifyLossDto");
  System.err.println("!!!!!!!!!!!!!!!!!!!!!!"+prpLverifyLossDto1.getVerifyOpinion());

  %>
			  <%--
			  <input name="verifyOpinion" type='hidden' value="01">
        	  <input name="verifyOpinionName" class="readOnly" readOnly value="定损完成">
			   --%>
        	  <SELECT style='width:160px'  style="WIDTH: 160px" name="verifyOpinion">
	            <OPTION selected value="01">定损完成</OPTION> 
              </SELECT>
          
  <%
    }
  %>   
        </td>                                
      </tr>
   </table>  