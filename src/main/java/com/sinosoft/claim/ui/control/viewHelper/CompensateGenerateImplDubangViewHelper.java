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
		//禁止构造，通过getInstance()获得实例。
	}
	public static CompensateGenerateImplDubangViewHelper getInstance(){
		return compensateGenerateImplDubangViewHelper;
	}
	
	/**
	 * 生成机动车险理算报告
	 * 
	 * @param 无
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
		// 是否为逃逸案件
		compensateData.strEscapeFlag = prpLclaimDto.getEscapeFlag();

		// add by qinyongli start 2005-8-5 获取出险时间
		String registNo = compensateDto.getPrpLclaimDto().getRegistNo();
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		// add by qinyongli end
		// 取得保单的信息
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
		 * 先初始化A险及B险,再检测该案有无A及B险,没有再删除
		 */
		vecKindCode.add("A");
		vecKindCode.add("B");

		boolean isHaveRiskA = false;
		boolean isHaveRiskB = false;
		for (Iterator iter = compensateDto.getPrpLlossDtoList().iterator(); iter.hasNext();) {
			PrpLlossDto prpLlossDto = (PrpLlossDto) iter.next();
			if (prpLlossDto.getFamilyName() == null || prpLlossDto.getFamilyName().length() == 0) {
				// 车牌号码
				prpLlossDto.setFamilyName(prpLclaimDto.getLossName());// 增加车牌号码
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
		//三者险放开施救费的输入，从而当没有三者险险别但有三者险的施救费时，依然走CarCreateForB()的生成
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

		logger.debug("开始生成各险别的公式及内容");	
		
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

		logger.debug("开始生成本案实赔金额公式及内容");

		List strLctextList = new ArrayList();
		strLctextList.add("");

		String lineText="";
		if (vecKindCode.size() > 0) {
			lineText = "本案实赔金额=";

			for (Iterator iter = vecKindCode.iterator(); iter.hasNext();) {
				String kindCode = (String) iter.next();
				if ("A".equals(kindCode)) {
					lineText += "车损险赔款＋";
				}else if ("B".equals(kindCode)) {
					lineText += "第三者责任险赔款＋";
				}else if("D3".equals(kindCode)){
					lineText += "车上人员责任险-司机座位赔款＋";
				}else if("D4".equals(kindCode)){
					lineText += "车上人员责任险-乘客座位赔款＋";
				}else if("G".equals(kindCode)){
					lineText += "全车盗抢险赔款＋";
				}else {
					if(lineText.indexOf("附加险赔款") == -1){
						lineText += "附加险赔款＋";
					}
					
				}
			}
			if (StringUtils.getBytesLength(lineText) > 14){
				lineText = lineText.substring(0, (lineText.length() - 1));
			}
			
			if(SumPrePaid > 0){
				lineText += " - 预付赔款";
			}
			strLctextList.add(lineText);
			lineText = "";
			boolean isContain_dblOtherSumRealPay = false;
			for (Iterator iter = vecKindCode.iterator(); iter.hasNext();) {
				String kindCode = (String) iter.next();
				if("A".equals(kindCode)){
					lineText = "            " + "=" + formatPay(compensateData.dblCarSumRealPay+compensateData.dblChargeSumRealPay) + "＋";
				}else if("B".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblThirdSumRealPay) + "＋";
					else
						lineText += formatPay(compensateData.dblThirdSumRealPay) + "＋";
				}else if("D3".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblDriverSumRealPay) + "＋";
					else
						lineText += formatPay(compensateData.dblDriverSumRealPay) + "＋";
				}else if("D4".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblPassengerSumRealPay) + "＋";
					else
						lineText += formatPay(compensateData.dblPassengerSumRealPay) + "＋";
				}else if("G".equals(kindCode)){
					if (lineText == null || lineText.length() == 0)
						lineText = "            " + "="	+ formatPay(compensateData.dblStealSumRealPay) + "＋";
					else
						lineText += formatPay(compensateData.dblStealSumRealPay) + "＋";
				}else{
					if(!isContain_dblOtherSumRealPay){
						if (lineText == null || lineText.length() == 0){						
							lineText = "            " + "="	+ formatPay(compensateData.dblOthSumRealPay + compensateData.dblNoFranchise) + "＋";
						}else{
							lineText += formatPay(compensateData.dblOthSumRealPay + compensateData.dblNoFranchise) + "＋";
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
			lineText = "            " + "=" + formatPay(compensateData.dblAllSumRealPay - SumPrePaid) + "元";
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
	 * 生成车损险的公式及内容
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
		double dblValue = 0;	//残值
		double dblsumDefPay = 0;


		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();

		String dedutibleAall = httpServletRequest.getParameter("prpLDeductible");
		if (dedutibleAall == null || dedutibleAall.equals("")) {
			dedutibleAall = "0";
		}

		// ==============取得保单的信息
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

		strLctextList.add("车辆损失险：");

		lineText =space(8)+"实赔金额=(";
		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
			if (prpLlossDto.getKindCode().equals("A")) {
				if (StringUtils.getBytesLength(lineText) + StringUtils.getBytesLength(prpLlossDto.getFeeTypeName()) > 60) {
					strLctextList.add(lineText);
					lineText = space(17) + prpLlossDto.getFeeTypeName() + "＋";
				} else {
					lineText += prpLlossDto.getFeeTypeName() + "＋";
				}
			}
		}
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			lineText = lineText.substring(0, (lineText.length() - 1));
			strLctextList.add(lineText);
			lineText = ")";  //LYM 不用残值计算
		} else {
			lineText = lineText.substring(0, (lineText.length() - 1));
			lineText += ")";  //LYM 不用残值计算
		}

		if (StringUtils.getBytesLength(lineText) + 10 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "×赔偿比例×协商赔偿比例";
		} else {
			lineText += "×赔偿比例×协商赔偿比例";
		}
		if (StringUtils.getBytesLength(lineText) + 10 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "×责任比例";
		} else {
			lineText += "×责任比例";
		}
		if (StringUtils.getBytesLength(lineText) + 11 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "×(1－事故责任免赔率)×(1-绝对免赔率)";
			strLctextList.add(lineText);
		} else {
			lineText += "×(1－事故责任免赔率)×(1-绝对免赔率)";
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
					lineText = space(17)	+ formatPay(prpLlossDto.getSumDefPay()) + "＋";
				} else {
					lineText += formatPay(prpLlossDto.getSumDefPay()) + "＋";
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
			lineText = space(17) + ")"; //LYM 不用残值计算
		} else {
			lineText += ")"; //LYM 不用残值计算
		}
		//dblsumloss = dblsumloss - dblsumrest; //LYM 不用残值计算
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％";
			lineText += "×" + formatPay(prpLlossDtobak.getArrangeRate()) + "％";
		} else {
			lineText += "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％";
			lineText += "×" + formatPay(prpLlossDtobak.getArrangeRate())+ "％";
		}
		dblsumloss = dblsumloss * prpLlossDtobak.getClaimRate() / 100 * prpLlossDtobak.getArrangeRate() / 100;
		if (StringUtils.getBytesLength(lineText) + 8 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "×" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "％";
		} else {
			lineText += "×" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "％";
		}
		dblsumloss = dblsumloss * prpLlossDtobak.getIndemnityDutyRate() / 100;

		if (StringUtils.getBytesLength(lineText) + 10 > 60) {
			strLctextList.add(lineText);
			lineText = space(17) + "×(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)" 
			+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
			strLctextList.add(lineText);
		} else {
			lineText += "×(1-"+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)" 
			+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
			strLctextList.add(lineText);
		}

		dblsumdefloss = dblsumloss
		* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
		* (1 - prpLlossDtobak.getDeductibleRate() / 100);


		lineText = space(16) + "=" + formatPay(dblsumdefloss) + "元";
		strLctextList.add(lineText);
		lineText = "";
		/*if (dblValue > 0 && dblsumdefloss > dblValue) {
			strLctextList.add(lineText);
			lineText = space(4) + "因该车投保了自负额附加条款，且自负额为" + formatPay(dblValue)	+ "元，";
			strLctextList.add(lineText);
			lineText = space(4) + "故车损险实赔金额 =" + formatPay(dblsumdefloss) + "-" 	+ formatPay(dblValue) 
			+ "=" + formatPay(dblsumdefloss - dblValue) + "元";
			dblcarsumrealpay = dblcarsumrealpay - dblValue;
			strLctextList.add(lineText);
		}*/

		/*if (dblsumdefloss > prpLlossDtobak.getItemValue() && !prpCitemCarDto.getClauseType().equals("F11")) {
			strLctextList.add(lineText);
			lineText = space(4) + "赔款大于等于保险车辆实际价值,故赔款按以下计算:";
			strLctextList.add(lineText);
			lineText = space(6) + "赔付金额 = 保险车辆实际价值 = " + formatPay(prpLlossDtobak.getItemValue()) + "元";
			dblcarsumrealpay = prpLlossDtobak.getItemValue();
			strLctextList.add(lineText);
		}*/


