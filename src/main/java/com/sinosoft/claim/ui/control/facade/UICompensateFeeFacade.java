package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;

/**
 * 分发HTTP 根据赔案号得到已决赔款未决赔款对应列表及显示
 * <p>Title: 根据赔案号得到已决赔款未决赔款对应列表及显示</p>
 * <p>Description: 车险理赔根据赔案号得到已决赔款未决赔款对应列表及显示信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */
public class UICompensateFeeFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
  	
  	String forward = "success";
  	String registNo = httpServletRequest.getParameter("prpLregistRegistNo");
  	System.out.println("－－－－－－－－－－－－－－－－－－－－－registNo is: "+registNo);
  	//CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
  	DAARegistViewHelper daaRegistViewHelper = new DAARegistViewHelper();
  	//if(registNo!=null&&)
  	CompensateFeeDto compensateFeeDto = new   	CompensateFeeDto();
    compensateFeeDto = daaRegistViewHelper.getCompensateFeeByRegistNo(registNo);
    
   	System.out.println("--------2---compensateFeeDto getSumNoPaid is :"+compensateFeeDto.getSumNoPaid());
	System.out.println("-------2----compensateFeeDto getSumPaid is :"+compensateFeeDto.getSumPaid());
	System.out.println("-------2----compensateFeeDto getSumClaim is :"+compensateFeeDto.getSumClaim());
  	httpServletRequest.setAttribute("compensateFeeDto",compensateFeeDto);
  	
    return actionMapping.findForward(forward);
  }

}
