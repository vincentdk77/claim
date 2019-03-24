package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpDpersonPayAction;
import com.sinosoft.claim.ui.control.action.UIPrpLpersonAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class CompensateGenerateImplDubangViewHelper extends CompensateGenerateViewHelper{
	private static Log logger = LogFactory.getLog(CompensateGenerateImplDubangViewHelper.class);
	private static CompensateGenerateImplDubangViewHelper compensateGenerateImplDubangViewHelper= new CompensateGenerateImplDubangViewHelper();
	private CompensateGenerateImplDubangViewHelper(){
		//��ֹ���죬ͨ��getInstance()���ʵ����
	}
	public static CompensateGenerateImplDubangViewHelper getInstance(){
		return compensateGenerateImplDubangViewHelper;
	}
	
	/**
	 * ���ɻ����������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void compensateGenerate(HttpServletRequest httpServletRequest, CompensateDto compensateDto) throws UserException, Exception {
		CompensateData compensateData = new CompensateData(); 

		compensateDto.setPrpLctextDtoDtoList(new ArrayList());

		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		String strPolicyNo = compensateDto.getPrpLcompensateDto().getPolicyNo();
		compensateDto.setPrpLclaimDto(UIClaimAction.getInstance().findByPrimaryKey(claimNo).getPrpLclaimDto());

		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
		PrpLclaimDto prpLclaimDto = compensateDto.getPrpLclaimDto();
		String strSumPrePaid = httpServletRequest.getParameter("prpLcompensateSumPrePaid");
		double SumPrePaid = 0;
		if(strSumPrePaid != null && !"".equals(strSumPrePaid)){
			SumPrePaid = Double.parseDouble(strSumPrePaid);
		}
		// �Ƿ�Ϊ���ݰ���
		compensateData.strEscapeFlag = prpLclaimDto.getEscapeFlag();

		// add by qinyongli start 2005-8-5 ��ȡ����ʱ��
		String registNo = compensateDto.getPrpLclaimDto().getRegistNo();
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		// add by qinyongli end
		// ȡ�ñ�������Ϣ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
				strPolicyNo, 
				registDto.getPrpLregistDto().getDamageStartDate().toString(), 
				registDto.getPrpLregistDto().getDamageStartHour()
		);

		PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
		if (policyDto.getPrpCitemCarDtoList().size() > 0) {
			PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
		}

		ArrayList vecKindCode = new ArrayList();
		/**
		 * �ȳ�ʼ��A�ռ�B��,�ټ��ð�����A��B��,û����ɾ��
		 */
		vecKindCode.add("A");
		vecKindCode.add("B");

		boolean isHaveRiskA = false;
		boolean isHaveRiskB = false;
		for (Iterator iter = compensateDto.getPrpLlossDtoList().iterator(); iter.hasNext();) {
			PrpLlossDto prpLlossDto = (PrpLlossDto) iter.next();
			if (prpLlossDto.getFamilyName() == null || prpLlossDto.getFamilyName().length() == 0) {
				// ���ƺ���
				prpLlossDto.setFamilyName(prpLclaimDto.getLossName());// ���ӳ��ƺ���
			}
			if ("A".equals(prpLlossDto.getKindCode())) {
				isHaveRiskA = true;
				if (PrpCitemCarDto.getPurchasePrice() <= 0)
					PrpCitemCarDto.setPurchasePrice(prpLlossDto.getAmount());
			}else if ("B".equals(prpLlossDto.getKindCode())){
				isHaveRiskB = true;
			}
			if(!(vecKindCode.contains(prpLlossDto.getKindCode()))){
				vecKindCode.add(prpLlossDto.getKindCode());
			}
		}

		for (Iterator iter = compensateDto.getPrpLpersonLossDtoList().iterator(); iter.hasNext();) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iter.next();
			if ("A".equals(prpLpersonLossDto.getKindCode())){
				isHaveRiskA = true;
			}else if ("B".equals(prpLpersonLossDto.getKindCode())){
				isHaveRiskB = true;
			}else if(!(vecKindCode.contains(prpLpersonLossDto.getKindCode()))){
				vecKindCode.add(prpLpersonLossDto.getKindCode());
			}
		}
		//�����շſ�ʩ�ȷѵ����룬�Ӷ���û���������ձ��������յ�ʩ�ȷ�ʱ����Ȼ��CarCreateForB()������
		for (Iterator iter = compensateDto.getPrpLchargeDtoList().iterator(); iter.hasNext();) {
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) iter.next();
			if ("B".equals(prpLchargeDto.getKindCode()) && "03".equals(prpLchargeDto.getChargeCode())){
				isHaveRiskB = true;
			}
		}
		
		if(!isHaveRiskA){
			vecKindCode.remove("A");
		}		
		if(!isHaveRiskB){
			vecKindCode.remove("B");
		}

		logger.debug("��ʼ���ɸ��ձ�Ĺ�ʽ������");	
		
		for (Iterator iter = vecKindCode.iterator(); iter.hasNext();) {
			String kindCode = (String) iter.next();
			logger.debug("kindCode==" + kindCode);
			if("A".equals(kindCode)){
				CarCreateForA(httpServletRequest, compensateDto,compensateData);
			}else if("B".equals(kindCode) || "D3".equals(kindCode) || "D4".equals(kindCode)){
				CarCreateForB(httpServletRequest, kindCode,compensateDto,compensateData);
			}else{
				CarCreateForOther(kindCode, httpServletRequest, compensateDto,compensateData);
			}
		}

		logger.debug("��ʼ���ɱ���ʵ���ʽ������");

		List strLctextList = new ArrayList();
		strLctextList.add("");

		String lineText="";
		if (vecKindCode.size() > 0) {
			lineText = "����ʵ����=";

			for (Iterator iter = vecKindCode.iterator(); iter.hasNext();) {
				String kindCode = (String) iter.next();
				if ("A".equals(kindCode)) {
					lineText += "��������";
				}else if ("B".equals(kindCode)) {
					lineText += "��������������";
				}else if("D3".equals(kindCode)){
					lineText += "������Ա������-˾����λ��";
				}else if("D4".equals(kindCode)){
					lineText += "������Ա������-�˿���λ��";
				}else if("G".equals(kindCode)){
					lineText += "ȫ����������";
				}else {
					if(lineText.indexOf("���������") == -1){
						lineText += "��������";
					}
					
				}
			}
			if (StringUtils.getBytesLength(lineText) > 14){
				lineText = lineText.substring(0, (lineText.length() - 1));
			}
			
			if(SumPrePaid > 0){
				lineText += " - Ԥ�����";
			}
			strLctextList.add(lineText);
			lineText = "";
			boolean isContain_dblOtherSumRealPay = false;
			for (Iterator iter = vecKindCode.iterator(); iter.hasNext();) {
				String kindCode = (String) iter.next();
				if("A".equals(kindCode)){
					lineText = "            " + "=" + formatPay(compensateData.dblCarSumRealPay+compensateData.dblChargeSumRealPay) + "��";
				}else if("B".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblThirdSumRealPay) + "��";
					else
						lineText += formatPay(compensateData.dblThirdSumRealPay) + "��";
				}else if("D3".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblDriverSumRealPay) + "��";
					else
						lineText += formatPay(compensateData.dblDriverSumRealPay) + "��";
				}else if("D4".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblPassengerSumRealPay) + "��";
					else
						lineText += formatPay(compensateData.dblPassengerSumRealPay) + "��";
				}else if("G".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblStealSumRealPay) + "��";
					else
						lineText += formatPay(compensateData.dblStealSumRealPay) + "��";
				}else{
					if(!isContain_dblOtherSumRealPay){
						if (lineText == null || lineText.length() == 0){						
							lineText = "            " + "="	+ formatPay(compensateData.dblOthSumRealPay + compensateData.dblNoFranchise) + "��";
						}else{
							lineText += formatPay(compensateData.dblOthSumRealPay + compensateData.dblNoFranchise) + "��";
						}
						isContain_dblOtherSumRealPay = true;
					}
				}
			}
			if (StringUtils.getBytesLength(lineText) > 14){
				lineText = lineText.substring(0, (lineText.length() - 1));
			}
			if(SumPrePaid > 0){
				lineText += " - " + SumPrePaid;
			}
			strLctextList.add(lineText);
			lineText = "            " + "=" + formatPay(compensateData.dblAllSumRealPay - SumPrePaid) + "Ԫ";
		}
		strLctextList.add(lineText);
		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
		for (Iterator iter = strLctextList.iterator(); iter.hasNext();) {
			lineText = (String) iter.next();
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(strCompensateNo);
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(ctextcount++);
			prpLctextDto.setContext(lineText);
			prpLctextDto.setFlag("");
			compensateData.prpLctextlist.add(prpLctextDto);
		}
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		prpLctextDto.setPrpLctextList(compensateData.prpLctextlist);
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
	}
	/**
	 * ���ɳ����յĹ�ʽ������
	 * @param httpServletRequest
	 * @param compensateDto
	 * @throws UserException
	 * @throws Exception
	 */
	public void CarCreateForA(HttpServletRequest httpServletRequest, CompensateDto compensateDto,CompensateData compensateData) throws UserException,Exception {
		UICodeAction uiCodeAction = UICodeAction.getInstance();
		PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();
		PrpLlossDto prpLlossDto = new PrpLlossDto();
		PrpLlossDto prpLlossDtobak = new PrpLlossDto();
		double dblsumloss = 0;
		double dblcarsumrealpay = 0;
		double dbdeductible = 0;

		double dblsumrest = 0;
		double dblsumdefloss = 0;
//		double dblcardeductible = 0;
		double dblValue = 0;	//��ֵ
		double dblsumDefPay = 0;


		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();

		String dedutibleAall = httpServletRequest.getParameter("prpLDeductible");
		if (dedutibleAall == null || dedutibleAall.equals("")) {
			dedutibleAall = "0";
		}

		// ==============ȡ�ñ�������Ϣ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
				compensateDto.getPrpLcompensateDto().getPolicyNo(),
				compensateDto.getPrpLcompensateDto().getDamageStartDate().toString(), 
				compensateDto.getPrpLcompensateDto().getDamageStartHour());

		if (policyDto.getPrpCitemCarDtoList().size() > 0) {
			prpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
		}

		List strLctextList = new ArrayList();
		String lineText = "";

		strLctextList.add("������ʧ�գ�");

		lineText =space(8)+"ʵ����=(";
		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
			if (prpLlossDto.getKindCode().equals("A")) {
				if (StringUtils.getBytesLength(lineText) + StringUtils.getBytesLength(prpLlossDto.getFeeTypeName()) > 60) {
					strLctextList.add(lineText);
					lineText = space(17) + prpLlossDto.getFeeTypeName() + "��";
				} else {
					lineText += prpLlossDto.getFeeTypeName() + "��";
				}
			}
		}
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			lineText = lineText.substring(0, (lineText.length() - 1));
			strLctextList.add(lineText);
			lineText = ")";  //LYM ���ò�ֵ����
		} else {
			lineText = lineText.substring(0, (lineText.length() - 1));
			lineText += ")";  //LYM ���ò�ֵ����
		}

		if (StringUtils.getBytesLength(lineText) + 10 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "���⳥������Э���⳥����";
		} else {
			lineText += "���⳥������Э���⳥����";
		}
		if (StringUtils.getBytesLength(lineText) + 10 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "�����α���";
		} else {
			lineText += "�����α���";
		}
		if (StringUtils.getBytesLength(lineText) + 11 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "��(1���¹�����������)��(1-����������)";
			strLctextList.add(lineText);
		} else {
			lineText += "��(1���¹�����������)��(1-����������)";
			strLctextList.add(lineText);
		}

		lineText = space(16) + "=(";

		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLlossDto.getRiskCode());
			if (prpLlossDto.getKindCode().equals("A")) {
				if ("D".equals(strRiskType)
						&& prpLlossDto.getFeeTypeCode().trim().equals("27")) {
					dblValue = prpLlossDto.getSumRest();
					continue;
				}

				if (StringUtils.getBytesLength(lineText) + 3 > 60) {
					strLctextList.add(lineText);
					lineText = space(17)	+ formatPay(prpLlossDto.getSumDefPay()) + "��";
				} else {
					lineText += formatPay(prpLlossDto.getSumDefPay()) + "��";
				}
				//dblsumloss += prpLlossDto.getSumLoss();
				dblsumloss += prpLlossDto.getSumDefPay();
				dblcarsumrealpay += prpLlossDto.getSumRealPay();
				//dbdeductible += prpLlossDto.getDeductible();

				//dblsumrest += prpLlossDto.getSumRest();

				prpLlossDtobak = new PrpLlossDto();
				PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
			}
		}

		lineText = lineText.substring(0, (lineText.length() - 1));
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + ")"; //LYM ���ò�ֵ����
		} else {
			lineText += ")"; //LYM ���ò�ֵ����
		}
		//dblsumloss = dblsumloss - dblsumrest; //LYM ���ò�ֵ����
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��";
			lineText += "��" + formatPay(prpLlossDtobak.getArrangeRate()) + "��";
		} else {
			lineText += "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��";
			lineText += "��" + formatPay(prpLlossDtobak.getArrangeRate())+ "��";
		}
		dblsumloss = dblsumloss * prpLlossDtobak.getClaimRate() / 100 * prpLlossDtobak.getArrangeRate() / 100;
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "��" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "��";
		} else {
			lineText += "��" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "��";
		}
		dblsumloss = dblsumloss * prpLlossDtobak.getIndemnityDutyRate() / 100;

		if (StringUtils.getBytesLength(lineText) + 10 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "��(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)" 
			+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
			strLctextList.add(lineText);
		} else {
			lineText += "��(1-"+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)" 
			+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
			strLctextList.add(lineText);
		}

		dblsumdefloss = dblsumloss
		* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
		* (1 - prpLlossDtobak.getDeductibleRate() / 100);


		lineText = space(16) + "=" + formatPay(dblsumdefloss) + "Ԫ";
		strLctextList.add(lineText);
		lineText = "";
		/*if (dblValue > 0 && dblsumdefloss > dblValue) {
			strLctextList.add(lineText);
			lineText = space(4) + "��ó�Ͷ�����Ը����������Ը���Ϊ" + formatPay(dblValue)	+ "Ԫ��";
			strLctextList.add(lineText);
			lineText = space(4) + "�ʳ�����ʵ���� =" + formatPay(dblsumdefloss) + "-" 	+ formatPay(dblValue) 
			+ "=" + formatPay(dblsumdefloss - dblValue) + "Ԫ";
			dblcarsumrealpay = dblcarsumrealpay - dblValue;
			strLctextList.add(lineText);
		}*/

		/*if (dblsumdefloss > prpLlossDtobak.getItemValue() && !prpCitemCarDto.getClauseType().equals("F11")) {
			strLctextList.add(lineText);
			lineText = space(4) + "�����ڵ��ڱ��ճ���ʵ�ʼ�ֵ,�������¼���:";
			strLctextList.add(lineText);
			lineText = space(6) + "�⸶��� = ���ճ���ʵ�ʼ�ֵ = " + formatPay(prpLlossDtobak.getItemValue()) + "Ԫ";
			dblcarsumrealpay = prpLlossDtobak.getItemValue();
			strLctextList.add(lineText);
		}*/


