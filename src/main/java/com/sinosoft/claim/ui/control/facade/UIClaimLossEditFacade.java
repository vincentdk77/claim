package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
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

public class UIClaimLossEditFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
    String forward  = "";                                          //向前
    try
    {
      ClaimDto claimDto =null;
      String claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); //赔案号
      httpServletRequest.setAttribute("claimNo", claimNo);      
      double sumClaim=0;
      DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
//      claimDto = dAAClaimViewHelper.viewToLossDto(httpServletRequest);
      claimDto = dAAClaimViewHelper.viewToDto(httpServletRequest);
      
       BLClaimFacade blClaimFacade = new BLClaimFacade();
       sumClaim=(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumClaim"))));
	blClaimFacade.UpdSumClaim(claimDto,claimNo,sumClaim);
      forward = "success";	

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
