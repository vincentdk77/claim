package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;

/**
 * ��ҽ�������ؿ��ⰸ�������ĸ�����
 * 
 * @author Administrator
 * 
 */
public class UIMedicalClaimRecaseViewHelper {
	
	public String autoRecaseClaimMain(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto){
		try {
//			//����ת������ȡǰ�ڵĹ�������
//			prpLinterRecaseRequestDto = getRecaseDtoMain(prpLinterRecaseRequestDto);
//			//�ؿ����뻷��
//			prpLinterRecaseRequestDto = new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
//			
//			//�ؿ�����
//			prpLinterRecaseRequestDto = new UIMedicalAutoRecaseApprovSubViewHelper().autoRecaseApprov(prpLinterRecaseRequestDto);
//			
//			//���㻷��
//			prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRecaseRequestDto);
//			
//			//���⻷��
//			prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRecaseRequestDto);
//			
//			//�᰸����
//			prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRecaseRequestDto);
			
			return "1^�����ɹ�";
		} catch (Exception e) {
			e.printStackTrace();
			return "1^�����ɹ�";
		}
	}
	
	/**
	 * ���ݲ���prpLinterRecaseRequesDto������RelationOutid��BLPrpLinterRequestFacade.findByConditionsWithChild ()����
	 * ����ȡ��PrpLinterRequestDto��������Ը�ֵ��������prpLinterRecaseRequesDto������
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
		prpLinterRecaseRequestDto.setRecaseFlag(true);//�����ؿ���ʶ
		return prpLinterRecaseRequestDto;
	}
}
