package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
 

/**
 * �ַ�HTTP Post �����������߳�������
 * <p>Title: �������ⱨ�����߳�����Ϣ</p>
 * <p>Description: �������ⱨ�����߳�����Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILThirdPartyEditPostFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    String forward  = "";                                          //��ǰ��ת

    PrpLregistDto prpLregistDto = new PrpLregistDto();             //DTO����
    //UIRegistAction uiRegistAction = new UIRegistAction();        //����Action


    forward = "success";
     
    return actionMapping.findForward(forward);
  }
}
