package com.sinosoft.claimzy.util;

import com.sinosoft.aip.webservice.server.CancelDto;
import com.sinosoft.aip.webservice.server.CancelMainInfo;
import com.sinosoft.claimzy.facade.BLPrpLcancelZYFacade;

/**
 * ��ƴ��SQL������ݷ�װ��CancelDto�γɣ�ע��/����ӿ���Ҫ�ϴ��ĵڶ�������
 * @author CDB
 *
 */
public class BLFZCancelDto {
	public CancelDto FZCancelDto(String claimNo){
		CancelDto cancelDto = new CancelDto();
		/**
		 * ע��/��������Ϣ
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
