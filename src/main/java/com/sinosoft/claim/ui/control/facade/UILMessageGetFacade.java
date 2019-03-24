package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.MessageViewHelper;

/**
 * UILMessageFacade
 * <p>Title:理赔流转讨论留言UI层Facade类 </p>
 * <p>Description: 理赔流转讨论留言UI层Facade类</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class UILMessageGetFacade extends Action{
  public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse
   ) throws Exception
    {
       
      String forward = "";
    try{
        MessageViewHelper messageViewHelper=new MessageViewHelper();
        //查看留言
        messageViewHelper.getMessage(httpServletRequest);
        forward = "result";
        //撰写留言和合并，防止改漏，留下原有查看留言接口
        if(httpServletRequest.getAttribute("prpLmessageDto1") == null){
        forward = "oldResult";
        }

      }

       catch (Exception e) {
          e.printStackTrace();
          forward="false";
       }

       finally {}

        
       System.out.println("forward"+forward);
       return actionMapping.findForward(forward);

    }

}
