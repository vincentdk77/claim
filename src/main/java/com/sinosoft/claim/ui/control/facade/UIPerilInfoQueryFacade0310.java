package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET �������ⱨ��ǰ��ѯ��������
 * <p>Title: �������ⱨ��ǰ��ѯ������Ϣ</p>
 * <p>Description: �������ⱨ��ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIPerilInfoQueryFacade0310 extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception {
    String policyNo     = httpServletRequest.getParameter("policyNo"); //������
    //String curRegistNo  = httpServletRequest.getParameter("curRegistNo"); //������   
    String idcard = httpServletRequest.getParameter("idcard"); 
    
    String riskCode = "";                           //����
    String forward  = "";                           //��ǰ

    try
    {	
        //ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();
        Collection registClaimDtoList = (Collection) uiClaimAction.findByPolicyNo(policyNo,idcard);
        
        httpServletRequest.setAttribute("registClaimDtoList", registClaimDtoList);
        //httpServletRequest.setAttribute("curRegistNo", curRegistNo);

        //DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        //dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,policyNo,curRegistNo);
        
        riskCode = BusinessRuleUtil.getRiskCode(policyNo,"PolicyNo");
          
        //ȡ��forward 2005-09-26
        UICodeAction uicodeAction = new UICodeAction();
        forward = "target1";
    
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      httpServletRequest.setAttribute("errorMessage",usee.getMessage()) ;
      forward = "error";
      //throw usee;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //������Ϣ����
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      forward = "error";
    }
    finally
    {
    }
    return actionMapping.findForward(forward);
  }
}
