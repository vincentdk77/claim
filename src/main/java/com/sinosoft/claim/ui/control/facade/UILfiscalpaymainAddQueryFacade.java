package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpayShowFacade;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentFiscalViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

public class UILfiscalpaymainAddQueryFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			PaymentFiscalViewHelper paymentFiscalViewHelper = new PaymentFiscalViewHelper();
			String registNo = httpServletRequest.getParameter("registNo");//报案号
			String compensateNo = httpServletRequest.getParameter("compensateNo");//计算书
			String condition = " 1=1 ";
			if(null!=compensateNo && !"".equals(compensateNo)){
				condition += " and compensateno = '"+compensateNo+"'";
			}
			if(null!=registNo && !"".equals(registNo)){
				condition += " and registNo = '"+registNo+"'";
			}
			condition += " and Length(insuredcode) = 15  and insuredcode not in  (select insuredcode from prplfiscalpaydetail dd where dd.compensateno = PrpLclaimBillManager.compensateno)";
			Collection claimBillList = paymentFiscalViewHelper.findByClaimBillConditions(httpServletRequest,condition);
			httpServletRequest.setAttribute("claimBillList", claimBillList);
			forward ="success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return actionMapping.findForward(forward);
	}
}
