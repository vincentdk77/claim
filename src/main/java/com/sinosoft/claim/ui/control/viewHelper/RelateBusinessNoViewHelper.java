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
 * ����ҳ�������������
 * <p>
 * Title: ����ҳ�������������
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
	 * ����ҳ���ѯ�����Ϣ
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

		//���ҳ�洫��ı�������
		String policyNo = request.getParameter("policyNo");

		log.debug("�������Action:RelateBusinessNoViewHelper,��õı�������:"+policyNo);
		// 1.��ñ�����Ϣ(����)
		
		PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
		//ֻ��Ҫ��������Ϣ����
		PrpCmainDto  prpCmainDto = policyDto.getPrpCmainDto();
		
		// 2.���������Ϣ(����)
		List headList = (List)(uiEndorseAction.findByConditions(policyNo)).getPrpPheadDtoList();
		//����ǰ̨�ǿճ��ȵļ��϶���Ҫ����ָ��
		if(headList==null)	headList = new ArrayList();
		
		// 3.���������Ϣ(����)
		
		
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
		// ����ֱ����ÿ�������������
		for (Iterator iter = registList.iterator(); iter.hasNext();) {
			PrpLregistDto prpLregistDto = (PrpLregistDto) iter.next();
			// ���ñ�����Ϣ�������
			prpLregistDto.setCompensateFeeDto(uiRegistAction.getCompensateFeeByRegistNo(prpLregistDto.getRegistNo()));
			prpLregistDto.setWorkFlowId(uiWorkFlowAction.findFlowIDByRegistNo(prpLregistDto.getRegistNo()));
			if("".equals(prpLregistDto.getWorkFlowId())){
				prpLregistDto.setWorkFlowId(uiWorkFlowAction.findStoreFlowIDBybusinessNo(prpLregistDto.getRegistNo()));
			}
		 }
		}
		
		// �������ִ��룬���ĳһ���ֲ��õ��ǹ������֣���˴���Ҫ���⴦��
		// ����copy��prpall\src\main\webapp\common\pub\UILogonSubmit.jsp
		String strRiskCode = prpCmainDto.getRiskCode();
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
		PrpDriskDto prpDriskDto = blPrpDriskFacade.findByPrimaryKey(strRiskCode);
		if(prpDriskDto.getFlag().length()>=3)
        {
          // ͨ�����֣��Ʋ�����00Q1
          if(prpDriskDto.getFlag().substring(1,3).equals("Q1"))
        	  strRiskCode = "00Q1";
          // ͨ�����֣�����1����00Z1
          else if(prpDriskDto.getFlag().substring(1,3).equals("Z1"))
        	  strRiskCode = "00Z1";
          // ͨ�����֣�����2����00Z2
          else if(prpDriskDto.getFlag().substring(1,3).equals("Z2"))
        	  strRiskCode = "00Z2";
          // ͨ�����֣�����1����00Y1
          else if(prpDriskDto.getFlag().substring(1,3).equals("Y1"))
        	  strRiskCode = "00Y1";
          // ͨ�����֣�����2����00Y2
          else if(prpDriskDto.getFlag().substring(1,3).equals("Y2"))
        	  strRiskCode = "00Y2";
          // ͨ�����֣���������00C1
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
		
		//���ñ�������Ϣ
		request.setAttribute("prpCmainDto",prpCmainDto);
		//����������Ϣ(List�б������PrpPheadDto����)
		request.setAttribute("headList",headList);
		//���ñ�����Ϣ(List�б������:prpLregistDto����)
		request.setAttribute("registList",registList);
	}

}
