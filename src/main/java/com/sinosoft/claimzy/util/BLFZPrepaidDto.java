package com.sinosoft.claimzy.util;

import com.sinosoft.aip.webservice.server.PrepaidDto;
import com.sinosoft.aip.webservice.server.PrepaidFarmerInfo;
import com.sinosoft.aip.webservice.server.PrepaidMainInfo;
import com.sinosoft.claimzy.facade.BLPrpLprepaidZYFacade;
import com.sinosoft.claimzy.facade.BLPrpprepaidFarmerZYFacade;

/**
 * ��ƴ��SQL������ݷ�װ��PrepaidDto,�γ�Ԥ�ⰸ�ӿڵĵڶ�������
 * @author CDB
 *
 */
public class BLFZPrepaidDto {
	public PrepaidDto FZPrepaidDto(String preCompensateNo){
		PrepaidDto prepaidDto = new PrepaidDto();
		/**
		 * �ֻ�Ԥ�⸶��Ϣ
		 */
		PrepaidFarmerInfo[] prepaidFarmerInfoList = null;
		BLPrpprepaidFarmerZYFacade blprfz = new BLPrpprepaidFarmerZYFacade();
		try {
			prepaidFarmerInfoList = blprfz.findByPrimaryKey(preCompensateNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		prepaidDto.setPrepaidFarmerInfoList(prepaidFarmerInfoList);
		
		/**
		 * Ԥ�ⰸ����Ϣ
		 */
		PrepaidMainInfo prePaidMainInfo = new PrepaidMainInfo();
		BLPrpLprepaidZYFacade blpzf = new BLPrpLprepaidZYFacade();
		long l = prepaidFarmerInfoList.length;//�ֻ�Ԥ�⸶�嵥��¼��
		try {
			prePaidMainInfo=blpzf.findByPrimaryKey(preCompensateNo);
			prePaidMainInfo.setFarmerCount(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		prepaidDto.setPrePaidMainInfo(prePaidMainInfo);
		
		
		return prepaidDto;
	}
}
