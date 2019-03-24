<%--
****************************************************************************
* DESC       ：机动车辆保险报案记录(代抄单)打印初始化
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   Name       Date            Reason/Contents
--------------------------------------------------------------------------
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
<%@page import="com.sinosoft.utility.string.Str"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLclaimFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLEndorseFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLCompensateFacade"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper" %>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmainSub"%>
<%@page import="com.sinosoft.prpall.bl.facade.BLPrpCengageFacade" %>

<%
	String strCode = "";
	String strName = "";
	boolean isChinese = true; //中文标志

	//对象定义部分

	int index = 0;
	PrpCmainDto prpMainDto = null; //保单的MainDto对象
	PrpCinsuredDto prpInsuredDto = null; //保单的InsuredDto对象
	PrpCitemCarDto PrpCitemCarDto = null; //保单的ItemcarDto对象
	PrpCcarDriverDto prpcarDriverDto = null; //保单的CarDriverDto对象
	PrpCitemKindDto prpCitemKindDto = null; //保单的ItemKindDto对象
	PrpCengageDto prpEngageDto = null; //保单的EngageDto对象
	com.sinosoft.prpall.dto.domain.PrpCengageDto prpEngageDtoMainSub = null;
	PrpLclaimDto prpLclaimDto = null; //ClaimDto对象
	PrpLdriverDto prpLdriverDto = null; //DriverDto对象
	PrpLthirdPartyDto prpLthirdPartyDto = null; //ThirdPartyDto对象
	PrpPheadDto prpPheadDto = null; //PheadDto对象
	//modify by lirj update begin 040211
	//reason:保险车辆出险信息建议显示报案出险摘要信息，目前只显示报案出险经过
	PrpLregistTextDto prpLregistTextDto = null;

	PrpCplanDto prpCplanDto = null;
	PrpLextDto prpLextDto = null;

	UICodeAction uiCodeAction = new UICodeAction();

	String strRegistNo1 = "";
	int intRegistCount = 0; //RegistDto对象的记录数
	int intInsuredCount = 0; //InsuredDto对象的记录数
	int intCarDriverCount = 0; //CarDriverDto对象的记录数
	int intItemKindCount = 0; //ItemKindDto对象的记录数
	int intItemCarCount = 0; //ItemCarDto对象的记录数
	int intEngageCount = 0; //EngageDto对象的记录数
	int intEngageCountTmp = 0; //textarea行数
	int intDriverCount = 0; //DriverDto对象的记录数
	int intThirdPartyCount = 0; //ThirdPartyDto对象的记录数
	int intPheadCount = 0; //PheadDto对象的记录数
	int intPheadCountTmp = 0;
	int intClaimCount = 0; //ClaimDto对象的记录数
	int intClaimCountTmp = 0;
	int intCompensateCount = 0; //Compensate对象的记录数   
	int intPlanCount = 0;

	String strInsuredNature = ""; //判断是自然人还是法人
	String strChangeLessFlag = ""; //判断是主驾驶还是副驾驶
	String strInsuredTerm = ""; //得到"/"的保险期间 
	String strClauseCode = ""; //得到特别约定代码：T0001
	String strClauses = ""; //得到特别约定内容
	String strFlag = ""; //判断是特别约定的名称还是内容，Flag[2]=0:名称，Flag[2]=1:内容
	String strEnrollDate = ""; //初次登记日期
	String strLicenseNo = ""; //保单中的号牌号码
	String strLicenseColorCode = ""; //保单中的号牌底色
	String strLicenseNo1 = ""; //理赔车辆信息中的号牌号码
	String strLicenseColorCode1 = ""; //理赔车辆信息中的号牌底色
	String strLicenseNo2 = ""; //号牌号码
	String strInsureCarFlag = ""; //是否为本保单车辆
	String strEndorseNo = ""; //批单号
	String strPheadText = ""; //批单信息
	String strClaimText = ""; //出险信息
	String strContext1 = ""; //出险摘要
	double dblSumPaid = 0; //赔款总计
	String policyNo = ""; //商业险保单号
	String DAZpolicyNo = ""; //交强险保单号
	String DAZStartDate = ""; //交强险起保日期
	String DAZEndDate = ""; //交强险终保日期
	String DAAStartDate = ""; //商业险起保日期
	String DAAEndDate = ""; //商业险终保日期
	String VINorFramNo = ""; //VIN码/车架号
	String DAZInsureDate = ""; //交强险保险期间
	String DAAInsureDate = ""; //商业险保险期间
	String strOperatorName = "";
	String strHandlerName = "";
	String strUnderwriteName = "";
	String strUserCode = "";
	String strUserName = "";
	String strInputDate = "";
	String strMessage = "";
	String strDelinquentFee = "";
	double douDelinquentFee = 0d;
	double douPlanFee = 0d;
	String[] strKindCode = new String[40];
	String[] strKindName = new String[40];
	String[] strDangerLevel = new String[40];//风险水平
	String[] douAmount = new String[40];
	String[] strItemKindFlag5 = new String[40];//不计免赔标志位
	String checkInfo = "";//查勘信息回复

	String strColorCode = "";//牌照颜色
	String outColorCode = "";//牌照颜色输出
	String strDirverFirstTime = "";//驾驶证初次领证日期
	String strInsuredCompany = "";//被保险人单位信息
	String strInsuredCompanyName = "";//被保险人单位信息
	String strCarClause = "";//基本条款类别
	String strCarClauseName = "";//基本条款类别名称
	double strSumPremium = 0;//保险费
	String strArgumentName = "";
	String strArgumentNumber = "";
	String strArgumentFirst = "";
	//取得policyDto，registDto，endorseDto
	RegistDto registDto = (RegistDto) request.getAttribute("registDto");
	PrpLregistDto prpLregistDto = (PrpLregistDto) request
			.getAttribute("prpLregistDto");
	PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");
	EndorseDto endorseDto = (EndorseDto) request
			.getAttribute("endorseDto");
	//报案前的抄单打印:报案的相关信息需要从页面来获取
	String strBizType = request.getParameter("bizType");
	String strmainPolicyNo = (String)request.getParameter("mainPolicyNo");
	if(strBizType != null && strBizType.equals("P")){
		policyNo = request.getParameter("PolicyNo");//保单号
		strLicenseNo = request.getParameter("licenseNo");
		//联系人
        //联系电话
        //报案时间
        //是否第一现场报案        
        //出险原因
        //出险地点
        //事故处理部门
		String strDamageStartDate = request.getParameter("damageStartDate");//出险时间
		String strDamageStartHour = request.getParameter("damageStartHour");//出险小时
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		policyDto = endorseViewHelper.findForEndorBefore(policyNo, strDamageStartDate, strDamageStartHour);//出险时保单信息
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
        endorseDto = uiEndorseAction.findByConditions(policyNo);//批单信息
        registDto = new RegistDto();
        prpLregistDto = new PrpLregistDto();
        prpLregistDto.setPolicyNo(policyNo);
        prpLregistDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
        prpLregistDto.setDamageStartDate(new DateTime(strDamageStartDate));
        prpLregistDto.setDamageStartHour(strDamageStartHour);
        
        String riskType = uiCodeAction.translateRiskCodetoRiskType(policyDto.getPrpCmainDto().getRiskCode());
        if("RISKCODE_DAZ".equals(riskType) == false&&"RISKCODE_DAY".equals(riskType) == false &&"RISKCODE_DAU".equals(riskType) == false)
		{
	        if(policyDto.getPrpCmainSubDtoList().size() > 0){
	        	PrpCmainSubDto prpCmainSubDto = (PrpCmainSubDto)policyDto.getPrpCmainSubDtoList().get(0);
	        	if(prpCmainSubDto.getFlag().substring(0,1).equals("1")){
	        		PolicyDto rPolicyDto = new PolicyDto();
	        		if(prpLregistDto.getRiskCode().equals("0507")||prpLregistDto.getRiskCode().equals("0577")||prpLregistDto.getRiskCode().equals("0587")){
	        			rPolicyDto = endorseViewHelper.findForEndorBefore(prpCmainSubDto.getPolicyNo(),strDamageStartDate,strDamageStartHour);
	        		}else{
	        		    rPolicyDto = endorseViewHelper.findForEndorBefore(prpCmainSubDto.getMainPolicyNo(),strDamageStartDate,strDamageStartHour);
	        		}
	            	if (rPolicyDto.getPrpCitemKindDtoList() != null){
	    				 ArrayList rPrpCitemKindDtoList = rPolicyDto.getPrpCitemKindDtoList();
	    				 request.setAttribute("rPrpCitemKindDto",rPrpCitemKindDtoList);
	                }
	        	}
	        }
		}
        
	}
	ArrayList endroseDtoList = endorseDto.getPrpPheadDtoList(); //批单列表
	prpMainDto = policyDto.getPrpCmainDto();
	String strPolicyNo = prpLregistDto.getPolicyNo(); //保单号码

	Collection prpLregistDtoList = new ArrayList();
	String registInfo = "";
	PrpLregistDto prpLregistDto1 = null;
	UIRegistAction uiRegistAction = new UIRegistAction();
	prpLregistDtoList = (ArrayList) uiRegistAction
			.findSamePolicyRegist(strPolicyNo);
	Iterator it = prpLregistDtoList.iterator();
	//int count = 0;
	/*while (it.hasNext()) {
		count++;
		prpLregistDto1 = (PrpLregistDto) it.next();
		registInfo += "&nbsp;报案号：" + prpLregistDto1.getRegistNo()
		+ "&nbsp;&nbsp;报案时间："
		+ prpLregistDto1.getDamageStartDate() + "<br>";
		if (count > 2) {
			registInfo += "数据过多，请查看历次出险信息！";
			break;
		}
	}
    */
	//得到PrpCengage对象的记录数  
	if (policyDto.getPrpCengageDtoList() != null) {
		intEngageCount = policyDto.getPrpCengageDtoList().size();
	}

	UIClaimAction uiClaimAction = new UIClaimAction();
	String conditions = " PolicyNo='" + strPolicyNo + "'";
			//+ "' AND RegistNo !='" + prpLregistDto.getRegistNo()
			//+ "' AND ClaimDate<='" + prpLregistDto.getReportDate()
			//+ "' ";
	ArrayList listTemp = (ArrayList) uiClaimAction
			.findByConditions(conditions);
	if (listTemp != null) {
		intCompensateCount = listTemp.size();
	}

	//if(registDto.getPrpLregistTextDtoList()!=null){

	//}
	//保险期间
	strInsuredTerm = prpMainDto.getStartDate().getYear() + "年"
			+ prpMainDto.getStartDate().getMonth() + "月"
			+ prpMainDto.getStartDate().getDate() + "日"
			+ prpMainDto.getStartHour() + "时起至"
			+ prpMainDto.getEndDate().getYear() + "年"
			+ prpMainDto.getEndDate().getMonth() + "月"
			+ prpMainDto.getEndDate().getDate() + "日"
			+ prpMainDto.getEndHour() + "时止";
	//取得交强险与商业险的关联信息
	List prpcmainSubList = policyDto.getPrpCmainSubDtoList();
		if ("0507".equals(prpLregistDto.getRiskCode())
				||"0577".equals(prpLregistDto.getRiskCode())
				||"0587".equals(prpLregistDto.getRiskCode())) {
					DAZpolicyNo = prpLregistDto.getPolicyNo();
		}else{
			policyNo = prpLregistDto.getPolicyNo();
		}
	if ("0507".equals(prpLregistDto.getRiskCode())
			||"0577".equals(prpLregistDto.getRiskCode())
			||"0587".equals(prpLregistDto.getRiskCode())) {
		DAZInsureDate = strInsuredTerm;
	}else{
		DAAInsureDate = strInsuredTerm;
	}
		if (prpcmainSubList.size() > 0) {
			PrpCmainSubDto prpcmainDto = (PrpCmainSubDto) prpcmainSubList.get(0);
			if ("0507".equals(prpLregistDto.getRiskCode())
					||"0577".equals(prpLregistDto.getRiskCode())
					||"0587".equals(prpLregistDto.getRiskCode())) {
				if("P".equals(strBizType)){
					if(strmainPolicyNo!=null && !strmainPolicyNo.equals("")){
						policyNo = prpcmainDto.getPolicyNo();
					}else{
						policyNo = "--------";
					}
				}else{
					policyNo = prpcmainDto.getPolicyNo();
				}
				if (prpcmainDto.getStartDate().isEmpty()) {
					DAAInsureDate = "--------------------";
						} else {
					DAAInsureDate = prpcmainDto.getStartDate().getYear()
							+ "年" + prpcmainDto.getStartDate().getMonth()
							+ "月" + prpcmainDto.getStartDate().getDate()
							+ "日" + "0时起至"
							+ prpcmainDto.getEndDate().getYear() + "年"
							+ prpcmainDto.getEndDate().getMonth() + "月"
							+ prpcmainDto.getEndDate().getDate() + "日"
							+ "24时止";
						}
			}else{
				if("P".equals(strBizType)){
					if(strmainPolicyNo!=null && !strmainPolicyNo.equals("")){
						DAZpolicyNo = prpcmainDto.getMainPolicyNo();
					}else{
						DAZpolicyNo = "--------";
					}
				}else{
					DAZpolicyNo = prpcmainDto.getMainPolicyNo();
				}
				if (prpcmainDto.getStartDate().isEmpty()) {
					DAZInsureDate = "--------------------";
						} else {
					DAZInsureDate = prpcmainDto.getStartDate().getYear()
							+ "年" + prpcmainDto.getStartDate().getMonth()
							+ "月" + prpcmainDto.getStartDate().getDate()
							+ "日" + "0时起至"
							+ prpcmainDto.getEndDate().getYear() + "年"
							+ prpcmainDto.getEndDate().getMonth() + "月"
							+ prpcmainDto.getEndDate().getDate() + "日"
							+ "24时止";
						}
			}			
			BLEndorseFacade blEndorseFacade = new BLEndorseFacade();
			//将关联的交强险保单的批改信息添加进 批改列表中
			EndorseDto endorseDtoTemp = blEndorseFacade.findByConditions(DAZpolicyNo);
			if (endorseDtoTemp != null) {
				  endroseDtoList.addAll(endorseDtoTemp.getPrpPheadDtoList());
			}
		} else {
			if("0507".equals(prpLregistDto.getRiskCode())
					||"0577".equals(prpLregistDto.getRiskCode())
					||"0587".equals(prpLregistDto.getRiskCode())){
				
				policyNo="----------";
			}else{
				DAZpolicyNo = "----------";
			}
		}
	

	//得到PrpPhead对象  
	if (endroseDtoList != null) {
		intPheadCount = endroseDtoList.size();
	}
