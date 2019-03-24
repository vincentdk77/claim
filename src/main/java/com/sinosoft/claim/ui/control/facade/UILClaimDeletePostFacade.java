package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * �ַ�HTTP GET ������������
 * <p>Title: ��������������������</p>
 * <p>Description: ��������������������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */

public class UILClaimDeletePostFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     

    //ҵ�����ͣ���������
    //�ⰸ����
    String bessinessNo = httpServletRequest.getParameter("bussinessNo") ;
    String registNo= httpServletRequest.getParameter("claimRegistNo") ;
    //��������ѯȷ��Ҫ�ñ����ĺ��롣������������

    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
     HttpSession session = httpServletRequest.getSession();
    //��ֹ�û��ظ��ύ
    String userLastActionNow="deleteclaim?"+bessinessNo;
    String condtions=httpServletRequest.getParameter("queryCondtions") ;
    String forward  = "";    //��ǰ
    try
    {
       UserDto user     = (UserDto)session.getAttribute("user");
       String msg="";
      //System.out.println("�ظ�ˢ�¡�����"+user.getUserLastAction());
       if (userLastActionNow.equals(user.getUserLastAction() ) )
       {
            System.out.println("�ظ�ˢ�¡�������ֹ�ظ��ύ");
            //��ֹ�ظ��ύ
       }else
       {
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            UIClaimAction uiClaimAction = new UIClaimAction();
            //��ѯ�ǲ����й�����������
            Collection swfFlowNodeList = new ArrayList();
            SwfLogDto swfLogDto =new SwfLogDto();
            swfFlowNodeList = uiWorkFlowAction.findCurrentNode(registNo, "claim");

         if (swfFlowNodeList.iterator().hasNext()) {
           //��õ�ǰ�������̵���Ϣ
           swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
           swfLogDto.setFlowStatus("1");//δ��ռ��
           swfLogDto.setNodeStatus("0"); //δ����
           swfLogDto.setHandlerCode("");
           swfLogDto.setHandlerName("");

           //����ɾ���������ڵ��ˣ�Ӧ���ǰѹ��������Ǹ��ڵ���û����ȽϺá�
           WorkFlowDto workFlowDto = new WorkFlowDto();
           workFlowDto.setUpdate(true);
           workFlowDto.setUpdateSwfLogDto(swfLogDto);
           System.out.println("workFlowDto.setUpdateSwfLogDto(swfLogDto);="+swfLogDto.getFlowID() ) ;
           uiClaimAction.delete(bessinessNo,workFlowDto);
         }
         else
         {
             uiClaimAction.delete(bessinessNo);
         }
         msg="ҵ���Ϊ'"+bessinessNo+"'�İ��������ɹ�!";
         }
        //ҳ��ˢ����ʾ:
        //��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
        user.setUserLastAction(userLastActionNow);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setAlertMessage(msg);
        httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;

        forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.queryEndcase");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.queryEndcase");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
   // System.out.println("%%%%%%%%%IWorkFlowLogQueryEditGetFacade forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
