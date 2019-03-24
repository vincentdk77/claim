package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
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
 * 分发HTTP Post 中央政策性六大农险实赔编辑界面
 * <p>
 * Title: 中央政策性六大农险实赔编辑界面
 * </p>
 * <p>
 * Description: 中央政策性六大农险实赔编辑界面
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
public class UILCompensateAgriGeneratePostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILCompensateAgriGeneratePostFacade.class);

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String KindCode[]=httpServletRequest.getParameterValues("prpLlossDtoKindCode");
		String policyNo=httpServletRequest.getParameter("PolicyNo");
		ArrayList arr=null;
		String conditions="";
		String forward = ""; // 向前流转
		try {
			   BLPrpCitemKindFacade blCitemKindFacade=new BLPrpCitemKindFacade();
			   if((!"".equals(KindCode[KindCode.length-1])&&null!=KindCode[KindCode.length-1])&&(!"".equals(policyNo)&&null!=policyNo)){
				   conditions=" kindcode='"+KindCode[1]+"' and policyNo='"+policyNo+"'";
			   }
			   arr=(ArrayList)blCitemKindFacade.findByConditions(conditions);
			   PrpCitemKindDto prpCitemKindDto=new PrpCitemKindDto();
			   prpCitemKindDto=(PrpCitemKindDto)arr.get(0);
			   double UnitAmount=prpCitemKindDto.getUnitAmount();
			   double DeductibleRate=prpCitemKindDto.getDeductibleRate();
			   String KindName=prpCitemKindDto.getKindName();
			   String riskCode = prpCitemKindDto.getRiskCode();
			   httpServletRequest.setAttribute("riskCode", riskCode);
			   AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
			   accidentCompensateViewHelper.generateAgriCtext(httpServletRequest,UnitAmount,DeductibleRate,KindName);
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
