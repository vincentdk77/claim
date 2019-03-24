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
public class UILCompensateGeneratePostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILCompensateGeneratePostFacade.class);

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; // ��ǰ��ת
		try {
			UICodeAction uiCodeAction = new UICodeAction();
			// ȡ���������
			String compensateNo = httpServletRequest
					.getParameter("prpLcompensateClaimNo");
			logger.debug("�������㱨�����������:" + compensateNo);

			httpServletRequest.setAttribute("compensateNo", compensateNo);
			// ��viewHelper�����������
			String riskCode = BusinessRuleUtil.getRiskCode(compensateNo,
					"ClaimNo");
			// modify by liuyanmei 20060221 start for������0503==DAC������
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
					// ���ǿ�Ʊ������㱨�����������ʵ��
					compensateGenerateViewHelper = CompensateGenerateImplCompelViewHelper
							.getInstance();
				} else {
					// �����ҵ�������㱨�����������ʵ��
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
			// ������Ϣ����
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
			// ������Ϣ����
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
