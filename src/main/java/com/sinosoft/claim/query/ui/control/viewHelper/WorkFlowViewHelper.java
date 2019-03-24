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
 * Description:调度ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 lixiang
 * @version 1.0 <br>
 */

public class WorkFlowViewHelper {
	/**
	 * 默认构造方法
	 */
	public WorkFlowViewHelper() {// COM.IIDIDispatch
	}

	/* ========================第一部分：工作引擎正向操作======================== */
	/**
	 * 操作工作流的数据整理,此函数就是所有工作流流转的引擎入口， 想知道工作流是如何运转的，从这个函数看起吧。
	 * 
	 * @param user
	 *            UserDto 用户dto
	 * @param swfLogFunctionInDto
	 *            传参数
	 * @throws Exception
	 * @return WorkFlowDto 工作流程数据传输数据结构
	 */
	public WorkFlowDto viewToDto(UserDto user, SwfLogDto swfLogFunctionInDto)
			throws Exception {
		// 取得当前用户信息，写操作员信息到Dto中
		WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		return workFlowEngineViewHelper.viewToDto(user, swfLogFunctionInDto);
	}
	
	public WorkFlowDto viewToDtoMedical(UserDto user, SwfLogDto swfLogFunctionInDto)
    throws Exception {
		 // 取得当前用户信息，写操作员信息到Dto中
		 WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		 return workFlowEngineViewHelper.viewToDtoMedical(user, swfLogFunctionInDto);
	}

	/* ========================第二部分：工作流引擎逆向操作======================== */
	/**
	 * 回退的工作流(利用模板进行回退)
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param flowID
	 *            String 工作流流程编码
	 * @param logNo
	 *            int 工作流流程顺序号
	 * @param keyOut
	 *            String 记录新节点的KeyOut的值，这样退回的数据就可以直接按业务的号码修改
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
	 * 回退的工作流(利用人对人的方式进行回退，即只想上一个节点是什么，复制后提交就行了)
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param flowID
	 *            String 工作流流程编码
	 * @param logNo
	 *            int 工作流流程顺序号
	 * @param keyOut
	 *            String 记录新节点的KeyOut的值，这样退回的数据就可以直接按业务的号码修改
	 * @throws Exception
	 * @return WorkFlowDto
	 */
	public WorkFlowDto getBackFlowInfo(UserDto user, String flowID, int logNo)
			throws Exception {
		WorkFlowEngineViewHelper workFlowEngineViewHelper = new WorkFlowEngineViewHelper();
		return workFlowEngineViewHelper.getBackFlowInfo(user, flowID, logNo);
	}

	/* ========================（工作流引擎逆向操作）结束============================ */

	/* ========================第三部分：工作流图像展现操作======================== */
	/**
	 * 设置工作流流程到界面
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
		// added by zhangli 20070427 拿到核赔后的支付状态
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
					// 拿到被保险人的名字
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

	/* ========================（工作流图像展现操作）结束============================ */

	/* ========================第四部分：工作流查询操作======================== */

