<%--
****************************************************************************
* DESC       ：机动车辆保险赔款计算书打印初始化
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
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
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>

<%
  //变量声明部分
  String strCompensateNo      = request.getParameter("CompensateNo"); //赔款计算书号
  String strClaimNo           = "";   //立案号
  String strRegistNo          = "";   //报案号
  String strPolicyNo          = "";   //保单号
  String strLicenseNo         = "";   //保单中的号牌号码
  String strLicenseColorCode  = "";   //保单中的号牌底色
  String strLicenseNo1        = "";   //理赔车辆信息中的号牌号码
  String strLicenseColorCode1 = "";   //理赔车辆信息中的号牌底色
  String strInsureCarFlag     = "";   //是否为本保单车辆
  String strTextType          = "";
  String strContext           = "&nbsp;计算公式及结果：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";   //赔款计算书文字
  String strContexTtemp       = "&nbsp;计算公式及结果：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";   //赔款计算方式清单中的 赔款计算书文字
  String strContext1          = "";
  String strDamageStartDate   = "";   //出险时间
  String strDamageName        = "";   //出险原因
  String strReportHour        = "";   //出险时间小时
  String strInsuredDate       = "";   //保险期间
  double dblJudgeFee          = 0;    //
  double dblCheckFee          = 0;    //
  double dblLawFee            = 0;    //
  double dblElseFee           = 0;    //
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0; 
  double dblAssessFee         = 0; 
  double dblRescueFee         = 0;    //施救费
  double dblGsjzFee			  = 0;	  //共损求助费
  double dblFlFee			  = 0;	  //法律费
  double dblAgentFee          = 0;    //代理费
  double dblPropSumLossPay	  = 0;	  //财产损失
  double dblPersonSumLossPay  = 0;	  //人伤损失
  double dblSumLossPay	 	  = 0;	  //标的赔款
  String strSumThisPaid       = "";   //
  String strCSumThisPaid      = "";   //
  double dblSumThisPaid       = 0;    //
  String strSumPaid           = "";   //
  String strCSumPaid          = "";   //
  double dblSumPaid           = 0;    //
  String strChargeCode        = "";
  double dblSumAmount1        = 0;    //保险金额    
  double dblSumAmount2        = 0;    //责任限额    
  String strRiskCode          = "";   //险种代码     
  String strKindCode          = "";   //险别代码     
  String strCalculateFlag     = "";   //是否记入保额
  String strMessage           = "";
  String strApproverCode      = "";
  String strOperatorCode      = "";
  String strApproverName      = "";
  String strOperatorName      = "";
  String strLossRate          = "";
  //add begin by zhuly 20051103 
  String strSeatCount         = "";   //座位
  String strTonCount          = "";   //座位数
  String strFrameNo           = "";   //车架号
  String strEngineNo          = "";   //发动机号
  String[] subKindName        = new String[6]; //附加险险别名称
  String[] subKindAmount      = new String[6]; //附加险保额
  String strKindName          = "";  //附加险别
  String strFlag              = "";  //主险附加险标志
  String strKindAmount        = "";  //附加险限额
  String strCarInsuredRelation = "" ; //所属性质代码
  String strCarInsuredRelationName = "";//所属性质
  String strUseNatureCode     = "";  //使用性质
  String strDisplay           = "none";  //赔款计算方式清单的打印标识
  //add end   by zhuly 20051103
 double SumChargeAmount=0;           //所有费用的合计
 //add end by fenglei 20080530
  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  double dblRescueFeeRealPay  = 0;         //记入赔款的 施救费
  double dblCheckFeeRealPay  = 0;          //记入赔款的 查勘费
  double dblJudgeFeeRealPay  = 0;          //记入赔款的 鉴定费
  double dblGsjzFeeRealPay  = 0;           //记入赔款的 共损救助费
  double dblAssessFeeRealPay  = 0;         //记入赔款的 公估费
  double dblFlFeeRealPay  = 0;             //记入赔款的 法律费
  double dblElseFeeRealPay  = 0;           //记入赔款的 其它

  
  //对象定义部分
                                              
  PrpCitemCarDto     prpItemCarDto      = null;   //ItemCarDto对象 
  PrpCitemKindDto    prpItemKindDto     = null;   //保单的ItemKindDto对象
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto对象
  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;
  
  int intCompensateCount = 0;   //CompensateDto对象的记录数
  int intItemCarCount    = 0;   //ItemcarDto对象的记录数
  int intItemKindCount   = 0;   //ItemKindDto对象的记录数
  int intThirdPartyCount = 0;   //ThirdPartyDto对象的记录数
  int intChargeCount     = 0;   //ChargeDto对象的记录数
  int intCtextCount      = 0;   //CtextDto对象的记录数
  int intCtextCountTmp   = 0;   //textarea行数
  int intDriverCount     = 0;   //DriverDto对象的记录数
  int intPropCount       = 0;
  String lossDesc        = "";  //损失程度
    
  int index = 0;
  
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //得到prpLcompensateDto 对象
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //得到prpLclaimDto对象
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  //得到prpLregistDto对象
  prpLregistDto  = registDto.getPrpLregistDto();
  
  strClaimNo = prpLclaimDto.getClaimNo();   
  strOperatorCode   = prpLcompensateDto.getOperatorCode();    
  strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese); 
  DateTime dateTime = new DateTime();
  String strHandlerCode    = prpLcompensateDto.getHandlerCode();    //经办人代码
  String strHandlerName    = uiCodeAction.translateUserCode(strHandlerCode,isChinese);  
  String strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  String strInputDate      = "";                                    //缮制时间
         strInputDate      = prpLcompensateDto.getInputDate().getYear()
                             + "年" + prpLcompensateDto.getInputDate().getMonth()
                             + "月" + prpLcompensateDto.getInputDate().getDate()
                             + "日";
  String strUnderWriteEndDate  = "";    //核赔完成日期
  strUnderWriteEndDate     = prpLcompensateDto.getUnderWriteEndDate().getYear()
                             + "年" + prpLcompensateDto.getUnderWriteEndDate().getMonth()
                             + "月" + prpLcompensateDto.getUnderWriteEndDate().getDate()
                             + "日";   
 
  
  //String strDatteTime = new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR);
  
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
  //得到blPrpCitemCar对象 
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }  
  
  //得到blPrpCitemKind对象的记录数
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
    
  //得到blPrpLthirdParty对象的记录数  
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
    
  //得到blPrpLcharge对象的记录数
  if(compensateDto.getPrpLchargeDtoList()!=null){
    intChargeCount     = compensateDto.getPrpLchargeDtoList().size();
  }  
  //得到dbPrpLctext对象的记录数  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
   PrpCmainDto prpCmainDto    = policyDto.getPrpCmainDto();           //得到保单主表对象 

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
      strPayRefDate = prpJpayRefMainDto.getPayRefDate().getYear()+" 年 "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" 月 "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" 日 ";
    
      strPayRefName = uiCodeAction.translateUserCode(strPayRefCode,isChinese);
    }  
  }

  //得到损失程度描叙
  if (claimDto.getPrpLthirdCarLossDtoList() != null) {
     for(index=0;index<claimDto.getPrpLthirdCarLossDtoList().size();index++){
      PrpLthirdCarLossDto prpLthirdCarLossDto = (PrpLthirdCarLossDto) claimDto.getPrpLthirdCarLossDtoList().get(0);
      lossDesc = prpLthirdCarLossDto.getLossDesc();
      }
  }
