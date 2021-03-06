<%--
****************************************************************************
* DESC       ：进口货物运输保险赔款理算书打印初始化
* AUTHOR     ：zhuly
* CREATEDATE ：2005-11-15
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- 引入bean类部分 --%>
<%@page import="java.text.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.dto.domain.PrpCplanDto"%> 

<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

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
  String strContext           = "";   //赔款计算书文字
  String strDamageStartDate   = "";   //出险日期
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
  double dblAgentFee          = 0;    //代理费
  double dblSumLoss           = 0;    //标的损失金额
  double dblGsjzFee			  = 0;	  //共损救助费
  double dblFlFee			  = 0;	  //法律费
  
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
  String strUnderWriteName    = "";
  String strApproverCode      = "";
  String strOperatorCode      = "";
  String strApproverName      = "";
  String strOperatorName      = "";
  String strLossRate          = "";
  //add begin by zhuly 20051103 
  String strSeatCount         = "";  //座位數
  String strTonCount          = "";  //噸位數
  String strFrameNo           = "";  //車架號
  String strEngineNo          = "";  //發動機號
  String[] subKindName        = new String[6]; //附加险险别名称
  String[] subKindAmount      = new String[6]; //附加险保额
  String strKindName          = "";  //附加险别
  String strFlag              = "";  //主险附加险标志
  String strKindAmount        = "";  //附加险限额
  String strCarInsuredRelation = "" ;//所属性质代码
  String strCarInsuredRelationName = "";//所属性质
  String strUseNatureCode     = "";  //使用性质
  String strBLNo              = "";  //货运险运输工具牌号
  String strCarryBillNo       = "";  //货运险运单号码
  String strStartSiteName     = "";  //运输起始地
  String strViaSiteName       = "";  //运输中转地
  String strEndSiteName       = "";  //运输终止地
  String strCaseNo            = "";  //赔案编号
  String strSumAmount         = "";  //保险金额
  String strLadingNo          = "";  //提单号
  String strInvoiceNo         = "";  //公司合同或发票号
  String strBLName            = "";  //运输工具
  String strSailStartDate     = "";  //开航日期
  String strCheckAgentCode    = "";  //检验代理人代码
  String strValue1            = "";  //标的及件数
   
  //add end   by zhuly 20051103

  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  //对象定义部分
  PrpCitemCarDto     prpItemCarDto      = null;   //ItemCarDto对象 
  PrpCitemKindDto    prpItemKindDto     = null;   //保单的ItemKindDto对象
  PrpCmainDto        prpCmainDto        = null;   //保单主表对象
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto对象
  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;   //理赔扩展信息表
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
  
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto,CompensateDto,CheckDto,EndorseDto对象
  ClaimDto           claimDto           = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto          policyDto          = (PolicyDto)request.getAttribute("policyDto");
  RegistDto          registDto          = (RegistDto)request.getAttribute("registDto");
  CheckDto           checkDto           = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto      compensateDto      = (CompensateDto)request.getAttribute("compensateDto"); 
  CertainLossDto     certainLossDto     = (CertainLossDto)request.getAttribute("certainLossDto"); 
  EndorseDto         endorseDto         = (EndorseDto)request.getAttribute("endorseDto");   
  UICodeAction       uiCodeAction       = new UICodeAction();
  prpLcompensateDto                     = compensateDto.getPrpLcompensateDto(); //得到prpLcompensateDto 对象
  prpLclaimDto                          = claimDto.getPrpLclaimDto();           //得到prpLclaimDto对象   
  prpCmainDto                           = policyDto.getPrpCmainDto();           //得到保单主表对象
  prpLregistDto                         = registDto.getPrpLregistDto();         //得到prpLregistDto对象
  prpCmainCargoDto                      = policyDto.getPrpCmainCargoDto();      //得到prpCmainCargoDto对象
  strClaimNo                            = prpLclaimDto.getClaimNo();   
  strOperatorCode                       = prpLcompensateDto.getOperatorCode();    
  strOperatorName                       = uiCodeAction.translateUserCode(strOperatorCode,isChinese); 
  DateTime           dateTime           = new DateTime();
  //String strDateTime = new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR);
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();
  System.out.println("zhulianyu");  
  //得到赔案编号
  strCaseNo   = prpLcompensateDto.getCaseNo();
  //得到保险金额
  strSumAmount = ""+new DecimalFormat("#,##0.00").format(prpCmainDto.getSumAmount());
  String  RiskCode = "" ;  //保单险种代码
  String  strRiskName = "" ;  //保单险种名称
  RiskCode = prpCmainDto.getRiskCode();//
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
 //得到标的损失
  dblSumLoss   = prpLcompensateDto.getSumLoss();
  //得到blPrpCitemCar对象  
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  } 
  //**********************货运险保单信息*****************************//
  if(policyDto.getPrpCmainCargoDto()!=null)
  {
    strBLNo              = prpCmainCargoDto.getBLNo();            //货运险运输工具牌号
    strCarryBillNo       = prpCmainCargoDto.getCarryBillNo();     //货运险运单号码
    strStartSiteName     = prpCmainCargoDto.getStartSiteName();   //运输起始地
    strViaSiteName       = prpCmainCargoDto.getViaSiteName();     //运输中转地
    strEndSiteName       = prpCmainCargoDto.getEndSiteName();     //运输终止地  
    strLadingNo          = prpCmainCargoDto.getLadingNo();        //得到提单号 
    strInvoiceNo         = prpCmainCargoDto.getInvoiceNo();       //发票号
    strBLName            = prpCmainCargoDto.getBLName();          //运输工具
    strCheckAgentCode    = prpCmainCargoDto.getCheckAgentCode();  //检验代理
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
  //得到损失程度描叙
  if (claimDto.getPrpLthirdCarLossDtoList() != null) {
     for(index=0;index<claimDto.getPrpLthirdCarLossDtoList().size();index++){
      PrpLthirdCarLossDto prpLthirdCarLossDto = (PrpLthirdCarLossDto) claimDto.getPrpLthirdCarLossDtoList().get(0);
      lossDesc = prpLthirdCarLossDto.getLossDesc();
      }
  }
  
  List prplLossList = new ArrayList();
  if(compensateDto.getPrpLlossDtoList()!=null){
  	prplLossList = compensateDto.getPrpLlossDtoList();
  }

  //若不够4个险别,则凑够4个，若多于4个，则打印部分内容
  int printLossCount = 4;
  int prplLossListSize = prplLossList.size();
  
  if(prplLossListSize<printLossCount){
  	for(int i=prplLossListSize;i<printLossCount;i++){
	  	prplLossList.add(new PrpLlossDto());
	}  	
  }else if(prplLossList.size()>printLossCount){
  	prplLossList.subList(0,printLossCount-1);
  }
%>

<script language="javascript">
  function loadForm()
  {
        
    //*****赔款计算书表PrpLcompensate*****
    //tdCompensateNo.innerHTML  = '<%=strCompensateNo%>';
    
<%
    dblSumPrePaid   = prpLcompensateDto.getSumPrePaid();  
    dblSumRest      = prpLcompensateDto.getSumRest();     
    dblSumThisPaid  = prpLcompensateDto.getSumThisPaid(); 
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);
    strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
    dblSumPaid      = prpLcompensateDto.getSumPaid();             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());  