//		dblcardeductible = dblsumloss * prpLlossDtobak.getDeductibleRate() / 100;

		compensateData.dblCarSumRealPay += dblcarsumrealpay;

//		this.dblAllSumDeductible += dblcardeductible;

		compensateData.dblAllSumRealPay += dblcarsumrealpay;



		/**
		 * ��ʼ����ʩ�ȷѵļ���
		 */
		int chargecount = 0;
		int j = 0;
		double dblchargesumrealpay = 0;
		double dblRescuesumrealpay=0;
//		double dblchargedeductible=0;
		PrpLchargeDto[] arrPrpLchargeDto = new PrpLchargeDto[50];
		/**
		 * ���ȶԷ�����Ϣ���кϲ�����ͬ�ձ�ͬ�������ͬ�ұ�Ľ��з���
		 */
		for (int i = 0; i < compensateDto.getPrpLchargeDtoList().size(); i++) {
			
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) compensateDto.getPrpLchargeDtoList().get(i);
			//ֻ�㳵���յ���Ϣ
			if("A".equals(prpLchargeDto.getKindCode()))
			{
				/**
				 * ʩ�ȷ�Ҫ�����չ�ʽ���м���
				 */
				if ("03".equals(prpLchargeDto.getChargeCode())&& "A".equals(prpLchargeDto.getKindCode())) {				
					dblchargesumrealpay +=prpLchargeDto.getChargeReport()
					* prpLlossDtobak.getClaimRate()/100
					* prpLlossDtobak.getIndemnityDutyRate()/100
					* (1-prpLlossDtobak.getDutyDeductibleRate()/100)
					* (1-prpLlossDtobak.getDeductibleRate()/100);		
				}else{			
					dblchargesumrealpay += prpLchargeDto.getSumRealPay();
				}
	
				for (j = 1; j <= chargecount; j++) {
					if (arrPrpLchargeDto[j].getChargeCode().equals(prpLchargeDto.getChargeCode())
							&& arrPrpLchargeDto[j].getCurrency().equals(prpLchargeDto.getCurrency())
							&& "A".equals(arrPrpLchargeDto[j].getKindCode())) {
						arrPrpLchargeDto[j].setChargeReport(arrPrpLchargeDto[j].getChargeReport()+ prpLchargeDto.getChargeReport());
						arrPrpLchargeDto[j].setChargeAmount(arrPrpLchargeDto[j].getChargeAmount()+ prpLchargeDto.getChargeAmount());
						arrPrpLchargeDto[j].setSumRealPay(arrPrpLchargeDto[j].getSumRealPay()+ prpLchargeDto.getSumRealPay());
						break;
					}
				}
				if (j > chargecount) {
					chargecount++;
					if(arrPrpLchargeDto[chargecount]==null){
						arrPrpLchargeDto[chargecount] = new PrpLchargeDto();
					}	
					PropertyUtils.copyProperties(arrPrpLchargeDto[chargecount], prpLchargeDto);
				}
			}
		}

		if (chargecount > 0) {
			for (int i = 1; i <= chargecount; i++) {
				//�����㳵���յ�ʩ�ȷ�
				if ("03".equals(arrPrpLchargeDto[i].getChargeCode())) {
					/**
					 * ��ʼ����ʩ�ȷѵļ��㹫ʽ��
					 */
//					dblsumloss = arrPrpLchargeDto[i].getChargeAmount();
					//dblRescuesumrealpay = arrPrpLchargeDto[i].getSumRealPay();
					dblRescuesumrealpay = arrPrpLchargeDto[i].getChargeReport();

					lineText = space(8) + "ʩ�ȷ���=ʩ�ȷ��ý����⳥���������α���" + "��(1���¹�����������)��(1-����������)";
					strLctextList.add(lineText);
					lineText = space(16)+"="+formatPay(dblRescuesumrealpay) 
					+ "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��"
					+ "��" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "��"
					+ "��(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)" 
					+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
					strLctextList.add(lineText);	
					dblRescuesumrealpay = dblRescuesumrealpay
					* prpLlossDtobak.getClaimRate()/100
					* prpLlossDtobak.getIndemnityDutyRate()/100
					* (1-prpLlossDtobak.getDutyDeductibleRate()/100)
					* (1-prpLlossDtobak.getDeductibleRate()/100);
					
					lineText = space(16) + "="	+ formatPay(dblRescuesumrealpay) + "Ԫ";
					strLctextList.add(lineText);
//					dblsumdefloss = dblsumloss * prpLlossDto.getIndemnityDutyRate() / 100 * prpLlossDto.getDeductibleRate() / 100;
//					dblchargedeductible += dblsumdefloss;
				}
			}
		}
		compensateData.dblChargeSumRealPay += dblchargesumrealpay;
