package com.sinosoft.claim.query.ui.control.viewHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.sinosoft.claim.bl.facade.BLPrpLaccipersonFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.query.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.query.ui.control.actioin.UICompensateAction;
import com.sinosoft.claim.query.ui.control.actioin.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.query.ui.control.actioin.UIWorkFlowAction;
import com.sinosoft.claim.query.ui.control.actioin.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowEngineViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowStatViewHelper;
import com.sinosoft.claim.ui.model.SwfLogFindByConditionsCommand;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.StringConvert;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.dto.domain.PrplcombineSwfLogDto;
import com.sinosoft.platform.bl.facade.BLPowerFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.claim.query.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;

/**
 * <p>
 * Title: ScheduleViewHelper
 * </p>
 * c
 * <p>
 * Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� lixiang
 * @version 1.0 <br>
 */

public class WorkFlowViewHelper {
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public WorkFlowViewHelper() {// COM.IIDIDispatch
	}

	/* ========================��һ���֣����������������======================== */
	/**
	 * ��������������������,�˺����������й�������ת��������ڣ� ��֪���������������ת�ģ��������������ɡ�
	 * 
	 * @param user
	 *            UserDto �û�dto
	 * @param swfLogFunctionInDto
	 *            ������
	 * @throws Exception
	 * @return WorkFlowDto �����������ݴ������ݽṹ
	 */
	public WorkFlowDto viewToDto(UserDto user, SwfLogDto swfLogFunctionInDto)
			throws Exception {
		// ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
		WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		return workFlowEngineViewHelper.viewToDto(user, swfLogFunctionInDto);
	}
	
	public WorkFlowDto viewToDtoMedical(UserDto user, SwfLogDto swfLogFunctionInDto)
    throws Exception {
		 // ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
		 WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		 return workFlowEngineViewHelper.viewToDtoMedical(user, swfLogFunctionInDto);
	}

	/* ========================�ڶ����֣������������������======================== */
	/**
	 * ���˵Ĺ�����(����ģ����л���)
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param flowID
	 *            String ���������̱���
	 * @param logNo
	 *            int ����������˳���
	 * @param keyOut
	 *            String ��¼�½ڵ��KeyOut��ֵ�������˻ص����ݾͿ���ֱ�Ӱ�ҵ��ĺ����޸�
	 * @throws Exception
	 * @return WorkFlowDto
	 */
	public WorkFlowDto getBackFlowInfo(HttpServletRequest httpServletRequest,
			String flowID, int logNo, String keyOut) throws Exception {
		WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		return workFlowEngineViewHelper.getBackFlowInfo(httpServletRequest,
				flowID, logNo, keyOut);
	}

	/**
	 * ���˵Ĺ�����(�����˶��˵ķ�ʽ���л��ˣ���ֻ����һ���ڵ���ʲô�����ƺ��ύ������)
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param flowID
	 *            String ���������̱���
	 * @param logNo
	 *            int ����������˳���
	 * @param keyOut
	 *            String ��¼�½ڵ��KeyOut��ֵ�������˻ص����ݾͿ���ֱ�Ӱ�ҵ��ĺ����޸�
	 * @throws Exception
	 * @return WorkFlowDto
	 */
	public WorkFlowDto getBackFlowInfo(UserDto user, String flowID, int logNo)
			throws Exception {
		WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		return workFlowEngineViewHelper.getBackFlowInfo(user, flowID, logNo);
	}

	/* ========================�������������������������============================ */

