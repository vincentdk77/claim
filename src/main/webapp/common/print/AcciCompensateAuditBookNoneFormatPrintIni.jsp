<%--
****************************************************************************
* DESC       ：理赔审核书初始化
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-14
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
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
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>

<%
  //变量声明部分
  String strCompensateNo      = request.getParameter("CompensateNo"); //理赔审核书号
  String strClaimNo           = "";   //立案号
  String strRegistNo          = "";   //报案号
  String strPolicyNo          = "";   //保单号
  String strTextType          = "";
  String strContext           = "";   //赔款审核书文字
  String[] strAcciName        ;   //事故人姓名
  String strSexCode           = "";   //性别代码
  String[] strAcciSex         ;     //事故人性别
  String[] strAcciAge         ;     //事故人年龄
  String[] strAcciIDCardNo    ;     //事故人身份证号
  String strAcciDate          = "";   //事故时间
  String strDamageTypeName    = "";   //事故类型
  String strClaimTypeName     = "";   //事故性质
  String strDamageName        = "";   //事故原因
  String strInsuredDate       = "";   //保险期限
  String strSumRealPay        = "";   //赔付总金额
  String strDamageType        = "";   //赔付类型
  String strHandlerName       = "";   //经办人
  String strUnderWriteName    = "";   //审核人
  String strInputDate         = "";   
  double sumRealpay           = 0.0;  //赔付合计
  String strUnderWriteEndDate         = "";   
  
  double dblSumAmount        = 0;    //保险金额 
  
  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  //对象定义部分
                                              
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto对象
  PrpLctextDto       prpLctextDto       = null; 
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;
  PrpLlossDto        prpLlossDto		= null;
  PrpLpersonLossDto  prpLpersonLossDto  = null;
  List               prplPersonList = new ArrayList(); 
	List    					 prpLctextList = new ArrayList();
  
  
  int index = 0;
  
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  
  prpLctextList = (ArrayList)request.getAttribute("prpLctextList");
  prplPersonList = (ArrayList)request.getAttribute("prplPersonList");
  
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //得到prpLcompensateDto 对象
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //得到prpLclaimDto对象
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  //得到prpLregistDto对象
  prpLregistDto  = registDto.getPrpLregistDto();
  
  strClaimNo = prpLclaimDto.getClaimNo();
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
  //得到事故人信息
  int personCount = claimDto.getPrplacciBenPersonDtoList().size();
  strAcciName = new String[personCount];
  strAcciSex  = new String[personCount];
  strAcciAge  = new String[personCount];
  strAcciIDCardNo = new String[personCount];
  if(claimDto != null){    
    for(int i = 0;i < personCount; i++){
      PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)claimDto.getPrplacciBenPersonDtoList().get(i);
      strAcciName[i]          = StringConvert.encode(prpLacciPersonDto.getAcciName());
      strSexCode              = prpLacciPersonDto.getSex(); 
      strAcciSex[i]           = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);  
      strAcciAge[i]           = String.valueOf(prpLacciPersonDto.getAge()); 
      strAcciIDCardNo[i]      = prpLacciPersonDto.getIdentifyNumber();
    }
  }
  
  //得到立案信息
  if(prpLclaimDto != null){
    strCode = prpLclaimDto.getDamageTypeCode();
    strDamageTypeName = uiCodeAction.translateCodeCode("DamageTypeCode",strCode,true);
    DateTime dtAcciDate = new DateTime();
    String strDamageStartHour = prpLclaimDto.getDamageStartHour();
    dtAcciDate = prpLclaimDto.getDamageStartDate();
    strAcciDate = dtAcciDate.getYear()+"年"+
                  dtAcciDate.getMonth()+"月"+
                  dtAcciDate.getDay()+"日"+
                  strDamageStartHour;
    strCode = prpLclaimDto.getClaimType();
    strClaimTypeName = uiCodeAction.translateCodeCode("CaseCode",strCode,true);
    strClaimTypeName = "性质：" + strClaimTypeName;
    strCode = prpLclaimDto.getDamageCode();
    strDamageName = uiCodeAction.translateCodeCode("DamageCode",strCode,true);
    //System.out.println("====="+strClaimTypeName);
  }
  
  //得到保单信息
  if(policyDto != null){
    PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
    if(prpCmainDto!=null){
      strInsuredDate = "自 " + prpCmainDto.getStartDate().getYear()
                       + "年" +prpCmainDto.getStartDate().getMonth()
                       + "月" + prpCmainDto.getStartDate().getDate()
                       + "日" + prpCmainDto.getStartHour()
                       + "时起"
                       + "至 " + prpCmainDto.getEndDate().getYear()
                       + "年" + prpCmainDto.getEndDate().getMonth()
                       + "月" + prpCmainDto.getEndDate().getDate()
                       + "日" + prpCmainDto.getEndHour()
                       + "时止";
      dblSumAmount = prpCmainDto.getSumAmount();
    }
  }
  
  
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
  
  
  
  //add by miaowenjun 2007-1-29 10:53 start
	sumRealpay = prpLcompensateDto.getPersonLossSumRealPay();
    //将赔款费用中的记入赔款金额加进赔款合计中    
    int count = compensateDto.getPrpLchargeDtoList().size();
    for(int i = 0 ; i < count; i ++){
    	prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(i);
    	sumRealpay += prpLchargeDto.getSumRealPay();
    }
    strSumRealPay = String.valueOf(new DecimalFormat("#,##0.00").format(sumRealpay));
	strHandlerName = uiCodeAction.translateUserCode(prpLcompensateDto.getHandlerCode(),true);
	strUnderWriteName = prpLcompensateDto.getUnderWriteName();
	strInputDate = prpLcompensateDto.getInputDate().getYear()+"年"+prpLcompensateDto.getInputDate().getMonth()+"月"+prpLcompensateDto.getInputDate().getDate()+"日";
	strUnderWriteEndDate = prpLcompensateDto.getUnderWriteEndDate().getYear()+"年"+prpLcompensateDto.getUnderWriteEndDate().getMonth()+"月"+prpLcompensateDto.getUnderWriteEndDate().getDate()+"日";
	//add by miaowenjun 2007-1-29 10:53 end
%>
<script language="javascript">

function loadForm(){
  
  spClaimNo.innerHTML = '<%=strClaimNo%>';
  spClaimNo1.innerHTML = '<%=strClaimNo%>';
  spPolicyNo.innerHTML = '<%=strPolicyNo%>';
  spDamageTypeName.innerHTML  = '<%=strDamageTypeName%>';
  spAcciDate.innerHTML  = '<%=strAcciDate%>';
  spAcciDate1.innerHTML  = '<%=strAcciDate%>';
  spAcciDamageDesc.innerHTML  = '<%="&nbsp;&nbsp;事故原因："+strDamageName+"&nbsp;&nbsp;"+strClaimTypeName%>';
  spAcciDamageName.innerHTML  = '<%=strDamageName%>';
  spPolicyNo1.innerHTML  = '<%=strPolicyNo%>'; 
  spInsuredDate.innerHTML  = '<%=strInsuredDate%>';
  spSumAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount)%>';
}

</script>
