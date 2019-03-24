package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

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
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.SpecialCaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.ui.model.PrpLacciCheckInsertCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ��������᰸ǰ��ѯ��������
 * <p>
 * Title: ��������᰸ǰ��ѯ������Ϣ
 * </p>
 * <p>
 * Description: ��������᰸ǰ��ѯ������Ϣϵͳ��������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILApplyScheduleEditPostFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        //ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
        String editType = httpServletRequest.getParameter("editType");
        String registNo = httpServletRequest.getParameter("registNo"); //�ⰸ��
        String riskCode = httpServletRequest.getParameter("riskCode"); //����
        String nodeStatus = httpServletRequest.getParameter("nodeStatus"); //ԭ���ڵ��״̬
        String nodeType=httpServletRequest.getParameter("nodeType"); //�ڵ�����
        String nodeName=httpServletRequest.getParameter("nodeName"); //�ڵ�����
        
        String forward = ""; //��ǰ
        try {    
            //ȡ�û���Ϣ
            UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
            SwfLogDto swfLogDtoTemp = new SwfLogDto();

            SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
            swfLogDtoTemp = specialCaseViewHelper.viewToDto(httpServletRequest);
            PrpLacciCheckDto prpLacciCheckDto = specialCaseViewHelper.viewToCheckDto(httpServletRequest);
            PrpLacciCheckInsertCommand command = new PrpLacciCheckInsertCommand(prpLacciCheckDto);
            command.execute();
            //���±�����Ϣ����ȷ
            WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
            SwfLogDto swfLogDtoDealNode = new SwfLogDto();
            swfLogDtoDealNode.setFlowID(swfLogDtoTemp.getFlowID());
            
            //add by lixiang start at 2006-01-05
            //���������ڵ㣬����ֳ�һ��������Ĵ�������ƿ���������أ�
            //��ʱ��Ϊ�������compeΪ����������ģ����1�żӵ㣬Ȼ���ں��������и��滻��,����Ҫ�ر�Դ�
            int intLogNo=swfLogDtoTemp.getLogNo();
            
            if ("compe".equals(nodeType)){
            	swfLogDtoDealNode.setLogNo(1); 
            }else{
                swfLogDtoDealNode.setLogNo(intLogNo);
            }
            //add by lixiang end at 2006-01-05
             
            swfLogDtoDealNode.setNodeStatus("4");
            //swfLogDtoDealNode.setKeyIn(prpLacciCheckDto.getCertiNo());  keyIn��certino��Ϊ����� 2005-08-16
            swfLogDtoDealNode.setKeyIn(prpLacciCheckDto.getCheckNo());    
            swfLogDtoDealNode.setKeyOut(prpLacciCheckDto.getCertiNo());
            swfLogDtoDealNode.setNextBusinessNo(prpLacciCheckDto.getCertiNo());
            //ָ���¸��ڵ���������ⰸ������
            Collection nextNodeList = new ArrayList();
            SwfLogDto swfLogNextNode = new SwfLogDto();
            swfLogNextNode.setNodeNo(0);
            swfLogNextNode.setNodeType("check");
            swfLogNextNode.setTypeFlag(swfLogDtoTemp.getTypeFlag());
            // //�����ⰸ���͵�

            nextNodeList.add(swfLogNextNode);

            swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
            swfLogDtoDealNode.setSwfLogList(nextNodeList);
            WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
            workFlowDto.setSwfNotionDtoList(swfLogDtoTemp.getSwfNotionDtoList());
            
//            workFlowDto.setUpdateSwfLogDto(null);
            if (workFlowDto.getUpdateSwfLogDto() != null) {
            	workFlowDto.setUpdateSwfLogDto(null);
            }

            //��ΪҪ�������ڵĽڵ�Ϊԭ����״̬�����ԡ���
            if ("compe".equals(nodeType)){
//            	����lognNo=1������ı�Ϊ���㵽����ı�
            	if (workFlowDto.getSubmitSwfPathLogDtoList() !=null){
            		//���ҵ���ı�
            		for (int i =0;i<workFlowDto.getSubmitSwfPathLogDtoList().size() ;i++){
            			if (((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).getStartNodeNo()==1){
            				((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).setStartNodeNo(intLogNo);
            				((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).setStartNodeName (nodeName);
            				break;
            			}
            		}
            	}
            }
            //�������������

            //���濪ʼ
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

            if (workFlowViewHelper.checkDealDto(workFlowDto)) {
                uiWorkFlowAction.deal(workFlowDto);
                user.setUserMessage(prpLacciCheckDto.getCheckNo());

            }

            ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.specialCase.save"));

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLacciCheck.saveSuccess"));
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLacciCheck.checkNo"));
            saveMessages(httpServletRequest, messages);
            forward = "success";

            saveToken(httpServletRequest);
        } catch (UserException usee) {
            usee.printStackTrace();
            //������Ϣ����
            //������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            //������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", e.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";

        } finally {

        }

        return actionMapping.findForward(forward);
    }
}
