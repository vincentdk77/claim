package com.sinosoft.claim.ui.control.viewHelper;

import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;

public class UIMedicalAutoClaimViewHelper {
	
	/**
	* Ĭ�Ϲ��췽��
	*/
	public UIMedicalAutoClaimViewHelper(){
		
	}
	
	public String autoClaimMain(PrpLinterRequestDto prpLinterRequestDto){
		
		try {
			/**------------------���нӿڶ��ǹرյģ�������Ϊ�˲��ԣ����ύ--------------------------*/
			/*
			//�Զ���������
			prpLinterRequestDto = new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
			
			//�Զ�����
			prpLinterRequestDto = new UIMedicalAutoSchedSubViewHelper().autoSched(prpLinterRequestDto);
			
			//�Զ��鿱
			prpLinterRequestDto = new UIMedicalAutoCheckSubViewHelper().autoCheck(prpLinterRequestDto);
			
			//�Զ�����
			prpLinterRequestDto = new UIMedicalAutoClaimSubViewHelper().autoClaim(prpLinterRequestDto);
			
			if(prpLinterRequestDto.getCaseType()!=null && 
					(prpLinterRequestDto.getPrpLinterPrepayFeeDto()!=null || prpLinterRequestDto.getSumPrePaid()>0)){
				//Ԥ������
				prpLinterRequestDto = new UIMedicalAutoPrepaySubViewHelper().autoPrepay(prpLinterRequestDto);
				
				//Ԥ������
				prpLinterRequestDto = new UIMedicalAutoPrepayVericSubViewHelper().autoPrepayVeric(prpLinterRequestDto);
			}
			
			//��֤����
			prpLinterRequestDto = new UIMedicalAutoCertiSubViewHelper().autoCerti(prpLinterRequestDto);
			
			//���㻷��
			prpLinterRequestDto = new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRequestDto);
			
			//���⻷��
			prpLinterRequestDto = new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRequestDto);
			
			//�᰸����
			prpLinterRequestDto = new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRequestDto);
			
			//��Ҫ�ѽ����ɹ��ı�־ֵΪ1��prplinterrelation.SYNCHRONFLAG
			
			new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
			*/
			
			return "1^�����ɹ�";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "1^�����ɹ�";
			
		}
		
		
	}
	
}
