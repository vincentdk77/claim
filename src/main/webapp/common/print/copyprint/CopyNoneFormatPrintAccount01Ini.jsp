<%--
****************************************************************************
* DESC       ：出险后抄单打印页初始化
* AUTHOR     ： 项目组
* CREATEDATE ：2005-9-14
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
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade"%>
<%
    int i = 0;
    String strClassCode = ""; //险类
    String strPolicyNo = ""; //保单号
    String strRegistNo = ""; //报案号
    String strPolicyName = ""; //被保险人名称
    String strPolicyAddress = ""; //被保险人地址
    String strCoinsFlag     = ""; //联共保标志
    String strCurrency   ="";
    double dbSumAmount   = 0.0;
    DateTime OperateDate = new DateTime();
    DateTime InputDate = new DateTime();
    DateTime SignDate = new DateTime();
    DateTime UnderWriteEndDate = new DateTime();
    DateTime StartDate = new DateTime();
    DateTime EndDate = new DateTime();
    
    
    String strRiskCode     = ""; //险种代码
    String strRiskName     = ""; //险种名称
    
    
    String[] strKindName = null;   //险别名称
    double[] dbAmount   = null;  //险别保额
    
    String[] strEndorseNo = null; 
    String[] strEndorType = null;
    DateTime[] strEndorDate = null;
    String[] strUnderWriteName = null;
    
    int[] iPlanNo = null;
    String[] strPlanEndorNo = null;
    double[] dbPlanFee = null;
    double[] dbRealFee = null;
    DateTime[] strPayDate = null;
    String conditon = "";//查询到账时间的条件
    BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();

    Collection collection = null;
    UICodeAction uiCodeAction = new UICodeAction();

    RegistDto registDto = (RegistDto) request.getAttribute("registDto");
    PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");
    EndorseDto endorseDto = (EndorseDto) request.getAttribute("endorseDto");
    if(registDto!=null && registDto.getPrpLregistDto()!=null){
        strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();
        strClassCode = registDto.getPrpLregistDto().getClassCode();
        strRegistNo = registDto.getPrpLregistDto().getRegistNo();
    }
    if(policyDto!=null && policyDto.getPrpCmainDto()!=null){
        strPolicyName = policyDto.getPrpCmainDto().getAppliName();
        strPolicyAddress = policyDto.getPrpCmainDto().getAppliAddress();
        strCoinsFlag= policyDto.getPrpCmainDto().getCoinsFlag().toString();
        dbSumAmount =policyDto.getPrpCmainDto().getSumAmount();
        strCurrency =policyDto.getPrpCmainDto().getCurrency();
        OperateDate = policyDto.getPrpCmainDto().getOperateDate();
        InputDate = policyDto.getPrpCmainDto().getInputDate();
        SignDate = policyDto.getPrpCmainDto().getSignDate();
        UnderWriteEndDate = policyDto.getPrpCmainDto().getUnderWriteEndDate();
        StartDate = policyDto.getPrpCmainDto().getStartDate();
        EndDate = policyDto.getPrpCmainDto().getEndDate();
        strRiskName = uiCodeAction.translateRiskCode(policyDto.getPrpCmainDto().getRiskCode(),true);
    }   
    if (endorseDto.getPrpPheadDtoList() != null) {
    	  collection = endorseDto.getPrpPheadDtoList();
    	  strEndorseNo = new String[collection.size()];
        strEndorType = new String[collection.size()];
        strEndorDate = new DateTime[collection.size()];
        strUnderWriteName = new String[collection.size()];
        i = 0;
				Iterator iterator = endorseDto.getPrpPheadDtoList()
						.iterator();
				//System.out.println(iterator.getSize());		
				while (iterator.hasNext()) {
					PrpPheadDto prpPheadDtoTemp = (PrpPheadDto) iterator
							.next();
					strEndorseNo[i] = prpPheadDtoTemp.getEndorseNo();
					strEndorType[i] = uiCodeAction.translateCodeCode("EndorType",prpPheadDtoTemp.getEndorType(),true);
					strEndorDate[i] = prpPheadDtoTemp.getEndorDate();
					strUnderWriteName[i] = prpPheadDtoTemp.getUnderWriteName();
					i++;
				}
			}
		if (policyDto.getPrpCplanDtoList() != null) {
				Iterator iterator = policyDto.getPrpCplanDtoList()
						.iterator();
    	  collection = policyDto.getPrpCplanDtoList();
			  iPlanNo = new int[collection.size()];     
        strPlanEndorNo = new String[collection.size()];
        dbPlanFee = new double[collection.size()];   
        dbRealFee = new double[collection.size()];
        strPayDate = new DateTime[collection.size()];
        i = 0;
				while (iterator.hasNext()) {
					PrpCplanDto prpCplanDtoTemp = (PrpCplanDto) iterator
							.next();
					
			    iPlanNo[i] = prpCplanDtoTemp.getPayNo();
			    if(prpCplanDtoTemp.getPayNo()==0)
			      iPlanNo[i] = 1;
			    strPlanEndorNo[i] = prpCplanDtoTemp.getEndorseNo();
			    dbPlanFee[i] = prpCplanDtoTemp.getPlanFee();
			    dbRealFee[i] = prpCplanDtoTemp.getPlanFee() - prpCplanDtoTemp.getDelinquentFee();
			    //无批改条件拼接
			    conditon = "rec.certino='" + strPolicyNo + "' and rec.serialno ='"+prpCplanDtoTemp.getSerialNo()+"' and rec.payrefreason='"+prpCplanDtoTemp.getPayReason()+"'";
			    //strPayDate[i] = prpCplanDtoTemp.getPlanDate();
			    if(strPlanEndorNo[i]!=null && !"".equals(strPlanEndorNo[i])){
			       conditon = "rec.certino='" + strPlanEndorNo[i] + "' and rec.payrefreason='"+prpCplanDtoTemp.getPayReason()+"'";
			    }
			    strPayDate[i] = blPrpJpayRefRecFacade.getRefDate(conditon);
			    i++;
				}
			}
		if (policyDto.getPrpCitemKindDtoList() != null) {
	      
    	  collection = policyDto.getPrpCitemKindDtoList();
			  strKindName = new String[collection.size()];
			  dbAmount    = new double[collection.size()];
			  i = 0;
				Iterator iterator = policyDto.getPrpCitemKindDtoList()
						.iterator();
				while (iterator.hasNext()) {
					PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator
							.next();
					strKindName[i] = prpCitemKindDtoTemp.getKindName();
					dbAmount[i] = prpCitemKindDtoTemp .getAmount();
					i++;
				}
			}

    if (strCoinsFlag.equals("0")) {         //非共保
        strCoinsFlag = "非共保";
    } else if (strCoinsFlag.equals("1")) {  //主共保
        strCoinsFlag = "主共保";
    } else if (strCoinsFlag.equals("2")) {  //共保
        strCoinsFlag = "共保";
    }
%>