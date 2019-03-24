package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAVerifyLossViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * Description: 车险理赔核损前查询定损信息信息系统样本程序
 * Copyright: Copyright (c) 2004
 * Company: Sinosoft
 * @author liubvo
 * @version 1.0
 */
public class UILVerifyLossBeforeEditGetFacade extends Action {
	// 日志信息
	private static final Log logger = LogFactory.getLog(UILVerifyLossBeforeEditGetFacade.class);
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示
		String editType = httpServletRequest.getParameter("editType");
		String registNo = ""; // 报案号
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // 用户信息
		String riskCode = httpServletRequest.getParameter("riskCode"); // 险种
		String insureCarFlag = httpServletRequest.getParameter("insureCarFlag"); // 主车标志
		String lossItemCode = httpServletRequest.getParameter("lossItemCode"); // 险种
		String lossItemName = httpServletRequest.getParameter("lossItemName"); // 车牌号码
		String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
		String tempStatus = httpServletRequest.getParameter("status"); // 车牌号码

		String forward = ""; // 向前
		int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode)); // 险种
		try {
			// 尚未加入type异常处理{}、其它必须参数异常处理{}
			if (editType.equals("ADD")) {
				logger.info("新增核损任务开始......");
				// 查询立案信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("RegistNo"); // 报案号
				DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
				// 进行占号分析，只有当有工作流号码和LogNo的时候才能使用。 如果没有flowID和logno则不进行判断。
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				String msg = "";
				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user
							.getUserCode(), user.getUserName());
					if (swfLogDto.getHoldNode() == false) {
						msg = "案件'" + registNo + "'已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
								+ swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!";
						throw new UserException(1, 3, "工作流", msg);
					}
				}
				// 农险
				if ("I".equals(riskType) || "H".equals(riskType)) {
					// 农险没有核损
					// agriVerifyLossViewHelper.certainLossDtoToView(httpServletRequest, registNo, editType);
				} else {
					dAAVerifyLossViewHelper.certainLossDtoToView(httpServletRequest, registNo,
							editType);
				}
				forward = editType + riskCode;
				
				// reason：增加与赔付数量对应的单位信息
				UICodeAction uiCodeAction = new UICodeAction();
				String conditions = " codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"
						+ riskCode + "' and codetype='Unit')";
				Collection collection = uiCodeAction.findByConditions(conditions);
				httpServletRequest.setAttribute("lossesUnitCodeCollection", collection);
				logger.info("新增核损任务结束......");
			}
			if (editType.equals("EDIT") || editType.equals("SHOW")) {
				logger.info("修改/查询核损任务开始......");
				// 查询核损信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // 报案号
				DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
				// 农险
				if ("I".equals(riskType) || "H".equals(riskType)) {
					// 农险没有核损
					// agriVerifyLossViewHelper.verifyLossDtoView(httpServletRequest, registNo, editType, tempStatus);
				} else {
					dAAVerifyLossViewHelper.verifyLossDtoView(httpServletRequest, registNo,
							editType, tempStatus);
				}
				//人伤核损页面增加“流程查询”，传递"swfLogFlowID"参数
				if("SHOW".equals(editType)){
					String flowID = httpServletRequest.getParameter("swfLogFlowID");
					if(null==flowID||"".equals(flowID)){
						ArrayList arraylistSwflog = (ArrayList)new BLSwfFlowMainFacade().findByConditions(" flowname='"+registNo+"' ");
						if(null!=arraylistSwflog&&arraylistSwflog.size()>0){
							SwfFlowMainDto swfFlowMainDto = (SwfFlowMainDto) arraylistSwflog.get(0);
							flowID = swfFlowMainDto.getFlowID();
							httpServletRequest.setAttribute("swfLogFlowID", flowID);
						}
					}
				}
				
				forward = editType + riskCode;
				// reason：增加与赔付数量对应的单位信息
				UICodeAction uiCodeAction = new UICodeAction();
				String conditions = " codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"
						+ riskCode + "' and codetype='Unit')";
				Collection collection = uiCodeAction.findByConditions(conditions);
				httpServletRequest.setAttribute("lossesUnitCodeCollection", collection);
				logger.info("修改/查询核损任务结束......");
			}

			// reason:区分回勘
			String nodeType = httpServletRequest.getParameter("nodeType");
			if (nodeType != null && nodeType.equals("backc")) {
				forward = "BackCDAA";
			} else {
				forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "verif",
						editType, intLossItemCode);
			}

			if (editType.equals("SelectLossType")) {
				forward = "SelectLossType";
			}
			saveToken(httpServletRequest);
			//reason: 核损防止重复提交
			session.setAttribute("oldVerifyLossLastAccessedTime","");
		} catch (SecurityException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.verifyLossBeforeEdit.titleName");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.verifyLossBeforeEdit.titleName");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} finally {

		}
		return actionMapping.findForward(forward);
	}
}