	/* ========================�������֣�������ͼ��չ�ֲ���======================== */
	/**
	 * ���ù��������̵�����
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param businessNo
	 *            String
	 * @throws Exception
	 */
	public void setFlowDtoToView(HttpServletRequest httpServletRequest,
			String businessNo) throws Exception {
		WorkFlowImageViewHelper workFlowImageViewHelper = new WorkFlowImageViewHelper();
		workFlowImageViewHelper
				.setFlowDtoToView(httpServletRequest, businessNo);
		// added by zhangli 20070427 �õ�������֧��״̬
		UICompensateAction uICompensateAction = new UICompensateAction();
		ArrayList payTotalList = new ArrayList();
		ArrayList compensateList = new ArrayList();
		try {
			compensateList = uICompensateAction.getCompensateList(businessNo);
			if (compensateList.size() > 0) {
				Iterator it = compensateList.iterator();
				while (it.hasNext()) {
					String compensateNo = (String) it.next();
					String realPayreffee = uICompensateAction
							.fetchPayFee(compensateNo);
					String payDate = uICompensateAction
							.fetchPaycompensateFinalDate(compensateNo);
					// �õ��������˵�����
					String policyNo = "";
					String registNo = (String) httpServletRequest
							.getAttribute("registNo");
					//com.sinosoft.claim.ui.control.action.UIRegistAction uIRegistAction = new com.sinosoft.claim.ui.control.action.UIRegistAction();
					com.sinosoft.claim.query.ui.control.actioin.UIRegistAction uIRegistAction = new com.sinosoft.claim.query.ui.control.actioin.UIRegistAction();
					RegistDto registDto = uIRegistAction
							.findByPrimaryKey(registNo);
					policyNo = registDto.getPrpLclaimStatusDto().getPolicyNo();
					String insuredName = uICompensateAction
							.fetchInsuredName(policyNo);
					ArrayList payList = new ArrayList();
					payList.add(compensateNo);
					payList.add(insuredName);
					payList.add(realPayreffee);
					payList.add(payDate);
					payTotalList.add(payList);
				}
			}
			httpServletRequest.setAttribute("payTotalList", payTotalList);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/* ========================��������ͼ��չ�ֲ���������============================ */

	/* ========================���Ĳ��֣���������ѯ����======================== */

	/**
	 * ���ݽڵ�����Ͳ���״̬��������Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */
	public void getWorkFlowLogList(HttpServletRequest httpServletRequest,
			String nodeType, String status, String alertMessage)
			throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo = httpServletRequest.getParameter("pageNo");
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
		if (nodeType == null || nodeType.trim().length() < 1) {
			conditions = getNodeTaskListConditions(httpServletRequest, status,
					user.getUserCode());
		} else {
			conditions = getNodeTaskListConditionsByNodeType(
					httpServletRequest, nodeType, status, user.getUserCode());
		}
		if (status.equals("4")) // �����ɷ�ҳ��
		{
			PageRecord pageRecord = (PageRecord) uiWorkFlowAction
					.findNodesByConditions(conditions, intPageNo,
							intRecordPerPage);
			swfLogList = (ArrayList) pageRecord.getResult();
			// ��ѯ������һҳ�Ľṹ��
			turnPageDto.setResultList(swfLogList);
			// ��ǰҳ��
			turnPageDto.setPageNo(pageRecord.getPageNo());
			// һҳ������
			turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
			// ��ѯ�����Ľ��������
			turnPageDto.setTotalCount(pageRecord.getCount());
			// �����ܵ�ҳ��
			turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
			// ��������
			turnPageDto.setCondition(conditions);
		} else {
			swfLogList = (List) uiWorkFlowAction
					.findNodesByConditions(conditions);
		}
		UICodeAction uiCodeAction = new UICodeAction();
		// ���nodeType=����/����Ļ�������Ҫת������/�������������
		if (nodeType != null) {
			if (nodeType.equals("certa") || nodeType.equals("verif")
					|| nodeType.equals("sched")) {
				if (swfLogList != null && swfLogList.size() > 0) {
					for (int i = 0; i < swfLogList.size(); i++) {
						{
							SwfLogDto swfLogTemp = new SwfLogDto();
							swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList)
									.get(i));
							if (nodeType.equals("sched")) {
								// ����Ⱥ�ʱ��
								if (swfLogTemp.getNodeStatus().equals("0"))
									swfLogTemp
											.setStopTimeDesc(DateCompute
													.betweenDate(
															swfLogTemp
																	.getFlowInTime(),
															new DateTime(
																	DateTime
																			.current(),
																	DateTime.YEAR_TO_SECOND)
																	.toString()));
								if (swfLogTemp.getNodeStatus().equals("2"))
									swfLogTemp
											.setStopTimeDesc(DateCompute
													.betweenDate(
															swfLogTemp
																	.getHandleTime(),
															new DateTime(
																	DateTime
																			.current(),
																	DateTime.YEAR_TO_SECOND)
																	.toString()));
							} else {
								if (swfLogTemp.getTypeFlag().equals("1")) {
									swfLogTemp.setTypeFlagName("1-������");
								} else if (swfLogTemp.getTypeFlag().equals("2")) {
									swfLogTemp.setTypeFlagName("2-��Ա����");
								} else if (swfLogTemp.getTypeFlag().equals("3")) {
									swfLogTemp.setTypeFlagName("3-�Ʋ�����");
								} else if (swfLogTemp.getTypeFlag().equals("4")) {
									swfLogTemp.setTypeFlagName("4-ȫ��/�ƶ�ȫ��");
								} else {
									swfLogTemp.setTypeFlagName("");
								}
							}

							// add by lixiang start at 2006-6-5
							// reason:ת�����������õ�
							swfLogTemp = translateRelatePolicyOnTaskQueryOne(swfLogTemp);
							// add by lixiang end at 2006-6-5

							swfLogListTemp.add(swfLogTemp);
						}
					}
					swfLogList = swfLogListTemp;
				}
			}
		} else {
			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					{
						SwfLogDto swfLogTemp = new SwfLogDto();
						swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList)
								.get(i));
						swfLogTemp.setNodeTypeName(uiCodeAction
								.translateCodeCode("ClaimNodeType", swfLogTemp
										.getNodeType(), true));
						swfLogListTemp.add(swfLogTemp);
					}
				}
				swfLogList = swfLogListTemp;
			}
		}
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setAlertMessage(alertMessage);
		if (nodeType == null || nodeType.trim().length() < 1) {
			swfLogDto.setNodeType("commo");
		} else {
			swfLogDto.setNodeType(nodeType);
		}
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		// ��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
		httpServletRequest.setAttribute("status", status);
		httpServletRequest.setAttribute("nodeType", nodeType);
	}

	/**
	 * ���ݽڵ�����Ͳ���״̬��������Ϣ(��ҳ)
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */
	public void getWorkFlowLogList(HttpServletRequest httpServletRequest,
			String nodeType, String status, String alertMessage, String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String riskCode=httpServletRequest.getParameter("RiskCode");
		httpServletRequest.setAttribute("riskCode", riskCode);
		String RiskClaimType=httpServletRequest.getParameter("RiskClaimType");
		httpServletRequest.setAttribute("RiskClaimType", RiskClaimType);
		// �õ����б���������Ϣ
		Collection swfLogList = new ArrayList();
		Collection swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
		if (nodeType == null || nodeType.trim().length() < 1) {
			conditions = getNodeTaskListConditions(httpServletRequest, status,
					user.getUserCode());
		} else {
			conditions = getNodeTaskListConditionsByNodeType(
					httpServletRequest, nodeType, status, user.getUserCode());
		}
		String condition = httpServletRequest.getParameter("condition");
		String searchFlag = httpServletRequest.getParameter("searchFlag");

		if (searchFlag == null || searchFlag.trim().equals("true")) {

		} else {
			if (condition != null && condition.trim().length() > 0) {
				conditions = condition;
			}
		}
		
			PageRecord pageRecord = (PageRecord) uiWorkFlowAction
			.findNodesByConditions(conditions, intPageNo, intRecordPerPage);
			if(pageRecord.getResult().size()==0 && "4".equals(status) && "cance".equals(nodeType)){
				conditions = getNodeTaskListConditionsByNodeTypeStore(
						httpServletRequest, nodeType, status, user.getUserCode());
				 pageRecord = (PageRecord) uiWorkFlowAction
				.findStoreNodesByConditions(conditions, intPageNo, intRecordPerPage);
			}
		
		Collection swfLogListtemp1 = null;
		Collection swfLogDtolist = null;
		swfLogListtemp1 = (ArrayList) pageRecord.getResult();

		String dfFlag = "N";

		for (Iterator it = swfLogListtemp1.iterator(); it.hasNext();) {
			SwfLogDto swflogtemp = (SwfLogDto) it.next();
			PageRecord pageRecord2 = (PageRecord) uiWorkFlowAction
					.findNodesByConditions("  flowid='"
							+ swflogtemp.getFlowID() + "'", intPageNo,
							intRecordPerPage);
			swfLogDtolist = (ArrayList) pageRecord2.getResult();
			/*
			 * ��Ԫ��Ŀ�� �������ѭ����鿱�б��е����Ҵ�����İ����Ƿ������˵渶.���������Ӱ������
			 * ��Ϊ��Ԫ�ĲƲ���Ҳ���߶����.�����������ε� for (Iterator iter =
			 * swfLogDtolist.iterator(); iter.hasNext();) { SwfLogDto element =
			 * (SwfLogDto) iter.next(); if ("8".equals(element.getTypeFlag())){
			 * //��ʾ�ð��������˵渶 dfFlag="Y"; swflogtemp.setDfFlag(dfFlag); break; }
			 *  }
			 */
			swfLogList.add(swflogtemp);
		}

		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

		UICodeAction uiCodeAction = new UICodeAction();
		// ���nodeType=����/����Ļ�������Ҫת������/�������������
		if (nodeType != null) {
			if (nodeType.equals("certa") || nodeType.equals("verif")
					|| nodeType.equals("sched")) {
				if (swfLogList != null && swfLogList.size() > 0) {
					for (int i = 0; i < swfLogList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList)
								.get(i));
						if (nodeType.equals("sched")) {
							// ����Ⱥ�ʱ��
							if (swfLogTemp.getNodeStatus().equals("0"))
								swfLogTemp
										.setStopTimeDesc(DateCompute
												.betweenDate(
														swfLogTemp
																.getFlowInTime(),
														new DateTime(
																DateTime
																		.current(),
																DateTime.YEAR_TO_SECOND)
																.toString()));
							if (swfLogTemp.getNodeStatus().equals("2"))
								swfLogTemp
										.setStopTimeDesc(DateCompute
												.betweenDate(
														swfLogTemp
																.getHandleTime(),
														new DateTime(
																DateTime
																		.current(),
																DateTime.YEAR_TO_SECOND)
																.toString()));
							int index = swfLogTemp.getStopTimeDesc().indexOf(
									"��");
							if (index != -1)
								swfLogTemp.setStopTimeDesc(swfLogTemp
										.getStopTimeDesc().substring(0, index));
						} else {
							if (swfLogTemp.getTypeFlag().equals("1")) {
								swfLogTemp.setTypeFlagName("1-������");
							} else if (swfLogTemp.getTypeFlag().equals("2")) {
								swfLogTemp.setTypeFlagName("2-��Ա����");
							} else if (swfLogTemp.getTypeFlag().equals("3")) {
								swfLogTemp.setTypeFlagName("3-�Ʋ�����");
							} else if (swfLogTemp.getTypeFlag().equals("4")) {
								swfLogTemp.setTypeFlagName("4-ȫ��/�ƶ�ȫ��");
							} else {
								swfLogTemp.setTypeFlagName("");
							}
						}
						swfLogListTemp.add(swfLogTemp);
					}
					swfLogList = swfLogListTemp;
				}
			} else if (nodeType.equals("compe") && status.equals("0")) { // ���ڴ��������:�������δ���ͨ���ļ����飬�Ͳ��������ɼ����顣
				if (swfLogList != null && swfLogList.size() > 0) {
					for (int i = 0; i < swfLogList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList)
								.get(i));
						UICompensateAction uiCompensateAciton = new UICompensateAction();
						String statement = "claimno='"
								+ swfLogTemp.getKeyIn()
								+ "' and (UnderWriteFlag <> '1' and UnderWriteFlag <>'3')";
						Collection uiCompenList = uiCompensateAciton
								.findByConditions(statement);
						swfLogTemp.setCompCount(uiCompenList.size());
						swfLogListTemp.add(swfLogTemp);
					}
					swfLogList = swfLogListTemp;
				}
			} else if (nodeType.equals("claim") && status.equals("0")) { // ���ڴ���ע��������ע���ı�����������
				/*
				 * if(swfLogList!=null&&swfLogList.size()>0){ for (int i = 0; i <
				 * swfLogList.size(); i++) { SwfLogDto swfLogTemp = new
				 * SwfLogDto(); swfLogTemp = (SwfLogDto) ( ( (ArrayList)
				 * swfLogList).get(i)); EndorseViewHelper endorseViewHelper =
				 * new EndorseViewHelper(); PolicyDto policyDto =
				 * endorseViewHelper.findForEndorBefore(swfLogTemp.getPolicyNo());
				 * swfLogTemp.setOtherFlag(policyDto.getPrpCmainDto().getOthFlag());
				 * swfLogListTemp.add(swfLogTemp); } swfLogList =
				 * swfLogListTemp; }
				 */
			}
		} else {
			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					SwfLogDto swfLogTemp = new SwfLogDto();
					swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogTemp.setNodeTypeName(uiCodeAction.translateCodeCode(
							"ClaimNodeType", swfLogTemp.getNodeType(), true));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
		}
		SwfLogDto swfLogDto = new SwfLogDto();
		// add by lixiang start at 2006-6-5
		// reason:ת�����������õ�
		swfLogList = translateRelatePolicyOnTaskQuery(swfLogList, nodeType);
		// add by lixiang end at 2006-6-5

		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setAlertMessage(alertMessage);
		if (nodeType == null || nodeType.trim().length() < 1) {
			swfLogDto.setNodeType("commo");
		} else {
			swfLogDto.setNodeType(nodeType);
		}
		swfLogDto.setTurnPageDto(turnPageDto);

		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		// ��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
		httpServletRequest.setAttribute("status", status);
		httpServletRequest.setAttribute("nodeType", nodeType);

		// modify by wangwei add start 2005-06-12
		// ԭ�򣺰�����������Ϣ����Request�У����������⽡�պ��������֡�
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by wangwei add end 2005-06-12
	}
	/**
	 * ���������ʾ�б�������������ֽڵ�����д��������
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 * add by qianxiantao
	 */
	private String getComBineListConditions(
			HttpServletRequest httpServletRequest) throws Exception {
		    UIPowerInterface uiPowerInterface = new UIPowerInterface();
		    String flag=httpServletRequest.getParameter("Flag");
		    String statStartDate="";
		    String statEndDate="";
		    String riskCode="";
		    String policyNo="";
		    String insuredName = httpServletRequest.getParameter("insuredName");
		    if("N".equals(flag)){
		    	statStartDate=httpServletRequest.getParameter("statStartDate");
			    statEndDate=httpServletRequest.getParameter("statEndDate");
			    riskCode=httpServletRequest.getParameter("riskCode");
			    policyNo=httpServletRequest.getParameter("PolicyNo");
		    }else{
		        statStartDate=httpServletRequest.getParameter("StartDate");
		        statEndDate=httpServletRequest.getParameter("EndDate");
		        riskCode=httpServletRequest.getParameter("riskCode");
		        policyNo=httpServletRequest.getParameter("policyNo");
		    }
		    UserDto userDto = (UserDto) httpServletRequest.getSession()
			.getAttribute("user");
		    String condition = " 1=1 and o.registno = g.registno ";
            if(!"".equals(policyNo)&&(policyNo!=null)){
            	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
            	if(null!=policyNoSign && "*".equals(policyNoSign))
            		condition=condition+" and o.policyNo like '%"+policyNo.trim()+"%' ";
            	else condition=condition+" and o.policyNo='"+policyNo.trim()+"'";
            }
            if(!"".equals(riskCode)&&(riskCode!=null)){
            	condition=condition+" and o.riskcode='"+riskCode+"'";
            }
            if(!"".equals(statStartDate)&&(statStartDate!=null)){
            	condition=condition+" and g.reportdate>=to_date('"+statStartDate+"','yyyy-mm-dd')";
            }
            if(!"".equals(statEndDate)&&(statEndDate!=null)){
            	condition=condition+" and g.reportdate<=to_date('"+statEndDate+"','yyyy-mm-dd')"; 
            }
            if(!"".equals(insuredName)&&(insuredName!=null)){
            	String insuredNameSign = httpServletRequest.getParameter("insuredNameSign");
            	if(null!=insuredNameSign && "*".equals(insuredNameSign))
            		condition=condition+" and o.insuredName like '%"+insuredName.trim()+"%' ";
            	else condition=condition+" and o.insuredName='"+insuredName.trim()+"'";
            }
		    condition = condition +
		    " and ((nodeType in('check' ,'certa')  " + uiPowerInterface.addPower(userDto, "o", "", "handledept") 
		    + " ) or (nodeType not in('check' ,'certa') " 
		    + uiPowerInterface.addPower(userDto, "o", "", "ComCode") 
		    +"  OR o.handlerCode='" + userDto.getUserCode() +"' ))"
			+" and flowStatus!='0' and (flowStatus='1' or flowStatus='2')"
			+ "and (o.handlerCode='" + userDto.getUserCode() + "' or o.handlerCode is null or o.handlerCode='')";
		    return condition;
		   
	}
	/**
	 * ���������ʾ�б�������������ֽڵ�����д���������¹ʺ�
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 * add by qianxiantao
	 */
	private String getComBineListByComBineNoConditions(
			HttpServletRequest httpServletRequest) throws Exception {
		    String flag=httpServletRequest.getParameter("Flag");
		    String comBineNo="";
		    String riskCode=httpServletRequest.getParameter("riskCode");
		    if("N".equals(flag)){
		    comBineNo=httpServletRequest.getParameter("ComBineNo");
		    }else{
		    comBineNo=httpServletRequest.getParameter("comBineNo");	
		    }
			String condition = "ComBineNo='"+comBineNo.trim()+"' and h.riskcode='"+riskCode+"'";
			return condition;		   
	}
	/**
	 * ���������ʾ�б�������������ֽڵ�����д�������񣩱�����
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 * add by qianxiantao
	 */
	private String getComBineListByPolicyNoConditions(
			HttpServletRequest httpServletRequest) throws Exception {
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
	    String flag=httpServletRequest.getParameter("Flag");
	    String statStartDate="";
	    String statEndDate="";
	    String riskCode="";
	    String policyNo="";
	    String comBineNo;
	    String insuredName = "";
	    if("N".equals(flag)){
	    	statStartDate=httpServletRequest.getParameter("statStartDate");
		    statEndDate=httpServletRequest.getParameter("statEndDate");
		    riskCode=httpServletRequest.getParameter("riskCode");
		    policyNo=httpServletRequest.getParameter("PolicyNo");
	        comBineNo=httpServletRequest.getParameter("comBineNo");
	        insuredName=httpServletRequest.getParameter("insuredName");
	    }else{
	        statStartDate=httpServletRequest.getParameter("StartDate");
	        statEndDate=httpServletRequest.getParameter("EndDate");
	        riskCode=httpServletRequest.getParameter("riskCode");
	        policyNo=httpServletRequest.getParameter("policyNo");
	        comBineNo=httpServletRequest.getParameter("comBineNo");
	        insuredName=httpServletRequest.getParameter("insuredName");
	    }
	    UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
	    String condition = " 1=1 and o.registno = g.registno ";
        if(!"".equals(policyNo)&&(policyNo!=null)){
        	condition=condition+"and o.policyNo='"+policyNo.trim()+"'";
        }
        if(!"".equals(riskCode)&&(riskCode!=null)){
        	condition=condition+" and o.riskcode='"+riskCode+"'";
        }
        if(!"".equals(statStartDate)&&(statStartDate!=null)){
        	condition=condition+" and g.reportdate>=to_date('"+statStartDate+"','yyyy-mm-dd')";
        }
        if(!"".equals(statEndDate)&&(statEndDate!=null)){
        	condition=condition+" and g.reportdate<=to_date('"+statEndDate+"','yyyy-mm-dd')"; 
        }
        if(!"".equals(insuredName)&&(insuredName!=null))
        	condition=condition+" and o.insuredName='"+insuredName+"'";
	    condition = condition
		+ uiPowerInterface.addPower(userDto, "o", "", "ComCode");
	    return condition;
	   
		   
	}
	/**
	 * ��ò�ѯδ��������������ʾ�б�������������ֽڵ�����д��������
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 * add by qianxiantao
	 */
	private String getCompensateListConditions(
			HttpServletRequest httpServletRequest) throws Exception {
	    BLPrplcombineFacade prplcombineFacade=new BLPrplcombineFacade();
	    PrplcombineDto combineDto=new PrplcombineDto();
	    BLPrpLclaimFacade prplClaimFacade=new BLPrpLclaimFacade();
	    PrpLclaimDto claimDto=new PrpLclaimDto();
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		String flag1=httpServletRequest.getParameter("flag1");
	    String flag=httpServletRequest.getParameter("Flag");
	    String status=httpServletRequest.getParameter("status");
	    String statStartDate="";
	    String statEndDate="";
	    String riskCode="";
	    String policyNo="";
	    String claimNo="";
	    String registNo="";
	    String comBineNo="";
	    if("N".equals(flag)){
	    	statStartDate=httpServletRequest.getParameter("statStartDate");
		    statEndDate=httpServletRequest.getParameter("statEndDate");
		    riskCode=httpServletRequest.getParameter("riskCode");
		    policyNo=httpServletRequest.getParameter("PolicyNo");
		    comBineNo=httpServletRequest.getParameter("ComBineNo");
		    claimNo=httpServletRequest.getParameter("CalimNo");
		    registNo=httpServletRequest.getParameter("RegistNo");
	    }else{
	        statStartDate=httpServletRequest.getParameter("StartDate");
	        statEndDate=httpServletRequest.getParameter("EndDate");
	        riskCode=httpServletRequest.getParameter("riskCode");
	        policyNo=httpServletRequest.getParameter("policyNo");
	        comBineNo=httpServletRequest.getParameter("comBineNo");
	        claimNo=httpServletRequest.getParameter("calimNo");
		    registNo=httpServletRequest.getParameter("registNo");
	    }
	    UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
	    String condition = " 1=1 and nodestatus<>'4'";
	    if(!"".equals(riskCode)&&(riskCode!=null)){
	    	condition=condition+" and riskcode='"+riskCode+"'";
	    }
	    if(!"".equals(statStartDate)&&(statStartDate!=null)){
	    	condition=condition+" and to_date(flowintime,'yyyy-mm-dd hh24:mi:ss')>=to_date('"+statStartDate+"','yyyy-mm-dd')";
	    }
	    if(!"".equals(statEndDate)&&(statEndDate!=null)){
	    	condition=condition+" and to_date(flowintime,'yyyy-mm-dd hh24:mi:ss')<=to_date('"+statEndDate+"','yyyy-mm-dd')"; 
	    }
        if(!"".equals(policyNo)&&(policyNo!=null)){
        	if("Y".equals(flag1)){
        	condition=condition+" and policyNo='"+policyNo.trim()+"') " +
        			"group by s.registno) t " +
        			"where l.registno = t.registno and l.nodetype in('compe','compp') and l.logno = t.logno) h,prplcombine p " +
        			"where h.registno = p.registno) n " +
        			"where m.registno = n.registno";
        	}else{
        		if("0".equals(status)){
	                 condition=condition+" and policyNo='"+policyNo.trim()+"') " +
		            "group by s.registno) t " +
		            "where l.registno = t.registno and l.nodetype in('compe') and l.logno = t.logno) h,prplcombine p " +
		            "where h.registno = p.registno) n " +
		            "where m.registno = n.registno";	
        		}else{
        			condition=condition+" and policyNo='"+policyNo.trim()+"') " +
        			"group by s.registno) t " +
        			"where l.registno = t.registno and l.nodetype in('compp') and l.logno = t.logno) h,prplcombine p " +
        			"where h.registno = p.registno) n " +
        			"where m.registno = n.registno";	
        		}
        	}
        }else{
        	if("Y".equals(flag1)){
        	condition=condition+") " +
			"group by s.registno) t " +
			"where l.registno = t.registno and l.nodetype in('compe','compp') and l.logno = t.logno) h,prplcombine p " +
			"where h.registno = p.registno) n " +
			"where m.registno = n.registno";
        	}else{
        		if("0".equals(status)){
	                 condition=condition+") " +
		            "group by s.registno) t " +
		            "where l.registno = t.registno and l.nodetype in('compe') and l.logno = t.logno) h,prplcombine p " +
		            "where h.registno = p.registno) n " +
		            "where m.registno = n.registno";	
       		}else{
       			condition=condition+") " +
       			"group by s.registno) t " +
       			"where l.registno = t.registno and l.nodetype in('compp') and l.logno = t.logno) h,prplcombine p " +
       			"where h.registno = p.registno) n " +
       			"where m.registno = n.registno";	
       		}	
        	}
        }
        if(!"".equals(claimNo)&&(claimNo!=null)){
        	claimDto=prplClaimFacade.findByPrimaryKey(claimNo);
        	combineDto=prplcombineFacade.findByPrimaryKey(claimDto.getRegistNo());
        	comBineNo=combineDto.getCombineno();
        	condition=condition+" and n.comBineNo='"+comBineNo+"'";
        }else if(!"".equals(registNo)&&(registNo!=null)){
        	combineDto=prplcombineFacade.findByPrimaryKey(claimDto.getRegistNo());
        	comBineNo=combineDto.getCombineno();
        	condition=condition+" and n.comBineNo='"+comBineNo+"'";
        }else if(!"".equals(comBineNo)&&(comBineNo!=null)){
	    	condition=condition+" and n.comBineNo='"+comBineNo+"'";
	    }
	    condition = condition
		+ uiPowerInterface.addPower(userDto, "m", "", "ComCode");
	    return condition;
	   
		   
	}
	/**
	 * ���������ʾ�б�������������ֽڵ�����д�������񣩱�����
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 * add by qianxiantao
	 */
	private String getComBineListByRegistNoConditions(
			HttpServletRequest httpServletRequest) throws Exception {
		    String condition = "";
		    String riskCode=httpServletRequest.getParameter("riskCode");
		    String RegistNo=httpServletRequest.getParameter("RegistNo");
		    BLPrplcombineFacade prplcombineFacade=new BLPrplcombineFacade();
		    PrplcombineDto combineDto=new PrplcombineDto();
		    String comBineNo = "";
	        combineDto=prplcombineFacade.findByPrimaryKey(RegistNo);
//	        if(combineDto==null){
//	        	throw new Exception("�ñ�����δ���кϲ�������ȷ�ϣ�");
//	        }
	        if(null != combineDto)
	        	comBineNo =combineDto.getCombineno();
		    condition = "ComBineNo='"+comBineNo.trim()+"' and h.riskcode='"+riskCode+"'";

		    return condition;
		   
	}

	/**
	 * ���������ʾ�б�������������ֽڵ�����д��������
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 */
	private String getNodeTaskListConditions(
			HttpServletRequest httpServletRequest, String status,
			String handlerCode) throws Exception {
		String condition = " ";
		String orderString = "  order by nodeType,handleTime desc";
		// ע������
		if (status.equals("-1")) {
			condition = condition + "  Nodestatus < '4' and handlerCode='"
					+ handlerCode + "'";
			// ����������
		} else if (status.equals("0")) {
			// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
			condition = "  ((NodeStatus='"
					+ status
					+ "' and (handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='' ))  or ( NodeStatus='3' and handlerCode='"
					+ handlerCode + "')) ";
		} else {
			condition = condition + " NodeStatus='" + status
					+ "' and handlerCode='" + handlerCode + "'";
		}
		// ������������ڴ��������м��벻��ʾ�Ѿ��ر����̵Ľڵ���Ϣ
		condition = condition + " and (flowStatus='1' or flowStatus='2')";

		// condition = condition +"' and NodeStatus='"+status+"'";
		/*
		 * if (handlerCode!=null&&handlerCode.trim().length()>0 ) { condition =
		 * condition + " and (handlerCode='"+handlerCode+"'"; }
		 */
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		// modify by zhaolu 20060816 start
		// condition =
		// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lp","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		condition = condition
				+ uiPowerInterface.addPower(userDto, "swflog", "", "ComCode");
		// modify by zhaolu 20060816 end
		// ������ԱȨ�޴��� add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end
		condition += " and dataFlag is null ";
		condition = condition + orderString;

		return condition;
	}

	/**
	 * ���������ʾ�б������,һ�����(�������������ڴ����������ύ����)
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 */
	private String getNodeTaskListConditionsByNodeType(
			HttpServletRequest httpServletRequest, String nodeType,
			String status, String handlerCode) throws Exception {
 		String condition = "";
		String orderString = " order by handleTime desc";
		String riskType = httpServletRequest.getParameter("type");
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String conSignType = httpServletRequest.getParameter("conSignType");
		if (nodeType.equals("verip")) {
			UICodeAction uiCodeAction = new UICodeAction();
			String comLevel = uiCodeAction.getComLevel(user.getComCode());
			if (comLevel.equals("1")) {
				nodeType = "verpo";
			}
		}

		// �����ѯ����˼��������޸Ľڵ�����
		if (conSignType != null && conSignType.equals("verpo")) {
			nodeType = conSignType;
			condition = "   handleDept = '" + user.getComCode() + "' ";
		}

		// ��ʼƴ������������
		condition = "";
		if (handlerCode.equals("")) {
			condition = " nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "'";
		} else {
			condition = " (nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "' and handlerCode='" + handlerCode + "')";
		}
		// ע������
		// if (status.equals("-1")&&!nodeType.equals("claim")) condition = "
		// nodeType='"+ nodeType+ "' and ( handlerCode='"+handlerCode+"' or
		// handlerCode is null or handlerCode='') and Nodestatus <'4' ";
		// if (status.equals("-1")&& nodeType.equals("claim")) condition = "
		// nodeType='"+ nodeType+ "' and ( handlerCode='"+handlerCode+"' or
		// handlerCode is null or handlerCode='') and Nodestatus ='4' ";//modify
		// by kangzhen 070417
		if (status.equals("-1")){
			if(!"compe".equals(nodeType)){
			condition = " nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus <'4' ";// ���������Ժ�
			
			}
			//����ע���������룬ҵ�񱳾���ע������ֻ������δ�������������������ע�����ⲻ��
			else{
				condition = " nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus ='0' ";// ���������Ժ�
			    }
			}																				// ����������ֻ���ύ֮ǰ����������ע��,����ύ,���뵽��֤����ע������

		// ����������
		if (status.equals("0")) {

			// �����˻ص����񵥶��ֳ����������ڴ�������
			if (nodeType.equals("certa") || nodeType.equals("wound")
					|| nodeType.equals("propc")) { //
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			} else {
				// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and flowStatus!='0' and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			}

			if (nodeType.equals("sched")) { // �������̫������

				condition = " (nodeType='" + nodeType + "' ) and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
				//��ũ�����ܹ�˾���б���������֧��˾ֻ������ũ�ձ���(�������ϱ���Ҳ������Ŷ)
				if(user.getComCode().indexOf("000") != 0){
					condition += " and  (riskcode like '31%' or riskcode like '32%' or riskcode like 'ZH%' or riskcode like '27%' or riskcode like '26%' or riskcode like '28%') ";
				}

			}
		}
		if(status.equals("2")){
			condition = condition +  "  and flowStatus!='0'";//���ѹر��ⰸ��,�����ڴ�������˵�ʱ������ʾ����
		}
		 //������������ڴ��������м��벻��ʾ�Ѿ��ر����̵Ľڵ���Ϣ
		condition = condition + " and (flowStatus='1' or flowStatus='2')";

		if (nodeType.equals("verpo")) {
			condition = condition + " and   handleDept like  '"
					+ user.getComCode().substring(0, 3) + "%' ";
		}

		if (nodeType.equals("claim") && status.equals("0")) {
			// modify by lixiang add 20050310 start
			// reason:����������ʾ
			orderString = " order by flowintime";
			// modify by lixiang add 20050310 end
		}

		if (nodeType.equals("sched") && status.equals("2")) {
			// condition = " (nodeType='"+ nodeType+ "' ) and
			// (NodeStatus='"+status+"') ";

		}

		if (nodeType.equals("sched") && status.equals("0")) {
			orderString = " order by flowintime";
		}
		// ����������
		if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
		{
			condition = " nodeType='" + nodeType + "'";
		}
		if (nodeType.equals("veric") && status.equals("0")) {
			condition = " nodeType='" + nodeType + "' and nodestatus <'4'";
		}
		// -------------------------------------------------------------
		// �����������

		// [�⽡�յ���]***************************************************************************
		// ԭ�򣺼���һ����Ѱ��������������պ���������
		if ("check".equals(nodeType)) {
			if ("acci".equals(riskType)) {
				// ���IF�еĲ�ѯ�������ڲ�ѯ�⽡�յ���Ϣ,��ÿ����ѯ����м����ѯ����+ "and riskcode like '27%'
				// or riskCode like '06%'"��modify by kangzhen
				if (handlerCode.equals("")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and NodeStatus='"
							+ status
							+ "'"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian ���ֵ���Ͳ鿱
							+ " and length(keyin)=25 ";
				} else {
					condition = " (nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian ���ֵ���Ͳ鿱
							+ " and length(keyin)=25 ";
					if(status.equals("2")){
						condition += "and NodeStatus='"	+ status +"'";
					}
				}
				// ע������
				if (status.equals("-1")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "' and Nodestatus <'4' "
							+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
				}
				// ����������
				if (status.equals("0")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and (NodeStatus='"
							+ status
							+ "' or NodeStatus='3' ) and (handlerCode='"
							+ handlerCode
							+ "' or handlerCode is null or handlerCode='')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//��-xxx�ĵ���Ÿ������������鿱��25λkeyin modified by xiatian
							+ " and length(keyin)=25 ";
				}
				condition = condition
						+ " and (flowStatus='1' or flowStatus='2' or flowStatus='0')";
				// ����������
				if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
				{
					condition = " nodeType='" + nodeType + "'";
				}
				// �����⽡���յĲ鿱�Ĳ�ѯ����
			} else {
				if(status.equals("-1")){
					condition = condition
					+ " and nodeType='"
					+ nodeType
					+ "' and NodeStatus < '4'"
					//add by xiatian 27 26 31Ҳ�ɲ鿱
					+ " and length(keyin)<>25 ";
					//+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
				}
				else{
					condition = condition
					+ " and nodeType='"
					+ nodeType
					+ "' and NodeStatus='"
					+ status
					+ "'"
					//add by xiatian 27 26 31Ҳ�ɲ鿱
					+ " and length(keyin)<>25 ";
					//+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
				}
				
			}
		}
		// ���¿�ʼ[�⽡����ˡ�������]

		if ("acci".equals(riskType)
				&& (nodeType.equals("compe") || nodeType.equals("compp"))) {

			// ���IF�еĲ�ѯ�������ڲ�ѯ�⽡�յ���Ϣ,��ÿ����ѯ����м����ѯ����+ "and riskcode like '27%' or
			// riskCode like '06%'"��modify by kangzhen
			if (handlerCode.equals("")) {
				condition = " nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "'"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			} else {
				condition = " (nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "' and handlerCode='" + handlerCode + "')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// ע������
			if (status.equals("-1")) {
				condition = " nodeType='" + nodeType + "' and handlerCode='"
						+ handlerCode + "' and Nodestatus <'4' "
						+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// ����������
			if (status.equals("0")) {
				// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			condition = condition + " and (flowStatus='1' or flowStatus='2')";

			// ����������
			if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
			{
				condition = " nodeType='" + nodeType + "'";
			}

			// �����⽡���յ�����Ĳ�ѯ����

		}

		// /////////////////////
		// �Ӵ���������ȡ��������˵��������ӽ����ϵ�ҵ������keyIn,keyOut����businessNO�Ͻ��в�ѯ
		if (status.equals("-1") && "claim".equals(nodeType)) {
		    String strBusinessNo = (String)httpServletRequest.getParameter("BusinessNo");
			if (strBusinessNo!= null && !"".equals(strBusinessNo)) {
				PrpLclaimDto prpLclaimDto = (new BLPrpLclaimFacade()).findByPrimaryKey(httpServletRequest.getParameter("BusinessNo"));
				String registNo = "null";
				if(prpLclaimDto != null){
					registNo = prpLclaimDto.getRegistNo();
				}
				
				condition = condition
						+ StringConvert.convertString(httpServletRequest.getParameter("searchField"), registNo,
								httpServletRequest.getParameter("BusinessNoSign"));
			}

		} else {
			condition = condition
					+ StringConvert.convertString(httpServletRequest
							.getParameter("searchField"), httpServletRequest
							.getParameter("BusinessNo"), httpServletRequest
							.getParameter("BusinessNoSign"));
		}

		// modify by lixiang start at 2006-6-5
		// reason:֧�ֶౣ���Ĳ�ѯ
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// ����һ�£�������������߽᰸�������Ǽ����鴦������δ�����أ�Ӧ���ǲ�������������ת���İɣ�
			if (!checkNeedFindRelatePolicy(nodeType)) {
				condition = condition
						+ StringConvert
								.convertString("policyNo", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));
			} else {
				condition = condition
						+ " and registno in (select registno from "
						+ "prplregistrpolicy where 1=1 "
						+ StringConvert
								.convertString(" policyNo", policyNo,
										httpServletRequest
												.getParameter("PolicyNoSign"))
						+ ") ";
			}
		}
		//
		// modify by lixiang end at 2006-6-5
		String strRiskClaimType = httpServletRequest.getParameter("RiskClaimType");
		if(strRiskClaimType != null &&!"".equals(strRiskClaimType)){
			condition = condition + " and riskcode in (select distinct outercode from uticodetransfer where risktype='"+strRiskClaimType+"' and validstatus='1') ";
//            String prpLregistRiskCode = httpServletRequest.getParameter("prpLregistRiskCode");
//            //String RiskCode = httpServletRequest.getParameter("RiskCode");
//            httpServletRequest.setAttribute("RiskClaimType1", strRiskClaimType);
//            httpServletRequest.setAttribute("RiskClaimType2", prpLregistRiskCode);
//			if(prpLregistRiskCode != null &&!"".equals(prpLregistRiskCode)){
//				condition = condition
//				+ StringConvert.convertString(" riskCode", prpLregistRiskCode,"=");
//            }
//			if(RiskCode != null &&!"".equals(RiskCode)){
//				condition = condition
//				+ StringConvert.convertString(" riskCode", RiskCode,"=");
//            }
		}else{
			condition = condition
			+ StringConvert.convertString("RiskCode",
					httpServletRequest.getParameter("RiskCode"),
					httpServletRequest.getParameter("RiskCodeNoSign"));
		}
        
		condition = condition
		+ StringConvert.convertString("insuredName",
				httpServletRequest.getParameter("insuredName"),
				httpServletRequest.getParameter("insuredNameSign"));

		// add by liuyanmei 20051123 start
		// reason : ���ڴ����������� ��ѯ�����豨����
		if (nodeType.equals("claim") && !status.equals("0")) {
			condition = condition
					+ " And exists (select * from prplclaim a where swflog.keyout=a.claimno "
					+ StringConvert.convertString("a.registno",
							httpServletRequest.getParameter("ClaimRegistNo"),
							httpServletRequest
									.getParameter("ClaimRegistNoSign"));
			condition = condition + ")";
		}

		if (nodeType.equals("compp") && !status.equals("1")) {
			condition = condition
					+ StringConvert.convertString("registno",
							httpServletRequest.getParameter("ComppRegistNo"),
							httpServletRequest
									.getParameter("ComppRegistNoSign"));
		}

		// add by liuyanmei 20051123 end
		// ���Ŵ���
		String deptname = httpServletRequest.getParameter("DeptName");
		if (deptname != null && (deptname.trim().length()) > 0) {
			condition = condition
					+ StringConvert.convertString("DeptName", deptname,
							httpServletRequest.getParameter("DeptNameSign"));
		}
		String operateDate = httpServletRequest.getParameter("OperateDate");
		if (operateDate != null && !operateDate.trim().equals("")) {
			condition = condition
					+ StringConvert.convertDate("FlowInTime", operateDate,
							httpServletRequest.getParameter("OperateDateSign"));
		}
		String statEndDate = httpServletRequest.getParameter("statEndDate");
		String statStartDate = httpServletRequest.getParameter("statStartDate");
		if (statEndDate != null && statEndDate.trim().length() > 0) {
			condition = condition //handletime FlowInTime
			        + "And "+"to_date(HandleTime,'YYYY-MM-DD HH24:mi:ss') <="
			        +"to_date('" + statEndDate + " 23:59:59"+ "','YYYY-MM-DD HH24:mi:ss')";
		}
		if (statStartDate != null && statStartDate.trim().length() > 0) {
			condition = condition 
			        + "And "+"to_date(HandleTime,'YYYY-MM-DD HH24:mi:ss') >="
			        +"to_date('" + statStartDate + " 00:00:00"+ "','YYYY-MM-DD HH24:mi:ss')";
		}
		// ////////////////////

		// ������
		String registNo = httpServletRequest.getParameter("RegistNo");
		if (registNo != null && registNo.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("RegistNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));

		}

		// ��ʧ���/����
		String lossitemName = httpServletRequest.getParameter("LicenseNo");
		if (lossitemName != null && lossitemName.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("LossItemName", lossitemName,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		String InsuredName = httpServletRequest.getParameter("InsuredName");
		if (InsuredName != null && InsuredName.trim().length() > 0) {

			// ����������
			condition = condition
					+ StringConvert.convertString("InsuredName", InsuredName,
							httpServletRequest.getParameter("InsuredNameSign"));
		}

		String conditionscompe = "";

		String endcaRegistNo = httpServletRequest.getParameter("EndcaRegistNo");
		String compeRegistNo = httpServletRequest.getParameter("CompeRegistNo");
		String comppRegistNo = httpServletRequest.getParameter("ComppRegistNo");
		// ��֣�ΪʲôҪ��ô���ء��������������б�������ѽ����������
		if (endcaRegistNo != null && endcaRegistNo.trim().length() > 0) {
			conditionscompe = endcaRegistNo;
		}
		if (compeRegistNo != null && compeRegistNo.trim().length() > 0) {
			conditionscompe = compeRegistNo;
		}
		if (comppRegistNo != null && comppRegistNo.trim().length() > 0) {
			conditionscompe = comppRegistNo;
		}

		if (conditionscompe != "") {
			condition = condition
					+ StringConvert.convertString("RegistNo", conditionscompe,
							"=");
		}

		String typeFlag = httpServletRequest.getParameter("typeFlag");
		if (("1").equals(typeFlag)) {
			condition = condition + " AND typeFlag='1' ";
		}

		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		if (riskType != null
				&& (nodeType.equals("compe") || nodeType.equals("compp"))
				&& riskType.equals("acci")) {
			// modify by zhaolu 20060816 start
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lpyh","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// modify by zhaolu 20060816 end
		} else if (riskType != null && nodeType.equals("check")
				&& riskType.equals("acci")) {
			// modify by zhaolu 20060816 start
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lpyd","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			// modify by zhaolu 20060816 start
		} else if (nodeType.equals("verpo")) {
			// ����˼۲���Ҫ
		}else if(nodeType.equals("check")){
			condition = condition + " and ((modelno=7  "+uiPowerInterface.addPower(userDto, "vv","", "ComCode").replace("vv", "Swflog")+") or (modelno<>7 "+uiPowerInterface.addPower(userDto, "kk", "","handledept").replace("kk", "Swflog")+") )";
		}else if(nodeType.equals("certa") ||
				nodeType.equals("wound") || nodeType.equals("propc") ||
				nodeType.equals("verif") || nodeType.equals("veriw") ||
				nodeType.equals("propv")){
			condition = condition
			+ uiPowerInterface.addPower(userDto, "swflog", "",
					"handledept");
		}

		else {
			// modify by zhaolu 20060816 start
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),BusinessRuleUtil.transTaskCode(nodeType),"swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			// modify by zhaolu 20060816 end
		}
		//start�����Ѿ������İ��� 
		if("check".equals(nodeType)||"certa".equals(nodeType)||"certi".equals(nodeType)||"claim".equals(nodeType))//||"compe".equals(nodeType)||"compp".equals(nodeType))
		{
			//if(!"compp".equals(nodeType) && !"3".equals(status))
			condition = condition + " and registno not in (select registno from prplcombine)" ;
		}
		//end
		//start ���ڵ��ӵ������ݿ�ͺ������ݿ����ѯ����ƴ��  add by jqzhang@gyic
		String strEarLabel = httpServletRequest.getParameter("EarLabel");
		String strFCardID = httpServletRequest.getParameter("FCardID");
		String strEarLabelSign = httpServletRequest.getParameter("EarLabelSign");
		String strFCardIDSign = httpServletRequest.getParameter("FCardIDSign");
		String strFname1 = httpServletRequest.getParameter("Fname1");
		String strFname1Sign = httpServletRequest.getParameter("Fname1Sign");
		String strFamilyNo = httpServletRequest.getParameter("FamilyNo");
		String strFamilyNoSign = httpServletRequest.getParameter("FamilyNoSign");
		String strFamilyFIDCard = httpServletRequest.getParameter("FamilyFIDCard");
		String strFamilyFIDCardSign = httpServletRequest.getParameter("FamilyFIDCardSign");
		String strFname = httpServletRequest.getParameter("Fname");
		String strFnameSign = httpServletRequest.getParameter("FnameSign");
		String strDZDACondition = "";
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			strDZDACondition = " and registno  in (" +
			" SELECT registno FROM prplcompensateear e" +
			" WHERE   e.nodetype='regis' " +
			StringConvert.convertString("e.Earno", strEarLabel, strEarLabelSign) + StringConvert.convertString("e.name", strFname,strFnameSign)//������������ֳ��ר��
			+ ")";
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			strDZDACondition = " and policyno in (" +
			" SELECT policyno FROM Plantingpolicylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign) + //��ֲ��ר��
			" union " +
			" SELECT policyno FROM planting31policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign)//������������ֲ��ר��
			+ ")";
		}

		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			strDZDACondition = "and policyno in (" +
			" SELECT policyno FROM ZH03policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign) + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign)//ũ�Ҹ���ϱ���ר��
			+ ")";
		}
		condition = condition + strDZDACondition;
		//end
		/*
		//start���Ӷ����ѯ����
		String earLabel = httpServletRequest.getParameter("EarLabel");
		if(earLabel != null && !"".equals(earLabel.trim())){
			BLPrplcompensateearFacade blPrplcompensateearFacade = new BLPrplcompensateearFacade();
			String prplcompensateearDtoConditions = "Earno = '" + earLabel.trim()  + "' and nodetype='regis'";
			String fname = httpServletRequest.getParameter("Fname");
			if(fname != null && !"".equals(fname.trim())){
				prplcompensateearDtoConditions = prplcompensateearDtoConditions + "and name ='" + fname.trim() +"'";
			}
			ArrayList PrplcompensateearDtoList = (ArrayList)blPrplcompensateearFacade.findByConditions(prplcompensateearDtoConditions);
			if(PrplcompensateearDtoList != null && PrplcompensateearDtoList.size() >0){
				String strCondition = "and Registno in (";
				for(int i = 0; i < PrplcompensateearDtoList.size(); i++){
					PrplcompensateearDto prplcompensateearDto = new PrplcompensateearDto();
					prplcompensateearDto = (PrplcompensateearDto)PrplcompensateearDtoList.get(i);
					if(i == 0)
						strCondition = strCondition +"'"+ prplcompensateearDto.getRegistno()+ "'";
					else
						strCondition = strCondition + ",'" + prplcompensateearDto.getRegistno() +"'";
				}
				condition = condition + strCondition + ")";
			}
			else
				condition = " 1!=1 and " + condition;
		}
		//end���Ӷ����ѯ����
		//start����������������ֲ��ũ�����֤��ѯ����
		String FCardID = httpServletRequest.getParameter("FCardID");
		if(FCardID != null && !"".equals(FCardID.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="FIDCARD = '" + FCardID.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					condition = condition + mainConditions;
    				} 
    				else
    					condition = " 1!=1 and " + condition;	
            }
            else
            	condition = " 1!=1 and " + condition;
		}
		//end����������������ֲ��ũ�����֤��ѯ����
		//start����������������ֲ��ũ��������ѯ����
		String Fname1 = httpServletRequest.getParameter("Fname1");
		if(Fname1 != null && !"".equals(Fname1.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="Fname = '" + Fname1.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					condition = condition + mainConditions;
    				} 
    				else
    					condition = " 1!=1 and " + condition;	
            }
            else
            	condition = " 1!=1 and " + condition;
		}*/
		//end����������������ֲ��ũ��������ѯ����
		// ������ԱȨ�޴��� add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end
		//����ϵͳ���������־
		condition += " and dataFlag is null ";
		condition +=" and medicalTransitFlag is null ";
		condition = condition + orderString;
        
		return condition;
	}
	
	private String getNodeTaskListConditionsByNodeTypeStore(
			HttpServletRequest httpServletRequest, String nodeType,
			String status, String handlerCode) throws Exception {
 		String condition = "";
		String orderString = " order by handleTime desc";
		String riskType = httpServletRequest.getParameter("type");
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String conSignType = httpServletRequest.getParameter("conSignType");
		if (nodeType.equals("verip")) {
			String comLevel = user.getComLevel();
			if (comLevel.equals("1")) {
				nodeType = "verpo";
			}
		}

		// �����ѯ����˼��������޸Ľڵ�����
		if (conSignType != null && conSignType.equals("verpo")) {
			nodeType = conSignType;
			condition = "   handleDept = '" + user.getComCode() + "' ";
		}

		// ��ʼƴ������������
		condition = "";
		if (handlerCode.equals("")) {
			condition = " nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "'";
		} else if("0000000000".equals(user.getComCode())){
			condition = " (nodeType='" + nodeType + "' and NodeStatus='"
			+ status + "' )";
		}else{
			condition = " (nodeType='" + nodeType + "' and NodeStatus='"
			+ status + "' and handlerCode='" + handlerCode + "')";
		}
		// ע������
		// if (status.equals("-1")&&!nodeType.equals("claim")) condition = "
		// nodeType='"+ nodeType+ "' and ( handlerCode='"+handlerCode+"' or
		// handlerCode is null or handlerCode='') and Nodestatus <'4' ";
		// if (status.equals("-1")&& nodeType.equals("claim")) condition = "
		// nodeType='"+ nodeType+ "' and ( handlerCode='"+handlerCode+"' or
		// handlerCode is null or handlerCode='') and Nodestatus ='4' ";//modify
		// by kangzhen 070417
		if (status.equals("-1")){
			if(!"compe".equals(nodeType)){
			condition = " nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus <'4' ";// ���������Ժ�
			
			}
			//����ע���������룬ҵ�񱳾���ע������ֻ������δ�������������������ע�����ⲻ��
			else{
				condition = " nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus ='0' ";// ���������Ժ�
			    }
			}																				// ����������ֻ���ύ֮ǰ����������ע��,����ύ,���뵽��֤����ע������

		// ����������
		if (status.equals("0")) {

			// �����˻ص����񵥶��ֳ����������ڴ�������
			if (nodeType.equals("certa") || nodeType.equals("wound")
					|| nodeType.equals("propc")) { //
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "') and flowStatus ='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			} else {
				// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and flowStatus ='0' and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			}

			if (nodeType.equals("sched")) { // �������̫������

				condition = " (nodeType='" + nodeType + "' ) and (NodeStatus='"
						+ status + "') and flowStatus ='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
				//��ũ�����ܹ�˾���б���������֧��˾ֻ������ũ�ձ���(�������ϱ���Ҳ������Ŷ)
				if(user.getComCode().indexOf("000") != 0){
					condition += " and  (riskcode like '31%' or riskcode like '32%' or riskcode like 'ZH%' or riskcode like '27%' or riskcode like '26%' or riskcode like '28%') ";
				}

			}
		}
		if(status.equals("2")){
			condition = condition +  "  and flowStatus ='0'";//���ѹر��ⰸ��,�����ڴ�������˵�ʱ������ʾ����
		}
		 //������������ڴ��������м��벻��ʾ�Ѿ��ر����̵Ľڵ���Ϣ
		condition = condition + " and (flowStatus='0')";

		if (nodeType.equals("verpo")) {
			condition = condition + " and   handleDept like  '"
					+ user.getComCode().substring(0, 3) + "%' ";
		}

		if (nodeType.equals("claim") && status.equals("0")) {
			// modify by lixiang add 20050310 start
			// reason:����������ʾ
			orderString = " order by flowintime";
			// modify by lixiang add 20050310 end
		}

		if (nodeType.equals("sched") && status.equals("2")) {
			// condition = " (nodeType='"+ nodeType+ "' ) and
			// (NodeStatus='"+status+"') ";

		}

		if (nodeType.equals("sched") && status.equals("0")) {
			orderString = " order by flowintime";
		}
		// ����������
		if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
		{
			condition = " nodeType='" + nodeType + "'";
		}
		if (nodeType.equals("veric") && status.equals("0")) {
			condition = " nodeType='" + nodeType + "' and nodestatus <'4'";
		}
		// -------------------------------------------------------------
		// �����������

		// [�⽡�յ���]***************************************************************************
		// ԭ�򣺼���һ����Ѱ��������������պ���������
		if ("check".equals(nodeType)) {
			if ("acci".equals(riskType)) {
				// ���IF�еĲ�ѯ�������ڲ�ѯ�⽡�յ���Ϣ,��ÿ����ѯ����м����ѯ����+ "and riskcode like '27%'
				// or riskCode like '06%'"��modify by kangzhen
				if (handlerCode.equals("")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and NodeStatus='"
							+ status
							+ "'"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian ���ֵ���Ͳ鿱
							+ " and length(keyin)=25 ";
				} else {
					condition = " (nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian ���ֵ���Ͳ鿱
							+ " and length(keyin)=25 ";
					if(status.equals("2")){
						condition += "and NodeStatus='"	+ status +"'";
					}
				}
				// ע������
				if (status.equals("-1")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "' and Nodestatus <'4' "
							+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
				}
				// ����������
				if (status.equals("0")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and (NodeStatus='"
							+ status
							+ "' or NodeStatus='3' ) and (handlerCode='"
							+ handlerCode
							+ "' or handlerCode is null or handlerCode='')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//��-xxx�ĵ���Ÿ������������鿱��25λkeyin modified by xiatian
							+ " and length(keyin)=25 ";
				}
				condition = condition
						+ " and (flowStatus='1' or flowStatus='2' or flowStatus='0')";
				// ����������
				if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
				{
					condition = " nodeType='" + nodeType + "'";
				}
				// �����⽡���յĲ鿱�Ĳ�ѯ����
			} else {
				if(status.equals("-1")){
					condition = condition
					+ " and nodeType='"
					+ nodeType
					+ "' and NodeStatus < '4'"
					//add by xiatian 27 26 31Ҳ�ɲ鿱
					+ " and length(keyin)<>25 ";
					//+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
				}
				else{
					condition = condition
					+ " and nodeType='"
					+ nodeType
					+ "' and NodeStatus='"
					+ status
					+ "'"
					//add by xiatian 27 26 31Ҳ�ɲ鿱
					+ " and length(keyin)<>25 ";
					//+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
				}
				
			}
		}
		// ���¿�ʼ[�⽡����ˡ�������]

		if ("acci".equals(riskType)
				&& (nodeType.equals("compe") || nodeType.equals("compp"))) {

			// ���IF�еĲ�ѯ�������ڲ�ѯ�⽡�յ���Ϣ,��ÿ����ѯ����м����ѯ����+ "and riskcode like '27%' or
			// riskCode like '06%'"��modify by kangzhen
			if (handlerCode.equals("")) {
				condition = " nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "'"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			} else {
				condition = " (nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "' and handlerCode='" + handlerCode + "')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// ע������
			if (status.equals("-1")) {
				condition = " nodeType='" + nodeType + "' and handlerCode='"
						+ handlerCode + "' and Nodestatus <'4' "
						+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// ����������
			if (status.equals("0")) {
				// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			condition = condition + " and (flowStatus='0')";

			// ����������
			if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
			{
				condition = " nodeType='" + nodeType + "'";
			}

			// �����⽡���յ�����Ĳ�ѯ����

		}

		// /////////////////////
		// �Ӵ���������ȡ��������˵��������ӽ����ϵ�ҵ������keyIn,keyOut����businessNO�Ͻ��в�ѯ
		if (status.equals("-1") && "claim".equals(nodeType)) {
		    String strBusinessNo = (String)httpServletRequest.getParameter("BusinessNo");
			if (strBusinessNo!= null && !"".equals(strBusinessNo)) {
				PrpLclaimDto prpLclaimDto = (new BLPrpLclaimFacade()).findByPrimaryKey(httpServletRequest.getParameter("BusinessNo"));
				String registNo = "null";
				if(prpLclaimDto != null){
					registNo = prpLclaimDto.getRegistNo();
				}
				
				condition = condition
						+ StringConvert.convertString(httpServletRequest.getParameter("searchField"), registNo,
								httpServletRequest.getParameter("BusinessNoSign"));
			}

		} else {
			condition = condition
					+ StringConvert.convertString(httpServletRequest
							.getParameter("searchField"), httpServletRequest
							.getParameter("BusinessNo"), httpServletRequest
							.getParameter("BusinessNoSign"));
		}

		// modify by lixiang start at 2006-6-5
		// reason:֧�ֶౣ���Ĳ�ѯ
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// ����һ�£�������������߽᰸�������Ǽ����鴦������δ�����أ�Ӧ���ǲ�������������ת���İɣ�
			if (!checkNeedFindRelatePolicy(nodeType)) {
				condition = condition
						+ StringConvert
								.convertString("policyNo", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));
			} else {
				condition = condition
						+ " and registno in (select registno from "
						+ "prplregistrpolicy where 1=1 "
						+ StringConvert
								.convertString(" policyNo", policyNo,
										httpServletRequest
												.getParameter("PolicyNoSign"))
						+ ") ";
			}
		}
		//
		// modify by lixiang end at 2006-6-5
		String strRiskClaimType = httpServletRequest.getParameter("RiskClaimType");
		if(strRiskClaimType != null &&!"".equals(strRiskClaimType)){
			condition = condition + " and riskcode in (select distinct outercode from uticodetransfer where risktype='"+strRiskClaimType+"' and validstatus='1') ";
//            String prpLregistRiskCode = httpServletRequest.getParameter("prpLregistRiskCode");
//            //String RiskCode = httpServletRequest.getParameter("RiskCode");
//            httpServletRequest.setAttribute("RiskClaimType1", strRiskClaimType);
//            httpServletRequest.setAttribute("RiskClaimType2", prpLregistRiskCode);
//			if(prpLregistRiskCode != null &&!"".equals(prpLregistRiskCode)){
//				condition = condition
//				+ StringConvert.convertString(" riskCode", prpLregistRiskCode,"=");
//            }
//			if(RiskCode != null &&!"".equals(RiskCode)){
//				condition = condition
//				+ StringConvert.convertString(" riskCode", RiskCode,"=");
//            }
		}else{
			condition = condition
			+ StringConvert.convertString("RiskCode",
					httpServletRequest.getParameter("RiskCode"),
					httpServletRequest.getParameter("RiskCodeNoSign"));
		}
        
		condition = condition
		+ StringConvert.convertString("insuredName",
				httpServletRequest.getParameter("insuredName"),
				httpServletRequest.getParameter("insuredNameSign"));

		// add by liuyanmei 20051123 start
		// reason : ���ڴ����������� ��ѯ�����豨����
		if (nodeType.equals("claim") && !status.equals("0")) {
			condition = condition
					+ " And exists (select * from prplclaim a where swflog.keyout=a.claimno "
					+ StringConvert.convertString("a.registno",
							httpServletRequest.getParameter("ClaimRegistNo"),
							httpServletRequest
									.getParameter("ClaimRegistNoSign"));
			condition = condition + ")";
		}

		if (nodeType.equals("compp") && !status.equals("1")) {
			condition = condition
					+ StringConvert.convertString("registno",
							httpServletRequest.getParameter("ComppRegistNo"),
							httpServletRequest
									.getParameter("ComppRegistNoSign"));
		}

		// add by liuyanmei 20051123 end
		// ���Ŵ���
		String deptname = httpServletRequest.getParameter("DeptName");
		if (deptname != null && (deptname.trim().length()) > 0) {
			condition = condition
					+ StringConvert.convertString("DeptName", deptname,
							httpServletRequest.getParameter("DeptNameSign"));
		}
		String operateDate = httpServletRequest.getParameter("OperateDate");
		if (operateDate != null && !operateDate.trim().equals("")) {
			condition = condition
					+ StringConvert.convertDate("FlowInTime", operateDate,
							httpServletRequest.getParameter("OperateDateSign"));
		}
		String statEndDate = httpServletRequest.getParameter("statEndDate");
		String statStartDate = httpServletRequest.getParameter("statStartDate");
		if (statEndDate != null && statEndDate.trim().length() > 0) {
			condition = condition + " AND HandleTime <='" + statEndDate + "'";
		}
		if (statStartDate != null && statStartDate.trim().length() > 0) {
			condition = condition + " AND HandleTime >='" + statStartDate + "'";
		}
		// ////////////////////

		// ������
		String registNo = httpServletRequest.getParameter("RegistNo");
		if (registNo != null && registNo.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("RegistNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));

		}

		// ��ʧ���/����
		String lossitemName = httpServletRequest.getParameter("LicenseNo");
		if (lossitemName != null && lossitemName.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("LossItemName", lossitemName,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		String InsuredName = httpServletRequest.getParameter("InsuredName");
		if (InsuredName != null && InsuredName.trim().length() > 0) {

			// ����������
			condition = condition
					+ StringConvert.convertString("InsuredName", InsuredName,
							httpServletRequest.getParameter("InsuredNameSign"));
		}

		String conditionscompe = "";

		String endcaRegistNo = httpServletRequest.getParameter("EndcaRegistNo");
		String compeRegistNo = httpServletRequest.getParameter("CompeRegistNo");
		String comppRegistNo = httpServletRequest.getParameter("ComppRegistNo");
		// ��֣�ΪʲôҪ��ô���ء��������������б�������ѽ����������
		if (endcaRegistNo != null && endcaRegistNo.trim().length() > 0) {
			conditionscompe = endcaRegistNo;
		}
		if (compeRegistNo != null && compeRegistNo.trim().length() > 0) {
			conditionscompe = compeRegistNo;
		}
		if (comppRegistNo != null && comppRegistNo.trim().length() > 0) {
			conditionscompe = comppRegistNo;
		}

		if (conditionscompe != "") {
			condition = condition
					+ StringConvert.convertString("RegistNo", conditionscompe,
							"=");
		}

		String typeFlag = httpServletRequest.getParameter("typeFlag");
		if (("1").equals(typeFlag)) {
			condition = condition + " AND typeFlag='1' ";
		}

		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		if (riskType != null
				&& (nodeType.equals("compe") || nodeType.equals("compp"))
				&& riskType.equals("acci")) {
			// modify by zhaolu 20060816 start
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lpyh","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// modify by zhaolu 20060816 end
		} else if (riskType != null && nodeType.equals("check")
				&& riskType.equals("acci")) {
			// modify by zhaolu 20060816 start
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lpyd","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			// modify by zhaolu 20060816 start
		} else if (nodeType.equals("verpo")) {
			// ����˼۲���Ҫ
		}else if(nodeType.equals("check")){
			condition = condition + " and ((modelno=7  "+uiPowerInterface.addPower(userDto, "vv","", "ComCode").replace("vv", "Swflog")+") or (modelno<>7 "+uiPowerInterface.addPower(userDto, "kk", "","handledept").replace("kk", "Swflog")+") )";
		}else if(nodeType.equals("certa") ||
				nodeType.equals("wound") || nodeType.equals("propc") ||
				nodeType.equals("verif") || nodeType.equals("veriw") ||
				nodeType.equals("propv")){
			condition = condition
			+ uiPowerInterface.addPower(userDto, "swflog", "",
					"handledept");
		}

		else {
			// modify by zhaolu 20060816 start
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),BusinessRuleUtil.transTaskCode(nodeType),"swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			// modify by zhaolu 20060816 end
		}
		//start�����Ѿ������İ��� 
		if("check".equals(nodeType)||"certa".equals(nodeType)||"certi".equals(nodeType)||"claim".equals(nodeType))//||"compe".equals(nodeType)||"compp".equals(nodeType))
		{
			//if(!"compp".equals(nodeType) && !"3".equals(status))
			condition = condition + " and registno not in (select registno from prplcombine)" ;
		}
		//end
		//start ���ڵ��ӵ������ݿ�ͺ������ݿ����ѯ����ƴ��  add by jqzhang@gyic
		String strEarLabel = httpServletRequest.getParameter("EarLabel");
		String strFCardID = httpServletRequest.getParameter("FCardID");
		String strEarLabelSign = httpServletRequest.getParameter("EarLabelSign");
		String strFCardIDSign = httpServletRequest.getParameter("FCardIDSign");
		String strFname1 = httpServletRequest.getParameter("Fname1");
		String strFname1Sign = httpServletRequest.getParameter("Fname1Sign");
		String strFamilyNo = httpServletRequest.getParameter("FamilyNo");
		String strFamilyNoSign = httpServletRequest.getParameter("FamilyNoSign");
		String strFamilyFIDCard = httpServletRequest.getParameter("FamilyFIDCard");
		String strFamilyFIDCardSign = httpServletRequest.getParameter("FamilyFIDCardSign");
		String strFname = httpServletRequest.getParameter("Fname");
		String strFnameSign = httpServletRequest.getParameter("FnameSign");
		String strDZDACondition = "";
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			strDZDACondition = " and registno  in (" +
			" SELECT registno FROM prplcompensateear e" +
			" WHERE   e.nodetype='regis' " +
			StringConvert.convertString("e.Earno", strEarLabel, strEarLabelSign) + StringConvert.convertString("e.name", strFname,strFnameSign)//������������ֳ��ר��
			+ ")";
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			strDZDACondition = " and policyno in (" +
			" SELECT policyno FROM Plantingpolicylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign) + //��ֲ��ר��
			" union " +
			" SELECT policyno FROM planting31policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign)//������������ֲ��ר��
			+ ")";
		}

		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			strDZDACondition = "and policyno in (" +
			" SELECT policyno FROM ZH03policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign) + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign)//ũ�Ҹ���ϱ���ר��
			+ ")";
		}
		condition = condition + strDZDACondition;
		//end
		/*
		//start���Ӷ����ѯ����
		String earLabel = httpServletRequest.getParameter("EarLabel");
		if(earLabel != null && !"".equals(earLabel.trim())){
			BLPrplcompensateearFacade blPrplcompensateearFacade = new BLPrplcompensateearFacade();
			String prplcompensateearDtoConditions = "Earno = '" + earLabel.trim()  + "' and nodetype='regis'";
			String fname = httpServletRequest.getParameter("Fname");
			if(fname != null && !"".equals(fname.trim())){
				prplcompensateearDtoConditions = prplcompensateearDtoConditions + "and name ='" + fname.trim() +"'";
			}
			ArrayList PrplcompensateearDtoList = (ArrayList)blPrplcompensateearFacade.findByConditions(prplcompensateearDtoConditions);
			if(PrplcompensateearDtoList != null && PrplcompensateearDtoList.size() >0){
				String strCondition = "and Registno in (";
				for(int i = 0; i < PrplcompensateearDtoList.size(); i++){
					PrplcompensateearDto prplcompensateearDto = new PrplcompensateearDto();
					prplcompensateearDto = (PrplcompensateearDto)PrplcompensateearDtoList.get(i);
					if(i == 0)
						strCondition = strCondition +"'"+ prplcompensateearDto.getRegistno()+ "'";
					else
						strCondition = strCondition + ",'" + prplcompensateearDto.getRegistno() +"'";
				}
				condition = condition + strCondition + ")";
			}
			else
				condition = " 1!=1 and " + condition;
		}
		//end���Ӷ����ѯ����
		//start����������������ֲ��ũ�����֤��ѯ����
		String FCardID = httpServletRequest.getParameter("FCardID");
		if(FCardID != null && !"".equals(FCardID.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="FIDCARD = '" + FCardID.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					condition = condition + mainConditions;
    				} 
    				else
    					condition = " 1!=1 and " + condition;	
            }
            else
            	condition = " 1!=1 and " + condition;
		}
		//end����������������ֲ��ũ�����֤��ѯ����
		//start����������������ֲ��ũ��������ѯ����
		String Fname1 = httpServletRequest.getParameter("Fname1");
		if(Fname1 != null && !"".equals(Fname1.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="Fname = '" + Fname1.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					condition = condition + mainConditions;
    				} 
    				else
    					condition = " 1!=1 and " + condition;	
            }
            else
            	condition = " 1!=1 and " + condition;
		}*/
		//end����������������ֲ��ũ��������ѯ����
		// ������ԱȨ�޴��� add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end
		//����ϵͳ���������־
		condition += " and dataFlag is null ";
		condition = condition + orderString;
        
		return condition;
	}

	/**
	 * ���ݽڵ�����Ͳ���״̬��������Ϣ(Ŀǰֻ���������ⰸ�Ĳ�ѯ)
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */
	public void getSwfLogList(HttpServletRequest httpServletRequest,
			String caseFlag, String userCode, String nodeType) throws Exception {
		if (caseFlag != null && caseFlag.trim().length() > 0) {
			caseFlag = caseFlag.substring(0, caseFlag.length() - 1);
		}
		// ��ѯ����ڵ�״̬��Ϣ
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		// �õ�����������Ϣ
		Collection swfLogList = new ArrayList();
		Collection swfLogListTemp = new ArrayList();
		String conditions = " handlerCode = '" + userCode
				+ "' AND NodeType = '" + nodeType + "'";
		conditions = conditions
				+ StringConvert.convertString("businessno", httpServletRequest
						.getParameter("RegistNo"), httpServletRequest
						.getParameter("RegistNoSign"));

		// modify by lixiang start at 2006-6-5
		// reason:֧�ֶౣ���Ĳ�ѯ
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// ����һ�£�������������߽᰸�������Ǽ����鴦������δ�����أ�Ӧ���ǲ�������������ת���İɣ�
			if (!checkNeedFindRelatePolicy(nodeType)) {
				conditions = conditions
						+ StringConvert
								.convertString("policyno", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));

			} else {
				conditions = conditions
						+ " and registno in (select registno from "
						+ "prplregistrpolicy where 1=1 "
						+ StringConvert
								.convertString(" policyNo", policyNo,
										httpServletRequest
												.getParameter("PolicyNoSign"))
						+ ") ";
			}
		}
		// modify by lixiang end at 2006-6-5

		if (caseFlag.trim().length() > 0) {
			//ƴ����״̬����			
			int newIndex = 0;
			String caseFlagTemp = "";
			while(true){
				if((newIndex = caseFlag.trim().indexOf(",")) != -1){
					caseFlagTemp += caseFlag.trim().substring(0,newIndex) + "','";
					caseFlag =caseFlag.trim().substring(newIndex + 1,caseFlag.trim().length());					
				}else{
					break;
				}
			}
			caseFlag = caseFlagTemp + caseFlag;
			conditions = conditions + "  AND NodeStatus in ('" + caseFlag
					+ "')";
		}		
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		// modify by zhaolu 20060816 start
		conditions = conditions
				+ uiPowerInterface.addPower(userDto, "swflog", "", "ComCode");
		// conditions =
		// conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lp","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		// modify by zhaolu 20060816 end
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		// Ŀǰֻ��Ϊ4��״̬�����ύ��Ҫ���з�ҳ
		swfLogList = (Collection) uiWorkFlowAction
				.findNodesByConditions(conditions);
		Collection swfLogList1= (Collection)uiWorkFlowAction.findStoreNodesByConditions(conditions.replace("swflog", "swflogStore"));
		if(swfLogList1 !=null){
			swfLogList.addAll(swfLogList1);
		}
		// ���nodeType=����/����Ļ�������Ҫת������/�������������
		if (nodeType.equals("speci")) {
			Iterator it = swfLogList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogTemp = new SwfLogDto();
				swfLogTemp = (SwfLogDto) it.next();
				if (swfLogTemp.getTypeFlag().equals("3")) {
					swfLogTemp.setTypeFlagName("ͨ��");
				} else if (swfLogTemp.getTypeFlag().equals("4")) {
					swfLogTemp.setTypeFlagName("Ԥ��");
				} else if (swfLogTemp.getTypeFlag().equals("5")) {
					swfLogTemp.setTypeFlagName("Ԥ��");
				} else {
					swfLogTemp.setTypeFlagName("");
				}
				swfLogListTemp.add(swfLogTemp);
			}

			swfLogList = swfLogListTemp;
		}
		SwfLogDto swfLogDto = new SwfLogDto();
		// add by lixiang start at 2006-6-5
		// reason:ת�����������õ�
		swfLogList = translateRelatePolicyOnTaskQuery(swfLogList, nodeType);
		// add by lixiang end at 2006-6-5
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setNodeType(nodeType);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		// ��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
		httpServletRequest.setAttribute("nodeType", nodeType);

	}

	/* ========================����������ѯ����������============================ */

	/* ========================���岿�֣�������ͳ�Ʋ���======================== */
	/**
	 * ������ͳ��--�ڵ�״̬��ͳ�ƹ������ڵ�״̬�����Ĺ���
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param strStartDate
	 *            String
	 * @param strEndDate
	 *            String
	 * @throws Exception
	 * @return StatStatusDto
	 */

	public StatStatusDto getNodeStatusStat(
			HttpServletRequest httpServletRequest, String strStartDate,
			String strEndDate) throws Exception {
		WorkFlowStatViewHelper workFlowStatViewHelper = new WorkFlowStatViewHelper();
		return workFlowStatViewHelper.getNodeStatusStat(httpServletRequest,
				strStartDate, strEndDate);
	}

	/**
	 * ������ͳ��--�û��ڵ�״̬��ͳ�ƹ������ڵ��û�״̬�����Ĺ���
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param strStartDate
	 *            String
	 * @param strEndDate
	 *            String
	 * @throws Exception
	 * @return StatStatusDto
	 */
	public StatStatusDto getNodeUserStatusStat(
			HttpServletRequest httpServletRequest, String strStartDate,
			String strEndDate) throws Exception {
		WorkFlowStatViewHelper workFlowStatViewHelper = new WorkFlowStatViewHelper();
		return workFlowStatViewHelper.getNodeUserStatusStat(httpServletRequest,
				strStartDate, strEndDate);

	}

	/**
	 * ��������ѯ--��ʱ�������鿴����������ѯ��ʱ��������Ϣ
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param conditions
	 *            String ��ѯ����
	 * @throws Exception
	 * @return Collection
	 */

	public Collection getNodeTimeOutInfo(HttpServletRequest httpServletRequest,
			String conditions) throws Exception {
		WorkFlowStatViewHelper workFlowStatViewHelper = new WorkFlowStatViewHelper();
		return workFlowStatViewHelper.getNodeTimeOutInfo(httpServletRequest,
				conditions);

	}

	/**
	 * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param user
	 *            ������Ա/�û�����
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */

	public void getWorkFLowNodeStatsStat(HttpServletRequest httpServletRequest,
			UserDto user, String nodeType) throws Exception {
		WorkFlowStatViewHelper workFlowStatViewHelper = new WorkFlowStatViewHelper();
		workFlowStatViewHelper.getWorkFLowNodeStatsStat(httpServletRequest,
				user, nodeType);

	}

	/* ========================��������ͳ�Ʋ���������============================ */
	/* ========================�����������У���������ʼ======================== */
	/**
	 * ���ýڵ��Ƿ���Ա��ύ����������ύ��������ԭ��
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto ��Ҫ�����Ľڵ����
	 * @throws Exception
	 */
	public void checkNodeSubmit(SwfLogDto swfLogDtoCurrent) throws Exception {
		// Ŀǰֻ��鵥֤���ύ�������֮ǰ������û���������𣬺������˺����˺���ֻҪ��һ��û����Ͳ����ύ
		// ��֤�ڵ��ж�˼·
		// ----------------------------------------------------------
		// 1.�����жϸ��������Ƿ�������µĽڵ㣨���������𣬺������˺����˺���
		// 2.��Щ�ڵ��ǲ��Ǵ��ڻ״̬������ǵĻ����������ύ
		// ----------------------------------------------------------

		String nodeType = swfLogDtoCurrent.getNodeType();
		String conditions = "";
		String nodeMsg = "";
		String msg = "";
		int checkCount = 0;
		Collection swfLogList = new ArrayList();
		Iterator it = null;

		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

		if (nodeType.equals("certi")) {
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in ('claim','certa','verif',"
					+ "'wound','veriw','propc','propv')) and  nodeStatus < '4'";

			swfLogList = uiWorkFlowAction.findNodesByConditions(conditions);
			it = swfLogList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogDto = new SwfLogDto();
				swfLogDto = (SwfLogDto) it.next();
				nodeMsg = nodeMsg + swfLogDto.getNodeName() + ",";
				checkCount++;
			}
			if (checkCount > 0) {
				msg = nodeMsg.substring(0, nodeMsg.length() - 1)
						+ "�ڵ�û�д�����ϣ������Խ��е�֤�ύ";
				throw new UserException(1, 3, "������", msg);
			}
		}

		if (nodeType.equals("compe")) {
			conditions = " flowid='"
					+ swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in ('claim','certa','verif',"
					+ "'wound','veriw','propc','propv','certi')) and  nodeStatus < '4'";

			swfLogList = uiWorkFlowAction.findNodesByConditions(conditions);
			it = swfLogList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogDto = new SwfLogDto();
				swfLogDto = (SwfLogDto) it.next();
				nodeMsg = nodeMsg + swfLogDto.getNodeName() + ",";
				checkCount++;
			}
			if (checkCount > 0) {
				msg = nodeMsg.substring(0, nodeMsg.length() - 1)
						+ "�ڵ�û�д�����ϣ������Խ�������Ĳ���";
				throw new UserException(1, 3, "������", msg);
			}
		}
		// ������֤���ж�
	}

	/**
	 * ���ýڵ��Ƿ���Ա��ύ����������ύ��������ԭ��
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto ��Ҫ�����Ľڵ����
	 * @throws Exception
	 */
	public String checkNodeSubmit(String swfLogFlowID, String swfLogLogNo)
			throws Exception {
		// Ŀǰֻ��鵥֤���ύ�������֮ǰ������û���������𣬺������˺����˺���ֻҪ��һ��û����Ͳ����ύ
		// ��֤�ڵ��ж�˼·
		// ----------------------------------------------------------
		// 1.�����жϸ��������Ƿ�������µĽڵ㣨���������𣬺������˺����˺���
		// 2.��Щ�ڵ��ǲ��Ǵ��ڻ״̬������ǵĻ����������ύ
		// ----------------------------------------------------------
		String nodeType = "";
		String conditions = "";
		String nodeMsg = "";
		String msg = "";
		String nodeName = "";
		int checkCount = 0;
		Collection swfLogList = new ArrayList();
		SwfLogDto swfLogDtoCurrent = null;
		Iterator it = null;
		int logNo = 0;
		if ("".equals(swfLogLogNo) || "null".equals(swfLogLogNo)||"undefined".equals(swfLogLogNo)) {
			logNo = 0;
		} else {
			logNo = Integer.parseInt(DataUtils.nullToZero(swfLogLogNo));
		}
		if (swfLogFlowID == null || logNo < 1)
			return msg;
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		swfLogDtoCurrent = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,
				logNo);
		if (swfLogDtoCurrent == null)
			return msg;
		nodeType = swfLogDtoCurrent.getNodeType();
		if (nodeType.equals("verip")) // �˼ۼ���Ƿ��Ѿ�����ѯ��
		{
			nodeName = "�˼�";
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and nodeType='verpo' ";
		}

		if (nodeType.equals("certi")) // ��������ǲ��ǿ����ύ
		{
			nodeName = "��֤";
			conditions = " flowid='"
					+ swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in ('claim','certa','verif','verip','verpo',"
					+ "'wound','veriw','propc','propv')) and  nodeStatus <'4'";

		}

		if (nodeType.equals("sched")) // �������ǲ��ǿ����ύ
		{
			nodeName = "����";
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in('check')) and  nodeStatus <'4'";
		}
		
		if ( nodeType.equals("compe") || nodeType.equals("compp")) // �������ǲ��ǿ����ύ
		{
			nodeName = "����";
			conditions = " flowid='"
					+ swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in ('claim','certa','verif','verip','verpo',"
					+ "'wound','veriw','propc','propv','check')) and  nodeStatus <'4'";

		}
		swfLogList = uiWorkFlowAction.findNodesByConditions(conditions);
		it = swfLogList.iterator();
		while (it.hasNext()) {
			SwfLogDto swfLogDto = new SwfLogDto();
			swfLogDto = (SwfLogDto) it.next();
			if ("claim".equals(swfLogDto.getNodeType())) {
				nodeMsg = nodeMsg + "'" + swfLogDto.getNodeName() + "',";
			} else {
				// modify by miaowenjun 20060928
				// ũ�գ���ֳ�ģ�itemcode�ݶ�Ϊ-2������ż����������~~~��
				if ("0".equals(swfLogDto.getLossItemCode())
						|| "-1".equals(swfLogDto.getLossItemCode())
						|| "-2".equals(swfLogDto.getLossItemCode())) {
					nodeMsg = nodeMsg + "'" + swfLogDto.getNodeName() + "',";
				} else {
					// modify by miaowenjun 20060929 ����Ҳ�ģ�ũ�����ҳ��ƺ�ȥ��
					if (!"I".equals(new UICodeAction()
							.translateRiskCodetoRiskType(swfLogDto
									.getRiskCode()))
							&& !"H".equals(new UICodeAction()
									.translateRiskCodetoRiskType(swfLogDto
											.getRiskCode()))) {
						nodeMsg = nodeMsg
								+ "'���ƺ���Ϊ��"
								+ DataUtils.nullToEmpty(swfLogDto
										.getLossItemName()) + "��"
								+ swfLogDto.getNodeName() + "',";
					} else {
						nodeMsg = nodeMsg + "��'" + swfLogDto.getNodeName()
								+ "',";
					}
				}
			}
			checkCount++;
		}
		if (checkCount > 0) {
			msg = nodeMsg.substring(0, nodeMsg.length() - 1) + "�ڵ�û�д�����ϣ����ܽ���"
					+ nodeName;
		}

		// ������֤���ж�
		return msg;
	}

	/**
	 * ���ýڵ��ڹ��������Ƿ���ڣ�������ڣ����ؽڵ�����
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto ��Ҫ�����Ľڵ����
	 * @throws Exception
	 */
	public String checkNodeExistInFlow(String swfLogFlowID, String strNodeTypes)
			throws Exception {

		String conditions = "";
		String nodeMsg = "";
		String msg = "";

		int checkCount = 0;
		Collection swfLogList = new ArrayList();
		Iterator it = null;

		conditions = " flowid='" + swfLogFlowID + "' and (nodeType in ("
				+ strNodeTypes + ")) and  nodeStatus <'4'";
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		swfLogList = uiWorkFlowAction.findNodesByConditions(conditions);
		it = swfLogList.iterator();
		while (it.hasNext()) {
			SwfLogDto swfLogDto = new SwfLogDto();
			swfLogDto = (SwfLogDto) it.next();
			nodeMsg = nodeMsg + "'" + swfLogDto.getNodeName() + "',";
			checkCount++;
		}
		if (checkCount > 0) {
			msg = nodeMsg.substring(0, nodeMsg.length() - 1);
		}

		// �����ж�
		// ���msg�ĳ��ȴ�
		return msg;
	}

	/**
	 * У�鹤����DTO�ǲ��ǺϷ����Դ����dto
	 * 
	 * @param workFlowDto
	 *            WorkFlowDto
	 * @throws Exception
	 * @return boolean
	 */
	public boolean checkDealDto(WorkFlowDto workFlowDto) throws Exception {
		boolean result = false;
		if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
				|| (workFlowDto.getSubmit()) || (workFlowDto.getClose())) {
			result = true;
		}
		return result;

	}

	/**
	 * ��ѯ���ڵ㣬����ύ�Ļ��������ж���
	 * 
	 * @param modelNo
	 *            String ģ�����
	 * @param nodeNo
	 *            String �ڵ����
	 * @throws Exception
	 * @return Collection
	 */
	public Collection getNextSumbitNodes(String modelNo, String nodeNo)
			throws Exception { // ����˼·��
		// ---------------------------------------------------
		// 1������ģ����룬�ڵ�����ѯ������swfPath������
		// 2������ע��,defaultFlag asc,priority asc
		// ---------------------------------------------------

		Collection nodesList = new ArrayList();
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		String conditions = "modelNo=" + modelNo + " and startNodeNo=" + nodeNo
				+ " order by defaultFlag,priority";
		nodesList = uiWorkFlowAction.findModelPathNodes(conditions);
		return nodesList;
	}

	/**
	 * ��ѯ���ڵ㣬�������ֺͲ����û����ʹ�õ�ģ�����
	 * 
	 * @param modelNo
	 *            String ģ�����
	 * @param nodeNo
	 *            String �ڵ����
	 * @throws Exception
	 * @return Collection
	 */
	public int getModelNoByRiskComCode(String RiskCode, String comCode)
			throws Exception {
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		int modelNo = uiWorkFlowAction.getModelNo(RiskCode, comCode);
		return modelNo;
	}

	/* ========================�����������У�����������======================== */
	/**
	 * ��ԭ��ĸ����������ϵĴ���ԭ��
	 * 
	 * @param flowID
	 *            String
	 * @param logNo
	 *            String
	 * @param handlerCode
	 *            String
	 * @param reasion
	 *            String
	 * @throws Exception
	 * @return WorkFlowDto
	 */
	public WorkFlowDto changeFlowNodeHandler(String flowID, String logNo,
			String handlerCode, String reasion, String handleDept)
			throws Exception {
		WorkFlowDto workFlowDto = new WorkFlowDto();
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		UICodeAction uiCodeAction = new UICodeAction();
		int intLogNo = Integer.parseInt(DataUtils.nullToZero(logNo));
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowID, intLogNo);
		if (swfLogDto == null)
			return workFlowDto;

		// Ĭ��handleDeptΪ�գ����жϡ�
		if (!handleDept.equals("")) {
			if (swfLogDto.getHandleDept().equals(handleDept)
					&& swfLogDto.getHandlerCode().equals(handlerCode))
				return workFlowDto;
		} else {
			if (swfLogDto.getHandlerCode().equals(handlerCode))
				return workFlowDto;
		}

		// if (handlerCode.length()>0 ){

		String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
		swfLogDto.setHandlerCode(handlerCode);
		swfLogDto.setHandlerName(handlerName);

		// }
		swfLogDto.setFlowInTime(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND).toString());

		// ����ʱ��

		if (!handleDept.equals("")) {
			swfLogDto.setHandleDept(handleDept);
		}
		workFlowDto.setUpdateSwfLogDto(swfLogDto);
		workFlowDto.setUpdate(true);
		SwfNotionDto swfNotionDto = new SwfNotionDto();
		int lineNo = uiWorkFlowAction.getSwfNotionMaxLineNo(flowID, intLogNo);
		swfNotionDto.setFlowID(flowID);
		swfNotionDto.setLogNo(intLogNo);
		swfNotionDto.setLineNo(lineNo);
		swfNotionDto.setHandleText(reasion);
		ArrayList swfNotionList = new ArrayList();
		swfNotionList.add(swfNotionDto);
		workFlowDto.setSwfNotionDtoList(swfNotionList);
		return workFlowDto;
	}

	// modify by wangli add start 20050412
	/* ========================����������ѯ��������ʼ============================ */
	/**
	 * ����������ʾ����������������嵥
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param conditions
	 *            ��ѯ����
	 * @throws Exception
	 */
	public void getScheduleAddCertainLossSwfLogList(
			HttpServletRequest httpServletRequest, String conditions)
			throws Exception {

		// ��ѯ����ڵ�״̬��Ϣ
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		// �õ�����������Ϣ
		ArrayList swfLogList = new ArrayList();
		// Ŀǰֻ��Ϊ4��״̬�����ύ��Ҫ���з�ҳ
		// ÿҳ��ʾ������
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo = httpServletRequest.getParameter("pageNo");
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";

		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����

		PageRecord pageRecord = (PageRecord) uiWorkFlowAction
				.findNodesByConditions(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList(swfLogList);
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
	}

	/**
	 * ���ݱ����źͱ�����,���ƺţ�����ʱ�䣬����״̬��ѯ������Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param registNo
	 *            ������
	 * @param policyNo
	 *            ������
	 * @param licenseNo
	 *            ���ƺ���
	 * @param riskCode
	 *            �ձ�
	 * @param insuredName
	 *            ������������
	 * @throws Exception
	 */
	public void getWorkFlowList(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo,
			String riskCode, String insuredName, int intPageNo,
			int intRecordPerPage) throws Exception {
		// ��������ı����ţ�����������SQL where �Ӿ�
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		insuredName = StringUtils.rightTrim(insuredName);
		riskCode = StringUtils.rightTrim(riskCode);
		riskCode = StringUtils.rightTrim(riskCode);
		insuredName = StringUtils.rightTrim(insuredName);
		String caseType = httpServletRequest.getParameter("caseType");
		String strTableName = "Swflog";//���̲�ѯʹ�õı�δת����ѯ��swflog����ת����ѯ��swflogstore
		String conditions = " 1=1  ";
		String swflogCondition = "";
		String swflogStoreCondition = "";
		// add by qinyong 2005-9-3 end
		
		if (policyNo.length() > 0) {

			// add by lixiang start at 2006-06-05
			// reason:�ı��ѯ�����ķ�ʽ��Ϊת��ΪregistNo�ĺ���Ĳ�ѯ

			conditions = conditions
					+ " and registno in (select registno from "
					+ "prplregistrpolicy where 1=1 "
					+ StringConvert.convertString(" policyNo", policyNo,
							httpServletRequest.getParameter("PolicyNoSign"))
					+ ") ";
		}
		// reason : ���ݽ᰸״̬ƴsql�������Ƿ�᰸�ж�
		/**
		 * sql���˵���� ����һ���������еĽ᰸�ڵ�״̬���ж��Ƿ��Ѿ��᰸�������ǣ��н᰸�ڵ� and nodestatus=4 and
		 * endflag = 1 1,select flowid from swflog where nodetype = 'regis')
		 * �鴦���й�����,������I 2,select flowid from swflog where nodetype ='endca' and
		 * endflag='1' and nodestatus = '4' and flowid in
		 * (I);�����й��������ҳ��Ѿ��᰸�Ĺ�����,������II 3,select * from swflog where registno =
		 * 'regis' and flowid in (II) �鴦���н᰸�ڵ㣻 4,select * from swflog where
		 * registno = 'regis' and flowid not in (II) �鴦����δ�᰸�ڵ㣻
		 */
		if (caseType != null && !caseType.equals("") && caseType.equals("1")) {
				strTableName = "SwflogStore";
		}

		// reason : ���Ӳ�ѯ�������ݣ������ձ������Ĳ�ѯ
/*		String riskCodeName = StringUtils.rightTrim(httpServletRequest
				.getParameter("prpLregistRiskCodeName"));
		String riskCodeNameSign = httpServletRequest
				.getParameter("RiskCodeNameSign");
		if (riskCodeName != null && riskCodeName.length() > 0) {
			conditions = conditions
					+ " and exists (select 0 from prpdrisk where prpdrisk.riskcode=swflog.riskcode "
					+ StringConvert.convertString(" riskcname", riskCodeName,
							riskCodeNameSign) + ")";
		}
*/		// add by lixiang end 2006-9-8

		// ƴȨ��
		
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		// modify by zhaolu 20060816 start
		// conditions =
		// conditions+uiPowerInterface.addPower(userDto.getUserCode(),httpServletRequest.getParameter("taskCodeC"),"swfLog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		if(!new BLPowerFacade().isSuperUser(userDto.getComCode(), userDto.getUserCode())){ 
			conditions = conditions + " and (exists(select 1 from " + strTableName + " g where g.registno= " + strTableName + ".registno ";
			conditions = conditions
					+ uiPowerInterface.addPower(userDto, strTableName, "", "handleDept").replaceAll(strTableName, "g");
			//�Ż�sql����start
			if (insuredName.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" g.insuredName", insuredName,
								httpServletRequest.getParameter("InsuredNameSign"));
			}
			if (licenseNo.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" g.lossitemName", licenseNo,
								httpServletRequest.getParameter("LicenseNoSign"));
			}
			if (riskCode.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" g.riskCode", riskCode,
								httpServletRequest.getParameter("RiskCodeSign"));
			}
			if (registNo.length() > 0) {
				conditions = conditions
						+ StringConvert.convertString(" g.RegistNO", registNo,
								httpServletRequest.getParameter("RegistNoSign"));
			}
			conditions = conditions + ")";
			//�Ż�sql����end
			conditions = conditions
			+ uiPowerInterface.addPower(userDto, "vv","", "ComCode").replaceAll("AND", "or").replaceAll("vv", strTableName)+")";
		}
		// modify by zhaolu 20060816 end
		conditions = conditions + " and nodeType='regis'";
		conditions += " and dataFlag is null ";
		if (insuredName.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" insuredName", insuredName,
							httpServletRequest.getParameter("InsuredNameSign"));
		}
		if (licenseNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" lossitemName", licenseNo,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		if (riskCode.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" riskCode", riskCode,
							httpServletRequest.getParameter("RiskCodeSign"));
		}
		if (registNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString("RegistNO", registNo,
							httpServletRequest.getParameter("RegistNoSign"));
		}
		//��������ʱ��
		String registFlowinTime = StringUtils.rightTrim(httpServletRequest
				.getParameter("prpLregistFlowinTime"));
		String flowinTimeNoSign = httpServletRequest
				.getParameter("FlowinTimeNoSign");
		if (registFlowinTime != null && registFlowinTime.length() > 0) {
			conditions = conditions
					+ " And to_Date (Flowintime,'yyyy-MM-dd HH24:mi:ss')" + flowinTimeNoSign + "to_date('" + registFlowinTime + " 00:00:00','yyyy-MM-dd HH24:mi:ss')";
		}
		//���������ũ�ձ�ʶ
		conditions = conditions + " and (systemflag is null or systemflag<>'agri') ";
		if (caseType != null && caseType.equals("")) {
			swflogCondition = conditions;
			swflogStoreCondition = conditions.replaceAll("Swflog", "SwflogStore");
		}
		//conditions += " and dataFlag is null "; 
		
		// ��session��ȡ��ƶ/�󻧱�־
		String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				conditions = conditions + " and policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
			}
			if(strHPflag.equals("Retaol")) {
				conditions = conditions + " and policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
			}	
		}
		conditions = conditions + " order by handleTime desc";
		// ��ѯ������Ϣ
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

