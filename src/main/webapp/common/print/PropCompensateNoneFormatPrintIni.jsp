<%--
****************************************************************************
* DESC       ：财产险赔款计算书打印页面初始化
* AUTHOR     ：hanliang
* CREATEDATE ：2005-12-12
* MODIFYLIST ：   Name       Date            Reason/Contents
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
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@ page import="com.sinosoft.claim.dto.domain.PrpPheadDto" %> 
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>
<%
  //变量声明部分
  String strCompensateNo      = ""; //赔款计算书号
  System.out.println("strCompensateNo = "+strCompensateNo);
  String strClaimNo           = "";   //立案号
  String strPolicyNo          = "";   //保单号
  double dblSumAmount1        = 0;    //保险金额      
  String strKindCode          = "";   //险别代码
  String strCause             = "";   //出险原因
  String strAddress           = "";   //出险地点
  String strDamageAddress     = "";   //出险地点
  String strDamageStartDate   = "";   //出险时间
  String strReportHour        = "";   //出险小时
  String strTextType          = "";
  String strContext           = "";   //赔款计算书文字
  String strContext1 = "";
  String strCountExp          = "";   //赔款计算公式
  String strInsuredDate       = "";  
  String strInsuredName       = "";   //被保险人
  String strInsuredAddress    = "";   //保险财产地址
  String strEndorseNo         = "";   //批单号码

  String strChargeCode        = "";   //
  
  //赔款核定
  double dblJudgeFee          = 0;    //鉴定费
  double dblCheckFee          = 0;    //查勘费
  double dblLawFee            = 0;    //诉讼费
  double dblElseFee           = 0;    //其他费用
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0;    //代查勘费
  double dblAssessFee         = 0;    //公估费
  double dblRescueFee         = 0;    //施救费
  double dblAgentFee          = 0;    //代理费
  double dblGsjzFee			      = 0;	  //共损救助费
  double dblFlFee			        = 0;	  //法律费  
  double dblPropSumLossPay	  = 0;	  //财产损失
  double dblPersonSumLossPay  = 0;	  //人伤损失
  double dblSumLossPay		    = 0;	  //标的赔款
  
  //记入赔款的各项费用
  double dblJudgeFeeRealPay          = 0;    //鉴定费
  double dblCheckFeeRealPay          = 0;    //查勘费
  double dblLawFeeRealPay            = 0;    //诉讼费
  double dblElseFeeRealPay           = 0;    //其他费用
  double dblSumPrePaidRealPay        = 0;    //
  double dblSumRestRealPay           = 0;    //
  double dblCheckFee1RealPay         = 0;    //代查勘费
  double dblAssessFeeRealPay         = 0;    //公估费
  double dblRescueFeeRealPay         = 0;    //施救费
  double dblAgentFeeRealPay          = 0;    //代理费
  double dblGsjzFeeRealPay           = 0;    //共损救助费
  double dblFlFeeRealPay             = 0;    //法律费  
  double dblSumLossPay1              = 0; //标度赔款+记入赔款的费用费用
  
  
  double dblSumLoss          = 0;    //核定损失，保险标的损失
  String strCurrency2        = "";   //核定损失，保险标的损失币别
  String strSumPaid          = "";   //赔款合计格式化
  String strCSumPaid         = "";   //赔款合计大写
  String strSumLossPay		   = "";	 //标的赔款
  String strCSumLossPay	     = "";	 //标的赔款中文
  double dblSumPaid          = 0;    //赔款合计
	String stritemKind         = "";
  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  //对象定义部分
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpLctextDto       prpLctextDto       = null; 
  
  int intCompensateCount = 0;   //CompensateDto对象的记录数
  int intItemCarCount    = 0;   //ItemcarDto对象的记录数
  int intItemKindCount   = 0;   //ItemKindDto对象的记录数
  int intThirdPartyCount = 0;   //ThirdPartyDto对象的记录数
  int intChargeCount     = 0;   //ChargeDto对象的记录数
  int intCtextCount      = 0;   //CtextDto对象的记录数
  int intCtextCountTmp   = 0;   //textarea行数
    
  int index = 0;
  
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  PrpLchargeDto prpLchargeDto = null;
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  
  UIEndorseAction uiEndorseAction = new UIEndorseAction();
  UICodeAction uiCodeAction = new UICodeAction();
  //得到prpLcompensateDto 对象
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  strCompensateNo = prpLcompensateDto.getCompensateNo();
  //得到prpLclaimDto对象
  prpLclaimDto   = claimDto.getPrpLclaimDto();
	
	List itemKindList = new ArrayList();
	itemKindList = (ArrayList)policyDto.getPrpCitemKindDtoList();
	
	stritemKind = ((PrpCitemKindDto)itemKindList.get(0)).getItemDetailName();

  strClaimNo = prpLclaimDto.getClaimNo(); 
  String strApproverCode   = prpLcompensateDto.getApproverCode();   //复核员代码
  String strOperatorCode   = prpLcompensateDto.getOperatorCode();   //操作员代码
  String strApproverName   = uiCodeAction.translateUserCode(strApproverCode,isChinese);  
  String strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese);  
  String strHandlerCode    = prpLcompensateDto.getHandlerCode();    //经办人代码
  String strHandlerName    = uiCodeAction.translateUserCode(strHandlerCode,isChinese);  
  String strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  String strInputDate      = "";  //缮制时间
  String strUnderWriteEndDate = ""; //核赔通过日期
         strInputDate      = prpLcompensateDto.getInputDate().getYear()
                             + "年" + prpLcompensateDto.getInputDate().getMonth()
                             + "月" + prpLcompensateDto.getInputDate().getDate()
                             + "日";
     strUnderWriteEndDate  = prpLcompensateDto.getUnderWriteEndDate().getYear()
                             + "年" + prpLcompensateDto.getUnderWriteEndDate().getMonth()
                             + "月" + prpLcompensateDto.getUnderWriteEndDate().getDate()
                             + "日"; 
  
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();
  PrpCmainDto prpCmainDto    = policyDto.getPrpCmainDto();           //得到保单主表对象 
  strInsuredName    = prpCmainDto.getInsuredName();     //被保险人
  strInsuredAddress = prpCmainDto.getInsuredAddress();  //保险财产地址
  dblSumAmount1     = prpCmainDto.getSumAmount();      //保险金额
  
  String  RiskCode  = "" ;  //保单险种代码
  String  strRiskName = "" ;  //保单险种名称
  RiskCode = prpCmainDto.getRiskCode();//
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
  
  String strPayRefCode = "";
  String strPayRefName = "";
  String strPayRefDate = "";
  String strPayRefNo = "";
  
  BLPrpJpayRefRec blPrpJpayRefRec = new BLPrpJpayRefRec();
  PrpJpayRefRecSchema prpJpayRefRecSchema = new PrpJpayRefRecSchema();
  String strSQL = "certitype = 'C' and certiNo = '" + strCompensateNo + "'";
  blPrpJpayRefRec.query(strSQL);
  if(blPrpJpayRefRec.getSize()>0)
  {
    prpJpayRefRecSchema = blPrpJpayRefRec.getArr(0);
  }
  if(prpJpayRefRecSchema!=null)
  {
    strPayRefNo = prpJpayRefRecSchema.getPayRefNo();
  }
  if(!strPayRefNo.equals("")&&strPayRefNo.length()==21)
  {
    BLPrpJpayRefMainFacade blPrpJpayRefMainFacade = new BLPrpJpayRefMainFacade();
    PrpJpayRefMainDto prpJpayRefMainDto = new PrpJpayRefMainDto();
    String conditions = "PayRefNo = '" + strPayRefNo + "'";
    ArrayList prpJpayRefMainDtoList = new ArrayList();
    prpJpayRefMainDtoList = (ArrayList)blPrpJpayRefMainFacade.findByConditions(conditions);
    if(prpJpayRefMainDtoList!=null)
    {
      prpJpayRefMainDto = (PrpJpayRefMainDto)prpJpayRefMainDtoList.get(0);
      strPayRefCode = prpJpayRefMainDto.getPayRefCode();
      strPayRefDate = "付款日期："
                   +prpJpayRefMainDto.getPayRefDate().getYear()+" 年 "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" 月 "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" 日 ";
    
      strPayRefName =  "付款人："+uiCodeAction.translateUserCode(strPayRefCode,isChinese);
    }
  }
  
  EndorseDto endorseDto = uiEndorseAction.findByConditions(strPolicyNo);//根据保单号得到批单对象
  ArrayList prpPheadDtoList = endorseDto.getPrpPheadDtoList();
  if(prpPheadDtoList!=null && prpPheadDtoList.size()>0){
     PrpPheadDto prpPheadDto = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(0); 
     strEndorseNo = prpPheadDto.getEndorseNo();
  }
  else {
    strEndorseNo="";
  } 
    
  PrpLregistDto  prpLregistDto = registDto.getPrpLregistDto(); //得到报案信息对象
  strDamageAddress    = prpLregistDto.getDamageAddress();
  strDamageStartDate  = prpLregistDto.getDamageStartDate().getYear()
                       + "年" + prpLregistDto.getDamageStartDate().getMonth()
                       + "月" + prpLregistDto.getDamageStartDate().getDate()
                       + "日";
  strReportHour       =  prpLregistDto.getReportHour().toString();

  //得到blPrpCitemCar对象 