	/**
	 * 根据节点种类和操作状态工作流信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 */
	public void getWorkFlowLogList(HttpServletRequest httpServletRequest,
			String nodeType, String status, String alertMessage)
			throws Exception {
		// 查询理赔节点状态信息
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo = httpServletRequest.getParameter("pageNo");
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;
		if (nodeType == null || nodeType.trim().length() < 1) {
			conditions = getNodeTaskListConditions(httpServletRequest, status,
					user.getUserCode());
		} else {
			conditions = getNodeTaskListConditionsByNodeType(
					httpServletRequest, nodeType, status, user.getUserCode());
		}
		if (status.equals("4")) // 想做成翻页的
		{
			PageRecord pageRecord = (PageRecord) uiWorkFlowAction
					.findNodesByConditions(conditions, intPageNo,
							intRecordPerPage);
			swfLogList = (ArrayList) pageRecord.getResult();
			// 查询出来的一页的结构集
			turnPageDto.setResultList(swfLogList);
			// 当前页号
			turnPageDto.setPageNo(pageRecord.getPageNo());
			// 一页的条数
			turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
			// 查询出来的结果的总数
			turnPageDto.setTotalCount(pageRecord.getCount());
			// 返回总的页数
			turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
			// 搜索条件
			turnPageDto.setCondition(conditions);
		} else {
			swfLogList = (List) uiWorkFlowAction
					.findNodesByConditions(conditions);
		}
		UICodeAction uiCodeAction = new UICodeAction();
		// 如果nodeType=定损/核损的话，还需要转换定损/核损的类型名称
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
								// 加入等候时间
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
									swfLogTemp.setTypeFlagName("1-修理换件");
								} else if (swfLogTemp.getTypeFlag().equals("2")) {
									swfLogTemp.setTypeFlagName("2-人员定损");
								} else if (swfLogTemp.getTypeFlag().equals("3")) {
									swfLogTemp.setTypeFlagName("3-财产定损");
								} else if (swfLogTemp.getTypeFlag().equals("4")) {
									swfLogTemp.setTypeFlagName("4-全损/推定全损");
								} else {
									swfLogTemp.setTypeFlagName("");
								}
							}

							// add by lixiang start at 2006-6-5
							// reason:转换保单号码用的
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
		// 防止再次刷新的时候会失去值
		httpServletRequest.setAttribute("status", status);
		httpServletRequest.setAttribute("nodeType", nodeType);
	}

	/**
	 * 根据节点种类和操作状态工作流信息(翻页)
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 */
	public void getWorkFlowLogList(HttpServletRequest httpServletRequest,
			String nodeType, String status, String alertMessage, String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String riskCode=httpServletRequest.getParameter("RiskCode");
		httpServletRequest.setAttribute("riskCode", riskCode);
		String RiskClaimType=httpServletRequest.getParameter("RiskClaimType");
		httpServletRequest.setAttribute("RiskClaimType", RiskClaimType);
		// 得到多行报案主表信息
		Collection swfLogList = new ArrayList();
		Collection swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
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
			 * 国元项目组 下面这个循环会查勘列表中的左右待定损的案件是否申请了垫付.这样处理会影响性能
			 * 因为国元的财产险也是走定损的.在这里先屏蔽掉 for (Iterator iter =
			 * swfLogDtolist.iterator(); iter.hasNext();) { SwfLogDto element =
			 * (SwfLogDto) iter.next(); if ("8".equals(element.getTypeFlag())){
			 * //表示该案件申请了垫付 dfFlag="Y"; swflogtemp.setDfFlag(dfFlag); break; }
			 *  }
			 */
			swfLogList.add(swflogtemp);
		}

		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);

		UICodeAction uiCodeAction = new UICodeAction();
		// 如果nodeType=定损/核损的话，还需要转换定损/核损的类型名称
		if (nodeType != null) {
			if (nodeType.equals("certa") || nodeType.equals("verif")
					|| nodeType.equals("sched")) {
				if (swfLogList != null && swfLogList.size() > 0) {
					for (int i = 0; i < swfLogList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						swfLogTemp = (SwfLogDto) (((ArrayList) swfLogList)
								.get(i));
						if (nodeType.equals("sched")) {
							// 加入等候时间
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
									"钟");
							if (index != -1)
								swfLogTemp.setStopTimeDesc(swfLogTemp
										.getStopTimeDesc().substring(0, index));
						} else {
							if (swfLogTemp.getTypeFlag().equals("1")) {
								swfLogTemp.setTypeFlagName("1-修理换件");
							} else if (swfLogTemp.getTypeFlag().equals("2")) {
								swfLogTemp.setTypeFlagName("2-人员定损");
							} else if (swfLogTemp.getTypeFlag().equals("3")) {
								swfLogTemp.setTypeFlagName("3-财产定损");
							} else if (swfLogTemp.getTypeFlag().equals("4")) {
								swfLogTemp.setTypeFlagName("4-全损/推定全损");
							} else {
								swfLogTemp.setTypeFlagName("");
							}
						}
						swfLogListTemp.add(swfLogTemp);
					}
					swfLogList = swfLogListTemp;
				}
			} else if (nodeType.equals("compe") && status.equals("0")) { // 用于处理计算书:如果还有未审核通过的计算书，就不得再生成计算书。
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
			} else if (nodeType.equals("claim") && status.equals("0")) { // 用于处理注销保单：注销的保单不得立案
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
		// reason:转换保单号码用的
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
		// 防止再次刷新的时候会失去值
		httpServletRequest.setAttribute("status", status);
		httpServletRequest.setAttribute("nodeType", nodeType);

		// modify by wangwei add start 2005-06-12
		// 原因：把险种类型信息放入Request中，用于区别意健险和其他险种。
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by wangwei add end 2005-06-12
	}
	/**
	 * 获得任务显示列表的条件（不区分节点的所有处理的任务）
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
	 * 获得任务显示列表的条件（不区分节点的所有处理的任务）事故号
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
	 * 获得任务显示列表的条件（不区分节点的所有处理的任务）保单号
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
	 * 获得查询未处理理算任务显示列表的条件（不区分节点的所有处理的任务）
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
	 * 获得任务显示列表的条件（不区分节点的所有处理的任务）报案号
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
//	        	throw new Exception("该报案号未进行合并处理，请确认！");
//	        }
	        if(null != combineDto)
	        	comBineNo =combineDto.getCombineno();
		    condition = "ComBineNo='"+comBineNo.trim()+"' and h.riskcode='"+riskCode+"'";

		    return condition;
		   
	}

	/**
	 * 获得任务显示列表的条件（不区分节点的所有处理的任务）
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
		// 注销条件
		if (status.equals("-1")) {
			condition = condition + "  Nodestatus < '4' and handlerCode='"
					+ handlerCode + "'";
			// 新任务条件
		} else if (status.equals("0")) {
			// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
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
		// 将待处理和正在处理的情况中加入不显示已经关闭流程的节点信息
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
		// 加入人员权限处理 add by qinyongli 2005-11-15 begin
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
	 * 获得任务显示列表的条件,一般情况(待处理任务，正在处理任务，已提交任务)
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

		// 如果查询对外核价任务则修改节点类型
		if (conSignType != null && conSignType.equals("verpo")) {
			nodeType = conSignType;
			condition = "   handleDept = '" + user.getComCode() + "' ";
		}

		// 开始拼条件。。。。
		condition = "";
		if (handlerCode.equals("")) {
			condition = " nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "'";
		} else {
			condition = " (nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "' and handlerCode='" + handlerCode + "')";
		}
		// 注销条件
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
					+ "' or handlerCode is null or handlerCode='') and Nodestatus <'4' ";// 这样处理以后
			
			}
			//理算注销新增代码，业务背景：注销回退只适用于未处理的理算任务，与其他注销拒赔不用
			else{
				condition = " nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus ='0' ";// 这样处理以后
			    }
			}																				// 在立案环节只有提交之前可以做立案注销,如果提交,必须到单证环做注销拒赔

		// 新任务条件
		if (status.equals("0")) {

			// 定损退回的任务单独分出来，不放在待处理中
			if (nodeType.equals("certa") || nodeType.equals("wound")
					|| nodeType.equals("propc")) { //
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			} else {
				// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and flowStatus!='0' and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			}

			if (nodeType.equals("sched")) { // 定损调度太特殊了

				condition = " (nodeType='" + nodeType + "' ) and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
				//非农险由总公司集中报案，各中支公司只能受理农险报案(意键险组合保险也可以了哦)
				if(user.getComCode().indexOf("000") != 0){
					condition += " and  (riskcode like '31%' or riskcode like '32%' or riskcode like 'ZH%' or riskcode like '27%' or riskcode like '26%' or riskcode like '28%') ";
				}

			}
		}
		if(status.equals("2")){
			condition = condition +  "  and flowStatus!='0'";//流已关闭赔案的,在正在处理任务菜单时不能显示出来
		}
		 //将待处理和正在处理的情况中加入不显示已经关闭流程的节点信息
		condition = condition + " and (flowStatus='1' or flowStatus='2')";

		if (nodeType.equals("verpo")) {
			condition = condition + " and   handleDept like  '"
					+ user.getComCode().substring(0, 3) + "%' ";
		}

		if (nodeType.equals("claim") && status.equals("0")) {
			// modify by lixiang add 20050310 start
			// reason:立案排序显示
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
		// 新任务条件
		if (status.equals("99")) // 9是查询所有状态的。。
		{
			condition = " nodeType='" + nodeType + "'";
		}
		if (nodeType.equals("veric") && status.equals("0")) {
			condition = " nodeType='" + nodeType + "' and nodestatus <'4'";
		}
		// -------------------------------------------------------------
		// 以下是特殊的

		// [意健险调查]***************************************************************************
		// 原因：加入一个查寻条件，区别意键险和其他险种
		if ("check".equals(nodeType)) {
			if ("acci".equals(riskType)) {
				// 这个IF中的查询条件用于查询意健险的信息,在每个查询语句中加入查询条件+ "and riskcode like '27%'
				// or riskCode like '06%'"。modify by kangzhen
				if (handlerCode.equals("")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and NodeStatus='"
							+ status
							+ "'"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian 区分调查和查勘
							+ " and length(keyin)=25 ";
				} else {
					condition = " (nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian 区分调查和查勘
							+ " and length(keyin)=25 ";
					if(status.equals("2")){
						condition += "and NodeStatus='"	+ status +"'";
					}
				}
				// 注销条件
				if (status.equals("-1")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "' and Nodestatus <'4' "
							+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
				}
				// 新任务条件
				if (status.equals("0")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and (NodeStatus='"
							+ status
							+ "' or NodeStatus='3' ) and (handlerCode='"
							+ handlerCode
							+ "' or handlerCode is null or handlerCode='')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//把-xxx的调查号给查出来，区别查勘的25位keyin modified by xiatian
							+ " and length(keyin)=25 ";
				}
				condition = condition
						+ " and (flowStatus='1' or flowStatus='2' or flowStatus='0')";
				// 新任务条件
				if (status.equals("99")) // 9是查询所有状态的。。
				{
					condition = " nodeType='" + nodeType + "'";
				}
				// 返回意健康险的查勘的查询条件
			} else {
				if(status.equals("-1")){
					condition = condition
					+ " and nodeType='"
					+ nodeType
					+ "' and NodeStatus < '4'"
					//add by xiatian 27 26 31也可查勘
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
					//add by xiatian 27 26 31也可查勘
					+ " and length(keyin)<>25 ";
					//+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
				}
				
			}
		}
		// 重新开始[意健险审核、计算书]

		if ("acci".equals(riskType)
				&& (nodeType.equals("compe") || nodeType.equals("compp"))) {

			// 这个IF中的查询条件用于查询意健险的信息,在每个查询语句中加入查询条件+ "and riskcode like '27%' or
			// riskCode like '06%'"。modify by kangzhen
			if (handlerCode.equals("")) {
				condition = " nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "'"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			} else {
				condition = " (nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "' and handlerCode='" + handlerCode + "')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// 注销条件
			if (status.equals("-1")) {
				condition = " nodeType='" + nodeType + "' and handlerCode='"
						+ handlerCode + "' and Nodestatus <'4' "
						+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// 新任务条件
			if (status.equals("0")) {
				// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			condition = condition + " and (flowStatus='1' or flowStatus='2')";

			// 新任务条件
			if (status.equals("99")) // 9是查询所有状态的。。
			{
				condition = " nodeType='" + nodeType + "'";
			}

			// 返回意健康险的理算的查询条件

		}

		// /////////////////////
		// 从待处理界面获取待处理过滤的条件，从界面上得业务号码的keyIn,keyOut还是businessNO上进行查询
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
		// reason:支持多保单的查询
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// 考虑一下，如果是立案或者结案，或者是计算书处，是如何处理的呢？应该是不用这样关联和转换的吧？
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
		// reason : 正在处理立案任务 查询条件需报案号
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
		// 部门代码
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

		// 报案号
		String registNo = httpServletRequest.getParameter("RegistNo");
		if (registNo != null && registNo.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("RegistNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));

		}

		// 损失标的/车牌
		String lossitemName = httpServletRequest.getParameter("LicenseNo");
		if (lossitemName != null && lossitemName.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("LossItemName", lossitemName,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		String InsuredName = httpServletRequest.getParameter("InsuredName");
		if (InsuredName != null && InsuredName.trim().length() > 0) {

			// 被保人名称
			condition = condition
					+ StringConvert.convertString("InsuredName", InsuredName,
							httpServletRequest.getParameter("InsuredNameSign"));
		}

		String conditionscompe = "";

		String endcaRegistNo = httpServletRequest.getParameter("EndcaRegistNo");
		String compeRegistNo = httpServletRequest.getParameter("CompeRegistNo");
		String comppRegistNo = httpServletRequest.getParameter("ComppRegistNo");
		// 奇怪，为什么要这么做呢。。工作流上面有报案号码呀。。。。。
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
			// 对外核价不需要
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
		//start屏蔽已经并案的案件 
		if("check".equals(nodeType)||"certa".equals(nodeType)||"certi".equals(nodeType)||"claim".equals(nodeType))//||"compe".equals(nodeType)||"compp".equals(nodeType))
		{
			//if(!"compp".equals(nodeType) && !"3".equals(status))
			condition = condition + " and registno not in (select registno from prplcombine)" ;
		}
		//end
		//start 用于电子档案数据库和核心数据库跨库查询条件拼接  add by jqzhang@gyic
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
			StringConvert.convertString("e.Earno", strEarLabel, strEarLabelSign) + StringConvert.convertString("e.name", strFname,strFnameSign)//中央政策性养殖险专用
			+ ")";
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			strDZDACondition = " and policyno in (" +
			" SELECT policyno FROM Plantingpolicylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign) + //种植险专用
			" union " +
			" SELECT policyno FROM planting31policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign)//中央政策性种植险专用
			+ ")";
		}

		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			strDZDACondition = "and policyno in (" +
			" SELECT policyno FROM ZH03policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign) + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign)//农家福组合保险专用
			+ ")";
		}
		condition = condition + strDZDACondition;
		//end
		/*
		//start增加耳标查询条件
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
		//end增加耳标查询条件
		//start增加中央政策性种植险农户身份证查询条件
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
		//end增加中央政策性种植险农户身份证查询条件
		//start增加中央政策性种植险农户姓名查询条件
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
		//end增加中央政策性种植险农户姓名查询条件
		// 加入人员权限处理 add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end
		//新老系统数据区别标志
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

		// 如果查询对外核价任务则修改节点类型
		if (conSignType != null && conSignType.equals("verpo")) {
			nodeType = conSignType;
			condition = "   handleDept = '" + user.getComCode() + "' ";
		}

		// 开始拼条件。。。。
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
		// 注销条件
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
					+ "' or handlerCode is null or handlerCode='') and Nodestatus <'4' ";// 这样处理以后
			
			}
			//理算注销新增代码，业务背景：注销回退只适用于未处理的理算任务，与其他注销拒赔不用
			else{
				condition = " nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus ='0' ";// 这样处理以后
			    }
			}																				// 在立案环节只有提交之前可以做立案注销,如果提交,必须到单证环做注销拒赔

		// 新任务条件
		if (status.equals("0")) {

			// 定损退回的任务单独分出来，不放在待处理中
			if (nodeType.equals("certa") || nodeType.equals("wound")
					|| nodeType.equals("propc")) { //
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "') and flowStatus ='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			} else {
				// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and flowStatus ='0' and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			}

			if (nodeType.equals("sched")) { // 定损调度太特殊了

				condition = " (nodeType='" + nodeType + "' ) and (NodeStatus='"
						+ status + "') and flowStatus ='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
				//非农险由总公司集中报案，各中支公司只能受理农险报案(意键险组合保险也可以了哦)
				if(user.getComCode().indexOf("000") != 0){
					condition += " and  (riskcode like '31%' or riskcode like '32%' or riskcode like 'ZH%' or riskcode like '27%' or riskcode like '26%' or riskcode like '28%') ";
				}

			}
		}
		if(status.equals("2")){
			condition = condition +  "  and flowStatus ='0'";//流已关闭赔案的,在正在处理任务菜单时不能显示出来
		}
		 //将待处理和正在处理的情况中加入不显示已经关闭流程的节点信息
		condition = condition + " and (flowStatus='0')";

		if (nodeType.equals("verpo")) {
			condition = condition + " and   handleDept like  '"
					+ user.getComCode().substring(0, 3) + "%' ";
		}

		if (nodeType.equals("claim") && status.equals("0")) {
			// modify by lixiang add 20050310 start
			// reason:立案排序显示
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
		// 新任务条件
		if (status.equals("99")) // 9是查询所有状态的。。
		{
			condition = " nodeType='" + nodeType + "'";
		}
		if (nodeType.equals("veric") && status.equals("0")) {
			condition = " nodeType='" + nodeType + "' and nodestatus <'4'";
		}
		// -------------------------------------------------------------
		// 以下是特殊的

		// [意健险调查]***************************************************************************
		// 原因：加入一个查寻条件，区别意键险和其他险种
		if ("check".equals(nodeType)) {
			if ("acci".equals(riskType)) {
				// 这个IF中的查询条件用于查询意健险的信息,在每个查询语句中加入查询条件+ "and riskcode like '27%'
				// or riskCode like '06%'"。modify by kangzhen
				if (handlerCode.equals("")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and NodeStatus='"
							+ status
							+ "'"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian 区分调查和查勘
							+ " and length(keyin)=25 ";
				} else {
					condition = " (nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//add by xiatian 区分调查和查勘
							+ " and length(keyin)=25 ";
					if(status.equals("2")){
						condition += "and NodeStatus='"	+ status +"'";
					}
				}
				// 注销条件
				if (status.equals("-1")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and handlerCode='"
							+ handlerCode
							+ "' and Nodestatus <'4' "
							+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
				}
				// 新任务条件
				if (status.equals("0")) {
					condition = " nodeType='"
							+ nodeType
							+ "' and (NodeStatus='"
							+ status
							+ "' or NodeStatus='3' ) and (handlerCode='"
							+ handlerCode
							+ "' or handlerCode is null or handlerCode='')"
							+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')"
							//把-xxx的调查号给查出来，区别查勘的25位keyin modified by xiatian
							+ " and length(keyin)=25 ";
				}
				condition = condition
						+ " and (flowStatus='1' or flowStatus='2' or flowStatus='0')";
				// 新任务条件
				if (status.equals("99")) // 9是查询所有状态的。。
				{
					condition = " nodeType='" + nodeType + "'";
				}
				// 返回意健康险的查勘的查询条件
			} else {
				if(status.equals("-1")){
					condition = condition
					+ " and nodeType='"
					+ nodeType
					+ "' and NodeStatus < '4'"
					//add by xiatian 27 26 31也可查勘
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
					//add by xiatian 27 26 31也可查勘
					+ " and length(keyin)<>25 ";
					//+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
				}
				
			}
		}
		// 重新开始[意健险审核、计算书]

		if ("acci".equals(riskType)
				&& (nodeType.equals("compe") || nodeType.equals("compp"))) {

			// 这个IF中的查询条件用于查询意健险的信息,在每个查询语句中加入查询条件+ "and riskcode like '27%' or
			// riskCode like '06%'"。modify by kangzhen
			if (handlerCode.equals("")) {
				condition = " nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "'"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			} else {
				condition = " (nodeType='" + nodeType + "' and NodeStatus='"
						+ status + "' and handlerCode='" + handlerCode + "')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// 注销条件
			if (status.equals("-1")) {
				condition = " nodeType='" + nodeType + "' and handlerCode='"
						+ handlerCode + "' and Nodestatus <'4' "
						+ "and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			// 新任务条件
			if (status.equals("0")) {
				// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
				condition = " nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')"
						+ " and (riskcode like '27%' or riskCode like '26%' or riskCode like '31%' or riskCode like '28%')";
			}
			condition = condition + " and (flowStatus='0')";

			// 新任务条件
			if (status.equals("99")) // 9是查询所有状态的。。
			{
				condition = " nodeType='" + nodeType + "'";
			}

			// 返回意健康险的理算的查询条件

		}

		// /////////////////////
		// 从待处理界面获取待处理过滤的条件，从界面上得业务号码的keyIn,keyOut还是businessNO上进行查询
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
		// reason:支持多保单的查询
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// 考虑一下，如果是立案或者结案，或者是计算书处，是如何处理的呢？应该是不用这样关联和转换的吧？
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
		// reason : 正在处理立案任务 查询条件需报案号
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
		// 部门代码
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

		// 报案号
		String registNo = httpServletRequest.getParameter("RegistNo");
		if (registNo != null && registNo.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("RegistNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));

		}

		// 损失标的/车牌
		String lossitemName = httpServletRequest.getParameter("LicenseNo");
		if (lossitemName != null && lossitemName.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("LossItemName", lossitemName,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		String InsuredName = httpServletRequest.getParameter("InsuredName");
		if (InsuredName != null && InsuredName.trim().length() > 0) {

			// 被保人名称
			condition = condition
					+ StringConvert.convertString("InsuredName", InsuredName,
							httpServletRequest.getParameter("InsuredNameSign"));
		}

		String conditionscompe = "";

		String endcaRegistNo = httpServletRequest.getParameter("EndcaRegistNo");
		String compeRegistNo = httpServletRequest.getParameter("CompeRegistNo");
		String comppRegistNo = httpServletRequest.getParameter("ComppRegistNo");
		// 奇怪，为什么要这么做呢。。工作流上面有报案号码呀。。。。。
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
			// 对外核价不需要
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
		//start屏蔽已经并案的案件 
		if("check".equals(nodeType)||"certa".equals(nodeType)||"certi".equals(nodeType)||"claim".equals(nodeType))//||"compe".equals(nodeType)||"compp".equals(nodeType))
		{
			//if(!"compp".equals(nodeType) && !"3".equals(status))
			condition = condition + " and registno not in (select registno from prplcombine)" ;
		}
		//end
		//start 用于电子档案数据库和核心数据库跨库查询条件拼接  add by jqzhang@gyic
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
			StringConvert.convertString("e.Earno", strEarLabel, strEarLabelSign) + StringConvert.convertString("e.name", strFname,strFnameSign)//中央政策性养殖险专用
			+ ")";
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			strDZDACondition = " and policyno in (" +
			" SELECT policyno FROM Plantingpolicylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign) + //种植险专用
			" union " +
			" SELECT policyno FROM planting31policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign)//中央政策性种植险专用
			+ ")";
		}

		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			strDZDACondition = "and policyno in (" +
			" SELECT policyno FROM ZH03policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign) + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign)//农家福组合保险专用
			+ ")";
		}
		condition = condition + strDZDACondition;
		//end
		/*
		//start增加耳标查询条件
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
		//end增加耳标查询条件
		//start增加中央政策性种植险农户身份证查询条件
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
		//end增加中央政策性种植险农户身份证查询条件
		//start增加中央政策性种植险农户姓名查询条件
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
		//end增加中央政策性种植险农户姓名查询条件
		// 加入人员权限处理 add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end
		//新老系统数据区别标志
		condition += " and dataFlag is null ";
		condition = condition + orderString;
        
		return condition;
	}

	/**
	 * 根据节点种类和操作状态工作流信息(目前只做了特殊赔案的查询)
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 */
	public void getSwfLogList(HttpServletRequest httpServletRequest,
			String caseFlag, String userCode, String nodeType) throws Exception {
		if (caseFlag != null && caseFlag.trim().length() > 0) {
			caseFlag = caseFlag.substring(0, caseFlag.length() - 1);
		}
		// 查询理赔节点状态信息
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		// 得到多行主表信息
		Collection swfLogList = new ArrayList();
		Collection swfLogListTemp = new ArrayList();
		String conditions = " handlerCode = '" + userCode
				+ "' AND NodeType = '" + nodeType + "'";
		conditions = conditions
				+ StringConvert.convertString("businessno", httpServletRequest
						.getParameter("RegistNo"), httpServletRequest
						.getParameter("RegistNoSign"));

		// modify by lixiang start at 2006-6-5
		// reason:支持多保单的查询
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// 考虑一下，如果是立案或者结案，或者是计算书处，是如何处理的呢？应该是不用这样关联和转换的吧？
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
			//拼案件状态条件			
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
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		// 目前只有为4的状态，以提交需要进行翻页
		swfLogList = (Collection) uiWorkFlowAction
				.findNodesByConditions(conditions);
		Collection swfLogList1= (Collection)uiWorkFlowAction.findStoreNodesByConditions(conditions.replace("swflog", "swflogStore"));
		if(swfLogList1 !=null){
			swfLogList.addAll(swfLogList1);
		}
		// 如果nodeType=定损/核损的话，还需要转换定损/核损的类型名称
		if (nodeType.equals("speci")) {
			Iterator it = swfLogList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogTemp = new SwfLogDto();
				swfLogTemp = (SwfLogDto) it.next();
				if (swfLogTemp.getTypeFlag().equals("3")) {
					swfLogTemp.setTypeFlagName("通融");
				} else if (swfLogTemp.getTypeFlag().equals("4")) {
					swfLogTemp.setTypeFlagName("预付");
				} else if (swfLogTemp.getTypeFlag().equals("5")) {
					swfLogTemp.setTypeFlagName("预赔");
				} else {
					swfLogTemp.setTypeFlagName("");
				}
				swfLogListTemp.add(swfLogTemp);
			}

			swfLogList = swfLogListTemp;
		}
		SwfLogDto swfLogDto = new SwfLogDto();
		// add by lixiang start at 2006-6-5
		// reason:转换保单号码用的
		swfLogList = translateRelatePolicyOnTaskQuery(swfLogList, nodeType);
		// add by lixiang end at 2006-6-5
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setNodeType(nodeType);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		// 防止再次刷新的时候会失去值
		httpServletRequest.setAttribute("nodeType", nodeType);

	}

	/* ========================（工作流查询操作）结束============================ */

	/* ========================第五部分：工作流统计操作======================== */
	/**
	 * 工作流统计--节点状态：统计工作流节点状态数量的功能
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
	 * 工作流统计--用户节点状态：统计工作流节点用户状态数量的功能
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
	 * 工作流查询--超时工作流查看：按条件查询超时案件的信息
	 * 
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param conditions
	 *            String 查询条件
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
	 * 根据节点种类和操作状态和办理人员编码查询查勘信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param user
	 *            办理人员/用户对象
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 */

	public void getWorkFLowNodeStatsStat(HttpServletRequest httpServletRequest,
			UserDto user, String nodeType) throws Exception {
		WorkFlowStatViewHelper workFlowStatViewHelper = new WorkFlowStatViewHelper();
		workFlowStatViewHelper.getWorkFLowNodeStatsStat(httpServletRequest,
				user, nodeType);

	}

	/* ========================（工作流统计操作）结束============================ */
	/* ========================（工作流检查校验操作）开始======================== */
	/**
	 * 检查该节点是否可以被提交，如果不能提交丢出理由原因
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto 需要被检查的节点对象
	 * @throws Exception
	 */
	public void checkNodeSubmit(SwfLogDto swfLogDtoCurrent) throws Exception {
		// 目前只检查单证的提交，如果它之前的立案没有做，定损，核损，人伤和人伤核损只要有一个没做完就不许提交
		// 单证节点判断思路
		// ----------------------------------------------------------
		// 1.首先判断该流程中是否存在如下的节点（立案，定损，核损，人伤和人伤核损）
		// 2.这些节点是不是处在活动状态，如果是的话，不允许提交
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
						+ "节点没有处理完毕，不可以进行单证提交";
				throw new UserException(1, 3, "工作流", msg);
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
						+ "节点没有处理完毕，不可以进行理算的操作";
				throw new UserException(1, 3, "工作流", msg);
			}
		}
		// 结束单证的判断
	}

	/**
	 * 检查该节点是否可以被提交，如果不能提交丢出理由原因
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto 需要被检查的节点对象
	 * @throws Exception
	 */
	public String checkNodeSubmit(String swfLogFlowID, String swfLogLogNo)
			throws Exception {
		// 目前只检查单证的提交，如果它之前的立案没有做，定损，核损，人伤和人伤核损只要有一个没做完就不许提交
		// 单证节点判断思路
		// ----------------------------------------------------------
		// 1.首先判断该流程中是否存在如下的节点（立案，定损，核损，人伤和人伤核损）
		// 2.这些节点是不是处在活动状态，如果是的话，不允许提交
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
		if (nodeType.equals("verip")) // 核价检查是否已经向外询价
		{
			nodeName = "核价";
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and nodeType='verpo' ";
		}

		if (nodeType.equals("certi")) // 单正检查是不是可以提交
		{
			nodeName = "单证";
			conditions = " flowid='"
					+ swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in ('claim','certa','verif','verip','verpo',"
					+ "'wound','veriw','propc','propv')) and  nodeStatus <'4'";

		}

		if (nodeType.equals("sched")) // 定损检查是不是可以提交
		{
			nodeName = "调度";
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and (nodeType in('check')) and  nodeStatus <'4'";
		}
		
		if ( nodeType.equals("compe") || nodeType.equals("compp")) // 理算检查是不是可以提交
		{
			nodeName = "理算";
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
				// 农险（养殖的）itemcode暂定为-2，所以偶改下这里先~~~！
				if ("0".equals(swfLogDto.getLossItemCode())
						|| "-1".equals(swfLogDto.getLossItemCode())
						|| "-2".equals(swfLogDto.getLossItemCode())) {
					nodeMsg = nodeMsg + "'" + swfLogDto.getNodeName() + "',";
				} else {
					// modify by miaowenjun 20060929 这里也改，农险哪找车牌号去？
					if (!"I".equals(new UICodeAction()
							.translateRiskCodetoRiskType(swfLogDto
									.getRiskCode()))
							&& !"H".equals(new UICodeAction()
									.translateRiskCodetoRiskType(swfLogDto
											.getRiskCode()))) {
						nodeMsg = nodeMsg
								+ "'车牌号码为："
								+ DataUtils.nullToEmpty(swfLogDto
										.getLossItemName()) + "的"
								+ swfLogDto.getNodeName() + "',";
					} else {
						nodeMsg = nodeMsg + "的'" + swfLogDto.getNodeName()
								+ "',";
					}
				}
			}
			checkCount++;
		}
		if (checkCount > 0) {
			msg = nodeMsg.substring(0, nodeMsg.length() - 1) + "节点没有处理完毕，不能结束"
					+ nodeName;
		}

		// 结束单证的判断
		return msg;
	}

	/**
	 * 检查该节点在工作流中是否存在，如果存在，返回节点名称
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto 需要被检查的节点对象
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

		// 结束判断
		// 如果msg的长度大
		return msg;
	}

	/**
	 * 校验工作流DTO是不是合法可以处理的dto
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
	 * 查询本节点，如果提交的话，可以有多种
	 * 
	 * @param modelNo
	 *            String 模板号码
	 * @param nodeNo
	 *            String 节点号码
	 * @throws Exception
	 * @return Collection
	 */
	public Collection getNextSumbitNodes(String modelNo, String nodeNo)
			throws Exception { // 程序思路：
		// ---------------------------------------------------
		// 1。根据模板号码，节点号码查询出（从swfPath）数据
		// 2。排序注意,defaultFlag asc,priority asc
		// ---------------------------------------------------

		Collection nodesList = new ArrayList();
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		String conditions = "modelNo=" + modelNo + " and startNodeNo=" + nodeNo
				+ " order by defaultFlag,priority";
		nodesList = uiWorkFlowAction.findModelPathNodes(conditions);
		return nodesList;
	}

	/**
	 * 查询本节点，根据险种和操作用户获得使用的模板号码
	 * 
	 * @param modelNo
	 *            String 模板号码
	 * @param nodeNo
	 *            String 节点号码
	 * @throws Exception
	 * @return Collection
	 */
	public int getModelNoByRiskComCode(String RiskCode, String comCode)
			throws Exception {
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		int modelNo = uiWorkFlowAction.getModelNo(RiskCode, comCode);
		return modelNo;
	}

	/* ========================（工作流检查校验操作）结束======================== */
	/**
	 * 有原因的更换工作流上的处理原因
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

		// 默认handleDept为空，则不判断。
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

		// 更新时间

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
	/* ========================（工作流查询操作）开始============================ */
	/**
	 * 根据条件显示新增定损调度任务清单
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param conditions
	 *            查询条件
	 * @throws Exception
	 */
	public void getScheduleAddCertainLossSwfLogList(
			HttpServletRequest httpServletRequest, String conditions)
			throws Exception {

		// 查询理赔节点状态信息
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		// 得到多行主表信息
		ArrayList swfLogList = new ArrayList();
		// 目前只有为4的状态，以提交需要进行翻页
		// 每页显示的行数
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo = httpServletRequest.getParameter("pageNo");
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";

		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容

		PageRecord pageRecord = (PageRecord) uiWorkFlowAction
				.findNodesByConditions(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(swfLogList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);

		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);
		swfLogDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
	}

	/**
	 * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @param licenseNo
	 *            车牌号码
	 * @param riskCode
	 *            险别
	 * @param insuredName
	 *            被保险人名称
	 * @throws Exception
	 */
	public void getWorkFlowList(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo,
			String riskCode, String insuredName, int intPageNo,
			int intRecordPerPage) throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		insuredName = StringUtils.rightTrim(insuredName);
		riskCode = StringUtils.rightTrim(riskCode);
		riskCode = StringUtils.rightTrim(riskCode);
		insuredName = StringUtils.rightTrim(insuredName);
		String caseType = httpServletRequest.getParameter("caseType");
		String strTableName = "Swflog";//流程查询使用的表，未转储查询表swflog，已转储查询表swflogstore
		String conditions = " 1=1  ";
		String swflogCondition = "";
		String swflogStoreCondition = "";
		// add by qinyong 2005-9-3 end
		
		if (policyNo.length() > 0) {

			// add by lixiang start at 2006-06-05
			// reason:改变查询保单的方式，为转换为registNo的号码的查询

			conditions = conditions
					+ " and registno in (select registno from "
					+ "prplregistrpolicy where 1=1 "
					+ StringConvert.convertString(" policyNo", policyNo,
							httpServletRequest.getParameter("PolicyNoSign"))
					+ ") ";
		}
		// reason : 根据结案状态拼sql，进行是否结案判断
		/**
		 * sql语句说明： 根据一个工作流中的结案节点状态来判断是否已经结案，条件是：有结案节点 and nodestatus=4 and
		 * endflag = 1 1,select flowid from swflog where nodetype = 'regis')
		 * 查处所有工作流,记做：I 2,select flowid from swflog where nodetype ='endca' and
		 * endflag='1' and nodestatus = '4' and flowid in
		 * (I);在所有工作流中找出已经结案的工作流,记做：II 3,select * from swflog where registno =
		 * 'regis' and flowid in (II) 查处所有结案节点； 4,select * from swflog where
		 * registno = 'regis' and flowid not in (II) 查处所有未结案节点；
		 */
		if (caseType != null && !caseType.equals("") && caseType.equals("1")) {
				strTableName = "SwflogStore";
		}

		// reason : 增加查询条件内容，关于险别和险类的查询
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

		// 拼权限
		
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
			//优化sql条件start
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
			//优化sql条件end
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
		//报案流入时间
		String registFlowinTime = StringUtils.rightTrim(httpServletRequest
				.getParameter("prpLregistFlowinTime"));
		String flowinTimeNoSign = httpServletRequest
				.getParameter("FlowinTimeNoSign");
		if (registFlowinTime != null && registFlowinTime.length() > 0) {
			conditions = conditions
					+ " And to_Date (Flowintime,'yyyy-MM-dd HH24:mi:ss')" + flowinTimeNoSign + "to_date('" + registFlowinTime + " 00:00:00','yyyy-MM-dd HH24:mi:ss')";
		}
		//添加区分新农险标识
		conditions = conditions + " and (systemflag is null or systemflag<>'agri') ";
		if (caseType != null && caseType.equals("")) {
			swflogCondition = conditions;
			swflogStoreCondition = conditions.replaceAll("Swflog", "SwflogStore");
		}
		//conditions += " and dataFlag is null "; 
		
		// 从session里取扶贫/大户标志
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
		// 查询流程信息
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

