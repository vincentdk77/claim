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

import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET ʵ���ѯ
 * <p>Title: ��������ʵ���ѯ��Ϣ</p>
 * <p>Description: ��������ʵ��ʵ���ѯ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICompensatePassQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  { 
   
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType   = httpServletRequest.getParameter("editType");//����
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //������
    String claimNo   = httpServletRequest.getParameter("ClaimNo");//�ⰸ��
    String compensateNo   = httpServletRequest.getParameter("CompensateNo") ; //���������

    String operateDate  = httpServletRequest.getParameter("OperateDate");//����ʱ��
    String underWriteFlag = httpServletRequest.getParameter("compensateFlag");//�����־
 
    //ȥ��compensateFlag�����һ������
    if(underWriteFlag!=null&&underWriteFlag.trim().length()>0){
      underWriteFlag = underWriteFlag.substring(0,underWriteFlag.length()-1);	
    }
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //����

    String forward  = "";                                          //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")||editType.equals("RegistBeforeQuery")) {
        //��ѯʵ��r��Ϣ,�������룬���ڳ�ʼ������ʾ

        //��Ҫ���з�ҳ����
        //ÿҳ��ʾ������
        String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
        SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
        sunnyCompensateViewHelper.searchPassCompensate(httpServletRequest,compensateNo,policyNo,claimNo,operateDate,underWriteFlag,pageNo,recordPerPage);
        forward = "success";
      }
    }  
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
