package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPrpLcheckAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * <p>Title: VerifyLossViewHelper</p>
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

public class DAAVerifyLossViewHelper extends VerifyLossViewHelper {
	private static Log logger = LogFactory.getLog(DAAVerifyLossViewHelper.class);

	/**
	 * ���涨��ʱ����ҳ����������.
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * @param httpServletRequest
	 * @return verifyLossDto �������ݴ������ݽṹ
	 * @throws Exception
	 */
	public VerifyLossDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		String lossType = httpServletRequest.getParameter("lossTypeFlag");
		String nodeType = httpServletRequest.getParameter("nodeType");

		//�̳ж�verifyLoss,verifyLossText��ĸ�ֵ
		VerifyLossDto verifyLossDto = super.viewToDto(httpServletRequest);
		/*---------------------  �Ʋ��˶�����ϸ�嵥�� prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		//add by lixiang start 20051228
		//reason: ��Ϊ���ǵ�¼���ʱ�򣬿���û���������������ύ��ʱ����������������������ûд�롣
		String claimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo");
		String registNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo");
		//��ȡ�������룬����Ҫ����Ҫ��ҳ����ȡ�á�����
		if (claimNo == null || claimNo.length() < 2) {
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		}
		//add by lixiang end 20051228

		//���������ı�
		PrpLverifyLossItemDto LossItemRepairComponentDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPersonDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemAllLossDto = new PrpLverifyLossItemDto();
		ArrayList lossItemListTemp = new ArrayList();

		//�ӽ���õ���������
		String prpLpropPolicyNo = httpServletRequest
				.getParameter("prpLverifyLossPolicyNo");
		String prpLpropRiskCode = httpServletRequest
				.getParameter("prpLverifyLossRiskCode");
		String prpLpropClaimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo");
		String prpLpropRegistNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo");

		String[] prpLpropSerialNo = httpServletRequest
				.getParameterValues("prpLpropSerialNo");
		String[] prpLpropItemKindNo = httpServletRequest
				.getParameterValues("prpLpropItemKindNo");
		String[] prpLpropFamilyNo = httpServletRequest
				.getParameterValues("prpLpropFamilyNo");
		String[] prpLpropFamilyName = httpServletRequest
				.getParameterValues("prpLpropFamilyName");
		String[] prpLpropKindCode = httpServletRequest
				.getParameterValues("prpLpropKindCode");
		String[] prpLpropItemCode = httpServletRequest
				.getParameterValues("prpLpropItemCode");
		String[] prpLpropLossItemCode = httpServletRequest
				.getParameterValues("prpLpropLossItemCode");
		String[] prpLpropLossItemName = httpServletRequest
				.getParameterValues("prpLpropLossItemName");
		String[] prpLpropFeeTypeCode = httpServletRequest
				.getParameterValues("prpLpropFeeTypeCode");
		String[] feeTypeCode = httpServletRequest
				.getParameterValues("feeTypeCode");
		String[] prpLpropFeeTypeName = httpServletRequest
				.getParameterValues("prpLpropFeeTypeName");
		String[] prpLpropCurrency = httpServletRequest
				.getParameterValues("prpLpropCurrency");
		String[] prpLpropUnitPrice = httpServletRequest
				.getParameterValues("prpLpropUnitPrice");
		String[] prpLpropLossQuantity = httpServletRequest
				.getParameterValues("prpLpropLossQuantity");
		String[] prpLpropUnit = httpServletRequest
				.getParameterValues("prpLpropUnit");
		String[] prpLpropBuyDate = httpServletRequest
				.getParameterValues("prpLpropBuyDate");
		String[] prpLpropDepreRate = httpServletRequest
				.getParameterValues("prpLpropDepreRate");
		String[] prpLpropSumLoss = httpServletRequest
				.getParameterValues("prpLpropSumLoss");
		String[] prpLpropSumReject = httpServletRequest
				.getParameterValues("prpLpropSumReject");
		String[] prpLpropRejectReason = httpServletRequest
				.getParameterValues("prpLpropRejectReason");
		String[] prpLpropLossRate = httpServletRequest
				.getParameterValues("prpLpropLossRate");
		String[] prpLpropSumDefLoss = httpServletRequest
				.getParameterValues("prpLpropSumDefLoss");
		String[] prpLpropRemark = httpServletRequest
				.getParameterValues("prpLpropRemark");
		String[] prpLpropVeriUnitPrice = httpServletRequest
				.getParameterValues("prpLpropVeriUnitPrice");
		String[] prpLpropVeriLossQuantity = httpServletRequest
				.getParameterValues("prpLpropVeriLossQuantity");
		String[] prpLpropVeriUnit = httpServletRequest
				.getParameterValues("prpLpropVeriUnit");
		String[] prpLpropVeriDepreRate = httpServletRequest
				.getParameterValues("prpLpropVeriDepreRate");
		String[] prpLpropVeriSumLoss = httpServletRequest
				.getParameterValues("prpLpropVeriSumLoss");
		String[] prpLpropVeriSumReject = httpServletRequest
				.getParameterValues("prpLpropVeriSumReject");
		String[] prpLpropVeriRejectReason = httpServletRequest
				.getParameterValues("prpLpropVeriRejectReason");
		String[] prpLpropVeriLossRate = httpServletRequest
				.getParameterValues("prpLpropVeriLossRate");
		String[] prpLpropVeriSumDefLoss = httpServletRequest
				.getParameterValues("prpLpropVeriSumDefLoss");
		String[] prpLpropVeriRemark = httpServletRequest
				.getParameterValues("prpLpropVeriRemark");
		String[] prpLpropFlag = httpServletRequest
				.getParameterValues("prpLpropFlag");
		//		add by lixiang start at 2006-04-21
		//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
		String[] prpLpropCompensateBackFlag = httpServletRequest
				.getParameterValues("prpLpropCompensateBackFlag");
		//add by lixiang end at 2006-04-21

		//����ֵ
		if (prpLpropSerialNo == null) {

		} else {
			for (int index = 1; index < prpLpropSerialNo.length; index++) {
				prpLpropDto = new PrpLpropDto();
				prpLpropDto.setPolicyNo(prpLpropPolicyNo);
				prpLpropDto.setRiskCode(prpLpropRiskCode);
				prpLpropDto.setClaimNo(claimNo);
				prpLpropDto.setRegistNo(prpLpropRegistNo);
				prpLpropDto.setSerialNo(index);
				//prpLpropDto.setSerialNo                 ( Integer.parseInt(DataUtils.nullToZero(prpLpropSerialNo     [index])));
				prpLpropDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpropItemKindNo[index])));
				prpLpropDto.setFamilyNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpropFamilyNo[index])));
				prpLpropDto.setFamilyName(prpLpropFamilyName[index]);
				prpLpropDto.setKindCode(prpLpropKindCode[index]);
				prpLpropDto.setItemCode(prpLpropItemCode[index]);
				prpLpropDto.setLossItemCode(prpLpropLossItemCode[index]);
				prpLpropDto.setLossItemName(prpLpropLossItemName[index]);
				prpLpropDto.setFeeTypeCode(feeTypeCode[index]);
				prpLpropDto.setFeeTypeName(prpLpropFeeTypeName[index]);
				prpLpropDto.setCurrency(prpLpropCurrency[index]);
				prpLpropDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLpropUnitPrice[index])));
				prpLpropDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLpropLossQuantity[index])));
				prpLpropDto.setUnit(prpLpropUnit[index]);
				
				prpLpropDto.setBuyDate(new DateTime(new Date(),
						DateTime.YEAR_TO_DAY));
				//prpLpropDto.setBuyDate                  ( new DateTime(prpLpropBuyDate      [index]));
				prpLpropDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropDepreRate[index])));
				prpLpropDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumLoss[index])));
				prpLpropDto.setSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumReject[index])));
				prpLpropDto.setRejectReason(prpLpropRejectReason[index]);
				prpLpropDto.setLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropLossRate[index])));
				prpLpropDto.setSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumDefLoss[index])));
				prpLpropDto.setRemark(prpLpropRemark[index]);
				prpLpropDto.setVeriUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriUnitPrice[index])));
				prpLpropDto.setVeriLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriLossQuantity[index])));
				prpLpropDto.setVeriUnit(prpLpropVeriUnit[index]);
				prpLpropDto.setVeriDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriDepreRate[index])));
				prpLpropDto.setVeriSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumLoss[index])));
				prpLpropDto.setVeriSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumReject[index])));
				prpLpropDto
						.setVeriRejectReason(prpLpropVeriRejectReason[index]);
				prpLpropDto.setVeriLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriLossRate[index])));
				prpLpropDto.setVeriSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumDefLoss[index])));
				prpLpropDto.setVeriRemark(prpLpropVeriRemark[index]);
				prpLpropDto.setFlag(prpLpropFlag[index]);
				prpLpropDto
						.setCompensateBackFlag(prpLpropCompensateBackFlag[index]);
				//===========================================================
				UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction
						.findByPrimaryKey(prpLpropRegistNo);

				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
					EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
					PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
							registDto.getPrpLregistDto().getPolicyNo(),
							registDto.getPrpLregistDto().getDamageStartDate()
									.toString(), registDto.getPrpLregistDto()
									.getDamageStartHour());

					for (int k = 0; k < policyDto.getPrpCitemKindDtoList()
							.size(); k++) {
						PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
								.getPrpCitemKindDtoList().get(k);
						if (prpCitemKindDto.getKindCode().equals(
								prpLpropDto.getKindCode())) {
							prpLpropDto.setItemKindNo(prpCitemKindDto
									.getItemKindNo());
							break;
						}
					}
				}
				//===========================================================
				//���뼯��
				prpLpropDtoList.add(prpLpropDto);
			}
			PropertyUtils.copyProperties(LossItemPropDto, verifyLossDto
					.getPrpLverifyLossDto());
			LossItemPropDto.setSerialNo(3);
			LossItemPropDto.setLossType("3");
			LossItemPropDto.setNodeType("veri");
			lossItemListTemp.add(LossItemPropDto);
		}
		//�Ʋ��˶�����ϸ�嵥��
		verifyLossDto.setPrpLpropDtoList(prpLpropDtoList);
		/*---------------------��������&��������嵥&������Ŀ�嵥 prpLcarLoss&prpLrepairFee&prpLcomponent ------------------------------------*/
		ArrayList prpLcarLossDtoList = new ArrayList();
		PrpLcarLossDto prpLcarLossDto = null;
		//��������嵥
		ArrayList prpLrepairFeeDtoList = new ArrayList();
		PrpLrepairFeeDto prpLrepairFeeDto = null;
		//������Ŀ�嵥
		ArrayList prpLcomponentDtoList = new ArrayList();
		PrpLcomponentDto prpLcomponentDto = null;

		//�ӽ���õ���������
		String prpLcarLossPolicyNo = httpServletRequest
				.getParameter("prpLverifyLossPolicyNo");
		String prpLcarLossRiskCode = httpServletRequest
				.getParameter("prpLverifyLossRiskCode");
		String prpLcarLossClaimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo");
		String prpLcarLossRegistNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo");

		int repairFeeNo = 0;
		int componentNo = 0;

		//String prpLcarLossLossItemCode = String.valueOf(i+1); //�������
		String[] prpLcarLossLossItemCode = httpServletRequest
				.getParameterValues("prpLcarLossLossItemCode");
		String[] prpLcarLossLossItemName = httpServletRequest
				.getParameterValues("prpLcarLossLossItemName");
		String[] prpLcarLossCurrency = httpServletRequest
				.getParameterValues("prpLcarLossCurrency");
		String[] prpLcarLossSumRest = httpServletRequest
				.getParameterValues("prpLcarLossSumRest");
		String[] prpLcarLossSumManager = httpServletRequest
				.getParameterValues("prpLcarLossSumManager");
		String[] prpLcarLossSumCertainLoss = httpServletRequest
				.getParameterValues("prpLcarLossSumCertainLoss");
		String[] prpLcarLossSumVeriRest = httpServletRequest
				.getParameterValues("prpLcarLossSumVeriRest");
		String[] prpLcarLossSumVeriManager = httpServletRequest
				.getParameterValues("prpLcarLossSumVeriManager");
		String[] prpLcarLossSumTransFee = httpServletRequest
				.getParameterValues("prpLcarLossSumTransFee");
		String[] prpLcarLossSumTax = httpServletRequest
				.getParameterValues("prpLcarLossSumTax");
		String[] prpLcarLossSumVerifyLoss = httpServletRequest
				.getParameterValues("prpLcarLossSumVerifyLoss");
		String[] prpLcarLossLossDesc = httpServletRequest
				.getParameterValues("prpLcarLossLossDesc");
		String[] prpLcarLossIndemnityDuty = httpServletRequest
				.getParameterValues("prpLcarLossIndemnityDuty");
		String[] prpLcarLossIndemnityDutyRate = httpServletRequest
				.getParameterValues("prpLcarLossIndemnityDutyRate");
		String[] prpLcarLossVeriIndeDutyRate = httpServletRequest
				.getParameterValues("prpLcarLossVeriIndeDutyRate");
		String[] prpLcarLossRemark = httpServletRequest
				.getParameterValues("prpLcarLossRemark");
		String[] prpLcarLossOperatorCode = httpServletRequest
				.getParameterValues("prpLcarLossOperatorCode");
		String[] prpLcarLossApproverCode = httpServletRequest
				.getParameterValues("prpLcarLossApproverCode");
		String[] prpLcarLossFlag = httpServletRequest
				.getParameterValues("prpLcarLossFlag");
		String[] prpLcarLossBackCheckFlag = httpServletRequest
				.getParameterValues("prpLcarLossBackCheckFlag");
		String[] prpLcarLossBackCheckRemark = httpServletRequest
				.getParameterValues("prpLcarLossBackCheckRemark");
		String[] prpLcarLossCarKindCode = httpServletRequest
				.getParameterValues("prpLcarLossCarKindCode");
		String[] prpLcarLossLicenseColorCode = httpServletRequest
				.getParameterValues("prpLcarLossLicenseColorCode");
		String[] prpLcarLossVINNo = httpServletRequest
				.getParameterValues("prpLcarLossVINNo");
		String[] prpLcarLossSumManageFeeRate = httpServletRequest
				.getParameterValues("prpLcarLossSumManageFeeRate");
		String prpLrepairFeeRepairFactoryCode = httpServletRequest
				.getParameter("prpLrepairFeeRepairFactoryCode");
		String prpLrepairFeeRepairFactoryName = httpServletRequest
				.getParameter("prpLrepairFeeRepairFactoryName");
		String prpLrepairFeeRepairStartDate = httpServletRequest
				.getParameter("prpLrepairFeeRepairStartDate");
		String prpLrepairFeeRepairEndDate = httpServletRequest
				.getParameter("prpLrepairFeeRepairEndDate");
		String prpLrepairFeeHandlerCode = httpServletRequest
				.getParameter("prpLrepairFeeHandlerCode");
		String prpLrepairFeeHandlerName = httpServletRequest
				.getParameter("prpLrepairFeeHandlerName");