//		int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
//				.get("sysconst.MaxQueryCount")));
//		int count = 0;
//		// 判断条件限制
//		//count = uiWorkFlowAction.findFlowNodeCountByConditon(conditions);
//		if (maxQueryCount != 0 && count > maxQueryCount) {
//			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
//		}
		// 得到多行报案主表信息
		PageRecord pageRecord = null;
		if (caseType != null ) {
			//已结案转储
			if(caseType.equals("1")){
				pageRecord = (PageRecord) uiWorkFlowAction.findStoreNodesByConditions(
						conditions, intPageNo, intRecordPerPage);
			//未结案转储
			}else if(caseType.equals("0")){
				pageRecord = (PageRecord) uiWorkFlowAction.findNodesByConditions(
						conditions, intPageNo, intRecordPerPage);
			//所有案件
			}else{
				BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
				pageRecord = (PageRecord) blSwfLogFacade.findAllStatusByConditions(
						swflogCondition,swflogStoreCondition, intPageNo, intRecordPerPage);
			}
	    }
		
		ArrayList swfLogList = new ArrayList();
		swfLogList = (ArrayList) pageRecord.getResult();
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 查询出来的一页的结构集
		turnPageDto.setResultList(swfLogList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setSwfLogList(swfLogList);

		swfLogDto.setTurnPageDto(turnPageDto);

		// add by miaowenjun 20060418
		// 以下代码什么意思，lixiang 看不大明白。。。是用来显示立案注销的
		// modify by lixiang start at 20060605
		ArrayList prpLclaimList = new ArrayList();
		ArrayList swfLogListtemp = new ArrayList();
		UICodeAction uiCodeAction = new UICodeAction();
		if (swfLogDto.getSwfLogList() != null) {
			// 若查询结果不为空，检查进行转换，首先确认是否是立案注销，或者是报案注销。
			UIClaimAction uiClaimAction = new UIClaimAction();
			BLSwfLogFacade blSwflogFacade = new BLSwfLogFacade();			
			for (int index = 0; index < swfLogDto.getSwfLogList().size(); index++) {
				SwfLogDto swfLogDtotemp = new SwfLogDto();
				swfLogDtotemp = (SwfLogDto) ((ArrayList) swfLogDto
						.getSwfLogList()).get(index);

				// add by lixiang start at 2006-9-9
				// reson:显示险种名称
				String strTemp = uiCodeAction.translateRiskCode(swfLogDtotemp
						.getRiskCode(), true);
				if (strTemp != null && strTemp.length() > 4)
					strTemp = strTemp.substring(0, 4);
				swfLogDtotemp.setRiskCodeName(strTemp);
				// add by lixiang end at 2006-9-9
				// 首先判断是否是报案注销，如果是报案注销的话，肯定没立案
				String nodetypetemp = "";
				BLPrpLaccipersonFacade blPrpLaccipersonFacade = new BLPrpLaccipersonFacade();
				if ("6".equals(swfLogDtotemp.getNodeStatus())) {
					swfLogDtotemp.setOtherFlag("报案注销");
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
				// 判断是否为立案注销,目前先屏蔽掉，因为增加强三后，显示一个是不够的，需要完善。
				
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
							swfLogDtotemp.setOtherFlag(swfLogDtotemp.getOtherFlag() + "立案注销"); 
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
							
							swfLogDtotemp.setOtherFlag(swfLogDtotemp.getOtherFlag() + "已结案"); 
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
					//已立案未结案的案件状态显示最后节点
					if(swfLogDtotemp.getOtherFlag() == null || "".equals(swfLogDtotemp.getOtherFlag())){
						 swfLogDtotemp.setOtherFlag("已立案(" + blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID()) + ")");
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
							 if("报案".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "regis";
								 
							 }else if("调度".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "regis";
							 }else if("查勘".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "regis";
							 }else if("财产定损".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "check";
							 }else if("核价".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "propc";
							 }else if("财产核损".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "verip";
							 }else if("立案".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "propv";
							 }else if("单证".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "claim";
							 }else if("理算".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "claim";
							 }else if("计算书".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
							 {
								 nodetypetemp = "compe";
							 }else if("核赔".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
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
			     //已报案未立案的案件状态显示最后节点
				 if(swfLogDtotemp.getOtherFlag() == null || "".equals(swfLogDtotemp.getOtherFlag())){
					 swfLogDtotemp.setOtherFlag("未立案(" + blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID()) + ")");
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
						 if("报案".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "regis";
							 
						 }else if("调度".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "regis";
						 }else if("查勘".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "regis";
						 }else if("财产定损".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "check";
						 }else if("核价".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "propc";
						 }else if("财产核损".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "verip";
						 }else if("立案".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "propv";
						 }else if("单证".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "claim";
						 }else if("理算".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "claim";
						 }else if("计算书".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
						 {
							 nodetypetemp = "compe";
						 }else if("核赔".equals(blSwflogFacade.getMaxNodeName(swfLogDtotemp.getFlowID())))
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
				 
				 
				 
				 
					 
				 

				 
				// 由于强三的修改，需要多个保单号的显示：
				UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
				String strSql = " registno='" + swfLogDtotemp.getRegistNo()
						+ "'";// and validstatus='1'";
				// 取得多个关联的保单信息
				Collection relatePolicyList = uiPrpLregistRPolicyAction
						.findByConditions(strSql);

				swfLogDtotemp.setRelatePolicyList(relatePolicyList);
				swfLogListtemp.add(swfLogDtotemp);
			}
			// 将整理过的列表放到结果集合中。
			swfLogDto.setSwfLogList(swfLogListtemp);
		}
		// modify by lixiang end at 20060605
		// add end by miaowenjun 20060418

		httpServletRequest.setAttribute("swfLogDto", swfLogDto);
		swfLogDto.setEditType(httpServletRequest.getParameter("editType"));
	}

	/* ========================（工作流查询操作）结束============================ */
	// modify by wangli add end 20050412
	/**
	 * 检查该节点是否可以被提交，如果不能提交丢出理由原因
	 * 
	 * @param swfLogDtoCurrent
	 *            SwfLogDto 需要被检查的节点对象
	 * @throws Exception
	 */
	public int checkCompensateCount(String flowID, String nodeType)
			throws Exception {
		// 目前只检查单证的提交，如果它之前的立案没有做，定损，核损，人伤和人伤核损只要有一个没做完就不许提交
		// 单证节点判断思路
		// ----------------------------------------------------------
		// 1.首先判断该流程中是否存在如下的节点（立案，定损，核损，人伤和人伤核损）
		// 2.这些节点是不是处在活动状态，如果是的话，不允许提交
		// ----------------------------------------------------------
		String conditions = "";
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

		conditions = " flowid='" + flowID + "'" + " and  nodeType='" + nodeType
				+ "'";
		// 结束单证的判断
		return uiWorkFlowAction.getCount(conditions);
	}

	/**
	 * 查找符合条件的流程节点信息
	 * 
	 * @param condition
	 *            条件
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
	 * 检查需要进行关联多个保单的
	 * 
	 * @param nodeType
	 *            节点类型
	 * @throws Exception
	 * @return boolean
	 */
	private boolean checkNeedFindRelatePolicy(String nodeType) throws Exception {
		boolean blresut = true;
		// 立案，计算书，结案是不需要进行关联多个保单的
		if ("claim".equals(nodeType) || "compp".equals(nodeType)
				|| "endca".equals(nodeType)) {
			blresut = false;

		}
		return blresut;
	}

	/**
	 * 检查需要进行关联多个保单的
	 * 
	 * @param nodeType
	 *            节点类型
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
				// 取得多个关联的保单信息
				strSql = " registno='" + swfLogTemp.getRegistNo() + "'";
				relatePolicyList = uiPrpLregistRPolicyAction
						.findByConditions(strSql);

			} else {
				// 如果不需要的话，直接将流程中的保单号码放到显示用的relatePolicyList变量中
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
	 * 检查需要进行关联多个保单的,用单的工作流的
	 * 
	 * @param nodeType
	 *            节点类型
	 * @throws Exception
	 * @return boolean
	 */
	private SwfLogDto translateRelatePolicyOnTaskQueryOne(SwfLogDto swfLogTemp)
			throws Exception {
		UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		String strSql = "";
		Collection relatePolicyList = new ArrayList();
		if (checkNeedFindRelatePolicy(swfLogTemp.getNodeType())) {
			// 取得多个关联的保单信息
			strSql = " registno='" + swfLogTemp.getRegistNo() + "'";
			relatePolicyList = uiPrpLregistRPolicyAction
					.findByConditions(strSql);

		} else {
			// 如果不需要的话，直接将流程中的保单号码放到显示用的relatePolicyList变量中
			PrpLRegistRPolicyDto prpLregistRPolicyDto = new PrpLRegistRPolicyDto();
			prpLregistRPolicyDto.setPolicyNo(swfLogTemp.getPolicyNo());
			prpLregistRPolicyDto.setRegistNo(swfLogTemp.getRegistNo());
			relatePolicyList.add(prpLregistRPolicyDto);
		}

		swfLogTemp.setRelatePolicyList(relatePolicyList);

		return swfLogTemp;
	}
	/**
	 * 根据节点种类和操作状态工作流信息(翻页)
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogList(HttpServletRequest httpServletRequest, String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;
	    conditions = getComBineListConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findByPolicyNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
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
	 * 根据事故号查询信息(翻页)
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogListByComBineNo(HttpServletRequest httpServletRequest,String condition,String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;
	    conditions = getComBineListByComBineNoConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findByComBineNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
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
	 * 根据报案号查询信息(翻页)
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogListByRegistNo(HttpServletRequest httpServletRequest,String RegistNo,String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
        String conditions = null;
     try{
	    conditions = getComBineListByRegistNoConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findByComBineNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
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
	 * 根据保单号查询信息(翻页)
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineWorkFlowLogListByPolicyNo(HttpServletRequest httpServletRequest,String PolicyNo,String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;
	    conditions = getComBineListByPolicyNoConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findBypolicyNo(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
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
	 * 根据条件查询未处理理算信息（并案处理）
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 * @author qianxiantao
	 */
	public void getComBineCompensateListByConditions(HttpServletRequest httpServletRequest,String condition,String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;
	    conditions = getCompensateListConditions(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findCompensateListByConditions(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
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
	 * 根据条件查询未处理理算信息（并案处理）
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param status
	 *            操作状态
	 * @param nodeType
	 *            节点种类
	 * @throws Exception
	 * @author Li, Yang
	 */
	public void getComBineWorkFlowLogListInCombineEditList(HttpServletRequest httpServletRequest, String pageNo,
			String recordPerPage) throws Exception {
		// 查询理赔节点状态信息
		BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		// 得到多行报案主表信息
		List swfLogList = null;
		List swfLogListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;
	    conditions = getComBineListCondition(httpServletRequest);
		PageRecord pageRecord = (PageRecord)bLSwfLogFacade.findComBineListByCondition(conditions, intPageNo, intRecordPerPage);
		swfLogList = (ArrayList) pageRecord.getResult();
		// 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
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
	 * 获得任务显示列表的条件（只显示查勘，定损，立案，单证，理算中非提交状态的节点）
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

