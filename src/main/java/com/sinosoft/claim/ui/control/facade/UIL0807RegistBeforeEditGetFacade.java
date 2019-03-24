package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpChospitalPersonFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpChospitalPersonDto;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
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
public class UIL0807RegistBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception {
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType     = httpServletRequest.getParameter("editType");
    String policyNo     = httpServletRequest.getParameter("prpCmainPolicyNo");   //保单号
    String registNo     = httpServletRequest.getParameter("prpLregistRegistNo"); //报案号
    String damageDate   = httpServletRequest.getParameter("damageDate");//出险日期
    String damageHour   = httpServletRequest.getParameter("damageHour");//出险小时
    
    String editForward  = editType;                 //最后做跳转的标志
    String riskCode = "";                           //险种
    String forward  = "";                           //向前
    
    String hospitalNumber = httpServletRequest.getParameter("hospitalNumber"); //医疗证号

    HttpSession session = httpServletRequest.getSession();
    UserDto   user     = (UserDto)session.getAttribute("user");

    try
    {   	
      if (editType.equals("queryBeforeAdd")) {
        policyNo = policyNo.trim() ;
        httpServletRequest.setAttribute("policyNo", policyNo);
        forward="queryBeforeAdd";
      }
      if(editType.equals("ADD")){
    	UIPolicyAction  uiPolicyAction = new UIPolicyAction();
    	PolicyDto  policyDto  =  uiPolicyAction.findByPrimaryKey(policyNo);
    	httpServletRequest.setAttribute("policyDto", policyDto);
    	BLPrpChospitalPersonFacade blPrpChospitalPersonFacade = new BLPrpChospitalPersonFacade();
    	PrpChospitalPersonDto prpChospitalPersonDto = blPrpChospitalPersonFacade.findByPrimaryKey(policyNo, hospitalNumber);
    	if(prpChospitalPersonDto==null){
    		throw new UserException(1,3,"claim","" +
        			"没有您要查找的医疗证号，请确认您输入了正确的号码！");
    	}
    	httpServletRequest.setAttribute("prpChospitalPersonDto", prpChospitalPersonDto);
    	forward="ADD";  
      }
      if("Query".equals(editType)){
    	  String conditions = "1=1";
    	  if(hospitalNumber!=null&&hospitalNumber.length()>0){
    		  conditions = conditions + "and hospitalNumber = '" + hospitalNumber + "'";
    	  }
    	  String insuredName = httpServletRequest.getParameter("insuredName");
    	  if(insuredName!=null&&insuredName.length()>0){
    		  conditions = conditions + "and insuredName = '" + insuredName + "'";
    	  }
    	  String identifyNumber = httpServletRequest.getParameter("identifyNumber");
    	  if(identifyNumber!=null&&identifyNumber.length()>0){
    		  conditions = conditions + "and identifyNumber = '" + identifyNumber + "'";
    	  }
    	  BLPrpChospitalPersonFacade blPrpChospitalPersonFacade = new BLPrpChospitalPersonFacade();
    	  ArrayList insuredList = (ArrayList)blPrpChospitalPersonFacade.findByConditions(conditions);
    	  httpServletRequest.setAttribute("insuredList", insuredList);
    	  forward="Query";
      }


      httpServletRequest.setAttribute("com.sinosoft.forward", forward);
      System.out.println("forward@=" + forward);	
      saveToken(httpServletRequest);
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
      //throw usee;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
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
