package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 立案撤消操作
 * <p>Title: 车险理赔立案撤消操作</p>
 * <p>Description: 车险理赔立案撤消操作</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */

public class UILClaimDeletePostFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     

    //业务类型：撤消操作
    //赔案号码
    String bessinessNo = httpServletRequest.getParameter("bussinessNo") ;
    String registNo= httpServletRequest.getParameter("claimRegistNo") ;
    //工作流查询确需要用报案的号码。。诶。。。。

    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
     HttpSession session = httpServletRequest.getSession();
    //防止用户重复提交
    String userLastActionNow="deleteclaim?"+bessinessNo;
    String condtions=httpServletRequest.getParameter("queryCondtions") ;
    String forward  = "";    //向前
    try
    {
       UserDto user     = (UserDto)session.getAttribute("user");
       String msg="";
      //System.out.println("重复刷新。。。"+user.getUserLastAction());
       if (userLastActionNow.equals(user.getUserLastAction() ) )
       {
            System.out.println("重复刷新。。。防止重复提交");
            //防止重复提交
       }else
       {
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            UIClaimAction uiClaimAction = new UIClaimAction();
            //查询是不是有工作流的数据
            Collection swfFlowNodeList = new ArrayList();
            SwfLogDto swfLogDto =new SwfLogDto();
            swfFlowNodeList = uiWorkFlowAction.findCurrentNode(registNo, "claim");

         if (swfFlowNodeList.iterator().hasNext()) {
           //获得当前工作流程的信息
           swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
           swfLogDto.setFlowStatus("1");//未被占用
           swfLogDto.setNodeStatus("0"); //未分配
           swfLogDto.setHandlerCode("");
           swfLogDto.setHandlerName("");

           //不想删除工作流节点了，应该是把工作流的那个节点变成没处理比较好。
           WorkFlowDto workFlowDto = new WorkFlowDto();
           workFlowDto.setUpdate(true);
           workFlowDto.setUpdateSwfLogDto(swfLogDto);
           System.out.println("workFlowDto.setUpdateSwfLogDto(swfLogDto);="+swfLogDto.getFlowID() ) ;
           uiClaimAction.delete(bessinessNo,workFlowDto);
         }
         else
         {
             uiClaimAction.delete(bessinessNo);
         }
         msg="业务号为'"+bessinessNo+"'的案件撤消成功!";
         }
        //页面刷新显示:
        //防止再次刷新的时候会失去值
        user.setUserLastAction(userLastActionNow);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setAlertMessage(msg);
        httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto) ;

        forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.queryEndcase");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.queryEndcase");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
   // System.out.println("%%%%%%%%%IWorkFlowLogQueryEditGetFacade forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
