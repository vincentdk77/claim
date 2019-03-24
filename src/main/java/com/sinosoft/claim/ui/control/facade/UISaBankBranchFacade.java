package com.sinosoft.claim.ui.control.facade;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpdBankBranchFacade;
import com.sinosoft.claim.bl.facade.BLSaBankBranchFacade;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;

public class UISaBankBranchFacade  extends Action {
	@Override
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
	    String forward = "";
	    queryBankCode(request,response);
		return actionMapping.findForward(forward);
	}
	public void  queryBankCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletException{
		//ParamUtils paramUtils = new ParamUtils(request);
		HttpSession session = request.getSession();
		//PrpDuserDto user = (PrpDuserDto) (session.getAttribute("user"));
		//BLSaBankBranchFacade blSaBankBranchFacade = new BLSaBankBranchFacade();
		BLPrpdBankBranchFacade blPrpdBankBranchFacade = new BLPrpdBankBranchFacade();
		//int pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
		int pageNo = 1;
		String pageNoStr =request.getParameter("pageNo");
		System.err.println("pageNoStr:"+pageNoStr);
		if(pageNoStr==null||"".equals(pageNoStr)){
			pageNo = 1; 
		}else{
			pageNo = Integer.parseInt(pageNoStr);
		}
		String bankCName = request.getParameter("bankCName");
	    bankCName = bankCName.trim().replace(" ", "");
	    System.err.println(bankCName);
		String conditions = "";
		conditions += conditions + " bank_name like '%"+bankCName+"%'";
		List bankCodeList = new ArrayList();
		String defaultCharset = "UTF-8";
		response.setContentType("text/html; charset=" + defaultCharset);
		try {
			PageRecord pageRecord = blPrpdBankBranchFacade.findByConditions(conditions, pageNo, 100);
			bankCodeList = (ArrayList)pageRecord.getResult();
			//SaBankBranchDto saBankBranchDto = null;
			PrpdBankBranchDto prpdBankBranchDto = null;
			String interfaceTypeStr = "{res:[";
			
            for (int i = 0; i < bankCodeList.size(); i++) {
            	prpdBankBranchDto = (PrpdBankBranchDto)bankCodeList.get(i);
            	String objectCode = prpdBankBranchDto.getBank_name();
            	String objectCname = prpdBankBranchDto.getBank_number();
            	interfaceTypeStr += "{name: \"" +objectCname+ "\",value:\"" + objectCode  +"\"},";
            	if(i==bankCodeList.size()-1){
            		interfaceTypeStr += "{name: \"" +objectCname+ "\",value:\"" + objectCode  +"\"}";
            	}
			}
            interfaceTypeStr +="]}";
            
            
            System.err.println(interfaceTypeStr);
            OutputStream os = response.getOutputStream();
    		os.write(interfaceTypeStr.getBytes(defaultCharset));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
