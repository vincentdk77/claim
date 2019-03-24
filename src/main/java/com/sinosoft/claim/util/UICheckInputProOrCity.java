package com.sinosoft.claim.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UICheckInputProOrCity extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String cityName = request.getParameter("city");
		String provinceName = request.getParameter("pro");
		CheckInputUtil checkUtil = new CheckInputUtil();
		boolean isCity = checkUtil.checkCityOrPro(cityName);
		boolean isPro = checkUtil.checkCityOrPro(provinceName);
		String returnMessage = isCity+","+isPro;
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnMessage);
		return null;
	}
	
}
