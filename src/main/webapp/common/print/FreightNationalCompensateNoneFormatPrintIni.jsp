<%--
****************************************************************************
* DESC       ：国内货物运输保险赔款理算书打印初始化
* AUTHOR     ：zhulianyu
* CREATEDATE ：2005-11-15
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
  String strTextType          = "";   //赔款文字类型
  String strContext           = "";   //赔款计算书文字
  String strDamageStartDate   = "";   //出险时间
  String strInsuredDate       = "";   //保险期间
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0; 	  //代查费
  double dblAgentFee          = 0;    //代理费
  double dblLawFee            = 0;    //诉讼费
  double dblSumLoss           = 0;    //标的损失金额

  double dblRescueFee         = 0;    //施救费
  double dblCheckFee          = 0;    //查勘费
  double dblJudgeFee          = 0;    //检验鉴定费
  double dblGsjzFee			  = 0;	  //共损救助费
  double dblAssessFee         = 0; 	  //公估费
  double dblFlFee			  = 0;	  //法律费  
  double dblElseFee           = 0;    //其它
  
  double dblPropSumLossPay	  = 0;	  //财产损失
  double dblPersonSumLossPay  = 0;	  //人伤损失
  double dblSumLossPay		  = 0;	  //标的赔款
  
  
  
  String strSumThisPaid       = "";   //
  String strCSumThisPaid      = "";   //
  String strSumLossPay		 = "";	 //标的赔款
  String strCSumLossPay	     = "";	 //标的赔款中文
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
  String strHandlerName       = "";   //缮制人
  String strInputDate         = "";   //缮制日期
  String strUnderWriteEndDate = "";   //核赔通过日期
  String strUnderWriteName    = "";
  String strApproverCode      = "";
  String strOperatorCode      = "";
  String strApproverName      = "";
  String strOperatorName      = "";
  String strLossRate          = "";
  //add begin by zhuly 20051103 
  String[] subKindName        = new String[6]; //附加险险别名称
  String[] subKindAmount      = new String[6]; //附加险保额
  String strKindName          = "";  //附加险别
  String strFlag              = "";  //主险附加险标志
  String strKindAmount        = "";  //附加险限额
  String strCarInsuredRelation = "" ; //所属性质代码
  String strCarInsuredRelationName = "";//所属性质
  String strUseNatureCode     = "";  //使用性质
  String strBLNo              = "";  //货运险运输工具牌号
  String strCarryBillNo       = "";  //货运险运单号码
  String strStartSiteName     = "";  //运输起始地
  String strViaSiteName       = "";  //运输中转地
  String strEndSiteName       = "";  //运输终止地
  String strCaseNo            = "";  //赔案编号
  String strSumAmount         = "";  //保险金额
  String strLossName          = "";  //受损标的(货物名称)
  int    intLossQuantity      = 0;   //受损标的数量
 
  //对象定义部分
                                              

  PrpCitemKindDto    prpItemKindDto     = null;   //保单的ItemKindDto对象
  PrpCmainDto        prpCmainDto        = null;   //保单主表对象
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto对象
  PrpLctextDto       prpLctextDto       = null; 
  PrpLregistDto      prpLregistDto      = null;
  PrpLextDto         prpLextDto         = null;
  PrpCmainCargoDto   prpCmainCargoDto   = null;   //货运险保单信息
  
  int                intCompensateCount = 0;      //CompensateDto对象的记录数
  int                intItemCarCount    = 0;      //ItemcarDto对象的记录数
  int                intItemKindCount   = 0;      //ItemKindDto对象的记录数
  int                intThirdPartyCount = 0;      //ThirdPartyDto对象的记录数
  int                intChargeCount     = 0;      //ChargeDto对象的记录数
  int                intCtextCount      = 0;      //CtextDto对象的记录数
  int                intCtextCountTmp   = 0;      //textarea行数
  int                intDriverCount     = 0;      //DriverDto对象的记录数
  int                intPropCount       = 0;
  String             lossDesc           = "";     //损失程度
    
  int index = 0;
  
  //得到ClaimDto,RegistDto,PolicyDto,CompensateDto,CheckDto对象
  ClaimDto           claimDto           = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto          policyDto          = (PolicyDto)request.getAttribute("policyDto");
  RegistDto          registDto          = (RegistDto)request.getAttribute("registDto");
  CheckDto           checkDto           = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto      compensateDto      = (CompensateDto)request.getAttribute("compensateDto"); 
  
  UICodeAction       uiCodeAction       = new UICodeAction();
  prpLcompensateDto                     = compensateDto.getPrpLcompensateDto(); //得到prpLcompensateDto 对象
  prpLclaimDto                          = claimDto.getPrpLclaimDto();           //得到prpLclaimDto对象   
  prpCmainDto                           = policyDto.getPrpCmainDto();           //得到保单主表对象
  prpLregistDto                         = registDto.getPrpLregistDto();         //得到prpLregistDto对象
  prpCmainCargoDto                      = policyDto.getPrpCmainCargoDto();      //得到prpCmainCargoDto对象
  strClaimNo                            = prpLclaimDto.getClaimNo();   
  DateTime           dateTime           = new DateTime();
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();
  //得到赔案编号
  strCaseNo   = prpLcompensateDto.getCaseNo();
  //得到保险金额
  strSumAmount = ""+new DecimalFormat("#,##0.00").format(prpCmainDto.getSumAmount());
  String  RiskCode = "" ;  //保单险种代码
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
    
      strPayRefName = uiCodeAction.translateUserCode(strPayRefCode,true);
    }
  }
  
  
  //得到标的损失
  dblSumLoss   = prpLcompensateDto.getSumLoss();
  
  	dblPropSumLossPay = compensateDto.getPrpLcompensateDto().getLossSumRealPay();	  //财产损失
	dblPersonSumLossPay = compensateDto.getPrpLcompensateDto().getPersonLossSumRealPay();	  //人伤损失
	dblSumLossPay = dblPropSumLossPay + dblPersonSumLossPay;	  //标的赔款
	strSumLossPay = new DecimalFormat("#,##0.00").format(dblSumLossPay);
	strCSumLossPay = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
	
	//得到缮制人和核赔人
	strHandlerName = uiCodeAction.translateUserCode(prpLcompensateDto.getHandlerCode(),true);
	strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  strInputDate = prpLcompensateDto.getInputDate().getYear()+"年"+prpLcompensateDto.getInputDate().getMonth()+"月"+prpLcompensateDto.getInputDate().getDate()+"日";
  strUnderWriteEndDate = prpLcompensateDto.getUnderWriteEndDate().getYear()+"年"+prpLcompensateDto.getUnderWriteEndDate().getMonth()+"月"+prpLcompensateDto.getUnderWriteEndDate().getDate()+"日";
  
  //报案信息
  if(registDto.getPrpLregistDto()!=null)
  {
     strLossName         = prpLregistDto.getLossName();
     intLossQuantity     = (int)prpLregistDto.getLossQuantity();
  } 
  if(policyDto.getPrpCmainCargoDto()!=null)
  {
    strBLNo              = prpCmainCargoDto.getBLNo();            //货运险运输工具牌号
    strCarryBillNo       = prpCmainCargoDto.getCarryBillNo();     //货运险运单号码
    strStartSiteName     = prpCmainCargoDto.getStartSiteName();   //运输起始地
    strViaSiteName       = prpCmainCargoDto.getViaSiteName();     //运输中转地
    strEndSiteName       = prpCmainCargoDto.getEndSiteName();     //运输终止地        
  }
    if(strStartSiteName.equals(""))
    {
        strStartSiteName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    }   
    if(strViaSiteName.equals(""))
    {
        strViaSiteName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    } 
    if(strEndSiteName.equals(""))
    {
        strEndSiteName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    }    
  //得到blPrpCitemKind对象的记录数
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
    
  //得到blPrpLcharge对象的记录数
  if(compensateDto.getPrpLchargeDtoList()!=null){
    intChargeCount     = compensateDto.getPrpLchargeDtoList().size();
  }  
  //得到dbPrpLctext对象的记录数  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