//		dblcardeductible = dblsumloss * prpLlossDtobak.getDeductibleRate() / 100;

		compensateData.dblCarSumRealPay += dblcarsumrealpay;

//		this.dblAllSumDeductible += dblcardeductible;

		compensateData.dblAllSumRealPay += dblcarsumrealpay;



		/**
		 * 开始进行施救费的计算
		 */
		int chargecount = 0;
		int j = 0;
		double dblchargesumrealpay = 0;
		double dblRescuesumrealpay=0;
//		double dblchargedeductible=0;
		PrpLchargeDto[] arrPrpLchargeDto = new PrpLchargeDto[50];
		/**
		 * 首先对费用信息进行合并，将同险别同费用类别同币别的进行分类
		 */
		for (int i = 0; i < compensateDto.getPrpLchargeDtoList().size(); i++) {
			
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) compensateDto.getPrpLchargeDtoList().get(i);
			//只算车损险的信息
			if("A".equals(prpLchargeDto.getKindCode()))
			{
				/**
				 * 施救费要按车险公式进行计算
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
				//仅计算车损险的施救费
				if ("03".equals(arrPrpLchargeDto[i].getChargeCode())) {
					/**
					 * 开始生成施救费的计算公式；
					 */
//					dblsumloss = arrPrpLchargeDto[i].getChargeAmount();
					//dblRescuesumrealpay = arrPrpLchargeDto[i].getSumRealPay();
					dblRescuesumrealpay = arrPrpLchargeDto[i].getChargeReport();

					lineText = space(8) + "施救费用=施救费用金额×赔偿比例×责任比例" + "×(1－事故责任免赔率)×(1-绝对免赔率)";
					strLctextList.add(lineText);
					lineText = space(16)+"="+formatPay(dblRescuesumrealpay) 
					+ "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％"
					+ "×" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "％"
					+ "×(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)" 
					+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
					strLctextList.add(lineText);	
					dblRescuesumrealpay = dblRescuesumrealpay
					* prpLlossDtobak.getClaimRate()/100
					* prpLlossDtobak.getIndemnityDutyRate()/100
					* (1-prpLlossDtobak.getDutyDeductibleRate()/100)
					* (1-prpLlossDtobak.getDeductibleRate()/100);
					
					lineText = space(16) + "="	+ formatPay(dblRescuesumrealpay) + "元";
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
		 * 开始进行车损的实赔付计算(车损险赔付金额+施救费-绝对免赔额)
		 */
		dbdeductible = Double.parseDouble(dedutibleAall);
		lineText=space(6)+"车损实赔付=实赔金额";
		if(dblRescuesumrealpay>0){
			lineText+="+施救费";
		}
		if(dbdeductible>0){
			lineText+="-绝对免赔额";
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
				lineText = space(16)+"="+formatPay(dblsumdefloss+dblRescuesumrealpay-dbdeductible) + "元";
			}else{
				lineText = space(16)+"=0" + "元";
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
	 * 生成三者险的理算公式及报告
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
		//double dblsumdefamount = 0;    //赔款金额，即核定赔偿与责任比例的积
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
		
		//取B限额---------------------------
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
			 lineText = "第三者责任险：";
		}else if("D3".equals(kindCode)){
			 lineText = "车上人员责任险-司机座位：";
		}else if("D4".equals(kindCode)){
			 lineText = "车上人员责任险-乘客座位：";
		}
		
		for (int i = 1; i <= licensenocount; i++) {
			dblsumloss = 0;
			if (arrKindCode[i].indexOf(kindCode) < 0)
				continue;
//			repcount++;
			strLctextList.add(lineText);
			lineText="";
			if (!lossName[i].trim().equals("车辆")) {
				lineText = space(4) + lossName[i].trim();
			} else {
				lineText = space(4) + arrLicenseNo[i].trim() + "号车";
			}
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "本项实赔金额=(";
			textlosscount++;

			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
				if (prpLlossDto.getKindCode().equals(kindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
					if (StringUtils.getBytesLength(lineText) + prpLlossDto.getFeeTypeName().length() + 2 > 60) {
//						repcount++;
						strLctextList.add(lineText);
						lineText = space(17) + prpLlossDto.getFeeTypeName() + "＋";
					} else {
						lineText += prpLlossDto.getFeeTypeName() + "＋";
					}
				}
			}
			lineText = lineText.substring(0, (lineText.length() - 1)) + ")";

			// 增加赔偿比例
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×赔偿比例×协商赔偿比例";
			} else {
				lineText += "×赔偿比例×协商赔偿比例";
			}

			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×责任比例";
			} else {
				lineText += "×责任比例";
			}
			if (StringUtils.getBytesLength(lineText) + 11 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×(1－事故责任免赔率)×（1-绝对免赔率)";// ×(1-驾驶员免赔率)";
			} else {
				lineText += "×(1－事故责任免赔率)×(1-绝对免赔率)";// ×(1-驾驶员免陪率)";
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
						lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "＋";
					} else {
						lineText += formatPay(prpLlossDto.getSumDefPay()) + "＋";
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

			// 增加赔偿比例
			if (StringUtils.getBytesLength(lineText) + 8 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％";
				lineText+="×" + formatPay(prpLlossDtobak.getArrangeRate()) + "％";
			} else {
				lineText += "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％";
				lineText+="×" + formatPay(prpLlossDtobak.getArrangeRate()) + "％";
			}
			dblsumloss = dblsumloss * prpLlossDtobak.getClaimRate()/100 * prpLlossDtobak.getArrangeRate() / 100;
			if (StringUtils.getBytesLength(lineText) + 8 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×" + formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "％";
			} else {
				lineText += "×"	+ formatPay(prpLlossDtobak.getIndemnityDutyRate()) + "％";
			}
			dblsumloss = dblsumloss * prpLlossDtobak.getIndemnityDutyRate() / 100;
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×(1－"
				+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)" + "×(1－"
				+ formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";// + "×(1－"+new
				// DecimalFormat("#,##0.00").format(prpLlossDtobak.getDriverDeductibleRate())+"％)";
			} else {
				lineText += "×(1－"
					+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)" + "×(1－"
					+ formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";// + "×(1－"+new
				// DecimalFormat("#,##0.00").format(prpLlossDtobak.getDriverDeductibleRate())+"％)";
			}
			dblthirdsumdefloss += dblsumloss;

			// 在下面的算式中增加赔偿比例信息
			dblsumdefloss = dblsumloss //* (prpLlossDtobak.getClaimRate() / 100.0)
			* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
			* (1 - prpLlossDtobak.getDeductibleRate() / 100);// *(1 -
//			dbldeductible = dblsumloss * prpLlossDtobak.getDeductibleRate() / 100;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(16) + "=" + formatPay(dblsumdefloss) + "元";

//			dblthirddeductible += dbldeductible;
		}

		if (intpropflag == 1) {
			textlosscount++;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "财产赔付:";
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals(kindCode)
						&& (prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
						&& prpLlossDto.getLossName() != null) {
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(4) + "项目:" + prpLlossDto.getLossName();
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额=损失金额×责任比例×(1－事故责任免赔率)×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
					dblsumloss = 0;
					dblsumdefloss = 0;
					dbldeductiblerate = prpLlossDto.getDeductibleRate();
					dblDutydeductiblerate = prpLlossDto.getDutyDeductibleRate();
					//dblamount = prpLlossDto.getAmount();
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(16) + "="
					+ formatPay(prpLlossDto.getSumDefPay()) + "×"
					+ formatPay(prpLlossDto.getIndemnityDutyRate()) + "％" + "×"
					+ "(1-" + formatPay(prpLlossDto.getDutyDeductibleRate()) + "％)"
					+ "(1-" + formatPay(prpLlossDto.getDeductibleRate()) + "％)";// +
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(16) + "="	+ formatPay(prpLlossDto.getSumRealPay()) + "元";
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

		// 人员处理表。
		for (j = 1; j <= personcount; j++) {
			if (arrKindCode1[j].indexOf(kindCode) < 0)
				continue;
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(4) + "车辆号牌号码为" + arrFamilyName[j].trim() + "的出险人员" + "  "
			+ arrPersonName[j].trim() + "：";
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
			lineText = space(4) + "本项实赔金额=(";
			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
				if (prpLpersonLossDto.getKindCode().equals(kindCode)	&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim())) {
					if (StringUtils.getBytesLength(lineText)
							+ StringUtils.getBytesLength(prpLpersonLossDto.getLiabDetailName()) + 1 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + prpLpersonLossDto.getLiabDetailName() + "×赔偿比例＋";
					} else {
						lineText += prpLpersonLossDto.getLiabDetailName() + "×赔偿比例＋";
					}
				}
			}
			lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×责任比例×协商赔偿比例";
			} else {
				lineText += "×责任比例×协商赔偿比例";
			}
			if (StringUtils.getBytesLength(lineText) + 11 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×(1－事故责任免赔率)×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
			} else {
				lineText += "×(1－事故责任免赔率)×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
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
						+ formatPay(prpLpersonLossDto.getSumDefPay()) + "×"  //LYM
						+ formatPay(prpLpersonLossDto.getClaimRate()) + "％" + "＋";
					} else {
						lineText += formatPay(prpLpersonLossDto.getSumDefPay()) //LYM
						+ "×" + formatPay(prpLpersonLossDto.getClaimRate()) + "％"
						+ "＋";
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
				lineText = space(17) + "×" + formatPay(prpLpersonLossDtobak.getIndemnityDutyRate()) + "％";
				lineText += "×" + formatPay(prpLpersonLossDtobak.getArrangeRate()) + "％";
			} else {
				lineText += "×"	+ formatPay(prpLpersonLossDtobak.getIndemnityDutyRate()) + "％";
				lineText += "×"	+ formatPay(prpLpersonLossDtobak.getArrangeRate()) + "％";
			}
			dblsumloss = dblsumloss * prpLpersonLossDtobak.getIndemnityDutyRate() / 100;
			dblsumloss = dblsumloss * prpLpersonLossDtobak.getArrangeRate() / 100;
			if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//				repcount++;
				strLctextList.add(lineText);
				lineText = space(17) + "×(1－"
				+ formatPay(prpLpersonLossDtobak.getDutyDeductibleRate()) + "％)"
				+ "×(1－" + formatPay(prpLpersonLossDtobak.getDeductibleRate())
				+ "％)";// +
			} else {
				lineText += "×(1－"
					+ formatPay(prpLpersonLossDtobak.getDutyDeductibleRate()) + "％)"
					+ "×(1－" + formatPay(prpLpersonLossDtobak.getDeductibleRate())
					+ "％)";// +
			}

			dblthirdsumdefloss += dblsumloss;
			dblsumdefloss = dblsumloss * (1 - prpLpersonLossDtobak.getDutyDeductibleRate() / 100)
			* (1 - prpLpersonLossDtobak.getDeductibleRate() / 100);
//			repcount++;
			strLctextList.add(lineText);
			lineText = space(16) + "=" + formatPay(dblsumdefloss) + "元";
//			dbldeductible = dblsumloss * prpLpersonLossDtobak.getDeductibleRate() / 100;
//			dblthirddeductible += dbldeductible;
		}
		
		/**
		 * 开始进行三者险施救费的计算
		 */
		int chargecount = 0;
		double dblchargesumrealpay = 0;
		double dblRescuesumrealpay=0;
		PrpLchargeDto[] arrPrpLchargeDto = new PrpLchargeDto[50];
		/**
		 * 首先对费用信息进行合并，将同险别同费用类别同币别的进行分类
		 */
		for (int i = 0; i < compensateDto.getPrpLchargeDtoList().size(); i++) {
			
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) compensateDto.getPrpLchargeDtoList().get(i);
			//只算三者险的信息
			if("B".equals(prpLchargeDto.getKindCode()) && "03".equals(prpLchargeDto.getChargeCode()))
			{
				/**
				 * 施救费要按车险公式进行计算
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
				//仅计算三者险的施救费
				if ("03".equals(arrPrpLchargeDto[i].getChargeCode()) && "B".equals(arrPrpLchargeDto[i].getKindCode())) {
					/**
					 * 开始生成施救费的计算公式；
					 */
					dblRescuesumrealpay = arrPrpLchargeDto[i].getSumRealPay();
					strLctextList.add(lineText);
					lineText = space(4) + "施救费用= "+formatPay(dblRescuesumrealpay)+ "元" ;
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
						
/*						  strLctext[repcount] = " " + "因按事故责任比例应承担的赔偿金额" +
						  "超过三者险的赔偿限额，所以："; repcount++; strLctext[repcount] = " " +
						  "本险别实赔金额=赔偿限额×（1－事故责任免赔率）*（1-绝对免赔率）="//*(1-驾驶员免赔率)="
						  +formatPay(dblamount) +
						  "×(1－" +new
						 DecimalFormat("#,##0.00").format(dblDutydeductiblerate) +
						  "％)"+"×(1－" +new
						  DecimalFormat("#,##0.00").format(dbldeductiblerate) +
						  "％)"+"×(1－" +new
						  DecimalFormat("#,##0.00").format(dblDriverdeductiblerate) +
						  "％)"; repcount++; strLctext[repcount] = " " + "=" +
						  new
						  DecimalFormat("#,##0.00").format(dblamount*(1-dblDutydeductiblerate/100)*(1-dbldeductiblerate/100)*(1-dblDriverdeductiblerate/100)) +
						  "元"; dblthirddeductible = dblamount *
						  dbldeductiblerate / 100;
*/						 
						if("B".equals(kindCode)){
							lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过三者险的赔偿限额，所以：";
						}else if("D3".equals(kindCode)){
							lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过车上人员责任险-司机座位的赔偿限额，所以：";
						}else if("D4".equals(kindCode)){
							lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过车上人员责任险-乘客座位的赔偿限额，所以：";
						}
						strLctextList.add(lineText);
						if("D3".equals(kindCode) || "D4".equals(kindCode))
							lineText = space(4) + "本险别实赔金额=赔偿限额×（1－事故责任免赔率）×（1－绝对免赔率）=";
						else
							lineText = space(4) + "本险别实赔金额=限额×（1－事故责任免赔率）×（1－绝对免赔率）="// ×(1-驾驶员免赔率)="
						+ formatPay(dblamount) + "×(1－"
						+ formatPay(dblDutydeductiblerate) + "％)" + "×(1－"
						+ formatPay(dbldeductiblerate) + "％)" ;//+ "×(1－"
						//+ formatPay(dblDriverdeductiblerate) + "％)";
//						repcount++;
						strLctextList.add(lineText);
						lineText = "                  "
							+ "="
							+ formatPay(dblamount * (1 - dblDutydeductiblerate / 100)
									* (1 - dbldeductiblerate / 100) ) + "元";
						dblthirdsumrealpay = dblamount *(1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100);
					} else {
						lineText = space(4) + "本险别实赔金额=人员实赔金额 ";
						if(dblRescuesumrealpay>0)
						{
							lineText+="+施救费";
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
						lineText = space(16)+"="+formatPay(dblthirdsumperson) + "元";
					}
				} else if (textpersoncount == 0) {
//					repcount++;
					strLctextList.add(lineText);
					if (dblthirdsumdefloss > dblamount
							&& (compensateData.strEscapeFlag.length() > 0 && compensateData.strEscapeFlag.charAt(0) != 'T' || compensateData.strEscapeFlag
									.length() == 0)) {

						if("B".equals(kindCode)){
							lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过三者险的赔偿限额，所以：";
						}else if("D3".equals(kindCode)){
							lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过车上人员责任险-司机座位的赔偿限额，所以：";
						}else if("D4".equals(kindCode)){
							lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过车上人员责任险-乘客座位的赔偿限额，所以：";
						}//						repcount++;
						strLctextList.add(lineText);
						lineText = space(4) + "本险别实赔金额=赔偿限额×（1－事故责任免赔率）×（1－绝对免赔率）="// ×(1-驾驶员免赔率)="
						+ formatPay(dblamount) + "×(1－"
						+ formatPay(dblDutydeductiblerate) + "％)" + "×(1－"
						+ formatPay(dbldeductiblerate) + "％)";// + "×(1－"
						//+ formatPay(dblDriverdeductiblerate) + "％)";
//						repcount++;
						strLctextList.add(lineText);
						lineText = "                  "
							+ "="
							+ formatPay(dblamount * (1 - dblDutydeductiblerate / 100)
									* (1 - dbldeductiblerate / 100)) + "元";
//						dblthirddeductible = dblamount * dbldeductiblerate / 100;
						dblthirdsumrealpay = dblamount *(1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100);
					} else {
						lineText = space(4) + "本险别实赔金额=标的实赔金额 ";
						if(dblRescuesumrealpay>0)
						{
							lineText+="+施救费";
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
						lineText = space(16)+"="+formatPay(dblthirdsumloss)+ "元";
					}
				}
			} else if (textlosscount * textpersoncount > 0) {
//				repcount++;
				strLctextList.add(lineText);
				if (dblthirdsumdefloss > dblamount
						&& (compensateData.strEscapeFlag.length() > 0 && compensateData.strEscapeFlag.charAt(0) != 'T' || compensateData.strEscapeFlag
								.length() == 0)) {
					if("B".equals(kindCode)){
						lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过三者险的赔偿限额，所以：";
					}else if("D3".equals(kindCode)){
						lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过车上人员责任险-司机座位的赔偿限额，所以：";
					}else if("D4".equals(kindCode)){
						lineText = space(4) + "因按事故责任比例应承担的赔偿金额" + "超过车上人员责任险-乘客座位的赔偿限额，所以：";
					}
 
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(4) + "本险别实赔金额=赔偿限额×（1－-事故责任免赔率）×(1-绝对免赔率)";
					strLctextList.add(lineText);
					lineText= "                  ="				
						+ formatPay(dblamount) + "×(1－"
						+ formatPay(dblDutydeductiblerate) + "％)" + "×(1－"
						+ formatPay(dbldeductiblerate) + "％)" ;//+ "×(1－"
						//+ formatPay(dblDriverdeductiblerate) + "％)";
//					repcount++;
					strLctextList.add(lineText);
					lineText = "                  " + "="
					+ formatPay(dblamount * (1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100)) + "元";
//					dblthirddeductible = dblamount * dbldeductiblerate / 100;
					dblthirdsumrealpay = dblamount *(1 - dblDutydeductiblerate / 100)*(1 - dbldeductiblerate / 100);
				} else {
					lineText = space(4) + "本险别实赔金额=标的实赔金额＋人员实赔金额";
//					repcount++;
					if(dblRescuesumrealpay>0)
					{
						lineText+="+施救费";
					}
					strLctextList.add(lineText);
					lineText = "                  " + "="
					+ formatPay(dblthirdsumloss) + "＋"
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
					lineText = "                  " + "=" + formatPay(dblthirdsumloss) + "元";
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
		logger.debug("三者险-车上人员-ctextcount:"+ctextcount);
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
	 * 生成附加险的理算公式及内容
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
			 * 车辆不计免赔特约保险
			 * ----------------------------------------------------------------------------------------
			 */			
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				if (prpLlossDto.getKindCode().equals("M")) {
					lineText = "车辆不计免赔特约保险=";
					lineText += formatPay(prpLlossDto.getSumRealPay()) + "元";
					dblnofranchise = prpLlossDto.getSumRealPay();
				}
			}
		} else if (iKindCode.trim().equals("G")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * 盗抢险
			 * ----------------------------------------------------------------------------------------
			 */
			dblsumdefloss = 0;
			dblsumloss = 0;
			strLctextList.add(lineText);
			lineText = "全车盗抢险：";
			//if (compensateData.strEscapeFlag.length() > 1 && compensateData.strEscapeFlag.charAt(1) != 'Y' || compensateData.strEscapeFlag.length() <= 1) {
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额=(";
				for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
					if (prpLlossDto.getKindCode().equals("G")) {
						if (StringUtils.getBytesLength(lineText.trim())
								+ StringUtils.getBytesLength(prpLlossDto.getFeeTypeName()) + 1 > 60) {
							strLctextList.add(lineText);
							lineText = space(17) + prpLlossDto.getFeeTypeName() + "＋";
						//	lineText = space(17) + "核定赔偿"+ "＋";
						} else {
							lineText += prpLlossDto.getFeeTypeName() + "＋";
							//lineText +=  "核定赔偿"+ "＋";
						}
					}
				}
				//全车盗抢险是否发生了“全车被盗、抢，两个月内未查明下落的免赔条件”
				boolean conditionsFalg = false;
				 List prpLdeductCondDtoList = new ArrayList();
				 prpLdeductCondDtoList = prpLcompensateDto.getPrpLdeductCondDtoList();
				 if(prpLdeductCondDtoList != null && prpLdeductCondDtoList.size() != 0){
				  for(int i=0;i<prpLdeductCondDtoList.size();i++){
					  PrpLdeductCondDto prpLdeductCondDto = (PrpLdeductCondDto)prpLdeductCondDtoList.get(i);
					  if(   "290".equals(prpLdeductCondDto.getDeductCondCode())
						 && "全车被盗、抢，自立案起两个月未查明下落".equals(prpLdeductCondDto.getDeductCondName())
						 && prpLdeductCondDto.getTimes() == 1
						 ){
						  	conditionsFalg = true;
						  	break;
					  }
				  }
				 }
				
				lineText = lineText.substring(0, (lineText.length() - 1)) + " ";// + ")";
				//当发生了“”免赔条件时，需要计算绝对免赔率，否则，将全赔
				if(conditionsFalg){
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + ")×协商赔偿比例×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
					} else {
						lineText += ")×协商赔偿比例×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
					}					
				}else{
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "- 残值)×协商赔偿比例";// ×(1-驾驶员免赔率)";
					} else {
						lineText += "- 残值)×协商赔偿比例";// ×(1-驾驶员免赔率)";
					}
				}

				/*if (StringUtils.getBytesLength(lineText) + 8 > 60) {
					strLctextList.add(lineText);
					lineText = space(17) + "×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
				} else {
					lineText += "×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
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
						lineText += formatPay(prpLlossDto.getSumLoss()) + "＋";
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
						+ "×"+formatPay(prpLlossDtobak.getArrangeRate()) + "％"					
						+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
						
					}else{
						lineText = space(17) +  "-" + formatPay(dblsumrest) + ")"
						+ "×"+formatPay(prpLlossDtobak.getArrangeRate()) + "％";
					//	+ "×(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)"
					//	+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
						
					}
				} else {
					if(conditionsFalg){
						lineText +=  ")" 
						+ "×"+formatPay(prpLlossDtobak.getArrangeRate()) + "％"							
						+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
						
					}else{
						lineText += "-" + formatPay(dblsumrest) + ")" 
						+ "×"+formatPay(prpLlossDtobak.getArrangeRate()) + "％";			
						//+ "×(1-" + formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)"
						//+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
						
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
				lineText = space(16) + "=" + formatPay(dblsumloss) + "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "赔付金额超过本险种保险金额，故按保险金额赔付：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
				}
			//}
		    /* else {
				strLctextList.add(lineText);
				for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
					if (prpLlossDto.getKindCode().equals("G"))
						break;
				}
				lineText = space(4) + "本项实赔金额 = 保险金额×协商赔偿比例×(1-事故责任免赔率）×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
				strLctextList.add(lineText);
				lineText = space(17) 
						+ "="
						+ formatPay(prpLlossDto.getAmount()) 
						+ "×"+formatPay(prpLlossDtobak.getArrangeRate()) + "％"	
						+ "×（1-" + formatPay(prpLlossDto.getDutyDeductibleRate()) + "％）" 
						+ "×（1-" + formatPay(prpLlossDto.getDeductibleRate()) + "％）" 
						+ "=" 
						+ formatPay(prpLlossDto.getSumRealPay()) + "元";
				dblothsumrealpay += prpLlossDto.getSumRealPay();
			}*/
		} else if (iKindCode.equals("T") || iKindCode.equals("C")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * 车辆停驶险
			 * ----------------------------------------------------------------------------------------
			 */			
			strLctextList.add(lineText);
			if (iKindCode.equals("T")) {
				lineText = "车辆停驶险：";
			}
			else{
				lineText = "代步车费用险：";
			}

			strLctextList.add(lineText);
			lineText = space(4) + "本项实赔金额=(约定日赔偿金额× 赔偿天数)-绝对免赔额";
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
					+ formatPay(dblothsumrealpay) + "元";
			if (dblsumloss > prpLlossDtobak.getAmount()) {
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额赔偿金额超过车辆停驶险的赔偿限额，所以：";
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额 = 保额 ="
						+ formatPay(prpLlossDtobak.getAmount()) + "元";
			} 
		} else if (iKindCode.equals("F")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * 玻璃单独破碎险
			 * ----------------------------------------------------------------------------------------
			 */						
			strLctextList.add(lineText);
			lineText = "玻璃单独破碎险：";
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
				lineText = space(4) + "本项实赔金额 = 保额 ="
						+ formatPay(prpLlossDtobak.getAmount()) + "元";
			} else {
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额=实际修理费用 = "//×(1-驾驶员免赔率)="
						+ lineTextTemp.substring(0,lineTextTemp.length() - 2) + "="
						+ formatPay(dblsumloss) + "元";
			}
			dblsumloss = 0;
			dblsumdefloss = 0;

		}else if (iKindCode.equals("H") || iKindCode.equals("R")) {
			/*
			 * ----------------------------------------------------------------------------------------
			 * 交通事故精神损失险、车载货物掉落险
			 * ----------------------------------------------------------------------------------------
			 */					
			if (iKindCode.equals("R")) {
				lineText = "交通事故精神损失险：";
			}
			if (iKindCode.equals("H")) {
				lineText = "车载货物掉落险：";
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
					if (!lossName[i].trim().equals("车辆")) {
						lineText = space(4) + lossName[i].trim();
					} else {
						lineText = space(4) + arrLicenseNo[i].trim() + "号车";
					}
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额=(";
					textlosscount++;
	
					for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
						prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
						if (prpLlossDto.getKindCode().equals(iKindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
							if (StringUtils.getBytesLength(lineText) + prpLlossDto.getFeeTypeName().length() + 2 > 60) {
								strLctextList.add(lineText);
								lineText = space(17) + prpLlossDto.getFeeTypeName() + "＋";
							} else {
								lineText += prpLlossDto.getFeeTypeName() + "＋";
							}
						}
					}
					lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
	
					if (StringUtils.getBytesLength(lineText) + 10 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "×赔偿比例×协商赔偿比例";
					} else {
						lineText += "×赔偿比例×协商赔偿比例";
					}
					if (StringUtils.getBytesLength(lineText) + 11 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "×（1-绝对免赔率)";
					} else {
						lineText += "×(1-绝对免赔率)";
					}
				
					strLctextList.add(lineText);
					lineText = space(16) + "=(";
	
					for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
						prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
						if (prpLlossDto.getKindCode().equals(iKindCode) && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i].trim())) {
							if (StringUtils.getBytesLength(lineText) + 3 > 60) {
								strLctextList.add(lineText);
								lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "＋";
							} else {
								lineText += formatPay(prpLlossDto.getSumDefPay()) + "＋";
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
					// 增加赔偿比例
					if (StringUtils.getBytesLength(lineText) + 8 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％";
						lineText+="×" + formatPay(prpLlossDtobak.getArrangeRate()) + "％";
					} else {
						lineText += "×" + formatPay(prpLlossDtobak.getClaimRate()) + "％";
						lineText+="×" + formatPay(prpLlossDtobak.getArrangeRate()) + "％";
					}
					dblsumloss = dblsumloss * prpLlossDtobak.getClaimRate()/100 ;
					if (StringUtils.getBytesLength(lineText) + 10 > 60) {
						strLctextList.add(lineText);
						lineText = space(17) + "×(1－"
						+ formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
	
					} else {
						lineText += "×(1－"
							+ formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
					}
					dblthirdsumdefloss += dblsumloss;
	
					// 在下面的算式中增加赔偿比例信息
					dblsumdefloss = dblsumloss 
					* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
					* (1 - prpLlossDtobak.getDeductibleRate() / 100);
					strLctextList.add(lineText);
					lineText = space(16) + "=" + formatPay(dblsumdefloss) + "元";
					strLctextList.add(lineText);
				}
				if (intpropflag == 1) {
					textlosscount++;
					
					lineText = space(4) + "财产赔付:";
					strLctextList.add(lineText);
					for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
						prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
						if (prpLlossDto.getKindCode().equals(iKindCode)
								&& (prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
								&& prpLlossDto.getLossName() != null) {
							lineText = space(4) + "项目:" + prpLlossDto.getLossName();
							strLctextList.add(lineText);
							lineText = space(4) + "本项实赔金额=损失金额×责任比例×(1-绝对免赔率)";
							dblsumloss = 0;
							dblsumdefloss = 0;
							dbldeductiblerate = prpLlossDto.getDeductibleRate();
							dblDutydeductiblerate = prpLlossDto.getDutyDeductibleRate();
							strLctextList.add(lineText);
							lineText = space(16) + "="
							+ formatPay(prpLlossDto.getSumDefPay()) + "×"
							+ formatPay(prpLlossDto.getIndemnityDutyRate()) + "％" + "×"
							+ "(1-" + formatPay(prpLlossDto.getDeductibleRate()) + "％)";// +
							strLctextList.add(lineText);
							lineText = space(16) + "="	+ formatPay(prpLlossDto.getSumRealPay()) + "元";
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
				lineText = space(4) + "车辆号牌号码为" + arrFamilyName[j].trim() + "的出险人员" + "  "
				+ arrPersonName[j].trim() + "：";
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
				lineText = space(4) + "本项实赔金额=(";
				for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
					prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
					if (prpLpersonLossDto.getKindCode().equals(iKindCode)	&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim())) {
						if (StringUtils.getBytesLength(lineText)
								+ StringUtils.getBytesLength(prpLpersonLossDto.getLiabDetailName()) + 1 > 60) {
							strLctextList.add(lineText);
							lineText = space(17) + prpLpersonLossDto.getLiabDetailName() + "×赔偿比例＋";
						} else {
							lineText += prpLpersonLossDto.getLiabDetailName() + "×赔偿比例＋";
						}
					}
				}
				lineText = lineText.substring(0, (lineText.length() - 1)) + ")";
				if (StringUtils.getBytesLength(lineText) + 10 > 60) {
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(17) + "×协商赔偿比例";
				} else {
					lineText += "×协商赔偿比例";
				}
				if (StringUtils.getBytesLength(lineText) + 11 > 60) {
//					repcount++;
					strLctextList.add(lineText);
					lineText = space(17) + "×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
				} else {
					lineText += "×(1-绝对免赔率)";// ×(1-驾驶员免赔率)";
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
							+ formatPay(prpLpersonLossDto.getSumDefPay()) + "×"  //LYM
							+ formatPay(prpLpersonLossDto.getClaimRate()) + "％" + "＋";
						} else {
							lineText += formatPay(prpLpersonLossDto.getSumDefPay()) //LYM
							+ "×" + formatPay(prpLpersonLossDto.getClaimRate()) + "％"
							+ "＋";
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
					lineText = space(17) +  "×" + formatPay(prpLpersonLossDtobak.getArrangeRate()) + "％";
				} else {
					lineText += "×"	+ formatPay(prpLpersonLossDtobak.getArrangeRate()) + "％";
				}
				dblsumloss = dblsumloss * prpLpersonLossDtobak.getArrangeRate() / 100;
				if (StringUtils.getBytesLength(lineText) + 10 > 60) {
					strLctextList.add(lineText);
					lineText = space(17) + "×(1－" + formatPay(prpLpersonLossDtobak.getDeductibleRate())+ "％)";
				} else {
					lineText += "×(1－" + formatPay(prpLpersonLossDtobak.getDeductibleRate())+ "％)";
				}

				dblthirdsumdefloss += dblsumloss;
				dblsumdefloss = dblsumloss * (1 - prpLpersonLossDtobak.getDeductibleRate() / 100);
				strLctextList.add(lineText);
				lineText = space(16) + "=" + formatPay(dblsumdefloss) + "元";
				strLctextList.add(lineText);
			}
			if (dblsumloss > dblamount) {
				if(iKindCode.equals("R")){
					lineText = space(4) + "本项实赔金额赔偿金额超过交通事故精神损失险的赔偿限额，所以：";
				}	
				if(iKindCode.equals("H")){
					lineText = space(4) + "本项实赔金额赔偿金额超过车载货物掉落责任险的赔偿限额，所以：";
				}	
				strLctextList.add(lineText);
				lineText = space(4) + "本险别实赔金额=赔偿限额="
						+ formatPay(dblamount) + "元";
				strLctextList.add(lineText);
				dblothsumrealpay = dblamount;
			}
			else{
					if (textlosscount > 0 && textpersoncount > 0) {
						lineText = space(4) + "本险别实赔金额=标的实赔金额＋人员实赔金额";
						strLctextList.add(lineText);
						lineText = "                  " + "="
						+ formatPay(dblthirdsumloss) + "＋"
						+ formatPay(dblthirdsumperson);
						strLctextList.add(lineText);
						lineText = "                  " + "=" + formatPay(dblthirdsumloss+dblthirdsumperson) + "元";
						strLctextList.add(lineText);
					}
					else if(textlosscount > 0 && textpersoncount <= 0){
						lineText = space(4) + "本险别实赔金额=标的实赔金额="+formatPay(dblthirdsumloss);
						strLctextList.add(lineText);
					}
					else if(textlosscount <= 0 && textpersoncount > 0){
						lineText = space(4) + "本险别实赔金额=人员实赔金额="+formatPay(dblthirdsumperson);
						strLctextList.add(lineText);
					}
			}
			lineText= "";
			
		}
		else {			
			/*
			 * ----------------------------------------------------------------------------------------
			 * 其他险
			 * ----------------------------------------------------------------------------------------
			 */		
			// dbPrpDkind.getInfo(prpLcompensateDto.getRiskCode(),iKindCode);
			strLctextList.add(lineText);
			// lineText = dbPrpDkind.getKindCName() + "：";
			lineText = uiCodeAction.translateKindCode(compensateDto.getPrpLcompensateDto().getRiskCode(),
					iKindCode, true)
					+ "：";
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
				 * 自燃损失险
				 * ----------------------------------------------------------------------------------------
				 */		
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额=（实际修理费用- 残值）×赔偿比例×协商比例×（1-绝对免赔率）";// ×(1-驾驶员免赔率)";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")" + prpLlossDtobak.getClaimRate()+ "％" + prpLlossDtobak.getArrangeRate()+"％" + "×(1-"
						+ formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
				dblsumloss = (dblsumloss ) *prpLlossDtobak.getClaimRate() / 100*prpLlossDtobak.getArrangeRate() / 100 *(1 - prpLlossDtobak.getDeductibleRate() / 100);// *(1
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("X3")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * 涉水行驶损失险
				 * ----------------------------------------------------------------------------------------
				 */		
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额=（实际修理费用- 残值）×赔偿比例×协商比例";// ×(1-驾驶员免赔率)";
				strLctextList.add(lineText);				
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")" + "×"
						+ formatPay(prpLlossDtobak.getClaimRate()) + "％"
						+ formatPay(prpLlossDtobak.getArrangeRate()) + "％";
				dblsumloss = (dblsumloss ) * prpLlossDtobak.getClaimRate()/100*(prpLlossDtobak.getArrangeRate()/ 100);// *(1
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("G0")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * 盗抢附加高尔夫险
				 * ----------------------------------------------------------------------------------------
				 */
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额= 实际损失×（1-绝对责任免赔率）";
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)
						+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
				dblsumloss = dblsumloss * (1 - prpLlossDtobak.getDeductibleRate() / 100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "	+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("L") || iKindCode.equals("K16") || iKindCode.equals("V1")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * 车身划痕险
				 * ----------------------------------------------------------------------------------------
				 */
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额= 实际损失×赔偿比例×协商比例×（1-绝对免赔率）";
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)+ "×"
				        + formatPay(prpLlossDtobak.getClaimRate()) + "％×"
				        + formatPay(prpLlossDtobak.getArrangeRate()) 
						+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
				dblsumloss = dblsumloss *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100)* (1 - prpLlossDtobak.getDeductibleRate() / 100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "元";
				if(iKindCode.equals("L") && dblsumloss > prpLlossDtobak.getAmount()){
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "	+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			
			if (iKindCode.equals("X") ) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * 新增设备险
				 * ----------------------------------------------------------------------------------------
				 */
				String strName = "实际损失";
				strLctextList.add(lineText);

				lineText = space(4) + "本项实赔金额=（" + strName + "- 残值）×责任比例";
				strLctextList.add(lineText);
				lineText = space(17) + "×（1-事故责任免赔率）×(1-绝对免赔率)";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")×"
						+ formatPay(prpLlossDtobak.getIndemnityDutyRate()) ;
				strLctextList.add(lineText);
				lineText =space(17) + "×(1-"+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)"
						+ "×(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
				dblsumloss = (dblsumloss ) * (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)*(1- prpLlossDtobak.getDeductibleRate()/100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("D2")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 * 车上货物责任险
				 * ----------------------------------------------------------------------------------------
				 */
				String strName = "实际损失";
				

				strLctextList.add(lineText);

				lineText = space(4) + "本项实赔金额=（" + strName + "- 残值）×赔偿比例×协商比例×责任比例";
				strLctextList.add(lineText);
				lineText = space(17) + "×（1-事故责任免赔率）*(1-绝对免赔率)";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")×"
						+ formatPay(prpLlossDtobak.getClaimRate()) + "％×"
						+ formatPay(prpLlossDtobak.getArrangeRate()) + "％×"
						+ formatPay(prpLlossDtobak.getIndemnityDutyRate());
				strLctextList.add(lineText);
				lineText = space(17) +"×(1-"
						+ formatPay(prpLlossDtobak.getDutyDeductibleRate()) + "％)"
						+ "*(1-" + formatPay(prpLlossDtobak.getDeductibleRate()) + "％)";
				dblsumloss = (dblsumloss ) *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getIndemnityDutyRate()/100)
							*(prpLlossDtobak.getIndemnityDutyRate()/100)* (1 - prpLlossDtobak.getDutyDeductibleRate() / 100)
							*(1-prpLlossDtobak.getDeductibleRate()/100);// *(1
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}

			if (iKindCode.equals("X4")) {
				/*
				 * ----------------------------------------------------------------------------------------
				 *系安全带补偿险
				 * ----------------------------------------------------------------------------------------
				 */				
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额=核定赔偿×赔偿比例×协商比例";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
				+  ")×"
				+ formatPay(prpLlossDtobak.getClaimRate()) + "％×"
				+ formatPay(prpLlossDtobak.getArrangeRate()) + "％×";
				strLctextList.add(lineText);
				dblsumloss = (dblsumloss ) *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4)
							+ "本项实赔金额 = 保险金额= "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if(iKindCode.equals("K6")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * 随车行李物品损失险
				 * ----------------------------------------------------------------------------------------
				 */
				String strName = "实际损失";
			
				strLctextList.add(lineText);

				lineText = space(4) + "本项实赔金额=（" + strName + "- 残值）×赔偿比例×协商比例×责任比例";
				strLctextList.add(lineText);
				lineText = space(17) + "=(" + formatPay(dblsumloss)
						+  ")×"
						+ formatPay(prpLlossDtobak.getClaimRate()) + "％×"
						+ formatPay(prpLlossDtobak.getArrangeRate()) + "％×"
						+ formatPay(prpLlossDtobak.getIndemnityDutyRate());
				dblsumloss = (dblsumloss ) *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100)
							*(prpLlossDtobak.getIndemnityDutyRate()/100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)	+ "元";
				if (dblsumloss > prpLlossDtobak.getAmount()) {
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "
							+ formatPay(prpLlossDtobak.getAmount()) + "元";
					dblothsumrealpay = prpLlossDtobak.getAmount();
				}
			}
			if (iKindCode.equals("K10")){
				/*
				 * ----------------------------------------------------------------------------------------
				 * 保险事故附随费用损失险
				 * ----------------------------------------------------------------------------------------
				 */
				strLctextList.add(lineText);
				lineText = space(4) + "本项实赔金额= 实际损失*赔偿比例×协商比例";
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss)+ "×"
				        + formatPay(prpLlossDtobak.getClaimRate()) + "％×"
				        + formatPay(prpLlossDtobak.getArrangeRate()) + "%" ;
				dblsumloss = dblsumloss *(prpLlossDtobak.getClaimRate()/100)*(prpLlossDtobak.getArrangeRate()/100);
				strLctextList.add(lineText);
				lineText = space(17) + "=" + formatPay(dblsumloss) + "元";
				if(dblsumloss > prpLlossDtobak.getAmount()){
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额超过保险金额，故赔款按以下计算：";
					strLctextList.add(lineText);
					lineText = space(4) + "本项实赔金额 = 保险金额 = "	+ formatPay(prpLlossDtobak.getAmount()) + "元";
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
		logger.debug("附加险-ctextcount:"+ctextcount);
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
					+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
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
				// 人员赔付误工费等生成赔款计算书报错
				if (prpDpersonPaylist.size() > 0) {
					prpDpersonPayDto = (PrpDpersonPayDto) prpDpersonPaylist.get(0);
					if (prpLpersonDto.getSumLoss() / prpLpersonDto.getQuantity() > prpDpersonPayDto.getStandardFee() / 365 * 3) {
						prpLpersonDto.setSumDefLoss(prpDpersonPayDto.getStandardFee() / 365 * 3
								* prpLpersonDto.getQuantity() - prpLpersonDto.getSumReject());
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3倍标准)×"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
					} else {
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3倍标准)×"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
					}
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元";  //SumLoss改为SumDefPay
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
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3倍标准)×"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
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
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(人均生活费)×"
						+ new DecimalFormat("#,##0.00").format((double) intpayyears) + "(赔偿年限)×"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getLossRate()) + "％(伤残等级)="
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
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
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3倍标准)×"
								+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getQuantity()) + "(天数)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
					} else {
						strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(3倍标准)×"
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
								+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
					}
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
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
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(标准)×"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
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
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(标准)×"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
				} else {
					strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
							+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元";//SumLoss改为SumDefPay
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
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(平均生活费)×"
						+ new DecimalFormat("#,##0.00").format((double) intpayyears) + "(赔偿年限)="
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
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
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(丧葬标准)元";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
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
						+ new DecimalFormat("#,##0.00").format(prpDpersonPayDto.getStandardFee()) + "(生活困难补助标准)×"
						+ new DecimalFormat("#,##0.00").format((double) intpayyears) + "(赔偿年限)="
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("23")) {
			strSQL = " PayItemCode = '02' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(出差住宿标准)×"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元";////SumLoss改为SumDefPay
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
			}
		} else if (iPrpLpersonLossDto.getLiabDetailCode().equals("34")) {
			strSQL = " PayItemCode = '03' AND DamageAreaCode = '" + prpLpersonDto.getAreaCode()
					+ "' AND BusinessSource = '0000' AND issuedate = '" + prpLclaimDto.getDamageStartDate() + "' ";
			// blPrpDpersonPay.query(strSQL,0);
			ArrayList prpDpersonPaylist = (ArrayList) uiPrpDpersonPayAction.findByConditions(strSQL);
			if (prpDpersonPaylist.size() > 0) {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getUnitAmount()) + "(出差伙食补助标准)×"
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getLossQuantity()) + "(天数)="
						+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元";  //SumLoss改为SumDefPay 
			} else {
				strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
						+ new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumDefLoss()) + "元";
			}
			// modify by liruijuan update end 040302
		} else {
			strFeeReport = space(4) + prpLpersonDto.getFeeTypeName() + ":"
					+ new DecimalFormat("#,##0.00").format(iPrpLpersonLossDto.getSumDefPay()) + "元"; //SumLoss改为SumDefPay
		}
		return strFeeReport;
		// return "CarCreateForFee";
	}

	private static class CompensateData{

		private double dblCarSumRealPay = 0;	//车损险实赔
		private double dblThirdSumRealPay = 0;	//三者险实赔
		private double dblDriverSumRealPay = 0; //驾驶员责任险实赔
		private double dblPassengerSumRealPay = 0; //乘客责任险实赔
		private double dblStealSumRealPay = 0;     //全车盗抢险赔款
		private double dblOthSumRealPay = 0;	//附加险实赔
		private double dblChargeSumRealPay = 0;	//费用实赔
		private double dblNoFranchise = 0;		//
		private double dblAllSumRealPay = 0;	//实赔合计
//		private double dblAllSumDeductible = 0;	//免赔额合计
		private String strEscapeFlag = "";		//是否为逃逸案
		List prpLctextlist = new ArrayList();
	}
	
	
	
