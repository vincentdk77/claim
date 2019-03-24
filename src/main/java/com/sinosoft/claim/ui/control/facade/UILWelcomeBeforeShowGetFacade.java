package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.UserClaimStatusViewHelper;
import com.sinosoft.claim.ui.view.formbean.LogonForm;

/**
 * 分发HTTP登录请求
 * <p>Title: 理赔样本程序</p>
 * <p>Description: 理赔样本程序 登录facade</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILWelcomeBeforeShowGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception
  {

    LogonForm logonForm = (LogonForm)actionForm;
    UICodeAction uiCodeAction = new UICodeAction();
    String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
    UserDto   user      = (UserDto)httpServletRequest.getSession().getAttribute("user");    //用户信息
    String usercode = user.getUserCode();
    String forward = "false";
    try{

      if ( usercode==null || usercode.trim().equals("") ||riskCode.equals("")||riskCode==null){
        forward = "false"; //检测不到用户或者险别则转发到校验无效页面
      } else {
        //查询用户任务状态
        UserClaimStatusViewHelper userClaimStatusViewHelper = new UserClaimStatusViewHelper();
        userClaimStatusViewHelper.getAllStatsStat(httpServletRequest, user);
        forward = "success";  //登录信息校验有效
      } 
    } catch(Exception e) {
       e.printStackTrace() ;
    }finally{

    }
    return actionMapping.findForward(forward);
  }
}
