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
 * 调整估损金额处理Facade
 * <p>
 * Title: 调整估损金额
 * </p>
 * <p>
 * Description: 对系统中的估损金额进行调整
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005 ００１
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

		// 业务类型：ModifyBeforeQuery准备查询并显示信息列表；modifyDetail显示估损金额详细信息;modifySave保存修改后的信息;false出现异常
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String editType = httpServletRequest.getParameter("editType");
		String isFirst = httpServletRequest.getParameter("isFirst"); // 是否第一次进来，第一次进来不查询结果
		String riskCode = user.getRiskCode(); // 险种
		String forward = ""; // 向前

		if (isFirst == null || "".equals(isFirst)) {
			isFirst = "Y";
		}
		httpServletRequest.setAttribute("isFirst", isFirst);

		try {
			UIModifySumClaimAction uiModifySumClaimAction = new UIModifySumClaimAction();
			if ((editType.equals("modifyBeforeQuery") && "N".equals(isFirst))
					|| editType.equals("RegistBeforeQuery")) { // 准备查询并显示信息列表
				uiModifySumClaimAction.findClaimInforByCondition(httpServletRequest,
						httpServletResponse);
				editType = "modifyBeforeQuery";
			} else if (editType.equals("modifyDetail")) { // 显示估损金额详细信息
				uiModifySumClaimAction.findDetailByClaimNo(httpServletRequest, httpServletResponse);
			} else if (editType.equals("modifySave")) { // 保存修改后的信息
				uiModifySumClaimAction.saveClaimLoss(httpServletRequest, httpServletResponse);

				String prpLclaimLossClaimNo = httpServletRequest.getParameter("prpLclaimClaimNo");
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade
						.findByPrimaryKey(prpLclaimLossClaimNo);
				// 新增危险单位
				String DangerUnitCheckSaveFlag = httpServletRequest
						.getParameter("DangerUnitCheckSaveFlag");// 危险单位保存标志位
				if (DangerUnitCheckSaveFlag != null) {
					ClaimDto claimDto = new ClaimDto();
					int claimADDTimes = 0;// 估损追加次数
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

					// 用旧的危险单位方法保存
					if (DangerUnitCheckSaveFlag.equals("1")) {
						// ******---------------------危险单位信息 add by qinyongli 2005-8-16
						// start------------------------------------*/
						UIPolicyAction uiPolicyAction = new UIPolicyAction();
						PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimDto
								.getPolicyNo());
						PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
						String strCoinsFlag = prpCmainDto.getCoinsFlag();
						ArrayList dangerUnitList = new ArrayList();
						// 从界面得到输入数组
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
						// 出险日期
						String prpLclaimDamageStartDate = httpServletRequest
								.getParameter("prpLclaimDamageStartDate");

						// 批改次数
						int ednorserTimes = policyDto.getPrpCmainDto().getEndorseTimes();
						// 保单号
						String policyno = policyDto.getPrpCmainDto().getPolicyNo();
						List prpDangerShareList = new ArrayList();
						// 取此保单离出险日期最近的危险单位的比例
						prpDangerShareList = blPrpLclaimFacade.getDangerShareList(policyno,
								ednorserTimes, prpLclaimDamageStartDate);

						// 对象赋值
						double temSumLoss = 0;
						double sumLost = 0;// 非最后一个危险单位累加值
						double temSumNoPaid = 0;
						double sumNoPaid = 0;// 非最后一个危险单位累加值
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
										if (i == prpDangerShareList.size() - 1) {// 最后一个危险单位用减法算
											temSumLoss = Double
													.parseDouble(prpLdangerRiskSumClaim[index])
													- sumLost;
											temSumNoPaid = Double
													.parseDouble(prpLdangerRiskSumClaim[index])
													- sumNoPaid;
										} else {
											// 非最后一个危险单位用乘法算
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

										// 加入集合
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
						// ******---------------------危险单位信息 add by qinyongli 2005-8-16
						// end------------------------------------*/
					} else if (DangerUnitCheckSaveFlag.equals("2")) {
						// 用新的危险单位方法保存
						// ******---------------------危险单位信息 国元项目组
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
						// 从界面得到输入数组
						String prpLdangerClaimNo = prpLclaimLossClaimNo;// 立案号
						String[] prpLdangerPolicyNo = httpServletRequest
								.getParameterValues("prpLdangerPolicyNo");// 保单号
						String[] prpLdangerRiskCode = httpServletRequest
								.getParameterValues("prpLdangerRiskCode");// 险种号
						String[] prpLdangerUnitDesc = httpServletRequest
								.getParameterValues("prpLdangerUnitDangerDesc");// 危险单位号
						String[] prpLdangerAddressName = httpServletRequest
								.getParameterValues("prpLdangerUnitAddressName");// 危险单位地址
						String[] prpLdangerCurrency = httpServletRequest
								.getParameterValues("prpLdangerCurrency");// 币别
						String[] prpLdangerUnitSumLoss = httpServletRequest
								.getParameterValues("prpLdangerUnitSumLoss");// 估损金额
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

						// 1、生成此赔款危险单位标的prpLdangerItem
						if (prpLdangerCurrency == null) {

						} else {

							PrpLdangerItemDto prpLdangerItemDto = null;
							for (int index = 1; index < prpLdangerCurrency.length; index++) {
								if (Double.parseDouble(prpLdangerUnitSumLoss[index]) != 0
										&& Double.parseDouble(prpLdangerShare[index]) != 0) {
									prpLdangerItemDto = new PrpLdangerItemDto();
									prpLdangerItemDto.setCertiNo(prpLdangerClaimNo); // 立案号
									prpLdangerItemDto.setDangerNo(Integer
											.parseInt(prpLdangerDangerNo[index]));
									prpLdangerItemDto.setCurrency(prpLdangerCurrency[index]); // 损失币别
									prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
									prpLdangerItemDto.setKindCode(prpLdangerKindcode[index]);
									prpLdangerItemDto.setKindName(prpLdangerKindname[index]);
									prpLdangerItemDto.setRiskCode(prpLdangerRiskCode[index]);
									prpLdangerItemDto.setAddressName(prpLdangerAddressName[index]);
									prpLdangerItemDto.setPolicyno(prpLdangerPolicyNo[index]);
									prpLdangerItemDto.setDangerdesc(prpLdangerUnitDesc[index]);
									prpLdangerItemDto.setItemcode(prpLdangerItemCode[index]);
									prpLdangerItemDto.setItemname(prpLdangerItemName[index]);
									// 占比最后一个减法原则
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
											.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
									prpLdangerItemDto.setClaimADDTimes(claimADDTimes);

									sumDangerUnit += Str.round(Double
											.parseDouble(prpLdangerUnitSumLoss[index]), 2);
									// 加入集合
									if (prpLdangerItemDto != null) {
										dangerItemList.add(prpLdangerItemDto);
									}
								}
								if (dangerItemList.size() > 0) {
									claimDto.setPrpLdangerItemDtoList(dangerItemList);
								}
							}
						}

						// 2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）

						Iterator iterator = null;
						PrpLdangerTotDto prpLdangerTotDto = null;
						Iterator itTot = null;
						PrpLdangerItemDto prpLdangerItemDto = null; // 标的DTO
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
								// 每个危险单位标的的第一次数据的生成
								if (find == false) {
									prpLdangerTotDto = new PrpLdangerTotDto();

									prpLdangerTotDto.setCertiNo(prpLdangerClaimNo);
									prpLdangerTotDto.setDangerNo(prpLdangerItemDto.getDangerNo());
									prpLdangerTotDto.setSCurrency(prpLdangerItemDto.getCurrency()); // 标的原币别
									prpLdangerTotDto.setSumFee(0);
									prpLdangerTotDto.setSumPaid(prpLdangerItemDto.getSumPaid());
									prpLdangerTotDto.setTCurrency(prpLdangerItemDto.getCurrency());
									prpLdangerTotDto.setExchRate(1);
									prpLdangerTotDto.setSumFeeEx(0);
									prpLdangerTotDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
									prpLdangerTotDto.setClaimADDTimes(claimADDTimes);
									// 加入集合
									if (prpLdangerTotDto != null) {
										dangerTotList.add(prpLdangerTotDto);
									}

								}

							}

							if (dangerTotList.size() > 0) {
								claimDto.setPrpLdangerTotDtoList(dangerTotList);
							}
						}

						// 3、生成危险单位prpLdangerUnit

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
								// 每个危险单位标的的第一次数据的生成
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
									// 加入集合
									if (prpLdangerUnitDto != null) {
										dangerUnitList.add(prpLdangerUnitDto);
									}
								}
							}
							// 最后一个占比减法原则
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
						// ******---------------------危险单位信息 国元项目组
						// end------------------------------------*/
					}

					// 创建数据库管理对象
					DBManager dbManager = new DBManager();
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					// 开始事务
					dbManager.beginTransaction();
					try {
						// 立案环节增加危险单位划分表处理 2011-01-14
						if (claimDto.getPrpLRiskUnitDtoList() != null) {
							new DBPrpLdangerUnit(dbManager).insertAll(claimDto
									.getPrpLRiskUnitDtoList());
						}
						// 立案环节增加危险单位信息表处理 2011-01-14
						if (claimDto.getPrpLdangerItemDtoList() != null) {
							new DBPrpLdangerItem(dbManager).insertAll(claimDto
									.getPrpLdangerItemDtoList());
						}
						// 立案环节增加危险单位金额合计信息表处理 2011-01-14
						if (claimDto.getPrpLdangerTotDtoList() != null) {
							new DBPrpLdangerTot(dbManager).insertAll(claimDto
									.getPrpLdangerTotDtoList());
						}
						// 提交事务
						dbManager.commitTransaction();
					} catch (SQLException sqle) {
						// 回滚事务
						dbManager.rollbackTransaction();
						throw sqle;
					} catch (Exception ex) {
						// 回滚事务
						dbManager.rollbackTransaction();
						throw ex;
					} finally {
						// 关闭数据库连接
						dbManager.close();
					}
				}
				
				if(prpLclaimDto!=null){
					new UIReinsTrialAction().simulateRepayByDangerNo(prpLclaimDto.getClaimNo(),prpLclaimDto.getClaimNo());
				    //再生成分赔案
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

				httpServletRequest.setAttribute("successMessage", "估损金额调整成功,赔案号:");
				httpServletRequest.setAttribute("successNO", httpServletRequest
						.getParameter("prpLclaimClaimNo"));
			}
			forward = editType;
		} catch (UserException usee) {
			usee.printStackTrace();
			httpServletRequest.setAttribute("Content", "查询立案估损金额信息出错");
			forward = "false";
		} catch (Exception e) {
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("调整估损金额信息出错");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
