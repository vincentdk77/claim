package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBackVisitAction;
import com.sinosoft.claim.ui.control.viewHelper.DAABackVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * �ַ�HTTP Post ��������طñ༭����
 * <p>Title: ��������طñ༭��Ϣ</p>
 * <p>Description: ��������طñ༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author ������Ŀ��
 * @version 1.0
 */

public class UILBackVisitEditPostFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

     String forward = "";          //��ǰ��ת
     String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
     String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
     String taskType=""; //�ǲ�����Ҫ�¼ӽڵ�
    try {
      if(isTokenValid(httpServletRequest,true)){
        //ȡ������
        String registNo=httpServletRequest.getParameter("prpLbackVisitRegistNo");

        //�Ƿ��ǵ�һ�β����ڵ�
        String newNode=httpServletRequest.getParameter("newNode");
        if (newNode!=null&&newNode.equals("true") ) taskType="T"  ;
        String nodeType=httpServletRequest.getParameter("fromNodeType");
        String typeFlag=httpServletRequest.getParameter("backVisitType"); //�鿱/����ط�
        

        //ȡ�û���Ϣ
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        String comCode   = user.getComCode() ;
        //����طñ���
        BackVisitDto backVisitDto =null;

        //��viewHelper����طý�������
        DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
        backVisitDto = dAABackVisitViewHelper.viewToDto(httpServletRequest);

        //����������ʼ
        //���±�����Ϣ����ȷ
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        swfLogDtoDealNode.setFlowID(swfLogFlowID);
        swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
        swfLogDtoDealNode.setNodeType("backv"); //�����½ڵ�Ϊbackv
        swfLogDtoDealNode.setTaskType(taskType); //T���͵Ľڵ�

        swfLogDtoDealNode.setNodeStatus(httpServletRequest.getParameter("buttonSaveType"));
        swfLogDtoDealNode.setNextBusinessNo(registNo);
        swfLogDtoDealNode.setKeyIn(registNo);
        swfLogDtoDealNode.setKeyOut(registNo);
        
         swfLogDtoDealNode.setTypeFlag(typeFlag);
         System.out.println("typeFlag"+typeFlag+"taskType"+taskType+"swfLogDtoDealNode.getNodeStatus"+swfLogDtoDealNode.getNodeStatus()
         +"swfLogDtoDealNode.getFlowID"+swfLogDtoDealNode.getFlowID()
         +"swfLogDtoDealNode.getLogNo"+swfLogDtoDealNode.getLogNo());
        
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        //�������������

        //����ط���Ϣ��ʼ

        UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();

        if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
        { 
           uiBackVisitAction.save(backVisitDto,workFlowDto);
            user.setUserMessage(backVisitDto.getPrpLbackVisitDto().getRegistNo());

        }else
        {
            uiBackVisitAction.save(backVisitDto);
            user.setUserMessage(backVisitDto.getPrpLbackVisitDto().getRegistNo()+";ע��:û�з����빤������������κ����ݣ���");
        }
        //����ط���Ϣ����
      }

      ActionMessages messages = new ActionMessages();
      if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.backv.submit"));
      }else {
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.backv.save"));
      }
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
      saveMessages( httpServletRequest, messages );
      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("�ط���Ϣ¼��");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("�ط���Ϣ¼��");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("�ط���Ϣ¼��");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally {

    }

    return actionMapping.findForward(forward);
  }

}
