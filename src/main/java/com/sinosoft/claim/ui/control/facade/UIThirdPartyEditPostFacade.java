
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
 * 分发HTTP Post 车险理赔三者车辆保存
 * <p>Title: 车险理赔报案三者车辆信息</p>
 * <p>Description: 车险理赔报案三者车辆信息</p>
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
     
    String forward  = "";                                          //向前流转
    forward = "success";
    
    try {
        //查勘号
        String checkNo = ""; //查勘号
        checkNo = httpServletRequest.getParameter("businessNo");
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        String comCode=user.getComCode() ;
        httpServletRequest.setAttribute("registNo", checkNo);
      
        String editType = httpServletRequest.getParameter("editType");
        String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
        String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno

    
       //用viewHelper整理界面输入
       //区分是三者，或者是主车的内容进行分别的数据整理
        ThirdPartyViewHelper thirdPartyViewHelper = new ThirdPartyViewHelper();
        CheckDto checkDto = thirdPartyViewHelper.viewToDto(httpServletRequest);
        //整理工作流的信息,将工作流的调度变成正在处理的状态
//      保存查勘信息
        UICheckAction uiCheckAction = new UICheckAction();
        
        if (checkDto.getNewScheduleItem()) //有新增加的标的信息
        {
        //需要更新工作流的状态等等信息
        int logNo=0;
        logNo=Integer.parseInt( DataUtils.nullToZero(swfLogLogNo));
        WorkFlowDto workFlowDto = new WorkFlowDto();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        SwfLogDto  swfLogDto= uiWorkFlowAction.findNodeByPrimaryKey( swfLogFlowID,logNo);
        if (swfLogDto!=null){
        //更新调度	
           swfLogDto.setNodeStatus("2");
           //swfLogDto.setLossItemName( checkDto.getScheduleItemNote() );
           
           workFlowDto.setUpdate( true);
           workFlowDto.setUpdateSwfLog2Dto(swfLogDto );
           
           if (workFlowDto.getSubmit() ) workFlowDto.setSubmit(false);
           uiCheckAction.saveScheduleAddCertainLoss(checkDto,workFlowDto);
        
           
           String commiFlag = httpServletRequest.getParameter("commiFlag");  //add by liyanjie 2005-12-17 start双代标志
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
			+"&commiFlag="+commiFlag;  //add by liyanjie 2005-12-17 start双代标志
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
        //错误信息处理
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
        //错误信息处理
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
        //错误信息处理
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
