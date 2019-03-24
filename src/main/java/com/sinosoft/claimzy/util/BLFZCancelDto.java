package com.sinosoft.claimzy.util;

import com.sinosoft.aip.webservice.server.CancelDto;
import com.sinosoft.aip.webservice.server.CancelMainInfo;
import com.sinosoft.claimzy.facade.BLPrpLcancelZYFacade;

/**
 * 将拼接SQL获得数据封装到CancelDto形成，注销/拒赔接口需要上传的第二个参数
 * @author CDB
 *
 */
public class BLFZCancelDto {
	public CancelDto FZCancelDto(String claimNo){
		CancelDto cancelDto = new CancelDto();
		/**
		 * 注销/拒赔主信息
		 */
		CancelMainInfo cancelMainInfo = new CancelMainInfo();
		BLPrpLcancelZYFacade blcz = new BLPrpLcancelZYFacade();
		try {
			cancelMainInfo = blcz.findByPrimaryKey(claimNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cancelDto.setCancelMainInfo(cancelMainInfo);
		return cancelDto;
		
	}
}