%>

<script language="javascript">
  function loadForm()
  {
        
    //赔款计算书表PrpLcompensate
    tdCompensateNo.innerHTML  = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;赔款计算书号：&nbsp;'+'<%=strCompensateNo%>';
    
<%
    dblSumPrePaid   = prpLcompensateDto.getSumPrePaid();  
    dblSumRest      = prpLcompensateDto.getSumRest();     
    dblSumThisPaid  = prpLcompensateDto.getSumThisPaid(); 
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);
    if(dblSumThisPaid < 0){
    	 strCSumThisPaid = "负"+MoneyUtils.toChinese(dblSumThisPaid*-1,prpLcompensateDto.getCurrency());
    }
    else{
    	strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
    }
    
    dblSumPaid      = prpLcompensateDto.getSumPaid();             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    if(dblSumPaid < 0){
    	strCSumPaid = "负"+  MoneyUtils.toChinese(dblSumPaid*-1,prpLcompensateDto.getCurrency()); 
    }
    else{
    	strCSumPaid = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());   
    }
    
    
    dblPropSumLossPay  = prpLcompensateDto.getLossSumRealPay();	  //财产损失
    dblPersonSumLossPay = prpLcompensateDto.getPersonLossSumRealPay();	  //人伤损失
    dblSumLossPay		= dblPropSumLossPay + dblPersonSumLossPay;	  //标的赔款
    String strSumLossPay      = new DecimalFormat("#,##0.00").format(dblSumLossPay);        
    String strCSumLossPay = "";
    if(dblSumLossPay < 0){
    	strCSumLossPay = "负" + MoneyUtils.toChinese(dblSumLossPay*-1,prpLcompensateDto.getCurrency());  
    }
    else{
    	strCSumLossPay     = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
    }
    
    