//		this.dblAllSumDeductible += dblchargedeductible;
		compensateData.dblAllSumRealPay += dblchargesumrealpay;


		/*
		 * ��ʼ���г����ʵ�⸶����(�������⸶���+ʩ�ȷ�-���������)
		 */
		dbdeductible = Double.parseDouble(dedutibleAall);
		lineText=space(6)+"����ʵ�⸶=ʵ����";
		if(dblRescuesumrealpay>0){
			lineText+="+ʩ�ȷ�";
		}
		if(dbdeductible>0){
			lineText+="-���������";
		}
		strLctextList.add(lineText);

		lineText = space(16)+"="+formatPay(dblsumdefloss);		
		if(dblRescuesumrealpay>0){
			lineText += "+" + formatPay(dblRescuesumrealpay);
		}

		if(dbdeductible>0){
			lineText += "-" + formatPay(dbdeductible);
		}
		strLctextList.add(lineText);

		if(dblRescuesumrealpay>0||dbdeductible>0){
			if(dblsumdefloss+dblRescuesumrealpay>=dbdeductible){
				lineText = space(16)+"="+formatPay(dblsumdefloss+dblRescuesumrealpay-dbdeductible) + "Ԫ";
			}else{
				lineText = space(16)+"=0" + "Ԫ";
			}
			strLctextList.add(lineText);
		}

		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
		for (Iterator iter = strLctextList.iterator(); iter.hasNext();) {
			lineText = (String) iter.next();
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(strCompensateNo);
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(ctextcount++);
			prpLctextDto.setContext(lineText);
			prpLctextDto.setFlag("");
			compensateData.prpLctextlist.add(prpLctextDto);
		}
	}

	/**
	 * ���������յ����㹫ʽ������
	 * @param httpServletRequest
	 * @param compensateDto
	 * @throws UserException
	 * @throws Exception
	 */
	public void CarCreateForB(HttpServletRequest httpServletRequest, String kindCode,CompensateDto compensateDto,CompensateData compensateData) throws UserException,Exception {
		
		PrpLlossDto prpLlossDto = new PrpLlossDto();
		PrpLlossDto prpLlossDtobak = new PrpLlossDto();
//		int repcount = 0;
		int licensenocount = 0;
		int personcount = 0;
		int textlosscount = 0;
		int textpersoncount = 0;
		int j = 0;
		int intpropflag = 0;
		//double dblsumdefamount = 0;    //�������˶��⳥�����α����Ļ�
		double dblsumloss = 0;
		double dblsumdefloss = 0;
		double dbldeductiblerate = 0;
		double dblDutydeductiblerate = 0;
		double dblDriverdeductiblerate = 0;
		double dblthirdsumrealpay = 0;
		double dblthirdsumdefloss = 0;
//		double dblthirddeductible = 0;
		double dblthirdsumperson = 0;
		double dblamount = 0;
		double dblthirdsumloss = 0;
		double dbldeductible = 0;
//		String[] strLctext = new String[300];
		String[] arrKindCode = new String[20];
		String[] arrLicenseNo = new String[20];
		String[] arrKindCode1 = new String[20];
		String[] arrPersonNo = new String[20];
		String[] arrPersonName = new String[20];
		String[] arrFamilyName = new String[20];
		String[] lossName = new String[20];
		String[] arrFeeReport = {};
		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
		String strFeeReport = "";
		PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
		PrpLpersonLossDto prpLpersonLossDtobak = new PrpLpersonLossDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		
		//ȡB�޶�---------------------------
		UIPolicyAction uiPolicyAction  = new UIPolicyAction (); 
		PolicyDto policyDto =uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
		ArrayList limitlist=policyDto.getPrpCitemKindDtoList();
		Iterator it =limitlist.iterator();
		if (limitlist!=null && limitlist.size()>0){
			while(it.hasNext()){
				PrpCitemKindDto  prpCitemKindDto =(PrpCitemKindDto)it.next();
				if (kindCode.equals(prpCitemKindDto.getKindCode())){
					dblamount =	prpCitemKindDto.getAmount();
					break;
				}
			}
		}		
		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);

			for (j = 1; j <= licensenocount; j++) {
				if (arrKindCode[j].indexOf(prpLlossDto.getKindCode()) < 0
						&& prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
					arrKindCode[j] = arrKindCode[j].trim() + prpLlossDto.getKindCode();
				if (prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
					break;
			}
			if (j > licensenocount && prpLlossDto.getLicenseNo() != null && prpLlossDto.getLicenseNo().length() > 0) {
				licensenocount++;
				lossName[licensenocount] = prpLlossDto.getLossName();
				arrLicenseNo[licensenocount] = prpLlossDto.getLicenseNo();
				arrKindCode[licensenocount] = prpLlossDto.getKindCode();
			}
			if ((prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
					&& prpLlossDto.getLossName() != null && prpLlossDto.getKindCode().equals(kindCode))
				intpropflag = 1;
		}
		for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
			prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
			for (j = 1; j <= personcount; j++) {
				if (arrKindCode1[j].indexOf(prpLpersonLossDto.getKindCode()) < 0
						&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
					arrKindCode1[j] = arrKindCode1[j].trim() + prpLpersonLossDto.getKindCode();
				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
					break;
			}
			if (j > personcount) {
				personcount++;
				arrKindCode1[personcount] = prpLpersonLossDto.getKindCode();
				arrPersonNo[personcount] = String.valueOf(prpLpersonLossDto.getPersonNo());
				arrPersonName[personcount] = prpLpersonLossDto.getPersonName();
				arrFamilyName[personcount] = prpLpersonLossDto.getFamilyName();
			}
		}

		List strLctextList = new ArrayList();
		String lineText = "";
		if(kindCode.equals("B")){
			 lineText = "�����������գ�";
		}else if("D3".equals(kindCode)){
			 lineText = "������Ա������-˾����λ��";
		}else if("D4".equals(kindCode)){
			 lineText = "������Ա������-�˿���λ��";
		}
		
		for (int i = 1; i <= licensenocount; i++) {
			dblsumloss = 0;
			if (arrKindCode[i].indexOf(kindCode) < 0)
				continue;
//			repcount++;
			strLctextList.add(lineText);
			lineText="";
			if (!lossName[i].trim().equals("����")) {
				lineText = space(4) + lossName[i].trim();
			} else {
				lineText = space(4) + arrLicenseNo[i].trim() + "�ų�";
			}
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "����ʵ����=(";
			textlosscount++;

			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
				if (prpLlossDto.getKindCode().equals(kindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
					if (StringUtils.getBytesLength(lineText) + prpLlossDto.getFeeTypeName().length() + 2 > 60) {
//						repcount++;
						strLctextList.add(lineText);
						lineText = space(17) + prpLlossDto.getFeeTypeName() + "��";
					} else {
						lineText += prpLlossDto.getFeeTypeName() + "��";
					}
				}
			}
			lineText = lineText.substring(0, (lineText.length() - 1)) + ")";

			// �����⳥����
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "���⳥������Э���⳥����";
			} else {
				lineText += "���⳥������Э���⳥����";
			}

			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "�����α���";
			} else {
				lineText += "�����α���";
			}
			if (StringUtils.getBytesLength(lineText) + 11 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��(1���¹�����������)����1-����������)";// ��(1-��ʻԱ������)";
			} else {
				lineText += "��(1���¹�����������)��(1-����������)";// ��(1-��ʻԱ������)";
			}
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(16) + "=(";

			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
				if (prpLlossDto.getKindCode().equals(kindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i].trim())) {
					if (StringUtils.getBytesLength(lineText) + 3 > 60) {
//						repcount++;
						strLctextList.add(lineText);
						lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "��";
					} else {
						lineText += formatPay(prpLlossDto.getSumDefPay()) + "��";
					}
					dbldeductiblerate = prpLlossDto.getDeductibleRate();
					dblDutydeductiblerate = prpLlossDto.getDutyDeductibleRate();
					dblDriverdeductiblerate = prpLlossDto.getDriverDeductibleRate();
					//dblamount = prpLlossDto.getAmount();
					dblsumloss += prpLlossDto.getSumDefPay();
					
					dblthirdsumrealpay += prpLlossDto.getSumRealPay();
					dblthirdsumloss += prpLlossDto.getSumRealPay();
					prpLlossDtobak = new PrpLlossDto();
					PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
				}
			}
			lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
			// prpLlossDto = prpLlossDtobak;

			// �����⳥����
			if (StringUtils.getBytesLength(lineText) + 8 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��";
				lineText+="��" + formatPay(prpLlossDtobak.getArrangeRate()) + "��";
			} else {
				lineText += "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��";
				lineText+="��" + formatPay(prpLlossDtobak.getArrangeRate()) + "��";
			}
			dblsumloss = dblsumloss * prpLlossDtobak.getClaimRate()/100 * prpLlossDtobak.getArrangeRate() / 100;
			if (StringUtils.getBytesLength(lineText) + 8 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "��";
			} else {
				lineText += "��"	+ formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "��";
			}
			dblsumloss = dblsumloss * prpLlossDtobak.getIndemnityDutyRate() / 100;
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��(1��"
				+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)" + "��(1��"
				+ formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";// + "��(1��"+new
				// DecimalFormat("#,##0.00").format(prpLlossDtobak.getDriverDeductibleRate())+"��)";
			} else {
				lineText += "��(1��"
					+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)" + "��(1��"
					+ formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";// + "��(1��"+new
				// DecimalFormat("#,##0.00").format(prpLlossDtobak.getDriverDeductibleRate())+"��)";
			}
			dblthirdsumdefloss += dblsumloss;

			// ���������ʽ�������⳥������Ϣ
			dblsumdefloss = dblsumloss //* (prpLlossDtobak.getClaimRate() / 100.0)
			* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
			* (1 - prpLlossDtobak.getDeductibleRate() / 100);// *(1 -
//			dbldeductible = dblsumloss * prpLlossDtobak.getDeductibleRate() / 100;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(16) + "=" + formatPay(dblsumdefloss) + "Ԫ";

//			dblthirddeductible += dbldeductible;
		}

		if (intpropflag == 1) {
			textlosscount++;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "�Ʋ��⸶:";
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(kindCode)
						&& (prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
						&& prpLlossDto.getLossName() != null) {
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(4) + "��Ŀ:" + prpLlossDto.getLossName();
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ����=��ʧ�������α�����(1���¹�����������)��(1-����������)";// ��(1-��ʻԱ������)";
					dblsumloss = 0;
					dblsumdefloss = 0;
					dbldeductiblerate = prpLlossDto.getDeductibleRate();
					dblDutydeductiblerate = prpLlossDto.getDutyDeductibleRate();
					//dblamount = prpLlossDto.getAmount();
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(16) + "="
					+ formatPay(prpLlossDto.getSumDefPay()) + "��"
					+ formatPay(prpLlossDto.getIndemnityDutyRate()) + "��" + "��"
					+ "(1-" + formatPay(prpLlossDto.getDutyDeductibleRate()) + "��)"
					+ "(1-" + formatPay(prpLlossDto.getDeductibleRate()) + "��)";// +
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(16) + "="	+ formatPay(prpLlossDto.getSumRealPay()) + "Ԫ";
					dblthirdsumrealpay += prpLlossDto.getSumRealPay();
					dblthirdsumloss += prpLlossDto.getSumRealPay();
					PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
					// prpLlossDtobak.setDto(prpLlossDto);
//					dbldeductible = prpLlossDto.getSumLoss() * prpLlossDto.getDeductibleRate() / 100;
//					dblthirddeductible += dbldeductible;
					dblthirdsumdefloss += prpLlossDto.getSumDefPay() * prpLlossDto.getIndemnityDutyRate() / 100
										  *prpLlossDto.getClaimRate()/100 * prpLlossDto.getArrangeRate()/100;
				}
			}
			// prpLlossDto.setDto(prpLlossDtobak);
		}

		// ��Ա�����
		for (j = 1; j <= personcount; j++) {
			if (arrKindCode1[j].indexOf(kindCode) < 0)
				continue;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "�������ƺ���Ϊ" + arrFamilyName[j].trim() + "�ĳ�����Ա" + "  "
			+ arrPersonName[j].trim() + "��";
			textpersoncount++;
			
			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
				if (prpLpersonLossDto.getKindCode().equals(kindCode)) {
					
					dbldeductiblerate = prpLpersonLossDto.getDeductibleRate();
					dblDutydeductiblerate = prpLpersonLossDto.getDutyDeductibleRate();
					dblDriverdeductiblerate = prpLpersonLossDto.getDriverDeductibleRate();
				}
				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])) {
//					repcount++;
					strLctextList.add(lineText);
					strFeeReport = this.CarCreateForFee(prpLpersonLossDto, compensateDto,compensateData);
					if (StringUtils.getBytesLength(strFeeReport) > 60) {
						arrFeeReport = (String[]) StringUtils.split(strFeeReport, 60);
						lineText = arrFeeReport[0];
//						repcount++;
						strLctextList.add(lineText);
						lineText = space(7) + arrFeeReport[1];
					} else {
						lineText = strFeeReport;
					}
				}
			}
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "����ʵ����=(";
			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
				if (prpLpersonLossDto.getKindCode().equals(kindCode)	&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim())) {
					if (StringUtils.getBytesLength(lineText)
							+ StringUtils.getBytesLength(prpLpersonLossDto.getLiabDetailName()) + 1 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + prpLpersonLossDto.getLiabDetailName() + "���⳥������";
					} else {
						lineText += prpLpersonLossDto.getLiabDetailName() + "���⳥������";
					}
				}
			}
			lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "�����α�����Э���⳥����";
			} else {
				lineText += "�����α�����Э���⳥����";
			}
			if (StringUtils.getBytesLength(lineText) + 11 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��(1���¹�����������)��(1-����������)";// ��(1-��ʻԱ������)";
			} else {
				lineText += "��(1���¹�����������)��(1-����������)";// ��(1-��ʻԱ������)";
			}
			dblsumloss = 0;
			dblsumdefloss = 0;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(16) + "=(";
			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);				
				if (prpLpersonLossDto.getKindCode().equals(kindCode)
						&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim())) {
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
//						repcount++;
						strLctextList.add(lineText);
						lineText = space(17)
						+ formatPay(prpLpersonLossDto.getSumDefPay()) + "��"  //LYM
						+ formatPay(prpLpersonLossDto.getClaimRate()) + "��" + "��";
					} else {
						lineText += formatPay(prpLpersonLossDto.getSumDefPay()) //LYM
						+ "��" + formatPay(prpLpersonLossDto.getClaimRate()) + "��"
						+ "��";
					}
					dblsumloss += prpLpersonLossDto.getSumDefPay() * prpLpersonLossDto.getClaimRate() * 0.01;  //LYM
					dblthirdsumrealpay += prpLpersonLossDto.getSumRealPay();
					
					dblthirdsumperson += prpLpersonLossDto.getSumRealPay();
					// prpLpersonLossDtobak.setDto(prpLpersonLossDto);

					PropertyUtils.copyProperties(prpLpersonLossDtobak, prpLpersonLossDto);
				}
			}
			lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
			// modify by zhanqiang begin 20031107
			// prpLpersonLossDto.setDto(prpLpersonLossDto);
			// modify by zhanqiang end 20031107
			if (StringUtils.getBytesLength(lineText) + 8 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��" + formatPay(prpLpersonLossDtobak.getIndemnityDutyRate()) + "��";
				lineText += "��" + formatPay(prpLpersonLossDtobak.getArrangeRate()) + "��";
			} else {
				lineText += "��"	+ formatPay(prpLpersonLossDtobak.getIndemnityDutyRate()) + "��";
				lineText += "��"	+ formatPay(prpLpersonLossDtobak.getArrangeRate()) + "��";
			}
			dblsumloss = dblsumloss * prpLpersonLossDtobak.getIndemnityDutyRate() / 100;
			dblsumloss = dblsumloss * prpLpersonLossDtobak.getArrangeRate() / 100;
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "��(1��"
				+ formatPay(prpLpersonLossDtobak.getDutyDeductibleRate()) + "��)"
				+ "��(1��" + formatPay(prpLpersonLossDtobak.getDeductibleRate())
				+ "��)";// +
			} else {
				lineText += "��(1��"
					+ formatPay(prpLpersonLossDtobak.getDutyDeductibleRate()) + "��)"
					+ "��(1��" + formatPay(prpLpersonLossDtobak.getDeductibleRate())
					+ "��)";// +
			}

			dblthirdsumdefloss += dblsumloss;
			dblsumdefloss = dblsumloss * (1 - prpLpersonLossDtobak.getDutyDeductibleRate() / 100)
			* (1 - prpLpersonLossDtobak.getDeductibleRate() / 100);
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(16) + "=" + formatPay(dblsumdefloss) + "Ԫ";
//			dbldeductible = dblsumloss * prpLpersonLossDtobak.getDeductibleRate() / 100;
//			dblthirddeductible += dbldeductible;
		}
		
		/**
		 * ��ʼ����������ʩ�ȷѵļ���
		 */
		int chargecount = 0;
		double dblchargesumrealpay = 0;
		double dblRescuesumrealpay=0;
		PrpLchargeDto[] arrPrpLchargeDto = new PrpLchargeDto[50];
		/**
		 * ���ȶԷ�����Ϣ���кϲ�����ͬ�ձ�ͬ�������ͬ�ұ�Ľ��з���
		 */
		for (int i = 0; i < compensateDto.getPrpLchargeDtoList().size(); i++) {
			
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) compensateDto.getPrpLchargeDtoList().get(i);
			//ֻ�������յ���Ϣ
			if("B".equals(prpLchargeDto.getKindCode()) && "03".equals(prpLchargeDto.getChargeCode()))
			{
				/**
				 * ʩ�ȷ�Ҫ�����չ�ʽ���м���
				 */
				dblchargesumrealpay += prpLchargeDto.getSumRealPay();
	
				for (j = 1; j <= chargecount; j++) {
					if (arrPrpLchargeDto[j].getChargeCode().equals(prpLchargeDto.getChargeCode())
							&& arrPrpLchargeDto[j].getCurrency().equals(prpLchargeDto.getCurrency())
							&& "03".equals(arrPrpLchargeDto[i].getChargeCode())) {
						arrPrpLchargeDto[j].setChargeReport(arrPrpLchargeDto[j].getChargeReport()+ prpLchargeDto.getChargeReport());
						arrPrpLchargeDto[j].setChargeAmount(arrPrpLchargeDto[j].getChargeAmount()+ prpLchargeDto.getChargeAmount());
						arrPrpLchargeDto[j].setSumRealPay(arrPrpLchargeDto[j].getSumRealPay()+ prpLchargeDto.getSumRealPay());
						break;
					}
				}
				if (j > chargecount) {
					chargecount++;
					if(arrPrpLchargeDto[chargecount]==null){
						arrPrpLchargeDto[chargecount] = new PrpLchargeDto();
					}	
					PropertyUtils.copyProperties(arrPrpLchargeDto[chargecount], prpLchargeDto);
				}
			}
		}

		if (chargecount > 0) {
			for (int i = 1; i <= chargecount; i++) {
				//�����������յ�ʩ�ȷ�
				if ("03".equals(arrPrpLchargeDto[i].getChargeCode()) && "B".equals(arrPrpLchargeDto[i].getKindCode())) {
					/**
					 * ��ʼ����ʩ�ȷѵļ��㹫ʽ��
					 */
					dblRescuesumrealpay = arrPrpLchargeDto[i].getSumRealPay();
					strLctextList.add(lineText);
					lineText = space(4) + "ʩ�ȷ���= "+formatPay(dblRescuesumrealpay)+ "Ԫ" ;
					textlosscount++;
				}
			}
		}
		compensateData.dblThirdSumRealPay += dblchargesumrealpay;
		compensateData.dblAllSumRealPay   += dblchargesumrealpay;
		dblthirdsumdefloss                += dblchargesumrealpay; 
		
		prpLclaimDto = compensateDto.getPrpLclaimDto();
  
		if (prpLclaimDto.getEscapeFlag().length() > 0 && prpLclaimDto.getEscapeFlag().charAt(0) == '5') {
		} else {
			if (textlosscount * textpersoncount == 0 && textlosscount + textpersoncount >= 1) {
				if (textlosscount == 0) {
//					repcount++;
					strLctextList.add(lineText);
					if ((dblthirdsumdefloss > dblamount && kindCode.equals("B")) || (dblthirdsumdefloss > dblamount * textpersoncount)&& !kindCode.equals("B")) {
						
/*						  strLctext[repcount] = " " + "���¹����α���Ӧ�е����⳥���" +
						  "���������յ��⳥�޶���ԣ�"; repcount++; strLctext[repcount] = " " +
						  "���ձ�ʵ����=�⳥�޶����1���¹����������ʣ�*��1-���������ʣ�="//*(1-��ʻԱ������)="
						  +formatPay(dblamount) +
						  "��(1��" +new
						 DecimalFormat("#,##0.00").format(dblDutydeductiblerate) +
						  "��)"+"��(1��" +new
						  DecimalFormat("#,##0.00").format(dbldeductiblerate) +
						  "��)"+"��(1��" +new
						  DecimalFormat("#,##0.00").format(dblDriverdeductiblerate) +
						  "��)"; repcount++; strLctext[repcount] = " " + "=" +
						  new
						  DecimalFormat("#,##0.00").format(dblamount*(1-dblDutydeductiblerate/100)*(1-dbldeductiblerate/100)*(1-dblDriverdeductiblerate/100)) +
						  "Ԫ"; dblthirddeductible = dblamount *
						  dbldeductiblerate / 100;
*/						 
						if("B".equals(kindCode)){
							lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "���������յ��⳥�޶���ԣ�";
						}else if("D3".equals(kindCode)){
							lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "����������Ա������-˾����λ���⳥�޶���ԣ�";
						}else if("D4".equals(kindCode)){
							lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "����������Ա������-�˿���λ���⳥�޶���ԣ�";
						}
						strLctextList.add(lineText);
						if("D3".equals(kindCode) || "D4".equals(kindCode))
							lineText = space(4) + "���ձ�ʵ����=�⳥�޶����1���¹����������ʣ�����1�����������ʣ�=";
						else
							lineText = space(4) + "���ձ�ʵ����=�޶����1���¹����������ʣ�����1�����������ʣ�="// ��(1-��ʻԱ������)="
						+ formatPay(dblamount) + "��(1��"
						+ formatPay(dblDutydeductiblerate) + "��)" + "��(1��"
						+ formatPay(dbldeductiblerate) + "��)" ;//+ "��(1��"
						//+ formatPay(dblDriverdeductiblerate) + "��)";
//						repcount++;
						strLctextList.add(lineText);
						lineText = "                  "
							+ "="
							+ formatPay(dblamount * (1 - dblDutydeductiblerate / 100)
									* (1 - dbldeductiblerate / 100) ) + "Ԫ";
						dblthirdsumrealpay = dblamount *(1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100);
					} else {
						lineText = space(4) + "���ձ�ʵ����=��Աʵ���� ";
						if(dblRescuesumrealpay>0)
						{
							lineText+="+ʩ�ȷ�";
						}
						strLctextList.add(lineText);
						lineText = space(16)+"="+formatPay(dblthirdsumperson) ;
						if(dblRescuesumrealpay>0)
						{
							lineText += "+" + formatPay(dblRescuesumrealpay);
						}
						strLctextList.add(lineText);
						if(dblRescuesumrealpay>0)
						{
							dblthirdsumperson += dblRescuesumrealpay;
						}
						lineText = space(16)+"="+formatPay(dblthirdsumperson) + "Ԫ";
					}
				} else if (textpersoncount == 0) {
//					repcount++;
					strLctextList.add(lineText);
					if (dblthirdsumdefloss > dblamount
							&& (compensateData.strEscapeFlag.length() > 0 && compensateData.strEscapeFlag.charAt(0) != 'T' || compensateData.strEscapeFlag
									.length() == 0)) {

						if("B".equals(kindCode)){
							lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "���������յ��⳥�޶���ԣ�";
						}else if("D3".equals(kindCode)){
							lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "����������Ա������-˾����λ���⳥�޶���ԣ�";
						}else if("D4".equals(kindCode)){
							lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "����������Ա������-�˿���λ���⳥�޶���ԣ�";
						}//						repcount++;
						strLctextList.add(lineText);
						lineText = space(4) + "���ձ�ʵ����=�⳥�޶����1���¹����������ʣ�����1�����������ʣ�="// ��(1-��ʻԱ������)="
						+ formatPay(dblamount) + "��(1��"
						+ formatPay(dblDutydeductiblerate) + "��)" + "��(1��"
						+ formatPay(dbldeductiblerate) + "��)";// + "��(1��"
						//+ formatPay(dblDriverdeductiblerate) + "��)";
//						repcount++;
						strLctextList.add(lineText);
						lineText = "                  "
							+ "="
							+ formatPay(dblamount * (1 - dblDutydeductiblerate / 100)
									* (1 - dbldeductiblerate / 100)) + "Ԫ";
//						dblthirddeductible = dblamount * dbldeductiblerate / 100;
						dblthirdsumrealpay = dblamount *(1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100);
					} else {
						lineText = space(4) + "���ձ�ʵ����=���ʵ���� ";
						if(dblRescuesumrealpay>0)
						{
							lineText+="+ʩ�ȷ�";
						}
						strLctextList.add(lineText);
						lineText = space(16)+"="+formatPay(dblthirdsumloss) ;
						if(dblRescuesumrealpay>0)
						{
							lineText += "+" + formatPay(dblRescuesumrealpay);
						}
						strLctextList.add(lineText);
						if(dblRescuesumrealpay>0)
						{
							dblthirdsumloss +=  dblRescuesumrealpay;
						}
						lineText = space(16)+"="+formatPay(dblthirdsumloss)+ "Ԫ";
					}
				}
			} else if (textlosscount * textpersoncount > 0) {
//				repcount++;
				strLctextList.add(lineText);
				if (dblthirdsumdefloss > dblamount
						&& (compensateData.strEscapeFlag.length() > 0 && compensateData.strEscapeFlag.charAt(0) != 'T' || compensateData.strEscapeFlag
								.length() == 0)) {
					if("B".equals(kindCode)){
						lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "���������յ��⳥�޶���ԣ�";
					}else if("D3".equals(kindCode)){
						lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "����������Ա������-˾����λ���⳥�޶���ԣ�";
					}else if("D4".equals(kindCode)){
						lineText = space(4) + "���¹����α���Ӧ�е����⳥���" + "����������Ա������-�˿���λ���⳥�޶���ԣ�";
					}
 
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(4) + "���ձ�ʵ����=�⳥�޶����1��-�¹����������ʣ���(1-����������)";
					strLctextList.add(lineText);
					lineText= "                  ="				
						+ formatPay(dblamount) + "��(1��"
						+ formatPay(dblDutydeductiblerate) + "��)" + "��(1��"
						+ formatPay(dbldeductiblerate) + "��)" ;//+ "��(1��"
						//+ formatPay(dblDriverdeductiblerate) + "��)";
//					repcount++;
					strLctextList.add(lineText);
					lineText = "                  " + "="
					+ formatPay(dblamount * (1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100)) + "Ԫ";
//					dblthirddeductible = dblamount * dbldeductiblerate / 100;
					dblthirdsumrealpay = dblamount *(1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100);
				} else {
					lineText = space(4) + "���ձ�ʵ����=���ʵ�����Աʵ����";
//					repcount++;
					if(dblRescuesumrealpay>0)
					{
						lineText+="+ʩ�ȷ�";
					}
					strLctextList.add(lineText);
					lineText = "                  " + "="
					+ formatPay(dblthirdsumloss) + "��"
					+ formatPay(dblthirdsumperson);
//					repcount++;
					if(dblRescuesumrealpay>0)
					{
						lineText += "+" + formatPay(dblRescuesumrealpay);
					}
					strLctextList.add(lineText);
					dblthirdsumloss += dblthirdsumperson;
					if(dblRescuesumrealpay>0)
					{
						dblthirdsumloss += dblRescuesumrealpay;
					}
					lineText = "                  " + "=" + formatPay(dblthirdsumloss) + "Ԫ";
				}
			}
		}
		strLctextList.add(lineText);
		if("B".equals(kindCode)){
			compensateData.dblThirdSumRealPay += dblthirdsumrealpay;			
		}else if("D3".equals(kindCode)){
			compensateData.dblDriverSumRealPay += dblthirdsumrealpay;	
		}else if("D4".equals(kindCode)){
			compensateData.dblPassengerSumRealPay += dblthirdsumrealpay;	
		}

