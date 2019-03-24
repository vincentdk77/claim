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
 * 分发HTTP GET 车险理赔报案前查询保单请求
 * <p>Title: 车险理赔报案前查询保单信息</p>
 * <p>Description: 车险理赔报案前查询保单信息系统样本程序</p>
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
    String policyNo     = httpServletRequest.getParameter("policyNo"); //保单号
    //String curRegistNo  = httpServletRequest.getParameter("curRegistNo"); //报案号   
    String idcard = httpServletRequest.getParameter("idcard"); 
    
    String riskCode = "";                           //险种
    String forward  = "";                           //向前

    try
    {	
        //原因：要在界面上显示一些立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();
        Collection registClaimDtoList = (Collection) uiClaimAction.findByPolicyNo(policyNo,idcard);
        
        httpServletRequest.setAttribute("registClaimDtoList", registClaimDtoList);
        //httpServletRequest.setAttribute("curRegistNo", curRegistNo);

        //DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        //dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,policyNo,curRegistNo);
        
        riskCode = BusinessRuleUtil.getRiskCode(policyNo,"PolicyNo");
          
        //取得forward 2005-09-26
        UICodeAction uicodeAction = new UICodeAction();
        forward = "target1";
    
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      httpServletRequest.setAttribute("errorMessage",usee.getMessage()) ;
      forward = "error";
      //throw usee;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //错误信息处理
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      forward = "error";
    }
    finally
    {
    }
    return actionMapping.findForward(forward);
  }
}
