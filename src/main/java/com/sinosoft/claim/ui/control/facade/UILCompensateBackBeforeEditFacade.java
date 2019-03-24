package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 车险理赔实赔退回定损前查询保单请求
 * <p>
 * Title: 车险理赔实赔退回定损前查询保单信息
 * </p>
 * <p>
 * Description: 车险理赔实赔退回定损前查询保单信息系统样本程序
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0  
 */
public class UILCompensateBackBeforeEditFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		
		//业务类型：查询当前的理赔处理情况
		
		String editType = httpServletRequest.getParameter("editType");
		String claimNo = httpServletRequest.getParameter("claimNo"); //赔案号
		String registNo = httpServletRequest.getParameter("registNo"); //报案号
		String policyNo = httpServletRequest.getParameter("policyNo"); //保单号
		String flowId = httpServletRequest.getParameter("swfLogFlowID");//当前工作流号码
		String logNo=httpServletRequest.getParameter("swfLogLogNo");//当前工作流号码
		String forward = ""; //向前
		
		try {
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");

			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
			
			SwfLogDto swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowId,Integer.parseInt(DataUtils.nullToZero(logNo)));
			 WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			//检查是不是前面的流程都已经结束了，可以操作计算书了。	
			workFlowViewHelper.checkNodeSubmit(swfLogDto);
			Collection swfList = uiWorkFlowAction.findNodesByConditions("registNo='" + registNo + "' and nodeType='compp' and flowstatus != '0'");
			if(swfList !=null && swfList.size() > 0){
				throw new UserException(1,3,"工作流","此报案已做过理算书不允许回退!");
			}
			UICodeAction uiCodeAction = new UICodeAction();
			
			PrpLverifyLossDto prpLverifyLossDto= new PrpLverifyLossDto();
			PrpLcompensateDto prpLcompensateDto =new PrpLcompensateDto ();
			String conditions="";
			//首先查询计算书情况：
			UICompensateAction uiCompensateAction= new UICompensateAction();
			conditions = "claimNo='"+claimNo+"'";
			Collection compensateList =uiCompensateAction.findByClaimNo(conditions);
			prpLcompensateDto.setCompensateList(compensateList);
			
			
			
			//再次查询定损的情况
			UIVerifyLossAction uiVerifyLossAction =new UIVerifyLossAction ();
			conditions="registNo='"+registNo+"'";
			Collection verifyLossList =uiVerifyLossAction.findByConditions(conditions);
			
			prpLverifyLossDto.setVerifyLossList(verifyLossList );
			
			prpLverifyLossDto.setClaimNo( claimNo);
			prpLverifyLossDto.setRegistNo( registNo);
			prpLverifyLossDto.setPolicyNo( policyNo);
			prpLverifyLossDto.setCompensateApproverCode(user.getUserCode() );
			prpLverifyLossDto.setCompensateApproverName(user.getUserName() );
			prpLverifyLossDto.setCompensateBackDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ));
			prpLverifyLossDto.setFlag("1");//1是可以回退的
//			判断核赔情况
			if (compensateList!=null){
				conditions = "claimNo='"+claimNo+"' and underwriteflag in('1','3','9')";
				Collection compensateListTemp =uiCompensateAction.findByClaimNo(conditions);
				if (compensateListTemp!=null&&compensateListTemp.size() >0){
					//不可以进行理算的会退·！因为已经有提交核赔的数据了
					prpLverifyLossDto.setFlag("0"); //不可以回退
				}
			}
			
			
			//理算退回意见
			Collection compensateBackOptionsList =ICollections.getCompensateBackList();
			httpServletRequest.setAttribute("compensateBackOptionsList",compensateBackOptionsList);
			
			httpServletRequest.setAttribute("prpLverifyLossDto",prpLverifyLossDto);
			httpServletRequest.setAttribute("prpLcompensateDto",prpLcompensateDto);
			
			
			//取得forward
			forward = "success";
			
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.titleName");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
		} 
		return actionMapping.findForward(forward);
	}
	
}