%>

<script language="javascript">
  function loadForm()
  {
        
    //*****赔款计算书表PrpLcompensate*****
    //tdCompensateNo.innerHTML  = '<%=strCompensateNo%>';
    
<%
    dblSumPaid      = dblSumLossPay;             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumLossPay);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
%>
    //tdCSumPaid.innerHTML  = '&nbsp;赔款总计（大写）：'      + '<%=strCSumPaid%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥:'+ '<%=strSumPaid%>元';
    tdCSumLossPay.innerHTML = '&nbsp;赔款总计（大写）：'      + '<%=strCSumLossPay%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥:'+ '<%=strSumLossPay%>元';
    
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>'+'元';
    tdSSumLossPay.innerHTML   = '&nbsp;'+'<%=strSumLossPay%>';
    tdBLNo.innerHTML          = '<%=strBLNo%>';         
    tdCarryBillNo.innerHTML   = '<%=strCarryBillNo%>';
    tdSiteName.innerHTML      = '自'+'<%=strStartSiteName%>'+'经'+'<%=strViaSiteName%>'+'至'+'<%=strEndSiteName%>';
    tdCaseNo.innerHTML        = '<%=strClaimNo%>';
    tdSumAmount.innerHTML     = '<%=strSumAmount%>';
    //tdSumLoss.innerHTML       = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdSumLossPay.innerHTML       = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLossPay)%>';
    //tdLossName.innerHTML      = '<%=StringConvert.encode(strLossName)%>';
    //tdLossQuantity.innerHTML  = '<%=intLossQuantity%>';
    tdPolicyNo.innerHTML      = '<%=strPolicyNo%>';
    tdRiskName.innerHTML      = '<%=strRiskName%>';
    tdInsuredName.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " 年 " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()
                        + " 日";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';  
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
<%    
    strInsuredDate =  prpLclaimDto.getStartDate().getYear()
                     + "年" +prpLclaimDto.getStartDate().getMonth()
                     + "月" + prpLclaimDto.getStartDate().getDate()
                     + "日" ;
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';    
<%
    //*****标的子险信息PrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
     int tempindex = 0 ;  //定义临时变量
    for(index=0;index<intItemKindCount;index++)
    {      
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();
      strCalculateFlag = prpItemKindDto.getCalculateFlag();         
    }    
  }     
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //*****赔款计算文字表PrpLctext*****
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='7' )
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
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
    
    if( intCtextCountTmp>20 )
    {
      strContext = strContext.substring(0,600)+"<br>计算书信息过多，请详见清单。";  
    }
    while(strContext.indexOf("\\r\\n")!=-1)
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());

%>  
   tdContext.innerHTML = '<%="&nbsp;赔款理算：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strContext%>';
<%    
    //*****赔款费用信息表PrpLcharge*****    
    dblJudgeFee = 0;  
    dblCheckFee = 0;  
    dblLawFee   = 0;  
    dblElseFee  = 0;
    dblCheckFee1 = 0; 
    dblAssessFee = 0; 
    dblRescueFee = 0;
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 
           
      if( strChargeCode.equals("07") )       //鉴定费
      {    
        dblJudgeFee += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("06") )  //代查勘费
      {    
        dblCheckFee1 += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("05") )  //诉讼费
      {    
        dblLawFee   += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("04") )  //查勘费
      {    
        dblCheckFee += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("13") )  //公估费
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("03"))   //施救费
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();        
      }
      else if( strChargeCode.equals("09"))   //代理费
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("11"))   //共损救助费
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("15"))   //法律费
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("99"))   //其它
      { 
        dblElseFee  += prpLchargeDto.getChargeAmount();
      }
    }    
  }    
%>    
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
    
    
    
}
</script>
  