//		int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
//				.get("sysconst.MaxQueryCount")));
//		int count = 0;
//		// �ж���������
//		//count = uiWorkFlowAction.findFlowNodeCountByConditon(conditions);
//		if (maxQueryCount != 0 && count > maxQueryCount) {
//			throw new UserException(1, 3, "0000", "��ѯ�����������ϵͳ����");
//		}
		// �õ����б���������Ϣ
		PageRecord pageRecord = null;
		if (caseType != null ) {
			//�ѽ᰸ת��
			if(caseType.equals("1")){
				pageRecord = (PageRecord) uiWorkFlowAction.findStoreNodesByConditions(
						conditions, intPageNo, intRecordPerPage);
			//δ�᰸ת��
			}else if(caseType.equals("0")){
				pageRecord = (PageRecord) uiWorkFlowAction.findNodesByConditions(
						conditions, intPageNo, intRecordPerPage);
			//���а���
			}else{
				BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
				pageRecord = (PageRecord) blSwfLogFacade.findAllStatusByConditions(
						swflogCondition,swflogStoreCondition, intPageNo, intRecordPerPage);
			}
	    }
		
		ArrayList swfLogList = new ArrayList();
		swfLogList = (ArrayList) pageRecord.getResult();
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList(swfLogList);
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);

		swfLogDto.setTurnPageDto(turnPageDto);

		// add by miaowenjun 20060418
		// ���´���ʲô��˼��lixiang ���������ס�������������ʾ����ע����
		// modify by lixiang start at 20060605
		ArrayList prpLclaimList = new ArrayList();
		ArrayList swfLogListtemp = new ArrayList();
		UICodeAction uiCodeAction = new UICodeAction();
		if (swfLogDto.getSwfLogList() != null) {
			// ����ѯ�����Ϊ�գ�������ת��������ȷ���Ƿ�������ע���������Ǳ���ע����
			UIClaimAction uiClaimAction = new UIClaimAction();
			BLSwfLogFacade blSwflogFacade = new BLSwfLogFacade();			
			for (int index = 0; index < swfLogDto.getSwfLogList().size(); index++) {
				SwfLogDto swfLogDtotemp = new SwfLogDto();
				swfLogDtotemp = (SwfLogDto) ((ArrayList) swfLogDto
						.getSwfLogList()).get(index);

				// add by lixiang start at 2006-9-9
				// reson:��ʾ��������
				String strTemp = uiCodeAction.translateRiskCode(swfLogDtotemp
						.getRiskCode(), true);
				if (strTemp != null && strTemp.length() > 4)
					strTemp = strTemp.substring(0, 4);
				swfLogDtotemp.setRiskCodeName(strTemp);
				// add by lixiang end at 2006-9-9
				// �����ж��Ƿ��Ǳ���ע��������Ǳ���ע���Ļ����϶�û����
				String nodetypetemp = "";
				BLPrpLaccipersonFacade blPrpLaccipersonFacade = new BLPrpLaccipersonFacade();
				if ("6".equals(swfLogDtotemp.getNodeStatus())) {
					swfLogDtotemp.setOtherFlag("����ע��");
					if("2714".equals(swfLogDtotemp.getRiskCode())){
						String conditions1 = " certino='"+swfLogDtotemp.getRegistNo()+"' ";
						ArrayList<PrpLacciPersonDto> prpLacciPersonDtos = (ArrayList<PrpLacciPersonDto>) blPrpLaccipersonFacade.findByConditions(conditions1);
						if(prpLacciPersonDtos != null && prpLacciPersonDtos.size()>0){
							String insurednametemp = swfLogDtotemp.getInsuredName()+"(";
							for(PrpLacciPersonDto prpLacciPersonDto : prpLacciPersonDtos){
								insurednametemp += prpLacciPersonDto.getAcciName() + ",";
							}
							insurednametemp = insurednametemp.substring(0,insurednametemp.length()-1);
							insurednametemp += ")";
							 swfLogDtotemp.setInsuredName(insurednametemp);
						}
					}
					if("0310".equals(swfLogDtotemp.getRiskCode())||"0312".equals(swfLogDtotemp.getRiskCode()))
					{
						nodetypetemp = "regis";
						BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
						 String conditionstemp = "";
						 conditionstemp = "registno='"+swfLogDtotemp.getRegistNo() + "' and nodetype='"+nodetypetemp + "'";
						 ArrayList collectiontemp = new ArrayList();
						 
						 collectiontemp =  (ArrayList)bLPrplcompensatehouseFacade.findByConditions(conditionstemp);
						 if(collectiontemp.size() >0)
						 {
							 PrplcompensatehouseDto prplcompensatehouseDto= (PrplcompensatehouseDto)collectiontemp.get(0);
							 String insurednametemp = swfLogDtotemp.getInsuredName();
							 insurednametemp = insurednametemp+"("+ prplcompensatehouseDto.getName() + ")";
							 swfLogDtotemp.setInsuredName(insurednametemp);
						 }
					}
				}
				// �ж��Ƿ�Ϊ����ע��,Ŀǰ�����ε�����Ϊ����ǿ������ʾһ���ǲ����ģ���Ҫ���ơ�
				
				prpLclaimList =	(ArrayList)uiClaimAction.findByConditions("prplclaim.registNo='" +
							swfLogDtotemp.getRegistNo() + "'"); 
				if(prpLclaimList != null &&	prpLclaimList.size() > 0){ 
					for(int i = 0 ; i < prpLclaimList.size(); i ++){
						PrpLclaimDto prpLclaimDto = (PrpLclaimDto)prpLclaimList.get(i);
						if(i > 0){
							swfLogDtotemp.setOtherFlag(swfLogDtotemp.getOtherFlag() + "/");
						}else{							
							swfLogDtotemp.setOtherFlag("");													
						}
						if(prpLclaimDto.getCancelDate() != null && !prpLclaimDto.getCancelDate().toString().equals("")){
							swfLogDtotemp.setOtherFlag(swfLogDtotemp.getOtherFlag() + "����ע��"); 
							if("2714".equals(swfLogDtotemp.getRiskCode())){
								String conditions1 = " certino='"+swfLogDtotemp.getRegistNo()+"' ";
								ArrayList<PrpLacciPersonDto> prpLacciPersonDtos = (ArrayList<PrpLacciPersonDto>) blPrpLaccipersonFacade.findByConditions(conditions1);
								if(prpLacciPersonDtos != null && prpLacciPersonDtos.size()>0){
									String insurednametemp = swfLogDtotemp.getInsuredName()+"(";
									for(PrpLacciPersonDto prpLacciPersonDto : prpLacciPersonDtos){
										insurednametemp += prpLacciPersonDto.getAcciName() + ",";
									}
									insurednametemp = insurednametemp.substring(0,insurednametemp.length()-1);
									insurednametemp += ")";
									 swfLogDtotemp.setInsuredName(insurednametemp);
								}
							}
							if("0310".equals(swfLogDtotemp.getRiskCode())||"0312".equals(swfLogDtotemp.getRiskCode()))
							{
								nodetypetemp = "check";
								BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
								 String conditionstemp = "";
								 conditionstemp = "registno='"+swfLogDtotemp.getRegistNo() + "' and nodetype='"+nodetypetemp + "'";
								 ArrayList collectiontemp = new ArrayList();
								 
								 collectiontemp =  (ArrayList)bLPrplcompensatehouseFacade.findByConditions(conditionstemp);
								 if(collectiontemp.size() >0)
								 {
									 PrplcompensatehouseDto prplcompensatehouseDto= (PrplcompensatehouseDto)collectiontemp.get(0);
									 String insurednametemp = swfLogDtotemp.getInsuredName();
									 insurednametemp = insurednametemp+"("+ prplcompensatehouseDto.getName() + ")";
									 swfLogDtotemp.setInsuredName(insurednametemp);
								 }
							}
						}
						else if(prpLclaimDto.getEndCaseDate() != null && !prpLclaimDto.getEndCaseDate().toString().equals("")){
							
							swfLogDtotemp.setOtherFlag(swfLogDtotemp.getOtherFlag() + "�ѽ᰸"); 
							if("2714".equals(swfLogDtotemp.getRiskCode())){
								String conditions1 = " certino='"+swfLogDtotemp.getRegistNo()+"' ";
								ArrayList<PrpLacciPersonDto> prpLacciPersonDtos = (ArrayList<PrpLacciPersonDto>) blPrpLaccipersonFacade.findByConditions(conditions1);
								if(prpLacciPersonDtos != null && prpLacciPersonDtos.size()>0){
									String insurednametemp = swfLogDtotemp.getInsuredName()+"(";
									for(PrpLacciPersonDto prpLacciPersonDto : prpLacciPersonDtos){
										insurednametemp += prpLacciPersonDto.getAcciName() + ",";
									}
									insurednametemp = insurednametemp.substring(0,insurednametemp.length()-1);
									insurednametemp += ")";
									 swfLogDtotemp.setInsuredName(insurednametemp);
								}
							}
							if("0310".equals(swfLogDtotemp.getRiskCode())||"0312".equals(swfLogDtotemp.getRiskCode()))
							{
								nodetypetemp = "compe";
								BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
								 String conditionstemp = "";
								 conditionstemp = "registno='"+swfLogDtotemp.getRegistNo() + "' and nodetype='"+nodetypetemp + "'";
								 ArrayList collectiontemp = new ArrayList();
								 
								 collectiontemp =  (ArrayList)bLPrplcompensatehouseFacade.findByConditions(conditionstemp);
								 if(collectiontemp.size() >0)
								 {
									 PrplcompensatehouseDto prplcompensatehouseDto= (PrplcompensatehouseDto)collectiontemp.get(0);
									 String insurednametemp = swfLogDtotemp.getInsuredName();
									 insurednametemp = insurednametemp+"("+ prplcompensatehouseDto.getName() + ")";
									 swfLogDtotemp.setInsuredName(insurednametemp);
								 }
							}
						}			
						else{
							swfLogDtotemp.setOtherFlag("");
						}
					}
					//������δ�᰸�İ���״̬��ʾ���ڵ�
					if(swfLogDtotemp.getOtherFlag() == null || "".equals(swfLogDtotemp.getOtherFlag())){
						 swfLogDtotemp.setOtherFlag("������(" + blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID()) + ")");
						 if("2714".equals(swfLogDtotemp.getRiskCode())){
								String conditions1 = " certino='"+swfLogDtotemp.getRegistNo()+"' ";
								ArrayList<PrpLacciPersonDto> prpLacciPersonDtos = (ArrayList<PrpLacciPersonDto>) blPrpLaccipersonFacade.findByConditions(conditions1);
								if(prpLacciPersonDtos != null && prpLacciPersonDtos.size()>0){
									String insurednametemp = swfLogDtotemp.getInsuredName()+"(";
									for(PrpLacciPersonDto prpLacciPersonDto : prpLacciPersonDtos){
										insurednametemp +=  prpLacciPersonDto.getAcciName() + ",";
									}
									insurednametemp = insurednametemp.substring(0,insurednametemp.length()-1);
									insurednametemp += ")";
									 swfLogDtotemp.setInsuredName(insurednametemp);
								}
							}
						 if("0310".equals(swfLogDtotemp.getRiskCode())||"0312".equals(swfLogDtotemp.getRiskCode()))
						 {
							 if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "regis";
								 
							 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "regis";
							 }else if("�鿱".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "regis";
							 }else if("�Ʋ�����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "check";
							 }else if("�˼�".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "propc";
							 }else if("�Ʋ�����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "verip";
							 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "propv";
							 }else if("��֤".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "claim";
							 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "claim";
							 }else if("������".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "compe";
							 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "compe";
							 }
							 BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
							 String conditionstemp = "";
							 conditionstemp = "registno='"+swfLogDtotemp.getRegistNo() + "' and nodetype='"+nodetypetemp + "'";
							 ArrayList collectiontemp = new ArrayList();
							 
							 collectiontemp =  (ArrayList)bLPrplcompensatehouseFacade.findByConditions(conditionstemp);
							 if(collectiontemp.size() >0)
							 {
								 PrplcompensatehouseDto prplcompensatehouseDto= (PrplcompensatehouseDto)collectiontemp.get(0);
								 String insurednametemp = swfLogDtotemp.getInsuredName();
								 insurednametemp = insurednametemp+"("+ prplcompensatehouseDto.getName() + ")";
								 swfLogDtotemp.setInsuredName(insurednametemp);
							 }
							 
							 
						 }
					 }
				 }
			     //�ѱ���δ�����İ���״̬��ʾ���ڵ�
				 if(swfLogDtotemp.getOtherFlag() == null || "".equals(swfLogDtotemp.getOtherFlag())){
					 swfLogDtotemp.setOtherFlag("δ����(" + blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID()) + ")");
					 if("2714".equals(swfLogDtotemp.getRiskCode())){
							String conditions1 = " certino='"+swfLogDtotemp.getRegistNo()+"' ";
							ArrayList<PrpLacciPersonDto> prpLacciPersonDtos = (ArrayList<PrpLacciPersonDto>) blPrpLaccipersonFacade.findByConditions(conditions1);
							if(prpLacciPersonDtos != null && prpLacciPersonDtos.size()>0){
								String insurednametemp = swfLogDtotemp.getInsuredName()+"(";
								for(PrpLacciPersonDto prpLacciPersonDto : prpLacciPersonDtos){
									insurednametemp += prpLacciPersonDto.getAcciName() + ",";
								}
								insurednametemp = insurednametemp.substring(0,insurednametemp.length()-1);
								insurednametemp += ")";
								 swfLogDtotemp.setInsuredName(insurednametemp);
							}
						}
					 if("0310".equals(swfLogDtotemp.getRiskCode())||"0312".equals(swfLogDtotemp.getRiskCode()))
					 {
						 if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "regis";
							 
						 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "regis";
						 }else if("�鿱".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "regis";
						 }else if("�Ʋ�����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "check";
						 }else if("�˼�".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "propc";
						 }else if("�Ʋ�����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "verip";
						 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "propv";
						 }else if("��֤".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "claim";
						 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "claim";
						 }else if("������".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "compe";
						 }else if("����".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "compe";
						 }
						 BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
						 String conditionstemp = "";
						 conditionstemp = "registno='"+swfLogDtotemp.getRegistNo() + "' and nodetype='"+nodetypetemp + "'";
						 ArrayList collectiontemp = new ArrayList();
						 
						 collectiontemp =  (ArrayList)bLPrplcompensatehouseFacade.findByConditions(conditionstemp);
						 if(collectiontemp.size() >0)
						 {
							 PrplcompensatehouseDto prplcompensatehouseDto= (PrplcompensatehouseDto)collectiontemp.get(0);
							 String insurednametemp = swfLogDtotemp.getInsuredName();
							 insurednametemp = insurednametemp+"("+ prplcompensatehouseDto.getName() + ")";
							 swfLogDtotemp.setInsuredName(insurednametemp);
						 }
						 
						 
					 }
				 }
				 
				 
				 
				 
					 
				 

				 
				// ����ǿ�����޸ģ���Ҫ��������ŵ���ʾ��
				UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
				String strSql = " registno='" + swfLogDtotemp.getRegistNo()
						+ "'";// and validstatus='1'";
				// ȡ�ö�������ı�����Ϣ
				Collection relatePolicyList = uiPrpLregistRPolicyAction
						.findByConditions(strSql);

				swfLogDtotemp.setRelatePolicyList(relatePolicyList);
				swfLogListtemp.add(swfLogDtotemp);
			}
			// ����������б�ŵ���������С�
			swfLogDto.setSwfLogList(swfLogListtemp);
		}
		// modify by lixiang end at 20060605
		// add end by miaowenjun 20060418

		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		swfLogDto.setEditType(httpServletRequest.getParameter("editType"));
	}

	/* ========================����������ѯ����������============================ */
	// modify by wangli add end 20050412
	/**
	 * ���ýڵ��Ƿ���Ա��ύ����������ύ��������ԭ��
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto ��Ҫ�����Ľڵ����
	 * @throws Exception
	 */
	public int checkCompensateCount(String flowID, String nodeType)
			throws Exception {
		// Ŀǰֻ��鵥֤���ύ�������֮ǰ������û���������𣬺������˺����˺���ֻҪ��һ��û����Ͳ����ύ
		// ��֤�ڵ��ж�˼·
		// ----------------------------------------------------------
		// 1.�����жϸ��������Ƿ�������µĽڵ㣨���������𣬺������˺����˺���
		// 2.��Щ�ڵ��ǲ��Ǵ��ڻ״̬������ǵĻ����������ύ
		// ----------------------------------------------------------
		String conditions = "";
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

		conditions = " flowid='" + flowID + "'" + " and  nodeType='" + nodeType
				+ "'";
		// ������֤���ж�
		return uiWorkFlowAction.getCount(conditions);
	}

	/**
	 * ���ҷ������������̽ڵ���Ϣ
	 * 
	 * @param condition
	 *            ����
	 * @throws Exception
	 * @return String
	 */
	public Collection findStoreNodesByConditions(String condition)
			throws Exception {
		SwfLogFindByConditionsCommand swfLogStoreFindByConditionsCommand = new SwfLogFindByConditionsCommand(
				condition);
		return (Collection) swfLogStoreFindByConditionsCommand.execute();
	}

	/**
	 * �����Ҫ���й������������
	 * 
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @return boolean
	 */
	private boolean checkNeedFindRelatePolicy(String nodeType) throws Exception {
		boolean blresut = true;
		// �����������飬�᰸�ǲ���Ҫ���й������������
		if ("claim".equals(nodeType) || "compp".equals(nodeType)
				|| "endca".equals(nodeType)) {
			blresut = false;

		}
		return blresut;
	}

	/**
	 * �����Ҫ���й������������
	 * 
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @return boolean
	 */
	private Collection translateRelatePolicyOnTaskQuery(Collection swfLogList,
			String nodeType) throws Exception {
		Collection swfLogListTemp = new ArrayList();
		UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		Iterator it = swfLogList.iterator();
		String strSql = "";
		while (it.hasNext()) {
			SwfLogDto swfLogTemp = new SwfLogDto();
			swfLogTemp = (SwfLogDto) it.next();
			Collection relatePolicyList = new ArrayList();
			if (checkNeedFindRelatePolicy(swfLogTemp.getNodeType())) {
				// ȡ�ö�������ı�����Ϣ
				strSql = " registno='" + swfLogTemp.getRegistNo() + "'";
				relatePolicyList = uiPrpLregistRPolicyAction
						.findByConditions(strSql);

			} else {
				// �������Ҫ�Ļ���ֱ�ӽ������еı�������ŵ���ʾ�õ�relatePolicyList������
				PrpLRegistRPolicyDto prpLregistRPolicyDto = new PrpLRegistRPolicyDto();
				prpLregistRPolicyDto.setPolicyNo(swfLogTemp.getPolicyNo());
				prpLregistRPolicyDto.setRegistNo(swfLogTemp.getRegistNo());
				relatePolicyList.add(prpLregistRPolicyDto);
			}

			swfLogTemp.setRelatePolicyList(relatePolicyList);

			swfLogListTemp.add(swfLogTemp);

		}
		return swfLogListTemp;
	}

	/**
	 * �����Ҫ���й������������,�õ��Ĺ�������
	 * 
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @return boolean
	 */
	private SwfLogDto translateRelatePolicyOnTaskQueryOne(SwfLogDto swfLogTemp)
			throws Exception {
		UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		String strSql = "";
		Collection relatePolicyList = new ArrayList();
		if (checkNeedFindRelatePolicy(swfLogTemp.getNodeType())) {
			// ȡ�ö�������ı�����Ϣ
			strSql = " registno='" + swfLogTemp.getRegistNo() + "'";
			relatePolicyList = uiPrpLregistRPolicyAction
					.findByConditions(strSql);

		} else {
			// �������Ҫ�Ļ���ֱ�ӽ������еı�������ŵ���ʾ�õ�relatePolicyList������
			PrpLRegistRPolicyDto prpLregistRPolicyDto = new PrpLRegistRPolicyDto();
			prpLregistRPolicyDto.setPolicyNo(swfLogTemp.getPolicyNo());
			prpLregistRPolicyDto.setRegistNo(swfLogTemp.getRegistNo());
			relatePolicyList.add(prpLregistRPolicyDto);
		}

		swfLogTemp.setRelatePolicyList(relatePolicyList);

		return swfLogTemp;
	}
	/**
	 * ���ݽڵ�����Ͳ���״̬��������Ϣ(��ҳ)
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogList(HttpServletRequest httpServletRequest, String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
	    conditions = getComBineListConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findByPolicyNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					SwfLogDto swfLogTemp = new SwfLogDto();
					swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by qianxiantao add end 2011-07-03
	}
	/**
	 * �����¹ʺŲ�ѯ��Ϣ(��ҳ)
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogListByComBineNo(HttpServletRequest httpServletRequest,String condition,String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
	    conditions = getComBineListByComBineNoConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findByComBineNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					PrplcombineSwfLogDto swfLogTemp = new PrplcombineSwfLogDto();
					swfLogTemp = (PrplcombineSwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
        PrplcombineSwfLogDto swfLogDto = new PrplcombineSwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by qianxiantao add end 2011-07-03
	}
	/**
	 * ���ݱ����Ų�ѯ��Ϣ(��ҳ)
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogListByRegistNo(HttpServletRequest httpServletRequest,String RegistNo,String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
        String conditions = null;
     try{
	    conditions = getComBineListByRegistNoConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findByComBineNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					PrplcombineSwfLogDto swfLogTemp = new PrplcombineSwfLogDto();
					swfLogTemp = (PrplcombineSwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
        PrplcombineSwfLogDto swfLogDto = new PrplcombineSwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by qianxiantao add end 2011-07-03
     }catch(Exception e){
    	 throw e;
     }
	}
	/**
	 * ���ݱ����Ų�ѯ��Ϣ(��ҳ)
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogListByPolicyNo(HttpServletRequest httpServletRequest,String PolicyNo,String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
	    conditions = getComBineListByPolicyNoConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findBypolicyNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					PrplcombineSwfLogDto swfLogTemp = new PrplcombineSwfLogDto();
					swfLogTemp = (PrplcombineSwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
        PrplcombineSwfLogDto swfLogDto = new PrplcombineSwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by qianxiantao add end 2011-07-03
	}
	/**
	 * ����������ѯδ����������Ϣ����������
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineCompensateListByConditions(HttpServletRequest httpServletRequest,String condition,String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
	    conditions = getCompensateListConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findCompensateListByConditions(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					PrplcombineSwfLogDto swfLogTemp = new PrplcombineSwfLogDto();
					swfLogTemp = (PrplcombineSwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
        PrplcombineSwfLogDto swfLogDto = new PrplcombineSwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by qianxiantao add end 2011-07-03
	}
	/**
	 * ����������ѯδ����������Ϣ����������
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @author Li, Yang
	 */
	public void getComBineWorkFlowLogListInCombineEditList(HttpServletRequest httpServletRequest, String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// �õ����б���������Ϣ
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
	    conditions = getComBineListCondition(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findComBineListByCondition(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);

			if (swfLogList != null && swfLogList.size() > 0) {
				for (int i = 0; i < swfLogList.size(); i++) {
					PrplcombineSwfLogDto swfLogTemp = new PrplcombineSwfLogDto();
					swfLogTemp = (PrplcombineSwfLogDto) (((ArrayList) swfLogList).get(i));
					swfLogListTemp.add(swfLogTemp);
				}
				swfLogList = swfLogListTemp;
			}
        PrplcombineSwfLogDto swfLogDto = new PrplcombineSwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by Li, Yang add end 2011-09-13
	}
	
	/**
	 * ���������ʾ�б��������ֻ��ʾ�鿱��������������֤�������з��ύ״̬�Ľڵ㣩
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 * add by Li, Yang
	 */
	private String getComBineListCondition(
			HttpServletRequest httpServletRequest) throws Exception {
		    UIPowerInterface uiPowerInterface = new UIPowerInterface();
		    String flag=httpServletRequest.getParameter("Flag");
		    String statStartDate="";
		    String statEndDate="";
		    String riskCode=httpServletRequest.getParameter("riskCode");
		    String policyNo=httpServletRequest.getParameter("PolicyNo");
		    String combineNo = httpServletRequest.getParameter("ComBineNo");
		    String registNo = httpServletRequest.getParameter("RegistNo");
		    String insuredName = httpServletRequest.getParameter("InsuredName");
		    if("N".equals(flag)){
		    	combineNo=httpServletRequest.getParameter("ComBineNo");
		    	statStartDate=httpServletRequest.getParameter("statStartDate");
			    statEndDate=httpServletRequest.getParameter("statEndDate");
		    }else{
		    	combineNo=httpServletRequest.getParameter("comBineNo");	
		        statStartDate=httpServletRequest.getParameter("StartDate");
		        statEndDate=httpServletRequest.getParameter("EndDate");
		    }
		    UserDto userDto = (UserDto) httpServletRequest.getSession()
			.getAttribute("user");
		    String condition = " 1=1 and o.registno = g.registno ";
            if(null != policyNo && !"".equals(policyNo)){
            	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
            	if("*".equals(policyNoSign))
            		condition =condition+" and o.policyNo like '%"+policyNo.trim()+"%'";
            	else condition=condition+" and o.policyNo='"+policyNo.trim()+"'";
            }
            if(null != combineNo && !"".equals(combineNo)){
            	String comBineNoSign = httpServletRequest.getParameter("ComBineNoSign");
            	if("*".equals(comBineNoSign))
            		condition =condition+" and o.registNo in (select pl.registNo from prplcombine pl where pl.combineNo like '%"+combineNo.trim()+"%') ";
            	else condition=condition+" and o.registNo in (select pl.registNo from prplcombine pl where pl.combineNo = '"+combineNo.trim()+"') ";
            }
            if(null != registNo && !"".equals(registNo)){
            	String registNoSign = httpServletRequest.getParameter("RegistNoSign");
            	if("*".equals(registNoSign))
            		condition =condition+" and o.registNo like '%"+registNo.trim()+"%'";
            	else condition=condition+" and o.registNo='"+registNo.trim()+"'";
            }
            if(null != riskCode && !"".equals(riskCode)){
            	condition=condition+" and o.riskcode='"+riskCode+"'";
            }
            if(null != statStartDate && !"".equals(statStartDate)){
            	condition=condition+" and g.reportdate>=to_date('"+statStartDate+"','yyyy-mm-dd')";
            }
            if(null != statEndDate && !"".equals(statEndDate)){
            	condition=condition+" and g.reportdate<=to_date('"+statEndDate+"','yyyy-mm-dd')"; 
            }
            if(null != insuredName && !"".equals(insuredName)){
            	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	        	if("*".equals(insuredNameSign))
	        		condition =condition+" and o.insuredName like '%"+insuredName.trim()+"%'";
	        	else condition=condition+" and o.insuredName='"+insuredName.trim()+"'";
            }
		    condition = condition
		    +
		    " and ((nodeType in('check' ,'certa')  " + uiPowerInterface.addPower(userDto, "o", "", "handledept") 
		    + " ) or (nodeType not in('check' ,'certa') " 
		    + uiPowerInterface.addPower(userDto, "o", "", "ComCode") 
		    +"  OR o.handlerCode='" + userDto.getUserCode() +"' ))"
			+" and flowStatus!='0' and (flowStatus='1' or flowStatus='2')"
			+ "and (o.handlerCode='" + userDto.getUserCode() + "' or o.handlerCode is null or o.handlerCode='')";
		    return condition;
		   
	}
}

