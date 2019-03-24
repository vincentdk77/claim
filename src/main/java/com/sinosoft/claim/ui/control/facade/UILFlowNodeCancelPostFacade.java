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

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;



/**
 * �ַ�HTTP Post ���̽ڵ�ע��������Ϣ
 * <p>Title: �������̽ڵ�ע��������Ϣ</p>
 * <p>Description: �������̽ڵ�ע��������Ϣ����</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author sinosoft
 * @version 1.0
 */

public class UILFlowNodeCancelPostFacade
extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

    String forward = ""; //��ǰ��ת

    try {
       
       //ȡ�õ�ǰ�û���Ϣ
       UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
       
        //����Ϊ������ʹ���е�
        //�õ����̱��
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID");
        String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo");
        String registNo=httpServletRequest.getParameter("RegistNo");
        String editType=httpServletRequest.getParameter("editType");
        //������������ע����Ϣ
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
       
       
        if (swfLogFlowID==null || swfLogLogNo==null||swfLogFlowID.equals("null")||swfLogLogNo.equals("null"))
        {  String msg="����'"+registNo+"'û���ֿ���ע���Ķ�������!";
            throw new UserException(1,3,"��������ע��",msg);
	 }
        System.out.println(swfLogFlowID+"|"+swfLogLogNo);
        swfLogDtoDealNode=uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)) );
        
        if (swfLogDtoDealNode==null){
        	 String msg="����'"+registNo+"'û���ֿ���ע���Ķ�������2!";
             throw new UserException(1,3,"��������ע��",msg);
        }
        
        if ("ScheduleCancel".equals( editType)){
        	//��Ҫ��鳷���Ķ����ǲ��ǵ�����Ψһ��һ����������ǵĻ���������ע���ġ���
        	//����
        	String strSql = "flowid='"+swfLogFlowID+"' and nodestatus<'5' "
			               +" and nodeType in ('certa','wound','propc')";
        	int count = uiWorkFlowAction.findFlowNodeCountByConditon( strSql);
        	
        	if (count==1){
        		//�����Ψһ���ȳ�ȥ�������жϵ����л�����û�е��ȳ�ȥ����
        		 strSql=" registno='"+registNo+"' and surveyTimes<1";
	                UIScheduleAction uiScheduleAction = new UIScheduleAction();
	                int schedulecount =uiScheduleAction.findScheduleItemCountByConditon(strSql);
	                //ֻ��Ψһ��һ�������������Ծ��ǲ�����ȡ������
	                if (schedulecount<1){
	                	 String msg="����'"+registNo+"'�У���ʣ��Ψһ�Ķ����������Բ���ע��!";
	                     throw new UserException(1,3,"��������ע��",msg);
	               
	                }
	         
        	}
        }
        WorkFlowDto workFlowDto = new WorkFlowDto();
        workFlowDto.setUpdate( true);
        swfLogDtoDealNode.setNodeStatus( "6");
        String context=httpServletRequest.getParameter("contextInnerHTML");
        String tempStr="@�û�:"+user.getUserName()+"ִ����ע��������ԭ��"+context; 
        swfLogDtoDealNode.setTitleStr(swfLogDtoDealNode.getTitleStr() +tempStr);
        workFlowDto.setUpdateSwfLogDto(swfLogDtoDealNode);
        //���汨��ע����Ϣ�����ҹ�������

        if (workFlowViewHelper.checkDealDto(workFlowDto))
        {
        	uiWorkFlowAction.deal( workFlowDto);
        }

       ActionMessages messages = new ActionMessages();
       ActionMessage message;
       message = new ActionMessage("");
       user.setUserMessage("����ע������ɹ�");
       messages.add( ActionMessages.GLOBAL_MESSAGE, message );
       saveMessages( httpServletRequest, messages );
      
       forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("����ע��");
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
      ActionError error = new ActionError("����ע��");
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
      ActionError error = new ActionError("����ע��");
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