%>

<script language="javascript">
  function loadForm()
  {
    tdDAZPolicyNo.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交强险保单号：' + '<%=DAZpolicyNo%>';
    tdPolicyNo.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商业险保单号：' + '<%=policyNo%>';
<!--    tdPolicyNo1.innerHTML = '保险单号：' + '<%=prpLregistDto.getPolicyNo()%>'; -->
    tdRegistNo.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报案编号：' + '<%=prpLregistDto.getRegistNo()%>' + '&nbsp;';
    tdDAZInsureDate.innerHTML = '交强险保险期间：' + '<%=DAZInsureDate%>';
    tdDAAInsureDate.innerHTML = '商业险保险期间：' + '<%=DAAInsureDate%>';
    //*****报案信息表PrpLregist*****
<%        
    //报案方式
    strCode = "";
    strName = "";
    //strCode = StringConvert.encode(prpLregistDto.getReportType());
    //strName = uiCodeAction.translateCodeCode("ReportType",strCode,isChinese);
    
    String strReportType = prpLregistDto.getReportType();
   
    
    String strDateTemp = "";   
    if(prpLregistDto.getDamageStartHour()!=null){
//      if(prpLregistDto.getDamageStartHour().length()<2){
        strDateTemp = prpLregistDto.getDamageStartHour(); 
//      }else{
//        strDateTemp = prpLregistDto.getDamageStartHour().substring(0,2);
//      }
    	}
	
    
%>    
    tdReportType.innerHTML      = '报案方式：' + '<%=strReportType%><%//=prpLregistDto.getReportType()%>';
    tdReportorName.innerHTML    = '报案人：'   + '<%=prpLregistDto.getReportorName()%>';
    tdReportDate.innerHTML      = '报案时间：' + '<%=prpLregistDto.getReportDate()%>' + ' '+'<%=prpLregistDto.getReportHour()%>';
    tdLinkerName.innerHTML      = '联系人：'   + '<%=StringConvert.encode(prpLregistDto.getLinkerName())%>';
    //tdLinkerName1.innerHTML      = '联系人：'   + '<%=StringConvert.encode(prpLregistDto.getLinkerName())%>';
    tdPhoneNumber.innerHTML     = '联系电话：' + '<%=StringConvert.encode(prpLregistDto.getPhoneNumber())%>';
    //tdPhoneNumber1.innerHTML     = '联系电话：' + '<%=StringConvert.encode(prpLregistDto.getPhoneNumber())%>';
    //tdDamageStartDate.innerHTML = '出险时间：' + '<%=prpLregistDto.getDamageStartDate()%>';
    tdDamageStartDate.innerHTML = '出险时间：' + '<%=prpLregistDto.getDamageStartDate()%>'+ ' '+ '<%=strDateTemp%>';
    //modify by lirj update end 040219
    tdDamageName.innerHTML      = '出险原因：' + '<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdDamageAddress.innerHTML   = '出险地点：' + '<%=StringConvert.encode(prpLregistDto.getDamageAddress())%>';
<%
    //是否是第一现场报案
    strCode = ""; 
    strName = "";
    strCode = prpLregistDto.getFirstSiteFlag();
    if( strCode.equals("0") )
    {
      strName = "否";    
    }
    else 
    {
      strName = "是";  
    }
%>    
    tdFirstSiteFlag.innerHTML   = '第一现场报案：' + '<%=strName%>';
<!--    tdPersonInjure.innerHTML    = '伤亡人员：';  -->
 <!--   tdDamageAreaName.innerHTML  = '出险区域：'+'<%=prpLregistDto.getDamageAreaName()%>'; -->
  <!--  tdDamageAddressType.innerHTML  = '出险地点分类：'+'<%=uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true)%>'; -->
<%
    //处理部门
    strCode = "";
    strCode = StringConvert.encode(prpLregistDto.getHandleUnit());
    String strHandleUnit = uiCodeAction.translateCodeCode("HandleUnit",strCode,true);
    String strComCode = StringConvert.encode(policyDto.getPrpCmainDto().getComCode());
    String strComName = uiCodeAction.translateComCode(strComCode,true);
%>
    tdHandleUnit.innerHTML      = '事故处理部门：' + '<%=strHandleUnit%>';
    tdHandleUnit1.innerHTML = '承保公司：' +'<%=Str.encode(strComName)%>';
<%        
    //modify by liruijuan update end 031229
    //承保公司
    strName = "";
    strName = StringConvert.encode(prpLregistDto.getComName());
%>    
    
    //*****保险关系人表PrpCinsured*****
    tdInsuredName.innerHTML        = '被保险人：';
    tdInsuredAddress.innerHTML     = '被保险人住址：';
    tdInsuredPostCode.innerHTML    = '邮政编码：';
    tdMobile.innerHTML    = '移动电话：';
    tdCustomerType.innerHTML    = '客户类别：';
    tdInsuredCompany.innerHTML    = '被保险人单位性质：';
<% 
  String strInsuredFlag       = "";   //判断是投保人还是被保险人 
    if(policyDto.getPrpCinsuredDtoList()!=null){
    ArrayList prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
    intInsuredCount = prpCinsuredDtoList.size();
    for(index=0;index<intInsuredCount;index++)
    {
      prpInsuredDto = (PrpCinsuredDto)((ArrayList)prpCinsuredDtoList).get(index);       
      strInsuredFlag = prpInsuredDto.getInsuredFlag();
      strInsuredCompany =prpInsuredDto.getBusinessSource();
      strInsuredCompanyName = uiCodeAction.translateCodeCode("BusinessDetail",strInsuredCompany,isChinese);
      if( strInsuredFlag.equals("1") ) //被保险人
      {
        //关系人性质(即客户类别)
        strCode = "";
        strName = "";
        strCode = prpInsuredDto.getInsuredType();
        strName = uiCodeAction.translateCodeCode("InsuredType",strCode,isChinese);
%>
        tdInsuredName.innerHTML        = '被保险人：'    + '<%=StringConvert.encode(prpInsuredDto.getInsuredName())%>';
        tdInsuredAddress.innerHTML     = '被保险人地址：'+ '<%=StringConvert.encode(prpInsuredDto.getInsuredAddress())%>';
        tdInsuredPostCode.innerHTML    = '邮编：'    + '<%=StringConvert.encode(prpInsuredDto.getPostCode())%>';
        tdMobile.innerHTML    = '联系电话：'    + '<%=StringConvert.encode(prpInsuredDto.getMobile())==""?prpInsuredDto.getPhoneNumber():prpInsuredDto.getMobile()%>';
        tdInsuredCompany.innerHTML = '被保险人单位性质：'+ '<%=strInsuredCompanyName%>';
<%        
        //单位性质  (法人（即单位）才有单位性质内容)
        strCode = "";
        strName = "";        
        if( strInsuredNature.equals("4") ) //法人（即单位）
        {
          strCode = prpInsuredDto.getBusinessSort();
          strName = "&nbsp&nbsp(" + uiCodeAction.translateCodeCode("BusinessSort",strCode,isChinese) + ")";
        }
        else if( strInsuredNature.equals("3") ) //自然人（即个人）
        {
          strName = "";
        }
%>
        
<%        
      }
    }
    }
%>  
    //--------------保单基本信息表PrpCmain***** 
  
    //tdInsuredTerm.innerHTML   = '保险期间：'      + '<%=strInsuredTerm%>';
<%        
    // 保险费
    strSumPremium =prpMainDto.getSumPremium();
    
    
    //争议解决方式
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpMainDto.getArgueSolution());
    if( strCode.equals("1") )   //诉讼
    {
      strName = "诉讼";
    } 
    else if( strCode.equals("2") )   //仲裁
    {
      strName = "仲裁";
    }    
