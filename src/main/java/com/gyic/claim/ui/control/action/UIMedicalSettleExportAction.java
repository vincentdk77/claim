package com.gyic.claim.ui.control.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.utils.PlantingSettleExport;
import com.gyic.claim.utils.*;
import com.sinosoft.reins.out.bl.facade.BLReCreateRepolicyFacade;
import com.sinosoft.reins.out.ui.control.action.UIReCreateRepolicyAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIMedicalSettleExportAction extends Action{
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)throws Exception{
		String mappingRes=null;
		ServletContext servletContext = getServlet().getServletContext();
		String rootPath = servletContext.getRealPath("/bea");
		MedicalSettleExport medicalSettleExport = new MedicalSettleExport();
		mappingRes=medicalSettleExport.medicalExportAct(httpServletRequest,httpServletResponse,rootPath);
		return actionMapping.findForward(mappingRes);
	}
	

}