%>
    //tdSumPrePaid.innerHTML    = '&nbsp;已预付赔款：'                    + '<%=DataUtils.zeroToEmpty(dblSumPrePaid)%>';
    //tdSumRest.innerHTML       = '&nbsp;损余物资/残值金额：'           + '<%=DataUtils.zeroToEmpty(dblSumRest)%>';
    //tdCSumThisPaid.innerHTML  = '&nbsp;本次实付赔款（人民币大写）：'  + '<%=strCSumThisPaid%>';
    //tdSumThisPaid.innerHTML   = '（￥：'                        + '<%=strSumThisPaid%>';
    
    //tdCSumPaid.innerHTML      = '&nbsp;责任赔款（大写）：'      + '<%=strCSumPaid%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥:'+ '<%=strSumPaid%>元';
    
   

    //立案信息表PrpLclaim
    tdPolicyNo.innerHTML     = "<%=strPolicyNo%>";
    tdRiskName.innerHTML     = '<%=strRiskName%>';
    //tdEndorseNo.innerHTML = '<%//=strEndorseNo%>';

    tdPropSumLossPay.innerHTML = '<%=dblPropSumLossPay%>';
    tdPersonSumLossPay.innerHTML = '<%=dblPersonSumLossPay%>';

    
    tdCSumLossPay.innerHTML      = '&nbsp;责任赔款（大写）：'      + '<%=strCSumLossPay%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥:'+ '<%=strSumLossPay%>元';
    tdSSumLossPay.innerHTML      = '&nbsp;'+'<%=strSumLossPay%>';
    

    tdHandlerName.innerHTML      = '<%="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + strHandlerName%>'
    <%if("1".equals(prpLcompensateDto.getUnderWriteFlag())){%>
    tdUnderWriteName.innerHTML = '<%="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + strUnderWriteName%>';                             
	<%}%>
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " 年 " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()
                        + " 日";
    strReportHour      =  prpLregistDto.getReportHour().toString();
    strDamageName      =  prpLregistDto.getDamageName();
	String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>'+'&nbsp;'+'<%=strReportHour.substring(0,2)%>'+'&nbsp;时';
    tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';
    //tdSumClaim.innerHTML        = '<%= lossDesc %>';    
    //tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    //tdDamageAddressType.innerHTML   = '<%=damangeAddressType%>';
   // tdDamageName.innerHTML = '<%=strDamageName%>';
    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    //事故责任
    strCode = ""; 
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getIndemnityDuty());
    strName = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);
%>
    //tdIndemnityDuty.innerHTML     = '<%=strName%>';
    //tdIndemnityDutyRate.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getIndemnityDutyRate())%>'+'％';
<%    
    strInsuredDate = "自 " + prpLclaimDto.getStartDate().getYear()
                     + "年" +prpLclaimDto.getStartDate().getMonth()
                     + "月" + prpLclaimDto.getStartDate().getDate()
                     + "日 零时起"
                     + "至 " + prpLclaimDto.getEndDate().getYear()
                     + "年" + prpLclaimDto.getEndDate().getMonth()
                     + "月" + prpLclaimDto.getEndDate().getDate()
                     + "日 二十四时止";
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    
    //理赔车辆信息PrpLthirdParty 