//		this.dblAllSumDeductible += dblthirddeductible;
		compensateData.dblAllSumRealPay += dblthirdsumrealpay;
		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
		logger.debug("������-������Ա-ctextcount:"+ctextcount);
		for (Iterator iter = strLctextList.iterator(); iter.hasNext();) {
			lineText = (String) iter.next();
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(strCompensateNo);
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(ctextcount++);
			prpLctextDto.setContext(lineText);
			prpLctextDto.setFlag("");
			compensateData.prpLctextlist.add(prpLctextDto);
		}
	}




	/**
	 * ���ɸ����յ����㹫ʽ������
	 * @param iKindCode
	 * @param httpServletRequest
	 * @param compensateDto
	 * @throws UserException
	 * @throws Exception
	 */
	public void CarCreateForOther(String iKindCode, HttpServletRequest httpServletRequest, CompensateDto compensateDto,CompensateData compensateData)
			throws UserException, Exception {
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		PrpLlossDto prpLlossDto = new PrpLlossDto();
		int personcount = 0;
		int licensenocount = 0;
		int j = 0;
		double dblnofranchise = 0;
		double dblsumdefloss = 0;
		double dblsumloss = 0;
		double dblsumrest = 0;
		double dblsumdefpay = 0;
		double dblothsumrealpay = 0;
		int intpropflag = 0 ;
		int textlosscount = 0;
		int textpersoncount = 0;
		double dbldeductiblerate = 0;
		double dblDutydeductiblerate = 0;
		double dblDriverdeductiblerate = 0;
		double dblthirdsumrealpay = 0;
		double dblthirdsumdefloss = 0;
		double dblthirdsumperson = 0;
		double dblamount = 0;
		double dblthirdsumloss = 0;
		double dbldeductible = 0;
		String[] arrKindCode = new String[20];
		String[] arrKindCode1 = new String[20];
		String[] arrPersonNo = new String[20];
		String[] arrPersonName = new String[20];
		String[] lossName = new String[20];
		String[] arrLicenseNo = new String[20];
		String[] arrFamilyName = new String[20];
		String[] arrFeeReport = {};
		String strFeeReport = "";
		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
		PrpLlossDto prpLlossDtobak = new PrpLlossDto();
		PrpLpersonLossDto prpLpersonLossDtobak = new PrpLpersonLossDto();
		PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();

		UICodeAction uiCodeAction = new UICodeAction();
		prpLcompensateDto = compensateDto.getPrpLcompensateDto();
		
		List strLctextList = new ArrayList();
		String lineText = "";
		
		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);

			for (j = 1; j <= licensenocount; j++) {
				if (arrKindCode[j].indexOf(prpLlossDto.getKindCode()) < 0
						&& prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
					arrKindCode[j] = arrKindCode[j].trim() + prpLlossDto.getKindCode();
				if (prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
					break;
			}
			if (j > licensenocount && prpLlossDto.getLicenseNo() != null && prpLlossDto.getLicenseNo().length() > 0) {
				licensenocount++;
				lossName[licensenocount] = prpLlossDto.getLossName();
				arrLicenseNo[licensenocount] = prpLlossDto.getLicenseNo();
				arrKindCode[licensenocount] = prpLlossDto.getKindCode();
			}
			if ((prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
					&& prpLlossDto.getLossName() != null && prpLlossDto.getKindCode().equals(iKindCode))
				intpropflag = 1;
		}
		
		for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
			prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
			for (j = 1; j <= personcount; j++) {
				if (arrKindCode1[j].indexOf(prpLpersonLossDto.getKindCode()) < 0
						&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
					arrKindCode1[j] = arrKindCode1[j].trim() + prpLpersonLossDto.getKindCode();
				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
					break;
			}
			if (j > personcount) {
				personcount++;
				arrKindCode1[personcount] = prpLpersonLossDto.getKindCode();
				arrPersonNo[personcount] = String.valueOf(prpLpersonLossDto.getPersonNo());
				arrPersonName[personcount] = prpLpersonLossDto.getPersonName();
				arrFamilyName[personcount] = prpLpersonLossDto.getFamilyName();
				
			}
		}

		if (iKindCode.trim().equals("M")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * ��������������Լ����
			 * ----------------------------------------------------------------------------------------
			 */			
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals("M")) {
					lineText = "��������������Լ����=";
					lineText += formatPay(prpLlossDto.getSumRealPay()) + "Ԫ";
					dblnofranchise = prpLlossDto.getSumRealPay();
				}
			}
		} else if (iKindCode.trim().equals("G")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * ������
			 * ----------------------------------------------------------------------------------------
			 */
			dblsumdefloss = 0;
			dblsumloss = 0;
			strLctextList.add(lineText);
			lineText = "ȫ�������գ�";
			//if (compensateData.strEscapeFlag.length() > 1 && compensateData.strEscapeFlag.charAt(1) != 'Y' || compensateData.strEscapeFlag.length() <= 1) {
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����=(";
				for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
					if (prpLlossDto.getKindCode().equals("G")) {
						if (StringUtils.getBytesLength(lineText.trim())
								+ StringUtils.getBytesLength(prpLlossDto.getFeeTypeName()) + 1 > 60) {
							strLctextList.add(lineText);
							lineText = space(17) + prpLlossDto.getFeeTypeName() + "��";
						//	lineText = space(17) + "�˶��⳥"+ "��";
						} else {
							lineText += prpLlossDto.getFeeTypeName() + "��";
							//lineText +=  "�˶��⳥"+ "��";
						}
					}
				}
				//ȫ���������Ƿ����ˡ�ȫ��������������������δ�������������������
				boolean conditionsFalg = false;
				 List prpLdeductCondDtoList = new ArrayList();
				 prpLdeductCondDtoList = prpLcompensateDto.getPrpLdeductCondDtoList();
				 if(prpLdeductCondDtoList != null && prpLdeductCondDtoList.size() != 0){
				  for(int i=0;i<prpLdeductCondDtoList.size();i++){
					  PrpLdeductCondDto prpLdeductCondDto = (PrpLdeductCondDto)prpLdeductCondDtoList.get(i);
					  if(   "290".equals(prpLdeductCondDto.getDeductCondCode())
						 && "ȫ��������������������������δ��������".equals(prpLdeductCondDto.getDeductCondName())
						 && prpLdeductCondDto.getTimes() == 1
						 ){
						  	conditionsFalg = true;
						  	break;
					  }
				  }
				 }
				
				lineText = lineText.substring(0, (lineText.length() - 1)) + " ";// + ")";
				//�������ˡ�����������ʱ����Ҫ������������ʣ����򣬽�ȫ��
				if(conditionsFalg){
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + ")��Э���⳥������(1-����������)";// ��(1-��ʻԱ������)";
					} else {
						lineText += ")��Э���⳥������(1-����������)";// ��(1-��ʻԱ������)";
					}					
				}else{
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "- ��ֵ)��Э���⳥����";// ��(1-��ʻԱ������)";
					} else {
						lineText += "- ��ֵ)��Э���⳥����";// ��(1-��ʻԱ������)";
					}
				}

				/*if (StringUtils.getBytesLength(lineText) + 8 > 60) {
					strLctextList.add(lineText);
					lineText = space(17) + "��(1-����������)";// ��(1-��ʻԱ������)";
				} else {
					lineText += "��(1-����������)";// ��(1-��ʻԱ������)";
				}*/
				dblsumloss = 0;
				dblsumdefloss = 0;
				dblsumrest = 0;
				dblsumdefpay = 0;
				strLctextList.add(lineText);
				lineText = space(16) + "=( ";
				for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
					if (prpLlossDto.getKindCode().equals("G")) {
						lineText += formatPay(prpLlossDto.getSumLoss()) + "��";
						dblsumloss += prpLlossDto.getSumLoss();
						dblsumrest += prpLlossDto.getSumRest();
						dblsumdefloss += prpLlossDto.getSumRealPay();
						dblothsumrealpay += prpLlossDto.getSumRealPay();
						dblsumdefpay += prpLlossDto.getSumDefPay();
						PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
					}
				}
				lineText = lineText.substring(0, (lineText.length() - 1));
				if (StringUtils.getBytesLength(lineText) + 8 > 60) {
					strLctextList.add(lineText);
					//lineText = space(17) +  ")"
					if(conditionsFalg){
						lineText = space(17) +  ")"
						+ "��"+formatPay(prpLlossDtobak.getArrangeRate()) + "��"					
						+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
						
					}else{
						lineText = space(17) +  "-" + formatPay(dblsumrest) + ")"
						+ "��"+formatPay(prpLlossDtobak.getArrangeRate()) + "��";
					//	+ "��(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)"
					//	+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
						
					}
				} else {
					if(conditionsFalg){
						lineText +=  ")" 
						+ "��"+formatPay(prpLlossDtobak.getArrangeRate()) + "��"							
						+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
						
					}else{
						lineText += "-" + formatPay(dblsumrest) + ")" 
						+ "��"+formatPay(prpLlossDtobak.getArrangeRate()) + "��";			
						//+ "��(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)"
						//+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
						
					}
				}
				
				if(conditionsFalg){
					dblsumloss = (dblsumloss) * prpLlossDtobak.getArrangeRate()/100 					
								* (1 - prpLlossDtobak.getDeductibleRate() / 100);
					
				}else{
					dblsumloss = (dblsumloss - dblsumrest) * prpLlossDtobak.getArrangeRate()/100 ;
					//* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
					//* (1 - prpLlossDtobak.getDeductibleRate() / 100);
					
				}
				strLctextList.add(lineText);
				lineText = space(16) + "=" + formatPay(dblsumloss) + "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "�⸶���������ֱ��ս��ʰ����ս���⸶��";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
				}
			//}
		    /* else {
				strLctextList.add(lineText);
				for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
					if (prpLlossDto.getKindCode().equals("G"))
						break;
				}
				lineText = space(4) + "����ʵ���� = ���ս���Э���⳥������(1-�¹����������ʣ���(1-����������)";// ��(1-��ʻԱ������)";
				strLctextList.add(lineText);
				lineText = space(17) 
						+ "="
						+ formatPay(prpLlossDto.getAmount()) 
						+ "��"+formatPay(prpLlossDtobak.getArrangeRate()) + "��"	
						+ "����1-" + formatPay(prpLlossDto.getDutyDeductibleRate()) + "����" 
						+ "����1-" + formatPay(prpLlossDto.getDeductibleRate()) + "����" 
						+ "=" 
						+ formatPay(prpLlossDto.getSumRealPay()) + "Ԫ";
				dblothsumrealpay += prpLlossDto.getSumRealPay();
			}*/
		} else if (iKindCode.equals("T") || iKindCode.equals("C")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * ����ͣʻ��
			 * ----------------------------------------------------------------------------------------
			 */			
			strLctextList.add(lineText);
			if (iKindCode.equals("T")) {
				lineText = "����ͣʻ�գ�";
			}
			else{
				lineText = "�����������գ�";
			}

			strLctextList.add(lineText);
			lineText = space(4) + "����ʵ����=(Լ�����⳥���� �⳥����)-���������";
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(iKindCode))
					break;
			}
			strLctextList.add(lineText);
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(iKindCode.trim())) {
					dblsumloss += prpLlossDto.getSumLoss();
					dblothsumrealpay += prpLlossDto.getSumRealPay();
					PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
				}
			}
			lineText = space(16) + "="
					+ formatPay(dblothsumrealpay) + "Ԫ";
			if (dblsumloss > prpLlossDtobak.getAmount()) {
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ�����⳥��������ͣʻ�յ��⳥�޶���ԣ�";
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ���� = ���� ="
						+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
			} 
		} else if (iKindCode.equals("F")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * ��������������
			 * ----------------------------------------------------------------------------------------
			 */						
			strLctextList.add(lineText);
			lineText = "�������������գ�";
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(iKindCode.trim()))
					break;
			}
			String lineTextTemp = "";
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(iKindCode.trim())) {
					dblsumloss += prpLlossDto.getSumLoss();
					dblothsumrealpay += prpLlossDto.getSumRealPay();
					lineTextTemp += prpLlossDto.getSumDefPay() + " + ";
					PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
					// prpLlossDtobak.setDto(prpLlossDto);
				}
			}
			if (dblsumloss > prpLlossDtobak.getAmount() && iKindCode.equals("L")) {
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ���� = ���� ="
						+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
			} else {
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����=ʵ��������� = "//��(1-��ʻԱ������)="
						+ lineTextTemp.substring(0,lineTextTemp.length() - 2) + "="
						+ formatPay(dblsumloss) + "Ԫ";
			}
			dblsumloss = 0;
			dblsumdefloss = 0;

		}else if (iKindCode.equals("H") || iKindCode.equals("R")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * ��ͨ�¹ʾ�����ʧ�ա����ػ��������
			 * ----------------------------------------------------------------------------------------
			 */					
			if (iKindCode.equals("R")) {
				lineText = "��ͨ�¹ʾ�����ʧ�գ�";
			}
			if (iKindCode.equals("H")) {
				lineText = "���ػ�������գ�";
			}
			strLctextList.add(lineText);
			//============================================================================
			UIPolicyAction uiPolicyAction  = new UIPolicyAction (); 
			PolicyDto policyDto =uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
			ArrayList limitlist=policyDto.getPrpCitemKindDtoList();
			Iterator it =limitlist.iterator();
			if (limitlist!=null && limitlist.size()>0){
				while(it.hasNext()){
					prpCitemKindDto =(PrpCitemKindDto)it.next();
					if (iKindCode.equals(prpCitemKindDto.getKindCode())){
						dblamount =	prpCitemKindDto.getAmount();
						break;
					}
				}
			}		
			if(iKindCode.equals("H") || iKindCode.equals("R")){
				for (int i = 1; i <= licensenocount; i++) {
					dblsumloss = 0;
					if (arrKindCode[i].indexOf(iKindCode) < 0)
						continue;
					lineText="";
					if (!lossName[i].trim().equals("����")) {
						lineText = space(4) + lossName[i].trim();
					} else {
						lineText = space(4) + arrLicenseNo[i].trim() + "�ų�";
					}
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ����=(";
					textlosscount++;
	
					for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
						prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
						if (prpLlossDto.getKindCode().equals(iKindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
							if (StringUtils.getBytesLength(lineText) + prpLlossDto.getFeeTypeName().length() + 2 > 60) {
								strLctextList.add(lineText);
								lineText = space(17) + prpLlossDto.getFeeTypeName() + "��";
							} else {
								lineText += prpLlossDto.getFeeTypeName() + "��";
							}
						}
					}
					lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
	
					if (StringUtils.getBytesLength(lineText) + 10 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "���⳥������Э���⳥����";
					} else {
						lineText += "���⳥������Э���⳥����";
					}
					if (StringUtils.getBytesLength(lineText) + 11 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "����1-����������)";
					} else {
						lineText += "��(1-����������)";
					}
				
					strLctextList.add(lineText);
					lineText = space(16) + "=(";
	
					for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
						prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
						if (prpLlossDto.getKindCode().equals(iKindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i].trim())) {
							if (StringUtils.getBytesLength(lineText) + 3 > 60) {
								strLctextList.add(lineText);
								lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "��";
							} else {
								lineText += formatPay(prpLlossDto.getSumDefPay()) + "��";
							}
							dbldeductiblerate = prpLlossDto.getDeductibleRate();
							dblDutydeductiblerate = prpLlossDto.getDutyDeductibleRate();
							dblDriverdeductiblerate = prpLlossDto.getDriverDeductibleRate();
							dblsumloss += prpLlossDto.getSumDefPay();
							dblothsumrealpay += prpLlossDto.getSumRealPay();
							dblthirdsumloss += prpLlossDto.getSumRealPay();
							prpLlossDtobak = new PrpLlossDto();
							PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
						}
					}
					lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
					// �����⳥����
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��";
						lineText+="��" + formatPay(prpLlossDtobak.getArrangeRate()) + "��";
					} else {
						lineText += "��" + formatPay(prpLlossDtobak.getClaimRate()) + "��";
						lineText+="��" + formatPay(prpLlossDtobak.getArrangeRate()) + "��";
					}
					dblsumloss = dblsumloss * prpLlossDtobak.getClaimRate()/100 ;
					if (StringUtils.getBytesLength(lineText) + 10 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "��(1��"
						+ formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
	
					} else {
						lineText += "��(1��"
							+ formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
					}
					dblthirdsumdefloss += dblsumloss;
	
					// ���������ʽ�������⳥������Ϣ
					dblsumdefloss = dblsumloss 
					* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
					* (1 - prpLlossDtobak.getDeductibleRate() / 100);
					strLctextList.add(lineText);
					lineText = space(16) + "=" + formatPay(dblsumdefloss) + "Ԫ";
					strLctextList.add(lineText);
				}
				if (intpropflag == 1) {
					textlosscount++;
					
					lineText = space(4) + "�Ʋ��⸶:";
					strLctextList.add(lineText);
					for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
						prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
						if (prpLlossDto.getKindCode().equals(iKindCode)
								&& (prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
								&& prpLlossDto.getLossName() != null) {
							lineText = space(4) + "��Ŀ:" + prpLlossDto.getLossName();
							strLctextList.add(lineText);
							lineText = space(4) + "����ʵ����=��ʧ�������α�����(1-����������)";
							dblsumloss = 0;
							dblsumdefloss = 0;
							dbldeductiblerate = prpLlossDto.getDeductibleRate();
							dblDutydeductiblerate = prpLlossDto.getDutyDeductibleRate();
							strLctextList.add(lineText);
							lineText = space(16) + "="
							+ formatPay(prpLlossDto.getSumDefPay()) + "��"
							+ formatPay(prpLlossDto.getIndemnityDutyRate()) + "��" + "��"
							+ "(1-" + formatPay(prpLlossDto.getDeductibleRate()) + "��)";// +
							strLctextList.add(lineText);
							lineText = space(16) + "="	+ formatPay(prpLlossDto.getSumRealPay()) + "Ԫ";
							dblothsumrealpay += prpLlossDto.getSumRealPay();
							dblthirdsumloss += prpLlossDto.getSumRealPay();
							PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
							strLctextList.add(lineText);
						}
					}
				}
			}
			
			//============================================================================
			
			
			for (j = 1; j <= personcount; j++) {
				if (arrKindCode1[j].indexOf(iKindCode) < 0)
					continue;
				lineText = space(4) + "�������ƺ���Ϊ" + arrFamilyName[j].trim() + "�ĳ�����Ա" + "  "
				+ arrPersonName[j].trim() + "��";
				textpersoncount++;
				
				for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
					prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
					if (prpLpersonLossDto.getKindCode().equals(iKindCode)) {
						
						dbldeductiblerate = prpLpersonLossDto.getDeductibleRate();
						dblDutydeductiblerate = prpLpersonLossDto.getDutyDeductibleRate();
						dblDriverdeductiblerate = prpLpersonLossDto.getDriverDeductibleRate();
					}
					if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])) {
						strLctextList.add(lineText);
						strFeeReport = this.CarCreateForFee(prpLpersonLossDto, compensateDto,compensateData);
						if (StringUtils.getBytesLength(strFeeReport) > 60) {
							arrFeeReport = (String[]) StringUtils.split(strFeeReport, 60);
							lineText = arrFeeReport[0];
							strLctextList.add(lineText);
							lineText = space(7) + arrFeeReport[1];
						} else {
							lineText = strFeeReport;
						}
					}
				}
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����=(";
				for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
					prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
					if (prpLpersonLossDto.getKindCode().equals(iKindCode)	&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim())) {
						if (StringUtils.getBytesLength(lineText)
								+ StringUtils.getBytesLength(prpLpersonLossDto.getLiabDetailName()) + 1 > 60) {
							strLctextList.add(lineText);
							lineText = space(17) + prpLpersonLossDto.getLiabDetailName() + "���⳥������";
						} else {
							lineText += prpLpersonLossDto.getLiabDetailName() + "���⳥������";
						}
					}
				}
				lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
				if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(17) + "��Э���⳥����";
				} else {
					lineText += "��Э���⳥����";
				}
				if (StringUtils.getBytesLength(lineText) + 11 > 60) {
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(17) + "��(1-����������)";// ��(1-��ʻԱ������)";
				} else {
					lineText += "��(1-����������)";// ��(1-��ʻԱ������)";
				}
				dblsumloss = 0;
				dblsumdefloss = 0;
				strLctextList.add(lineText);
				lineText = space(16) + "=(";
				for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
					prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);				
					if (prpLpersonLossDto.getKindCode().equals(iKindCode)
							&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim())) {
						if (StringUtils.getBytesLength(lineText) + 8 > 60) {
							strLctextList.add(lineText);
							lineText = space(17)
							+ formatPay(prpLpersonLossDto.getSumDefPay()) + "��"  //LYM
							+ formatPay(prpLpersonLossDto.getClaimRate()) + "��" + "��";
						} else {
							lineText += formatPay(prpLpersonLossDto.getSumDefPay()) //LYM
							+ "��" + formatPay(prpLpersonLossDto.getClaimRate()) + "��"
							+ "��";
						}
						dblsumloss += prpLpersonLossDto.getSumDefPay() * prpLpersonLossDto.getClaimRate() * 0.01; 				
						dblothsumrealpay += prpLpersonLossDto.getSumRealPay();
						dblthirdsumperson += prpLpersonLossDto.getSumRealPay();
						PropertyUtils.copyProperties(prpLpersonLossDtobak, prpLpersonLossDto);
					}
				}
				lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
				if (StringUtils.getBytesLength(lineText) + 8 > 60) {
					strLctextList.add(lineText);
					lineText = space(17) +  "��" + formatPay(prpLpersonLossDtobak.getArrangeRate()) + "��";
				} else {
					lineText += "��"	+ formatPay(prpLpersonLossDtobak.getArrangeRate()) + "��";
				}
				dblsumloss = dblsumloss * prpLpersonLossDtobak.getArrangeRate() / 100;
				if (StringUtils.getBytesLength(lineText) + 10 > 60) {
					strLctextList.add(lineText);
					lineText = space(17) + "��(1��" + formatPay(prpLpersonLossDtobak.getDeductibleRate())+ "��)";
				} else {
					lineText += "��(1��" + formatPay(prpLpersonLossDtobak.getDeductibleRate())+ "��)";
				}

				dblthirdsumdefloss += dblsumloss;
				dblsumdefloss = dblsumloss * (1 - prpLpersonLossDtobak.getDeductibleRate() / 100);
				strLctextList.add(lineText);
				lineText = space(16) + "=" + formatPay(dblsumdefloss) + "Ԫ";
				strLctextList.add(lineText);
			}
			if (dblsumloss > dblamount) {
				if(iKindCode.equals("R")){
					lineText = space(4) + "����ʵ�����⳥������ͨ�¹ʾ�����ʧ�յ��⳥�޶���ԣ�";
				}	
				if(iKindCode.equals("H")){
					lineText = space(4) + "����ʵ�����⳥�������ػ�����������յ��⳥�޶���ԣ�";
				}	
				strLctextList.add(lineText);
				lineText = space(4) + "���ձ�ʵ����=�⳥�޶�="
						+ formatPay(dblamount) + "Ԫ";
				strLctextList.add(lineText);
				dblothsumrealpay = dblamount;
			}
			else{
					if (textlosscount > 0 && textpersoncount > 0) {
						lineText = space(4) + "���ձ�ʵ����=���ʵ�����Աʵ����";
						strLctextList.add(lineText);
						lineText = "                  " + "="
						+ formatPay(dblthirdsumloss) + "��"
						+ formatPay(dblthirdsumperson);
						strLctextList.add(lineText);
						lineText = "                  " + "=" + formatPay(dblthirdsumloss+dblthirdsumperson) + "Ԫ";
						strLctextList.add(lineText);
					}
					else if(textlosscount > 0 && textpersoncount <= 0){
						lineText = space(4) + "���ձ�ʵ����=���ʵ����="+formatPay(dblthirdsumloss);
						strLctextList.add(lineText);
					}
					else if(textlosscount <= 0 && textpersoncount > 0){
						lineText = space(4) + "���ձ�ʵ����=��Աʵ����="+formatPay(dblthirdsumperson);
						strLctextList.add(lineText);
					}
			}
			lineText= "";
			
		}
		else {			
			/*
			 * ----------------------------------------------------------------------------------------
			 * ������
			 * ----------------------------------------------------------------------------------------
			 */		
			// dbPrpDkind.getInfo(prpLcompensateDto.getRiskCode(),iKindCode);
			strLctextList.add(lineText);
			// lineText = dbPrpDkind.getKindCName() + "��";
			lineText = uiCodeAction.translateKindCode(compensateDto.getPrpLcompensateDto().getRiskCode(),
					iKindCode, true)
					+ "��";
			dblsumloss = 0;
			dblsumdefloss = 0;
			dblsumrest = 0;
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(iKindCode)) {
					dblsumloss += prpLlossDto.getSumDefPay();
					dblsumdefloss += prpLlossDto.getSumRealPay();
					dblothsumrealpay += prpLlossDto.getSumRealPay();
					dblsumrest += prpLlossDto.getSumRest();
					PropertyUtils.copyProperties(prpLlossDtobak, prpLlossDto);
					// prpLlossDtobak.setSchema(prpLlossDto);
				}
			}
			// prpLlossDto.setSchema(prpLlossDto);
			if (iKindCode.equals("Z")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * ��ȼ��ʧ��
				 * ----------------------------------------------------------------------------------------
				 */		
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����=��ʵ���������- ��ֵ�����⳥������Э�̱�������1-���������ʣ�";// ��(1-��ʻԱ������)";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")" + prpLlossDtobak.getClaimRate()+ "��" + prpLlossDtobak.getArrangeRate()+"��" + "��(1-"
						+ formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
				dblsumloss = (dblsumloss ) *prpLlossDtobak.getClaimRate() / 100*prpLlossDtobak.getArrangeRate() / 100 *(1 - prpLlossDtobak.getDeductibleRate() / 100);// *(1
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("X3")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * ��ˮ��ʻ��ʧ��
				 * ----------------------------------------------------------------------------------------
				 */		
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����=��ʵ���������- ��ֵ�����⳥������Э�̱���";// ��(1-��ʻԱ������)";
				strLctextList.add(lineText);				
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")" + "��"
						+ formatPay(prpLlossDtobak.getClaimRate()) + "��"
						+ formatPay(prpLlossDtobak.getArrangeRate()) + "��";
				dblsumloss = (dblsumloss ) * prpLlossDtobak.getClaimRate()/100*(prpLlossDtobak.getArrangeRate()/ 100);// *(1
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("G0")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * �������Ӹ߶�����
				 * ----------------------------------------------------------------------------------------
				 */
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����= ʵ����ʧ����1-�������������ʣ�";
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)
						+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
				dblsumloss = dblsumloss * (1 - prpLlossDtobak.getDeductibleRate() / 100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "	+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("L") || iKindCode.equals("K16") || iKindCode.equals("V1")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * ��������
				 * ----------------------------------------------------------------------------------------
				 */
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����= ʵ����ʧ���⳥������Э�̱�������1-���������ʣ�";
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)+ "��"
				        + formatPay(prpLlossDtobak.getClaimRate()) + "����"
				        + formatPay(prpLlossDtobak.getArrangeRate()) 
						+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
				dblsumloss = dblsumloss *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100)* (1 - prpLlossDtobak.getDeductibleRate() / 100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "Ԫ";
				if(iKindCode.equals("L") && dblsumloss > prpLlossDtobak.getAmount()){
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "	+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			
			if (iKindCode.equals("X") ) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * �����豸��
				 * ----------------------------------------------------------------------------------------
				 */
				String strName = "ʵ����ʧ";
				strLctextList.add(lineText);

				lineText = space(4) + "����ʵ����=��" + strName + "- ��ֵ�������α���";
				strLctextList.add(lineText);
				lineText = space(17) + "����1-�¹����������ʣ���(1-����������)";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")��"
						+ formatPay(prpLlossDtobak.getIndemnityDutyRate()) ;
				strLctextList.add(lineText);
				lineText =space(17) + "��(1-"+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)"
						+ "��(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
				dblsumloss = (dblsumloss ) * (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)*(1- prpLlossDtobak.getDeductibleRate()/100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("D2")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * ���ϻ���������
				 * ----------------------------------------------------------------------------------------
				 */
				String strName = "ʵ����ʧ";
				

				strLctextList.add(lineText);

				lineText = space(4) + "����ʵ����=��" + strName + "- ��ֵ�����⳥������Э�̱��������α���";
				strLctextList.add(lineText);
				lineText = space(17) + "����1-�¹����������ʣ�*(1-����������)";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")��"
						+ formatPay(prpLlossDtobak.getClaimRate()) + "����"
						+ formatPay(prpLlossDtobak.getArrangeRate()) + "����"
						+ formatPay(prpLlossDtobak.getIndemnityDutyRate());
				strLctextList.add(lineText);
				lineText = space(17) +"��(1-"
						+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "��)"
						+ "*(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "��)";
				dblsumloss = (dblsumloss ) *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getIndemnityDutyRate()/100)
							*(prpLlossDtobak.getIndemnityDutyRate()/100)* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
							*(1-prpLlossDtobak.getDeductibleRate()/100);// *(1
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}

			if (iKindCode.equals("X4")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 *ϵ��ȫ��������
				 * ----------------------------------------------------------------------------------------
				 */				
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����=�˶��⳥���⳥������Э�̱���";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
				+  ")��"
				+ formatPay(prpLlossDtobak.getClaimRate()) + "����"
				+ formatPay(prpLlossDtobak.getArrangeRate()) + "����";
				strLctextList.add(lineText);
				dblsumloss = (dblsumloss ) *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4)
							+ "����ʵ���� = ���ս��= "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if(iKindCode.equals("K6")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * �泵������Ʒ��ʧ��
				 * ----------------------------------------------------------------------------------------
				 */
				String strName = "ʵ����ʧ";
			
				strLctextList.add(lineText);

				lineText = space(4) + "����ʵ����=��" + strName + "- ��ֵ�����⳥������Э�̱��������α���";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")��"
						+ formatPay(prpLlossDtobak.getClaimRate()) + "����"
						+ formatPay(prpLlossDtobak.getArrangeRate()) + "����"
						+ formatPay(prpLlossDtobak.getIndemnityDutyRate());
				dblsumloss = (dblsumloss ) *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100)
							*(prpLlossDtobak.getIndemnityDutyRate()/100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "Ԫ";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "
							+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("K10")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * �����¹ʸ��������ʧ��
				 * ----------------------------------------------------------------------------------------
				 */
				strLctextList.add(lineText);
				lineText = space(4) + "����ʵ����= ʵ����ʧ*�⳥������Э�̱���";
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)+ "��"
				        + formatPay(prpLlossDtobak.getClaimRate()) + "����"
				        + formatPay(prpLlossDtobak.getArrangeRate()) + "%" ;
				dblsumloss = dblsumloss *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "Ԫ";
				if(dblsumloss > prpLlossDtobak.getAmount()){
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ��������ս��������¼��㣺";
					strLctextList.add(lineText);
					lineText = space(4) + "����ʵ���� = ���ս�� = "	+ formatPay(prpLlossDtobak.getAmount()) + "Ԫ";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
		}
		strLctextList.add(lineText);
		if(iKindCode.equals("G")){
			compensateData.dblStealSumRealPay = dblothsumrealpay;
			compensateData.dblAllSumRealPay += dblothsumrealpay + dblnofranchise;
			compensateData.dblNoFranchise += dblnofranchise;
		}else{
			compensateData.dblOthSumRealPay += dblothsumrealpay;
			compensateData.dblAllSumRealPay += dblothsumrealpay + dblnofranchise;
			compensateData.dblNoFranchise += dblnofranchise;
		}
		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
		logger.debug("������-ctextcount:"+ctextcount);
		for (Iterator iter = strLctextList.iterator(); iter.hasNext();) {
			lineText = (String) iter.next();
			prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(strCompensateNo);
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(ctextcount ++);
			prpLctextDto.setContext(lineText);
			prpLctextDto.setFlag("");
			compensateData.prpLctextlist.add(prpLctextDto);
		}
	}


	
	public String CarCreateForFee(PrpLpersonLossDto iPrpLpersonLossDto, CompensateDto iCompensateDto,CompensateData compensateData)
			throws UserException, Exception {

		String strFeeReport = "";
		double dblsumloss = 0;
		int intpayyears = 0;
		// BLPrpLperson blPrpLperson = new BLPrpLperson();
		UIPrpLpersonAction uiPrpLpersonAction = new UIPrpLpersonAction();
		PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		// BLPrpDpersonPay blPrpDpersonPay = new BLPrpDpersonPay();
		UIPrpDpersonPayAction uiPrpDpersonPayAction = new UIPrpDpersonPayAction();
		PrpDpersonPayDto prpDpersonPayDto = new PrpDpersonPayDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();

		prpLclaimDto = iCompensateDto.getPrpLclaimDto();
		prpLcompensateDto = iCompensateDto.getPrpLcompensateDto();
		String strSQL = " ClaimNo = '" + prpLclaimDto.getClaimNo() + "' AND PersonNo = "
				+ iPrpLpersonLossDto.getPersonNo() + " AND KindCode = '" + iPrpLpersonLossDto.getKindCode()
				+ "' AND FeeTypeCode = '" + iPrpLpersonLossDto.getLiabDetailCode() + "' ";
		// blPrpLperson.query(strSQL,0);
		ArrayList prpLpersonList = (ArrayList) uiPrpLpersonAction.findByConditions(strSQL);
		if (prpLpersonList.size() == 0) {
			strFeeReport = space(4) + iPrpLpersonLossDto.getLiabDetailName() + ":"
					+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
			return strFeeReport;
		}

		prpLpersonDto = (PrpLpersonDto) prpLpersonList.get(0);
		if (iPrpLpersonLossDto.getLiabDetailCode().equals("15")) {
			dblsumloss = prpLpersonDto.getUnitLoss() * prpLpersonDto.getQuantity();
			if (prpLpersonDto.getFixedIncomeFlag().equals("1")) {
				strSQL = " PayItemCode = '01' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
						+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
				// blPrpDpersonPay.query(strSQL,0);
				ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
				// modify by liruijuan update begin 040203
				// ��Ա�⸶�󹤷ѵ������������鱨��
				if (prpDpersonPaylist.size() > 0) {
					prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
					if (prpLpersonDto.getSumLoss() / prpLpersonDto.getQuantity() > prpDpersonPayDto.getStandardFee() / 365 * 3) {
						prpLpersonDto.setSumDefLoss(prpDpersonPayDto.getStandardFee() / 365 * 3
								* prpLpersonDto.getQuantity() - prpLpersonDto.getSumReject());
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3����׼)��"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
					} else {
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3����׼)��"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
					}
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ";  //SumLoss��ΪSumDefPay
				}
			} else if (prpLpersonDto.getFixedIncomeFlag().equals("2")) {
				strSQL = " PayItemCode = '07' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
						+ "' AND BusinessSource = '" + prpLpersonDto.getJobCode() + "' AND issuedate = '"
						+ prpLclaimDto.getDamageStartDate() + "' ";
				// blPrpDpersonPay.query(strSQL,0);
				ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
				if (prpDpersonPaylist.size() > 0) {
					prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3����׼)��"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
				}
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("17")) {
			strSQL = " PayItemCode = '01' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
				if (prpLpersonDto.getPersonAge() > 50) {
					intpayyears = prpLpersonDto.getPersonAge() - 50;
					if (intpayyears > 10 && intpayyears < 20)
						intpayyears = 10;
					else if (intpayyears >= 20)
						intpayyears = 5;
				} else {
					intpayyears = 20;
				}
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(�˾������)��"
						+ new DecimalFormat("#,##0.00").format((double) intpayyears) + "(�⳥����)��"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getLossRate()) + "��(�˲еȼ�)="
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("17")) {
			if (prpLpersonDto.getFixedIncomeFlag().equals("1")) {
				strSQL = " PayItemCode = '01' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
						+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
				// blPrpDpersonPay.query(strSQL,0);
				ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
				if (prpDpersonPaylist.size() > 0) {
					prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
					if (prpLpersonDto.getSumLoss() / prpLpersonDto.getQuantity() > prpDpersonPayDto.getStandardFee() / 365 * 3) {
						prpLpersonDto.setSumDefLoss(prpDpersonPayDto.getStandardFee() / 365 * 3
								* prpLpersonDto.getQuantity() - prpLpersonDto.getSumReject());
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3����׼)��"
								+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getQuantity()) + "(����)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
					} else {
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3����׼)��"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
					}
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
				}
			} else if (prpLpersonDto.getFixedIncomeFlag().equals("2")) {
				strSQL = " PayItemCode = '07' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
						+ "' AND BusinessSource = '" + prpLpersonDto.getJobCode() + "' AND issuedate = '"
						+ prpLclaimDto.getDamageStartDate() + "' ";
				// blPrpDpersonPay.query(strSQL,0);
				ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
				if (prpDpersonPaylist.size() > 0) {
					prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(��׼)��"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
				}
			} else if (prpLpersonDto.getFixedIncomeFlag().equals("3")) {
				strSQL = " PayItemCode = '01' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
						+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
				// blPrpDpersonPay.query(strSQL,0);
				ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
				if (prpDpersonPaylist.size() > 0) {
					prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
					prpLpersonDto.setUnitLoss(prpDpersonPayDto.getStandardFee() / 365);
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(��׼)��"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ";//SumLoss��ΪSumDefPay
				}
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("19")) {
			strSQL = " PayItemCode = '01' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
				if (prpLpersonDto.getPersonAge() > 70) {
					intpayyears = prpLpersonDto.getPersonAge() - 70;
					if (intpayyears > 5)
						intpayyears = 5;
					else
						intpayyears = 10 - intpayyears;
				} else if (prpLpersonDto.getPersonAge() < 16) {
					intpayyears = 16 - prpLpersonDto.getPersonAge();
					if (intpayyears > 5)
						intpayyears = 5;
					else
						intpayyears = 10 - intpayyears;
				} else {
					intpayyears = 10;
				}
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(ƽ�������)��"
						+ new DecimalFormat("#,##0.00").format((double) intpayyears) + "(�⳥����)="
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("20")) {
			strSQL = " PayItemCode = '04' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
				prpLpersonDto.setSumDefLoss(prpDpersonPayDto.getStandardFee() - prpLpersonDto.getSumReject());
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(ɥ���׼)Ԫ";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("21")) {
			if (prpLpersonDto.getFixedIncomeFlag().equals("4")) {
				if (prpLpersonDto.getPersonAge() > 50) {
					intpayyears = prpLpersonDto.getPersonAge() - 50;
					if (intpayyears > 10 && intpayyears < 20)
						intpayyears = 10;
					else if (intpayyears >= 20)
						intpayyears = 5;
				}
			} else {
				if (prpLpersonDto.getPersonAge() < 16)
					intpayyears = 16 - prpLpersonDto.getPersonAge();
				else
					intpayyears = 5;
			}
			strSQL = " PayItemCode = '06' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(�������Ѳ�����׼)��"
						+ new DecimalFormat("#,##0.00").format((double) intpayyears) + "(�⳥����)="
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("23")) {
			strSQL = " PayItemCode = '02' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(����ס�ޱ�׼)��"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ";////SumLoss��ΪSumDefPay
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("34")) {
			strSQL = " PayItemCode = '03' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(�����ʳ������׼)��"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(����)="
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ";  //SumLoss��ΪSumDefPay 
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "Ԫ";
			}
			// modify by liruijuan update end 040302
		} else {
			strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
					+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "Ԫ"; //SumLoss��ΪSumDefPay
		}
		return strFeeReport;
		// return "CarCreateForFee";
	}

	private static class CompensateData{

		private double dblCarSumRealPay = 0;	//������ʵ��
		private double dblThirdSumRealPay = 0;	//������ʵ��
		private double dblDriverSumRealPay = 0; //��ʻԱ������ʵ��
		private double dblPassengerSumRealPay = 0; //�˿�������ʵ��
		private double dblStealSumRealPay = 0;     //ȫ�����������
		private double dblOthSumRealPay = 0;	//������ʵ��
		private double dblChargeSumRealPay = 0;	//����ʵ��
		private double dblNoFranchise = 0;		//
		private double dblAllSumRealPay = 0;	//ʵ��ϼ�
//		private double dblAllSumDeductible = 0;	//�����ϼ�
		private String strEscapeFlag = "";		//�Ƿ�Ϊ���ݰ�
		List prpLctextlist = new ArrayList();
	}
	
	
	
