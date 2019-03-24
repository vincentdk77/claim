package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;

/**
 * 大病医疗理赔重开赔案工作流的辅助类
 * 
 * @author Administrator
 * 
 */
public class UIMedicalClaimRecaseViewHelper {
	
	public String autoRecaseClaimMain(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto){
		try {
//			//数据转换，获取前期的关联数据
//			prpLinterRecaseRequestDto = getRecaseDtoMain(prpLinterRecaseRequestDto);
//			//重开申请环节
//			prpLinterRecaseRequestDto = new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
//			
//			//重开审批
//			prpLinterRecaseRequestDto = new UIMedicalAutoRecaseApprovSubViewHelper().autoRecaseApprov(prpLinterRecaseRequestDto);
//			
//			//理算环节
//			prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRecaseRequestDto);
//			
//			//核赔环节
//			prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRecaseRequestDto);
//			
//			//结案环节
//			prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRecaseRequestDto);
			
			return "1^交互成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "1^交互成功";
		}
	}
	
	/**
	 * 根据参数prpLinterRecaseRequesDto的属性RelationOutid及BLPrpLinterRequestFacade.findByConditionsWithChild ()方法
	 * 将获取的PrpLinterRequestDto的相关属性赋值到其子类prpLinterRecaseRequesDto对象中
	 * @param prpLinterRecaseRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRecaseRequestDto  getRecaseDtoMain(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
			throws Exception {
		String relationOutId = prpLinterRecaseRequestDto.getRelationOutId();
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		ArrayList<PrpLinterRequestDto> PrpLinterRequestDtoList = (ArrayList<PrpLinterRequestDto>) 
			blPrpLinterRequestFacade.findByConditionsWithChild(" OutId='"+prpLinterRecaseRequestDto.getRelationOutId()+"' ");
		if(PrpLinterRequestDtoList!=null&&!PrpLinterRequestDtoList.isEmpty()){
			PrpLinterRequestDto prpLinterRequestDto = PrpLinterRequestDtoList.get(0);
			//prpLinterRecaseRequestDto.setRegistno(prpLinterRequestDto.getRegistno());
			prpLinterRecaseRequestDto.setPolicyno(prpLinterRequestDto.getPolicyno());
			//prpLinterRecaseRequestDto.setClaimno(prpLinterRequestDto.getClaimno());
			prpLinterRecaseRequestDto.setRelationRegistNo(prpLinterRequestDto.getRelationRegistNo());
			prpLinterRecaseRequestDto.setDamageStartDate(prpLinterRequestDto.getDamageStartDate());
			prpLinterRecaseRequestDto.setDamageStartHour(prpLinterRequestDto.getDamageStartHour());
			prpLinterRecaseRequestDto.setCurrency(prpLinterRequestDto.getCurrency());
			prpLinterRecaseRequestDto.setClaimType(prpLinterRequestDto.getClaimType());
		}
		prpLinterRecaseRequestDto.setRecaseFlag(true);//设置重开标识
		return prpLinterRecaseRequestDto;
	}
}