%>
    //tdSumPrePaid.innerHTML    = '&nbsp;已预付赔款：'                    + '<%=DataUtils.zeroToEmpty(dblSumPrePaid)%>';
    //tdSumRest.innerHTML       = '&nbsp;损余物资/残值金额：'           + '<%=DataUtils.zeroToEmpty(dblSumRest)%>';
    //tdCSumThisPaid.innerHTML  = '&nbsp;本次实付赔款（人民币大写）：'  + '<%=strCSumThisPaid%>';
    //tdSumThisPaid.innerHTML   = '（￥：'                        + '<%=strSumThisPaid%>';
    //tdCSumPaid.innerHTML      = '&nbsp;赔款总计（大写）：'      + '<%=strCSumPaid%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥:'+ '<%=strSumPaid%>元';
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>'+'元';
    //tdBLNo.innerHTML            = '<%=strBLNo%>';         
    //tdCarryBillNo.innerHTML     = '<%=strCarryBillNo%>';
    tdSumAmount.innerHTML       = '<%=StringConvert.encode(strSumAmount)%>';
    tdRiskName.innerHTML      = '<%=strRiskName%>';
    //tdSumLoss.innerHTML         = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdLadingNo.innerHTML        = '<%=StringConvert.encode(strLadingNo)%>';
    tdInvoiceNo.innerHTML       = '<%=StringConvert.encode(strInvoiceNo)%>';
    tdCheckAgentCode.innerHTML  = '<%=StringConvert.encode(strCheckAgentCode)%>';
    tdBLName.innerHTML          = '<%=StringConvert.encode(strBLName)%>';
    tdSiteName.innerHTML        = '从'+'<%=strStartSiteName%>'+'起至'+'<%=strEndSiteName%>'+'止';    
    tdPolicyNo.innerHTML        = '<%=StringConvert.encode(strPolicyNo)%>';
    tdCaseNo.innerHTML          = '<%=StringConvert.encode(strCaseNo)%>';
    tdInsuredName.innerHTML     = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " 年 " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()
                        + " 日";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);

