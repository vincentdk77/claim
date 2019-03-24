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
 * <p>Title:������ת��������UI��Facade�� </p>
 * <p>Description: ������ת��������UI��Facade��</p>
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
        //�鿴����
        messageViewHelper.getMessage(httpServletRequest);
        forward = "result";
        //׫д���Ժͺϲ�����ֹ��©������ԭ�в鿴���Խӿ�
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
