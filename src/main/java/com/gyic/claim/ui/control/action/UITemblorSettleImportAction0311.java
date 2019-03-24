package com.gyic.claim.ui.control.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.gyic.claim.ui.control.facade.UIClaimTemblor0311SettleLoadFacade;
import com.gyic.claim.utils.LoadForm;


/**
 * 分发HTTP GET
 * <p>Title: 养殖险合并案件</p>
 * <p>Description: 养殖险合并案件</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Sinosoft</p>
 * @author qianxiantao
 * @version 1.0
 */

public class UITemblorSettleImportAction0311 extends Action
{
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)throws Exception{

		String mappingRes=null;
		try {
			LoadForm loadForm = (LoadForm)actionForm;
			
			ServletContext servletContext=getServlet().getServletContext();
			String rootPath=servletContext.getRealPath("/bea");
			UIClaimTemblor0311SettleLoadFacade uiTemblor0311SettleLoadFacade = new UIClaimTemblor0311SettleLoadFacade();
			mappingRes= uiTemblor0311SettleLoadFacade.temblorLoadAct(httpServletRequest, rootPath,loadForm);
			return actionMapping.findForward(mappingRes);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
		  
}