package com.gyic.claim.ui.control.facade;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacadeBase;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowUWInterFaceFacade;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP Post 并案处理编辑界面
 * <p>
 * Title: 并案处理编辑界面
 * </p>
 * <p>
 * Description: 并案处理编辑界面
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author qianxiantao
 * @version 1.0
 */
public class UILCombineCompensateEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		    String forward = ""; // 向前流转
		try{
			String CombineNo=httpServletRequest.getParameter("combineNo");
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			String status=httpServletRequest.getParameter("status");
			UILCombineCompensateEditPostFacade combine=new UILCombineCompensateEditPostFacade();
			String[] businessNo=httpServletRequest.getParameterValues("combineBusinessNo");
		    for(int i=0;i<businessNo.length;i++){
				combine.combineSave(httpServletRequest,businessNo[i],status);
			}
		    user.setUserMessage(CombineNo);
		    ActionMessages messages = new ActionMessages();
		    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.submit"));	
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prplcombine.comboneNo"));
			saveMessages(httpServletRequest, messages);
		    forward="success";
		   }catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		}
		return actionMapping.findForward(forward);
	}
	public void combineSave(HttpServletRequest httpServletRequest,String businessNo,String status)throws Exception {
		
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
        String condition="";
        SwfLogDto swfLogDto1 =null;
        PrpLcompensateDto  compensateDto=null;
        BLCompensateFacade blComoensateFacade=new BLCompensateFacade();
        PrpLcompensateDto  compensateDto1= new PrpLcompensateDto();
	    String swfLogFlowID =""; // 工作流号码
        String swfLogLogNo = ""; // 工作流logno
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        BLPrpLcompensateFacadeBase compensateFacade=new BLPrpLcompensateFacadeBase();
		ArrayList arryList1=new ArrayList();
		if("0".equals(status)){
		    condition="claimNo='"+businessNo+"'";
		}else{
			condition="compensateNo='"+businessNo+"'";	
		}
		arryList1=(ArrayList)compensateFacade.findByConditions(condition);
		compensateDto=(PrpLcompensateDto)arryList1.get(0);
        condition="businessno='"+compensateDto.getCompensateNo()+"' and nodetype='compp'";
        compensateDto1=(PrpLcompensateDto)compensateFacade.findByPrimaryKey(compensateDto.getCompensateNo());
        BLSwfLogFacade swflogBase=new BLSwfLogFacade();
        ArrayList arryList=new ArrayList();
        arryList=(ArrayList)swflogBase.findByConditions(condition);
        swfLogDto1=(SwfLogDto)arryList.get(0);
        swfLogFlowID=swfLogDto1.getFlowID();
        swfLogLogNo=String.valueOf(swfLogDto1.getLogNo());
        int LogNo = Integer.parseInt(swfLogLogNo);
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		swfLogDtoDealNode.setBusinessNo(compensateDto.getCompensateNo());
		swfLogDtoDealNode.setNodeStatus("4");
		swfLogDtoDealNode.setNewMTask(-1);
		if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
			swfLogDtoDealNode.setFlowID(swfLogFlowID);
			swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils
					.nullToZero(swfLogLogNo)));
		}
		swfLogDtoDealNode.setNextBusinessNo(compensateDto.getClaimNo());
		swfLogDtoDealNode.setKeyIn(compensateDto.getClaimNo());
		swfLogDtoDealNode.setKeyOut(compensateDto.getCompensateNo());
		WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
		int vericLogNo = 0;
		if (workFlowViewHelper.checkDealDto(workFlowDto)) {
			// 增加对核保核赔系统的接口调用。
			if (swfLogDtoDealNode.getNodeStatus().equals("4")){
				// modify by lixiang start at 2006-08-22
				// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态。
				// 提交前的暂时保存
				WorkFlowDto workFlowDtoTemp = null;
				swfLogDtoDealNode.setNodeStatus("2");
				workFlowDtoTemp = workFlowViewHelper.viewToDto(user,
						swfLogDtoDealNode);
				// 暂存计算书节点时将理算节点状态置为已处理
				UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
						swfLogFlowID, LogNo);
				if (swfLogDto.getNodeType().equals("compe")) {
					swfLogDto.setNodeStatus("4");
					workFlowDtoTemp.setUpdate(true);
					workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
				}
				
				// 如果提交核赔失败则状态为0
				compensateDto.setUnderWriteFlag("0");
				blComoensateFacade.saveCombine(compensateDto1,workFlowDtoTemp);

				// 如果提交核赔则状态为9
				if (httpServletRequest.getParameter("buttonSaveType").equals("4")) {
					compensateDto.setUnderWriteFlag("9");
				}
				// modify by lixiang end at 2006-08-22
				if (workFlowDto.getSubmitSwfLogDtoList() != null&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
					vericLogNo = ((SwfLogDto) workFlowDto
							.getSubmitSwfLogDtoList().get(0))
							.getLogNo();
				}

				// add end 2005-10-19
				UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
				String UWflowID = uiWorkFlowUWInterFaceFacade
						.submitVericTask(workFlowDto
								.getUpdateSwfLogDto().getFlowID(),
								vericLogNo + "", "22", "C",
								compensateDto1.getCompensateNo(),
								compensateDto1.getRiskCode(),
								compensateDto1.getClassCode(),
								compensateDto1.getComCode(),
								compensateDto1.getHandlerCode(),
								compensateDto1.getMakeCom(), 
								user.getUserCode(),
								compensateDto1.getHandler1Code(), "");
				if (UWflowID.length() < 15) {
					String msg = "案件'" + compensateDto.getCompensateNo()
							+ "'提交双核系统失败，请重新提交或者与管理员联系!";
					throw new UserException(1, 3, "工作流", msg);
				}

				// add by lixiang start at 2006-08-22
				// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态，但是发送双核成功后，需要变更成提交数据。

			}
			// 此处修改理算节点状态，主要在理算暂存时使用。
			UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
			SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
					swfLogFlowID, LogNo);
			if (swfLogDto.getNodeType().equals("compe")) {
				swfLogDto.setNodeStatus("4");
				workFlowDto.setUpdate(true);
				workFlowDto.setUpdateSwfLog2Dto(swfLogDto);
			}
			blComoensateFacade.saveCombine(compensateDto1,workFlowDto);
		
	}
}
}