<%--
****************************************************************************
* DESC       ：机动车辆保险预付赔款审批表打印初始化
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- 引入bean类部分 --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>

<%
  //变量声明部分
  String strPreCompensateNo   = request.getParameter("PreCompensateNo"); //预赔号
  String strClaimNo         = "";   //立案号
  String strInsuredDate     = "";   //保险期间
  String strDamageStartDate = "";   //出险时间
  String strInsureCarFlag   = "";   //是否为本保单车辆
  String strCSumPrePaid     = "";   //大写预赔金额
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode(); 
  String strUserName        = "";
  String strInputDate       = "";
  String strMessage         = "";  

  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  //对象定义部分                                           
  PrpLregistDto      prpLregistDto      = null;   //RegistDto对象
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto对象
  
  int intPrepayCount      = 0;   //PrepayDto对象的记录数
  int intThirdPartyCount  = 0;   //ThirdPartyDto对象的记录数
    
  int index = 0;
  
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  PrepayDto prepayDto = (PrepayDto)request.getAttribute("prepayDto"); 
    
  UICodeAction uiCodeAction = new UICodeAction();
  
  //得到prpLclaimDto对象
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  strClaimNo = prpLclaimDto.getClaimNo(); 
    
  //得到blPrpLthirdParty对象的记录数
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
  //得到prpLregistDto对象
  prpLregistDto    = registDto.getPrpLregistDto();
  
  PrpLprepayDto prpLprepayDto = prepayDto.getPrpLprepayDto();
%>

<script language="javascript">
  function loadForm()
  {
    tdClaimNo.innerHTML = '立案编号：' + '<%=strClaimNo%>';
    
    //*****报案信息表PrpLregist*****
    tdEstimateLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLregistDto.getEstimateLoss())%>';    
    //*****立案信息表PrpLregist*****
    tdPolicyNo.innerHTML    = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdSumAmount.innerHTML   = '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strInsuredDate = "自 " + prpLclaimDto.getStartDate().getYear()
                     + "年" + prpLclaimDto.getStartDate().getMonth()
                     + "月" + prpLclaimDto.getStartDate().getDate()
                     + "日 零时起"
                     + "<br>" + "<br>" 
                     + "至 " + prpLclaimDto.getEndDate().getYear()
                     + "年" + prpLclaimDto.getEndDate().getMonth()
                     + "月" + prpLclaimDto.getEndDate().getDate()
                     + "日 二十四时止";
%>                     
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
<%
    //出险险种
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
%>
    tdRiskName.innerHTML = '<%=strName%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " 年 " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " 月 " + prpLclaimDto.getDamageStartDate().getDate()
                        + " 日";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
    //*****理赔车辆信息PrpLthirdParty*****
<%  
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
%>        
        tdLicenseNo.innerHTML = '<%=prpLthirdPartyDto.getLicenseNo()%>';
        tdBrandName.innerHTML = '<%=prpLthirdPartyDto.getBrandName()%>';
<%        
        //条款类别
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
        tdClauseType.innerHTML= '<%=strName%>';
<%  
      }
    }
  }  
    
    //*****预赔登记表PrpLprepay*****

      strCSumPrePaid = MoneyUtils.toChinese(prpLprepayDto.getSumPrePaid(),prpLprepayDto.getCurrency());

%>
    tdSumPrePaid.innerHTML = '&nbsp;预付赔款金额（大写人民币）：' + '<%=strCSumPrePaid%>';
<%    
    //填报人 
    strUserName = uiCodeAction.translateUserCode(strUserCode,isChinese);
    
    //填报时间
    strInputDate = DateTime.current().getYear() + "年"
                 + DateTime.current().getMonth() + "月" 
                 + DateTime.current().getDate() + "日";
%>
    tdUserName.innerHTML  ='填报人：'   + '<%=strUserName%>';
    tdInputDate.innerHTML ='填报时间：' + '<%=strInputDate%>';    
  }
</script>
