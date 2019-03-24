package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpayShowFacade;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

/**
 * 支付菜单 支付查询facade类
 * @author Administrator
 *
 */
public class UILpaymainNewBeforeFacade_new extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
			ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
			BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			String back = httpServletRequest.getParameter("back");
			String type = httpServletRequest.getParameter("type");
			String conditions = "";
			//优化修改
			//paymentViewHelper.paymainNewBefore(httpServletRequest);
			paymentViewHelper.paymainNewBeforeNew(httpServletRequest);
			String prevPageUrl = httpServletRequest.getParameter("prevPageUrl");
			httpServletRequest.setAttribute("back", back);
			httpServletRequest.setAttribute("prevPageUrl", prevPageUrl);
			httpServletRequest.setAttribute("payTypeMain", payType);
			httpServletRequest.setAttribute("paymentType", paymentType);	
			httpServletRequest.setAttribute("type", type);
			forward = "success";
//			blPrpLpayShowFacade.getNewQueryShowList(payType, paymentType, conditions);
		}catch(Exception e){
			e.printStackTrace();
		}
		return actionMapping.findForward(forward);
	}
}

