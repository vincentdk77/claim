package com.gyic.claim.ui.control.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.reins.out.bl.facade.BLReCreateRepolicyFacade;
import com.sinosoft.reins.out.ui.control.action.UIReCreateRepolicyAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
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

public class UIClaimComBineAction extends Action
{
	
		  /**
		   * @param  
		   * @return 
		   * @author 
		   */
		  public String claimComBine(PrplcombineDto prplcombineDto) throws SQLException,Exception
		  {
			  BLPrplcombineFacade  bLPrplcombineFacade = new BLPrplcombineFacade();
			  bLPrplcombineFacade.insert(prplcombineDto);
			  return null;
		  }
}