<%
//获得赔偿限额
  double dblSumAmount3 = 0;
  PrpCitemKindDto prpCitemKindDto = null;
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<policyDto.getPrpCitemKindDtoList().size();index++)
    {
      prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strCalculateFlag = prpCitemKindDto.getCalculateFlag();    
      if( strCalculateFlag.equals("N") ) 
      {
        dblSumAmount3 += prpCitemKindDto.getAmount();
      }
    }    
  }  

	//modify by lixiaohua 20040326 begin reason 赔款计算书厂牌型号打印不出
  if(policyDto.getPrpCitemCarDtoList()!=null){
    for(index=0;index<intItemCarCount;index++)
    { 
        prpItemCarDto       = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
        strLicenseNo        = StringConvert.encode(prpItemCarDto.getLicenseNo());
        strLicenseColorCode = StringConvert.encode(prpItemCarDto.getLicenseColorCode());
        strSeatCount        = ""+prpItemCarDto.getSeatCount();
        strTonCount         = ""+prpItemCarDto.getTonCount();
        strEngineNo         = StringConvert.encode(prpItemCarDto.getEngineNo());
        strFrameNo          = StringConvert.encode(prpItemCarDto.getFrameNo());
        strCarInsuredRelation = StringConvert.encode(prpItemCarDto.getCarInsuredRelation());
        strCarInsuredRelationName = uiCodeAction.translateCodeCode("CarInsuredRelation",strCarInsuredRelation,true);
        strUseNatureCode    = StringConvert.encode(prpItemCarDto.getUseNatureCode());
        if(strUseNatureCode.equals("1")||strUseNatureCode.equals("2")||strUseNatureCode.equals("3"))
        {
            strUseNatureCode = "非营业";//非营业
        }
        else
        {
            strUseNatureCode = "营业";//营业
        }
%>
        tdUseNatureCode.innerHTML = '<%=strUseNatureCode%>';
        tdLicenseNo.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getLicenseNo())%>';       
        tdBrandName.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getBrandName())%>';
        tdCarInsuredRelationName.innerHTML = '<%=strCarInsuredRelationName%>';
        tdSeatTonCount.innerHTML = '<%=strSeatCount+"座/"+strTonCount+"吨"%>';  
        tdEngineNo.innerHTML     = '<%=StringConvert.encode(prpItemCarDto.getEngineNo())%>';
        tdFrameNo.innerHTML      = '<%=StringConvert.encode(prpItemCarDto.getFrameNo())%>'; 
     
<%
        //条款类别
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpItemCarDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
<%
    }    
  }      

  if(policyDto.getPrpCitemCarDtoList()!=null){
    //机动车险标的信息表PrpCitemCar   
    for(index=0;index<intItemCarCount;index++)
    {
      prpItemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo1 = StringConvert.encode(prpItemCarDto.getLicenseNo()); 
           
      if( strLicenseNo1.equals(strLicenseNo) )
      {    
%>        
        //tdPurchasePrice.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpItemCarDto.getPurchasePrice())%>';
<%
      }
    }
  }  
    
    //标的子险信息PrpTitemKind
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
     int tempindex = 0 ;  //定义临时变量
    for(index=0;index<intItemKindCount;index++)
    {
      
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //add begin by zhuly 20051103 reason:增加子信息
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();
      //add end by zhuly 20051103
      //strRiskCode = prpItemKindDto.getRiskCode();
      //strKindCode = prpItemKindDto.getKindCode();
      //dbPrpDkind.getInfo(strRiskCode,strKindCode);
      //strCalculateFlag = dbPrpDkind.getCalculateFlag().substring(0,2);
      strCalculateFlag = prpItemKindDto.getCalculateFlag();    
      //strCalculateFlag="Y1";
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("A"))//主险车损保险 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("B"))//主险三者保险
      {
        dblSumAmount2 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("2")&&tempindex<6)//附加险
      {
        subKindName[tempindex] = strKindName;
        subKindAmount[tempindex] = ""+new DecimalFormat("#,##0.00").format(prpItemKindDto.getAmount());  
   %>
      //<%="tdKindName"+tempindex%>.innerHTML = '<%=subKindName[tempindex]%>'; 
      //<%="tdKindAmount"+tempindex%>.innerHTML = '<%=subKindAmount[tempindex]%>';              
   <%
        tempindex ++;
      }      
    }    
  }  

