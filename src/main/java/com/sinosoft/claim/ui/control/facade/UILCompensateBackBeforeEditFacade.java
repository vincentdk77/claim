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
 * �ַ�HTTP GET ��������ʵ���˻ض���ǰ��ѯ��������
 * <p>
 * Title: ��������ʵ���˻ض���ǰ��ѯ������Ϣ
 * </p>
 * <p>
 * Description: ��������ʵ���˻ض���ǰ��ѯ������Ϣϵͳ��������
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
		
		//ҵ�����ͣ���ѯ��ǰ�����⴦�����
		
		String editType = httpServletRequest.getParameter("editType");
		String claimNo = httpServletRequest.getParameter("claimNo"); //�ⰸ��
		String registNo = httpServletRequest.getParameter("registNo"); //������
		String policyNo = httpServletRequest.getParameter("policyNo"); //������
		String flowId = httpServletRequest.getParameter("swfLogFlowID");//��ǰ����������
		String logNo=httpServletRequest.getParameter("swfLogLogNo");//��ǰ����������
		String forward = ""; //��ǰ
		
		try {
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");

			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
			
			SwfLogDto swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowId,Integer.parseInt(DataUtils.nullToZero(logNo)));
			 WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			//����ǲ���ǰ������̶��Ѿ������ˣ����Բ����������ˡ�	
			workFlowViewHelper.checkNodeSubmit(swfLogDto);
			Collection swfList = uiWorkFlowAction.findNodesByConditions("registNo='" + registNo + "' and nodeType='compp' and flowstatus != '0'");
			if(swfList !=null && swfList.size() > 0){
				throw new UserException(1,3,"������","�˱��������������鲻�������!");
			}
			UICodeAction uiCodeAction = new UICodeAction();
			
			PrpLverifyLossDto prpLverifyLossDto= new PrpLverifyLossDto();
			PrpLcompensateDto prpLcompensateDto =new PrpLcompensateDto ();
			String conditions="";
			//���Ȳ�ѯ�����������
			UICompensateAction uiCompensateAction= new UICompensateAction();
			conditions = "claimNo='"+claimNo+"'";
			Collection compensateList =uiCompensateAction.findByClaimNo(conditions);
			prpLcompensateDto.setCompensateList(compensateList);
			
			
			
			//�ٴβ�ѯ��������
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
			prpLverifyLossDto.setFlag("1");//1�ǿ��Ի��˵�
//			�жϺ������
			if (compensateList!=null){
				conditions = "claimNo='"+claimNo+"' and underwriteflag in('1','3','9')";
				Collection compensateListTemp =uiCompensateAction.findByClaimNo(conditions);
				if (compensateListTemp!=null&&compensateListTemp.size() >0){
					//�����Խ�������Ļ��ˡ�����Ϊ�Ѿ����ύ�����������
					prpLverifyLossDto.setFlag("0"); //�����Ի���
				}
			}
			
			
			//�����˻����
			Collection compensateBackOptionsList =ICollections.getCompensateBackList();
			httpServletRequest.setAttribute("compensateBackOptionsList",compensateBackOptionsList);
			
			httpServletRequest.setAttribute("prpLverifyLossDto",prpLverifyLossDto);
			httpServletRequest.setAttribute("prpLcompensateDto",prpLcompensateDto);
			
			
			//ȡ��forward
			forward = "success";
			
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			//������Ϣ����
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