%>    
    tdSumPremium.innerHTML='保险费：' + '<%=strSumPremium%>';;   
    tdArgue.innerHTML='争议解决方式：'      + '<%=strName%>';
<%        
    //签单人
    strCode = "";
    strCode = StringConvert.encode(prpMainDto.getOperatorCode());
    strOperatorName = uiCodeAction.translateUserCode(strCode,isChinese);
    
    //经办人
    strCode = "";
    //modify by dengxh begin 20040823
    //reason:归属业务员
    //strCode = StringConvert.encode(prpMainDto.getHandlerCode());
    strCode = StringConvert.encode(prpMainDto.getHandler1Code());
    //modify by dengxh end 20040823
    strHandlerName = uiCodeAction.translateUserCode(strCode,isChinese);    
    //核保人
    strUnderwriteName = StringConvert.encode(prpMainDto.getUnderWriteName());

    //抄单人
    strUserCode = prpLregistDto.getOperatorCode();
    strUserName = uiCodeAction.translateUserCode(strUserCode,isChinese);
    
    //抄单日期
    strInputDate = DateTime.current().getYear() + "年"
                 + DateTime.current().getMonth() + "月"
                 + DateTime.current().getDay() + "日";
   
%>
    
    tdHandlerName.innerHTML    ='经办人：'   + '<%=strHandlerName%>';
    tdUnderwriteName.innerHTML ='核保人：'   + '<%=strUnderwriteName%>';
    tdUserName.innerHTML       ='抄单人：'   + '<%=strUserName%>';
    tdInputDate.innerHTML      ='抄单日期：' + '<%=strInputDate%>';
    tdOperatorName.innerHTML   ='签单人：'+'<%=strOperatorName%>';    