/*
  if(policyDto.getPrpCitem_carDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitem_carDtoList().size();
  }  
*/  
  //得到blPrpCitemKind对象的记录数
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
  int indexl = 0;  
  //得到blPrpLcharge对象的记录数
  if(compensateDto.getPrpLchargeDtoList()!=null){
    indexl     = compensateDto.getPrpLchargeDtoList().size();
  }  
  //得到dbPrpLctext对象的记录数  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
	 String strEndMoney =  new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumPrePaid());
	 String strCEndMoney = "";
	 if(prpLcompensateDto.getSumPrePaid() >= 0){
		 strCEndMoney = MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid(),prpLcompensateDto.getCurrency()); 
	 }
	 else{
		 strCEndMoney = "负" + MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid()*-1,prpLcompensateDto.getCurrency()); 
	 }
	 
	 dblSumPaid = prpLcompensateDto.getSumDutyPaid();
	 if(dblSumPaid >= 0){
		 strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());  
	 }
	 else{
		 strCSumPaid     = "负" + MoneyUtils.toChinese(dblSumPaid*-1,prpLcompensateDto.getCurrency());  
	 }
	  

	dblPropSumLossPay = compensateDto.getPrpLcompensateDto().getLossSumRealPay();	  //财产损失
	dblPersonSumLossPay = compensateDto.getPrpLcompensateDto().getPersonLossSumRealPay();	  //人伤损失
	
	
	   
	    

    dblJudgeFee = 0;  
    dblCheckFee = 0;  
    dblLawFee   = 0;  
    dblElseFee  = 0;
    dblCheckFee1 = 0; 
    dblAssessFee = 0; 
    dblRescueFee = 0;

		String MJudgeFee = "CNY";
		String MCheckFee = "CNY";
		String MAssessFee = "CNY";
		String MRescueFee = "CNY";
		String MAgentFee = "CNY";
		String MElseFee = "CNY";
		String MGsjzFee = "CNY";
		String MFlFee = "CNY";
	
	intChargeCount = compensateDto.getPrpLchargeDtoList().size();
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(indexl=0;indexl<intChargeCount;indexl++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(indexl);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 

      if( strChargeCode.equals("07") )       //鉴定费
      {    
        dblJudgeFee += prpLchargeDto.getChargeAmount();
        dblJudgeFeeRealPay += prpLchargeDto.getSumRealPay();
        MJudgeFee =  prpLchargeDto.getCurrency();
      }   
      else if( strChargeCode.equals("06") )  //代查勘费
      {    
        dblCheckFee1 += prpLchargeDto.getChargeAmount();
        dblCheckFee1RealPay += prpLchargeDto.getSumRealPay();
        
      }   
      else if( strChargeCode.equals("05") )  //诉讼费
      {    
        dblLawFee   += prpLchargeDto.getChargeAmount();
        dblLawFeeRealPay += prpLchargeDto.getSumRealPay();
        
      }
      else if( strChargeCode.equals("04") )  //查勘费
      {    
        dblCheckFee += prpLchargeDto.getChargeAmount();
        dblCheckFeeRealPay += prpLchargeDto.getSumRealPay();
        
        MCheckFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("13") )  //公估费
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
        dblAssessFeeRealPay += prpLchargeDto.getSumRealPay();
        MAssessFee  =  prpLchargeDto.getCurrency();
      }   
      else if( strChargeCode.equals("03"))   //施救费
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();
        dblRescueFeeRealPay += prpLchargeDto.getSumRealPay();        
        MRescueFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("09"))   //代理费
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
        dblAgentFeeRealPay += prpLchargeDto.getSumRealPay(); 
        MAgentFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("11"))   //共损救助费
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
        dblGsjzFeeRealPay += prpLchargeDto.getSumRealPay();
        MGsjzFee = prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("15"))   //法律费
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
        dblFlFeeRealPay += prpLchargeDto.getSumRealPay();
        MFlFee = prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("99"))   //其它
      { 
        dblElseFee  += prpLchargeDto.getChargeAmount();
        dblElseFeeRealPay += prpLchargeDto.getSumRealPay();
        MElseFee =  prpLchargeDto.getCurrency();
      }
    }    
    
  }    
 
