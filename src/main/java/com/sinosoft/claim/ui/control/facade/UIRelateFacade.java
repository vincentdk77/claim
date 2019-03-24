package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.MessageViewHelper;

public class UIRelateFacade extends Action
{
  /**
   * 留言保存页面中查询相关信息
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

    String forward  = "";
    MessageViewHelper messageViewHelper = new MessageViewHelper();
     try
     {
       messageViewHelper.queryRelateInfoToDto(httpServletRequest) ;
       forward = "success";
     }
     catch(Exception e)
     {
       e.printStackTrace();
       //错误信息处理
       ActionErrors errors = new ActionErrors();
       ActionError error = new ActionError("title.registBeforeEdit.titleName");
       errors.add(ActionErrors.GLOBAL_ERROR, error);
       httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
       saveErrors(httpServletRequest, errors);
       forward = "error";

     }
     finally
     {

     }
      
     System.out.println("forward="+forward);
     return actionMapping.findForward(forward);
   }

}
