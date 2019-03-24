package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;

public class UIMedicalAutoCancelClaimViewHelper {
	
	/**
	* 默认构造方法
	*/
	public UIMedicalAutoCancelClaimViewHelper(){
		
	}

	public String autoCancelMain(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto){
		
		try {
			//更新报案注销标识
			prpLinterCancelClaimRequestDto.setCancelFlag(true);
			
		    String outRegistNo = prpLinterCancelClaimRequestDto.getOutRegistNo();
		    
		    BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		    BLPrpLclaimFacade bLPrpLclaimFacade = new BLPrpLclaimFacade();
		    PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		    ArrayList prpLinterRequestList = new ArrayList();
		    String registNo = "";
		    Boolean cancelFlag = true;
		    prpLinterRequestList = (ArrayList)blPrpLinterRequestFacade.findByConditionsWithChild("outRigstNo='"+outRegistNo+"'");
		    if(prpLinterRequestList!=null&&!prpLinterRequestList.isEmpty()&&prpLinterRequestList.size()>0){
		    	PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)prpLinterRequestList.get(0);
		    	PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto =  prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		    	prpLinterCancelClaimRequestDto.setRegistNo(prplinterAutoClaimDetailDto.getRegistNo());
		    	ArrayList claimList = (ArrayList)bLPrpLclaimFacade.findByConditions("registNo='"+prplinterAutoClaimDetailDto.getRegistNo()+"'");
		    	if(claimList!=null&&claimList.size()>0){
		    		prpLclaimDto = (PrpLclaimDto)claimList.get(0);
		    		prpLinterCancelClaimRequestDto.setClaimNo(prpLclaimDto.getClaimNo());
		    		cancelFlag = false;
		    	}
		    }
			//报案
			//prpLinterCancelClaimRequestDto = (PrpLinterCancelClaimRequestDto)new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterCancelClaimRequestDto);
			if(cancelFlag){
			    //报案注销
		   	    prpLinterCancelClaimRequestDto = new UIMedicalAutoRegistCancleSubViewHelpe().autoRegistCancel(prpLinterCancelClaimRequestDto);
			}else{
				//立案注销申请
				new UIMedicalAutoRegistCancleSubViewHelpe().autoClaimCancel(prpLinterCancelClaimRequestDto);
				
				new UIMedicalAutoRegistCancleSubViewHelpe().autoCancelApprov(prpLinterCancelClaimRequestDto);
			}
			return "1^交互成功";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "0^交互失败";
			
		}
		
	}
	
}