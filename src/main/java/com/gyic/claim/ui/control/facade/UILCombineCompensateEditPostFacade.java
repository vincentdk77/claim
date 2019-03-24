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
 * �ַ�HTTP Post ��������༭����
 * <p>
 * Title: ��������༭����
 * </p>
 * <p>
 * Description: ��������༭����
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
		    String forward = ""; // ��ǰ��ת
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
			// ������Ϣ����
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
	    String swfLogFlowID =""; // ����������
        String swfLogLogNo = ""; // ������logno
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
			// ���ӶԺ˱�����ϵͳ�Ľӿڵ��á�
			if (swfLogDtoDealNode.getNodeStatus().equals("4")){
				// modify by lixiang start at 2006-08-22
				// reason:ֱ�ӱ���ҵ�����ݵ��¹��������ݶ�ʧ�������ύǰ��Ҫ��ʱ���浽���ڴ����״̬��
				// �ύǰ����ʱ����
				WorkFlowDto workFlowDtoTemp = null;
				swfLogDtoDealNode.setNodeStatus("2");
				workFlowDtoTemp = workFlowViewHelper.viewToDto(user,
						swfLogDtoDealNode);
				// �ݴ������ڵ�ʱ������ڵ�״̬��Ϊ�Ѵ���
				UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(
						swfLogFlowID, LogNo);
				if (swfLogDto.getNodeType().equals("compe")) {
					swfLogDto.setNodeStatus("4");
					workFlowDtoTemp.setUpdate(true);
					workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
				}
				
				// ����ύ����ʧ����״̬Ϊ0
				compensateDto.setUnderWriteFlag("0");
				blComoensateFacade.saveCombine(compensateDto1,workFlowDtoTemp);

				// ����ύ������״̬Ϊ9
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
					String msg = "����'" + compensateDto.getCompensateNo()
							+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
					throw new UserException(1, 3, "������", msg);
				}

				// add by lixiang start at 2006-08-22
				// reason:ֱ�ӱ���ҵ�����ݵ��¹��������ݶ�ʧ�������ύǰ��Ҫ��ʱ���浽���ڴ����״̬�����Ƿ���˫�˳ɹ�����Ҫ������ύ���ݡ�

			}
			// �˴��޸�����ڵ�״̬����Ҫ�������ݴ�ʱʹ�á�
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