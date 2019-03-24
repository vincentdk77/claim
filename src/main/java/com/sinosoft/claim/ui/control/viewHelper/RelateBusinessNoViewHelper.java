package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.platform.bl.facade.BLPrpDriskFacade;
import com.sinosoft.platform.dto.domain.PrpDriskDto;

/**
 * 关联页面相关数据整理
 * <p>
 * Title: 关联页面相关数据整理
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:sinosoft
 * </p>
 * 
 * @author sunhao
 * @version 1.0
 */
public class RelateBusinessNoViewHelper {
	Log log = LogFactory.getLog(RelateBusinessNoViewHelper.class);
	public RelateBusinessNoViewHelper() {
	}

	/**
	 * 关联页面查询相关信息
	 * 
	 * @param httpServletRequest request
	 * @throws Exception
	 * 
	 */

	public void queryRelateInfoToDto(HttpServletRequest request)
			throws Exception {
		UIRegistAction uiRegistAction = new UIRegistAction();
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		UIEndorseAction uiEndorseAction =new UIEndorseAction();
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

		//获得页面传入的保单号码
		String policyNo = request.getParameter("policyNo");

		log.debug("进入关联Action:RelateBusinessNoViewHelper,获得的保单号是:"+policyNo);
		// 1.获得保单信息(单条)
		
		PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
		//只需要保单主信息即可
		PrpCmainDto  prpCmainDto = policyDto.getPrpCmainDto();
		
		// 2.获得批单信息(多条)
		List headList = (List)(uiEndorseAction.findByConditions(policyNo)).getPrpPheadDtoList();
		//传到前台是空长度的集合而不要传空指针
		if(headList==null)	headList = new ArrayList();
		
		// 3.获得理赔信息(多条)
		
		
		List registList = (List)(uiRegistAction.findRegistsByPolicyno(policyNo));
		if(registList==null) registList = new ArrayList();
		if(registList.size() == 0 ){
			List registListTemp = (List) new UIPrpLregistRPolicyAction().findByConditions("policyNo = '" + policyNo + "'");
			for (Iterator iterator = registListTemp.iterator();iterator.hasNext();){
				PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)iterator.next();
				PrpLregistDto prpLregistDto = uiRegistAction.findByPrimaryKey(prpLRegistRPolicyDto.getRegistNo()).getPrpLregistDto();
				prpLregistDto.setCompensateFeeDto(uiRegistAction.getCompensateFeeByRegistNo(prpLRegistRPolicyDto.getRegistNo()));
				prpLregistDto.setWorkFlowId(uiWorkFlowAction.findFlowIDByRegistNo(prpLRegistRPolicyDto.getRegistNo()));
				registList.add(prpLregistDto);
			}
		}
		
		else{
		// 下面分别计算每个报案的赔款金额
		for (Iterator iter = registList.iterator(); iter.hasNext();) {
			PrpLregistDto prpLregistDto = (PrpLregistDto) iter.next();
			// 设置报案信息的赔款金额
			prpLregistDto.setCompensateFeeDto(uiRegistAction.getCompensateFeeByRegistNo(prpLregistDto.getRegistNo()));
			prpLregistDto.setWorkFlowId(uiWorkFlowAction.findFlowIDByRegistNo(prpLregistDto.getRegistNo()));
			if("".equals(prpLregistDto.getWorkFlowId())){
				prpLregistDto.setWorkFlowId(uiWorkFlowAction.findStoreFlowIDBybusinessNo(prpLregistDto.getRegistNo()));
			}
		 }
		}
		
		// 处理险种代码，如果某一险种采用的是公共险种，则此处需要特殊处理
		// 代码copy自prpall\src\main\webapp\common\pub\UILogonSubmit.jsp
		String strRiskCode = prpCmainDto.getRiskCode();
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
		PrpDriskDto prpDriskDto = blPrpDriskFacade.findByPrimaryKey(strRiskCode);
		if(prpDriskDto.getFlag().length()>=3)
        {
          // 通用险种（财产）：00Q1
          if(prpDriskDto.getFlag().substring(1,3).equals("Q1"))
        	  strRiskCode = "00Q1";
          // 通用险种（责任1）：00Z1
          else if(prpDriskDto.getFlag().substring(1,3).equals("Z1"))
        	  strRiskCode = "00Z1";
          // 通用险种（责任2）：00Z2
          else if(prpDriskDto.getFlag().substring(1,3).equals("Z2"))
        	  strRiskCode = "00Z2";
          // 通用险种（货运1）：00Y1
          else if(prpDriskDto.getFlag().substring(1,3).equals("Y1"))
        	  strRiskCode = "00Y1";
          // 通用险种（货运2）：00Y2
          else if(prpDriskDto.getFlag().substring(1,3).equals("Y2"))
        	  strRiskCode = "00Y2";
          // 通用险种（船舶）：00C1
          else if(prpDriskDto.getFlag().substring(1,3).equals("C1"))
        	  strRiskCode = "00C1";
          else if(prpDriskDto.getFlag().substring(1,3).equals("G1"))
        	  strRiskCode = "00G1";
          else if(prpDriskDto.getFlag().substring(1,3).equals("E1"))
        	  strRiskCode = "00E1";
          else if(prpDriskDto.getFlag().substring(1,3).equals("H1"))
        	  strRiskCode = "00H1";
        }
		prpCmainDto.setRiskCode(strRiskCode);
		
		//设置保单主信息
		request.setAttribute("prpCmainDto",prpCmainDto);
		//设置批单信息(List中保存的是PrpPheadDto对象)
		request.setAttribute("headList",headList);
		//设置报案信息(List中保存的是:prpLregistDto对象)
		request.setAttribute("registList",registList);
	}

}