<% 
  if(registDto.getPrpLthirdPartyDtoList() != null){ 
    intThirdPartyCount = registDto.getPrpLthirdPartyDtoList().size();
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
        strLicenseNo = StringConvert.encode(prpLthirdPartyDto.getLicenseNo());
        //VIN码/车架号
        if(!"".equals(prpLthirdPartyDto.getVINNo())){
        	VINorFramNo = StringConvert.encode(prpLthirdPartyDto.getVINNo());
        }
        if("".equals(VINorFramNo)){
        	VINorFramNo = StringConvert.encode(prpLthirdPartyDto.getFrameNo());
        }else if(!"".equals(prpLthirdPartyDto.getFrameNo())){
        	VINorFramNo = VINorFramNo + "/" +StringConvert.encode(prpLthirdPartyDto.getFrameNo());
        }
%>                
        tdUseYears.innerHTML        = '已使用年限：'       + '<%=DataUtils.zeroToEmpty(prpLthirdPartyDto.getUseYears())%>' +'年';
<%    
        //号牌底色
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getLicenseColorCode());
        strName = "";
        strLicenseColorCode = strCode;
        strName = uiCodeAction.translateCodeCode("LicenseColor",strCode,isChinese);
%>                                                         
        tdVINorFramNo.innerHTML      = 'VIN码/车架号：' + '<%=VINorFramNo %>';
        tdBrandName.innerHTML        = '厂牌型号：'        + '<%=StringConvert.encode(prpLthirdPartyDto.getBrandName())%>';
   <!--     tdBrandName1.innerHTML        = tdBrandName.innerHTML ; -->
        tdEngineNo.innerHTML         = '发动机号：'        + '<%=StringConvert.encode(prpLthirdPartyDto.getEngineNo())%>';

        tdFrameNo.innerHTML          = '车架号：'          + '<%=StringConvert.encode(prpLthirdPartyDto.getFrameNo())%>';

        tdVinCode.innerHTML   = 'VIN号：' + '<%=StringConvert.encode(prpLthirdPartyDto.getVINNo())%>';       
<%        
        
        //车辆种类
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getCarKindCode());
        strName = uiCodeAction.translateCodeCode("CarKind",strCode,isChinese);
%>       
       tdCarType.innerHTML  = '车辆种类：'+ '<%=strName%>';
<%            
        //条款类别
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
  
        tdUseNatureCode.innerHTML = '车辆使用性质：';
        tdSeatCount.innerHTML     = '核定载客 '+ '&nbsp;&nbsp;' + ' 人' +  ' 核定载质量 '+ '&nbsp;&nbsp;' + ' 吨';
        tdRunAreaName.innerHTML    = '车辆行驶区域：';
        tdPurchasePrice.innerHTML  = '新车购置价：'+ '&nbsp;&nbsp;' + '元';
        tdCarRegistFirst.innerHTML = '车辆初次登记日期：'
<%  
      }
    } 
  }