%>                    
    tdDamageStartDate.innerHTML = '<%=StringConvert.encode(strDamageStartDate)%>';
    //tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';
    //tdSumClaim.innerHTML        = '<%= lossDesc %>';    
    //tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    //tdDamageAddressType.innerHTML   = '<%=damangeAddressType%>';
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
    strInsuredDate =  prpLclaimDto.getStartDate().getYear()
                     + "年" +prpLclaimDto.getStartDate().getMonth()
                     + "月" + prpLclaimDto.getStartDate().getDate()
                     + "日" ;
%>                    
    //tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    
    //*****理赔车辆信息PrpLthirdParty*****  
<%
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
        //tdUseNatureCode.innerHTML = '<%=strUseNatureCode%>';
        //tdLicenseNo.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getLicenseNo())%>';       
        //tdBrandName.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getBrandName())%>';
        //tdCarInsuredRelationName.innerHTML = '<%=strCarInsuredRelationName%>';
        //tdSeatTonCount.innerHTML = '<%=strSeatCount+"座/"+strTonCount+"吨"%>';  
        //tdEngineNo.innerHTML     = '<%=StringConvert.encode(prpItemCarDto.getEngineNo())%>';
        //tdFrameNo.innerHTML      = '<%=StringConvert.encode(prpItemCarDto.getFrameNo())%>'; 
     
<%
        System.out.println(prpItemCarDto.getLicenseNo()+" "+prpItemCarDto.getBrandName()+" ppppppppppppppppppppppppp");
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
    //*****机动车险标的信息表PrpCitemCar*****    
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
    
    //*****标的子险信息PrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
     int tempindex = 0 ;  //定义临时变量
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //add begin by zhuly 20051103 reason:增加子險信息
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
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("A"))//主险車損險保額 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("B"))//主险三者險限額
      {
        dblSumAmount2 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("2")&&tempindex<6)//附加险
      {
        subKindName[tempindex] = strKindName;
        subKindAmount[tempindex] = strKindAmount;  
   %>
     // <%="tdKindName"+tempindex%>.innerHTML = '<%=subKindName[tempindex]%>'; 
     // <%="tdKindAmount"+tempindex%>.innerHTML = '<%=subKindAmount[tempindex]%>';              
   <%
        tempindex ++;
      }      
    }    
  }  

%>
    //tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    //tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>'; 
    //tdDeductibleRate.innerHTML = '<%=prpItemKindDto.getDeductibleRate()%>'+'％';   
<%    
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //*****赔款计算文字表PrpLctext*****
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' )
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
      strContext = strContext.substring(0,1200)+"<br>计算书信息过多，请详见清单。";  
    }
    while(strContext.indexOf("\\r\\n")!=-1)
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());

%>  
   tdContext.innerHTML = '<%="赔款计算：<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strContext%>';
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
<%  
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumPrePaid-dblSumRest);
    strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumPrePaid-dblSumRest,prpLcompensateDto.getCurrency());
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
     strValue1           =  prpLextDto.getValue1();
     strSailStartDate    = prpLextDto.getSailStartDate().getYear()
                         + "年"+prpLextDto.getSailStartDate().getMonth()
                         + "月"+prpLextDto.getSailStartDate().getDay()
                         + "日";   
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
   tdValue1.innerHTML = '<%=strValue1%>';
   tdSailStartDate.innerHTML = '<%=strSailStartDate%>';
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
   //tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
<%
    }
  }
%>
   
}  
</script>
  