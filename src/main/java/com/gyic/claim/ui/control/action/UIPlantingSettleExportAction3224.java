package com.gyic.claim.ui.control.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.gyic.claim.utils.NyxSettleExport;

/**
 * 分发HTTP GET
 * <p>Title: 养殖险合并案件</p>
 * <p>Description: 养殖险合并案件</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Sinosoft</p>
 * @author qianxiantao
 * @version 1.0
 */

public class UIPlantingSettleExportAction3224 extends Action
{
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)throws Exception{
		String mappingRes=null;
		ServletContext servletContext = getServlet().getServletContext();
		String rootPath = servletContext.getRealPath("/bea");
		NyxSettleExport nyxSettleExport = new NyxSettleExport();
		mappingRes=nyxSettleExport.plantingExportAct(httpServletRequest,httpServletResponse,rootPath);
		return actionMapping.findForward(mappingRes);
	}
		  
}