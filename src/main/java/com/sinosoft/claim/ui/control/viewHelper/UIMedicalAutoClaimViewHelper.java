package com.sinosoft.claim.ui.control.viewHelper;

import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;

public class UIMedicalAutoClaimViewHelper {
	
	/**
	* 默认构造方法
	*/
	public UIMedicalAutoClaimViewHelper(){
		
	}
	
	public String autoClaimMain(PrpLinterRequestDto prpLinterRequestDto){
		
		try {
			/**------------------所有接口都是关闭的，放来是为了测试，不提交--------------------------*/
			/*
			//自动报案方法
			prpLinterRequestDto = new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
			
			//自动调度
			prpLinterRequestDto = new UIMedicalAutoSchedSubViewHelper().autoSched(prpLinterRequestDto);
			
			//自动查勘
			prpLinterRequestDto = new UIMedicalAutoCheckSubViewHelper().autoCheck(prpLinterRequestDto);
			
			//自动立案
			prpLinterRequestDto = new UIMedicalAutoClaimSubViewHelper().autoClaim(prpLinterRequestDto);
			
			if(prpLinterRequestDto.getCaseType()!=null && 
					(prpLinterRequestDto.getPrpLinterPrepayFeeDto()!=null || prpLinterRequestDto.getSumPrePaid()>0)){
				//预赔申请
				prpLinterRequestDto = new UIMedicalAutoPrepaySubViewHelper().autoPrepay(prpLinterRequestDto);
				
				//预赔审批
				prpLinterRequestDto = new UIMedicalAutoPrepayVericSubViewHelper().autoPrepayVeric(prpLinterRequestDto);
			}
			
			//单证环节
			prpLinterRequestDto = new UIMedicalAutoCertiSubViewHelper().autoCerti(prpLinterRequestDto);
			
			//理算环节
			prpLinterRequestDto = new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRequestDto);
			
			//核赔环节
			prpLinterRequestDto = new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRequestDto);
			
			//结案环节
			prpLinterRequestDto = new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRequestDto);
			
			//需要把交互成功的标志值为1：prplinterrelation.SYNCHRONFLAG
			
			new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
			*/
			
			return "1^交互成功";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "1^交互成功";
			
		}
		
		
	}
	
}
