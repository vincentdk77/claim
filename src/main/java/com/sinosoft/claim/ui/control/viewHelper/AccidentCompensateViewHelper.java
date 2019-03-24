package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainSchema;

import org.apache.commons.beanutils.PropertyUtils;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpLacciCheckFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;
import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.claim.dto.domain.PrpDlimitDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIAcciCheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIExchAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIRiskUnitAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.blsvr.cb.BLPrpCvirturlItem;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.reins.out.bl.facade.BLFcoRepolicyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.MoneyUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utiall.dbsvr.DBPrpDcode;
import com.sinosoft.utiall.schema.PrpDcodeSchema;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.ChgData;
import com.sinosoft.utility.string.Str;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;

/**
 * @author wangli TODO To change the template for this generated type comment go
 *         to Window - Preferences - Java - Code Style - Code Templates
 */
public class AccidentCompensateViewHelper extends CompensateViewHelper {

	List prpLctextlist = new ArrayList();

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public AccidentCompensateViewHelper() {
	}

	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��дʵ�ⵥʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ�� ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * 
	 * @param httpServletRequest
	 * @return compensateDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */

	public CompensateDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		CompensateDto compensateDto = new CompensateDto();
		return compensateDto;
	}

	/**
	 * ��дʵ��ҳ�漰��ѯʵ��request������.
	 * ��дʵ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception {
		// �õ�request��PrpLcompensateForm������ʾ
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();
		// ���⽡����Ĭ���ǣ����ա��Ʋ��ա������ա�������Ĭ�Ϸ�

		if (prpLcompensateDto.getFinallyFlag().trim().equals("")) {
			// modify by ��Ŀ�� ������ 27�����޸�Ϊ07
			if (prpLcompensateDto.getClassCode().equals("27"))
				prpLcompensateDto.setFinallyFlag("1");
			else
				prpLcompensateDto.setFinallyFlag("0");
		}
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}

	/**
	 * �ǳ��� ���µ�����������ʱ���ʼ���⸶��ĵ���Ϣ
	 * 
	 * @throws Exception
	 */
	public ArrayList initPropLossItem(HttpServletRequest httpServletRequest,
			String claimNo, ClaimDto claimDto) throws Exception {
		ArrayList prpLclaimLossList = new ArrayList();
		ArrayList prpLlossListTemp = new ArrayList();
		PrpLlossDto prpLlossDtoTemp = new PrpLlossDto();
		PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
		prpLclaimLossList = claimDto.getPrpLclaimLossDtoList();
		int serialNo = 1;
		if (prpLclaimLossList != null) {
			Map tempMap = new HashMap();
			for (Iterator lossIt = prpLclaimLossList.iterator(); lossIt
					.hasNext();) {
				prpLclaimLossDto = (PrpLclaimLossDto) lossIt.next();
				prpLlossDtoTemp = new PrpLlossDto();
				String itemKindNoFlag = String.valueOf(prpLclaimLossDto
						.getItemKindNo());
				String itemCondition = "policyNo ='"
						+ claimDto.getPrpLclaimDto().getPolicyNo()
						+ "' and itemKindNo="
						+ prpLclaimLossDto.getItemKindNo() + " and riskCode='"
						+ prpLclaimLossDto.getRiskCode() + "'";
				PrpCitemKindDto itemKindDto = new PrpCitemKindDto();
				ArrayList itemKindList = (ArrayList) new BLPrpCitemKindFacade()
						.findByConditions(itemCondition);
				for (Iterator it = itemKindList.iterator(); it.hasNext();) {
					itemKindDto = (PrpCitemKindDto) it.next();
				}
				if (tempMap.get(itemKindNoFlag) != null) {
					int prpLlossDtoTempNo = Integer.parseInt((String) tempMap
							.get(itemKindNoFlag));
					prpLlossDtoTemp.setKindCode(prpLclaimLossDto.getKindCode());
					prpLlossDtoTemp.setRiskCode(prpLclaimLossDto.getRiskCode());
					UICodeAction uiCode = new UICodeAction();
					String kindName = uiCode.translateKindCode(prpLclaimLossDto
							.getRiskCode(), prpLclaimLossDto.getKindCode(),
							true);
					prpLlossDtoTemp.setKindName(kindName);
					prpLlossDtoTemp = (PrpLlossDto) prpLlossListTemp
							.get(prpLlossDtoTempNo);
					prpLlossDtoTemp.setSumLoss(prpLlossDtoTemp.getSumLoss()
							+ prpLclaimLossDto.getKindLoss());
					prpLlossDtoTemp.setSumRest(prpLlossDtoTemp.getSumRest()
							+ prpLclaimLossDto.getKindRest());
					prpLlossDtoTemp.setSumRealPay(prpLlossDtoTemp.getSumLoss()
							- prpLlossDtoTemp.getSumRest());
				} else {

					prpLlossDtoTemp.setKindCode(prpLclaimLossDto.getKindCode());
					UICodeAction uiCode = new UICodeAction();

					String kindName = uiCode.translateKindCode(prpLclaimLossDto
							.getRiskCode(), prpLclaimLossDto.getKindCode(),
							true);

					String currencyName = uiCode.translateCurrencyCode(
							prpLclaimLossDto.getCurrency(), true);
					prpLlossDtoTemp.setSerialNo(serialNo);
					prpLlossDtoTemp
							.setLossName(itemKindDto.getItemDetailName());
					prpLlossDtoTemp.setRiskCode(prpLclaimLossDto.getRiskCode());
					prpLlossDtoTemp.setKindName(kindName);
					prpLlossDtoTemp.setItemCode(prpLclaimLossDto.getItemCode());
					prpLlossDtoTemp.setItemKindNo(prpLclaimLossDto
							.getItemKindNo());
					prpLlossDtoTemp.setClaimRate(100.00);
					if ("ZH01".equals(claimDto.getPrpLclaimDto().getRiskCode())
							|| "ZH02".equals(claimDto.getPrpLclaimDto()
									.getRiskCode())
							|| "1528".equals(claimDto.getPrpLclaimDto()
									.getRiskCode())) {
						double amount = 0.0;
						BLPrpCvirturlItem blPrpCvirturlItem = new BLPrpCvirturlItem();
						String isWhere = " policyNo = '"
								+ claimDto.getPrpLclaimDto().getPolicyNo()
								+ "'" + " and riskCode = '"
								+ claimDto.getPrpLclaimDto().getRiskCode()
								+ "'" + " and kindCode = '"
								+ prpLclaimLossDto.getKindCode() + "'"
								+ " and familyNo = '"
								+ prpLclaimLossDto.getFamilyNo() + "'";
						blPrpCvirturlItem.query(isWhere);
						if (blPrpCvirturlItem.getSize() > 0) {
							prpLlossDtoTemp.setAmount(Double
									.parseDouble(blPrpCvirturlItem.getArr(0)
											.getAmount()));
						}
					} else {
						prpLlossDtoTemp.setAmount(itemKindDto.getAmount());
					}

					prpLlossDtoTemp.setFlag(String.valueOf(serialNo++));
					prpLlossDtoTemp
							.setCurrency1(prpLclaimLossDto.getCurrency());
					prpLlossDtoTemp.setCurrency1Name(currencyName);
					prpLlossDtoTemp
							.setCurrency2(prpLclaimLossDto.getCurrency());
					prpLlossDtoTemp.setCurrency2Name(currencyName);
					prpLlossDtoTemp
							.setCurrency3(prpLclaimLossDto.getCurrency());
					prpLlossDtoTemp.setCurrency3Name(currencyName);
					prpLlossDtoTemp
							.setCurrency4(prpLclaimLossDto.getCurrency());
					prpLlossDtoTemp.setCurrency4Name(currencyName);
					prpLlossDtoTemp.setSumLoss(prpLclaimLossDto.getKindLoss());
					prpLlossDtoTemp.setSumRest(prpLclaimLossDto.getKindRest());
					prpLlossDtoTemp.setSumRealPay(prpLclaimLossDto
							.getKindLoss()
							- prpLclaimLossDto.getKindRest());

					prpLlossDtoTemp.setItemKindNo((int) prpLclaimLossDto
							.getItemKindNo());
					prpLlossDtoTemp.setFamilyNo(prpLclaimLossDto.getFamilyNo());
					prpLlossDtoTemp.setFamilyName(prpLclaimLossDto
							.getFamilyName());
					prpLlossDtoTemp.setFamilyNoZH(prpLclaimLossDto
							.getFamilyNoZH());
					if ("1528".equals(claimDto.getPrpLclaimDto().getRiskCode())) {
						prpLlossDtoTemp.setLicenseNo(prpLclaimLossDto
								.getLicenseNo());
						prpLlossDtoTemp.setBrandCode(prpLclaimLossDto
								.getItemDetailName());
					}
					if("0313".equals(claimDto.getPrpLclaimDto().getRiskCode())){
						if(prpLclaimLossDto.getImei()!=null && !"".equals(prpLclaimLossDto.getImei())){
							prpLlossDtoTemp.setImei(prpLclaimLossDto.getImei());
						}
					}

					prpLlossListTemp.add(prpLlossDtoTemp);

				}
				if (!"ZH01".equals(claimDto.getPrpLclaimDto().getRiskCode())
						&& !"ZH02".equals(claimDto.getPrpLclaimDto()
								.getRiskCode())
						&& !"1528".equals(claimDto.getPrpLclaimDto()
								.getRiskCode())
						&& !"ZH03".equals(claimDto.getPrpLclaimDto()
								.getRiskCode())) {
					tempMap.put(
							String.valueOf(prpLlossDtoTemp.getItemKindNo()),
							String.valueOf(prpLlossDtoTemp.getSerialNo() - 1));
				}
			}
		}
		return prpLlossListTemp;
		// add by caoshengbin end
	}

	/**
	 * �ǳ��� ���µ�����������ʱ���ʼ���⸶��ĵ���Ϣ
	 * 
	 * @throws Exception
	 */
	public ArrayList initPersonLossItem(HttpServletRequest httpServletRequest,
			String claimNo, ClaimDto claimDto) throws Exception {
		return new ArrayList();
		// add by caoshengbin end
	}

	/**
	 * �ǳ��� ���µ�����������ʱ���ʼ���⸶��ĵ���Ϣ
	 * 
	 * @throws Exception
	 */
	public ArrayList initPropLossItemAgri(String claimNo, ClaimDto claimDto)
			throws Exception {
		// add by caoshengbin 2007-05-24 start
		BLPrpLpropFacade prpLProp = new BLPrpLpropFacade();
		Collection prpLPropList = new ArrayList();
		ArrayList prpLlossListTemp = new ArrayList();
		PrpLpropDto prpLpropDto = new PrpLpropDto();
		PrpLlossDto prpLlossDtoTemp = new PrpLlossDto();
		// �����ŵ��Ĵ���������ŵ���amountҪ��prpcvirturlitem��ȥȡֵ
		GroupProposalService groupProposalService = new GroupProposalService();
		String strRiskCode = claimDto.getPrpLclaimDto().getRiskCode();
		boolean isVirturlItemRisk = groupProposalService
				.isGroupProposal(strRiskCode);

		String conditions = "claimNo = '" + claimNo + "' and registNo = '"
				+ claimDto.getPrpLclaimDto().getRegistNo() + "'";
		prpLPropList = prpLProp.findByConditions(conditions);
		int serialNo = 1;
		if (prpLPropList != null) {
			Map tempMap = new HashMap();
			for (Iterator propIt = prpLPropList.iterator(); propIt.hasNext();) {
				prpLpropDto = (PrpLpropDto) propIt.next();
				prpLlossDtoTemp = new PrpLlossDto();
				String itemKindNoFlag = String.valueOf(prpLpropDto
						.getFamilyName());
				ArrayList itemKindList = new ArrayList();
				String strItemCode = new String();
				strItemCode = prpLpropDto.getLossItemCode();
				String itemCondition = "policyNo ='"
						+ claimDto.getPrpLclaimDto().getPolicyNo()
						+ "' AND itemKindNo=" + prpLpropDto.getItemKindNo()
						+ " AND riskCode='" + prpLpropDto.getRiskCode() + "'";
				String strItemDetailName = "";
				double dbAmount = 0.0;
				if (isVirturlItemRisk) {
					PrpCvirturlItemSchema itemKindDto = new PrpCvirturlItemSchema();
					itemKindList = (ArrayList) new BLPrpCitemKindFacade()
							.findVirturlItemByConditions(itemCondition);
					for (Iterator it = itemKindList.iterator(); it.hasNext();) {
						itemKindDto = (PrpCvirturlItemSchema) it.next();
					}
					strItemDetailName = itemKindDto.getItemDetailName();
					dbAmount = Double.parseDouble(ChgData
							.chgStrZero(itemKindDto.getAmount()));
				} else {
					PrpCitemKindDto itemKindDto = new PrpCitemKindDto();
					itemKindList = (ArrayList) new BLPrpCitemKindFacade()
							.findByConditions(itemCondition);
					for (Iterator it = itemKindList.iterator(); it.hasNext();) {
						itemKindDto = (PrpCitemKindDto) it.next();
					}
					strItemDetailName = itemKindDto.getItemDetailName();
					dbAmount = itemKindDto.getAmount();
				}

				ArrayList acciPersonList = claimDto
						.getPrplacciBenPersonDtoList();
				for (Iterator it = acciPersonList.iterator(); it.hasNext();) {
					PrpLacciPersonDto acciPersonDto = new PrpLacciPersonDto();
					acciPersonDto = (PrpLacciPersonDto) it.next();
					if (!prpLpropDto.getRiskCode().equals("3202")) {
						if (acciPersonDto.getFamilyNo() == prpLpropDto
								.getFamilyNo()) {
							serialNo = acciPersonDto.getSerialNo();
						}
					} else {
						if (acciPersonDto.getAddress().equals(
								prpLpropDto.getFamilyName())) {
							serialNo = acciPersonDto.getSerialNo();
						}
					}

				}
				if (tempMap.get(itemKindNoFlag) != null) {
					int prpLlossDtoTempNo = Integer.parseInt((String) tempMap
							.get(itemKindNoFlag));
					prpLlossDtoTemp.setKindCode(prpLpropDto.getKindCode());
					prpLlossDtoTemp.setRiskCode(prpLpropDto.getRiskCode());
					UICodeAction uiCode = new UICodeAction();
					String kindName = uiCode.translateKindCode(prpLpropDto
							.getRiskCode(), prpLpropDto.getKindCode(), true);
					prpLlossDtoTemp.setKindName(kindName);
					prpLlossDtoTemp.setItemCode(prpLpropDto.getItemCode());
					// prpLlossDtoTemp.setLossName(strItemDetailName);
					if ("3204".equals(claimDto.getPrpLclaimDto().getRiskCode())) {
						prpLlossDtoTemp.setLossName(prpLpropDto
								.getLossItemName());
						// System.err.println(prpLpropDto.getLossItemName());
					} else {
						prpLlossDtoTemp.setLossName(strItemDetailName);
					}
					prpLlossDtoTemp = (PrpLlossDto) prpLlossListTemp
							.get(prpLlossDtoTempNo);
					prpLlossDtoTemp.setSumLoss(prpLlossDtoTemp.getSumLoss()
							+ prpLpropDto.getSumLoss());
					prpLlossDtoTemp.setSumRest(prpLlossDtoTemp.getSumRest()
							+ prpLpropDto.getSumReject());
					prpLlossDtoTemp.setSumRealPay(prpLlossDtoTemp.getSumLoss()
							- prpLlossDtoTemp.getSumRest());
					// prpLlossDtoTemp.setAmount(dbAmount);
					if ("3204".equals(claimDto.getPrpLclaimDto().getRiskCode())) {
						PrpCitemKindDto itemKindDto = new PrpCitemKindDto();
						itemKindList = (ArrayList) new BLPrpCitemKindFacade()
								.findByConditions(itemCondition);
						System.err.println(itemCondition);
						for (Iterator it = itemKindList.iterator(); it
								.hasNext();) {
							itemKindDto = (PrpCitemKindDto) it.next();
							if (itemKindDto.getKindCode().equals(
									prpLpropDto.getKindCode())
									&& itemKindDto.getItemCode().equals(
											prpLpropDto.getItemCode()))
								prpLlossDtoTemp.setAmount(itemKindDto
										.getAmount());
						}
						System.err.println(itemKindList.size() + "saassa");

						// strItemDetailName = itemKindDto.getItemDetailName();
						// dbAmount = itemKindDto.getAmount();
						// prpLlossDtoTemp.setAmount(prpLpropDto.get);
						// System.err.println(prpLpropDto.getLossItemName());
					} else {
						prpLlossDtoTemp.setAmount(dbAmount);
					}
					prpLlossDtoTemp.setPolicyNo(prpLpropDto.getPolicyNo());
					prpLlossDtoTemp.setFamilyNo(prpLpropDto.getFamilyNo());
				} else {

					prpLlossDtoTemp.setKindCode(prpLpropDto.getKindCode());
					UICodeAction uiCode = new UICodeAction();
					String kindName = uiCode.translateKindCode(prpLpropDto
							.getRiskCode(), prpLpropDto.getKindCode(), true);
					String currencyName = uiCode.translateCurrencyCode(
							prpLpropDto.getCurrency(), true);
					prpLlossDtoTemp.setSerialNo(serialNo);
					// prpLlossDtoTemp.setLossName(strItemDetailName);
					if ("3204".equals(claimDto.getPrpLclaimDto().getRiskCode())) {
						prpLlossDtoTemp.setLossName(prpLpropDto
								.getLossItemName());
						// System.err.println(prpLpropDto.getLossItemName());
					} else {
						prpLlossDtoTemp.setLossName(strItemDetailName);
					}
					prpLlossDtoTemp.setRiskCode(prpLpropDto.getRiskCode());
					prpLlossDtoTemp.setKindName(kindName);
					prpLlossDtoTemp.setItemCode(prpLpropDto.getItemCode());
					prpLlossDtoTemp.setItemKindNo(prpLpropDto.getItemKindNo());
					prpLlossDtoTemp.setClaimRate(100.00);
					if ("3204".equals(claimDto.getPrpLclaimDto().getRiskCode())) {
						PrpCitemKindDto itemKindDto = new PrpCitemKindDto();
						itemKindList = (ArrayList) new BLPrpCitemKindFacade()
								.findByConditions(itemCondition);
						System.err.println(itemCondition);
						for (Iterator it = itemKindList.iterator(); it
								.hasNext();) {
							itemKindDto = (PrpCitemKindDto) it.next();
							if (itemKindDto.getKindCode().equals(
									prpLpropDto.getKindCode())
									&& itemKindDto.getItemCode().equals(
											prpLpropDto.getItemCode())) {
								System.err.println(itemKindDto.getAmount());
								prpLlossDtoTemp.setAmount(itemKindDto
										.getAmount());
							}
						}
						System.err.println(itemKindList.size() + "saassa");
						// strItemDetailName = itemKindDto.getItemDetailName();
						// dbAmount = itemKindDto.getAmount();
						// prpLlossDtoTemp.setAmount(prpLpropDto.get);
						// System.err.println(prpLpropDto.getLossItemName());
					} else {
						prpLlossDtoTemp.setAmount(dbAmount);
					}
					// prpLlossDtoTemp.setAmount(dbAmount);
					prpLlossDtoTemp.setFlag(String.valueOf(serialNo++));
					prpLlossDtoTemp.setCurrency1(prpLpropDto.getCurrency());
					prpLlossDtoTemp.setCurrency1Name(currencyName);
					prpLlossDtoTemp.setCurrency2(prpLpropDto.getCurrency());
					prpLlossDtoTemp.setCurrency2Name(currencyName);
					prpLlossDtoTemp.setCurrency3(prpLpropDto.getCurrency());
					prpLlossDtoTemp.setCurrency3Name(currencyName);
					prpLlossDtoTemp.setCurrency4(prpLpropDto.getCurrency());
					prpLlossDtoTemp.setCurrency4Name(currencyName);
					prpLlossDtoTemp.setSumLoss(prpLpropDto.getSumLoss());
					prpLlossDtoTemp.setSumRest(prpLpropDto.getSumReject());
					prpLlossDtoTemp.setSumRealPay(prpLpropDto.getSumLoss()
							- prpLpropDto.getSumReject());

					prpLlossDtoTemp.setItemKindNo((int) prpLpropDto
							.getItemKindNo());

					prpLlossDtoTemp.setPolicyNo(prpLpropDto.getPolicyNo());
					prpLlossDtoTemp.setFamilyNo(prpLpropDto.getFamilyNo());
					prpLlossListTemp.add(prpLlossDtoTemp);

				}
				tempMap.put(String.valueOf(prpLlossDtoTemp.getItemKindNo()),
						String.valueOf(prpLlossDtoTemp.getSerialNo() - 1));
			}
		}

		return prpLlossListTemp;
		// add by caoshengbin end
	}

	/**
	 * ũ�մ�������������������Ϣ
	 * 
	 * @param httpServletRequest
	 * @param claimNo
	 *            ������
	 * @param claimDto
	 *            ������Ϣ
	 * @return ���𻷽�¼�������ֻ���Ϣ
	 * @throws Exception
	 */
	public ArrayList initPersonLossItemAgri(String claimNo, String registNo)
			throws Exception {
		ArrayList prpLagriPersonDtoList = new ArrayList();
		BLPrpLpropFacade prpLProp = new BLPrpLpropFacade();
		String conditions = "claimNo = '" + claimNo + "' and registNo = '"
				+ registNo + "'";
		List prpLPropList = (List) prpLProp.findByConditions(conditions);
		if (prpLPropList != null) {
			for (int i = 0; i < prpLPropList.size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) prpLPropList.get(i);
				PrpLacciPersonDto prpLacciPersonDto = new PrpLacciPersonDto();
				prpLacciPersonDto.setFamilyNo(prpLpropDto.getFamilyNo());
				prpLacciPersonDto.setAcciName(prpLpropDto.getFamilyName());
				prpLacciPersonDto.setSerialNo(prpLpropDto.getSerialNo());
				prpLagriPersonDtoList.add(prpLacciPersonDto);
				System.err.println("XXXXXX");
			}
		}
		return prpLagriPersonDtoList;
	}

	/**
	 * ũ�մ�������������������Ϣ
	 * 
	 * @param httpServletRequest
	 * @param claimNo
	 *            ������
	 * @param claimDto
	 *            ������Ϣ
	 * @return ���𻷽�¼�������ֻ���Ϣ
	 * @throws Exception
	 */
	public ArrayList initPersonLossItemAgri3204(String claimNo, String registNo)
			throws Exception {
		ArrayList prpLagriPersonDtoList = new ArrayList();
		BLPrpLpropFacade prpLProp = new BLPrpLpropFacade();
		String conditions = "claimNo = '" + claimNo + "' and registNo = '"
				+ registNo + "'";
		List prpLPropList = (List) prpLProp.findByConditions(conditions);
		if (prpLPropList != null) {
			for (int i = 0; i < 1; i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) prpLPropList.get(i);
				PrpLacciPersonDto prpLacciPersonDto = new PrpLacciPersonDto();
				prpLacciPersonDto.setFamilyNo(prpLpropDto.getFamilyNo());
				prpLacciPersonDto.setAcciName(prpLpropDto.getFamilyName());
				prpLacciPersonDto.setSerialNo(prpLpropDto.getSerialNo());
				prpLagriPersonDtoList.add(prpLacciPersonDto);
				// System.err.println("XXXXXX");
			}
		}
		return prpLagriPersonDtoList;
	}

	/**
	 * ��дʵ��ҳ�漰��ѯʵ��request������.
	 * ��дʵ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param PrpLcompensateDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void claimDtoToView(HttpServletRequest httpServletRequest,
			String claimNo, String editType) throws Exception {
		// �����ⰸ��־
		String caseType = httpServletRequest.getParameter("caseType");// �����ⰸ��־
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		// ����claimDto�����й����ձ���ձ�����
		setClaimLossKindName(claimDto);
		// ���¹��ߺ�������������Ϣѹ��ҳ����
		ArrayList prplacciBenPersonDtoList = claimDto
				.getPrplacciBenPersonDtoList();
		ArrayList prplacciPersonDtoList = claimDto.getPrpLacciPersonDtoList();
		PrpLacciPersonDto prpLacciBenPersonDto = new PrpLacciPersonDto();
		prpLacciBenPersonDto.setPrpLacciBenPersonList(prplacciBenPersonDtoList);
		if (prpLacciBenPersonDto.getPrpLagriPersonList() == null) {
			prpLacciBenPersonDto
					.setPrpLagriPersonList(prplacciBenPersonDtoList);
		}
		prpLacciBenPersonDto.setPrpLacciPersonList(prplacciPersonDtoList); // ����������ģ��
		httpServletRequest.setAttribute("prpLacciPersonDto",
				prpLacciBenPersonDto);
		httpServletRequest.setAttribute("prpLclaimDto", claimDto
				.getPrpLclaimDto());

		// modify by wangwei add start 2005-06-10
		// ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);
		// modify by wangwei add end 2005-06-10

		// add by huangyunzhong 20051128 �õ��Ƿ��ؿ��ⰸ
		int recount = 0;
		double sumDamageInsured = 0.00;
		double dbSumPaid = 0.00;
		double dbLossNumber = 0.00;
		double dbSumDutyPaid = 0.00;
		ReCaseDto reCaseDto = new ReCaseDto();
		PrpLrecaseDto prpLrecaseDto = new PrpLrecaseDto();
		// ��ѯ�ؿ��ⰸ��Ϣ
		UIRecaseAction uiRecaseAction = new UIRecaseAction();
		reCaseDto = uiRecaseAction.findByPrimaryKey(claimNo, 1);
		prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
		if (prpLrecaseDto != null && prpLrecaseDto.getClaimNo() != null
				&& prpLrecaseDto.getClaimNo().trim().length() > 0) {
			recount = 1;
			String strSql = "claimNo = '" + claimNo
					+ "' and underwriteflag in ('1','3')";
			UICompensateAction uiCompensateAction = new UICompensateAction();
			ArrayList compensateDtoList = (ArrayList) uiCompensateAction
					.findByClaimNo(strSql);
			for (int index = 0; index < compensateDtoList.size(); index++) {
				PrpLcompensateDto prplcompensateDto = (PrpLcompensateDto) compensateDtoList
						.get(index);
				sumDamageInsured += prplcompensateDto.getDamageInsured();
				dbSumPaid += prplcompensateDto.getSumPaid();
				dbLossNumber += prplcompensateDto.getLossesNumber();
				dbSumDutyPaid += prplcompensateDto.getSumDutyPaid();
			}
		}
		httpServletRequest.setAttribute("dbSumPaid", dbSumPaid);
		httpServletRequest.setAttribute("sumDamageInsured", sumDamageInsured);
		httpServletRequest.setAttribute("dbLossNumber", dbLossNumber);
		httpServletRequest.setAttribute("recaseFlag", String.valueOf(recount));
		httpServletRequest.setAttribute("dbSumDutyPaid", dbSumDutyPaid);
		// add end huangyunzhong 20051128

		// ������������Ϣ
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();

		// ����������úϼ�ֵ-----------------------------------------------------------
		String riskCode = claimDto.getPrpLclaimDto().getRiskCode();
		String prplregistNo = claimDto.getPrpLclaimDto().getRegistNo();
		BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = bLPrpLregistFacade
				.findByPrimaryKey(prplregistNo);
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

		String taskCode = SysConfig.getProperty("FamilySplittingFlag", "claim");
		if (taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();// �����嵥�б�
			if (prplregistNo != null) {
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
						.getPrpLCompensateEarDtos(prplregistNo, "claim",
								prplregistNo);
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList",
					prplCompensateEarDtoList);// ���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag", "true");// ���ö�����嵥�б�
		}

		if ("0310".equals(riskCode) || "0312".equals(riskCode)) {
			ArrayList prplCompensateHouseDtoList = new ArrayList();
			if (prplregistNo != null) {
				String nodetype = "claim";
				BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
				String condition = " registno='" + prplregistNo
						+ "' and nodetype='" + nodetype + "'";
				prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade
						.findByConditions(condition);
			}
			httpServletRequest.setAttribute("prplCompensateHouseDtoList",
					prplCompensateHouseDtoList);
		}
		double sumCheckFee = 0.00;
		String conditionshere = " registNo='"
				+ claimDto.getPrpLclaimDto().getRegistNo() + "'";
		PrpLacciCheckDto prplacciCheckDto = new PrpLacciCheckDto();
		UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
		Collection prpLacciCheckDtoList = uiAcciCheckAction
				.findByConditionsAcciCheck(conditionshere);
		Iterator it = prpLacciCheckDtoList.iterator();
		while (it.hasNext()) {
			prplacciCheckDto = (PrpLacciCheckDto) it.next();
			sumCheckFee = sumCheckFee + prplacciCheckDto.getCheckFee();
		}

		prpLcompensateDto.setSumCheckFee(sumCheckFee);
		prpLcompensateDto.setCaseType(claimDto.getPrpLclaimDto().getCaseType());

		// �����ⰸ��־
		if (caseType != null) {
			prpLcompensateDto.setCaseType(caseType);

		} else {
			// ���������̣������⸶
			prpLcompensateDto.setCaseType("2");
		}

		prpLcompensateDto.setCompensateNo(" ");
		prpLcompensateDto.setEditType(editType.trim());
		prpLcompensateDto.setLFlag(claimDto.getPrpLclaimDto().getLFlag());
		prpLcompensateDto.setCaseNo(claimDto.getPrpLclaimDto().getCaseNo());
		prpLcompensateDto.setTimes(1);
		prpLcompensateDto.setEscapeFlag(claimDto.getPrpLclaimDto()
				.getEscapeFlag());
		prpLcompensateDto.setIndemnityDuty(claimDto.getPrpLclaimDto()
				.getIndemnityDuty());
		prpLcompensateDto.setClassCode(claimDto.getPrpLclaimDto()
				.getClassCode());
		prpLcompensateDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
		prpLcompensateDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
		prpLcompensateDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
		prpLcompensateDto.setDeductCond(httpServletRequest
				.getParameter("DeductibleTerm"));
		prpLcompensateDto.setPreserveDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto()
				.getIndemnityDutyRate());
		prpLcompensateDto.setIndemnityDuty(claimDto.getPrpLclaimDto()
				.getIndemnityDuty());
		prpLcompensateDto.setBusinessType1(claimDto.getPrpLclaimDto()
				.getBusinessType1());
		prpLcompensateDto.setUnderWriteFlag("0");
		// add by qinyongli start 2005-7-25
		prpLcompensateDto.setBusinessNature(claimDto.getPrpLclaimDto()
				.getBusinessNature());
		prpLcompensateDto.setDamageCode(claimDto.getPrpLclaimDto()
				.getDamageCode());
		prpLcompensateDto.setDamageName(claimDto.getPrpLclaimDto()
				.getDamageName());
		prpLcompensateDto.setUnderWriteFlag("0");
		prpLcompensateDto
				.setSumPaidAll(claimDto.getPrpLclaimDto().getSumPaid());

		prpLcompensateDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
		UICodeAction uiCodeAction = new UICodeAction();
		String currencyName = uiCodeAction.translateCurrencyCode(
				prpLcompensateDto.getCurrency(), true);
		prpLcompensateDto.setCurrencyName(currencyName);
		prpLcompensateDto.setMakeCom(claimDto.getPrpLclaimDto().getMakeCom());
		prpLcompensateDto.setComCode(claimDto.getPrpLclaimDto().getComCode());
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute(
				"user");
		prpLcompensateDto.setHandlerCode(user.getUserCode());
		prpLcompensateDto.setHandlerName(user.getUserName());
		prpLcompensateDto.setHandler1Code(claimDto.getPrpLclaimDto()
				.getHandler1Code());
		prpLcompensateDto.setStatisticsYM(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setOperatorCode(claimDto.getPrpLclaimDto()
				.getOperatorCode());
		prpLcompensateDto.setInputDate(claimDto.getPrpLclaimDto()
				.getInputDate());
		prpLcompensateDto.setUnderWriteEndDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setRemark(claimDto.getPrpLclaimDto().getRemark());
		prpLcompensateDto.setFlag(claimDto.getPrpLclaimDto().getFlag());
		// ����ʵ�������״̬Ϊ �°����Ǽ� (δ��������)
		prpLcompensateDto.setStatus("1");
		prpLcompensateDto.setInsuredCode(claimDto.getPrpLclaimDto()
				.getInsuredCode());
		prpLcompensateDto.setInsuredName(claimDto.getPrpLclaimDto()
				.getInsuredName());
		prpLcompensateDto.setStartDate(claimDto.getPrpLclaimDto()
				.getStartDate());
		prpLcompensateDto.setStartHour(claimDto.getPrpLclaimDto()
				.getStartHour());
		prpLcompensateDto.setEndDate(claimDto.getPrpLclaimDto().getEndDate());
		prpLcompensateDto.setEndHour(claimDto.getPrpLclaimDto().getEndHour());
		prpLcompensateDto.setClauseType(claimDto.getPrpLclaimDto()
				.getClauseType());

		prpLcompensateDto.setDamageStartDate(claimDto.getPrpLclaimDto()
				.getDamageStartDate());
		// prpLcompensateDto.setDamageStartHour(claimDto.getPrpLclaimDto().getDamageStartHour());
		String timeTemp = StringConvert.toStandardTime(claimDto
				.getPrpLclaimDto().getDamageStartHour());
		prpLcompensateDto.setDamageStartHour(timeTemp.substring(0, 2));
		prpLcompensateDto.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLcompensateDto.setDamageAddressType(claimDto.getPrpLclaimDto()
				.getDamageAddressType());
		prpLcompensateDto.setDamageAddress(claimDto.getPrpLclaimDto()
				.getDamageAddress());
		prpLcompensateDto.setSumAmount(claimDto.getPrpLclaimDto()
				.getSumAmount());
		prpLcompensateDto.setSumPremium(claimDto.getPrpLclaimDto()
				.getSumPremium());
		prpLcompensateDto.setSumClaim(claimDto.getPrpLclaimDto().getSumClaim());
		// ��ӱ����� 2005-08-07
		prpLcompensateDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
		/** add by wuzheng ����ҽ������ ������ͳ��ר�� 20080601 */
		prpLcompensateDto.setMedicalType(claimDto.getPrpLclaimDto()
				.getMedicalType());

		// ��ѯԤ����Ϣ
		double sumPrePaid = 0.0;
		double preSosMedicFee = 0.0;
		if (recount < 1) {
			UIPrepayAction uiPrePayAction = new UIPrepayAction();
			PrpLprepayDto prpLprepayDto = null;
			String underWriteFlag = "";
			ArrayList PrepayList = (ArrayList) uiPrePayAction
					.findByConditions("claimNo = '"
							+ claimDto.getPrpLclaimDto().getClaimNo() + "'");
			if (PrepayList != null) {
				for (Iterator its = PrepayList.iterator(); its.hasNext();) {
					prpLprepayDto = new PrpLprepayDto();
					prpLprepayDto = (PrpLprepayDto) its.next();
					underWriteFlag = prpLprepayDto.getUnderWriteFlag();
					if (underWriteFlag.equals("1")
							|| underWriteFlag.equals("3")) {
						sumPrePaid += prpLprepayDto.getSumPrePaid();
						preSosMedicFee += prpLprepayDto.getSumPreChargePaid();
					} else {
						throw new UserException(1, 3, "123", "����δ����ͨ����Ԥ�ⰸ��");
					}
				}
			}
		}

		prpLcompensateDto.setSumPrePaid(sumPrePaid);
		prpLcompensateDto.setSumPreChargeAmount(preSosMedicFee);
		// ��Ӱ������� 2005-08-01
		uiCodeAction = new UICodeAction();
		prpLcompensateDto.setCaseType(claimDto.getPrpLclaimDto().getCaseType());
		prpLcompensateDto.setCaseTypeName(uiCodeAction.translateCodeCode(
				"CaseCode", claimDto.getPrpLclaimDto().getCaseType(), true));
		// ��Ӱ������� 2005-08-03
		prpLcompensateDto.setClaimType(claimDto.getPrpLclaimDto()
				.getClaimType());
		prpLcompensateDto.setClaimTypeName(uiCodeAction.translateCodeCode(
				"CaseCode", claimDto.getPrpLclaimDto().getClaimType(), true));
		// ����������⸶���� 2005-9-23
		prpLcompensateDto
				.setCounterClaimerName((claimDto.getPrpLextDto() == null) ? ""
						: claimDto.getPrpLextDto().getSalvor());
		String strRiskType = uiCodeAction
				.translateRiskCodetoRiskType(prpLcompensateDto.getRiskCode());
		// add by wunier 20080103
		// reason:���ũ�ո�������Ҫ���µ�����
		// String strRegistNo = claimDto.getPrpLclaimDto().getRegistNo();
		// UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		// CertainLossDto certainLossDto =
		// uiCertainLossAction.findByPrimaryKey(strRegistNo);
		// ArrayList arrayList = certainLossDto.getPrpLverifyLossDtoList();
		PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
		// if(arrayList.size()>0){
		// PrpLverifyLossDto prpLverifyLossDto =
		// (PrpLverifyLossDto)arrayList.get(0);
		// if(prpLverifyLossDto!=null){
		// if(prpLverifyLossDto.getLossesNumber()!=0.00){
		// //����⸶������Ϊ0˵�����ں��𻷽ڲ����ں��𻷽�¼��������
		// prpLcompensateDto.setLossesNumber(prpLverifyLossDto.getLossesNumber());
		// prpLcompensateDto.setLossesUnitCode(prpLverifyLossDto.getLossesUnitCode());
		// prpLcompensateDto.setDamageInsured(prpLverifyLossDto.getDamageInsured());
		// prpLcompensateDto.setDisasterArea(prpLverifyLossDto.getDisasterArea());
		// prpLcompensateDto.setDisasterUnit(prpLverifyLossDto.getDisasterUnit());
		// prpLcompensateDto.setAffectedArea(prpLverifyLossDto.getAffectedArea());
		// prpLcompensateDto.setAffectedUnit(prpLverifyLossDto.getAffectedUnit());
		// prpLcompensateDto.setNoProductionArea(prpLverifyLossDto.getNoProductionArea());
		// prpLcompensateDto.setNoProductionUnit(prpLverifyLossDto.getNoProductionUnit());
		// prpLcompensateDto.setDeathQuantity(prpLverifyLossDto.getDeathQuantity());
		// prpLcompensateDto.setDeathUnit(prpLverifyLossDto.getDeathUnit());
		// prpLcompensateDto.setKillQuantity(prpLverifyLossDto.getKillQuantity());
		// prpLcompensateDto.setKillUnit(prpLverifyLossDto.getKillUnit());
		// }else{
		// ���Ϊ0��˵�����ں��𻷽ڵ���û��¼�����ݣ���ô�ʹ�����������
		// prpLcompensateDto.setLossesNumber(prpLclaimDto.getLossesNumber());
		// prpLcompensateDto.setLossesUnitCode(prpLclaimDto.getLossesUnitCode());
		// prpLcompensateDto.setDamageInsured(prpLclaimDto.getDamageInsured());
		// prpLcompensateDto.setDisasterArea(prpLclaimDto.getDisasterArea());
		// prpLcompensateDto.setDisasterUnit(prpLclaimDto.getDisasterUnit());
		// prpLcompensateDto.setAffectedArea(prpLclaimDto.getAffectedArea());
		// prpLcompensateDto.setAffectedUnit(prpLclaimDto.getAffectedUnit());
		// prpLcompensateDto.setNoProductionArea(prpLclaimDto.getNoProductionArea());
		// prpLcompensateDto.setNoProductionUnit(prpLclaimDto.getNoProductionUnit());
		// prpLcompensateDto.setDeathQuantity(prpLclaimDto.getDeathQuantity());
		// prpLcompensateDto.setDeathUnit(prpLclaimDto.getDeathUnit());
		// prpLcompensateDto.setKillQuantity(prpLclaimDto.getKillQuantity());
		// prpLcompensateDto.setKillUnit(prpLclaimDto.getKillUnit());
		// }
		// }
		// }else{
		// ���certainLossDtoû������˵��������û�ж����������,��ô�ʹ�����������
		if (prpLclaimDto != null) {
			prpLcompensateDto.setLossesNumber(prpLclaimDto.getLossesNumber());
			prpLcompensateDto.setLossesUnitCode(prpLclaimDto
					.getLossesUnitCode());
			prpLcompensateDto.setDamageInsured(prpLclaimDto.getDamageInsured());
			prpLcompensateDto.setDisasterArea(prpLclaimDto.getDisasterArea());
			prpLcompensateDto.setDisasterUnit(prpLclaimDto.getDisasterUnit());
			prpLcompensateDto.setAffectedArea(prpLclaimDto.getAffectedArea());
			prpLcompensateDto.setAffectedUnit(prpLclaimDto.getAffectedUnit());
			prpLcompensateDto.setNoProductionArea(prpLclaimDto
					.getNoProductionArea());
			prpLcompensateDto.setNoProductionUnit(prpLclaimDto
					.getNoProductionUnit());
			prpLcompensateDto.setDeathQuantity(prpLclaimDto.getDeathQuantity());
			prpLcompensateDto.setDeathUnit(prpLclaimDto.getDeathUnit());
			prpLcompensateDto.setKillQuantity(prpLclaimDto.getKillQuantity());
			prpLcompensateDto.setKillUnit(prpLclaimDto.getKillUnit());
		}
		// }
		// end by wunier 20080103

		// �Ƿ����⸶�����⽡����,�Ʋ��ա������ա�Ĭ���ǣ����ա�������Ĭ�Ϸ� 2005-9-16
		if ("E".equals(strRiskType)) {
			prpLcompensateDto.setFinallyFlag("1");
		}
		if ("D".equals(strRiskType)) {
			prpLcompensateDto.setFinallyFlag("0");
		}

		if (prpLcompensateDto.getResult() == null
				|| prpLcompensateDto.getResult().trim().length() == 0) {
			// ����������۵�Ĭ��ֵ
			prpLcompensateDto.setResult(prpLcompensateDto
					.getDefaultCompensateResult());
		}

		PolicyDto policyDto = null;
		PrpCitemKindDto prpCitemKindDto = null;
		if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
			// ��ѯ������Ϣ
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			policyDto = endorseViewHelper.findForEndorBefore(claimDto
					.getPrpLclaimDto().getPolicyNo(), claimDto
					.getPrpLclaimDto().getDamageStartDate().toString(),
					claimDto.getPrpLclaimDto().getDamageStartHour());

			PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();

			// ȡ�����������ƣ������ŵ���Ҫ��ʾ����
			String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();

			if (String.valueOf(insureQuantity) == null
					|| String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1) {
				strInsuredNameShow = policyDto.getPrpCmainDto()
						.getInsuredName();
			} else {
				strInsuredNameShow = policyDto.getPrpCmainDto()
						.getInsuredName()
						+ "��" + insureQuantity + "��";
			}
			prpLcompensateDto.setInsuredNameShow(strInsuredNameShow);
			// �б�����
			prpLcompensateDto.setSumInsured(policyDto.getPrpCmainDto()
					.getSumInsured());
			// add by lixiang start at 20051227
			// reason: ����Ͷ���˵���Ϣ
			prpLcompensateDto.setAppliName(policyDto.getPrpCmainDto()
					.getAppliName());
			// add by lixiang end at 20051227

			String defaultKindCode = new DAAClaimViewHelper()
					.getDefaultKindCodeByPolicyDto(policyDto);
			httpServletRequest.setAttribute("defaultKindCode", defaultKindCode); // ��ñ���Ĭ�ϵ��ձ�

			httpServletRequest.setAttribute("shareHolderFlag", policyDto
					.getPrpCmainDto().getShareHolderFlag());

			httpServletRequest.setAttribute("statQuantity", policyDto
					.getPrpCmainDto().getStatQuantity());
			// -------------------------------------------------------------------------------------------
			// ���������¹����������ձ������ʷ�⸶��
			// ��ȡ�¹��ߵķֻ����,���ݷֻ���Ų��������ձ�
			if (claimDto.getPrplacciBenPersonDtoList() != null
					&& claimDto.getPrplacciBenPersonDtoList().size() > 0) {
				int intPersonCount = 0;
				int intFamilyNo = 0;
				int intItemKindNo = 0;
				double dblHisPaid = 0;
				String strPolicyno = "";
				String strItemKindQueryCon = "";
				String strItemKindQueryCon1 = "";
				PrpLpersonLossDto prpLpersonLossDto = null;
				PrpLacciPersonDto prpLacciPersonDto = null;
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				UICompensateAction uiCompensateAction = new UICompensateAction();
				ArrayList benPersonKindList = new ArrayList();
				Collection prplpersonlossDtoList = new ArrayList();
				ArrayList prpCitemKindDtoCopyList = new ArrayList();

				intPersonCount = claimDto.getPrplacciBenPersonDtoList().size();
				for (int j = 0; j < intPersonCount; j++) {
					prpLacciPersonDto = (PrpLacciPersonDto) claimDto
							.getPrplacciBenPersonDtoList().get(j);
					intFamilyNo = prpLacciPersonDto.getFamilyNo();
					strPolicyno = prpLacciPersonDto.getPolicyNo();
					// ���ݰ�����������������������ȡ������Ϣʱֱ��ȡ��ʱ���±�����Ϣ�������е�����
					strItemKindQueryCon = " policyno = '" + strPolicyno
							+ "' and familyno = " + intFamilyNo;
					benPersonKindList = (ArrayList) blPrpCitemKindFacade
							.findByConditions(strItemKindQueryCon);
					if (benPersonKindList != null
							&& benPersonKindList.size() > 0) {
						for (int m = 0; m < benPersonKindList.size(); m++) {
							prpCitemKindDto = (PrpCitemKindDto) benPersonKindList
									.get(m);
							intItemKindNo = prpCitemKindDto.getItemKindNo();
							dblHisPaid = 0;
							strItemKindQueryCon1 = " policyNo='" + strPolicyno
									+ "' AND FamilyNo=" + intFamilyNo
									+ " AND ItemKindNo=" + intItemKindNo;

							prplpersonlossDtoList = uiCompensateAction
									.findPersonLossByConditions(strItemKindQueryCon1);
							// �ۼ���ʷ��¼���
							Iterator itpersonloss = prplpersonlossDtoList
									.iterator();
							while (itpersonloss.hasNext()) {
								prpLpersonLossDto = (PrpLpersonLossDto) itpersonloss
										.next();
								dblHisPaid = dblHisPaid
										+ prpLpersonLossDto.getSumRealPay();
							}
							prpCitemKindDto.setHisPaid(dblHisPaid);
							prpCitemKindDtoCopyList.add(prpCitemKindDto);
						}

					}
				}
				policyDto.setPrpCitemKindDtoList(prpCitemKindDtoCopyList);
			}
			// -------------------------------------------------------------------------------------------
			httpServletRequest.setAttribute("prpCitemKindList", policyDto
					.getPrpCitemKindDtoList());
		}
		// -------------------------------------------------------------------------------------------
		// ��ȡ�һ�����Ϣ
		Collection prpdexchDtoList = new ArrayList();
		UIExchAction uiExchAction = new UIExchAction();

		prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime()
				.current().toString().substring(0, 10));
		httpServletRequest.setAttribute("prpdexchDtoList", prpdexchDtoList);

		// ��ֵ��ʼ�ļ�����Times��Ϣ
		String conditions = " ClaimNo= '" + claimNo + "'";
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Collection prplCompensateListTemp = uiCompensateAction
				.findByConditions(conditions);
		if (prplCompensateListTemp != null) {
			prpLcompensateDto.setTimes(prplCompensateListTemp.size() + 1);
		} else {
			prpLcompensateDto.setTimes(1);
		}

		// ��ʼ����ģ��Ӷ������������
		ArrayList prpLlossListTemp = new ArrayList();
		ArrayList prpLpersonLossListTemp = new ArrayList();
		CompensateDto compensateDto = new CompensateDto();
		// ��ʼ����ĴӶ�������� �������������㲢�Ҳ����ؿ��ⰸ������
		if (editType.trim().equals("ADD") && recount != 1) {
			String riskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);
			// ũ�����㻷�ڴ���
			if (riskType.equals("H") || riskType.equals("I")) {
				// �����ʧ��Ϣ����
				prpLlossListTemp = initPropLossItemAgri(claimNo, claimDto);

				// ����������Ϣ���������зֻ���Ϣ���������
				if ("3204".equals(riskCode)) {
					prpLpersonLossListTemp = initPersonLossItemAgri3204(
							claimNo, claimDto.getPrpLclaimDto().getRegistNo());
				} else {
					prpLpersonLossListTemp = initPersonLossItemAgri(claimNo,
							claimDto.getPrpLclaimDto().getRegistNo());
				}
				PrpLacciPersonDto prpLacciPersonDto = new PrpLacciPersonDto();
				prpLacciPersonDto.setPrpLagriPersonList(prpLpersonLossListTemp);
				httpServletRequest.setAttribute("prpLacciPersonDto",
						prpLacciPersonDto);
			} else {
				prpLlossListTemp = initPropLossItem(httpServletRequest,
						claimNo, claimDto);
				prpLpersonLossListTemp = initPersonLossItem(httpServletRequest,
						claimNo, claimDto);
			}
			compensateDto.setPrpLlossDtoList(prpLlossListTemp);
			// compensateDto.setPrpLpersonLossDtoList(prpLpersonLossListTemp);
		}

		PrpLctextDto prpLctextDto1 = new PrpLctextDto();
		// ��ֵ�ı�������
		httpServletRequest.setAttribute("prpLctextDto1", prpLctextDto1);
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		// ��ֵ�ı�������
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		PrpLctextDto prpLctextPayTextDto = new PrpLctextDto();
		String payText = "";
		payText += "�뽫���      ����\r\n";
		payText += "��λ:\r\n";
		payText += "������:\r\n";
		payText += "�ʺ�:\r\n";
		payText += "�������ڼ���ʽ:\r\n";
		prpLctextPayTextDto.setTextType(PAY_TEXT);
		prpLctextPayTextDto.setContext(payText);

		// ��ֵ�ı�������
		httpServletRequest.setAttribute("prpLctextPayTextDto",
				prpLctextPayTextDto);

		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcompensateDto.getPolicyNo(), claimDto.getPrpLclaimDto()
						.getRegistNo());

		// ������ʵ����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

		// �ڽ�������ʾ�������� 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLcompensateDto.getRiskCode(), true));
		httpServletRequest.setAttribute("riskType", strRiskType);
		// ���ø����ӱ���Ϣ������
		compensateDto.setPrpLcompensateDto(prpLcompensateDto);
		compensateDto = uiCompensateAction
				.findByAppendInformation(compensateDto);
		String policyNo = prpLcompensateDto.getPolicyNo();
		int intPayFee = this.checkPay(httpServletRequest, policyNo);

		prpLcompensateDto.setPayFee(intPayFee);
		// reason:��ȡΣ�յ�λ��Ϣ
		UIRiskUnitAction blPrpCdangerUnitFacade = new UIRiskUnitAction();
		PrpLdangerUnitDto prpLdangerUnitDto = blPrpCdangerUnitFacade
				.findByPrimaryKeyFromPrpLdangerUnit(prpLcompensateDto
						.getClaimNo(), 1, httpServletRequest, claimDto
						.getPrpLclaimDto().getRiskCode(), 0);
		if (prpLdangerUnitDto == null) {
			prpLdangerUnitDto = new PrpLdangerUnitDto();
		}
		prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(
				prpLdangerUnitDto.getCurrency(), true)); // �ô��ֶα�ʾ�ұ�������Ϣ
		httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);

		// �õ������͹ɶ�ҵ����Ϣ�ٷ���Ϣ
		if (policyDto != null) {
			httpServletRequest.setAttribute("coinsFlag", policyDto
					.getPrpCmainDto().getCoinsFlag());
			String conditions2 = "reinsType in ('1','2')  and policyno = '"
					+ claimDto.getPrpLclaimDto().getPolicyNo() + "'";
			BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
			ArrayList reins = (ArrayList) blFcoRepolicyFacade
					.findByConditions(conditions2);
			if (reins != null && reins.size() > 0) {
				httpServletRequest.setAttribute("tempReinsFlag", "1");
			} else {
				httpServletRequest.setAttribute("tempReinsFlag", "0");
			}
			compensateDto = initPrpLCfeeCoins(httpServletRequest, policyDto,
					editType, compensateDto);
		}
		// add by qinyongli end 2005-7-19

		compensateDto.setPrpLcompensateDto(prpLcompensateDto);

		String registNo = uiCodeAction.translateBusinessCode(prpLcompensateDto
				.getClaimNo(), false);
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		compensateDto.setPrpLregistExtDtoList(registDto
				.getPrpLregistExtDtoList());
		setSubInfo(httpServletRequest, compensateDto);

		String text = "";
		if (claimDto.getPrpLltextDtoList() != null
				&& !editType.trim().equals("ADD")) {
			for (Iterator iter = prpLlossListTemp.iterator(); iter.hasNext();) {
				PrpLltextDto element = (PrpLltextDto) iter.next();
				if (element.getTextType().equals("08")) {
					text += element.getContext();
				}
			}
		}
		boolean herdHaveEar = false;
		if (taskCode.indexOf(riskCode) > -1) {
			herdHaveEar = true;
		}
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		if (!claimDto.getPrpLclaimDto().getClassCode().equals("26")
				&& !claimDto.getPrpLclaimDto().getClassCode().equals("27")
				&& !claimDto.getPrpLclaimDto().getClassCode().equals("28")
				&& !herdHaveEar) {
			text = "һ���������˸ſ�" + "\r\n";
			text = text + "�����¹ʾ�����ԭ�����" + "\r\n";
			text = text + "�����϶�����" + "\r\n";
			text = text + "�ġ����Ͷ��" + "\r";
			text = text + "�塢�Ƿ�����ظ�Ͷ�����������׷��ǰ��" + "\r\n";
			text = text + "�������⼰����" + "\r\n";
			text = text + "�ߡ��ܽ���⸶";
			// add by lixiang end at 2006-1-25
		}
		if (herdHaveEar) {
			text = "";
			ArrayList prplCompensateEarDtoListTemp = new ArrayList();
			prplCompensateEarDtoListTemp = (ArrayList) httpServletRequest
					.getAttribute("prplCompensateEarDtoList");
			Iterator ite = prplCompensateEarDtoListTemp.iterator();
			double sumloss = 0.00;
			while (ite.hasNext()) {
				PrplcompensateearDto prplCompensateEarDtoTemp = (PrplcompensateearDto) ite
						.next();
				double claimloss = prplCompensateEarDtoTemp.getEstimateloss();
				sumloss = sumloss + claimloss;
				text = text + "����ţ�" + prplCompensateEarDtoTemp.getEarno()
						+ " �⸶���=" + claimloss + "\r\n";
			}
			text = text + "\r\n" + "���⸶���=" + sumloss;

		}
		prpLltextDto.setTextType("08");
		prpLltextDto.setContext(text);
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		httpServletRequest.setAttribute("prpLltextDto3", claimDto
				.getPrpLltextDtoList3());
		// ������������б�
		httpServletRequest.setAttribute("compensateResultMap",
				getCompensateResultList());

		// �������Ĭ��Ϊ������Ϣ�еĲ鿱��
		PrpLchargeDto prpLchargeDto = getDefaultPrpLchargeFromAcciCheckFee(claimDto);

		if (prpLchargeDto != null) {
			Collection prpLchargeList = new ArrayList();
			prpLchargeList.add(prpLchargeDto);

			prpLchargeDto.setPrpLchargeList(prpLchargeList);
			httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);

			// ������������е�������ֵΪ�����
			prpLcompensateDto.setSumNoDutyFee(prpLchargeDto.getChargeAmount());
		}

	}

	public CompensateDto initPrpLCfeeCoins(
			HttpServletRequest httpServletRequest, PolicyDto policyDto,
			String editType, CompensateDto compensateDto) {
		double coinsSelfRate = 0d;
		PrpLcfeecoinsDto prpLcfeecoinsDto = null;
		ArrayList prpLcfeecoinsDtoList = new ArrayList();
		if ("2".equals(policyDto.getPrpCmainDto().getCoinsFlag())
				|| "1".equals(policyDto.getPrpCmainDto().getCoinsFlag())) {
			ArrayList prpCcoinsDtoList = policyDto.getPrpCcoinsDtoList();
			PrpCcoinsDto prpCcoinsDto = null;
			if (prpCcoinsDtoList != null && prpCcoinsDtoList.size() > 0) {
				prpCcoinsDto = new PrpCcoinsDto();
				Iterator itCoins = prpCcoinsDtoList.iterator();
				while (itCoins.hasNext()) {
					prpCcoinsDto = (PrpCcoinsDto) itCoins.next();
					if ("1".equals(prpCcoinsDto.getCoinsType())) {
						coinsSelfRate = prpCcoinsDto.getCoinsRate();
						break;
					}
				}
			}
			DecimalFormat decimalFormat = new DecimalFormat("#0.00");
			int intCount = 1;
			if ("ADD".equals(editType)) {
				if (prpCcoinsDtoList != null && prpCcoinsDtoList.size() > 0) {
					prpCcoinsDto = new PrpCcoinsDto();
					Iterator itCoins = prpCcoinsDtoList.iterator();
					while (itCoins.hasNext()) {
						prpCcoinsDto = (PrpCcoinsDto) itCoins.next();
						if (!"1".equals(prpCcoinsDto.getCoinsType())
								&& !"0".equals(prpCcoinsDto.getCoinsType())) {
							prpLcfeecoinsDto = new PrpLcfeecoinsDto();
							prpLcfeecoinsDto.setSerialNo(intCount++);
							prpLcfeecoinsDto.setMainPolicyNo(prpCcoinsDto
									.getMainPolicyNo());
							prpLcfeecoinsDto.setRiskCode(policyDto
									.getPrpCmainDto().getRiskCode());
							prpLcfeecoinsDto.setPolicyNo(policyDto
									.getPrpCmainDto().getPolicyNo());
							prpLcfeecoinsDto.setCoinsCode(prpCcoinsDto
									.getCoinsCode());
							prpLcfeecoinsDto.setCoinsName(prpCcoinsDto
									.getCoinsName());
							prpLcfeecoinsDto.setCoinsRate(prpCcoinsDto
									.getCoinsRate());
							prpLcfeecoinsDto.setCoinsType(prpCcoinsDto
									.getCoinsType());
							prpLcfeecoinsDto.setChiefFlag(prpCcoinsDto
									.getChiefFlag());
							prpLcfeecoinsDto.setCoinsSumpaid(0.00);
							prpLcfeecoinsDtoList.add(prpLcfeecoinsDto);
						}
					}
				}
			} else {
				PrpLcompensateDto prpLcompensateDto = compensateDto
						.getPrpLcompensateDto();
				prpLcompensateDto.setCoinsOtherPaid(prpLcompensateDto
						.getCoinsSumPaid()
						- prpLcompensateDto.getSumPaid());
				compensateDto.setPrpLcompensateDto(prpLcompensateDto);
				prpLcfeecoinsDtoList = compensateDto.getPrpLcfeecoinsList();
				if (prpLcfeecoinsDtoList == null
						|| prpLcfeecoinsDtoList.size() == 0) {
					prpLcfeecoinsDtoList = new ArrayList();
					double sumpaid = prpLcompensateDto.getSumPaid();
					String coinsPaidType = prpLcompensateDto
							.getCoinsPaidLossType();
					double otherpaid = 0;
					if (prpCcoinsDtoList != null && prpCcoinsDtoList.size() > 0) {
						prpCcoinsDto = new PrpCcoinsDto();
						int endCount = 1;
						Iterator itCoins = prpCcoinsDtoList.iterator();
						while (itCoins.hasNext()) {
							prpCcoinsDto = (PrpCcoinsDto) itCoins.next();
							if (!"1".equals(prpCcoinsDto.getCoinsType())
									&& !"0".equals(prpCcoinsDto.getCoinsType())) {
								prpLcfeecoinsDto = new PrpLcfeecoinsDto();
								prpLcfeecoinsDto.setSerialNo(intCount++);
								prpLcfeecoinsDto.setMainPolicyNo(prpCcoinsDto
										.getMainPolicyNo());
								prpLcfeecoinsDto.setRiskCode(policyDto
										.getPrpCmainDto().getRiskCode());
								prpLcfeecoinsDto.setPolicyNo(policyDto
										.getPrpCmainDto().getPolicyNo());
								prpLcfeecoinsDto.setCoinsCode(prpCcoinsDto
										.getCoinsCode());
								prpLcfeecoinsDto.setCoinsName(prpCcoinsDto
										.getCoinsName());
								prpLcfeecoinsDto.setCoinsRate(prpCcoinsDto
										.getCoinsRate());
								prpLcfeecoinsDto.setCoinsType(prpCcoinsDto
										.getCoinsType());
								prpLcfeecoinsDto.setChiefFlag(prpCcoinsDto
										.getChiefFlag());
								double coinspaid = Double
										.parseDouble(decimalFormat
												.format(sumpaid
														/ coinsSelfRate
														* prpCcoinsDto
																.getCoinsRate()));
								if ("1".equals(coinsPaidType)) {
									prpLcfeecoinsDto.setCoinsSumpaid(coinspaid);
									otherpaid += coinspaid;
								} else {
									prpLcfeecoinsDto.setCoinsSumpaid(0);
								}

								prpLcfeecoinsDtoList.add(prpLcfeecoinsDto);
							}
						}
					}
					prpLcompensateDto.setCoinsOtherPaid(otherpaid);
					prpLcompensateDto.setCoinsSumPaid(otherpaid + sumpaid);
					compensateDto.setPrpLcompensateDto(prpLcompensateDto);
				}
			}

			httpServletRequest.setAttribute("coinsSelfRate", coinsSelfRate);
			// httpServletRequest.setAttribute("prpCcoinsDtoList",
			// prpCcoinsDtoList);
			httpServletRequest.setAttribute("prpLcfeecoinsDtoList",
					prpLcfeecoinsDtoList);
		}
		return compensateDto;
	}

	private PrpLchargeDto getDefaultPrpLchargeFromAcciCheckFee(ClaimDto claimDto)
			throws Exception {
		// ����⽡�յĶ�ε������֮��
		double sumAcciCheckFee = new BLPrpLacciCheckFacade()
				.getAcciCheckFeeByRegistNo(claimDto.getPrpLclaimDto()
						.getRegistNo());
		PrpLchargeDto prpLchargeDto = null;

		if (sumAcciCheckFee > 0) {
			prpLchargeDto = new PrpLchargeDto();
			// ����Ĭ�ϵ�����Ϊ1
			prpLchargeDto.setSerialNo(1);

			// ����Ĭ�ϵ��ձ������ձ�����Ϊ����ʱ���ձ����ƺ��ձ����;
			List claimLossList = claimDto.getPrpLclaimLossDtoList();
			if (claimLossList != null && claimLossList.size() > 0) {
				PrpLclaimLossDto claimLoss = (PrpLclaimLossDto) claimLossList
						.get(0);
				prpLchargeDto.setKindCode(claimLoss.getKindCode());
				prpLchargeDto.setKindName(claimLoss.getKindName());
			}
			// ����Ĭ�ϵķ������Ϊ04-�鿱��
			prpLchargeDto.setChargeCode("04");
			prpLchargeDto.setChargeName("�鿱��");

			// ����Ĭ�ϵıұ�ΪCNY-�����
			prpLchargeDto.setCurrency("CNY");
			prpLchargeDto.setCurrencyName("�����");

			// ���÷���Ϊ�����
			prpLchargeDto.setChargeAmount(sumAcciCheckFee);

			// ���ü��������Ϊ0
			prpLchargeDto.setSumRealPay(0);
		}
		return prpLchargeDto;
	}

	/**
	 * ����ClaimDto�е�
	 * 
	 * @param claimDto
	 * @throws Exception
	 */

	private void setClaimLossKindName(ClaimDto claimDto) throws Exception {

		claimDto.getPrpLclaimLossDtoList();
		for (Iterator iter = claimDto.getPrpLclaimLossDtoList().iterator(); iter
				.hasNext();) {
			PrpLclaimLossDto claimLoss = (PrpLclaimLossDto) iter.next();
			setClaimLossKindName(claimLoss);
		}
	}

	/**
	 * ����PrpLclaimLossDto���ձ�����(���������ձ����)
	 * 
	 * @param claimLoss
	 * @throws Exception
	 */
	private void setClaimLossKindName(PrpLclaimLossDto claimLoss)
			throws Exception {
		String kindName = new UICodeAction().translateKindCode(claimLoss
				.getRiskCode(), claimLoss.getKindCode(), true);
		claimLoss.setKindName(kindName);
	}

	/**
	 * ������������Ų�ѯԤ����Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param compensateNo
	 *            ���������
	 * @throws Exception
	 */

	public void compensateDtoView(HttpServletRequest httpServletRequest,
			String compensateNo, String editType) throws Exception {

		ClaimDto claimDto = null;
		UICodeAction uiCodeAction = new UICodeAction();
		String prpltextForEar = "";

		// �����ⰸ��־,�ӹ������ϻ�á�
		String riskType = "";
		String caseType = httpServletRequest.getParameter("caseType");
		UICompensateAction uiCompensateAction = new UICompensateAction();
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(
				compensateNo, caseType);

		// ������������Ϣ
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();
		prpLcompensateDto.setEditType(editType.trim());
		String riskcodefortemp = prpLcompensateDto.getRiskCode();

		// add by miaowenjun 20070130 ��ʾ��ʱ��ȥ������������ start
		double sumPaid = 0d;
		double sumDutyPaid = 0d;
		double sumThisPaid = 0d;
		sumPaid = prpLcompensateDto.getSumPaid();
		sumDutyPaid = prpLcompensateDto.getSumDutyPaid();
		sumThisPaid = prpLcompensateDto.getSumThisPaid();
		riskType = uiCodeAction.translateRiskCodetoRiskType(prpLcompensateDto
				.getRiskCode());
		for (Iterator iter = compensateDto.getPrpLchargeDtoList().iterator(); iter
				.hasNext();) {
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) iter.next();
			if ("28".equals(prpLchargeDto.getChargeCode())) {
				sumPaid -= prpLchargeDto.getChargeAmount();
				sumDutyPaid -= prpLchargeDto.getChargeAmount();
				sumThisPaid -= prpLchargeDto.getChargeAmount();
			}
		}
		prpLcompensateDto.setSumPaid(sumPaid);
		prpLcompensateDto.setSumDutyPaid(sumDutyPaid);
		prpLcompensateDto.setSumThisPaid(sumThisPaid);
		// add by miaowenjun 20070130 ��ʾ��ʱ��ȥ������������ end

		// add by huangyunzhong 20051128 �õ��Ƿ��ؿ��ⰸ
		String claimNo = prpLcompensateDto.getClaimNo().trim();
		int recount = 0;
		double sumDamageInsured = 0.00;
		double dbSumPaid = 0.00;
		double dbLossNumber = 0.00;
		double dbSumDutyPaid = 0.00;
		ReCaseDto reCaseDto = new ReCaseDto();
		PrpLrecaseDto prpLrecaseDto = new PrpLrecaseDto();
		// ��ѯ�ؿ��ⰸ��Ϣ
		UIRecaseAction uiRecaseAction = new UIRecaseAction();
		reCaseDto = uiRecaseAction.findByPrimaryKey(claimNo, 1);
		prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
		if (prpLrecaseDto != null && prpLrecaseDto.getClaimNo() != null
				&& prpLrecaseDto.getClaimNo().trim().length() > 0) {
			recount = 1;
			String strSql = "claimNo = '" + claimNo
					+ "' and underwriteflag in ('1','3')";
			UICompensateAction uiCompensateAction1 = new UICompensateAction();
			ArrayList compensateDtoList = (ArrayList) uiCompensateAction1
					.findByClaimNo(strSql);
			for (int index = 0; index < compensateDtoList.size(); index++) {
				PrpLcompensateDto prplcompensateDto = (PrpLcompensateDto) compensateDtoList
						.get(index);
				sumDamageInsured += prplcompensateDto.getDamageInsured();
				dbSumPaid += prplcompensateDto.getSumPaid();
				dbLossNumber += prplcompensateDto.getLossesNumber();
				dbSumDutyPaid += prplcompensateDto.getSumDutyPaid();
			}
			httpServletRequest.setAttribute("recaseFlag", String
					.valueOf(recount));
		}
		httpServletRequest.setAttribute("sumDamageInsured", sumDamageInsured);
		httpServletRequest.setAttribute("dbSumPaid", dbSumPaid);
		httpServletRequest.setAttribute("dbLossNumber", dbLossNumber);
		httpServletRequest.setAttribute("dbSumDutyPaid", dbSumDutyPaid);
		httpServletRequest.setAttribute("recaseFlag", String.valueOf(recount));

		// add end huangyunzhong 20051128

		// �õ��ұ���������
		prpLcompensateDto.setCurrencyName(uiCodeAction.translateCurrencyCode(
				prpLcompensateDto.getCurrency(), true));
		// ����ʵ�������״̬Ϊ �����޸� (����������)
		if (compensateDto.getPrpLclaimStatusDto() != null) {
			// ���ó�ʼ��������
			prpLcompensateDto = compensateDto.getPrpLcompensateDto();

			if (compensateDto.getPrpLclaimStatusDto().getStatus().equals("7"))
				compensateDto.getPrpLclaimStatusDto().setStatus("3");
			prpLcompensateDto.setStatus(compensateDto.getPrpLclaimStatusDto()
					.getStatus());
		} else {

			// ���ύ���Ѿ�������ϵ�״̬
			prpLcompensateDto.setStatus("4");
		}
		String status = httpServletRequest.getParameter("status");// �ӹ�������ȥ״̬
		if (status != null && !status.equals(""))
			prpLcompensateDto.setStatus(status);

		// add by liubvo 20040601
		if (!compensateDto.getPrpLcompensateDto().getClaimNo().equals("")) {
			// ��ѯ������Ϣ
			UIClaimAction uiClaimAction = new UIClaimAction();
			claimDto = uiClaimAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getClaimNo());

			// ����������úϼ�ֵ-----------------------------------------------------------
			String riskCode = claimDto.getPrpLclaimDto().getRiskCode();
			riskType = uiCodeAction
					.translateRiskCodetoRiskType(prpLcompensateDto
							.getRiskCode());

			double sumCheckFee = 0.00;
			String conditionshere = " registNo='"
					+ claimDto.getPrpLclaimDto().getRegistNo() + "'";
			PrpLacciCheckDto prplacciCheckDto = new PrpLacciCheckDto();
			UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
			Collection prpLacciCheckDtoList = uiAcciCheckAction
					.findByConditionsAcciCheck(conditionshere);
			Iterator it = prpLacciCheckDtoList.iterator();
			while (it.hasNext()) {
				prplacciCheckDto = (PrpLacciCheckDto) it.next();
				sumCheckFee = sumCheckFee + prplacciCheckDto.getCheckFee();
			}

			prpLcompensateDto.setSumCheckFee(sumCheckFee);

			PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
			prpLclaimDto = claimDto.getPrpLclaimDto();
			prpLcompensateDto.setDamageStartDate(prpLclaimDto
					.getDamageStartDate());
			prpLcompensateDto.setIndemnityDuty(prpLclaimDto.getIndemnityDuty());// dododo
			prpLcompensateDto.setEscapeFlag(prpLclaimDto.getEscapeFlag());// dododo
			// prpLcompensateDto.setDamageStartHour(prpLclaimDto.getDamageStartHour());
			String timeTemp = StringConvert.toStandardTime(claimDto
					.getPrpLclaimDto().getDamageStartHour());
			prpLcompensateDto.setDamageStartHour(timeTemp.substring(0, 2));
			prpLcompensateDto.setDamageStartMinute(timeTemp.substring(3, 5));
			prpLcompensateDto.setStartDate(prpLclaimDto.getStartDate());
			prpLcompensateDto.setEndDate(prpLclaimDto.getEndDate());
			prpLcompensateDto.setDamageAddress(prpLclaimDto.getDamageAddress());
			prpLcompensateDto.setSumClaim(prpLclaimDto.getSumClaim());
			prpLcompensateDto.setSumAmount(prpLclaimDto.getSumAmount());
			prpLcompensateDto.setInsuredName(prpLclaimDto.getInsuredName());
			prpLcompensateDto.setInsuredCode(prpLclaimDto.getInsuredCode());
			prpLcompensateDto.setSumPaidAll(prpLclaimDto.getSumPaid());
			prpLcompensateDto.setHandlerName(uiCodeAction.translateUserCode(
					prpLcompensateDto.getHandlerCode(), true));

			// ��ӳ���ԭ�� 2005-08-02
			prpLcompensateDto.setDamageName(prpLclaimDto.getDamageName());

			// ��Ӱ������� 2005-08-03
			prpLcompensateDto.setClaimType(prpLclaimDto.getClaimType());
			prpLcompensateDto.setClaimTypeName(uiCodeAction.translateCodeCode(
					"CaseCode", prpLclaimDto.getClaimType(), true));

			// ��ӱ����� 2005-08-07
			prpLcompensateDto.setRegistNo(prpLclaimDto.getRegistNo());
			double sumPrePaid = 0.0;
			double preSosMedicFee = 0.0;
			if (recount < 1) {
				UIPrepayAction uiPrePayAction = new UIPrepayAction();
				PrpLprepayDto prpLprepayDto = null;
				String underWriteFlag = "";
				ArrayList PrepayList = (ArrayList) uiPrePayAction
						.findByConditions("claimNo = '"
								+ claimDto.getPrpLclaimDto().getClaimNo() + "'");
				if (PrepayList != null) {
					for (Iterator its = PrepayList.iterator(); its.hasNext();) {
						prpLprepayDto = new PrpLprepayDto();
						prpLprepayDto = (PrpLprepayDto) its.next();
						underWriteFlag = prpLprepayDto.getUnderWriteFlag();
						if (underWriteFlag.equals("1")
								|| underWriteFlag.equals("3")) {
							sumPrePaid += prpLprepayDto.getSumPrePaid();
							preSosMedicFee += prpLprepayDto
									.getSumPreChargePaid();
						} else {
							throw new UserException(1, 3, "123", "����δ����ͨ����Ԥ�ⰸ��");
						}
					}
				}
			}
			prpLcompensateDto.setSumPreChargeAmount(preSosMedicFee);

			String taskCode = SysConfig.getProperty("FamilySplittingFlag",
					"claim");
			String registNo = prpLclaimDto.getRegistNo();
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade
					.findByPrimaryKey(registNo);
			httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

			if (taskCode.indexOf(riskCode) > -1) {
				ArrayList prplCompensateEarDtoList = new ArrayList();// �����嵥�б�
				if (registNo != null) {
					BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
					prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
							.getPrpLCompensateEarDtos(registNo, "compe",
									compensateNo);
					prpltextForEar = "";
					Iterator ite = prplCompensateEarDtoList.iterator();
					double sumloss = 0.00;
					while (ite.hasNext()) {
						PrplcompensateearDto prplCompensateEarDtotemp2 = (PrplcompensateearDto) ite
								.next();
						double claimloss = prplCompensateEarDtotemp2
								.getEstimateloss();
						sumloss = sumloss + claimloss;
						prpltextForEar = prpltextForEar + "����ţ�"
								+ prplCompensateEarDtotemp2.getEarno()
								+ " �⸶���=" + claimloss + "\r\n";
					}
					// DecimalFormat df = new DecimalFormat("#.00");
					// String sumloss1 = df.format(sumloss);
					sumloss = (double) (Math.round(sumloss * 100) / 100.0);// �������㱨���ʼ��ʱ���������뱣����λС���Ĳ�����
					prpltextForEar = prpltextForEar + "\r\n" + "���⸶���="
							+ sumloss;

				}
				httpServletRequest.setAttribute("prplCompensateEarDtoList",
						prplCompensateEarDtoList);// ���ö�����嵥�б�
				httpServletRequest.setAttribute("familySplittingFlag", "true");// ���ö�����嵥�б�
			}

			if ("0310".equals(riskCode) || "0312".equals(riskCode)) {
				ArrayList prplCompensateHouseDtoList = new ArrayList();
				if (registNo != null) {
					String nodetype = "compe";
					BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
					String condition = " businessno='" + compensateNo
							+ "' and nodetype='" + nodetype + "'";
					prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade
							.findByConditions(condition);
				}
				httpServletRequest.setAttribute("prplCompensateHouseDtoList",
						prplCompensateHouseDtoList);
			}
		}

		// ��ȡ�һ�����Ϣ
		Collection prpdexchDtoList = new ArrayList();
		UIExchAction uiExchAction = new UIExchAction();
		prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime()
				.current().toString().substring(0, 10));
		httpServletRequest.setAttribute("prpdexchDtoList", prpdexchDtoList);
		if (!compensateDto.getPrpLcompensateDto().getPolicyNo().equals("")) {
			// ��ѯ������Ϣ
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					compensateDto.getPrpLcompensateDto().getPolicyNo(),
					prpLcompensateDto.getDamageStartDate().toString(),
					prpLcompensateDto.getDamageStartHour());
			// PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
			if ("E".equals(riskType)) {

				// ��ȡ�¹��ߵķֻ����,���ݷֻ���Ų��������ձ�
				if (claimDto.getPrplacciBenPersonDtoList() != null
						&& claimDto.getPrplacciBenPersonDtoList().size() > 0) {
					int intPersonCount = 0;
					int intFamilyNo = 0;
					int intItemKindNo = 0;
					double dblHisPaid = 0;
					String strPolicyno = "";
					String strItemKindQueryCon = "";
					String strItemKindQueryCon1 = "";
					PrpLpersonLossDto prpLpersonLossDto = null;
					PrpLacciPersonDto prpLacciPersonDto2 = null;
					PrpCitemKindDto prpCitemKindDto = null;
					BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
					ArrayList benPersonKindList = new ArrayList();
					Collection prplpersonlossDtoList = new ArrayList();
					ArrayList prpCitemKindDtoCopyList = new ArrayList();

					intPersonCount = claimDto.getPrplacciBenPersonDtoList()
							.size();
					for (int j = 0; j < intPersonCount; j++) {
						prpLacciPersonDto2 = (PrpLacciPersonDto) claimDto
								.getPrplacciBenPersonDtoList().get(j);
						intFamilyNo = prpLacciPersonDto2.getFamilyNo();
						strPolicyno = prpLacciPersonDto2.getPolicyNo();
						// ���ݰ�����������������������ȡ������Ϣʱֱ��ȡ��ʱ���±�����Ϣ�������е�����
						strItemKindQueryCon = " policyno = '" + strPolicyno
								+ "' and familyno = " + intFamilyNo;
						benPersonKindList = (ArrayList) blPrpCitemKindFacade
								.findByConditions(strItemKindQueryCon);
						if (benPersonKindList != null
								&& benPersonKindList.size() > 0) {
							for (int m = 0; m < benPersonKindList.size(); m++) {
								prpCitemKindDto = (PrpCitemKindDto) benPersonKindList
										.get(m);
								intItemKindNo = prpCitemKindDto.getItemKindNo();
								dblHisPaid = 0;
								strItemKindQueryCon1 = " policyNo='"
										+ strPolicyno + "' AND FamilyNo="
										+ intFamilyNo + " AND ItemKindNo="
										+ intItemKindNo;

								prplpersonlossDtoList = uiCompensateAction
										.findPersonLossByConditions(strItemKindQueryCon1);
								// �ۼ���ʷ��¼���
								Iterator itpersonloss = prplpersonlossDtoList
										.iterator();
								while (itpersonloss.hasNext()) {
									prpLpersonLossDto = (PrpLpersonLossDto) itpersonloss
											.next();
									dblHisPaid = dblHisPaid
											+ prpLpersonLossDto.getSumRealPay();
								}
								prpCitemKindDto.setHisPaid(dblHisPaid);
								prpCitemKindDtoCopyList.add(prpCitemKindDto);
							}

						}
					}
					policyDto.setPrpCitemKindDtoList(prpCitemKindDtoCopyList);
				}
				httpServletRequest.setAttribute("prpCitemKindList", policyDto
						.getPrpCitemKindDtoList());

			} else {
				httpServletRequest.setAttribute("prpCitemKindList", policyDto
						.getPrpCitemKindDtoList());
			}

			// add by qinyongli begin 2005-7-19
			// �õ������͹ɶ�ҵ����Ϣ�ٷ���Ϣ
			httpServletRequest.setAttribute("statQuantity", policyDto
					.getPrpCmainDto().getStatQuantity());
			httpServletRequest.setAttribute("shareHolderFlag", policyDto
					.getPrpCmainDto().getShareHolderFlag());
			if (policyDto != null) {

				String defaultKindCode = new DAAClaimViewHelper()
						.getDefaultKindCodeByPolicyDto(policyDto);
				httpServletRequest.setAttribute("defaultKindCode",
						defaultKindCode);

				// ȡ�����������ƣ������ŵ���Ҫ��ʾ����
				String strInsuredNameShow = "";
				int insureQuantity = policyDto.getPrpCmainDto()
						.getSumQuantity();

				if (String.valueOf(insureQuantity) == null
						|| String.valueOf(insureQuantity).equals("")
						|| insureQuantity <= 1) {
					strInsuredNameShow = policyDto.getPrpCmainDto()
							.getInsuredName();
				} else {
					strInsuredNameShow = policyDto.getPrpCmainDto()
							.getInsuredName()
							+ "��" + insureQuantity + "��";
				}
				prpLcompensateDto.setInsuredNameShow(strInsuredNameShow);
				prpLcompensateDto.setSumInsured(policyDto.getPrpCmainDto()
						.getSumInsured());

				// add by lixiang start at 20051227
				// reason: ����Ͷ���˵���Ϣ
				prpLcompensateDto.setAppliName(policyDto.getPrpCmainDto()
						.getAppliName());

				// add by lixiang end at 20051227
				httpServletRequest.setAttribute("coinsFlag", policyDto
						.getPrpCmainDto().getCoinsFlag());
				compensateDto = initPrpLCfeeCoins(httpServletRequest,
						policyDto, editType, compensateDto);
				String conditions2 = "reinsType in ('1','2')  and policyno = '"
						+ claimDto.getPrpLclaimDto().getPolicyNo() + "'";
				BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
				ArrayList reins = (ArrayList) blFcoRepolicyFacade
						.findByConditions(conditions2);
				if (reins != null && reins.size() > 0) {
					httpServletRequest.setAttribute("tempReinsFlag", "1");
				} else {
					httpServletRequest.setAttribute("tempReinsFlag", "0");
				}
			}
			// add by qinyongli end 2005-7-19

			PubTools pubTools = new PubTools();
			int time = pubTools.compareDate(policyDto.getPrpCmainDto()
					.getInputDate().toString(), "2011-02-27");
			if (time < 0) {
				// add by qinyongli start 2005-8-16
				// reason:��ȡΣ�յ�λ��Ϣ
				UIRiskUnitAction uiRiskUnitAction = new UIRiskUnitAction();
				PrpLdangerUnitDto prpLdangerUnitDto = uiRiskUnitAction
						.findByPrimaryKeyFromPrpLdangerUnit(compensateNo, 1,
								httpServletRequest, policyDto.getPrpCmainDto()
										.getRiskCode(), 0);
				if (prpLdangerUnitDto == null) {
					// add by caopeng start 2006-1-9
					prpLdangerUnitDto = uiRiskUnitAction
							.findByPrimaryKeyFromPrpLdangerUnit(claimNo, 1,
									httpServletRequest, prpLcompensateDto
											.getRiskCode(), 0);
					if (prpLdangerUnitDto == null) {
						// add by caopeng end 2006-1-9
						prpLdangerUnitDto = new PrpLdangerUnitDto();
					}
				}
				prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction
						.translateCurrencyCode(prpLdangerUnitDto.getCurrency(),
								true)); // �ô��ֶα�ʾ�ұ�������Ϣ
				httpServletRequest.setAttribute("prpLdangerUnitDto",
						prpLdangerUnitDto);
				// add by qinyongli end 2005-8-16
			} else {
				// ******---------------------��ȡΣ�յ�λ��Ϣ ��Ԫ��Ŀ��
				// start-----------------------------------*/
				BLDangerUnitFacade blDangerFacade = new BLDangerUnitFacade();
				List prpLdangerUnitList = new ArrayList();
				prpLdangerUnitList = blDangerFacade
						.getPrpLdangerUnit(compensateNo);
				httpServletRequest.setAttribute("prpLdangerUnitList",
						prpLdangerUnitList);
				// ******---------------------��ȡΣ�յ�λ��Ϣ ��Ԫ��Ŀ��
				// end-----------------------------------*/
			}

			/*
			 * if(policyDto.getPrpCitemCarDtoList().size()>0) { //�Գ��͵���Ϣ��֧��
			 * PrpCitemCarDto=
			 * (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(0);
			 * prpLcompensateDto.setClauseType(PrpCitemCarDto.getClauseType() );
			 * prpLcompensateDto.setLicenseNo(PrpCitemCarDto.getLicenseNo() );
			 * prpLcompensateDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode() );
			 * prpLcompensateDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
			 * prpLcompensateDto.setBrandName(PrpCitemCarDto.getBrandName() );
			 * prpLcompensateDto.setCarKindCode(PrpCitemCarDto.getCarKindCode() );
			 * prpLcompensateDto.setEngineNo(PrpCitemCarDto.getEngineNo() );
			 * prpLcompensateDto.setFrameNo(PrpCitemCarDto.getFrameNo() );
			 * prpLcompensateDto.setClauseTypeCode(PrpCitemCarDto.getClauseType());//dododo
			 * prpLcompensateDto.setPurchasePrice(String.valueOf(PrpCitemCarDto.getPurchasePrice())); }
			 */
		}

		// ���⽡����Ĭ���ǣ����ա��Ʋ��ա������ա�������Ĭ�Ϸ�

		if (prpLcompensateDto.getFinallyFlag().trim().equals("")) { // modify by
			// ��Ŀ�� ������
			// 27�����޸�Ϊ07
			if ("E".equals(riskType))
				// || prpLcompensateDto.getClassCode().equals("07")
				// || prpLcompensateDto.getClassCode().equals("06"))
				prpLcompensateDto.setFinallyFlag("1");
			else
				prpLcompensateDto.setFinallyFlag("0");
		}

		// ���㱨�����Ϣ
		String tempContext = "";
		String tempContext1 = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList()
					.iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				if (prpLctextDtoTemp.getTextType().equals("7")) {
					tempContext = tempContext + prpLctextDtoTemp.getContext();
				} else if (prpLctextDtoTemp.getTextType().equals("1")) {
					tempContext1 += prpLctextDtoTemp.getContext();
				}

			}
		}
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		prpLctextDto.setContext(tempContext);
		prpLctextDto.setTextType("7");
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		PrpLctextDto prpLctextDto1 = new PrpLctextDto();
		prpLctextDto1.setContext(tempContext1);
		prpLctextDto1.setTextType("1");
		httpServletRequest.setAttribute("prpLctextDto1", prpLctextDto1);

		// ����˵��
		tempContext = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList()
					.iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				if (prpLctextDtoTemp.getTextType().equals(PAY_TEXT)) {
					tempContext = tempContext + prpLctextDtoTemp.getContext();
				}
			}
		}

		PrpLctextDto prpLctextPayTextDto = new PrpLctextDto();
		prpLctextPayTextDto.setContext(tempContext);
		prpLctextPayTextDto.setTextType(PAY_TEXT);
		httpServletRequest.setAttribute("prpLctextPayTextDto",
				prpLctextPayTextDto);

		// �᰸����
		tempContext = "";
		if (compensateDto.getPrpLltextDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLltextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
				if (prpLltextDtoTemp.getTextType().equals("08")) {
					tempContext = tempContext + prpLltextDtoTemp.getContext();
				}
			}
		}

		String taskCode = SysConfig.getProperty("FamilySplittingFlag", "claim");
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		if (taskCode.indexOf(riskcodefortemp) > -1
				&& !prpltextForEar.equals("")) {
			prpLltextDto.setContext(prpltextForEar);
		} else {
			prpLltextDto.setContext(tempContext);
		}
		prpLltextDto.setTextType("08");
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		httpServletRequest.setAttribute("prpLltextDto3", claimDto
				.getPrpLltextDtoList3());

		if (compensateDto.getPrpLlossDtoList() != null) {
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				PrpLlossDto prpLlossDto = (PrpLlossDto) compensateDto
						.getPrpLlossDtoList().get(i);
				prpLlossDto.setKindName(uiCodeAction.translateKindCode(
						"KindCode", prpLlossDto.getKindCode(), true));
				prpLlossDto
						.setCurrency2Name(uiCodeAction.translateCurrencyCode(
								prpLlossDto.getCurrency2(), true));
			}
		}

		if (compensateDto.getPrpLpersonLossDtoList() != null) {
			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
				PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) compensateDto
						.getPrpLpersonLossDtoList().get(i);
				prpLpersonLossDto.setInjuryGradeName(uiCodeAction
						.translateCodeCode("InjuryGrade", prpLpersonLossDto
								.getInjuryGrade(), true));
			}
		}

		// ��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcompensateDto.getPolicyNo(), claimDto.getPrpLclaimDto()
						.getRegistNo());

		httpServletRequest.setAttribute("prpLqualityCheckList", compensateDto
				.getPrpLqualityCheckList());

		// ��Ӱ������� 2005-08-01
		prpLcompensateDto.setCaseType(compensateDto.getPrpLcompensateDto()
				.getCaseType());
		prpLcompensateDto.setCaseTypeName(uiCodeAction.translateCodeCode(
				"CaseCode",
				compensateDto.getPrpLcompensateDto().getClaimType(), true));

		// ������ʵ����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

		// �ڽ�������ʾ�������� 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLcompensateDto.getRiskCode(), true));
		httpServletRequest.setAttribute("riskType", riskType);

		// ------------------------
		PrpLclaimDto prpLclaimDto = compensateDto.getPrpLclaimDto();
		PrpLacciPersonDto prpLacciPersonDto = new PrpLacciPersonDto();
		// ���¹�����Ϣ�����������ˡ��⸶����������Ϣѹ��ҳ����
		ArrayList prpLacciBenPersonDtoList = claimDto
				.getPrplacciBenPersonDtoList();
		ArrayList prpLacciPersonDtoList = compensateDto
				.getPrpLacciPersonDtoList();
		prpLacciPersonDto.setPrpLacciBenPersonList(prpLacciBenPersonDtoList);
		prpLacciPersonDto.setPrpLacciPersonList(prpLacciPersonDtoList);
		ArrayList prpLagriPersonDtoList = compensateDto
				.getPrpLagriPersonDtoList();
		prpLacciPersonDto.setPrpLagriPersonList(prpLagriPersonDtoList);
		httpServletRequest.setAttribute("prpLacciPersonDto", prpLacciPersonDto);
		httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);

		// -----------------------------------------

		// ���ø����ӱ���Ϣ������
		setSubInfo(httpServletRequest, compensateDto);
		// ������������б�
		httpServletRequest.setAttribute("compensateResultMap",
				getCompensateResultList());

	}

	public CompensateDto viewToDtoForJprop(HttpServletRequest httpServletRequest)
			throws Exception {

		// �̳ж�compensate,compensateText��ĸ�ֵ
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));
		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		/*---------------------�⸶�����ϢprpLlossDto------------------------------------*/
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;
		// ����Σ�յ�λ���� add by qinyongli 2005-9-10
		// reason: Ŀǰֻ��һ��Σ�յ�λ�����Ժͱ����Ϣ����һ����������ж��Σ�յ�λ�������Σ�յ�λ��Ϣ���洦��
		ArrayList prpLprpLdangerTotList = new ArrayList(); // ����Σ�յ�λ���ϼ���Ϣ
		ArrayList prpLprpLdangerItemList = new ArrayList(); // �����Σ�յ�λ��Ϣ��
		PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // ���ϼ�Dto
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // ���DTO
		int dangerItemSerialNo = 1; // ���ڴ洢��ĵ����

		String prpLlossDtoCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLlossDtoRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLlossDtoPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");

		String[] prpLlossDtoSerialNo = httpServletRequest
				.getParameterValues("prpLlossDtoSerialNo");
		String[] prpLlossDetailSerialNo = httpServletRequest
				.getParameterValues("prpLlossDetailSerialNo");
		String[] prpLlossSerialNo = httpServletRequest
				.getParameterValues("prpLlossSerialNo");
		String[] prpLlossDtoItemKindNo = httpServletRequest
				.getParameterValues("prpLlossDtoItemKindNo");
		String[] prpLlossDtoFamilyNo = httpServletRequest
				.getParameterValues("prpLlossDtoFamilyNo");
		String[] prpLlossDtoFamilyName = httpServletRequest
				.getParameterValues("prpLlossDtoFamilyName");
		String[] prpLclaimLossAcciCode = httpServletRequest
				.getParameterValues("prpLclaimLossAcciCode");
		String[] prpLlossDtoKindCode = httpServletRequest
				.getParameterValues("prpLlossDtoKindCode");
		String[] prpLlossDtoLicenseNo = httpServletRequest
				.getParameterValues("prpLlossDtoLicenseNo");
		String[] prpLlossDtoItemCode = httpServletRequest
				.getParameterValues("prpLlossDtoItemCode");
		String[] prpLlossDtoLossName = httpServletRequest
				.getParameterValues("prpLlossDtoLossName");
		String[] prpLlossDtoItemAddress = httpServletRequest
				.getParameterValues("prpLlossDtoItemAddress");
		String[] prpLlossDtoFeeTypeCode = httpServletRequest
				.getParameterValues("prpLlossDtoFeeTypeCode");
		String[] prpLlossDtoFeeTypeName = httpServletRequest
				.getParameterValues("prpLlossDtoFeeTypeName");
		String[] prpLlossDtoLossQuantity = httpServletRequest
				.getParameterValues("prpLlossDtoLossQuantity");
		String[] prpLlossDtoUnit = httpServletRequest
				.getParameterValues("prpLlossDtoUnit");
		String[] prpLlossDtoUnitPrice = httpServletRequest
				.getParameterValues("prpLlossDtoUnitPrice");
		String[] prpLlossDtoBuyDate = httpServletRequest
				.getParameterValues("prpLlossDtoBuyDate");
		String[] prpLlossDtoDepreRate = httpServletRequest
				.getParameterValues("prpLlossDtoDepreRate");
		String[] prpLlossDtoCurrency = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency4");
		String[] prpLlossDtoAmount = httpServletRequest
				.getParameterValues("prpLlossDtoAmount");
		String[] prpLlossDtoCurrency1 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency1");
		String[] prpLlossDtoItemValue = httpServletRequest
				.getParameterValues("prpLlossDtoItemValue");
		String[] prpLlossDtoCurrency2 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency2");
		String[] prpLlossDtoSumLoss = httpServletRequest
				.getParameterValues("prpLlossDtoSumLoss");
		String[] prpLlossDtoSumRest = httpServletRequest
				.getParameterValues("prpLlossDtoSumRest");
		String[] prpLlossDtoIndemnityDutyRate = httpServletRequest
				.getParameterValues("prpLlossDtoIndemnityDutyRate");
		String[] prpLlossDtoClaimRate = httpServletRequest
				.getParameterValues("prpLlossDtoClaimRate");
		String[] prpLlossDtoCurrency3 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency3");
		String[] prpLlossDtoDeductibleRate = httpServletRequest
				.getParameterValues("prpLlossDtoDeductibleRate");
		String[] prpLlossDtoDeductible = httpServletRequest
				.getParameterValues("prpLlossDtoDeductible");
		String[] prpLlossDtoCurrency4 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency4");
		String[] prpLlossDtoSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoSumRealPay");
		String[] prpLlossDtoCoinsSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoCoinsSumRealPay");

		// ����ֵ
		if (prpLlossDetailSerialNo == null) {
		} else {
			for (int index = 1; index < prpLlossDetailSerialNo.length; index++) {
				prpLlossDto = new PrpLlossDto();
				prpLlossDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLlossDto.setRiskCode(prpLlossDtoRiskCode);
				prpLlossDto.setCompensateNo(prpLlossDtoCompensateNo);
				prpLlossDto.setSerialNo(index);
				prpLlossDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLlossDtoItemKindNo[index])));

				for (int index2 = 1; index2 < prpLlossDtoSerialNo.length; index2++) {
					if (prpLlossDtoSerialNo[index2]
							.equals(prpLlossSerialNo[index])) {
						prpLlossDto.setFamilyNo(Integer.parseInt(DataUtils
								.nullToZero(prpLlossDtoFamilyNo[index2])));
						prpLlossDto
								.setFamilyName(prpLlossDtoFamilyName[index2]);

						prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// ��prplloss������flag���Ӧ��Ա���
					}

				}
				prpLlossDto.setLicenseNo(prpLlossDtoLicenseNo[index]);
				prpLlossDto.setKindCode(prpLlossDtoKindCode[index]);
				prpLlossDto.setItemCode(prpLlossDtoItemCode[index]);
				prpLlossDto.setLossName(prpLlossDtoLossName[index]);
				prpLlossDto.setItemAddress(prpLlossDtoItemAddress[index]);
				prpLlossDto.setFeeTypeCode(prpLlossDtoFeeTypeCode[index]);
				prpLlossDto.setFeeTypeName(prpLlossDtoFeeTypeName[index]);
				prpLlossDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoLossQuantity[index])));
				prpLlossDto.setUnit(prpLlossDtoUnit[index]);
				prpLlossDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoUnitPrice[index])));
				prpLlossDto.setBuyDate(new DateTime(prpLlossDtoBuyDate[index]));
				prpLlossDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDepreRate[index])));
				prpLlossDto.setCurrency(prpLlossDtoCurrency[index]);
				prpLlossDto.setAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoAmount[index])));
				prpLlossDto.setCurrency1(prpLlossDtoCurrency1[index]);
				prpLlossDto.setItemValue(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoItemValue[index])));
				prpLlossDto.setCurrency2(prpLlossDtoCurrency2[index]);
				prpLlossDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumLoss[index])));
				prpLlossDto.setSumRest(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRest[index])));
				prpLlossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoIndemnityDutyRate[index])));
				prpLlossDto.setClaimRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoClaimRate[index])));
				prpLlossDto.setCurrency3(prpLlossDtoCurrency3[index]);
				prpLlossDto.setDeductibleRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductibleRate[index])));
				prpLlossDto.setDeductible(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductible[index])));
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3��curreny4���(�ն��߼�)
				prpLlossDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRealPay[index])));
				if (null != prpLlossDtoCoinsSumRealPay
						&& prpLlossDtoCoinsSumRealPay.length > 0) {
					if (null != prpLlossDtoCoinsSumRealPay[index]) {
						prpLlossDto
								.setCoinsSumRealPaid(Double
										.parseDouble(DataUtils
												.nullToZero(prpLlossDtoCoinsSumRealPay[index])));
					}
				}
				if (DangerUnitCheckSaveFlag.equals("1")) {
					// ����Σ�յ�λ�ռ� add by qinyongli 2005-9-10
					prpLdangerItemDto = new PrpLdangerItemDto();
					prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // ʵ���
					prpLdangerItemDto.setDangerNo(1); // Ŀǰֻ��һ��Σ�յ�λ
					prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]); // ��ʧ�ұ�
					prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
					prpLdangerItemDto.setKindName("����"); // �ձ��������
					prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); // �ձ�
					prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // ������
					dangerItemSerialNo++;
					prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils
							.nullToZero(prpLlossDtoSumRealPay[index])));// �Ѿ����
					prpLprpLdangerItemList.add(prpLdangerItemDto);
					// add by qinyongli end 2005-9-10
				}
				// ���뼯��
				prpLlossDtoList.add(prpLlossDto);
			}
		}
		// �⸶�����Ϣ
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);

		/*---------------------�⸶����������Ϣ begin ------------------------------------*/
		ArrayList prpLagriPersonList = new ArrayList();
		// prpLagriPersonDtoList

		PrpLacciPersonDto prpLagriPersonDto = null;
		int intFamilyNo = 0;
		String strFamilyName = "";
		if (prpLlossDtoSerialNo == null) {
		} else {

			for (int index2 = 1; index2 < prpLlossDtoSerialNo.length; index2++) {
				prpLagriPersonDto = new PrpLacciPersonDto();
				prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
				prpLagriPersonDto.setCertiType("04"); // ũ���ŵ����⸶��������
				prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLagriPersonDto.setSerialNo(Integer
						.parseInt(prpLlossDtoSerialNo[index2]));
				if (prpLlossDtoFamilyNo[index2] != null
						&& !prpLlossDtoFamilyNo[index2].equals("")) {
					intFamilyNo = Integer.parseInt(prpLlossDtoFamilyNo[index2]);
					strFamilyName = prpLlossDtoFamilyName[index2];
				} else {
					// ����AcciName�Ƿǿ��ֶΣ������ڸ�����˵�����ܲ�ѡ����Ӧ�������ˣ������ȱ����������ƽ��д洢
					intFamilyNo = 2;
					strFamilyName = httpServletRequest
							.getParameter("prpLcompensateInsuredName");
				}
				//
				prpLagriPersonDto.setFamilyNo(intFamilyNo);
				prpLagriPersonDto.setAcciCode(prpLclaimLossAcciCode[index2]);
				prpLagriPersonDto.setAcciName(strFamilyName);// ���⸶������
				prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // ���⸶ţ��
				prpLagriPersonDto.setFlag("");
				prpLagriPersonDto.setAge(0);
				prpLagriPersonDto.setSex("");
				prpLagriPersonDto.setIdentifyNumber("");
				// ���뼯��
				prpLagriPersonList.add(prpLagriPersonDto);
			}
		}

		compensateDto.setPrpLagriPersonDtoList(prpLagriPersonList);

		/*---------------------�⸶����������Ϣ end ------------------------------------*/

		/*---------------------��������ϢprpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// �ӽ���õ���������
		String prpLchargePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLchargeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLchargeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String[] prpLchargeSerialNo = httpServletRequest
				.getParameterValues("prpLchargeSerialNo");
		String[] prpLchargeKindCode = httpServletRequest
				.getParameterValues("prpLchargeKindCode");
		String[] prpLchargeChargeCode = httpServletRequest
				.getParameterValues("prpLchargeChargeCode");
		String[] prpLchargeChargeName = httpServletRequest
				.getParameterValues("prpLchargeChargeName");
		String[] prpLchargeCheckDeptCode = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptCode");
		String[] prpLchargeCheckDeptName = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptName");
		String[] prpLchargeCurrency = httpServletRequest
				.getParameterValues("prpLchargeCurrency");
		String[] prpLchargeChargeAmount = httpServletRequest
				.getParameterValues("prpLchargeChargeAmount");
		String[] prpLpreChargeAmount = httpServletRequest
				.getParameterValues("prpLpreChargeAmount");
		String[] prpLchargeSumRealPay = httpServletRequest
				.getParameterValues("prpLchargeSumRealPay");
		String[] prpLchargeFlag = httpServletRequest
				.getParameterValues("prpLchargeFlag");
		String[] prpLchargeChargeReport = httpServletRequest
				.getParameterValues("prpLchargeChargeReport"); // add 20060512
		String[] prpLchargePayObjectType = httpServletRequest
				.getParameterValues("prpLchargePayObjectType"); // add 20060803
		String[] prpLchargePayObjectCode = httpServletRequest
				.getParameterValues("prpLchargePayObjectCode"); // add 20060803
		String[] prpLchargePayObjectName = httpServletRequest
				.getParameterValues("prpLchargePayObjectName"); // add 20060803

		// ����ֵ
		if (prpLchargeSerialNo == null) {

		} else {
			for (int index = 1; index < prpLchargeSerialNo.length; index++) {
				prpLchargeDto = new PrpLchargeDto();
				prpLchargeDto.setPolicyNo(prpLchargePolicyNo);
				prpLchargeDto.setRiskCode(prpLchargeRiskCode);
				prpLchargeDto.setCompensateNo(prpLchargeCompensateNo);

				prpLchargeDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLchargeSerialNo[index])));
				prpLchargeDto.setKindCode(prpLchargeKindCode[index]);
				prpLchargeDto.setChargeCode(prpLchargeChargeCode[index]);
				prpLchargeDto.setChargeName(prpLchargeChargeName[index]);
				if (prpLchargeChargeCode[index] != null
						&& "14".equals(prpLchargeChargeCode[index])) {
					prpLchargeDto
							.setCheckDeptCode(prpLchargeCheckDeptCode[index]);
					prpLchargeDto
							.setCheckDeptName(prpLchargeCheckDeptName[index]);
				}
				prpLchargeDto.setCurrency(prpLchargeCurrency[index]);
				prpLchargeDto.setChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeChargeAmount[index])));
				prpLchargeDto.setPreChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLpreChargeAmount[index])));
				prpLchargeDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeSumRealPay[index])));
				prpLchargeDto.setFlag(prpLchargeFlag[index]);
				if (prpLchargeChargeReport == null
						|| prpLchargeChargeReport.length < 1) {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeAmount[index]))); // add
					// 20060512
				} else {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeReport[index])));
				}
				prpLchargeDto.setPayObjectCode(prpLchargePayObjectCode[index]);
				prpLchargeDto.setPayObjectType(prpLchargePayObjectType[index]);
				prpLchargeDto.setPayObjectName(prpLchargePayObjectName[index]);
				if (DangerUnitCheckSaveFlag.equals("1")) {
					// ����Σ�յ�λ�ռ� add by qinyongli 2005-9-10
					PrpLdangerItemDto prpLdangerItemChargeDto = new PrpLdangerItemDto();
					prpLdangerItemChargeDto.setCertiNo(prpLchargeCompensateNo); // ʵ���
					prpLdangerItemChargeDto.setDangerNo(1); // Ŀǰֻ��һ��Σ�յ�λ
					prpLdangerItemChargeDto
							.setCurrency(prpLchargeCurrency[index]); // ��ʧ�ұ�
					prpLdangerItemChargeDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
					prpLdangerItemChargeDto.setKindName("����"); // �ձ��������
					prpLdangerItemChargeDto.setRiskCode(prpLchargeRiskCode); // �ձ�
					prpLdangerItemChargeDto.setSerialNo(dangerItemSerialNo); // ������
					dangerItemSerialNo++;
					prpLdangerItemChargeDto.setSumFee(Double
							.parseDouble(DataUtils
									.nullToZero(prpLchargeSumRealPay[index])));
					// �Ѿ����
					prpLprpLdangerItemList.add(prpLdangerItemChargeDto);
					// add by qinyongli end 2005-9-10
				}
				// ���뼯��
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// ��������Ϣ
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// �ӽ���õ���������
		String prpLcfeeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLcfeePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLcfeeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLcfeeCurrency1 = httpServletRequest
				.getParameter("prpLcompensateCurrency");
		String prpLcfeeSumThisPaid = httpServletRequest
				.getParameter("prpLcompensateSumThisPaid");
		String prpLcfeeFlag = httpServletRequest.getParameter("prpLcfeeFlag");
		// ����ֵ
		// ����������Ϣ
		prpLcfeeDto = new PrpLcfeeDto();
		prpLcfeeDto.setCompensateNo(prpLcfeeCompensateNo);
		prpLcfeeDto.setPolicyNo(prpLcfeePolicyNo);
		prpLcfeeDto.setRiskCode(prpLcfeeRiskCode);
		prpLcfeeDto.setCurrency(prpLcfeeCurrency1);
		prpLcfeeDto.setSumPaid(Double.parseDouble(DataUtils
				.nullToZero(prpLcfeeSumThisPaid)));
		prpLcfeeDto.setFlag("");
		prpLcfeeDtoList.add(prpLcfeeDto);
		compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);
		// ����������ڰ����⸶������Ҫ�᰸�����ı�
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");

		ArrayList prpLltextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLltextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			PrpLltextDto prpLltextDto = new PrpLltextDto();
			prpLltextDto.setClaimNo((String) httpServletRequest
					.getParameter("prpLcompensateClaimNo"));
			prpLltextDto.setContext(rules[k]);
			prpLltextDto.setLineNo(k + 1);
			prpLltextDto.setTextType("08");
			prpLltextDtoList.add(prpLltextDto);
		}
		compensateDto.setPrpLltextDtoList(prpLltextDtoList);

		compensateDto.getPrpLcompensateDto().setFinallyFlag(
				prpLcompensateFinallyFlag);

		if (DangerUnitCheckSaveFlag.equals("1")) {
			// ----------------------------Σ�յ�λ��Ϣ����,Ŀǰֻ��һ��Σ�յ�λ
			String TCurrency = httpServletRequest.getParameter("MergeCurrency");
			// ��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10
			compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
			// �Ա����Ϣ���д����õ��ϼ���Ϣ
			ArrayList itemListAll = (ArrayList) prpLprpLdangerItemList.clone();
			ArrayList itemList = (ArrayList) prpLprpLdangerItemList.clone();
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto(); // ��ȡÿ����Ķ���
			PrpLdangerItemDto dangerItem = new PrpLdangerItemDto(); // ѭ���ж�ʱʹ��
			ArrayList tempCurrency = new ArrayList();
			Iterator itemListIteratorAll = itemListAll.iterator();
			Iterator itemListIterator = itemList.iterator();
			PrpLdangerItemDto dangerItemAll1 = new PrpLdangerItemDto();
			while (itemListIteratorAll.hasNext()) {
				dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll.next();
				dangerItemAll1 = new PrpLdangerItemDto();
				dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
				dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());

				// �õ�ǰ�ұ�������Ͻ���ͳ��
				String currentCur = dangerItemAll1.getCurrency();
				if (tempCurrency.contains(currentCur)) {
					continue; // ����Ѿ��ϼƹ��ı��֣����ٽ��кϼ�;
				}
				int currentSerial = dangerItemAll1.getSerialNo();
				while (itemListIterator.hasNext()) {
					dangerItem = (PrpLdangerItemDto) itemListIterator.next();
					// ����ұ���ȣ�����⳥���ͷ��ý����ۼ�
					if (currentSerial != dangerItem.getSerialNo()
							&& currentCur.equals(dangerItem.getCurrency())) {
						dangerItemAll1.setSumFee(dangerItemAll1.getSumFee()
								+ dangerItem.getSumFee()); // �ϼƷ���
						dangerItemAll1.setSumPaid(dangerItemAll1.getSumPaid()
								+ dangerItem.getSumPaid()); // �ϼƽ��
					}
				}
				tempCurrency.add(currentCur); // ����ǰ�ϼƵı����ݴ� ;
				// �������Ϣ����ϼ�Dto
				if (dangerItemAll != null) {
					prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
					prpLdangerTotDto.setDangerNo(1); // Ŀǰ����һ��Σ�յ�λ
					prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); // ���ԭ�ұ�
					prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
					prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
					prpLdangerTotDto.setTCurrency(TCurrency);
					// ���бұ�ת�� ת����ıұ�ΪTCurrency
					String SCurrency = dangerItemAll.getCurrency(); // ԭ�ұ�
					double exchangeRate = PubTools.getExchangeRate(SCurrency,
							TCurrency, String.valueOf(new Date()));
					prpLdangerTotDto.setExchRate(exchangeRate);
					prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()
							* exchangeRate);
					prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()
							* exchangeRate);
				}
				if (prpLdangerTotDto != null) {
					prpLprpLdangerTotList.add(prpLdangerTotDto);
				}
			}
			compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			// ��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10 end
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061130 start reason ���ٱ�������
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061130 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// �ӽ���õ���������
			String compensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");
			String[] prpLdangerClaimNo = httpServletRequest
					.getParameterValues("prpLdangerClaimNo");
			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDesc");
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerAddressName");
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");

			String[] prpLdangerRiskSumClaim = httpServletRequest
					.getParameterValues("prpLdangerRiskSumClaim");
			String[] prpLdangerRiskSumPaid = httpServletRequest
					.getParameterValues("prpLdangerRiskSumPaid");
			String[] prpLcompensateSumThisPaid = httpServletRequest
					.getParameterValues("prpLcompensateSumThisPaid");
			String[] prpLdangerProportion = httpServletRequest
					.getParameterValues("prpLdangerProportion");
			String prpLcompensateSumNoDutyFee = httpServletRequest
					.getParameter("prpLcompensateSumNoDutyFee");
			// ����ֵ
			if (prpLdangerCurrency == null) {
			} else {
				for (int index = 0; index < prpLdangerCurrency.length; index++) {
					prpLdangerUnitDto = new PrpLdangerUnitDto();
					prpLdangerUnitDto.setCertiNo(compensateNo);
					prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
					prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
					prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
					prpLdangerUnitDto.setDangerNo(index + 1);
					prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
					prpLdangerUnitDto
							.setAddressName(prpLdangerAddressName[index]);
					prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
					prpLdangerUnitDto.setSumLoss(Double
							.parseDouble(prpLdangerRiskSumClaim[index]));
					prpLdangerUnitDto.setSumPaid(Double
							.parseDouble(prpLdangerRiskSumPaid[index]));
					prpLdangerUnitDto.setBusinessNature(prpCmainDto
							.getBusinessNature());
					prpLdangerUnitDto.setPolicyBizType(prpCmainDto
							.getPolicyBizType());
					prpLdangerUnitDto
							.setPolicyType(prpCmainDto.getPolicyType());
					prpLdangerUnitDto.setBusinessType(prpCmainDto
							.getBusinessType());
					prpLdangerUnitDto.setBusinessType1(prpCmainDto
							.getBusinessType1());
					prpLdangerUnitDto.setOthFlag(prpCmainDto.getOthFlag());
					prpLdangerUnitDto.setBusinessProvince(prpCmainDto
							.getBusinessProvince());
					prpLdangerUnitDto.setBusinessTown(prpCmainDto
							.getBusinessTown());
					prpLdangerUnitDto.setBusinessCounty(prpCmainDto
							.getBusinessCounty());
					prpLdangerUnitDto.setBusinessAreaName(prpCmainDto
							.getBusinessAreaName());
					// prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
					// ��������ȡʵ��
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						double sumPaid = claimDto.getPrpLclaimDto()
								.getSumPaid();
						prpLdangerUnitDto.setSumNoPaid(Double
								.parseDouble(prpLdangerRiskSumClaim[index])
								- sumPaid);
					}
					if ("1".equals(prpLcompensateFinallyFlag)) {
						prpLdangerUnitDto.setCertiType("3");// ����Ϊʵ��
						prpLdangerUnitDto.setSumNoPaid(0); // �᰸ δ���������
					} else {
						prpLdangerUnitDto.setCertiType("3");
						prpLdangerUnitDto
								.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()
										- Double
												.parseDouble(prpLcompensateSumThisPaid[index]));
					}
					prpLdangerUnitDto.setDangerShare(Double
							.parseDouble(prpLdangerProportion[index]));
					prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);// add by
					// kangzhen
					prpLdangerUnitDto.setDamageDate(compensateDto
							.getPrpLcompensateDto().getDamageStartDate());
					// ���뼯��
					if (prpLdangerPolicyNo[index] != null
							&& !(prpLdangerPolicyNo[index].equals(""))) {
						dangerUnitList.add(prpLdangerUnitDto);
					}
				}
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {

			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// start------------------------------------*/

			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();

			ArrayList dangerUnitList = new ArrayList();
			ArrayList dangerItemList = new ArrayList();
			ArrayList dangerTotList = new ArrayList();
			ArrayList  prpLchargeList = compensateDto.getPrpLchargeDtoList();
	        PrpLchargeDto lchargeDto = null;
	        boolean isfee;

			double temp = 0;
			double sumDangerUnit = 0d;
			boolean flag = true;
			String sql = "";
			// �ӽ���õ���������

			String prpLdangerCompensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");// �������

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");// ������
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");// ���ֺ�
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");// Σ�յ�λ����
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");// Σ�յ�λ��ַ
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");// �ұ�
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");// �⸶���
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");// Σ�յ�λ��
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");// ռ��
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");// �ձ����
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");// �ձ�����
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");// ��Ĵ���
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");// �������
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// ������

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// ҵ����Դ
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// ����ҵ������
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// Ͷ����ʽ
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// �����Ա�־
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// ��ũ��ʶ
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// ������ʶ�ֶ�
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// ��������ʡ
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// ����������
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// ����������
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// ������������
			// 1�����ɴ����Σ�յ�λ���prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto(); // ���DTO
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer
							.parseInt(prpLdangerDangerNo[index])); // Σ�յ�λ
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); // ��ʧ�ұ�
					prpLdangerItemNewDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); // �ձ�
					prpLdangerItemNewDto
							.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto
							.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					// ռ�����һ������ԭ��
					flag = true;
					for (int i = index + 1; i < prpLdangerCurrency.length; i++) {
						if (prpLdangerUnitItemKindNo[index].equals(prpLdangerUnitItemKindNo[i])) {
							flag = false;
						}
					}
					if (flag) {
						temp = 0;
						for (int k = 1; k < index; k++) {
							if (prpLdangerUnitItemKindNo[k].equals(prpLdangerUnitItemKindNo[index])) {
								temp += Str.round(Double.parseDouble(prpLdangerShare[k]), 2);
							}
						}
						prpLdangerItemNewDto.setDangerKindShare(Str.round(100 - temp, 2));
					} else {
						prpLdangerItemNewDto.setDangerKindShare(Double.parseDouble(prpLdangerShare[index]));
					}
					isfee = false; //�Ƿ��з��ã���������ֵ���Ӧ���ձ����ͱ�Ĵ���
	                  if(prpLchargeList != null && prpLchargeList.size()>0){
	                	 lchargeDto = new PrpLchargeDto();
	                	 for(int c=0;c<prpLchargeList.size();c++){
	                		lchargeDto = (PrpLchargeDto) prpLchargeList.get(c);
	                		if(lchargeDto.getKindCode().equals(prpLdangerKindcode[index])){
	                			isfee = true;
	     	           			break;
	                		}
   	                  	}
	                  }
	                  if(isfee){
	                	prpLdangerItemNewDto.setSumFee(Str.round((lchargeDto.getChargeAmount()-lchargeDto.getSumRealPay()),2));
	                	prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }else{
	                	prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }
	                   prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // ������
				
	                   sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// ���뼯��
					if (prpLdangerItemDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // ���DTO
			boolean find = true;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itTot = dangerTotList.iterator();
					while (itTot.hasNext()) {
						prpLdangerTotNewDto = (PrpLdangerTotDto) itTot.next();
						if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerTotNewDto.setSumPaid(Str.round(prpLdangerTotDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumPaidEx(Str.round(prpLdangerTotDto.getSumPaidEx() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumFee(Str.round(prpLdangerTotDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
	           				prpLdangerTotNewDto.setSumFeeEx(Str.round(prpLdangerTotDto.getSumFeeEx()+prpLdangerItemNewDto.getSumFee(),2));
							break;
						}
					}
					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemDto.getCurrency()); // ���ԭ�ұ�
						prpLdangerTotNewDto.setSumFee(prpLdangerItemDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
						// ���뼯��
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3������Σ�յ�λprpLdangerUnit
			com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit dbPrpLdangerUnit = null ;
			Iterator itUnit = null;
			PrpLdangerUnitDto prpLdangerUnitNewDto = null;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itUnit = dangerUnitList.iterator();
					while (itUnit.hasNext()) {
						prpLdangerUnitNewDto = (PrpLdangerUnitDto) itUnit.next();
						if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerUnitNewDto.setSumFee(Str.round(prpLdangerUnitNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
	           				prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
							break;
						}
					}

					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {

						prpLdangerUnitNewDto = new PrpLdangerUnitDto();
						prpLdangerUnitNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerUnitNewDto.setClaimNo(compensateDto.getPrpLcompensateDto().getClaimNo());
						prpLdangerUnitNewDto.setCertiType("3");
						prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto.getRiskCode());
						prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto.getPolicyno());
						prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto.getDangerdesc());
						prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto.getAddressName());
						prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerUnitNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						dbPrpLdangerUnit = new com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit();
						dbPrpLdangerUnit.getInfo(compensateDto.getPrpLcompensateDto().getCaseNo(), ""+prpLdangerUnitNewDto.getDangerNo());
						if(!"".equals(dbPrpLdangerUnit.getSumLoss()) && !"".equals(prpLdangerItemNewDto.getSumPaid())){
    						prpLdangerUnitNewDto.setSumNoPaid(Double.parseDouble(dbPrpLdangerUnit.getSumLoss()) - prpLdangerItemNewDto.getSumPaid());
    					}
						prpLdangerUnitNewDto.setCoinsFlag(strCoinsFlag);
						prpLdangerUnitNewDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitNewDto.setAgricultureflag(prpCmainDto.getBusinessType1());
						prpLdangerUnitNewDto.setBusinessNature(prpLdangerBusinessNature[1]);
						prpLdangerUnitNewDto.setPolicyBizType(prpLdangerPolicyBizType[1]);
						prpLdangerUnitNewDto.setPolicyType(prpLdangerPolicyType[1]);
						prpLdangerUnitNewDto.setBusinessType(prpLdangerBusinessType[1]);
						prpLdangerUnitNewDto.setBusinessType1(prpLdangerBusinessType1[1]);
						prpLdangerUnitNewDto.setOthFlag(prpLdangerOthFlag[1]);
						prpLdangerUnitNewDto.setBusinessProvince(prpLdangerBusinessProvince[1]);
						prpLdangerUnitNewDto.setBusinessTown(prpLdangerBusinessTown[1]);
						prpLdangerUnitNewDto.setBusinessCounty(prpLdangerBusinessCounty[1]);
						prpLdangerUnitNewDto.setBusinessAreaName(prpLdangerBusinessAreaName[1]);
						// ���뼯��
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// ���һ��ռ�ȼ���ԭ��
				double dangerShare = 0;
				double tempSumDangerShare = 0;
				ClaimDto claimDto = new ClaimDto();
				UIClaimAction uiclaimAction = new UIClaimAction();
				claimDto = uiclaimAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getClaimNo());
				double tempSumLoss = 0;
				double temSumFee=0;
				double sumTempSumLoss = 0;
				double tempSumNoPaid = 0;
				double sumTempNoPaid = 0;
				PrpLdangerUnitDto prpLdangerUnitDtotemp = null;
				for (int i = 0; i < dangerUnitList.size(); i++) {
					prpLdangerUnitDtotemp = (PrpLdangerUnitDto) dangerUnitList.get(i);
					if (i == (dangerUnitList.size() - 1)) {
						dangerShare = Str.round(100 - tempSumDangerShare, 2);
						tempSumNoPaid = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid() - sumTempNoPaid, 2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - sumTempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					} else {
						dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid() / sumDangerUnit * 100, 2);
						tempSumDangerShare = Str.round(tempSumDangerShare + dangerShare, 2);
						tempSumNoPaid = Str.round((claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid())* dangerShare / 100, 2);
						sumTempNoPaid = Str.round(sumTempSumLoss + tempSumLoss,2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim()* dangerShare / 100, 2);
						sumTempSumLoss = Str.round(sumTempSumLoss + tempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					}
					prpLdangerUnitDtotemp.setDangerShare(dangerShare);
					prpLdangerUnitDtotemp.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
					prpLdangerUnitDtotemp.setSumLoss(tempSumLoss);
					prpLdangerUnitDtotemp.setSumFee(temSumFee);
					if ("1".equals(prpLcompensateFinallyFlag)) {
						prpLdangerUnitDtotemp.setSumNoPaid(0); // �᰸ δ���������
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid() - compensateDto.getPrpLcompensateDto().getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// end------------------------------------*/

		}
		return compensateDto;

	}

	// Add by chenrd begin 20070719
	// Reason:ũ���ŵ��������
	public CompensateDto viewToDtoForAgri(HttpServletRequest httpServletRequest)
			throws Exception {

		System.err.println("1111111111111");
		// �̳ж�compensate,compensateText��ĸ�ֵ
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));

		/*---------------------�⸶�����ϢprpLlossDto------------------------------------*/
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;

		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		// ����Σ�յ�λ���� add by qinyongli 2005-9-10
		// reason: Ŀǰֻ��һ��Σ�յ�λ�����Ժͱ����Ϣ����һ����������ж��Σ�յ�λ�������Σ�յ�λ��Ϣ���洦��
		ArrayList prpLprpLdangerTotList = new ArrayList(); // ����Σ�յ�λ���ϼ���Ϣ
		ArrayList prpLprpLdangerItemList = new ArrayList(); // �����Σ�յ�λ��Ϣ��
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // ���DTO
		int dangerItemSerialNo = 1; // ���ڴ洢��ĵ����

		String prpLlossDtoCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLlossDtoRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLlossDtoPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");

		String[] prpLlossDtoSerialNo = httpServletRequest
				.getParameterValues("prpLlossDtoSerialNo");
		String[] prpLlossDetailSerialNo = httpServletRequest
				.getParameterValues("prpLlossDetailSerialNo");
		String[] prpLlossSerialNo = httpServletRequest
				.getParameterValues("prpLlossSerialNo");
		String[] prpLlossDtoItemKindNo = httpServletRequest
				.getParameterValues("prpLlossDtoItemKindNo");
		String[] prpLlossDtoFamilyNo = httpServletRequest
				.getParameterValues("prpLlossDtoFamilyNo");
		String[] prpLlossDtoFamilyName = httpServletRequest
				.getParameterValues("prpLlossDtoFamilyName");
		String[] prpLclaimLossAcciCode = httpServletRequest
				.getParameterValues("prpLclaimLossAcciCode");
		String[] prpLlossDtoKindCode = httpServletRequest
				.getParameterValues("prpLlossDtoKindCode");
		String[] prpLlossDtoLicenseNo = httpServletRequest
				.getParameterValues("prpLlossDtoLicenseNo");
		String[] prpLlossDtoItemCode = httpServletRequest
				.getParameterValues("prpLlossDtoItemCode");
		String[] prpLlossDtoLossName = httpServletRequest
				.getParameterValues("prpLlossDtoLossName");
		String[] prpLlossDtoItemAddress = httpServletRequest
				.getParameterValues("prpLlossDtoItemAddress");
		String[] prpLlossDtoFeeTypeCode = httpServletRequest
				.getParameterValues("prpLlossDtoFeeTypeCode");
		String[] prpLlossDtoFeeTypeName = httpServletRequest
				.getParameterValues("prpLlossDtoFeeTypeName");
		String[] prpLlossDtoLossQuantity = httpServletRequest
				.getParameterValues("prpLlossDtoLossQuantity");
		String[] prpLlossDtoUnit = httpServletRequest
				.getParameterValues("prpLlossDtoUnit");
		String[] prpLlossDtoUnitPrice = httpServletRequest
				.getParameterValues("prpLlossDtoUnitPrice");
		String[] prpLlossDtoBuyDate = httpServletRequest
				.getParameterValues("prpLlossDtoBuyDate");
		String[] prpLlossDtoDepreRate = httpServletRequest
				.getParameterValues("prpLlossDtoDepreRate");
		String[] prpLlossDtoCurrency = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency4");
		String[] prpLlossDtoAmount = httpServletRequest
				.getParameterValues("prpLlossDtoAmount");
		String[] prpLlossDtoCurrency1 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency1");
		String[] prpLlossDtoItemValue = httpServletRequest
				.getParameterValues("prpLlossDtoItemValue");
		String[] prpLlossDtoCurrency2 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency2");
		String[] prpLlossDtoSumLoss = httpServletRequest
				.getParameterValues("prpLlossDtoSumLoss");
		String[] prpLlossDtoSumRest = httpServletRequest
				.getParameterValues("prpLlossDtoSumRest");
		String[] prpLlossDtoIndemnityDutyRate = httpServletRequest
				.getParameterValues("indemnityDutyRate");
		String[] prpLlossDtoClaimRate = httpServletRequest
				.getParameterValues("prpLlossDtoClaimRate");
		String[] prpLlossDtoCurrency3 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency3");
		String[] prpLlossDtoDeductibleRate = httpServletRequest
				.getParameterValues("prpLlossDtoDeductibleRate");
		String[] prpLlossDtoDeductible = httpServletRequest
				.getParameterValues("prpLlossDtoDeductible");
		String[] prpLlossDtoCurrency4 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency4");
		String[] prpLlossDtoSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoSumRealPay");
		String[] prpLlossDtoSettleArea = httpServletRequest
				.getParameterValues("prpLlossDtoSettleArea");
		String[] indemnityDutyRate = httpServletRequest
				.getParameterValues("indemnityDutyRate");
		// ��ֲ��ר�� ������ʽ�ͼ��㷽ʽ
		String[] prpLlossDtoCalaType = httpServletRequest
				.getParameterValues("calaType");
		String[] prpLlossDtoCala = httpServletRequest
				.getParameterValues("cala");

		// ������ֲ���жϲ�����
		String planting31FarmerListFlag = SysConfig.getProperty(
				"PLNATING_31_FARMER_LIST_FLAG", "claim");
		String[] prpLlossDtoCoinsSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoCoinsSumRealPay");

		// ����ֵ
		if (prpLlossDetailSerialNo == null) {

		} else {
			for (int index = 1; index < prpLlossDetailSerialNo.length; index++) {
				prpLlossDto = new PrpLlossDto();
				prpLlossDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLlossDto.setRiskCode(prpLlossDtoRiskCode);
				prpLlossDto.setCompensateNo(prpLlossDtoCompensateNo);
				prpLlossDto.setSerialNo(index);
				prpLlossDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLlossDtoItemKindNo[index])));

				if ("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182"
						.indexOf(prpLlossDtoRiskCode) > -1
						&& null != prpLlossDtoSettleArea
						&& null != indemnityDutyRate) {
					for (int index2 = 0; index2 < prpLlossDtoSerialNo.length; index2++) {
						prpLlossDto.setFamilyNo(Integer.parseInt(DataUtils
								.nullToZero(prpLlossDtoFamilyNo[index2])));
						prpLlossDto
								.setFamilyName(prpLlossDtoFamilyName[index2]);
						prpLlossDto.setLicenseNo(prpLlossDtoLicenseNo[index2]);
						prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// ����ũ����prplloss������flag���Ӧ��Ա���
					}
				} else if (null != planting31FarmerListFlag
						&& planting31FarmerListFlag
								.indexOf(prpLlossDtoRiskCode) > -1
						&& null != prpLlossDtoSettleArea
						&& null != indemnityDutyRate) {
					for (int index2 = 0; index2 < prpLlossDtoSerialNo.length; index2++) {
						prpLlossDto.setFamilyNo(Integer.parseInt(DataUtils
								.nullToZero(prpLlossDtoFamilyNo[index2])));
						prpLlossDto
								.setFamilyName(prpLlossDtoFamilyName[index2]);
						prpLlossDto.setLicenseNo(prpLlossDtoLicenseNo[index2]);
						prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// ����ũ����prplloss������flag���Ӧ��Ա���
					}
				} else {
					for (int index2 = 1; index2 < prpLlossDtoSerialNo.length; index2++) {
						if (prpLlossDtoSerialNo[index2]
								.equals(prpLlossSerialNo[index])) {
							prpLlossDto.setFamilyNo(Integer.parseInt(DataUtils
									.nullToZero(prpLlossDtoFamilyNo[index2])));
							prpLlossDto
									.setFamilyName(prpLlossDtoFamilyName[index2]);
							prpLlossDto
									.setLicenseNo(prpLlossDtoLicenseNo[index2]);
							prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// ����ũ����prplloss������flag���Ӧ��Ա���
						}

					}
				}
				prpLlossDto.setKindCode(prpLlossDtoKindCode[index]);
				prpLlossDto.setItemCode(prpLlossDtoItemCode[index]);
				prpLlossDto.setLossName(prpLlossDtoLossName[index]);
				prpLlossDto.setItemAddress(prpLlossDtoItemAddress[index]);
				prpLlossDto.setFeeTypeCode(prpLlossDtoFeeTypeCode[index]);
				prpLlossDto.setFeeTypeName(prpLlossDtoFeeTypeName[index]);
				prpLlossDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoLossQuantity[index])));
				prpLlossDto.setUnit(prpLlossDtoUnit[index]);
				prpLlossDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoUnitPrice[index])));
				prpLlossDto.setBuyDate(new DateTime(prpLlossDtoBuyDate[index]));
				prpLlossDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDepreRate[index])));
				prpLlossDto.setCurrency(prpLlossDtoCurrency[index]);
				prpLlossDto.setAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoAmount[index])));
				prpLlossDto.setCurrency1(prpLlossDtoCurrency1[index]);
				// ��Ԫ��ֲ�չ�ʽ������ҳ��ȥ���˱��ռ�ֵ
				if ("31".equals(prpLlossDtoRiskCode.substring(0, 2))) {
					prpLlossDto.setItemValue(0.00);
					prpLlossDto.setRemark(prpLlossDtoCalaType[index] + "-"
							+ prpLlossDtoCala[index]);
				} else if ("3219".equals(prpLlossDtoRiskCode)) {
					prpLlossDto.setItemValue(0.00);
					prpLlossDto.setRemark(prpLlossDtoCalaType[index]);
				} else if ("3228".equals(prpLlossDtoRiskCode)
						|| "3224".equals(prpLlossDtoRiskCode)
						|| "3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182"
								.indexOf(prpLlossDtoRiskCode) > -1) {
					prpLlossDto.setItemValue(0.00);
					if (prpLlossDtoCalaType != null)
						prpLlossDto.setRemark(prpLlossDtoCalaType[index]);
				} else {
					prpLlossDto.setItemValue(Double.parseDouble(DataUtils
							.nullToZero(prpLlossDtoItemValue[index])));
				}
				prpLlossDto.setCurrency2(prpLlossDtoCurrency2[index]);
				prpLlossDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumLoss[index])));
				prpLlossDto.setSumRest(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRest[index])));
				prpLlossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoIndemnityDutyRate[index])));
				prpLlossDto.setClaimRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoClaimRate[index])));
				prpLlossDto.setCurrency3(prpLlossDtoCurrency3[index]);
				prpLlossDto.setDeductibleRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductibleRate[index])));
				prpLlossDto.setDeductible(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductible[index])));
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3��curreny4���(�ն��߼�)
				prpLlossDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRealPay[index])));
				if (null != prpLlossDtoCoinsSumRealPay
						&& prpLlossDtoCoinsSumRealPay.length > 0) {
					if (null != prpLlossDtoCoinsSumRealPay[index]) {
						prpLlossDto
								.setCoinsSumRealPaid(Double
										.parseDouble(DataUtils
												.nullToZero(prpLlossDtoCoinsSumRealPay[index])));
					}
				}
				if ("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182"
						.indexOf(prpLlossDtoRiskCode) > -1
						&& null != prpLlossDtoSettleArea
						&& null != indemnityDutyRate) {
					prpLlossDto.setSettleArea(Double.parseDouble(DataUtils
							.nullToZero(prpLlossDtoSettleArea[index])));
					prpLlossDto.setLossrate(Double.parseDouble(DataUtils
							.nullToZero(indemnityDutyRate[index])));
				}
				if (null != planting31FarmerListFlag
						&& planting31FarmerListFlag
								.indexOf(prpLlossDtoRiskCode) > -1
						&& null != prpLlossDtoSettleArea
						&& null != indemnityDutyRate) {
					prpLlossDto.setSettleArea(Double.parseDouble(DataUtils
							.nullToZero(prpLlossDtoSettleArea[index])));
					prpLlossDto.setLossrate(Double.parseDouble(DataUtils
							.nullToZero(indemnityDutyRate[index])));
				} else if (null != prpLlossDtoSettleArea)
					prpLlossDto.setSettleArea(Double.parseDouble(DataUtils
							.nullToZero(prpLlossDtoSettleArea[index])));
				// ��Ԫ��prpLdangerItem������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); //ʵ���
				 * prpLdangerItemDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]);
				 * //��ʧ�ұ� prpLdangerItemDto.setKindFlag("0"); //�ձ�����־,0��ʾ����
				 * prpLdangerItemDto.setKindName("����"); //�ձ��������
				 * prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); //�ձ�
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //������
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));//�Ѿ����
				 * prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				prpLlossDtoList.add(prpLlossDto);
			}
		}
		// �⸶�����Ϣ
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);

		/*---------------------�⸶����������Ϣ begin ------------------------------------*/
		ArrayList prpLagriPersonList = new ArrayList();
		// prpLagriPersonDtoList

		PrpLacciPersonDto prpLagriPersonDto = null;
		int intFamilyNo = 0;
		String strFamilyName = "";
		System.err.println("prpLlossDtoRiskCode" + "prpLlossDtoRiskCode");
		// yx
		boolean hasHeadInsureList = false;
		String conditionsOfFatchInsureMainList = " policyNo = '"
				+ prpLlossDtoPolicyNo + "' and validity = '2' ";
		BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
		Collection blInsureMainListCollection = blInsureMainListFacade
				.findByConditions(conditionsOfFatchInsureMainList);
		// System.err.println(conditionsOfFatchInsureMainList);
		if (null != blInsureMainListCollection
				&& blInsureMainListCollection.size() > 0) {
			hasHeadInsureList = true;
		}

		if (prpLlossDtoSerialNo != null) {
			if ("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182"
					.indexOf(prpLlossDtoRiskCode) > -1
					&& null != prpLlossDtoSettleArea
					&& null != indemnityDutyRate && hasHeadInsureList) {
				for (int index2 = 0; index2 < prpLlossDtoSerialNo.length; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // ũ���ŵ����⸶��������
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[0]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// ����AcciName�Ƿǿ��ֶΣ������ڸ�����˵�����ܲ�ѡ����Ӧ�������ˣ������ȱ����������ƽ��д洢
						intFamilyNo = 2;
						strFamilyName = httpServletRequest
								.getParameter("prpLcompensateInsuredName");
					}
					//
					prpLagriPersonDto.setFamilyNo(intFamilyNo);
					if (prpLclaimLossAcciCode.length >= index2 + 1) {
						prpLagriPersonDto
								.setAcciCode(prpLclaimLossAcciCode[index2]);
					}
					prpLagriPersonDto.setAcciName(strFamilyName);// ���⸶������
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // ���⸶ţ��
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// ���뼯��
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			} else if (null != planting31FarmerListFlag
					&& planting31FarmerListFlag.indexOf(prpLlossDtoRiskCode) > -1
					&& null != prpLlossDtoSettleArea
					&& null != indemnityDutyRate) {
				for (int index2 = 0; index2 < prpLlossDtoSerialNo.length; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // ũ���ŵ����⸶��������
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[0]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// ����AcciName�Ƿǿ��ֶΣ������ڸ�����˵�����ܲ�ѡ����Ӧ�������ˣ������ȱ����������ƽ��д洢
						intFamilyNo = 2;
						strFamilyName = httpServletRequest
								.getParameter("prpLcompensateInsuredName");
					}
					//
					prpLagriPersonDto.setFamilyNo(intFamilyNo);
					if (prpLclaimLossAcciCode.length >= index2 + 1) {
						prpLagriPersonDto
								.setAcciCode(prpLclaimLossAcciCode[index2]);
					}
					prpLagriPersonDto.setAcciName(strFamilyName);// ���⸶������
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // ���⸶ţ��
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// ���뼯��
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			} else if ("3204".equals(prpLlossDtoRiskCode)) {
				System.err.println("1111111111111");
				for (int index2 = 1; index2 < 2; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // ũ���ŵ����⸶��������
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[index2]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// ����AcciName�Ƿǿ��ֶΣ������ڸ�����˵�����ܲ�ѡ����Ӧ�������ˣ������ȱ����������ƽ��д洢
						intFamilyNo = 2;
						strFamilyName = httpServletRequest
								.getParameter("prpLcompensateInsuredName");
					}
					//
					prpLagriPersonDto.setFamilyNo(intFamilyNo);
					if (prpLclaimLossAcciCode.length >= index2 + 1) {
						prpLagriPersonDto
								.setAcciCode(prpLclaimLossAcciCode[index2]);
					}
					prpLagriPersonDto.setAcciName(strFamilyName);// ���⸶������
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // ���⸶ţ��
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// ���뼯��
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			} else {
				for (int index2 = 1; index2 < prpLlossDtoSerialNo.length; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // ũ���ŵ����⸶��������
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[index2]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// ����AcciName�Ƿǿ��ֶΣ������ڸ�����˵�����ܲ�ѡ����Ӧ�������ˣ������ȱ����������ƽ��д洢
						intFamilyNo = 2;
						strFamilyName = httpServletRequest
								.getParameter("prpLcompensateInsuredName");
					}
					//
					prpLagriPersonDto.setFamilyNo(intFamilyNo);
					if (prpLclaimLossAcciCode.length >= index2 + 1) {
						prpLagriPersonDto
								.setAcciCode(prpLclaimLossAcciCode[index2]);
					}
					prpLagriPersonDto.setAcciName(strFamilyName);// ���⸶������
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // ���⸶ţ��
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// ���뼯��
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			}
		}

		compensateDto.setPrpLagriPersonDtoList(prpLagriPersonList);

		/*---------------------�⸶����������Ϣ end ------------------------------------*/

		/*---------------------��������ϢprpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// �ӽ���õ���������
		String prpLchargePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLchargeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLchargeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String[] prpLchargeSerialNo = httpServletRequest
				.getParameterValues("prpLchargeSerialNo");
		String[] prpLchargeKindCode = httpServletRequest
				.getParameterValues("prpLchargeKindCode");
		String[] prpLchargeChargeCode = httpServletRequest
				.getParameterValues("prpLchargeChargeCode");
		String[] prpLchargeChargeName = httpServletRequest
				.getParameterValues("prpLchargeChargeName");
		String[] prpLchargeCheckDeptCode = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptCode");
		String[] prpLchargeCheckDeptName = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptName");
		String[] prpLchargeCurrency = httpServletRequest
				.getParameterValues("prpLchargeCurrency");
		String[] prpLchargeChargeAmount = httpServletRequest
				.getParameterValues("prpLchargeChargeAmount");
		String[] prpLpreChargeAmount = httpServletRequest
				.getParameterValues("prpLpreChargeAmount");
		String[] prpLchargeSumRealPay = httpServletRequest
				.getParameterValues("prpLchargeSumRealPay");
		String[] prpLchargeFlag = httpServletRequest
				.getParameterValues("prpLchargeFlag");
		String[] prpLchargeChargeReport = httpServletRequest
				.getParameterValues("prpLchargeChargeReport"); // add 20060512
		String[] prpLchargePayObjectType = httpServletRequest
				.getParameterValues("prpLchargePayObjectType"); // add 20060803
		String[] prpLchargePayObjectCode = httpServletRequest
				.getParameterValues("prpLchargePayObjectCode"); // add 20060803
		String[] prpLchargePayObjectName = httpServletRequest
				.getParameterValues("prpLchargePayObjectName"); // add 20060803

		// ����ֵ
		if (prpLchargeSerialNo == null) {

		} else {
			for (int index = 1; index < prpLchargeSerialNo.length; index++) {
				prpLchargeDto = new PrpLchargeDto();
				prpLchargeDto.setPolicyNo(prpLchargePolicyNo);
				prpLchargeDto.setRiskCode(prpLchargeRiskCode);
				prpLchargeDto.setCompensateNo(prpLchargeCompensateNo);

				prpLchargeDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLchargeSerialNo[index])));
				prpLchargeDto.setKindCode(prpLchargeKindCode[index]);
				prpLchargeDto.setChargeCode(prpLchargeChargeCode[index]);
				prpLchargeDto.setChargeName(prpLchargeChargeName[index]);
				if (prpLchargeChargeCode[index] != null
						&& "14".equals(prpLchargeChargeCode[index])) {
					prpLchargeDto
							.setCheckDeptCode(prpLchargeCheckDeptCode[index]);
					prpLchargeDto
							.setCheckDeptName(prpLchargeCheckDeptName[index]);
				}
				prpLchargeDto.setCurrency(prpLchargeCurrency[index]);
				prpLchargeDto.setChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeChargeAmount[index])));
				prpLchargeDto.setPreChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLpreChargeAmount[index])));
				prpLchargeDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeSumRealPay[index])));
				prpLchargeDto.setFlag(prpLchargeFlag[index]);
				if (prpLchargeChargeReport == null
						|| prpLchargeChargeReport.length < 1) {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeAmount[index]))); // add
					// 20060512
				} else {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeReport[index])));
				}
				prpLchargeDto.setPayObjectCode(prpLchargePayObjectCode[index]);
				prpLchargeDto.setPayObjectType(prpLchargePayObjectType[index]);
				prpLchargeDto.setPayObjectName(prpLchargePayObjectName[index]);

				// ��Ԫ��prpLdangerItem������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
				/*
				 * PrpLdangerItemDto prpLdangerItemChargeDto = new
				 * PrpLdangerItemDto();
				 * prpLdangerItemChargeDto.setCertiNo(prpLchargeCompensateNo);
				 * //ʵ��� prpLdangerItemChargeDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemChargeDto.setCurrency(prpLchargeCurrency[index]);
				 * //��ʧ�ұ� prpLdangerItemChargeDto.setKindFlag("0");
				 * //�ձ�����־,0��ʾ���� prpLdangerItemChargeDto.setKindName("����");
				 * //�ձ��������
				 * prpLdangerItemChargeDto.setRiskCode(prpLchargeRiskCode); //�ձ�
				 * prpLdangerItemChargeDto.setSerialNo(dangerItemSerialNo);
				 * //������ dangerItemSerialNo++;
				 * prpLdangerItemChargeDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				 * //�Ѿ���� prpLprpLdangerItemList.add(prpLdangerItemChargeDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// ��������Ϣ
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// �ӽ���õ���������
		String prpLcfeeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLcfeePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLcfeeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLcfeeCurrency1 = httpServletRequest
				.getParameter("prpLcompensateCurrency");
		String prpLcfeeSumThisPaid = httpServletRequest
				.getParameter("prpLcompensateSumThisPaid");
		String prpLcfeeFlag = httpServletRequest.getParameter("prpLcfeeFlag");
		// ����ֵ
		// ����������Ϣ
		prpLcfeeDto = new PrpLcfeeDto();
		prpLcfeeDto.setCompensateNo(prpLcfeeCompensateNo);
		prpLcfeeDto.setPolicyNo(prpLcfeePolicyNo);
		prpLcfeeDto.setRiskCode(prpLcfeeRiskCode);
		prpLcfeeDto.setCurrency(prpLcfeeCurrency1);
		prpLcfeeDto.setSumPaid(Double.parseDouble(DataUtils
				.nullToZero(prpLcfeeSumThisPaid)));
		prpLcfeeDto.setFlag("");
		prpLcfeeDtoList.add(prpLcfeeDto);
		compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);
		// ����������ڰ����⸶������Ҫ�᰸�����ı�
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");

		ArrayList prpLltextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLltextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			PrpLltextDto prpLltextDto = new PrpLltextDto();
			prpLltextDto.setClaimNo((String) httpServletRequest
					.getParameter("prpLcompensateClaimNo"));
			prpLltextDto.setContext(rules[k]);
			prpLltextDto.setLineNo(k + 1);
			prpLltextDto.setTextType("08");
			prpLltextDtoList.add(prpLltextDto);
		}
		compensateDto.setPrpLltextDtoList(prpLltextDtoList);

		compensateDto.getPrpLcompensateDto().setFinallyFlag(
				prpLcompensateFinallyFlag);
		// ��Ԫ��prpLdangertot������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
		/*
		 * String TCurrency = httpServletRequest.getParameter("MergeCurrency");
		 * //��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10
		 * compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
		 * //�Ա����Ϣ���д����õ��ϼ���Ϣ ArrayList itemListAll =(ArrayList)
		 * prpLprpLdangerItemList.clone(); ArrayList itemList =(ArrayList)
		 * prpLprpLdangerItemList.clone(); PrpLdangerItemDto dangerItemAll = new
		 * PrpLdangerItemDto(); //��ȡÿ����Ķ��� PrpLdangerItemDto dangerItem = new
		 * PrpLdangerItemDto(); //ѭ���ж�ʱʹ�� ArrayList tempCurrency = new
		 * ArrayList(); Iterator itemListIteratorAll = itemListAll.iterator();
		 * Iterator itemListIterator = itemList.iterator(); PrpLdangerItemDto
		 * dangerItemAll1 = new PrpLdangerItemDto();
		 * while(itemListIteratorAll.hasNext()){ dangerItemAll=
		 * (PrpLdangerItemDto)itemListIteratorAll.next(); dangerItemAll1 = new
		 * PrpLdangerItemDto();
		 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
		 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());
		 * 
		 * //�õ�ǰ�ұ�������Ͻ���ͳ�� String currentCur = dangerItemAll1.getCurrency();
		 * if(tempCurrency.contains(currentCur)){ continue; //����Ѿ��ϼƹ��ı��֣����ٽ��кϼ�; }
		 * int currentSerial = dangerItemAll1.getSerialNo();
		 * while(itemListIterator.hasNext()){ dangerItem =
		 * (PrpLdangerItemDto)itemListIterator.next(); //����ұ���ȣ�����⳥���ͷ��ý����ۼ�
		 * if(currentSerial!=dangerItem.getSerialNo()&&currentCur.equals(dangerItem.getCurrency())){
		 * dangerItemAll1.setSumFee(dangerItemAll1.getSumFee()+dangerItem.getSumFee());
		 * //�ϼƷ���
		 * dangerItemAll1.setSumPaid(dangerItemAll1.getSumPaid()+dangerItem.getSumPaid());
		 * //�ϼƽ�� } } tempCurrency.add(currentCur); //����ǰ�ϼƵı����ݴ� ;
		 * //�������Ϣ����ϼ�Dto if(dangerItemAll!=null){
		 * prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
		 * prpLdangerTotDto.setDangerNo(1); //Ŀǰ����һ��Σ�յ�λ
		 * prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); //���ԭ�ұ�
		 * prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
		 * prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
		 * prpLdangerTotDto.setTCurrency(TCurrency); //���бұ�ת�� ת����ıұ�ΪTCurrency
		 * String SCurrency = dangerItemAll.getCurrency(); //ԭ�ұ� double
		 * exchangeRate =
		 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
		 * Date())); prpLdangerTotDto.setExchRate(exchangeRate);
		 * prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()*exchangeRate);
		 * prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()*exchangeRate); }
		 * if(prpLdangerTotDto!=null){
		 * prpLprpLdangerTotList.add(prpLdangerTotDto); } }
		 * compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
		 */
		// ��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10 end
		if (DangerUnitCheckSaveFlag.equals("1")) {
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061130 start reason ���ٱ�������
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061130 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// �ӽ���õ���������
			String compensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");
			String[] prpLdangerClaimNo = httpServletRequest
					.getParameterValues("prpLdangerClaimNo");
			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDesc");
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerAddressName");
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");

			String[] prpLdangerRiskSumClaim = httpServletRequest
					.getParameterValues("prpLdangerRiskSumClaim");
			String[] prpLdangerRiskSumPaid = httpServletRequest
					.getParameterValues("prpLdangerRiskSumPaid");
			String[] prpLcompensateSumThisPaid = httpServletRequest
					.getParameterValues("prpLcompensateSumThisPaid");
			String[] prpLdangerProportion = httpServletRequest
					.getParameterValues("prpLdangerProportion");
			String prpLcompensateSumNoDutyFee = httpServletRequest
					.getParameter("prpLcompensateSumNoDutyFee");

			// ��ǰ����prpLdangerUnit���״���ע������һ��
			// ����ֵ
			/*
			 * if (prpLdangerCurrency == null) { } else { for (int index = 0;
			 * index < prpLdangerCurrency.length; index++) { prpLdangerUnitDto =
			 * new PrpLdangerUnitDto();
			 * prpLdangerUnitDto.setCertiNo(compensateNo);
			 * prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
			 * prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
			 * prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
			 * prpLdangerUnitDto.setDangerNo(index+1);
			 * prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
			 * prpLdangerUnitDto.setAddressName(prpLdangerAddressName[index]);
			 * prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
			 * prpLdangerUnitDto.setSumLoss(Double.parseDouble(prpLdangerRiskSumClaim[index]));
			 * prpLdangerUnitDto.setSumPaid(Double.parseDouble(prpLdangerRiskSumPaid[index]));
			 * prpLdangerUnitDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
			 * //prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
			 * //��������ȡʵ�� if(!prpLdangerClaimNo[index].equals("")){ ClaimDto
			 * claimDto = new ClaimDto(); UIClaimAction uiclaimAction= new
			 * UIClaimAction(); claimDto =
			 * uiclaimAction.findByPrimaryKey(prpLdangerClaimNo[index]); double
			 * sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
			 * prpLdangerUnitDto.setSumNoPaid(Double.parseDouble(prpLdangerRiskSumClaim[index])-sumPaid); }
			 * if("1".equals(prpLcompensateFinallyFlag)){
			 * prpLdangerUnitDto.setCertiType("3");//����Ϊʵ��
			 * prpLdangerUnitDto.setSumNoPaid(0); //�᰸ δ��������� }else{
			 * prpLdangerUnitDto.setCertiType("3");
			 * prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index])); }
			 * prpLdangerUnitDto.setDangerShare(Double.parseDouble(prpLdangerProportion[index]));
			 * prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);//add by kangzhen
			 * //���뼯��
			 * if(prpLdangerPolicyNo[index]!=null&&!(prpLdangerPolicyNo[index].equals(""))){
			 * dangerUnitList.add(prpLdangerUnitDto); } }
			 * if(dangerUnitList.size()>0){
			 * compensateDto.setPrplRiskUnitDtoList(dangerUnitList); } }
			 */
			// ��Ԫ����Σ�յ�λ�����Ϣ���¿���һ�ף�����ǰ������ע���ˣ�
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
			String sql = "";
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto();
			double sumTempLoss = 0;// dangerUnit����������һ���ۼ�ֵ������������⣩
			double sumTempPaid = 0;// dangerUnit�Ѿ��������һ���ۼ�ֵ
			double sumTempNoPaid = 0;// dangerUnitδ���������һ���ۼ�ֵ
			double tempLoss = 0;
			double tempPaid = 0;
			double tempNoPaid = 0;

			double sumLSumRealPay[] = new double[1000];

			// start
			// ��Ԫ�¸ķ���-------------------------------------------------------------------------
			// ����ֵ
			if (prpLdangerCurrency == null) {
			} else {
				sql = " certino ='" + prpLdangerClaimNo[0] + "'";
				// ȡ������Σ�յ�λ��Ϣ������ ����Σ�յ�λ ���� �����Σ�յ�λ��Ϣ
				List prpLdangerUnitClaimList = (ArrayList) blPrpLdangerUnitFacade
						.findByConditions(sql);
				for (int index = 0; index < prpLdangerCurrency.length; index++) {

					sumTempLoss = 0;
					sumTempPaid = 0;
					sumTempNoPaid = 0;

					double sumPaid = 0;
					double sumNoPaid = 0;

					// ȡ����������δ��
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
						sumNoPaid = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumPaid;// ��������δ��
					}

					// ���� ����Σ�յ�λ ���� �����Σ�յ�λ��Ϣ
					for (int dangerUnitSize = 0; dangerUnitSize < prpLdangerUnitClaimList
							.size(); dangerUnitSize++) {
						List temPrpLprpLdangerItemList = new ArrayList();
						dangerItemSerialNo = 1;
						prpLdangerUnitClaimDto = (PrpLdangerUnitDto) prpLdangerUnitClaimList.get(dangerUnitSize);

						// 1������Σ�յ�λprpLdangerUnit
						prpLdangerUnitDto = new PrpLdangerUnitDto();
						prpLdangerUnitDto.setCertiNo(compensateNo);
						prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
						prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
						prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
						prpLdangerUnitDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo());
						prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
						prpLdangerUnitDto.setAddressName(prpLdangerAddressName[index]);
						prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
						prpLdangerUnitDto.setBusinessNature(prpLdangerUnitClaimDto.getBusinessNature());
						prpLdangerUnitDto.setPolicyBizType(prpLdangerUnitClaimDto.getPolicyBizType());
						prpLdangerUnitDto.setPolicyType(prpLdangerUnitClaimDto.getPolicyType());
						prpLdangerUnitDto.setBusinessType(prpLdangerUnitClaimDto.getBusinessType());
						prpLdangerUnitDto.setBusinessType1(prpLdangerUnitClaimDto.getBusinessType1());
						prpLdangerUnitDto.setOthFlag(prpLdangerUnitClaimDto.getOthFlag());
						prpLdangerUnitDto.setBusinessProvince(prpLdangerUnitClaimDto.getBusinessProvince());
						prpLdangerUnitDto.setBusinessTown(prpLdangerUnitClaimDto.getBusinessTown());
						prpLdangerUnitDto.setBusinessCounty(prpLdangerUnitClaimDto.getBusinessCounty());
						prpLdangerUnitDto.setBusinessAreaName(prpLdangerUnitClaimDto.getBusinessAreaName());
						if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1)// ���һ��Σ�յ�λ�ü�����
						{
							tempLoss = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumTempLoss;
							tempPaid = Double.parseDouble(prpLdangerRiskSumPaid[index]) - sumTempPaid;
							tempNoPaid = sumNoPaid - sumTempNoPaid;

						}
						// �����һ��Σ�յ�λ�ó˷��㣨���Ա�����
						else {
							tempLoss = Double.parseDouble(prpLdangerRiskSumClaim[index]) * prpLdangerUnitClaimDto.getDangerShare() / 100;
							tempPaid = Double.parseDouble(prpLdangerRiskSumPaid[index]) * prpLdangerUnitClaimDto.getDangerShare() / 100;
							tempNoPaid = sumNoPaid * prpLdangerUnitClaimDto.getDangerShare() / 100;
							sumTempLoss += tempLoss;
							sumTempPaid += tempPaid;
							sumTempNoPaid += tempNoPaid; 
						}
						prpLdangerUnitDto.setSumLoss(tempLoss);
						prpLdangerUnitDto.setSumPaid(tempPaid);
						prpLdangerUnitDto.setSumNoPaid(tempNoPaid);
						prpLdangerUnitDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
						prpLdangerUnitDto.setDangerShare(prpLdangerUnitClaimDto.getDangerShare());
						if ("1".equals(prpLcompensateFinallyFlag)) {
							prpLdangerUnitDto.setCertiType("3");// ����Ϊʵ��
							prpLdangerUnitDto.setSumNoPaid(0); // �᰸ δ���������
						} else {
							prpLdangerUnitDto.setCertiType("3");
							// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
						}
						prpLdangerUnitDto.setCoinsFlag(strCoinsFlag); // add
						// by
						// kangzhen
						// ���뼯��
						if (prpLdangerPolicyNo[index] != null && !(prpLdangerPolicyNo[index].equals(""))) {
							dangerUnitList.add(prpLdangerUnitDto);
						}

						// 2�����ɴ����Σ�յ�λ���prpLdangerItem��������
						if (prpLlossDtoSerialNo == null) {

						} else {
							double tempLossRealPay = 0;
							for (int j = 1; j < prpLlossDtoSerialNo.length; j++) {

								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // ʵ���
								prpLdangerItemDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1) {
									tempLossRealPay = Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[j])) - sumLSumRealPay[dangerItemSerialNo];
								} else {
									tempLossRealPay = Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[j]))
											* prpLdangerUnitClaimDto.getDangerShare() / 100;
									sumLSumRealPay[dangerItemSerialNo] += tempLossRealPay;
								}
								prpLdangerItemDto.setSumPaid(tempLossRealPay); // �Ѿ����
								prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;

								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList.add(prpLdangerItemDto);
							}
						}

						// 3�����ɴ�Σ�յ�λ��prpLdangerItem�����ã�
						if (prpLchargeSerialNo == null) {

						} else {
							double tempLchargeSumRealPay = 0;
							for (int j = 1; j < prpLchargeSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto.setCertiNo(prpLchargeCompensateNo); // ʵ���
								prpLdangerItemDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto.setCurrency(prpLchargeCurrency[j]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto.setRiskCode(prpLchargeRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1) {
									tempLchargeSumRealPay = Double.parseDouble(DataUtils.nullToZero(prpLchargeChargeAmount[j]))
											- sumLSumRealPay[dangerItemSerialNo];
								} else {
									// Σ�յ�λ��ı����Ƿ����ǲ��Ǽ�������ȫҪ��¼��prpLdangerItem
									tempLchargeSumRealPay = Double.parseDouble(DataUtils.nullToZero(prpLchargeChargeAmount[j]))
											* prpLdangerUnitClaimDto.getDangerShare() / 100;
									sumLSumRealPay[dangerItemSerialNo] += tempLchargeSumRealPay;
								}
								prpLdangerItemDto.setSumFee(tempLchargeSumRealPay);
								prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList.add(prpLdangerItemDto);
							}
						}

						// 4�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTotD������prpLdangerItem��
						Iterator itemListIteratorAll = temPrpLprpLdangerItemList.iterator();
						Iterator itemListIterator = temPrpLprpLdangerItemList.iterator();
						double sumPaidAll = 0;
						while (itemListIteratorAll.hasNext()) {
							dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll.next();
							sumPaidAll += dangerItemAll.getSumPaid();
							sumPaidAll += dangerItemAll.getSumFee();
						}
						PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // ���ϼ�Dto
						prpLdangerTotDto.setCertiNo(compensateNo);
						prpLdangerTotDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo()); // Ŀǰ����һ��Σ�յ�λ
						prpLdangerTotDto.setSCurrency(prpLdangerCurrency[index]); // ���ԭ�ұ�
						prpLdangerTotDto.setSumFee(0);
						prpLdangerTotDto.setSumPaid(sumPaidAll);
						prpLdangerTotDto.setTCurrency(prpLdangerCurrency[index]);
						// ���бұ�ת�� ת����ıұ�ΪTCurrency
						/*
						 * String SCurrency = dangerItemAll.getCurrency(); //ԭ�ұ�
						 * double exchangeRate =
						 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new Date()));
						 */
						prpLdangerTotDto.setExchRate(1);
						prpLdangerTotDto.setSumFeeEx(0);
						prpLdangerTotDto.setSumPaidEx(sumPaidAll);
						if (prpLdangerTotDto != null) {
							prpLprpLdangerTotList.add(prpLdangerTotDto);
						}

					}

				}
				// �����Ϣ
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
				compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
				compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			}
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {
			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// start------------------------------------*/

			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();

			ArrayList dangerUnitList = new ArrayList();
			ArrayList dangerItemList = new ArrayList();
			ArrayList dangerTotList = new ArrayList();
			ArrayList  prpLchargeList = compensateDto.getPrpLchargeDtoList();
	        PrpLchargeDto lchargeDto = null;
	        boolean isfee;

			double temp = 0;
			double sumDangerUnit = 0d;
			boolean flag = true;
			// �ӽ���õ���������

			String prpLdangerCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");// �������

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");// ������
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");// ���ֺ�
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");// Σ�յ�λ����
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");// Σ�յ�λ��ַ
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");// Σ�յ�λ�ұ�
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");// �⸶���
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");// Σ�յ�λ��
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");// ռ��
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");// �ձ����
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");// �ձ�����
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");// ��Ĵ���
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");// �������
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// ������

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// ҵ����Դ
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// ����ҵ������
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// Ͷ����ʽ
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// �����Ա�־
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// ��ũ��ʶ
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// ������ʶ�ֶ�
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// ��������ʡ
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// ����������
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// ����������
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// ������������
			// 1�����ɴ����Σ�յ�λ���prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto();
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index]));
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]);
					prpLdangerItemNewDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]);
					prpLdangerItemNewDto.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					// ռ�����һ������ԭ��
					flag = true;
					for (int i = index + 1; i < prpLdangerCurrency.length; i++) {
						if (prpLdangerUnitItemKindNo[index].equals(prpLdangerUnitItemKindNo[i])) {
							flag = false;
						}
					}
					if (flag) {
						temp = 0;
						for (int k = 1; k < index; k++) {
							if (prpLdangerUnitItemKindNo[k].equals(prpLdangerUnitItemKindNo[index])) {
								temp += Str.round(Double.parseDouble(prpLdangerShare[k]), 2);
							}
						}
						prpLdangerItemNewDto.setDangerKindShare(Str.round(100 - temp, 2));
					} else {
						prpLdangerItemNewDto.setDangerKindShare(Double.parseDouble(prpLdangerShare[index]));
					}
					isfee = false; //�Ƿ��з��ã���������ֵ���Ӧ���ձ����ͱ�Ĵ���
					if(prpLchargeList != null && prpLchargeList.size()>0){
						 lchargeDto = new PrpLchargeDto();
	                	 for(int c=0;c<prpLchargeList.size();c++){
	                		lchargeDto = (PrpLchargeDto) prpLchargeList.get(c);
	                		if(lchargeDto.getKindCode().equals(prpLdangerKindcode[index])){
	                			isfee = true;
	     	           			break;
	                		}
	                	 }
	                  }
	                  if(isfee){
	                	prpLdangerItemNewDto.setSumFee(Str.round((lchargeDto.getChargeAmount()-lchargeDto.getSumRealPay()),2));
	                	prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2));
	                  }else{
	                	prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }
                  prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // ������
			
			sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// ���뼯��
					if (prpLdangerItemNewDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // ���DTO
			boolean find = true;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itTot = dangerTotList.iterator();
					while (itTot.hasNext()) {
						prpLdangerTotNewDto = (PrpLdangerTotDto) itTot.next();
						if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerTotNewDto.setSumPaid(Str.round(prpLdangerTotNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumPaidEx(Str.round(prpLdangerTotNewDto.getSumPaidEx() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumFee(Str.round(prpLdangerTotNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
	           				prpLdangerTotNewDto.setSumFeeEx(Str.round(prpLdangerTotNewDto.getSumFeeEx()+prpLdangerItemNewDto.getSumFee(),2));
							break;
						}
					}
					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // ���ԭ�ұ�
						prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
						// ���뼯��
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3������Σ�յ�λprpLdangerUnit
			com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit dbPrpLdangerUnit = null ;
			Iterator itUnit = null;
			PrpLdangerUnitDto prpLdangerUnitNewDto = null;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itUnit = dangerUnitList.iterator();
					while (itUnit.hasNext()) {
						prpLdangerUnitNewDto = (PrpLdangerUnitDto) itUnit.next();
						if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid()+ prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerUnitNewDto.setSumFee(Str.round(prpLdangerUnitNewDto.getSumFee() + prpLdangerItemNewDto.getSumFee(),2));
	           				prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
							break;
						}
					}

					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {

						prpLdangerUnitNewDto = new PrpLdangerUnitDto();
						prpLdangerUnitNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerUnitNewDto.setClaimNo(compensateDto.getPrpLcompensateDto().getClaimNo());
						prpLdangerUnitNewDto.setCertiType("3");
						prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto.getRiskCode());
						prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto.getPolicyno());
						prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto.getDangerdesc());
						prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto.getAddressName());
						prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerUnitNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						dbPrpLdangerUnit = new com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit();
						dbPrpLdangerUnit.getInfo(compensateDto.getPrpLcompensateDto().getCaseNo(), ""+prpLdangerItemNewDto.getDangerNo());
						if(!"".equals(dbPrpLdangerUnit.getSumLoss()) && !"".equals(prpLdangerItemNewDto.getSumPaid())){
    						prpLdangerUnitNewDto.setSumNoPaid(Double.parseDouble(dbPrpLdangerUnit.getSumLoss()) - prpLdangerItemNewDto.getSumPaid());
    					}
						prpLdangerUnitNewDto.setCoinsFlag(strCoinsFlag);
						prpLdangerUnitNewDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitNewDto.setAgricultureflag(prpCmainDto.getBusinessType1());
						prpLdangerUnitNewDto.setBusinessNature(prpLdangerBusinessNature[1]);
						prpLdangerUnitNewDto.setPolicyBizType(prpLdangerPolicyBizType[1]);
						prpLdangerUnitNewDto.setPolicyType(prpLdangerPolicyType[1]);
						prpLdangerUnitNewDto.setBusinessType(prpLdangerBusinessType[1]);
						prpLdangerUnitNewDto.setBusinessType1(prpLdangerBusinessType1[1]);
						prpLdangerUnitNewDto.setOthFlag(prpLdangerOthFlag[1]);
						prpLdangerUnitNewDto.setBusinessProvince(prpLdangerBusinessProvince[1]);
						prpLdangerUnitNewDto.setBusinessTown(prpLdangerBusinessTown[1]);
						prpLdangerUnitNewDto.setBusinessCounty(prpLdangerBusinessCounty[1]);
						prpLdangerUnitNewDto.setBusinessAreaName(prpLdangerBusinessAreaName[1]);
						// ���뼯��
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// ���һ��ռ�ȼ���ԭ��
				double dangerShare = 0;
				double tempSumDangerShare = 0;
				ClaimDto claimDto = new ClaimDto();
				UIClaimAction uiclaimAction = new UIClaimAction();
				claimDto = uiclaimAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getClaimNo());
				double tempSumLoss = 0;
				double temSumFee=0;
				double sumTempSumLoss = 0;
				double tempSumNoPaid = 0;
				double sumTempNoPaid = 0;
				PrpLdangerUnitDto prpLdangerUnitDtotemp = null;
				for (int i = 0; i < dangerUnitList.size(); i++) {
					prpLdangerUnitDtotemp = (PrpLdangerUnitDto) dangerUnitList.get(i);
					if (i == (dangerUnitList.size() - 1)) {
						dangerShare = Str.round(100 - tempSumDangerShare, 2);
						tempSumNoPaid = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid() - sumTempNoPaid, 2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - sumTempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					} else {
						dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid() / sumDangerUnit * 100, 2);
						tempSumDangerShare = Str.round(tempSumDangerShare + dangerShare, 2);
						tempSumNoPaid = Str.round((claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid())* dangerShare / 100, 2);
						sumTempNoPaid = Str.round(sumTempSumLoss + tempSumLoss,2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim()* dangerShare / 100, 2);
						sumTempSumLoss = Str.round(sumTempSumLoss + tempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					}
					prpLdangerUnitDtotemp.setDangerShare(dangerShare);
					prpLdangerUnitDtotemp.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
					prpLdangerUnitDtotemp.setSumLoss(tempSumLoss);
					prpLdangerUnitDtotemp.setSumFee(temSumFee);
					if ("1".equals(prpLcompensateFinallyFlag)) {
						prpLdangerUnitDtotemp.setSumNoPaid(0); // �᰸ δ���������
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid() - compensateDto.getPrpLcompensateDto().getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// end------------------------------------*/
		}

		return compensateDto;
	}

	/**
	 * ����ʵ��ʱʵ��ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * 
	 * @param httpServletRequest
	 * @return compensateDto ʵ�����ݴ������ݽṹ
	 * @throws Exception
	 */
	public CompensateDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// �̳ж�compensate,compensateText��ĸ�ֵ
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();
		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		// add by lixiang start at 2005-12-27
		// reason:����Ͷ���˸���
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));
		// add by lixiang end at 2005-12-27

		System.err.println("zouyixia");
		/*-------------------������������Ϣ-------start------------------------------------*/
		ClaimDto claim2Dto = null;
		ArrayList prpLacciPersonList = new ArrayList();
		PrpLacciPersonDto prpLacciPersonProposerDto = null;
		// �ӽ���õ���������

		String proposerClaimNo = httpServletRequest.getParameter("claimNo");
		String proposerPolicyNo = httpServletRequest
				.getParameter("prpLclaimPolicyNo");
		String[] proposerName = httpServletRequest
				.getParameterValues("proposerName");
		String[] proposerSerialNo = httpServletRequest
				.getParameterValues("prpLacciPersonSerialNo");
		String[] proposerIdentifyNumber = httpServletRequest
				.getParameterValues("proposerIdentifyNumber");
		String[] proposerRelation = httpServletRequest
				.getParameterValues("relationCode");
		String[] proposerPhone = httpServletRequest
				.getParameterValues("proposerPhone");
		String[] proposerAddress = httpServletRequest
				.getParameterValues("proposerAddress");
		String proposerFamilyNo = httpServletRequest
				.getParameter("personFamilyNo");

		// ����ֵ
		if (proposerSerialNo == null) {
		} else {

			for (int index = 1; index < proposerSerialNo.length; index++) {
				prpLacciPersonProposerDto = new PrpLacciPersonDto();
				prpLacciPersonProposerDto.setAcciName(proposerName[index]);
				prpLacciPersonProposerDto.setCertiNo(proposerClaimNo);
				prpLacciPersonProposerDto.setCertiType("03");
				prpLacciPersonProposerDto.setPolicyNo(proposerPolicyNo);
				prpLacciPersonProposerDto.setFlag("1"); // ��־��������
				prpLacciPersonProposerDto
						.setIdentifyNumber(proposerIdentifyNumber[index]);
				prpLacciPersonProposerDto
						.setSerialNo(Integer.parseInt(DataUtils
								.nullToZero(proposerSerialNo[index])));
				prpLacciPersonProposerDto.setAddress(proposerAddress[index]);
				prpLacciPersonProposerDto.setFamilyNo(0); // ��ͥ���
				prpLacciPersonProposerDto.setPhone(proposerPhone[index]);
				prpLacciPersonProposerDto
						.setRelationCode(proposerRelation[index]);
				String relationName = "";

				if (proposerRelation[index].equals("1")) {
					relationName = "�������˱���";
				} else if (proposerRelation[index].equals("2")) {
					relationName = "ָ��������";
				} else if (proposerRelation[index].equals("3")) {
					relationName = "��������֮�̳���";
				} else if (proposerRelation[index].equals("4")) {
					relationName = "��������֮�໤��";
				}
				prpLacciPersonProposerDto.setRelationName(relationName);
				prpLacciPersonProposerDto.setFamilyNo(Integer
						.parseInt(proposerFamilyNo));

				// ���뼯��
				prpLacciPersonList.add(prpLacciPersonProposerDto);

			}
			// �⽡�����������м�������������
			compensateDto.setPrpLacciPersonDtoList(prpLacciPersonList);

		}
		/*-------------------������������Ϣ-------end------------------------------------*/

		/*---------------------�⸶�����ϢprpLlossDto------------------------------------*/
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;
		// ����Σ�յ�λ���� add by qinyongli 2005-9-10
		// reason: Ŀǰֻ��һ��Σ�յ�λ�����Ժͱ����Ϣ����һ����������ж��Σ�յ�λ�������Σ�յ�λ��Ϣ���洦��
		ArrayList prpLprpLdangerTotList = new ArrayList(); // ����Σ�յ�λ���ϼ���Ϣ
		ArrayList prpLprpLdangerItemList = new ArrayList(); // �����Σ�յ�λ��Ϣ��
		PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // ���ϼ�Dto
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // ���DTO
		int dangerItemSerialNo = 1; // ���ڴ洢��ĵ����

		// �ӽ���õ���������
		// String prpLlossDtoCompensateNo =
		// httpServletRequest.getParameter("prpLcompensateCompensateNo");
		String prpLlossDtoCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLlossDtoRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLlossDtoPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String[] prpLlossDtoSerialNo = httpServletRequest
				.getParameterValues("prpLlossDtoSerialNo");
		String[] prpLlossDtoItemKindNo = httpServletRequest
				.getParameterValues("prpLlossDtoItemKindNo");

		String[] prpLlossDtoFamilyNo = httpServletRequest
				.getParameterValues("prpLlossDtoFamilyNo");
		String[] prpLlossDtoFamilyName = httpServletRequest
				.getParameterValues("prpLlossDtoFamilyName");
		String[] prpLlossDtoKindCode = httpServletRequest
				.getParameterValues("prpLlossDtoKindCode");
		String[] prpLlossDtoLicenseNo = httpServletRequest
				.getParameterValues("prpLlossDtoLicenseNo");
		String[] prpLlossDtoItemCode = httpServletRequest
				.getParameterValues("prpLlossDtoItemCode");
		String[] prpLlossDtoLossName = httpServletRequest
				.getParameterValues("prpLlossDtoLossName");
		String[] prpLlossDtoItemAddress = httpServletRequest
				.getParameterValues("prpLlossDtoItemAddress");
		String[] prpLlossDtoFeeTypeCode = httpServletRequest
				.getParameterValues("prpLlossDtoFeeTypeCode");
		String[] prpLlossDtoFeeTypeName = httpServletRequest
				.getParameterValues("prpLlossDtoFeeTypeName");
		String[] prpLlossDtoLossQuantity = httpServletRequest
				.getParameterValues("prpLlossDtoLossQuantity");
		String[] prpLlossDtoUnit = httpServletRequest
				.getParameterValues("prpLlossDtoUnit");
		String[] prpLlossDtoUnitPrice = httpServletRequest
				.getParameterValues("prpLlossDtoUnitPrice");
		String[] prpLlossDtoBuyDate = httpServletRequest
				.getParameterValues("prpLlossDtoBuyDate");
		String[] prpLlossDtoDepreRate = httpServletRequest
				.getParameterValues("prpLlossDtoDepreRate");
		String[] prpLlossDtoCurrency = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency4");
		// String[] prpLlossDtoAmount =
		// httpServletRequest.getParameterValues("prpLlossDtoAmount");
		String[] prpLlossDtoAmount = httpServletRequest
				.getParameterValues("prpLlossDtoAmount");
		String[] prpLlossDtoCurrency1 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency1");
		String[] prpLlossDtoItemValue = httpServletRequest
				.getParameterValues("prpLlossDtoItemValue");
		String[] prpLlossDtoCurrency2 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency2");
		String[] prpLlossDtoSumLoss = httpServletRequest
				.getParameterValues("prpLlossDtoSumLoss");
		String[] prpLlossDtoSumRest = httpServletRequest
				.getParameterValues("prpLlossDtoSumRest");
		String[] prpLlossDtoIndemnityDutyRate = httpServletRequest
				.getParameterValues("prpLlossDtoIndemnityDutyRate");
		String[] prpLlossDtoClaimRate = httpServletRequest
				.getParameterValues("prpLlossDtoClaimRate");
		String[] prpLlossDtoCurrency3 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency3");
		String[] prpLlossDtoDeductibleRate = httpServletRequest
				.getParameterValues("prpLlossDtoDeductibleRate");
		String[] prpLlossDtoDeductible = httpServletRequest
				.getParameterValues("prpLlossDtoDeductible");
		String[] prpLlossDtoCurrency4 = httpServletRequest
				.getParameterValues("prpLlossDtoCurrency4");
		String[] prpLlossDtoSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoSumRealPay");
		String[] prpLlossDtoFlag = httpServletRequest
				.getParameterValues("prpLlossDtoFlag");
		String[] prpLlossFamilyNo = httpServletRequest
				.getParameterValues("prpLlossFamilyNo");
		String[] prpLlossFamilyName = httpServletRequest
				.getParameterValues("prpLlossFamilyName");
		String[] prpLlossDtoBrandCode = httpServletRequest
				.getParameterValues("prpLlossDtoBrandCode");
		String[] prpLlossDtoCarNumber = httpServletRequest
				.getParameterValues("prpLlossDtoCarNumber");
		String[] prpLlossDtoCoinsSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoCoinsSumRealPay");
		String[] indemnityDutyRate = httpServletRequest
				.getParameterValues("indemnityDutyRate");
		String[] prpLlossDetailSerialNo = httpServletRequest
				.getParameterValues("prpLlossDetailSerialNo");
		//0313���������IMEI�ֶ�
		String[] prpLlossDtoImei = httpServletRequest
				.getParameterValues("prpLlossDtoImei");
		// ����ֵ

		if (prpLlossDetailSerialNo == null) {

		} else {
			for (int index = 1; index < prpLlossDetailSerialNo.length; index++) {
				prpLlossDto = new PrpLlossDto();
				prpLlossDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLlossDto.setRiskCode(prpLlossDtoRiskCode);
				prpLlossDto.setCompensateNo(prpLlossDtoCompensateNo);
				prpLlossDto.setSerialNo(index);
				prpLlossDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLlossDtoItemKindNo[index])));

				prpLlossDto.setKindCode(prpLlossDtoKindCode[index]);
				prpLlossDto.setItemCode(prpLlossDtoItemCode[index]);
				prpLlossDto.setLossName(prpLlossDtoLossName[index]);
				prpLlossDto.setItemAddress(prpLlossDtoItemAddress[index]);
				prpLlossDto.setFeeTypeCode(prpLlossDtoFeeTypeCode[index]);
				prpLlossDto.setFeeTypeName(prpLlossDtoFeeTypeName[index]);
				prpLlossDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoLossQuantity[index])));
				prpLlossDto.setUnit(prpLlossDtoUnit[index]);
				prpLlossDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoUnitPrice[index])));
				prpLlossDto.setBuyDate(new DateTime(prpLlossDtoBuyDate[index]));
				prpLlossDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDepreRate[index])));
				prpLlossDto.setCurrency(prpLlossDtoCurrency[index]);
				prpLlossDto.setAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoAmount[index])));
				prpLlossDto.setCurrency1(prpLlossDtoCurrency1[index]);
				// ��Ԫ��ֲ�չ�ʽ������ҳ��ȥ���˱��ռ�ֵ
				if ("0311".equals(prpLlossDtoRiskCode.substring(0, 2))) {
					prpLlossDto.setItemValue(0.00);

				}
				prpLlossDto.setCurrency2(prpLlossDtoCurrency2[index]);
				prpLlossDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumLoss[index])));
				prpLlossDto.setSumRest(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRest[index])));
				prpLlossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoIndemnityDutyRate[index])));
				prpLlossDto.setClaimRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoClaimRate[index])));
				prpLlossDto.setCurrency3(prpLlossDtoCurrency3[index]);
				prpLlossDto.setDeductibleRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductibleRate[index])));
				prpLlossDto.setDeductible(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductible[index])));
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3��curreny4���(�ն��߼�)
				prpLlossDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRealPay[index])));
				if (null != prpLlossDtoCoinsSumRealPay
						&& prpLlossDtoCoinsSumRealPay.length > 0) {
					if (null != prpLlossDtoCoinsSumRealPay[index]) {
						prpLlossDto
								.setCoinsSumRealPaid(Double
										.parseDouble(DataUtils
												.nullToZero(prpLlossDtoCoinsSumRealPay[index])));
					}
				}

				prpLlossDto.setLossrate(Double.parseDouble(DataUtils
						.nullToZero(indemnityDutyRate[index])));

				if("0313".equals(prpLlossDtoRiskCode)){
					if(prpLlossDtoImei[index]!=null && !"".equals(prpLlossDtoImei[index])){
						prpLlossDto.setImei(prpLlossDtoImei[index]);
					}
				}
				// ��Ԫ��prpLdangerItem������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); //ʵ���
				 * prpLdangerItemDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]);
				 * //��ʧ�ұ� prpLdangerItemDto.setKindFlag("0"); //�ձ�����־,0��ʾ����
				 * prpLdangerItemDto.setKindName("����"); //�ձ��������
				 * prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); //�ձ�
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //������
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));//�Ѿ����
				 * prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				prpLlossDtoList.add(prpLlossDto);
			}
		}

		if (prpLlossDtoSerialNo == null) {

		} else {
			for (int index = 1; index < prpLlossDtoSerialNo.length; index++) {
				prpLlossDto = new PrpLlossDto();
				prpLlossDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLlossDto.setRiskCode(prpLlossDtoRiskCode);
				prpLlossDto.setCompensateNo(prpLlossDtoCompensateNo);
				prpLlossDto.setSerialNo(index);
				prpLlossDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLlossDtoItemKindNo[index])));
				if (!"ZH03".equals(prpLlossDtoRiskCode))// ũ�Ҹ���ϱ���ʹ��FamilyNoZH
					// ���� FamilyNo,��ֵ�����ں��
					prpLlossDto.setFamilyNo(Integer.parseInt(DataUtils
							.nullToZero(prpLlossDtoFamilyNo[index])));
				prpLlossDto.setFamilyName(prpLlossDtoFamilyName[index]);
				prpLlossDto.setKindCode(prpLlossDtoKindCode[index]);
				prpLlossDto.setLicenseNo(prpLlossDtoLicenseNo[index]);
				prpLlossDto.setItemCode(prpLlossDtoItemCode[index]);
				prpLlossDto.setLossName(prpLlossDtoLossName[index]);
				prpLlossDto.setItemAddress(prpLlossDtoItemAddress[index]);
				prpLlossDto.setFeeTypeCode(prpLlossDtoFeeTypeCode[index]);
				prpLlossDto.setFeeTypeName(prpLlossDtoFeeTypeName[index]);
				prpLlossDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoLossQuantity[index])));
				prpLlossDto.setUnit(prpLlossDtoUnit[index]);
				prpLlossDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoUnitPrice[index])));
				prpLlossDto.setBuyDate(new DateTime(prpLlossDtoBuyDate[index]));
				prpLlossDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDepreRate[index])));
				prpLlossDto.setCurrency(prpLlossDtoCurrency[index]);
				prpLlossDto.setAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoAmount[index])));
				prpLlossDto.setCurrency1(prpLlossDtoCurrency1[index]);
				prpLlossDto.setItemValue(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoItemValue[index])));
				prpLlossDto.setCurrency2(prpLlossDtoCurrency2[index]);
				prpLlossDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumLoss[index])));
				prpLlossDto.setSumRest(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRest[index])));
				prpLlossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoIndemnityDutyRate[index])));
				prpLlossDto.setClaimRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoClaimRate[index])));
				prpLlossDto.setCurrency3(prpLlossDtoCurrency3[index]);
				prpLlossDto.setDeductibleRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductibleRate[index])));
				prpLlossDto.setDeductible(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoDeductible[index])));
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3��curreny4���(�ն��߼�)
				prpLlossDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoSumRealPay[index])));
				if (null != prpLlossDtoCoinsSumRealPay
						&& prpLlossDtoCoinsSumRealPay.length > 0) {
					if (null != prpLlossDtoCoinsSumRealPay[index]) {
						prpLlossDto
								.setCoinsSumRealPaid(Double
										.parseDouble(DataUtils
												.nullToZero(prpLlossDtoCoinsSumRealPay[index])));
					}
				}
				prpLlossDto.setFlag(prpLlossDtoFlag[index]);
				// ��Ԫ��prpLdangerItem������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); //ʵ���
				 * prpLdangerItemDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]);
				 * //��ʧ�ұ� prpLdangerItemDto.setKindFlag("0"); //�ձ�����־,0��ʾ����
				 * prpLdangerItemDto.setKindName("����"); //�ձ��������
				 * prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); //�ձ�
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //������
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));//�Ѿ����
				 * prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				// ���ɲ���ϱ����⸶���˻�
				if ("ZH01".equals(prpLlossDtoRiskCode)
						|| "ZH02".equals(prpLlossDtoRiskCode)) {
					if ("".equals(prpLlossFamilyNo[index])
							|| prpLlossFamilyNo[index] == null) {
						prpLlossDto.setFamilyNo(0);
					} else {
						prpLlossDto.setFamilyNo(Integer
								.parseInt(prpLlossFamilyNo[index]));
					}
					prpLlossDto.setFamilyName(prpLlossFamilyName[index]);
				}
				if ("ZH03".equals(prpLlossDtoRiskCode)) {
					if ("".equals(prpLlossFamilyNo[index])
							|| prpLlossFamilyNo[index] == null) {
						prpLlossDto.setFamilyNo(0);
					} else {
						prpLlossDto.setFamilyNoZH(prpLlossFamilyNo[index]);
					}
					prpLlossDto.setFamilyName(prpLlossFamilyName[index]);
				}
				// ���г����������α����⸶����
				if ("1528".equals(prpLlossDtoRiskCode)) {
					if ("".equals(prpLlossFamilyNo[index])
							|| prpLlossFamilyNo[index] == null) {
						prpLlossDto.setFamilyNo(0);
					} else {
						prpLlossDto.setFamilyNo(Integer
								.parseInt(prpLlossFamilyNo[index]));
					}
					if (prpLlossDtoBrandCode != null) {
						prpLlossDto.setBrandCode(prpLlossDtoBrandCode[index]);
					}
					if (prpLlossDtoCarNumber != null) {
						prpLlossDto.setLicenseNo(prpLlossDtoCarNumber[index]);
					}

				}

				if("0313".equals(prpLlossDtoRiskCode)){
					if(prpLlossDtoImei[index]!=null && !"".equals(prpLlossDtoImei[index])){
						prpLlossDto.setImei(prpLlossDtoImei[index]);
					}
				}
				prpLlossDtoList.add(prpLlossDto);
			}
		}
		// �⸶�����Ϣ
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);

		/*---------------------�⸶��Ա��ϢprpLpersonLossDto------------------------------------*/
		ArrayList prpLpersonLossDtoList = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = null;

		// �ӽ���õ���������
		// String prpLpersonLossCompensateNo =
		// httpServletRequest.getParameter("prpLcompensateCompensateNo");
		String prpLpersonLossCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLpersonLossRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLpersonLossPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");

		String[] personLossSerialNo = httpServletRequest
				.getParameterValues("personLossSerialNo");
		String[] prpLpersonLossSerialNo = httpServletRequest
				.getParameterValues("prpLpersonLossSerialNo");
		String[] prpLpersonLossPersonNo = httpServletRequest
				.getParameterValues("prpLpersonLossPersonNo");
		String[] prpLpersonLossPersonName = httpServletRequest
				.getParameterValues("prpLpersonLossPersonName");

		// ��������⸶��������⸶�� 2005-9-23
		String[] prpLpersonLossMaxpaid = httpServletRequest
				.getParameterValues("prpLpersonLossMaxPaid");
		String[] prpLpersonLossHispaid = httpServletRequest
				.getParameterValues("prpLpersonLossHisPaid");
		String[] prpLpersonLossIdentifyNumber = httpServletRequest
				.getParameterValues("prpLpersonLossIdentifyNumber");
		String[] prpLpersonLossSex = httpServletRequest
				.getParameterValues("prpLpersonLossSex");
		String[] prpLpersonLossAge = httpServletRequest
				.getParameterValues("prpLpersonLossAge");
		String[] prpLpersonLossItemKindNo = httpServletRequest
				.getParameterValues("prpLpersonLossItemKindNo");
		String[] prpLpersonLossFamilyNo = httpServletRequest
				.getParameterValues("prpLpersonLossFamilyNo");
		String[] prpLpersonLossFamilyName = httpServletRequest
				.getParameterValues("prpLpersonLossFamilyName");
		String[] prpLpersonLossKindCode = httpServletRequest
				.getParameterValues("prpLpersonLossKindCode");
		String[] prpLpersonLossLiabCode = httpServletRequest
				.getParameterValues("prpLpersonLossLiabCode");
		String[] prpLpersonLossLiabName = httpServletRequest
				.getParameterValues("prpLpersonLossLiabName");
		String[] prpLpersonLossJobCode = httpServletRequest
				.getParameterValues("prpLpersonLossJobCode");
		String[] prpLpersonLossJobName = httpServletRequest
				.getParameterValues("prpLpersonLossJobName");
		String[] prpLpersonLossLiabDetailCode = httpServletRequest
				.getParameterValues("prpLpersonLossLiabDetailCode");
		String[] prpLpersonLossLiabDetailName = httpServletRequest
				.getParameterValues("prpLpersonLossLiabDetailName");
		String[] prpLpersonLossItemAddress = httpServletRequest
				.getParameterValues("prpLpersonLossItemAddress");
		String[] prpLpersonLossLossQuantity = httpServletRequest
				.getParameterValues("prpLpersonLossLossQuantity");
		String[] prpLpersonLossUnit = httpServletRequest
				.getParameterValues("prpLpersonLossUnit");
		String[] prpLpersonLossUnitAmount = httpServletRequest
				.getParameterValues("prpLpersonLossUnitAmount");
		String[] prpLpersonLossHospitalDays = httpServletRequest
				.getParameterValues("prpLpersonLossHospitalDays");
		String[] prpLpersonLossCurrency = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency");
		String[] prpLpersonLossAmount = httpServletRequest
				.getParameterValues("prpLpersonLossAmount");
		String[] prpLpersonLossCurrency1 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency1");
		String[] prpLpersonLossItemValue = httpServletRequest
				.getParameterValues("prpLpersonLossItemValue");
		String[] prpLpersonLossCurrency2 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency2");
		String[] prpLpersonLossSumLoss = httpServletRequest
				.getParameterValues("prpLpersonLossSumLoss");
		String[] prpLpersonLossSumRest = httpServletRequest
				.getParameterValues("prpLpersonLossSumRest");
		String[] prpLpersonLossIndemnityDutyRate = httpServletRequest
				.getParameterValues("prpLpersonLossIndemnityDutyRate");
		String[] prpLpersonLossClaimRate = httpServletRequest
				.getParameterValues("prpLpersonLossClaimRate");
		String[] prpLpersonLossCurrency3 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency3");
		String[] prpLpersonLossDeductibleRate = httpServletRequest
				.getParameterValues("prpLpersonLossDeductibleRate");
		String[] prpLpersonLossDeductible = httpServletRequest
				.getParameterValues("prpLpersonLossDeductible");
		String[] prpLpersonLossCurrency4 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency4");
		String[] prpLpersonLossSumRealPay = httpServletRequest
				.getParameterValues("prpLpersonLossSumRealPay");
		String[] prpLpersonLossFlag = httpServletRequest
				.getParameterValues("prpLpersonLossFlag");

		if (personLossSerialNo == null) {

		} else {
			String strRiskType = uiCodeAction
					.translateRiskCodetoRiskType(prpLpersonLossRiskCode);
			if (prpLpersonLossRiskCode != null && "D".equals(strRiskType)) {
				// ����ֵ
				for (int index = 1; index < personLossSerialNo.length; index++) {
					prpLpersonLossDto = new PrpLpersonLossDto();
					prpLpersonLossDto.setPolicyNo(prpLpersonLossPolicyNo);
					prpLpersonLossDto.setRiskCode(prpLpersonLossRiskCode);
					prpLpersonLossDto
							.setCompensateNo(prpLpersonLossCompensateNo);
					prpLpersonLossDto.setSerialNo(index);
					// prpLpersonLossDto.setPersonNo (
					// Integer.parseInt(DataUtils.nullToZero(
					// prpLpersonLossPersonNo [index])));
					prpLpersonLossDto
							.setIdentifyNumber(prpLpersonLossIdentifyNumber[index]);
					prpLpersonLossDto.setItemKindNo(Integer.parseInt(DataUtils
							.nullToZero(prpLpersonLossItemKindNo[index])));
					prpLpersonLossDto.setFamilyNo(Integer.parseInt(DataUtils
							.nullToZero(prpLpersonLossFamilyNo[index])));
					prpLpersonLossDto
							.setLiabCode(prpLpersonLossLiabCode[index]);
					prpLpersonLossDto
							.setLiabName(prpLpersonLossLiabName[index]);
					prpLpersonLossDto.setJobCode(prpLpersonLossJobCode[index]);
					prpLpersonLossDto.setJobName(prpLpersonLossJobName[index]);
					prpLpersonLossDto
							.setItemAddress(prpLpersonLossItemAddress[index]);
					prpLpersonLossDto.setUnit(prpLpersonLossUnit[index]);
					prpLpersonLossDto
							.setCurrency(prpLpersonLossCurrency[index]);
					prpLpersonLossDto.setAmount(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossAmount[index])));
					prpLpersonLossDto
							.setCurrency1(prpLpersonLossCurrency1[index]);
					prpLpersonLossDto.setItemValue(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossItemValue[index])));
					prpLpersonLossDto
							.setCurrency2(prpLpersonLossCurrency2[index]);
					prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossSumRest[index])));
					prpLpersonLossDto.setClaimRate(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossClaimRate[index])));
					prpLpersonLossDto
							.setDeductible(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossDeductible[index])));
					prpLpersonLossDto
							.setCurrency4(prpLpersonLossCurrency4[index]);
					prpLpersonLossDto
							.setSumRealPay(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossSumRealPay[index])));
					prpLpersonLossDto.setFlag(prpLpersonLossFlag[index]);
					prpLpersonLossDto
							.setLiabDetailCode(prpLpersonLossLiabDetailCode[index]);
					prpLpersonLossDto
							.setLiabDetailName(prpLpersonLossLiabDetailName[index]);
					prpLpersonLossDto
							.setUnitAmount(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossUnitAmount[index])));
					prpLpersonLossDto
							.setHospitalDays(Integer
									.parseInt(DataUtils
											.nullToZero(prpLpersonLossHospitalDays[index])));
					prpLpersonLossDto
							.setLossQuantity(Integer
									.parseInt(DataUtils
											.nullToZero(prpLpersonLossLossQuantity[index])));
					prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossSumLoss[index])));
					/*
					 * prpLpersonLossDto.setIndemnityDutyRate (
					 * Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate
					 * [index]))); prpLpersonLossDto.setKindCode (
					 * prpLpersonLossKindCode [index]);
					 * prpLpersonLossDto.setDeductibleRate (
					 * Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate
					 * [index])));
					 */for (int index2 = 0; index2 < prpLpersonLossSerialNo.length; index2++) {
						if (prpLpersonLossSerialNo[index2]
								.equals(personLossSerialNo[index])) {

							prpLpersonLossDto.setSex(prpLpersonLossSex[index2]);
							prpLpersonLossDto
									.setPersonName(prpLpersonLossPersonName[index2]);
							prpLpersonLossDto.setAge(Integer.parseInt(DataUtils
									.nullToZero(prpLpersonLossAge[index2])));
							prpLpersonLossDto
									.setCurrency3(prpLpersonLossCurrency3[index2]);
							prpLpersonLossDto
									.setFamilyName(prpLpersonLossFamilyName[index2]);// ���ƺ���

							prpLpersonLossDto
									.setIndemnityDutyRate(Double
											.parseDouble(DataUtils
													.nullToZero(prpLpersonLossIndemnityDutyRate[index2])));
							prpLpersonLossDto
									.setKindCode(prpLpersonLossKindCode[index2]);
							prpLpersonLossDto
									.setDeductibleRate(Double
											.parseDouble(DataUtils
													.nullToZero(prpLpersonLossDeductibleRate[index2])));

							prpLpersonLossDto.setPersonNo(index2);
						}
					}
					// ���뼯��
					prpLpersonLossDtoList.add(prpLpersonLossDto);
				}
			} else {
				// ����ֵ

				// modify by lixiang start at 2005-12-28
				// resaon:���¶��������Ǵ�ġ���������ֻ��personLossSerialNo���prpLpersonLossSerialNo��
				// û���κ����壬ֻ����ʱ����ϵͳ���ش��� ������û�н������ġ�
				for (int index = 1; index < personLossSerialNo.length; index++) {
					// for (int index = 1; index <=
					// prpLpersonLossSerialNo.length; index++) {
					// modify by lixiang end at 2005-12-28

					prpLpersonLossDto = new PrpLpersonLossDto();
					prpLpersonLossDto.setPolicyNo(prpLpersonLossPolicyNo);
					prpLpersonLossDto.setRiskCode(prpLpersonLossRiskCode);
					prpLpersonLossDto
							.setCompensateNo(prpLpersonLossCompensateNo);
					prpLpersonLossDto.setSerialNo(index);
					// prpLpersonLossDto.setPersonNo (
					// Integer.parseInt(DataUtils.nullToZero(
					// prpLpersonLossPersonNo [index])));
					prpLpersonLossDto
							.setIdentifyNumber(prpLpersonLossIdentifyNumber[index]);
					// prpLpersonLossDto.setItemKindNo(Integer.parseInt(DataUtils
					// .nullToZero(prpLpersonLossItemKindNo[index])));

					prpLpersonLossDto.setFamilyNo(Integer.parseInt(DataUtils
							.nullToZero(prpLpersonLossFamilyNo[index])));
					prpLpersonLossDto
							.setLiabCode(prpLpersonLossLiabCode[index]);
					prpLpersonLossDto
							.setLiabName(prpLpersonLossLiabName[index]);
					prpLpersonLossDto.setJobCode(prpLpersonLossJobCode[index]);
					prpLpersonLossDto.setJobName(prpLpersonLossJobName[index]);
					prpLpersonLossDto
							.setItemAddress(prpLpersonLossItemAddress[index]);
					prpLpersonLossDto.setUnit(prpLpersonLossUnit[index]);
					prpLpersonLossDto
							.setCurrency(prpLpersonLossCurrency[index]);
					prpLpersonLossDto.setAmount(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossAmount[index])));
					prpLpersonLossDto
							.setCurrency1(prpLpersonLossCurrency1[index]);
					prpLpersonLossDto.setItemValue(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossItemValue[index])));
					prpLpersonLossDto
							.setCurrency2(prpLpersonLossCurrency2[index]);
					prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossSumRest[index])));
					prpLpersonLossDto.setClaimRate(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossClaimRate[index])));
					prpLpersonLossDto
							.setDeductible(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossDeductible[index])));
					prpLpersonLossDto
							.setCurrency4(prpLpersonLossCurrency4[index]);
					prpLpersonLossDto
							.setSumRealPay(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossSumRealPay[index])));
					prpLpersonLossDto.setFlag(prpLpersonLossFlag[index]);
					prpLpersonLossDto
							.setLiabDetailCode(prpLpersonLossLiabDetailCode[index]);
					prpLpersonLossDto
							.setLiabDetailName(prpLpersonLossLiabDetailName[index]);
					prpLpersonLossDto
							.setUnitAmount(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossUnitAmount[index])));
					// prpLpersonLossDto.setHospitalDays(
					// Integer.parseInt(DataUtils.nullToZero(prpLpersonLossHospitalDays
					// [index])));
					prpLpersonLossDto
							.setLossQuantity(Integer
									.parseInt(DataUtils
											.nullToZero(prpLpersonLossLossQuantity[index])));
					prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils
							.nullToZero(prpLpersonLossSumLoss[index])));

					// prpLpersonLossDto.setSex ( prpLpersonLossSex [index]);
					// prpLpersonLossDto.setPersonName (
					// prpLpersonLossPersonName [index]);
					// prpLpersonLossDto.setAge (
					// Integer.parseInt(DataUtils.nullToZero( prpLpersonLossAge
					// [index])));
					prpLpersonLossDto
							.setCurrency3(prpLpersonLossCurrency3[index]);
					prpLpersonLossDto
							.setFamilyName(prpLpersonLossFamilyName[index]);
					prpLpersonLossDto
							.setIndemnityDutyRate(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossIndemnityDutyRate[index])));
					// prpLpersonLossDto.setKindCode(prpLpersonLossKindCode[index]);
					prpLpersonLossDto
							.setDeductibleRate(Double
									.parseDouble(DataUtils
											.nullToZero(prpLpersonLossDeductibleRate[index])));
					prpLpersonLossDto.setPersonNo(index);
					// ����for���治�˶����⸶�����Ϣ��ԭ���ձ�index����
					for (int index3 = 0; index3 < prpLpersonLossSerialNo.length; index3++) {
						if (prpLpersonLossSerialNo[index3]
								.equals(personLossSerialNo[index])) {

							prpLpersonLossDto
									.setItemKindNo(Integer
											.parseInt(DataUtils
													.nullToZero(prpLpersonLossItemKindNo[index]))); // �����
							prpLpersonLossDto
									.setKindCode(prpLpersonLossKindCode[index]);
						}
					}

					// for (int index2 = 0; index2 <
					// prpLpersonLossSerialNo.length; index2++) {
					for (int index2 = 0; index2 < prpLpersonLossAge.length; index2++) {
						if (prpLpersonLossSerialNo[index2]
								.equals(personLossSerialNo[index])) {
							/*
							 * prpLpersonLossDto.setCurrency3 (
							 * prpLpersonLossCurrency3 [index2]);
							 * prpLpersonLossDto.setFamilyName (
							 * prpLpersonLossFamilyName [index2]);
							 * prpLpersonLossDto.setIndemnityDutyRate (
							 * Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate
							 * [index2]))); prpLpersonLossDto.setKindCode (
							 * prpLpersonLossKindCode [index2]);
							 * prpLpersonLossDto.setDeductibleRate (
							 * Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate
							 * [index2]))); prpLpersonLossDto.setPersonNo
							 * (index2);
							 */
							prpLpersonLossDto.setAge(Integer.parseInt(DataUtils
									.nullToZero(prpLpersonLossAge[index2])));
							prpLpersonLossDto.setPersonNo(index2);
							prpLpersonLossDto
									.setPersonName(prpLpersonLossPersonName[index2]);
							prpLpersonLossDto.setSex(prpLpersonLossSex[index2]);
						}
					}
					// ��Ԫ��prpLdangerItem������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
					/*
					 * PrpLdangerItemDto prpLdangerItemDtoPerson = new
					 * PrpLdangerItemDto();
					 * prpLdangerItemDtoPerson.setCertiNo(prpLlossDtoCompensateNo);
					 * //ʵ��� prpLdangerItemDtoPerson.setDangerNo(1);
					 * //Ŀǰֻ��һ��Σ�յ�λ
					 * prpLdangerItemDtoPerson.setCurrency(prpLpersonLossCurrency[index]);
					 * //��ʧ�ұ� prpLdangerItemDtoPerson.setKindFlag("0");
					 * //�ձ�����־,0��ʾ���� prpLdangerItemDtoPerson.setKindName("����");
					 * //�ձ��������
					 * prpLdangerItemDtoPerson.setRiskCode(prpLpersonLossRiskCode);
					 * //�ձ�
					 * prpLdangerItemDtoPerson.setSerialNo(dangerItemSerialNo);
					 * //������ dangerItemSerialNo++;
					 * prpLdangerItemDtoPerson.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
					 * //�Ѿ����
					 * prpLprpLdangerItemList.add(prpLdangerItemDtoPerson);
					 */
					// add by qinyongli end 2005-9-10
					// ���뼯��
					prpLpersonLossDtoList.add(prpLpersonLossDto);
				}
			}
		}
		// �⸶��Ա��Ϣ
		compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
		/*---------------------��������ϢprpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// �ӽ���õ���������
		String prpLchargePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLchargeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		// String prpLchargeCompensateNo =
		// httpServletRequest.getParameter("prpLcompensateCompensateNo");
		String prpLchargeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String[] prpLchargeSerialNo = httpServletRequest
				.getParameterValues("prpLchargeSerialNo");
		String[] prpLchargeKindCode = httpServletRequest
				.getParameterValues("prpLchargeKindCode");
		String[] prpLchargeChargeCode = httpServletRequest
				.getParameterValues("prpLchargeChargeCode");
		String[] prpLchargeChargeName = httpServletRequest
				.getParameterValues("prpLchargeChargeName");
		String[] prpLchargeCheckDeptCode = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptCode");
		String[] prpLchargeCheckDeptName = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptName");
		String[] prpLchargeCurrency = httpServletRequest
				.getParameterValues("prpLchargeCurrency");
		String[] prpLchargeChargeAmount = httpServletRequest
				.getParameterValues("prpLchargeChargeAmount");
		String[] prpLpreChargeAmount = httpServletRequest
				.getParameterValues("prpLpreChargeAmount");
		String[] prpLchargeSumRealPay = httpServletRequest
				.getParameterValues("prpLchargeSumRealPay");
		String[] prpLchargeFlag = httpServletRequest
				.getParameterValues("prpLchargeFlag");
		String[] prpLchargeChargeReport = httpServletRequest
				.getParameterValues("prpLchargeChargeReport"); // add 20060512
		String[] prpLchargePayObjectType = httpServletRequest
				.getParameterValues("prpLchargePayObjectType"); // add 20060803
		String[] prpLchargePayObjectCode = httpServletRequest
				.getParameterValues("prpLchargePayObjectCode"); // add 20060803
		String[] prpLchargePayObjectName = httpServletRequest
				.getParameterValues("prpLchargePayObjectName"); // add 20060803
		String[] prpLlossDtoItemKindNoForCharge = httpServletRequest
				.getParameterValues("prpLlossDtoItemKindNoForCharge"); // ���ñ�Ĵ���

		// ����ֵ
		if (prpLchargeSerialNo == null) {

		} else {
			for (int index = 1; index < prpLchargeSerialNo.length; index++) {
				prpLchargeDto = new PrpLchargeDto();
				prpLchargeDto.setPolicyNo(prpLchargePolicyNo);
				prpLchargeDto.setRiskCode(prpLchargeRiskCode);
				prpLchargeDto.setCompensateNo(prpLchargeCompensateNo);

				prpLchargeDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLchargeSerialNo[index])));
				prpLchargeDto.setKindCode(prpLchargeKindCode[index]);
				prpLchargeDto.setChargeCode(prpLchargeChargeCode[index]);
				prpLchargeDto.setChargeName(prpLchargeChargeName[index]);
				if (prpLchargeChargeCode[index] != null
						&& "14".equals(prpLchargeChargeCode[index])) {
					prpLchargeDto
							.setCheckDeptCode(prpLchargeCheckDeptCode[index]);
					prpLchargeDto
							.setCheckDeptName(prpLchargeCheckDeptName[index]);
				}
				prpLchargeDto.setCurrency(prpLchargeCurrency[index]);
				prpLchargeDto.setChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeChargeAmount[index])));
				prpLchargeDto.setPreChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLpreChargeAmount[index])));
				prpLchargeDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeSumRealPay[index])));
				prpLchargeDto.setFlag(prpLchargeFlag[index]);
				if (prpLchargeChargeReport == null
						|| prpLchargeChargeReport.length < 1) {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeAmount[index]))); // add
					// 20060512
				} else {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeReport[index])));
				}

				prpLchargeDto.setPayObjectCode(prpLchargePayObjectCode[index]);
				prpLchargeDto.setPayObjectType(prpLchargePayObjectType[index]);
				prpLchargeDto.setPayObjectName(prpLchargePayObjectName[index]);
				prpLchargeDto.setItemkindno(Integer.parseInt(DataUtils
						.nullToZero(prpLlossDtoItemKindNoForCharge[index])));

				// ��Ԫ��prpLdangerItem������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
				/*
				 * PrpLdangerItemDto prpLdangerItemChargeDto = new
				 * PrpLdangerItemDto();
				 * prpLdangerItemChargeDto.setCertiNo(prpLchargeCompensateNo);
				 * //ʵ��� prpLdangerItemChargeDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemChargeDto.setCurrency(prpLchargeCurrency[index]);
				 * //��ʧ�ұ� prpLdangerItemChargeDto.setKindFlag("0");
				 * //�ձ�����־,0��ʾ���� prpLdangerItemChargeDto.setKindName("����");
				 * //�ձ��������
				 * prpLdangerItemChargeDto.setRiskCode(prpLchargeRiskCode); //�ձ�
				 * prpLdangerItemChargeDto.setSerialNo(dangerItemSerialNo);
				 * //������ dangerItemSerialNo++;
				 * prpLdangerItemChargeDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				 * //�Ѿ���� prpLprpLdangerItemList.add(prpLdangerItemChargeDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// ��������Ϣ
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		/*
		 * ArrayList prpLqualityCheckDtoList = new ArrayList();
		 * PrpLqualityCheckDto prpLqualityCheckDto = null; String strCount =
		 * httpServletRequest.getParameter("txtRecordNum"); int intCount =
		 * Integer.parseInt(strCount); int j=0; String strQuestionCode = "";
		 * String strQuestionName = ""; String strQuestionRemark = ""; String
		 * strVisitBackQueRes = ""; for(int i=0;i <intCount;i++) { j = i+1;
		 * strQuestionCode = "txtQuestionCode"+j; strQuestionName =
		 * "txtQuestionName"+j; strQuestionRemark = "txtQuestionRemark"+j;
		 * strVisitBackQueRes = "VisitBackQue"+j; prpLqualityCheckDto = new
		 * PrpLqualityCheckDto();
		 * prpLqualityCheckDto.setRegistNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
		 * prpLqualityCheckDto.setQualityCheckType(httpServletRequest.getParameter("qualityCheckType"));
		 * prpLqualityCheckDto.setSerialNo(i+1);
		 * prpLqualityCheckDto.setTypeName(httpServletRequest.getParameter(strQuestionName));
		 * prpLqualityCheckDto.setTypeCode(httpServletRequest.getParameter(strQuestionCode));
		 * prpLqualityCheckDto.setCheckResult(httpServletRequest.getParameter(strVisitBackQueRes));
		 * prpLqualityCheckDto.setCheckRemark(httpServletRequest.getParameter(strQuestionRemark));
		 * prpLqualityCheckDto.setFlag("");
		 * prpLqualityCheckDtoList.add(prpLqualityCheckDto);
		 * //System.out.println("----j----"+j+"|"+strVisitBackQueRes+"|"+strQuestionRemark); }
		 * //�ӵ�ArrayList��
		 * compensateDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
		 * //����ط���ѯ��Ϣ����
		 */

		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		/*
		 * ArrayList prpLregistExtDtoList = new ArrayList(); PrpLregistExtDto
		 * prpLregistExtDto = null ; //�ӽ���õ��������� String prpLregistExtRegistNo =
		 * (String)httpServletRequest.getParameter("prpLregistExtRegistNo");
		 * String prpLregistExtRiskCode = httpServletRequest.getParameter
		 * ("prpLregistExtRiskCode"); String[] prpLregistExtSerialNo =
		 * httpServletRequest.getParameterValues("prpLregistExtSerialNo");
		 * String[] prpLregistExtInputDate =
		 * httpServletRequest.getParameterValues("prpLregistExtInputDate");
		 * String[] prpLregistExtInputHour =
		 * httpServletRequest.getParameterValues("prpLregistExtInputHour");
		 * String[] prpLregistExtOperatorCode =
		 * httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
		 * String[] prpLregistExtContext =
		 * httpServletRequest.getParameterValues("prpLregistExtContext"); //����ֵ
		 * //��Ա�������� ���ֿ�ʼ if (prpLregistExtSerialNo==null) {} else {
		 * //System.out.println("��Ա�������ٲ��ֿ�ʼ "); for(int index=1;index
		 * <prpLregistExtSerialNo.length;index++) { prpLregistExtDto = new
		 * PrpLregistExtDto();
		 * prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
		 * prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
		 * prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
		 * prpLregistExtDto.setInputDate(new
		 * DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
		 * prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
		 * prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
		 * prpLregistExtDto.setContext(prpLregistExtContext[index]); //���뼯��
		 * prpLregistExtDtoList.add(prpLregistExtDto); } //���������м�����ʧ��λ
		 * compensateDto.setPrpLregistExtDtoList(prpLregistExtDtoList); }
		 */

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// �ӽ���õ���������
		String prpLcfeeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLcfeePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLcfeeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLcfeeCurrency1 = httpServletRequest
				.getParameter("prpLcompensateCurrency");
		String prpLcfeeSumThisPaid = httpServletRequest
				.getParameter("prpLcompensateSumThisPaid");
		String prpLcfeeFlag = httpServletRequest.getParameter("prpLcfeeFlag");
		// ����ֵ
		// ����������Ϣ
		prpLcfeeDto = new PrpLcfeeDto();
		prpLcfeeDto.setCompensateNo(prpLcfeeCompensateNo);
		prpLcfeeDto.setPolicyNo(prpLcfeePolicyNo);
		prpLcfeeDto.setRiskCode(prpLcfeeRiskCode);
		prpLcfeeDto.setCurrency(prpLcfeeCurrency1);
		prpLcfeeDto.setSumPaid(Double.parseDouble(DataUtils
				.nullToZero(prpLcfeeSumThisPaid)));
		prpLcfeeDto.setFlag("");
		prpLcfeeDtoList.add(prpLcfeeDto);
		compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);
		// ����������ڰ����⸶������Ҫ�᰸�����ı�
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");

		// modify by lixiang start 2006-8-1
		// reason:���ڲ��ǵ�һ�ż����������£�Ҫ˵��������������Ծ�Ҫ����������
		// if (prpLcompensateFinallyFlag.equals("1")) {
		ArrayList prpLltextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLltextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			PrpLltextDto prpLltextDto = new PrpLltextDto();
			prpLltextDto.setClaimNo((String) httpServletRequest
					.getParameter("prpLcompensateClaimNo"));
			prpLltextDto.setContext(rules[k]);
			prpLltextDto.setLineNo(k + 1);
			prpLltextDto.setTextType("08");
			prpLltextDtoList.add(prpLltextDto);
		}

		// compensateDto
		compensateDto.setPrpLltextDtoList(prpLltextDtoList);
		// }
		// modify by lixiang start 2006-8-1
		compensateDto.getPrpLcompensateDto().setFinallyFlag(
				prpLcompensateFinallyFlag);
		// ----------------------------Σ�յ�λ��Ϣ����,Ŀǰֻ��һ��Σ�յ�λ
		// ��Ԫ��prpLdangertot������Ų������Σ�յ�λprpLdangerUnitѭ����ȥ������ע�����´���
		/*
		 * String TCurrency = httpServletRequest.getParameter("MergeCurrency");
		 * //��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10
		 * compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
		 * //�Ա����Ϣ���д����õ��ϼ���Ϣ ArrayList itemListAll =(ArrayList)
		 * prpLprpLdangerItemList.clone(); ArrayList itemList =(ArrayList)
		 * prpLprpLdangerItemList.clone(); PrpLdangerItemDto dangerItemAll = new
		 * PrpLdangerItemDto(); //��ȡÿ����Ķ��� PrpLdangerItemDto dangerItem = new
		 * PrpLdangerItemDto(); //ѭ���ж�ʱʹ�� ArrayList tempCurrency = new
		 * ArrayList(); Iterator itemListIteratorAll = itemListAll.iterator();
		 * Iterator itemListIterator = itemList.iterator(); PrpLdangerItemDto
		 * dangerItemAll1 = new PrpLdangerItemDto();
		 * while(itemListIteratorAll.hasNext()){ dangerItemAll=
		 * (PrpLdangerItemDto)itemListIteratorAll.next(); dangerItemAll1 = new
		 * PrpLdangerItemDto();
		 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
		 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());
		 * 
		 * //�õ�ǰ�ұ�������Ͻ���ͳ�� String currentCur = dangerItemAll1.getCurrency();
		 * if(tempCurrency.contains(currentCur)){ continue; //����Ѿ��ϼƹ��ı��֣����ٽ��кϼ�; }
		 * int currentSerial = dangerItemAll1.getSerialNo();
		 * while(itemListIterator.hasNext()){ dangerItem =
		 * (PrpLdangerItemDto)itemListIterator.next(); //����ұ���ȣ�����⳥���ͷ��ý����ۼ�
		 * if(currentSerial!=dangerItem.getSerialNo()&&currentCur.equals(dangerItem.getCurrency())){
		 * dangerItemAll1.setSumFee(dangerItemAll1.getSumFee()+dangerItem.getSumFee());
		 * //�ϼƷ���
		 * dangerItemAll1.setSumPaid(dangerItemAll1.getSumPaid()+dangerItem.getSumPaid());
		 * //�ϼƽ�� } } tempCurrency.add(currentCur); //����ǰ�ϼƵı����ݴ� ;
		 * //�������Ϣ����ϼ�Dto if(dangerItemAll!=null){
		 * prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
		 * prpLdangerTotDto.setDangerNo(1); //Ŀǰ����һ��Σ�յ�λ
		 * prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); //���ԭ�ұ�
		 * prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
		 * prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
		 * prpLdangerTotDto.setTCurrency(TCurrency); //���бұ�ת�� ת����ıұ�ΪTCurrency
		 * String SCurrency = dangerItemAll.getCurrency(); //ԭ�ұ� double
		 * exchangeRate =
		 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
		 * Date())); prpLdangerTotDto.setExchRate(exchangeRate);
		 * prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()*exchangeRate);
		 * prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()*exchangeRate); }
		 * if(prpLdangerTotDto!=null){
		 * prpLprpLdangerTotList.add(prpLdangerTotDto); } }
		 * compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
		 */
		// ��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10 end
		if (DangerUnitCheckSaveFlag.equals("1")) {
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061130 start reason ���ٱ�������
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061130 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// �ӽ���õ���������
			String compensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");
			String[] prpLdangerClaimNo = httpServletRequest
					.getParameterValues("prpLdangerClaimNo");
			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDesc");
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerAddressName");
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");

			String[] prpLdangerRiskSumClaim = httpServletRequest
					.getParameterValues("prpLdangerRiskSumClaim");
			String[] prpLdangerRiskSumPaid = httpServletRequest
					.getParameterValues("prpLdangerRiskSumPaid");
			String[] prpLcompensateSumThisPaid = httpServletRequest
					.getParameterValues("prpLcompensateSumThisPaid");
			String[] prpLdangerProportion = httpServletRequest
					.getParameterValues("prpLdangerProportion");
			String prpLcompensateSumNoDutyFee = httpServletRequest
					.getParameter("prpLcompensateSumNoDutyFee");

			// ��ǰ����prpLdangerUnit���״���ע������һ��
			// ����ֵ
			/*
			 * if (prpLdangerCurrency == null) { } else { for (int index = 0;
			 * index < prpLdangerCurrency.length; index++) { prpLdangerUnitDto =
			 * new PrpLdangerUnitDto();
			 * prpLdangerUnitDto.setCertiNo(compensateNo);
			 * prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
			 * prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
			 * prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
			 * prpLdangerUnitDto.setDangerNo(index+1);
			 * prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
			 * prpLdangerUnitDto.setAddressName(prpLdangerAddressName[index]);
			 * prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
			 * prpLdangerUnitDto.setSumLoss(Double.parseDouble(prpLdangerRiskSumClaim[index]));
			 * prpLdangerUnitDto.setSumPaid(Double.parseDouble(prpLdangerRiskSumPaid[index]));
			 * prpLdangerUnitDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
			 * //prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
			 * //��������ȡʵ�� if(!prpLdangerClaimNo[index].equals("")){ ClaimDto
			 * claimDto = new ClaimDto(); UIClaimAction uiclaimAction= new
			 * UIClaimAction(); claimDto =
			 * uiclaimAction.findByPrimaryKey(prpLdangerClaimNo[index]); double
			 * sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
			 * prpLdangerUnitDto.setSumNoPaid(Double.parseDouble(prpLdangerRiskSumClaim[index])-sumPaid); }
			 * if("1".equals(prpLcompensateFinallyFlag)){
			 * prpLdangerUnitDto.setCertiType("3");//����Ϊʵ��
			 * prpLdangerUnitDto.setSumNoPaid(0); //�᰸ δ��������� }else{
			 * prpLdangerUnitDto.setCertiType("3");
			 * prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index])); }
			 * prpLdangerUnitDto.setDangerShare(Double.parseDouble(prpLdangerProportion[index]));
			 * prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);//add by kangzhen
			 * //���뼯��
			 * if(prpLdangerPolicyNo[index]!=null&&!(prpLdangerPolicyNo[index].equals(""))){
			 * dangerUnitList.add(prpLdangerUnitDto); } }
			 * if(dangerUnitList.size()>0){
			 * compensateDto.setPrplRiskUnitDtoList(dangerUnitList); } }
			 */
			// ��Ԫ����Σ�յ�λ�����Ϣ���¿���һ�ף�����ǰ������ע���ˣ�
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
			String sql = "";
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto();
			double sumTempLoss = 0;// dangerUnit����������һ���ۼ�ֵ������������⣩
			double sumTempPaid = 0;// dangerUnit�Ѿ��������һ���ۼ�ֵ
			double sumTempNoPaid = 0;// dangerUnitδ���������һ���ۼ�ֵ
			double tempLoss = 0;
			double tempPaid = 0;
			double tempNoPaid = 0;

			double sumLSumRealPay[] = new double[1000];

			// start
			// ��Ԫ�¸ķ���-------------------------------------------------------------------------
			// ����ֵ
			if (prpLdangerCurrency == null) {
			} else {
				sql = " certino ='" + prpLdangerClaimNo[0] + "'";
				// ȡ������Σ�յ�λ��Ϣ������ ����Σ�յ�λ ���� �����Σ�յ�λ��Ϣ
				List prpLdangerUnitClaimList = (ArrayList) blPrpLdangerUnitFacade
						.findByConditions(sql);
				for (int index = 0; index < prpLdangerCurrency.length; index++) {

					sumTempLoss = 0;
					sumTempPaid = 0;
					sumTempNoPaid = 0;

					double sumPaid = 0;
					double sumNoPaid = 0;

					// ȡ����������δ��
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
						sumNoPaid = Double
								.parseDouble(prpLdangerRiskSumClaim[index])
								- sumPaid;// ��������δ��
					}

					// ���� ����Σ�յ�λ ���� �����Σ�յ�λ��Ϣ
					for (int dangerUnitSize = 0; dangerUnitSize < prpLdangerUnitClaimList
							.size(); dangerUnitSize++) {
						List temPrpLprpLdangerItemList = new ArrayList();
						dangerItemSerialNo = 1;
						prpLdangerUnitClaimDto = (PrpLdangerUnitDto) prpLdangerUnitClaimList
								.get(dangerUnitSize);

						// 1������Σ�յ�λprpLdangerUnit
						prpLdangerUnitDto = new PrpLdangerUnitDto();
						prpLdangerUnitDto.setCertiNo(compensateNo);
						prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
						prpLdangerUnitDto
								.setRiskCode(prpLdangerRiskCode[index]);
						prpLdangerUnitDto
								.setPolicyNo(prpLdangerPolicyNo[index]);
						prpLdangerUnitDto.setDangerNo(prpLdangerUnitClaimDto
								.getDangerNo());
						prpLdangerUnitDto
								.setDangerDesc(prpLdangerUnitDesc[index]);
						prpLdangerUnitDto
								.setAddressName(prpLdangerAddressName[index]);
						prpLdangerUnitDto
								.setCurrency(prpLdangerCurrency[index]);
						prpLdangerUnitDto
								.setBusinessNature(prpLdangerUnitClaimDto
										.getBusinessNature());
						prpLdangerUnitDto
								.setPolicyBizType(prpLdangerUnitClaimDto
										.getPolicyBizType());
						prpLdangerUnitDto.setPolicyType(prpLdangerUnitClaimDto
								.getPolicyType());
						prpLdangerUnitDto
								.setBusinessType(prpLdangerUnitClaimDto
										.getBusinessType());
						prpLdangerUnitDto
								.setBusinessType1(prpLdangerUnitClaimDto
										.getBusinessType1());
						prpLdangerUnitDto.setOthFlag(prpLdangerUnitClaimDto
								.getOthFlag());
						prpLdangerUnitDto
								.setBusinessProvince(prpLdangerUnitClaimDto
										.getBusinessProvince());
						prpLdangerUnitDto
								.setBusinessTown(prpLdangerUnitClaimDto
										.getBusinessTown());
						prpLdangerUnitDto
								.setBusinessCounty(prpLdangerUnitClaimDto
										.getBusinessCounty());
						prpLdangerUnitDto
								.setBusinessAreaName(prpLdangerUnitClaimDto
										.getBusinessAreaName());
						if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1)// ���һ��Σ�յ�λ�ü�����
						{
							tempLoss = Str.round(Double
									.parseDouble(prpLdangerRiskSumClaim[index])
									- sumTempLoss, 2);
							tempPaid = Str.round(Double
									.parseDouble(prpLdangerRiskSumPaid[index])
									- sumTempPaid, 2);
							tempNoPaid = sumNoPaid - sumTempNoPaid;

						}
						// �����һ��Σ�յ�λ�ó˷��㣨���Ա�����
						else {
							tempLoss = Str.round(Double
									.parseDouble(prpLdangerRiskSumClaim[index])
									* prpLdangerUnitClaimDto.getDangerShare()
									/ 100, 2);
							tempPaid = Str.round(Double
									.parseDouble(prpLdangerRiskSumPaid[index])
									* prpLdangerUnitClaimDto.getDangerShare()
									/ 100, 2);
							tempNoPaid = Str.round(sumNoPaid
									* prpLdangerUnitClaimDto.getDangerShare()
									/ 100, 2);
							sumTempLoss += tempLoss;
							sumTempPaid += tempPaid;
							sumTempNoPaid += tempNoPaid;
						}
						prpLdangerUnitDto.setSumLoss(tempLoss);
						prpLdangerUnitDto.setSumPaid(tempPaid);
						prpLdangerUnitDto.setSumNoPaid(tempNoPaid);
						prpLdangerUnitDto.setDamageDate(compensateDto
								.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
						prpLdangerUnitDto.setDangerShare(prpLdangerUnitClaimDto
								.getDangerShare());
						if ("1".equals(prpLcompensateFinallyFlag)) {
							prpLdangerUnitDto.setCertiType("3");// ����Ϊʵ��
							prpLdangerUnitDto.setSumNoPaid(0); // �᰸ δ���������
						} else {
							prpLdangerUnitDto.setCertiType("3");
							// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
						}
						prpLdangerUnitDto.setCoinsFlag(strCoinsFlag); // add
						// by
						// kangzhen
						// ���뼯��
						if (prpLdangerPolicyNo[index] != null
								&& !(prpLdangerPolicyNo[index].equals(""))) {
							dangerUnitList.add(prpLdangerUnitDto);
						}

						// 2�����ɴ����Σ�յ�λ���prpLdangerItem��������
						if (prpLlossDtoSerialNo == null) {

						} else {
							double tempLossRealPay = 0;
							for (int j = 1; j < prpLlossDtoSerialNo.length; j++) {

								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLlossDtoCompensateNo); // ʵ���
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto
										.setCurrency(prpLlossDtoCurrency2[index]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto
										.setRiskCode(prpLlossDtoRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList
										.size() - 1) {
									tempLossRealPay = Str
											.round(
													Double
															.parseDouble(DataUtils
																	.nullToZero(prpLlossDtoSumRealPay[j]))
															- sumLSumRealPay[dangerItemSerialNo],
													2);
								} else {
									tempLossRealPay = Str
											.round(
													Double
															.parseDouble(DataUtils
																	.nullToZero(prpLlossDtoSumRealPay[j]))
															* prpLdangerUnitClaimDto
																	.getDangerShare()
															/ 100, 2);
									sumLSumRealPay[dangerItemSerialNo] += tempLossRealPay;
								}
								prpLdangerItemDto.setSumPaid(tempLossRealPay); // �Ѿ����
								prpLdangerItemDto
										.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;

								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						if (personLossSerialNo == null) {

						} else {
							double tempPersonRealPay = 0;
							/*
							 * String strRiskType =
							 * uiCodeAction.translateRiskCodetoRiskType(prpLpersonLossRiskCode);
							 * if (prpLpersonLossRiskCode != null&&
							 * "D".equals(strRiskType)) { //����ֵ for (int j = 1;
							 * j < personLossSerialNo.length; j++) { } }else {
							 */
							for (int j = 1; j < personLossSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLpersonLossCompensateNo); // ʵ���
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto
										.setCurrency(prpLpersonLossCurrency[j]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto
										.setRiskCode(prpLpersonLossRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList
										.size() - 1) {
									tempPersonRealPay = Str
											.round(
													Double
															.parseDouble(DataUtils
																	.nullToZero(prpLpersonLossSumRealPay[j]))
															- sumLSumRealPay[dangerItemSerialNo],
													2);
								} else {
									tempPersonRealPay = Str
											.round(
													Double
															.parseDouble(DataUtils
																	.nullToZero(prpLpersonLossSumRealPay[j]))
															* prpLdangerUnitClaimDto
																	.getDangerShare()
															/ 100, 2);
									sumLSumRealPay[dangerItemSerialNo] += tempPersonRealPay;
								}
								prpLdangerItemDto.setSumPaid(tempPersonRealPay);
								prpLdangerItemDto
										.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;
								// �Ѿ����
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
							// }
						}

						// 3�����ɴ�Σ�յ�λ��prpLdangerItem�����ã�
						if (prpLchargeSerialNo == null) {

						} else {
							double tempLchargeSumRealPay = 0;
							for (int j = 1; j < prpLchargeSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLchargeCompensateNo); // ʵ���
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto
										.setCurrency(prpLchargeCurrency[j]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto
										.setRiskCode(prpLchargeRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList
										.size() - 1) {
									tempLchargeSumRealPay = Str
											.round(
													Double
															.parseDouble(DataUtils
																	.nullToZero(prpLchargeChargeAmount[j]))
															- sumLSumRealPay[dangerItemSerialNo],
													2);
								} else {
									// Σ�յ�λ��ı����Ƿ����ǲ��Ǽ�������ȫҪ��¼��prpLdangerItem
									tempLchargeSumRealPay = Str
											.round(
													Double
															.parseDouble(DataUtils
																	.nullToZero(prpLchargeChargeAmount[j]))
															* prpLdangerUnitClaimDto
																	.getDangerShare()
															/ 100, 2);
									sumLSumRealPay[dangerItemSerialNo] += tempLchargeSumRealPay;
								}
								prpLdangerItemDto
										.setSumFee(tempLchargeSumRealPay);
								prpLdangerItemDto
										.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						// 4�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTotD������prpLdangerItem��
						Iterator itemListIteratorAll = temPrpLprpLdangerItemList
								.iterator();
						Iterator itemListIterator = temPrpLprpLdangerItemList
								.iterator();
						double sumPaidAll = 0;
						while (itemListIteratorAll.hasNext()) {
							dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll
									.next();
							sumPaidAll = Str.round(sumPaidAll
									+ dangerItemAll.getSumPaid(), 2);
							sumPaidAll = Str.round(sumPaidAll
									+ dangerItemAll.getSumFee(), 2);
						}
						prpLdangerTotDto = new PrpLdangerTotDto(); // ���ϼ�Dto
						prpLdangerTotDto.setCertiNo(compensateNo);
						prpLdangerTotDto.setDangerNo(prpLdangerUnitClaimDto
								.getDangerNo()); // Ŀǰ����һ��Σ�յ�λ
						prpLdangerTotDto
								.setSCurrency(prpLdangerCurrency[index]); // ���ԭ�ұ�
						prpLdangerTotDto.setSumFee(0);
						prpLdangerTotDto.setSumPaid(sumPaidAll);
						prpLdangerTotDto
								.setTCurrency(prpLdangerCurrency[index]);
						// ���бұ�ת�� ת����ıұ�ΪTCurrency
						/*
						 * String SCurrency = dangerItemAll.getCurrency(); //ԭ�ұ�
						 * double exchangeRate =
						 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
						 * Date()));
						 */
						prpLdangerTotDto.setExchRate(1);
						prpLdangerTotDto.setSumFeeEx(0);
						prpLdangerTotDto.setSumPaidEx(sumPaidAll);
						if (prpLdangerTotDto != null) {
							prpLprpLdangerTotList.add(prpLdangerTotDto);
						}

					}

				}
				// �����Ϣ
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
				compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
				compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			}
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {

			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// start------------------------------------*/

			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();

			ArrayList dangerUnitList = new ArrayList();
			ArrayList dangerItemList = new ArrayList();
			ArrayList dangerTotList = new ArrayList();
			ArrayList  prpLchargeList = compensateDto.getPrpLchargeDtoList();
            PrpLchargeDto lchargeDto = null;
            boolean isfee;

			double temp = 0;
			double sumDangerUnit = 0d;
			boolean flag = true;
			// �ӽ���õ���������

			String prpLdangerCompensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");// �������

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");// ������
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");// ���ֺ�
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");// Σ�յ�λ����
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");// Σ�յ�λ��ַ
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");// �ұ�
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");// �⸶���
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");// Σ�յ�λ��
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");// ռ��
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");// �ձ����
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");// �ձ�����
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");// ��Ĵ���
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");// �������
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// ������

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// ҵ����Դ
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// ����ҵ������
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// Ͷ����ʽ
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// �����Ա�־
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// ��ũ��ʶ
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// ������ʶ�ֶ�
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// ��������ʡ
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// ����������
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// ����������
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// ������������
			// 1�����ɴ����Σ�յ�λ���prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto(); // ���DTO
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); // Σ�յ�λ
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); // ��ʧ�ұ�
					prpLdangerItemNewDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); // �ձ�
					prpLdangerItemNewDto.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					prpLdangerItemNewDto
							.setBusinessNature(prpLdangerBusinessNature[index]);
					prpLdangerItemNewDto
							.setPolicyBizType(prpLdangerPolicyBizType[index]);
					prpLdangerItemNewDto
							.setPolicyType(prpLdangerPolicyType[index]);
					prpLdangerItemNewDto
							.setBusinessType(prpLdangerBusinessType[index]);
					prpLdangerItemNewDto
							.setBusinessType1(prpLdangerBusinessType1[index]);
					prpLdangerItemNewDto.setOthFlag(prpLdangerOthFlag[index]);
					prpLdangerItemNewDto
							.setBusinessProvince(prpLdangerBusinessProvince[index]);
					prpLdangerItemNewDto
							.setBusinessTown(prpLdangerBusinessTown[index]);
					prpLdangerItemNewDto
							.setBusinessCounty(prpLdangerBusinessCounty[index]);
					prpLdangerItemNewDto
							.setBusinessAreaName(prpLdangerBusinessAreaName[index]);
					flag = true;
					for (int i = index + 1; i < prpLdangerCurrency.length; i++) {
						if (prpLdangerUnitItemKindNo[index].equals(prpLdangerUnitItemKindNo[i])) {
							flag = false;
						}
					}
					if (flag) {
						temp = 0;
						for (int k = 1; k < index; k++) {

							if (prpLdangerUnitItemKindNo[k].equals(prpLdangerUnitItemKindNo[index])) {
								temp += Str.round(Double.parseDouble(prpLdangerShare[k]), 2);
							}

						}
						prpLdangerItemNewDto.setDangerKindShare(Str.round(100 - temp, 2));
					} else {
						prpLdangerItemNewDto.setDangerKindShare(Double.parseDouble(prpLdangerShare[index]));
					}
					isfee = false; //�Ƿ��з��ã���������ֵ���Ӧ���ձ����ͱ�Ĵ���
	                  if(prpLchargeList != null && prpLchargeList.size()>0){
	                	 lchargeDto = new PrpLchargeDto();
	                	 for(int c=0;c<prpLchargeList.size();c++){
	                		lchargeDto = (PrpLchargeDto) prpLchargeList.get(c);
	                		if(lchargeDto.getKindCode().equals(prpLdangerKindcode[index])){
	                			isfee = true;
	     	           			break;
	                		}
  	                  }
	                  }
	                  if(isfee){
	                	 prpLdangerItemNewDto.setSumFee(Str.round((lchargeDto.getChargeAmount()-lchargeDto.getSumRealPay()),2));
	                	 prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }else{
	                	 prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }
	                  prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // ������
				
	                  sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// ���뼯��
					if (prpLdangerItemNewDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // ���DTO
			boolean find = true;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itTot = dangerTotList.iterator();
					while (itTot.hasNext()) {
						prpLdangerTotNewDto = (PrpLdangerTotDto) itTot.next();
						if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerTotDto.setSumPaid(Str.round(prpLdangerTotNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotDto.setSumPaidEx(Str.round(prpLdangerTotNewDto.getSumPaidEx() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumFee(Str.round(prpLdangerTotNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
            				prpLdangerTotNewDto.setSumFeeEx(Str.round(prpLdangerTotNewDto.getSumFeeEx()+prpLdangerItemNewDto.getSumFee(),2));
							break;
						}
					}
					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // ���ԭ�ұ�
						prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
						// ���뼯��
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3������Σ�յ�λprpLdangerUnit
			com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit dbPrpLdangerUnit = null ;
			Iterator itUnit = null;
			PrpLdangerUnitDto prpLdangerUnitNewDto = null;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itUnit = dangerUnitList.iterator();
					while (itUnit.hasNext()) {
						prpLdangerUnitNewDto = (PrpLdangerUnitDto) itUnit.next();
						if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerUnitNewDto.setSumFee(Str.round(prpLdangerUnitNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
            				prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
							break;
						}
					}

					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {

						prpLdangerUnitNewDto = new PrpLdangerUnitDto();
						prpLdangerUnitNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerUnitNewDto.setClaimNo(compensateDto.getPrpLcompensateDto().getClaimNo());
						prpLdangerUnitNewDto.setCertiType("3");
						prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto.getRiskCode());
						prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto.getPolicyno());
						prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto.getDangerdesc());
						prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto.getAddressName());
						prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerUnitNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						dbPrpLdangerUnit = new com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit();
    					dbPrpLdangerUnit.getInfo(compensateDto.getPrpLcompensateDto().getCaseNo(), ""+prpLdangerUnitNewDto.getDangerNo());
    					if(!"".equals(dbPrpLdangerUnit.getSumLoss()) && !"".equals(prpLdangerItemNewDto.getSumPaid())){
    						prpLdangerUnitNewDto.setSumNoPaid(Double.parseDouble(dbPrpLdangerUnit.getSumLoss()) - prpLdangerItemNewDto.getSumPaid());
    					}
						prpLdangerUnitNewDto.setCoinsFlag(strCoinsFlag);
						prpLdangerUnitNewDto.setDamageDate(compensateDto
								.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitNewDto.setAgricultureflag(prpCmainDto.getBusinessType1());
						prpLdangerUnitNewDto
								.setBusinessNature(prpLdangerItemNewDto
										.getBusinessNature());
						prpLdangerUnitNewDto
								.setPolicyBizType(prpLdangerItemNewDto
										.getPolicyBizType());
						prpLdangerUnitNewDto.setPolicyType(prpLdangerItemNewDto
								.getPolicyType());
						prpLdangerUnitNewDto
								.setBusinessType(prpLdangerItemNewDto
										.getBusinessType());
						prpLdangerUnitNewDto
								.setBusinessType1(prpLdangerItemNewDto
										.getBusinessType1());
						prpLdangerUnitNewDto.setOthFlag(prpLdangerItemNewDto
								.getOthFlag());
						prpLdangerUnitNewDto
								.setBusinessProvince(prpLdangerItemNewDto
										.getBusinessProvince());
						prpLdangerUnitNewDto
								.setBusinessTown(prpLdangerItemNewDto
										.getBusinessTown());
						prpLdangerUnitNewDto
								.setBusinessCounty(prpLdangerItemNewDto
										.getBusinessCounty());
						prpLdangerUnitNewDto
								.setBusinessAreaName(prpLdangerItemNewDto
										.getBusinessAreaName());
						// ���뼯��
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// ���һ��ռ�ȼ���ԭ��
				double dangerShare = 0;
				double tempSumDangerShare = 0;
				ClaimDto claimDto = new ClaimDto();
				UIClaimAction uiclaimAction = new UIClaimAction();
				claimDto = uiclaimAction.findByPrimaryKey(compensateDto
						.getPrpLcompensateDto().getClaimNo());
				double tempSumLoss = 0;
				double temSumFee=0;
				double sumTempSumLoss = 0;
				double tempSumNoPaid = 0;
				double sumTempNoPaid = 0;
				PrpLdangerUnitDto prpLdangerUnitDtotemp = null;
				for (int i = 0; i < dangerUnitList.size(); i++) {
					prpLdangerUnitDtotemp = (PrpLdangerUnitDto) dangerUnitList
							.get(i);
					if (i == (dangerUnitList.size() - 1)) {
						dangerShare = Str.round(100 - tempSumDangerShare, 2);
						tempSumNoPaid = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid() - sumTempNoPaid, 2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - sumTempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					} else {
						dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid() / sumDangerUnit * 100, 2);
						tempSumDangerShare = Str.round(tempSumDangerShare + dangerShare, 2);
						tempSumNoPaid = Str.round((claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid()) * dangerShare / 100, 2);
						sumTempNoPaid = Str.round(sumTempSumLoss + tempSumLoss,2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim() * dangerShare / 100, 2);
						sumTempSumLoss = Str.round(sumTempSumLoss + tempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					}
					prpLdangerUnitDtotemp.setDangerShare(dangerShare);
					prpLdangerUnitDtotemp.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
					prpLdangerUnitDtotemp.setSumLoss(tempSumLoss);
					prpLdangerUnitDtotemp.setSumFee(temSumFee);
					if ("1".equals(prpLcompensateFinallyFlag)) {
						prpLdangerUnitDtotemp.setSumNoPaid(0); // �᰸ δ���������
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid() - compensateDto.getPrpLcompensateDto().getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// end------------------------------------*/
		}

		return compensateDto;

	}

	// modify by luqin 2005-04-08 start
	/**
	 * ���ɷѱ�־ ����ֵ int -1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param policyNo
	 *            �ⰸ��
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// ȡ������������Ϣ
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo
				+ "' AND substr(Flag,1,1)!='1' ";
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions);
		return intReturn;
	}

	// modify by luqin 2005-04-08 end

	/**
	 * ����compensateDto�еĸ��ӱ��ڵ���Ϣ������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param compensateDto
	 *            ʵ���������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// ��������Ϣ����˵�������б�׼������
		/*
		 * Collection arrayListRegistExt = new ArrayList(); PrpLregistExtDto
		 * prpLregistExtDto = new PrpLregistExtDto(); // UICodeAction
		 * uiCodeAction = new UICodeAction(); String registNo =
		 * uiCodeAction.translateBusinessCode(compensateDto.getPrpLcompensateDto().getClaimNo(),false);
		 * prpLregistExtDto.setRegistNo(registNo);
		 * prpLregistExtDto.setRiskCode(compensateDto.getPrpLcompensateDto().getRiskCode());
		 * arrayListRegistExt = compensateDto.getPrpLregistExtDtoList();
		 * prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
		 * httpServletRequest.setAttribute("prpLregistExtDto",
		 * prpLregistExtDto);
		 */

		// �ر�Լ����Ϣ�����б�׼������
		Collection arrayList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		arrayList = compensateDto.getPrpCengageDtoList();
		ArrayList cengageListTemp = new ArrayList();
		if (arrayList != null) {
			Iterator iteratorCengage = arrayList.iterator();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
						.next();
				if (prpCengageDtoTemp.getClauseCode() != null
						&& prpCengageDtoTemp.getClauseCode().length() > 0
						&& prpCengageDtoTemp.getClauseCode().charAt(0) == 'T'
				// && prpCengageDtoTemp.getClauseCode().charAt(1)!= 'X'
				) {
					cengageListTemp.add(prpCengageDtoTemp);
				}
			}
			boolean cFlag = false;
			arrayList = new ArrayList();
			arrayList.addAll(cengageListTemp);
			cengageListTemp = new ArrayList();
			iteratorCengage = arrayList.iterator();
			PrpCengageDto prpCengageDtoTemp1 = new PrpCengageDto();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
						.next();
				if (prpCengageDtoTemp.getTitleFlag().equals("0")) {
					cFlag = true;
					cengageListTemp.add(prpCengageDtoTemp1);
					prpCengageDtoTemp1 = new PrpCengageDto();
					PropertyUtils.copyProperties(prpCengageDtoTemp1,
							prpCengageDtoTemp);
				} else {
					prpCengageDtoTemp1.setContext(prpCengageDtoTemp1
							.getContext()
							+ prpCengageDtoTemp.getClauses() + "<br>");
				}
			}
			cengageListTemp.add(prpCengageDtoTemp1);
			if (cengageListTemp.size() > 0) {
				cengageListTemp.remove(0);
			}
		}
		prpCengageDto.setPrpCengageList(cengageListTemp);

		httpServletRequest.setAttribute("prpCengageDto", prpCengageDto);

		// �⳥�޶�/�������Ϣ�����б�׼������
		Collection arraylist4 = new ArrayList();
		PrpDlimitDto prpDlimitDto = new PrpDlimitDto();
		arraylist4 = compensateDto.getPrpDlimitDtoList();
		prpDlimitDto.setPrpDlimitList(arraylist4);
		httpServletRequest.setAttribute("prpDlimitDto", prpDlimitDto);

		// ���Ҵ�����б�
		Collection collection = uiCodeAction.getCurrencyList();
		Iterator iterator = collection.iterator();
		HashMap currencyTemp = new HashMap();
		while (iterator.hasNext()) {
			PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto) iterator.next();
			currencyTemp.put(prpDcurrencyDto.getCurrencyCode(), prpDcurrencyDto
					.getCurrencyCName());
		}

		// �⳥�޶�/�������Ϣ�����б�׼������

		Collection arraylist5 = new ArrayList();
		PrpClimitDto prpClimitDto = new PrpClimitDto();
		arraylist5 = compensateDto.getPrpClimitDtoList();
		Iterator iPrpClimitTemp = arraylist5.iterator();
		while (iPrpClimitTemp.hasNext()) {
			PrpClimitDto prpClimitDtoTemp = (PrpClimitDto) iPrpClimitTemp
					.next();
			if (currencyTemp.containsKey(prpClimitDtoTemp.getCurrency())) {

				prpClimitDtoTemp.setCurrencyName(currencyTemp.get(
						prpClimitDtoTemp.getCurrency()).toString());
			}
			if (prpClimitDtoTemp.getLimitGrade().trim().equals("1")) {
				prpClimitDtoTemp.setLimitGrade("����");

			} else {
				UIPolicyAction uipolicyAction = new UIPolicyAction();
				// PolicyDto policyDto =
				// uipolicyAction.findByPrimaryKey(compensateDto.getPrpLclaimDto().getPolicyNo());
				PolicyDto policyDto = uipolicyAction
						.findByPrimaryKey(compensateDto.getPrpLcompensateDto()
								.getPolicyNo());
				Collection prpcitemkindlist = policyDto
						.getPrpCitemKindDtoList();
				Iterator itemkindlist = prpcitemkindlist.iterator();
				while (itemkindlist.hasNext()) {
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) itemkindlist
							.next();
					if (prpCitemKindDto.getItemKindNo() == prpClimitDtoTemp
							.getLimitNo()) {
						if (prpCitemKindDto.getFlag().trim().equals("1")) {
							prpClimitDtoTemp.setLimitGrade(prpCitemKindDto
									.getItemDetailName());
						} else {
							prpClimitDtoTemp.setLimitGrade(prpCitemKindDto
									.getKindName());
						}
					}
				}

				// prpClimitDtoTemp.setLimitGrade("����ձ�");
			}
			prpClimitDtoTemp.setLimitTypeName(uiCodeAction.translateLimit(
					prpClimitDtoTemp.getRiskCode(), prpClimitDtoTemp
							.getLimitType(), true));

		}
		prpClimitDto.setPrpClimitList(arraylist5);
		httpServletRequest.setAttribute("prpClimitDto", prpClimitDto);

		// �⸶�����Ϣ�����б�׼������
		Collection arrayList1 = new ArrayList();
		PrpLlossDto prpLlossDto = new PrpLlossDto();
		arrayList1 = compensateDto.getPrpLlossDtoList();
		if (arrayList1 != null) {
			Iterator iteratorPrpLloss = arrayList1.iterator();
			PrpLlossDto prpLlossDtoTemp = null;
			while (iteratorPrpLloss.hasNext()) {
				prpLlossDtoTemp = (PrpLlossDto) iteratorPrpLloss.next();
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrencyName(currencyTemp.get(
							prpLlossDtoTemp.getCurrency()).toString());
				}
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency1Name(currencyTemp.get(
							prpLlossDtoTemp.getCurrency1()).toString());
				}

				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency2Name(currencyTemp.get(
							prpLlossDtoTemp.getCurrency2()).toString());
				}
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency3Name(currencyTemp.get(
							prpLlossDtoTemp.getCurrency3()).toString());
				}
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency4Name(currencyTemp.get(
							prpLlossDtoTemp.getCurrency4()).toString());
				}
				prpLlossDtoTemp.setKindName(uiCodeAction.translateKindCode(
						prpLlossDtoTemp.getRiskCode(), prpLlossDtoTemp
								.getKindCode(), true));

			}
		}
		if (arrayList1 == null) {

		}
		prpLlossDto.setPrpLlossList(arrayList1);
		httpServletRequest.setAttribute("prpLlossDto", prpLlossDto);

		// �⸶��Ա��Ϣ�����б�׼������
		Collection arrayList2 = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
		arrayList2 = compensateDto.getPrpLpersonLossDtoList();
		if (arrayList2 != null) {
			Iterator iteraotrPersonLossTemp = arrayList2.iterator();
			PrpLpersonLossDto pLpersonLossDtoTemp = null;
			while (iteraotrPersonLossTemp.hasNext()) {
				pLpersonLossDtoTemp = (PrpLpersonLossDto) iteraotrPersonLossTemp
						.next();
				if (currencyTemp
						.containsKey(pLpersonLossDtoTemp.getCurrency2())) {
					pLpersonLossDtoTemp.setCurrency2Name(currencyTemp.get(
							pLpersonLossDtoTemp.getCurrency2()).toString());
				}
				if (currencyTemp.containsKey(pLpersonLossDtoTemp.getCurrency())) {
					pLpersonLossDtoTemp.setCurrencyName(currencyTemp.get(
							pLpersonLossDtoTemp.getCurrency()).toString());
				}
				pLpersonLossDtoTemp.setKindName(uiCodeAction.translateKindCode(
						pLpersonLossDtoTemp.getRiskCode(), pLpersonLossDtoTemp
								.getKindCode(), true));

			}
		}
		prpLpersonLossDto.setPrpLpersonLossList(arrayList2);
		httpServletRequest.setAttribute("prpLpersonLossDto", prpLpersonLossDto);

		// ��������Ϣ�����б�׼������
		Collection arrayList3 = new ArrayList();
		PrpLchargeDto prpLchargeDto = new PrpLchargeDto();
		arrayList3 = compensateDto.getPrpLchargeDtoList();
		if (arrayList3 != null) {
			Iterator iteraotrChargeDto = arrayList3.iterator();
			PrpLchargeDto prpLchargeDtoTemp = null;
			while (iteraotrChargeDto.hasNext()) {
				prpLchargeDtoTemp = (PrpLchargeDto) iteraotrChargeDto.next();
				prpLchargeDtoTemp.setKindName(uiCodeAction.translateKindCode(
						prpLchargeDtoTemp.getRiskCode(), prpLchargeDtoTemp
								.getKindCode(), true));

				if (currencyTemp.containsKey(prpLchargeDtoTemp.getCurrency())) {
					prpLchargeDtoTemp.setCurrencyName(currencyTemp.get(
							prpLchargeDtoTemp.getCurrency()).toString());
				}
			}
		}
		// add by miaowenjun 20070130 ȥ������������ start
		Collection newArrayList3 = new ArrayList();
		if ("SHOW".equals(compensateDto.getPrpLcompensateDto().getEditType())
				|| "EDIT".equals(compensateDto.getPrpLcompensateDto()
						.getEditType())) {
			for (Iterator iter = arrayList3.iterator(); iter.hasNext();) {
				PrpLchargeDto prpLchargeDtoTemp = (PrpLchargeDto) iter.next();
				if (!"28".equals(prpLchargeDtoTemp.getChargeCode())) {
					newArrayList3.add(prpLchargeDtoTemp);
				}
			}
		} else {
			newArrayList3 = arrayList3;
		}
		// add by miaowenjun 20070130 ȥ������������ end
		prpLchargeDto.setPrpLchargeList(newArrayList3);
		httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);

	}

	/**
	 * STUB-ONLY �������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void generateCtext(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws UserException, Exception {
		try {
			createReport(httpServletRequest, compensateDto);
		} catch (UserException usere) {
			throw usere;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * STUB-ONLY �����������������֣���ֲ�գ��������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void generateAgriCtext(HttpServletRequest httpServletRequest,
			double UnitAmount, double DeductibleRate, String KindName)
			throws UserException, Exception {
		try {
			createAgriReport(httpServletRequest, UnitAmount, DeductibleRate,
					KindName);
		} catch (UserException usere) {
			throw usere;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * STUB-ONLY �����������������֣���ֲ�գ��������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void createAgriReport(HttpServletRequest httpServletRequest,
			double UnitAmount, double DeductibleRate, String KindName)
			throws UserException, Exception {
		double dblSumRealpay = 0;
		double dblSettleArea = 0;
		double dblSumRealpaySum = 0;
		double dblSettleAreaSum = 0;
		Map dblSumRealpaySumMap = new HashMap();
		Map dblSettleAreaSumSumMap = new HashMap();
		Map dblSumRealpayMap = new HashMap();
		Map dblSettleAreaMap = new HashMap();
		List DutyRateList = new ArrayList();
		List prpLctextList = new ArrayList();
		String indemnityDutyRate[] = httpServletRequest
				.getParameterValues("indemnityDutyRate");
		String SettleArea[] = httpServletRequest
				.getParameterValues("prpLlossDtoSettleArea");
		String ClaimRate[] = httpServletRequest
				.getParameterValues("prpLlossDtoClaimRate");
		String SumRealPay[] = httpServletRequest
				.getParameterValues("prpLlossDtoSumRealPay");
		String riskCode = httpServletRequest.getAttribute("riskCode") == null ? ""
				: String.valueOf(httpServletRequest.getAttribute("riskCode"));
		String itemCode = httpServletRequest.getParameter("ItemCode");
		String strDamageDate = httpServletRequest.getParameter("damageDate");
		for (int i = 0; i < indemnityDutyRate.length; i++) {
			if ((!"".equals(SettleArea[i]) && null != SettleArea[i])
					&& (!"".equals(SumRealPay[i]) && null != SumRealPay[i])) {
				if (dblSettleAreaMap.containsKey(DeductibleRate)) {
					dblSumRealpay = (Double) dblSumRealpayMap
							.get(DeductibleRate)
							+ Double.parseDouble(SumRealPay[i]);
					dblSettleArea = (Double) dblSettleAreaMap
							.get(DeductibleRate)
							+ Double.parseDouble(SettleArea[i]);
					dblSettleAreaMap.put(DeductibleRate, dblSettleArea);
					dblSumRealpayMap.put(DeductibleRate, dblSumRealpay);
				} else {
					dblSettleAreaMap.put(DeductibleRate, Double
							.parseDouble(SettleArea[i]));
					dblSumRealpayMap.put(DeductibleRate, Double
							.parseDouble(SumRealPay[i]));
				}
			}
		}

		// 2016.3.30 ĵ��3187���������ȫ�����������90%(�ִ����ݿ�ȡֵ�����������)
		Double ratelimit3187 = 90.00; // Ĭ���������90%
		if ("3187".equals(riskCode)) {
			// �ӱ���ȡȫ����ʧ��
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
			blPrpCitemKind.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blPrpCitemKind.getSize() > 0
					&& !blPrpCitemKind.getArr(0).getTotalLossRatio().equals("")
					&& blPrpCitemKind.getArr(0).getTotalLossRatio() != null) {
				PrpCitemKindSchema prpCitemKindSchema = blPrpCitemKind
						.getArr(0);
				ratelimit3187 = Double.parseDouble(prpCitemKindSchema
						.getTotalLossRatio());
			}
			if (itemCode.equals("Z001")) {
				// ratelimit3187 = ratelimit3187 + 0.01; // �ϵ���90%�ֽ��ߴ�����ȫ��
			}
		}

		// 2016.4.8 ����3151���������ȫ�����������70%(�ִ����ݿ�ȡֵ�����������)
		Double ratelimit3151HB = 70.00; // �����ݿ�ȡ������ֵ��Ĭ���Ǻ��������70%
		Double ratelimit3151AH = 80.00; // �����ݿ�ȡ������ֵ��Ĭ���ǰ��������80%
		if ("3151".equals(riskCode)) {
			// �ӱ���ȡȫ����ʧ��
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
			blPrpCitemKind.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blPrpCitemKind.getSize() > 0
					&& !blPrpCitemKind.getArr(0).getTotalLossRatio().equals("")
					&& blPrpCitemKind.getArr(0).getTotalLossRatio() != null) {
				PrpCitemKindSchema prpCitemKindSchema = blPrpCitemKind
						.getArr(0);
				ratelimit3151HB = Double.parseDouble(prpCitemKindSchema
						.getTotalLossRatio());
				ratelimit3151AH = Double.parseDouble(prpCitemKindSchema
						.getTotalLossRatio());
			}
		}

		// ��ͬ����ȫ����ʧ�ʲ���,����ȫ����ʧ�ʴ����ݿ���ȡֵ,������;����µ����ֺ���������
		// ������:ë��3176
		Double ratelimitOthers = 100.00; // ��ȡ������ֵ��Ĭ����100%
		if ("3176".equals(riskCode) || "3178".equals(riskCode)
				|| "3158".equals(riskCode) || "3161".equals(riskCode)
				|| "3162".equals(riskCode) || "3164".equals(riskCode)) {
			// �ӱ���ȡȫ����ʧ��
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
			blPrpCitemKind.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blPrpCitemKind.getSize() > 0
					&& !blPrpCitemKind.getArr(0).getTotalLossRatio().equals("")
					&& blPrpCitemKind.getArr(0).getTotalLossRatio() != null) {
				PrpCitemKindSchema prpCitemKindSchema = blPrpCitemKind
						.getArr(0);
				ratelimitOthers = Double.parseDouble(prpCitemKindSchema
						.getTotalLossRatio());
			}
		}
		if ("3179".equals(riskCode)) {
			ratelimitOthers = 80.0;
		}

		prpLctextList.add("�����������:");
		prpLctextList.add("�ձ�����:" + KindName);
		String strSpace = "                      ";
		String strSpace1 = "             ";
		if (!"3172".equals(riskCode)) {
			String policyno = httpServletRequest.getParameter("PolicyNo");
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			String versionNo = "";
			Double ratelimit = 80.00; // ȫ�����ֵһ�㶼��80%
			blprpcmain.getData(policyno);
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			// 2016.3.15 ����ˮ��3101���������ȫ�����������70%
			if (versionNo.startsWith("C") && "3101".equals(riskCode))
				ratelimit = 70.00;
			if ((versionNo.startsWith("D") && "3101".equals(riskCode))
					|| (versionNo.startsWith("C") && "3108".equals(riskCode))) {
				BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
				blPrpCitemKind.getData(httpServletRequest
						.getParameter("PolicyNo"));
				if (blPrpCitemKind.getSize() > 0
						&& !blPrpCitemKind.getArr(0).getTotalLossRatio()
								.equals("")
						&& blPrpCitemKind.getArr(0).getTotalLossRatio() != null) {
					PrpCitemKindSchema prpCitemKindSchema = blPrpCitemKind
							.getArr(0);
					ratelimit = Double.parseDouble(prpCitemKindSchema
							.getTotalLossRatio());
				}
			}
			if ("3187".equals(riskCode))
				ratelimit = ratelimit3187;
			// 2016.4.6 ����ˮ������3151���⴦��ȫ����ʧ��
			if (versionNo.startsWith("C") && "3151".equals(riskCode))
				ratelimit = ratelimit3151HB;
			else if (versionNo.startsWith("B") && "3149".equals(riskCode))
				ratelimit = 85.00;
			else if (versionNo.startsWith("A") && "3149".equals(riskCode))
				ratelimit = 90.00;
			else if ("3151".equals(riskCode))
				ratelimit = ratelimit3151AH;
			else if ("3176".equals(riskCode) || "3178".equals(riskCode)
					|| "3158".equals(riskCode) || "3179".equals(riskCode)
					|| "3161".equals(riskCode) || "3162".equals(riskCode)
					|| "3164".equals(riskCode)) // ���ȫ���ʴ����ݿ�ȡֵ�����ֺſ��Դ���������
				ratelimit = ratelimitOthers;
			for (int j = 1; j < indemnityDutyRate.length; j++) {
				if (!"".equals(indemnityDutyRate[j])
						&& null != indemnityDutyRate[j]) {
					if (Double.parseDouble(indemnityDutyRate[j]) >= ratelimit) {
						if ((!"".equals(SettleArea[j]) && null != SettleArea[j])
								&& (!"".equals(SumRealPay[j]) && null != SumRealPay[j])) {
							if (dblSettleAreaSumSumMap.containsKey(100.00)) {
								dblSumRealpaySum = Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString())
										+ Double.parseDouble(SumRealPay[j]);
								dblSettleAreaSum = Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(100.00).toString())
										+ Double.parseDouble(SettleArea[j]);
								dblSettleAreaSumSumMap.put(100.00,
										dblSettleAreaSum);
								dblSumRealpaySumMap.put(100.00,
										dblSumRealpaySum);
							} else {
								dblSettleAreaSumSumMap.put(100.00, Double
										.parseDouble(SettleArea[j]));
								dblSumRealpaySumMap.put(100.00, Double
										.parseDouble(SumRealPay[j]));
							}

						}
						if (dblSettleAreaSumSumMap.containsKey(100.00)) {
							if (DutyRateList.contains(100.00)) {

							} else {
								DutyRateList.add(100.00);
							}
						}
					}

					if (Double.parseDouble(indemnityDutyRate[j]) < ratelimit) {
						dblSettleAreaSumSumMap.put(Double
								.parseDouble(indemnityDutyRate[j]), Double
								.parseDouble(SettleArea[j]));
						dblSumRealpaySumMap.put(Double
								.parseDouble(indemnityDutyRate[j]), Double
								.parseDouble(SumRealPay[j]));
						DutyRateList.add(Double
								.parseDouble(indemnityDutyRate[j]));
					}
				}
			}
		} else {
			for (int j = 1; j < indemnityDutyRate.length; j++) {
				if (!"".equals(indemnityDutyRate[j])
						&& null != indemnityDutyRate[j]) {
					if (Double.parseDouble(indemnityDutyRate[j]) >= 90.00) {
						if ((!"".equals(SettleArea[j]) && null != SettleArea[j])
								&& (!"".equals(SumRealPay[j]) && null != SumRealPay[j])) {
							if (dblSettleAreaSumSumMap.containsKey(100.00)) {
								dblSumRealpaySum = Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString())
										+ Double.parseDouble(SumRealPay[j]);
								dblSettleAreaSum = Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(100.00).toString())
										+ Double.parseDouble(SettleArea[j]);
								dblSettleAreaSumSumMap.put(100.00,
										dblSettleAreaSum);
								dblSumRealpaySumMap.put(100.00,
										dblSumRealpaySum);
							} else {
								dblSettleAreaSumSumMap.put(100.00, Double
										.parseDouble(SettleArea[j]));
								dblSumRealpaySumMap.put(100.00, Double
										.parseDouble(SumRealPay[j]));
							}

						}
						if (dblSettleAreaSumSumMap.containsKey(100.00)) {
							if (DutyRateList.contains(100.00)) {

							} else {
								DutyRateList.add(100.00);
							}
						}
					}

					if (Double.parseDouble(indemnityDutyRate[j]) < 90.00) {
						dblSettleAreaSumSumMap.put(Double
								.parseDouble(indemnityDutyRate[j]), Double
								.parseDouble(SettleArea[j]));
						dblSumRealpaySumMap.put(Double
								.parseDouble(indemnityDutyRate[j]), Double
								.parseDouble(SumRealPay[j]));
						DutyRateList.add(Double
								.parseDouble(indemnityDutyRate[j]));
					}
				}
			}
		}
		Collections.sort(DutyRateList);
		if ("3149".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			String versionNo = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			for (int k = 0; k < DutyRateList.size(); k++) {
				if (versionNo.startsWith("A")) {
					if ((Double) DutyRateList.get(k) < 90.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���� �� �⸶��� �� ��ʧ�� ");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("ȫ�������=��λ���� �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				} else if (versionNo.startsWith("B")) {
					if ((Double) DutyRateList.get(k) < 85.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���� �� �⸶��� �� ��ʧ�� ");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("ȫ�������=��λ���� �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}

			}
		} else if ("3177".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			String versionNo = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			if (versionNo.startsWith("C")) {
				prpLctextList
						.add("����� = ��λ���� �� ��ʧ�� �� ������� ");
				prpLctextList.add(" = "
						+ Str.round(Double.parseDouble(dblSumRealpayMap.get(
								DeductibleRate).toString()), 2));
			}
			if (versionNo.startsWith("D")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < 90.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���� �� ��ʧ��� �� ��ʧ��");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) >= 90.00) {
						prpLctextList.add("ȫ�������=��λ���ս�� �� ��ʧ��� ");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}

			// for(int k=0;k<DutyRateList.size();k++){
			// if(versionNo.startsWith("C")) {
			// prpLctextList.add("����� = ��λ���� �� ��ʧ�� �� ������� �� Ͷ�����/ʵ���ֵ���� �� ( 1 -
			// 10% )");
			// prpLctextList.add(
			// " =
			// "+Str.round(Double.parseDouble(dblSumRealpaySumMap.get(DutyRateList.get(k)).toString()),2));
			// }
			// }
		} else if ("3224".equals(riskCode)) {
			// else if("3228".equals(riskCode)||"3224".equals(riskCode)){
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) <= 100.00) {
					prpLctextList.add("��ʧ��" + DutyRateList.get(k)
							+ "%������� = ��λ���� �� �⸶���� �� �⸶��� �� ��ʧ�� �� �� 1 - �����ʣ�");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
			}
		} else if ("3145".equals(riskCode) || "3132".equals(riskCode)) {
			System.out.println("3145");
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < 80.00) {
					prpLctextList.add("��ʧ��" + DutyRateList.get(k)
							+ "%������� = ���ս�� �� �⸶���� �� ��ʧ�� �� ������� �� �� 1 - �����ʣ�");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) == 100.00) {
					prpLctextList.add("�����������=���ս�� �� �⸶���� �� ��ʧ�� �� ������� ");
					prpLctextList.add(strSpace1
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3157".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpcmainSchema = new PrpCmainSchema();
			String versionno = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpcmainSchema = blprpcmain.getArr(0);
				versionno = prpcmainSchema.getVersionNo();
			}
			if (versionno.startsWith("D")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < 80.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ���ս�� �� �⸶���� �� ��ʧ�� �� �������");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("�����������=���ս�� �� �⸶���� �� ������� ");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
		} else if ("3181".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpcmainSchema = new PrpCmainSchema();
			String versionno = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpcmainSchema = blprpcmain.getArr(0);
				versionno = prpcmainSchema.getVersionNo();
			}
			if (versionno.startsWith("D")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < 80.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ���ս�� �� �⸶���� �� ��ʧ�� �� �������");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("�����������=���ս�� �� �⸶���� �� ������� ");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
		} else if ("3170".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpcmainSchema = new PrpCmainSchema();
			String versionno = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpcmainSchema = blprpcmain.getArr(0);
				versionno = prpcmainSchema.getVersionNo();
			}
			if (versionno.startsWith("D")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < 80.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ���ս�� �� �⸶���� �� ��ʧ�� �� �������");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("�����������=���ս�� �� �⸶���� �� ������� ");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
		} else if ("31A6".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpcmainSchema = new PrpCmainSchema();
			String versionno = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpcmainSchema = blprpcmain.getArr(0);
				versionno = prpcmainSchema.getVersionNo();
			}
			if (versionno.startsWith("D")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < 80.00) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ���ս�� �� �⸶���� �� ��ʧ�� �� �������");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("�����������=���ս�� �� �⸶���� �� ������� ");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
		} else if ("3172".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < 90.00) {
					prpLctextList.add("��ʧ��" + DutyRateList.get(k)
							+ "%������� = ��λ���� �� ��ʧ��� �� �⸶���� �� ��ʧ�� �� �� 1 - �����ʣ�");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " �� "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " �� "
							+ ClaimRate[DutyRateList.size()]
							+ "% �� "
							+ DutyRateList.get(k)
							+ "% �� (1 - "
							+ DeductibleRate
							+ "%)  = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= 90.00) {
					System.err.print("111" + (Double) (DutyRateList.get(k)));
					prpLctextList.add("ȫ�������=��λ���ս�� �� �⸶���� �� ��ʧ��� ");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " �� "
							+ ClaimRate[DutyRateList.size()]
							+ "% * "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3191".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < 90.00) {
					prpLctextList
							.add("��ʧ��"
									+ DutyRateList.get(k)
									+ "%������� = ��λ���ս��  �� ��ʧ�� �� ��ʧ��� �� �� 1 - �����ʣ� �� ����� = ��λ���ս��  �� ��ʧ�� �� ��ʧ��� -1000");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= 90.00) {
					prpLctextList
							.add("ȫ�������=��λ���ս��  �� ��ʧ��� �� �� 1 - �����ʣ� �� ��λ���ս��  �� ��ʧ��� - 1000");
					prpLctextList.add(strSpace1
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3176".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < ratelimitOthers) {
					prpLctextList.add("��ʧ��" + DutyRateList.get(k)
							+ "%������� = ÿĶ���ս��  �� ��ʧ�� �� ��ʧ���");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " �� "
							+ DutyRateList.get(k)
							+ "% �� "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= ratelimitOthers) {
					prpLctextList.add("ȫ������� = ÿĶ���ս��  �� ��ʧ���");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " �� "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3178".equals(riskCode) || "3158".equals(riskCode)
				|| "3179".equals(riskCode) || "3161".equals(riskCode)
				|| "3162".equals(riskCode) || "3164".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < ratelimitOthers) {
					prpLctextList.add("��ʧ��" + DutyRateList.get(k)
							+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ��");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " �� "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " �� "
							+ ClaimRate[DutyRateList.size()]
							+ "% �� "
							+ DutyRateList.get(k)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= ratelimitOthers) {
					prpLctextList.add("ȫ������� = ��λ���� �� �⸶��� �� �⸶����");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											100.00).toString()), 2)
							+ " �� "
							+ ClaimRate[DutyRateList.size()]
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3187".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				// 1-4����ĵ��
				if (itemCode.equals("Z002")) {
					if ((Double) DutyRateList.get(k) < ratelimit3187) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �� 1 - �����ʣ�");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ DutyRateList.get(k)
								+ "% �� (1 - "
								+ DeductibleRate
								+ "%)  = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3187) {
						prpLctextList.add("ȫ������� = ��λ���ս�� �� ��ʧ�� �� ��ʧ��� ");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ DutyRateList.get(k)
								+ "% �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
				// 5�꼰������ĵ��
				else if (itemCode.equals("Z003")) {
					if ((Double) DutyRateList.get(k) < ratelimit3187) {
						prpLctextList
								.add("��ʧ��"
										+ DutyRateList.get(k)
										+ "%������� = ��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ�� �� �� 1 - �����ʣ�");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ DutyRateList.get(k)
								+ "% �� (1 - "
								+ DeductibleRate
								+ "%) = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3187) {
						prpLctextList
								.add("ȫ������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ��ʧ��");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
				// �����ϵ��ӵ�ĵ��
				else {
					if ((Double) DutyRateList.get(k) < ratelimit3187) {
						prpLctextList
								.add("��ʧ��"
										+ DutyRateList.get(k)
										+ "%������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ����ʧ�� - 20.0%��");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� ("
								+ DutyRateList.get(k)
								+ "% - 20.0%)  = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3187) {
						prpLctextList
								.add("ȫ������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ��ʧ��");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
		} else if ("3151".equals(riskCode)) {
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			String versionNo = "";
			blprpcmain.getData(httpServletRequest.getParameter("PolicyNo"));
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			// ����
			if (versionNo.startsWith("C")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < ratelimit3151HB) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ��ʧ��");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3151HB) {
						prpLctextList
								.add("ȫ������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ��ʧ��");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� 100% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
			// ����
			else {
				System.err.println("zou");
				if ("3151".equals(riskCode)
						&& !checkRiskVersion("CLAIM_VERSIONDATEAH3151", "3151",
								httpServletRequest.getParameter("PolicyNo"))) {
					for (int k = 0; k < DutyRateList.size(); k++) {

						if ((Double) DutyRateList.get(k) < ratelimit3151AH) {
							prpLctextList.add("��ʧ��" + DutyRateList.get(k)
									+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ��");
							prpLctextList.add(strSpace
									+ " = "
									+ UnitAmount
									+ " �� "
									+ Str.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
									+ " �� "
									+ ClaimRate[DutyRateList.size()]
									+ "% �� "
									+ DutyRateList.get(k)
									+ "% = "
									+ Str.round(Double
											.parseDouble(dblSumRealpaySumMap
													.get(DutyRateList.get(k))
													.toString()), 2));
						}
						if ((Double) (DutyRateList.get(k)) >= ratelimit3151AH) {
							prpLctextList.add("ȫ�������=��λ���� �� �⸶��� �� �⸶����");
							prpLctextList
									.add(strSpace1
											+ " = "
											+ UnitAmount
											+ " �� "
											+ Str
													.round(
															Double
																	.parseDouble(dblSettleAreaSumSumMap
																			.get(
																					100.00)
																			.toString()),
															2)
											+ " �� "
											+ ClaimRate[DutyRateList.size()]
											+ "% = "
											+ Str
													.round(
															Double
																	.parseDouble(dblSumRealpaySumMap
																			.get(
																					100.00)
																			.toString()),
															2));
						}
					}
				} else {
					for (int k = 0; k < DutyRateList.size(); k++) {
						if ((Double) DutyRateList.get(k) < ratelimit3151AH) {
							prpLctextList
									.add("��ʧ��"
											+ DutyRateList.get(k)
											+ "%������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ����ʧ�� - 10.0%��");
							prpLctextList.add(strSpace
									+ " = "
									+ UnitAmount
									+ " �� "
									+ ClaimRate[DutyRateList.size()]
									+ "% �� "
									+ Str.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
									+ " �� ("
									+ DutyRateList.get(k)
									+ "% - 10.0%)  = "
									+ Str.round(Double
											.parseDouble(dblSumRealpaySumMap
													.get(DutyRateList.get(k))
													.toString()), 2));
						} else if ((Double) (DutyRateList.get(k)) >= ratelimit3151AH) {
							prpLctextList
									.add("ȫ������� = ��λ���ս�� �� �⸶���� �� ��ʧ��� �� ��ʧ��");
							prpLctextList
									.add(strSpace1
											+ " = "
											+ UnitAmount
											+ " �� "
											+ ClaimRate[DutyRateList.size()]
											+ "% �� "
											+ Str
													.round(
															Double
																	.parseDouble(dblSettleAreaSumSumMap
																			.get(
																					DutyRateList
																							.get(k))
																			.toString()),
															2)
											+ " �� "
											+ DutyRateList.get(k)
											+ "% = "
											+ Str
													.round(
															Double
																	.parseDouble(dblSumRealpaySumMap
																			.get(
																					100.00)
																			.toString()),
															2));
						}
					}
				}
			}
		}

		// yx
		// yx
		else if ("3101,3107,3108,3114,3122,3126,3155,3156".indexOf(riskCode) > -1) {
			String policyno = httpServletRequest.getParameter("PolicyNo");
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			String versionNo = "";
			Double ratelimit = 80.00; // ȫ�����һ�㶼��80%
			blprpcmain.getData(policyno);
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			// 2016.3.15 ����ˮ��3101���������ȫ�����������70%
			if (versionNo.startsWith("C") && "3101".equals(riskCode) || versionNo.startsWith("C") && "3107".equals(riskCode))
				ratelimit = 70.00;
			if ((versionNo.startsWith("D") && "3101".equals(riskCode))
					|| (versionNo.startsWith("C") && "3108".equals(riskCode))) {
				// �ӱ���ȡȫ����ʧ��
				BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
				blPrpCitemKind.getData(httpServletRequest
						.getParameter("PolicyNo"));
				if (blPrpCitemKind.getSize() > 0
						&& !blPrpCitemKind.getArr(0).getTotalLossRatio()
								.equals("")
						&& blPrpCitemKind.getArr(0).getTotalLossRatio() != null) {
					PrpCitemKindSchema prpCitemKindSchema = blPrpCitemKind
							.getArr(0);
					ratelimit = Double.parseDouble(prpCitemKindSchema
							.getTotalLossRatio());
				}
			}
			if (("3101".equals(riskCode) && !checkRiskVersion(
					"CLAIM_VERSIONDATEHN3101", "3101", policyno))
					|| ("3107".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEHN3107", "3107", policyno))
					|| ("3108".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEHN3108", "3108", policyno))
					|| ("3114".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEHN3114", "3114", policyno))
					|| ("3122".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEHN3122", "3122", policyno))
					|| ("3151".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEAH3151", "3151", policyno))
					|| ("3197".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEAH3197", "3197", policyno))
					|| ("3152".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEAH3152", "3152", policyno))
					|| ("3155".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEAH3155", "3155", policyno))
					|| ("3156".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEAH3156", "3156", policyno))
					|| ("3126".equals(riskCode) && !checkRiskVersion(
							"CLAIM_VERSIONDATEHN3126", "3126", policyno))) {

				for (int k = 0; k < DutyRateList.size(); k++) {

					if ((Double) DutyRateList.get(k) < ratelimit) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ��");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) >= ratelimit) {
						
						if(versionNo.startsWith("C") && "3107".equals(riskCode)){
							prpLctextList.add("ȫ�������=��λ���� �� �⸶��� �� �⸶����");
							prpLctextList.add(strSpace
									+ " = "
									+ UnitAmount
									+ " �� "
									+ Str.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
									+ " �� "
									+ ClaimRate[DutyRateList.size()]
									+ "% = "
									+ Str.round(
											Double.parseDouble(dblSumRealpaySumMap
													.get(DutyRateList.get(k))
													.toString()), 2));
						}else{
						
						prpLctextList.add("ȫ�������=��λ���� �� �⸶��� �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(100.00).toString()), 2)
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				   }		
				}
			} else {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < ratelimit) {
						prpLctextList.add("��ʧ��" + DutyRateList.get(k)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ����ʧ�� - �����ʣ�");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% �� ("
								+ DutyRateList.get(k)
								+ "%-"
								+ DeductibleRate
								+ "%) = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) >= ratelimit) {
						prpLctextList.add("ȫ�������=��λ���� �� �⸶��� �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(100.00).toString()), 2)
								+ " �� "
								+ ClaimRate[DutyRateList.size()]
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
		}

		else {
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < 80.00) {
					prpLctextList.add("��ʧ��" + DutyRateList.get(k)
							+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ����ʧ�� - �����ʣ�");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " �� "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " �� "
							+ ClaimRate[DutyRateList.size()]
							+ "% �� ("
							+ DutyRateList.get(k)
							+ "%-"
							+ DeductibleRate
							+ "%) = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) == 100.00) {
					prpLctextList.add("ȫ�������=��λ���� �� �⸶��� �� �⸶����");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											100.00).toString()), 2)
							+ " �� "
							+ ClaimRate[DutyRateList.size()]
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		}
		prpLctextList.add("�⸶���С�ƣ�"
				+ Str.round(Double.parseDouble(dblSettleAreaMap.get(
						DeductibleRate).toString()), 2));
		prpLctextList.add("�����С�ƣ�"
				+ Str.round(Double.parseDouble(dblSumRealpayMap.get(
						DeductibleRate).toString()), 2));
		PrpLctextDto prpLctextDto = null;
		for (int i = 1; i <= prpLctextList.size(); i++) {
			prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo("");
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(i);
			prpLctextDto.setContext((String) prpLctextList.get(i - 1));
			prpLctextlist.add(prpLctextDto);
		}
		prpLctextDto.setPrpLctextList(prpLctextlist);
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);

	}

	/**
	 * STUB-ONLY ���ձ������ֲ�գ���������������ũ�գ��������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void generateAgriPlanting31Ctext(
			HttpServletRequest httpServletRequest) throws UserException,
			Exception {
		try {
			createAgriPlanting31Report(httpServletRequest);
		} catch (UserException usere) {
			throw usere;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * STUB-ONLY ���ձ������ֲ�գ���������������ũ�գ��������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void createAgriPlanting31Report(HttpServletRequest httpServletRequest)
			throws UserException, Exception {
		double dblSumRealpay = 0;
		double dblSettleArea = 0;
		double dblSumRealpaySum = 0;
		double dblSettleAreaSum = 0;
		Map dblSumRealpaySumMap = new HashMap();
		Map dblSettleAreaSumSumMap = new HashMap();
		Map dblSumRealpayMap = new HashMap();
		Map dblSettleAreaMap = new HashMap();
		Map itemNameMap = new HashMap();
		Map kindNameMap = new HashMap();
		Map unitAmountMapTemp = new HashMap();
		Map claimRateMap = new HashMap();
		Map lossRateMap = new HashMap();
		Map deductibleRateMap = new HashMap();
		List dutyRateList = new ArrayList();
		List prpLctextList = new ArrayList();
		List kindCodeList = new ArrayList();
		List itemCodeList = new ArrayList();
		String riskcode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String indemnityDutyRate[] = httpServletRequest
				.getParameterValues("indemnityDutyRate");
		String settleArea[] = httpServletRequest
				.getParameterValues("prpLlossDtoSettleArea");
		String claimRate[] = httpServletRequest
				.getParameterValues("prpLlossDtoClaimRate");
		String sumRealPay[] = httpServletRequest
				.getParameterValues("prpLlossDtoSumRealPay");
		String kindCode[] = httpServletRequest
				.getParameterValues("prpLlossDtoKindCode");
		String kindName[] = httpServletRequest
				.getParameterValues("prpLlossDtoKindName");
		String itemCode[] = httpServletRequest
				.getParameterValues("prpLlossDtoItemCode");
		String itemName[] = httpServletRequest
				.getParameterValues("prpLlossDtoLossName");
		String deductibleRates[] = httpServletRequest
				.getParameterValues("prpLlossDtoDeductibleRate");
		Map totalLossRatePointMap = (Map) httpServletRequest
				.getAttribute("totalLossRatePointMap");
		Map unitAmountMap = (Map) httpServletRequest
				.getAttribute("unitAmountMap");
		String deductibleRate = "100";
		for (int i = 0; i < indemnityDutyRate.length; i++) {
			if ((!"".equals(settleArea[i]) && null != settleArea[i])
					&& (!"".equals(sumRealPay[i]) && null != sumRealPay[i])) {
				if (dblSettleAreaMap.containsKey(deductibleRate)) {
					dblSumRealpay = (Double) dblSumRealpayMap
							.get(deductibleRate)
							+ Double.parseDouble(sumRealPay[i]);
					dblSettleArea = (Double) dblSettleAreaMap
							.get(deductibleRate)
							+ Double.parseDouble(settleArea[i]);
					dblSettleAreaMap.put(deductibleRate, dblSettleArea);
					dblSumRealpayMap.put(deductibleRate, dblSumRealpay);
				} else {
					dblSettleAreaMap.put(deductibleRate, Double
							.parseDouble(settleArea[i]));
					dblSumRealpayMap.put(deductibleRate, Double
							.parseDouble(sumRealPay[i]));
				}
			}
		}
		prpLctextList.add("�����������:");
		String strSpace = "                        ";
		String strSpace1 = "               ";
		String strSpace2 = "  ";
		List keyList = new ArrayList();
		for (int j = 1; j < indemnityDutyRate.length; j++) {
			if (!"".equals(indemnityDutyRate[j])
					&& null != indemnityDutyRate[j]
					&& null != totalLossRatePointMap) {
				String kindCodeTemp = kindCode[j];
				String itemCodeTemp = itemCode[j];
				String claimRateTemp = claimRate[j];
				String key = "" + kindCodeTemp + "_" + itemCodeTemp;
				String keyTemp = key + "_" + claimRateTemp;
				double totalLossRatePoint = Double.parseDouble(String
						.valueOf(totalLossRatePointMap.get(key)));
				if (riskcode.equals("3134"))
					totalLossRatePoint = 90.0; // 3134ȫ����ʧ����90%
				if (riskcode.equals("3157"))
					totalLossRatePoint = 80.0; // 3134ȫ����ʧ����90%
				if (riskcode.equals("3181"))
					totalLossRatePoint = 80.0;
				if (riskcode.equals("3170"))
					totalLossRatePoint = 90.0;
				if (riskcode.equals("31A6"))
					totalLossRatePoint = 80.0;
				if (riskcode.equals("3184"))
					totalLossRatePoint = 90.0;
				if (riskcode.equals("3183"))
					totalLossRatePoint = 80.0;
				if (riskcode.equals("3180"))
					totalLossRatePoint = 80.0;
				if (Double.parseDouble(indemnityDutyRate[j]) >= totalLossRatePoint) {
					keyTemp += "_100";
					if ((!"".equals(settleArea[j]) && null != settleArea[j])
							&& (!"".equals(sumRealPay[j]) && null != sumRealPay[j])) {
						if (dblSettleAreaSumSumMap.containsKey(keyTemp)) {
							dblSumRealpaySum = Double
									.parseDouble(dblSumRealpaySumMap.get(
											keyTemp).toString())
									+ Double.parseDouble(sumRealPay[j]);
							dblSettleAreaSum = Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString())
									+ Double.parseDouble(settleArea[j]);
							dblSettleAreaSumSumMap.put(keyTemp,
									dblSettleAreaSum);
							dblSumRealpaySumMap.put(keyTemp, dblSumRealpaySum);
						} else {
							dblSettleAreaSumSumMap.put(keyTemp, Double
									.parseDouble(settleArea[j]));
							dblSumRealpaySumMap.put(keyTemp, Double
									.parseDouble(sumRealPay[j]));
							itemNameMap.put(keyTemp, itemName[j]);
							kindNameMap.put(keyTemp, kindName[j]);
							unitAmountMapTemp.put(keyTemp, unitAmountMap
									.get(key));
							claimRateMap.put(keyTemp, claimRate[j]);
							lossRateMap.put(keyTemp, indemnityDutyRate[j]);
							deductibleRateMap.put(keyTemp, deductibleRates[j]);
						}
					}
					if (dblSettleAreaSumSumMap.containsKey(keyTemp)) {
						if (keyList.contains(keyTemp)) {

						} else {
							keyList.add(keyTemp);
							kindCodeList.add(kindCodeTemp);
							itemCodeList.add(itemCodeTemp);
						}
					}
				} else if (Double.parseDouble(indemnityDutyRate[j]) < totalLossRatePoint) {
					keyTemp += "_" + indemnityDutyRate[j];
					dblSettleAreaSumSumMap.put(keyTemp, Double
							.parseDouble(settleArea[j]));
					dblSumRealpaySumMap.put(keyTemp, Double
							.parseDouble(sumRealPay[j]));
					keyList.add(keyTemp);
					itemNameMap.put(keyTemp, itemName[j]);
					kindNameMap.put(keyTemp, kindName[j]);
					unitAmountMapTemp.put(keyTemp, unitAmountMap.get(key));
					claimRateMap.put(keyTemp, claimRate[j]);
					lossRateMap.put(keyTemp, indemnityDutyRate[j]);
					deductibleRateMap.put(keyTemp, deductibleRates[j]);
					kindCodeList.add(kindCodeTemp);
					itemCodeList.add(itemCodeTemp);
				}
			}
		}
		String kindCodePre = "";
		String itemCodePre = "";
		for (int k = 0; k < keyList.size(); k++) {
			String kindCodeTemp = String.valueOf(kindCodeList.get(k));
			String itemCodeTemp = String.valueOf(itemCodeList.get(k));
			String keyTemp = String.valueOf(keyList.get(k));
			if (!kindCodePre.equals(kindCodeTemp)
					|| !itemCodePre.equals(itemCodeTemp)) {
				prpLctextList.add("�ձ�����:"
						+ String.valueOf(kindNameMap.get(keyTemp)) + " ��ʧ���:"
						+ String.valueOf(itemNameMap.get(keyTemp)));
				kindCodePre = kindCodeTemp;
				itemCodePre = itemCodeTemp;
			}
			if (keyTemp.endsWith("_100")) {
				if (riskcode.equals("3173") || riskcode.equals("3157")) {
					if (!itemCodeTemp.equals("4312") && !itemCodeTemp.equals("4311")){
					prpLctextList.add(strSpace2
							+ "ȫ������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶����");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " �� "
							+ "100% �� "
							+ claimRateMap.get(keyTemp)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4311")) { // ������
						prpLctextList.add(strSpace2
								+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶����  �� ��1 - �����ʣ�");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " �� "
								+ claimRateMap.get(keyTemp)
								+ "% �� ( 1 -"
								+ deductibleRateMap.get(keyTemp)
								+ "%)  = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4312")) {
						prpLctextList.add(strSpace2
								+ "ȫ������� = ��λ���ս�� �� ��ʧ���  �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " �� "
								+ claimRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					}
				} else if (riskcode.equals("3232")) {
					prpLctextList.add(strSpace2
							+ "ȫ������� = ��λ���ս�� �� ��ʧ��� �� �⸶����");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " �� "
							+ claimRateMap.get(keyTemp)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				} else if (riskcode.equals("3134") || riskcode.equals("3141")) {
					if(riskcode.equals("3141") && (itemCodeTemp.indexOf("032")>-1 || itemCodeTemp.equals("6330"))) {
						String strDamageDate = httpServletRequest.getParameter("damageDate");
				        	//String strItemCode = prpCitemKindSchema.getItemCode();
				        	//if(null!=strItemCode && (strItemCode.indexOf("032")>-1||strItemCode.equals("6330"))){//032 �߲�����
				        String policyNo = httpServletRequest.getParameter("PolicyNo");
				        		BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new BLPrpCitemKindAgriFacade();
				        		String sqlCondition = " PolicyNo = '"+policyNo+"' And EndDate >= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And StratDate <= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And Times >0 ";
									Collection collection = blPrpCitemKindAgriFacade.findByConditions(sqlCondition);//��ȡ�����Ϣ
									String strdistributingRate="";
									if(null != collection && collection.size() == 1){
										PrpCitemKindAgriDto prpCitemKindAgriDto = (PrpCitemKindAgriDto)collection.toArray()[0];
										double distributingRate = prpCitemKindAgriDto.getDistributingRate()/100;
										strdistributingRate=String.valueOf(distributingRate);	
									}
						
						prpLctextList
						.add(strSpace2
								+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶���� �� ��1 - �����ʣ�");
				prpLctextList.add(strSpace
						+ " = "
						+ unitAmountMapTemp.get(keyTemp)
						+ " �� "
						+ Str.round(Double
								.parseDouble(dblSettleAreaSumSumMap.get(
										keyTemp).toString()), 2)
						+ " �� "
						+ claimRateMap.get(keyTemp)
						+ "% "
 						//+ Str.round(Double.parseDouble(strdistributingRate), 2)
						+ " �� ( 1 -"
						+ deductibleRateMap.get(keyTemp)
						+ "%)  = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					} else if (riskcode.equals("3141")) {
						prpLctextList
						.add(strSpace2
								+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ��");
						prpLctextList.add(strSpace
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " �� "
								+ claimRateMap.get(keyTemp)
								+ "% �� "
								+ "100% "
								+ " = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					} else {
						prpLctextList
						.add(strSpace2
								+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶���� �� ��Ӧ��α��ս��ֲ����� ��  (1 - �����ʣ�");
				prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					}
			} else if (riskcode.equals("3140") ) {
				if(itemCodeTemp.indexOf("032")>-1) {
					prpLctextList
					.add(strSpace2
							+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶���� �� ��Ӧ��α��ս��ֲ�����");
			prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));
				} else {
					prpLctextList
					.add(strSpace2
							+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶����  ��  (1 - ���������ʣ�");
			prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));
				}
				
			}
				else if (riskcode.equals("3163")) {
					if (itemCodeList.get(k).equals("31b1")) {
					prpLctextList
							.add(strSpace2
									+ "ȫ������� = ��λ���� �� �⸶���� �� �⸶���� �� ��Ӧ��α��ս��ֲ����� ");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				}
					else{
						prpLctextList
						.add(strSpace2
								+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶���� ");
						prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					}
					
				}
				else if (riskcode.equals("3182")) {

					prpLctextList
							.add(strSpace2
									+ "ȫ�𣺲�ͬ�����ڵ�����⳥��׼�������������1-���������ʣ� ");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));


					
				}
				else if (riskcode.equals("3184") || riskcode.equals("3183") || riskcode.equals("3180")|| riskcode.equals("3181")|| riskcode.equals("3170")|| riskcode.equals("31A6")) {
					prpLctextList.add(strSpace2
							+ "ȫ������� = ��λ���� �� �⸶��� �� �⸶����");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " �� "
							+ claimRateMap.get(keyTemp)
							+ "%  = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				} else {
					prpLctextList.add(strSpace2
							+ "ȫ�������=��λ���� �� �⸶��� �� �⸶���� �� ��1 - �����ʣ�");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " �� "
							+ claimRateMap.get(keyTemp)
							+ "% �� ( 1 -"
							+ deductibleRateMap.get(keyTemp)
							+ "%)  = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				}
			} else {
				if (riskcode.equals("3173") || riskcode.equals("3157")) {
					// ������ʧ�����ѹ�ʽ����Ĥ��ܲ�һ��
					if (itemCodeList.get(k).equals("p001")) {
						prpLctextList
								.add(strSpace2
										+ "��ʧ��"
										+ lossRateMap.get(keyTemp)
										+ "%������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶���� �� �� 1 - �����ʣ�");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(keyTemp).toString()), 2)
								+ " �� "
								+ lossRateMap.get(keyTemp)
								+ "% �� "
								+ claimRateMap.get(keyTemp)
								+ "% �� ( 1 -"
								+ deductibleRateMap.get(keyTemp)
								+ "%) = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												keyTemp).toString()), 2));
					}else if(itemCodeList.get(k).equals("2610")){
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶���� �� �� 1 - �����ʣ�");
				prpLctextList.add(strSpace1
						+ " = "
						+ unitAmountMapTemp.get(keyTemp)
						+ " �� "
						+ Str.round(Double
								.parseDouble(dblSettleAreaSumSumMap
										.get(keyTemp).toString()), 2)
						+ " �� "
						+ lossRateMap.get(keyTemp)
						+ "% �� "
						+ claimRateMap.get(keyTemp)
						+ "% �� ( 1 -"
						+ deductibleRateMap.get(keyTemp)
						+ "%) = "
						+ Str.round(Double
								.parseDouble(dblSumRealpaySumMap.get(
										keyTemp).toString()), 2));
					} else if (!itemCodeTemp.equals("4312") && !itemCodeTemp.equals("4311")){
						prpLctextList.add(strSpace2 + "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(keyTemp).toString()), 2)
								+ " �� "
								+ lossRateMap.get(keyTemp)
								+ "% �� "
								+ claimRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4311")) { // ������
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶���� �� �� 1 - �����ʣ�");
				prpLctextList.add(strSpace1
						+ " = "
						+ unitAmountMapTemp.get(keyTemp)
						+ " �� "
						+ Str.round(Double
								.parseDouble(dblSettleAreaSumSumMap
										.get(keyTemp).toString()), 2)
						+ " �� "
						+ lossRateMap.get(keyTemp)
						+ "% �� "
						+ claimRateMap.get(keyTemp)
						+ "% �� ( 1 -"
						+ deductibleRateMap.get(keyTemp)
						+ "%) = "
						+ Str.round(Double
								.parseDouble(dblSumRealpaySumMap.get(
										keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4312")) { // ������
						prpLctextList.add(strSpace2 + "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶����");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(keyTemp).toString()), 2)
								+ " �� "
								+ lossRateMap.get(keyTemp)
								+ "% �� "
								+ claimRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												keyTemp).toString()), 2));
					}
				} else if (riskcode.equals("3134")) {
					prpLctextList
							.add(strSpace2
									+ "��ʧ��"
									+ lossRateMap.get(keyTemp)
									+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��Ӧ��α��ս��ֲ����� �� ����ʧ�� - �����ʣ�");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));

				}else if (riskcode.equals("3141")) {
					if(itemCodeTemp.indexOf("032")>-1 || itemCodeTemp.equals("6330")) {
						String strDamageDate = httpServletRequest.getParameter("damageDate");
			        	//String strItemCode = prpCitemKindSchema.getItemCode();
			        	//if(null!=strItemCode && (strItemCode.indexOf("032")>-1||strItemCode.equals("6330"))){//032 �߲�����
			        String policyNo = httpServletRequest.getParameter("PolicyNo");
			        		BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new BLPrpCitemKindAgriFacade();
			        		String sqlCondition = " PolicyNo = '"+policyNo+"' And EndDate >= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And StratDate <= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And Times >0 ";
								Collection collection = blPrpCitemKindAgriFacade.findByConditions(sqlCondition);//��ȡ�����Ϣ
								String strdistributingRate="";
								if(null != collection && collection.size() == 1){
									PrpCitemKindAgriDto prpCitemKindAgriDto = (PrpCitemKindAgriDto)collection.toArray()[0];
									double distributingRate = prpCitemKindAgriDto.getDistributingRate()/100;
									strdistributingRate=String.valueOf(distributingRate);	
								}
						
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ�� �� (1 - �����ʣ�");
						prpLctextList.add(strSpace
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " �� "
								+ claimRateMap.get(keyTemp)
								+ "% �� "
		 						//+ Str.round(Double.parseDouble(strdistributingRate), 2)
		 						//+ " �� "
		 						+ lossRateMap.get(keyTemp)
								+ "% �� ( 1 -"
								+ deductibleRateMap.get(keyTemp)
								+ "%)  = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					} else {
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ��");
						prpLctextList.add(strSpace
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " �� "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " �� "
								+ claimRateMap.get(keyTemp)
								+ "% �� "
		 						+ lossRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					}
					
				}else if (riskcode.equals("3140")) {
					if(itemCodeTemp.indexOf("032")>-1) {
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��Ӧ��α��ս��ֲ����� �� (��ʧ��- ���������ʣ�");
				prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					} else {
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� (��ʧ��- ���������ʣ�");
				prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					}
						
		        }else if (riskcode.equals("3163")) {
					if (itemCodeList.get(k).equals("31b1")) {
					prpLctextList
					.add(strSpace2
							+ "��ʧ��"
							+ lossRateMap.get(keyTemp)
							+ "%������� = ��λ���� �� �⸶���� �� �⸶���� �� ��Ӧ��α��ս��ֲ����� �� ��ʧ�� ");
					prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));

					}
					else{
						prpLctextList
						.add(strSpace2
								+ "��ʧ��"
								+ lossRateMap.get(keyTemp)
								+ "%������� = ��λ���� �� �⸶��� �� �⸶����  �� ��ʧ�� ");
						prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));

						}
						
					
						
				}
		        else if (riskcode.equals("3182")) {

					prpLctextList
					.add(strSpace2
							+ "��ʧ��"
							+ lossRateMap.get(keyTemp)
							+ "%������� = ��ͬ�����ڵ�����⳥��׼����ʧ�ʡ������������1-���������ʣ� ");
					prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));

					

					
						
				}
				else if (riskcode.equals("3184") || riskcode.equals("3183")|| riskcode.equals("3180")|| riskcode.equals("3181")|| riskcode.equals("3170")|| riskcode.equals("31A6")) {
					prpLctextList.add(strSpace2 + "��ʧ��"
							+ lossRateMap.get(keyTemp)
							+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ��");
					prpLctextList.add(strSpace
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " �� "
							+ claimRateMap.get(keyTemp)
							+ "% �� "
							+ lossRateMap.get(keyTemp)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				} else {
					prpLctextList.add(strSpace2 + "��ʧ��"
							+ lossRateMap.get(keyTemp)
							+ "%������� = ��λ���� �� �⸶��� �� �⸶���� �� ��ʧ�� �� ��1 - �����ʣ�");
					prpLctextList.add(strSpace
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " �� "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " �� "
							+ claimRateMap.get(keyTemp)
							+ "% �� "
							+ lossRateMap.get(keyTemp)
							+ "% �� ( 1 -"
							+ deductibleRateMap.get(keyTemp)
							+ "%) = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				}
			}
		}
		if (riskcode.equals("3163")){
			Double dblSettle3163001Area = 0.0;
			Double dblSettle3163002Area = 0.0;
			for (int k = 0; k < keyList.size(); k++) {
				String keyTemp = String.valueOf(keyList.get(k));
				if(keyTemp.startsWith("001"))
				{
					dblSettle3163001Area=dblSettle3163001Area +Str.round(Double.parseDouble(dblSettleAreaSumSumMap.get(
							keyTemp).toString()), 2);
				}
				else
				{
					dblSettle3163002Area=dblSettle3163002Area +Str.round(Double.parseDouble(dblSettleAreaSumSumMap.get(
							keyTemp).toString()), 2);
				}
				if(dblSettle3163001Area==0.0)
				{
					dblSettle3163001Area = dblSettle3163002Area;
				}
				
			}
			prpLctextList.add("�⸶����С�ƣ�"+ dblSettle3163001Area);
		}else
		{
		prpLctextList.add("�⸶���С�ƣ�"
				+ Str.round(Double.parseDouble(dblSettleAreaMap.get(
						deductibleRate).toString()), 2));
		}
		prpLctextList.add("�����С�ƣ�"
				+ Str.round(Double.parseDouble(dblSumRealpayMap.get(
						deductibleRate).toString()), 2));
		PrpLctextDto prpLctextDto = null;
		for (int i = 1; i <= prpLctextList.size(); i++) {
			prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo("");
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(i);
			prpLctextDto.setContext((String) prpLctextList.get(i - 1));
			prpLctextlist.add(prpLctextDto);
		}
		prpLctextDto.setPrpLctextList(prpLctextlist);
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);

	}

	/**
	 * STUB-ONLY �������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public void createReport(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws UserException, Exception {
		// System.out.println("ʵ��ʵ��ʵ��ʵ��ʵ��ʵ��ʵ��");

		PrpLlossDto prpLlossDto = null;
		PrpLpersonLossDto prpLpersonLossDto = null;
		PrpLchargeDto prpLchargeDto = null;
		PrpLcfeeDto prpLcfeeDto = null;

		// String[] arrPrpLctext = new String[70];
		// Modify by sunhao begin 2004-11-30 reason:ԭ�������鱣�����㱨�����ĵķ�ʽ��Ϊ����
		List prpLctextList = new ArrayList();
		// Modify by sunhao end 2004-11-30
		String compensateCurrency = httpServletRequest
				.getParameter("prpLcompensateCurrency");
		int curr = 0;
		int intLossCount = 0;
		int intChargeCount = 0;
		int intPersonLossCount = 0;
		int intLossCurr = 0;
		int intChargeCurr = 0;
		int intPersonLossCurr = 0;
		int i, j = 0;
		double dblSumRealpay = 0;
		double dblSumLoss = 0;
		double dblSumCharge = 0;
		double dblSumPerson = 0;
		double dblSumJE = 0;
		String strSpace = "    ";
		String strClaimNo = "";
		String strChineseMoney = "";
		String strCompensateNo = "";
		UICodeAction uiCodeAction = new UICodeAction();
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();

		// DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency();
		// Money money = new Money();
		Vector tmpPrpLlossDtos = new Vector();
		Vector tmpPrpLpersonLossDtos = new Vector();
		Vector tmpPrpLchargeDtos = new Vector();
		// modify by qinyongli 2005-9-5 start
		// reason:�޸�����յ�Ĭ���г���
		// modify by ��Ŀ�� ������ ����27�޸�Ϊ07
		String strRiskType = uiCodeAction
				.translateRiskCodetoRiskType(prpLcompensateDto.getRiskCode());
		if ("E".equals(strRiskType)) {
			RULE_LENGTH = 80;
		}
		// modify by qinyongli end
		// Check Exist Of Compensate
		if (prpLcompensateDto == null) {
			throw new UserException(-98, -1, "BLCompensate.generateCtext()",
					"û�м�������Ϣ����ȷ�ϣ�");
		} else {
			strCompensateNo = prpLcompensateDto.getCompensateNo();
		}

		// 1.�Ա�ġ����á���Ա�⸶��Ϣ���з������
		intLossCount = compensateDto.getPrpLlossDtoList().size();
		for (i = 0; i < intLossCount; i++) {
			prpLlossDto = new PrpLlossDto();
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(
					i);
			for (j = 0; j < intLossCurr; j++) {
				PrpLlossDto prpLlossDtoCurr = new PrpLlossDto();
				prpLlossDtoCurr = (PrpLlossDto) tmpPrpLlossDtos.get(j);
				if ((prpLlossDto.getLossName().equals(
						prpLlossDtoCurr.getLossName())
						&& prpLlossDto.getFamilyName().equals(
								prpLlossDtoCurr.getFamilyName()) && prpLlossDto
						.getCurrency4().equals(prpLlossDtoCurr.getCurrency4())
				// &&
				// prpLlossDto.getRiskCode().equals(uiCodeAction.translateProductCode("RISKCODE_JKD"))
				)
						|| (prpLlossDto.getLossName().equals(
								prpLlossDtoCurr.getLossName())
								&& prpLlossDto.getCurrency4().equals(
										prpLlossDtoCurr.getCurrency4())
								&& (prpLlossDto.getDeductible() == prpLlossDtoCurr
										.getDeductible()) && (prpLlossDto
								.getSumRest() == prpLlossDtoCurr.getSumRest())
						// &&
						// !(prpLlossDto.getRiskCode().equals(uiCodeAction.translateProductCode("RISKCODE_JKD")))
						)) {
					prpLlossDtoCurr.setSumRealPay(prpLlossDtoCurr
							.getSumRealPay()
							+ prpLlossDto.getSumRealPay());
					prpLlossDtoCurr.setSumLoss(prpLlossDtoCurr.getSumLoss()
							+ prpLlossDto.getSumLoss());
					tmpPrpLlossDtos.set(j, prpLlossDtoCurr);
					break;
				}
			}
			if (intLossCurr == 0) {
				intLossCurr = intLossCurr + 1;
				tmpPrpLlossDtos.add(prpLlossDto);
			}
			if (j >= intLossCurr) {
				intLossCurr = intLossCurr + 1;
				tmpPrpLlossDtos.add(prpLlossDto);
			}
		}

		intChargeCount = compensateDto.getPrpLchargeDtoList().size();
		for (i = 0; i < intChargeCount; i++) {
			prpLchargeDto = new PrpLchargeDto();
			prpLchargeDto = (PrpLchargeDto) compensateDto
					.getPrpLchargeDtoList().get(i);
			for (j = 0; j < intChargeCurr; j++) {
				PrpLchargeDto prpLchargeDtoCurr = new PrpLchargeDto();
				prpLchargeDtoCurr = (PrpLchargeDto) tmpPrpLchargeDtos.get(j);
				if (prpLchargeDto.getChargeCode().equals(
						prpLchargeDtoCurr.getChargeCode())
						&& prpLchargeDto.getCurrency().equals(
								prpLchargeDtoCurr.getCurrency())) {
					prpLchargeDtoCurr.setChargeAmount(prpLchargeDtoCurr
							.getChargeAmount()
							+ prpLchargeDto.getChargeAmount());
					prpLchargeDtoCurr.setSumRealPay(prpLchargeDtoCurr
							.getSumRealPay()
							+ prpLchargeDto.getSumRealPay());
					tmpPrpLchargeDtos.set(j, prpLchargeDtoCurr);
					break;
				}
			}
			if (intChargeCurr == 0) {
				intChargeCurr = intChargeCurr + 1;
				tmpPrpLchargeDtos.add(prpLchargeDto);
			}
			if (j >= intChargeCurr) {
				intChargeCurr = intChargeCurr + 1;
				tmpPrpLchargeDtos.add(prpLchargeDto);
			}
		}

		intPersonLossCount = compensateDto.getPrpLpersonLossDtoList().size();
		ArrayList prpLpersonLossDtoListCopy = new ArrayList();
		for (i = 0; i < intPersonLossCount; i++) {
			prpLpersonLossDto = new PrpLpersonLossDto();
			PrpLpersonLossDto prpLpersonLossDtoCopy = new PrpLpersonLossDto();
			prpLpersonLossDto = (PrpLpersonLossDto) compensateDto
					.getPrpLpersonLossDtoList().get(i);

			// ���ƶ������� 2005-9-21
			prpLpersonLossDtoCopy.setAmount(prpLpersonLossDto.getAmount());
			prpLpersonLossDtoCopy.setUnitAmount(prpLpersonLossDto
					.getUnitAmount());
			prpLpersonLossDtoCopy.setPersonName(prpLpersonLossDto
					.getPersonName());
			prpLpersonLossDtoCopy.setPersonNo(prpLpersonLossDto.getPersonNo());
			prpLpersonLossDtoCopy.setFamilyNo(prpLpersonLossDto.getFamilyNo());
			prpLpersonLossDtoCopy.setKindCode(prpLpersonLossDto.getKindCode());
			prpLpersonLossDtoCopy.setSumRealPay(prpLpersonLossDto
					.getSumRealPay());
			prpLpersonLossDtoCopy
					.setCurrency4(prpLpersonLossDto.getCurrency4());
			prpLpersonLossDtoCopy.setLiabDetailName(prpLpersonLossDto
					.getLiabDetailName());
			prpLpersonLossDtoCopy.setRemark(prpLpersonLossDto.getRemark());
			prpLpersonLossDtoCopy.setRiskCode(prpLpersonLossDto.getRiskCode());
			prpLpersonLossDtoCopy.setdblMaxPaid(prpLpersonLossDto
					.getdblMaxPaid());
			prpLpersonLossDtoListCopy.add(prpLpersonLossDtoCopy);

			for (j = 0; j < intPersonLossCurr; j++) {
				PrpLpersonLossDto prpLpersonLossDtoCurr = new PrpLpersonLossDto();
				prpLpersonLossDtoCurr = (PrpLpersonLossDto) tmpPrpLpersonLossDtos
						.get(j);
				if (prpLpersonLossDto.getPersonName().equals(
						prpLpersonLossDtoCurr.getPersonName())
						&& prpLpersonLossDto.getCurrency4().equals(
								prpLpersonLossDtoCurr.getCurrency4())
						&& (prpLpersonLossDto.getPersonNo() == prpLpersonLossDtoCurr
								.getPersonNo())) {
					prpLpersonLossDtoCurr.setSumRealPay(prpLpersonLossDtoCurr
							.getSumRealPay()
							+ prpLpersonLossDto.getSumRealPay());
					tmpPrpLpersonLossDtos.set(j, prpLpersonLossDtoCurr);
					break;
				}
			}
			if (intPersonLossCurr == 0) {
				intPersonLossCurr = intPersonLossCurr + 1;
				tmpPrpLpersonLossDtos.add(prpLpersonLossDto);
			}
			if (j >= intPersonLossCurr) {
				intPersonLossCurr = intPersonLossCurr + 1;
				tmpPrpLpersonLossDtos.add(prpLpersonLossDto);
			}
		}

		// 2.����������
		// 2.1 �����ʧ���㱨��

		if (intLossCurr > 0) {
			prpLctextList.add("      ");
			curr = curr + 1;
			prpLctextList.add("***<�⸶��ģ�>***");
			for (i = 0; i < intLossCurr; i++) {
				PrpLlossDto prpLlossDtoCurr = null;
				prpLlossDtoCurr = (PrpLlossDto) tmpPrpLlossDtos.get(i);
				// int intResult =
				// dbPrpDkind.getInfo(prpLlossDtoCurr.getRiskCode(),prpLlossDtoCurr.getKindCode());
				// prpLrepairFeeDto.setKindName(uiCodeAction.translateKindCode(uiCodeAction.translateProductCode(httpServletRequest,"RISKCODE_DAA"),prpLrepairFeeDto.getKindCode(),true));
				// uiCodeAction.translateKindCode(compensateDto.getPrpLcompensateDto().getRiskCode(),iKindCode,true)
				// uiCodeAction.translateCurrencyCode(prpLpersonDtoTemp.getCurrency(),true)
				curr = curr + 1;
				// prpLctextList.add(uiCodeAction.translateKindCode(prpLlossDtoCurr.getRiskCode(),
				// prpLlossDtoCurr.getKindCode(), true)
				// + ":"); 2005-9-21 modify
				curr = curr + 1;

				// if
				// (prpLlossDtoCurr.getRiskCode().equals(uiCodeAction.translateProductCode("RISKCODE_JKD")))
				// {
				// prpLctextList.add(strSpace + "��������: " +
				// prpLlossDtoCurr.getFamilyName()); 2005-9-21 modify
				curr = curr + 1;
				// }

				// prpLctextList.add(strSpace + "���������ƣ�" +
				// prpLlossDtoCurr.getLossName()); 2005-9-21 modify
				curr = curr + 1;

				// intResult =
				// dbPrpDcurrency.getInfo(prpLlossDtoCurr.getCurrency4());
				dblSumRealpay = prpLlossDtoCurr.getSumRealPay();
				/* edit by lijingke 20040518 begin */
				/* reason: ���������Ϊ��ֵ */
				if (dblSumRealpay < 0) {
					dblSumRealpay = -1 * dblSumRealpay;
					strChineseMoney = "��"
							+ MoneyUtils.toChinese(dblSumRealpay,
									prpLlossDtoCurr.getCurrency3());
				} else {
					strChineseMoney = MoneyUtils.toChinese(dblSumRealpay,
							prpLlossDtoCurr.getCurrency4());
				}
				/* edit by lijingke 20040518 end */
				// prpLctextList.add(strSpace + "�������⳥��");
				curr = curr + 1;

				prpLctextList.add(strSpace
						+ "�������⳥��"
						+ uiCodeAction.translateCurrencyCode(prpLlossDtoCurr
								.getCurrency4(), true) + strChineseMoney.trim()
						+ strSpace + prpLlossDtoCurr.getCurrency4()
						+ prpLlossDtoCurr.getSumRealPay());
				curr = curr + 1;

				// prpLctextList.add(strSpace + strSpace + strSpace + strSpace +
				// "���㹫ʽ:");
				prpLctextList.add(strSpace + strSpace + strSpace + strSpace);

				curr = curr + 1;

				double Amount = 0;
				double SumLoss = 0;
				double DeductibleRate = 0;
				double Deductible = 0;
				double Deductible1 = 0;

				DeductibleRate = prpLlossDtoCurr.getDeductibleRate();
				Deductible = prpLlossDtoCurr.getDeductible();
				if (prpLlossDtoCurr.getRiskCode().substring(1, 2).equals("YD")) {
					Deductible1 = prpLlossDtoCurr.getAmount() * DeductibleRate
							/ 100;
				} else {
					Deductible1 = prpLlossDtoCurr.getSumLoss() * DeductibleRate
							/ 100;
				}

				if (Deductible < Deductible1) {
					Deductible = Deductible1;
				}
				if (prpLlossDtoCurr.getRiskCode().equals(
						uiCodeAction.translateProductCode("RISKCODE_ZFG"))) {
					prpLctextList.add(strSpace + "�����ʧ �� �⸶���� �� ����� ��");
				} else {
					if (prpLlossDtoCurr.getDeductible() > 0) {
						prpLctextList.add(strSpace
								+ "(�����ʧ �� ��ֵ) �� �⸶���� �� ����� ��");
					} else {
						prpLctextList.add(strSpace
								+ "(�����ʧ �� ��ֵ) �� �⸶���� ��(1-������) ��");
					}
				}
				curr = curr + 1;

				if (prpLlossDtoCurr.getRiskCode().equals(
						uiCodeAction.translateProductCode("RISKCODE_ZFG"))) {
					prpLctextList.add(strSpace + prpLlossDtoCurr.getSumLoss()
							+ "��" + prpLlossDtoCurr.getClaimRate() + "��" + "��"
							+ String.valueOf(Deductible) + "��"
							+ prpLlossDtoCurr.getSumRealPay());
				} else {
					if (prpLlossDtoCurr.getDeductible() > 0) {
						prpLctextList.add(strSpace + "("
								+ prpLlossDtoCurr.getSumLoss() + "��"
								+ prpLlossDtoCurr.getSumRest() + ")" + "��"
								+ prpLlossDtoCurr.getClaimRate() + "��" + "��"
								+ String.valueOf(Deductible) + "��"
								+ prpLlossDtoCurr.getSumRealPay());
					} else {
						prpLctextList.add(strSpace
								+ "("
								+ prpLlossDtoCurr.getSumLoss()
								+ "��"
								+ prpLlossDtoCurr.getSumRest()
								+ ")"
								+ "��"
								+ prpLlossDtoCurr.getClaimRate()
								+ "��*(1"
								+ "-"
								+ String.valueOf(prpLlossDtoCurr
										.getDeductibleRate()) + ")��"
								+ prpLlossDtoCurr.getSumRealPay());
					}
				}

				dblSumLoss = dblSumLoss + dblSumRealpay;

				curr = curr + 1;
				prpLctextList.add("   ");

			}
		}

		// 2.3 ��Ա�⸶���㱨��
		if (intPersonLossCurr > 0) {
			curr = curr + 1;

			prpLctextList.add("***<�⸶��Ա��>***");
			for (i = 0; i < intPersonLossCurr; i++) {
				PrpLpersonLossDto prpLpersonLossDtoCurr = null;
				prpLpersonLossDtoCurr = (PrpLpersonLossDto) tmpPrpLpersonLossDtos
						.get(i);
				curr = curr + 1;
				prpLctextList.add(strSpace + "��Ա���ƣ�"
						+ prpLpersonLossDtoCurr.getPersonName());

				curr = curr + 1;
				strRiskType = uiCodeAction
						.translateRiskCodetoRiskType(prpLpersonLossDtoCurr
								.getRiskCode());

				if ("E".equals(strRiskType)) {

					prpLctextList.add(strSpace + strSpace
							+ "��Ա�⸶��� = (������ - �����) �� �⳥���� ");
					curr = curr + 1;
					prpLctextList.add(strSpace + strSpace + strSpace + strSpace
							+ strSpace + " = "
							+ prpLpersonLossDtoCurr.getCurrency4()
							+ prpLpersonLossDtoCurr.getSumRealPay());
					// + "("+prpLpersonLossDtoCurr.getCurrency4() + ")";
				} else {
					prpLctextList.add(strSpace + strSpace + "��Ա�⸶��"
							+ prpLpersonLossDtoCurr.getCurrency4() + "  "
							+ prpLpersonLossDtoCurr.getSumRealPay());
				}

				dblSumPerson = dblSumPerson
						+ prpLpersonLossDtoCurr.getSumRealPay();
			}
			curr = curr + 1;
			prpLctextList.add("   ");
		}

		// ������Ϣ
		if (intChargeCurr > 0) {
			prpLctextList.add("***<������Ϣ��>***");
			for (i = 0; i < tmpPrpLchargeDtos.size(); i++) {
				prpLchargeDto = (PrpLchargeDto) tmpPrpLchargeDtos.get(i);

				// �ı���ʾ�ĸ�ʽ 2005-9-22
				// prpLctextList.add(strSpace + "�������ƣ�" +
				// prpLchargeDto.getChargeName());
				// prpLctextList.add(strSpace + "���ñұ�" +
				// prpLchargeDto.getCurrency());
				// prpLctextList.add(strSpace + "���ý�" +
				// prpLchargeDto.getSumRealPay());
				// prpLctextList.add("-------------------------------------------");
				prpLctextList.add(strSpace + prpLchargeDto.getChargeName()
						+ "��" + prpLchargeDto.getCurrency()
						+ prpLchargeDto.getSumRealPay());
				dblSumCharge = dblSumCharge + prpLchargeDto.getSumRealPay();
			}
			curr = curr + 1;
			prpLctextList.add("   ");
		}

		// 3.�⸶��Ϣ����
		dblSumJE = dblSumLoss + dblSumCharge + dblSumPerson;

		curr = curr + 1;
		prpLctextList.add("***<���ϼƣ�>***");
		if (compensateDto.getPrpLcfeeDtoList() != null) {
			for (i = 0; i < compensateDto.getPrpLcfeeDtoList().size(); i++) {
				prpLcfeeDto = new PrpLcfeeDto();
				prpLcfeeDto = (PrpLcfeeDto) compensateDto.getPrpLcfeeDtoList()
						.get(i);
				/*
				 * int intResult =
				 * dbPrpDcurrency.getInfo(prpLcfeeDto.getCurrency());
				 * if(intResult==100) { throw new
				 * UserException(-98,-1128,"BLCompensate.generateCtext()","��ȡ
				 * dbPrpDcurrency ���¼ʧ��[100]!"); }
				 */

				/* edit by lijingke 20040518 begin */
				/* reason: ���������Ϊ�� */
				boolean bflag = false;
				if (prpLcfeeDto.getSumPaid() < 0) {
					bflag = true;
					prpLcfeeDto.setSumPaid(-1 * (prpLcfeeDto.getSumPaid()));
				}
				strChineseMoney = MoneyUtils.toChinese(
						prpLcfeeDto.getSumPaid(), prpLcfeeDto.getCurrency());

				curr = curr + 1;
				if (bflag) {
					prpLctextList.add(strSpace
							+ "���"
							+ uiCodeAction.translateCurrencyCode(prpLcfeeDto
									.getCurrency(), true)
							+ strChineseMoney.trim() + strSpace
							+ prpLcfeeDto.getCurrency().trim()
							+ prpLcfeeDto.getSumPaid());
				} else {
					prpLctextList.add(strSpace
							+ uiCodeAction.translateCurrencyCode(prpLcfeeDto
									.getCurrency(), true)
							+ strChineseMoney.trim() + strSpace
							+ prpLcfeeDto.getCurrency().trim()
							+ prpLcfeeDto.getSumPaid());
				}
				/* edit by lijignke 20040518 end */
			}
		}
		// ����Dto
		PrpLctextDto prpLctextDto = null;
		// modify by ��Ŀ�� ������ ����27�޸�Ϊ07
		// if
		// (compensateDto.getPrpLcompensateDto().getRiskCode().substring(0,2).equals("27"))
		// { //�����������ݿͻ�Ҫ����Ҫ���ݰ���������ʾ��Ӧ��ģ�塣 2005-08-02
		// modify by lixiang start at 2006-1-20
		// reason, classcode����substring����ȡ������6��Ҳ��Ҫ��7һ���ĸ�ʽ
		// if
		// (compensateDto.getPrpLcompensateDto().getClassCode().equals("07")||compensateDto.getPrpLcompensateDto().getClassCode().equals("06"))
		// { //�����������ݿͻ�Ҫ����Ҫ���ݰ���������ʾ��Ӧ��ģ�塣 2005-08-02
		if (compensateDto.getPrpLcompensateDto().getClassCode().equals("27")
				|| compensateDto.getPrpLcompensateDto().getClassCode().equals(
						"26")
				|| compensateDto.getPrpLcompensateDto().getClassCode().equals(
						"28")) { // �����������ݿͻ�Ҫ����Ҫ���ݰ���������ʾ��Ӧ��ģ�塣 2005-08-02

			// modify by lixiang end at 2006-1-20
			// �õ����Ӵ�,���潫���зֵ�����
			String TextTemp = null;
			String[] rulesAcci = null;

			String strClaimType = compensateDto.getPrpLcompensateDto()
					.getCaseType(); // ��������
			String insuredName = compensateDto.getPrpLcompensateDto()
					.getInsuredName(); // ��������
			PrpLpersonLossDto prpLpersonLossDtoNew = null;

			// ���ձ���������� 2005-9-21
			intPersonLossCurr = 0;
			tmpPrpLpersonLossDtos.clear();
			for (int intCount = 0; intCount < prpLpersonLossDtoListCopy.size(); intCount++) {
				prpLpersonLossDto = new PrpLpersonLossDto();
				prpLpersonLossDto = (PrpLpersonLossDto) prpLpersonLossDtoListCopy
						.get(intCount);
				for (j = 0; j < intPersonLossCurr; j++) {
					PrpLpersonLossDto prpLpersonLossDtoCurr = new PrpLpersonLossDto();
					prpLpersonLossDtoCurr = (PrpLpersonLossDto) tmpPrpLpersonLossDtos
							.get(j);
					if (prpLpersonLossDto.getPersonName().equals(
							prpLpersonLossDtoCurr.getPersonName())
							&& prpLpersonLossDto.getCurrency4().equals(
									prpLpersonLossDtoCurr.getCurrency4())
							&& (prpLpersonLossDto.getPersonNo() == prpLpersonLossDtoCurr
									.getPersonNo())
							&& prpLpersonLossDto.getKindCode().equals(
									prpLpersonLossDtoCurr.getKindCode())) {
						prpLpersonLossDtoCurr
								.setSumRealPay(prpLpersonLossDtoCurr
										.getSumRealPay()
										+ prpLpersonLossDto.getSumRealPay());
						tmpPrpLpersonLossDtos.set(j, prpLpersonLossDtoCurr);
						break;
					}
				}
				if (intPersonLossCurr == 0) {
					intPersonLossCurr = intPersonLossCurr + 1;
					tmpPrpLpersonLossDtos.add(prpLpersonLossDto);
				}
				if (j >= intPersonLossCurr) {
					intPersonLossCurr = intPersonLossCurr + 1;
					tmpPrpLpersonLossDtos.add(prpLpersonLossDto);
				}
			}

			if (compensateDto.getPrpLpersonLossDtoList() != null
					&& compensateDto.getPrpLpersonLossDtoList().size() > 0) {
				prpLpersonLossDtoNew = (PrpLpersonLossDto) compensateDto
						.getPrpLpersonLossDtoList().get(0);
			}

			// insuredName = prpLpersonLossDtoNew.getPersonName(); //��������Ϣ
			// 2005-9-17
			insuredName = compensateDto.getPrpLcompensateDto().getInsuredName(); // ��������Ϣ
			// 2005-9-17
			String strSex = prpLpersonLossDtoNew.getSex().equals("1") ? "����"
					: "Ůʿ"; // ��Ϣת�� 2005-7-19
			String damageName = compensateDto.getPrpLcompensateDto()
					.getDamageName(); // ����ԭ��
			String policyNo = compensateDto.getPrpLcompensateDto()
					.getPolicyNo(); // ������
			String strRiskCode = compensateDto.getPrpLcompensateDto()
					.getRiskCode(); // ����
			double dblPolicySumAmount = compensateDto.getPrpLcompensateDto()
					.getSumAmount(); // ��������
			String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo(); // ������
			String strAddInfo = "";
			// ��λ��Ͷ���������أ���
			String strAppliName = compensateDto.getPrpLcompensateDto()
					.getAppliName();
			// String apliName =prpLpersonLossDtoNew.get
			if (strClaimType.equals("7")) { // 7:Ϊ���ⰸ��
				prpLctextList.clear();
				prpLctextList.add("  ");
				prpLctextList.add("�𾴵�" + insuredName + strSex);

				TextTemp = "�����������뱾��˾�Ѿ���Ϥ�����ݱ��������ط��ɣ����������˶������ṩ���й�������֤��������˾��Ϊ��"
						+ "�����������ɲ��ܳ������������´��� ";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace
						+ "�����������˼�/����������ս�/�˻���Լ��CNY0.00Ԫ ,��������պ�ͬ��");
				prpLctextList.add(strSpace + "����˾�������������������ǣ�");
				prpLctextList.add("  ");

				TextTemp = "�����Ա���˾�Ĵ��������飬���ڽӵ���֪֮ͨ����ʮ�����򱾹�˾���ⲿ��Ѱ����͡������������޷��������Ĵ𸴣�������������Ȩ���� ";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace + "���ٲû��������ٲ�/������Ժ��������");
				prpLctextList.add(strSpace + "�����벢����������������Ȩ����");
			} else if (strClaimType.equals("8")) { // 8:ΪЭ�鰸��
				prpLctextList.clear();
				prpLctextList.add("  ");

				TextTemp = "����" + policyNo
						+ "�ű�������֮Ȩ�������ҹ�˾����������룬��˫��Э�̣��������Э��:";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace + "1. ���չ�˾ͬ��������ս�CNY" + dblSumJE
						+ "Ԫ����");
				prpLctextList.add(strSpace + "2.�������ս������" + insuredName
						+ "����ȫ��Ȩ�������죻");
				prpLctextList.add(strSpace
						+ "3.ȫ��Ȩ����ͬ��������������������������뱾�����¹��й�֮Ȩ����");
				prpLctextList.add("�ϼƸ������ս�CNY" + dblSumJE + "Ԫ");
			} else if (strClaimType.equals("5")) { // 5:Ϊͨ�ڰ���
				prpLctextList.clear();
				prpLctextList.add("  ");

				TextTemp = "����" + policyNo + "�ű�������" + insuredName + "���������ˣ�����"
						+ damageName + "�¹ʲ�������˾��������," + policyNo + "��������"
						+ "֮Ȩ�������ҹ�˾���ͨ���������룬����˾��˺��о�������ͬ��ͨ�ڸ������������Э�飺 ";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace + "1. ���չ�˾ͬ��ͨ�ڸ������ս�CNY" + dblSumJE
						+ "Ԫ��");
				prpLctextList.add(strSpace + "2.�������ս������" + insuredName
						+ "����ȫ��Ȩ�������죻");
				prpLctextList.add(strSpace
						+ "3.ȫ��Ȩ����ͬ��������������������������뱾�����¹��й�֮Ȩ����");
				prpLctextList.add("�ϼƸ������ս�CNY" + dblSumJE + "Ԫ");
			} else {

				// ����Ϊ0��һ���ⰸ 1���پ��ⰸ B�����󰸼��е�һ��
				prpLctextList.clear();
				prpLctextList.add("  ");
				// modify by lixiang start at 20051227
				// reason :�ͻ�Ҫ���޸���˵ĸ�ʽ
				// TextTemp = "����" + insuredName + strSex + "��" + damageName +
				// "�¹�Ҽ������������룬������˾������������η�Χ��ͬ������������ ";
				TextTemp = "���пͻ����ⰸ��" + claimNo + "������������룬������˾��ˣ�ͬ�����¸���������";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);

				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				TextTemp = "1��" + policyNo + "�������£�Ͷ���ˣ���" + strAppliName
						+ "�� �������ˣ���" + insuredName + "��";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);

				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				String TextTemp2 = "";
				TextTemp = ""; // clear
				prpLpersonLossDtoNew = new PrpLpersonLossDto();
				for (int intCount = 0; intCount < tmpPrpLpersonLossDtos.size(); intCount++) {
					prpLpersonLossDtoNew = (PrpLpersonLossDto) tmpPrpLpersonLossDtos
							.get(intCount);
					double dblUnitAmountSum = prpLpersonLossDto.getdblMaxPaid();
					double dblUnitAmountSum2 = prpLpersonLossDtoNew
							.getdblMaxPaid()
							- prpLpersonLossDtoNew.getSumRealPay(); // Ϊ�˼�����ձ��ս��
					strAddInfo = "";
					String codeNameNew = uiCodeAction.translateKindCode(
							prpLpersonLossDtoNew.getRiskCode(),
							prpLpersonLossDtoNew.getKindCode(), true);
					// ������ս��ȫ���꣬����Ϊ0Ԫ���Ҹ���ʾ��Ϣ�� 2005-9-19
					if (dblUnitAmountSum2 < 0.0) {
						dblUnitAmountSum2 = 0.0;
						// strAddInfo = "ͬʱ������������ֹ��";
					}
					TextTemp = TextTemp
							+ "  ���ݡ�"
							+ codeNameNew
							+ "���������� ��"
							+ insuredName
							+ "�����ս�����ң�"
							+ MoneyUtils.toChinese(prpLpersonLossDtoNew
									.getSumRealPay(), "CNY") + "���� "
							+ prpLpersonLossDtoNew.getSumRealPay() + "����"
							+ strAddInfo;
					// System.out.println("TextTemp:"+ intCount+ TextTemp);
					if (dblUnitAmountSum2 == 0)
						TextTemp2 = TextTemp2
								+ "  ��"
								+ uiCodeAction.translateRiskCode(
										prpLpersonLossDtoNew.getRiskCode(),
										true) + "��������ս� ����ң� Ԫ��";
					else
						TextTemp2 = TextTemp2
								+ "  ��"
								+ uiCodeAction.translateRiskCode(
										prpLpersonLossDtoNew.getRiskCode(),
										true)
								+ "��������ս� �����"
								+ MoneyUtils
										.toChinese(dblUnitAmountSum2, "CNY")
								+ "�� " + dblUnitAmountSum2 + " ��";
					// System.out.println("TextTemp2:"+ intCount+ TextTemp2);
				}

				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				TextTemp = "2��������֮����" + policyNo + "�������£�";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}
				rulesAcci = StringUtils.split(TextTemp2, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				TextTemp = "3���������䡣";
				// modify by lixiang end at 20051227

				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				// ��Ӵ������㹫ʽ���� 2005-9-18
				/*
				 * prpLpersonLossDtoNew = new PrpLpersonLossDto(); for (int
				 * intIndex = 0; intIndex < prpLpersonLossDtoListCopy.size();
				 * intIndex++) { prpLpersonLossDtoNew = (PrpLpersonLossDto)
				 * prpLpersonLossDtoListCopy.get(intIndex);
				 * prpLctextList.add(strSpace + strSpace +
				 * prpLpersonLossDtoNew.getLiabDetailName() + ":" +
				 * prpLpersonLossDtoNew.getRemark() + ";" + "�⸶���:"
				 * +compensateCurrency+ prpLpersonLossDtoNew.getSumRealPay() +
				 * "Ԫ"); }
				 * 
				 * prpLctextList.add(" "); prpLctextList.add("�ϼƸ������ս�:
				 * "+compensateCurrency + dblSumJE + "Ԫ");
				 */

			}

			for (i = 1; i <= prpLctextList.size(); i++) {
				prpLctextDto = new PrpLctextDto();
				prpLctextDto.setCompensateNo(strCompensateNo);
				prpLctextDto.setTextType("1");
				prpLctextDto.setLineNo(i);
				prpLctextDto.setContext((String) prpLctextList.get(i - 1));
				prpLctextlist.add(prpLctextDto);
			}
		} else { // ���⽡������ģ����Ϣ
			for (i = 1; i <= prpLctextList.size(); i++) {
				prpLctextDto = new PrpLctextDto();
				prpLctextDto.setCompensateNo(strCompensateNo);
				prpLctextDto.setTextType("1");
				prpLctextDto.setLineNo(i);
				prpLctextDto.setContext((String) prpLctextList.get(i - 1));
				prpLctextlist.add(prpLctextDto);
			}
		}
		prpLctextDto.setPrpLctextList(prpLctextlist);
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);

	}

	private void setLossFromPolicy(HttpServletRequest httpServletRequest,
			PolicyDto policyDto) {

		ArrayList prpLlossList = new ArrayList();
		int index = 1;
		if (policyDto.getPrpCitemKindDtoList() != null) {
			for (Iterator iter = policyDto.getPrpCitemKindDtoList().iterator(); iter
					.hasNext();) {
				PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
				PrpLlossDto prpLlossTempDto = new PrpLlossDto();
				prpLlossTempDto.setSerialNo(index++);
				prpLlossTempDto.setKindCode(prpCitemKindDto.getKindCode());
				prpLlossTempDto.setKindName(prpCitemKindDto.getKindName());
				prpLlossTempDto
						.setLossName(prpCitemKindDto.getItemDetailName());
				prpLlossTempDto.setItemValue(prpCitemKindDto.getAmount());
				prpLlossTempDto.setAmount(prpCitemKindDto.getAmount());
				prpLlossTempDto.setCurrency(prpCitemKindDto.getCurrency());
				prpLlossTempDto.setCurrency2(prpCitemKindDto.getCurrency());
				prpLlossTempDto.setCurrency3(prpCitemKindDto.getCurrency());
				prpLlossTempDto.setCurrency4(prpCitemKindDto.getCurrency());
				prpLlossTempDto.setDeductible(prpCitemKindDto.getDeductible());
				prpLlossTempDto.setDeductibleRate(prpCitemKindDto
						.getDeductibleRate());
				prpLlossTempDto.setClaimRate(prpCitemKindDto.getClaimRate());
				if (prpLlossTempDto.getCurrency().equals("CNY")) {
					prpLlossTempDto.setCurrencyName("�����");
				}
				if (prpLlossTempDto.getCurrency().equals("USD")) {
					prpLlossTempDto.setCurrencyName("��Ԫ");
				}
				if (prpLlossTempDto.getCurrency1().equals("CNY")) {
					prpLlossTempDto.setCurrency1Name("�����");
				}
				if (prpLlossTempDto.getCurrency1().equals("USD")) {
					prpLlossTempDto.setCurrency1Name("��Ԫ");
				}
				if (prpLlossTempDto.getCurrency2().equals("CNY")) {
					prpLlossTempDto.setCurrency2Name("�����");
				}
				if (prpLlossTempDto.getCurrency2().equals("USD")) {
					prpLlossTempDto.setCurrency2Name("��Ԫ");
				}
				if (prpLlossTempDto.getCurrency3().equals("CNY")) {
					prpLlossTempDto.setCurrency3Name("�����");
				}
				if (prpLlossTempDto.getCurrency3().equals("USD")) {
					prpLlossTempDto.setCurrency3Name("��Ԫ");
				}
				if (prpLlossTempDto.getCurrency4().equals("CNY")) {
					prpLlossTempDto.setCurrency4Name("�����");
				}
				if (prpLlossTempDto.getCurrency4().equals("USD")) {
					prpLlossTempDto.setCurrency4Name("��Ԫ");
				}
				prpLlossList.add(prpLlossTempDto);
			}
		}
		PrpLlossDto prpLlossDto = new PrpLlossDto();

		prpLlossDto.setPrpLlossList(prpLlossList);

		httpServletRequest.setAttribute("prpLlossDto", prpLlossDto);
	}

	private void setChargeFromPolicy(HttpServletRequest httpServletRequest,
			PolicyDto policyDto) throws Exception {

		ArrayList prpLchargeList = new ArrayList();
		int index = 1;
		UICodeAction uiCodeAction = new UICodeAction();
		if (policyDto.getPrpCitemKindDtoList() != null) {
			for (Iterator iter = policyDto.getPrpCitemKindDtoList().iterator(); iter
					.hasNext();) {
				PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
				PrpLchargeDto prpLchargeTempDto = new PrpLchargeDto();
				prpLchargeTempDto.setSerialNo(index++);
				prpLchargeTempDto.setKindCode(prpCitemKindDto.getKindCode());
				prpLchargeTempDto.setKindName(prpCitemKindDto.getKindName());
				prpLchargeTempDto.setCurrency(prpCitemKindDto.getCurrency());
				prpLchargeTempDto.setCurrencyName(uiCodeAction
						.translateCurrencyCode(prpCitemKindDto.getCurrency(),
								policyDto.getPrpCmainDto().getLanguage()
										.equals("C")));
				prpLchargeList.add(prpLchargeTempDto);
			}
		}
		PrpLchargeDto prpLchargeDto = new PrpLchargeDto();

		prpLchargeDto.setPrpLchargeList(prpLchargeList);

		httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);
	}

	/**
	 * ��������������
	 * 
	 * @param httpServletRequest
	 * @return compensateDto ʵ�����ݴ������ݽṹ
	 * @throws Exception
	 */
	public CompensateDto viewToDtoForAccident(
			HttpServletRequest httpServletRequest) throws Exception {
		// �̳ж�compensate,compensateText��ĸ�ֵ
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();

		ArrayList prpLpersonLossDtoList = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = null;
		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		// ����Σ�յ�λ���� add by qinyongli 2005-9-10
		// reason: Ŀǰֻ��һ��Σ�յ�λ�����Ժͱ����Ϣ����һ����������ж��Σ�յ�λ�������Σ�յ�λ��Ϣ���洦��
		ArrayList prpLprpLdangerTotList = new ArrayList(); // ����Σ�յ�λ���ϼ���Ϣ
		ArrayList prpLprpLdangerItemList = new ArrayList(); // �����Σ�յ�λ��Ϣ��

		PrpLdangerItemDto prpLdangerItemDto = null; // ���DTO
		int dangerItemSerialNo = 1; // ���ڴ洢��ĵ����
		// �ӽ���õ���������
		String prpLpersonLossCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLpersonLossRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLpersonLossPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");

		String[] prplAcciPersonNo = httpServletRequest
				.getParameterValues("prplAcciPersonNo");// �����¹�����
		String[] personLossSerialNo = httpServletRequest
				.getParameterValues("personLossSerialNo");// �����¹���
		String[] prpLpersonLossLiabSerialNo = httpServletRequest
				.getParameterValues("prpLpersonLossLiabSerialNo");// ����������ϸ

		String[] prpLpersonLossPersonName = httpServletRequest
				.getParameterValues("prpLpersonLossPersonName");
		String[] prpLpersonLossIdentifyNumber = httpServletRequest
				.getParameterValues("prpLpersonLossIdentifyNumber");
		String[] prpLpersonLossSex = httpServletRequest
				.getParameterValues("prpLpersonLossSex");
		String[] prpLpersonLossAge = httpServletRequest
				.getParameterValues("prpLpersonLossAge");

		String[] prpLpersonLossItemKindNo = httpServletRequest
				.getParameterValues("prpLpersonLossItemKindNo");
		String[] prpLpersonLossFamilyNo = httpServletRequest
				.getParameterValues("prpLpersonLossFamilyNo");
		String[] prpLpersonLossFamilyName = httpServletRequest
				.getParameterValues("prpLpersonLossFamilyName");
		String[] prpLpersonLossKindCode = httpServletRequest
				.getParameterValues("prpLpersonLossKindCode");
		String[] prpLpersonLossLiabCode = httpServletRequest
				.getParameterValues("prpLpersonLossLiabCode");
		String[] prpLpersonLossLiabName = httpServletRequest
				.getParameterValues("prpLpersonLossLiabName");
		String[] prpLpersonLossJobCode = httpServletRequest
				.getParameterValues("prpLpersonLossJobCode");
		String[] prpLpersonLossJobName = httpServletRequest
				.getParameterValues("prpLpersonLossJobName");
		String[] prpLpersonLossLiabDetailCode = httpServletRequest
				.getParameterValues("prpLpersonLossLiabDetailCode");
		String[] prpLpersonLossLiabDetailName = httpServletRequest
				.getParameterValues("prpLpersonLossLiabDetailName");
		String[] prpLpersonLossItemAddress = httpServletRequest
				.getParameterValues("prpLpersonLossItemAddress");
		String[] prpLpersonLossLossQuantity = httpServletRequest
				.getParameterValues("prpLpersonLossLossQuantity");
		String[] prpLpersonLossUnit = httpServletRequest
				.getParameterValues("prpLpersonLossUnit");
		String[] prpLpersonLossUnitAmount = httpServletRequest
				.getParameterValues("prpLpersonLossUnitAmount");
		String[] prpLpersonLossCurrency = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency");
		String[] prpLpersonLossAmount = httpServletRequest
				.getParameterValues("prpLpersonLossAmount");
		String[] prpLpersonLossCurrency1 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency1");
		String[] prpLpersonLossItemValue = httpServletRequest
				.getParameterValues("prpLpersonLossItemValue");
		String[] prpLpersonLossCurrency2 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency2");
		String[] prpLpersonLossSumLoss = httpServletRequest
				.getParameterValues("prpLpersonLossSumLoss");
		String[] prpLpersonLossSumRest = httpServletRequest
				.getParameterValues("prpLpersonLossSumRest");
		String[] prpLpersonLossIndemnityDutyRate = httpServletRequest
				.getParameterValues("prpLpersonLossIndemnityDutyRate");
		String[] prpLpersonLossClaimRate = httpServletRequest
				.getParameterValues("prpLpersonLossClaimRate");
		String[] prpLpersonLossCurrency3 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency3");
		String[] prpLpersonLossDeductibleRate = httpServletRequest
				.getParameterValues("prpLpersonLossDeductibleRate");
		String[] prpLpersonLossDeductible = httpServletRequest
				.getParameterValues("prpLpersonLossDeductible");
		String[] prpLpersonLossCurrency4 = httpServletRequest
				.getParameterValues("prpLpersonLossCurrency4");
		String[] prpLpersonLossSumRealPay = httpServletRequest
				.getParameterValues("prpLpersonLossSumRealPay");
		String[] prpLpersonLossFlag = httpServletRequest
				.getParameterValues("prpLpersonLossFlag");
		String[] prpLpersonLossRemark = httpServletRequest
				.getParameterValues("prpLpersonLossRemark");
		// �˲еȼ�,��Ժ����,��Ժ����,סԺ����
		String[] prpLpersonLossInjuryGrade = httpServletRequest
				.getParameterValues("prpLpersonLossInjuryGrade");
		String[] prpLpersonLossInHospDate = httpServletRequest
				.getParameterValues("prpLpersonLossInHospDate");
		String[] prpLpersonLossOutHospDate = httpServletRequest
				.getParameterValues("prpLpersonLossOutHospDate");
		String[] prpLpersonLossHospitalDays = httpServletRequest
				.getParameterValues("prpLpersonLossHospitalDays");

		// �ձ�����⸶�� 2005-9-21
		String[] prpLpersonLossMaxPaid = httpServletRequest
				.getParameterValues("prpLpersonLossMaxPaid");
		String[] prpLpersonLossHisPaid = httpServletRequest
				.getParameterValues("prpLpersonLossHisPaid");
		String hospitalCode = httpServletRequest
				.getParameter("prpLcompensateHospitalCode");
		String diseaseCode = httpServletRequest
				.getParameter("prpLcompensateDiseaseCode");

		if (prpLpersonLossLiabSerialNo == null) {
		} else {
			for (int index = 1; index < prpLpersonLossLiabSerialNo.length; index++) {
				prpLpersonLossDto = new PrpLpersonLossDto();
				prpLpersonLossDto.setPolicyNo(prpLpersonLossPolicyNo);
				prpLpersonLossDto.setRiskCode(prpLpersonLossRiskCode);
				prpLpersonLossDto.setCompensateNo(prpLpersonLossCompensateNo);
				prpLpersonLossDto.setSerialNo(index);

				for (int index3 = 0; index3 < prplAcciPersonNo.length; index3++) {
					if (prplAcciPersonNo[index3]
							.equals(personLossSerialNo[index])) {
						prpLpersonLossDto
								.setIdentifyNumber(prpLpersonLossIdentifyNumber[index3]);
						prpLpersonLossDto
								.setFamilyNo(Integer
										.parseInt(DataUtils
												.nullToZero(prpLpersonLossFamilyNo[index3])));
						prpLpersonLossDto
								.setFamilyName(prpLpersonLossPersonName[index3]);
						prpLpersonLossDto.setAge(Integer.parseInt(DataUtils
								.nullToZero(prpLpersonLossAge[index3])));
						prpLpersonLossDto.setPersonNo(Integer
								.parseInt(DataUtils
										.nullToZero(prplAcciPersonNo[index3])));
						prpLpersonLossDto
								.setPersonName(prpLpersonLossPersonName[index3]);
						prpLpersonLossDto.setSex(prpLpersonLossSex[index3]);

					}

				}
				prpLpersonLossDto.setKindCode(DataUtils
						.nullToZero(prpLpersonLossKindCode[index]));
				prpLpersonLossDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonLossItemKindNo[index])));
				prpLpersonLossDto.setdblMaxPaid(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossMaxPaid[index])));
				prpLpersonLossDto.setMaxpaid(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossMaxPaid[index])));
				prpLpersonLossDto.setHispaid(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossHisPaid[index])));

				prpLpersonLossDto.setLiabCode(prpLpersonLossLiabCode[index]);
				prpLpersonLossDto.setLiabName(prpLpersonLossLiabName[index]);
				prpLpersonLossDto.setJobCode(prpLpersonLossJobCode[index]);
				prpLpersonLossDto.setJobName(prpLpersonLossJobName[index]);
				prpLpersonLossDto
						.setItemAddress(prpLpersonLossItemAddress[index]);
				prpLpersonLossDto.setUnit(prpLpersonLossUnit[index]);
				prpLpersonLossDto.setCurrency(prpLpersonLossCurrency[index]);
				prpLpersonLossDto.setAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossAmount[index])));
				prpLpersonLossDto.setCurrency1(prpLpersonLossCurrency1[index]);
				prpLpersonLossDto.setItemValue(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossItemValue[index])));
				prpLpersonLossDto.setCurrency2(prpLpersonLossCurrency2[index]);
				prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossSumRest[index])));
				prpLpersonLossDto.setClaimRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossClaimRate[index])));
				prpLpersonLossDto.setDeductible(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossDeductible[index])));
				prpLpersonLossDto.setCurrency4(prpLpersonLossCurrency4[index]);
				prpLpersonLossDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossSumRealPay[index])));
				prpLpersonLossDto.setFlag(prpLpersonLossFlag[index]);
				prpLpersonLossDto
						.setLiabDetailCode(prpLpersonLossLiabDetailCode[index]);
				prpLpersonLossDto
						.setLiabDetailName(prpLpersonLossLiabDetailName[index]);
				prpLpersonLossDto.setUnitAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossUnitAmount[index])));
				if ("2801".indexOf(prpLpersonLossRiskCode) > -1) {
					prpLpersonLossDto.setInjuryGrade("");
					prpLpersonLossDto.setHospitalDays(0);
					prpLpersonLossDto.setInHospDate(DateTime.current());
					prpLpersonLossDto.setOutHospDate(new DateTime(DateTime
							.current()));
				} else {
					prpLpersonLossDto
							.setInjuryGrade(prpLpersonLossInjuryGrade[index]);
					prpLpersonLossDto
							.setHospitalDays(Integer
									.parseInt(DataUtils
											.nullToZero(prpLpersonLossHospitalDays[index])));
					prpLpersonLossDto.setInHospDate(new DateTime(
							prpLpersonLossInHospDate[index]));
					prpLpersonLossDto.setOutHospDate(new DateTime(
							prpLpersonLossOutHospDate[index]));
				}
				// prpLpersonLossDto.setInjuryGrade(prpLpersonLossInjuryGrade[index]);
				// prpLpersonLossDto.setHospitalDays(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossHospitalDays[index])));
				// prpLpersonLossDto.setInHospDate(new
				// DateTime(prpLpersonLossInHospDate[index]));
				// prpLpersonLossDto.setOutHospDate(new
				// DateTime(prpLpersonLossOutHospDate[index]));
				prpLpersonLossDto.setLossQuantity(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonLossLossQuantity[index])));
				prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpersonLossSumLoss[index])));

				prpLpersonLossDto.setCurrency3(prpLpersonLossCurrency3[index]);

				prpLpersonLossDto
						.setIndemnityDutyRate(Double
								.parseDouble(DataUtils
										.nullToZero(prpLpersonLossIndemnityDutyRate[index])));
				// prpLpersonLossDto.setKindCode(prpLpersonLossKindCode[index]);
				prpLpersonLossDto
						.setDeductibleRate(Double
								.parseDouble(DataUtils
										.nullToZero(prpLpersonLossDeductibleRate[index])));

				prpLpersonLossDto.setRemark(prpLpersonLossRemark[index]);

				prpLpersonLossDto.setHospitalCode(hospitalCode);
				prpLpersonLossDto.setDiseaseCode(diseaseCode);

				// ����Σ�յ�λ�ռ� add by qinyongli 2005-9-10
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLpersonLossCompensateNo);
				 * //ʵ��� prpLdangerItemDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemDto.setCurrency(prpLpersonLossCurrency[index]);
				 * //��ʧ�ұ� prpLdangerItemDto.setKindFlag("0"); //�ձ�����־,0��ʾ����
				 * prpLdangerItemDto.setKindName("����"); //�ձ��������
				 * prpLdangerItemDto.setRiskCode(prpLpersonLossRiskCode); //�ձ�
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //������
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
				 * //�Ѿ���� prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				prpLpersonLossDtoList.add(prpLpersonLossDto);
			}// end for
		}// end if
		// �⸶��Ա��Ϣ
		compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
		ArrayList prpllossDtoList = new ArrayList();
		compensateDto.setPrpLlossDtoList(prpllossDtoList);

		/*---------------------��������ϢprpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// �ӽ���õ���������
		String prpLchargePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLchargeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLchargeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String[] prpLchargeSerialNo = httpServletRequest
				.getParameterValues("prpLchargeSerialNo");
		String[] prpLchargeKindCode = httpServletRequest
				.getParameterValues("prpLchargeKindCode");
		String[] prpLchargeChargeCode = httpServletRequest
				.getParameterValues("prpLchargeChargeCode");
		String[] prpLchargeChargeName = httpServletRequest
				.getParameterValues("prpLchargeChargeName");
		String[] prpLchargeCheckDeptCode = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptCode");
		String[] prpLchargeCheckDeptName = httpServletRequest
				.getParameterValues("prpLchargeCheckDeptName");
		String[] prpLchargeCurrency = httpServletRequest
				.getParameterValues("prpLchargeCurrency");
		String[] prpLchargeChargeAmount = httpServletRequest
				.getParameterValues("prpLchargeChargeAmount");
		String[] prpLpreChargeAmount = httpServletRequest
				.getParameterValues("prpLpreChargeAmount");
		String[] prpLchargeSumRealPay = httpServletRequest
				.getParameterValues("prpLchargeSumRealPay");
		String[] prpLchargeFlag = httpServletRequest
				.getParameterValues("prpLchargeFlag");
		String[] prpLchargeChargeReport = httpServletRequest
				.getParameterValues("prpLchargeChargeReport"); // add 20060512
		String[] prpLlossDtoItemKindNoForCharge = httpServletRequest
				.getParameterValues("prpLlossDtoItemKindNoForCharge"); // �⽡�շ��ñ�Ĵ���

		// ����ֵ
		if (prpLchargeSerialNo == null) {

		} else {
			for (int index = 1; index < prpLchargeSerialNo.length; index++) {
				prpLchargeDto = new PrpLchargeDto();
				prpLchargeDto.setPolicyNo(prpLchargePolicyNo);
				prpLchargeDto.setRiskCode(prpLchargeRiskCode);
				prpLchargeDto.setCompensateNo(prpLchargeCompensateNo);

				prpLchargeDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLchargeSerialNo[index])));
				prpLchargeDto.setKindCode(prpLchargeKindCode[index]);
				prpLchargeDto.setChargeCode(prpLchargeChargeCode[index]);
				prpLchargeDto.setChargeName(prpLchargeChargeName[index]);
				if (prpLchargeChargeCode[index] != null
						&& "14".equals(prpLchargeChargeCode[index])) {
					prpLchargeDto
							.setCheckDeptCode(prpLchargeCheckDeptCode[index]);
					prpLchargeDto
							.setCheckDeptName(prpLchargeCheckDeptName[index]);
				}
				prpLchargeDto.setCurrency(prpLchargeCurrency[index]);
				prpLchargeDto.setChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeChargeAmount[index])));
				prpLchargeDto.setPreChargeAmount(Double.parseDouble(DataUtils
						.nullToZero(prpLpreChargeAmount[index])));
				prpLchargeDto.setSumRealPay(Double.parseDouble(DataUtils
						.nullToZero(prpLchargeSumRealPay[index])));
				prpLchargeDto.setFlag(prpLchargeFlag[index]);
				prpLchargeDto.setItemkindno(Integer.parseInt(DataUtils
						.nullToZero(prpLlossDtoItemKindNoForCharge[index])));

				if (prpLchargeChargeReport != null
						&& prpLchargeChargeReport.length > 0) {
					prpLchargeDto.setChargeReport(Double.parseDouble(DataUtils
							.nullToZero(prpLchargeChargeReport[index]))); // add
					// 20060512
				}

				// ����Σ�յ�λ�ռ� add by qinyongli 2005-9-10
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLchargeCompensateNo); //ʵ���
				 * prpLdangerItemDto.setDangerNo(1); //Ŀǰֻ��һ��Σ�յ�λ
				 * prpLdangerItemDto.setCurrency(prpLchargeCurrency[index]);
				 * //��ʧ�ұ� prpLdangerItemDto.setKindFlag("0"); //�ձ�����־,0��ʾ����
				 * prpLdangerItemDto.setKindName("����"); //�ձ��������
				 * prpLdangerItemDto.setRiskCode(prpLchargeRiskCode); //�ձ�
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //������
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				 * //�Ѿ���� prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// ���뼯��
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// ��������Ϣ
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// �ӽ���õ���������
		String prpLcfeeCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLcfeePolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String prpLcfeeRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLcfeeCurrency1 = httpServletRequest
				.getParameter("prpLcompensateCurrency");
		String prpLcfeeSumThisPaid = httpServletRequest
				.getParameter("prpLcompensateSumThisPaid");
		String prpLcfeeFlag = httpServletRequest.getParameter("prpLcfeeFlag");
		// ����ֵ
		// ����������Ϣ
		prpLcfeeDto = new PrpLcfeeDto();
		prpLcfeeDto.setCompensateNo(prpLcfeeCompensateNo);
		prpLcfeeDto.setPolicyNo(prpLcfeePolicyNo);
		prpLcfeeDto.setRiskCode(prpLcfeeRiskCode);
		prpLcfeeDto.setCurrency(prpLcfeeCurrency1);
		prpLcfeeDto.setSumPaid(Double.parseDouble(DataUtils
				.nullToZero(prpLcfeeSumThisPaid)));
		prpLcfeeDto.setFlag("");
		prpLcfeeDtoList.add(prpLcfeeDto);
		compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);

		// ����������ڰ����⸶������Ҫ�᰸�����ı�
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");
		String strRiskType = uiCodeAction
				.translateRiskCodetoRiskType(prpLpersonLossRiskCode);
		/*
		 * if("E".equals(strRiskType)){ prpLcompensateFinallyFlag = "1"; }
		 */
		if (prpLcompensateFinallyFlag.equals("1")) {
			ArrayList prpLltextDtoList = new ArrayList();
			String TextTemp = httpServletRequest
					.getParameter("prpLltextContextInnerHTML");
			String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
			// �õ����Ӵ�,���潫���зֵ�����
			for (int k = 0; k < rules.length; k++) {
				PrpLltextDto prpLltextDto = new PrpLltextDto();
				prpLltextDto.setClaimNo((String) httpServletRequest
						.getParameter("prpLcompensateClaimNo"));
				prpLltextDto.setContext(rules[k]);
				prpLltextDto.setLineNo(k + 1);
				prpLltextDto.setTextType("08");
				prpLltextDtoList.add(prpLltextDto);
			}

			// compensateDto
			compensateDto.setPrpLltextDtoList(prpLltextDtoList);
		}

		if (DangerUnitCheckSaveFlag.equals("1")) {
			// ----------------------------Σ�յ�λ��Ϣ����,Ŀǰֻ��һ��Σ�յ�λ
			String TCurrency = httpServletRequest.getParameter("MergeCurrency");
			// ��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10
			// compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
			// �Ա����Ϣ���д����õ����ϼ���Ϣ
			ArrayList itemList = prpLprpLdangerItemList;
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto(); // ��ȡÿ����Ķ���
			PrpLdangerItemDto dangerItem = new PrpLdangerItemDto(); // ѭ���ж�ʱʹ��
			ArrayList tempCurrency = new ArrayList();
			// Iterator itemListIteratorAll = itemList.iterator();
			// Iterator itemListIterator = itemList.iterator();
			PrpLdangerItemDto dangerItemAll1 = new PrpLdangerItemDto();
			/*
			 * while(itemListIteratorAll.hasNext()){ dangerItemAll=
			 * (PrpLdangerItemDto)itemListIteratorAll.next(); dangerItemAll1 =
			 * new PrpLdangerItemDto();
			 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
			 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());
			 * //�õ�ǰ�ұ�������Ͻ���ͳ�� String currentCur = dangerItemAll.getCurrency();
			 * int currentSerial = dangerItemAll.getSerialNo();
			 * while(itemListIterator.hasNext()){ dangerItem =
			 * (PrpLdangerItemDto)itemListIterator.next();
			 * //����ұ���ȣ�����⳥���ͷ��ý����ۼ�
			 * if(currentSerial!=dangerItem.getSerialNo()&&currentCur.equals(dangerItem.getCurrency())){
			 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee()+dangerItem.getSumFee());
			 * //�ϼƷ���
			 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid()+dangerItem.getSumPaid());
			 * //�ϼƽ�� } } if(tempCurrency.contains(currentCur)){ continue;
			 * //����Ѿ��ϼƹ��ı��֣����ٽ��кϼ�; } tempCurrency.add(currentCur); //����ǰ�ϼƵı����ݴ� ;
			 * 
			 * //�������Ϣ����ϼ�Dto if(dangerItemAll!=null){
			 * prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
			 * prpLdangerTotDto.setDangerNo(1); //Ŀǰ����һ��Σ�յ�λ
			 * prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency());
			 * //���ԭ�ұ� prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
			 * prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
			 * prpLdangerTotDto.setTCurrency(TCurrency); //���бұ�ת��
			 * ת����ıұ�ΪTCurrency String SCurrency = dangerItemAll.getCurrency();
			 * //ԭ�ұ� double exchangeRate =
			 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
			 * Date())); prpLdangerTotDto.setExchRate(exchangeRate);
			 * prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()*exchangeRate);
			 * prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()*exchangeRate); }
			 * if(prpLdangerTotDto!=null){
			 * prpLprpLdangerTotList.add(prpLdangerTotDto); } }
			 */
			// compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			// ��Σ�յ�λ�����Ϣ�����ڼ����У�add by qinyongli 2005-9-10 end
			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061120 start reason ���ٱ�������
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061120 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// �ӽ���õ���������
			String compensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");
			String[] prpLdangerClaimNo = httpServletRequest
					.getParameterValues("prpLdangerClaimNo");
			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDesc");
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerAddressName");
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");
			String[] prpLcompensateSumThisPaid = httpServletRequest
					.getParameterValues("prpLcompensateSumThisPaid");
			String[] prpLdangerRiskSumPaid = httpServletRequest
					.getParameterValues("prpLdangerRiskSumPaid");
			String[] prpLdangerRiskSumClaim = httpServletRequest
					.getParameterValues("prpLdangerRiskSumClaim");
			String[] prpLdangerProportion = httpServletRequest
					.getParameterValues("prpLdangerProportion");
			String prpLcompensateSumNoDutyFee = httpServletRequest
					.getParameter("prpLcompensateSumNoDutyFee");

			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
			String sql = "";
			double sumTempLoss = 0;// dangerUnit����������һ���ۼ�ֵ������������⣩
			double sumTempPaid = 0;// dangerUnit�Ѿ��������һ���ۼ�ֵ
			double sumTempNoPaid = 0;// dangerUnitδ���������һ���ۼ�ֵ
			double tempLoss = 0;
			double tempPaid = 0;
			double tempNoPaid = 0;

			double sumLSumRealPay[] = new double[1000];

			// start
			// ��Ԫ�¸ķ���-------------------------------------------------------------------------
			// ����ֵ
			if (prpLdangerCurrency == null) {
			} else {
				sql = " certino ='" + prpLdangerClaimNo[0] + "'";
				// ȡ������Σ�յ�λ��Ϣ������ ����Σ�յ�λ ���� �����Σ�յ�λ��Ϣ
				List prpLdangerUnitClaimList = (ArrayList) blPrpLdangerUnitFacade
						.findByConditions(sql);
				for (int index = 0; index < prpLdangerCurrency.length; index++) {

					sumTempLoss = 0;
					sumTempPaid = 0;
					sumTempNoPaid = 0;

					double sumPaid = 0;
					double sumNoPaid = 0;

					// ȡ����������δ��
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
						sumNoPaid = Double
								.parseDouble(prpLdangerRiskSumClaim[index])
								- sumPaid;// ��������δ��
					}

					// ���� ����Σ�յ�λ ���� �����Σ�յ�λ��Ϣ
					for (int dangerUnitSize = 0; dangerUnitSize < prpLdangerUnitClaimList
							.size(); dangerUnitSize++) {
						List temPrpLprpLdangerItemList = new ArrayList();
						dangerItemSerialNo = 1;
						prpLdangerUnitClaimDto = (PrpLdangerUnitDto) prpLdangerUnitClaimList
								.get(dangerUnitSize);

						// 1������Σ�յ�λprpLdangerUnit
						prpLdangerUnitDto = new PrpLdangerUnitDto();
						prpLdangerUnitDto.setCertiNo(compensateNo);
						prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
						prpLdangerUnitDto
								.setRiskCode(prpLdangerRiskCode[index]);
						prpLdangerUnitDto
								.setPolicyNo(prpLdangerPolicyNo[index]);
						prpLdangerUnitDto.setDangerNo(prpLdangerUnitClaimDto
								.getDangerNo());
						prpLdangerUnitDto
								.setDangerDesc(prpLdangerUnitDesc[index]);
						prpLdangerUnitDto
								.setAddressName(prpLdangerAddressName[index]);
						prpLdangerUnitDto
								.setCurrency(prpLdangerCurrency[index]);
						prpLdangerUnitDto
								.setBusinessNature(prpLdangerUnitClaimDto
										.getBusinessNature());
						prpLdangerUnitDto
								.setPolicyBizType(prpLdangerUnitClaimDto
										.getPolicyBizType());
						prpLdangerUnitDto.setPolicyType(prpLdangerUnitClaimDto
								.getPolicyType());
						prpLdangerUnitDto
								.setBusinessType(prpLdangerUnitClaimDto
										.getBusinessType());
						prpLdangerUnitDto
								.setBusinessType1(prpLdangerUnitClaimDto
										.getBusinessType1());
						prpLdangerUnitDto.setOthFlag(prpLdangerUnitClaimDto
								.getOthFlag());
						prpLdangerUnitDto
								.setBusinessProvince(prpLdangerUnitClaimDto
										.getBusinessProvince());
						prpLdangerUnitDto
								.setBusinessTown(prpLdangerUnitClaimDto
										.getBusinessTown());
						prpLdangerUnitDto
								.setBusinessCounty(prpLdangerUnitClaimDto
										.getBusinessCounty());
						prpLdangerUnitDto
								.setBusinessAreaName(prpLdangerUnitClaimDto
										.getBusinessAreaName());
						if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1)// ���һ��Σ�յ�λ�ü�����
						{
							tempLoss = Double
									.parseDouble(prpLdangerRiskSumClaim[index])
									- sumTempLoss;
							tempPaid = Double
									.parseDouble(prpLdangerRiskSumPaid[index])
									- sumTempPaid;
							tempNoPaid = sumNoPaid - sumTempNoPaid;

						}
						// �����һ��Σ�յ�λ�ó˷��㣨���Ա�����
						else {
							tempLoss = Double
									.parseDouble(prpLdangerRiskSumClaim[index])
									* prpLdangerUnitClaimDto.getDangerShare()
									/ 100;
							tempPaid = Double
									.parseDouble(prpLdangerRiskSumPaid[index])
									* prpLdangerUnitClaimDto.getDangerShare()
									/ 100;
							tempNoPaid = sumNoPaid
									* prpLdangerUnitClaimDto.getDangerShare()
									/ 100;
							sumTempLoss += tempLoss;
							sumTempPaid += tempPaid;
							sumTempNoPaid += tempNoPaid;
						}
						prpLdangerUnitDto.setSumLoss(tempLoss);
						prpLdangerUnitDto.setSumPaid(tempPaid);
						prpLdangerUnitDto.setSumNoPaid(tempNoPaid);
						prpLdangerUnitDto.setDamageDate(compensateDto
								.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
						prpLdangerUnitDto.setDangerShare(prpLdangerUnitClaimDto
								.getDangerShare());
						if ("1".equals(prpLcompensateFinallyFlag)) {
							prpLdangerUnitDto.setCertiType("3");// ����Ϊʵ��
							prpLdangerUnitDto.setSumNoPaid(0); // �᰸ δ���������
						} else {
							prpLdangerUnitDto.setCertiType("3");
							// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
						}
						prpLdangerUnitDto.setCoinsFlag(strCoinsFlag); // add
						// by
						// kangzhen
						// ���뼯��
						if (prpLdangerPolicyNo[index] != null
								&& !(prpLdangerPolicyNo[index].equals(""))) {
							dangerUnitList.add(prpLdangerUnitDto);
						}

						// 2�����ɴ����Σ�յ�λ���prpLdangerItem����
						if (prpLpersonLossLiabSerialNo == null) {
						} else {
							double tempPersonRealPay = 0;
							for (int j = 1; j < prpLpersonLossLiabSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLpersonLossCompensateNo); // ʵ���
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto
										.setCurrency(prpLpersonLossCurrency[j]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto
										.setRiskCode(prpLpersonLossRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList
										.size() - 1) {
									tempPersonRealPay = Double
											.parseDouble(DataUtils
													.nullToZero(prpLpersonLossSumRealPay[j]))
											- sumLSumRealPay[dangerItemSerialNo];
								} else {
									tempPersonRealPay = Double
											.parseDouble(DataUtils
													.nullToZero(prpLpersonLossSumRealPay[j]))
											* prpLdangerUnitClaimDto
													.getDangerShare() / 100;
									sumLSumRealPay[dangerItemSerialNo] += tempPersonRealPay;
								}
								prpLdangerItemDto.setSumPaid(tempPersonRealPay);
								prpLdangerItemDto
										.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;
								// �Ѿ����
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						// 3�����ɴ�Σ�յ�λ��prpLdangerItem�����ã�
						if (prpLchargeSerialNo == null) {

						} else {
							double tempLchargeSumRealPay = 0;
							for (int j = 1; j < prpLchargeSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLchargeCompensateNo); // ʵ���
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // Ŀǰֻ��һ��Σ�յ�λ
								prpLdangerItemDto
										.setCurrency(prpLchargeCurrency[j]); // ��ʧ�ұ�
								prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
								prpLdangerItemDto.setKindName("����"); // �ձ��������
								prpLdangerItemDto
										.setRiskCode(prpLchargeRiskCode); // �ձ�
								if (dangerUnitSize == prpLdangerUnitClaimList
										.size() - 1) {
									tempLchargeSumRealPay = Double
											.parseDouble(DataUtils
													.nullToZero(prpLchargeChargeAmount[j]))
											- sumLSumRealPay[dangerItemSerialNo];
								} else {
									// Σ�յ�λ��ı����Ƿ����ǲ��Ǽ�������ȫҪ��¼��prpLdangerItem
									tempLchargeSumRealPay = Double
											.parseDouble(DataUtils
													.nullToZero(prpLchargeChargeAmount[j]))
											* prpLdangerUnitClaimDto
													.getDangerShare() / 100;
									sumLSumRealPay[dangerItemSerialNo] += tempLchargeSumRealPay;
								}
								prpLdangerItemDto
										.setSumFee(tempLchargeSumRealPay);
								prpLdangerItemDto
										.setSerialNo(dangerItemSerialNo); // ������
								dangerItemSerialNo++;
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						// 4�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTotD������prpLdangerItem��
						Iterator itemListIteratorAll = temPrpLprpLdangerItemList
								.iterator();
						Iterator itemListIterator = temPrpLprpLdangerItemList
								.iterator();
						double sumPaidAll = 0;
						while (itemListIteratorAll.hasNext()) {
							dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll
									.next();
							sumPaidAll += dangerItemAll.getSumPaid();
							sumPaidAll += dangerItemAll.getSumFee();
						}
						PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // ���ϼ�Dto
						prpLdangerTotDto.setCertiNo(compensateNo);
						prpLdangerTotDto.setDangerNo(prpLdangerUnitClaimDto
								.getDangerNo()); // Ŀǰ����һ��Σ�յ�λ
						prpLdangerTotDto
								.setSCurrency(prpLdangerCurrency[index]); // ���ԭ�ұ�
						prpLdangerTotDto.setSumFee(0);
						prpLdangerTotDto.setSumPaid(sumPaidAll);
						prpLdangerTotDto
								.setTCurrency(prpLdangerCurrency[index]);
						// ���бұ�ת�� ת����ıұ�ΪTCurrency
						/*
						 * String SCurrency = dangerItemAll.getCurrency(); //ԭ�ұ�
						 * double exchangeRate =
						 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
						 * Date()));
						 */
						prpLdangerTotDto.setExchRate(1);
						prpLdangerTotDto.setSumFeeEx(0);
						prpLdangerTotDto.setSumPaidEx(sumPaidAll);
						if (prpLdangerTotDto != null) {
							prpLprpLdangerTotList.add(prpLdangerTotDto);
						}

					}

				}
				// �����Ϣ
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
				compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
				compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			}
			// end
			// ��Ԫ�¸ķ���-------------------------------------------------------------------------

			// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {
			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// start------------------------------------*/

			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();

			ArrayList dangerUnitList = new ArrayList();
			ArrayList dangerItemList = new ArrayList();
			ArrayList dangerTotList = new ArrayList();
			ArrayList  prpLchargeList = compensateDto.getPrpLchargeDtoList();
		    PrpLchargeDto lchargeDto = null;
		    boolean isfee;

			double temp = 0;
			double sumDangerUnit = 0d;
			boolean flag = true;
			String sql = "";
			// �ӽ���õ���������

			String prpLdangerCompensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// ������

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// ҵ����Դ
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// ����ҵ������
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// Ͷ����ʽ
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// �����Ա�־
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// ��ũ��ʶ
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// ������ʶ�ֶ�
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// ��������ʡ
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// ����������
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// ����������
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// ������������
			// 1�����ɴ����Σ�յ�λ���prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto(); // ���DTO
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); // Σ�յ�λ
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); // ��ʧ�ұ�
					prpLdangerItemNewDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); // �ձ�
					prpLdangerItemNewDto.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					// ռ�����һ������ԭ��
					flag = true;
					for (int i = index + 1; i < prpLdangerCurrency.length; i++) {
						if (prpLdangerUnitItemKindNo[index].equals(prpLdangerUnitItemKindNo[i])) {
							flag = false;
						}
					}
					if (flag) {
						temp = 0;
						for (int k = 1; k < index; k++) {
							if (prpLdangerUnitItemKindNo[k].equals(prpLdangerUnitItemKindNo[index])) {
								temp += Str.round(Double.parseDouble(prpLdangerShare[k]), 2);
							}
						}
						prpLdangerItemNewDto.setDangerKindShare(Str.round(100 - temp, 2));
					} else {
						prpLdangerItemNewDto.setDangerKindShare(Double.parseDouble(prpLdangerShare[index]));
					}
					isfee = false; //�Ƿ��з��ã���������ֵ���Ӧ���ձ����ͱ�Ĵ���
	                  if(prpLchargeList != null && prpLchargeList.size()>0){
	                	 lchargeDto = new PrpLchargeDto();
	                	 for(int c=0;c<prpLchargeList.size();c++){
	                		lchargeDto = (PrpLchargeDto) prpLchargeList.get(c);
	                		if(lchargeDto.getKindCode().equals(prpLdangerKindcode[index])){
	                			isfee = true;
	     	           			break;
	                		}
   	                  }
	                  }
	                  if(isfee){
	                	prpLdangerItemNewDto.setSumFee(Str.round((lchargeDto.getChargeAmount()-lchargeDto.getSumRealPay()),2));
	                	prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }else{
	                	prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
	                  }
	                   prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // ������
				
	                   sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// ���뼯��
					if (prpLdangerItemNewDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // ���DTO
			boolean find = true;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itTot = dangerTotList.iterator();
					while (itTot.hasNext()) {
						prpLdangerTotNewDto = (PrpLdangerTotDto) itTot.next();
						if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerTotNewDto.setSumPaid(Str.round(prpLdangerTotNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumPaidEx(Str.round(prpLdangerTotNewDto.getSumPaidEx() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerTotNewDto.setSumFee(Str.round(prpLdangerTotNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
		       				prpLdangerTotNewDto.setSumFeeEx(Str.round(prpLdangerTotNewDto.getSumFeeEx()+prpLdangerItemNewDto.getSumFee(),2));
							break;
						}
					}
					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // ���ԭ�ұ�
						prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto
								.getSumPaid());
						// ���뼯��
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3������Σ�յ�λprpLdangerUnit
			com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit dbPrpLdangerUnit = null ;
			Iterator itUnit = null;
			PrpLdangerUnitDto prpLdangerUnitNewDto = null;
			if (dangerItemList != null) {
				iterator = dangerItemList.iterator();
				while (iterator.hasNext()) {
					prpLdangerItemNewDto = (PrpLdangerItemDto) iterator.next();
					find = false;
					itUnit = dangerUnitList.iterator();
					while (itUnit.hasNext()) {
						prpLdangerUnitNewDto = (PrpLdangerUnitDto) itUnit.next();
						if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo()) {
							find = true;
							prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid() + prpLdangerItemNewDto.getSumPaid(), 2));
							prpLdangerUnitNewDto.setSumFee(Str.round(prpLdangerUnitNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
		       				prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
							break;
						}
					}

					// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
					if (find == false) {

						prpLdangerUnitNewDto = new PrpLdangerUnitDto();
						prpLdangerUnitNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerUnitNewDto.setClaimNo(compensateDto
								.getPrpLcompensateDto().getClaimNo());
						prpLdangerUnitNewDto.setCertiType("3");
						prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto.getRiskCode());
						prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto.getPolicyno());
						prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto.getDangerdesc());
						prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto.getAddressName());
						prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerUnitNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						dbPrpLdangerUnit = new com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit();
						dbPrpLdangerUnit.getInfo(compensateDto.getPrpLcompensateDto().getCaseNo(), ""+prpLdangerUnitNewDto.getDangerNo());
						if(!"".equals(dbPrpLdangerUnit.getSumLoss()) && !"".equals(prpLdangerItemNewDto.getSumPaid())){
    						prpLdangerUnitNewDto.setSumNoPaid(Double.parseDouble(dbPrpLdangerUnit.getSumLoss()) - prpLdangerItemNewDto.getSumPaid());
    					}
						prpLdangerUnitNewDto.setCoinsFlag(strCoinsFlag);
						prpLdangerUnitNewDto.setDamageDate(compensateDto
								.getPrpLcompensateDto().getDamageStartDate());
						// prpLdangerUnitNewDto.setAgricultureflag(prpCmainDto.getBusinessType1());
						prpLdangerUnitNewDto
								.setBusinessNature(prpLdangerBusinessNature[1]);
						prpLdangerUnitNewDto
								.setPolicyBizType(prpLdangerPolicyBizType[1]);
						prpLdangerUnitNewDto
								.setPolicyType(prpLdangerPolicyType[1]);
						prpLdangerUnitNewDto
								.setBusinessType(prpLdangerBusinessType[1]);
						prpLdangerUnitNewDto
								.setBusinessType1(prpLdangerBusinessType1[1]);
						prpLdangerUnitNewDto.setOthFlag(prpLdangerOthFlag[1]);
						prpLdangerUnitNewDto
								.setBusinessProvince(prpLdangerBusinessProvince[1]);
						prpLdangerUnitNewDto
								.setBusinessTown(prpLdangerBusinessTown[1]);
						prpLdangerUnitNewDto
								.setBusinessCounty(prpLdangerBusinessCounty[1]);
						prpLdangerUnitNewDto
								.setBusinessAreaName(prpLdangerBusinessAreaName[1]);
						// ���뼯��
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// ���һ��ռ�ȼ���ԭ��
				double dangerShare = 0;
				double tempSumDangerShare = 0;
				ClaimDto claimDto = new ClaimDto();
				UIClaimAction uiclaimAction = new UIClaimAction();
				claimDto = uiclaimAction.findByPrimaryKey(compensateDto
						.getPrpLcompensateDto().getClaimNo());
				double tempSumLoss = 0;
				double temSumFee=0;
				double sumTempSumLoss = 0;
				double tempSumNoPaid = 0;
				double sumTempNoPaid = 0;
				PrpLdangerUnitDto prpLdangerUnitDtotemp = null;
				for (int i = 0; i < dangerUnitList.size(); i++) {
					prpLdangerUnitDtotemp = (PrpLdangerUnitDto) dangerUnitList.get(i);
					if (i == (dangerUnitList.size() - 1)) {
						dangerShare = Str.round(100 - tempSumDangerShare, 2);
						tempSumNoPaid = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid() - sumTempNoPaid, 2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim() - sumTempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					} else {
						dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid() / sumDangerUnit * 100, 2);
						tempSumDangerShare = Str.round(tempSumDangerShare + dangerShare, 2);
						tempSumNoPaid = Str.round((claimDto.getPrpLclaimDto().getSumClaim() - claimDto.getPrpLclaimDto().getSumPaid()) * dangerShare / 100, 2);
						sumTempNoPaid = Str.round(sumTempSumLoss + tempSumLoss,2);
						tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim() * dangerShare / 100, 2);
						sumTempSumLoss = Str.round(sumTempSumLoss + tempSumLoss, 2);
						temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
					}
					prpLdangerUnitDtotemp.setDangerShare(dangerShare);
					prpLdangerUnitDtotemp.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
					prpLdangerUnitDtotemp.setSumLoss(tempSumLoss);
					prpLdangerUnitDtotemp.setSumFee(temSumFee);
					if ("1".equals(prpLcompensateFinallyFlag)) {
						prpLdangerUnitDtotemp.setSumNoPaid(0); // �᰸ δ���������
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(
								prpLdangerUnitDtotemp.getSumNoPaid()
										- compensateDto.getPrpLcompensateDto()
												.getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
			// end------------------------------------*/
		}
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));
		compensateDto.getPrpLcompensateDto().setFinallyFlag(
				prpLcompensateFinallyFlag);
		return compensateDto;

	}

	/**
	 * ���������������б�ѡ��
	 * 
	 * @return
	 */
	private Collection getCompensateResultList() {
		return ICollections.getCompensateResultList();
	}

	// yx
	public boolean checkRiskVersion(String configCode, String riskCode,
			String policyNo) {
		UIConfigAction uiConfigAction = new UIConfigAction();
		DateTime versionDate = new DateTime();
		DateTime underWriteDate = new DateTime();
		try {
			versionDate = new DateTime(uiConfigAction.getConfigValue(
					configCode, riskCode));
			BLPrpCmain blPrpCmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			blPrpCmain.getData(policyNo);
			if (blPrpCmain.getSize() == 1) {
				prpCmainSchema = blPrpCmain.getArr(0);
			}
			underWriteDate = new DateTime(prpCmainSchema.getUnderWriteEndDate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (underWriteDate.before(versionDate)) {
			return true;
		} else {
			return false;
		}
	}
}
