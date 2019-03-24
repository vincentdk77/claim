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
 * 分发HTTP GET 车险理赔结案前查询保单请求
 * <p>Title: 车险理赔结案前查询保单信息</p>
 * <p>Description: 车险理赔结案前查询保单信息系统样本程序</p>
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

    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType     = httpServletRequest.getParameter("editType");
    //String[] claimNoArray = httpServletRequest.getParameterValues("ClaimNo"); //赔案号
    String claimNo = httpServletRequest.getParameter("prpLclaimNo");
    //String[] claimNoFlag = httpServletRequest.getParameterValues("claimNoFlag");
    String riskCode = httpServletRequest.getParameter("riskCode");   //险种
    String nodeStatus=httpServletRequest.getParameter("nodeStatus"); //原来节点的状态
    String forward  = "";//向前
    try
    {
    	//取用户信息
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        SwfLogDto swfLogDtoTemp = new SwfLogDto();
        SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
        swfLogDtoTemp =specialCaseViewHelper.viewToDto(httpServletRequest);
        /**for (int i = 1; i < claimNoArray.length; i++) {
        	   claimNo = claimNoArray[i];
		}*/
        UIClaimAction  uiClaimAction  =new UIClaimAction (); 
        ClaimDto  claimDto=uiClaimAction.findByPrimaryKey(claimNo);
        
        //以下保存信息不明确
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        swfLogDtoDealNode.setFlowID(swfLogDtoTemp.getFlowID());
        swfLogDtoDealNode.setLogNo(swfLogDtoTemp.getLogNo());
        swfLogDtoDealNode.setNodeStatus("4");
        swfLogDtoDealNode.setKeyIn(claimNo);
        swfLogDtoDealNode.setKeyOut(claimNo);
        swfLogDtoDealNode.setNextBusinessNo(claimNo );
        swfLogDtoDealNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
        //指定下个节点就是特殊赔案的申请
         Collection nextNodeList = new ArrayList();
         SwfLogDto swfLogNextNode = new SwfLogDto();
         swfLogNextNode.setNodeNo(0);
         swfLogNextNode.setNodeType("speci");
         swfLogNextNode.setTypeFlag(swfLogDtoTemp.getTypeFlag()); //区分赔案类型的
         swfLogNextNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());

         nextNodeList.add(swfLogNextNode);

          swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
          swfLogDtoDealNode.setSwfLogList(nextNodeList);
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
       workFlowDto.setSwfNotionDtoList(swfLogDtoTemp.getSwfNotionDtoList() );
       if (workFlowDto.getUpdateSwfLogDto()!=null) {
       	workFlowDto.getUpdateSwfLogDto().setNodeStatus(nodeStatus);
       }
       
       //因为要保持现在的节点为原来的状态，所以。。
       
       //工作流处理结束

        //保存开始
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
      //错误信息处理
      //错误信息处理
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
      //错误信息处理
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