//	public void ReportForCommerceB(HttpServletRequest httpServletRequest, CompensateDto compensateDto,CompensateData compensateData)throws UserException,Exception 
//	{
//
//		PrpLlossDto prpLlossDto = new PrpLlossDto();
//		PrpLlossDto prpLlossDtobak = new PrpLlossDto();
//		
//		double propLimit  = 5000;    //�Ʋ��޶�
//		double medicLimit = 10000;    //ҽ���޶�
//		double deathLimit = 40000;    //�����м��޶�
//		//double dbChargeRealPay=0;  //���������� 
//		
//		int licensenoNumber = 0;
//		int personcount = 0;
//		int textlosscount = 0;
//		int textpersoncount = 0;
//		int j = 0;
//		int intpropflag = 0;
//		double dblsumloss = 0;
//		double dblsumdefloss = 0;
//		double dbldeductiblerate = 0;
//		double dblDutydeductiblerate = 0;
//		double dblDriverdeductiblerate = 0;
//		double dblthirdsumrealpay = 0;
//		double dblthirdsumdefloss = 0;
//		double dblthirdsumperson = 0;
//		double dblamount = 0;
//		double dblthirdsumloss = 0;
//		double dbldeductible = 0;
//		String[] arrKindCode = new String[20];
//		String[] arrLicenseNo = new String[20];
//		String[] arrKindCodePerson = new String[20];
//		String[] arrPersonNo = new String[20];
//		String[] arrPersonName = new String[20];
//		String[] arrFamilyName = new String[20];
//		String[] arrLossName = new String[20];
//		String[] arrFeeReport = {};
//		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
//		String lineText = "";
//		int      lineNumber=1;
//		int      propindex=0;
//		int      proptitileindex=0;
//		double dbtempSumloss = 0;
//		double dbtempSumRest = 0;
//		double dbpropall=0;
//		HashMap mybackupvalue= new HashMap();		
//		String  propname="���߳�";
//		String[] lineReportText ={"һ���Ʋ���ʧ��",
//				"�˶���ʧ",
//				"��(�����м����ã�ǿ�������м��޶�))���¹����α���",
//				"�⳥�޶",
//				"�˶��⳥�� ��( �Ʋ��˶�����ʧ + ҽ�ƺ˶�����ʧ + ҽ�ƺ˶�����ʧ)* �¹����α���",
//				"ʵ����˶��⳥�� * ��1-���������ʣ�* ��1-���������ʣ�",//LYM
//		};
//		int    ireport=0;
//		
//		PrpLpersonLossDto prpLpersonLossDto 		= new PrpLpersonLossDto();
//		PrpLpersonLossDto prpLpersonLossDtobak 	= new PrpLpersonLossDto();
//		PrpLclaimDto 		prpLclaimDto 			= new PrpLclaimDto();
//		
//		
//		
//		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
//			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
//			for (j = 1; j <= licensenoNumber; j++) {
//				if (arrKindCode[j].indexOf(prpLlossDto.getKindCode()) < 0&& 
//						prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
//					arrKindCode[j] = arrKindCode[j].trim() + prpLlossDto.getKindCode();
//				if (prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
//					break;
//			}
//			if (j > licensenoNumber && prpLlossDto.getLicenseNo() != null && prpLlossDto.getLicenseNo().length() > 0) {
//				licensenoNumber++;
//				arrLossName [licensenoNumber] = prpLlossDto.getLossName();
//				arrLicenseNo [licensenoNumber] = prpLlossDto.getLicenseNo();
//				arrKindCode  [licensenoNumber] = prpLlossDto.getKindCode();
//			}
//			if ((prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
//					&& prpLlossDto.getLossName() != null && prpLlossDto.getKindCode().equals("B"))
//				intpropflag = 1;
//		}
//		
//		
//		for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
//			prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
//			for (j = 1; j <= personcount; j++) {
//				if (arrKindCodePerson[j].indexOf(prpLpersonLossDto.getKindCode()) < 0
//						&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
//					arrKindCodePerson[j] = arrKindCodePerson[j].trim() + prpLpersonLossDto.getKindCode();
//				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
//					break;
//			}
//			if (j > personcount) {
//				personcount++;
//				arrKindCodePerson   [personcount] = prpLpersonLossDto.getKindCode();
//				arrPersonNo     [personcount] = String.valueOf(prpLpersonLossDto.getPersonNo());
//				arrPersonName [personcount] = prpLpersonLossDto.getPersonName();
//				arrFamilyName [personcount] = prpLpersonLossDto.getFamilyName();
//			}
//		}
//		List strLctextList = new ArrayList();
//		
//		for (int i = 1; i <= licensenoNumber; i++) {
//			dblsumloss = 0;
//			ireport=0;
//			if (arrKindCode[i].indexOf("B") < 0)	continue;
//			if (lineNumber==1){
//				strLctextList.add("��ҵ�����ۺϱ���(A):");
//				strLctextList.add(lineReportText[ireport]);
//			}
//			lineNumber++;
//			ireport++;
//			if (!arrLossName [i].trim().equals("����")) {
//				lineText = space(4) +propname+"("+ arrLossName [i].trim()+")";
//			} else {
//				lineText = space(4) +propname+"("+ arrLicenseNo[i].trim() + "�ų�"+")";  
//			}
//			mybackupvalue.put("proptitle"+proptitileindex,propname+"("+ arrLicenseNo [i].trim()+")"+"�˶���ʧ");			
//			proptitileindex++;
//			strLctextList.add(lineText);
//			
//			lineText = space(4) + lineReportText[ireport];  //�˶���ʧ=
//			ireport++;
//			lineText +="��";
//			textlosscount++;//�������������Ǹ�ʲô�Ե�
//			
//			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
//				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
//				if (prpLlossDto.getKindCode().equals("B") && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
//					if (ExceedFormat(lineText, prpLlossDto.getFeeTypeName().length() + 2)) {
//						strLctextList.add(lineText);
//						lineText = space(17) + prpLlossDto.getFeeTypeName() + "��";
//					} else {
//						lineText += prpLlossDto.getFeeTypeName() + "��";
//					}
//				}
//			}
//			lineText = SubtractDesignate(lineText,"��");						
//							
//			strLctextList.add(lineText);  
//			dbtempSumRest=0;
//			dbtempSumloss=0;
//			
//			lineText = space(16) + "=";
//			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {  //�Ʋ��ۼ�;
//				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
//				if (prpLlossDto.getKindCode().equals("B") && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
//					dbtempSumloss+=prpLlossDto.getSumDefPay();  //ԭ��ȡSumloss,����ȡ�˶��⳥SumDefPay  LYM
//					if (ExceedFormat(lineText, prpLlossDto.getFeeTypeName().length() + 2)) {//���� 
//						strLctextList.add(lineText);
//						lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "��";  //ԭ��ȡSumloss,����ȡ�˶��⳥SumDefPay  LYM
//					} else {
//						lineText += formatPay(prpLlossDto.getSumDefPay()) + "��"; //ԭ��ȡSumloss,����ȡ�˶��⳥SumDefPay  LYM
//					}
//				}
//			}
//			
//			
//			
//			lineText = SubtractDesignate(lineText,"��");						
////			lineText += CombinationBracket(lineText,")");						
//			//lineText +="��"+formatPay(dbtempSumRest);   //�����ǲ�ֵ LYM
//			strLctextList.add(lineText);  //������=100+10
//			lineText = space(16) + "=" + formatPay(dbtempSumloss) + "Ԫ"; //�����ǲ�ֵ LYM
//			dbpropall+=dbtempSumloss; //�����ǲ�ֵ LYM
//			mybackupvalue.put("prop"+propindex,formatPay(dbtempSumloss)); //�����ǲ�ֵ LYM
//			propindex++;
//			strLctextList.add(lineText);
//			System.out.println("--------lineText-000--" +lineText +"---"+ireport);
//		}
//		
//		lineText="";
//		lineNumber=1;
//		dbtempSumRest=0;
//		dbtempSumloss=0;
//		
//		if (intpropflag == 1) {
//			System.out.println( "   !!!!!!!!!!!!!!!!!!!!!");
//			textlosscount++;
//			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
//				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
//				if (prpLlossDto.getKindCode().equals("B")
//						&& (prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
//						&& prpLlossDto.getLossName() != null) {
//					lineText = space(4) + "����:" + prpLlossDto.getLossName();
//					strLctextList.add(lineText);					
//					mybackupvalue.put("proptitle"+proptitileindex,prpLlossDto.getLossName()+"�˶���ʧ");			
//					proptitileindex++;
//					lineText = space(4) + lineReportText[1];
//					lineText +="=";
//					lineText += prpLlossDto.getFeeTypeName() ;
//					lineText +=lineReportText[2];	
//					strLctextList.add(lineText);																								
//					dbtempSumRest=prpLlossDto.getSumRest();
//					dbtempSumloss=prpLlossDto.getSumLoss();
//					lineText = space(16) + "=";					
//					lineText +=formatPay(dbtempSumloss)+"��"+formatPay(dbtempSumRest);
//					strLctextList.add(lineText);														
//					lineText = space(16) + "=" + formatPay(dbtempSumloss-dbtempSumRest) + "Ԫ";
//					strLctextList.add(lineText);
//					dbpropall+=dbtempSumloss-dbtempSumRest;					
//					mybackupvalue.put("prop"+propindex,formatPay(dbtempSumloss-dbtempSumRest));
//					propindex++;
//				}
//			}}
//		lineText = space(4) + "�Ʋ��˶�����ʧ ";
//		lineText +="=";			
//		for(int jj=0;jj<proptitileindex;jj++){
//			lineText +=mybackupvalue.get("proptitle"+jj).toString()+"��"	;
//		}
//		lineText =SubtractDesignate(lineText, "��");	
//				
//		strLctextList.add(lineText);			
//		lineText = space(16) + "=";					
//		for(int jj=0;jj<propindex;jj++){
//			lineText +=mybackupvalue.get("prop"+jj).toString()+"��"	;
//		}
//		lineText =SubtractDesignate(lineText, "��");
//		
//		
//		strLctextList.add(lineText);
//		lineText = space(16) + "=" + formatPay(dbpropall ) + "Ԫ";  //�ü���ʩ�ȷ�,��ʱд��100,����100Ӧ������dbpropall
//		strLctextList.add(lineText);  //  �Ʋ��ܺ˶��⳥��zheyihang 
//		/*if (( dbpropall) > propLimit){
//			lineText = space(4)	+ " ��˶��⳥�𳬹��Ʋ��⳥�޶�("+ formatPay(propLimit)+"Ԫ)������ ��";
//			strLctextList.add(lineText);
//			lineText = space(4) + "�Ʋ������Ʋ��⳥�޶�";
//			lineText += "=" + formatPay(propLimit) + "Ԫ";  //�ü���ʩ�ȷ�,��ʱд��100 
//			dbpropall = propLimit ; //
//		}else {
//		    lineText = space(4) + "�Ʋ������Ʋ��˶��⳥��";
//		    lineText += "=" + formatPay(dbpropall ) + "Ԫ";  //�ü���ʩ�ȷ�,��ʱд��100
//		}
//		
//		strLctextList.add(lineText);
//		*/
//		String strFeeReport = "";
//		String strFeeValueReport = "";
//		int persontitleindex=0;
//		int personindex=0;
//		double dbpersonall=0;
//		double dbpersonmedicalall=0;
//		double dbpersondeformityall=0;		
//	//	double dbpersonmedicallimit=0;		
//		dbtempSumRest=0;
//		dbtempSumloss=0;
//		
//		lineText="����ҽ�Ʒ��ã�";
//		strLctextList.add(lineText);
//		for (j = 1; j <= personcount; j++) {
//			if (arrKindCodePerson[j].indexOf("B") < 0)
//				continue;
//			
//			
//			lineText = space(4) + "������Ա"+ "("
//			+ arrPersonName[j].trim() + ")��";
//			strLctextList.add(lineText);			
//			mybackupvalue.put("persontitle"+persontitleindex,"("+arrPersonName[j].trim()+")�˶���ʧ");						
//			persontitleindex++;
//			textpersoncount++;
//			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
//				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
//				/*				
//				 if (prpLpersonLossDto.getKindCode().equals("B")) {
//				 dbldeductiblerate = prpLpersonLossDto.getDeductibleRate();
//				 dblDutydeductiblerate = prpLpersonLossDto.getDutyDeductibleRate();
//				 dblDriverdeductiblerate = prpLpersonLossDto.getDriverDeductibleRate();
//				 dblamount = prpLpersonLossDto.getAmount();
//				 }
//				 */				
//				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])
//						&&prpLpersonLossDto.getRemark().equals("M")) {
//					strFeeReport +=prpLpersonLossDto.getLiabDetailName();
//					strFeeReport +="��";
//					strFeeValueReport+=formatPay(prpLpersonLossDto.getSumDefPay());//LYM
//					strFeeValueReport+="��";
//					//dbtempSumRest+=prpLpersonLossDto.getSumRest(); //��ʱ��Ҫ��ֵ LYM
//					dbtempSumloss+=	prpLpersonLossDto.getSumDefPay();//LYM
//					
//				}
//			}
//			strFeeReport  = space(4) + lineReportText[1]+"="+strFeeReport;
//			System.out.println(  "  strFeeReport ========="+strFeeReport);
//			strFeeValueReport= space(16) + "="+strFeeValueReport;	
//			System.out.println(  "  strFeeValueReport ========="+strFeeValueReport);
//			
//			if (StringUtils.getBytesLength(strFeeReport) > 60) {
//				arrFeeReport = (String[]) StringUtils.split(strFeeReport, 60);
//				lineText = arrFeeReport[0];
//				strLctextList.add(lineText);
//				lineText = space(7) + arrFeeReport[1];
//			} else {
//				lineText = strFeeReport;
//			}
//			
//			lineText = SubtractDesignate(lineText ,"��");	
//			//lineText =lineText;
//			strLctextList.add(lineText);
//			if (StringUtils.getBytesLength(strFeeValueReport) > 60) {
//				arrFeeReport = (String[]) StringUtils.split(strFeeValueReport, 60);
//				lineText = arrFeeReport[0];
//				strLctextList.add(lineText);
//				lineText = space(7) + arrFeeReport[1];
//			} else {
//				lineText = strFeeValueReport;
//			}
//			lineText = SubtractDesignate(lineText ,"��");
//			//lineText =lineText+"��"+formatPay(dbtempSumRest) ;  //��ʱ��Ҫ��ֵ LYM
//			strLctextList.add(lineText);
//			lineText= space(16) + "="+formatPay(dbtempSumloss) + "Ԫ";  //��ʱ��Ҫ��ֵ LYM
//			strLctextList.add(lineText);
//			mybackupvalue.put("person"+personindex,formatPay(dbtempSumloss)); //��ʱ��Ҫ��ֵ LYM
//			dbpersonall+=(dbtempSumloss); //��ʱ��Ҫ��ֵ LYM
//			personindex++;
//			strFeeReport="";
//			strFeeValueReport="";
//			dbtempSumRest =0;
//			dbtempSumloss  =	0;			
//		}
//		lineText = space(4) + "ҽ�ƺ˶�����ʧ=";
//		for(int jj=0;jj<persontitleindex;jj++){
//			lineText +=mybackupvalue.get("persontitle"+jj).toString()+"��"	;
//		}
//		lineText =SubtractDesignate(lineText, "��");			
//		strLctextList.add(lineText);			
//		lineText = space(16) + "=";							
//		for(int jj=0;jj<personindex;jj++){
//			lineText +=mybackupvalue.get("person"+jj).toString()+"��"	;
//		}		
//		lineText =SubtractDesignate(lineText, "��");					
//		strLctextList.add(lineText);			 
//		lineText = space(16) + "=" + formatPay(dbpersonall) + "Ԫ";
//		
//		/*if (dbpersonall>medicLimit){
//		   lineText = space(4) + "��ҽ�ƺ˶��⳥�𳬹�ҽ�Ʒ����޶"+ formatPay(medicLimit)+"Ԫ��,���ԣ�";   	
//	  	   strLctextList.add(lineText);
//		   lineText = space(4) + "ҽ������ҽ�Ʒ����޶� ";
//		   lineText += "=" + formatPay(medicLimit) + "Ԫ";
//		   dbpersonmedicalall=medicLimit;
//	    }
//		else {
//		   lineText = space(4) + "ҽ������ҽ�ƺ˶��⳥�� ";
//		   lineText += "=" + formatPay(dbpersonall) + "Ԫ";
//		   dbpersonmedicalall=dbpersonall;
//		}
//	    */	
//		strLctextList.add(lineText);		
//		dbpersonmedicalall=dbpersonall;
//		strFeeReport = "";
//		strFeeValueReport = "";
//		persontitleindex=0;
//		personindex=0;
//		dbpersonall=0;
//		dbtempSumRest=0;
//		dbtempSumloss=0;
//		lineText="���������˲з��ã�";
//		strLctextList.add(lineText);
//		for (j = 1; j <= personcount; j++) {
//			if (arrKindCodePerson[j].indexOf("B") < 0)
//				continue;
//			
//			
//			lineText = space(4) + "������Ա"+ "  "
//			+ arrPersonName[j].trim() + "��";
//			strLctextList.add(lineText);			
//			mybackupvalue.put("persondeformitytitle"+persontitleindex,"("+arrPersonName[j].trim()+")�˶���ʧ");						
//			persontitleindex++;
//			textpersoncount++;
//			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
//				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
//				
//				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])
//						&&prpLpersonLossDto.getRemark().equals("D")) {
//					strFeeReport +=prpLpersonLossDto.getLiabDetailName();
//					strFeeReport +="��";
//					strFeeValueReport+=formatPay(prpLpersonLossDto.getSumDefPay());  // LYM
//					strFeeValueReport+="��";
//					//dbtempSumRest+=prpLpersonLossDto.getSumRest();  //��ʱ��Ҫ��ֵ LYM
//					dbtempSumloss+=	prpLpersonLossDto.getSumDefPay(); // LYM
//					
//				}
//			}
//			strFeeReport  = space(4) + lineReportText[1]+"="+strFeeReport;
//			strFeeValueReport= space(16) + "="+strFeeValueReport;					
//			if (StringUtils.getBytesLength(strFeeReport) > 60) {
//				arrFeeReport = (String[]) StringUtils.split(strFeeReport, 60);
//				lineText = arrFeeReport[0];
//				strLctextList.add(lineText);
//				lineText = space(7) + arrFeeReport[1];
//			} else {
//				lineText = strFeeReport;
//			}
//			lineText = SubtractDesignate(lineText ,"��");	
//			//lineText =lineText+lineReportText[2];
//			strLctextList.add(lineText);
//			if (StringUtils.getBytesLength(strFeeValueReport) > 60) {
//				arrFeeReport = (String[]) StringUtils.split(strFeeValueReport, 60);
//				lineText = arrFeeReport[0];
//				strLctextList.add(lineText);
//				lineText = space(7) + arrFeeReport[1];
//			} else {
//				lineText = strFeeValueReport;
//			}
//			lineText = SubtractDesignate(lineText ,"��");
//			//lineText =lineText+"��"+formatPay(dbtempSumRest) ; //��ʱ��Ҫ��ֵ LYM
//			strLctextList.add(lineText);
//			lineText= space(16) + "="+formatPay(dbtempSumloss) + "Ԫ"; //��ʱ��Ҫ��ֵ LYM
//			strLctextList.add(lineText);
//			mybackupvalue.put("persondeformity"+personindex,formatPay(dbtempSumloss)); //��ʱ��Ҫ��ֵ LYM
//			dbpersonall+=(dbtempSumloss); //��ʱ��Ҫ��ֵ LYM
//			personindex++;
//			strFeeReport="";
//			strFeeValueReport="";
//			dbtempSumRest =0;
//			dbtempSumloss  =	0;
//			
//		}
//		lineText = space(4) + "�����˲к˶�����ʧ=";
//		for(int jj=0;jj<persontitleindex;jj++){
//			lineText +=mybackupvalue.get("persondeformitytitle"+jj).toString()+"��"	;
//		}
//		lineText =SubtractDesignate(lineText, "��");			
//		strLctextList.add(lineText);			
//		lineText = space(16) + "=";							
//		for(int jj=0;jj<personindex;jj++){
//			lineText +=mybackupvalue.get("persondeformity"+jj).toString()+"��"	;
//		}		
//		lineText =SubtractDesignate(lineText, "��");					
//		strLctextList.add(lineText);			 
//		lineText = space(16) + "=" + formatPay(dbpersonall) + "Ԫ";
//		strLctextList.add(lineText);
//		/*
//		if (dbpersonall>deathLimit){
//			   lineText = space(4) + "�������˲к˶��⳥�𳬹������˲��޶"+ formatPay(deathLimit)+"Ԫ��,���ԣ�";   	
//		  	   strLctextList.add(lineText);
//			   lineText = space(4) + "�����˲����������˲��޶� ";
//			   lineText += "=" + formatPay(deathLimit) + "Ԫ";
//			   dbpersondeformityall = deathLimit;  
//		}
//			else {
//			   lineText = space(4) + "�����˲����������˲к˶��⳥�� ";
//			   lineText += "=" + formatPay(dbpersonall) + "Ԫ";
//			   dbpersondeformityall =dbpersonall;
//			}
//		*/
//		 dbpersondeformityall =dbpersonall;
//		strLctextList.add(lineText);			 
//		
//		//------------------------------------------
//		lineText="�ġ����ձ�˶��⳥��"; 
//		strLctextList.add(lineText);
//		lineText =space(4) +lineReportText[4];
//		strLctextList.add(lineText);
//		lineText = space(16) + "=��" + formatPay(dbpropall) +"��"+formatPay(dbpersonmedicalall) +"��"+formatPay(dbpersondeformityall)+"���� 100%"   ;	//�¹����α�����ʱд��	
//		//lineText += "����1��5%��";		
//		strLctextList.add(lineText);		
//		lineText = space(16) + "=" + formatPay((dbpropall+dbpersonmedicalall+dbpersondeformityall)*0.01) + "Ԫ"; //�¹����α�����ʱд��
//		strLctextList.add(lineText);
//		double cormmerceBLimit = 100.00;//��ʱд��
//		double sumSumDefPay =0;
//		if (((dbpropall+dbpersonmedicalall+dbpersondeformityall)*0.01)> cormmerceBLimit){
//			lineText =	space(4) +" ��˶��⳥�𳬹��⳥�޶�("+cormmerceBLimit+"Ԫ)" ;
//			strLctextList.add(lineText);
//			lineText =	space(4) +"���ԣ��˶��⳥�� = �⳥�޶� = "+cormmerceBLimit+"Ԫ" ;
//			strLctextList.add(lineText);
//			sumSumDefPay =cormmerceBLimit;
//		}else {
//			sumSumDefPay =(dbpropall+dbpersonmedicalall+dbpersondeformityall)*0.01;
//		
//		}//-----------------------------------------
//		lineText="�塢����ʵ����"; ///���ﶼ��д����
//		strLctextList.add(lineText);
//		lineText =space(4) +lineReportText[5];
//		strLctextList.add(lineText);
//		lineText = space(16) + "=" + formatPay(sumSumDefPay) +" * ( 1-10%) *(1-10%)"   ;		
//		//lineText += "����1��5%��";		
//		strLctextList.add(lineText);		
//		lineText = space(16) + "=" + formatPay(sumSumDefPay*0.9 *0.9) + "Ԫ";
//		strLctextList.add(lineText);
//		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
//		logger.debug("������-ctextcount:"+ctextcount);
//		for (Iterator iter = strLctextList.iterator(); iter.hasNext();) {
//			lineText = (String) iter.next();
//			PrpLctextDto prpLctextDto = new PrpLctextDto();
//			prpLctextDto.setCompensateNo(strCompensateNo);
//			prpLctextDto.setTextType("1");
//			prpLctextDto.setLineNo(ctextcount++);
//			prpLctextDto.setContext(lineText);
//			prpLctextDto.setFlag("");
//			compensateData.prpLctextlist.add(prpLctextDto);
//		}
//	}
	
}