%>
<%
    
    //------------机动车险标的信息表PrpCitemCar*****
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount = policyDto.getPrpCitemCarDtoList().size();
    for(index=0;index<intItemCarCount;index++)
    {
      PrpCitemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo2 = StringConvert.encode(PrpCitemCarDto.getLicenseNo()); 
      //modify by kangzhen
      strColorCode = PrpCitemCarDto.getLicenseColorCode();

      outColorCode=uiCodeAction.translateCodeCode("LicenseColor",strColorCode,isChinese);
      strCarClause=PrpCitemCarDto.getClauseType();
      strCarClauseName=uiCodeAction.translateCodeCode("ClauseType",strCarClause,isChinese);
                                        
      if( strLicenseNo2.equals(strLicenseNo) )
      {              
        //使用性质
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(PrpCitemCarDto.getUseNatureCode());
        strName = uiCodeAction.translateCodeCode("UseNature",strCode,isChinese);
        if(!"".equals(PrpCitemCarDto.getVINNo())){
            VINorFramNo = StringConvert.encode(PrpCitemCarDto.getVINNo());
        }
        if("".equals(VINorFramNo)){
            VINorFramNo = StringConvert.encode(PrpCitemCarDto.getFrameNo());
        }else if(!"".equals(PrpCitemCarDto.getFrameNo())){
            VINorFramNo = VINorFramNo + "/" +StringConvert.encode(PrpCitemCarDto.getFrameNo());
        }
%>        
        tdColorCode.innerHTML     ='号牌颜色：'         + '<%=outColorCode%>';
        tdLicenseNo.innerHTML       = '号牌号码：'         + '<%=strLicenseNo%>';
        tdUseNatureCode.innerHTML = '车辆使用性质：'      + '<%=strName%>';
        tdSeatCount.innerHTML     = '核定载客 '           + '<%=PrpCitemCarDto.getSeatCount()%>' + ' 人' + ' 核定载质量 '      + '<%=DataUtils.zeroToEmpty(PrpCitemCarDto.getTonCount())%>' + ' 吨';
        tdVINorFramNo.innerHTML      = 'VIN码/车架号：' + '<%=VINorFramNo %>';
        tdBrandName.innerHTML        = '厂牌型号：'        + '<%=StringConvert.encode(PrpCitemCarDto.getBrandName())%>';   
        tdEngineNo.innerHTML         = '发动机号：'        + '<%=StringConvert.encode(PrpCitemCarDto.getEngineNo())%>';  
<%          
        //初次登记日期
        strEnrollDate = PrpCitemCarDto.getEnrollDate().toString();
        if ( (strEnrollDate == null) || (strEnrollDate.equals("")) ) 
        {
          strEnrollDate = ""; 
        }
%>      
       tdCarRegistFirst.innerHTML = '车辆初次登记日期：'      + '<%=strEnrollDate%>';  
       tdUseYears.innerHTML        = '已使用年限：'       + '<%=DataUtils.zeroToEmpty(PrpCitemCarDto.getUseYears())%>' +'年';
<%            
        //行驶区域
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(PrpCitemCarDto.getRunAreaName());
        if( !strCode.equals("") )
        {
          strName = strCode;
        }
        else
        {
          strName = "中华人民共和国境内(不含港澳台)";
        }
%>        
        tdRunAreaName.innerHTML    = '车辆行驶区域：'    + '<%=strName%>';
        tdPurchasePrice.innerHTML  = '新车购置价：'      + '<%=new DecimalFormat("#,##0.00").format(PrpCitemCarDto.getPurchasePrice())%>' + '元';
<%
      }
    }
  }
%>
    //车险驾驶员信息表PrpLdriver*****
    tdDriverName.innerHTML         = '驾驶员姓名：';
    tdDrivingCarType.innerHTML     = '准驾车型：';
    
    tdDrivingLicenseNo.innerHTML   = '驾驶证号码：';
    tdDriverFirstTime.innerHTML = '驾驶证初次领证日期：';
<%  
  if(registDto.getPrpLdriverDtoList()!=null){
    intDriverCount = registDto.getPrpLdriverDtoList().size();
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(index) ;
      strLicenseNo1        = prpLdriverDto.getLicenseNo();
      strLicenseColorCode1 = prpLdriverDto.getLicenseColorCode();
     		
      strDirverFirstTime =prpLdriverDto.getReceiveLicenseDate().toString();
      if ( (strDirverFirstTime == null) || (strDirverFirstTime.equals("")) ) 
        {
          strDirverFirstTime = ""; 
        }
%>
      tdDriverName.innerHTML         = '驾驶员：'       + '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
      tdDrivingLicenseNo.innerHTML   = '驾驶证号码：'         + '<%=StringConvert.encode(prpLdriverDto.getDrivingLicenseNo())%>';
<%      
      if( strLicenseNo1.equals(strLicenseNo) && strLicenseColorCode1.equals(strLicenseColorCode) ) 
      {
%>        
        tdDriverName.innerHTML         = '驾驶员：'       + '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        tdDrivingCarType.innerHTML     = '准驾车型：'           + '<%=StringConvert.encode(prpLdriverDto.getDrivingCarType())%>';
        
        tdDrivingLicenseNo.innerHTML   = '驾驶证号码：'         + '<%=StringConvert.encode(prpLdriverDto.getDrivingLicenseNo())%>';
        tdDriverFirstTime.innerHTML = '驾驶证初次领证日期：'+'<%=strDirverFirstTime%>';
<%  
      }
    } 
  }
%>  

<%
  if(policyDto.getPrpCcarDriverDtoList()!=null){
    intCarDriverCount = policyDto.getPrpCcarDriverDtoList().size();
    for(index=0;index<intCarDriverCount;index++)
    {
      prpcarDriverDto = (PrpCcarDriverDto)policyDto.getPrpCcarDriverDtoList().get(index);      
      strChangeLessFlag = prpcarDriverDto.getChangelessFlag();
                           
      if( strChangeLessFlag.equals("1") )  //主驾驶
      {
      strArgumentName=prpcarDriverDto.getDriverName();
      strArgumentNumber=prpcarDriverDto.getDrivingLicenseNo();
      strArgumentFirst=prpcarDriverDto.getAcceptLicenseDate().toString();      
%>    
    tdArgumentName1.innerHTML = '<%=strArgumentName%>';
    tdArgumentNumber1.innerHTML = '<%=strArgumentNumber%>';
    tdArgumentFirst1.innerHTML = '<%=strArgumentFirst%>'; 
    tdArgumentSex1.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getSex())%>';
    tdDrivingCarType1.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getDrivingCarType())%>';
    //tdDrivingLicenseNo1.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getDrivingLicenseNo())%>';
<%
      }
      else if( strChangeLessFlag.equals("0") )  //从驾驶员
      { 
%>               
    tdArgumentName2.innerHTML = '<%=prpcarDriverDto.getDriverName()%>';
    tdArgumentNumber2.innerHTML = '<%=prpcarDriverDto.getDrivingLicenseNo()%>';
    tdArgumentFirst2.innerHTML = '<%=prpcarDriverDto.getAcceptLicenseDate().toString()%>'; 
    tdArgumentSex2.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getSex())%>';
    tdDrivingCarType2.innerHTML = '<%=StringConvert.encode(prpcarDriverDto.getDrivingCarType())%>';
       
<%
      }
    }
  }

%>

 
    //特别约定表PrpCengage*****
<% 
    strClauses = ""; 
    for(index=0;index<intEngageCount;index++) 
    {
      prpEngageDto = (PrpCengageDto)policyDto.getPrpCengageDtoList().get(index);
      strClauseCode = prpEngageDto.getClauseCode(); 
      String strTitleFlag =  prpEngageDto.getTitleFlag();
      strClauses += StringConvert.encode(prpEngageDto.getClauses());
    }
    
    //检查特别约定打出来是几行
    intEngageCountTmp = 0;    //textarea的行数
    
    for(index=0;index<strClauses.length();index++)
    {
      if(strClauses.substring(index,index+1).equals("\\"))
      {
        if(!(strClauses.substring(index).length()<4))
        {
          if(strClauses.substring(index,index+4).equals("\\r\\n"))
          {
             intEngageCountTmp += 1;    //只要有回车换行，intEngageCountTmp+1
          }
        }
      }
    }
    
    int x = 0;
    int y = 0;
    if(!(strClauses.length()<4))    //如果strClauses.length()>=4，判断strClauses结尾是文字，还是回车换行
    {
      x = strClauses.length()-4;
      y = strClauses.length();
      if(!strClauses.substring(x,y).equals("\\r\\n"))
      {
         intEngageCountTmp += 1;   
      }
    }
    else    //如果strClauses不足1行，intEngageCountTmp = 1; 
      intEngageCountTmp = 1; 
    
    if(intEngageCountTmp>9)
    {
%>  
      tdEngage.innerHTML = ' 特别约定：内容较多，请详见特别约定清单';
<%
    }
    else
    {
%>
      tdEngage.innerHTML = '<%=strClauses%>';
<%
    } 
