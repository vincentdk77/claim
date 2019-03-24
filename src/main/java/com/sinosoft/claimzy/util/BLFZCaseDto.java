package com.sinosoft.claimzy.util;

import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.CaseMainInfo;
import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.claimzy.facade.BLPrpLcaseZYFacade;
import com.sinosoft.claimzy.facade.BLPrpLclaimFarmerZYFacade;

/**
 * 将拼接SQL获得数据封装到CaseDto形成，赔案接口需要上传的第二个参数
 * @author CDB
 *
 */
public class BLFZCaseDto {
	public CaseDto FZCaseDto(String caseNo){
		CaseDto caseDto = new CaseDto();
		long l;
		
		/**
		 * 分户赔付清单信息
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
		 * 赔案主信息
		 */
		CaseMainInfo caseMainInfo = new CaseMainInfo();
		BLPrpLcaseZYFacade bczyf = new BLPrpLcaseZYFacade();
		if(farmerInfoList==null){
			 l=0;
		}else{
			 l = farmerInfoList.length;//分户赔付清单记录数
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
