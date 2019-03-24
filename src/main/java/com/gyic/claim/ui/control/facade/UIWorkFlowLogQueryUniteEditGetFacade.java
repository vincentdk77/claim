package com.gyic.claim.ui.control.facade;


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
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
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

public class UIWorkFlowLogQueryUniteEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
//    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ

	  String flag=httpServletRequest.getParameter("Flag");
	  if("N".equals(flag)){
		  String policyNo=httpServletRequest.getParameter("PolicyNo");
	      String startDate=httpServletRequest.getParameter("statStartDate");
	      String endDate=httpServletRequest.getParameter("statEndDate");
	      httpServletRequest.setAttribute("StartDate", startDate);
	      httpServletRequest.setAttribute("PolicyNo", policyNo);
	      httpServletRequest.setAttribute("EndDate", endDate);
	  }else{
		  String policyNo=httpServletRequest.getParameter("policyNo");
		  String startDate=httpServletRequest.getParameter("StartDate");
		  String endDate=httpServletRequest.getParameter("EndDate");
		  httpServletRequest.setAttribute("StartDate", startDate);
		  httpServletRequest.setAttribute("PolicyNo", policyNo);  
		  httpServletRequest.setAttribute("EndDate", endDate);  
	  }
      String nodeType     = httpServletRequest.getParameter("nodeType");
      String status      = httpServletRequest.getParameter("status");    //������
      HttpSession session = httpServletRequest.getSession();
      String editType= httpServletRequest.getParameter("editType");
      String isFirst		= httpServletRequest.getParameter("isFirst"); //�Ƿ��һ�ν�������һ�ν�������ѯ���
      String forward  = "";  
    try
    { 
    	//��һ�ν�������־Ϊ�յģ����Զ�����г�ʼ�����ڶ��ν�����ȡ����ҳ���ֵ�����Բ�Ϊ�գ����ô���
    	if(isFirst == null || "".equals(isFirst)){
    		isFirst = "Y";
    	}
    	httpServletRequest.setAttribute("isFirst", isFirst);	
    	 WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        //��ѯ������״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
		//��Ҫ���з�ҳ����
		//ÿҳ��ʾ������
    	String isFirstFlag=httpServletRequest.getParameter("isFirstFlag");
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
		if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
		if("1".equals(isFirstFlag)){
			
		}else{
			  String registNos= httpServletRequest.getParameter("checkBox");
			  httpServletRequest.setAttribute("checkBox", registNos);
              workFlowViewHelper.getComBineWorkFlowLogList(httpServletRequest,pageNo,recordPerPage);
		}
        forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.combine.queryCombineListNot");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.combine.queryCombineListNot");
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
