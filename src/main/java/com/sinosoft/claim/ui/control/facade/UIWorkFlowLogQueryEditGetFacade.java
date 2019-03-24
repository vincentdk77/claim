package com.sinosoft.claim.ui.control.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET ������״̬��ѯ
 * <p>Title: �������⹤������ѯ��Ϣ</p>
 * <p>Description: �������⹤������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowLogQueryEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String nodeType     = httpServletRequest.getParameter("nodeType");
    String caseFlag     = httpServletRequest.getParameter("caseFlag");
    String status      = httpServletRequest.getParameter("status");    //������
    HttpSession session = httpServletRequest.getSession();
    String editType= httpServletRequest.getParameter("editType");
    String funcName=httpServletRequest.getParameter("FuncName"); //ֻ����ע��/���������ʱ��������õ�
    String isFirst		= httpServletRequest.getParameter("isFirst"); //�Ƿ��һ�ν�������һ�ν�������ѯ���
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String forward  = "";  
    String comLevel ="" ; 
    try
    { 
    	//��һ�ν�������־Ϊ�յģ����Զ�����г�ʼ�����ڶ��ν�����ȡ����ҳ���ֵ�����Բ�Ϊ�գ����ô���
    	if(isFirst == null || "".equals(isFirst)){
    		isFirst = "Y";
    	}
    	httpServletRequest.setAttribute("isFirst", isFirst);
       //�����Ƿ����ܹ�˾-----------------------------
    	if ("verip".equals(nodeType)){
    		UICodeAction uiCodeAction = new UICodeAction();
    		comLevel = uiCodeAction.getComLevel(user.getComCode());
        	httpServletRequest.setAttribute("comLevel",comLevel);
    	}
    	//----------------------------
    	
    	WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        //��ѯ������״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
		//��Ҫ���з�ҳ����
		//ÿҳ��ʾ������
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
		if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
        if(editType!=null&&editType.trim().equals("specialQuery")){
          //�����ⰸ��ѯ
          workFlowViewHelper.getSwfLogList(httpServletRequest,caseFlag,userCode,nodeType);
          return actionMapping.findForward("specialQuery");
        } else if(editType!=null&&editType.trim().equals("welcome")){//��ҳ���б�����ʱ��
          workFlowViewHelper.getWorkFlowLogList(httpServletRequest,nodeType,status,"",pageNo,"10000");
          return actionMapping.findForward("success");
        }  else {
          workFlowViewHelper.getWorkFlowLogList(httpServletRequest,nodeType,status,"",pageNo,recordPerPage);
//          String startDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addMonth(-1).toString();
//          String todayDate = sdf.format(new Date());
//          httpServletRequest.setAttribute("startDate", startDate);
//          httpServletRequest.setAttribute("todayDate", todayDate);
        }
        forward = "success";
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

    return actionMapping.findForward(forward);
  }

}
