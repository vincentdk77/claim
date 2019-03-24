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

import com.sinosoft.claim.ui.control.viewHelper.DAAPrepayViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 立案查询
 * <p>Title: 车险理赔立案查询信息</p>
 * <p>Description: 车险理赔立案立案查询信息系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIPrepayQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType   = httpServletRequest.getParameter("editType");
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //保单号
    String claimNo   = httpServletRequest.getParameter("ClaimNo") ; //赔案号
    String prepayNo   = httpServletRequest.getParameter("PrepayNo") ; //预赔登记号
    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间,核赔标志查询条件
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//车牌号
    String status     = httpServletRequest.getParameter("caseFlag");//案件状态
    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间
    String underWriteFlag = httpServletRequest.getParameter("prepayFlag");//核赔标志

    //去掉status中最后一个逗号
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    System.out.println("这里显示状态标志"+status);

    //去掉compensateFlag中最后一个逗号
    if(underWriteFlag!=null&&underWriteFlag.trim().length()>0){
      underWriteFlag = underWriteFlag.substring(0,underWriteFlag.length()-1);	
    }
    System.out.println("这里显示核赔标志"+underWriteFlag);

    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种
    String forward  = "";                                            //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW"))
      {
        //查询预赔信息,整理输入，用于初始界面显示

        DAAPrepayViewHelper dAAPrepayViewHelper = new DAAPrepayViewHelper();
        dAAPrepayViewHelper.setPrpLprepayDtoToView(httpServletRequest,prepayNo,policyNo,claimNo,licenseNo,status,operateDate,underWriteFlag);

        forward = "success";

      }
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error"; 
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
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
