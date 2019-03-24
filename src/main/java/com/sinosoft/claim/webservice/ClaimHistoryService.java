package com.sinosoft.claim.webservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;

public class ClaimHistoryService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 非车险理赔历史信息查询
	 * @param registNo
	 * @return
	 */
	public ClaimHistoryInfo getClaimHistoryInfo(String registNo){
		long serial = System.currentTimeMillis();
		logger.log("非车险理赔历史信息查询", 1,serial, "[registNo:"+registNo+"]");
		ClaimHistoryInfo claimHistoryInfo = new ClaimHistoryInfo();
		try{
			UIRegistAction uiRegistAction = new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			String riskCode = prpLregistDto.getRiskCode();
			//险种名称
			UICodeAction uiCodeAction = new UICodeAction();
			String strTemp =uiCodeAction.translateRiskCode(riskCode ,true);
			if (strTemp!=null&&strTemp.length() >4){
				strTemp=strTemp.substring( 0,4);
			}
			String policyNo = "";
			policyNo = prpLregistDto.getPolicyNo();
			prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto
					.getReportHour()));
			prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(
					3, 5));
			prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,
					2));
			prpLregistDto.setDamageStartHour(StringConvert
					.toStandardTime(prpLregistDto.getDamageStartHour()));
			prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour()
					.substring(3, 5));
			prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour()
					.substring(0, 2));
			if(!"05".equals(prpLregistDto.getClassCode())){
				prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(),DateTime.YEAR_TO_DAY));
			}else{
				prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(),DateTime.YEAR_TO_SECOND));
			}
			
			// 根据保单号查询保单信息
			if (!prpLregistDto.getPolicyNo().equals("")) {
				policyNo = prpLregistDto.getPolicyNo();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String damageDate = sf.format(prpLregistDto.getDamageStartDate());
				String damageHour = String.valueOf(prpLregistDto.getDamageStartHour());
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHour );
				registDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
				prpLregistDto.setPolicyNo(policyNo);
				prpLregistDto.setHandler1Code(policyDto.getPrpCmainDto()
						.getHandler1Code());
				prpLregistDto.setStartDate(policyDto.getPrpCmainDto()
						.getStartDate().toString());
				prpLregistDto.setEndDate(policyDto.getPrpCmainDto().getEndDate()
						.toString());
				prpLregistDto.setComCode(policyDto.getPrpCmainDto().getComCode());

				prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto()
						.getInsuredCode());

				String strInsuredName = "";
				
				int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
				
				    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
						|| insureQuantity <= 1 ) {
					       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
					}
					else {
						   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";	
					}
				prpLregistDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
				prpLregistDto.setInsuredNameShow(strInsuredName);
				prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto()
						.getInsuredAddress());
				prpLregistDto.setSumAmount(policyDto.getPrpCmainDto()
						.getSumAmount());
				prpLregistDto.setEstiCurrencyName(uiCodeAction
						.translateCurrencyCode(prpLregistDto.getEstiCurrency(),
								true));
				String agentCode = "";
				if (policyDto.getPrpCmainDto() != null) {
					agentCode = policyDto.getPrpCmainDto().getAgentCode(); // 代理人代码
				}
				prpLregistDto.setAgentCode(agentCode);
				prpLregistDto.setAgentName(uiCodeAction
						.translateAgentName(agentCode));// 得到代理人名称
				// 设置报案操作的状态为 案件已提交
				if (registDto.getPrpLclaimStatusDto() != null) {
					if (registDto.getPrpLclaimStatusDto().getStatus().equals("7"))
						registDto.getPrpLclaimStatusDto().setStatus("3");
					prpLregistDto.setStatus(registDto.getPrpLclaimStatusDto()
							.getStatus());
				} else {
					// 已提交，已经处理完毕的状态
					prpLregistDto.setStatus("4");
				}
			}
			
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
			// reason:加入保险标的信息的内容，界面上可以直接显示承保险别
			registDto.setPrpCitemKindDtoList(policyDto.getPrpCitemKindDtoList());
			// 出险原因、事故原因按照优先级别排序
			// 分别黙认显示为碰撞、疏忽大意、措施不当
			prpLregistDto.setPrpLregistDamageCode(prpLregistDto.getDamageCode());
			prpLregistDto.setPrpLregistDamageTypeCode(prpLregistDto
					.getDamageTypeCode());
			
			PrpLextDto prpLextDto = registDto.getPrpLextDto();
			if (prpLextDto != null) {
				prpLregistDto.setCertiNo(prpLextDto.getCertiNo());
				prpLregistDto.setCertiType(prpLextDto.getCertiType());
				prpLregistDto.setPersonDeathB(prpLextDto.getPersonDeathB());
				prpLregistDto.setPersonInjureB(prpLextDto.getPersonInjureB());
				prpLregistDto.setPersonDeathD1(prpLextDto.getPersonDeathD1());
				prpLregistDto.setPersonInjureD1(prpLextDto.getPersonInjureD1());
				prpLregistDto.setFlag(prpLextDto.getFlag());
			}
			// 设置客户类型
			if (!prpLregistDto.getInsuredCode().equals("")) {
				prpLregistDto.setCustomerType(uiCodeAction
						.getCustomerType(prpLregistDto.getInsuredCode()));
			}
			
			//出险次数
			this.getSamePolicyRegistInfo(prpLregistDto, policyNo, registNo);
			
			this.changeCodeToName(prpLregistDto);
			
			//封装数据
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			claimHistoryInfo.setRegistNo(registNo);
			claimHistoryInfo.setRiskCode(riskCode);
			claimHistoryInfo.setRiskName(strTemp);
			claimHistoryInfo.setPolicyNo(policyNo);
			claimHistoryInfo.setInsuredCode(prpLregistDto.getInsuredCode());
			claimHistoryInfo.setInsuredName(prpLregistDto.getInsuredName());
			claimHistoryInfo.setPerilCount(""+prpLregistDto.getPerilCount());
			claimHistoryInfo.setDamageStartDate(prpLregistDto.getDamageStartDate());
			claimHistoryInfo.setDamageStartHour(prpLregistDto.getDamageStartHour());
			claimHistoryInfo.setDamageStartMinute(prpLregistDto.getDamageStartMinute());
			claimHistoryInfo.setDamageCode(prpLregistDto.getDamageCode());
			claimHistoryInfo.setDamageName(prpLregistDto.getDamageName());
			claimHistoryInfo.setStartDate(prpLregistDto.getStartDate());
			claimHistoryInfo.setStartHour(""+prpLregistDto.getStartHour());
			claimHistoryInfo.setEndDate(prpLregistDto.getEndDate());
			claimHistoryInfo.setEndHour(""+prpLregistDto.getEndHour());
			claimHistoryInfo.setReportDate(format.format(prpLregistDto.getReportDate()));
			claimHistoryInfo.setReportHour(prpLregistDto.getReportHour());
			claimHistoryInfo.setReportorName(prpLregistDto.getReportorName());
			claimHistoryInfo.setReportType(prpLregistDto.getReportType());
			claimHistoryInfo.setInputDate(format.format(prpLregistDto.getInputDate()));
			claimHistoryInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
			claimHistoryInfo.setLinkerName(prpLregistDto.getLinkerName());
			claimHistoryInfo.setAddressCode(prpLregistDto.getAddressCode());
			claimHistoryInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			claimHistoryInfo.setEstiCurrency(prpLregistDto.getEstiCurrency());
			claimHistoryInfo.setEstimateLoss(""+prpLregistDto.getEstimateLoss());
			claimHistoryInfo.setLossName(prpLregistDto.getLossName());
			claimHistoryInfo.setHandlerCode(prpLregistDto.getHandler1Code());
			claimHistoryInfo.setHandlerName(prpLregistDto.getHandler1Name());
			claimHistoryInfo.setComCode(prpLregistDto.getComCode());
			claimHistoryInfo.setComName(prpLregistDto.getComName());
			claimHistoryInfo.setOperatorCode(prpLregistDto.getOperatorCode());
			claimHistoryInfo.setOperatorName(prpLregistDto.getOperatorName());
			claimHistoryInfo.setMakeCom(prpLregistDto.getMakeCom());
			claimHistoryInfo.setMakeComName(prpLregistDto.getMakeComName());
			claimHistoryInfo.setReceiverName(prpLregistDto.getReceiverName());
			claimHistoryInfo.setRemark(prpLregistDto.getRemark());
			
		}catch(Exception e){
			e.printStackTrace();
			logger.log("非车险理赔历史信息查询",serial,e);
		}
		logger.log("非车险理赔历史信息查询", 0,serial, claimHistoryInfo);
		return claimHistoryInfo;
	}
	
	/**
	 * 非车险历史列表查询
	 * @param policyNo
	 * @return
	 */
	public ClaimHistoryListInfo getClaimHistoryList(String policyNo){
		long serial = System.currentTimeMillis();
		logger.log("非车险历史列表查询", 1,serial, "[policyNo:"+policyNo+"]");
		ClaimHistoryListInfo claimHistoryListInfo = new ClaimHistoryListInfo();
 		try{
			UIRegistAction uiRegistAction = new UIRegistAction();
			UIEndorseAction uiEndorseAction =new UIEndorseAction();
			
			// 获得批单信息(多条)
			ArrayList<PrpPheadDto> headList = (ArrayList<PrpPheadDto>)(uiEndorseAction.findByConditions(policyNo)).getPrpPheadDtoList();
			
			// 获得理赔信息(多条)
			ArrayList<PrpLregistDto> registList = (ArrayList<PrpLregistDto>)(uiRegistAction.findRegistsByPolicyno(policyNo));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(null != headList && headList.size()>0){
				ClaimHistoryPMainInfo[] claimHistoryPMainInfoList = new ClaimHistoryPMainInfo[headList.size()];
				for(int i=0;i<headList.size();i++){
					ClaimHistoryPMainInfo claimHistoryPMainInfo = new ClaimHistoryPMainInfo();
					PrpPheadDto prpPheadDto = headList.get(i);
					claimHistoryPMainInfo.setEndorseNo(prpPheadDto.getEndorseNo());
					claimHistoryPMainInfo.setUnderWriteEndDate(format.format(prpPheadDto.getUnderWriteEndDate()));
					claimHistoryPMainInfoList[i] = claimHistoryPMainInfo;
				}
				claimHistoryListInfo.setClaimHistoryPMainInfoList(claimHistoryPMainInfoList);
			}
			
            if(null != registList && registList.size()>0){
            	ClaimHistoryRegistInfo[] claimHistoryRegistInfoList = new ClaimHistoryRegistInfo[registList.size()];
            	for(int i=0;i<registList.size();i++){
            		PrpLregistDto prpLregistDto = registList.get(i);
            		// 设置报案信息的赔款金额
        			prpLregistDto.setCompensateFeeDto(uiRegistAction.getCompensateFeeByRegistNo(prpLregistDto.getRegistNo()));
        			
        			ClaimHistoryRegistInfo claimHistoryRegistInfo = new ClaimHistoryRegistInfo();
            		claimHistoryRegistInfo.setRegistNo(prpLregistDto.getRegistNo());
            		claimHistoryRegistInfo.setDamageStartDate(format.format(prpLregistDto.getDamageStartDate()));
            		claimHistoryRegistInfo.setDamageAddress(prpLregistDto.getDamageAddress());
            		claimHistoryRegistInfo.setIsCancel((prpLregistDto.getCancelDate().toString()==null || "".equals(prpLregistDto.getCancelDate().toString()))?"0":"1");//是否注销
            		CompensateFeeDto compensateFeeDto = prpLregistDto.getCompensateFeeDto();
            		if(null != compensateFeeDto){
            			claimHistoryRegistInfo.setSumPaid(String.valueOf(compensateFeeDto.getSumPaid()));
            		}else{
            			claimHistoryRegistInfo.setSumPaid("0.0");
            		}
            		claimHistoryRegistInfoList[i] = claimHistoryRegistInfo;
            	}
            	claimHistoryListInfo.setClaimHistoryRegistInfoList(claimHistoryRegistInfoList);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.log("非车险历史列表查询",serial,e);
		}
		logger.log("非车险历史列表查询", 0,serial, claimHistoryListInfo);
		return claimHistoryListInfo;
	}
	
	
	/**
	 * 查询已经报案的数据，计算出现次数来进行显示
	 * 
	 * @param policyNo 保单号
	 * @param curRegistNo 当前报案号
	 * @throws Exception
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void getSamePolicyRegistInfo(PrpLregistDto prpLregistDto,String policyNo, String curRegistNo) throws Exception {
		UIRegistAction uiRegistAction = new UIRegistAction();
		ArrayList registList = new ArrayList();
		PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
		PrpLregistDto prpLregistDtoPre = new PrpLregistDto();
		registList = (ArrayList) uiRegistAction.findSamePolicyRegist(policyNo);
		int intPerilCount = 0;
		int intRecentCount = 0; // 最近几天的出险次数
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// 转换操作人员的名称，以及计算个数,去掉由于出险部位引起的问题
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null){
			rowCount = registList.size(); // 计算数据的数目
		}

		if (curRegistNo == null)
			curRegistNo = "";
		for (rowNo = 0; rowNo < rowCount; rowNo++) {
			oldRegistNo = nowRegistNo;
			prpLregistDtoPre = prpLregistDtoTemp;
			prpLregistDtoTemp = (PrpLregistDto) registList.get(rowNo);
			nowRegistNo = prpLregistDtoTemp.getRegistNo();
			intervalDay = DateTime.intervalDay(prpLregistDtoTemp
					.getDamageStartDate(), 0, dateTime, 0);
            
			 if (intervalDay <= Integer.parseInt(priorDate)) {
				intRecentCount++;
			 }
			 
			// 如果为第一行，或者中间行，并且报案号不等于上一行的，或者小于最后一行的，
			if (rowNo == 0
					&& rowCount != 1
					|| ((rowNo != (rowCount - 1)) && (rowNo > 0) && (oldRegistNo
							.equals(nowRegistNo)))) {
				if (oldRegistNo.equals(nowRegistNo)) {
					prpLregistDtoTemp.setBrandName(prpLregistDtoPre
							.getBrandName()
							+ " " + prpLregistDtoTemp.getBrandName());
				}
				// 接着就continue了，这里需要补个intPerilCount记数
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 接着就continue了，这里需要补个intPerilCount记数
				continue;
			}
			// 添加上行记录

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// reason:如果是第一次出险 intPerilCount就不应该再增加
			// 本次出险不计算在内
			if ((rowNo == rowCount - 1) && !curRegistNo.equals(nowRegistNo)
					&& (!oldRegistNo.equals(nowRegistNo))) {
				
				intPerilCount++;
			} else {
				if (rowCount != 1 && !curRegistNo.equals(nowRegistNo)) {
					intPerilCount++;
				}
			}
		}
		// 计算出险的次数
		prpLregistDto.setPerilCount(intPerilCount);
		prpLregistDto.setRecentCount(intRecentCount);
	}
	
	/**
	 * 根据PrpRegistDto中的已经设置的代码内容，对代码进行名称转换
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLcheckDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// (1)归属业务员名称的转换
		String handler1Code = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)归属业务机构的转换
		String comCode = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLregistDto.setComName(comName);

		// (3)币别名称的转换
		String estiCurrency = prpLregistDto.getEstiCurrency();
		String estiCurrencyName = uiCodeAction.translateCurrencyCode(
				estiCurrency, true);
		prpLregistDto.setEstiCurrencyName(estiCurrencyName);

		// (4)理赔登记机构的转换
		String makeComCode = prpLregistDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeComCode, true);
		prpLregistDto.setMakeComName(makeComName);

		// (5)条款名称的转换
		String clauseType = prpLregistDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLregistDto.setClauseName(clauseName);

		// (6)操作用户的转换
		String operatorCode = prpLregistDto.getOperatorCode();
		String operatorName = uiCodeAction
				.translateUserCode(operatorCode, true);
		prpLregistDto.setOperatorName(operatorName);

		// (7)处理部门的转换

		String handleUnit = prpLregistDto.getHandleUnit();
		String handleUnitName = "";
		if (handleUnit.length() > 0) {
			handleUnitName = uiCodeAction.translateCodeCode("HandleUnit",
					handleUnit, true);
			prpLregistDto.setHandleUnitName(handleUnitName);
		}
		//（8）赔案类别转换
		String claimType = prpLregistDto.getClaimType();
		if(claimType.length() > 0){
			prpLregistDto.setClaimTypeName(uiCodeAction.translateCodeCode("CaseCode", prpLregistDto.getClaimType(), true));
		}		
	}

}