if (compensateDto.getPrpLlossDtoList()!=null && compensateDto.getPrpLlossDtoList().size()>0){
 
     PrpLlossDto   prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(0);  // 得到赔付标的信息对象
     dblSumLoss         = prpLlossDto.getSumLoss();
     strCurrency2       = prpLlossDto.getCurrency2();
     strCurrency2       = uiCodeAction.translateCurrencyCode(strCurrency2,true);
 }
 
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    // *****赔款计算文字表PrpLctext*****
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if(RiskCode.substring(0,2).equals("11") ||RiskCode.substring(0,2).equals("15") 
      		|| RiskCode.substring(0,2).equals("01") || RiskCode.substring(0,2).equals("03")){
      	if ( strTextType.charAt(0)=='7' )
      	{      
        	strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
      	}
      }else{
      		if ( strTextType.charAt(0)=='1' || strTextType.charAt(0)=='7')
		      {
		        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
		      }
      }
    }    
  }
    //检查计算书文字打出来是几行
    intCtextCountTmp = 0;    //textarea的行数
//    String la="\\";
//    String lala="\\r\\n";

    
    for(index=0;index<strContext.length();index++)
    {
      if(strContext.substring(index,index+1).equals("\\"))
      {
        if(!(strContext.substring(index).length()<4))
        {
          if(strContext.substring(index,index+4).equals("\\r\\n"))
          {
             intCtextCountTmp += 1;    //只要有回车换行，intCtextCountTmp+1
          }
        }
      }
    }
    int x = 0;
    int y = 0;
    if(!(strContext.length()<4))    //如果strContext.length()>=4，判断strContext结尾是文字，还是回车换行
    {
      x = strContext.length()-4;
      y = strContext.length();
      if(!strContext.substring(x,y).equals("\\r\\n"))
      {
         intCtextCountTmp += 1;   
      }
    }
    else    //如果strContext不足1行，intCtextCountTmp = 1; 
      intCtextCountTmp = 1; 
      strContext1 = strContext;
    if( intCtextCountTmp>6 )
    {
    	strContext = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理算过程信息过多，请详见清单。";
    }
    while(strContext.indexOf("\\r\\n")!=-1){
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());
      
    }
    while(strContext1.indexOf("\\r\\n")!=-1){
       strContext1=strContext1.substring(0,strContext1.indexOf("\\r\\n"))+"<br>"+strContext1.substring(strContext1.indexOf("\\r\\n")+"\\r\\n".length());
    }
       dblSumLossPay =  dblPropSumLossPay + dblPersonSumLossPay; //标的赔款
       strSumPaid  = new DecimalFormat("#,##0.00").format(dblSumLossPay+dblRescueFee+dblCheckFee+dblJudgeFee+dblGsjzFee+dblAssessFee+dblFlFee+dblElseFee);
       dblSumLossPay1 = dblSumLossPay+dblRescueFeeRealPay+dblCheckFeeRealPay+dblJudgeFeeRealPay+dblGsjzFeeRealPay+dblAssessFeeRealPay+dblFlFeeRealPay+dblElseFeeRealPay;   //标的赔款
       strSumLossPay = new DecimalFormat("#,##0.00").format(dblSumLossPay1);
	   if(dblSumLossPay1 >= 0){
		   strCSumLossPay = MoneyUtils.toChinese(dblSumLossPay1,prpLcompensateDto.getCurrency());
	   }
	   else{
		   strCSumLossPay = "负" + MoneyUtils.toChinese(dblSumLossPay1*-1,prpLcompensateDto.getCurrency());
	   }
