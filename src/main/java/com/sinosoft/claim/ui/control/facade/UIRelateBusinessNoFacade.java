package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.ui.control.viewHelper.RelateBusinessNoViewHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ����ҳ��UI��Facade��
 * <p>Title: ����ҳ��</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:sinosoft </p>
 * @author sunhao
 * @version 1.0
 */
public class UIRelateBusinessNoFacade extends Action
{
	Log log = LogFactory.getLog(UIRelateBusinessNoFacade.class);
  /**
   * ����ҳ���в�ѯ�����Ϣ
   * @param actionMapping ActionMapping
   * @param actionForm ActionForm
   * @param httpServletRequest HttpServletRequest
   * @param httpServletResponse HttpServletResponse
   * @throws Exception
   * @return ActionForward
   */
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {

	  log.debug("����UIRelateBusinessNoFacade-------");
    String forward  = "";
    RelateBusinessNoViewHelper relateBusinessNoViewHelper = new RelateBusinessNoViewHelper();
     try
     {
       relateBusinessNoViewHelper.queryRelateInfoToDto(httpServletRequest) ;
       forward = "success";
     }
     catch(Exception e)
     {
       e.printStackTrace();
       //������Ϣ����
       ActionMessages msgs = new ActionMessages();
       ActionMessage msg = new ActionMessage("title.endcaseBeforeEdit.titleName");
       msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
       httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
       saveErrors(httpServletRequest, msgs);
       forward = "error";

     }      
     System.out.println("forward="+forward);
     return actionMapping.findForward(forward);
   }

}
