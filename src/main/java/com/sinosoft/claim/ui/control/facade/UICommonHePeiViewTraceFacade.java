package com.sinosoft.claim.ui.control.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.utility.error.UserException;
import com.sinosoft.undwrt.ui.control.action.UICommonViewTraceAction;

/**
 * <p>Title: uwweb</p>
 * <p>Description: 查看轨迹信息</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author Pao
 * @version 1.0
 */
public class UICommonHePeiViewTraceFacade extends Action
{
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(UICommonHePeiViewTraceFacade.class);

  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest req,
                               HttpServletResponse res) throws UserException, Exception
  {
    HttpSession session = req.getSession(false);
    String forward = "";
    try
    {
      Collection colTraceInfoList = new ArrayList();
      UICommonViewTraceAction uiCommonViewTraceAction = new UICommonViewTraceAction();
      colTraceInfoList = uiCommonViewTraceAction.getTraceInfoList(req);
      session.setAttribute("TraceInfoList",colTraceInfoList);
      forward = "success";
    }
    catch (Exception e)
    {
			logger.error("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$
      throw e;
    }
    return actionMapping.findForward(forward);
  }
}
