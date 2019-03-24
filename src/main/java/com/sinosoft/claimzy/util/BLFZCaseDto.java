package com.sinosoft.claimzy.util;

import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.CaseMainInfo;
import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.claimzy.facade.BLPrpLcaseZYFacade;
import com.sinosoft.claimzy.facade.BLPrpLclaimFarmerZYFacade;

/**
 * ��ƴ��SQL������ݷ�װ��CaseDto�γɣ��ⰸ�ӿ���Ҫ�ϴ��ĵڶ�������
 * @author CDB
 *
 */
public class BLFZCaseDto {
	public CaseDto FZCaseDto(String caseNo){
		CaseDto caseDto = new CaseDto();
		long l;
		
		/**
		 * �ֻ��⸶�嵥��Ϣ
		 */
		ClaimFarmerInfo[] farmerInfoList = null;
		BLPrpLclaimFarmerZYFacade bcfz = new BLPrpLclaimFarmerZYFacade();
		try {
			farmerInfoList = bcfz.findByPrimaryKey(caseNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		caseDto.setFarmerInfoList(farmerInfoList);
		
		/**
		 * �ⰸ����Ϣ
		 */
		CaseMainInfo caseMainInfo = new CaseMainInfo();
		BLPrpLcaseZYFacade bczyf = new BLPrpLcaseZYFacade();
		if(farmerInfoList==null){
			 l=0;
		}else{
			 l = farmerInfoList.length;//�ֻ��⸶�嵥��¼��
		}
		try {
			caseMainInfo = bczyf.findByPrimaryKey(caseNo);
			caseMainInfo.setFarmerCount(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		caseDto.setCaseMainInfo(caseMainInfo);
		
		return caseDto;
		
	}
}
