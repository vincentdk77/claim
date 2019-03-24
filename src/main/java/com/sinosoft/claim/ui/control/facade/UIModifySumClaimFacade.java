package com.sinosoft.claim.ui.control.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrpDangerShareDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.ui.control.action.UIModifySumClaimAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerItem;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerTot;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerUnit;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.string.Str;

/**
 * �����������Facade
 * <p>
 * Title: ����������
 * </p>
 * <p>
 * Description: ��ϵͳ�еĹ�������е���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005 ������
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author qinyongli
 * @version 1.0
 */
public class UIModifySumClaimFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		// ҵ�����ͣ�ModifyBeforeQuery׼����ѯ����ʾ��Ϣ�б�modifyDetail��ʾ��������ϸ��Ϣ;modifySave�����޸ĺ����Ϣ;false�����쳣
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String editType = httpServletRequest.getParameter("editType");
		String isFirst = httpServletRequest.getParameter("isFirst"); // �Ƿ��һ�ν�������һ�ν�������ѯ���
		String riskCode = user.getRiskCode(); // ����
		String forward = ""; // ��ǰ

		if (isFirst == null || "".equals(isFirst)) {
			isFirst = "Y";
		}
		httpServletRequest.setAttribute("isFirst", isFirst);

		try {
			UIModifySumClaimAction uiModifySumClaimAction = new UIModifySumClaimAction();
			if ((editType.equals("modifyBeforeQuery") && "N".equals(isFirst))
					|| editType.equals("RegistBeforeQuery")) { // ׼����ѯ����ʾ��Ϣ�б�
				uiModifySumClaimAction.findClaimInforByCondition(httpServletRequest,
						httpServletResponse);
				editType = "modifyBeforeQuery";
			} else if (editType.equals("modifyDetail")) { // ��ʾ��������ϸ��Ϣ
				uiModifySumClaimAction.findDetailByClaimNo(httpServletRequest, httpServletResponse);
			} else if (editType.equals("modifySave")) { // �����޸ĺ����Ϣ
				uiModifySumClaimAction.saveClaimLoss(httpServletRequest, httpServletResponse);

				String prpLclaimLossClaimNo = httpServletRequest.getParameter("prpLclaimClaimNo");
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade
						.findByPrimaryKey(prpLclaimLossClaimNo);
				// ����Σ�յ�λ
				String DangerUnitCheckSaveFlag = httpServletRequest
						.getParameter("DangerUnitCheckSaveFlag");// Σ�յ�λ�����־λ
				if (DangerUnitCheckSaveFlag != null) {
					ClaimDto claimDto = new ClaimDto();
					int claimADDTimes = 0;// ����׷�Ӵ���
					PrpLdangerUnitDto prpLdangerUnitDto = null;
					BLPrpLdangerUnitFacade BLPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();

					String conditions = " certino='" + prpLclaimLossClaimNo + "'";
					ArrayList list = (ArrayList) BLPrpLdangerUnitFacade
							.findByConditions(conditions);

					for (int i = 0; i < list.size(); i++) {
						prpLdangerUnitDto = (PrpLdangerUnitDto) list.get(i);
						if (prpLdangerUnitDto.getClaimADDTimes() > claimADDTimes) {
							claimADDTimes = prpLdangerUnitDto.getClaimADDTimes();
						}
					}

					claimADDTimes += 1;

					// �þɵ�Σ�յ�λ��������
					if (DangerUnitCheckSaveFlag.equals("1")) {
						// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-16
						// start------------------------------------*/
						UIPolicyAction uiPolicyAction = new UIPolicyAction();
						PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimDto
								.getPolicyNo());
						PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
						String strCoinsFlag = prpCmainDto.getCoinsFlag();
						ArrayList dangerUnitList = new ArrayList();
						// �ӽ���õ���������
						String prpLdangerClaimNo = prpLclaimLossClaimNo;
						String[] prpLdangerPolicyNo = httpServletRequest
								.getParameterValues("prpLdangerPolicyNo");
						String[] prpLdangerRiskCode = httpServletRequest
								.getParameterValues("prpLclaimRiskCode");
						String[] prpLdangerUnitDesc = httpServletRequest
								.getParameterValues("prpLdangerUnitDesc");
						String[] prpLdangerAddressName = httpServletRequest
								.getParameterValues("prpLdangerAddressName");
						String[] prpLdangerCurrency = httpServletRequest
								.getParameterValues("prpLdangerCurrency");
						String[] prpLdangerRiskSumClaim = httpServletRequest
								.getParameterValues("prpLdangerRiskSumClaim");
						String[] prpLdangerProportion = httpServletRequest
								.getParameterValues("prpLdangerProportion");
						// ��������
						String prpLclaimDamageStartDate = httpServletRequest
								.getParameter("prpLclaimDamageStartDate");

						// ���Ĵ���
						int ednorserTimes = policyDto.getPrpCmainDto().getEndorseTimes();
						// ������
						String policyno = policyDto.getPrpCmainDto().getPolicyNo();
						List prpDangerShareList = new ArrayList();
						// ȡ�˱�����������������Σ�յ�λ�ı���
						prpDangerShareList = blPrpLclaimFacade.getDangerShareList(policyno,
								ednorserTimes, prpLclaimDamageStartDate);

						// ����ֵ
						double temSumLoss = 0;
						double sumLost = 0;// �����һ��Σ�յ�λ�ۼ�ֵ
						double temSumNoPaid = 0;
						double sumNoPaid = 0;// �����һ��Σ�յ�λ�ۼ�ֵ
						if (prpLdangerCurrency == null) {
						} else {
							for (int index = 0; index < prpLdangerCurrency.length; index++) {
								sumLost = 0;
								sumNoPaid = 0;
								PrpDangerShareDto prpdangerShareDto = new PrpDangerShareDto();

								if (prpDangerShareList != null && prpDangerShareList.size() > 0) {
									for (int i = 0; i < prpDangerShareList.size(); i++) {
										prpLdangerUnitDto = new PrpLdangerUnitDto();
										prpdangerShareDto = (PrpDangerShareDto) prpDangerShareList
												.get(i);
										prpLdangerUnitDto.setCertiNo(prpLdangerClaimNo);
										prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo);
										prpLdangerUnitDto.setCertiType("1");
										prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
										prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
										prpLdangerUnitDto.setDangerNo(prpdangerShareDto
												.getDangerNo());
										prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
										prpLdangerUnitDto
												.setAddressName(prpLdangerAddressName[index]);
										prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
										if (i == prpDangerShareList.size() - 1) {// ���һ��Σ�յ�λ�ü�����
											temSumLoss = Double
													.parseDouble(prpLdangerRiskSumClaim[index])
													- sumLost;
											temSumNoPaid = Double
													.parseDouble(prpLdangerRiskSumClaim[index])
													- sumNoPaid;
										} else {
											// �����һ��Σ�յ�λ�ó˷���
											temSumLoss = Double
													.parseDouble(prpLdangerRiskSumClaim[index])
													* prpdangerShareDto.getDangerShare() / 100;
											temSumNoPaid = Double
													.parseDouble(prpLdangerRiskSumClaim[index])
													* prpdangerShareDto.getDangerShare() / 100;
											sumLost += temSumLoss;
											sumNoPaid += temSumNoPaid;
										}
										prpLdangerUnitDto.setSumLoss(temSumLoss);
										prpLdangerUnitDto.setSumNoPaid(temSumNoPaid);
										prpLdangerUnitDto.setDangerShare(prpdangerShareDto
												.getDangerShare());
										prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);
										prpLdangerUnitDto.setDamageDate(prpLclaimDto
												.getDamageStartDate());
										prpLdangerUnitDto.setClaimDate(prpLclaimDto.getClaimDate());
										prpLdangerUnitDto.setClaimADDTimes(claimADDTimes);

										// ���뼯��
										if (prpLdangerClaimNo != null
												&& !(prpLdangerClaimNo.equals(""))) {
											dangerUnitList.add(prpLdangerUnitDto);
										}
									}
								}
							}
							if (dangerUnitList.size() > 0) {
								claimDto.setPrplRiskUnitDtoList(dangerUnitList);
							}
						}
						// ******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-16
						// end------------------------------------*/
					} else if (DangerUnitCheckSaveFlag.equals("2")) {
						// ���µ�Σ�յ�λ��������
						// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
						// start------------------------------------*/

						UIPolicyAction uiPolicyAction = new UIPolicyAction();
						PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimDto
								.getPolicyNo());
						PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
						String strCoinsFlag = prpCmainDto.getCoinsFlag();
						ArrayList dangerUnitList = new ArrayList();
						ArrayList dangerItemList = new ArrayList();
						ArrayList dangerTotList = new ArrayList();

						double temp = 0;
						double sumDangerUnit = 0d;
						boolean flag = true;
						// �ӽ���õ���������
						String prpLdangerClaimNo = prpLclaimLossClaimNo;// ������
						String[] prpLdangerPolicyNo = httpServletRequest
								.getParameterValues("prpLdangerPolicyNo");// ������
						String[] prpLdangerRiskCode = httpServletRequest
								.getParameterValues("prpLdangerRiskCode");// ���ֺ�
						String[] prpLdangerUnitDesc = httpServletRequest
								.getParameterValues("prpLdangerUnitDangerDesc");// Σ�յ�λ��
						String[] prpLdangerAddressName = httpServletRequest
								.getParameterValues("prpLdangerUnitAddressName");// Σ�յ�λ��ַ
						String[] prpLdangerCurrency = httpServletRequest
								.getParameterValues("prpLdangerCurrency");// �ұ�
						String[] prpLdangerUnitSumLoss = httpServletRequest
								.getParameterValues("prpLdangerUnitSumLoss");// ������
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

						// 1�����ɴ����Σ�յ�λ���prpLdangerItem
						if (prpLdangerCurrency == null) {

						} else {

							PrpLdangerItemDto prpLdangerItemDto = null;
							for (int index = 1; index < prpLdangerCurrency.length; index++) {
								if (Double.parseDouble(prpLdangerUnitSumLoss[index]) != 0
										&& Double.parseDouble(prpLdangerShare[index]) != 0) {
									prpLdangerItemDto = new PrpLdangerItemDto();
									prpLdangerItemDto.setCertiNo(prpLdangerClaimNo); // ������
									prpLdangerItemDto.setDangerNo(Integer
											.parseInt(prpLdangerDangerNo[index]));
									prpLdangerItemDto.setCurrency(prpLdangerCurrency[index]); // ��ʧ�ұ�
									prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
									prpLdangerItemDto.setKindCode(prpLdangerKindcode[index]);
									prpLdangerItemDto.setKindName(prpLdangerKindname[index]);
									prpLdangerItemDto.setRiskCode(prpLdangerRiskCode[index]);
									prpLdangerItemDto.setAddressName(prpLdangerAddressName[index]);
									prpLdangerItemDto.setPolicyno(prpLdangerPolicyNo[index]);
									prpLdangerItemDto.setDangerdesc(prpLdangerUnitDesc[index]);
									prpLdangerItemDto.setItemcode(prpLdangerItemCode[index]);
									prpLdangerItemDto.setItemname(prpLdangerItemName[index]);
									// ռ�����һ������ԭ��
									flag = true;
									for (int i = index + 1; i < prpLdangerCurrency.length; i++) {
										if (prpLdangerUnitItemKindNo[index]
												.equals(prpLdangerUnitItemKindNo[i])) {
											flag = false;
										}
									}
									if (flag) {
										temp = 0;
										for (int k = 1; k < index; k++) {
											if (prpLdangerUnitItemKindNo[k]
													.equals(prpLdangerUnitItemKindNo[index])) {
												temp += Str.round(Double
														.parseDouble(prpLdangerShare[k]), 2);
											}
										}
										prpLdangerItemDto.setDangerKindShare(Str.round(100 - temp,
												2));
									} else {
										prpLdangerItemDto.setDangerKindShare(Double
												.parseDouble(prpLdangerShare[index]));
									}

									prpLdangerItemDto.setSumPaid(Str.round(Double
											.parseDouble(prpLdangerUnitSumLoss[index]), 2));
									prpLdangerItemDto.setSerialNo(Integer
											.parseInt(prpLdangerUnitItemKindNo[index])); // ������
									prpLdangerItemDto.setClaimADDTimes(claimADDTimes);

									sumDangerUnit += Str.round(Double
											.parseDouble(prpLdangerUnitSumLoss[index]), 2);
									// ���뼯��
									if (prpLdangerItemDto != null) {
										dangerItemList.add(prpLdangerItemDto);
									}
								}
								if (dangerItemList.size() > 0) {
									claimDto.setPrpLdangerItemDtoList(dangerItemList);
								}
							}
						}

						// 2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��

						Iterator iterator = null;
						PrpLdangerTotDto prpLdangerTotDto = null;
						Iterator itTot = null;
						PrpLdangerItemDto prpLdangerItemDto = null; // ���DTO
						boolean find = true;
						if (dangerItemList != null) {
							iterator = dangerItemList.iterator();
							while (iterator.hasNext()) {
								prpLdangerItemDto = (PrpLdangerItemDto) iterator.next();
								find = false;
								itTot = dangerTotList.iterator();
								while (itTot.hasNext()) {
									prpLdangerTotDto = (PrpLdangerTotDto) itTot.next();
									if (prpLdangerTotDto.getDangerNo() == prpLdangerItemDto
											.getDangerNo()) {
										find = true;
										prpLdangerTotDto.setSumPaid(Str.round(prpLdangerTotDto
												.getSumPaid()
												+ prpLdangerItemDto.getSumPaid(), 2));
										prpLdangerTotDto.setSumPaidEx(Str.round(prpLdangerTotDto
												.getSumPaidEx()
												+ prpLdangerItemDto.getSumPaid(), 2));
										break;
									}
								}
								// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
								if (find == false) {
									prpLdangerTotDto = new PrpLdangerTotDto();

									prpLdangerTotDto.setCertiNo(prpLdangerClaimNo);
									prpLdangerTotDto.setDangerNo(prpLdangerItemDto.getDangerNo());
									prpLdangerTotDto.setSCurrency(prpLdangerItemDto.getCurrency()); // ���ԭ�ұ�
									prpLdangerTotDto.setSumFee(0);
									prpLdangerTotDto.setSumPaid(prpLdangerItemDto.getSumPaid());
									prpLdangerTotDto.setTCurrency(prpLdangerItemDto.getCurrency());
									prpLdangerTotDto.setExchRate(1);
									prpLdangerTotDto.setSumFeeEx(0);
									prpLdangerTotDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
									prpLdangerTotDto.setClaimADDTimes(claimADDTimes);
									// ���뼯��
									if (prpLdangerTotDto != null) {
										dangerTotList.add(prpLdangerTotDto);
									}

								}

							}

							if (dangerTotList.size() > 0) {
								claimDto.setPrpLdangerTotDtoList(dangerTotList);
							}
						}

						// 3������Σ�յ�λprpLdangerUnit

						Iterator itUnit = null;
						if (dangerItemList != null) {
							iterator = dangerItemList.iterator();
							while (iterator.hasNext()) {
								prpLdangerItemDto = (PrpLdangerItemDto) iterator.next();
								find = false;
								itUnit = dangerUnitList.iterator();
								while (itUnit.hasNext()) {
									prpLdangerUnitDto = (PrpLdangerUnitDto) itUnit.next();
									if (prpLdangerUnitDto.getDangerNo() == prpLdangerItemDto
											.getDangerNo()) {
										find = true;
										prpLdangerUnitDto.setSumLoss(Str.round(prpLdangerUnitDto
												.getSumLoss()
												+ prpLdangerItemDto.getSumPaid(), 2));
										prpLdangerUnitDto.setSumNoPaid(Str.round(prpLdangerUnitDto
												.getSumLoss(), 2));
										break;
									}
								}
								// ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
								if (find == false) {
									prpLdangerUnitDto = new PrpLdangerUnitDto();
									prpLdangerUnitDto.setCertiNo(prpLdangerClaimNo);
									prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo);
									prpLdangerUnitDto.setCertiType("1");
									prpLdangerUnitDto.setRiskCode(prpLdangerItemDto.getRiskCode());
									prpLdangerUnitDto.setPolicyNo(prpLdangerItemDto.getPolicyno());
									prpLdangerUnitDto.setDangerNo(prpLdangerItemDto.getDangerNo());
									prpLdangerUnitDto.setDangerDesc(prpLdangerItemDto
											.getDangerdesc());
									prpLdangerUnitDto.setAddressName(prpLdangerItemDto
											.getAddressName());
									prpLdangerUnitDto.setCurrency(prpLdangerItemDto.getCurrency());
									prpLdangerUnitDto.setSumLoss(prpLdangerItemDto.getSumPaid());
									prpLdangerUnitDto.setSumPaid(0);
									prpLdangerUnitDto.setSumNoPaid(prpLdangerItemDto.getSumPaid());
									prpLdangerUnitDto.setSumFee(0);
									prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);
									prpLdangerUnitDto.setDamageDate(prpLclaimDto
											.getDamageStartDate());
									prpLdangerUnitDto.setClaimDate(prpLclaimDto.getClaimDate());
									// prpLdangerUnitDto.setAgricultureflag(prpCmainDto.getBusinessType1());
									prpLdangerUnitDto.setClaimADDTimes(claimADDTimes);
									// ���뼯��
									if (prpLdangerUnitDto != null) {
										dangerUnitList.add(prpLdangerUnitDto);
									}
								}
							}
							// ���һ��ռ�ȼ���ԭ��
							double dangerShare = 0;
							double tempSumDangerShare = 0;
							PrpLdangerUnitDto prpLdangerUnitDtotemp = null;
							for (int i = 0; i < dangerUnitList.size(); i++) {
								prpLdangerUnitDtotemp = (PrpLdangerUnitDto) dangerUnitList.get(i);
								if (i == (dangerUnitList.size() - 1)) {
									dangerShare = Str.round(100 - tempSumDangerShare, 2);
								} else {
									dangerShare = Str.round(prpLdangerUnitDtotemp.getSumLoss()
											/ sumDangerUnit * 100, 2);
									tempSumDangerShare = Str.round(
											tempSumDangerShare + dangerShare, 2);
								}
								prpLdangerUnitDtotemp.setDangerShare(dangerShare);
							}

							if (dangerUnitList.size() > 0) {
								claimDto.setPrplRiskUnitDtoList(dangerUnitList);
							}
						}
						// ******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��
						// end------------------------------------*/
					}

					// �������ݿ�������
					DBManager dbManager = new DBManager();
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					// ��ʼ����
					dbManager.beginTransaction();
					try {
						// ������������Σ�յ�λ���ֱ��� 2011-01-14
						if (claimDto.getPrpLRiskUnitDtoList() != null) {
							new DBPrpLdangerUnit(dbManager).insertAll(claimDto
									.getPrpLRiskUnitDtoList());
						}
						// ������������Σ�յ�λ��Ϣ���� 2011-01-14
						if (claimDto.getPrpLdangerItemDtoList() != null) {
							new DBPrpLdangerItem(dbManager).insertAll(claimDto
									.getPrpLdangerItemDtoList());
						}
						// ������������Σ�յ�λ���ϼ���Ϣ���� 2011-01-14
						if (claimDto.getPrpLdangerTotDtoList() != null) {
							new DBPrpLdangerTot(dbManager).insertAll(claimDto
									.getPrpLdangerTotDtoList());
						}
						// �ύ����
						dbManager.commitTransaction();
					} catch (SQLException sqle) {
						// �ع�����
						dbManager.rollbackTransaction();
						throw sqle;
					} catch (Exception ex) {
						// �ع�����
						dbManager.rollbackTransaction();
						throw ex;
					} finally {
						// �ر����ݿ�����
						dbManager.close();
					}
				}
				
				if(prpLclaimDto!=null){
					new UIReinsTrialAction().simulateRepayByDangerNo(prpLclaimDto.getClaimNo(),prpLclaimDto.getClaimNo());
				    //�����ɷ��ⰸ
					Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + prpLclaimLossClaimNo + "'");
					prpLclaimDto= blPrpLclaimFacade.findByPrimaryKey(prpLclaimLossClaimNo);
					if (dangerUnit != null) {
						Iterator iter = dangerUnit.iterator();
						while (iter.hasNext()) {
							PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
							if(!prpLdangerUnitDto.getReinsureFlag().equals("1")){
								String newRepayNo = new BLRepayFacade().genRepay(
										prpLclaimLossClaimNo, 
										prpLdangerUnitDto.getDangerNo(),
										prpLclaimDto.getComCode(), 
										user.getUserCode(),
										prpLdangerUnitDto.getClaimADDTimes()
										);
								if (!newRepayNo.equals("")) {
									new BLRepayFacade().checkRepay(newRepayNo, user.getUserCode());
								}
							}
						}
					} 
				}

				httpServletRequest.setAttribute("successMessage", "����������ɹ�,�ⰸ��:");
				httpServletRequest.setAttribute("successNO", httpServletRequest
						.getParameter("prpLclaimClaimNo"));
			}
			forward = editType;
		} catch (UserException usee) {
			usee.printStackTrace();
			httpServletRequest.setAttribute("Content", "��ѯ������������Ϣ����");
			forward = "false";
		} catch (Exception e) {
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("������������Ϣ����");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
