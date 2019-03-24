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

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.SpecialCaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ��������᰸ǰ��ѯ��������
 * <p>Title: ��������᰸ǰ��ѯ������Ϣ</p>
 * <p>Description: ��������᰸ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILSpeicalCaseEditPostFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {

    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType     = httpServletRequest.getParameter("editType");
    //String[] claimNoArray = httpServletRequest.getParameterValues("ClaimNo"); //�ⰸ��
    String claimNo = httpServletRequest.getParameter("prpLclaimNo");
    //String[] claimNoFlag = httpServletRequest.getParameterValues("claimNoFlag");
    String riskCode = httpServletRequest.getParameter("riskCode");   //����
    String nodeStatus=httpServletRequest.getParameter("nodeStatus"); //ԭ���ڵ��״̬
    String forward  = "";//��ǰ
    try
    {
    	//ȡ�û���Ϣ
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        SwfLogDto swfLogDtoTemp = new SwfLogDto();
        SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
        swfLogDtoTemp =specialCaseViewHelper.viewToDto(httpServletRequest);
        /**for (int i = 1; i < claimNoArray.length; i++) {
        	   claimNo = claimNoArray[i];
		}*/
        UIClaimAction  uiClaimAction  =new UIClaimAction (); 
        ClaimDto  claimDto=uiClaimAction.findByPrimaryKey(claimNo);
        
        //���±�����Ϣ����ȷ
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        swfLogDtoDealNode.setFlowID(swfLogDtoTemp.getFlowID());
        swfLogDtoDealNode.setLogNo(swfLogDtoTemp.getLogNo());
        swfLogDtoDealNode.setNodeStatus("4");
        swfLogDtoDealNode.setKeyIn(claimNo);
        swfLogDtoDealNode.setKeyOut(claimNo);
        swfLogDtoDealNode.setNextBusinessNo(claimNo );
        swfLogDtoDealNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
        //ָ���¸��ڵ���������ⰸ������
         Collection nextNodeList = new ArrayList();
         SwfLogDto swfLogNextNode = new SwfLogDto();
         swfLogNextNode.setNodeNo(0);
         swfLogNextNode.setNodeType("speci");
         swfLogNextNode.setTypeFlag(swfLogDtoTemp.getTypeFlag()); //�����ⰸ���͵�
         swfLogNextNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());

         nextNodeList.add(swfLogNextNode);

          swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
          swfLogDtoDealNode.setSwfLogList(nextNodeList);
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
       workFlowDto.setSwfNotionDtoList(swfLogDtoTemp.getSwfNotionDtoList() );
       if (workFlowDto.getUpdateSwfLogDto()!=null) {
       	workFlowDto.getUpdateSwfLogDto().setNodeStatus(nodeStatus);
       }
       
       //��ΪҪ�������ڵĽڵ�Ϊԭ����״̬�����ԡ���
       
       //�������������

        //���濪ʼ
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        if (workFlowViewHelper.checkDealDto(workFlowDto))
        {
           uiWorkFlowAction.deal(workFlowDto);
           user.setUserMessage(claimNo);

        }


      ActionMessages messages = new ActionMessages();
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.specialcase.save"));
      
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.claimNo"));
      saveMessages( httpServletRequest, messages );
      forward = "success";

      saveToken(httpServletRequest);
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
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
