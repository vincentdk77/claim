package com.sinosoft.common_claim.bl.action.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class UISDAcciClaimToPlatFacade extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String forward = "input";
		String claimNo = request.getParameter("claimNo").trim();
		String serviceType = request.getParameter("serviceType").trim();
		DBManager dbManager = new DBManager();
		String groupFlag = "";
		boolean isSuccess = false;
		String message = "";
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
			BLPrpCmain blPrpCmain = new BLPrpCmain();
			blPrpCmain.getData(prpLclaimDto.getPolicyNo());
			if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
				groupFlag = "0";//个体
			}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
				groupFlag = "1";//团体
			}
			if("L01".equals(serviceType)){//立案登记接口补传
				isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L01", claimNo, groupFlag);
				if(isSuccess){
					message = "山东意外险风险预警立案登记接口补传成功!";
				}else{
					message = "山东意外险风险预警立案登记接口补传失败!";
				}
			}else if("L02".equals(serviceType)){//结案登记接口补传
				isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", claimNo, groupFlag);
				if(isSuccess){
					message = "山东意外险风险预警结案登记接口补传成功!";
				}else{
					message = "山东意外险风险预警结案登记接口补传失败!";
				}
			}
			request.setAttribute("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return mapping.findForward(forward);
		
	}
}
