package com.sinosoft.claimzy.util;
/**
 * ���������װ��
 * ��ƴ��SQL�õ������ݷ�װ��ClaimDto,�γ������ϴ��ӿڵĵڶ�������
 * @author CDB
 */
import com.sinosoft.aip.webservice.server.ClaimDto;
import com.sinosoft.aip.webservice.server.ClaimMainInfo;
import com.sinosoft.aip.webservice.server.RegistInfo;
import com.sinosoft.claimzy.facade.BLPrpLclaimZYFacade;
import com.sinosoft.claimzy.facade.BLPrpLregistZYFacade;

public class BLFZClaimDto {
	public ClaimDto FZClaimDto(String registNo,String claimNo){
		ClaimDto claimDto = new ClaimDto();
		/**
		 * ������Ϣ
		 */
		RegistInfo[] registInfoList = new RegistInfo[1];
		BLPrpLregistZYFacade bzf = new BLPrpLregistZYFacade();
		try {
				registInfoList[0] = bzf.findByPrimaryKey(registNo);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		claimDto.setRegistInfoList(registInfoList);
		
		/**
		 * ��������Ϣ
		 */
		ClaimMainInfo claimMainInfo = new ClaimMainInfo();
		BLPrpLclaimZYFacade bczf = new BLPrpLclaimZYFacade();
		try {
			claimMainInfo = bczf.findByPrimaryKey(claimNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		claimDto.setClaimMainInfo(claimMainInfo);
		return claimDto;
		
	}
}

