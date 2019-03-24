package com.gyic.claim.ui.control.facade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET
 * <p>Title: 养殖险合并案件</p>
 * <p>Description: 养殖险合并案件</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Sinosoft</p>
 * @author qianxiantao
 * @version 1.0
 */

public class UIClaimCompensateGetListFacade extends Action
{
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)
	  throws Exception
	  {
		  String flag=httpServletRequest.getParameter("Flag");
		     if("N".equals(flag)){
		      String comBineNo=httpServletRequest.getParameter("ComBineNo");
		      String policyNo=httpServletRequest.getParameter("PolicyNo");
		      String startDate=httpServletRequest.getParameter("statStartDate");
		      String endDate=httpServletRequest.getParameter("statEndDate");
		      String registNo=httpServletRequest.getParameter("RegistNo");
		      String claimNo=httpServletRequest.getParameter("ClaimNo");
		      String nodeStatus=httpServletRequest.getParameter("status");
		      httpServletRequest.setAttribute("ClaimNo", claimNo);
		      httpServletRequest.setAttribute("RegistNo", registNo);
		      httpServletRequest.setAttribute("StartDate", startDate);
		      httpServletRequest.setAttribute("EndDate", endDate);
		      httpServletRequest.setAttribute("PolicyNo", policyNo);
		      httpServletRequest.setAttribute("ComBineNo", comBineNo);
		      httpServletRequest.setAttribute("status", nodeStatus);
		     }else{
		      String nodeStatus=httpServletRequest.getParameter("status");
		      String registNo=httpServletRequest.getParameter("registNo");
			  String claimNo=httpServletRequest.getParameter("claimNo");
			  String startDate=httpServletRequest.getParameter("StartDate");
			  String endDate=httpServletRequest.getParameter("EndDate");
			  httpServletRequest.setAttribute("StartDate", startDate);
			  httpServletRequest.setAttribute("EndDate", endDate); 
			  String policyNo=httpServletRequest.getParameter("policyNo");
			  httpServletRequest.setAttribute("PolicyNo", policyNo); 
			  String comBineNo=httpServletRequest.getParameter("comBineNo");
			  httpServletRequest.setAttribute("ComBineNo", comBineNo); 
			  httpServletRequest.setAttribute("status", nodeStatus);
		      }
		    String forward="";
		    String condition="";
		    String policyNo=httpServletRequest.getParameter("PolicyNo");
		    String RegistNo=httpServletRequest.getParameter("RegistNo");
		    String ComBineNo=httpServletRequest.getParameter("ComBineNo");
		    String isFirstFlag=httpServletRequest.getParameter("isFirstFlag");
		    String isFirst=httpServletRequest.getParameter("isFirst");
		    try{
		    	if(isFirst == null || "".equals(isFirst)){
		    		isFirst = "Y";
		    	}
		    httpServletRequest.setAttribute("isFirst", isFirst);
		    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		    String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
			String pageNo     = httpServletRequest.getParameter("pageNo");
			if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
			if("1".equals(isFirstFlag)){
				
			}else{
				workFlowViewHelper.getComBineCompensateListByConditions(httpServletRequest, condition, pageNo, recordPerPage);
			}
			forward = "success";
		    }catch(Exception e){
		        e.printStackTrace();
		        ActionErrors errors = new ActionErrors();
		        ActionError error = new ActionError("title.combine.queryCombineList");
		        errors.add(ActionErrors.GLOBAL_ERROR, error);
		        httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
		        saveErrors(httpServletRequest, errors);
		    }finally{
		       return actionMapping.findForward("success");  
		    }
	  }
	}
