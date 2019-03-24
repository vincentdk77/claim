package com.gyic.claim.ui.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;
import com.gyic.claim.bl.action.domain.*;
import com.gyic.claim.bl.facade.*;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.sinosoft.sysframework.reference.DBManager;

public class UIDeleteMedicalSettleListAction extends Action{
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)throws Exception{
		String forward= "success";
		String[] settleIndexes = httpServletRequest.getParameterValues("settleIndexes");
		String settleListCode = httpServletRequest.getParameter("settleListCode");
		String policyNo = httpServletRequest.getParameter("policyNo");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String registNo = httpServletRequest.getParameter("registNo");
		String editType = httpServletRequest.getParameter("editType");
		String compensateNo = httpServletRequest.getParameter("compensateNo");
		String claimNo = httpServletRequest.getParameter("claimNo");
		httpServletRequest.setAttribute("policyNo", policyNo);
		httpServletRequest.setAttribute("nodeType", nodeType);
		httpServletRequest.setAttribute("registNo", registNo);
		httpServletRequest.setAttribute("editType", editType);
		httpServletRequest.setAttribute("compensateNo", compensateNo);
		httpServletRequest.setAttribute("claimNo", claimNo);
		String deleteAll = httpServletRequest.getParameter("deleteAll");
		if(null!=settleListCode && !"".equals(settleListCode) && null!=nodeType && !"".equals(nodeType)){
			DBManager dbManager = new DBManager();
			dbManager.open("JKXDataSource");
			dbManager.beginTransaction();
			try {
				BLMedicalsettlelistAction blMedicalSettleListAction = new BLMedicalsettlelistAction();
				if(null!=deleteAll && "deleteAll".equals(deleteAll)){
					String sqlCondition = " settleListCode like '"+settleListCode+"' and nodeType like '"+nodeType+"'";
					blMedicalSettleListAction.deleteByConditions(dbManager,sqlCondition);
					dbManager.commitTransaction();
				}else if(null!=settleIndexes && settleIndexes.length>0){
					for(int i=0;i<settleIndexes.length;i++){
						String sqlCondition = " settleListCode like '"+settleListCode+"' and nodeType like '"+nodeType+"' and indexOfSettle like '"+settleIndexes[i]+"'";
						blMedicalSettleListAction.deleteByConditions(dbManager,sqlCondition);
					}
					dbManager.commitTransaction();
				}else{
					httpServletRequest.setAttribute("deleteErrorMessage", "理赔清单："+settleListCode+"删除失败！");
					return actionMapping.findForward("message");
				}
			}catch(Exception exception){
	            dbManager.rollbackTransaction();
				httpServletRequest.setAttribute("deleteErrorMessage", "理赔清单："+settleListCode+"删除失败！");
				return actionMapping.findForward("message");
	        }finally{
	            dbManager.close();
	        }
		}else{
			httpServletRequest.setAttribute("deleteErrorMessage", "理赔清单号："+settleListCode+" 或者节点名称："+nodeType+" 有误！");
			return actionMapping.findForward("error");
		}
		return actionMapping.findForward(forward);
	}
	public boolean deleteSettleLists(String settleListCode, String nodeType, String riskCode, DBManager dbManager)throws Exception{
		boolean success = false;
		try {
			if(null!=settleListCode && !"".equals(settleListCode)
					&&null!=nodeType && !"".equals(nodeType)
					&&null!=riskCode && !"".equals(riskCode)){
				String sqlCondition = " settleListCode like '"+settleListCode+"' and nodeType like '"+nodeType
										+"' and riskCode like '"+riskCode+"' ";
				BLMedicalsettlelistAction blMedicalSettleListAction = new BLMedicalsettlelistAction();
				blMedicalSettleListAction.deleteByConditions(dbManager,sqlCondition);
				success = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

}
