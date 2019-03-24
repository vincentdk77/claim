package com.gyic.claim.ui.control.facade;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLendorFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowUWInterFaceFacade;
import com.sinosoft.claim.ui.control.viewHelper.AccidentCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.prpall.blsvr.cb.BLCPolicy;
import com.sinosoft.prpall.blsvr.pg.BLEndorse;
import com.sinosoft.prpall.dbsvr.pg.DBPrpPhead;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;

/**
 * �ַ�HTTP Post ��������ʵ��༭����
 * <p>
 * Title: ��������ʵ��༭������Ϣ
 * </p>
 * <p>
 * Description: ��������ʵ��༭������Ϣ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILCompensateEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; // ��ǰ��ת
		try {
			// ����˼·:
			// ---------------------------------------------------
			// ����ǵ�һ�α��棬ֻҪ�ܽ�״̬������ڴ�������ˡ���
			// �������������ڴ����״̬������д����ˡ�
			// ---------------------------------------------------
			// ȡ���������
			String[] prpLlossDtoSumRealPay = httpServletRequest.getParameterValues("prpLlossDtoSumRealPay");
			String sumRealPay=prpLlossDtoSumRealPay[1];
			httpServletRequest.setAttribute("sumRealPay", sumRealPay);
			String ClaimNo=httpServletRequest.getParameter("ClaimNo");
			String caseType=httpServletRequest.getParameter("caseType");
			String status=httpServletRequest.getParameter("status");
			String riskCode=httpServletRequest.getParameter("riskCode");
			String editType=httpServletRequest.getParameter("editType");
			String nodeType=httpServletRequest.getParameter("nodeType");
			String businessNo=httpServletRequest.getParameter("prpLcompensateCompensateNo");
			String keyIn=httpServletRequest.getParameter("keyIn");
			String policyNo=httpServletRequest.getParameter("policyNo");
			String modelNo=httpServletRequest.getParameter("modelNo");
			String nodeNo=httpServletRequest.getParameter("nodeNo");
			String dfFlag=httpServletRequest.getParameter("dfFlag");
			String compeCount=httpServletRequest.getParameter("compeCount");
			String combineNo=httpServletRequest.getParameter("combineNo");
			String prpLcompensateSumThisPaid=httpServletRequest.getParameter("prpLcompensateSumThisPaid");
			httpServletRequest.setAttribute("policyNo", policyNo);
			httpServletRequest.setAttribute("comBineNo", combineNo);
			String compensateNo = ""; // ��������
			String swfLogFlowID = httpServletRequest
					.getParameter("swfLogFlowID"); // ����������
			httpServletRequest.setAttribute("swfLogFlowID", swfLogFlowID);
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); // ������logno
			httpServletRequest.setAttribute("swfLogLogNo", swfLogLogNo);
            httpServletRequest.setAttribute("editType", editType);
			String combineUrl="ClaimNo="+ClaimNo+"&comBineNo="+combineNo+"&policyNo="+policyNo+"&status="+status+"&nodeType="+nodeType+"&editType="
			+editType+"&modelNo="+modelNo+"&swfLogLogNo="+swfLogLogNo+"&swfLogFlowID="+swfLogFlowID+"&compeCount="+compeCount+"&dfFlag="+dfFlag+"&nodeNo="
			+nodeNo+"&keyIn="+keyIn+"&prpLcompensateCompensateNo="+businessNo+"&caseType="+caseType+"&riskCode="+riskCode+"&SumThisPaid="+prpLcompensateSumThisPaid+"";
			httpServletRequest.setAttribute("combineUrl", combineUrl);
			int LogNo = Integer.parseInt(swfLogLogNo);
			UICodeAction uiCodeAction = new UICodeAction();
			int newCompensate = -1; // Ĭ�ϲ���Ҫ����������������,������������Ҫ�ù���������ÿ���������״̬
			UserDto user = (UserDto) httpServletRequest.getSession()
					.getAttribute("user");
			String riskCodeTemp = httpServletRequest
					.getParameter("prpLcompensateRiskCode");
			httpServletRequest.setAttribute("riskCode", riskCodeTemp);
            caseType = httpServletRequest
					.getParameter("prpLcompensateCaseType");
			httpServletRequest.setAttribute("caseType", caseType);
			if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
				user.setRiskCode(riskCodeTemp);
			}
			String comCode = user.getComCode();
            riskCode = user.getRiskCode();
			int year = DateTime.current().getYear();
			// ------------------------------------------------------------
			//У���Ƿ�ע��
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();  
			String strClaimNoTemp = (String) httpServletRequest.getParameter("prpLcompensateClaimNo");
			httpServletRequest.setAttribute("claimNo", strClaimNoTemp);
			String condition = "flowId ='"+swfLogFlowID+"' and nodeType='cance' and nodeStatus in ('0','2') and businessno='"+strClaimNoTemp+"'";
		       Collection cancelNodeList = uiWorkFlowAction.findNodesByConditions(condition);
		       if(cancelNodeList!=null&&cancelNodeList.size()>0){
		    	   throw new UserException(1,3,"1234","�����Ѿ�����ע�����⣡");
		       }
			
			// modify by ww add begin 2005-12-21
			// reason: ��ֹ�ظ��ύ
			String strLastAccessedTime = ""
					+ httpServletRequest.getSession().getLastAccessedTime()
					/ 1000;
			String oldLastAccessedTime = (String) httpServletRequest
					.getSession().getAttribute("oldCompensateLastAccessedTime");
			String strRiskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);

			/* modify by wuzheng ���μ������ύ�ɹ�����ʾҳ����������ť"�������"��"���ձ���"��20071112 begin */
			// String isCompensate = "Y";
			String isCompensate = "";
			/* modify by wuzheng ���μ������ύ�ɹ�����ʾҳ����������ť"�������"��"���ձ���"��20071112 end */

			String isNew = "old";

			// modify by ww add end 2005-11-15
			if (oldLastAccessedTime.trim().equals("")) {
				// modify by ww add begin 2005-11-15
				// reason: ��ֹ�ظ��ύ
				httpServletRequest.getSession().setAttribute(
						"oldCompensateLastAccessedTime", strLastAccessedTime);
				// modify by ww add end 2005-11-15
				//��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
				condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus ='4'";
			    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
			    if(certifyNodeList!=null&&certifyNodeList.size()>0){
			    	   throw new UserException(1,3,"������","�ð���������ڵ��Ѵ���");
			    }
				// ҵ�����
				compensateNo = httpServletRequest
						.getParameter("prpLcompensateCompensateNo");
				if (compensateNo == null || compensateNo.length() < 1
						|| compensateNo.trim().equals("")) {
					isNew = "new";
					UIBillAction uiBillAction = new UIBillAction();//
					String tableName = "prplcompensate";
					compensateNo = uiBillAction.getNo(tableName,
							httpServletRequest
									.getParameter("prpLcompensateClaimNo"),
							comCode, year);
					newCompensate = 1; // ������������ ������������Ƕ����������ۺ�ʱ������Ҫ�²�ڵ�
				}
				httpServletRequest.setAttribute("compensateNo", compensateNo);
				// ��viewHelper�����������
				BLPrpLclaimFacadeBase claimFacade=new BLPrpLclaimFacadeBase();
				PrpLclaimDto  claimDto1= new PrpLclaimDto();
				claimDto1=claimFacade.findByPrimaryKey(ClaimNo);
				String registNo=claimDto1.getRegistNo();
				httpServletRequest.setAttribute("registNo", registNo);
				CompensateDto compensateDto = null;

				
				
				// modify by wangli add start 20050519
				if ("D".equals(strRiskType)) {//����û������Σ�յ�λ�Ĵ���
					// modify by liuyanmei 20060221 end
					SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
					compensateDto = sunnyCompensateViewHelper
							.viewToDto(httpServletRequest);
				} else if ("H".equals(strRiskType) || "I".equals(strRiskType)) {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					compensateDto = accidentCompensateViewHelper
							.viewToDtoForAgri(httpServletRequest);
				} else if ("J".equals(strRiskType)) {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					compensateDto = accidentCompensateViewHelper
							.viewToDtoForJprop(httpServletRequest);
				} else {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					if (riskCode.substring(0, 2).equals("27")
							|| riskCode.substring(0, 2).equals("26")) {
						compensateDto = accidentCompensateViewHelper
								.viewToDtoForAccident(httpServletRequest);
					} else {
						compensateDto = accidentCompensateViewHelper
								.viewToDto(httpServletRequest);
					}
				}
				BLCompensateFacade bl = new BLCompensateFacade();
				if(bl.checkCompensateRelation(compensateDto)){
					throw new UserException(1,3,"12345","�⸶�����������ӷ��ã�");
				}
				
				// ũ��ͳ���ƶ�
				String claimNo = httpServletRequest.getParameter("prpLcompensateClaimNo");
				UIClaimAction uiClaimAction = new UIClaimAction();
				ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
			    String businessType = claimDto.getPrpLclaimDto().getBusinessType();
				String businessType1 = claimDto.getPrpLclaimDto().getBusinessType1();
				String businessFlag  = claimDto.getPrpLclaimDto().getBusinessFlag();
				String otherFlag	 = claimDto.getPrpLclaimDto().getOtherFlag();
				compensateDto.getPrpLcompensateDto().setBusinessType(businessType);
				compensateDto.getPrpLcompensateDto().setBusinessType1(businessType1);
				compensateDto.getPrpLcompensateDto().setBusinessFlag(businessFlag);
				compensateDto.getPrpLcompensateDto().setOtherFlag(otherFlag);
			
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				SwfLogDto swfLogDtoDealNode = new SwfLogDto();

				swfLogDtoDealNode.setNewMTask(newCompensate);

				// ������Ĵ��� ,������������Ĵ���
				if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
					swfLogDtoDealNode.setFlowID(swfLogFlowID);
					swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils
							.nullToZero(swfLogLogNo)));
				}

				if (newCompensate == 1) {
					swfLogDtoDealNode.setBusinessNo(compensateDto
							.getPrpLcompensateDto().getClaimNo()); // ���ڵ�Ĳ���
					swfLogDtoDealNode.setNextBusinessNo(compensateDto
							.getPrpLcompensateDto().getCompensateNo());

				} else {
					swfLogDtoDealNode.setBusinessNo(compensateDto
							.getPrpLcompensateDto().getCompensateNo()); // ���ڵ�Ĳ���
					swfLogDtoDealNode.setNextBusinessNo(compensateDto
							.getPrpLcompensateDto().getClaimNo());
				}

				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto()
						.getClaimNo());
				swfLogDtoDealNode.setNodeStatus((String) httpServletRequest
						.getParameter("buttonSaveType"));
				swfLogDtoDealNode.setKeyOut(compensateDto
						.getPrpLcompensateDto().getCompensateNo());

				// add by lixiang start at 2005-12-20
				// reason:����������ⰸ���еĺ����ύ������Ҫ��businessnoת���ɼ�������롣
				if (("3".equals(caseType) || "4".equals(caseType) || "6"
						.equals(caseType))
						&& "4".equals(swfLogDtoDealNode.getNodeStatus())) {
					swfLogDtoDealNode.setNextBusinessNo(compensateDto
							.getPrpLcompensateDto().getCompensateNo());
				}

				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
						swfLogDtoDealNode);
				// add by lym 20070327 ���������÷��ձ�-------
				String kindCode = "";
				String kk="";
				double chargeAmount = 0.00;
				double sumrealPay = 0.00;
				int serialNo = compensateDto.getPrpLchargeDtoList().size() + 1;
				int chargecount = compensateDto.getPrpLchargeDtoList().size() + 1;
				String policyno = compensateDto.getPrpLcompensateDto()
						.getPolicyNo();
				Collection prpLchargeDtoList = new ArrayList();

				boolean inderect = true;
				if (inderect) {
					if (compensateDto.getPrpLchargeDtoList() != null
							&& compensateDto.getPrpLchargeDtoList().size() > 0) {
						for (Iterator PrpLcharge = compensateDto
								.getPrpLchargeDtoList().iterator(); PrpLcharge
								.hasNext();) {
							PrpLchargeDto prpLchargeDto = (PrpLchargeDto) PrpLcharge
									.next();
							if (!"28".equals(prpLchargeDto.getChargeCode())) {
								PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
								kindCode = prpLchargeDto.getKindCode();
								chargeAmount = prpLchargeDto.getChargeAmount();
								sumrealPay = chargeAmount;
								prpLchargeKindDto.setCompensateNo(compensateNo);
								prpLchargeKindDto.setRiskCode(riskCode);
								prpLchargeKindDto.setKindCode(kindCode);
								prpLchargeKindDto.setPolicyNo(policyno);
								prpLchargeKindDto.setSerialNo(serialNo);
								prpLchargeKindDto.setChargeCode("28");
								prpLchargeKindDto.setChargeName("����������");
								prpLchargeKindDto.setCurrency("CNY");
								prpLchargeKindDto.setChargeAmount(chargeAmount);
								prpLchargeKindDto.setSumRealPay(sumrealPay);
								prpLchargeDtoList.add(prpLchargeKindDto);
								serialNo = serialNo + 1;
							}

						}
						inderect = false;

					} else {

						inderect = false;
					}

				}
				if (!inderect) {
					if (compensateDto.getPrpLlossDtoList() != null
							&& compensateDto.getPrpLlossDtoList().size() > 0) {
						for (Iterator prplloss = compensateDto
								.getPrpLlossDtoList().iterator(); prplloss
								.hasNext();) {
							PrpLlossDto prpLlossDto = (PrpLlossDto) prplloss
									.next();
							PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
							kindCode = prpLlossDto.getKindCode();
							chargeAmount = prpLlossDto.getSumRealPay();
							sumrealPay = chargeAmount;
							prpLchargeKindDto.setCompensateNo(compensateNo);
							prpLchargeKindDto.setRiskCode(riskCode);
							prpLchargeKindDto.setKindCode(kindCode);
							prpLchargeKindDto.setPolicyNo(policyno);
							prpLchargeKindDto.setSerialNo(serialNo);
							prpLchargeKindDto.setChargeCode("28");
							prpLchargeKindDto.setChargeName("����������");
							prpLchargeKindDto.setCurrency("CNY");
							prpLchargeKindDto.setChargeAmount(chargeAmount);
							prpLchargeKindDto.setSumRealPay(sumrealPay);
							prpLchargeDtoList.add(prpLchargeKindDto);
							serialNo = serialNo + 1;

						}
					}
					if (compensateDto.getPrpLpersonLossDtoList() != null
							&& compensateDto.getPrpLpersonLossDtoList().size() > 0) {
						for (Iterator prpLpersonLoss = compensateDto
								.getPrpLpersonLossDtoList().iterator(); prpLpersonLoss
								.hasNext();) {
							PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) prpLpersonLoss
									.next();
							PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
							kindCode = prpLpersonLossDto.getKindCode();
							chargeAmount = prpLpersonLossDto.getSumRealPay();
							sumrealPay = chargeAmount;
							prpLchargeKindDto.setCompensateNo(compensateNo);
							prpLchargeKindDto.setRiskCode(riskCode);
							prpLchargeKindDto.setKindCode(kindCode);
							prpLchargeKindDto.setPolicyNo(policyno);
							prpLchargeKindDto.setSerialNo(serialNo);
							prpLchargeKindDto.setChargeCode("28");
							prpLchargeKindDto.setChargeName("����������");
							prpLchargeKindDto.setCurrency("CNY");
							prpLchargeKindDto.setChargeAmount(chargeAmount);
							prpLchargeKindDto.setSumRealPay(sumrealPay);
							prpLchargeDtoList.add(prpLchargeKindDto);
							serialNo = serialNo + 1;

						}

					}

				}
				int m = chargecount;
				Collection prpLchargeList = new ArrayList();
				HashMap hashMapTemp = new HashMap();
				hashMapTemp = new HashMap();

				PrpLchargeDto prpLchargeKindDto = new PrpLchargeDto();
				if (prpLchargeDtoList != null && prpLchargeDtoList.size() > 0) {
					for (Iterator it = prpLchargeDtoList.iterator(); it
							.hasNext();) {
						PrpLchargeDto prpLchargeDto = (PrpLchargeDto) it.next();
						if (!"04".equals(prpLchargeDto.getChargeCode())
								&& !"18".equals(prpLchargeDto.getChargeCode())) {
							kindCode = prpLchargeDto.getKindCode();
							//�رռ���������
							//chargeAmount = (prpLchargeDto.getChargeAmount() * 0.025);
							  chargeAmount = (prpLchargeDto.getChargeAmount() * 0);
							//�رռ���������
							sumrealPay = chargeAmount;
							if (hashMapTemp.containsKey(kindCode)) {
								prpLchargeKindDto = (PrpLchargeDto) hashMapTemp
										.get(kindCode);
								prpLchargeKindDto
										.setChargeAmount(prpLchargeKindDto
												.getChargeAmount()
												+ chargeAmount);
								prpLchargeKindDto
										.setSumRealPay(prpLchargeKindDto
												.getSumRealPay()
												+ sumrealPay);

							} else {
								prpLchargeKindDto = new PrpLchargeDto();
								prpLchargeKindDto.setKindCode(kindCode);
								prpLchargeKindDto
										.setKindName(uiCodeAction
												.translateKindCode(
														prpLchargeDto
																.getRiskCode(),
														kindCode, true));
								prpLchargeKindDto.setCompensateNo(compensateNo);
								prpLchargeKindDto.setRiskCode(riskCode);
								prpLchargeKindDto.setPolicyNo(policyno);
								prpLchargeKindDto.setSerialNo(m);
								prpLchargeKindDto.setChargeCode("28");
								prpLchargeKindDto.setChargeName("����������");
								prpLchargeKindDto.setCurrency("CNY");
								prpLchargeKindDto.setChargeAmount(chargeAmount);
								prpLchargeKindDto.setSumRealPay(sumrealPay);
								m++;
							}

							hashMapTemp.put(kindCode, prpLchargeKindDto);
						}
					}
				}

				double sumThisPaid = Double.parseDouble(httpServletRequest
						.getParameter("prpLcompensateSumThisPaid"));
				double sumPaid = compensateDto.getPrpLcompensateDto()
						.getSumPaid();
				double sumDutyPaid = compensateDto.getPrpLcompensateDto()
						.getSumDutyPaid();

				// ��hashmap�����ֵȡ����
				Collection collection = hashMapTemp.values();
				if (collection.size() > 0) {
					prpLchargeList = new ArrayList();
				}
				Iterator iterator = collection.iterator();
				while (iterator.hasNext()) {
					PrpLchargeDto prpLchargeKindDtotemp = (PrpLchargeDto) iterator
							.next();
					/*
					 * GYNB-170 FENGLEI ��Ԫ�汾����Ҫ���������� satrt
					 */
					// prpLchargeList.add(prpLchargeKindDtotemp);
					/*
					 * GYNB-170 FENGLEI ��Ԫ�汾����Ҫ���������� end
					 */
					// sumPaid += prpLchargeKindDtotemp.getChargeAmount();
					// sumDutyPaid +=prpLchargeKindDtotemp.getChargeAmount();
					// sumThisPaid += prpLchargeKindDtotemp.getChargeAmount();
					// compensateDto.getPrpLcompensateDto().setSumPaid(sumPaid);
					// compensateDto.getPrpLcompensateDto().setSumDutyPaid(sumDutyPaid);
					// compensateDto.getPrpLcompensateDto().setSumThisPaid(sumThisPaid);
				}
				//�رռ��������ÿ�ʼ
			
