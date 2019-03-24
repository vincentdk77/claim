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
   PrpLregistDto  prpLregistDto  = (PrpLregistDto)request.getAttribute("prpLregistDto");
   PrpLRegistRPolicyDto prpLregistRPolicyNoBz = null;
   String registRPolicyNoBz = "";
   PrpLRegistRPolicyDto prpLregistRPolicyNoBu = null;
   String registRPolicyNoBu = "";
   boolean involveBz = false;
   boolean involveBu = false;
   if(request.getAttribute("prpLregistRPolicyNoBz")!=null)
   {
	   prpLregistRPolicyNoBz  = (PrpLRegistRPolicyDto)request.getAttribute("prpLregistRPolicyNoBz");
	   if(prpLregistRPolicyNoBz!=null)
	   {
		   registRPolicyNoBz = prpLregistRPolicyNoBz.getPolicyNo();
	   }
   }
   if(request.getAttribute("prpLregistRPolicyNoBu")!=null)
   {
	   prpLregistRPolicyNoBu  = (PrpLRegistRPolicyDto)request.getAttribute("prpLregistRPolicyNoBu");
	   if(prpLregistRPolicyNoBu!=null)
	   {
		   registRPolicyNoBu = prpLregistRPolicyNoBu.getPolicyNo();
	   }
   }

   PrpLthirdPartyDto prpLthirdPartyDto = certainLossDto.getPrpLthirdPartyDto();
   ArrayList prpLcomponentDtoList   = certainLossDto.getPrpLcomponentDtoList();
   ArrayList prpLrepairfeeDtoList   = certainLossDto.getPrpLrepairFeeDtoList();
   BLPrpDcode blPrpDcode = new BLPrpDcode();
   
   String strInsuredName = prpLregistDto.getInsuredName();
   String strRegistNo    = prpLregistDto.getRegistNo();
   String strLicenseNo   = prpLthirdPartyDto.getLicenseNo();
   String strBrandName   = prpLthirdPartyDto.getBrandName();
   String strPolicyNo    = prpLregistDto.getPolicyNo();
   String strEngineNo    = prpLthirdPartyDto.getEngineNo();
   String strModelNo     = prpLthirdPartyDto.getModelCode();
   //String strCarKindCode = prpLthirdPartyDto.getCarKindCode();
   //String strCarkindName = blPrpDcode.translateCode("CarKind",strCarKindCode,true);
   String strFrameNo     = prpLthirdPartyDto.getFrameNo();
   Date   reportDate     = prpLregistDto.getReportDate();
   
   String strDamageStartDate = prpLregistDto.getDamageStartDate().toString();
   String strDamageStartHour = prpLregistDto.getDamageStartHour().toString();
   //出险日期
   strDamageStartDate = strDamageStartDate.substring(0,4)+"年"+strDamageStartDate.substring(5,7)+"月"+strDamageStartDate.substring(8,10)
              +"日"+strDamageStartHour.substring(0,2)+"时"+strDamageStartHour.substring(3,5)+"分";
   int componentSize = 0;
   int repariSize  = 0;
   int maxSize  = 0;
   String printMessage = "";
   double sumSumDefLoss = 0;
   double sumRepairDefLoss  = 0;
   double sumLoss  = 0;
   double sumRestFee = 0;
   PrpLcomponentDto prpLcomponentDto =new  PrpLcomponentDto();
   PrpLrepairFeeDto prpLrepairFeeDto = new PrpLrepairFeeDto();
   String [] strCompName			  ;   //更换配件名
   String [] dbComQuantity            ;     
   String [] dbComUnitPrice           ;
   String [] dbComSumPrice            ;
   String [] strRepairName            ;
   String [] dbRepairSumFee           ;    
   boolean involveKindA  = false;
   boolean involveKindB  = false;
   boolean involveKindSub = false;
   String repairFactoryCode = "";
   if(prpLcomponentDtoList!=null)
   {
	   componentSize = prpLcomponentDtoList.size();
	   for(int i=0;i<componentSize;i++)
	   {
		   prpLcomponentDto = (PrpLcomponentDto)prpLcomponentDtoList.get(i);
		   sumSumDefLoss += prpLcomponentDto.getSumDefLoss();
		   sumRestFee += prpLcomponentDto.getRestFee();
		   if("A".equals(prpLcomponentDto.getKindCode()))
		   {
			   involveKindA = true;
		   }else if("B".equals(prpLcomponentDto.getKindCode()))
		   {
			   involveKindB = true;
		   }else if("BZ".equals(prpLcomponentDto.getKindCode())){
			   involveKindB = true;
		   }else if(!"D4".equals(prpLcomponentDto.getKindCode())
				   &&!"D3".equals(prpLcomponentDto.getKindCode())
				   &&!"G".equals(prpLcomponentDto.getKindCode())){
			   involveKindSub = true;
		   }
	   }
   }
   if(prpLrepairfeeDtoList!=null)
   {
	   repariSize = prpLrepairfeeDtoList.size();
	   if(repariSize>0)
	   {
		   prpLrepairFeeDto = (PrpLrepairFeeDto)prpLrepairfeeDtoList.get(0);
		   repairFactoryCode = prpLrepairFeeDto.getRepairFactoryCode();
	   }
	   for(int i=0;i<repariSize;i++)
	   {
		   prpLrepairFeeDto = (PrpLrepairFeeDto)prpLrepairfeeDtoList.get(i);
		   sumRepairDefLoss += prpLrepairFeeDto.getSumDefLoss();
		   if("A".equals(prpLrepairFeeDto.getKindCode()))
		   {
			   involveKindA = true;
		   }else if("B".equals(prpLrepairFeeDto.getKindCode()))
		   {
			   involveKindB = true;
		   }else if("BZ".equals(prpLrepairFeeDto.getKindCode())){
			   involveKindB = true;
		   }else if(!"D4".equals(prpLcomponentDto.getKindCode())
				   &&!"D3".equals(prpLcomponentDto.getKindCode())
				   &&!"G".equals(prpLcomponentDto.getKindCode())){
			   involveKindSub = true;
		   }
	   }
   }
   sumLoss = sumSumDefLoss+sumRepairDefLoss-sumRestFee;
   String strSumLossChina = Money.toChineseMoney(sumLoss,"CNY") ;
   if(componentSize>=repariSize)
   {
	   maxSize = componentSize;
   }else
   {
	   maxSize = repariSize;
   }
   strCompName  = new String[16];        //更换配件名
   dbComQuantity  =    new String[16];            
   dbComUnitPrice =    new String[16];       
   dbComSumPrice  =    new String[16];        
   strRepairName  =    new String[16];         
   dbRepairSumFee =    new String[16]; 
   if(maxSize>13)
   {
	   printMessage = "请见定损报告清单";
	   int i = 0 ;
	   for(i = 0;i<13;i++){
		   strCompName[i] = "";
		   dbComQuantity[i] = "";
		   dbComUnitPrice[i] = "";
		   dbComSumPrice[i] = "";
	   }
	   for(i = 0;i<13;i++){
		   strRepairName[i] = "";
		   dbRepairSumFee[i] = "";
	   }
   }else
   {
	   int i=1;
	   for(i=0;i<componentSize;i++){
		   prpLcomponentDto = (PrpLcomponentDto)prpLcomponentDtoList.get(i);
		   strCompName[i] = prpLcomponentDto.getCompName();
		   dbComQuantity[i] = new DecimalFormat("#,###").format(prpLcomponentDto.getQuantity());
		   dbComUnitPrice[i] = new DecimalFormat("#,##0.00").format(prpLcomponentDto.getMaterialFee());
		   dbComSumPrice[i] = new DecimalFormat("#,##0.00").format(prpLcomponentDto.getSumDefLoss());
	   }
	   for(;i<13;i++){
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
	   for(;i<13;i++){
		   strRepairName[i] = "";
		   dbRepairSumFee[i] = "";
	   }
   }
   
   
%>

<%@page import="com.sinosoft.utility.string.Money"%>
<script language="javascript">
  function loadForm()
  {
  
  }
</script>