%>

<script language="javascript">
  function loadForm()
  {
    
    // *****赔款计算书表PrpLcompensate*****
    //tdCompensateNo.innerHTML = '<%=strCompensateNo%>';

    // *****立案信息表PrpLclaim*****
    tdPolicyNo.innerHTML     = '<%=strPolicyNo%>';
    //tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    //tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " 年 " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()
                        + " 日";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
<%    
		String a = "prpLclaimDto.getStartDate()==="+prpLclaimDto.getStartDate().getYear();
		System.out.println(a);
    strInsuredDate = "自 " + prpLclaimDto.getStartDate().getYear()
                     + "年" + prpLclaimDto.getStartDate().getMonth()
                     + "月" + prpLclaimDto.getStartDate().getDate()
                     + "日&nbsp;&nbsp;&nbsp;零&nbsp;&nbsp;&nbsp;时起"
                     + "至 " + prpLclaimDto.getEndDate().getYear()
                     + "年" + prpLclaimDto.getEndDate().getMonth()
                     + "月" +prpLclaimDto.getEndDate().getDate()
                     + "日 二十四 时止";
%>   
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';
    tdInsuredName.innerHTML = '<%=strInsuredName%>';
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%>';
    tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
    tdDamageAddress.innerHTML = '<%=strDamageAddress%>';
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>'+'&nbsp;'+'<%=strReportHour.substring(0,2)%>'+'时';
   tdContext.innerHTML = '<%="赔款计算：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strContext%>';
    tdHandlerName.innerHTML = '<%="&nbsp;缮制：<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strHandlerName
                                 +"<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strInputDate%>';
    <%if("1".equals(prpLcompensateDto.getUnderWriteFlag())){%>
    tdUnderWriteName.innerHTML = '<%="&nbsp;核赔人:<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strUnderWriteName
                                 +"<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strUnderWriteEndDate%>';
   <%}%>
    //tdSumLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdSumLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumLossPay)%>';
    
    tdCurrency2.innerHTML ='&nbsp;'+ '<%=strCurrency2%>';
    tdCurrency22.innerHTML = '<%=strCurrency2%>';
    tdClaimNo.innerHTML = '<%=strClaimNo%>';
    //施救费
    //dblRescueFee>0?(new DecimalFormat("#,##0.00").format(dblRescueFee)):(DataUtils.zeroToEmpty(dblRescueFee))
    tdRescueFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblRescueFee)%>';  
	  //查勘费
    tdCheckFee.innerHTML = '&nbsp;' + '<%=new DecimalFormat("#,##0.00").format(dblCheckFee)%>';
    //检验鉴定费
    tdJudgeFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblJudgeFee)%>';
	  //共损救助费
    tdGsjzFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblGsjzFee)%>';
	  //公估费
    tdAssessFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblAssessFee)%>';
	  //法律费
    tdFlFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblFlFee)%>';
    //其它
    tdElseFee.innerHTML  = '&nbsp;' + '<%=new DecimalFormat("#,##0.00").format(dblElseFee)%>';
    
    tdMRescueFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MRescueFee,true)%>';
    tdMCheckFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MCheckFee,true)%>';
    tdMJudgeFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MJudgeFee,true)%>';
    tdMGsjzFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MGsjzFee,true)%>';
    tdMAssessFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MAssessFee,true)%>';
    tdMFlFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MFlFee,true)%>';
    tdMElseFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MElseFee,true)%>';

    //tdAgentFee.innerHTML = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblAgentFee)%>';
    //tdMAgentFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MAgentFee,true)%>';
   
    tdSumPaid.innerHTML = '&nbsp;'+ '<%=strSumPaid%>';
   
 } 
</script>
  