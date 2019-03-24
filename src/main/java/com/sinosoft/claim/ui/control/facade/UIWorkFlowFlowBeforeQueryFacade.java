package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.claim.dto.custom.UserDto;

/**
 * 分发HTTP GET 工作流流程查询
 * <p>Title: 工作流流程查询</p>
 * <p>Description: 工作流流程查询</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIWorkFlowFlowBeforeQueryFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		//业务类型：ADD-新增  EDIT-修改  SHOW-显示

		String forward = ""; //向前
		String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //业务号
		//支付环节通过报案号链接查询相关工作流程图 add by chu 20130828
		if(swfLogFlowID==null||"".equals(swfLogFlowID)){
			String rigistNo = httpServletRequest.getParameter("registNo");
			Collection collection = new BLSwfLogFacade().findByConditions(" registNo='"+rigistNo+"'");
			if(collection==null||collection.isEmpty()){
				collection= new BLSwfLogStoreFacade().findByConditions(" registNo='"+rigistNo+"'");
			}
			if(collection!=null&&!collection.isEmpty()){
				SwfLogDto swfLogDto =  (SwfLogDto) collection.iterator().next();
				swfLogFlowID = swfLogDto.getFlowID();
			}
		}
		
		UserDto ecmUser = new UserDto();
		
		ecmUser.setComCode(httpServletRequest.getParameter("comCodeEcm"));
		ecmUser.setUserName(httpServletRequest.getParameter("userNameEcm"));
		ecmUser.setUserCode(httpServletRequest.getParameter("userCodeEcm"));
		ecmUser.setComName(httpServletRequest.getParameter("comNameEcm"));
		
		httpServletRequest.setAttribute("userEcm", ecmUser);
		//判断IE版本是否支持svg
		httpServletRequest.setAttribute("svgFlag", httpServletRequest.getParameter("svgFlag"));
		System.out.println("========"+httpServletRequest.getParameter("svgFlag"));
		//支付环节通过报案号链接查询相关工作流程图 add by chu 20130828 end
		try {

			//根据报案号查询工作流程信息
			
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			workFlowViewHelper.setFlowDtoToView(httpServletRequest,
					swfLogFlowID);	
			
		/*	//added by zhangli 20070424 增加工作流中有关支付的信息框，非节点			
			//拿到policyNo********“compensatePolicyNo”*********
			
			
			String policyNo = "";			
			String registNo = (String)httpServletRequest.getAttribute("registNo");		
			 com.sinosoft.claim.ui.control.action.UIRegistAction uIRegistAction = 
				 new  com.sinosoft.claim.ui.control.action.UIRegistAction();
			 RegistDto registDto = uIRegistAction.findByPrimaryKey(registNo);
			 policyNo = registDto.getPrpLclaimStatusDto().getPolicyNo();
			//拿到被保险人名称********“”**********
			String insuredName = uiCompensateAction.fetchInsuredName(policyNo);
			httpServletRequest.setAttribute("compensateInsuredName", insuredName);
			
			//拿到是否赔款以及赔款总金额			
			double realPayreffee =
				uiCompensateAction.compensatePaymentResult(httpServletRequest, registNo,policyNo);			   
			//判断是未支付还是已支付 ******“payed”******
			if(realPayreffee>0){
				httpServletRequest.setAttribute("payed","true" );
			}
			 
			//判断赔款总金额 *****“realPayreffee”****
			httpServletRequest.setAttribute("realPayreffee", Double.toString(realPayreffee));
			//拿到赔款的最后支付日期******* “compensatePayDate”********
			String compensateFinalPayDate = uiCompensateAction.fetchPayCompensateFinalDate(registNo,policyNo);
			httpServletRequest.setAttribute("compensatePayDate", compensateFinalPayDate);*/
			forward = "success";
			System.out.println("forward=" + forward);
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (Exception e) {
			e.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
