package com.sinosoft.claim.ui.control.facade;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UIScheduleNewAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * 分发HTTP GET 工作流回退一步
 * <p>Title: 车险理赔工作流回退一步</p>
 * <p>Description: 车险理赔工作流信息系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowLogBackStepFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {

	String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
    if (pageNo==null&&pageNo.length()<1) pageNo="1";
    //业务类型：BACKSTEP-后退一步
    String nodeType = httpServletRequest.getParameter("nodeType");
    String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
    int  logNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
    String status =httpServletRequest.getParameter("status") ;
    String bessinessNo = httpServletRequest.getParameter("bussinessNo") ;
    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
    HttpSession session = httpServletRequest.getSession();
    //防止用户重复提交
    String userLastActionNow="back?"+flowID+"&"+logNo;
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
             //设置工作流的数据保存
             String keyOut = bessinessNo ;

             //首先要判断这个用户是不是可以占号。。
             SwfLogDto swfLogDto = new SwfLogDto();
             swfLogDto = uiWorkFlowAction.holdNode(flowID,logNo ,user.getUserCode() ,user.getUserName() );

             if (swfLogDto.getHoldNode()==false)
             {
               msg="案件'"+bessinessNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,"
                         +"\r\n请选择其它案件进行回退或者与'"+swfLogDto.getHandlerName()+"'联系!";
               throw new UserException(1,3,"工作流",msg);
             }
             //查询工作流状态信息,整理输入，用于初始界面显示
             WorkFlowDto workFlowDto = new WorkFlowDto();
             workFlowDto =workFlowViewHelper.getBackFlowInfo(user,flowID,logNo);
             uiWorkFlowAction.deal(workFlowDto);
             //变更当前节点的状态
             //uiWorkFlowAction.updateFlow(swfLogDto);
              //提交工作流
             //uiWorkFlowAction.submitNode(workFlowDto);
            //修改claimstatus中的标志状态,如果以后不依赖这张表，可以把这个去掉
            SwfLogDto nowSwfLogDto=null;
            nowSwfLogDto = workFlowDto.getUpdateSwfLogDto();
             
            //判断本节点是不是注销拒赔
           if (nowSwfLogDto.getNodeType().equals("cance")){
            //如果是的话，可以去掉prplclaim中的标志	
			BLClaimFacade blClaimFacade = new BLClaimFacade();
			blClaimFacade.UpdCaseType(bessinessNo);
             } 
//
           
             UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction ();
             //bessinessNo由于后退的不止一个节点，所以是集合
             if (workFlowDto.getSubmit())
             {
             	   //查询出来的可能有多个
                 Iterator it = workFlowDto.getSubmitSwfLogDtoList().iterator()  ;

                  while (it.hasNext())
                  {
                    SwfLogDto swfBackLog = new SwfLogDto();
                    swfBackLog = (SwfLogDto) it.next();
                    ClaimStatusDto claimStatusDto = new ClaimStatusDto();
                    //如果是核损退到定损，那么。。。。。不止，所有退定损de 和人伤跟踪的的
                      if (swfBackLog.getNodeType().equals("wound") )
                     {

                            claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "wound", 1);
                            if (claimStatusDto.getPrpLclaimStatusDto() == null) {
                            claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "veriw", 1);
                               }

                            //System.out.println("设置新增的节点为回退需处理的状态");
                            if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                             //设置新增的节点为回退需处理的状态
                             claimStatusDto.getPrpLclaimStatusDto().setStatus("3");
                             claimStatusDto.getPrpLclaimStatusDto().setNodeType("wound");
                             uiClaimStatusAction.save(claimStatusDto);
                            // System.out.println("设置新增的节点为回退需处理的状态");
                             //设置到正在处理
                            }
                     }
                    else if (swfBackLog.getNodeType().equals("certa") ){

                      claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "verif", 1);
                            if (claimStatusDto.getPrpLclaimStatusDto() == null) {
                            claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "certa", 1);
                               }

                            //System.out.println("设置新增的节点为回退需处理的状态");
                            if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                             //设置新增的节点为回退需处理的状态
                             claimStatusDto.getPrpLclaimStatusDto().setStatus("3");
                             claimStatusDto.getPrpLclaimStatusDto().setNodeType("certa");
                             uiClaimStatusAction.save(claimStatusDto);
                            // System.out.println("设置新增的节点为回退需处理的状态");
                             //设置到正在处理
                            }


                    }else
                    {
                       claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.
                       getKeyOut(), swfBackLog.getNodeType(), 0);
                   //如果当前为查勘，退回到调度状态，那么调度也应该是能够看到的。。
                      if ((swfBackLog.getNodeType().equals("sched") )&&(nowSwfLogDto.getNodeType().equals("check") ) )
                       {
                         UIScheduleNewAction uiScheduleNewAction = new UIScheduleNewAction();
                         ScheduleNewDto scheduleNewDto  = new ScheduleNewDto ();
                         //查到的数据为null
                         scheduleNewDto = uiScheduleNewAction.findByPrimaryKey( swfLogDto.getKeyIn() ,1) ;
                           //设置新调度提示表的调度为退回处理状态，并且也在状态列表上进行显示
                           if (scheduleNewDto.getPrpLscheduleNewDto()!=null)
                           {
                             scheduleNewDto.getPrpLscheduleNewDto().setScheduleFlag("3");
                             uiScheduleNewAction.save(scheduleNewDto);
                           }
                        }
                       if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                          //设置新增的节点为回退需处理的状态
                          claimStatusDto.getPrpLclaimStatusDto().setStatus("3");
                          uiClaimStatusAction.save(claimStatusDto);
                          //设置到正在处理
                         }
                         
                         
                     }
                  }
             }
            msg="业务号为'"+bessinessNo+"'的案件回退成功!";
             //httpServletRequest.setAttribute("alertMessage",msg);

        }
        //页面刷新显示:
        //防止再次刷新的时候会失去值
        user.setUserLastAction(userLastActionNow);

     httpServletRequest.setAttribute("status",status) ;
     httpServletRequest.setAttribute("nodeType",nodeType) ;
      //调用列表显示的过程，
      //System.out.println("In的数据内容为:"+ nodeType+"|"+status+ "|"+msg);
      workFlowViewHelper.getWorkFlowLogList(httpServletRequest,nodeType,status,msg,pageNo,recordPerPage);
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
 System.out.println("%%%%%%%%%IWorkFlowLogBackFacade forward="+forward);

    return actionMapping.findForward(forward);
  }

}
