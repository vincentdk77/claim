package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.AccidentCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.CompensateGenerateImplCompelViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.CompensateGenerateImplDubangViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.CompensateGenerateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 分发HTTP Post 车险理赔实赔编辑界面
 * <p>
 * Title: 车险理赔实赔编辑界面信息
 * </p>
 * <p>
 * Description: 车险理赔实赔编辑界面信息
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
public class UILCompensateGeneratePostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILCompensateGeneratePostFacade.class);

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; // 向前流转
		try {
			UICodeAction uiCodeAction = new UICodeAction();
			// 取赔款计算书号
			String compensateNo = httpServletRequest
					.getParameter("prpLcompensateClaimNo");
			logger.debug("生成理算报告的立案号是:" + compensateNo);

			httpServletRequest.setAttribute("compensateNo", compensateNo);
			// 用viewHelper整理界面输入
			String riskCode = BusinessRuleUtil.getRiskCode(compensateNo,
					"ClaimNo");
			// modify by liuyanmei 20060221 start for：增加0503==DAC的险种
			String strRiskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);
			String strConfigCode = uiCodeAction
					.translateRiskCodetoConfigCode(riskCode);
			if ("D".equals(strRiskType)) {
				// //modify by liuyanmei 20060221
				CompensateDto compensateDto = SunnyCompensateViewHelper
						.getInstance().viewToDto(httpServletRequest);
				CompensateGenerateViewHelper compensateGenerateViewHelper;
				if ("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)
						||"RISKCODE_DAU".equals(strConfigCode)) {
					// 获得强制保险理算报告书的生成类实例
					compensateGenerateViewHelper = CompensateGenerateImplCompelViewHelper
							.getInstance();
				} else {
					// 获得商业保险理算报告书的生成类实例
					compensateGenerateViewHelper = CompensateGenerateImplDubangViewHelper
							.getInstance();
				}
				compensateGenerateViewHelper.compensateGenerate(
						httpServletRequest, compensateDto);
			} else {
				AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
				CompensateDto compensateDto = null;
				if (riskCode.substring(0, 2).equals("27")
						|| riskCode.substring(0, 2).equals("26")
						|| riskCode.substring(0, 2).equals("28")) {
					compensateDto = accidentCompensateViewHelper
							.viewToDtoForAccident(httpServletRequest);
				} else {
					compensateDto = accidentCompensateViewHelper
							.viewToDto(httpServletRequest);
				}
				accidentCompensateViewHelper.generateCtext(httpServletRequest,
						compensateDto);
			}
			forward = "generate";
		} catch (UserException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
