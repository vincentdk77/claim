package com.sinosoft.claim.ui.control.viewHelper;

import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

public class UIMedicalAutoPayViewHelper {
	
	/**
	* 默认构造方法
	*/
	public UIMedicalAutoPayViewHelper(){
		
	}

	public String autoPayMain(PrpLinterPayRequestDto prpLinterPayRequestDto){
		
		try {
			//新增支付
			prpLinterPayRequestDto = new UIMedicalAutoPaySubViewHelper().autoPay(prpLinterPayRequestDto);
			 
			//提交双核审批
			prpLinterPayRequestDto = new UIMedicalPayVericSubViewHelper().autoPayVeric(prpLinterPayRequestDto);
			
			return "1^交互成功";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "1^交互成功，自动理赔出错：" + e.getMessage();
			
		}
		
	}
	
}