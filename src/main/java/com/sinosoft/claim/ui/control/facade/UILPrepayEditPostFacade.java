package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

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

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAPrepayViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP Post ��������Ԥ��༭����
 * <p>Title: ��������Ԥ��༭������Ϣ</p>
 * <p>Description: ��������Ԥ��༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILPrepayEditPostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
    Exception {

    String forward = ""; //��ǰ��ת
    try {
      UserDto   user     = (UserDto )httpServletRequest.getSession().getAttribute("user");
      String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
      String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
      String riskCodeTemp = httpServletRequest.getParameter("prpLprepayRiskCode");
      String taskType=""; //��ʾ�������ⰸ�е�Ԥ��������������޸ģ��������������������µĹ�������Ϣ��
                          //ֻҪ����taskType="T"���͵ľͿ����ˡ�

    	if(riskCodeTemp !=null&&riskCodeTemp.trim().length()>0){
        user.setRiskCode(riskCodeTemp);
      }
      String riskCode = user.getRiskCode();
      String comCode = user.getComCode();
      int year = DateTime.current().getYear() ;
      //����
      if(isTokenValid(httpServletRequest,true)){
      //������µǼǣ����ȡ�ű���ȡԤ����룬������޸ģ��򱣳�ԭ����preCompensateNo����
      //ȡԤ���
      String preCompensateNo = ""; //Ԥ���
      preCompensateNo = httpServletRequest.getParameter("prpLprepayPreCompensateNo");
      if (preCompensateNo== null||preCompensateNo.length()<1|| preCompensateNo.trim().equals(""))
      {
        UIBillAction uiBillAction = new UIBillAction();
        String tableName = "prplprepay";
        preCompensateNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
        taskType="T"  ;
      }
      httpServletRequest.setAttribute("preCompensateNo", preCompensateNo);
      httpServletRequest.setAttribute("prpLprepayPreCompensateNo", preCompensateNo);
      //��viewHelper�����������
      PrepayDto prepayDto = null;
      DAAPrepayViewHelper daaPrepayViewHelper = new DAAPrepayViewHelper();
      prepayDto = daaPrepayViewHelper.viewToDto(httpServletRequest);
      
      //����ύ������״̬Ϊ9
      if (httpServletRequest.getParameter("buttonSaveType").equals("4")) {
          prepayDto.getPrpLprepayDto().setUnderWriteFlag("9");
      }

      //�쳣����

      if(preCompensateNo.equals("") || preCompensateNo.length()!=22)
      {
        //throw new UserException(-98,-200,"","�������");
      }

        //�������������(��������)
        //-----------------------------------------------------
        // 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();

        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        //swfLogDtoDealNode.setTaskType(taskType);
   
          swfLogDtoDealNode.setFlowID(swfLogFlowID);
          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
       
        //�����һ���ڵ��ǽ᰸�Ļ�����ôֱ�����ⰸ�žͿ�����
        //swfLogDtoDealNode.setNextBusinessNo(prepayDto.getPrpLprepayDto().getClaimNo());
        swfLogDtoDealNode.setNextBusinessNo(preCompensateNo);
        swfLogDtoDealNode.setKeyIn(prepayDto.getPrpLprepayDto().getClaimNo());
        swfLogDtoDealNode.setKeyOut(preCompensateNo);
        swfLogDtoDealNode.setNodeStatus(httpServletRequest.getParameter("buttonSaveType"));
        System.out.println();System.out.println(httpServletRequest.getParameter("buttonSaveType")+"============");System.out.println();
        
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        //------------------------------------------------------------
        //����Ԥ����Ϣ
        UIPrepayAction uiPrepayAction = new UIPrepayAction();

        if (workFlowDto.getCheckClose() )
         { String msg ="�ù��������Ѿ��رգ�"
                      +"\n\r�����Ҫ����������ϵ����Ա���¿���������!";
           throw new UserException(1,2,"������",msg);
         }

         if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
        {

        	     //���ӶԺ˱�����ϵͳ�Ľӿڵ��á�
        int vericLogNo=0;
         if (swfLogDtoDealNode.getNodeStatus().equals("4")){
               if (taskType.equals("T" ))
                  { //ҵ�����ݿ��л�û������
                   uiPrepayAction.save(prepayDto);}
                    if (workFlowDto.getSubmitSwfLogDtoList()!=null &&workFlowDto.getSubmitSwfLogDtoList().size()!=0){
                      vericLogNo=((SwfLogDto)workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo() ;
                    }

                    UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade=new UIWorkFlowUWInterFaceFacade();
                    String UWflowID= uiWorkFlowUWInterFaceFacade.submitVericTask(workFlowDto.getUpdateSwfLogDto().getFlowID() ,
                           vericLogNo+"",
                           "22",
                           "Y",
                           preCompensateNo,
                           prepayDto.getPrpLprepayDto().getRiskCode() ,
                           prepayDto.getPrpLprepayDto().getClassCode() ,
                           prepayDto.getPrpLprepayDto().getComCode(),
                           prepayDto.getPrpLprepayDto().getHandlerCode() ,
                           prepayDto.getPrpLprepayDto().getMakeCom() ,
                           user.getUserCode(),
                           prepayDto.getPrpLprepayDto().getHandler1Code() ,
                           "");
 
             if (UWflowID.length()!= 27){
                //����ύ����ʧ����״̬Ϊ0 2005-9-29
//             	�������ύʧ��ʱ���Ѽ�������Ϊ�ݴ棬�����ٴ��ύ��
				swfLogDtoDealNode.setNodeStatus("2");
                prepayDto.getPrpLprepayDto().setUnderWriteFlag("0");
				workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
				uiPrepayAction.save(prepayDto, workFlowDto);
                String msg="����'"+preCompensateNo+"'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
                throw new UserException(1,3,"������",msg);
             }

         }
        	 uiPrepayAction.save(prepayDto,workFlowDto);
             user.setUserMessage(preCompensateNo);
        } else {
             //����ύ����ʧ����״̬Ϊ0
             prepayDto.getPrpLprepayDto().setUnderWriteFlag("0");
        	 uiPrepayAction.save(prepayDto);
             user.setUserMessage(preCompensateNo+";ע��:û�з����빤������������κ����ݣ���");
        }

      //httpServletRequest.setAttribute("messagepagevalue",preCompensateNo) ;
      httpServletRequest.setAttribute("prpLregistDto",prepayDto.getPrpLprepayDto()) ;
    }

      ActionMessages messages = new ActionMessages();
      if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.prepay.submit"));
      }else {
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.prepay.save"));
      }
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLprepay.preCompensateNo"));
      saveMessages( httpServletRequest, messages );

      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally {

    }

    return actionMapping.findForward(forward);
  }
}