%>
    //tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount3)%>'; 
    //tdDeductibleRate.innerHTML = '<%=prpItemKindDto.getDeductibleRate()%>'+'％';   
<%    
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //赔款计算文字表PrpLctext
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' || strTextType.charAt(0)=='7')
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
        strContexTtemp = strContexTtemp + StringConvert.toHTMLFormat(prpLctextDto.getContext()) ;
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
    	strDisplay = "";
    }
    while(strContext.indexOf("\\r\\n")!=-1){
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>&nbsp;"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());
    }
    while(strContext1.indexOf("\\r\\n")!=-1){
        strContext1=strContext1.substring(0,strContext1.indexOf("\\r\\n"))+"<br>&nbsp;"+strContext1.substring(strContext1.indexOf("\\r\\n")+"\\r\\n".length());
     }
%>  
   tdContext.innerHTML = '<%=strContext%>';
<%    
    //赔款费用信息表PrpLcharge  
    dblJudgeFee = 0;  //鉴定费
    dblCheckFee = 0;  //查勘费
    dblLawFee   = 0;  //诉讼费
    dblElseFee  = 0;  //其它
    dblCheckFee1 = 0; //代查费
    dblAssessFee = 0; //公估费
    dblRescueFee = 0; //施救费
    dblGsjzFee = 0 ;  //公损救助费
    dblFlFee = 0 ;	  //法律费
    double dblfee28 = 0;//间接理赔费用
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 
       SumChargeAmount += prpLchargeDto.getChargeAmount();
      if( strChargeCode.equals("07") )       //鉴定费dblJudgeFee
      {    
        dblJudgeFee += prpLchargeDto.getChargeAmount();
        dblJudgeFeeRealPay += prpLchargeDto.getSumRealPay();
      }   
      else if( strChargeCode.equals("06") )  //代查勘费
      {    
        dblCheckFee1 += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("05") )  //诉讼费
      {    
        dblLawFee   += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("04") )  //查勘费dblCheckFee
      {    
        dblCheckFee += prpLchargeDto.getChargeAmount();
        dblCheckFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if( strChargeCode.equals("13") )  //公估费dblAssessFee
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
        dblAssessFeeRealPay += prpLchargeDto.getSumRealPay();
      }   
      else if( strChargeCode.equals("03"))   //施救费dblRescueFee
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();    
        dblRescueFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if( strChargeCode.equals("09"))   //代理费
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("11"))   //共损救助费dblGsjzFee
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
        dblGsjzFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if( strChargeCode.equals("15"))   //法律费dblFlFee
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
        dblFlFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if(strChargeCode.equals("28"))
      {
        dblfee28  += prpLchargeDto.getChargeAmount();
      }
//      else if( strChargeCode.equals("99"))   //其它dblElseFee
//      { 
//        dblElseFee  += prpLchargeDto.getChargeAmount();
//      }
//      else                                   //其他费用
//     {    
//        dblElseFee  += prpLchargeDto.getChargeAmount();
//      }   
    } 
    dblElseFee = SumChargeAmount - (dblRescueFee+dblCheckFee+dblJudgeFee+dblAssessFee+dblFlFee);
  }
  strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid-dblfee28);        
