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
 * 分发HTTP GET 车险理赔结案前查询保单请求
 * <p>
 * Title: 车险理赔结案前查询保单信息
 * </p>
 * <p>
 * Description: 车险理赔结案前查询保单信息系统样本程序
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

        //业务类型：ADD-新增 EDIT-修改 SHOW-显示
        String editType = httpServletRequest.getParameter("editType");
        String registNo = httpServletRequest.getParameter("registNo"); //赔案号
        String riskCode = httpServletRequest.getParameter("riskCode"); //险种
        String nodeStatus = httpServletRequest.getParameter("nodeStatus"); //原来节点的状态
        String nodeType=httpServletRequest.getParameter("nodeType"); //节点类型
        String nodeName=httpServletRequest.getParameter("nodeName"); //节点名称
        
        String forward = ""; //向前
        try {    
            //取用户信息
            UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
            SwfLogDto swfLogDtoTemp = new SwfLogDto();

            SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
            swfLogDtoTemp = specialCaseViewHelper.viewToDto(httpServletRequest);
            PrpLacciCheckDto prpLacciCheckDto = specialCaseViewHelper.viewToCheckDto(httpServletRequest);
            PrpLacciCheckInsertCommand command = new PrpLacciCheckInsertCommand(prpLacciCheckDto);
            command.execute();
            //以下保存信息不明确
            WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
            SwfLogDto swfLogDtoDealNode = new SwfLogDto();
            swfLogDtoDealNode.setFlowID(swfLogDtoTemp.getFlowID());
            
            //add by lixiang start at 2006-01-05
            //如果是理算节点，会出现出一个计算书的错误，如何绕开这个问题呢？
            //暂时认为是如果是compe为理算上提出的，则从1号加点，然后在后续过程中给替换掉,理算要特别对待
            int intLogNo=swfLogDtoTemp.getLogNo();
            
            if ("compe".equals(nodeType)){
            	swfLogDtoDealNode.setLogNo(1); 
            }else{
                swfLogDtoDealNode.setLogNo(intLogNo);
            }
            //add by lixiang end at 2006-01-05
             
            swfLogDtoDealNode.setNodeStatus("4");
            //swfLogDtoDealNode.setKeyIn(prpLacciCheckDto.getCertiNo());  keyIn由certino改为调查号 2005-08-16
            swfLogDtoDealNode.setKeyIn(prpLacciCheckDto.getCheckNo());    
            swfLogDtoDealNode.setKeyOut(prpLacciCheckDto.getCertiNo());
            swfLogDtoDealNode.setNextBusinessNo(prpLacciCheckDto.getCertiNo());
            //指定下个节点就是特殊赔案的申请
            Collection nextNodeList = new ArrayList();
            SwfLogDto swfLogNextNode = new SwfLogDto();
            swfLogNextNode.setNodeNo(0);
            swfLogNextNode.setNodeType("check");
            swfLogNextNode.setTypeFlag(swfLogDtoTemp.getTypeFlag());
            // //区分赔案类型的

            nextNodeList.add(swfLogNextNode);

            swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
            swfLogDtoDealNode.setSwfLogList(nextNodeList);
            WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
            workFlowDto.setSwfNotionDtoList(swfLogDtoTemp.getSwfNotionDtoList());
            
//            workFlowDto.setUpdateSwfLogDto(null);
            if (workFlowDto.getUpdateSwfLogDto() != null) {
            	workFlowDto.setUpdateSwfLogDto(null);
            }

            //因为要保持现在的节点为原来的状态，所以。。
            if ("compe".equals(nodeType)){
//            	设置lognNo=1到调查的边为理算到调查的边
            	if (workFlowDto.getSubmitSwfPathLogDtoList() !=null){
            		//查找调查的边
            		for (int i =0;i<workFlowDto.getSubmitSwfPathLogDtoList().size() ;i++){
            			if (((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).getStartNodeNo()==1){
            				((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).setStartNodeNo(intLogNo);
            				((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).setStartNodeName (nodeName);
            				break;
            			}
            		}
            	}
            }
            //工作流处理结束

            //保存开始
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
            //错误信息处理
            //错误信息处理
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息处理
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
