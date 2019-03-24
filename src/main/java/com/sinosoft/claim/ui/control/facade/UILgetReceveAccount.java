package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLTripartiteComFacade;

public class UILgetReceveAccount extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		String receiverTypeOther = request.getParameter("receiverTypeOther");
		String registNo = request.getParameter("registNo");
		String enterpriseDateType = "";
		String conditions = " 1 = 1 ";
		if("t07".equals(receiverTypeOther)){
			enterpriseDateType = "XL";
		}else if("t06".equals(receiverTypeOther)){
			enterpriseDateType = "GG";
		}else if("t08".equals(receiverTypeOther)){
			enterpriseDateType = "DC";
		}else if("t09".equals(receiverTypeOther)){
			enterpriseDateType = "JY";
		}else if("t10".equals(receiverTypeOther)){
			enterpriseDateType = "JD";
		}else if("t11".equals(receiverTypeOther)){
			enterpriseDateType = "LS";
		}else if("t05".equals(receiverTypeOther)){
			enterpriseDateType = "FY";
		}
		BLPrpLTripartiteComFacade blPrpLTripartiteComFacade = new BLPrpLTripartiteComFacade();
		conditions +=  "  and enterpriseDateType = '"+enterpriseDateType+"' and approveflag = '1' and validstatus = '1' ";
		if("t07".equals(receiverTypeOther)){
			conditions += " and enterprisecode in (select ss.repairfactorycode "+
	        " from prplcarloss ss "+
	        " where ss.registno = '"+registNo+"')" +
	        " and cooperationtype in ('CT001','CT004','CT005')";
		}
		
		try {
			
			ArrayList prpLTripartiteComList = (ArrayList)blPrpLTripartiteComFacade.findConditions(conditions);
			request.setAttribute("prpLTripartiteComList", prpLTripartiteComList);
			
		} catch (Exception e) {
			response.getWriter().write("false#");//不存在委托
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
			request.setAttribute("errorMessage", stringWriter.toString());
		}
		
		return mapping.findForward(forward);
	}
}