//	public void ReportForCommerceB(HttpServletRequest httpServletRequest, CompensateDto compensateDto,CompensateData compensateData)throws UserException,Exception 
//	{
//
//		PrpLlossDto prpLlossDto = new PrpLlossDto();
//		PrpLlossDto prpLlossDtobak = new PrpLlossDto();
//		
//		double propLimit  = 5000;    //财产限额
//		double medicLimit = 10000;    //医疗限额
//		double deathLimit = 40000;    //死亡残疾限额
//		//double dbChargeRealPay=0;  //即如赔款费用 
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
//		String  propname="三者车";
//		String[] lineReportText ={"一、财产损失：",
//				"核定损失",
//				"＋(伤亡残疾费用－强三伤亡残疾限额))×事故责任比例",
//				"赔偿限额：",
//				"核定赔偿金 ＝( 财产核定总损失 + 医疗核定总损失 + 医疗核定总损失)* 事故责任比例",
//				"实赔金额＝核定赔偿金 * （1-责任免赔率）* （1-绝对免赔率）",//LYM
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
//				strLctextList.add("商业三者综合保险(A):");
//				strLctextList.add(lineReportText[ireport]);
//			}
//			lineNumber++;
//			ireport++;
//			if (!arrLossName [i].trim().equals("车辆")) {
//				lineText = space(4) +propname+"("+ arrLossName [i].trim()+")";
//			} else {
//				lineText = space(4) +propname+"("+ arrLicenseNo[i].trim() + "号车"+")";  
//			}
//			mybackupvalue.put("proptitle"+proptitileindex,propname+"("+ arrLicenseNo [i].trim()+")"+"核定损失");			
//			proptitileindex++;
//			strLctextList.add(lineText);
//			
//			lineText = space(4) + lineReportText[ireport];  //核定损失=
//			ireport++;
//			lineText +="＝";
//			textlosscount++;//还不清楚这个点是干什么髟的
//			
//			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
//				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
//				if (prpLlossDto.getKindCode().equals("B") && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
//					if (ExceedFormat(lineText, prpLlossDto.getFeeTypeName().length() + 2)) {
//						strLctextList.add(lineText);
//						lineText = space(17) + prpLlossDto.getFeeTypeName() + "＋";
//					} else {
//						lineText += prpLlossDto.getFeeTypeName() + "＋";
//					}
//				}
//			}
//			lineText = SubtractDesignate(lineText,"＋");						
//							
//			strLctextList.add(lineText);  
//			dbtempSumRest=0;
//			dbtempSumloss=0;
//			
//			lineText = space(16) + "=";
//			for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {  //财产累加;
//				prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
//				if (prpLlossDto.getKindCode().equals("B") && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
//					dbtempSumloss+=prpLlossDto.getSumDefPay();  //原来取Sumloss,现在取核定赔偿SumDefPay  LYM
//					if (ExceedFormat(lineText, prpLlossDto.getFeeTypeName().length() + 2)) {//换行 
//						strLctextList.add(lineText);
//						lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "＋";  //原来取Sumloss,现在取核定赔偿SumDefPay  LYM
//					} else {
//						lineText += formatPay(prpLlossDto.getSumDefPay()) + "＋"; //原来取Sumloss,现在取核定赔偿SumDefPay  LYM
//					}
//				}
//			}
//			
//			
//			
//			lineText = SubtractDesignate(lineText,"＋");						
////			lineText += CombinationBracket(lineText,")");						
//			//lineText +="－"+formatPay(dbtempSumRest);   //不考虑残值 LYM
//			strLctextList.add(lineText);  //第四行=100+10
//			lineText = space(16) + "=" + formatPay(dbtempSumloss) + "元"; //不考虑残值 LYM
//			dbpropall+=dbtempSumloss; //不考虑残值 LYM
//			mybackupvalue.put("prop"+propindex,formatPay(dbtempSumloss)); //不考虑残值 LYM
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
//					lineText = space(4) + "财物:" + prpLlossDto.getLossName();
//					strLctextList.add(lineText);					
//					mybackupvalue.put("proptitle"+proptitileindex,prpLlossDto.getLossName()+"核定损失");			
//					proptitileindex++;
//					lineText = space(4) + lineReportText[1];
//					lineText +="=";
//					lineText += prpLlossDto.getFeeTypeName() ;
//					lineText +=lineReportText[2];	
//					strLctextList.add(lineText);																								
//					dbtempSumRest=prpLlossDto.getSumRest();
//					dbtempSumloss=prpLlossDto.getSumLoss();
//					lineText = space(16) + "=";					
//					lineText +=formatPay(dbtempSumloss)+"－"+formatPay(dbtempSumRest);
//					strLctextList.add(lineText);														
//					lineText = space(16) + "=" + formatPay(dbtempSumloss-dbtempSumRest) + "元";
//					strLctextList.add(lineText);
//					dbpropall+=dbtempSumloss-dbtempSumRest;					
//					mybackupvalue.put("prop"+propindex,formatPay(dbtempSumloss-dbtempSumRest));
//					propindex++;
//				}
//			}}
//		lineText = space(4) + "财产核定总损失 ";
//		lineText +="=";			
//		for(int jj=0;jj<proptitileindex;jj++){
//			lineText +=mybackupvalue.get("proptitle"+jj).toString()+"＋"	;
//		}
//		lineText =SubtractDesignate(lineText, "＋");	
//				
//		strLctextList.add(lineText);			
//		lineText = space(16) + "=";					
//		for(int jj=0;jj<propindex;jj++){
//			lineText +=mybackupvalue.get("prop"+jj).toString()+"＋"	;
//		}
//		lineText =SubtractDesignate(lineText, "＋");
//		
//		
//		strLctextList.add(lineText);
//		lineText = space(16) + "=" + formatPay(dbpropall ) + "元";  //得加上施救费,暂时写死100,这里100应包含到dbpropall
//		strLctextList.add(lineText);  //  财产总核定赔偿金zheyihang 
//		/*if (( dbpropall) > propLimit){
//			lineText = space(4)	+ " 因核定赔偿金超过财产赔偿限额("+ formatPay(propLimit)+"元)，所以 ：";
//			strLctextList.add(lineText);
//			lineText = space(4) + "财产赔款金额＝财产赔偿限额";
//			lineText += "=" + formatPay(propLimit) + "元";  //得加上施救费,暂时写死100 
//			dbpropall = propLimit ; //
//		}else {
//		    lineText = space(4) + "财产赔款金额＝财产核定赔偿金";
//		    lineText += "=" + formatPay(dbpropall ) + "元";  //得加上施救费,暂时写死100
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
//		lineText="二、医疗费用：";
//		strLctextList.add(lineText);
//		for (j = 1; j <= personcount; j++) {
//			if (arrKindCodePerson[j].indexOf("B") < 0)
//				continue;
//			
//			
//			lineText = space(4) + "出险人员"+ "("
//			+ arrPersonName[j].trim() + ")：";
//			strLctextList.add(lineText);			
//			mybackupvalue.put("persontitle"+persontitleindex,"("+arrPersonName[j].trim()+")核定损失");						
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
//					strFeeReport +="＋";
//					strFeeValueReport+=formatPay(prpLpersonLossDto.getSumDefPay());//LYM
//					strFeeValueReport+="＋";
//					//dbtempSumRest+=prpLpersonLossDto.getSumRest(); //暂时不要残值 LYM
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
//			lineText = SubtractDesignate(lineText ,"＋");	
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
//			lineText = SubtractDesignate(lineText ,"＋");
//			//lineText =lineText+"－"+formatPay(dbtempSumRest) ;  //暂时不要残值 LYM
//			strLctextList.add(lineText);
//			lineText= space(16) + "="+formatPay(dbtempSumloss) + "元";  //暂时不要残值 LYM
//			strLctextList.add(lineText);
//			mybackupvalue.put("person"+personindex,formatPay(dbtempSumloss)); //暂时不要残值 LYM
//			dbpersonall+=(dbtempSumloss); //暂时不要残值 LYM
//			personindex++;
//			strFeeReport="";
//			strFeeValueReport="";
//			dbtempSumRest =0;
//			dbtempSumloss  =	0;			
//		}
//		lineText = space(4) + "医疗核定总损失=";
//		for(int jj=0;jj<persontitleindex;jj++){
//			lineText +=mybackupvalue.get("persontitle"+jj).toString()+"＋"	;
//		}
//		lineText =SubtractDesignate(lineText, "＋");			
//		strLctextList.add(lineText);			
//		lineText = space(16) + "=";							
//		for(int jj=0;jj<personindex;jj++){
//			lineText +=mybackupvalue.get("person"+jj).toString()+"＋"	;
//		}		
//		lineText =SubtractDesignate(lineText, "＋");					
//		strLctextList.add(lineText);			 
//		lineText = space(16) + "=" + formatPay(dbpersonall) + "元";
//		
//		/*if (dbpersonall>medicLimit){
//		   lineText = space(4) + "因医疗核定赔偿金超过医疗费用限额（"+ formatPay(medicLimit)+"元）,所以：";   	
//	  	   strLctextList.add(lineText);
//		   lineText = space(4) + "医疗赔款金额＝医疗费用限额 ";
//		   lineText += "=" + formatPay(medicLimit) + "元";
//		   dbpersonmedicalall=medicLimit;
//	    }
//		else {
//		   lineText = space(4) + "医疗赔款金额＝医疗核定赔偿金 ";
//		   lineText += "=" + formatPay(dbpersonall) + "元";
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
//		lineText="三、死亡伤残费用：";
//		strLctextList.add(lineText);
//		for (j = 1; j <= personcount; j++) {
//			if (arrKindCodePerson[j].indexOf("B") < 0)
//				continue;
//			
//			
//			lineText = space(4) + "出险人员"+ "  "
//			+ arrPersonName[j].trim() + "：";
//			strLctextList.add(lineText);			
//			mybackupvalue.put("persondeformitytitle"+persontitleindex,"("+arrPersonName[j].trim()+")核定损失");						
//			persontitleindex++;
//			textpersoncount++;
//			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
//				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
//				
//				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])
//						&&prpLpersonLossDto.getRemark().equals("D")) {
//					strFeeReport +=prpLpersonLossDto.getLiabDetailName();
//					strFeeReport +="＋";
//					strFeeValueReport+=formatPay(prpLpersonLossDto.getSumDefPay());  // LYM
//					strFeeValueReport+="＋";
//					//dbtempSumRest+=prpLpersonLossDto.getSumRest();  //暂时不要残值 LYM
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
//			lineText = SubtractDesignate(lineText ,"＋");	
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
//			lineText = SubtractDesignate(lineText ,"＋");
//			//lineText =lineText+"－"+formatPay(dbtempSumRest) ; //暂时不要残值 LYM
//			strLctextList.add(lineText);
//			lineText= space(16) + "="+formatPay(dbtempSumloss) + "元"; //暂时不要残值 LYM
//			strLctextList.add(lineText);
//			mybackupvalue.put("persondeformity"+personindex,formatPay(dbtempSumloss)); //暂时不要残值 LYM
//			dbpersonall+=(dbtempSumloss); //暂时不要残值 LYM
//			personindex++;
//			strFeeReport="";
//			strFeeValueReport="";
//			dbtempSumRest =0;
//			dbtempSumloss  =	0;
//			
//		}
//		lineText = space(4) + "死亡伤残核定总损失=";
//		for(int jj=0;jj<persontitleindex;jj++){
//			lineText +=mybackupvalue.get("persondeformitytitle"+jj).toString()+"＋"	;
//		}
//		lineText =SubtractDesignate(lineText, "＋");			
//		strLctextList.add(lineText);			
//		lineText = space(16) + "=";							
//		for(int jj=0;jj<personindex;jj++){
//			lineText +=mybackupvalue.get("persondeformity"+jj).toString()+"＋"	;
//		}		
//		lineText =SubtractDesignate(lineText, "＋");					
//		strLctextList.add(lineText);			 
//		lineText = space(16) + "=" + formatPay(dbpersonall) + "元";
//		strLctextList.add(lineText);
//		/*
//		if (dbpersonall>deathLimit){
//			   lineText = space(4) + "因死亡伤残核定赔偿金超过死亡伤残限额（"+ formatPay(deathLimit)+"元）,所以：";   	
//		  	   strLctextList.add(lineText);
//			   lineText = space(4) + "死亡伤残赔款金额＝死亡伤残限额 ";
//			   lineText += "=" + formatPay(deathLimit) + "元";
//			   dbpersondeformityall = deathLimit;  
//		}
//			else {
//			   lineText = space(4) + "死亡伤残赔款金额＝死亡伤残核定赔偿金 ";
//			   lineText += "=" + formatPay(dbpersonall) + "元";
//			   dbpersondeformityall =dbpersonall;
//			}
//		*/
//		 dbpersondeformityall =dbpersonall;
//		strLctextList.add(lineText);			 
//		
//		//------------------------------------------
//		lineText="四、本险别核定赔偿金"; 
//		strLctextList.add(lineText);
//		lineText =space(4) +lineReportText[4];
//		strLctextList.add(lineText);
//		lineText = space(16) + "=（" + formatPay(dbpropall) +"＋"+formatPay(dbpersonmedicalall) +"＋"+formatPay(dbpersondeformityall)+"）× 100%"   ;	//事故责任比例暂时写死	
//		//lineText += "×（1－5%）";		
//		strLctextList.add(lineText);		
//		lineText = space(16) + "=" + formatPay((dbpropall+dbpersonmedicalall+dbpersondeformityall)*0.01) + "元"; //事故责任比例暂时写死
//		strLctextList.add(lineText);
//		double cormmerceBLimit = 100.00;//暂时写死
//		double sumSumDefPay =0;
//		if (((dbpropall+dbpersonmedicalall+dbpersondeformityall)*0.01)> cormmerceBLimit){
//			lineText =	space(4) +" 因核定赔偿金超过赔偿限额("+cormmerceBLimit+"元)" ;
//			strLctextList.add(lineText);
//			lineText =	space(4) +"所以：核定赔偿金 = 赔偿限额 = "+cormmerceBLimit+"元" ;
//			strLctextList.add(lineText);
//			sumSumDefPay =cormmerceBLimit;
//		}else {
//			sumSumDefPay =(dbpropall+dbpersonmedicalall+dbpersondeformityall)*0.01;
//		
//		}//-----------------------------------------
//		lineText="五、本案实赔金额"; ///这里都被写死了
//		strLctextList.add(lineText);
//		lineText =space(4) +lineReportText[5];
//		strLctextList.add(lineText);
//		lineText = space(16) + "=" + formatPay(sumSumDefPay) +" * ( 1-10%) *(1-10%)"   ;		
//		//lineText += "×（1－5%）";		
//		strLctextList.add(lineText);		
//		lineText = space(16) + "=" + formatPay(sumSumDefPay*0.9 *0.9) + "元";
//		strLctextList.add(lineText);
//		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
//		logger.debug("三者险-ctextcount:"+ctextcount);
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
