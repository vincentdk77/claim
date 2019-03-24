package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.ui.control.action.UIMessageAction;
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
public class UILMessageFacade extends Action{
  public ActionForward execute(ActionMapping actionMapping,
                                 ActionForm actionForm,
                                 HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse
   ) throws Exception
    {
       
      String forward = "";
    try{
       // System.out.println("���Ա�����Կ�ʼ��������������������������");
        String context = httpServletRequest.getParameter("prpLmessageContext");

        httpServletRequest.setAttribute("prpLmessageContext", context);

        //��viewHelper�����������
        MessageViewHelper messageViewHelper = new MessageViewHelper();
        PrpLmessageDto prpLmessageDto = messageViewHelper.viewToDto(httpServletRequest);

        //System.out.println("������ʾ��������" +context);

        //��������

         //System.out.println("�鿴����!!!!"+httpServletRequest.getParameter("prpLmessageSave"));

        if(httpServletRequest.getParameter("prpLmessageSave")!=null){
            UIMessageAction uiMessageAction = new UIMessageAction();
            uiMessageAction.save(prpLmessageDto);

            forward = "success";
        }else {
             //�鿴����
             messageViewHelper.getMessage(httpServletRequest);
             forward = "false";
        }
      }

       catch (Exception e) {
          e.printStackTrace();
          forward="false";
       }

       finally {}

        
       System.out.println("forward"+forward);
       httpServletRequest.setAttribute("Content", "���Ա���ʧ�ܣ�");
       return actionMapping.findForward(forward);

    }

}