//			    compensateDto.getPrpLcompensateDto().setSumPaid(
//			 			sumPaid + sumPaid * 0.025);
//				compensateDto.getPrpLcompensateDto().setSumDutyPaid(
//						sumDutyPaid + sumPaid * 0.025);
//				compensateDto.getPrpLcompensateDto().setSumThisPaid(
//						sumThisPaid + sumPaid * 0.025);
				compensateDto.getPrpLcompensateDto().setSumPaid(
						sumPaid);
				compensateDto.getPrpLcompensateDto().setSumDutyPaid(
						sumDutyPaid);
				compensateDto.getPrpLcompensateDto().setSumThisPaid(
						sumThisPaid);
				//�رռ��������ý���
				compensateDto.getPrpLchargeDtoList().addAll(prpLchargeList);

				String endorseNo = "";
				BLPrpLendorFacade blPrpLendorFacade = new BLPrpLendorFacade();
				int count = -1;
				String Sql = "CompensateNo = '" + compensateNo
						+ "' and EndorType = '14'";
				count = blPrpLendorFacade.getCount(Sql);
				if (count > 0) {
					ArrayList prpLendorDtoList = new ArrayList();
					prpLendorDtoList = (ArrayList) blPrpLendorFacade
							.findByConditions(Sql);
					PrpLendorDto prpLendorDto = new PrpLendorDto();
					prpLendorDto = (PrpLendorDto) prpLendorDtoList.get(0);
					endorseNo = prpLendorDto.getEndorseNo();
					blPrpLendorFacade.deleteByConditions(Sql);

					DbPool dbPool = new DbPool();
					dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
					DBManager dbManager = dbPool.getDBManager(SysConfig
							.getProperty("DDCCDATASOURCE"));

					BLCPolicy blCPolicy = new BLCPolicy();
					BLEndorse blEndorse = new BLEndorse();
					DBPrpPhead dbPrpPhead = new DBPrpPhead();
					DBWfLog dbWfLog = new DBWfLog(dbManager);
					try {
						dbPool.beginTransaction();
						dbPrpPhead.getInfo(dbPool, endorseNo);
						blCPolicy.cancel(dbPool, policyno, "Y");
						blEndorse.cancel(dbPool, endorseNo);
						dbWfLog.deleteUWTrace(dbManager, endorseNo);
						dbPool.commitTransaction();
					} catch (Exception e) {
						dbPool.rollbackTransaction();
					}finally{
					    dbManager.close();
						dbPool.close();//����finally,��֤�ܹ������ر�����
					}
				}

				int count2 = -1;
				String Sql2 = "CompensateNo = '" + compensateNo
						+ "' and EndorType = '72'";
				count2 = blPrpLendorFacade.getCount(Sql2);
				if (count2 > 0) {
					ArrayList prpLendorDtoList = new ArrayList();
					prpLendorDtoList = (ArrayList) blPrpLendorFacade
							.findByConditions(Sql2);
					PrpLendorDto prpLendorDto = new PrpLendorDto();
					prpLendorDto = (PrpLendorDto) prpLendorDtoList.get(0);
					endorseNo = prpLendorDto.getEndorseNo();
					blPrpLendorFacade.deleteByConditions(Sql2);

					DbPool dbPool = new DbPool();
					dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
					DBManager dbManager = dbPool.getDBManager(SysConfig
							.getProperty("DDCCDATASOURCE"));

					BLCPolicy blCPolicy = new BLCPolicy();
					BLEndorse blEndorse = new BLEndorse();
					DBPrpPhead dbPrpPhead = new DBPrpPhead();
					DBWfLog dbWfLog = new DBWfLog(dbManager);
					try {
						dbPool.beginTransaction();
						dbPrpPhead.getInfo(dbPool, endorseNo);
						blCPolicy.cancel(dbPool, policyno, "Y");
						blEndorse.cancel(dbPool, endorseNo);
						dbWfLog.deleteUWTrace(dbManager, endorseNo);
						dbPool.commitTransaction();
					} catch (Exception e) {
						dbPool.rollbackTransaction();
					}finally{
					    dbManager.close();
						dbPool.close();//����finally,��֤�ܹ������ر�����
					}
				}
				// ------------------------------------------------------------
				// ��������������Ϣ
				UICompensateAction uiCompensateAction = new UICompensateAction();
				int vericLogNo = 0;
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					// ���ӶԺ˱�����ϵͳ�Ľӿڵ��á�
					if (swfLogDtoDealNode.getNodeStatus().equals("4")) {

						// modify by lixiang start at 2006-08-22
						// reason:ֱ�ӱ���ҵ�����ݵ��¹��������ݶ�ʧ�������ύǰ��Ҫ��ʱ���浽���ڴ����״̬��
						// �ύǰ����ʱ����
						WorkFlowDto workFlowDtoTemp = null;
						swfLogDtoDealNode.setNodeStatus("2");
						workFlowDtoTemp = workFlowViewHelper.viewToDto(user,
								swfLogDtoDealNode);
						// �ݴ������ڵ�ʱ������ڵ�״̬��Ϊ�Ѵ���
						UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
						SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
								swfLogFlowID, LogNo);
						if (swfLogDto.getNodeType().equals("compe")) {
							swfLogDto.setNodeStatus("4");
							workFlowDtoTemp.setUpdate(true);
							workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
						}
						
						// ����ύ����ʧ����״̬Ϊ0
						compensateDto.getPrpLcompensateDto().setUnderWriteFlag(
								"0");
						uiCompensateAction.save(compensateDto, workFlowDtoTemp);

						// ����ύ������״̬Ϊ9
						if (httpServletRequest.getParameter("buttonSaveType")
								.equals("4")) {
							compensateDto.getPrpLcompensateDto()
									.setUnderWriteFlag("9");
						}
						// modify by lixiang end at 2006-08-22
						if (workFlowDto.getSubmitSwfLogDtoList() != null
								&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
							vericLogNo = ((SwfLogDto) workFlowDto
									.getSubmitSwfLogDtoList().get(0))
									.getLogNo();
						}

						// add end 2005-10-19
						UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
						String UWflowID = uiWorkFlowUWInterFaceFacade
								.submitVericTask(workFlowDto
										.getUpdateSwfLogDto().getFlowID(),
										vericLogNo + "", "22", "C",
										compensateDto.getPrpLcompensateDto()
												.getCompensateNo(),
										compensateDto.getPrpLcompensateDto()
												.getRiskCode(), compensateDto
												.getPrpLcompensateDto()
												.getClassCode(), compensateDto
												.getPrpLcompensateDto()
												.getComCode(), compensateDto
												.getPrpLcompensateDto()
												.getHandlerCode(),
										compensateDto.getPrpLcompensateDto()
												.getMakeCom(), user
												.getUserCode(), compensateDto
												.getPrpLcompensateDto()
												.getHandler1Code(), "");
						if (UWflowID.length() < 15) {
							String msg = "����'" + compensateNo
									+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
							throw new UserException(1, 3, "������", msg);
						}

						// add by lixiang start at 2006-08-22
						// reason:ֱ�ӱ���ҵ�����ݵ��¹��������ݶ�ʧ�������ύǰ��Ҫ��ʱ���浽���ڴ����״̬�����Ƿ���˫�˳ɹ�����Ҫ������ύ���ݡ�
						if (newCompensate == 1) { // Ҫ�����µ�workFlowDtoΪ�ύ��״̬��
							// ���� workFlowDtoTemp ��workFlowDto
							int newCompeLogNo = 0;
							if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
								newCompeLogNo = ((SwfLogDto) workFlowDtoTemp
										.getSubmitSwfLogDtoList().get(0))
										.getLogNo();
								((SwfLogDto) workFlowDtoTemp
										.getSubmitSwfLogDtoList().get(0))
										.setNodeStatus("4");
								workFlowDto.setUpdate(true);
								workFlowDto
										.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp
												.getSubmitSwfLogDtoList()
												.get(0));
							}
							if (workFlowDto.getSubmitSwfLogDtoList() != null) {
								// ɾ������ĵ�
								for (int i = 0; i < workFlowDto
										.getSubmitSwfLogDtoList().size(); i++) {
									if (((SwfLogDto) workFlowDto
											.getSubmitSwfLogDtoList().get(i))
											.getLogNo() == newCompeLogNo) {
										workFlowDto.getSubmitSwfLogDtoList()
												.remove(i);
										break;
									}

								}
							}

							if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
								// ɾ������ı�
								for (int i = 0; i < workFlowDto
										.getSubmitSwfPathLogDtoList().size(); i++) {
									if (((SwfPathLogDto) workFlowDto
											.getSubmitSwfPathLogDtoList()
											.get(i)).getEndNodeNo() == newCompeLogNo) {
										workFlowDto
												.getSubmitSwfPathLogDtoList()
												.remove(i);
										break;
									}

								}
							}
							// add by lixiang end at 2006-08-22
						}

					}
					// �˴��޸�����ڵ�״̬����Ҫ�������ݴ�ʱʹ�á�
					UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
							swfLogFlowID, LogNo);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLog2Dto(swfLogDto);
					}
					uiCompensateAction.save(compensateDto, workFlowDto);
					// Modify by chenrenda begin 20070704
					// ���������ע�Ϳ���ԭ�򣬼���������β���
					/*
					 * ���� GYNB-170 ��Ԫ�汾����Ҫ���������� start
					 */
					// chargeAmount = sumPaid*0.025;
					// BLPrpLchargeFacade blPrpLchargeFacade = new
					// BLPrpLchargeFacade();
					// String conditions = "chargeCode = '28' and compensateno =
					// '" +
					// compensateDto.getPrpLcompensateDto().getCompensateNo()+"'
					// order by serialNo";
					// Collection prpLcharge28DtoList =
					// blPrpLchargeFacade.findByConditions(conditions);
					// if(prpLcharge28DtoList.size()==1){}
					// else{
					// BLPrpLchargeFacade blPrpLchargeFacade1 = new
					// BLPrpLchargeFacade();
					// int maxSerialNo =
					// blPrpLchargeFacade1.getMaxSerialNo(conditions);
					// Iterator iterator1 = prpLcharge28DtoList.iterator();
					// double chargeAmount28 = 0;
					// while(iterator1.hasNext()){
					// PrpLchargeDto prpLchargeDtoTemp = (PrpLchargeDto)
					// iterator1.next();
					// if(prpLchargeDtoTemp.getSerialNo()!=maxSerialNo){
					// chargeAmount28 += prpLchargeDtoTemp.getChargeAmount();
					// }
					// }
					// PrpLchargeDto prpLchargeDtoTemp =
					// blPrpLchargeFacade1.findByPrimaryKey(compensateNo,
					// maxSerialNo);
					// prpLchargeDtoTemp.setSumRealPay(chargeAmount-chargeAmount28);
					// prpLchargeDtoTemp.setChargeAmount(chargeAmount-chargeAmount28);
					// blPrpLchargeFacade1.update(prpLchargeDtoTemp);
					// }
					/*
					 * ���� GYNB-170 ��Ԫ�汾����Ҫ���������� end
					 */
					// //Modify by chenrenda end 20070704
					compensateDto.getPrpLcompensateDto().setRemark("remark");
					user.setUserMessage(compensateNo);
				} else {
					uiCompensateAction.save(compensateDto);
					user
							.setUserMessage(compensateNo
									+ ";ע��:û�з����빤������������κ����ݣ���");
				}

				httpServletRequest.setAttribute("prpLcompensateDto",
						compensateDto.getPrpLcompensateDto());
				
				//������������ֲ�������д ũ�����ӵ�����Ϣ
				if(null!=compensateDto.getPrpLcompensateDto()&&null!=compensateDto.getPrpLcompensateDto().getRiskCode()&&!"".equals(compensateDto.getPrpLcompensateDto().getRiskCode())
						&&"3101,3107,3108,3114,3122,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3149,3148,3150,3174,3151,3197,3185,3165,3166,3184,3152,3153,3154,3155,3156,3228,3224,3190,3191,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(compensateDto.getPrpLcompensateDto().getRiskCode())>-1){
					String claimRelateNo = "";//�����嵥��
					String strClaimNo = "";//������
					String strRegistNo = "";//������
					String strCompensateNo = "";//�������
					claimRelateNo = compensateDto.getPrpLcompensateDto().getClaimRelationNo();
					strClaimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
					strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
					if(null!=strClaimNo&&!"".equals(strClaimNo)){
						PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(strClaimNo);
						if(null!=prpLclaimDto){
							strRegistNo = prpLclaimDto.getRegistNo();
						}
					}
					if(null!=claimRelateNo&&!"".equals(claimRelateNo)){
						new BLPrpLcompensateFacade().update(strRegistNo, strClaimNo, strCompensateNo, claimRelateNo);
					}
				}
			} else {
				throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
			}
			ActionMessages messages = new ActionMessages();

			if (httpServletRequest.getParameter("buttonSaveType").trim()
					.equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.compensate.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.compensate.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"db.prpLcompensate.compensateNo"));
			saveMessages(httpServletRequest, messages);

			String buttonSaveType = httpServletRequest.getParameter(
					"buttonSaveType").trim();
			httpServletRequest.setAttribute("compensateNo", compensateNo);
			httpServletRequest.setAttribute("isCompensate", isCompensate);
			httpServletRequest.setAttribute("isNew", isNew);
			httpServletRequest.setAttribute("buttonSaveType", buttonSaveType);

			forward = "success";
			String printFlag = httpServletRequest
					.getParameter("prpLcompensatePrintFlag");
			if (printFlag != null && printFlag.trim().equals("1")) {
				httpServletResponse
						.sendRedirect("/claim/ClaimPrint.do?printType=Compensate&CompensateNo="
								+ compensateNo);
			}
			
			
		} catch (UserException usee) {
			usee.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		}
		return actionMapping.findForward(forward);
	}
}