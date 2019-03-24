<%--
****************************************************************************
* DESC       ： 新危险单位显示编辑赋值页面
* AUTHOR     ： 国元项目组
* CREATEDATE ： 2011-01-17
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*" %>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
    
 <%-- 给新危险单位界面赋值 --%>
<script language="javascript">
function loadDangerUnit(){
    <%
        List prpLdangerUnitList = (List) request.getAttribute("prpLdangerUnitList");
     	NewDangerUnitDto newDangerUnitDto = null;
     	BLPrpDcode blPrpDcode = new BLPrpDcode();
     	String currencyCode = "";
     	String currencyName = "";
     	String condition = "";
     	
     	for (int z = 1; z <= prpLdangerUnitList.size(); z++) {
     		newDangerUnitDto = (NewDangerUnitDto) prpLdangerUnitList.get(z - 1);
     		currencyCode = newDangerUnitDto.getCurrency();
     		condition = " codecode='" + currencyCode + "' ";
     		currencyName = blPrpDcode.translateNameForUnit(condition);
     %>

		        insertRow('NewDangerUnit','NewDangerUnit_Data');
		        fm.prpLdangerPolicyNo[<%=z %>].value               = '<%=newDangerUnitDto.getPolicyno()%>';
			    fm.prpLdangerRiskCode[<%=z %>].value               = '<%=newDangerUnitDto.getRiskcode() %>';
			    fm.prpLdangerUnitItemKindNo[<%=z %>].value         = '<%=newDangerUnitDto.getItemkindno()%>';
			    fm.prpLdangerDangerNo[<%=z%>].value                = '<%=newDangerUnitDto.getDangerno()%>';
			    <%
			     if(newDangerUnitDto.getDangerdesc()==null){
			    %>
			    	   fm.prpLdangerUnitDangerDesc[<%=z %>].value  = '<%=""%>';
			    <%
			     }else{
			    %>
			           fm.prpLdangerUnitDangerDesc[<%=z %>].value  = '<%=newDangerUnitDto.getDangerdesc()%>';
			    <%
			     }
			    %>
			    <%
			     if(newDangerUnitDto.getAddressname()==null){
			    %>
			    	   fm.prpLdangerUnitAddressName[<%=z %>].value  = '<%=""%>';
			    <%
			     }else{
			    %>
			           fm.prpLdangerUnitAddressName[<%=z %>].value  = '<%=newDangerUnitDto.getAddressname()%>';
			    <%
			     }
			    %>
			    fm.prpLdangerCurrency[<%=z %>].value		       = '<%=newDangerUnitDto.getCurrency()%>';			
			    fm.prpLdangerCurrencyName[<%=z %>].value           = '<%=currencyName%>';
			    fm.prpLdangerUnitSumLoss[<%=z%>].value             = '<%=newDangerUnitDto.getDangerkindAmount()%>';
			    fm.prpLdangerShare[<%=z%>].value                   = '<%=newDangerUnitDto.getDangerkindshare()%>';
			    fm.prpLdangerKindcode[<%=z%>].value                = '<%=newDangerUnitDto.getKindcode()%>';    
			    fm.prpLdangerKindname[<%=z %>].value               = '<%=newDangerUnitDto.getKindname()%>';
			    <%
			     if(newDangerUnitDto.getItemcode()==null){
			    %>
			    	  fm.prpLdangerItemCode[<%=z%>].value          = '<%=""%>';    
			    <%
			     }else{
			    %>  	 
			    	  fm.prpLdangerItemCode[<%=z%>].value           = '<%=newDangerUnitDto.getItemcode()%>';
			   <% 	      
			     }
			     if(newDangerUnitDto.getItemname()==null){
			  	%>
			     	  fm.prpLdangerItemName[<%=z %>].value         = '<%=""%>';
			   <% 	 
			     }else{
			   %> 	 
			    	  fm.prpLdangerItemName[<%=z %>].value          = '<%=newDangerUnitDto.getItemname()%>';
		      <%
	  	          }
     		   }
		      %>
 }
    
  </script>