package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
 

/**
 * 分发HTTP Post 车险理赔三者车辆界面
 * <p>Title: 车险理赔报案三者车辆信息</p>
 * <p>Description: 车险理赔报案三者车辆信息</p>
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
     
    String forward  = "";                                          //向前流转

    PrpLregistDto prpLregistDto = new PrpLregistDto();             //DTO报案
    //UIRegistAction uiRegistAction = new UIRegistAction();        //报案Action


    forward = "success";
     
    return actionMapping.findForward(forward);
  }
}