%>    
	//检验鉴定费
    tdJudgeFee.innerHTML = '&nbsp;' + '<%=dblJudgeFee>0?(new DecimalFormat("#,##0.00").format(dblJudgeFee)):(DataUtils.zeroToEmpty(dblJudgeFee))%>';
    
    //查勘费    
    tdCheckFee.innerHTML = '&nbsp;' + '<%=dblCheckFee>0?new DecimalFormat("#,##0.00").format(dblCheckFee):DataUtils.zeroToEmpty(dblCheckFee)%>';
    
    //待查费
    //tdCheckFee1.innerHTML = '&nbsp;' + '<%=dblCheckFee1>0?(new DecimalFormat("#,##0.00").format(dblCheckFee1)):(DataUtils.zeroToEmpty(dblCheckFee1))%>';
    
    //诉讼费
    //tdLawFee.innerHTML = '&nbsp;' + '<%=dblLawFee>0?new DecimalFormat("#,##0.00").format(dblLawFee):DataUtils.zeroToEmpty(dblLawFee)%>';
    
    //法律费
    tdFlFee.innerHTML = '&nbsp;' + '<%=dblFlFee>0?new DecimalFormat("#,##0.00").format(dblFlFee):DataUtils.zeroToEmpty(dblFlFee)%>';
    
    //共损救助费
    tdGsjzFee.innerHTML = '&nbsp;' + '<%=dblGsjzFee>0?new DecimalFormat("#,##0.00").format(dblGsjzFee):DataUtils.zeroToEmpty(dblGsjzFee)%>';

    
	//其它    
    tdElseFee.innerHTML = '&nbsp;' + '<%=dblElseFee>0?(new DecimalFormat("#,##0.00").format(dblElseFee)):(DataUtils.zeroToEmpty(dblElseFee))%>';

    //公估费
    tdAssessFee.innerHTML = '&nbsp;' + '<%=dblAssessFee>0?new DecimalFormat("#,##0.00").format(dblAssessFee):DataUtils.zeroToEmpty(dblAssessFee)%>';
    
	//施救费
    tdRescueFee.innerHTML = '&nbsp;' + '<%=dblRescueFee>0?new DecimalFormat("#,##0.00").format(dblRescueFee):DataUtils.zeroToEmpty(dblRescueFee)%>';

	//代理费
    //tdAgentFee.innerHTML = '&nbsp;'   + '<%=DataUtils.zeroToEmpty(dblAgentFee)%>';
    //有效保险金额
    tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    
    //保险金额
    tdOldSumAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainOriginDto().getSumAmount())%>';
    
    
    //出险地点
    tdDamageAddress.innerHTML = '<%=prpLclaimDto.getDamageAddress() %>';
    
    //保险标的
    <%
    String itemName = "";
    if( compensateDto.getPrpLlossDtoList() != null && compensateDto.getPrpLlossDtoList().size() > 0){
    	PrpLlossDto prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(0);
    	itemName = prpLlossDto.getLossName();
    }
    %>
    tdLossName.innerHTML = '<%= itemName%>';
    
    //实赔金额
    tdtSumThisPaid.innerHTML = '<%= compensateDto.getPrpLcompensateDto().getSumThisPaid()%>';
    
    //
    tdPayDate.innerHTML = '<%=strUnderWriteEndDate%>';
    
    tdClaimNo.innerHTML = '&nbsp;'   + '<%=strClaimNo%>';
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>';

<%  
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);
	if(dblSumThisPaid < 0){
		strCSumThisPaid = "负" + MoneyUtils.toChinese(dblSumThisPaid*-1,prpLcompensateDto.getCurrency());
	}
	else{
		 strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
	}
   
%>    
    //tdCSumThisPaid.innerHTML  = '&nbsp;本次实付赔款（人民币大写）：'  + '<%=strCSumThisPaid%>';    
    //tdSumThisPaid.innerHTML   = '（￥：'                        + '<%=strSumThisPaid%>';
<%    
    //*****车辆信息表PrpLdriver*****  
    if(registDto.getPrpLdriverDtoList() != null){    
    intDriverCount = registDto.getPrpLdriverDtoList().size();
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(index) ;

%>        
        //tdDriverName.innerHTML         = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        //tdDriverName1.innerHTML         = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        
<%  
   }  
   }
%> 
<%
  String claimType = prpLregistDto.getClaimType();
  String strClaimType = uiCodeAction.translateCodeCode("CaseCode",claimType,true);
  String handleUnit = prpLregistDto.getHandleUnit();
  String strHandleUnit = uiCodeAction.translateCodeCode("HandleUnit",handleUnit,true);
