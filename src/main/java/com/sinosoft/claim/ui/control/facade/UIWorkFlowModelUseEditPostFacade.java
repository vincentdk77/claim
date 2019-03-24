package com.sinosoft.claim.ui.control.facade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowModelAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowModelViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 工作流模板分配查询
 * <p>Title: 工作流模板分配</p>
 * <p>Description: 工作流模板分配</p>
 * <p>Copyright: Copyright (c) 2004-08-25</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIWorkFlowModelUseEditPostFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    String forward = "" ;//界面流转
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType = "" ; //编辑类型
    int modelNo = 0 ;//模板号
    editType = httpServletRequest.getParameter("editType") ;
    try
    {
        WorkFlowModelViewHelper workFlowModelViewHelper = new WorkFlowModelViewHelper();
        UIWorkFlowModelAction    uiWorkFlowModelAction     = new UIWorkFlowModelAction();
        SwfModelUseDto swfModelUseDto = null;
        System.out.println("editType:"+editType);
        if(editType.equals("ADD"))
        {
          //得到初始化界面Dto

          swfModelUseDto = workFlowModelViewHelper.viewSwfModelUseToDto(httpServletRequest) ;
          /*
          if (swfModelUseDto.getModelUseList()!=null){
          	for (int j=0;j<swfModelUseDto.getModelUseList().size() ;j++ ){
          		SwfModelUseDto st= (SwfModelUseDto)((ArrayList)swfModelUseDto.getModelUseList()).get(j);
          	System.out.println("st.getModelType()"+st.getModelType());
          	
          	}
          	
          	
          }
          */	
          uiWorkFlowModelAction.saveWfModelUse(swfModelUseDto) ;
          
          
        }
        else if(editType.equals("EDIT"))
        {
          swfModelUseDto = workFlowModelViewHelper.viewSwfModelUseEditToDto(httpServletRequest) ;
          uiWorkFlowModelAction.saveWfModelUse(swfModelUseDto) ;
        }
        ActionMessages msgs = new ActionMessages();
        ActionMessage msg = new ActionMessage("prompt.workFlow.tempcfg.success");
        msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
        saveMessages(httpServletRequest,msgs);
        forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionMessages errors = new ActionMessages();
      ActionMessage msg = new ActionMessage("title.verifyLossBeforeEdit.queryVerifyLossList");
      errors.add(ActionMessages.GLOBAL_MESSAGE, msg);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionMessages errors = new ActionMessages();
      ActionMessage error = new ActionMessage("title.verifyLossBeforeEdit.queryVerifyLossList");
      errors.add(ActionMessages.GLOBAL_MESSAGE, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("UIWorkFlowModelUseEditPostFacade forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
