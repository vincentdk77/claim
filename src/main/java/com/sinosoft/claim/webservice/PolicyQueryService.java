package com.sinosoft.claim.webservice;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;

/**
 * ������Ϣ��ѯ�ӿ���
 * 
 * @author Administrator
 * 
 */
public class PolicyQueryService {

	/**
	 * ����������Ϣ����
	 * 
	 * @param claimdRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String queryPrpallInfo(String policyNo) throws Exception {
		String returnStr = "";
		PrpallInfo prpallInfo = new PrpallInfo();
		PolicyDto policyDto = null;
		UICodeAction uiCodeAction = new UICodeAction();
		if (null != policyNo && !"".equals(policyNo)) {
			// ȡ�õ�ǰ��������Ϣ
			try {
				UIPolicyAction uiPolicyAction = new UIPolicyAction();
				policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
				if(null != policyDto && null != policyDto.getPrpCmainDto()){
					prpallInfo.setCoinsFlag(policyDto.getPrpCmainDto().getCoinsFlag());
					prpallInfo.setEndDate(policyDto.getPrpCmainDto().getEndDate());
					prpallInfo.setStartDate(policyDto.getPrpCmainDto().getStartDate());
					prpallInfo.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
					prpallInfo.setProposalNo(policyDto.getPrpCmainDto().getProposalNo());
					prpallInfo.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
					if(policyDto.getPrpCmainDto().getArticleType()!=null&&!"".equals(policyDto.getPrpCmainDto().getArticleType())){
						prpallInfo.setArticleType(uiCodeAction.translateCodeCode("ArticleType", policyDto.getPrpCmainDto().getArticleType(), true));
					}else{
						prpallInfo.setArticleType("");
					}
					if(policyDto.getPrpCmainDto().getBigMedicalType()!=null&&!"".equals(policyDto.getPrpCmainDto().getBigMedicalType())){
						prpallInfo.setBigMedicalType(uiCodeAction.translateCodeCode("BigMedicalType", policyDto.getPrpCmainDto().getBigMedicalType(), true));
					}else{
						prpallInfo.setBigMedicalType("");
					}
					prpallInfo.setSumPremium(policyDto.getPrpCmainDto().getSumPremium());
					prpallInfo.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
					prpallInfo.setAppliName(policyDto.getPrpCmainDto().getAppliName());
					prpallInfo.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
					if(null != policyDto.getPrpCitemKindDtoList() && policyDto.getPrpCitemKindDtoList().size() > 0){
						for(int i = 0;i < policyDto.getPrpCitemKindDtoList().size(); i++){
							PrpCitemKindDto ck = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(i);
							prpallInfo.setKindCode(ck.getKindCode());
							prpallInfo.setKindName(ck.getKindName());
						}
					}
					returnStr = "1^"+prpallInfo.getProposalNo()+"^"+prpallInfo.getPolicyNo()+"^"+prpallInfo.getStartDate()+
					"^"+prpallInfo.getEndDate()+"^"+prpallInfo.getRiskCode()+"^"+prpallInfo.getKindCode()+
					"^"+prpallInfo.getKindName()+"^"+prpallInfo.getCoinsFlag()+"^"+prpallInfo.getArticleType()+
					"^"+prpallInfo.getBigMedicalType()+"^"+prpallInfo.getSumPremium()+"^"+prpallInfo.getSumAmount()+
					"^"+prpallInfo.getAppliName()+"^"+prpallInfo.getInsuredName();
				} else{
					returnStr = "0^��ѯʧ��";
				}
			} catch (Exception e) {
				returnStr = "0^��ѯʧ��";
				e.printStackTrace();
			}
		}
		return returnStr;
	}

}
