package com.sinosoft.claimzy.util;

import com.sinosoft.aip.webservice.server.PrepaidDto;
import com.sinosoft.aip.webservice.server.PrepaidFarmerInfo;
import com.sinosoft.aip.webservice.server.PrepaidMainInfo;
import com.sinosoft.claimzy.facade.BLPrpLprepaidZYFacade;
import com.sinosoft.claimzy.facade.BLPrpprepaidFarmerZYFacade;

/**
 * 将拼接SQL获得数据封装到PrepaidDto,形成预赔案接口的第二个参数
 * @author CDB
 *
 */
public class BLFZPrepaidDto {
	public PrepaidDto FZPrepaidDto(String preCompensateNo){
		PrepaidDto prepaidDto = new PrepaidDto();
		/**
		 * 分户预赔付信息
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
		 * 预赔案主信息
		 */
		PrepaidMainInfo prePaidMainInfo = new PrepaidMainInfo();
		BLPrpLprepaidZYFacade blpzf = new BLPrpLprepaidZYFacade();
		long l = prepaidFarmerInfoList.length;//分户预赔付清单记录数
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