%>
    //tdClaimType.innerHTML = '<%=strClaimType%>';
    //tdHandleUnit.innerHTML = '<%=strHandleUnit%>';
    //tdRunAreaName.innerHTML = '<%=prpLregistDto.getDamageAreaName()%>';

    //tdLossRate.innerHTML    = '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getIndemnityDutyRate())%>'+'％';
    //tdRemark.innerHTML = '备注：';
<%
  double douDelinquentFee = 0;
  String strDelinquentFee = "";
  String strPlanFee = "";
  if(policyDto.getPrpCplanDtoList()!=null){
    int intPlanCount = policyDto.getPrpCplanDtoList().size();
    for(index=0;index<intPlanCount;index++){
      PrpCplanDto prpCplanDto = (PrpCplanDto)policyDto.getPrpCplanDtoList().get(index);      
      douDelinquentFee = prpCplanDto.getDelinquentFee();
      if(douDelinquentFee==0){
        strDelinquentFee = "是";
        strPlanFee = "已足额交费";
      }else{
        strDelinquentFee = "否";
        strPlanFee = "还欠保费："+douDelinquentFee;
      }
%>
   //tdEndorseNo.innerHTML  = '<%=prpCplanDto.getEndorseNo()%>';
   //tdRemark.innerHTML = '备注：'+'<br>'+'保费缴费情况：'+'<%=strPlanFee%>' + '<br>'+'保费收讫日期：'+'<%=prpCplanDto.getPlanDate()%>'+'<br>'+'收款人：'+'';
   //tdSerialNo.innerHTML  = '已预付次数：'+'<%=DataUtils.zeroToEmpty(prpCplanDto.getSerialNo()-1)%>';
<%
    }
  }
%>
<%
   prpLextDto = registDto.getPrpLextDto();
   if(prpLextDto != null){
     long personInjureB  = prpLextDto.getPersonInjureB();
     long personDeathB   = prpLextDto.getPersonDeathB();
     long personInjureD1 = prpLextDto.getPersonInjureD1();
     long personDeathD1  = prpLextDto.getPersonDeathD1();
     String personInjure1 = "";
     String personInjure2 = "";
     String personInjure = "第三者（伤 "+personInjureB+" 人，亡 "+personDeathB+" 人），车上人员（伤 "
                            +personInjureD1+" 人， 亡 "+personDeathD1+" 人）";
     
     if(personInjureB==0){
       if(personDeathB==0){
         personInjure1 = "";
       }else{
         personInjure1 = "第三者（亡 "+personDeathB+" 人），";
       }  
     }else{
       if(personDeathB==0){
         personInjure1 = "第三者（伤 "+personInjureB+" 人），";
       }else{
         personInjure1 = "第三者（伤 "+personInjureB+" 人，亡 "+personDeathB+" 人），";
       }
     }
     if(personInjureD1==0){
       if(personDeathD1==0){
         personInjure2 = "";
       }else{
         personInjure2 = "车上人员（亡 "+personDeathD1+" 人）";
       }  
     }else{
       if(personDeathD1==0){
         personInjure2 = "车上人员（伤 "+personInjureD1+" 人）";
       }else{
         personInjure2 = "车上人员（伤 "+personInjureD1+" 人， 亡 "+personDeathD1+" 人）";
       }
     }
     personInjure = personInjure1 + personInjure2; 
     if((prpLextDto.getPersonInjureB()==0)&&(prpLextDto.getPersonDeathB()==0)&&(prpLextDto.getPersonInjureD1()==0)&&(prpLextDto.getPersonDeathD1()==0)){
       personInjure = "无人员伤亡";
     }
%>
   //tdPersonInjure.innerHTML = '<%=personInjure%>';
<%
  }
%>
<%
  String strEndorseNo = "";
  if(endorseDto.getPrpPheadDtoList()!=null){
    for(index=0;index<endorseDto.getPrpPheadDtoList().size();index++){
      PrpPheadDto prpPheadDto = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(index);
      strEndorseNo = prpPheadDto.getEndorseNo();
%>
   tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
<%
    }
  }
%>
   
}  
</script>
  