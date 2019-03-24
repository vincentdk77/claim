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
 * �ַ�HTTP �����ⰸ�ŵõ��Ѿ����δ������Ӧ�б���ʾ
 * <p>Title: �����ⰸ�ŵõ��Ѿ����δ������Ӧ�б���ʾ</p>
 * <p>Description: ������������ⰸ�ŵõ��Ѿ����δ������Ӧ�б���ʾ��Ϣϵͳ��������</p>
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
  	System.out.println("������������������������������������������registNo is: "+registNo);
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
