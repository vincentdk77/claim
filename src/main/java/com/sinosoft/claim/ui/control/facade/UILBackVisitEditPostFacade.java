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
 * 分发HTTP Post 车险理赔回访编辑界面
 * <p>Title: 车险理赔回访编辑信息</p>
 * <p>Description: 车险理赔回访编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author 理赔项目组
 * @version 1.0
 */

public class UILBackVisitEditPostFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

     String forward = "";          //向前流转
     String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
     String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
     String taskType=""; //是不是需要新加节点
    try {
      if(isTokenValid(httpServletRequest,true)){
        //取报案号
        String registNo=httpServletRequest.getParameter("prpLbackVisitRegistNo");

        //是否是第一次产生节点
        String newNode=httpServletRequest.getParameter("newNode");
        if (newNode!=null&&newNode.equals("true") ) taskType="T"  ;
        String nodeType=httpServletRequest.getParameter("fromNodeType");
        String typeFlag=httpServletRequest.getParameter("backVisitType"); //查勘/定损回访
        

        //取用户信息
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        String comCode   = user.getComCode() ;
        //定义回访变量
        BackVisitDto backVisitDto =null;

        //用viewHelper整理回访界面输入
        DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
        backVisitDto = dAABackVisitViewHelper.viewToDto(httpServletRequest);

        //工作流处理开始
        //以下保存信息不明确
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        swfLogDtoDealNode.setFlowID(swfLogFlowID);
        swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
        swfLogDtoDealNode.setNodeType("backv"); //设置新节点为backv
        swfLogDtoDealNode.setTaskType(taskType); //T类型的节点

        swfLogDtoDealNode.setNodeStatus(httpServletRequest.getParameter("buttonSaveType"));
        swfLogDtoDealNode.setNextBusinessNo(registNo);
        swfLogDtoDealNode.setKeyIn(registNo);
        swfLogDtoDealNode.setKeyOut(registNo);
        
         swfLogDtoDealNode.setTypeFlag(typeFlag);
         System.out.println("typeFlag"+typeFlag+"taskType"+taskType+"swfLogDtoDealNode.getNodeStatus"+swfLogDtoDealNode.getNodeStatus()
         +"swfLogDtoDealNode.getFlowID"+swfLogDtoDealNode.getFlowID()
         +"swfLogDtoDealNode.getLogNo"+swfLogDtoDealNode.getLogNo());
        
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        //工作流处理结束

        //保存回访信息开始

        UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();

        if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
        { 
           uiBackVisitAction.save(backVisitDto,workFlowDto);
            user.setUserMessage(backVisitDto.getPrpLbackVisitDto().getRegistNo());

        }else
        {
            uiBackVisitAction.save(backVisitDto);
            user.setUserMessage(backVisitDto.getPrpLbackVisitDto().getRegistNo()+";注意:没有发现与工作流流程相关任何数据！！");
        }
        //保存回访信息结束
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
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("回访信息录入");
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
      ActionError error = new ActionError("回访信息录入");
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
      ActionError error = new ActionError("回访信息录入");
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
