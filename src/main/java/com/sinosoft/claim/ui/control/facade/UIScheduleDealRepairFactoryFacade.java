package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLscheduleObjectFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 理赔调度节点的保存任务
 * <p>Title: 理赔调度节点的保存任务</p>
 * <p>Description: 理赔调度节点的保存任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */

public class UIScheduleDealRepairFactoryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     String forward  = "";
     try{
        String repairFactoryCode = httpServletRequest.getParameter("prplScheduleObjectRepairFactoryCode"); 
        String repairFactoryName = httpServletRequest.getParameter("prplScheduleObjectRepairFactoryName"); 
        UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
		

        PrpLscheduleObjectDto prpLscheduleObjectDto = new PrpLscheduleObjectDto();
        prpLscheduleObjectDto.setObjectArea("0000000000");
        prpLscheduleObjectDto.setObjectType("100");
        prpLscheduleObjectDto.setScheduleObjectName(repairFactoryName);
        prpLscheduleObjectDto.setScheduleObjectID(repairFactoryCode);
        prpLscheduleObjectDto.setComCode(userDto.getComCode());
	 BLPrpLscheduleObjectFacade blPrpLscheduleObjectFacade=new BLPrpLscheduleObjectFacade();
	 blPrpLscheduleObjectFacade.insert(prpLscheduleObjectDto);
      forward="success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }

    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }

    return actionMapping.findForward(forward);
  }

}

