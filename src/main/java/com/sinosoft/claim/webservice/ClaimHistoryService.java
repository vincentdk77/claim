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
	 * �ǳ���������ʷ��Ϣ��ѯ
	 * @param registNo
	 * @return
	 */
	public ClaimHistoryInfo getClaimHistoryInfo(String registNo){
		long serial = System.currentTimeMillis();
		logger.log("�ǳ���������ʷ��Ϣ��ѯ", 1,serial, "[registNo:"+registNo+"]");
		ClaimHistoryInfo claimHistoryInfo = new ClaimHistoryInfo();
		try{
			UIRegistAction uiRegistAction = new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			String riskCode = prpLregistDto.getRiskCode();
			//��������
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
			
			// ���ݱ����Ų�ѯ������Ϣ
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
						   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"��"+insureQuantity+"��";	
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
					agentCode = policyDto.getPrpCmainDto().getAgentCode(); // �����˴���
				}
				prpLregistDto.setAgentCode(agentCode);
				prpLregistDto.setAgentName(uiCodeAction
						.translateAgentName(agentCode));// �õ�����������
				// ���ñ���������״̬Ϊ �������ύ
				if (registDto.getPrpLclaimStatusDto() != null) {
					if (registDto.getPrpLclaimStatusDto().getStatus().equals("7"))
						registDto.getPrpLclaimStatusDto().setStatus("3");
					prpLregistDto.setStatus(registDto.getPrpLclaimStatusDto()
							.getStatus());
				} else {
					// ���ύ���Ѿ�������ϵ�״̬
					prpLregistDto.setStatus("4");
				}
			}
			
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
			// reason:���뱣�ձ����Ϣ�����ݣ������Ͽ���ֱ����ʾ�б��ձ�
			registDto.setPrpCitemKindDtoList(policyDto.getPrpCitemKindDtoList());
			// ����ԭ���¹�ԭ�������ȼ�������
			// �ֱ��a����ʾΪ��ײ��������⡢��ʩ����
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
			// ���ÿͻ�����
			if (!prpLregistDto.getInsuredCode().equals("")) {
				prpLregistDto.setCustomerType(uiCodeAction
						.getCustomerType(prpLregistDto.getInsuredCode()));
			}
			
			//���մ���
			this.getSamePolicyRegistInfo(prpLregistDto, policyNo, registNo);
			
			this.changeCodeToName(prpLregistDto);
			
			//��װ����
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
			logger.log("�ǳ���������ʷ��Ϣ��ѯ",serial,e);
		}
		logger.log("�ǳ���������ʷ��Ϣ��ѯ", 0,serial, claimHistoryInfo);
		return claimHistoryInfo;
	}
	
	/**
	 * �ǳ�����ʷ�б��ѯ
	 * @param policyNo
	 * @return
	 */
	public ClaimHistoryListInfo getClaimHistoryList(String policyNo){
		long serial = System.currentTimeMillis();
		logger.log("�ǳ�����ʷ�б��ѯ", 1,serial, "[policyNo:"+policyNo+"]");
		ClaimHistoryListInfo claimHistoryListInfo = new ClaimHistoryListInfo();
 		try{
			UIRegistAction uiRegistAction = new UIRegistAction();
			UIEndorseAction uiEndorseAction =new UIEndorseAction();
			
			// ���������Ϣ(����)
			ArrayList<PrpPheadDto> headList = (ArrayList<PrpPheadDto>)(uiEndorseAction.findByConditions(policyNo)).getPrpPheadDtoList();
			
			// ���������Ϣ(����)
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
            		// ���ñ�����Ϣ�������
        			prpLregistDto.setCompensateFeeDto(uiRegistAction.getCompensateFeeByRegistNo(prpLregistDto.getRegistNo()));
        			
        			ClaimHistoryRegistInfo claimHistoryRegistInfo = new ClaimHistoryRegistInfo();
            		claimHistoryRegistInfo.setRegistNo(prpLregistDto.getRegistNo());
            		claimHistoryRegistInfo.setDamageStartDate(format.format(prpLregistDto.getDamageStartDate()));
            		claimHistoryRegistInfo.setDamageAddress(prpLregistDto.getDamageAddress());
            		claimHistoryRegistInfo.setIsCancel((prpLregistDto.getCancelDate().toString()==null || "".equals(prpLregistDto.getCancelDate().toString()))?"0":"1");//�Ƿ�ע��
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
			logger.log("�ǳ�����ʷ�б��ѯ",serial,e);
		}
		logger.log("�ǳ�����ʷ�б��ѯ", 0,serial, claimHistoryListInfo);
		return claimHistoryListInfo;
	}
	
	
	/**
	 * ��ѯ�Ѿ����������ݣ�������ִ�����������ʾ
	 * 
	 * @param policyNo ������
	 * @param curRegistNo ��ǰ������
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
		int intRecentCount = 0; // �������ĳ��մ���
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// ת��������Ա�����ƣ��Լ��������,ȥ�����ڳ��ղ�λ���������
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null){
			rowCount = registList.size(); // �������ݵ���Ŀ
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
			 
			// ���Ϊ��һ�У������м��У����ұ����Ų�������һ�еģ�����С�����һ�еģ�
			if (rowNo == 0
					&& rowCount != 1
					|| ((rowNo != (rowCount - 1)) && (rowNo > 0) && (oldRegistNo
							.equals(nowRegistNo)))) {
				if (oldRegistNo.equals(nowRegistNo)) {
					prpLregistDtoTemp.setBrandName(prpLregistDtoPre
							.getBrandName()
							+ " " + prpLregistDtoTemp.getBrandName());
				}
				// ���ž�continue�ˣ�������Ҫ����intPerilCount����
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 ���ž�continue�ˣ�������Ҫ����intPerilCount����
				continue;
			}
			// ������м�¼

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// reason:����ǵ�һ�γ��� intPerilCount�Ͳ�Ӧ��������
			// ���γ��ղ���������
			if ((rowNo == rowCount - 1) && !curRegistNo.equals(nowRegistNo)
					&& (!oldRegistNo.equals(nowRegistNo))) {
				
				intPerilCount++;
			} else {
				if (rowCount != 1 && !curRegistNo.equals(nowRegistNo)) {
					intPerilCount++;
				}
			}
		}
		// ������յĴ���
		prpLregistDto.setPerilCount(intPerilCount);
		prpLregistDto.setRecentCount(intRecentCount);
	}
	
	/**
	 * ����PrpRegistDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param prpLcheckDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void changeCodeToName(PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// (1)����ҵ��Ա���Ƶ�ת��
		String handler1Code = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)����ҵ�������ת��
		String comCode = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLregistDto.setComName(comName);

		// (3)�ұ����Ƶ�ת��
		String estiCurrency = prpLregistDto.getEstiCurrency();
		String estiCurrencyName = uiCodeAction.translateCurrencyCode(
				estiCurrency, true);
		prpLregistDto.setEstiCurrencyName(estiCurrencyName);

		// (4)����Ǽǻ�����ת��
		String makeComCode = prpLregistDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeComCode, true);
		prpLregistDto.setMakeComName(makeComName);

		// (5)�������Ƶ�ת��
		String clauseType = prpLregistDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLregistDto.setClauseName(clauseName);

		// (6)�����û���ת��
		String operatorCode = prpLregistDto.getOperatorCode();
		String operatorName = uiCodeAction
				.translateUserCode(operatorCode, true);
		prpLregistDto.setOperatorName(operatorName);

		// (7)�����ŵ�ת��

		String handleUnit = prpLregistDto.getHandleUnit();
		String handleUnitName = "";
		if (handleUnit.length() > 0) {
			handleUnitName = uiCodeAction.translateCodeCode("HandleUnit",
					handleUnit, true);
			prpLregistDto.setHandleUnitName(handleUnitName);
		}
		//��8���ⰸ���ת��
		String claimType = prpLregistDto.getClaimType();
		if(claimType.length() > 0){
			prpLregistDto.setClaimTypeName(uiCodeAction.translateCodeCode("CaseCode", prpLregistDto.getClaimType(), true));
		}		
	}

}
