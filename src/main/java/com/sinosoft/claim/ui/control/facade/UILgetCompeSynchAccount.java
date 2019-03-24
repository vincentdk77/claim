package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;


public class UILgetCompeSynchAccount extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		String registNo = request.getParameter("registNo");
		String conditions = " 1 = 1 ";
		BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
		String[] registNoList = null;
		String strRegistNo = "";
		if(null!=registNo && !"".equals(registNo)){
			registNoList = registNo.split(",");
			for(int i=0;i<registNoList.length;i++){
				if(i==0){
					strRegistNo = "'"+registNoList[i]+"'";
				}else{
					strRegistNo += ",'"+registNoList[i]+"'";
				}
			}
			conditions +=  " and (receivername is not null or bank is not null or account is not null) and claimno in (select claimno from prplclaim where registno in ("+strRegistNo+"))";
		}
		
		
		try {
			ArrayList blPrpLcompensateList = (ArrayList)blPrpLcompensateFacade.findByConditions(conditions);
			String claimRelationNoList = "";
			for(int num=0;num<blPrpLcompensateList.size();num++){
				PrpLcompensateDto iPrpLcompensateDto= (PrpLcompensateDto)blPrpLcompensateList.get(num);
				if(null!=claimRelationNoList && !"".equals(claimRelationNoList)){
					claimRelationNoList += ",'"+iPrpLcompensateDto.getClaimRelationNo()+"'";
				}else{
					claimRelationNoList += "'"+iPrpLcompensateDto.getClaimRelationNo()+"'";
				}
			}
			if(null!=claimRelationNoList && !"".equals(claimRelationNoList)){
				BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
				String newQuery = " settlelistcode in ("+claimRelationNoList+") and nodetype='compe' ";
				
				ArrayList plantingsettlelist = (ArrayList)blPlantingsettlelistFacade.findAccountByConditions(newQuery);
				for(int i=0;i<plantingsettlelist.size();i++){
					PlantingsettlelistDto plantingsettlelistDto = (PlantingsettlelistDto)plantingsettlelist.get(i);
					PrpLcompensateDto iPrpLcompensateDto = new PrpLcompensateDto();
					iPrpLcompensateDto.setAccount(plantingsettlelistDto.getZhibuka());
					iPrpLcompensateDto.setBank(plantingsettlelistDto.getBank());
					iPrpLcompensateDto.setReceiverName(plantingsettlelistDto.getFname());
					iPrpLcompensateDto.setCompensateNo(plantingsettlelistDto.getSettlelistcode());
					blPrpLcompensateList.add(iPrpLcompensateDto);
				}
			}
			
			
			request.setAttribute("blPrpLcompensateList", blPrpLcompensateList);
			
		} catch (Exception e) {
			response.getWriter().write("false#");//不存在委托
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
			request.setAttribute("errorMessage", stringWriter.toString());
		}
		
		return mapping.findForward(forward);
	}
}
