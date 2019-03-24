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
	 * 默认构造方法
	 */
	public AccidentCompensateViewHelper() {
	}

	/**
	 * 取初始化信息需要的数据的整理. 填写实赔单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 * @return compensateDto 取初始化信息需要的数据
	 * @throws Exception
	 */

	public CompensateDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		CompensateDto compensateDto = new CompensateDto();
		return compensateDto;
	}

	/**
	 * 填写实赔页面及查询实赔request的生成.
	 * 填写实赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception {
		// 得到request的PrpLcompensateForm用于显示
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();
		// 意外健康险默认是，车险、财产险、责任险、货船险默认否

		if (prpLcompensateDto.getFinallyFlag().trim().equals("")) {
			// modify by 项目组 孙兆云 27险类修改为07
			if (prpLcompensateDto.getClassCode().equals("27"))
				prpLcompensateDto.setFinallyFlag("1");
			else
				prpLcompensateDto.setFinallyFlag("0");
		}
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}

	/**
	 * 非车险 出新的赔款计算数的时候初始化赔付标的的信息
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
	 * 非车险 出新的赔款计算数的时候初始化赔付标的的信息
	 * 
	 * @throws Exception
	 */
	public ArrayList initPersonLossItem(HttpServletRequest httpServletRequest,
			String claimNo, ClaimDto claimDto) throws Exception {
		return new ArrayList();
		// add by caoshengbin end
	}

	/**
	 * 非车险 出新的赔款计算数的时候初始化赔付标的的信息
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
		// 增加团单的处理，如果是团单，amount要从prpcvirturlitem里去取值
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
	 * 农险带数：带出被保险人信息
	 * 
	 * @param httpServletRequest
	 * @param claimNo
	 *            立案号
	 * @param claimDto
	 *            立案信息
	 * @return 定损环节录入的受损分户信息
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
	 * 农险带数：带出被保险人信息
	 * 
	 * @param httpServletRequest
	 * @param claimNo
	 *            立案号
	 * @param claimDto
	 *            立案信息
	 * @return 定损环节录入的受损分户信息
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
	 * 填写实赔页面及查询实赔request的生成.
	 * 填写实赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param PrpLcompensateDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void claimDtoToView(HttpServletRequest httpServletRequest,
			String claimNo, String editType) throws Exception {
		// 特殊赔案标志
		String caseType = httpServletRequest.getParameter("caseType");// 特殊赔案标志
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		// 设置claimDto中所有估损险别的险别名称
		setClaimLossKindName(claimDto);
		// 将事故者和索赔申请人信息压到页面上
		ArrayList prplacciBenPersonDtoList = claimDto
				.getPrplacciBenPersonDtoList();
		ArrayList prplacciPersonDtoList = claimDto.getPrpLacciPersonDtoList();
		PrpLacciPersonDto prpLacciBenPersonDto = new PrpLacciPersonDto();
		prpLacciBenPersonDto.setPrpLacciBenPersonList(prplacciBenPersonDtoList);
		if (prpLacciBenPersonDto.getPrpLagriPersonList() == null) {
			prpLacciBenPersonDto
					.setPrpLagriPersonList(prplacciBenPersonDtoList);
		}
		prpLacciBenPersonDto.setPrpLacciPersonList(prplacciPersonDtoList); // 索赔申请人模块
		httpServletRequest.setAttribute("prpLacciPersonDto",
				prpLacciBenPersonDto);
		httpServletRequest.setAttribute("prpLclaimDto", claimDto
				.getPrpLclaimDto());

		// modify by wangwei add start 2005-06-10
		// 原因：要在界面上显示一些立案信息
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);
		// modify by wangwei add end 2005-06-10

		// add by huangyunzhong 20051128 得到是否重开赔案
		int recount = 0;
		double sumDamageInsured = 0.00;
		double dbSumPaid = 0.00;
		double dbLossNumber = 0.00;
		double dbSumDutyPaid = 0.00;
		ReCaseDto reCaseDto = new ReCaseDto();
		PrpLrecaseDto prpLrecaseDto = new PrpLrecaseDto();
		// 查询重开赔案信息
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

		// 赔款计算书主信息
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();

		// 带出调查费用合计值-----------------------------------------------------------
		String riskCode = claimDto.getPrpLclaimDto().getRiskCode();
		String prplregistNo = claimDto.getPrpLclaimDto().getRegistNo();
		BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = bLPrpLregistFacade
				.findByPrimaryKey(prplregistNo);
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

		String taskCode = SysConfig.getProperty("FamilySplittingFlag", "claim");
		if (taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();// 耳标清单列表
			if (prplregistNo != null) {
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
						.getPrpLCompensateEarDtos(prplregistNo, "claim",
								prplregistNo);
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList",
					prplCompensateEarDtoList);// 设置耳标号清单列表
			httpServletRequest.setAttribute("familySplittingFlag", "true");// 设置耳标号清单列表
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

		// 特殊赔案标志
		if (caseType != null) {
			prpLcompensateDto.setCaseType(caseType);

		} else {
			// 正常的流程，进行赔付
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
		// 设置实赔操作的状态为 新案件登记 (未处理任务)
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
		// 添加报案号 2005-08-07
		prpLcompensateDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
		/** add by wuzheng 增加医疗类型 健康险统计专用 20080601 */
		prpLcompensateDto.setMedicalType(claimDto.getPrpLclaimDto()
				.getMedicalType());

		// 查询预赔信息
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
						throw new UserException(1, 3, "123", "还有未核赔通过的预赔案件");
					}
				}
			}
		}

		prpLcompensateDto.setSumPrePaid(sumPrePaid);
		prpLcompensateDto.setSumPreChargeAmount(preSosMedicFee);
		// 添加案件性质 2005-08-01
		uiCodeAction = new UICodeAction();
		prpLcompensateDto.setCaseType(claimDto.getPrpLclaimDto().getCaseType());
		prpLcompensateDto.setCaseTypeName(uiCodeAction.translateCodeCode(
				"CaseCode", claimDto.getPrpLclaimDto().getCaseType(), true));
		// 添加案件类型 2005-08-03
		prpLcompensateDto.setClaimType(claimDto.getPrpLclaimDto()
				.getClaimType());
		prpLcompensateDto.setClaimTypeName(uiCodeAction.translateCodeCode(
				"CaseCode", claimDto.getPrpLclaimDto().getClaimType(), true));
		// 货运险添加赔付对象 2005-9-23
		prpLcompensateDto
				.setCounterClaimerName((claimDto.getPrpLextDto() == null) ? ""
						: claimDto.getPrpLextDto().getSalvor());
		String strRiskType = uiCodeAction
				.translateRiskCodetoRiskType(prpLcompensateDto.getRiskCode());
		// add by wunier 20080103
		// reason:添加农险改造所需要的新的属性
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
		// //如果赔付数量不为0说明存在核损环节并且在核损环节录入了数据
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
		// 如果为0则说明存在核损环节但是没有录入数据，那么就从立案带过来
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
		// 如果certainLossDto没有数据说明该险种没有定损这个环节,那么就从立案带过来
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

		// 是否案终赔付：意外健康险,财产险、责任险、默认是，车险、货船险默认否。 2005-9-16
		if ("E".equals(strRiskType)) {
			prpLcompensateDto.setFinallyFlag("1");
		}
		if ("D".equals(strRiskType)) {
			prpLcompensateDto.setFinallyFlag("0");
		}

		if (prpLcompensateDto.getResult() == null
				|| prpLcompensateDto.getResult().trim().length() == 0) {
			// 设置理赔结论的默认值
			prpLcompensateDto.setResult(prpLcompensateDto
					.getDefaultCompensateResult());
		}

		PolicyDto policyDto = null;
		PrpCitemKindDto prpCitemKindDto = null;
		if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			policyDto = endorseViewHelper.findForEndorBefore(claimDto
					.getPrpLclaimDto().getPolicyNo(), claimDto
					.getPrpLclaimDto().getDamageStartDate().toString(),
					claimDto.getPrpLclaimDto().getDamageStartHour());

			PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();

			// 取被保险人名称，对于团单需要显示名称
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
						+ "等" + insureQuantity + "人";
			}
			prpLcompensateDto.setInsuredNameShow(strInsuredNameShow);
			// 承保户次
			prpLcompensateDto.setSumInsured(policyDto.getPrpCmainDto()
					.getSumInsured());
			// add by lixiang start at 20051227
			// reason: 增加投保人的信息
			prpLcompensateDto.setAppliName(policyDto.getPrpCmainDto()
					.getAppliName());
			// add by lixiang end at 20051227

			String defaultKindCode = new DAAClaimViewHelper()
					.getDefaultKindCodeByPolicyDto(policyDto);
			httpServletRequest.setAttribute("defaultKindCode", defaultKindCode); // 获得保单默认的险别

			httpServletRequest.setAttribute("shareHolderFlag", policyDto
					.getPrpCmainDto().getShareHolderFlag());

			httpServletRequest.setAttribute("statQuantity", policyDto
					.getPrpCmainDto().getStatQuantity());
			// -------------------------------------------------------------------------------------------
			// 按保单上事故者所保的险别查找历史赔付额
			// 获取事故者的分户序号,根据分户序号查找所保险别
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
					// 根据安信理赔的特殊情况，在理算取保单信息时直接取当时最新保单信息，不进行倒批单
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
							// 累加历史记录金额
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
		// 获取兑换率信息
		Collection prpdexchDtoList = new ArrayList();
		UIExchAction uiExchAction = new UIExchAction();

		prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime()
				.current().toString().substring(0, 10));
		httpServletRequest.setAttribute("prpdexchDtoList", prpdexchDtoList);

		// 赋值初始的计算书Times信息
		String conditions = " ClaimNo= '" + claimNo + "'";
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Collection prplCompensateListTemp = uiCompensateAction
				.findByConditions(conditions);
		if (prplCompensateListTemp != null) {
			prpLcompensateDto.setTimes(prplCompensateListTemp.size() + 1);
		} else {
			prpLcompensateDto.setTimes(1);
		}

		// 初始化标的（从定核损带过来）
		ArrayList prpLlossListTemp = new ArrayList();
		ArrayList prpLpersonLossListTemp = new ArrayList();
		CompensateDto compensateDto = new CompensateDto();
		// 初始化标的从定损带数据 条件：新增理算并且不是重开赔案的理算
		if (editType.trim().equals("ADD") && recount != 1) {
			String riskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);
			// 农险理算环节带数
			if (riskType.equals("H") || riskType.equals("I")) {
				// 标的损失信息带数
				prpLlossListTemp = initPropLossItemAgri(claimNo, claimDto);

				// 被保险人信息带数（若有分户信息，需带出）
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
		// 设值文本的内容
		httpServletRequest.setAttribute("prpLctextDto1", prpLctextDto1);
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		// 设值文本的内容
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		PrpLctextDto prpLctextPayTextDto = new PrpLctextDto();
		String payText = "";
		payText += "请将赔款      付给\r\n";
		payText += "单位:\r\n";
		payText += "开户行:\r\n";
		payText += "帐号:\r\n";
		payText += "付讫日期及方式:\r\n";
		prpLctextPayTextDto.setTextType(PAY_TEXT);
		prpLctextPayTextDto.setContext(payText);

		// 设值文本的内容
		httpServletRequest.setAttribute("prpLctextPayTextDto",
				prpLctextPayTextDto);

		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcompensateDto.getPolicyNo(), claimDto.getPrpLclaimDto()
						.getRegistNo());

		// 设置主实赔信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

		// 在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLcompensateDto.getRiskCode(), true));
		httpServletRequest.setAttribute("riskType", strRiskType);
		// 设置各个子表信息项到窗体表单
		compensateDto.setPrpLcompensateDto(prpLcompensateDto);
		compensateDto = uiCompensateAction
				.findByAppendInformation(compensateDto);
		String policyNo = prpLcompensateDto.getPolicyNo();
		int intPayFee = this.checkPay(httpServletRequest, policyNo);

		prpLcompensateDto.setPayFee(intPayFee);
		// reason:获取危险单位信息
		UIRiskUnitAction blPrpCdangerUnitFacade = new UIRiskUnitAction();
		PrpLdangerUnitDto prpLdangerUnitDto = blPrpCdangerUnitFacade
				.findByPrimaryKeyFromPrpLdangerUnit(prpLcompensateDto
						.getClaimNo(), 1, httpServletRequest, claimDto
						.getPrpLclaimDto().getRiskCode(), 0);
		if (prpLdangerUnitDto == null) {
			prpLdangerUnitDto = new PrpLdangerUnitDto();
		}
		prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(
				prpLdangerUnitDto.getCurrency(), true)); // 用此字段表示币别中文信息
		httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);

		// 得到共保和股东业务信息临分信息
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
			text = "一、被保险人概况" + "\r\n";
			text = text + "二、事故经过及原因调查" + "\r\n";
			text = text + "三、认定责任" + "\r\n";
			text = text + "四、足额投保" + "\r";
			text = text + "五、是否存在重复投保及向第三者追偿前景" + "\r\n";
			text = text + "六、索赔及定损" + "\r\n";
			text = text + "七、总结和赔付";
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
				text = text + "耳标号：" + prplCompensateEarDtoTemp.getEarno()
						+ " 赔付金额=" + claimloss + "\r\n";
			}
			text = text + "\r\n" + "总赔付金额=" + sumloss;

		}
		prpLltextDto.setTextType("08");
		prpLltextDto.setContext(text);
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		httpServletRequest.setAttribute("prpLltextDto3", claimDto
				.getPrpLltextDtoList3());
		// 设置理赔结论列表
		httpServletRequest.setAttribute("compensateResultMap",
				getCompensateResultList());

		// 将调查费默认为费用信息中的查勘费
		PrpLchargeDto prpLchargeDto = getDefaultPrpLchargeFromAcciCheckFee(claimDto);

		if (prpLchargeDto != null) {
			Collection prpLchargeList = new ArrayList();
			prpLchargeList.add(prpLchargeDto);

			prpLchargeDto.setPrpLchargeList(prpLchargeList);
			httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);

			// 设置理算对象中的赔款费用值为调查费
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
		// 获得意健险的多次调查费用之和
		double sumAcciCheckFee = new BLPrpLacciCheckFacade()
				.getAcciCheckFeeByRegistNo(claimDto.getPrpLclaimDto()
						.getRegistNo());
		PrpLchargeDto prpLchargeDto = null;

		if (sumAcciCheckFee > 0) {
			prpLchargeDto = new PrpLchargeDto();
			// 设置默认的序列为1
			prpLchargeDto.setSerialNo(1);

			// 设置默认的险别代码和险别名称为立案时的险别名称和险别代码;
			List claimLossList = claimDto.getPrpLclaimLossDtoList();
			if (claimLossList != null && claimLossList.size() > 0) {
				PrpLclaimLossDto claimLoss = (PrpLclaimLossDto) claimLossList
						.get(0);
				prpLchargeDto.setKindCode(claimLoss.getKindCode());
				prpLchargeDto.setKindName(claimLoss.getKindName());
			}
			// 设置默认的费用类别为04-查勘费
			prpLchargeDto.setChargeCode("04");
			prpLchargeDto.setChargeName("查勘费");

			// 设置默认的币别为CNY-人民币
			prpLchargeDto.setCurrency("CNY");
			prpLchargeDto.setCurrencyName("人民币");

			// 设置费用为调查费
			prpLchargeDto.setChargeAmount(sumAcciCheckFee);

			// 设置计入赔款金额为0
			prpLchargeDto.setSumRealPay(0);
		}
		return prpLchargeDto;
	}

	/**
	 * 设置ClaimDto中的
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
	 * 设置PrpLclaimLossDto的险别名称(根据它的险别代码)
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
	 * 根据赔款计算书号查询预赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @throws Exception
	 */

	public void compensateDtoView(HttpServletRequest httpServletRequest,
			String compensateNo, String editType) throws Exception {

		ClaimDto claimDto = null;
		UICodeAction uiCodeAction = new UICodeAction();
		String prpltextForEar = "";

		// 特殊赔案标志,从工作流上获得。
		String riskType = "";
		String caseType = httpServletRequest.getParameter("caseType");
		UICompensateAction uiCompensateAction = new UICompensateAction();
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(
				compensateNo, caseType);

		// 赔款计算书主信息
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();
		prpLcompensateDto.setEditType(editType.trim());
		String riskcodefortemp = prpLcompensateDto.getRiskCode();

		// add by miaowenjun 20070130 显示的时候去掉间接理赔费用 start
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
		// add by miaowenjun 20070130 显示的时候去掉间接理赔费用 end

		// add by huangyunzhong 20051128 得到是否重开赔案
		String claimNo = prpLcompensateDto.getClaimNo().trim();
		int recount = 0;
		double sumDamageInsured = 0.00;
		double dbSumPaid = 0.00;
		double dbLossNumber = 0.00;
		double dbSumDutyPaid = 0.00;
		ReCaseDto reCaseDto = new ReCaseDto();
		PrpLrecaseDto prpLrecaseDto = new PrpLrecaseDto();
		// 查询重开赔案信息
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

		// 得到币别中文名称
		prpLcompensateDto.setCurrencyName(uiCodeAction.translateCurrencyCode(
				prpLcompensateDto.getCurrency(), true));
		// 设置实赔操作的状态为 案件修改 (正处理任务)
		if (compensateDto.getPrpLclaimStatusDto() != null) {
			// 设置初始化的内容
			prpLcompensateDto = compensateDto.getPrpLcompensateDto();

			if (compensateDto.getPrpLclaimStatusDto().getStatus().equals("7"))
				compensateDto.getPrpLclaimStatusDto().setStatus("3");
			prpLcompensateDto.setStatus(compensateDto.getPrpLclaimStatusDto()
					.getStatus());
		} else {

			// 已提交，已经处理完毕的状态
			prpLcompensateDto.setStatus("4");
		}
		String status = httpServletRequest.getParameter("status");// 从工作流上去状态
		if (status != null && !status.equals(""))
			prpLcompensateDto.setStatus(status);

		// add by liubvo 20040601
		if (!compensateDto.getPrpLcompensateDto().getClaimNo().equals("")) {
			// 查询保单信息
			UIClaimAction uiClaimAction = new UIClaimAction();
			claimDto = uiClaimAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getClaimNo());

			// 带出调查费用合计值-----------------------------------------------------------
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

			// 添加出险原因 2005-08-02
			prpLcompensateDto.setDamageName(prpLclaimDto.getDamageName());

			// 添加案件类型 2005-08-03
			prpLcompensateDto.setClaimType(prpLclaimDto.getClaimType());
			prpLcompensateDto.setClaimTypeName(uiCodeAction.translateCodeCode(
					"CaseCode", prpLclaimDto.getClaimType(), true));

			// 添加报案号 2005-08-07
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
							throw new UserException(1, 3, "123", "还有未核赔通过的预赔案件");
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
				ArrayList prplCompensateEarDtoList = new ArrayList();// 耳标清单列表
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
						prpltextForEar = prpltextForEar + "耳标号："
								+ prplCompensateEarDtotemp2.getEarno()
								+ " 赔付金额=" + claimloss + "\r\n";
					}
					// DecimalFormat df = new DecimalFormat("#.00");
					// String sumloss1 = df.format(sumloss);
					sumloss = (double) (Math.round(sumloss * 100) / 100.0);// 增加理算报告初始化时的四舍五入保留两位小数的操作。
					prpltextForEar = prpltextForEar + "\r\n" + "总赔付金额="
							+ sumloss;

				}
				httpServletRequest.setAttribute("prplCompensateEarDtoList",
						prplCompensateEarDtoList);// 设置耳标号清单列表
				httpServletRequest.setAttribute("familySplittingFlag", "true");// 设置耳标号清单列表
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

		// 获取兑换率信息
		Collection prpdexchDtoList = new ArrayList();
		UIExchAction uiExchAction = new UIExchAction();
		prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime()
				.current().toString().substring(0, 10));
		httpServletRequest.setAttribute("prpdexchDtoList", prpdexchDtoList);
		if (!compensateDto.getPrpLcompensateDto().getPolicyNo().equals("")) {
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					compensateDto.getPrpLcompensateDto().getPolicyNo(),
					prpLcompensateDto.getDamageStartDate().toString(),
					prpLcompensateDto.getDamageStartHour());
			// PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
			if ("E".equals(riskType)) {

				// 获取事故者的分户序号,根据分户序号查找所保险别
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
						// 根据安信理赔的特殊情况，在理算取保单信息时直接取当时最新保单信息，不进行倒批单
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
								// 累加历史记录金额
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
			// 得到共保和股东业务信息临分信息
			httpServletRequest.setAttribute("statQuantity", policyDto
					.getPrpCmainDto().getStatQuantity());
			httpServletRequest.setAttribute("shareHolderFlag", policyDto
					.getPrpCmainDto().getShareHolderFlag());
			if (policyDto != null) {

				String defaultKindCode = new DAAClaimViewHelper()
						.getDefaultKindCodeByPolicyDto(policyDto);
				httpServletRequest.setAttribute("defaultKindCode",
						defaultKindCode);

				// 取被保险人名称，对于团单需要显示名称
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
							+ "等" + insureQuantity + "人";
				}
				prpLcompensateDto.setInsuredNameShow(strInsuredNameShow);
				prpLcompensateDto.setSumInsured(policyDto.getPrpCmainDto()
						.getSumInsured());

				// add by lixiang start at 20051227
				// reason: 增加投保人的信息
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
				// reason:获取危险单位信息
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
								true)); // 用此字段表示币别中文信息
				httpServletRequest.setAttribute("prpLdangerUnitDto",
						prpLdangerUnitDto);
				// add by qinyongli end 2005-8-16
			} else {
				// ******---------------------获取危险单位信息 国元项目组
				// start-----------------------------------*/
				BLDangerUnitFacade blDangerFacade = new BLDangerUnitFacade();
				List prpLdangerUnitList = new ArrayList();
				prpLdangerUnitList = blDangerFacade
						.getPrpLdangerUnit(compensateNo);
				httpServletRequest.setAttribute("prpLdangerUnitList",
						prpLdangerUnitList);
				// ******---------------------获取危险单位信息 国元项目组
				// end-----------------------------------*/
			}

			/*
			 * if(policyDto.getPrpCitemCarDtoList().size()>0) { //对车型等信息的支持
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

		// 意外健康险默认是，车险、财产险、责任险、货船险默认否

		if (prpLcompensateDto.getFinallyFlag().trim().equals("")) { // modify by
			// 项目组 孙兆云
			// 27险类修改为07
			if ("E".equals(riskType))
				// || prpLcompensateDto.getClassCode().equals("07")
				// || prpLcompensateDto.getClassCode().equals("06"))
				prpLcompensateDto.setFinallyFlag("1");
			else
				prpLcompensateDto.setFinallyFlag("0");
		}

		// 理算报告的信息
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

		// 付款说明
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

		// 结案报告
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

		// 查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcompensateDto.getPolicyNo(), claimDto.getPrpLclaimDto()
						.getRegistNo());

		httpServletRequest.setAttribute("prpLqualityCheckList", compensateDto
				.getPrpLqualityCheckList());

		// 添加案件性质 2005-08-01
		prpLcompensateDto.setCaseType(compensateDto.getPrpLcompensateDto()
				.getCaseType());
		prpLcompensateDto.setCaseTypeName(uiCodeAction.translateCodeCode(
				"CaseCode",
				compensateDto.getPrpLcompensateDto().getClaimType(), true));

		// 设置主实赔信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

		// 在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLcompensateDto.getRiskCode(), true));
		httpServletRequest.setAttribute("riskType", riskType);

		// ------------------------
		PrpLclaimDto prpLclaimDto = compensateDto.getPrpLclaimDto();
		PrpLacciPersonDto prpLacciPersonDto = new PrpLacciPersonDto();
		// 将事故者信息、索赔申请人、赔付被保险人信息压到页面上
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

		// 设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest, compensateDto);
		// 设置理赔结论列表
		httpServletRequest.setAttribute("compensateResultMap",
				getCompensateResultList());

	}

	public CompensateDto viewToDtoForJprop(HttpServletRequest httpServletRequest)
			throws Exception {

		// 继承对compensate,compensateText表的赋值
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));
		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		/*---------------------赔付标的信息prpLlossDto------------------------------------*/
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;
		// 加入危险单位处理 add by qinyongli 2005-9-10
		// reason: 目前只有一个危险单位，所以和标的信息放在一起处理，如果，有多个危险单位必须放入危险单位信息里面处理！
		ArrayList prpLprpLdangerTotList = new ArrayList(); // 理赔危险单位金额合计信息
		ArrayList prpLprpLdangerItemList = new ArrayList(); // 理赔的危险单位信息表
		PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // 金额合计Dto
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // 标的DTO
		int dangerItemSerialNo = 1; // 用于存储标的的序号

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

		// 对象赋值
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

						prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// 在prplloss表中用flag存对应人员序号
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
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3与curreny4相等(终端逻辑)
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
					// 加入危险单位收集 add by qinyongli 2005-9-10
					prpLdangerItemDto = new PrpLdangerItemDto();
					prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // 实赔号
					prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
					prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]); // 损失币别
					prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemDto.setKindName("正常"); // 险别归类名称
					prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); // 险别
					prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
					dangerItemSerialNo++;
					prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils
							.nullToZero(prpLlossDtoSumRealPay[index])));// 已决赔款
					prpLprpLdangerItemList.add(prpLdangerItemDto);
					// add by qinyongli end 2005-9-10
				}
				// 加入集合
				prpLlossDtoList.add(prpLlossDto);
			}
		}
		// 赔付标的信息
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);

		/*---------------------赔付被保险人信息 begin ------------------------------------*/
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
				prpLagriPersonDto.setCertiType("04"); // 农险团单存赔付被保险人
				prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLagriPersonDto.setSerialNo(Integer
						.parseInt(prpLlossDtoSerialNo[index2]));
				if (prpLlossDtoFamilyNo[index2] != null
						&& !prpLlossDtoFamilyNo[index2].equals("")) {
					intFamilyNo = Integer.parseInt(prpLlossDtoFamilyNo[index2]);
					strFamilyName = prpLlossDtoFamilyName[index2];
				} else {
					// 这里AcciName是非空字段，但对于个单来说，可能不选择相应被保险人，所用先被保险人名称进行存储
					intFamilyNo = 2;
					strFamilyName = httpServletRequest
							.getParameter("prpLcompensateInsuredName");
				}
				//
				prpLagriPersonDto.setFamilyNo(intFamilyNo);
				prpLagriPersonDto.setAcciCode(prpLclaimLossAcciCode[index2]);
				prpLagriPersonDto.setAcciName(strFamilyName);// 存赔付被保险
				prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // 存赔付牛号
				prpLagriPersonDto.setFlag("");
				prpLagriPersonDto.setAge(0);
				prpLagriPersonDto.setSex("");
				prpLagriPersonDto.setIdentifyNumber("");
				// 加入集合
				prpLagriPersonList.add(prpLagriPersonDto);
			}
		}

		compensateDto.setPrpLagriPersonDtoList(prpLagriPersonList);

		/*---------------------赔付被保险人信息 end ------------------------------------*/

		/*---------------------赔款费用信息prpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// 从界面得到输入数组
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

		// 对象赋值
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
					// 加入危险单位收集 add by qinyongli 2005-9-10
					PrpLdangerItemDto prpLdangerItemChargeDto = new PrpLdangerItemDto();
					prpLdangerItemChargeDto.setCertiNo(prpLchargeCompensateNo); // 实赔号
					prpLdangerItemChargeDto.setDangerNo(1); // 目前只有一个危险单位
					prpLdangerItemChargeDto
							.setCurrency(prpLchargeCurrency[index]); // 损失币别
					prpLdangerItemChargeDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemChargeDto.setKindName("正常"); // 险别归类名称
					prpLdangerItemChargeDto.setRiskCode(prpLchargeRiskCode); // 险别
					prpLdangerItemChargeDto.setSerialNo(dangerItemSerialNo); // 标的序号
					dangerItemSerialNo++;
					prpLdangerItemChargeDto.setSumFee(Double
							.parseDouble(DataUtils
									.nullToZero(prpLchargeSumRealPay[index])));
					// 已决赔款
					prpLprpLdangerItemList.add(prpLdangerItemChargeDto);
					// add by qinyongli end 2005-9-10
				}
				// 加入集合
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// 赔款费用信息
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// 从界面得到输入数组
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
		// 对象赋值
		// 赔款计算金额信息
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
		// 如果案件属于案终赔付，则需要结案报告文本
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");

		ArrayList prpLltextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLltextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// 得到连接串,下面将其切分到数组
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
			// ----------------------------危险单位信息处理,目前只有一个危险单位
			String TCurrency = httpServletRequest.getParameter("MergeCurrency");
			// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10
			compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
			// 对标的信息进行处理，得到合计信息
			ArrayList itemListAll = (ArrayList) prpLprpLdangerItemList.clone();
			ArrayList itemList = (ArrayList) prpLprpLdangerItemList.clone();
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto(); // 获取每个标的对象
			PrpLdangerItemDto dangerItem = new PrpLdangerItemDto(); // 循环判断时使用
			ArrayList tempCurrency = new ArrayList();
			Iterator itemListIteratorAll = itemListAll.iterator();
			Iterator itemListIterator = itemList.iterator();
			PrpLdangerItemDto dangerItemAll1 = new PrpLdangerItemDto();
			while (itemListIteratorAll.hasNext()) {
				dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll.next();
				dangerItemAll1 = new PrpLdangerItemDto();
				dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
				dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());

				// 用当前币别遍历集合进行统计
				String currentCur = dangerItemAll1.getCurrency();
				if (tempCurrency.contains(currentCur)) {
					continue; // 如果已经合计过的币种，不再进行合计;
				}
				int currentSerial = dangerItemAll1.getSerialNo();
				while (itemListIterator.hasNext()) {
					dangerItem = (PrpLdangerItemDto) itemListIterator.next();
					// 如果币别相等，则对赔偿金额和费用进行累加
					if (currentSerial != dangerItem.getSerialNo()
							&& currentCur.equals(dangerItem.getCurrency())) {
						dangerItemAll1.setSumFee(dangerItemAll1.getSumFee()
								+ dangerItem.getSumFee()); // 合计费用
						dangerItemAll1.setSumPaid(dangerItemAll1.getSumPaid()
								+ dangerItem.getSumPaid()); // 合计金额
					}
				}
				tempCurrency.add(currentCur); // 将当前合计的币种暂存 ;
				// 将标的信息加入合计Dto
				if (dangerItemAll != null) {
					prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
					prpLdangerTotDto.setDangerNo(1); // 目前，就一个危险单位
					prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); // 标的原币别
					prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
					prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
					prpLdangerTotDto.setTCurrency(TCurrency);
					// 进行币别转化 转化后的币别为TCurrency
					String SCurrency = dangerItemAll.getCurrency(); // 原币别
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
			// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10 end
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061130 start reason 给再保送数据
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061130 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// 从界面得到输入数组
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
			// 对象赋值
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
					// 从立案获取实赔
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
						prpLdangerUnitDto.setCertiType("3");// 案终为实赔
						prpLdangerUnitDto.setSumNoPaid(0); // 结案 未决赔款置零
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
					// 加入集合
					if (prpLdangerPolicyNo[index] != null
							&& !(prpLdangerPolicyNo[index].equals(""))) {
						dangerUnitList.add(prpLdangerUnitDto);
					}
				}
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {

			// ******---------------------危险单位信息 国元项目组
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
			// 从界面得到输入数组

			String prpLdangerCompensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");// 理算书号

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");// 保单号
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");// 险种号
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");// 危险单位描述
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");// 危险单位地址
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");// 币别
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");// 赔付金额
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");// 危险单位号
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");// 占比
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");// 险别代码
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");// 险别名称
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");// 标的代码
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");// 标的名称
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// 标的序号

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// 业务来源
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// 保单业务类型
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// 投保方式
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// 政策性标志
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// 涉农标识
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// 其他标识字段
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// 归属区域省
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// 归属区域市
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// 归属区域县
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// 归属区域乡镇
			// 1、生成此赔款危险单位标的prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto(); // 标的DTO
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer
							.parseInt(prpLdangerDangerNo[index])); // 危险单位
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); // 损失币别
					prpLdangerItemNewDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); // 险别
					prpLdangerItemNewDto
							.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto
							.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					// 占比最后一个减法原则
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
					isfee = false; //是否有费用，如果有则拆分到对应的险别代码和标的代码
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
	                   prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
				
	                   sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// 加入集合
					if (prpLdangerItemDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // 标的DTO
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
					// 每个危险单位标的的第一次数据的生成
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemDto.getCurrency()); // 标的原币别
						prpLdangerTotNewDto.setSumFee(prpLdangerItemDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
						// 加入集合
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3、生成危险单位prpLdangerUnit
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

					// 每个危险单位标的的第一次数据的生成
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
						// 加入集合
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// 最后一个占比减法原则
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
						prpLdangerUnitDtotemp.setSumNoPaid(0); // 结案 未决赔款置零
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid() - compensateDto.getPrpLcompensateDto().getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------危险单位信息 国元项目组
			// end------------------------------------*/

		}
		return compensateDto;

	}

	// Add by chenrd begin 20070719
	// Reason:农险团单理赔改造
	public CompensateDto viewToDtoForAgri(HttpServletRequest httpServletRequest)
			throws Exception {

		System.err.println("1111111111111");
		// 继承对compensate,compensateText表的赋值
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));

		/*---------------------赔付标的信息prpLlossDto------------------------------------*/
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;

		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		// 加入危险单位处理 add by qinyongli 2005-9-10
		// reason: 目前只有一个危险单位，所以和标的信息放在一起处理，如果，有多个危险单位必须放入危险单位信息里面处理！
		ArrayList prpLprpLdangerTotList = new ArrayList(); // 理赔危险单位金额合计信息
		ArrayList prpLprpLdangerItemList = new ArrayList(); // 理赔的危险单位信息表
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // 标的DTO
		int dangerItemSerialNo = 1; // 用于存储标的的序号

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
		// 种植险专用 计算形式和计算方式
		String[] prpLlossDtoCalaType = httpServletRequest
				.getParameterValues("calaType");
		String[] prpLlossDtoCala = httpServletRequest
				.getParameterValues("cala");

		// 多标的种植险判断参数。
		String planting31FarmerListFlag = SysConfig.getProperty(
				"PLNATING_31_FARMER_LIST_FLAG", "claim");
		String[] prpLlossDtoCoinsSumRealPay = httpServletRequest
				.getParameterValues("prpLlossDtoCoinsSumRealPay");

		// 对象赋值
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
						prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// 对于农险在prplloss表中用flag存对应人员序号
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
						prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// 对于农险在prplloss表中用flag存对应人员序号
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
							prpLlossDto.setFlag(prpLlossDtoSerialNo[index2]);// 对于农险在prplloss表中用flag存对应人员序号
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
				// 国元种植险公式调整：页面去掉了保险价值
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
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3与curreny4相等(终端逻辑)
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
				// 国元把prpLdangerItem的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); //实赔号
				 * prpLdangerItemDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]);
				 * //损失币别 prpLdangerItemDto.setKindFlag("0"); //险别归类标志,0表示正常
				 * prpLdangerItemDto.setKindName("正常"); //险别归类名称
				 * prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); //险别
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //标的序号
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));//已决赔款
				 * prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
				prpLlossDtoList.add(prpLlossDto);
			}
		}
		// 赔付标的信息
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);

		/*---------------------赔付被保险人信息 begin ------------------------------------*/
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
					prpLagriPersonDto.setCertiType("04"); // 农险团单存赔付被保险人
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[0]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// 这里AcciName是非空字段，但对于个单来说，可能不选择相应被保险人，所用先被保险人名称进行存储
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
					prpLagriPersonDto.setAcciName(strFamilyName);// 存赔付被保险
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // 存赔付牛号
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// 加入集合
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			} else if (null != planting31FarmerListFlag
					&& planting31FarmerListFlag.indexOf(prpLlossDtoRiskCode) > -1
					&& null != prpLlossDtoSettleArea
					&& null != indemnityDutyRate) {
				for (int index2 = 0; index2 < prpLlossDtoSerialNo.length; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // 农险团单存赔付被保险人
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[0]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// 这里AcciName是非空字段，但对于个单来说，可能不选择相应被保险人，所用先被保险人名称进行存储
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
					prpLagriPersonDto.setAcciName(strFamilyName);// 存赔付被保险
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // 存赔付牛号
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// 加入集合
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			} else if ("3204".equals(prpLlossDtoRiskCode)) {
				System.err.println("1111111111111");
				for (int index2 = 1; index2 < 2; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // 农险团单存赔付被保险人
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[index2]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// 这里AcciName是非空字段，但对于个单来说，可能不选择相应被保险人，所用先被保险人名称进行存储
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
					prpLagriPersonDto.setAcciName(strFamilyName);// 存赔付被保险
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // 存赔付牛号
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// 加入集合
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			} else {
				for (int index2 = 1; index2 < prpLlossDtoSerialNo.length; index2++) {
					prpLagriPersonDto = new PrpLacciPersonDto();
					prpLagriPersonDto.setCertiNo(prpLlossDtoCompensateNo);
					prpLagriPersonDto.setCertiType("04"); // 农险团单存赔付被保险人
					prpLagriPersonDto.setPolicyNo(prpLlossDtoPolicyNo);
					prpLagriPersonDto.setSerialNo(Integer
							.parseInt(prpLlossDtoSerialNo[index2]));
					if (prpLlossDtoFamilyNo[index2] != null
							&& !prpLlossDtoFamilyNo[index2].equals("")) {
						intFamilyNo = Integer
								.parseInt(prpLlossDtoFamilyNo[index2]);
						strFamilyName = prpLlossDtoFamilyName[index2];
					} else {
						// 这里AcciName是非空字段，但对于个单来说，可能不选择相应被保险人，所用先被保险人名称进行存储
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
					prpLagriPersonDto.setAcciName(strFamilyName);// 存赔付被保险
					prpLagriPersonDto.setAddress(prpLlossDtoLicenseNo[index2]); // 存赔付牛号
					prpLagriPersonDto.setFlag("");
					prpLagriPersonDto.setAge(0);
					prpLagriPersonDto.setSex("");
					prpLagriPersonDto.setIdentifyNumber("");
					// 加入集合
					prpLagriPersonList.add(prpLagriPersonDto);
				}
			}
		}

		compensateDto.setPrpLagriPersonDtoList(prpLagriPersonList);

		/*---------------------赔付被保险人信息 end ------------------------------------*/

		/*---------------------赔款费用信息prpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// 从界面得到输入数组
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

		// 对象赋值
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

				// 国元把prpLdangerItem的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
				/*
				 * PrpLdangerItemDto prpLdangerItemChargeDto = new
				 * PrpLdangerItemDto();
				 * prpLdangerItemChargeDto.setCertiNo(prpLchargeCompensateNo);
				 * //实赔号 prpLdangerItemChargeDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemChargeDto.setCurrency(prpLchargeCurrency[index]);
				 * //损失币别 prpLdangerItemChargeDto.setKindFlag("0");
				 * //险别归类标志,0表示正常 prpLdangerItemChargeDto.setKindName("正常");
				 * //险别归类名称
				 * prpLdangerItemChargeDto.setRiskCode(prpLchargeRiskCode); //险别
				 * prpLdangerItemChargeDto.setSerialNo(dangerItemSerialNo);
				 * //标的序号 dangerItemSerialNo++;
				 * prpLdangerItemChargeDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				 * //已决赔款 prpLprpLdangerItemList.add(prpLdangerItemChargeDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// 赔款费用信息
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// 从界面得到输入数组
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
		// 对象赋值
		// 赔款计算金额信息
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
		// 如果案件属于案终赔付，则需要结案报告文本
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");

		ArrayList prpLltextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLltextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// 得到连接串,下面将其切分到数组
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
		// 国元把prpLdangertot的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
		/*
		 * String TCurrency = httpServletRequest.getParameter("MergeCurrency");
		 * //将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10
		 * compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
		 * //对标的信息进行处理，得到合计信息 ArrayList itemListAll =(ArrayList)
		 * prpLprpLdangerItemList.clone(); ArrayList itemList =(ArrayList)
		 * prpLprpLdangerItemList.clone(); PrpLdangerItemDto dangerItemAll = new
		 * PrpLdangerItemDto(); //获取每个标的对象 PrpLdangerItemDto dangerItem = new
		 * PrpLdangerItemDto(); //循环判断时使用 ArrayList tempCurrency = new
		 * ArrayList(); Iterator itemListIteratorAll = itemListAll.iterator();
		 * Iterator itemListIterator = itemList.iterator(); PrpLdangerItemDto
		 * dangerItemAll1 = new PrpLdangerItemDto();
		 * while(itemListIteratorAll.hasNext()){ dangerItemAll=
		 * (PrpLdangerItemDto)itemListIteratorAll.next(); dangerItemAll1 = new
		 * PrpLdangerItemDto();
		 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
		 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());
		 * 
		 * //用当前币别遍历集合进行统计 String currentCur = dangerItemAll1.getCurrency();
		 * if(tempCurrency.contains(currentCur)){ continue; //如果已经合计过的币种，不再进行合计; }
		 * int currentSerial = dangerItemAll1.getSerialNo();
		 * while(itemListIterator.hasNext()){ dangerItem =
		 * (PrpLdangerItemDto)itemListIterator.next(); //如果币别相等，则对赔偿金额和费用进行累加
		 * if(currentSerial!=dangerItem.getSerialNo()&&currentCur.equals(dangerItem.getCurrency())){
		 * dangerItemAll1.setSumFee(dangerItemAll1.getSumFee()+dangerItem.getSumFee());
		 * //合计费用
		 * dangerItemAll1.setSumPaid(dangerItemAll1.getSumPaid()+dangerItem.getSumPaid());
		 * //合计金额 } } tempCurrency.add(currentCur); //将当前合计的币种暂存 ;
		 * //将标的信息加入合计Dto if(dangerItemAll!=null){
		 * prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
		 * prpLdangerTotDto.setDangerNo(1); //目前，就一个危险单位
		 * prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); //标的原币别
		 * prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
		 * prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
		 * prpLdangerTotDto.setTCurrency(TCurrency); //进行币别转化 转化后的币别为TCurrency
		 * String SCurrency = dangerItemAll.getCurrency(); //原币别 double
		 * exchangeRate =
		 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
		 * Date())); prpLdangerTotDto.setExchRate(exchangeRate);
		 * prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()*exchangeRate);
		 * prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()*exchangeRate); }
		 * if(prpLdangerTotDto!=null){
		 * prpLprpLdangerTotList.add(prpLdangerTotDto); } }
		 * compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
		 */
		// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10 end
		if (DangerUnitCheckSaveFlag.equals("1")) {
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061130 start reason 给再保送数据
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061130 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// 从界面得到输入数组
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

			// 以前生成prpLdangerUnit那套代码注掉，另开一套
			// 对象赋值
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
			 * //从立案获取实赔 if(!prpLdangerClaimNo[index].equals("")){ ClaimDto
			 * claimDto = new ClaimDto(); UIClaimAction uiclaimAction= new
			 * UIClaimAction(); claimDto =
			 * uiclaimAction.findByPrimaryKey(prpLdangerClaimNo[index]); double
			 * sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
			 * prpLdangerUnitDto.setSumNoPaid(Double.parseDouble(prpLdangerRiskSumClaim[index])-sumPaid); }
			 * if("1".equals(prpLcompensateFinallyFlag)){
			 * prpLdangerUnitDto.setCertiType("3");//案终为实赔
			 * prpLdangerUnitDto.setSumNoPaid(0); //结案 未决赔款置零 }else{
			 * prpLdangerUnitDto.setCertiType("3");
			 * prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index])); }
			 * prpLdangerUnitDto.setDangerShare(Double.parseDouble(prpLdangerProportion[index]));
			 * prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);//add by kangzhen
			 * //加入集合
			 * if(prpLdangerPolicyNo[index]!=null&&!(prpLdangerPolicyNo[index].equals(""))){
			 * dangerUnitList.add(prpLdangerUnitDto); } }
			 * if(dangerUnitList.size()>0){
			 * compensateDto.setPrplRiskUnitDtoList(dangerUnitList); } }
			 */
			// 国元生成危险单位相关信息（新开的一套，把以前的那套注掉了）
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
			String sql = "";
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto();
			double sumTempLoss = 0;// dangerUnit估损金额非最后一个累加值（解决精度问题）
			double sumTempPaid = 0;// dangerUnit已决赔款非最后一个累加值
			double sumTempNoPaid = 0;// dangerUnit未决赔款非最后一个累加值
			double tempLoss = 0;
			double tempPaid = 0;
			double tempNoPaid = 0;

			double sumLSumRealPay[] = new double[1000];

			// start
			// 国元新改方案-------------------------------------------------------------------------
			// 对象赋值
			if (prpLdangerCurrency == null) {
			} else {
				sql = " certino ='" + prpLdangerClaimNo[0] + "'";
				// 取立案的危险单位信息，根据 立案危险单位 生成 理算的危险单位信息
				List prpLdangerUnitClaimList = (ArrayList) blPrpLdangerUnitFacade
						.findByConditions(sql);
				for (int index = 0; index < prpLdangerCurrency.length; index++) {

					sumTempLoss = 0;
					sumTempPaid = 0;
					sumTempNoPaid = 0;

					double sumPaid = 0;
					double sumNoPaid = 0;

					// 取此立案的总未决
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
						sumNoPaid = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumPaid;// 立案的总未决
					}

					// 根据 立案危险单位 生成 理算的危险单位信息
					for (int dangerUnitSize = 0; dangerUnitSize < prpLdangerUnitClaimList
							.size(); dangerUnitSize++) {
						List temPrpLprpLdangerItemList = new ArrayList();
						dangerItemSerialNo = 1;
						prpLdangerUnitClaimDto = (PrpLdangerUnitDto) prpLdangerUnitClaimList.get(dangerUnitSize);

						// 1、生成危险单位prpLdangerUnit
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
						if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1)// 最后一个危险单位用减法算
						{
							tempLoss = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumTempLoss;
							tempPaid = Double.parseDouble(prpLdangerRiskSumPaid[index]) - sumTempPaid;
							tempNoPaid = sumNoPaid - sumTempNoPaid;

						}
						// 非最后一个危险单位用乘法算（乘以比例）
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
							prpLdangerUnitDto.setCertiType("3");// 案终为实赔
							prpLdangerUnitDto.setSumNoPaid(0); // 结案 未决赔款置零
						} else {
							prpLdangerUnitDto.setCertiType("3");
							// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
						}
						prpLdangerUnitDto.setCoinsFlag(strCoinsFlag); // add
						// by
						// kangzhen
						// 加入集合
						if (prpLdangerPolicyNo[index] != null && !(prpLdangerPolicyNo[index].equals(""))) {
							dangerUnitList.add(prpLdangerUnitDto);
						}

						// 2、生成此赔款危险单位标的prpLdangerItem（物损赔款）
						if (prpLlossDtoSerialNo == null) {

						} else {
							double tempLossRealPay = 0;
							for (int j = 1; j < prpLlossDtoSerialNo.length; j++) {

								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // 实赔号
								prpLdangerItemDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); // 险别
								if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1) {
									tempLossRealPay = Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[j])) - sumLSumRealPay[dangerItemSerialNo];
								} else {
									tempLossRealPay = Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[j]))
											* prpLdangerUnitClaimDto.getDangerShare() / 100;
									sumLSumRealPay[dangerItemSerialNo] += tempLossRealPay;
								}
								prpLdangerItemDto.setSumPaid(tempLossRealPay); // 已决赔款
								prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
								dangerItemSerialNo++;

								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList.add(prpLdangerItemDto);
							}
						}

						// 3、生成此危险单位标prpLdangerItem（费用）
						if (prpLchargeSerialNo == null) {

						} else {
							double tempLchargeSumRealPay = 0;
							for (int j = 1; j < prpLchargeSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto.setCertiNo(prpLchargeCompensateNo); // 实赔号
								prpLdangerItemDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto.setCurrency(prpLchargeCurrency[j]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto.setRiskCode(prpLchargeRiskCode); // 险别
								if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1) {
									tempLchargeSumRealPay = Double.parseDouble(DataUtils.nullToZero(prpLchargeChargeAmount[j]))
											- sumLSumRealPay[dangerItemSerialNo];
								} else {
									// 危险单位标的表不考虑费用是不是记入总赔款，全要记录到prpLdangerItem
									tempLchargeSumRealPay = Double.parseDouble(DataUtils.nullToZero(prpLchargeChargeAmount[j]))
											* prpLdangerUnitClaimDto.getDangerShare() / 100;
									sumLSumRealPay[dangerItemSerialNo] += tempLchargeSumRealPay;
								}
								prpLdangerItemDto.setSumFee(tempLchargeSumRealPay);
								prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
								dangerItemSerialNo++;
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList.add(prpLdangerItemDto);
							}
						}

						// 4、生成此危险单位标金额合计PrpLdangerTotD（汇总prpLdangerItem）
						Iterator itemListIteratorAll = temPrpLprpLdangerItemList.iterator();
						Iterator itemListIterator = temPrpLprpLdangerItemList.iterator();
						double sumPaidAll = 0;
						while (itemListIteratorAll.hasNext()) {
							dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll.next();
							sumPaidAll += dangerItemAll.getSumPaid();
							sumPaidAll += dangerItemAll.getSumFee();
						}
						PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // 金额合计Dto
						prpLdangerTotDto.setCertiNo(compensateNo);
						prpLdangerTotDto.setDangerNo(prpLdangerUnitClaimDto.getDangerNo()); // 目前，就一个危险单位
						prpLdangerTotDto.setSCurrency(prpLdangerCurrency[index]); // 标的原币别
						prpLdangerTotDto.setSumFee(0);
						prpLdangerTotDto.setSumPaid(sumPaidAll);
						prpLdangerTotDto.setTCurrency(prpLdangerCurrency[index]);
						// 进行币别转化 转化后的币别为TCurrency
						/*
						 * String SCurrency = dangerItemAll.getCurrency(); //原币别
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
				// 赔款信息
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
				compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
				compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			}
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {
			// ******---------------------危险单位信息 国元项目组
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
			// 从界面得到输入数组

			String prpLdangerCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");// 理算书号

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");// 保单号
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");// 险种号
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");// 危险单位描述
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");// 危险单位地址
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");// 危险单位币别
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");// 赔付金额
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");// 危险单位号
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");// 占比
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");// 险别代码
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");// 险别名称
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");// 标的代码
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");// 标的名称
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// 标的序号

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// 业务来源
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// 保单业务类型
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// 投保方式
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// 政策性标志
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// 涉农标识
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// 其他标识字段
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// 归属区域省
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// 归属区域市
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// 归属区域县
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// 归属区域乡镇
			// 1、生成此赔款危险单位标的prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto();
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index]));
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]);
					prpLdangerItemNewDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]);
					prpLdangerItemNewDto.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					// 占比最后一个减法原则
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
					isfee = false; //是否有费用，如果有则拆分到对应的险别代码和标的代码
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
                  prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
			
			sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// 加入集合
					if (prpLdangerItemNewDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // 标的DTO
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
					// 每个危险单位标的的第一次数据的生成
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // 标的原币别
						prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
						// 加入集合
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3、生成危险单位prpLdangerUnit
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

					// 每个危险单位标的的第一次数据的生成
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
						// 加入集合
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// 最后一个占比减法原则
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
						prpLdangerUnitDtotemp.setSumNoPaid(0); // 结案 未决赔款置零
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid() - compensateDto.getPrpLcompensateDto().getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------危险单位信息 国元项目组
			// end------------------------------------*/
		}

		return compensateDto;
	}

	/**
	 * 保存实赔时实赔页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return compensateDto 实赔数据传输数据结构
	 * @throws Exception
	 */
	public CompensateDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// 继承对compensate,compensateText表的赋值
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();
		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		// add by lixiang start at 2005-12-27
		// reason:增加投保人复制
		compensateDto.getPrpLcompensateDto().setAppliName(
				(String) httpServletRequest
						.getParameter("prpLcompensateAppliName"));
		// add by lixiang end at 2005-12-27

		System.err.println("zouyixia");
		/*-------------------索赔申请人信息-------start------------------------------------*/
		ClaimDto claim2Dto = null;
		ArrayList prpLacciPersonList = new ArrayList();
		PrpLacciPersonDto prpLacciPersonProposerDto = null;
		// 从界面得到输入数组

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

		// 对象赋值
		if (proposerSerialNo == null) {
		} else {

			for (int index = 1; index < proposerSerialNo.length; index++) {
				prpLacciPersonProposerDto = new PrpLacciPersonDto();
				prpLacciPersonProposerDto.setAcciName(proposerName[index]);
				prpLacciPersonProposerDto.setCertiNo(proposerClaimNo);
				prpLacciPersonProposerDto.setCertiType("03");
				prpLacciPersonProposerDto.setPolicyNo(proposerPolicyNo);
				prpLacciPersonProposerDto.setFlag("1"); // 标志是索赔人
				prpLacciPersonProposerDto
						.setIdentifyNumber(proposerIdentifyNumber[index]);
				prpLacciPersonProposerDto
						.setSerialNo(Integer.parseInt(DataUtils
								.nullToZero(proposerSerialNo[index])));
				prpLacciPersonProposerDto.setAddress(proposerAddress[index]);
				prpLacciPersonProposerDto.setFamilyNo(0); // 家庭序号
				prpLacciPersonProposerDto.setPhone(proposerPhone[index]);
				prpLacciPersonProposerDto
						.setRelationCode(proposerRelation[index]);
				String relationName = "";

				if (proposerRelation[index].equals("1")) {
					relationName = "被保险人本人";
				} else if (proposerRelation[index].equals("2")) {
					relationName = "指定受益人";
				} else if (proposerRelation[index].equals("3")) {
					relationName = "被保险人之继承人";
				} else if (proposerRelation[index].equals("4")) {
					relationName = "被保险人之监护人";
				}
				prpLacciPersonProposerDto.setRelationName(relationName);
				prpLacciPersonProposerDto.setFamilyNo(Integer
						.parseInt(proposerFamilyNo));

				// 加入集合
				prpLacciPersonList.add(prpLacciPersonProposerDto);

			}
			// 意健险立案集合中加入索赔申请人
			compensateDto.setPrpLacciPersonDtoList(prpLacciPersonList);

		}
		/*-------------------索赔申请人信息-------end------------------------------------*/

		/*---------------------赔付标的信息prpLlossDto------------------------------------*/
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;
		// 加入危险单位处理 add by qinyongli 2005-9-10
		// reason: 目前只有一个危险单位，所以和标的信息放在一起处理，如果，有多个危险单位必须放入危险单位信息里面处理！
		ArrayList prpLprpLdangerTotList = new ArrayList(); // 理赔危险单位金额合计信息
		ArrayList prpLprpLdangerItemList = new ArrayList(); // 理赔的危险单位信息表
		PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // 金额合计Dto
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // 标的DTO
		int dangerItemSerialNo = 1; // 用于存储标的的序号

		// 从界面得到输入数组
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
		//0313碎屏险添加IMEI字段
		String[] prpLlossDtoImei = httpServletRequest
				.getParameterValues("prpLlossDtoImei");
		// 对象赋值

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
				// 国元种植险公式调整：页面去掉了保险价值
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
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3与curreny4相等(终端逻辑)
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
				// 国元把prpLdangerItem的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); //实赔号
				 * prpLdangerItemDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]);
				 * //损失币别 prpLdangerItemDto.setKindFlag("0"); //险别归类标志,0表示正常
				 * prpLdangerItemDto.setKindName("正常"); //险别归类名称
				 * prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); //险别
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //标的序号
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));//已决赔款
				 * prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
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
				if (!"ZH03".equals(prpLlossDtoRiskCode))// 农家福组合保险使用FamilyNoZH
					// 代替 FamilyNo,赋值部分在后边
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
				prpLlossDto.setCurrency4(prpLlossDto.getCurrency3());// currency3与curreny4相等(终端逻辑)
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
				// 国元把prpLdangerItem的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); //实赔号
				 * prpLdangerItemDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]);
				 * //损失币别 prpLdangerItemDto.setKindFlag("0"); //险别归类标志,0表示正常
				 * prpLdangerItemDto.setKindName("正常"); //险别归类名称
				 * prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); //险别
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //标的序号
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));//已决赔款
				 * prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
				// 乡村干部组合保险赔付到人或户
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
				// 自行车第三者责任保险赔付到车
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
		// 赔付标的信息
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);

		/*---------------------赔付人员信息prpLpersonLossDto------------------------------------*/
		ArrayList prpLpersonLossDtoList = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = null;

		// 从界面得到输入数组
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

		// 增加最大赔付额和历次赔付额 2005-9-23
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
				// 对象赋值
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
									.setFamilyName(prpLpersonLossFamilyName[index2]);// 车牌号码

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
					// 加入集合
					prpLpersonLossDtoList.add(prpLpersonLossDto);
				}
			} else {
				// 对象赋值

				// modify by lixiang start at 2005-12-28
				// resaon:以下读数据总是错的。。我现在只把personLossSerialNo变成prpLpersonLossSerialNo，
				// 没有任何意义，只是暂时不出系统严重错误， 但是是没有解决问题的。
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
					// 调整for保存不了多条赔付标的信息，原因：险别index不对
					for (int index3 = 0; index3 < prpLpersonLossSerialNo.length; index3++) {
						if (prpLpersonLossSerialNo[index3]
								.equals(personLossSerialNo[index])) {

							prpLpersonLossDto
									.setItemKindNo(Integer
											.parseInt(DataUtils
													.nullToZero(prpLpersonLossItemKindNo[index]))); // 需调整
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
					// 国元把prpLdangerItem的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
					/*
					 * PrpLdangerItemDto prpLdangerItemDtoPerson = new
					 * PrpLdangerItemDto();
					 * prpLdangerItemDtoPerson.setCertiNo(prpLlossDtoCompensateNo);
					 * //实赔号 prpLdangerItemDtoPerson.setDangerNo(1);
					 * //目前只有一个危险单位
					 * prpLdangerItemDtoPerson.setCurrency(prpLpersonLossCurrency[index]);
					 * //损失币别 prpLdangerItemDtoPerson.setKindFlag("0");
					 * //险别归类标志,0表示正常 prpLdangerItemDtoPerson.setKindName("正常");
					 * //险别归类名称
					 * prpLdangerItemDtoPerson.setRiskCode(prpLpersonLossRiskCode);
					 * //险别
					 * prpLdangerItemDtoPerson.setSerialNo(dangerItemSerialNo);
					 * //标的序号 dangerItemSerialNo++;
					 * prpLdangerItemDtoPerson.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
					 * //已决赔款
					 * prpLprpLdangerItemList.add(prpLdangerItemDtoPerson);
					 */
					// add by qinyongli end 2005-9-10
					// 加入集合
					prpLpersonLossDtoList.add(prpLpersonLossDto);
				}
			}
		}
		// 赔付人员信息
		compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
		/*---------------------赔款费用信息prpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// 从界面得到输入数组
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
				.getParameterValues("prpLlossDtoItemKindNoForCharge"); // 费用标的代码

		// 对象赋值
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

				// 国元把prpLdangerItem的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
				/*
				 * PrpLdangerItemDto prpLdangerItemChargeDto = new
				 * PrpLdangerItemDto();
				 * prpLdangerItemChargeDto.setCertiNo(prpLchargeCompensateNo);
				 * //实赔号 prpLdangerItemChargeDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemChargeDto.setCurrency(prpLchargeCurrency[index]);
				 * //损失币别 prpLdangerItemChargeDto.setKindFlag("0");
				 * //险别归类标志,0表示正常 prpLdangerItemChargeDto.setKindName("正常");
				 * //险别归类名称
				 * prpLdangerItemChargeDto.setRiskCode(prpLchargeRiskCode); //险别
				 * prpLdangerItemChargeDto.setSerialNo(dangerItemSerialNo);
				 * //标的序号 dangerItemSerialNo++;
				 * prpLdangerItemChargeDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				 * //已决赔款 prpLprpLdangerItemList.add(prpLdangerItemChargeDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// 赔款费用信息
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
		 * //加到ArrayList中
		 * compensateDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
		 * //整理回访问询信息结束
		 */

		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		/*
		 * ArrayList prpLregistExtDtoList = new ArrayList(); PrpLregistExtDto
		 * prpLregistExtDto = null ; //从界面得到输入数组 String prpLregistExtRegistNo =
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
		 * httpServletRequest.getParameterValues("prpLregistExtContext"); //对象赋值
		 * //人员伤亡跟踪 部分开始 if (prpLregistExtSerialNo==null) {} else {
		 * //System.out.println("人员伤亡跟踪部分开始 "); for(int index=1;index
		 * <prpLregistExtSerialNo.length;index++) { prpLregistExtDto = new
		 * PrpLregistExtDto();
		 * prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
		 * prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
		 * prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
		 * prpLregistExtDto.setInputDate(new
		 * DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
		 * prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
		 * prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
		 * prpLregistExtDto.setContext(prpLregistExtContext[index]); //加入集合
		 * prpLregistExtDtoList.add(prpLregistExtDto); } //报案集合中加入损失部位
		 * compensateDto.setPrpLregistExtDtoList(prpLregistExtDtoList); }
		 */

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// 从界面得到输入数组
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
		// 对象赋值
		// 赔款计算金额信息
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
		// 如果案件属于案终赔付，则需要结案报告文本
		String prpLcompensateFinallyFlag = httpServletRequest
				.getParameter("prpLcompensateFinallyFlag");

		// modify by lixiang start 2006-8-1
		// reason:由于不是第一张计算书的情况下，要说明后续情况，所以就要保存数据了
		// if (prpLcompensateFinallyFlag.equals("1")) {
		ArrayList prpLltextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLltextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// 得到连接串,下面将其切分到数组
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
		// ----------------------------危险单位信息处理,目前只有一个危险单位
		// 国元把prpLdangertot的生成挪到生成危险单位prpLdangerUnit循环中去，暂且注掉以下代码
		/*
		 * String TCurrency = httpServletRequest.getParameter("MergeCurrency");
		 * //将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10
		 * compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
		 * //对标的信息进行处理，得到合计信息 ArrayList itemListAll =(ArrayList)
		 * prpLprpLdangerItemList.clone(); ArrayList itemList =(ArrayList)
		 * prpLprpLdangerItemList.clone(); PrpLdangerItemDto dangerItemAll = new
		 * PrpLdangerItemDto(); //获取每个标的对象 PrpLdangerItemDto dangerItem = new
		 * PrpLdangerItemDto(); //循环判断时使用 ArrayList tempCurrency = new
		 * ArrayList(); Iterator itemListIteratorAll = itemListAll.iterator();
		 * Iterator itemListIterator = itemList.iterator(); PrpLdangerItemDto
		 * dangerItemAll1 = new PrpLdangerItemDto();
		 * while(itemListIteratorAll.hasNext()){ dangerItemAll=
		 * (PrpLdangerItemDto)itemListIteratorAll.next(); dangerItemAll1 = new
		 * PrpLdangerItemDto();
		 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
		 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());
		 * 
		 * //用当前币别遍历集合进行统计 String currentCur = dangerItemAll1.getCurrency();
		 * if(tempCurrency.contains(currentCur)){ continue; //如果已经合计过的币种，不再进行合计; }
		 * int currentSerial = dangerItemAll1.getSerialNo();
		 * while(itemListIterator.hasNext()){ dangerItem =
		 * (PrpLdangerItemDto)itemListIterator.next(); //如果币别相等，则对赔偿金额和费用进行累加
		 * if(currentSerial!=dangerItem.getSerialNo()&&currentCur.equals(dangerItem.getCurrency())){
		 * dangerItemAll1.setSumFee(dangerItemAll1.getSumFee()+dangerItem.getSumFee());
		 * //合计费用
		 * dangerItemAll1.setSumPaid(dangerItemAll1.getSumPaid()+dangerItem.getSumPaid());
		 * //合计金额 } } tempCurrency.add(currentCur); //将当前合计的币种暂存 ;
		 * //将标的信息加入合计Dto if(dangerItemAll!=null){
		 * prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
		 * prpLdangerTotDto.setDangerNo(1); //目前，就一个危险单位
		 * prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); //标的原币别
		 * prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
		 * prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
		 * prpLdangerTotDto.setTCurrency(TCurrency); //进行币别转化 转化后的币别为TCurrency
		 * String SCurrency = dangerItemAll.getCurrency(); //原币别 double
		 * exchangeRate =
		 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
		 * Date())); prpLdangerTotDto.setExchRate(exchangeRate);
		 * prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()*exchangeRate);
		 * prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()*exchangeRate); }
		 * if(prpLdangerTotDto!=null){
		 * prpLprpLdangerTotList.add(prpLdangerTotDto); } }
		 * compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
		 */
		// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10 end
		if (DangerUnitCheckSaveFlag.equals("1")) {
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061130 start reason 给再保送数据
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061130 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// 从界面得到输入数组
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

			// 以前生成prpLdangerUnit那套代码注掉，另开一套
			// 对象赋值
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
			 * //从立案获取实赔 if(!prpLdangerClaimNo[index].equals("")){ ClaimDto
			 * claimDto = new ClaimDto(); UIClaimAction uiclaimAction= new
			 * UIClaimAction(); claimDto =
			 * uiclaimAction.findByPrimaryKey(prpLdangerClaimNo[index]); double
			 * sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
			 * prpLdangerUnitDto.setSumNoPaid(Double.parseDouble(prpLdangerRiskSumClaim[index])-sumPaid); }
			 * if("1".equals(prpLcompensateFinallyFlag)){
			 * prpLdangerUnitDto.setCertiType("3");//案终为实赔
			 * prpLdangerUnitDto.setSumNoPaid(0); //结案 未决赔款置零 }else{
			 * prpLdangerUnitDto.setCertiType("3");
			 * prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index])); }
			 * prpLdangerUnitDto.setDangerShare(Double.parseDouble(prpLdangerProportion[index]));
			 * prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);//add by kangzhen
			 * //加入集合
			 * if(prpLdangerPolicyNo[index]!=null&&!(prpLdangerPolicyNo[index].equals(""))){
			 * dangerUnitList.add(prpLdangerUnitDto); } }
			 * if(dangerUnitList.size()>0){
			 * compensateDto.setPrplRiskUnitDtoList(dangerUnitList); } }
			 */
			// 国元生成危险单位相关信息（新开的一套，把以前的那套注掉了）
			BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
			PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
			String sql = "";
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto();
			double sumTempLoss = 0;// dangerUnit估损金额非最后一个累加值（解决精度问题）
			double sumTempPaid = 0;// dangerUnit已决赔款非最后一个累加值
			double sumTempNoPaid = 0;// dangerUnit未决赔款非最后一个累加值
			double tempLoss = 0;
			double tempPaid = 0;
			double tempNoPaid = 0;

			double sumLSumRealPay[] = new double[1000];

			// start
			// 国元新改方案-------------------------------------------------------------------------
			// 对象赋值
			if (prpLdangerCurrency == null) {
			} else {
				sql = " certino ='" + prpLdangerClaimNo[0] + "'";
				// 取立案的危险单位信息，根据 立案危险单位 生成 理算的危险单位信息
				List prpLdangerUnitClaimList = (ArrayList) blPrpLdangerUnitFacade
						.findByConditions(sql);
				for (int index = 0; index < prpLdangerCurrency.length; index++) {

					sumTempLoss = 0;
					sumTempPaid = 0;
					sumTempNoPaid = 0;

					double sumPaid = 0;
					double sumNoPaid = 0;

					// 取此立案的总未决
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
						sumNoPaid = Double
								.parseDouble(prpLdangerRiskSumClaim[index])
								- sumPaid;// 立案的总未决
					}

					// 根据 立案危险单位 生成 理算的危险单位信息
					for (int dangerUnitSize = 0; dangerUnitSize < prpLdangerUnitClaimList
							.size(); dangerUnitSize++) {
						List temPrpLprpLdangerItemList = new ArrayList();
						dangerItemSerialNo = 1;
						prpLdangerUnitClaimDto = (PrpLdangerUnitDto) prpLdangerUnitClaimList
								.get(dangerUnitSize);

						// 1、生成危险单位prpLdangerUnit
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
						if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1)// 最后一个危险单位用减法算
						{
							tempLoss = Str.round(Double
									.parseDouble(prpLdangerRiskSumClaim[index])
									- sumTempLoss, 2);
							tempPaid = Str.round(Double
									.parseDouble(prpLdangerRiskSumPaid[index])
									- sumTempPaid, 2);
							tempNoPaid = sumNoPaid - sumTempNoPaid;

						}
						// 非最后一个危险单位用乘法算（乘以比例）
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
							prpLdangerUnitDto.setCertiType("3");// 案终为实赔
							prpLdangerUnitDto.setSumNoPaid(0); // 结案 未决赔款置零
						} else {
							prpLdangerUnitDto.setCertiType("3");
							// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
						}
						prpLdangerUnitDto.setCoinsFlag(strCoinsFlag); // add
						// by
						// kangzhen
						// 加入集合
						if (prpLdangerPolicyNo[index] != null
								&& !(prpLdangerPolicyNo[index].equals(""))) {
							dangerUnitList.add(prpLdangerUnitDto);
						}

						// 2、生成此赔款危险单位标的prpLdangerItem（物损赔款）
						if (prpLlossDtoSerialNo == null) {

						} else {
							double tempLossRealPay = 0;
							for (int j = 1; j < prpLlossDtoSerialNo.length; j++) {

								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLlossDtoCompensateNo); // 实赔号
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto
										.setCurrency(prpLlossDtoCurrency2[index]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto
										.setRiskCode(prpLlossDtoRiskCode); // 险别
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
								prpLdangerItemDto.setSumPaid(tempLossRealPay); // 已决赔款
								prpLdangerItemDto
										.setSerialNo(dangerItemSerialNo); // 标的序号
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
							 * "D".equals(strRiskType)) { //对象赋值 for (int j = 1;
							 * j < personLossSerialNo.length; j++) { } }else {
							 */
							for (int j = 1; j < personLossSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLpersonLossCompensateNo); // 实赔号
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto
										.setCurrency(prpLpersonLossCurrency[j]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto
										.setRiskCode(prpLpersonLossRiskCode); // 险别
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
										.setSerialNo(dangerItemSerialNo); // 标的序号
								dangerItemSerialNo++;
								// 已决赔款
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
							// }
						}

						// 3、生成此危险单位标prpLdangerItem（费用）
						if (prpLchargeSerialNo == null) {

						} else {
							double tempLchargeSumRealPay = 0;
							for (int j = 1; j < prpLchargeSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLchargeCompensateNo); // 实赔号
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto
										.setCurrency(prpLchargeCurrency[j]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto
										.setRiskCode(prpLchargeRiskCode); // 险别
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
									// 危险单位标的表不考虑费用是不是记入总赔款，全要记录到prpLdangerItem
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
										.setSerialNo(dangerItemSerialNo); // 标的序号
								dangerItemSerialNo++;
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						// 4、生成此危险单位标金额合计PrpLdangerTotD（汇总prpLdangerItem）
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
						prpLdangerTotDto = new PrpLdangerTotDto(); // 金额合计Dto
						prpLdangerTotDto.setCertiNo(compensateNo);
						prpLdangerTotDto.setDangerNo(prpLdangerUnitClaimDto
								.getDangerNo()); // 目前，就一个危险单位
						prpLdangerTotDto
								.setSCurrency(prpLdangerCurrency[index]); // 标的原币别
						prpLdangerTotDto.setSumFee(0);
						prpLdangerTotDto.setSumPaid(sumPaidAll);
						prpLdangerTotDto
								.setTCurrency(prpLdangerCurrency[index]);
						// 进行币别转化 转化后的币别为TCurrency
						/*
						 * String SCurrency = dangerItemAll.getCurrency(); //原币别
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
				// 赔款信息
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
				compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
				compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			}
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {

			// ******---------------------危险单位信息 国元项目组
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
			// 从界面得到输入数组

			String prpLdangerCompensateNo = (String) httpServletRequest
					.getAttribute("compensateNo");// 理算书号

			String[] prpLdangerPolicyNo = httpServletRequest
					.getParameterValues("prpLdangerPolicyNo");// 保单号
			String[] prpLdangerRiskCode = httpServletRequest
					.getParameterValues("prpLdangerRiskCode");// 险种号
			String[] prpLdangerUnitDesc = httpServletRequest
					.getParameterValues("prpLdangerUnitDangerDesc");// 危险单位描述
			String[] prpLdangerAddressName = httpServletRequest
					.getParameterValues("prpLdangerUnitAddressName");// 危险单位地址
			String[] prpLdangerCurrency = httpServletRequest
					.getParameterValues("prpLdangerCurrency");// 币别
			String[] prpLdangerUnitSumLoss = httpServletRequest
					.getParameterValues("prpLdangerUnitSumLoss");// 赔付金额
			String[] prpLdangerDangerNo = httpServletRequest
					.getParameterValues("prpLdangerDangerNo");// 危险单位号
			String[] prpLdangerShare = httpServletRequest
					.getParameterValues("prpLdangerShare");// 占比
			String[] prpLdangerKindcode = httpServletRequest
					.getParameterValues("prpLdangerKindcode");// 险别代码
			String[] prpLdangerKindname = httpServletRequest
					.getParameterValues("prpLdangerKindname");// 险别名称
			String[] prpLdangerItemCode = httpServletRequest
					.getParameterValues("prpLdangerItemCode");// 标的代码
			String[] prpLdangerItemName = httpServletRequest
					.getParameterValues("prpLdangerItemName");// 标的名称
			String[] prpLdangerUnitItemKindNo = httpServletRequest
					.getParameterValues("prpLdangerUnitItemKindNo");// 标的序号

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// 业务来源
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// 保单业务类型
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// 投保方式
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// 政策性标志
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// 涉农标识
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// 其他标识字段
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// 归属区域省
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// 归属区域市
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// 归属区域县
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// 归属区域乡镇
			// 1、生成此赔款危险单位标的prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto(); // 标的DTO
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); // 危险单位
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); // 损失币别
					prpLdangerItemNewDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); // 险别
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
					isfee = false; //是否有费用，如果有则拆分到对应的险别代码和标的代码
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
	                  prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
				
	                  sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// 加入集合
					if (prpLdangerItemNewDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // 标的DTO
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
					// 每个危险单位标的的第一次数据的生成
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // 标的原币别
						prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
						// 加入集合
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3、生成危险单位prpLdangerUnit
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

					// 每个危险单位标的的第一次数据的生成
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
						// 加入集合
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// 最后一个占比减法原则
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
						prpLdangerUnitDtotemp.setSumNoPaid(0); // 结案 未决赔款置零
					} else {
						prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
						prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid() - compensateDto.getPrpLcompensateDto().getSumThisPaid(), 2));
					}

				}

				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
			}

			// ******---------------------危险单位信息 国元项目组
			// end------------------------------------*/
		}

		return compensateDto;

	}

	// modify by luqin 2005-04-08 start
	/**
	 * 检查缴费标志 返回值 int -1为未缴费，0为未缴全，1为缴全
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param policyNo
	 *            赔案号
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// 取得赔款计算书信息
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo
				+ "' AND substr(Flag,1,1)!='1' ";
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions);
		return intReturn;
	}

	// modify by luqin 2005-04-08 end

	/**
	 * 根据compensateDto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateDto
	 *            实赔的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// 给报案信息补充说明多行列表准备数据
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

		// 特别约定信息多行列表准备数据
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

		// 赔偿限额/免赔额信息多行列表准备数据
		Collection arraylist4 = new ArrayList();
		PrpDlimitDto prpDlimitDto = new PrpDlimitDto();
		arraylist4 = compensateDto.getPrpDlimitDtoList();
		prpDlimitDto.setPrpDlimitList(arraylist4);
		httpServletRequest.setAttribute("prpDlimitDto", prpDlimitDto);

		// 货币代码的列表
		Collection collection = uiCodeAction.getCurrencyList();
		Iterator iterator = collection.iterator();
		HashMap currencyTemp = new HashMap();
		while (iterator.hasNext()) {
			PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto) iterator.next();
			currencyTemp.put(prpDcurrencyDto.getCurrencyCode(), prpDcurrencyDto
					.getCurrencyCName());
		}

		// 赔偿限额/免赔额信息多行列表准备数据

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
				prpClimitDtoTemp.setLimitGrade("保单");

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

				// prpClimitDtoTemp.setLimitGrade("标的险别");
			}
			prpClimitDtoTemp.setLimitTypeName(uiCodeAction.translateLimit(
					prpClimitDtoTemp.getRiskCode(), prpClimitDtoTemp
							.getLimitType(), true));

		}
		prpClimitDto.setPrpClimitList(arraylist5);
		httpServletRequest.setAttribute("prpClimitDto", prpClimitDto);

		// 赔付标的信息多行列表准备数据
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

		// 赔付人员信息多行列表准备数据
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

		// 赔款费用信息多行列表准备数据
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
		// add by miaowenjun 20070130 去掉间接理赔费用 start
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
		// add by miaowenjun 20070130 去掉间接理赔费用 end
		prpLchargeDto.setPrpLchargeList(newArrayList3);
		httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);

	}

	/**
	 * STUB-ONLY 生成理算报告
	 * 
	 * @param 无
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
	 * STUB-ONLY 中央政策性六大险种（种植险）生成理算报告
	 * 
	 * @param 无
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
	 * STUB-ONLY 中央政策性六大险种（种植险）生成理算报告
	 * 
	 * @param 无
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

		// 2016.3.30 牡丹3187，赔款计算的全损比例调整至90%(现从数据库取值不按照条款定死)
		Double ratelimit3187 = 90.00; // 默认是条款的90%
		if ("3187".equals(riskCode)) {
			// 从表里取全损损失率
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
				// ratelimit3187 = ratelimit3187 + 0.01; // 老单子90%分界线处不算全损
			}
		}

		// 2016.4.8 湖北3151，赔款计算的全损比例调整至70%(现从数据库取值不按照条款定死)
		Double ratelimit3151HB = 70.00; // 若数据库取不出来值则默认是湖北条款的70%
		Double ratelimit3151AH = 80.00; // 若数据库取不出来值则默认是安徽条款的80%
		if ("3151".equals(riskCode)) {
			// 从表里取全损损失率
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

		// 不同险种全损损失率不定,所以全损损失率从数据库里取值,不定死;今后新的险种号往后罗列
		// 险种有:毛竹3176
		Double ratelimitOthers = 100.00; // 若取不出来值则默认是100%
		if ("3176".equals(riskCode) || "3178".equals(riskCode)
				|| "3158".equals(riskCode) || "3161".equals(riskCode)
				|| "3162".equals(riskCode) || "3164".equals(riskCode)) {
			// 从表里取全损损失率
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

		prpLctextList.add("理算过程如下:");
		prpLctextList.add("险别名称:" + KindName);
		String strSpace = "                      ";
		String strSpace1 = "             ";
		if (!"3172".equals(riskCode)) {
			String policyno = httpServletRequest.getParameter("PolicyNo");
			BLPrpCmain blprpcmain = new BLPrpCmain();
			PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
			String versionNo = "";
			Double ratelimit = 80.00; // 全损比例值一般都在80%
			blprpcmain.getData(policyno);
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			// 2016.3.15 湖北水稻3101，赔款计算的全损比例调整至70%
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
			// 2016.4.6 湖北水稻补充3151特殊处理全损损失率
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
					|| "3164".equals(riskCode)) // 今后全损率从数据库取值的险种号可以从这里罗列
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 损失率 ");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("全损：赔款金额=单位保额 × 赔付比例");
						prpLctextList.add(strSpace1
								+ " = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				} else if (versionNo.startsWith("B")) {
					if ((Double) DutyRateList.get(k) < 85.00) {
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 损失率 ");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("全损：赔款金额=单位保额 × 赔付比例");
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
						.add("赔款金额 = 单位保额 × 损失率 × 受损面积 ");
				prpLctextList.add(" = "
						+ Str.round(Double.parseDouble(dblSumRealpayMap.get(
								DeductibleRate).toString()), 2));
			}
			if (versionNo.startsWith("D")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < 90.00) {
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保额 × 损失面积 × 损失率");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) >= 90.00) {
						prpLctextList.add("全损：赔款金额=单位保险金额 × 损失面积 ");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
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
			// prpLctextList.add("赔款金额 = 单位保额 × 损失率 × 受损面积 × 投保面积/实有林地面积 × ( 1 -
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
					prpLctextList.add("损失率" + DutyRateList.get(k)
							+ "%：赔款金额 = 单位保额 × 赔付比例 × 赔付面积 × 损失率 × （ 1 - 免赔率）");
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
					prpLctextList.add("损失率" + DutyRateList.get(k)
							+ "%：赔款金额 = 保险金额 × 赔付比例 × 损失率 × 受损面积 × （ 1 - 免赔率）");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) == 100.00) {
					prpLctextList.add("绝产：赔款金额=保险金额 × 赔付比例 × 损失率 × 受损面积 ");
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 保险金额 × 赔付比例 × 损失率 × 受损面积");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("绝产：赔款金额=保险金额 × 赔付比例 × 受损面积 ");
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 保险金额 × 赔付比例 × 损失率 × 受损面积");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("绝产：赔款金额=保险金额 × 赔付比例 × 受损面积 ");
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 保险金额 × 赔付比例 × 损失率 × 受损面积");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("绝产：赔款金额=保险金额 × 赔付比例 × 受损面积 ");
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 保险金额 × 赔付比例 × 损失率 × 受损面积");
						prpLctextList.add(strSpace
								+ " = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) == 100.00) {
						prpLctextList.add("绝产：赔款金额=保险金额 × 赔付比例 × 受损面积 ");
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
					prpLctextList.add("损失率" + DutyRateList.get(k)
							+ "%：赔款金额 = 单位保额 × 损失面积 × 赔付比例 × 损失率 × （ 1 - 免赔率）");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " × "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " × "
							+ ClaimRate[DutyRateList.size()]
							+ "% × "
							+ DutyRateList.get(k)
							+ "% × (1 - "
							+ DeductibleRate
							+ "%)  = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= 90.00) {
					System.err.print("111" + (Double) (DutyRateList.get(k)));
					prpLctextList.add("全损：赔款金额=单位保险金额 × 赔付比例 × 损失面积 ");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " × "
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
							.add("损失率"
									+ DutyRateList.get(k)
									+ "%：赔款金额 = 单位保险金额  × 损失率 × 损失面积 × （ 1 - 免赔率） 或 赔款金额 = 单位保险金额  × 损失率 × 损失面积 -1000");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= 90.00) {
					prpLctextList
							.add("全损：赔款金额=单位保险金额  × 损失面积 × （ 1 - 免赔率） 或 单位保险金额  × 损失面积 - 1000");
					prpLctextList.add(strSpace1
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3176".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				if ((Double) DutyRateList.get(k) < ratelimitOthers) {
					prpLctextList.add("损失率" + DutyRateList.get(k)
							+ "%：赔款金额 = 每亩保险金额  × 损失率 × 损失面积");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " × "
							+ DutyRateList.get(k)
							+ "% × "
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
					prpLctextList.add("全损：赔款金额 = 每亩保险金额  × 损失面积");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " × "
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
					prpLctextList.add("损失率" + DutyRateList.get(k)
							+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " × "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " × "
							+ ClaimRate[DutyRateList.size()]
							+ "% × "
							+ DutyRateList.get(k)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) >= ratelimitOthers) {
					prpLctextList.add("全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											100.00).toString()), 2)
							+ " × "
							+ ClaimRate[DutyRateList.size()]
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		} else if ("3187".equals(riskCode)) {
			for (int k = 0; k < DutyRateList.size(); k++) {
				// 1-4年生牡丹
				if (itemCode.equals("Z002")) {
					if ((Double) DutyRateList.get(k) < ratelimit3187) {
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × （ 1 - 免赔率）");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ DutyRateList.get(k)
								+ "% × (1 - "
								+ DeductibleRate
								+ "%)  = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3187) {
						prpLctextList.add("全损：赔款金额 = 单位保险金额 × 损失率 × 损失面积 ");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
								+ DutyRateList.get(k)
								+ "% × "
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
				// 5年及以上生牡丹
				else if (itemCode.equals("Z003")) {
					if ((Double) DutyRateList.get(k) < ratelimit3187) {
						prpLctextList
								.add("损失率"
										+ DutyRateList.get(k)
										+ "%：赔款金额 = 单位保险金额 × 损失面积 × 赔付比例 × 损失率 × （ 1 - 免赔率）");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ DutyRateList.get(k)
								+ "% × (1 - "
								+ DeductibleRate
								+ "%) = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3187) {
						prpLctextList
								.add("全损：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × 损失率");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
				// 处理老单子的牡丹
				else {
					if ((Double) DutyRateList.get(k) < ratelimit3187) {
						prpLctextList
								.add("损失率"
										+ DutyRateList.get(k)
										+ "%：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × （损失率 - 20.0%）");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × ("
								+ DutyRateList.get(k)
								+ "% - 20.0%)  = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3187) {
						prpLctextList
								.add("全损：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × 损失率");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
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
			// 湖北
			if (versionNo.startsWith("C")) {
				for (int k = 0; k < DutyRateList.size(); k++) {
					if ((Double) DutyRateList.get(k) < ratelimit3151HB) {
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × 损失率");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					} else if ((Double) (DutyRateList.get(k)) >= ratelimit3151HB) {
						prpLctextList
								.add("全损：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × 损失率");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × 100% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												100.00).toString()), 2));
					}
				}
			}
			// 安徽
			else {
				System.err.println("zou");
				if ("3151".equals(riskCode)
						&& !checkRiskVersion("CLAIM_VERSIONDATEAH3151", "3151",
								httpServletRequest.getParameter("PolicyNo"))) {
					for (int k = 0; k < DutyRateList.size(); k++) {

						if ((Double) DutyRateList.get(k) < ratelimit3151AH) {
							prpLctextList.add("损失率" + DutyRateList.get(k)
									+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率");
							prpLctextList.add(strSpace
									+ " = "
									+ UnitAmount
									+ " × "
									+ Str.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
									+ " × "
									+ ClaimRate[DutyRateList.size()]
									+ "% × "
									+ DutyRateList.get(k)
									+ "% = "
									+ Str.round(Double
											.parseDouble(dblSumRealpaySumMap
													.get(DutyRateList.get(k))
													.toString()), 2));
						}
						if ((Double) (DutyRateList.get(k)) >= ratelimit3151AH) {
							prpLctextList.add("全损：赔款金额=单位保额 × 赔付面积 × 赔付比例");
							prpLctextList
									.add(strSpace1
											+ " = "
											+ UnitAmount
											+ " × "
											+ Str
													.round(
															Double
																	.parseDouble(dblSettleAreaSumSumMap
																			.get(
																					100.00)
																			.toString()),
															2)
											+ " × "
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
									.add("损失率"
											+ DutyRateList.get(k)
											+ "%：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × （损失率 - 10.0%）");
							prpLctextList.add(strSpace
									+ " = "
									+ UnitAmount
									+ " × "
									+ ClaimRate[DutyRateList.size()]
									+ "% × "
									+ Str.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
									+ " × ("
									+ DutyRateList.get(k)
									+ "% - 10.0%)  = "
									+ Str.round(Double
											.parseDouble(dblSumRealpaySumMap
													.get(DutyRateList.get(k))
													.toString()), 2));
						} else if ((Double) (DutyRateList.get(k)) >= ratelimit3151AH) {
							prpLctextList
									.add("全损：赔款金额 = 单位保险金额 × 赔付比例 × 损失面积 × 损失率");
							prpLctextList
									.add(strSpace1
											+ " = "
											+ UnitAmount
											+ " × "
											+ ClaimRate[DutyRateList.size()]
											+ "% × "
											+ Str
													.round(
															Double
																	.parseDouble(dblSettleAreaSumSumMap
																			.get(
																					DutyRateList
																							.get(k))
																			.toString()),
															2)
											+ " × "
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
			Double ratelimit = 80.00; // 全损比例一般都在80%
			blprpcmain.getData(policyno);
			if (blprpcmain.getSize() == 1) {
				prpCmainSchema = blprpcmain.getArr(0);
				versionNo = prpCmainSchema.getVersionNo();
			}
			// 2016.3.15 湖北水稻3101，赔款计算的全损比例调整至70%
			if (versionNo.startsWith("C") && "3101".equals(riskCode) || versionNo.startsWith("C") && "3107".equals(riskCode))
				ratelimit = 70.00;
			if ((versionNo.startsWith("D") && "3101".equals(riskCode))
					|| (versionNo.startsWith("C") && "3108".equals(riskCode))) {
				// 从表里取全损损失率
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × "
								+ DutyRateList.get(k)
								+ "% = "
								+ Str.round(
										Double.parseDouble(dblSumRealpaySumMap
												.get(DutyRateList.get(k))
												.toString()), 2));
					}
					if ((Double) (DutyRateList.get(k)) >= ratelimit) {
						
						if(versionNo.startsWith("C") && "3107".equals(riskCode)){
							prpLctextList.add("全损：赔款金额=单位保额 × 赔付面积 × 赔付比例");
							prpLctextList.add(strSpace
									+ " = "
									+ UnitAmount
									+ " × "
									+ Str.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
									+ " × "
									+ ClaimRate[DutyRateList.size()]
									+ "% = "
									+ Str.round(
											Double.parseDouble(dblSumRealpaySumMap
													.get(DutyRateList.get(k))
													.toString()), 2));
						}else{
						
						prpLctextList.add("全损：赔款金额=单位保额 × 赔付面积 × 赔付比例");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(100.00).toString()), 2)
								+ " × "
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
						prpLctextList.add("损失率" + DutyRateList.get(k)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × （损失率 - 免赔率）");
						prpLctextList.add(strSpace
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(DutyRateList.get(k))
												.toString()), 2)
								+ " × "
								+ ClaimRate[DutyRateList.size()]
								+ "% × ("
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
						prpLctextList.add("全损：赔款金额=单位保额 × 赔付面积 × 赔付比例");
						prpLctextList.add(strSpace1
								+ " = "
								+ UnitAmount
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(100.00).toString()), 2)
								+ " × "
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
					prpLctextList.add("损失率" + DutyRateList.get(k)
							+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × （损失率 - 免赔率）");
					prpLctextList.add(strSpace
							+ " = "
							+ UnitAmount
							+ " × "
							+ Str
									.round(Double
											.parseDouble(dblSettleAreaSumSumMap
													.get(DutyRateList.get(k))
													.toString()), 2)
							+ " × "
							+ ClaimRate[DutyRateList.size()]
							+ "% × ("
							+ DutyRateList.get(k)
							+ "%-"
							+ DeductibleRate
							+ "%) = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(DutyRateList.get(k)).toString()), 2));
				}
				if ((Double) (DutyRateList.get(k)) == 100.00) {
					prpLctextList.add("全损：赔款金额=单位保额 × 赔付面积 × 赔付比例");
					prpLctextList.add(strSpace1
							+ " = "
							+ UnitAmount
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											100.00).toString()), 2)
							+ " × "
							+ ClaimRate[DutyRateList.size()]
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(100.00).toString()), 2));
				}
			}
		}
		prpLctextList.add("赔付面积小计："
				+ Str.round(Double.parseDouble(dblSettleAreaMap.get(
						DeductibleRate).toString()), 2));
		prpLctextList.add("赔款金额小计："
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
	 * STUB-ONLY 多险别多标的种植险（不含中央政策性农险）生成理算报告
	 * 
	 * @param 无
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
	 * STUB-ONLY 多险别多标的种植险（不含中央政策性农险）生成理算报告
	 * 
	 * @param 无
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
		prpLctextList.add("理算过程如下:");
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
					totalLossRatePoint = 90.0; // 3134全损损失率是90%
				if (riskcode.equals("3157"))
					totalLossRatePoint = 80.0; // 3134全损损失率是90%
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
				prpLctextList.add("险别名称:"
						+ String.valueOf(kindNameMap.get(keyTemp)) + " 损失标的:"
						+ String.valueOf(itemNameMap.get(keyTemp)));
				kindCodePre = kindCodeTemp;
				itemCodePre = itemCodeTemp;
			}
			if (keyTemp.endsWith("_100")) {
				if (riskcode.equals("3173") || riskcode.equals("3157")) {
					if (!itemCodeTemp.equals("4312") && !itemCodeTemp.equals("4311")){
					prpLctextList.add(strSpace2
							+ "全损：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × 赔付比例");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " × "
							+ "100% × "
							+ claimRateMap.get(keyTemp)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4311")) { // 河南用
						prpLctextList.add(strSpace2
								+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例  × （1 - 免赔率）");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " × "
								+ claimRateMap.get(keyTemp)
								+ "% × ( 1 -"
								+ deductibleRateMap.get(keyTemp)
								+ "%)  = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4312")) {
						prpLctextList.add(strSpace2
								+ "全损：赔款金额 = 单位保险金额 × 损失面积  × 赔付比例");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " × "
								+ claimRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					}
				} else if (riskcode.equals("3232")) {
					prpLctextList.add(strSpace2
							+ "全损：赔款金额 = 单位保险金额 × 损失面积 × 赔付比例");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " × "
							+ claimRateMap.get(keyTemp)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				} else if (riskcode.equals("3134") || riskcode.equals("3141")) {
					if(riskcode.equals("3141") && (itemCodeTemp.indexOf("032")>-1 || itemCodeTemp.equals("6330"))) {
						String strDamageDate = httpServletRequest.getParameter("damageDate");
				        	//String strItemCode = prpCitemKindSchema.getItemCode();
				        	//if(null!=strItemCode && (strItemCode.indexOf("032")>-1||strItemCode.equals("6330"))){//032 蔬菜作物
				        String policyNo = httpServletRequest.getParameter("PolicyNo");
				        		BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new BLPrpCitemKindAgriFacade();
				        		String sqlCondition = " PolicyNo = '"+policyNo+"' And EndDate >= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And StratDate <= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And Times >0 ";
									Collection collection = blPrpCitemKindAgriFacade.findByConditions(sqlCondition);//获取茬次信息
									String strdistributingRate="";
									if(null != collection && collection.size() == 1){
										PrpCitemKindAgriDto prpCitemKindAgriDto = (PrpCitemKindAgriDto)collection.toArray()[0];
										double distributingRate = prpCitemKindAgriDto.getDistributingRate()/100;
										strdistributingRate=String.valueOf(distributingRate);	
									}
						
						prpLctextList
						.add(strSpace2
								+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × （1 - 免赔率）");
				prpLctextList.add(strSpace
						+ " = "
						+ unitAmountMapTemp.get(keyTemp)
						+ " × "
						+ Str.round(Double
								.parseDouble(dblSettleAreaSumSumMap.get(
										keyTemp).toString()), 2)
						+ " × "
						+ claimRateMap.get(keyTemp)
						+ "% "
 						//+ Str.round(Double.parseDouble(strdistributingRate), 2)
						+ " × ( 1 -"
						+ deductibleRateMap.get(keyTemp)
						+ "%)  = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					} else if (riskcode.equals("3141")) {
						prpLctextList
						.add(strSpace2
								+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率");
						prpLctextList.add(strSpace
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " × "
								+ claimRateMap.get(keyTemp)
								+ "% × "
								+ "100% "
								+ " = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					} else {
						prpLctextList
						.add(strSpace2
								+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 相应茬次保险金额分布比例 ×  (1 - 免赔率）");
				prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					}
			} else if (riskcode.equals("3140") ) {
				if(itemCodeTemp.indexOf("032")>-1) {
					prpLctextList
					.add(strSpace2
							+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 相应茬次保险金额分布比例");
			prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));
				} else {
					prpLctextList
					.add(strSpace2
							+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例  ×  (1 - 绝对免赔率）");
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
									+ "全损：赔款金额 = 单位保额 × 赔付数量 × 赔付比例 × 相应茬次保险金额分布比例 ");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				}
					else{
						prpLctextList
						.add(strSpace2
								+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 ");
						prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					}
					
				}
				else if (riskcode.equals("3182")) {

					prpLctextList
							.add(strSpace2
									+ "全损：不同生长期的最高赔偿标准×受损面积×（1-绝对免赔率） ");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));


					
				}
				else if (riskcode.equals("3184") || riskcode.equals("3183") || riskcode.equals("3180")|| riskcode.equals("3181")|| riskcode.equals("3170")|| riskcode.equals("31A6")) {
					prpLctextList.add(strSpace2
							+ "全损：赔款金额 = 单位保额 × 赔付面积 × 赔付比例");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " × "
							+ claimRateMap.get(keyTemp)
							+ "%  = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				} else {
					prpLctextList.add(strSpace2
							+ "全损：赔款金额=单位保额 × 赔付面积 × 赔付比例 × （1 - 免赔率）");
					prpLctextList.add(strSpace1
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " × "
							+ claimRateMap.get(keyTemp)
							+ "% × ( 1 -"
							+ deductibleRateMap.get(keyTemp)
							+ "%)  = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				}
			} else {
				if (riskcode.equals("3173") || riskcode.equals("3157")) {
					// 部分损失的葡萄公式和棚膜棚架不一样
					if (itemCodeList.get(k).equals("p001")) {
						prpLctextList
								.add(strSpace2
										+ "损失率"
										+ lossRateMap.get(keyTemp)
										+ "%：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × 赔付比例 × （ 1 - 免赔率）");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(keyTemp).toString()), 2)
								+ " × "
								+ lossRateMap.get(keyTemp)
								+ "% × "
								+ claimRateMap.get(keyTemp)
								+ "% × ( 1 -"
								+ deductibleRateMap.get(keyTemp)
								+ "%) = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												keyTemp).toString()), 2));
					}else if(itemCodeList.get(k).equals("2610")){
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × 赔付比例 × （ 1 - 免赔率）");
				prpLctextList.add(strSpace1
						+ " = "
						+ unitAmountMapTemp.get(keyTemp)
						+ " × "
						+ Str.round(Double
								.parseDouble(dblSettleAreaSumSumMap
										.get(keyTemp).toString()), 2)
						+ " × "
						+ lossRateMap.get(keyTemp)
						+ "% × "
						+ claimRateMap.get(keyTemp)
						+ "% × ( 1 -"
						+ deductibleRateMap.get(keyTemp)
						+ "%) = "
						+ Str.round(Double
								.parseDouble(dblSumRealpaySumMap.get(
										keyTemp).toString()), 2));
					} else if (!itemCodeTemp.equals("4312") && !itemCodeTemp.equals("4311")){
						prpLctextList.add(strSpace2 + "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × 赔付比例");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(keyTemp).toString()), 2)
								+ " × "
								+ lossRateMap.get(keyTemp)
								+ "% × "
								+ claimRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4311")) { // 河南用
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × 赔付比例 × （ 1 - 免赔率）");
				prpLctextList.add(strSpace1
						+ " = "
						+ unitAmountMapTemp.get(keyTemp)
						+ " × "
						+ Str.round(Double
								.parseDouble(dblSettleAreaSumSumMap
										.get(keyTemp).toString()), 2)
						+ " × "
						+ lossRateMap.get(keyTemp)
						+ "% × "
						+ claimRateMap.get(keyTemp)
						+ "% × ( 1 -"
						+ deductibleRateMap.get(keyTemp)
						+ "%) = "
						+ Str.round(Double
								.parseDouble(dblSumRealpaySumMap.get(
										keyTemp).toString()), 2));
					}
					if(riskcode.equals("3173") && itemCodeTemp.equals("4312")) { // 河南用
						prpLctextList.add(strSpace2 + "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保险金额 × 损失面积 × 损失率 × 赔付比例");
						prpLctextList.add(strSpace1
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap
												.get(keyTemp).toString()), 2)
								+ " × "
								+ lossRateMap.get(keyTemp)
								+ "% × "
								+ claimRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double
										.parseDouble(dblSumRealpaySumMap.get(
												keyTemp).toString()), 2));
					}
				} else if (riskcode.equals("3134")) {
					prpLctextList
							.add(strSpace2
									+ "损失率"
									+ lossRateMap.get(keyTemp)
									+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 相应茬次保险金额分布比例 × （损失率 - 免赔率）");
					prpLctextList.add(strSpace
							+ " = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));

				}else if (riskcode.equals("3141")) {
					if(itemCodeTemp.indexOf("032")>-1 || itemCodeTemp.equals("6330")) {
						String strDamageDate = httpServletRequest.getParameter("damageDate");
			        	//String strItemCode = prpCitemKindSchema.getItemCode();
			        	//if(null!=strItemCode && (strItemCode.indexOf("032")>-1||strItemCode.equals("6330"))){//032 蔬菜作物
			        String policyNo = httpServletRequest.getParameter("PolicyNo");
			        		BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new BLPrpCitemKindAgriFacade();
			        		String sqlCondition = " PolicyNo = '"+policyNo+"' And EndDate >= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And StratDate <= sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') And Times >0 ";
								Collection collection = blPrpCitemKindAgriFacade.findByConditions(sqlCondition);//获取茬次信息
								String strdistributingRate="";
								if(null != collection && collection.size() == 1){
									PrpCitemKindAgriDto prpCitemKindAgriDto = (PrpCitemKindAgriDto)collection.toArray()[0];
									double distributingRate = prpCitemKindAgriDto.getDistributingRate()/100;
									strdistributingRate=String.valueOf(distributingRate);	
								}
						
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率 × (1 - 免赔率）");
						prpLctextList.add(strSpace
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " × "
								+ claimRateMap.get(keyTemp)
								+ "% × "
		 						//+ Str.round(Double.parseDouble(strdistributingRate), 2)
		 						//+ " × "
		 						+ lossRateMap.get(keyTemp)
								+ "% × ( 1 -"
								+ deductibleRateMap.get(keyTemp)
								+ "%)  = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					} else {
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率");
						prpLctextList.add(strSpace
								+ " = "
								+ unitAmountMapTemp.get(keyTemp)
								+ " × "
								+ Str.round(Double
										.parseDouble(dblSettleAreaSumSumMap.get(
												keyTemp).toString()), 2)
								+ " × "
								+ claimRateMap.get(keyTemp)
								+ "% × "
		 						+ lossRateMap.get(keyTemp)
								+ "% = "
								+ Str.round(Double.parseDouble(dblSumRealpaySumMap
										.get(keyTemp).toString()), 2));
					}
					
				}else if (riskcode.equals("3140")) {
					if(itemCodeTemp.indexOf("032")>-1) {
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 相应茬次保险金额分布比例 × (损失率- 绝对免赔率）");
				prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					} else {
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × (损失率- 绝对免赔率）");
				prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));
					}
						
		        }else if (riskcode.equals("3163")) {
					if (itemCodeList.get(k).equals("31b1")) {
					prpLctextList
					.add(strSpace2
							+ "损失率"
							+ lossRateMap.get(keyTemp)
							+ "%：赔款金额 = 单位保额 × 赔付数量 × 赔付比例 × 相应茬次保险金额分布比例 × 损失率 ");
					prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));

					}
					else{
						prpLctextList
						.add(strSpace2
								+ "损失率"
								+ lossRateMap.get(keyTemp)
								+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例  × 损失率 ");
						prpLctextList.add(strSpace
						+ " = "
						+ Str.round(Double.parseDouble(dblSumRealpaySumMap
								.get(keyTemp).toString()), 2));

						}
						
					
						
				}
		        else if (riskcode.equals("3182")) {

					prpLctextList
					.add(strSpace2
							+ "损失率"
							+ lossRateMap.get(keyTemp)
							+ "%：赔款金额 = 不同生长期的最高赔偿标准×损失率×受损面积×（1-绝对免赔率） ");
					prpLctextList.add(strSpace
					+ " = "
					+ Str.round(Double.parseDouble(dblSumRealpaySumMap
							.get(keyTemp).toString()), 2));

					

					
						
				}
				else if (riskcode.equals("3184") || riskcode.equals("3183")|| riskcode.equals("3180")|| riskcode.equals("3181")|| riskcode.equals("3170")|| riskcode.equals("31A6")) {
					prpLctextList.add(strSpace2 + "损失率"
							+ lossRateMap.get(keyTemp)
							+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率");
					prpLctextList.add(strSpace
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " × "
							+ claimRateMap.get(keyTemp)
							+ "% × "
							+ lossRateMap.get(keyTemp)
							+ "% = "
							+ Str.round(Double.parseDouble(dblSumRealpaySumMap
									.get(keyTemp).toString()), 2));
				} else {
					prpLctextList.add(strSpace2 + "损失率"
							+ lossRateMap.get(keyTemp)
							+ "%：赔款金额 = 单位保额 × 赔付面积 × 赔付比例 × 损失率 × （1 - 免赔率）");
					prpLctextList.add(strSpace
							+ " = "
							+ unitAmountMapTemp.get(keyTemp)
							+ " × "
							+ Str.round(Double
									.parseDouble(dblSettleAreaSumSumMap.get(
											keyTemp).toString()), 2)
							+ " × "
							+ claimRateMap.get(keyTemp)
							+ "% × "
							+ lossRateMap.get(keyTemp)
							+ "% × ( 1 -"
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
			prpLctextList.add("赔付数量小计："+ dblSettle3163001Area);
		}else
		{
		prpLctextList.add("赔付面积小计："
				+ Str.round(Double.parseDouble(dblSettleAreaMap.get(
						deductibleRate).toString()), 2));
		}
		prpLctextList.add("赔款金额小计："
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
	 * STUB-ONLY 生成理算报告
	 * 
	 * @param 无
	 * @throws UserException
	 * @throws Exception
	 */
	public void createReport(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws UserException, Exception {
		// System.out.println("实质实质实质实质实质实质实质");

		PrpLlossDto prpLlossDto = null;
		PrpLpersonLossDto prpLpersonLossDto = null;
		PrpLchargeDto prpLchargeDto = null;
		PrpLcfeeDto prpLcfeeDto = null;

		// String[] arrPrpLctext = new String[70];
		// Modify by sunhao begin 2004-11-30 reason:原来用数组保存理算报告正文的方式改为集合
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
		// reason:修改意键险的默认行长度
		// modify by 项目组 孙兆云 险类27修改为07
		String strRiskType = uiCodeAction
				.translateRiskCodetoRiskType(prpLcompensateDto.getRiskCode());
		if ("E".equals(strRiskType)) {
			RULE_LENGTH = 80;
		}
		// modify by qinyongli end
		// Check Exist Of Compensate
		if (prpLcompensateDto == null) {
			throw new UserException(-98, -1, "BLCompensate.generateCtext()",
					"没有计算书信息，请确认！");
		} else {
			strCompensateNo = prpLcompensateDto.getCompensateNo();
		}

		// 1.对标的、费用、人员赔付信息进行分类汇总
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

			// 复制对象数据 2005-9-21
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

		// 2.计算书正文
		// 2.1 标的损失理算报告

		if (intLossCurr > 0) {
			prpLctextList.add("      ");
			curr = curr + 1;
			prpLctextList.add("***<赔付标的：>***");
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
				// prpLctextList.add(strSpace + "被保险人: " +
				// prpLlossDtoCurr.getFamilyName()); 2005-9-21 modify
				curr = curr + 1;
				// }

				// prpLctextList.add(strSpace + "受损标的名称：" +
				// prpLlossDtoCurr.getLossName()); 2005-9-21 modify
				curr = curr + 1;

				// intResult =
				// dbPrpDcurrency.getInfo(prpLlossDtoCurr.getCurrency4());
				dblSumRealpay = prpLlossDtoCurr.getSumRealPay();
				/* edit by lijingke 20040518 begin */
				/* reason: 允许赔款金额为负值 */
				if (dblSumRealpay < 0) {
					dblSumRealpay = -1 * dblSumRealpay;
					strChineseMoney = "负"
							+ MoneyUtils.toChinese(dblSumRealpay,
									prpLlossDtoCurr.getCurrency3());
				} else {
					strChineseMoney = MoneyUtils.toChinese(dblSumRealpay,
							prpLlossDtoCurr.getCurrency4());
				}
				/* edit by lijingke 20040518 end */
				// prpLctextList.add(strSpace + "受损标的赔偿金额：");
				curr = curr + 1;

				prpLctextList.add(strSpace
						+ "受损标的赔偿金额："
						+ uiCodeAction.translateCurrencyCode(prpLlossDtoCurr
								.getCurrency4(), true) + strChineseMoney.trim()
						+ strSpace + prpLlossDtoCurr.getCurrency4()
						+ prpLlossDtoCurr.getSumRealPay());
				curr = curr + 1;

				// prpLctextList.add(strSpace + strSpace + strSpace + strSpace +
				// "计算公式:");
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
					prpLctextList.add(strSpace + "标的损失 × 赔付比例 － 免赔额 ＝");
				} else {
					if (prpLlossDtoCurr.getDeductible() > 0) {
						prpLctextList.add(strSpace
								+ "(标的损失 － 残值) × 赔付比例 － 免赔额 ＝");
					} else {
						prpLctextList.add(strSpace
								+ "(标的损失 － 残值) × 赔付比例 ×(1-免赔率) ＝");
					}
				}
				curr = curr + 1;

				if (prpLlossDtoCurr.getRiskCode().equals(
						uiCodeAction.translateProductCode("RISKCODE_ZFG"))) {
					prpLctextList.add(strSpace + prpLlossDtoCurr.getSumLoss()
							+ "×" + prpLlossDtoCurr.getClaimRate() + "％" + "－"
							+ String.valueOf(Deductible) + "＝"
							+ prpLlossDtoCurr.getSumRealPay());
				} else {
					if (prpLlossDtoCurr.getDeductible() > 0) {
						prpLctextList.add(strSpace + "("
								+ prpLlossDtoCurr.getSumLoss() + "－"
								+ prpLlossDtoCurr.getSumRest() + ")" + "×"
								+ prpLlossDtoCurr.getClaimRate() + "％" + "－"
								+ String.valueOf(Deductible) + "＝"
								+ prpLlossDtoCurr.getSumRealPay());
					} else {
						prpLctextList.add(strSpace
								+ "("
								+ prpLlossDtoCurr.getSumLoss()
								+ "－"
								+ prpLlossDtoCurr.getSumRest()
								+ ")"
								+ "×"
								+ prpLlossDtoCurr.getClaimRate()
								+ "％*(1"
								+ "-"
								+ String.valueOf(prpLlossDtoCurr
										.getDeductibleRate()) + ")＝"
								+ prpLlossDtoCurr.getSumRealPay());
					}
				}

				dblSumLoss = dblSumLoss + dblSumRealpay;

				curr = curr + 1;
				prpLctextList.add("   ");

			}
		}

		// 2.3 人员赔付理算报告
		if (intPersonLossCurr > 0) {
			curr = curr + 1;

			prpLctextList.add("***<赔付人员：>***");
			for (i = 0; i < intPersonLossCurr; i++) {
				PrpLpersonLossDto prpLpersonLossDtoCurr = null;
				prpLpersonLossDtoCurr = (PrpLpersonLossDto) tmpPrpLpersonLossDtos
						.get(i);
				curr = curr + 1;
				prpLctextList.add(strSpace + "人员名称："
						+ prpLpersonLossDtoCurr.getPersonName());

				curr = curr + 1;
				strRiskType = uiCodeAction
						.translateRiskCodetoRiskType(prpLpersonLossDtoCurr
								.getRiskCode());

				if ("E".equals(strRiskType)) {

					prpLctextList.add(strSpace + strSpace
							+ "人员赔付金额 = (核损金额 - 免赔额) × 赔偿比例 ");
					curr = curr + 1;
					prpLctextList.add(strSpace + strSpace + strSpace + strSpace
							+ strSpace + " = "
							+ prpLpersonLossDtoCurr.getCurrency4()
							+ prpLpersonLossDtoCurr.getSumRealPay());
					// + "("+prpLpersonLossDtoCurr.getCurrency4() + ")";
				} else {
					prpLctextList.add(strSpace + strSpace + "人员赔付金额："
							+ prpLpersonLossDtoCurr.getCurrency4() + "  "
							+ prpLpersonLossDtoCurr.getSumRealPay());
				}

				dblSumPerson = dblSumPerson
						+ prpLpersonLossDtoCurr.getSumRealPay();
			}
			curr = curr + 1;
			prpLctextList.add("   ");
		}

		// 费用信息
		if (intChargeCurr > 0) {
			prpLctextList.add("***<费用信息：>***");
			for (i = 0; i < tmpPrpLchargeDtos.size(); i++) {
				prpLchargeDto = (PrpLchargeDto) tmpPrpLchargeDtos.get(i);

				// 改变显示的格式 2005-9-22
				// prpLctextList.add(strSpace + "费用名称：" +
				// prpLchargeDto.getChargeName());
				// prpLctextList.add(strSpace + "费用币别：" +
				// prpLchargeDto.getCurrency());
				// prpLctextList.add(strSpace + "费用金额：" +
				// prpLchargeDto.getSumRealPay());
				// prpLctextList.add("-------------------------------------------");
				prpLctextList.add(strSpace + prpLchargeDto.getChargeName()
						+ "：" + prpLchargeDto.getCurrency()
						+ prpLchargeDto.getSumRealPay());
				dblSumCharge = dblSumCharge + prpLchargeDto.getSumRealPay();
			}
			curr = curr + 1;
			prpLctextList.add("   ");
		}

		// 3.赔付信息汇总
		dblSumJE = dblSumLoss + dblSumCharge + dblSumPerson;

		curr = curr + 1;
		prpLctextList.add("***<金额合计：>***");
		if (compensateDto.getPrpLcfeeDtoList() != null) {
			for (i = 0; i < compensateDto.getPrpLcfeeDtoList().size(); i++) {
				prpLcfeeDto = new PrpLcfeeDto();
				prpLcfeeDto = (PrpLcfeeDto) compensateDto.getPrpLcfeeDtoList()
						.get(i);
				/*
				 * int intResult =
				 * dbPrpDcurrency.getInfo(prpLcfeeDto.getCurrency());
				 * if(intResult==100) { throw new
				 * UserException(-98,-1128,"BLCompensate.generateCtext()","获取
				 * dbPrpDcurrency 表记录失败[100]!"); }
				 */

				/* edit by lijingke 20040518 begin */
				/* reason: 允许赔款金额为负 */
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
							+ "冲减"
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
		// 存入Dto
		PrpLctextDto prpLctextDto = null;
		// modify by 项目组 孙兆云 险类27修改为07
		// if
		// (compensateDto.getPrpLcompensateDto().getRiskCode().substring(0,2).equals("27"))
		// { //意键险理赔根据客户要求，需要根据案件性质显示相应的模板。 2005-08-02
		// modify by lixiang start at 2006-1-20
		// reason, classcode不能substring这样取，并且6的也需要和7一样的格式
		// if
		// (compensateDto.getPrpLcompensateDto().getClassCode().equals("07")||compensateDto.getPrpLcompensateDto().getClassCode().equals("06"))
		// { //意键险理赔根据客户要求，需要根据案件性质显示相应的模板。 2005-08-02
		if (compensateDto.getPrpLcompensateDto().getClassCode().equals("27")
				|| compensateDto.getPrpLcompensateDto().getClassCode().equals(
						"26")
				|| compensateDto.getPrpLcompensateDto().getClassCode().equals(
						"28")) { // 意键险理赔根据客户要求，需要根据案件性质显示相应的模板。 2005-08-02

			// modify by lixiang end at 2006-1-20
			// 得到连接串,下面将其切分到数组
			String TextTemp = null;
			String[] rulesAcci = null;

			String strClaimType = compensateDto.getPrpLcompensateDto()
					.getCaseType(); // 案件类型
			String insuredName = compensateDto.getPrpLcompensateDto()
					.getInsuredName(); // 被保险人
			PrpLpersonLossDto prpLpersonLossDtoNew = null;

			// 分险别进行赔款汇总 2005-9-21
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

			// insuredName = prpLpersonLossDtoNew.getPersonName(); //出险人信息
			// 2005-9-17
			insuredName = compensateDto.getPrpLcompensateDto().getInsuredName(); // 出险人信息
			// 2005-9-17
			String strSex = prpLpersonLossDtoNew.getSex().equals("1") ? "先生"
					: "女士"; // 信息转化 2005-7-19
			String damageName = compensateDto.getPrpLcompensateDto()
					.getDamageName(); // 出险原因
			String policyNo = compensateDto.getPrpLcompensateDto()
					.getPolicyNo(); // 报单号
			String strRiskCode = compensateDto.getPrpLcompensateDto()
					.getRiskCode(); // 险种
			double dblPolicySumAmount = compensateDto.getPrpLcompensateDto()
					.getSumAmount(); // 报单保额
			String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo(); // 立案号
			String strAddInfo = "";
			// 如何获得投保人名称呢？？
			String strAppliName = compensateDto.getPrpLcompensateDto()
					.getAppliName();
			// String apliName =prpLpersonLossDtoNew.get
			if (strClaimType.equals("7")) { // 7:为拒赔案件
				prpLctextList.clear();
				prpLctextList.add("  ");
				prpLctextList.add("尊敬的" + insuredName + strSex);

				TextTemp = "您的理赔申请本公司已经获悉，根据保险条款及相关法律，并经审慎核定您所提供的有关资料与证明，本公司认为，"
						+ "您的申请事由不能成立，并做如下处理： ";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace
						+ "不予立案并退件/不予给付保险金/退还解约金CNY0.00元 ,解除本保险合同。");
				prpLctextList.add(strSpace + "本公司做出上述决定的理由是：");
				prpLctextList.add("  ");

				TextTemp = "若您对本公司的处理有异议，可于接到本通知之日起十日内向本公司理赔部门寻求解释。若您觉得仍无法获得满意的答复，您还享有以下权利： ";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace + "向仲裁机关申请仲裁/向人民法院提起诉讼");
				prpLctextList.add(strSpace + "请申请并审慎运用您的上述权利。");
			} else if (strClaimType.equals("8")) { // 8:为协议案件
				prpLctextList.clear();
				prpLctextList.add("  ");

				TextTemp = "兹有" + policyNo
						+ "号保单项下之权利人向我公司提出理赔申请，经双方协商，达成如下协议:";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace + "1. 保险公司同意给付保险金CNY" + dblSumJE
						+ "元整；");
				prpLctextList.add(strSpace + "2.上述保险金款项由" + insuredName
						+ "代表全体权利人受领；");
				prpLctextList.add(strSpace
						+ "3.全体权利人同意放弃上述保单项下其他所有与本保险事故有关之权利。");
				prpLctextList.add("合计给付保险金：CNY" + dblSumJE + "元");
			} else if (strClaimType.equals("5")) { // 5:为通融案件
				prpLctextList.clear();
				prpLctextList.add("  ");

				TextTemp = "兹有" + policyNo + "号保单项下" + insuredName + "（被保险人）发生"
						+ damageName + "事故不属于我司保险责任," + policyNo + "保单项下"
						+ "之权利人向我公司提出通融理赔申请，经我司审核后研究决定，同意通融给付并达成如下协议： ";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				prpLctextList.add(strSpace + "1. 保险公司同意通融给付保险金CNY" + dblSumJE
						+ "元整");
				prpLctextList.add(strSpace + "2.上述保险金款项由" + insuredName
						+ "代表全体权利人受领；");
				prpLctextList.add(strSpace
						+ "3.全体权利人同意放弃上述保单项下其他所有与本保险事故有关之权利。");
				prpLctextList.add("合计给付保险金：CNY" + dblSumJE + "元");
			} else {

				// 否则为0：一般赔案 1：速决赔案 B：议审案件中的一种
				prpLctextList.clear();
				prpLctextList.add("  ");
				// modify by lixiang start at 20051227
				// reason :客户要求修改审核的格式
				// TextTemp = "兹有" + insuredName + strSex + "因" + damageName +
				// "事故壹案提出理赔申请，经本公司审核属保险责任范围，同意如下批复： ";
				TextTemp = "兹有客户（赔案号" + claimNo + "）提出索赔申请，经本公司审核，同意如下各项批复：";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);

				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				TextTemp = "1、" + policyNo + "保单项下：投保人：（" + strAppliName
						+ "） 被保险人：（" + insuredName + "）";
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
							- prpLpersonLossDtoNew.getSumRealPay(); // 为核减后的险别保险金额
					strAddInfo = "";
					String codeNameNew = uiCodeAction.translateKindCode(
							prpLpersonLossDtoNew.getRiskCode(),
							prpLpersonLossDtoNew.getKindCode(), true);
					// 如果保险金额全赔完，则置为0元，且给提示信息。 2005-9-19
					if (dblUnitAmountSum2 < 0.0) {
						dblUnitAmountSum2 = 0.0;
						// strAddInfo = "同时，保险责任终止。";
					}
					TextTemp = TextTemp
							+ "  依据《"
							+ codeNameNew
							+ "条款》计算给付 （"
							+ insuredName
							+ "）保险金人民币："
							+ MoneyUtils.toChinese(prpLpersonLossDtoNew
									.getSumRealPay(), "CNY") + "（￥ "
							+ prpLpersonLossDtoNew.getSumRealPay() + "）。"
							+ strAddInfo;
					// System.out.println("TextTemp:"+ intCount+ TextTemp);
					if (dblUnitAmountSum2 == 0)
						TextTemp2 = TextTemp2
								+ "  （"
								+ uiCodeAction.translateRiskCode(
										prpLpersonLossDtoNew.getRiskCode(),
										true) + "）冲减保险金额： 人民币￥ 元。";
					else
						TextTemp2 = TextTemp2
								+ "  （"
								+ uiCodeAction.translateRiskCode(
										prpLpersonLossDtoNew.getRiskCode(),
										true)
								+ "）冲减保险金额： 人民币"
								+ MoneyUtils
										.toChinese(dblUnitAmountSum2, "CNY")
								+ "￥ " + dblUnitAmountSum2 + " 。";
					// System.out.println("TextTemp2:"+ intCount+ TextTemp2);
				}

				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				TextTemp = "2、自批改之日起" + policyNo + "保单项下：";
				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}
				rulesAcci = StringUtils.split(TextTemp2, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				TextTemp = "3、其他不变。";
				// modify by lixiang end at 20051227

				rulesAcci = StringUtils.split(TextTemp, RULE_LENGTH);
				for (int k = 0; k < rulesAcci.length; k++) {
					prpLctextList.add(strSpace + rulesAcci[k]);
				}

				// 添加带出计算公式功能 2005-9-18
				/*
				 * prpLpersonLossDtoNew = new PrpLpersonLossDto(); for (int
				 * intIndex = 0; intIndex < prpLpersonLossDtoListCopy.size();
				 * intIndex++) { prpLpersonLossDtoNew = (PrpLpersonLossDto)
				 * prpLpersonLossDtoListCopy.get(intIndex);
				 * prpLctextList.add(strSpace + strSpace +
				 * prpLpersonLossDtoNew.getLiabDetailName() + ":" +
				 * prpLpersonLossDtoNew.getRemark() + ";" + "赔付金额:"
				 * +compensateCurrency+ prpLpersonLossDtoNew.getSumRealPay() +
				 * "元"); }
				 * 
				 * prpLctextList.add(" "); prpLctextList.add("合计给付保险金:
				 * "+compensateCurrency + dblSumJE + "元");
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
		} else { // 非意健险理算模板信息
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
					prpLlossTempDto.setCurrencyName("人民币");
				}
				if (prpLlossTempDto.getCurrency().equals("USD")) {
					prpLlossTempDto.setCurrencyName("美元");
				}
				if (prpLlossTempDto.getCurrency1().equals("CNY")) {
					prpLlossTempDto.setCurrency1Name("人民币");
				}
				if (prpLlossTempDto.getCurrency1().equals("USD")) {
					prpLlossTempDto.setCurrency1Name("美元");
				}
				if (prpLlossTempDto.getCurrency2().equals("CNY")) {
					prpLlossTempDto.setCurrency2Name("人民币");
				}
				if (prpLlossTempDto.getCurrency2().equals("USD")) {
					prpLlossTempDto.setCurrency2Name("美元");
				}
				if (prpLlossTempDto.getCurrency3().equals("CNY")) {
					prpLlossTempDto.setCurrency3Name("人民币");
				}
				if (prpLlossTempDto.getCurrency3().equals("USD")) {
					prpLlossTempDto.setCurrency3Name("美元");
				}
				if (prpLlossTempDto.getCurrency4().equals("CNY")) {
					prpLlossTempDto.setCurrency4Name("人民币");
				}
				if (prpLlossTempDto.getCurrency4().equals("USD")) {
					prpLlossTempDto.setCurrency4Name("美元");
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
	 * 意外险数据整理
	 * 
	 * @param httpServletRequest
	 * @return compensateDto 实赔数据传输数据结构
	 * @throws Exception
	 */
	public CompensateDto viewToDtoForAccident(
			HttpServletRequest httpServletRequest) throws Exception {
		// 继承对compensate,compensateText表的赋值
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		UICodeAction uiCodeAction = new UICodeAction();

		ArrayList prpLpersonLossDtoList = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = null;
		String DangerUnitCheckSaveFlag = httpServletRequest
				.getParameter("DangerUnitCheckSaveFlag");
		// 加入危险单位处理 add by qinyongli 2005-9-10
		// reason: 目前只有一个危险单位，所以和标的信息放在一起处理，如果，有多个危险单位必须放入危险单位信息里面处理！
		ArrayList prpLprpLdangerTotList = new ArrayList(); // 理赔危险单位金额合计信息
		ArrayList prpLprpLdangerItemList = new ArrayList(); // 理赔的危险单位信息表

		PrpLdangerItemDto prpLdangerItemDto = null; // 标的DTO
		int dangerItemSerialNo = 1; // 用于存储标的的序号
		// 从界面得到输入数组
		String prpLpersonLossCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLpersonLossRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLpersonLossPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");

		String[] prplAcciPersonNo = httpServletRequest
				.getParameterValues("prplAcciPersonNo");// 几个事故者者
		String[] personLossSerialNo = httpServletRequest
				.getParameterValues("personLossSerialNo");// 几个事故者
		String[] prpLpersonLossLiabSerialNo = httpServletRequest
				.getParameterValues("prpLpersonLossLiabSerialNo");// 几条费用明细

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
		// 伤残等级,入院日期,出院日期,住院天数
		String[] prpLpersonLossInjuryGrade = httpServletRequest
				.getParameterValues("prpLpersonLossInjuryGrade");
		String[] prpLpersonLossInHospDate = httpServletRequest
				.getParameterValues("prpLpersonLossInHospDate");
		String[] prpLpersonLossOutHospDate = httpServletRequest
				.getParameterValues("prpLpersonLossOutHospDate");
		String[] prpLpersonLossHospitalDays = httpServletRequest
				.getParameterValues("prpLpersonLossHospitalDays");

		// 险别最大赔付额 2005-9-21
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

				// 加入危险单位收集 add by qinyongli 2005-9-10
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLpersonLossCompensateNo);
				 * //实赔号 prpLdangerItemDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemDto.setCurrency(prpLpersonLossCurrency[index]);
				 * //损失币别 prpLdangerItemDto.setKindFlag("0"); //险别归类标志,0表示正常
				 * prpLdangerItemDto.setKindName("正常"); //险别归类名称
				 * prpLdangerItemDto.setRiskCode(prpLpersonLossRiskCode); //险别
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //标的序号
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
				 * //已决赔款 prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
				prpLpersonLossDtoList.add(prpLpersonLossDto);
			}// end for
		}// end if
		// 赔付人员信息
		compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
		ArrayList prpllossDtoList = new ArrayList();
		compensateDto.setPrpLlossDtoList(prpllossDtoList);

		/*---------------------赔款费用信息prpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// 从界面得到输入数组
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
				.getParameterValues("prpLlossDtoItemKindNoForCharge"); // 意健险费用标的代码

		// 对象赋值
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

				// 加入危险单位收集 add by qinyongli 2005-9-10
				/*
				 * prpLdangerItemDto = new PrpLdangerItemDto();
				 * prpLdangerItemDto.setCertiNo(prpLchargeCompensateNo); //实赔号
				 * prpLdangerItemDto.setDangerNo(1); //目前只有一个危险单位
				 * prpLdangerItemDto.setCurrency(prpLchargeCurrency[index]);
				 * //损失币别 prpLdangerItemDto.setKindFlag("0"); //险别归类标志,0表示正常
				 * prpLdangerItemDto.setKindName("正常"); //险别归类名称
				 * prpLdangerItemDto.setRiskCode(prpLchargeRiskCode); //险别
				 * prpLdangerItemDto.setSerialNo(dangerItemSerialNo); //标的序号
				 * dangerItemSerialNo++;
				 * prpLdangerItemDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				 * //已决赔款 prpLprpLdangerItemList.add(prpLdangerItemDto);
				 */
				// add by qinyongli end 2005-9-10
				// 加入集合
				prpLchargeDtoList.add(prpLchargeDto);
			}
		}
		// 赔款费用信息
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// 从界面得到输入数组
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
		// 对象赋值
		// 赔款计算金额信息
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

		// 如果案件属于案终赔付，则需要结案报告文本
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
			// 得到连接串,下面将其切分到数组
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
			// ----------------------------危险单位信息处理,目前只有一个危险单位
			String TCurrency = httpServletRequest.getParameter("MergeCurrency");
			// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10
			// compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
			// 对标的信息进行处理，得到，合计信息
			ArrayList itemList = prpLprpLdangerItemList;
			PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto(); // 获取每个标的对象
			PrpLdangerItemDto dangerItem = new PrpLdangerItemDto(); // 循环判断时使用
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
			 * //用当前币别遍历集合进行统计 String currentCur = dangerItemAll.getCurrency();
			 * int currentSerial = dangerItemAll.getSerialNo();
			 * while(itemListIterator.hasNext()){ dangerItem =
			 * (PrpLdangerItemDto)itemListIterator.next();
			 * //如果币别相等，则对赔偿金额和费用进行累加
			 * if(currentSerial!=dangerItem.getSerialNo()&&currentCur.equals(dangerItem.getCurrency())){
			 * dangerItemAll1.setSumFee(dangerItemAll.getSumFee()+dangerItem.getSumFee());
			 * //合计费用
			 * dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid()+dangerItem.getSumPaid());
			 * //合计金额 } } if(tempCurrency.contains(currentCur)){ continue;
			 * //如果已经合计过的币种，不再进行合计; } tempCurrency.add(currentCur); //将当前合计的币种暂存 ;
			 * 
			 * //将标的信息加入合计Dto if(dangerItemAll!=null){
			 * prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
			 * prpLdangerTotDto.setDangerNo(1); //目前，就一个危险单位
			 * prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency());
			 * //标的原币别 prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
			 * prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
			 * prpLdangerTotDto.setTCurrency(TCurrency); //进行币别转化
			 * 转化后的币别为TCurrency String SCurrency = dangerItemAll.getCurrency();
			 * //原币别 double exchangeRate =
			 * PubTools.getExchangeRate(SCurrency,TCurrency,String.valueOf(new
			 * Date())); prpLdangerTotDto.setExchRate(exchangeRate);
			 * prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee()*exchangeRate);
			 * prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid()*exchangeRate); }
			 * if(prpLdangerTotDto!=null){
			 * prpLprpLdangerTotList.add(prpLdangerTotDto); } }
			 */
			// compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10 end
			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// start------------------------------------*/
			// add by kangzhen 061120 start reason 给再保送数据
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto
					.getPrpLcompensateDto().getPolicyNo());
			PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
			String strCoinsFlag = prpCmainDto.getCoinsFlag();
			// add by kangzhen 061120 end
			ArrayList dangerUnitList = new ArrayList();
			PrpLdangerUnitDto prpLdangerUnitDto = null;
			// 从界面得到输入数组
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
			double sumTempLoss = 0;// dangerUnit估损金额非最后一个累加值（解决精度问题）
			double sumTempPaid = 0;// dangerUnit已决赔款非最后一个累加值
			double sumTempNoPaid = 0;// dangerUnit未决赔款非最后一个累加值
			double tempLoss = 0;
			double tempPaid = 0;
			double tempNoPaid = 0;

			double sumLSumRealPay[] = new double[1000];

			// start
			// 国元新改方案-------------------------------------------------------------------------
			// 对象赋值
			if (prpLdangerCurrency == null) {
			} else {
				sql = " certino ='" + prpLdangerClaimNo[0] + "'";
				// 取立案的危险单位信息，根据 立案危险单位 生成 理算的危险单位信息
				List prpLdangerUnitClaimList = (ArrayList) blPrpLdangerUnitFacade
						.findByConditions(sql);
				for (int index = 0; index < prpLdangerCurrency.length; index++) {

					sumTempLoss = 0;
					sumTempPaid = 0;
					sumTempNoPaid = 0;

					double sumPaid = 0;
					double sumNoPaid = 0;

					// 取此立案的总未决
					if (!prpLdangerClaimNo[index].equals("")) {
						ClaimDto claimDto = new ClaimDto();
						UIClaimAction uiclaimAction = new UIClaimAction();
						claimDto = uiclaimAction
								.findByPrimaryKey(prpLdangerClaimNo[index]);
						sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
						sumNoPaid = Double
								.parseDouble(prpLdangerRiskSumClaim[index])
								- sumPaid;// 立案的总未决
					}

					// 根据 立案危险单位 生成 理算的危险单位信息
					for (int dangerUnitSize = 0; dangerUnitSize < prpLdangerUnitClaimList
							.size(); dangerUnitSize++) {
						List temPrpLprpLdangerItemList = new ArrayList();
						dangerItemSerialNo = 1;
						prpLdangerUnitClaimDto = (PrpLdangerUnitDto) prpLdangerUnitClaimList
								.get(dangerUnitSize);

						// 1、生成危险单位prpLdangerUnit
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
						if (dangerUnitSize == prpLdangerUnitClaimList.size() - 1)// 最后一个危险单位用减法算
						{
							tempLoss = Double
									.parseDouble(prpLdangerRiskSumClaim[index])
									- sumTempLoss;
							tempPaid = Double
									.parseDouble(prpLdangerRiskSumPaid[index])
									- sumTempPaid;
							tempNoPaid = sumNoPaid - sumTempNoPaid;

						}
						// 非最后一个危险单位用乘法算（乘以比例）
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
							prpLdangerUnitDto.setCertiType("3");// 案终为实赔
							prpLdangerUnitDto.setSumNoPaid(0); // 结案 未决赔款置零
						} else {
							prpLdangerUnitDto.setCertiType("3");
							// prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
						}
						prpLdangerUnitDto.setCoinsFlag(strCoinsFlag); // add
						// by
						// kangzhen
						// 加入集合
						if (prpLdangerPolicyNo[index] != null
								&& !(prpLdangerPolicyNo[index].equals(""))) {
							dangerUnitList.add(prpLdangerUnitDto);
						}

						// 2、生成此赔款危险单位标的prpLdangerItem（赔款）
						if (prpLpersonLossLiabSerialNo == null) {
						} else {
							double tempPersonRealPay = 0;
							for (int j = 1; j < prpLpersonLossLiabSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLpersonLossCompensateNo); // 实赔号
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto
										.setCurrency(prpLpersonLossCurrency[j]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto
										.setRiskCode(prpLpersonLossRiskCode); // 险别
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
										.setSerialNo(dangerItemSerialNo); // 标的序号
								dangerItemSerialNo++;
								// 已决赔款
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						// 3、生成此危险单位标prpLdangerItem（费用）
						if (prpLchargeSerialNo == null) {

						} else {
							double tempLchargeSumRealPay = 0;
							for (int j = 1; j < prpLchargeSerialNo.length; j++) {
								prpLdangerItemDto = new PrpLdangerItemDto();
								prpLdangerItemDto
										.setCertiNo(prpLchargeCompensateNo); // 实赔号
								prpLdangerItemDto
										.setDangerNo(prpLdangerUnitClaimDto
												.getDangerNo()); // 目前只有一个危险单位
								prpLdangerItemDto
										.setCurrency(prpLchargeCurrency[j]); // 损失币别
								prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
								prpLdangerItemDto.setKindName("正常"); // 险别归类名称
								prpLdangerItemDto
										.setRiskCode(prpLchargeRiskCode); // 险别
								if (dangerUnitSize == prpLdangerUnitClaimList
										.size() - 1) {
									tempLchargeSumRealPay = Double
											.parseDouble(DataUtils
													.nullToZero(prpLchargeChargeAmount[j]))
											- sumLSumRealPay[dangerItemSerialNo];
								} else {
									// 危险单位标的表不考虑费用是不是记入总赔款，全要记录到prpLdangerItem
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
										.setSerialNo(dangerItemSerialNo); // 标的序号
								dangerItemSerialNo++;
								prpLprpLdangerItemList.add(prpLdangerItemDto);
								temPrpLprpLdangerItemList
										.add(prpLdangerItemDto);
							}
						}

						// 4、生成此危险单位标金额合计PrpLdangerTotD（汇总prpLdangerItem）
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
						PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // 金额合计Dto
						prpLdangerTotDto.setCertiNo(compensateNo);
						prpLdangerTotDto.setDangerNo(prpLdangerUnitClaimDto
								.getDangerNo()); // 目前，就一个危险单位
						prpLdangerTotDto
								.setSCurrency(prpLdangerCurrency[index]); // 标的原币别
						prpLdangerTotDto.setSumFee(0);
						prpLdangerTotDto.setSumPaid(sumPaidAll);
						prpLdangerTotDto
								.setTCurrency(prpLdangerCurrency[index]);
						// 进行币别转化 转化后的币别为TCurrency
						/*
						 * String SCurrency = dangerItemAll.getCurrency(); //原币别
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
				// 赔款信息
				if (dangerUnitList.size() > 0) {
					compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
				}
				compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
				compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
			}
			// end
			// 国元新改方案-------------------------------------------------------------------------

			// ******---------------------危险单位信息 add by qinyongli 2005-8-19
			// end------------------------------------*/
		} else if (DangerUnitCheckSaveFlag.equals("2")) {
			// ******---------------------危险单位信息 国元项目组
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
			// 从界面得到输入数组

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
					.getParameterValues("prpLdangerUnitItemKindNo");// 标的序号

			String[] prpLdangerBusinessNature = httpServletRequest
					.getParameterValues("prpLdangerBusinessNature");// 业务来源
			String[] prpLdangerPolicyBizType = httpServletRequest
					.getParameterValues("prpLdangerPolicyBizType");// 保单业务类型
			String[] prpLdangerPolicyType = httpServletRequest
					.getParameterValues("prpLdangerPolicyType");// 投保方式
			String[] prpLdangerBusinessType1 = httpServletRequest
					.getParameterValues("prpLdangerBusinessType1");// 政策性标志
			String[] prpLdangerBusinessType = httpServletRequest
					.getParameterValues("prpLdangerBusinessType");// 涉农标识
			String[] prpLdangerOthFlag = httpServletRequest
					.getParameterValues("prpLdangerOthFlag");// 其他标识字段
			String[] prpLdangerBusinessProvince = httpServletRequest
					.getParameterValues("prpLdangerBusinessProvince");// 归属区域省
			String[] prpLdangerBusinessTown = httpServletRequest
					.getParameterValues("prpLdangerBusinessTown");// 归属区域市
			String[] prpLdangerBusinessCounty = httpServletRequest
					.getParameterValues("prpLdangerBusinessCounty");// 归属区域县
			String[] prpLdangerBusinessAreaName = httpServletRequest
					.getParameterValues("prpLdangerBusinessAreaName");// 归属区域乡镇
			// 1、生成此赔款危险单位标的prpLdangerItem
			if (prpLdangerCurrency == null) {

			} else {
				PrpLdangerItemDto prpLdangerItemNewDto = null;
				for (int index = 1; index < prpLdangerCurrency.length; index++) {

					prpLdangerItemNewDto = new PrpLdangerItemDto(); // 标的DTO
					prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); // 
					prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); // 危险单位
					prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); // 损失币别
					prpLdangerItemNewDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]);
					prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);
					prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); // 险别
					prpLdangerItemNewDto.setAddressName(prpLdangerAddressName[index]);
					prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
					prpLdangerItemNewDto.setDangerdesc(prpLdangerUnitDesc[index]);
					prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
					prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);

					// 占比最后一个减法原则
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
					isfee = false; //是否有费用，如果有则拆分到对应的险别代码和标的代码
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
	                   prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
				
	                   sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
					// 加入集合
					if (prpLdangerItemNewDto != null) {
						dangerItemList.add(prpLdangerItemNewDto);
					}
				}

				if (dangerItemList.size() > 0) {
					compensateDto.setPrpLprpLdangerItemList(dangerItemList);
				}
			}

			// 2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）

			Iterator iterator = null;
			PrpLdangerTotDto prpLdangerTotNewDto = null;
			Iterator itTot = null;
			PrpLdangerItemDto prpLdangerItemNewDto = null; // 标的DTO
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
					// 每个危险单位标的的第一次数据的生成
					if (find == false) {
						prpLdangerTotNewDto = new PrpLdangerTotDto();

						prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
						prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
						prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency()); // 标的原币别
						prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
						prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
						prpLdangerTotNewDto.setExchRate(1);
						prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
						prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto
								.getSumPaid());
						// 加入集合
						if (prpLdangerTotNewDto != null) {
							dangerTotList.add(prpLdangerTotNewDto);
						}

					}

				}

				if (dangerTotList.size() > 0) {
					compensateDto.setPrpLprpLdangerTotList(dangerTotList);
				}
			}

			// 3、生成危险单位prpLdangerUnit
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

					// 每个危险单位标的的第一次数据的生成
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
						// 加入集合
						if (prpLdangerUnitNewDto != null) {
							dangerUnitList.add(prpLdangerUnitNewDto);
						}
					}

				}
				// 最后一个占比减法原则
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
						prpLdangerUnitDtotemp.setSumNoPaid(0); // 结案 未决赔款置零
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

			// ******---------------------危险单位信息 国元项目组
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
	 * 获得理赔结论下拉列表选项
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
