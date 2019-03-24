<%--
****************************************************************************
* DESC       ： 新危险单位刷新页面
* AUTHOR     ： 国元项目组
* CREATEDATE ： 2011-01-17
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html;charset=gb2312"%>    
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@page import="com.sinosoft.claim.dto.custom.*" %>
<jsp:include page="/common/pub/StaticJavascript.jsp" />

<%	
	List prpdangerUnitList = (List)request.getAttribute("prpdangerUnitList");
	int count = prpdangerUnitList.size();
	NewDangerUnitDto newDangerUnitDto = null;
	BLPrpDcode blPrpDcode = new BLPrpDcode();
	String currencyCode = "";
	String currencyName = "";
	String condition = "";
	String prpLdangerRiskCompensate=(String)request.getAttribute("prpLdangerRiskCompensate");
	String prpLcompensateRiskCode=(String)request.getAttribute("prpLcompensateRiskCode");
%>
	<script>
	//删除多行
       var oTBODY   =  parent.fraInterface.document.all('NewDangerUnit').tBodies.item(0);
	   var intCount =  parent.fraInterface.getRowsCount('NewDangerUnit');
	  for(var i=0;i<intCount;i++)
	  {
	  	oTBODY.deleteRow(0);
	  }
	  //商业性车险理算免赔额分摊
	  var deductibleAall=0;
	  <%if("compensate".equals(prpLdangerRiskCompensate)&&(("0506").equals(prpLcompensateRiskCode)||("0576").equals(prpLcompensateRiskCode)||("0586").equals(prpLcompensateRiskCode))){%>
	    deductibleAall = parseFloat(parent.fraInterface.fm.prpLDeductible.value);
		if(deductibleAall==null||deductibleAall=="")
		    deductibleAall = 0;
		 var prpLcompensateSumPaid=parseFloat(parent.fraInterface.fm.prpLcompensateSumPaid.value);
		 var tempAll=prpLcompensateSumPaid+deductibleAall;
	 <%}%>	    
	 
	 var tempBeforeLast=0;
	</script>