		//prpLrepairFee
		String[] carLossRepairFeeLossItemCode = httpServletRequest
				.getParameterValues("carLossRepairFeeLossItemCode");
		String[] prpLrepairFeeSerialNo = httpServletRequest
				.getParameterValues("prpLrepairFeeSerialNo");
		String[] prpLrepairFeeItemKindNo = httpServletRequest
				.getParameterValues("prpLrepairFeeItemKindNo");
		String[] prpLrepairFeeLossItemCode = httpServletRequest
				.getParameterValues("prpLrepairFeeLossItemCode");
		String[] prpLrepairFeeKindCode = httpServletRequest
				.getParameterValues("prpLrepairFeeKindCode");
		String[] prpLrepairFeeLicenseNo = httpServletRequest
				.getParameterValues("prpLrepairFeeLicenseNo");
		String[] prpLrepairFeeLicenseColorCode = httpServletRequest
				.getParameterValues("prpLrepairFeeLicenseColorCode");
		String[] prpLrepairFeeCarKindCode = httpServletRequest
				.getParameterValues("prpLrepairFeeCarKindCode");
		//String[]   prpLrepairFeeRepairFactoryCode          =httpServletRequest.getParameterValues("prpLrepairFeeRepairFactoryCode");
		//String[]   prpLrepairFeeRepairFactoryName          =httpServletRequest.getParameterValues("prpLrepairFeeRepairFactoryName");
		//String[]   prpLrepairFeeHandlerCode                =httpServletRequest.getParameterValues("prpLrepairFeeHandlerCode");
		//String[]   prpLrepairFeeRepairStartDate            =httpServletRequest.getParameterValues("prpLrepairFeeRepairStartDate");
		//String[]   prpLrepairFeeRepairEndDate              =httpServletRequest.getParameterValues("prpLrepairFeeRepairEndDate");
		String[] prpLrepairFeeSanctioner = httpServletRequest
				.getParameterValues("prpLrepairFeeSanctioner");
		String[] prpLrepairFeeApproverCode = httpServletRequest
				.getParameterValues("prpLrepairFeeApproverCode");
		String[] prpLrepairFeeOperatorCode = httpServletRequest
				.getParameterValues("prpLrepairFeeOperatorCode");
		String[] prpLrepairFeeCompCode = httpServletRequest
				.getParameterValues("prpLrepairFeeCompCode");
		String[] prpLrepairFeeCompName = httpServletRequest.getParameterValues("prpLrepairFeeCompName");
		String[] prpLrepairFeeManHour = httpServletRequest
				.getParameterValues("prpLrepairFeeManHour");
		String[] prpLrepairFeeManHourUnitPrice = httpServletRequest
				.getParameterValues("prpLrepairFeeManHourUnitPrice");
		String[] prpLrepairFeeManHourFee = httpServletRequest
				.getParameterValues("prpLrepairFeeManHourFee");
		String[] prpLrepairFeeMaterialFee = httpServletRequest
				.getParameterValues("prpLrepairFeeMaterialFee");
		String[] prpLrepairFeeLossRate = httpServletRequest
				.getParameterValues("prpLrepairFeeLossRate");
		String[] prpLrepairFeeCurrency = httpServletRequest
				.getParameterValues("prpLrepairFeeCurrency");
		String[] prpLrepairFeeFirstSumDefLoss = httpServletRequest
				.getParameterValues("prpLrepairFeeFirstSumDefLoss");
		String[] prpLrepairFeeSumDefLoss = httpServletRequest
				.getParameterValues("prpLrepairFeeSumDefLoss");
		String[] prpLrepairFeeRemark = httpServletRequest
				.getParameterValues("prpLrepairFeeRemark");
		String[] prpLrepairFeeVeriManHour = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriManHour");
		String[] prpLrepairFeeVeriManUnitPrice = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriManUnitPrice");
		String[] prpLrepairFeeVeriManHourFee = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriManHourFee");
		String[] prpLrepairFeeVeriMaterQuantity = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriMaterQuantity");
		String[] prpLrepairFeeVeriMaterUnitPrice = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriMaterUnitPrice");
		String[] prpLrepairFeeVeriMaterialFee = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriMaterialFee");
		String[] prpLrepairFeeVeriLossRate = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriLossRate");
		String[] prpLrepairFeeVeriSumLoss = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriSumLoss");
		String[] prpLrepairFeeVeriRemark = httpServletRequest
				.getParameterValues("prpLrepairFeeVeriRemark");
		String[] prpLrepairFeeBackCheckRemark = httpServletRequest
				.getParameterValues("prpLrepairFeeBackCheckRemark");
		String[] prpLrepairFeeFlag = httpServletRequest
				.getParameterValues("prpLrepairFeeFlag");
		String[] prpLrepairFeePartCode = httpServletRequest
				.getParameterValues("prpLrepairFeePartCode");

		String[] prpLrepairFeePartName = httpServletRequest
				.getParameterValues("prpLrepairFeePartName");
		String[] prpLrepairFeeRepairType = httpServletRequest
				.getParameterValues("prpLrepairFeeRepairType");

		//      add by lixiang start at 2006-04-21
		//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
		String[] prpLrepairFeeCompensateBackFlag = httpServletRequest
				.getParameterValues("prpLrepairFeeCompensateBackFlag");
		//		add by lixiang start at 2006-04-21
		//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
		String[] prpLcomponentCompensateBackFlag = httpServletRequest
				.getParameterValues("prpLcomponentCompensateBackFlag");
		//add by lixiang end at 2006-04-21

		//prpLcomponent
		String[] carLossComponentLossItemCode = httpServletRequest
				.getParameterValues("carLossComponentLossItemCode");
		String[] prpLcomponentSerialNo = httpServletRequest
				.getParameterValues("prpLcomponentSerialNo");
		String[] prpLcomponentItemKindNo = httpServletRequest
				.getParameterValues("prpLcomponentItemKindNo");
		String[] prpLcomponentKindCode = httpServletRequest
				.getParameterValues("prpLcomponentKindCode");
		String[] prpLcomponentLossItemCode = httpServletRequest
				.getParameterValues("prpLcomponentLossItemCode");
		String[] prpLcomponentLicenseNo = httpServletRequest
				.getParameterValues("prpLcomponentLicenseNo");
		String[] prpLcomponentLicenseColorCode = httpServletRequest
				.getParameterValues("prpLcomponentLicenseColorCode");
		String[] prpLcomponentCarKindCode = httpServletRequest
				.getParameterValues("prpLcomponentCarKindCode");
		String[] prpLcomponentMakeYear = httpServletRequest
				.getParameterValues("prpLcomponentMakeYear");
		String[] prpLcomponentGearboxType = httpServletRequest
				.getParameterValues("prpLcomponentGearboxType");
		String[] prpLcomponentQuoteCompanyGrade = httpServletRequest
				.getParameterValues("prpLcomponentQuoteCompanyGrade");
		String[] prpLcomponentManageFeeRate = httpServletRequest
				.getParameterValues("prpLcomponentManageFeeRate");
		String prpLcomponentRepairFactoryCode = httpServletRequest
				.getParameter("prpLrepairFeeRepairFactoryCode");
		String prpLcomponentRepairFactoryName = httpServletRequest
				.getParameter("prpLrepairFeeRepairFactoryName");
		
		
		String prpLcomponentHandlerCode = httpServletRequest
				.getParameter("prpLrepairFeeHandlerCode");
		String[] prpLcomponentRepairStartDate = httpServletRequest
				.getParameterValues("prpLrepairFeeRepairStartDate");
		String[] prpLcomponentRepairEndDate = httpServletRequest
				.getParameterValues("prpLrepairFeeRepairEndDate");
		//String[]   prpLcomponentPartDesc               =httpServletRequest.getParameterValues("prpLcomponentPartDesc");
		String[] prpLcomponentSanctioner = httpServletRequest
				.getParameterValues("prpLcomponentSanctioner");
		String[] prpLcomponentApproverCode = httpServletRequest
				.getParameterValues("prpLcomponentApproverCode");
		String[] prpLcomponentOperatorCode = httpServletRequest
				.getParameterValues("prpLcomponentOperatorCode");
		String[] prpLcomponentCompCode = httpServletRequest
				.getParameterValues("prpLcomponentCompCode");
		String[] prpLcomponentCompName = httpServletRequest
				.getParameterValues("prpLcomponentCompName");
		String[] prpLcomponentQuantity = httpServletRequest
				.getParameterValues("prpLcomponentQuantity");
		String[] prpLcomponentManHourFee = httpServletRequest.getParameterValues("prpLcomponentManHourFee");
		String[] prpLcomponentFirstMaterialFee = httpServletRequest
				.getParameterValues("prpLcomponentFirstMaterialFee");
		String[] prpLcomponentMaterialFee = httpServletRequest
				.getParameterValues("prpLcomponentMaterialFee");
		String[] prpLcomponentRestFee = httpServletRequest
				.getParameterValues("prpLcomponentRestFee");
		String[] prpLcomponentVeriRestFee = httpServletRequest
				.getParameterValues("prpLcomponentVeriRestFee");
		String[] prpLcomponentQueryPrice = httpServletRequest
				.getParameterValues("prpLcomponentQueryPrice");
		String[] prpLcomponentQuotedPrice = httpServletRequest
				.getParameterValues("prpLcomponentQuotedPrice");
		String[] prpLcomponentLossRate = httpServletRequest
				.getParameterValues("prpLcomponentLossRate");
		String[] prpLcomponentCurrency = httpServletRequest
				.getParameterValues("prpLcomponentCurrency");
		String[] prpLcomponentSumDefLoss = httpServletRequest
				.getParameterValues("prpLcomponentSumDefLoss");
		String[] prpLcomponentRemark = httpServletRequest
				.getParameterValues("prpLcomponentRemark");
		String[] prpLcomponentVeriQuantity = httpServletRequest
				.getParameterValues("prpLcomponentVeriQuantity");
		String[] prpLcomponentVeriManHourFee = httpServletRequest
				.getParameterValues("prpLcomponentVeriManHourFee");
		String[] prpLcomponentVeriMaterFee = httpServletRequest
				.getParameterValues("prpLcomponentVeriMaterFee");
		String[] prpLcomponentVeriLossRate = httpServletRequest
				.getParameterValues("prpLcomponentVeriLossRate");
		String[] prpLcomponentSumVeriLoss = httpServletRequest
				.getParameterValues("prpLcomponentSumVeriLoss");
		String[] prpLcomponentOriginalId = httpServletRequest
				.getParameterValues("prpLcomponentOriginalId");
		String[] prpLcomponentSys4SPrice = httpServletRequest
				.getParameterValues("prpLcomponentSys4SPrice");
		String[] prpLcomponentSysMarketPrice = httpServletRequest
				.getParameterValues("prpLcomponentSysMarketPrice");
		String[] prpLcomponentSysMatchPrice = httpServletRequest
				.getParameterValues("prpLcomponentSysMatchPrice");
		String[] prpLcomponentNative4SPrice = httpServletRequest
				.getParameterValues("prpLcomponentNative4SPrice");
		String[] prpLcomponentNativeMarketPrice = httpServletRequest
				.getParameterValues("prpLcomponentNativeMarketPrice");
		String[] prpLcomponentNativeMatchPrice = httpServletRequest
				.getParameterValues("prpLcomponentNativeMatchPrice");
		String[] prpLcomponentVerpCompPrice = httpServletRequest
				.getParameterValues("prpLcomponentVerpCompPrice");
		String[] prpLcomponentVeriRemark = httpServletRequest
				.getParameterValues("prpLcomponentVeriRemark");
		String[] prpLcomponentBackCheckRemark = httpServletRequest
				.getParameterValues("prpLcomponentBackCheckRemark");
		String[] prpLcomponentFlag = httpServletRequest
				.getParameterValues("prpLcomponentFlag");
		String[] prpLcomponentPartCode = httpServletRequest
				.getParameterValues("prpLcomponentPartCode");
		String[] prpLcomponentPartName = httpServletRequest
				.getParameterValues("prpLcomponentPartName");
		String[] prpLcomponentKindName = httpServletRequest
				.getParameterValues("prpLcomponentKindName");
		String[] prpLcomponentVerpoFlag = httpServletRequest
				.getParameterValues("verpoFlag");
		String[] prpLcomponentIndId = httpServletRequest
				.getParameterValues("prpLcomponentIndId");
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction
				.findByPrimaryKey(prpLcarLossRegistNo);
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper
				.findForEndorBefore(registDto
						.getPrpLregistDto().getPolicyNo(),
						registDto.getPrpLregistDto()
								.getDamageStartDate()
								.toString(), registDto
								.getPrpLregistDto()
								.getDamageStartHour());

