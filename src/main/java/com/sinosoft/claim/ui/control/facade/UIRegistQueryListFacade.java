package com.sinosoft.claim.ui.control.facade;

/**
 * 分发HTTP  报案查询
 * <p>Title: CLAIMWEB</p>
 * <p>Description: 车险理赔系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lijiyuan
 * @version 1.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UIRegistQueryListFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		return actionMapping.findForward("result");
	}
}
