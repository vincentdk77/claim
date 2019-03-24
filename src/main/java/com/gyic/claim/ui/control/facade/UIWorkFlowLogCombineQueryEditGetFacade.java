package com.gyic.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.BLPrplcombineSwfLogFacade;
import com.gyic.claim.dto.custom.ClaimCombineDto;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 工作流状态查询
 * <p>Title: 车险理赔工作流查询信息</p>
 * <p>Description: 车险理赔工作流信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowLogCombineQueryEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
	//业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String nodeType     = httpServletRequest.getParameter("nodeType");
    String caseFlag     = httpServletRequest.getParameter("caseFlag");
    String status      = httpServletRequest.getParameter("status");     //立案号
    HttpSession session = httpServletRequest.getSession();
    String editType= httpServletRequest.getParameter("editType");
    String funcName=httpServletRequest.getParameter("FuncName"); //只有在注销/特殊申请的时候才起作用的
    String isFirst		= httpServletRequest.getParameter("isFirst"); //是否第一次进来，第一次进来不查询结果
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();
    String forward  = "";  
    String comLevel ="" ; 
    try
    { 
    	//第一次进来，标志为空的，所以对其进行初始化；第二次进来，取的是页面的值，所以不为空，不用处理
    	if(isFirst == null || "".equals(isFirst)){
    		isFirst = "Y";
    	}
    	httpServletRequest.setAttribute("isFirst", isFirst);
    	//看看是否是总公司-----------------------------
    	if (nodeType.equals("verip")){
    		comLevel = user.getComLevel();
        	httpServletRequest.setAttribute("comLevel",comLevel);
    	}
    	//----------------------------
    	//查询工作流状态信息,整理输入，用于初始界面显示
		//需要进行翻页处理
		//每页显示的行数
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
		if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
        if(editType!=null&&editType.trim().equals("specialQuery")){
        	//特殊赔案查询
          getSwfLogList(httpServletRequest,caseFlag,userCode,nodeType);
          return actionMapping.findForward("specialQuery");
        } else if(editType!=null&&editType.trim().equals("welcome")){//首页的列表点击的时候
          getWorkFlowLogList(httpServletRequest,nodeType,status,"",pageNo,"10000");
          return actionMapping.findForward("success");
        }  else {
          getWorkFlowLogList(httpServletRequest,nodeType,status,"",pageNo,recordPerPage);
        }
        forward = "success";

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
    //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage","usee.getErrorMessage()") ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
    return actionMapping.findForward(forward);
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
		BLPrplcombineSwfLogFacade blPrplcombineSwfLogFacade = new BLPrplcombineSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// 得到多行报案主表信息
		Collection claimCombineDtoList = new ArrayList();
		Collection claimCombineDtoListTemp = new ArrayList();
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
		PageRecord pageRecord = (PageRecord) blPrplcombineSwfLogFacade.findByConditions(conditions, intPageNo, intRecordPerPage);
		Collection claimCombineDtoListtemp1 = null;
		claimCombineDtoListtemp1 = (ArrayList) pageRecord.getResult();

		String dfFlag = "N";

		for (Iterator it = claimCombineDtoListtemp1.iterator(); it.hasNext();) {
			ClaimCombineDto ClaimCombineDtotemp = (ClaimCombineDto)it.next();
			
//			由于这部分不再起作用，故注释掉   GYIC 李杨 start 20110803
//			
//			PageRecord pageRecord2 = (PageRecord) blPrplcombineSwfLogFacade
//					.findByConditions("  flowid='"
//							+ swflogtemp.getFlowID() + "'", intPageNo,
//							intRecordPerPage);
//			swfLogDtolist = (ArrayList) pageRecord2.getResult();
//			由于这部分不再起作用，故注释掉   GYIC 李杨 end 20110803
			/*
			 * 国元项目组 下面这个循环会查勘列表中的左右待定损的案件是否申请了垫付.这样处理会影响性能
			 * 因为国元的财产险也是走定损的.在这里先屏蔽掉 for (Iterator iter =
			 * swfLogDtolist.iterator(); iter.hasNext();) { SwfLogDto element =
			 * (SwfLogDto) iter.next(); if ("8".equals(element.getTypeFlag())){
			 * //表示该案件申请了垫付 dfFlag="Y"; swflogtemp.setDfFlag(dfFlag); break; }
			 *  }
			 */
			claimCombineDtoList.add(ClaimCombineDtotemp);
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
				if (claimCombineDtoList != null && claimCombineDtoList.size() > 0) {
					for (int i = 0; i < claimCombineDtoList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						ClaimCombineDto claimCombineTemp = (ClaimCombineDto) (((ArrayList) claimCombineDtoList)
								.get(i));
						swfLogTemp = claimCombineTemp.getSwfLogDto();
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
						claimCombineTemp.setSwfLogDto(swfLogTemp);
						claimCombineDtoListTemp.add(claimCombineTemp);
					}
					claimCombineDtoList = claimCombineDtoListTemp;
				}
			} else if (nodeType.equals("compe") && status.equals("0")) { // 用于处理计算书:如果还有未审核通过的计算书，就不得再生成计算书。
				if (claimCombineDtoList != null && claimCombineDtoList.size() > 0) {
					for (int i = 0; i < claimCombineDtoList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						ClaimCombineDto claimCombineDto = (ClaimCombineDto) (((ArrayList) claimCombineDtoList).get(i));
						swfLogTemp = claimCombineDto.getSwfLogDto();
						UICompensateAction uiCompensateAciton = new UICompensateAction();
						String statement = "claimno='"
								+ swfLogTemp.getKeyIn()
								+ "' and (UnderWriteFlag <> '1' and UnderWriteFlag <>'3')";
						Collection uiCompenList = uiCompensateAciton
								.findByConditions(statement);
						swfLogTemp.setCompCount(uiCompenList.size());
						claimCombineDto.setSwfLogDto(swfLogTemp);
						claimCombineDtoListTemp.add(claimCombineDto);
					}
					claimCombineDtoList = claimCombineDtoListTemp;
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
			if (claimCombineDtoList != null && claimCombineDtoList.size() > 0) {
				for (int i = 0; i < claimCombineDtoList.size(); i++) {
					SwfLogDto swfLogTemp = new SwfLogDto();
					ClaimCombineDto claimCombineDto = new ClaimCombineDto();
					claimCombineDto = (ClaimCombineDto) (((ArrayList) claimCombineDtoList).get(i));
					swfLogTemp = claimCombineDto.getSwfLogDto();
					swfLogTemp.setNodeTypeName(uiCodeAction.translateCodeCode(
							"ClaimNodeType", swfLogTemp.getNodeType(), true));
					claimCombineDto.setSwfLogDto(swfLogTemp);
					claimCombineDtoListTemp.add(claimCombineDto);
				}
				claimCombineDtoList = claimCombineDtoListTemp;
			}
		}
		SwfLogDto swfLogDto = new SwfLogDto();
		ClaimCombineDto claimCombineDto = new ClaimCombineDto();
		// add by lixiang start at 2006-6-5
		// reason:转换保单号码用的
		claimCombineDtoList = translateRelatePolicyOnTaskQuery(claimCombineDtoList, nodeType);
		// add by lixiang end at 2006-6-5
		getNodeTimeOutInfo(claimCombineDtoList);
		claimCombineDto.setClaimCombineDtoList(claimCombineDtoList);
		claimCombineDto.setAlertMessage(alertMessage);
		if (nodeType == null || nodeType.trim().length() < 1) {
			claimCombineDto.setNodeType("commo");
		} else {
			claimCombineDto.setNodeType(nodeType);
		}
		claimCombineDto.setTurnPageDto(turnPageDto);

		httpServletRequest.setAttribute("claimCombineDto", claimCombineDto);
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
	 */
	private String getNodeTaskListConditions(
			HttpServletRequest httpServletRequest, String status,
			String handlerCode) throws Exception {
		String condition = " ";
		// 首先加入联表条件。 GYIC 李杨 20110803 start
		String combineCondition = " SWFLOG.RegistNo = PRPLCOMBINE.RegistNo ";
		// 首先加入联表条件。 GYIC 李杨 20110803 end
		String orderString = "  order by nodeType,handleTime desc";
		// 注销条件
		if (status.equals("-1")) {
			condition = condition +combineCondition + " and Nodestatus < '4' and handlerCode='"
					+ handlerCode + "'";
			// 新任务条件
		} else if (status.equals("0")) {
			// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
			condition = combineCondition + " and ((NodeStatus='"
					+ status
					+ "' and (handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='' ))  or ( NodeStatus='3' and handlerCode='"
					+ handlerCode + "')) ";
		} else {
			condition = condition + combineCondition + " and NodeStatus='" + status
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
			String comLevel = user.getComLevel();
			if (comLevel.equals("1")) {
				nodeType = "verpo";
			}
		}
		// 如果查询对外核价任务则修改节点类型
		if (conSignType != null && conSignType.equals("verpo")) {
			nodeType = conSignType;
			condition = "  handleDept = '" + user.getComCode() + "' ";
		}

		// 开始拼条件。。。。
		condition = "";
		// 首先加入联表条件。 GYIC 李杨 20110803 start
		String combineCondition = " SWFLOG.RegistNo = PRPLCOMBINE.RegistNo ";
		// 首先加入联表条件。 GYIC 李杨 20110803 end
		if (handlerCode.equals("")) {
			condition = combineCondition + "  and nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "'";
		} else {
			condition = combineCondition +  "  and (nodeType='" + nodeType + "' and NodeStatus='"
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
			condition = combineCondition +  "  and nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus <'4' ";// 这样处理以后
			
			}
			//理算注销新增代码，业务背景：注销回退只适用于未处理的理算任务，与其他注销拒赔不用
			else{
				condition = combineCondition +  "  and nodeType='"
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
				condition = combineCondition +  "  and nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			} else {
				// 状态等于0，分配的为指定的人和公共部分的，没有被指定用户的数据
				condition = combineCondition +  "  and nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and flowStatus!='0' and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			}

			if (nodeType.equals("sched")) { // 定损调度太特殊了

				condition = combineCondition +  "  and (nodeType='" + nodeType + "' ) and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
				//非农险由总公司集中报案，各中支公司只能受理农险报案
				if(user.getComCode().indexOf("000") != 0){
					condition = condition +  " and  (riskcode like '31%' or riskcode like '32%') ";
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
			condition = combineCondition +   " nodeType='" + nodeType + "'";
		}
		if (nodeType.equals("veric") && status.equals("0")) {
			condition = combineCondition +  " nodeType='" + nodeType + "' and nodestatus <'4'";
		}
		// -------------------------------------------------------------
		if ("check".equals(nodeType)) {
			if(status.equals("-1")){
				condition = condition
				+ " and nodeType='"
				+ nodeType
				+ "' and NodeStatus < '4'"
				+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
			}
			else{
				condition = condition
				+ " and nodeType='"
				+ nodeType
				+ "' and NodeStatus='"
				+ status
				+ "'"
				+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
			}
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
								.convertString("SWFLOG.policyNo", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));
			} else {
				condition = condition
						+ " and SWFLOG.registno in (select registno from "
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
					+ StringConvert.convertString("SWFLOG.registno",
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
					+ StringConvert.convertString("SWFLOG.RegistNo", registNo,
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
					+ StringConvert.convertString("SWFLOG.RegistNo", conditionscompe,
							"=");
		}

		String typeFlag = httpServletRequest.getParameter("typeFlag");
		if (("1").equals(typeFlag)) {
			condition = condition + " AND typeFlag='1' ";
		}
		
		/*
		 * added by 李杨 from 国元保险 start
		 * 增加对并案处理中查询的支持。
		 * 增加 事故号（并案号）的查询。
		 * 
		 */
		String combineNo = httpServletRequest.getParameter("CombineNo");
		if(null != combineNo && combineNo.trim().length() > 0){
			condition = condition
			+ StringConvert.convertString("PRPLCOMBINE.CombineNo", combineNo, httpServletRequest.getParameter("CombineNoSign"));
//			String sqlGetRegistNoUnderCombined = "select registno from PRPLCOMBINE where "+ StringConvert.convertString("CombineNo", combineNo,
//					httpServletRequest.getParameter("combineNoSign"));
//			condition = condition + " AND RegistNo in (" + sqlGetRegistNoUnderCombined + ") ";
		}
//		 added by 李杨 from 国元保险 end

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

		// 加入人员权限处理 add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end

		condition = condition + orderString;
        
		return condition;
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
	private Collection translateRelatePolicyOnTaskQuery(Collection claimCombineDtoList,
			String nodeType) throws Exception {
		Collection claimCombineDtoListTemp = new ArrayList();
		UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		Iterator it = claimCombineDtoList.iterator();
		String strSql = "";
		while (it.hasNext()) {
			SwfLogDto swfLogTemp = new SwfLogDto();
			ClaimCombineDto claimCombineDto = new ClaimCombineDto();
			claimCombineDto = (ClaimCombineDto)it.next();
			swfLogTemp = claimCombineDto.getSwfLogDto();
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

			claimCombineDto.setSwfLogDto(swfLogTemp);
			claimCombineDtoListTemp.add(claimCombineDto);

		}
		return claimCombineDtoListTemp;
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
		// 得到多行主表信息
		Collection claimCombineDtoList = new ArrayList();
		Collection claimCombineDtoListTemp = new ArrayList();
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
								.convertString("SWFLOG.policyno", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));

			} else {
				conditions = conditions
						+ " and SWFLOG.registno in (select registno from "
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
		BLPrplcombineSwfLogFacade blPrplcombineSwfLogFacade = new BLPrplcombineSwfLogFacade();
		claimCombineDtoList = (Collection) blPrplcombineSwfLogFacade.findByConditions(conditions);

		// 如果nodeType=定损/核损的话，还需要转换定损/核损的类型名称
		if (nodeType.equals("speci")) {
			Iterator it = claimCombineDtoList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogTemp = new SwfLogDto();
				ClaimCombineDto claimCombineDto = new ClaimCombineDto();
				claimCombineDto = (ClaimCombineDto) it.next();
				swfLogTemp = claimCombineDto.getSwfLogDto();
				if (swfLogTemp.getTypeFlag().equals("3")) {
					swfLogTemp.setTypeFlagName("通融");
				} else if (swfLogTemp.getTypeFlag().equals("4")) {
					swfLogTemp.setTypeFlagName("预付");
				} else if (swfLogTemp.getTypeFlag().equals("5")) {
					swfLogTemp.setTypeFlagName("预赔");
				} else {
					swfLogTemp.setTypeFlagName("");
				}
				claimCombineDto.setSwfLogDto(swfLogTemp);
				claimCombineDtoListTemp.add(claimCombineDto);
			}

			claimCombineDtoList = claimCombineDtoListTemp;
		}
		ClaimCombineDto claimCombineDto = new ClaimCombineDto();
		// add by lixiang start at 2006-6-5
		// reason:转换保单号码用的
		claimCombineDtoList = translateRelatePolicyOnTaskQuery(claimCombineDtoList, nodeType);
		getNodeTimeOutInfo(claimCombineDtoList);
		// add by lixiang end at 2006-6-5
		claimCombineDto.setClaimCombineDtoList(claimCombineDtoList);
		claimCombineDto.setNodeType(nodeType);
		httpServletRequest.setAttribute("claimCombineDto", claimCombineDto);
		// 防止再次刷新的时候会失去值
		httpServletRequest.setAttribute("nodeType", nodeType);

	}
	
	
	public Collection getNodeTimeOutInfo(Collection claimCombineDtoList)
	throws Exception
	{
		Collection claimCombineDtoListTemp = new ArrayList();
		if(null!=claimCombineDtoList && claimCombineDtoList.size()>0){
	      Collection swfLogDtoList = new ArrayList();
	      Collection swfLogDtoLastList = new ArrayList();
	      UICodeAction  uiCodeAction = new UICodeAction();

	      SwfLogDto swfLogDto = new SwfLogDto();
	      Iterator it = claimCombineDtoList.iterator() ;
	      String riskCodeName ="";
	      String nodeStatusName ="";
	      String nodeTypeName ="";
	      int count=0;

	      while (it.hasNext() )
	      {
	        //转换名称
	          SwfLogDto swfLogDtoTemp = new SwfLogDto();
	          ClaimCombineDto claimCombineDto = new ClaimCombineDto();
	          claimCombineDto = (ClaimCombineDto)it.next();
	          swfLogDtoTemp = claimCombineDto.getSwfLogDto();
	        //计算超时的时间长度
	        //public static int intervalDay(DateTime startDate, int startHour, DateTime endDate, int endHour) { return 0;}
	        count =DateTime.intervalDay(new DateTime(swfLogDtoTemp.getHandleTime(),DateTime.YEAR_TO_DAY ),0,new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ) ,0) -1;
	        //-1是为了出掉最后统计的当天
	        swfLogDtoTemp.setTimeLimit(count);
	         //转换名称
	         riskCodeName =  uiCodeAction.translateRiskCode(swfLogDtoTemp.getRiskCode(),true);
	         swfLogDtoTemp.setRiskCodeName(riskCodeName);
	         nodeStatusName =uiCodeAction.translateCodeCode("ClaimStatus",swfLogDtoTemp.getNodeStatus() ,true);
	         swfLogDtoTemp.setNodeStatusName(nodeStatusName);
	         nodeTypeName=uiCodeAction.translateCodeCode("ClaimNodeType",swfLogDtoTemp.getNodeType() ,true);
	         swfLogDtoTemp.setNodeTypeName(nodeTypeName) ;
	         claimCombineDto.setSwfLogDto(swfLogDtoTemp);
	         claimCombineDtoListTemp.add(claimCombineDto);
	      }
		}

	      return claimCombineDtoListTemp;
	}

}

