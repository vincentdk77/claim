package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP Post ��������ʵ��༭����
 * <p>
 * Title: ��������ʵ��༭������Ϣ
 * </p>
 * <p>
 * Description: ��������ʵ��༭������Ϣ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILCompensateBackEditPostFacade extends Action {
	public ActionForward execute(
			ActionMapping actionMapping, 
			ActionForm actionForm,
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) throws Exception {
		   String forward = ""; //��ǰ��ת
		try {
			//����˼·:
			//---------------------------------------------------
			//����ǵ�һ�α��棬ֻҪ�ܽ�״̬������ڴ�������ˡ���
			//�������������ڴ����״̬������д����ˡ�
			//---------------------------------------------------
			//ȡ���������
			String compensateNo = ""; //���������
			String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
			String claimNo= httpServletRequest.getParameter("prpLverifyLossClaimNoShow"); //claimNo
			String lossItemCode[]=httpServletRequest.getParameterValues("lossitemCode"); //lossitemCode
			String nodeType[]=httpServletRequest.getParameterValues("nodeType"); //nodeType
			String checked[]=httpServletRequest.getParameterValues("selectCerta"); //lossitemCode
			String compensateOpinion = httpServletRequest.getParameter("compensateOpinion");
			String haveCompensate = httpServletRequest.getParameter("haveCompensate");
			
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
			
			SwfLogDto swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,Integer.parseInt(DataUtils.nullToZero((String)httpServletRequest.getParameter("swfLogLogNo"))));
			if (swfLogDto==null){
				throw new UserException(1, 3, "������", "δ��ѯ����Ҫ����Ĺ���������");
			}
			
			if (Integer.parseInt(DataUtils.nullToZero(swfLogDto.getNodeStatus()))>3){//throw new Exception("@@@@@@@@@@@@@@@@@�벻Ҫ�ύ");
				throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
			}
			 WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			
			UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
			//��������ɾ���͹�������������һ��workflow���������
			UICompensateAction uiCompensateAction = new UICompensateAction();
			//ģ��������ύ���ύ����ͬ�Ķ��𣬵�����󽫲鿱�����滻�����������
			//�����õ�ǰ��Ҫ����Ľڵ�Ϊ��Ҫ�˻صĶ���
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			 swfLogDtoDealNode.setFlowID(swfLogDto.getFlowID() );
			 swfLogDtoDealNode.setLogNo(swfLogDto.getLogNo() );
			 swfLogDtoDealNode.setNodeStatus( "5");
			 //�����б�
		     Collection nextNodeList = new ArrayList();      
		     String conditions="";
		     String nowNodeType="";
		     String nowLossItemCode="";
			 for (int i=1;i<checked.length ;i++){
			 	nowNodeType=DataUtils.nullToEmpty(nodeType[i]);
			 	nowLossItemCode=DataUtils.nullToEmpty(lossItemCode[i]);
			 	if (checked[i].equals( "1")){
			 		conditions=" flowId='"+swfLogDto.getFlowID() +"' and nodeType='"
					          +nowNodeType+"' and lossItemCode='"+nowLossItemCode
							  +"' order by logNo desc";
			 		System.out.println(conditions);
			 		//ȡ�ö�������һ�εĲ����������ڵ�
			 		ArrayList SwfLogTempList  = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions);
			 		if (SwfLogTempList==null||SwfLogTempList.size() <1) continue;
			 		SwfLogDto swfLogNextNode = ( SwfLogDto)SwfLogTempList.iterator().next() ;
			 		nextNodeList.add(swfLogNextNode );
			 	}
			 }
			 if (nextNodeList.size() >0){
			 	swfLogDtoDealNode.setNextNodeListType("1");
			 	swfLogDtoDealNode.setSwfLogList(nextNodeList );
			 }
			
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
		    PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		    prpLverifyLossDto.setCompensateApproverCode(user.getUserCode() );
		    prpLverifyLossDto.setCompensateBackDate(new DateTime(DateTime.current() ,DateTime.YEAR_TO_DAY ));
		    prpLverifyLossDto.setCompensateOpinion(compensateOpinion);
		    prpLverifyLossDto.setFlowID( swfLogDto.getFlowID());
			//
			uiCompensateAction.backToCerta(claimNo,workFlowDto,prpLverifyLossDto);
			user.setUserMessage(claimNo);
			ActionMessages messages = new ActionMessages();
        	messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.save"));
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.claimNo"));
			saveMessages(httpServletRequest, messages);
			forward = "success";
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} 
    return actionMapping.findForward(forward);
	}
}

