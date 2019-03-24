package com.sinosoft.claim.ui.control.facade;

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
import com.sinosoft.claim.dto.domain.SwfLogDto;
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

public class UIWorkFlowSubmitStepFacade extends Action
{
  public static String EDITTYPEEDIT="EDIT";    //编辑类型内容
  public static String EDITTYPE="editType";    //编辑类型内容
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {



    //业务类型：SubmitNode-前进一步
    /*
    String flowID =(String)httpServletRequest.getAttribute("wflogFlowID") ;
    String bussinessNo = (String)httpServletRequest.getAttribute("wflogBussinessNo") ;
    String nstatus = (String)httpServletRequest.getAttribute("wflogNstatus") ;

    String nodeStatus = (String)httpServletRequest.getAttribute("wflogNodeStatus") ;
    String nodeType = (String)httpServletRequest.getAttribute("wflogNodeType") ;
    */
   String nodeType = httpServletRequest.getParameter("nodeType");
   String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
   int  logNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
   String nstatus =httpServletRequest.getParameter("status") ;
   String bussinessNo = httpServletRequest.getParameter("bussinessNo") ;
   String nodeStatus= httpServletRequest.getParameter("nstatus") ;
   String bussinessOut= httpServletRequest.getParameter("bussinessOut") ;
   //System.out.println(flowID);
   // System.out.println(bussinessNo);
    //System.out.println(nodeStatus);

    String forward  = "";  //向前
    String msg="";
    try
    {
       //防止用户重复提交

   	String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
    if (pageNo==null&&pageNo.length()<1) pageNo="1";

      String userLastActionNow= "deal?"+flowID+"&"+logNo+"&"+bussinessNo+"&"+nodeStatus;
     // System.out.println(userLastActionNow);

      HttpSession session = httpServletRequest.getSession();
      UserDto user     = (UserDto)session.getAttribute("user");
      //System.out.println("caozuo 战壕。。。");
      forward = "success";

      if (userLastActionNow.equals(user.getUserLastAction() ) )
         {
              System.out.println("重复刷新。。。防止重复提交");
              //防止重复提交
         }else
         {
           UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
           //判断占号情况
           SwfLogDto swfLogDto = new SwfLogDto();
           swfLogDto =uiWorkFlowAction.holdNode(flowID,logNo,user.getUserCode() ,user.getUserName() );

              if (swfLogDto.getHoldNode() )
              { //成功占号，根据节点和操作状态进行不同的跳转。
                //具体是设置不同的forward的值
                  forward =getNodeForward(httpServletRequest,nodeType,nodeStatus,forward,bussinessOut);
//forward = "DAACheckAdd"      ;
               }else
               {
                   msg="案件'"+bussinessNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,请选择其它案件!";
                   //调用列表显示的过程，和点了待处理任务是相同的作用
                   httpServletRequest.setAttribute("status",nstatus) ;
                   httpServletRequest.setAttribute("nodeType",nodeType) ;
                   WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
                   workFlowViewHelper.getWorkFlowLogList(httpServletRequest,nodeType,nstatus,msg,pageNo,recordPerPage);
                }
           }

        //页面刷新显示:
        //防止再次刷新的时候会失去值
        System.out.println("forward==="+forward);

        user.setUserLastAction(userLastActionNow);

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
    System.out.println("%%%%%%%%%IWorkFlowLogQueryEditGetFacade forward="+forward);

    return actionMapping.findForward(forward);
  }

  //判断什么样的节点出现什么样的forward
  private String getNodeForward(HttpServletRequest httpServletRequest,String nodeType,String strNodeStatus,String forward,String bussinessOut)
  {
    int nodeStatus=Integer.parseInt(strNodeStatus);

  	 //  1.报案
               	 if (nodeType.equals("regis"))
               	 {
               	  switch (nodeStatus)
               	   {
               	   case 0:
               	       break;
                   /*
               	   case '1','2','3':
               	       //fm.action="/claim/registFinishQueryList.do?prpLregistRegistNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/registFinishQueryList.do?prpLregistRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
                  */
                   case 7:
                     forward = "DAARegisBackEdit" ;
                     httpServletRequest.setAttribute("prpLregistRegistNo",bussinessOut);
                     httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
               	      // fm.action="/claim/registFinishQueryList.do?prpLregistRegistNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/registFinishQueryList.do?prpLregistRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

                 }
                 // 2定损
                  if (nodeType.equals("certa"))
               	 {
               	   switch (nodeStatus)
               	   {
               	   case 0:
                      forward = "DAACertaAdd"      ;
               	       //fm.RegistNo.value= bussinessNo;
               	       //fm.action="/claim/certainLossBeforeEdit.do";
               	       //fm.editType.value="ADD";
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAACertaBackEdit" ;
                         httpServletRequest.setAttribute("prpLverifyLossRegistNo",bussinessOut);
                         httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
                         httpServletRequest.setAttribute("flag","1");
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessOut+"&editType=EDIT&flag=1";
               	       break;

               	   default:
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

                 }
                //3单证

                if (nodeType.equals("certi"))
               	 {

                  switch (nodeStatus)
               	   {
               	   case 0:
                        forward = "DAACertiAdd"      ;
               	      // fm.RegistNo.value= bussinessNo;
               	     //  fm.action="/claim/certifyBeforeEdit.do";
               	      // fm.editType.value="SELECTFLAG";
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAACertiBackEdit" ;
                            httpServletRequest.setAttribute("prpLcertifyCertifyNo",bussinessOut);
                              httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);


               	       //fm.action="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

                 }

                 //4。查勘
                if (nodeType.equals("check"))
               	 {

               	 switch (nodeStatus)
               	   {
               	   case 0:
                        forward = "DAACheckAdd"      ;
               	       //fm.RegistNo.value= bussinessNo;
               	       //fm.action="/claim/checkBeforeEdit.do";
               	       //fm.editType.value="ADD";
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAACheckBackEdit" ;
                            httpServletRequest.setAttribute("prpLcheckCheckNo",bussinessOut);
                              httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
               	       //fm.action="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

                 }
               //5。立案
               if (nodeType.equals("claim"))
               	 {
               	  switch (nodeStatus)
               	   {
               	   case 0:
                        forward = "DAAClaimAdd"      ;
               	       //fm.RegistNo.value= bussinessNo;
               	       //fm.action="/claim/claimBeforeEdit.do";
               	       //fm.editType.value="ADD";
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAAClaimBackEdit" ;

                                httpServletRequest.setAttribute("prpLclaimClaimNo",bussinessOut);
                              httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
               	       //fm.action="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

                 }
               //6。实赔
               if (nodeType.equals("compe"))
               	 {
               	 switch (nodeStatus)
               	   {
               	   case 0:
                        forward = "DAACompeAdd"      ;
               	       //fm.ClaimNo.value= bussinessNo;
               	       //fm.action="/claim/compensateBeforeEdit.do";
               	       //fm.editType.value="ADD";
               	       break;
                              /*
               	   case '1','2','3':
               	      // fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAACompeBackEdit" ;
                            httpServletRequest.setAttribute("prpLverifyLossRegistNo",bussinessOut);
                              httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

                 }
                 //7。结案
                 if (nodeType.equals("endca"))
               	 {
               	  switch (nodeStatus)
               	   {
               	   case 0:
               	       //fm.ClaimNo.value= bussinessNo;
               	       //fm.action="/claim/endcaseBeforeEdit.do";
               	       //fm.editType.value="ADD";
  forward = "DAAEndcaAdd"      ;
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                             httpServletRequest.setAttribute("prpLendcaseEndcaseNo",bussinessOut);
                              httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
                            forward = "DAAEndcaBackEdit" ;
               	       //fm.action="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }
               	 }


               	//8。核损
                 if (nodeType.equals("verif"))
               	 {


               	  switch (nodeStatus)
               	   {
               	   case 0:
                        forward = "DAAVerifAdd"      ;
               	       //fm.RegistNo.value= bussinessNo;
               	       //fm.action="/claim/verifyLossBeforeEdit.do";
               	       //fm.editType.value="ADD";
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAAVerifBackEdit" ;
                            httpServletRequest.setAttribute("prpLverifyLossRegistNo",bussinessOut);
                              httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
               	       //fm.action="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }

               	}


                 //8。预赔
                 if (nodeType.equals("prepa"))
               	 {
               	 switch (nodeStatus)
               	   {
               	   case 0:
               	       //fm.ClaimNo.value= bussinessNo;
               	       //fm.action="/claim/prepayBeforeEdit.do";
               	       //fm.editType.value="ADD";
  forward = "DAAPrepaAdd"      ;
               	       break;
                              /*
               	   case '1','2','3':
               	       //fm.action="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+bussinessNo+"&editType=EDIT";
               	       break;
               	   case '4':
               	       //fm.action="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+bussinessNo+"&editType=SHOW";
               	       break;
                              */
               	   case 7:
                            forward = "DAAPrepaBackEdit" ;
                            httpServletRequest.setAttribute("prpLprepayPrepayNo",bussinessOut);
                            httpServletRequest.setAttribute(EDITTYPE,EDITTYPEEDIT);
               	       //fm.action="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+bussinessOut+"&editType=EDIT";
               	       break;
               	   default:
               	       //fm.action="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+bussinessNo+"&editType=SHOW";
               	       break;
               	  }
               	 }

         return forward;
  }

}