%>
//关联保单号特别约定
<%
	String policyNoMainSub = "";
    strClauses = "";
	if ("0507".equals(prpLregistDto.getRiskCode())
			||"0577".equals(prpLregistDto.getRiskCode())
			||"0587".equals(prpLregistDto.getRiskCode())) {
		policyNoMainSub = policyNo;
	}else{
		policyNoMainSub = DAZpolicyNo;
	}
    BLPrpCengageFacade blPrpCengageFacade = new BLPrpCengageFacade();
    String CengageConditions = "PolicyNo= '" + policyNoMainSub +"'";
    ArrayList PrpCengageDtoList = (ArrayList)blPrpCengageFacade.findByConditions(CengageConditions);
	for(int Engageindex= 0;Engageindex<PrpCengageDtoList.size();Engageindex++){
		prpEngageDtoMainSub = (com.sinosoft.prpall.dto.domain.PrpCengageDto)PrpCengageDtoList.get(Engageindex);
	      strClauseCode = prpEngageDtoMainSub.getClauseCode(); 
	      String strTitleFlag =  prpEngageDtoMainSub.getTitleFlag();
	      strClauses += StringConvert.encode(prpEngageDtoMainSub.getClauses());
	}
intEngageCountTmp = 0;    //textarea的行数
    
    for(index=0;index<strClauses.length();index++)
    {
      if(strClauses.substring(index,index+1).equals("\\"))
      {
        if(!(strClauses.substring(index).length()<4))
        {
          if(strClauses.substring(index,index+4).equals("\\r\\n"))
          {
             intEngageCountTmp += 1;    //只要有回车换行，intEngageCountTmp+1
          }
        }
      }
    }
    
    x = 0;
    y = 0;
    if(!(strClauses.length()<4))    //如果strClauses.length()>=4，判断strClauses结尾是文字，还是回车换行
    {
      x = strClauses.length()-4;
      y = strClauses.length();
      if(!strClauses.substring(x,y).equals("\\r\\n"))
      {
         intEngageCountTmp += 1;   
      }
    }
    else    //如果strClauses不足1行，intEngageCountTmp = 1; 
      intEngageCountTmp = 1; 
    
    if(intEngageCountTmp>9)
    {
%>
     tdEngageMainSub.innerHTML = ' 特别约定：内容较多，请详见特别约定清单';
<%
    }
    else
    {
%>
      tdEngageMainSub.innerHTML = '<%=strClauses%>';
<%
    } 
%>


<%
    //批改信息表PrpPhead*****
    strPheadText = "";
    int intPheadCount1 = 0;
    String strEndorLastLine = "none";   //批改信息最后一行  
    String strEndorInfoLine6 = "";             //批改信息第六行  
     //liubvo
    if( intPheadCount>5 )
    {
      intPheadCountTmp = 5;
      strEndorLastLine = "";
      strEndorInfoLine6 = "none";
%>
    tdEndorseNo5.style.colspan="7";
    tdEndorseNo5.innerHTML = '&nbsp;……数据过多，请查看历次批改信息……';
    tdEndorDate5.style.display = 'none';
    tdEndorType5.style.display = 'none';
    tdChgPremium5.style.display = 'none';
<%
    }
    else
    {
      intPheadCountTmp = intPheadCount;
    }
    //intPheadCount = endorseDto.getPrpPHeadDtoList().size();
    for(index=0;index<intPheadCountTmp;index++)
    { 
      String EndorDate = "";  //批改日期
      String EndorTypeName = ""; //批改类型名称
      String ChgPremium = "0.0";       //保费变化量
      prpPheadDto = (PrpPheadDto)endroseDtoList.get(index); 
      strEndorseNo   = prpPheadDto.getEndorseNo();      
      if(!("56").equals(prpPheadDto.getEndorType())){
    	  EndorDate =  prpPheadDto.getEndorDate().getYear()
                      + "-" + prpPheadDto.getEndorDate().getMonth()
                      + "-" + prpPheadDto.getEndorDate().getDate();
    	  String[] endorseTypeTemp = prpPheadDto.getEndorType().split(",");
    	  for(int i = 0;i < endorseTypeTemp.length;i++){
    		    if(i == 0 ){
    		        EndorTypeName =  new UICodeAction().translateCodeCode("EndorType",endorseTypeTemp[i],true) ;
    		    }else{
    		    	EndorTypeName += "，" + new UICodeAction().translateCodeCode("EndorType",endorseTypeTemp[i],true) ;    		  
    		    }
    	  }
      
    	  //得到blPrpPmain对象
          UIEndorseAction uiEndorseAction = new UIEndorseAction();   
          EndorseDto endorseDtoTemp = uiEndorseAction.findByPrimaryKey(strEndorseNo);
          PrpPmainDto PrpPmainDto = endorseDtoTemp.getPrpPmainDto();
      
          //得到保额变化量和保费变化量
          if (PrpPmainDto!=null) 
          {
        	  ChgPremium  = "" + new DecimalFormat("0.00").format(PrpPmainDto.getChgPremium());
          }        
      }else{
    	  intPheadCount1++;
    	  break;
      }
%>
    tdEndorseNo<%=index%>.innerHTML = '<%=strEndorseNo%>';
    tdEndorDate<%=index%>.innerHTML = '<%=EndorDate%>';
    tdEndorType<%=index%>.innerHTML = '<%=EndorTypeName%>';
    tdChgPremium<%=index%>.innerHTML = '<%=ChgPremium %>';
<%
    }       
%>  
   // trEndorInfoLine5.style.display = '<%=strEndorInfoLine6 %>'; 
  //  trEndorLast.style.display = '<%=strEndorLastLine %>'; 
/**
 *历次出险信息
 */
