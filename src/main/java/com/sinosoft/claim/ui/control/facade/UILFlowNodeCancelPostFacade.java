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

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;



/**
 * 分发HTTP Post 流程节点注销界面信息
 * <p>Title: 车险流程节点注销界面信息</p>
 * <p>Description: 车险流程节点注销界面信息保存</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author sinosoft
 * @version 1.0
 */

public class UILFlowNodeCancelPostFacade
extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

    String forward = ""; //向前流转

    try {
       
       //取得当前用户信息
       UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
       
        //以下为工作流使用中的
        //得到流程编号
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID");
        String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo");
        String registNo=httpServletRequest.getParameter("RegistNo");
        String editType=httpServletRequest.getParameter("editType");
        //保存立案拒赔注销信息
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
       
       
        if (swfLogFlowID==null || swfLogLogNo==null||swfLogFlowID.equals("null")||swfLogLogNo.equals("null"))
        {  String msg="案件'"+registNo+"'没发现可以注销的定损任务!";
            throw new UserException(1,3,"定损任务注销",msg);
	 }
        System.out.println(swfLogFlowID+"|"+swfLogLogNo);
        swfLogDtoDealNode=uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)) );
        
        if (swfLogDtoDealNode==null){
        	 String msg="案件'"+registNo+"'没发现可以注销的定损任务2!";
             throw new UserException(1,3,"定损任务注销",msg);
        }
        
        if ("ScheduleCancel".equals( editType)){
        	//需要检查撤消的定损是不是调度中唯一的一个定损，如果是的话，不可以注销的。。
        	//检查边
        	String strSql = "flowid='"+swfLogFlowID+"' and nodestatus<'5' "
			               +" and nodeType in ('certa','wound','propc')";
        	int count = uiWorkFlowAction.findFlowNodeCountByConditon( strSql);
        	
        	if (count==1){
        		//如果是唯一调度出去的任务。判断调度中还存在没有调度出去的吗？
        		 strSql=" registno='"+registNo+"' and surveyTimes<1";
	                UIScheduleAction uiScheduleAction = new UIScheduleAction();
	                int schedulecount =uiScheduleAction.findScheduleItemCountByConditon(strSql);
	                //只有唯一的一个定损任务，所以就是不能让取消！！
	                if (schedulecount<1){
	                	 String msg="案件'"+registNo+"'中，仅剩此唯一的定损任务，所以不能注销!";
	                     throw new UserException(1,3,"定损任务注销",msg);
	               
	                }
	         
        	}
        }
        WorkFlowDto workFlowDto = new WorkFlowDto();
        workFlowDto.setUpdate( true);
        swfLogDtoDealNode.setNodeStatus( "6");
        String context=httpServletRequest.getParameter("contextInnerHTML");
        String tempStr="@用户:"+user.getUserName()+"执行了注销操作，原因："+context; 
        swfLogDtoDealNode.setTitleStr(swfLogDtoDealNode.getTitleStr() +tempStr);
        workFlowDto.setUpdateSwfLogDto(swfLogDtoDealNode);
        //保存报案注销信息并查找工作流程

        if (workFlowViewHelper.checkDealDto(workFlowDto))
        {
        	uiWorkFlowAction.deal( workFlowDto);
        }

       ActionMessages messages = new ActionMessages();
       ActionMessage message;
       message = new ActionMessage("");
       user.setUserMessage("定损注销保存成功");
       messages.add( ActionMessages.GLOBAL_MESSAGE, message );
       saveMessages( httpServletRequest, messages );
      
       forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("报案注销");
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
      ActionError error = new ActionError("报案注销");
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
      ActionError error = new ActionError("报案注销");
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
