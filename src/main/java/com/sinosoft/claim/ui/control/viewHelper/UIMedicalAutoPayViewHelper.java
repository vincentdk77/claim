package com.sinosoft.claim.ui.control.viewHelper;

import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

public class UIMedicalAutoPayViewHelper {
	
	/**
	* Ĭ�Ϲ��췽��
	*/
	public UIMedicalAutoPayViewHelper(){
		
	}

	public String autoPayMain(PrpLinterPayRequestDto prpLinterPayRequestDto){
		
		try {
			//����֧��
			prpLinterPayRequestDto = new UIMedicalAutoPaySubViewHelper().autoPay(prpLinterPayRequestDto);
			 
			//�ύ˫������
			prpLinterPayRequestDto = new UIMedicalPayVericSubViewHelper().autoPayVeric(prpLinterPayRequestDto);
			
			return "1^�����ɹ�";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "1^�����ɹ����Զ��������" + e.getMessage();
			
		}
		
	}
	
}