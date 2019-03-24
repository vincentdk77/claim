package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 理赔调度节点的新的需要调度的任务
 * <p>Title: 理赔调度节点的新的需要调度的任务</p>
 * <p>Description: 理赔调度节点的新的需要调度的任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0u
 */

public class UIScheduleDealFacade extends Action {

	public static String SCHEDULEADD = "ADD"; //
	public static String SCHEDULEEDIT = "EDIT"; //
	public static String SCHEDULEQUERYCHECK = "QUERYCHECK"; //

	public static String FORWARDSUCCESS = "success"; //跳转条件成功
	public static String FORWARDERROR = "error"; //跳转条件失败
	public static String FORWARDLISTDAA = "LISTDAA"; //跳转条件成功到LISTDAA
	public static String FORWARDEDITDAA = "EDITDAA"; //跳转条件成功到EDITDAA

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		/**  包含如下功能
		 * 1。调度录入的界面展现
		 * 2。已提交调度任务列表中的调度信息详细查看
		 * 3。已查勘情况查询
		 * 4。查询调度取回任务
		 * 5。查询调度撤消任务
		 * 6。查询调度的所有信息
		 **/

		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		String forward = "";

		//向前
		String editType = httpServletRequest.getParameter("editType");
		try {
			//尚未加入type异常处理{}、其它必须参数异常处理{}
			//查询新调度提示表信息,整理输入，用于初始界面显示
			String registNo = "";
			String scheduleID = "";
			String surveyNo = "";
			String checkFlag0 = "";
			String checkFlag1 = "";
			String checkFlag2 = "";
			String checkFlag3 = "";
			String checkFlag4 = "";
			String checkFlag5 = "";
			String checkFlag6 = "";

			String operatorCode = "";
			String scheduleObjectID = "";
			String startDate = "";
			String endDate = "";
			String conditions = "";
			String strTemp = "";
			String licenseNo = "";
			String scheduleType = "schedule"; //调度传入参数

			String beforeHandlerCode = "";
			String handlerCode = "";
			UICodeAction uiCodeAction = new UICodeAction();
			String strRiskCode = uiCodeAction
					.translateProductCode("RISKCODE_DAA");
			String flowID = httpServletRequest.getParameter("swfLogFlowID");
			String logNo = httpServletRequest.getParameter("swfLogLogNo");
			//add by miaowenjun 20060922 start
			String riskCode = httpServletRequest.getParameter("riskCode");
			String riskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);
			//add by miaowenjun 20060922 end

			//1。调度录入的界面展现
			//调用位置:调度任务登记 ->新案件提示任务列表中选中一个报案->显示调度任务信息			
			if (editType.equals("ADD")) {
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //报案号
				surveyNo = httpServletRequest
						.getParameter("prpLscheduleMainWFSurveyNo"); //次数号码

				//  占号怎么处理？？
				//	考虑先占号，大家都能看得到。。。。。找不到人就可以随便问了。。。
				//  可以做立案了
				//==================================================
				//进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
				//如果没有flowID和logno则不进行判断。

				String msg = "";

				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer
							.parseInt(logNo), user.getUserCode(), user
							.getUserName());