		if (prpLcarLossLossItemCode == null) {
		} else {
			for (int i = 0; i < prpLcarLossLossItemCode.length; i++) {
				prpLcarLossDto = new PrpLcarLossDto();
				prpLcarLossDto.setPolicyNo(prpLcarLossPolicyNo);
				prpLcarLossDto.setRiskCode(prpLcarLossRiskCode);
				prpLcarLossDto.setClaimNo(claimNo);
				prpLcarLossDto.setRegistNo(prpLcarLossRegistNo);
				prpLcarLossDto.setLossItemCode(prpLcarLossLossItemCode[i]);
				//prpLcarLossDto.setLossItemCode(prpLcarLossLossItemCode[i]);
				prpLcarLossDto.setLossItemName(prpLcarLossLossItemName[i]);
				prpLcarLossDto.setCurrency(prpLcarLossCurrency[i]);
				prpLcarLossDto.setSumRest(Double.parseDouble(DataUtils
						.nullToZero(prpLcarLossSumRest[i])));
				prpLcarLossDto.setSumManager(Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumManager[i])));
				prpLcarLossDto.setSumCertainLoss(Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumCertainLoss[i])));
				prpLcarLossDto.setSumVeriRest(Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumVeriRest[i])));
				prpLcarLossDto.setSumVeriManager(Double.parseDouble(DataUtils
						.nullToZero(prpLcarLossSumVeriManager[i])));
				prpLcarLossDto.setSumTransFee( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumTransFee[i])));
				prpLcarLossDto.setSumTax( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumTax[i])));            
				prpLcarLossDto.setSumVerifyLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLcarLossSumVerifyLoss[i])));
				prpLcarLossDto.setLossDesc(prpLcarLossLossDesc[i]);
				prpLcarLossDto.setIndemnityDuty(prpLcarLossIndemnityDuty[i]);
				prpLcarLossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(prpLcarLossIndemnityDutyRate[i])));
				prpLcarLossDto.setVeriIndeDutyRate(Double.parseDouble(DataUtils.nullToZero(prpLcarLossVeriIndeDutyRate[i])));
				prpLcarLossDto.setRemark(prpLcarLossRemark[i]);
				prpLcarLossDto.setSumManageFeeRate(Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumManageFeeRate[i])));
				prpLcarLossDto.setVINNo(prpLcarLossVINNo[i]);
				prpLcarLossDto.setOperatorCode(prpLcarLossOperatorCode[i]);
				prpLcarLossDto.setApproverCode(prpLcarLossApproverCode[i]);
				prpLcarLossDto.setFlag(prpLcarLossFlag[i]);
				prpLcarLossDto.setBackCheckRemark(prpLcarLossBackCheckRemark[i]);
				prpLcarLossDto.setBackCheckFlag(prpLcarLossBackCheckFlag[i]);
				prpLcarLossDto.setRepairFactoryCode(prpLcomponentRepairFactoryCode);
				prpLcarLossDto.setRepairFactoryName(prpLrepairFeeRepairFactoryName);
				//���뼯��
				prpLcarLossDtoList.add(prpLcarLossDto);

				//����ֵ
				for (int index1 = 1; index1 < carLossRepairFeeLossItemCode.length; index1++) {
					if (String.valueOf(Integer.parseInt(carLossRepairFeeLossItemCode[index1]) + 1)
							.equals(prpLcarLossLossItemCode[i])) {
						repairFeeNo = repairFeeNo + 1;
						prpLrepairFeeDto = new PrpLrepairFeeDto();
						prpLrepairFeeDto.setPolicyNo(prpLcarLossPolicyNo);
						prpLrepairFeeDto.setRiskCode(prpLcarLossRiskCode);
						prpLrepairFeeDto.setClaimNo(claimNo);
						prpLrepairFeeDto.setRegistNo(prpLcarLossRegistNo);

						prpLrepairFeeDto.setSerialNo(repairFeeNo);
						//prpLrepairFeeDto.setSerialNo                 (Integer.parseInt(DataUtils.nullToZero(prpLrepairFeeSerialNo[index])));
						prpLrepairFeeDto
								.setItemKindNo(Integer
										.parseInt(DataUtils
												.nullToZero(prpLrepairFeeItemKindNo[index1])));
						prpLrepairFeeDto
								.setLossItemCode(prpLcarLossLossItemCode[i]);
						//prpLrepairFeeDto.setLossItemCode             (prpLrepairFeeLossItemCode[index]);
						prpLrepairFeeDto
								.setKindCode(prpLrepairFeeKindCode[index1]);
						//===========================================================
						

						if (!registDto.getPrpLregistDto().getPolicyNo().equals(
								"")) {
							for (int k = 0; k < policyDto
									.getPrpCitemKindDtoList().size(); k++) {
								PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
										.getPrpCitemKindDtoList().get(k);
								if (prpCitemKindDto.getKindCode().equals(
										prpLrepairFeeDto.getKindCode())) {
									prpLrepairFeeDto
											.setItemKindNo(prpCitemKindDto
													.getItemKindNo());
									break;
								}
							}
						}
						//===========================================================

						prpLrepairFeeDto
								.setLicenseNo(prpLcarLossLossItemName[i]);
						prpLrepairFeeDto
								.setLicenseColorCode(prpLcarLossLicenseColorCode[i]);
						prpLrepairFeeDto
								.setCarKindCode(prpLcarLossCarKindCode[i]);
						prpLrepairFeeDto
								.setRepairFactoryCode(prpLrepairFeeRepairFactoryCode);
						prpLrepairFeeDto
								.setRepairFactoryName(prpLrepairFeeRepairFactoryName);
						prpLrepairFeeDto
								.setHandlerCode(prpLrepairFeeHandlerCode);
						prpLrepairFeeDto.setRepairStartDate(new DateTime(
								new Date(), DateTime.YEAR_TO_DAY));
						prpLrepairFeeDto.setRepairEndDate(new DateTime(
								new Date(), DateTime.YEAR_TO_DAY));
						//prpLrepairFeeDto.setRepairStartDate          (new DateTime(prpLrepairFeeRepairStartDate));
						//prpLrepairFeeDto.setRepairEndDate            (new DateTime(prpLrepairFeeRepairEndDate));
						prpLrepairFeeDto
								.setSanctioner(prpLrepairFeeSanctioner[index1]);
						prpLrepairFeeDto
								.setApproverCode(prpLrepairFeeApproverCode[index1]);
						prpLrepairFeeDto
								.setOperatorCode(prpLrepairFeeOperatorCode[index1]);
						prpLrepairFeeDto
								.setCompCode(prpLrepairFeeCompCode[index1]);
						prpLrepairFeeDto
								.setCompName(prpLrepairFeeCompName[index1]);
						prpLrepairFeeDto
								.setManHour(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeManHour[index1])));
						prpLrepairFeeDto
								.setManHourUnitPrice(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeManHourUnitPrice[index1])));
						prpLrepairFeeDto
								.setManHourFee(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeManHourFee[index1])));
						prpLrepairFeeDto
								.setMaterialFee(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeMaterialFee[index1])));
						prpLrepairFeeDto
								.setLossRate(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeLossRate[index1])));
						prpLrepairFeeDto
								.setCurrency(prpLrepairFeeCurrency[index1]);
						//prpLrepairFeeDto.setFirstSumDefLoss            (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeFirstSumDefLoss[index1])));
						prpLrepairFeeDto
								.setSumDefLoss(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeSumDefLoss[index1])));
						prpLrepairFeeDto.setRemark(prpLrepairFeeRemark[index1]);
						prpLrepairFeeDto
								.setVeriManHour(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriManHour[index1])));
						prpLrepairFeeDto
								.setVeriManUnitPrice(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriManUnitPrice[index1])));
						prpLrepairFeeDto
								.setVeriManHourFee(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriManHourFee[index1])));
						prpLrepairFeeDto
								.setVeriMaterQuantity(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriMaterQuantity[index1])));
						prpLrepairFeeDto
								.setVeriMaterUnitPrice(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriMaterUnitPrice[index1])));
						prpLrepairFeeDto
								.setVeriMaterialFee(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriMaterialFee[index1])));
						prpLrepairFeeDto
								.setVeriLossRate(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriLossRate[index1])));
						prpLrepairFeeDto
								.setVeriSumLoss(Double
										.parseDouble(DataUtils
												.nullToZero(prpLrepairFeeVeriSumLoss[index1])));
						prpLrepairFeeDto
								.setVeriRemark(prpLrepairFeeVeriRemark[index1]);
						prpLrepairFeeDto
								.setBackCheckRemark(prpLrepairFeeBackCheckRemark[index1]);

						prpLrepairFeeDto
								.setPartCode(prpLrepairFeePartCode[index1]);
						prpLrepairFeeDto
								.setPartName(prpLrepairFeePartName[index1]);
						prpLrepairFeeDto
								.setRepairType(prpLrepairFeeRepairType[index1]);

						prpLrepairFeeDto.setFlag(prpLrepairFeeFlag[index1]);
						//prpLrepairFeeDto.setRepairType( prpLrepairFeeRepairType[index1]);
						//���뼯��
						//add by lixiang start at 2006-04-21
						//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
						prpLrepairFeeDto
								.setCompensateBackFlag(prpLrepairFeeCompensateBackFlag[index1]);
						//add by lixiang end at 2006-04-21
						

						prpLrepairFeeDtoList.add(prpLrepairFeeDto);
					}
				}

				//����ֵ
                   for (int index2 = 1; index2 < carLossComponentLossItemCode.length; index2++) {
                       if (String.valueOf(Integer.parseInt(carLossComponentLossItemCode[index2]) + 1).equals(prpLcarLossLossItemCode[i])) 
                       {
			        componentNo = componentNo + 1;
			        prpLcomponentDto = new PrpLcomponentDto();
			        prpLcomponentDto.setPolicyNo(prpLcarLossPolicyNo);//��������
				prpLcomponentDto.setRiskCode(prpLcarLossRiskCode);//���ִ���
				prpLcomponentDto.setClaimNo(claimNo);//������
				prpLcomponentDto.setRegistNo(prpLcarLossRegistNo);//������
				prpLcomponentDto.setSerialNo(componentNo);//���
				prpLcomponentDto.setItemKindNo(Integer.parseInt(DataUtils.nullToZero(prpLcomponentItemKindNo[index2])));//��������������
				prpLcomponentDto.setKindCode(prpLcomponentKindCode[index2]);//�ձ����
//				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
//					EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
//					PolicyDto policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto().getPolicyNo(),
//									registDto.getPrpLregistDto().getDamageStartDate().toString(), registDto.getPrpLregistDto().getDamageStartHour());
//					for (int k = 0; k < policyDto.getPrpCitemKindDtoList().size(); k++) {
//						PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(k);
//						if (prpCitemKindDto.getKindCode().equals(prpLcomponentDto.getKindCode())) {
//						prpLcomponentDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
//							break;
//						}
//					}
//				}
				
				prpLcomponentDto.setLossItemCode(prpLcarLossLossItemCode[i]);//��Ĵ���
				prpLcomponentDto.setLicenseNo(prpLrepairFeeLicenseNo[i]);//���ƺ���
				prpLcomponentDto.setLicenseColorCode(prpLcarLossLicenseColorCode[i]);//���Ƶ�ɫ����
				prpLcomponentDto.setCarKindCode(prpLcarLossCarKindCode[i]);//�����������
				prpLcomponentDto.setMakeYear(prpLcomponentMakeYear[index2]);//�������
				prpLcomponentDto.setGearboxType(prpLcomponentGearboxType[index2]);//��������ʽ
				prpLcomponentDto.setQuoteCompanyGrade(prpLcomponentQuoteCompanyGrade[index2]);//���۹�˾�ȼ�
				prpLcomponentDto.setManageFeeRate(Double.parseDouble(DataUtils.nullToZero(prpLcomponentManageFeeRate[index2])));//����ѱ���
				prpLcomponentDto.setRepairFactoryCode(prpLcomponentRepairFactoryCode);//��������
				prpLcomponentDto.setRepairFactoryName(prpLcomponentRepairFactoryName);//��������
				prpLcomponentDto.setHandlerCode(prpLcomponentHandlerCode);//�����˴���
				prpLcomponentDto.setOriginalId(prpLcomponentOriginalId[index2]);
				//prpLcomponentDto.setRepairStartDate(new DateTime(prpLcomponentRepairStartDate[index2]));//��������
				//prpLcomponentDto.setRepairEndDate(new DateTime(prpLcomponentRepairEndDate[index2]));//�޻�����
				prpLcomponentDto.setRepairStartDate(new DateTime(new Date(), DateTime.YEAR_TO_DAY));//��������
				prpLcomponentDto.setRepairEndDate(new DateTime(new Date(), DateTime.YEAR_TO_DAY));//�޻�����
				//prpLcomponentDto.setPartDesc(prpLcomponentPartDesc[index2]);//��λ����
				prpLcomponentDto.setSanctioner(prpLcomponentSanctioner[index2]);//��׼��
				prpLcomponentDto.setApproverCode(prpLcomponentApproverCode[index2]);//�����˴���
				prpLcomponentDto.setOperatorCode(prpLcomponentOperatorCode[index2]);//����Ա����
				prpLcomponentDto.setCompCode(prpLcomponentCompCode[index2]);//������Ŀ����
				prpLcomponentDto.setCompName(prpLcomponentCompName[index2]);//������Ŀ����
				prpLcomponentDto.setQuantity(Integer.parseInt(DataUtils.nullToZero(prpLcomponentQuantity[index2])));//����
				prpLcomponentDto.setSys4SPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentSys4SPrice[index2])));//ϵͳר�޼�
				prpLcomponentDto.setSysMarketPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentSysMarketPrice[index2])));//ϵͳ�г��۸�
				prpLcomponentDto.setSysMatchPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentSysMatchPrice[index2])));//ϵͳ���׼۸�
				prpLcomponentDto.setNative4SPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentNative4SPrice[index2])));//����ר�޼۸�
				prpLcomponentDto.setNativeMarketPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentNativeMarketPrice[index2])));//�����г��۸�
				prpLcomponentDto.setNativeMatchPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentNativeMatchPrice[index2])));//�������׼۸�
				prpLcomponentDto.setVerpCompPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentVerpCompPrice[index2])));//�˼�
				prpLcomponentDto.setManHourFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentManHourFee[index2])));//��ʱ��
				//prpLcomponentDto.setFirstMaterialFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentFirstMaterialFee[index2])));//
				prpLcomponentDto.setMaterialFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentMaterialFee[index2])));//���Ϸ�(�ϱ��۸�)
				prpLcomponentDto.setRestFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentRestFee[index2])));//��ֵ
				prpLcomponentDto.setVeriRestFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriRestFee[index2])));//��ֵ(����)
				prpLcomponentDto.setQueryPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentQueryPrice[index2])));//ѯ�ۼ۸�
				prpLcomponentDto.setQuotedPrice(Double.parseDouble(DataUtils.nullToZero(prpLcomponentQuotedPrice[index2])));//���ۼ۸�
				prpLcomponentDto.setLossRate(Double.parseDouble(DataUtils.nullToZero(prpLcomponentLossRate[index2])));//�⳥����
				prpLcomponentDto.setCurrency(prpLcomponentCurrency[index2]);//�ұ�
				prpLcomponentDto.setSumDefLoss(Double.parseDouble(DataUtils.nullToZero(prpLcomponentSumDefLoss[index2])));//�˶�����
				prpLcomponentDto.setRemark(prpLcomponentRemark[index2]);//��ע
				prpLcomponentDto.setVeriQuantity(Integer.parseInt(DataUtils.nullToZero(prpLcomponentVeriQuantity[index2])));//����(����)
				prpLcomponentDto.setVeriManHourFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriManHourFee[index2])));//��ʱ��(����)
				prpLcomponentDto.setVeriMaterFee(Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriMaterFee[index2])));//���Ϸ�(����)
				prpLcomponentDto.setVeriLossRate(Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriLossRate[index2])));//�⳥����(����)
				prpLcomponentDto.setSumVeriLoss(Double.parseDouble(DataUtils.nullToZero(prpLcomponentSumVeriLoss[index2])));//�˶�����
				prpLcomponentDto.setVeriRemark(prpLcomponentVeriRemark[index2]);//��ע(�������)
				prpLcomponentDto.setBackCheckRemark(prpLcomponentBackCheckRemark[index2]);//�ؿ��������
				prpLcomponentDto.setFlag(prpLcomponentFlag[index2]);//	
				prpLcomponentDto.setPartCode(prpLcomponentPartCode[index2]);//��ʧ��������
				prpLcomponentDto.setPartName(prpLcomponentPartName[index2]);//��ʧ��������
				prpLcomponentDto.setIndId(Integer.parseInt(DataUtils.nullToZero(prpLcomponentIndId[index2])));
				if (nodeType.equals("verip")|| nodeType.equals("verpo")|| nodeType.equals("verif"))
				 {
					//   prpLcomponentDto.setVerpoFlag(prpLcomponentVerpoFlag[index2]);
				 }
				//add by lixiang start at 2006-04-21
				//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
				prpLcomponentDto.setCompensateBackFlag(prpLcomponentCompensateBackFlag[index2]);//ԭ�л������
				//add by lixiang end at 2006-04-21
				//���뼯��
				prpLcomponentDtoList.add(prpLcomponentDto);
			}
				
			}
			}
			PropertyUtils.copyProperties(LossItemRepairComponentDto,
					verifyLossDto.getPrpLverifyLossDto());
			LossItemRepairComponentDto.setSerialNo(1);
			LossItemRepairComponentDto.setLossType("1");
			LossItemRepairComponentDto.setNodeType(nodeType);
			lossItemListTemp.add(LossItemRepairComponentDto);
		}

		//��������
		verifyLossDto.setPrpLcarLossDtoList(prpLcarLossDtoList);
		verifyLossDto.setPrpLrepairFeeDtoList(prpLrepairFeeDtoList);
		verifyLossDto.setPrpLcomponentDtoList(prpLcomponentDtoList);

		/*---------------------��Ա������ϸ��Ϣ�� prpLperson ------------------------------------*/
		ArrayList prpLpersonDtoList = new ArrayList();
		PrpLpersonDto prpLpersonDto = null;

		//�ӽ���õ���������
		String prpLpersonPolicyNo = httpServletRequest
				.getParameter("prpLverifyLossPolicyNo");
		String prpLpersonRiskCode = httpServletRequest
				.getParameter("prpLverifyLossRiskCode");
		String prpLpersonClaimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo");
		String prpLpersonRegistNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo");

		String[] personSerialNo = httpServletRequest
				.getParameterValues("personSerialNo");
		String[] prpLpersonSerialNo = httpServletRequest
				.getParameterValues("prpLpersonSerialNo");
		String[] prpLpersonItemKindNo = httpServletRequest
				.getParameterValues("prpLpersonItemKindNo");
		String[] prpLpersonFamilyNo = httpServletRequest
				.getParameterValues("prpLpersonFamilyNo");
		String[] prpLpersonFamilyName = httpServletRequest
				.getParameterValues("prpLpersonFamilyName");
		String[] prpLpersonKindCode = httpServletRequest
				.getParameterValues("prpLpersonKindCode");
		String[] prpLpersonItemCode = httpServletRequest
				.getParameterValues("prpLpersonItemCode");
		String[] prpLpersonAreaCode = httpServletRequest
				.getParameterValues("prpLpersonAreaCode");
		String[] prpLpersonFixedIncomeFlag = httpServletRequest
				.getParameterValues("prpLpersonFixedIncomeFlag");
		String[] prpLpersonJobCode = httpServletRequest
				.getParameterValues("prpLpersonJobCode");
		String[] prpLpersonJobName = httpServletRequest
				.getParameterValues("prpLpersonJobName");
		String[] prpLpersonPayPersonType = httpServletRequest
				.getParameterValues("prpLpersonPayPersonType");
		String[] prpLpersonFeeTypeCode = httpServletRequest
				.getParameterValues("prpLpersonFeeTypeCode");
		String[] prpLpersonFeeTypeName = httpServletRequest
				.getParameterValues("prpLpersonFeeTypeName");
		String[] prpLpersonPersonNo = httpServletRequest
				.getParameterValues("prpLpersonPersonNo");
		String[] prpLpersonPersonName = httpServletRequest
				.getParameterValues("prpLpersonPersonName");
		String[] prpLpersonPersonSex = httpServletRequest
				.getParameterValues("prpLpersonPersonSex");

		String[] prpLpersonJobUnit = httpServletRequest
				.getParameterValues("prpLpersonJobUnit");
		String[] prpLpersonMonthStdWage = httpServletRequest
				.getParameterValues("prpLpersonMonthStdWage");
		String[] prpLpersonMonthBonus = httpServletRequest
				.getParameterValues("prpLpersonMonthBonus");
		String[] prpLpersonAllowance = httpServletRequest
				.getParameterValues("prpLpersonAllowance");
		String[] prpLpersonMonthWage = httpServletRequest
				.getParameterValues("prpLpersonMonthWage");
		String[] prpLpersonHospital = httpServletRequest
				.getParameterValues("prpLpersonHospital");
		String[] prpLpersonNursePersons = httpServletRequest
				.getParameterValues("prpLpersonNursePersons");
		String[] prpLpersonNurseDays = httpServletRequest
				.getParameterValues("prpLpersonNurseDays");
		String[] prpLpersonDiagnose = httpServletRequest
				.getParameterValues("prpLpersonDiagnose");
		String[] prpLpersonWoundGrade = httpServletRequest
				.getParameterValues("prpLpersonWoundGrade");
		String[] prpLpersonHospitalDays = httpServletRequest
				.getParameterValues("prpLpersonHospitalDays");
		String[] prpLpersonCureDays = httpServletRequest
				.getParameterValues("prpLpersonCureDays");
		String[] prpLpersonChangeHospital = httpServletRequest
				.getParameterValues("prpLpersonChangeHospital");
		String[] prpLpersonPersonAge = httpServletRequest
				.getParameterValues("prpLpersonPersonAge");
		String[] prpLpersonCurrency = httpServletRequest
				.getParameterValues("prpLpersonCurrency");
		String[] prpLpersonIdentifyNumber = httpServletRequest
				.getParameterValues("prpLpersonIdentifyNumber");
		String[] prpLpersonRelatePersonNo = httpServletRequest
				.getParameterValues("prpLpersonRelatePersonNo");
		String[] prpLpersonUnitLoss = httpServletRequest
				.getParameterValues("prpLpersonUnitLoss");
		String[] prpLpersonQuantity = httpServletRequest
				.getParameterValues("prpLpersonQuantity");
		String[] prpLpersonUnit = httpServletRequest
				.getParameterValues("prpLpersonUnit");
		String[] prpLpersonTimes = httpServletRequest
				.getParameterValues("prpLpersonTimes");
		String[] prpLpersonSumLoss = httpServletRequest
				.getParameterValues("prpLpersonSumLoss");
		String[] prpLpersonSumReject = httpServletRequest
				.getParameterValues("prpLpersonSumReject");
		String[] prpLpersonRejectReason = httpServletRequest
				.getParameterValues("prpLpersonRejectReason");
		String[] prpLpersonLossRate = httpServletRequest
				.getParameterValues("prpLpersonLossRate");
		String[] prpLpersonSumDefLoss = httpServletRequest
				.getParameterValues("prpLpersonSumDefLoss");
		String[] prpLpersonRemark = httpServletRequest
				.getParameterValues("prpLpersonRemark");
		String[] prpLpersonVeriQuantity = httpServletRequest
				.getParameterValues("prpLpersonVeriQuantity");
		String[] prpLpersonVeriUnitLoss = httpServletRequest
				.getParameterValues("prpLpersonVeriUnitLoss");
		String[] prpLpersonVeriUnit = httpServletRequest
				.getParameterValues("prpLpersonVeriUnit");
		String[] prpLpersonVeriTimes = httpServletRequest
				.getParameterValues("prpLpersonVeriTimes");
		String[] prpLpersonVeriSumLoss = httpServletRequest
				.getParameterValues("prpLpersonVeriSumLoss");
		String[] prpLpersonVeriSumReject = httpServletRequest
				.getParameterValues("prpLpersonVeriSumReject");
		String[] prpLpersonVeriRejectReason = httpServletRequest
				.getParameterValues("prpLpersonVeriRejectReason");
		String[] prpLpersonVeriLossRate = httpServletRequest
				.getParameterValues("prpLpersonVeriLossRate");
		String[] prpLpersonVeriSumDefLoss = httpServletRequest
				.getParameterValues("prpLpersonVeriSumDefLoss");
		String[] prpLpersonVeriRemark = httpServletRequest
				.getParameterValues("prpLpersonVeriRemark");
		String[] prpLpersonFlag = httpServletRequest
				.getParameterValues("prpLpersonFlag");
		//		add by lixiang start at 2006-04-21
		//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
		String[] prpLpersonCompensateBackFlag = httpServletRequest
				.getParameterValues("prpLpersonCompensateBackFlag");
		//add by lixiang end at 2006-04-21

		//modify by wangli add start 20050401
		//reason:�����ҽ���˵�� ��
		String[] prpLpersonFllowHospRemark = httpServletRequest
				.getParameterValues("prpLpersonFllowHospRemark");//��ҽ���˵��
		String[] prpLpersonInHospDate = httpServletRequest
				.getParameterValues("prpLpersonInHospDate"); //��Ժ����
		String[] prpLpersonOutHospDate = httpServletRequest
				.getParameterValues("prpLpersonOutHospDate"); //��Ժ����
		String[] prpLpersonRestDate = httpServletRequest
				.getParameterValues("prpLpersonRestDate"); //��������
		//modify by wangli add end 20050401

		//����ֵ
		if (personSerialNo == null) {
		} else {
			for (int index = 1; index < personSerialNo.length; index++) {
				prpLpersonDto = new PrpLpersonDto();
				prpLpersonDto.setPolicyNo(prpLpersonPolicyNo);
				prpLpersonDto.setRiskCode(prpLpersonRiskCode);
				prpLpersonDto.setClaimNo(claimNo);
				prpLpersonDto.setRegistNo(prpLpersonRegistNo);
				//������
				prpLpersonDto.setSerialNo(index);
				//prpLpersonDto.setSerialNo           (Integer.parseInt(DataUtils.nullToZero(personSerialNo [index])));
				prpLpersonDto.setKindCode(prpLpersonKindCode[index]);
				prpLpersonDto.setFeeTypeCode(prpLpersonFeeTypeCode[index]);
				prpLpersonDto.setFeeTypeName(prpLpersonFeeTypeName[index]);
				//modify by liuyanmei reason: ����ȥ�����˵ķ��������͵���
				//prpLpersonDto.setUnitLoss           (Double.parseDouble(DataUtils.nullToZero( prpLpersonUnitLoss [index])));
				//prpLpersonDto.setQuantity           (Double.parseDouble(DataUtils.nullToZero( prpLpersonQuantity [index])));
				prpLpersonDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonSumLoss[index])));
				prpLpersonDto.setSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonSumReject[index])));
				prpLpersonDto.setSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonSumDefLoss[index])));
				prpLpersonDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonItemKindNo[index])));
				prpLpersonDto.setFamilyNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonFamilyNo[index])));
				prpLpersonDto.setItemCode(prpLpersonItemCode[index]);
				//prpLpersonDto.setPersonNo           (Integer.parseInt(DataUtils.nullToZero( prpLpersonPersonNo [index])));
				prpLpersonDto.setUnit(prpLpersonUnit[index]);
				prpLpersonDto.setTimes(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonTimes[index])));
				prpLpersonDto.setRejectReason(prpLpersonRejectReason[index]);
				//prpLpersonDto.setVeriQuantity        (Double.parseDouble(DataUtils.nullToZero(  prpLpersonVeriQuantity [index])));
				//prpLpersonDto.setVeriUnitLoss        (Double.parseDouble(DataUtils.nullToZero(  prpLpersonVeriUnitLoss [index])));
				prpLpersonDto.setVeriUnit(prpLpersonVeriUnit[index]);
				prpLpersonDto.setVeriTimes(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonVeriTimes[index])));
				prpLpersonDto.setVeriSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonVeriSumLoss[index])));
				prpLpersonDto.setVeriSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonVeriSumReject[index])));
				prpLpersonDto
						.setVeriRejectReason(prpLpersonVeriRejectReason[index]);
				prpLpersonDto.setVeriLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonVeriLossRate[index])));
				prpLpersonDto.setVeriSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonVeriSumDefLoss[index])));
				prpLpersonDto.setVeriRemark(prpLpersonVeriRemark[index]);
				prpLpersonDto.setFlag(prpLpersonFlag[index]);
				prpLpersonDto
						.setCompensateBackFlag(prpLpersonCompensateBackFlag[index]);
				//===========================================================

				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {

					for (int k = 0; k < policyDto.getPrpCitemKindDtoList()
							.size(); k++) {
						PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
								.getPrpCitemKindDtoList().get(k);
						if (prpCitemKindDto.getKindCode().equals(
								prpLpersonDto.getKindCode())) {
							prpLpersonDto.setItemKindNo(prpCitemKindDto
									.getItemKindNo());
							break;
						}
					}
				}
				//===========================================================			  

				for (int index2 = 0; index2 < prpLpersonSerialNo.length; index2++) {
					if (prpLpersonSerialNo[index2]
							.equals(personSerialNo[index])) {
						//������
						prpLpersonDto
								.setFamilyName(prpLpersonFamilyName[index2]);
						prpLpersonDto.setAreaCode(prpLpersonAreaCode[index2]);
						prpLpersonDto
								.setFixedIncomeFlag(prpLpersonFixedIncomeFlag[index2]);
						prpLpersonDto.setJobCode(prpLpersonJobCode[index2]);
						prpLpersonDto.setJobName(prpLpersonJobName[index2]);
						prpLpersonDto
								.setPayPersonType(prpLpersonPayPersonType[index2]);
						prpLpersonDto
								.setPersonName(prpLpersonPersonName[index2]);
						prpLpersonDto.setPersonSex(prpLpersonPersonSex[index2]);
						prpLpersonDto.setJobUnit(prpLpersonJobUnit[index2]);
						prpLpersonDto
								.setMonthStdWage(Double
										.parseDouble(DataUtils
												.nullToZero(prpLpersonMonthStdWage[index2])));
						prpLpersonDto
								.setMonthBonus(Double
										.parseDouble(DataUtils
												.nullToZero(prpLpersonMonthBonus[index2])));
						prpLpersonDto.setAllowance(Double.parseDouble(DataUtils
								.nullToZero(prpLpersonAllowance[index2])));
						prpLpersonDto.setMonthWage(Double.parseDouble(DataUtils
								.nullToZero(prpLpersonMonthWage[index2])));
						prpLpersonDto.setHospital(prpLpersonHospital[index2]);
						prpLpersonDto
								.setNursePersons(Integer
										.parseInt(DataUtils
												.nullToZero(prpLpersonNursePersons[index2])));
						prpLpersonDto.setNurseDays(Integer.parseInt(DataUtils
								.nullToZero(prpLpersonNurseDays[index2])));
						prpLpersonDto.setDiagnose(prpLpersonDiagnose[index2]);
						prpLpersonDto
								.setWoundGrade(prpLpersonWoundGrade[index2]);
						prpLpersonDto
								.setHospitalDays(Integer
										.parseInt(DataUtils
												.nullToZero(prpLpersonHospitalDays[index2])));
						prpLpersonDto.setCureDays(Integer.parseInt(DataUtils
								.nullToZero(prpLpersonCureDays[index2])));
						prpLpersonDto
								.setChangeHospital(prpLpersonChangeHospital[index2]);

						prpLpersonDto.setPersonAge(Integer.parseInt(DataUtils
								.nullToZero(prpLpersonPersonAge[index2])));
						prpLpersonDto.setCurrency(prpLpersonCurrency[index2]);
						prpLpersonDto
								.setIdentifyNumber(prpLpersonIdentifyNumber[index2]);
						prpLpersonDto
								.setRelatePersonNo(Integer
										.parseInt(DataUtils
												.nullToZero(prpLpersonRelatePersonNo[index2])));
						prpLpersonDto.setLossRate(Double.parseDouble(DataUtils
								.nullToZero(prpLpersonLossRate[index2])));
						prpLpersonDto.setRemark(prpLpersonRemark[index2]);
						prpLpersonDto.setPersonNo(index2);

						//modify by wangli add start 20050401
						prpLpersonDto
								.setFllowHospRemark(prpLpersonFllowHospRemark[index2]);
						prpLpersonDto.setInHospDate(new DateTime(
								prpLpersonInHospDate[index2],
								DateTime.YEAR_TO_DAY));
						prpLpersonDto.setOutHospDate(new DateTime(
								prpLpersonOutHospDate[index2],
								DateTime.YEAR_TO_DAY));
						prpLpersonDto.setRestDate(new DateTime(
								prpLpersonRestDate[index2],
								DateTime.YEAR_TO_DAY));
						//modify by wangli add end 20050401

					}
				}

				//���뼯��
				prpLpersonDtoList.add(prpLpersonDto);
			}
			PropertyUtils.copyProperties(LossItemPersonDto, verifyLossDto
					.getPrpLverifyLossDto());
			LossItemPersonDto.setSerialNo(0);
			LossItemPersonDto.setLossType("0");
			LossItemPersonDto.setNodeType(nodeType);
			lossItemListTemp.add(LossItemPersonDto);
		}

		//�Ʋ��˶�����ϸ�嵥��
		verifyLossDto.setPrpLpersonDtoList(prpLpersonDtoList);
		verifyLossDto.setPrpLverifyLossItemDtoList(lossItemListTemp);
		/*---------------------������Ϣ�� PrpLpersonWound ------------------------------------*/
		ArrayList prpLpersonWoundDtoList = new ArrayList();
		PrpLpersonWoundDto prpLpersonWoundDto = null;

		//�ӽ���õ���������
		String[] woundCodeCheck001Txt = httpServletRequest
				.getParameterValues("woundCodeCheck001Txt");
		String[] woundCodeCheck002Txt = httpServletRequest
				.getParameterValues("woundCodeCheck002Txt");
		String[] woundCodeCheck003Txt = httpServletRequest
				.getParameterValues("woundCodeCheck003Txt");
		String[] woundCodeCheck004Txt = httpServletRequest
				.getParameterValues("woundCodeCheck004Txt");
		String[] woundCodeCheck005Txt = httpServletRequest
				.getParameterValues("woundCodeCheck005Txt");
		String[] woundCodeCheck006Txt = httpServletRequest
				.getParameterValues("woundCodeCheck006Txt");
		String[] woundCodeCheck007Txt = httpServletRequest
				.getParameterValues("woundCodeCheck007Txt");
		String[] woundCodeCheck008Txt = httpServletRequest
				.getParameterValues("woundCodeCheck008Txt");
		String[] woundCodeCheck009Txt = httpServletRequest
				.getParameterValues("woundCodeCheck009Txt");
		String[] woundCodeCheck010Txt = httpServletRequest
				.getParameterValues("woundCodeCheck010Txt");
		String[] woundCodeCheck011Txt = httpServletRequest
				.getParameterValues("woundCodeCheck011Txt");
		String[] woundCodeCheck012Txt = httpServletRequest
				.getParameterValues("woundCodeCheck012Txt");
		String[] woundCodeCheck013Txt = httpServletRequest
				.getParameterValues("woundCodeCheck013Txt");
		String[] woundCodeCheck014Txt = httpServletRequest
				.getParameterValues("woundCodeCheck014Txt");
		String[] woundCodeCheck015Txt = httpServletRequest
				.getParameterValues("woundCodeCheck015Txt");
		String[] woundCodeCheck016Txt = httpServletRequest
				.getParameterValues("woundCodeCheck016Txt");
		String[] woundCodeCheck017Txt = httpServletRequest
				.getParameterValues("woundCodeCheck017Txt");
		String[] woundCodeCheck018Txt = httpServletRequest
				.getParameterValues("woundCodeCheck018Txt");
		String[] woundCodeCheck019Txt = httpServletRequest
				.getParameterValues("woundCodeCheck019Txt");
		String[] woundCodeCheck020Txt = httpServletRequest
				.getParameterValues("woundCodeCheck020Txt");
		String[] woundCodeCheck021Txt = httpServletRequest
				.getParameterValues("woundCodeCheck021Txt");
		String[] woundCodeCheck022Txt = httpServletRequest
				.getParameterValues("woundCodeCheck022Txt");
		String[] woundCodeCheck023Txt = httpServletRequest
				.getParameterValues("woundCodeCheck023Txt");
		String[] woundCodeCheck024Txt = httpServletRequest
				.getParameterValues("woundCodeCheck024Txt");

		//ȡ���������˵Ĵ�����Ϣ
		UICodeAction uiCodeAction = new UICodeAction();
		List woundCodeList = (ArrayList) uiCodeAction.getCodeType("WoundCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
						"RISKCODE_DAA"));
		Map woundCodeMap = new HashMap();
		for (int i = 0; i < woundCodeList.size(); i++) {
			PrpDcodeDto prpDcodeDto = (PrpDcodeDto) woundCodeList.get(i);
			woundCodeMap.put(prpDcodeDto.getCodeCode(), prpDcodeDto
					.getCodeCName());
		}
		int intSerialNo = 1;
		if (woundCodeCheck001Txt == null) {

		} else {
			for (int index = 1; index < woundCodeCheck001Txt.length; index++) {
				intSerialNo = 1;
				if (woundCodeCheck001Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("001");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("001"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck002Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("002");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("002"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck003Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("003");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("003"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck004Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("004");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("004"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck005Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("005");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("005"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck006Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("006");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("006"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck007Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("007");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("007"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck008Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("008");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("008"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck009Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("009");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("009"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck010Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("010");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("010"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck011Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("011");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("011"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck012Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("012");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("012"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck013Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("013");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("013"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck014Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("014");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("014"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck015Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("015");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("015"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck016Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("016");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("016"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck017Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("017");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("017"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck018Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("018");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("018"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck019Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("019");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("019"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck020Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("020");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("020"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck021Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("021");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("021"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck022Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("022");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("022"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck023Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("023");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("023"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if (woundCodeCheck024Txt[index].trim().equals("1")) {
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(verifyLossDto
							.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(verifyLossDto
							.getPrpLverifyLossDto().getClaimNo());
					prpLpersonWoundDto.setPolicyNo(verifyLossDto
							.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto
							.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("024");
					prpLpersonWoundDto.setWoundDesc((String) woundCodeMap
							.get("024"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
			}
		}
		verifyLossDto.setPrpLpersonWoundDtoList(prpLpersonWoundDtoList);

		/*---------------------��������Ϣ����˵�� PrpLverifyLossExt ------------------------------------*/
		ArrayList prpLverifyLossExtDtoList = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto = null;
		//�ӽ���õ���������
		String prpLverifyLossExtRegistNo = (String) httpServletRequest
				.getParameter("prpLverifyLossExtRegistNo");
		String prpLverifyLossExtRiskCode = httpServletRequest
				.getParameter("prpLverifyLossExtRiskCode");
		String[] prpLverifyLossExtSerialNo = httpServletRequest
				.getParameterValues("prpLverifyLossExtSerialNo");
		String[] prpLverifyLossExtInputDate = httpServletRequest
				.getParameterValues("prpLverifyLossExtInputDate");
		String[] prpLverifyLossExtInputHour = httpServletRequest
				.getParameterValues("prpLverifyLossExtInputHour");
		String[] prpLverifyLossExtOperatorCode = httpServletRequest
				.getParameterValues("prpLverifyLossExtOperatorCode");
		String[] prpLverifyLossExtTitle = httpServletRequest
				.getParameterValues("prpLverifyLossExtTitle");
		String[] prpLverifyLossExtContext = httpServletRequest
				.getParameterValues("prpLverifyLossExtContext");

		String prpLverifyLossExtLossItemCode = httpServletRequest
				.getParameter("prpLcarLossLossItemCode");
		System.out.println("===================[ ����]================"
				+ prpLverifyLossExtLossItemCode);
		//�Ʋ����𱣴涨���������ϸ��Ϣ
		if(prpLverifyLossExtLossItemCode == null){
			prpLverifyLossExtLossItemCode = httpServletRequest.getParameter("prpLpropLossLossItemCode");
		}
		//����ֵ
		//��Ա�������� ���ֿ�ʼ
		if (prpLverifyLossExtSerialNo == null) {
		} else {
			//System.out.println("��Ա�������ٲ��ֿ�ʼ ");
			for (int index = 1; index < prpLverifyLossExtSerialNo.length; index++) {
				prpLverifyLossExtDto = new PrpLverifyLossExtDto();
				prpLverifyLossExtDto.setRegistNo(prpLverifyLossExtRegistNo);
				prpLverifyLossExtDto.setRiskCode(prpLverifyLossExtRiskCode);
				prpLverifyLossExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLverifyLossExtSerialNo[index])));
				prpLverifyLossExtDto
						.setInputDate(new DateTime(
								prpLverifyLossExtInputDate[index],
								DateTime.YEAR_TO_DAY));
				prpLverifyLossExtDto
						.setInputHour(prpLverifyLossExtInputHour[index]);
				prpLverifyLossExtDto
						.setOperatorCode(prpLverifyLossExtOperatorCode[index]);
				prpLverifyLossExtDto.setTitle(prpLverifyLossExtTitle[index]);
				prpLverifyLossExtDto
						.setContext(prpLverifyLossExtContext[index]);
				prpLverifyLossExtDto
						.setLossItemCode(prpLverifyLossExtLossItemCode);
				//���뼯��
				prpLverifyLossExtDtoList.add(prpLverifyLossExtDto);
			}
			//���������м�����ʧ��λ
			verifyLossDto.setPrpLverifyLossExtDtoList(prpLverifyLossExtDtoList);
		}

		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		//�ӽ���õ���������
		String prpLregistExtRegistNo = (String) httpServletRequest
				.getParameter("prpLregistExtRegistNo");
		String prpLregistExtRiskCode = httpServletRequest
				.getParameter("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest
				.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest
				.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest
				.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest
				.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest
				.getParameterValues("prpLregistExtContext");

		//����ֵ
		//��Ա�������� ���ֿ�ʼ
		if (prpLregistExtSerialNo == null) {
		} else {
			//System.out.println("��Ա�������ٲ��ֿ�ʼ ");
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(
						prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto
						.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//���뼯��
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//���������м�����ʧ��λ
			verifyLossDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}

		return verifyLossDto;
	}

	/**
	 * ���ɶ�����Ϣ��ϸ����
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo     ҵ�����
	 * @param editType   �༭����
	 * @throws Exception
	 */
	public void verifyLossDtoView(HttpServletRequest httpServletRequest,
			String registNo, String editType, String tempStatus)
			throws Exception {
		//�����ţ����������Ϊ0������Ϊ1��2��3��4��5�ȳ������
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		String riskCode = httpServletRequest.getParameter("riskCode");
		//�ǳ��գ�lossItemCodeĬ��Ϊ1,�����Ϳ����������вƲ�����ϸ��ɾ��������
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if (riskCode != null && !strRiskType.equals(("D"))) {
			lossItemCode = "1";
		}
		
		//��89��ģ������� start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
        String riskcodeStr = "";//��89��ģ������ֵ��ַ���
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //��89��ģ�������  end===
		        
		if("0310".equals(riskCode)||"0312".equals(riskCode) || riskcodeStr.indexOf(riskCode)>0 )
		{
			lossItemCode = "-1";
		}
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		VerifyLossDto verifyLossDto = uiVerifyLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode, nodeType);
		PrpLverifyLossDto prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();
		//���ö��������״̬Ϊ �����޸� (����������)      
		if (verifyLossDto.getPrpLclaimStatusDto() != null) {
			if (tempStatus == null) {
				prpLverifyLossDto.setStatus(verifyLossDto
						.getPrpLclaimStatusDto().getStatus());
			} else {
				prpLverifyLossDto.setStatus(tempStatus);
			}
		} else {
			//���ύ���Ѿ�������ϵ�״̬
			prpLverifyLossDto.setStatus("1");
		}

		//�����������
		prpLverifyLossDto.setClauseType("none");
		// ��ȡ������ǿ�ձ�����Ϣ
		this.getRelatCompelPolicyDto(httpServletRequest, registNo);
		// ��ȡ��ʧ������Ϣ���������𡢺���ҳ���ϵ����⳵����Ϣ
		getLossCarInfo(registNo, lossItemCode, verifyLossDto);
		// ��ȡ�������鿱��Ϣ
		getRegistCheckInfo(httpServletRequest, registNo);
		
		//У���Ƿ��Ѿ�����ѯ�ۣ�����Ѿ�����ѯ�ۣ�������˼�Ա��Ȩ���ύ
		/*if (!prpLverifyLossDto.getStatus().equals("4")) {
			String msg = "";
			msg = this.checkVerpo(swfLogFlowID, swfLogLogNo, lossItemCode);
			prpLverifyLossDto.setVerifPriceOuterMsg(msg);
		}*/
		//��ѯ�˼�Ȩ��       
		//String taskCode = AppConfig.get("sysconst.TASKCODE_LPHJ"); //�������Ϊ�˼�
		//UIPrpLclaimGradeAction uiPrpLclaimGradeAction = new UIPrpLclaimGradeAction();
		
		/*--- ���ε��˹���,����ϵͳû��,˫�˲鿴ʱ�����쳣---
		//�����Զ�������۸�
		PrpLclaimGradeDto prpLclaimGradeDto1 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLE_CUSTOM_COMP_PRICE");
		//�����Զ�������۸�
		PrpLclaimGradeDto prpLclaimGradeDto2 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_CUSTOM_COMP_PRICE");
		//����ȫ������۸�
		PrpLclaimGradeDto prpLclaimGradeDto3 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_ALL_COMP_PRICE");
		
		if (prpLclaimGradeDto1 == null)
			prpLclaimGradeDto1 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto2 == null)
			prpLclaimGradeDto2 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto3 == null)
			prpLclaimGradeDto3 = new PrpLclaimGradeDto();

		httpServletRequest.setAttribute("prpLclaimGradeDto1",
				prpLclaimGradeDto1);
		httpServletRequest.setAttribute("prpLclaimGradeDto2",
				prpLclaimGradeDto2);
		httpServletRequest.setAttribute("prpLclaimGradeDto3",
				prpLclaimGradeDto3);
		*/

		String insureCarFlag = "0";
		if (prpLverifyLossDto.getLossItemCode().equals("1"))
			insureCarFlag = "1";
		prpLverifyLossDto.setInsureCarFlag(insureCarFlag);

		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(), prpLverifyLossDto
						.getRegistNo());
		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLverifyLossDto);
		changeCodeToName(httpServletRequest, verifyLossDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest);
		
		if(riskCode!= null && ("0310".equals(riskCode)||"0312".equals(riskCode) || riskcodeStr.indexOf(riskCode)>0 ))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();//�嵥�б�
			BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
			if (editType.equals("EDIT") || editType.equals("SHOW"))
			{
				String nodetype = httpServletRequest.getParameter("nodeType");
				String condition = " registno='" + registNo + "' and nodetype='" + nodetype + "' ";
			    prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition);
				
				
			}
			httpServletRequest.setAttribute("prplCompensateHouseDtoList",prplCompensateHouseDtoList);
		}	
		
		
		

		//���ö�����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("verifyLossDto", verifyLossDto);

		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections
				.getVerifyPriceOpinionList());
		//Reason:���Ӻ������       
		httpServletRequest.setAttribute("verifyOpinionList", ICollections
				.getVerifyOpinionList());

		//���ø����ӱ���Ϣ������
		setSubInfo(httpServletRequest, verifyLossDto);

		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}

	/**
	 * ��ȡ��������Ӧ�ı������鿱��Ϣ
	 * @param httpServletRequest
	 * @param registNo ������
	 * @throws Exception
	 */
	private void getRegistCheckInfo(HttpServletRequest httpServletRequest, String registNo)
			throws Exception {
		// ������Ϣ
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDtoTemp = blPrpLregistFacade.findByPrimaryKey(registNo);
		if(prpLregistDtoTemp == null) {
			throw new Exception("û�в�ѯ����ǰ��������Ӧ�ı�����Ϣ��");
		}
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp
				.getDamageStartHour());
		prpLregistDtoTemp.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp);
		
		// �鿱��Ϣ
		UIPrpLcheckAction uiPrpLcheckAction = new UIPrpLcheckAction();
		PrpLcheckDto prpLcheckDtoTemp = uiPrpLcheckAction.findByPrimaryKey(registNo);
		if (prpLcheckDtoTemp == null) {
			prpLcheckDtoTemp = new PrpLcheckDto();
		}
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp);
	}

	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo ҵ�����
	 * @param editType �༭����
	 * @throws Exception
	 */
	public void certainLossDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType) throws Exception {
		//�����ţ����������Ϊ0������Ϊ1��2��3��4��5�ȳ������
		//System.err.println("RegistNo:" +registNo);
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		String riskCode = httpServletRequest.getParameter("riskCode");

		//�ǳ��գ�lossItemCodeĬ��Ϊ1,�����Ϳ����������вƲ�����ϸ��ɾ��������
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if (riskCode != null && !strRiskType.equals(("D"))) {
			lossItemCode = "1";
		}
		
		//��89��ģ������� start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
        String riskcodeStr = "";//��89��ģ������ֵ��ַ���
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //��89��ģ�������  end===
        
		if("0310".equals(riskCode)||"0312".equals(riskCode) || riskcodeStr.indexOf(riskCode)>0 )
		{
			lossItemCode = "-1";
		}
		//System.err.println("lossItemCode:" +lossItemCode);
		//System.err.println("strRiskType:" +strRiskType);
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		VerifyLossDto verifyLossDto = uiVerifyLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode, nodeType);
		//���ݲ�ѯ�������������ݣ���PrpLverifyLossDto��ֵ
		PrpLverifyLossDto prpLverifyLossDto = null;
		prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();
		if (prpLverifyLossDto == null) {
			prpLverifyLossDto = new PrpLverifyLossDto();
		}
		
		// ��������嵥

		if (verifyLossDto.getPrpLrepairFeeDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLrepairFeeDtoList().size(); i++) {
				PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto) verifyLossDto
						.getPrpLrepairFeeDtoList().get(i);
				if (prpLrepairFeeDto.getVeriManHour() == 0)
					prpLrepairFeeDto.setVeriManHour(prpLrepairFeeDto
							.getManHour());
				if (prpLrepairFeeDto.getVeriManUnitPrice() == 0)
					prpLrepairFeeDto.setVeriManUnitPrice(prpLrepairFeeDto
							.getManHourUnitPrice());
				if (prpLrepairFeeDto.getVeriMaterialFee() == 0)
					prpLrepairFeeDto.setVeriMaterialFee(prpLrepairFeeDto
							.getMaterialFee());
				if (prpLrepairFeeDto.getVeriSumLoss() == 0)
					prpLrepairFeeDto.setVeriSumLoss(prpLrepairFeeDto
							.getSumDefLoss());
				if(prpLrepairFeeDto.getVeriRemark() == null || prpLrepairFeeDto.getVeriRemark().equals(""))
					prpLrepairFeeDto.setVeriRemark(prpLrepairFeeDto.getRemark());
			}
		}
		// �����嵥
		if (verifyLossDto.getPrpLcomponentDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLcomponentDtoList().size(); i++) {
				PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto) verifyLossDto
						.getPrpLcomponentDtoList().get(i);
				if(prpLcomponentDto.getVeriQuantity() == 0)
					prpLcomponentDto.setVeriQuantity(prpLcomponentDto.getQuantity());
				if(prpLcomponentDto.getVeriManHourFee() == 0)
					prpLcomponentDto.setVeriManHourFee(prpLcomponentDto.getManHourFee());
				if(prpLcomponentDto.getVeriMaterFee() == 0)
					prpLcomponentDto.setVeriMaterFee(prpLcomponentDto.getMaterialFee());
				if(prpLcomponentDto.getSumVeriLoss() == 0)
					prpLcomponentDto.setSumVeriLoss(prpLcomponentDto.getSumDefLoss());
				if(prpLcomponentDto.getVerpCompPrice() == 0){
					prpLcomponentDto.setVerpCompPrice(prpLcomponentDto.getMaterialFee());
				}
				if(prpLcomponentDto.getVeriRemark() == null || prpLcomponentDto.getVeriRemark().equals(""))
					prpLcomponentDto.setVeriRemark(prpLcomponentDto.getRemark());
			}
		}
		// �Ʋ���ʧ�嵥
		if (verifyLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpropDtoList().size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) verifyLossDto
						.getPrpLpropDtoList().get(i);
				if(prpLpropDto.getVeriSumLoss() == 0)
					prpLpropDto.setVeriSumLoss(prpLpropDto.getSumLoss());
				if(prpLpropDto.getVeriSumReject() == 0)
					prpLpropDto.setVeriSumReject(prpLpropDto.getSumReject());
				if(prpLpropDto.getVeriSumDefLoss() == 0)
					prpLpropDto.setVeriSumDefLoss(prpLpropDto.getSumDefLoss());
				if(prpLpropDto.getVeriRemark() == null || prpLpropDto.getVeriRemark().equals(""))
					prpLpropDto.setVeriRemark(prpLpropDto.getRemark());
				if("ADD".equals(editType) ||  riskcodeStr.indexOf(riskCode)>0 ){
					prpLpropDto.setVeriSumLoss(prpLpropDto.getSumLoss());
					prpLpropDto.setVeriSumReject(prpLpropDto.getSumReject());
					prpLpropDto.setVeriSumDefLoss(prpLpropDto.getSumDefLoss());
				}
			}
		}
		// ������ʧ�嵥
		if (verifyLossDto.getPrpLpersonDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpersonDtoList().size(); i++) {
				PrpLpersonDto prpLpersonDto = (PrpLpersonDto) verifyLossDto
						.getPrpLpersonDtoList().get(i);
				if(prpLpersonDto.getVeriSumLoss() == 0)
					prpLpersonDto.setVeriSumLoss(prpLpersonDto.getSumLoss());
				if(prpLpersonDto.getSumReject() == 0)
					prpLpersonDto.setVeriSumReject(prpLpersonDto.getSumReject());
				if(prpLpersonDto.getVeriSumLoss() == 0)
					prpLpersonDto.setVeriSumDefLoss(prpLpersonDto.getSumDefLoss());
				if(prpLpersonDto.getVeriUnitLoss() == 0)
					prpLpersonDto.setVeriUnitLoss(prpLpersonDto.getUnitLoss());
				if(prpLpersonDto.getVeriQuantity() == 0)
					prpLpersonDto.setVeriQuantity(prpLpersonDto.getQuantity());
				if(prpLpersonDto.getVeriRemark() == null || prpLpersonDto.getVeriRemark().equals(""))
					prpLpersonDto.setVeriRemark(prpLpersonDto.getRemark());
			}
		}
		prpLverifyLossDto.setStatus("1");
		// ��ȡ��ʧ������Ϣ���������𡢺���ҳ���ϵ����⳵����Ϣ
		getLossCarInfo(registNo, lossItemCode, verifyLossDto);
		// ��ȡ������ǿ�ձ�����Ϣ
		getRelatCompelPolicyDto(httpServletRequest, registNo);
		// ��ȡ�������鿱��Ϣ
		getRegistCheckInfo(httpServletRequest, registNo);

		// У���Ƿ��Ѿ�����ѯ�ۣ�����Ѿ�����ѯ�ۣ�������˼�Ա��Ȩ���ύ
		/*
		 * if (!prpLverifyLossDto.getStatus().equals("4")) { String msg = "";
		 * msg = this.checkVerpo(swfLogFlowID, swfLogLogNo, lossItemCode);
		 * prpLverifyLossDto.setVerifPriceOuterMsg(msg); }
		 */
		//��ѯ�˼�Ȩ��       
		/*String taskCode = AppConfig.get("sysconst.TASKCODE_LPHJ"); //�������Ϊ�˼�
		UIPrpLclaimGradeAction uiPrpLclaimGradeAction = new UIPrpLclaimGradeAction();

		//�����Զ�������۸�
		PrpLclaimGradeDto prpLclaimGradeDto1 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLE_CUSTOM_COMP_PRICE");
		//�����Զ�������۸�
		PrpLclaimGradeDto prpLclaimGradeDto2 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_CUSTOM_COMP_PRICE");
		//����ȫ������۸�
		PrpLclaimGradeDto prpLclaimGradeDto3 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_ALL_COMP_PRICE");

		if (prpLclaimGradeDto1 == null)
			prpLclaimGradeDto1 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto2 == null)
			prpLclaimGradeDto2 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto3 == null)
			prpLclaimGradeDto3 = new PrpLclaimGradeDto();

		httpServletRequest.setAttribute("prpLclaimGradeDto1",
				prpLclaimGradeDto1);
		httpServletRequest.setAttribute("prpLclaimGradeDto2",
				prpLclaimGradeDto2);
		httpServletRequest.setAttribute("prpLclaimGradeDto3",
				prpLclaimGradeDto3);
		*/

		//�����������:��Ԫ�汾���ã�Leave by yehuiquan��
		prpLverifyLossDto.setClauseType("none");
		
		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(), prpLverifyLossDto
						.getRegistNo());
		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLverifyLossDto);
		changeCodeToName(httpServletRequest, verifyLossDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest);
		
		//���ö�����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("verifyLossDto", verifyLossDto);
		if (nodeType.equals("verip")) {
			httpServletRequest.setAttribute("verifyPriceOpinionList",
					ICollections.getVerifyPriceOpinionList());
		} else if (nodeType.equals("verpo")) {
			httpServletRequest.setAttribute("verifyPriceOpinionList",
					ICollections.getVerifyPriceVerpoOpinionList());
		}
		
		if(riskCode!= null && ("0310".equals(riskCode)||"0312".equals(riskCode)))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();//�嵥�б�
			BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
			if (editType.equals("ADD"))
			{
				if ("verip".equals(httpServletRequest
						.getParameter("nodeType")))
				{
					String condition1 = " registno='" + registNo + "' and nodetype='propc' ";
					prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition1);
				
				}
				
				if ("propv".equals(httpServletRequest
						.getParameter("nodeType")))
				{
					String condition1 = " registno='" + registNo + "' and nodetype='verip' ";
					prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition1);
				
				}
				
			}
			
			httpServletRequest.setAttribute("prplCompensateHouseDtoList",prplCompensateHouseDtoList);
		}	

		// �������
		httpServletRequest.setAttribute("verifyOpinionList", ICollections
				.getVerifyOpinionList());
		//���ø����ӱ���Ϣ������
		verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest, verifyLossDto);

		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}

	/**
	 * ��ȡ������ǿ�ձ�����Ϣ
	 * @param httpServletRequest
	 * @param registNo ������
	 * @throws Exception
	 */
	private void getRelatCompelPolicyDto(HttpServletRequest httpServletRequest, String registNo)
			throws Exception {
		BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new BLPrpLRegistRPolicyFacade();
		String riskCode = (String)httpServletRequest.getSession().getAttribute("RiskCode");
		//���Ϊ��ҵ����ת�ɶ�Ӧ�Ľ�ǿ�����ֺ�
		if("0506".equals(riskCode)){
			riskCode = "0507";
		}else if("0576".equals(riskCode)){
			riskCode = "0577";
		}else if("0586".equals(riskCode)){
			riskCode = "0587";
		}
		List rPolicyDtoList = (List) blPrpLRegistRPolicyFacade.findByConditions("registNo = '"
				+ registNo + "' and validstatus = '1' and riskcode = '"+riskCode+"'");
		if (rPolicyDtoList.size() > 1) {
			httpServletRequest.setAttribute("prpLregistRPolicyNo", (PrpLRegistRPolicyDto)rPolicyDtoList.get(0));
		}
	}

	/**
	 * ��ȡ��ʧ������Ϣ���������𡢺���ҳ���ϵ����⳵����Ϣ
	 * @param registNo ������
	 * @param lossItemCode ������
	 * @param verifyLossDto �������
	 * @throws Exception
	 */
	private void getLossCarInfo(String registNo, String lossItemCode, VerifyLossDto verifyLossDto)
			throws Exception {
		// ��ȡ���⳵����Ϣ�������ͺš����������
		BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
		List thirdPartyDtoList = (List) blPrpLthirdPartyFacade.findByConditions("registNo = '"
				+ registNo + "' and serialno = '" + lossItemCode + "'");
		PrpLthirdPartyDto prpLthirdParty1Dto = null;
		if(thirdPartyDtoList.size() > 0) {
			prpLthirdParty1Dto = (PrpLthirdPartyDto)thirdPartyDtoList.get(0);
		}
		if (verifyLossDto.getPrpLcarLossDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLcarLossDtoList().size(); i++) {
				PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto) verifyLossDto
						.getPrpLcarLossDtoList().get(i);
				prpLcarLossDto.setLicenseColorCode(prpLthirdParty1Dto.getLicenseColorCode());
				prpLcarLossDto.setCarKindCode(prpLthirdParty1Dto.getCarKindCode());
				prpLcarLossDto.setModelCode(prpLthirdParty1Dto.getModelCode());
				prpLcarLossDto.setBrandName(prpLthirdParty1Dto.getBrandName());
				prpLcarLossDto.setEngineNo(prpLthirdParty1Dto.getEngineNo());
				prpLcarLossDto.setFrameNo(prpLthirdParty1Dto.getFrameNo());
				prpLcarLossDto.setVINNo(prpLthirdParty1Dto.getVINNo());
				prpLcarLossDto.setInsureCarFlag(prpLthirdParty1Dto.getInsureCarFlag());
				prpLcarLossDto.setInsureComCode(prpLthirdParty1Dto.getInsureComCode());
				prpLcarLossDto.setInsureComName(prpLthirdParty1Dto.getInsureComName());
			}
		}
	}


	/**
	 * ��鱾���˼��Ƿ�������ѯ��
	 * @param swfLogDtoCurrent SwfLogDto ��Ҫ�����Ľڵ����
	 * @throws Exception
	 */
	public String checkVerpo(String swfLogFlowID, String swfLogLogNo,
			String lossItemCode) throws Exception {
		//Ŀǰֻ���ó��˼��Ƿ��Ѿ�ѯ�۹���ֻ��Ե�������

		String nodeType = "";
		String conditions = "";
		String msg = "";

		Collection swfLogList = new ArrayList();
		SwfLogDto swfLogDtoCurrent = null;

		int logNo = Integer.parseInt(DataUtils.nullToZero(swfLogLogNo));

		if (swfLogFlowID == null || logNo < 1)
			return msg;

		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		swfLogDtoCurrent = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,
				logNo);
		if (swfLogDtoCurrent == null)
			return msg;

		nodeType = swfLogDtoCurrent.getNodeType();

		if (nodeType.equals("verip")) //�˼ۼ���Ƿ��Ѿ�����ѯ��
		{
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and nodeType='verpo'  and  lossItemCode = '"
					+ lossItemCode + "' ";
		}

		swfLogList = uiWorkFlowAction.findNodesByConditions(conditions);
		if (swfLogList != null && swfLogList.size() > 0) {
			msg = "�����Ѿ�����ѯ��";
		}
		return msg;
	}

	/**
	 * �����ⰸ�źͱ����Ų�ѯ������Ϣ
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo      �ⰸ��
	 * @throws Exception
	 */
	public void setPrpLverifyLossDtoToView(
			HttpServletRequest httpServletRequest, String registNo,
			String policyNo) throws Exception {
		//caseNO,policyNo,claimNo
		logger.info("��LIKE �������Ż�...");
		//��������ı����ţ����������SQL where �Ӿ�
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		String conditions = "";
		conditions = " registNo = '" + registNo.trim()
				+ "' and policyNo = '" + policyNo.trim() + "'";
		//��ѯ������Ϣ
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		//�õ����ж���������Ϣ
		Collection verifyLossList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		verifyLossList = (Collection) uiVerifyLossAction
				.findByConditions(conditions);
		System.out.println("end search,please waiting for result...");
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLverifyLossDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
	}

	//add by zhaolu 20060803 start
	public void setPrpLverifyLossDtoToView(
			HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto, int pageNo, int recordPerPage)
			throws Exception {

		//caseNO,policyNo,claimNo
		//��������ı����ţ����������SQL where �Ӿ�
		String nodeType = workFlowQueryDto.getConSignType();
		//�ж���ȡί�����ͻ���ȡnodeType
		if (nodeType == null || nodeType.equals("")) {
			nodeType = workFlowQueryDto.getNodeType();
		}

		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		//String nodeType = StringUtils.rightTrim(workFlowQueryDto.getNodeType());
		String conditions = " 1=1 ";
		//���������ũ�ձ�ʶ
		conditions = conditions + " and (b.BusinessNo in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='"+nodeType+"') ";
		conditions = conditions + " or b.BusinessNo in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='"+nodeType+"')) ";
		conditions = conditions
				+ StringConvert.convertString("a.registNo", registNo,
						workFlowQueryDto.getRegistNoSign());
		//       conditions = conditions + StringConvert.convertString("a.policyNo",policyNo,workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:ǿ����ѯ
		conditions = conditions
				+ StringConvert.convertString("d.policyNo", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9

		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			//ƴ����״̬(�������Ѵ���)����			
			int newIndex = 0;
			String statusTemp = "";
			while(true){
				if((newIndex = status.trim().indexOf(",")) != -1){
					statusTemp += status.trim().substring(0,newIndex) + "','";
					status =status.trim().substring(newIndex + 1,status.trim().length());					
				}else{
					break;
				}
			}
			status = statusTemp + status;			
			conditions = conditions + " AND b.status in ('" + status + "') ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
        
		
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060816 end
		//Modify by caopeng add begin 20051215 Reason:ʹÿ�ֺ����ѯֻ�ܲ�ѯ�����������
		String strNodeType = httpServletRequest.getParameter("nodeType");
		if (strNodeType != null) {
			strNodeType = StringUtils.rightTrim(strNodeType);
		}
		String strLossItemCode = "";
		//add by zhaolu 20060809 start
		String strSerialNo = "";
		//add by zhaolu 20060809 start
		//modify by zhaolu 20060809 start
		if ("verif".equals(strNodeType) || "certa".equals(strNodeType)) { //����
			strLossItemCode = " AND (a.lossitemcode >'0' or a.lossitemcode = '-2')";
			strSerialNo = " AND (b.serialNo>0 or b.serialNo = -2)";
		} else if ("veriw".equals(strNodeType)) { //����
			strLossItemCode = " AND a.lossitemcode ='0' ";
		    strSerialNo = " AND b.serialNo = 0";
		} else if ("propv".equals(strNodeType)) { //�Ʋ�
			strLossItemCode = " AND a.lossitemcode ='-1' ";
			strSerialNo = " AND b.serialNo = -1";
		}
		 //modify by zhaolu 20060809 end
		
		// ��session��ȡ��ƶ/�󻧱�־
		String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				conditions = conditions+ " and a.policyno in (select policyno from prpcmain where policytype in ('H24', 'I28', 'E2', 'Q2'))";
			}
			if(strHPflag.equals("Retaol")) {
				conditions = conditions+ " and a.policyno in (select policyno from prpcmain where policytype in ('H23', 'I27', 'E1', 'Q1'))";
			}	
		}

		String condition = httpServletRequest.getParameter("condition");
		if (condition != null && condition.trim().length() > 0) {
			conditions = condition;
		}
		conditions = conditions + strLossItemCode+strSerialNo;
		UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
		//Modify by caopeng add end 20051215

		//��ѯ������Ϣ
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();

		//�õ����ж���������Ϣ
		ArrayList verifyLossList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		PageRecord pageRecord = (PageRecord) uiVerifyLossAction
				.findByCondition(conditions, nodeType, pageNo, recordPerPage);
		verifyLossList = (ArrayList) pageRecord.getResult();
		//verifyLossList  = (ArrayList)uiVerifyLossAction.findByQueryConditions(conditions,nodeType) ;
		System.out.println("end search,please waiting for result...");

		TurnPageDto turnPageDto = new TurnPageDto();
		//��ѯ������һҳ�Ľṹ�� 
		turnPageDto.setResultList(verifyLossList);
		//��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		//һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		//��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		//�����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		//��������
		turnPageDto.setCondition(conditions);

		for (int i = 0; i < verifyLossList.size(); i++) {
			PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto) verifyLossList
					.get(i);
			//Modify by caopeng add begin 20051215 Reason:ʹÿ�ֺ����ѯֻ�ܲ�ѯ�����������
			ClaimStatusDto claimStatusDto = uiClaimStatusAction
					.findByPrimaryKey(prpLverifyLossDto.getRegistNo(), httpServletRequest.getParameter("nodeType"),
							Integer.parseInt(prpLverifyLossDto
									.getLossItemCode()));
			if (claimStatusDto != null) {
				PrpLclaimStatusDto prpLclaimStatusDto = claimStatusDto
						.getPrpLclaimStatusDto();
				if (prpLclaimStatusDto != null) {
					prpLverifyLossDto.setStatus(prpLclaimStatusDto.getStatus());
				} else {
					prpLverifyLossDto.setStatus("0");
				}

			}
			//Modify by caopeng add end 20051215

		}
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		prpLverifyLossDto.setTurnPageDto(turnPageDto);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLverifyLossDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
	}

	//add by zhaoul 20060803 end

	/**
	 * �Ѻ��𰸼���ѯ
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo      �ⰸ��
	 * @throws Exception
	 */
	public void getUnderWriteVerifyLossList(
			HttpServletRequest httpServletRequest) throws Exception {
		//caseNO,policyNo,claimNo
		//��������ı����ţ����������SQL where �Ӿ�
		String conditions = "";
		conditions = " underWriteFlag = '1' ";
		//��ѯ������Ϣ
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		//�õ����ж���������Ϣ
		Collection verifyLossList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		verifyLossList = (Collection) uiVerifyLossAction
				.findByConditions(conditions);
		System.out.println("end search,please waiting for result...");
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLverifyLossDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
	}

	/**
	 * ��ȡѡ�����б���е���������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest)
			throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(11)�õ��������Ƶ��б� ---
		Collection FeeTypeCodeList = new ArrayList();
		FeeTypeCodeList.add(new LabelValueBean("�����", "01"));
		FeeTypeCodeList.add(new LabelValueBean("���Ϸ�", "02"));
		httpServletRequest.setAttribute("FeeTypeCodeList", FeeTypeCodeList);

		//(2)�õ����������б�
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
						"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);

	}

	/**
	 * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLverifyLossDto prpLverifyLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//������ɫת��
		String licenseColorCodeCode = prpLverifyLossDto.getLicenseColorcode();
		String licenseColor = uiCodeAction.translateCodeCode("LicenseColor",
				licenseColorCodeCode, true);
		prpLverifyLossDto.setLicenseColor(licenseColor);
		//��������ת��
		String carKindCode = prpLverifyLossDto.getCarKindCode();
		String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode,
				true);
		prpLverifyLossDto.setCarKind(carKind);
		//�������Ƶ�ת��
		String clauseType = prpLverifyLossDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLverifyLossDto.setClauseName(clauseName);

	}

	/**
	 * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// �洢�Ѿ���������ձ����ƣ����ٷ������ݿ�Ĵ���
		Map kindNameMap = new HashMap();
		PrpLpropDto prpLpropDto = null;
		if (verifyLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpropDtoList().size(); i++) {
				prpLpropDto = (PrpLpropDto) verifyLossDto.getPrpLpropDtoList()
						.get(i);
				if (prpLpropDto.getFeeTypeCode().trim().equals("01")) {
					prpLpropDto.setFeeTypeName("�����");
				} else if (prpLpropDto.getFeeTypeCode().trim().equals("02")) {
					prpLpropDto.setFeeTypeName("���Ϸ�");
				}
				
				String riskCode = prpLpropDto.getRiskCode();
				String kindCode = prpLpropDto.getKindCode();
				// ȡ���ձ�����
				String kindName = getKindName(kindNameMap, riskCode, kindCode); 
				prpLpropDto.setKindName(kindName);
				//add by dongkun ����ҳ����ʾ�ұ�����
				prpLpropDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpropDto
						.getCurrency(), true));
			}
		}

		PrpLcarLossDto prpLcarLossDto = null;
		if (verifyLossDto.getPrpLcarLossDtoList() != null) {
			String carKindName = "";
			for (int i = 0; i < verifyLossDto.getPrpLcarLossDtoList().size(); i++) {
				prpLcarLossDto = (PrpLcarLossDto) verifyLossDto
						.getPrpLcarLossDtoList().get(i);
				//�Ƿ�Ϊ����������ת��
				if (prpLcarLossDto.getInsureCarFlag().trim().equals("1")) {
					prpLcarLossDto.setInsureCarFlagName("��");
				} else {
					prpLcarLossDto.setInsureCarFlagName("��");
				}
				//��������(����������Ϣ����Ҫÿ��ѭ�������룬һ����ֻ��һ������)
				if("".equals(carKindName)) {
					carKindName = uiCodeAction.translateCodeCode("CarKind", prpLcarLossDto
							.getCarKindCode(), true);
				}
				prpLcarLossDto.setCarKindName(carKindName);
			}
		}

		if (verifyLossDto.getPrpLrepairFeeDtoList() != null) {
			PrpLrepairFeeDto prpLrepairFeeDto = null;
			//�ձ�����ת��
			Iterator iterator = verifyLossDto.getPrpLrepairFeeDtoList()
					.iterator();
			while (iterator.hasNext()) {
				prpLrepairFeeDto = (PrpLrepairFeeDto) iterator.next();
				prpLrepairFeeDto.setHandlerName(uiCodeAction.translateUserCode(
						prpLrepairFeeDto.getHandlerCode(), true));
				
				String riskCode = prpLrepairFeeDto.getRiskCode();
				String kindCode = prpLrepairFeeDto.getKindCode();
				// ȡ���ձ�����
				String kindName = getKindName(kindNameMap, riskCode, kindCode);
				prpLrepairFeeDto.setKindName(kindName);
				prpLrepairFeeDto.setRepairTypeName(uiCodeAction
						.translateCodeCode("RepairType", prpLrepairFeeDto
								.getRepairType(), true));
			}
		}

		if (verifyLossDto.getPrpLcomponentDtoList() != null) {
			PrpLcomponentDto prpLcomponentDto = null;
			//�ձ�����ת��
			Iterator iterator1 = verifyLossDto.getPrpLcomponentDtoList()
					.iterator();
			while (iterator1.hasNext()) {
				prpLcomponentDto = (PrpLcomponentDto) iterator1.next();
				prpLcomponentDto.setHandlerName(uiCodeAction.translateUserCode(
						prpLcomponentDto.getHandlerCode(), true));
				String riskCode = prpLcomponentDto.getRiskCode();
				String kindCode = prpLcomponentDto.getKindCode();
				// ȡ���ձ�����
				String kindName = getKindName(kindNameMap, riskCode, kindCode); 
				prpLcomponentDto.setKindName(kindName);
			}
		}
		if (verifyLossDto.getPrpLpersonDtoList() != null) {
			PrpLpersonDto prpLpersonDto = null;
			//�ձ�����ת��
			Iterator iterator2 = verifyLossDto.getPrpLpersonDtoList()
					.iterator();
			while (iterator2.hasNext()) {
				prpLpersonDto = (PrpLpersonDto) iterator2.next();
				String riskCode = prpLpersonDto.getRiskCode();
				String kindCode = prpLpersonDto.getKindCode();
				// ȡ���ձ�����
				String kindName = getKindName(kindNameMap, riskCode, kindCode); 
				prpLpersonDto.setKindName(kindName);
				
				prpLpersonDto.setAreaName(uiCodeAction.translateCodeCode(
						"DamageDistrict", prpLpersonDto.getAreaCode(), true));
				if (prpLpersonDto.getFixedIncomeFlag().trim().equals("1")) {
					prpLpersonDto.setFixedIncomeFlagName("�й̶�����");
				} else if (prpLpersonDto.getFixedIncomeFlag().trim()
						.equals("2")) {
					prpLpersonDto.setFixedIncomeFlagName("�޹̶�����");
				} else if (prpLpersonDto.getFixedIncomeFlag().trim()
						.equals("3")) {
					prpLpersonDto.setFixedIncomeFlagName("������");
				} else if (prpLpersonDto.getFixedIncomeFlag().trim()
						.equals("4")) {
					prpLpersonDto.setFixedIncomeFlagName("���Ͷ�����");
				} else {
					prpLpersonDto.setFixedIncomeFlagName("����");
				}
				if (prpLpersonDto.getPayPersonType().trim().equals("1")) {
					prpLpersonDto.setPayPersonTypeName("��");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("2")) {
					prpLpersonDto.setPayPersonTypeName("��������");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("3")) {
					prpLpersonDto.setPayPersonTypeName("������");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("4")) {
					prpLpersonDto.setPayPersonTypeName("��");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("5")) {
					prpLpersonDto.setPayPersonTypeName("��");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("6")) {
					prpLpersonDto.setPayPersonTypeName("�μ��¹ʴ�����Ա");
				} else {
					prpLpersonDto.setPayPersonTypeName("����");
				}
			}
		}
	}

	/**
	 * ��ȡ�ձ�����
	 * @param kindNameMap �ձ����ƻ���
	 * @param riskCode ���ִ���
	 * @param kindCode �ձ����
	 * @return �ձ�����
	 * @throws Exception
	 */
	private String getKindName(Map kindNameMap, String riskCode, String kindCode) throws Exception {
		String kindName = "";
		if ("BZ".equals(kindCode)) {
			if("0506".equals(riskCode)){
				riskCode = "0507";
			}else if("0576".equals(riskCode)){
				riskCode = "0577";
			}else if("0586".equals(riskCode)){
				riskCode = "0587";
			}
		}
		if (kindNameMap.containsKey(kindCode)) {
			kindName = kindNameMap.get(kindCode).toString();
		} else {
			kindName = new UICodeAction().translateKindCode(riskCode, kindCode, true);
			kindNameMap.put(kindCode, kindName);
		}
		return kindName;
	}

	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
	 * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
	 * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public VerifyLossDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		VerifyLossDto verifyLossDto = new VerifyLossDto();
		return verifyLossDto;
	}

	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param verifyLossDto ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
	}

	/**
	 * ����verifyLossDto�еĸ��ӱ��ڵ���Ϣ������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param verifyLossDto    �����������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
		//Reason:�õ����������б�
		String strRiskCode = BusinessRuleUtil.getRiskCode(verifyLossDto
				.getPrpLverifyLossDto().getRegistNo(), "RegistNo");
		UICodeAction uiCodeAction = new UICodeAction();
		Collection repairTypes = uiCodeAction.getCodeType("RepairType",
				strRiskCode);
		httpServletRequest.setAttribute("repairTypes", repairTypes);
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());

		//����������Ϣ����˵�������б�׼������
		ArrayList<PrpLverifyLossExtDto> arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd = new PrpLverifyLossExtDto();
		if (nodeType.equals("verip")) {
			prpLverifyLossExtDtoAdd.setTitle("ͬ�ⱨ��");
		}
		if (nodeType.equals("verif")) {
			prpLverifyLossExtDtoAdd.setTitle("ͬ�ⶨ��");
		}
		//�Ʋ�����ʱ���涨���������ϸ��Ϣ
		if("propv".equals(nodeType)){
			prpLverifyLossExtDtoAdd.setTitle("ͬ�ⶨ��");
		}

		if (nodeType.equals("backc")) {
			prpLverifyLossExtDtoAdd.setTitle("ͨ������");
		}
		prpLverifyLossExtDtoAdd.setRegistNo(verifyLossDto
				.getPrpLverifyLossDto().getRegistNo());
		prpLverifyLossExtDtoAdd.setRiskCode(verifyLossDto
				.getPrpLverifyLossDto().getRiskCode());
		prpLverifyLossExtDtoAdd.setInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLverifyLossExtDtoAdd.setInputHour(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_SECOND).getHour()
				+ "ʱ"
				+ new DateTime(DateTime.current().toString(),
						DateTime.YEAR_TO_SECOND).getMinute() + "��");
		prpLverifyLossExtDto.setRegistNo(verifyLossDto.getPrpLverifyLossDto()
				.getRegistNo());
		prpLverifyLossExtDto.setRiskCode(verifyLossDto.getPrpLverifyLossDto()
				.getRiskCode());
		arrayListVerifyLossExt = verifyLossDto.getPrpLverifyLossExtDtoList();
		//add by dongkun �ҵ���ǰ���е����serialno��Ӧ�Ľڵ㣬��� swflog�ڵ�״̬Ϊ0,�������ŵ�����ڵ�� nodetype=propc/certa && nodestatus=4 ������һ����
		PrpLverifyLossExtDto prpLverifyLossExtDtoMax = new PrpLverifyLossExtDto();//���serialno��Ӧ������ڵ�
		int maxSerialNo = 0;
		if(arrayListVerifyLossExt != null){
			for(int i=0;i<arrayListVerifyLossExt.size();i++){
				PrpLverifyLossExtDto prpLverifyLossExtDto1 = arrayListVerifyLossExt.get(i);
				if(prpLverifyLossExtDto1.getSerialNo() > maxSerialNo){
					maxSerialNo = prpLverifyLossExtDto1.getSerialNo();
					prpLverifyLossExtDtoMax = prpLverifyLossExtDto1;
				}
			}
		}
		if (arrayListVerifyLossExt == null) {
			arrayListVerifyLossExt = new ArrayList();
		}
		prpLverifyLossExtDtoAdd.setSerialNo(maxSerialNo + 1);
		String status = httpServletRequest.getParameter("status");
		String riskCode = httpServletRequest.getParameter("riskCode");
//		if("0102".equals(riskCode)){
//			if ( "0".equals(status) && "propc".equals(prpLverifyLossExtDtoMax.getNodeType())&& "4".equals(prpLverifyLossExtDtoMax.getStatus()) ){
//				arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
//			}
//		}else{
			if ( "0".equals(status)){
				arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
			}
//		}
		prpLverifyLossExtDto.setVerifyLossExtList(arrayListVerifyLossExt);
		httpServletRequest.setAttribute("prpLverifyLossExtDto",
				prpLverifyLossExtDto);

		//��������Ϣ����˵�������б�׼������
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(verifyLossDto.getPrpLverifyLossDto()
				.getRegistNo());
		prpLregistExtDto.setRiskCode(verifyLossDto.getPrpLverifyLossDto()
				.getRiskCode());
		arrayListRegistExt = verifyLossDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		//��������嵥�����б�׼������
		ArrayList arrayList1 = new ArrayList();
		PrpLrepairFeeDto prpLrepairFeeDto = new PrpLrepairFeeDto();
		arrayList1 = verifyLossDto.getPrpLrepairFeeDtoList();
		prpLrepairFeeDto.setRepairFeeList(arrayList1);
		httpServletRequest.setAttribute("prpLrepairFeeDto", prpLrepairFeeDto);

		//������Ŀ�嵥�����б�׼������
		ArrayList arrayList2 = new ArrayList();
		PrpLcomponentDto prpLcomponentDto = new PrpLcomponentDto();
		arrayList2 = verifyLossDto.getPrpLcomponentDtoList();
		prpLcomponentDto.setComponentList(arrayList2);
		httpServletRequest.setAttribute("prpLcomponentDto", prpLcomponentDto);

		//��Ա������ϸ��Ϣ�嵥�����б�׼������
		Collection arrayList3 = new ArrayList();
		PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		arrayList3 = verifyLossDto.getPrpLpersonDtoList();
		prpLpersonDto.setPersonList(arrayList3);
		httpServletRequest.setAttribute("prpLpersonDto", prpLpersonDto);

		//�Ʋ��˶�����ϸ�嵥�����б�׼������
		Collection arrayList4 = new ArrayList();
		PrpLpropDto prpLpropDto = new PrpLpropDto();
		arrayList4 = verifyLossDto.getPrpLpropDtoList();
		prpLpropDto.setPropList(arrayList4);
		httpServletRequest.setAttribute("prpLpropDto", prpLpropDto);
		//������Ϣ�� �����б�׼������
		Collection list5 = new ArrayList();
		PrpLpersonWoundDto prpLpersonWoundDto = new PrpLpersonWoundDto();
		list5 = verifyLossDto.getPrpLpersonWoundDtoList();
		prpLpersonWoundDto.setWoundList(list5);
		httpServletRequest.setAttribute("prpLpersonWoundDto",
				prpLpersonWoundDto);

	}

	/**
	 * ����Ƿ��ѳ��ⰸ������
	 * ����ֵ   true �ѳ�        false δ��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */
	public boolean checkCompensate(HttpServletRequest httpServletRequest,
			String registNo) throws Exception {
		//���ݱ�������ȡ�ö�Ӧ���ⰸ����
		UICodeAction uiCodeAction = new UICodeAction();
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		//ȡ������������Ϣ
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction
				.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * �����ⰸ��,������,����״̬�����ƺ��룬����ʱ���ѯ������Ϣ
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo      �ⰸ��
	 * @throws Exception
	 * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ��ڵ����ͣ�����״̬������ʱ���ѯ����
	 */

	public void setPrpLverifyLossDtoToView(
			HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//caseNO,policyNo,claimNo
		//��������ı����ţ����������SQL where �Ӿ�
		String nodeType = workFlowQueryDto.getConSignType();
		//�ж���ȡί�����ͻ���ȡnodeType
		if (nodeType == null || nodeType.equals("")) {
			nodeType = workFlowQueryDto.getNodeType();
		}
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		//String nodeType = StringUtils.rightTrim(workFlowQueryDto.getNodeType());
		String conditions = " 1=1 ";
		//���������ũ�ձ�ʶ
		conditions = conditions + " and (b.BusinessNo in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='verip') ";
		conditions = conditions + " or b.BusinessNo in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='verip')) ";
		conditions = conditions
				+ StringConvert.convertString("a.registNo", registNo,
						workFlowQueryDto.getRegistNoSign());
		//       conditions = conditions + StringConvert.convertString("a.policyNo",policyNo,workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:ǿ����ѯ
		conditions = conditions
				+ StringConvert.convertString("d.policyNo", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9

		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "') ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
       
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions
				+ uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify b zhaolu 20060816 end
		
		// ��session��ȡ��ƶ/�󻧱�־
		String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				conditions = conditions+ " and a.policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
			}
			if(strHPflag.equals("Retaol")) {
				conditions = conditions+ " and a.policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
			}	
		}
		
		
		//Modify by caopeng add begin 20051215 Reason:ʹÿ�ֺ����ѯֻ�ܲ�ѯ�����������
		String strNodeType = httpServletRequest.getParameter("nodeType");
		if (strNodeType != null) {
			strNodeType = StringUtils.rightTrim(strNodeType);
		}
		String strLossItemCode = "";
		if ("verif".equals(strNodeType) || "certa".equals(strNodeType)) { //����
			strLossItemCode = " AND a.lossitemcode >0 ";
		} else if ("veriw".equals(strNodeType)) { //����
			strLossItemCode = " AND a.lossitemcode =0 ";
		} else if ("propv".equals(strNodeType)) { //�Ʋ�
			strLossItemCode = " AND a.lossitemcode =-1 ";
		}
		conditions = conditions + strLossItemCode;
		UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
		//Modify by caopeng add end 20051215

		//��ѯ������Ϣ
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();

		//�õ����ж���������Ϣ
		ArrayList verifyLossList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		verifyLossList = (ArrayList) uiVerifyLossAction.findByQueryConditions(
				conditions, nodeType);
		System.out.println("end search,please waiting for result...");
		for (int i = 0; i < verifyLossList.size(); i++) {
			PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto) verifyLossList
					.get(i);
			//Modify by caopeng add begin 20051215 Reason:ʹÿ�ֺ����ѯֻ�ܲ�ѯ�����������
			ClaimStatusDto claimStatusDto = uiClaimStatusAction
					.findByPrimaryKey(prpLverifyLossDto.getRegistNo(), "verif",
							Integer.parseInt(prpLverifyLossDto
									.getLossItemCode()));
			if (claimStatusDto != null) {
				PrpLclaimStatusDto prpLclaimStatusDto = claimStatusDto
						.getPrpLclaimStatusDto();
				if (prpLclaimStatusDto != null) {
					prpLverifyLossDto.setStatus(prpLclaimStatusDto.getStatus());
				} else {
					prpLverifyLossDto.setStatus("0");
				}

			}
			//Modify by caopeng add end 20051215
			System.out.println("--------itemkindo-----" + i + "|"
					+ prpLverifyLossDto.getLossItemCode());
		}
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLverifyLossDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
	}

	/**
	 * ��ѯ��������������ѡ��Ľڵ�����
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest)
			throws Exception {
		String modelNo = httpServletRequest.getParameter("modelNo"); //ģ���
		String nodeNo = httpServletRequest.getParameter("nodeNo"); //�ڵ��
		int nextNodeNo = 0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		if (modelNo != null && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo, nodeNo);
			if (pathList.iterator().hasNext()) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}
}
