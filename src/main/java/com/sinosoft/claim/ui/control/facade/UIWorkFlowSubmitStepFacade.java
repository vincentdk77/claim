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
 * �ַ�HTTP GET ����������һ��
 * <p>Title: �������⹤��������һ��</p>
 * <p>Description: �������⹤������Ϣϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowSubmitStepFacade extends Action
{
  public static String EDITTYPEEDIT="EDIT";    //�༭��������
  public static String EDITTYPE="editType";    //�༭��������
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {



    //ҵ�����ͣ�SubmitNode-ǰ��һ��
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

    String forward  = "";  //��ǰ
    String msg="";
    try
    {
       //��ֹ�û��ظ��ύ

   	String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
    if (pageNo==null&&pageNo.length()<1) pageNo="1";

      String userLastActionNow= "deal?"+flowID+"&"+logNo+"&"+bussinessNo+"&"+nodeStatus;
     // System.out.println(userLastActionNow);

      HttpSession session = httpServletRequest.getSession();
      UserDto user     = (UserDto)session.getAttribute("user");
      //System.out.println("caozuo ս��������");
      forward = "success";

      if (userLastActionNow.equals(user.getUserLastAction() ) )
         {
              System.out.println("�ظ�ˢ�¡�������ֹ�ظ��ύ");
              //��ֹ�ظ��ύ
         }else
         {
           UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
           //�ж�ռ�����
           SwfLogDto swfLogDto = new SwfLogDto();
           swfLogDto =uiWorkFlowAction.holdNode(flowID,logNo,user.getUserCode() ,user.getUserName() );

              if (swfLogDto.getHoldNode() )
              { //�ɹ�ռ�ţ����ݽڵ�Ͳ���״̬���в�ͬ����ת��
                //���������ò�ͬ��forward��ֵ
                  forward =getNodeForward(httpServletRequest,nodeType,nodeStatus,forward,bussinessOut);
//forward = "DAACheckAdd"      ;
               }else
               {
                   msg="����'"+bussinessNo+"'�Ѿ�������:'"+swfLogDto.getHandlerCode() +"',����:'"+swfLogDto.getHandlerName() +"'���û���ռ��,��ѡ����������!";
                   //�����б���ʾ�Ĺ��̣��͵��˴�������������ͬ������
                   httpServletRequest.setAttribute("status",nstatus) ;
                   httpServletRequest.setAttribute("nodeType",nodeType) ;
                   WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
                   workFlowViewHelper.getWorkFlowLogList(httpServletRequest,nodeType,nstatus,msg,pageNo,recordPerPage);
                }
           }

        //ҳ��ˢ����ʾ:
        //��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
        System.out.println("forward==="+forward);

        user.setUserLastAction(userLastActionNow);

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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

  //�ж�ʲô���Ľڵ����ʲô����forward
  private String getNodeForward(HttpServletRequest httpServletRequest,String nodeType,String strNodeStatus,String forward,String bussinessOut)
  {
    int nodeStatus=Integer.parseInt(strNodeStatus);

  	 //  1.����
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
                 // 2����
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
                //3��֤

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

                 //4���鿱
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
               //5������
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
               //6��ʵ��
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
                 //7���᰸
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


               	//8������
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


                 //8��Ԥ��
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