					if (swfLogDto.getHoldNode() == false) {
						msg = "案件'" + registNo + "'已经被代码:'"
								+ swfLogDto.getHandlerCode() + "',名称:'"
								+ swfLogDto.getHandlerName()
								+ "'的用户所占用,请选择其它案件进行处理!";
						throw new UserException(1, 3, "工作流", msg);
					}
				}
				//modify by miaowenjun 20060922 农险走不同的viewhelper,返回不同的forward
				if ("D".equals(riskType) ) {
					DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
					dAAScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "success";
				} else if ("I".equals(riskType) || "H".equals(riskType)) {
					AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
					agriScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "AgriSuccess";
				} else if ("Q".equals(riskType) || "Z".equals(riskType)
						|| "Y".equals(riskType) ) {
					//财产险的JAVA类借用农险的来实现
					AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
					agriScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "PropSuccess";
					//意健险走自己的调度页面，add by xiatian
				} else if ("E".equals(riskType) ) {
					//财产险的JAVA类借用农险的来实现
					AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
					agriScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "AcciSuccess";
				}
				//添加查勘机构和定损机构的默认值
				BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
				PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)httpServletRequest.getAttribute("prpLscheduleMainWFDto");
				if(null != prpLscheduleMainWFDto){
					String centerComCode = blPrpDcompanyFacade.getCenterCode(prpLscheduleMainWFDto.getClaimComCode());
					String centerComName = blPrpDcompanyFacade.translateCode(centerComCode, true);
					
					prpLscheduleMainWFDto.setScheduleObjectID(centerComCode);
					prpLscheduleMainWFDto.setScheduleObjectName(centerComName);
					
					PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto)httpServletRequest.getAttribute("prpLscheduleItemDto");
					Collection scheduleItemList = prpLscheduleItemDto.getScheduleItemList();
					for(Iterator scheduleItemItr = scheduleItemList.iterator();scheduleItemItr.hasNext();){
						PrpLscheduleItemDto prpLscheduleItem = (PrpLscheduleItemDto)scheduleItemItr.next();
						prpLscheduleItem.setScheduleObjectID(centerComCode);
						prpLscheduleItem.setScheduleObjectName(centerComName);
					}
				} 
			}
			//2。已提交调度任务列表中的调度信息详细查看
			//调用位置:已提交调度任务 ->任务列表中选中一个报案->显示保存过的调度任务信息
			if (editType.equals("EDIT")) {
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //报案号
				scheduleID = httpServletRequest
						.getParameter("prpLscheduleMainWFScheduleID"); //调度号
				//modify by miaowenjun 20060928 农险走自己的viewhelper
				AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				if ("I".equals(riskType) || "H".equals(riskType)) {
					agriScheduleViewHelper.scheduleDtoToView(
							httpServletRequest, registNo, editType, scheduleID);
					forward = "EDITAgri";
				} else if ("Q".equals(riskType)|| "Y".equals(riskType)||"Z".equals(riskType)|| "E".equals(riskType)) {
					agriScheduleViewHelper.scheduleDtoToView(
							httpServletRequest, registNo, editType, scheduleID);
					forward = "EDITProp";
					//add by xiatian 添加意健险调度
				}else if ("E".equals(riskType)) {
						agriScheduleViewHelper.scheduleDtoToView(
								httpServletRequest, registNo, editType, scheduleID);
						forward = "EDITAcci";
				} else {
					dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,
							registNo, editType, scheduleID);
					forward = "EDITDAA";
				}
			}

			//3。已查勘情况查询
			//调用位置:调度任务->查勘处理情况查询  ->输入查询条件后按下按钮->显示查询结果
			if (editType.equals("QUERYCHECK")
					|| editType.equals("QUERYCERTAINLOSS")) {
				registNo = httpServletRequest.getParameter("registNo");
				beforeHandlerCode = httpServletRequest
						.getParameter("handlerCode");
				handlerCode = httpServletRequest.getParameter("NhandlerCode");
				checkFlag0 = httpServletRequest.getParameter("checkFlag0");
				checkFlag2 = httpServletRequest.getParameter("checkFlag2");
				checkFlag4 = httpServletRequest.getParameter("checkFlag4");
				startDate = httpServletRequest.getParameter("startDate");
				endDate = httpServletRequest.getParameter("endDate");
				licenseNo = httpServletRequest.getParameter("licenseNo");

				conditions = "";

				if (registNo != null && registNo.trim().length() > 0) {
					conditions = conditions + " (keyin like '" + registNo
							+ "%') AND ";

				}
				if (beforeHandlerCode != null
						&& beforeHandlerCode.trim().length() > 0) {
					conditions = conditions + " (beforeHandlerCode="
							+ beforeHandlerCode + ") AND ";
				}

				if (startDate != null && startDate.trim().length() > 0) {
					conditions = conditions + " (flowIntime>='" + startDate
							+ "') AND ";
				}
				if (endDate != null && endDate.trim().length() > 0) {
					conditions = conditions
							+ " (flowIntime<='"
							+ new DateTime(endDate, DateTime.YEAR_TO_DAY)
									.addDay(1).toString() + "') AND ";
				}
				if (checkFlag0 != null || checkFlag2 != null
						|| checkFlag4 != null) {
					if (checkFlag0 != null)
						strTemp = strTemp + "'0',";
					if (checkFlag2 != null)
						strTemp = strTemp + "'2',";
					if (checkFlag4 != null)
						strTemp = strTemp + "'4',";
					//去掉最后的一个","
					strTemp = strTemp.substring(0, strTemp.length() - 1);
					conditions = conditions + " (nodeStatus in(" + strTemp
							+ ")) AND ";
				}
				if (licenseNo != null && licenseNo.trim().length() > 0) {
					conditions = conditions + " (lossItemCode like '%"
							+ licenseNo + "%') AND ";
				}

				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				String nodeType = "";
				if (editType.equals("QUERYCHECK")) {
					nodeType = "check";
					conditions = conditions + " nodeType='check'";
				} else {
					conditions = conditions + " nodeType='certa'";
					nodeType = "certa";
				}

				UIPowerInterface uiPowerInterface = new UIPowerInterface();
				UserDto userDto = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				//conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),com.sinosoft.claim.util.BusinessRuleUtil.transTaskCode(httpServletRequest.getParameter("nodeType")),"swflog",strRiskCode);
				conditions = conditions
						+ uiPowerInterface.addPower(userDto, "swflog", "",
								"ComCode");
				conditions = conditions + " order by flowintime";

				//从翻页取数据
				String condition = httpServletRequest.getParameter("condition");
				if (condition != null && condition.trim().length() > 0) {
					conditions = condition;
				}
				System.out.println();
				System.out.println("conditions=" + conditions);
				System.out.println();
				dAAScheduleViewHelper.getNextTaskList(httpServletRequest,
						conditions, nodeType);

				forward = "LISTDAA";
			}

			//5。查询调度撤消任务
			//调用位置:调度任务->已查勘情况查询 ->输入查询条件后按下按钮->显示查询结果
			if (editType.equals("CANCELQUERY")) {
				conditions = "1=1";
				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.getScheuleCheckList(httpServletRequest,
						conditions, scheduleType);
				forward = "CANCELLISTDAA";

			}

			//6。查询调度的所有信息
			//调用位置:调度任务->已查勘情况查询 ->输入查询条件后按下按钮->显示查询结果

			if (editType.equals("QUERY")) {
				registNo = httpServletRequest.getParameter("registNo");
				startDate = httpServletRequest.getParameter("startDate");
				endDate = httpServletRequest.getParameter("endDate");
				checkFlag0 = httpServletRequest.getParameter("checkFlag0");
				checkFlag4 = httpServletRequest.getParameter("checkFlag4");
				checkFlag2 = httpServletRequest.getParameter("checkFlag2");
				operatorCode = httpServletRequest.getParameter("handlerCode");
				licenseNo = httpServletRequest.getParameter("licenseNo");
				scheduleObjectID = httpServletRequest
						.getParameter("scheduleObjectID");
				scheduleType = httpServletRequest.getParameter("scheduleType");
				conditions = " 1=1 ";
				//添加区分新农险标识
				conditions = conditions + " and (registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='sched') ";
				conditions = conditions + " or registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='sched')) ";
				conditions = conditions
						+ StringConvert
								.convertString("registNo", registNo,
										httpServletRequest
												.getParameter("registNoSign"));
				conditions = conditions
						+ StringConvert.convertString("operatorCode",
								operatorCode, "=");
				conditions = conditions
						+ StringConvert.convertString("scheduleObjectID",
								scheduleObjectID, "=");
				String strTemp1 = "";
				String tableName = "";
				if (scheduleType.equals("schel")) {
					conditions = conditions
							+ StringConvert
									.convertString(
											"licenseNo",
											httpServletRequest
													.getParameter("prpLscheduleItemLicenseNo"),
											httpServletRequest
													.getParameter("prpLscheduleItemLicenseNoSign"));
				}
				if (checkFlag0 != null || checkFlag4 != null) {
					if (checkFlag0 != null) {
						strTemp = strTemp + "'0',";
						strTemp1 = strTemp1 + "'0',";
					}

					if (checkFlag4 != null) {
						strTemp = strTemp + "'4',";
						strTemp1 = strTemp1 + "'1',";

					}
					//去掉最后的一个","
					strTemp = strTemp.substring(0, strTemp.length() - 1);
					strTemp1 = strTemp1.substring(0, strTemp1.length() - 1);

					if (scheduleType.equals("schel")) {

						conditions = conditions + " AND (surveyTimes in("
								+ strTemp1 + "))";
					} else {
						conditions = conditions + " AND (checkFlag in("
								+ strTemp + "))";
					}
				}

				if (startDate != null && startDate.trim().length() > 0) {
					conditions = conditions + " AND (inputdate>=to_date('"
							+ startDate + "','YYYY-MM-DD')) ";
				}
				if (endDate != null && endDate.trim().length() > 0) {
					conditions = conditions
							+ " AND (inputdate<=to_date('"
							+ new DateTime(endDate, DateTime.YEAR_TO_DAY)
									.addDay(1).toString() + "','YYYY-MM-DD')) ";
				}

				if (scheduleType.equals("schel")) {

					//tableName="prplscheduleitem";
					tableName = "swflog";
				} else {
					// 	tableName="prplschedulemainwf";
					tableName = "swflog"; //modify by kangzhen
				}
				//           20060807  conditions =conditions+ " and claimComCode='"+user.getScheduleComCode() +"'";

				//从session里取扶贫/大户标志
		          String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
		          if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
		        	  if(strHPflag.equals("Large")) {
		        		  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
		        	  }
		              if(strHPflag.equals("Retaol")) {
		            	  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
		        	  }
		          }
		          
				//conditions += " AND exists(select 0 from prplregist a,swflog where DealerCode is null and a.registNo="+tableName+".registno)";
				conditions += " AND exists(select 0 from prplregist a,swflog where (DealerCode is null or DealerCode='') and a.registNo="
						+ tableName + ".registno";//modify by kangzhen
				conditions = conditions
						+ StringConvert.convertString("InsuredName",
								httpServletRequest.getParameter("InsuredName"),
								httpServletRequest
										.getParameter("InsuredNameSign"));

				UIPowerInterface uiPowerInterface = new UIPowerInterface();
				UserDto userDto = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				//conditions =conditions+ uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","prplregist",strRiskCode)+") " ;
				conditions = conditions
						+ uiPowerInterface.addPower(userDto, tableName, "",
								"ComCode");

				//conditions =conditions +" order by inputdate desc";
				conditions = conditions + ") order by inputdate desc";//modify by kangzhen
				//System.out.println(conditions);
				//从翻页取数据
				String condition = httpServletRequest.getParameter("condition");
				if (condition != null && condition.trim().length() > 0) {
					conditions = condition;
				}

				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.getScheuleCheckList(httpServletRequest,
						conditions, scheduleType);
				forward = "COMMONLISTDAA" + scheduleType;

			}

			//7。显示调度信息详细查看 只读的

			if (editType.equals("SHOW")) {
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //报案号
				scheduleID = httpServletRequest
						.getParameter("prpLscheduleMainWFScheduleID"); //调度号

				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,
						registNo, editType, scheduleID);
				forward = "SHOWDAA";
				if ("I".equals(riskType) || "H".equals(riskType)) {
					forward = "SHOWAgri";
				}else if("Q".equals(riskType)|| "Y".equals(riskType)||"Z".equals(riskType)){
					forward = "SHOWProp";
					//add by xiatian 修改意健险显示路径
				}else if("E".equals(riskType))
					forward = "SHOWAcci";
			}

			//8。调度信息取回详细显示
			//调用位置:调度取回任务 ->任务列表中选中一个报案->显示保存过的调度任务信息
			if (editType.equals("GETBACKEDIT")) {
				scheduleType = httpServletRequest.getParameter("scheduleType");
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //报案号
				scheduleID = "1"; //调度号
				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,
						registNo, editType, scheduleID);
				forward = "EDITDAA" + scheduleType;
			}

			//modify by wangli add start 20050412

			//9. 新增定损调度的所有信息
			//调用位置:调度任务->新增定损调度 ->输入查询条件后按下按钮->显示查询结果

			if (editType.equals("ADDQUERY")) {
				//说明:能够取回的任务必须是还没有被查勘处理过的调度任务
				registNo = httpServletRequest.getParameter("registNo");
				startDate = httpServletRequest.getParameter("startDate");
				endDate = httpServletRequest.getParameter("endDate");
				conditions = " NodeType = 'sched' ";
				conditions = conditions
						+ StringConvert
								.convertString("keyin", registNo,
										httpServletRequest
												.getParameter("registNoSign"));
				conditions = conditions
						+ StringConvert
								.convertString(
										"LossItemName",
										httpServletRequest
												.getParameter("prpLscheduleItemLicenseNo"),
										httpServletRequest
												.getParameter("prpLscheduleItemLicenseNoSign"));
				conditions = conditions
						+ StringConvert.convertString("InsuredName",
								httpServletRequest.getParameter("InsuredName"),
								httpServletRequest
										.getParameter("InsuredNameSign"));

				if (startDate != null && startDate.trim().length() > 0) {
					conditions = conditions + " AND (FlowInTime>='" + startDate
							+ "') ";
				}
				if (endDate != null && endDate.trim().length() > 0) {
					conditions = conditions
							+ " AND (FlowInTime<='"
							+ new DateTime(endDate, DateTime.YEAR_TO_DAY)
									.addDay(1) + "') ";
				}
				System.out.println();

				//查询出所有的
				//UIPowerInterface uiPowerInterface = new UIPowerInterface();
				UserDto userDto = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				//conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","swflog",strRiskCode);
				//          20060807     conditions =conditions+ " and handledept='"+user.getScheduleComCode() +"'";           

				//从翻页取数据
				String condition = httpServletRequest.getParameter("condition");
				if (condition != null && condition.trim().length() > 0) {
					conditions = condition;
				}

				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				workFlowViewHelper.getScheduleAddCertainLossSwfLogList(
						httpServletRequest, conditions);
				forward = "ADDLISTDAA";

			}
			//modify by wangli add start 20050412

			saveToken(httpServletRequest);
		}

		catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.scheduleBeforeEdit.querySchedule");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = FORWARDERROR;

		}

		catch (Exception e) {
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.scheduleBeforeEdit.querySchedule");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = FORWARDERROR;

		} finally {

		}
		return actionMapping.findForward(forward);

	}

}