<%
    double SumPaid = 0;     //赔款总计
    int PayCount = 0;       //赔款次数
    String strDamageLastLine = "none";
    String strDamageLine6 = "";    
    String[] damageInfoRegistno       = new String[]{"","","","","","","",}; //报案号
    String[] damageInfoReportDate     = new String[]{"","","","","","","",};//报案时间
    String[] damageInfoStartDate      = new String[]{"","","","","","","",};//出险时间
    String[] damageInfoSumPay         = new String[]{"","","","","","","",};//赔付金额
    String[] damageInfoIsPersonInjure = new String[]{"","","","","","","",};//是否涉及人伤
    String[] damageInfoCaseTypeName   = new String[]{"","","","","","","",};//案件状态
    String[] damageInfoFlag           = new String[]{"","","","","","","",};//标识，商业险或交强险
    
    prpLregistDtoList = (ArrayList)uiRegistAction.findSamePolicyRegist(strPolicyNo);
    Iterator registIterator = prpLregistDtoList.iterator();
    String riskCode = "";
    int count = 0;         //计数器
    for(int k = 0;k < prpLregistDtoList.size();k++){
    	
    	prpLregistDto1 = (PrpLregistDto)registIterator.next();  
    	damageInfoIsPersonInjure[count] = "否";
    	if(  prpLregistDto1.getPersonInjureB() > 0 
    	  || prpLregistDto1.getPersonDeathB() > 0 
    	  || prpLregistDto1.getPersonInjureD1() > 0 
    	  || prpLregistDto1.getPersonDeathD1() > 0 ){
    		damageInfoIsPersonInjure[count] = "是";
    	}            
        damageInfoRegistno[count]   = prpLregistDto1.getRegistNo();
        damageInfoReportDate[count] = prpLregistDto1.getReportDate().toString();
        damageInfoStartDate[count]  = prpLregistDto1.getDamageStartDate().toString();
        riskCode = prpLregistDto1.getRiskCode();
        if("0507".equals(riskCode)||"0577".equals(riskCode)||"0587".equals(riskCode))
        {
        	damageInfoFlag[count] = "交强险";
        }else 
        {
        	damageInfoFlag[count] = "商业险";
        }
        if(!prpLregistDto1.getCancelDate().isEmpty() || prpLregistDto1.getCancelDate().toString().length() > 1){
        	damageInfoCaseTypeName[count]  = "已注销";
        	damageInfoSumPay[count]        = "————";        	
        }else {
        	String condition = "registno='" + prpLregistDto1.getRegistNo() + "' ";//and policyno='" + prpLregistDto1.getPolicyNo() + "' ";
        	
        	Collection claimList = new BLPrpLclaimFacade().findByConditions(condition);        	
        	if(claimList.size() < 1){
        		damageInfoCaseTypeName[count]  = "未结案";
                damageInfoSumPay[count]        = "————";      
        	}else{
        		Iterator claimIterator = claimList.iterator();
        		int currentIndex = count;
        		for(int j = 0;j < claimList.size();j++){
        			damageInfoRegistno[currentIndex + j]         = damageInfoRegistno[count];
        			damageInfoReportDate[currentIndex + j]       = damageInfoReportDate[count];
        			damageInfoStartDate[currentIndex + j]        = damageInfoStartDate[count];
        			damageInfoIsPersonInjure[currentIndex + j]   = damageInfoIsPersonInjure[count];
        			PrpLclaimDto prpLclaimDto1                   = (PrpLclaimDto)claimIterator.next();
        			riskCode  = prpLclaimDto1.getRiskCode();
        	        if("0507".equals(riskCode)||"0577".equals(riskCode)||"0587".equals(riskCode))
        	        {
        	        	damageInfoFlag[currentIndex + j] = "交强险";
        	        }else 
        	        {
        	        	damageInfoFlag[currentIndex + j] = "商业险";
        	        }
                    if(prpLclaimDto1 == null){
                    	damageInfoCaseTypeName[currentIndex + j]  = "未结案";
                        damageInfoSumPay[currentIndex + j]        = "————"; 
                    }else{
                        if("0".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j] = "已注销";
                        	damageInfoSumPay[currentIndex + j] = "————";
                        }else if("1".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j] = "已拒赔";
                        	damageInfoSumPay[currentIndex + j] = "————";
                        }else if("2".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j] = "已结案";
                        	damageInfoSumPay[currentIndex + j] = "" + prpLclaimDto1.getSumPaid();
                        	SumPaid += prpLclaimDto1.getSumPaid();
                        	PayCount += 1;
                        }else if(prpLclaimDto1.getCaseType() == null || "".equals(prpLclaimDto1.getCaseType())){
                        	damageInfoCaseTypeName[currentIndex + j]  = "未结案";
                            damageInfoSumPay[currentIndex + j]        = "————"; 
                        }
                    }
                   count = currentIndex + j;
        		}            		
        	}
        }
        
        if(count > 4){
            strDamageLastLine = "";
            strDamageLine6 = "none";  
            count = 5;
        }else{
        	count++;
        }        
    }
%>  
<%
    if("none".equals(strDamageLine6)){
%>
    tdDamageInfoLine61.colspan="7";
    tdDamageInfoLine61.innerHTML = '&nbsp;……数据过多，请查看历次出险信息……';
    tdDamageInfoLine62.colspan="0";
    tdDamageInfoLine63.colspan="0";
    tdDamageInfoLine64.colspan="0";
    tdDamageInfoLine65.colspan="0";
    tdDamageInfoLine66.colspan="0";
    tdDamageInfoLine67.colspan="0";
    
    tdDamageInfoLine62.style.display = 'none';
    tdDamageInfoLine63.style.display = 'none';
    tdDamageInfoLine64.style.display = 'none';
    tdDamageInfoLine65.style.display = 'none';
    tdDamageInfoLine66.style.display = 'none';
    tdDamageInfoLine67.style.display = 'none';
    
    
    //trDamageInfoLine6.style.display = '<%=strDamageLine6 %>';
    //trDamageLast.style.display = '<%=strDamageLastLine %>';
<% }%>
/*
 *涉及损失险别
 */
<%
    String strRefKind = "";     //涉及损失险别
    Set kindSet = new HashSet();    //存放涉及的险别代码
    UICodeAction uicodeAction = new UICodeAction();
    Collection claimList = new BLPrpLclaimFacade().findByConditions("registno='" + prpLregistDto.getRegistNo() + "'");  
    Iterator claimIterator = claimList.iterator();
    for(int k = 0;k < claimList.size();k++){
    	PrpLclaimDto prpLclaimDto1  = (PrpLclaimDto)claimIterator.next();
    	Collection prpLcompensateDtoList = new BLCompensateFacade().findByConditions("claimno='" + prpLclaimDto1.getClaimNo() + "'");
        Iterator compensateIterator = prpLcompensateDtoList.iterator();
        BLCompensateFacade blCompensateFacade = new BLCompensateFacade();
        for(int m = 0;m < prpLcompensateDtoList.size();m++){
            PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)compensateIterator.next();
            CompensateDto compensateDto = blCompensateFacade.findByPrimaryKey(prpLcompensateDto.getCompensateNo());
            if(compensateDto != null){
                //取涉及到标的赔付的险别
                for(int j = 0;j < compensateDto.getPrpLlossDtoList().size();j++){
                    PrpLlossDto prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(j);
                    kindSet.add(uicodeAction.translateKindCode(prpLlossDto.getRiskCode(),prpLlossDto.getKindCode(),true));
                }
                //取涉及到人伤赔付的险别
                for(int j = 0;j < compensateDto.getPrpLpersonLossDtoList().size();j++){
                    PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)compensateDto.getPrpLpersonLossDtoList().get(j);
                    kindSet.add(uicodeAction.translateKindCode(prpLpersonLossDto.getRiskCode(),prpLpersonLossDto.getKindCode(),true));
                }
            }
        }
    }
    
    claimIterator = kindSet.iterator();
    
    for(int k = 0;k < kindSet.size();k++){
    	strRefKind += "、" + claimIterator.next();
    }
    if(strRefKind.length() > 2){
        strRefKind = strRefKind.substring(1) + "。";	
    }