<%
	
	//插入行并赋值
	for(int i=1;i<=count;i++){
		newDangerUnitDto=(NewDangerUnitDto)prpdangerUnitList.get(i-1);
		currencyCode=newDangerUnitDto.getCurrency();
		condition =" codecode='"+currencyCode+"' ";
		currencyName=blPrpDcode.translateNameForUnit(condition);
%>
<script>
                parent.fraInterface.insertRow('NewDangerUnit','NewDangerUnit_Data');
			    parent.fraInterface.fm.prpLdangerPolicyNo[<%=i %>].value                = '<%=newDangerUnitDto.getPolicyno()%>';
			    parent.fraInterface.fm.prpLdangerRiskCode[<%=i %>].value                = '<%=newDangerUnitDto.getRiskcode() %>';
			    parent.fraInterface.fm.prpLdangerDangerNo[<%=i %>].value                = '<%=newDangerUnitDto.getDangerno()%>';
			    parent.fraInterface.fm.prpLdangerUnitItemKindNo[<%=i %>].value          = '<%=newDangerUnitDto.getItemkindno()%>';
			    parent.fraInterface.fm.prpLdangerBusinessNature[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessNature()==null?"":newDangerUnitDto.getBusinessNature()%>';
			    parent.fraInterface.fm.prpLdangerPolicyBizType[<%=i %>].value          = '<%=newDangerUnitDto.getPolicyBizType()==null?"":newDangerUnitDto.getPolicyBizType()%>';
			    parent.fraInterface.fm.prpLdangerPolicyType[<%=i %>].value          = '<%=newDangerUnitDto.getPolicyType()==null?"":newDangerUnitDto.getPolicyType()%>';
			    parent.fraInterface.fm.prpLdangerBusinessType1[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessType1()==null?"":newDangerUnitDto.getBusinessType1()%>';
			    parent.fraInterface.fm.prpLdangerBusinessType[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessType()==null?"":newDangerUnitDto.getBusinessType()%>';
			    parent.fraInterface.fm.prpLdangerOthFlag[<%=i %>].value          = '<%=newDangerUnitDto.getOthFlag()==null?"":newDangerUnitDto.getOthFlag()%>';
			    parent.fraInterface.fm.prpLdangerBusinessProvince[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessProvince()==null?"":newDangerUnitDto.getBusinessProvince()%>';
			    parent.fraInterface.fm.prpLdangerBusinessTown[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessTown()==null?"":newDangerUnitDto.getBusinessTown()%>';
			    parent.fraInterface.fm.prpLdangerBusinessCounty[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessCounty()==null?"":newDangerUnitDto.getBusinessCounty()%>';
			    parent.fraInterface.fm.prpLdangerBusinessAreaName[<%=i %>].value          = '<%=newDangerUnitDto.getBusinessAreaName()==null?"":newDangerUnitDto.getBusinessAreaName()%>';
			    <%
			     if(newDangerUnitDto.getDangerdesc()==null){
			    %>
			    	   parent.fraInterface.fm.prpLdangerUnitDangerDesc[<%=i %>].value  = '<%=""%>';
			    <%
			     }else{
			    %>
			           parent.fraInterface.fm.prpLdangerUnitDangerDesc[<%=i %>].value	= '<%=newDangerUnitDto.getDangerdesc()%>';
			    <%
			     }
			    %>
			    <%
			     if(newDangerUnitDto.getAddressname()==null){
			    %>
			    	   parent.fraInterface.fm.prpLdangerUnitAddressName[<%=i %>].value  = '<%=""%>';
			    <%
			     }else{
			    %>
			           parent.fraInterface.fm.prpLdangerUnitAddressName[<%=i %>].value	= '<%=newDangerUnitDto.getAddressname()%>';
			    <%
			     }
			    %>
			    parent.fraInterface.fm.prpLdangerCurrency[<%=i %>].value		       = '<%=newDangerUnitDto.getCurrency()%>';			
			    parent.fraInterface.fm.prpLdangerCurrencyName[<%=i %>].value           = '<%=currencyName%>';
			  //商业性车险理算免赔额分摊
			    <%if(newDangerUnitDto.getRiskcode().equals("0506")&&newDangerUnitDto.getKindcode().equals("A")&&("compensate".equals(prpLdangerRiskCompensate))){%>
			       if(deductibleAall>0){
			          parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value             = round(<%=newDangerUnitDto.getDangerkindAmount()%>-deductibleAall,2);
			       }else{
			          parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value             = '<%=newDangerUnitDto.getDangerkindAmount()%>';
			       }
			    <%} else if(newDangerUnitDto.getRiskcode().equals("0576")||newDangerUnitDto.getRiskcode().equals("0586")&&("compensate".equals(prpLdangerRiskCompensate))){%>
			    //最后一位分摊减法原则
			        if(deductibleAall>0){
				        if(<%=i%>==<%=count%>){
				            parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value      =round(prpLcompensateSumPaid-tempBeforeLast,2);
				        }else{
				           parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value       = round(<%=newDangerUnitDto.getDangerkindAmount()%>-(deductibleAall*(<%=newDangerUnitDto.getDangerkindAmount()%>/tempAll)),2);
				           tempBeforeLast+=parseFloat(parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value) ;
				        }
			        }else{
			           parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value             = pointTwo(<%=newDangerUnitDto.getDangerkindAmount()%>);
			        }
			    <%}else{%>
			        parent.fraInterface.fm.prpLdangerUnitSumLoss[<%=i%>].value             = pointTwo(<%=newDangerUnitDto.getDangerkindAmount()%>);
			    <%}%>
			    <%
			     if(newDangerUnitDto.getDangerkindshare()==null){
			    %>
			    	   parent.fraInterface.fm.prpLdangerShare[<%=i %>].value  = '<%=""%>';
			    <%
			     }else{
			    %>
			           parent.fraInterface.fm.prpLdangerShare[<%=i %>].value	= '<%=newDangerUnitDto.getDangerkindshare()%>';
			    <%
			     }
			    %>
			    parent.fraInterface.fm.prpLdangerKindcode[<%=i%>].value                = '<%=newDangerUnitDto.getKindcode()%>';    
			    parent.fraInterface.fm.prpLdangerKindname[<%=i %>].value               = '<%=newDangerUnitDto.getKindname()%>';
			    <%
			     if(newDangerUnitDto.getItemcode()==null){
			    %>
			    	 parent.fraInterface.fm.prpLdangerItemCode[<%=i%>].value           = '<%=""%>';    
			    <%
			     }else{
			    	
			    %>
				     parent.fraInterface.fm.prpLdangerItemCode[<%=i%>].value           = '<%=newDangerUnitDto.getItemcode()%>';    
			    <%
			     }
			      if(newDangerUnitDto.getItemname()==null){
			    %>
			         parent.fraInterface.fm.prpLdangerItemName[<%=i %>].value          = '<%=""%>';
			    <%	  
			      }else{
		        %>
		    	     parent.fraInterface.fm.prpLdangerItemName[<%=i %>].value          = '<%=newDangerUnitDto.getItemname()%>';
		    	<%
			      }
			    %>
</script>

<%
		}
	
%>

