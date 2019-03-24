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
 * �ַ�HTTP GET ����������һ��
 * <p>Title: �������⹤��������һ��</p>
 * <p>Description: �������⹤������Ϣϵͳ</p>
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
    //ҵ�����ͣ�BACKSTEP-����һ��
    String nodeType = httpServletRequest.getParameter("nodeType");
    String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
    int  logNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
    String status =httpServletRequest.getParameter("status") ;
    String bessinessNo = httpServletRequest.getParameter("bussinessNo") ;
    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
    HttpSession session = httpServletRequest.getSession();
    //��ֹ�û��ظ��ύ
    String userLastActionNow="back?"+flowID+"&"+logNo;
    String forward  = "";    //��ǰ
   try
    {
       UserDto user     = (UserDto)session.getAttribute("user");
       String msg="";
      //System.out.println("�ظ�ˢ�¡�����"+user.getUserLastAction());
       if (userLastActionNow.equals(user.getUserLastAction() ) )
       {
            System.out.println("�ظ�ˢ�¡�������ֹ�ظ��ύ");
            //��ֹ�ظ��ύ
       }else
       {
             UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
             //���ù����������ݱ���
             String keyOut = bessinessNo ;

             //����Ҫ�ж�����û��ǲ��ǿ���ռ�š���
             SwfLogDto swfLogDto = new SwfLogDto();
             swfLogDto = uiWorkFlowAction.holdNode(flowID,logNo ,user.getUserCode() ,user.getUserName() );

             if (swfLogDto.getHoldNode()==false)
             {
               msg="����'"+bessinessNo+"'�Ѿ�������:'"+swfLogDto.getHandlerCode() +"',����:'"+swfLogDto.getHandlerName() +"'���û���ռ��,"
                         +"\r\n��ѡ�������������л��˻�����'"+swfLogDto.getHandlerName()+"'��ϵ!";
               throw new UserException(1,3,"������",msg);
             }
             //��ѯ������״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
             WorkFlowDto workFlowDto = new WorkFlowDto();
             workFlowDto =workFlowViewHelper.getBackFlowInfo(user,flowID,logNo);
             uiWorkFlowAction.deal(workFlowDto);
             //�����ǰ�ڵ��״̬
             //uiWorkFlowAction.updateFlow(swfLogDto);
              //�ύ������
             //uiWorkFlowAction.submitNode(workFlowDto);
            //�޸�claimstatus�еı�־״̬,����Ժ��������ű����԰����ȥ��
            SwfLogDto nowSwfLogDto=null;
            nowSwfLogDto = workFlowDto.getUpdateSwfLogDto();
             
            //�жϱ��ڵ��ǲ���ע������
           if (nowSwfLogDto.getNodeType().equals("cance")){
            //����ǵĻ�������ȥ��prplclaim�еı�־	
			BLClaimFacade blClaimFacade = new BLClaimFacade();
			blClaimFacade.UpdCaseType(bessinessNo);
             } 
//
           
             UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction ();
             //bessinessNo���ں��˵Ĳ�ֹһ���ڵ㣬�����Ǽ���
             if (workFlowDto.getSubmit())
             {
             	   //��ѯ�����Ŀ����ж��
                 Iterator it = workFlowDto.getSubmitSwfLogDtoList().iterator()  ;

                  while (it.hasNext())
                  {
                    SwfLogDto swfBackLog = new SwfLogDto();
                    swfBackLog = (SwfLogDto) it.next();
                    ClaimStatusDto claimStatusDto = new ClaimStatusDto();
                    //����Ǻ����˵�������ô������������ֹ�������˶���de �����˸��ٵĵ�
                      if (swfBackLog.getNodeType().equals("wound") )
                     {

                            claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "wound", 1);
                            if (claimStatusDto.getPrpLclaimStatusDto() == null) {
                            claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "veriw", 1);
                               }

                            //System.out.println("���������Ľڵ�Ϊ�����账���״̬");
                            if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                             //���������Ľڵ�Ϊ�����账���״̬
                             claimStatusDto.getPrpLclaimStatusDto().setStatus("3");
                             claimStatusDto.getPrpLclaimStatusDto().setNodeType("wound");
                             uiClaimStatusAction.save(claimStatusDto);
                            // System.out.println("���������Ľڵ�Ϊ�����账���״̬");
                             //���õ����ڴ���
                            }
                     }
                    else if (swfBackLog.getNodeType().equals("certa") ){

                      claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "verif", 1);
                            if (claimStatusDto.getPrpLclaimStatusDto() == null) {
                            claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.getKeyOut(), "certa", 1);
                               }

                            //System.out.println("���������Ľڵ�Ϊ�����账���״̬");
                            if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                             //���������Ľڵ�Ϊ�����账���״̬
                             claimStatusDto.getPrpLclaimStatusDto().setStatus("3");
                             claimStatusDto.getPrpLclaimStatusDto().setNodeType("certa");
                             uiClaimStatusAction.save(claimStatusDto);
                            // System.out.println("���������Ľڵ�Ϊ�����账���״̬");
                             //���õ����ڴ���
                            }


                    }else
                    {
                       claimStatusDto = uiClaimStatusAction.findByPrimaryKey(swfBackLog.
                       getKeyOut(), swfBackLog.getNodeType(), 0);
                   //�����ǰΪ�鿱���˻ص�����״̬����ô����ҲӦ�����ܹ������ġ���
                      if ((swfBackLog.getNodeType().equals("sched") )&&(nowSwfLogDto.getNodeType().equals("check") ) )
                       {
                         UIScheduleNewAction uiScheduleNewAction = new UIScheduleNewAction();
                         ScheduleNewDto scheduleNewDto  = new ScheduleNewDto ();
                         //�鵽������Ϊnull
                         scheduleNewDto = uiScheduleNewAction.findByPrimaryKey( swfLogDto.getKeyIn() ,1) ;
                           //�����µ�����ʾ��ĵ���Ϊ�˻ش���״̬������Ҳ��״̬�б��Ͻ�����ʾ
                           if (scheduleNewDto.getPrpLscheduleNewDto()!=null)
                           {
                             scheduleNewDto.getPrpLscheduleNewDto().setScheduleFlag("3");
                             uiScheduleNewAction.save(scheduleNewDto);
                           }
                        }
                       if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                          //���������Ľڵ�Ϊ�����账���״̬
                          claimStatusDto.getPrpLclaimStatusDto().setStatus("3");
                          uiClaimStatusAction.save(claimStatusDto);
                          //���õ����ڴ���
                         }
                         
                         
                     }
                  }
             }
            msg="ҵ���Ϊ'"+bessinessNo+"'�İ������˳ɹ�!";
             //httpServletRequest.setAttribute("alertMessage",msg);

        }
        //ҳ��ˢ����ʾ:
        //��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
        user.setUserLastAction(userLastActionNow);

     httpServletRequest.setAttribute("status",status) ;
     httpServletRequest.setAttribute("nodeType",nodeType) ;
      //�����б���ʾ�Ĺ��̣�
      //System.out.println("In����������Ϊ:"+ nodeType+"|"+status+ "|"+msg);
      workFlowViewHelper.getWorkFlowLogList(httpServletRequest,nodeType,status,msg,pageNo,recordPerPage);
      forward = "success";

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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
