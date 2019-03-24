package com.sinosoft.workrove.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.action.domain.BLPrpLpersonTraceAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleItemAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleMainWFAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPartyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPropAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleItemFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleMainWFFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPropFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.bl.facade.BLWorkRoveFacade;
import com.sinosoft.workrove.dto.formbean.WorkRoveDto;
import com.sinosoft.workrove.dto.formbean.WorkRoveForm;
import com.sinosoft.workrove.ui.control.viewHelper.CoincareOfWorkViewHelper;

/**
 * 分发HTTP Post 车险理赔工作转交处理Action
 * <p>
 * Title: 车险理赔工作转交处理Action
 * </p>
 * <p>
 * Description: 车险理赔工作转交处理Action
 * </p>
 * <p>
 * Copyright: Copyright (c) 2011
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author zhangjs
 * @version 1.0
 */
public class UILCoincareOfWorkEditPostFacade extends Action {
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		String forward ="success";
		try {
			BLWorkRoveFacade workRoveFacade = new BLWorkRoveFacade();
			CoincareOfWorkViewHelper viewHelper = new CoincareOfWorkViewHelper(); 
			WorkRoveForm workRoveForm = (WorkRoveForm)actionForm;
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			
			//1 整理数据 
			//1.1 
			WorkRoveDto workRoveDto = viewHelper.formToDto(user,workRoveForm);
			//1.2  工作流数据
			WorkFlowDto workFlowDto = viewHelper.formToWorkFlowDto(user,workRoveForm);
			
			//2 保存数据
			workRoveFacade.save(workRoveDto, workFlowDto);
			
			//3查勘任务转交时，更新定损节点处理部门信息
			workRoveFacade.updateSwflogForCerta(workRoveForm);
			
			//3返回给 客户端一个正确的值
			httpServletRequest.setAttribute("saveRedirect","success");
			httpServletRequest.setAttribute("context", workRoveForm.getContext());

		} catch (Exception e) {
			//1打印错误的堆栈信息
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			
			//2 返回给客户端一个错误的值(这个很重要)
			httpServletRequest.setAttribute("saveRedirect","error");
		}finally{
			//无论异常与否都应该处理的，（暂时没有）
		}
		
		
		//无论异常与否，都返回到转交的页面，只是如果有异常参数saveRedirect为errot否则为true
		return actionMapping.findForward(forward);
	}
}
