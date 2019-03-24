package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpayNoticeListFacade;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentFiscalViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

/**
 * 预赔、理算环节支付信息进入详细页面编辑facade类
 * @author Administrator
 *
 */
public class UILfiscalpaymainEditPostfacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			PaymentFiscalViewHelper paymentFiscalViewHelper = new PaymentFiscalViewHelper();
			paymentFiscalViewHelper.fiscalmainEdit(httpServletRequest);
			httpServletRequest.setAttribute("prevPageUrl",httpServletRequest.getParameter("prevPageUrl") );
			httpServletRequest.setAttribute("pageConditions",httpServletRequest.getParameter("pageConditions") );
			forward ="success";
		}catch(Exception e){
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
