<%--
****************************************************************************
* DESC       ：机动车辆保险定损报告/明细表打印初始化
* AUTHOR     ：zhulianyu
* CREATEDATE ：2005-11-15
* MODIFYLIST ：   Name       Date            Reason/Contents
--------------------------------------------------------------------------
****************************************************************************
--%>

<%-- 引入bean类部分 --%> 
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.claim.dto.custom.RepairContentDto"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>

<%
   CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
   ArrayList prpLcomponentDtoList   = certainLossDto.getPrpLcomponentDtoList();
   ArrayList prpLrepairfeeDtoList   = certainLossDto.getPrpLrepairFeeDtoList();
   PrpLregistDto  prpLregistDto  = (PrpLregistDto)request.getAttribute("prpLregistDto");
   PrpLthirdPartyDto prpLthirdPartyDto = certainLossDto.getPrpLthirdPartyDto();
   
   int componentSize = 0;
   int repariSize  = 0;
   int maxSize  = 0;
   PrpLcomponentDto prpLcomponentDto =new  PrpLcomponentDto();
   PrpLrepairFeeDto prpLrepairFeeDto = new PrpLrepairFeeDto();
   String registerNo = prpLregistDto.getRegistNo();
   String strLicenseNo   = prpLthirdPartyDto.getLicenseNo();
   String strEngineNo    = prpLthirdPartyDto.getEngineNo();
   String strtFrameNo    = prpLthirdPartyDto.getFrameNo();
   String [] strCompName			  ;   //更换配件名
   String [] dbComQuantity            ;     
   String [] dbComUnitPrice           ;
   String [] dbComSumPrice            ;
   String [] strRepairName            ;
   String [] dbRepairSumFee           ;
   if(prpLcomponentDtoList!=null)
   {
	   componentSize = prpLcomponentDtoList.size();
   }
   if(prpLrepairfeeDtoList!=null)
   {
	   repariSize = prpLrepairfeeDtoList.size();
   }
   if(componentSize>=repariSize)
   {
	   maxSize = componentSize;
   }else
   {
	   maxSize = repariSize;
   }
   strCompName  = new String[maxSize];        //更换配件名
   dbComQuantity  =    new String[maxSize];            
   dbComUnitPrice =    new String[maxSize];       
   dbComSumPrice  =    new String[maxSize];        
   strRepairName  =    new String[maxSize];         
   dbRepairSumFee =    new String[maxSize]; 
   int i=1;
   for(i=0;i<componentSize;i++){
		prpLcomponentDto = (PrpLcomponentDto)prpLcomponentDtoList.get(i);
		strCompName[i] = prpLcomponentDto.getCompName();
		dbComQuantity[i] = new DecimalFormat("#,###").format(prpLcomponentDto.getQuantity());
		dbComUnitPrice[i] = new DecimalFormat("#,##0.00").format(prpLcomponentDto.getMaterialFee());
		dbComSumPrice[i] = new DecimalFormat("#,##0.00").format(prpLcomponentDto.getSumDefLoss());
   }
   for(;i<maxSize;i++){
	   strCompName[i] = "";
	   dbComQuantity[i] = "";
	   dbComUnitPrice[i] = "";
	   dbComSumPrice[i] = "";
   }
   for(i=0;i<repariSize;i++){
		prpLrepairFeeDto = (PrpLrepairFeeDto)prpLrepairfeeDtoList.get(i);
		strRepairName[i] = prpLrepairFeeDto.getCompName();
		dbRepairSumFee[i] = new DecimalFormat("#,##0.00").format(prpLrepairFeeDto.getSumDefLoss());
   }
   for(;i<maxSize;i++){
	    strRepairName[i] = "";
	    dbRepairSumFee[i] = "";
   }
   
   
%>

<%@page import="com.sinosoft.utility.string.Money"%>
<script language="javascript">
  function loadForm()
  {
  
  }
</script>
