package com.sinosoft.claimzy.util;
/**
 * 对象参数封装类
 * 将拼接SQL得到的数据封装到ClaimDto,形成立案上传接口的第二个参数
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
		 * 报案信息
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
		 * 立案主信息
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