%>
    tdRefKind.innerHTML = '<%=strRefKind%>';
<%    
    strClaimText = "";

        strClaimText += " 出险日期：" + prpLregistDto.getDamageStartDate().getYear()
                        + "年" + prpLregistDto.getDamageStartDate().getMonth()
                        + "月" + prpLregistDto.getDamageStartDate().getDate()
                        + "日"+"<br>";
       
        strClaimText += " 出险原因：" + StringConvert.encode(prpLregistDto.getDamageName());
        strClaimText += "\\r\\n";
          //modify by lirj update begin 040211
        //reason:保险车辆出险信息建议显示报案出险摘要信息，目前只显示报案出险经过
        if(registDto.getPrpLregistTextDtoList()!=null){
         int intSizeTemp = registDto.getPrpLregistTextDtoList().size();
         if (intSizeTemp>0)
         {  
           for(int i=0;i<intSizeTemp;i++)
           {   
                 if ( ((PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i)).getTextType().trim().equals("1")) 
              {   
               prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i);  
               if(!prpLregistTextDto.getContext().trim().equals(""))  
               {          
               strContext1 += StringConvert.encode(prpLregistTextDto.getContext())+"\\r\\n";      
               }   
              }
              //add by wuxiaodong 050914 begain reasion 查勘回复信息取查勘报告
                if ( ((PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i)).getTextType().trim().equals("3")) 
              {   
               prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i);  
                if(!prpLregistTextDto.getContext().trim().equals(""))  
               {          
             checkInfo += StringConvert.encode(prpLregistTextDto.getContext())+"<br>";      
               }     
              }
              //add by wuxiaodong 050914 end
            }  
            if(!strContext1.trim().equals(""))  
            {
            strClaimText += strContext1;
            }
         }
       }  
         
        //modify by lirj update end 040211
    
    if(intCompensateCount>8)
    {
      strClaimText += "(其余出险信息请见立案)";
    }    
    //计算赔款总计
    for(int m=0;m<intCompensateCount;m++)
    {
      prpLclaimDto = (PrpLclaimDto)listTemp.get(m);
      dblSumPaid = dblSumPaid + prpLclaimDto.getSumPaid();
    }
%>  
    tdPheadCount.innerHTML      = '本单批改次数：'  + '<%=DataUtils.zeroToEmpty(intPheadCount - intPheadCount1)%>';
    tdClaimCount.innerHTML      = '车辆出险次数：'  + '<%=DataUtils.zeroToEmpty(intCompensateCount)%>';
    tdCompensateCount.innerHTML = '赔款次数：'      + '<%=DataUtils.zeroToEmpty(PayCount)%>';
    tdSumPaid.innerHTML         = '赔款总计：'      + '<%=DataUtils.zeroToEmpty(SumPaid)%>';   
    tdContext.innerHTML         = '出险经过及损失情况：<br>'+'<%=strClaimText%>';
<%

    if(policyDto.getPrpCitemKindDtoList()!=null){
     ArrayList rPrpCitemKindDtoList = (ArrayList)request.getAttribute("rPrpCitemKindDto");
      //对于老单子0501原有逻辑存在险种显示不全的问题
     if( rPrpCitemKindDtoList != null ){
      policyDto.getPrpCitemKindDtoList().addAll(rPrpCitemKindDtoList);
     }
     for(index=0;index<policyDto.getPrpCitemKindDtoList().size();index++){
           prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
           strKindCode[index] = prpCitemKindDto.getKindCode();
            
           strKindName[index] = prpCitemKindDto.getKindName();
           if(prpCitemKindDto.getFlag()!=null && prpCitemKindDto.getFlag().length()>=5 && "1".equals(prpCitemKindDto.getFlag().substring(4,5)))
           {
               strItemKindFlag5[index] = "是";
           }else if(prpCitemKindDto.getFlag()!=null && prpCitemKindDto.getFlag().length()>=5 && "0".equals(prpCitemKindDto.getFlag().substring(4,5)))
           {
               strItemKindFlag5[index] = "否";
           }else{
        	   strItemKindFlag5[index] = " ";
           }
           strDangerLevel[index] = "";
           if(prpCitemKindDto.getModeCode()!=null&&!prpCitemKindDto.getModeCode().equals("")&&(prpCitemKindDto.getKindCode().equals("A")||prpCitemKindDto.getKindCode().equals("B"))){
               if(prpCitemKindDto.getModeCode().equals("1")){strDangerLevel[index] = "(风险水平A)";}
               if(prpCitemKindDto.getModeCode().equals("2")){strDangerLevel[index] = "(风险水平B)";}
               if(prpCitemKindDto.getModeCode().equals("3")){strDangerLevel[index] = "(风险水平C)";}
           }
             if(prpCitemKindDto.getAmount()==0){
            	 if("F".equals(strKindCode[index])){
                     douAmount[index] = prpCitemKindDto.getModeName();
                 }else{
                	 douAmount[index]   = "";
                 }
             }else{
            	 if("F".equals(strKindCode[index])){
                     douAmount[index] = prpCitemKindDto.getModeName();
                 }else{
                     douAmount[index] = String.valueOf(new DecimalFormat("#,##0.00").format(prpCitemKindDto.getAmount()));         
                 }
             }
     }
   }
%>
 <!--  tdDelinquentFee.innerHTML  = '是否足额交费：';  -->
 <!--  tdPlanFee.innerHTML        = '应收保费：' ; -->
<!--   tdPlanDate.innerHTML       = '交费日期：'; -->
<%
  String strPlanFee = "";
  if(policyDto.getPrpCplanDtoList()!=null){
    intPlanCount = policyDto.getPrpCplanDtoList().size();
    for(index=0;index<intPlanCount;index++){
      prpCplanDto = (PrpCplanDto)policyDto.getPrpCplanDtoList().get(index);    
      douDelinquentFee = prpCplanDto.getDelinquentFee();
      if(douDelinquentFee==0){
        strDelinquentFee = "是";
        strPlanFee = "已足额交费";
      }else{
        strDelinquentFee = "否";
        strPlanFee = "还欠保费："+douDelinquentFee;
      }
%>
 <!--  tdDelinquentFee.innerHTML  = '是否足额交费：'+'<%=strDelinquentFee%>';  -->
  <!-- tdPlanFee.innerHTML        = '应收保费：' +'<%=strPlanFee%>'; -->
  <!-- tdPlanDate.innerHTML       = '交费日期：'+'<%=prpCplanDto.getPlanDate()%>'; -->
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
<!--   tdPersonInjure.innerHTML = '人员伤亡情况：'+'<%=personInjure%>'; -->
<%
  }
%>
  }
</script>
 