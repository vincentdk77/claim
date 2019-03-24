package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.prpall.pubfun.GroupProposalService;

/**
 * 分发HTTP GET 根据被保险人查找相关受益人
 * Title: 根据被保险人查找相关受益人
 * Description: 根据被保险人查找相关受益人
 * @author liuyang
 * @version 1.0
 */
public class UIBeneInfoQueryFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String riskCode = "";
		//familyno
		String serialNo = httpServletRequest.getParameter("serialNo");
		//是显示收益人信息，还是显示保益信息
		String bizType = httpServletRequest.getParameter("bizType");
		String strPolicyNo = httpServletRequest.getParameter("policyno"); // 取保单号
		
		//根据保单号去查险种代码
		BLPrpCmain blPrpCmain = new BLPrpCmain();
		blPrpCmain.getData(strPolicyNo);
		riskCode = blPrpCmain.getArr(0).getRiskCode();
		
		httpServletRequest.setAttribute("virturlRiskCode",
				riskCode);
		//增加团单和个单的控制取值，团单从prpcvirturlitem取，个单从prpcinsured和prpcitemkind里取
		  GroupProposalService groupProposalService = new GroupProposalService();
          boolean VIRTUALITEM_RISK = groupProposalService.isGroupProposal(riskCode);
		
		
		int relationSerialNo = 0;
		String forward = "";
		int i = 0;
		try {
			  HttpSession session = httpServletRequest.getSession();
				if(VIRTUALITEM_RISK){
				    //查询收益人信息
				    if (bizType.equals("beneInfoShow")) {
			
						ArrayList BeneInsuredList = new ArrayList();
						BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
						int intFamilyNo = Integer.parseInt(serialNo);
						String conditions = "policyno = '" + strPolicyNo
						+ "' and familyno= '" + intFamilyNo+"'";
						
						BeneInsuredList = (ArrayList)blPrpCinsuredFacade.findVirturlItemBeneInsuredConditions(conditions);
						httpServletRequest.setAttribute("beneInsuredList",
								BeneInsuredList);
				    }
				  //查询保益信息
				  if (bizType.equals("riskInfoShow")) {
						ArrayList BeneKindList = new ArrayList();
						BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
						int intFamilyNo = Integer.parseInt(serialNo);
						String strConditions = "policyno = '" + strPolicyNo
								+ "' and familyno=" + intFamilyNo;
						BeneKindList = (ArrayList) blPrpCitemKindFacade
								.findVirturlItemByConditions(strConditions);
						httpServletRequest.setAttribute("beneKindList", BeneKindList);
				  }
				 if (bizType.equals("3202InfoShow")) {
						ArrayList BeneKindList = new ArrayList();
						BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
						String strConditions = "policyno = '" + strPolicyNo
								+ "' and model = '" + serialNo + "'";
						BeneKindList = (ArrayList) blPrpCitemKindFacade
								.findByConditions(strConditions);
						httpServletRequest.setAttribute("beneKindList", BeneKindList);
						bizType = "riskInfoShow";
				 }
				
				} else {

						if (bizType.equals("beneInfoShow")) {
							ArrayList prpcinsuredDtoList = (ArrayList) session
									.getAttribute("prpcinsuredDtoList");
							ArrayList BeneInsuredList = new ArrayList();
							PrpCinsuredDto prpCinsuredDto;
							if (prpcinsuredDtoList != null) {
								for (i = 0; i < prpcinsuredDtoList.size(); i++) {
									prpCinsuredDto = (PrpCinsuredDto) prpcinsuredDtoList
											.get(i);
									if (prpCinsuredDto.getRelateserialno() == Integer
											.parseInt(serialNo)
											&& prpCinsuredDto.getInsuredFlag().equals(
													"9")) {
										BeneInsuredList.add(prpCinsuredDto);
									}
								}
							}
							httpServletRequest.setAttribute("beneInsuredList",
									BeneInsuredList);
						}
						if (bizType.equals("riskInfoShow")) {
							// Modify by chenrenda begin 20070625
							// Reason:prpcitemkind对象放到session中，对于团单业务量比较大情况下，系统展现会比较慢，
							// 改为直接根据保单号和分户号取数据
							/*
							 * ArrayList prpcitemkindDtoList =
							 * (ArrayList)session.getAttribute("prpcitemkindDtoList");
							 * ArrayList BeneKindList = new ArrayList(); PrpCitemKindDto
							 * prpCitemKindDto; for (i=0;i<prpcitemkindDtoList.size();i++) {
							 * prpCitemKindDto =
							 * (PrpCitemKindDto)prpcitemkindDtoList.get(i);
							 * if(prpCitemKindDto.getFamilyNo()==Integer.parseInt(serialNo)) {
							 * BeneKindList.add(prpCitemKindDto); } }
							 * httpServletRequest.setAttribute("beneKindList",BeneKindList);
							 */
							ArrayList BeneKindList = new ArrayList();
							BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
							int intFamilyNo = Integer.parseInt(serialNo);
							String strConditions = "policyno = '" + strPolicyNo
									+ "' and familyno=" + intFamilyNo;
							BeneKindList = (ArrayList) blPrpCitemKindFacade
									.findByConditions(strConditions);
							httpServletRequest.setAttribute("beneKindList",
									BeneKindList);
							// Modify by chenrenda end 20070625
		
						}
						if (bizType.equals("3202InfoShow")) {
							ArrayList BeneKindList = new ArrayList();
							BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
							String strConditions = "policyno = '" + strPolicyNo
									+ "' and model = '" + serialNo + "'";
							BeneKindList = (ArrayList) blPrpCitemKindFacade
									.findByConditions(strConditions);
							httpServletRequest.setAttribute("beneKindList",
									BeneKindList);
							bizType = "riskInfoShow";
						}

			}
			// 取得forward
			forward = bizType;

		}

		catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			forward = "error";
		} finally {
		}
		return actionMapping.findForward(forward);
	}
}
