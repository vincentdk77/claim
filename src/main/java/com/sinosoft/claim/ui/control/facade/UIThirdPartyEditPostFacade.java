
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

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.ThirdPartyViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

 

/**
 * �ַ�HTTP Post �����������߳�������
 * <p>Title: �������ⱨ�����߳�����Ϣ</p>
 * <p>Description: �������ⱨ�����߳�����Ϣ</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class UIThirdPartyEditPostFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    String forward  = "";                                          //��ǰ��ת
    forward = "success";
    
    try {
        //�鿱��
        String checkNo = ""; //�鿱��
        checkNo = httpServletRequest.getParameter("businessNo");
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        String comCode=user.getComCode() ;
        httpServletRequest.setAttribute("registNo", checkNo);
      
        String editType = httpServletRequest.getParameter("editType");
        String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
        String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno

    
       //��viewHelper�����������
       //���������ߣ����������������ݽ��зֱ����������
        ThirdPartyViewHelper thirdPartyViewHelper = new ThirdPartyViewHelper();
        CheckDto checkDto = thirdPartyViewHelper.viewToDto(httpServletRequest);
        //������������Ϣ,���������ĵ��ȱ�����ڴ����״̬
//      ����鿱��Ϣ
        UICheckAction uiCheckAction = new UICheckAction();
        
        if (checkDto.getNewScheduleItem()) //�������ӵı����Ϣ
        {
        //��Ҫ���¹�������״̬�ȵ���Ϣ
        int logNo=0;
        logNo=Integer.parseInt( DataUtils.nullToZero(swfLogLogNo));
        WorkFlowDto workFlowDto = new WorkFlowDto();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        SwfLogDto  swfLogDto= uiWorkFlowAction.findNodeByPrimaryKey( swfLogFlowID,logNo);
        if (swfLogDto!=null){
        //���µ���	
           swfLogDto.setNodeStatus("2");
           //swfLogDto.setLossItemName( checkDto.getScheduleItemNote() );
           
           workFlowDto.setUpdate( true);
           workFlowDto.setUpdateSwfLog2Dto(swfLogDto );
           
           if (workFlowDto.getSubmit() ) workFlowDto.setSubmit(false);
           uiCheckAction.saveScheduleAddCertainLoss(checkDto,workFlowDto);
        
           
           String commiFlag = httpServletRequest.getParameter("commiFlag");  //add by liyanjie 2005-12-17 start˫����־
            String scheduleRef="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo="
            +checkNo
            +"&prpLscheduleMainWFScheduleID=1"
            +"&status=2"
            +"&scheduleType=sched"
			+"&editType=ADD"
			+"&swfLogFlowID="+swfLogFlowID
			+"&swfLogLogNo="+swfLogLogNo
			+"&nodeType=sched"
			+"&riskCode=DAA"
			+"&handleDept"+swfLogDto.getHandleDept()
			+"&endflag="+swfLogDto.getEndFlag() 
			+"&commiFlag="+commiFlag;  //add by liyanjie 2005-12-17 start˫����־
          httpServletResponse.sendRedirect(scheduleRef);
         }
        }else{
          uiCheckAction.saveScheduleAddCertainLoss(checkDto);
          String checkSaveMessage = "q"+checkNo;
          ActionMessages messages = new ActionMessages();
          Object obj_msg = checkSaveMessage;
          messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.save"));
          saveMessages( httpServletRequest, messages );
          forward = "success";
          
        }
      }
      catch(UserException usee)
      {
        usee.printStackTrace() ;
        //������Ϣ����
        ActionErrors errors = new ActionErrors();
        ActionError error = new ActionError("title.registBeforeEdit.editRegist");
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
        ActionError error = new ActionError("title.registBeforeEdit.editRegist");
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
        ActionError error = new ActionError("title.registBeforeEdit.editRegist");
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
