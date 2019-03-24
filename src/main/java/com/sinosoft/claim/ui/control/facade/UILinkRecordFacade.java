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

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.LinkRecordViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 报案查询
 * <p>Title: 车险理赔报案查询信息</p>
 * <p>Description: 车险理赔报案报案查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UILinkRecordFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
    String editType   = httpServletRequest.getParameter("editType");    //类型
	System.err.println("==================editType:" + editType);
    String registNo   = httpServletRequest.getParameter("RegistNo") ;    //报案号
    String claimNo   = httpServletRequest.getParameter("claimNo") ;    //赔案号
	String userCode = "";
	String comCode = "";
	String riskCode = httpServletRequest.getParameter("riskcode");
    String forward  = "";  
    WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
    workFlowQueryDto.setRegistNo(registNo);
    workFlowQueryDto.setClaimNo(claimNo);
    workFlowQueryDto.setRiskCode(riskCode);
    try
    {
      HttpSession session = httpServletRequest.getSession();
	  UserDto userDto = (UserDto)session.getAttribute("user");
	  if(userDto != null){
	  userCode = userDto.getUserCode();
	  comCode = userDto.getComCode();
	  }
      if (editType.equals("prepareUpdate") || editType.equals("prepareInsert") ||editType.equals("view")||editType.equals("preparePrint")) {
		  LinkRecordViewHelper linkRecordViewHelper = new LinkRecordViewHelper();
		  linkRecordViewHelper.setLinkRecordDToView(httpServletRequest,claimNo,userCode,
		             riskCode,  comCode,  editType);
		  forward = editType;
      } else if(editType.equalsIgnoreCase("queryList")){
		    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //保单号
		    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
		    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//车牌号
		    String status     = httpServletRequest.getParameter("caseFlag");//案件状态
		    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间
		    workFlowQueryDto.setLicenseNo(licenseNo);
		    workFlowQueryDto.setStatus(status);
		    workFlowQueryDto.setOperateDate(operateDate);
	        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
	        dAAClaimViewHelper.setPrpLclaimDtoToView(httpServletRequest,workFlowQueryDto);
			 forward = "queryList";
      }else if(editType.equalsIgnoreCase("query")){
		  forward = "query";
      }
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
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
