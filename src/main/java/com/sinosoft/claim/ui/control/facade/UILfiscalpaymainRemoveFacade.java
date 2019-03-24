package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrplfiscalpaydetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplfiscalpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;

/**
 * 财政支付清单删除
 * @author Administrator
 *
 */
public class UILfiscalpaymainRemoveFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			String fiscalno = httpServletRequest.getParameter("fiscalno");
			BLPrplfiscalpaymainFacade blPrplfiscalpaymainFacade = new BLPrplfiscalpaymainFacade();
			BLPrplfiscalpaydetailFacade blPrplfiscalpaydetailFacade = new BLPrplfiscalpaydetailFacade();
			BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
			blPrplfiscalpaymainFacade.delete(fiscalno);
			blPrplfiscalpaydetailFacade.delete(fiscalno);
			blPrpLpayExtFacade.deleteByConditions("  paymentNo='"+fiscalno+"' ");
			httpServletResponse.getWriter().write("true");
		}catch(Exception e){
			e.printStackTrace();
			httpServletResponse.getWriter().write(e.getMessage());
			
		}
		return null;
	}
}
