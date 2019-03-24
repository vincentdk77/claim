package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

public class UILpayMergeCheckfacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		try{
			String paymentType = httpServletRequest.getParameter("paymentType");
			String certiNo = httpServletRequest.getParameter("certiNo");
			String paymentNo = httpServletRequest.getParameter("paymentNo");
			int count = 0;
			if(paymentType!=null&&!"".equals(paymentType)){
				count = paymentViewHelper.payMerge(paymentNo,paymentType, certiNo);
			}else{
				count = paymentViewHelper.payMerge(paymentNo, certiNo);
			}
			if(count>0){
				httpServletResponse.getWriter().write("false");
			}else{
				httpServletResponse.getWriter().write("true");
			}
		}catch(Exception e){
			e.printStackTrace();
			httpServletResponse.getWriter().write(e.getMessage());
		}
		return null;
	}
}
