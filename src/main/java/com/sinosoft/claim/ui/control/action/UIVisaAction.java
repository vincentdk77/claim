package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLVisaFacade;

public class UIVisaAction {

	private BLVisaFacade blVisaFacade = new BLVisaFacade();
	
	/**
	 * 根据业务险种和业务类型获取对应的单证类型代码和名称
	 * @param comCode
	 * @param riskCode
	 * @param certiType
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection getVsCode(String comCode,String riskCode,String certiType)throws SQLException,Exception{
		return blVisaFacade.getVsCode(comCode,riskCode,certiType);
	}
	/**
	 * 检查有号单证是否可以使用
	 * @param visaCode
	 * @param visaSerialNo
	 * @param userCode
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean checkVisaCodeValid(String visaCode,String visaSerialNo,String userCode)throws SQLException,Exception{
		return blVisaFacade.checkVisaCodeValid(visaCode,visaSerialNo,userCode);
	}
	/**
	 * 业务对有号单证的使用操作
	 * @param visaCode
	 * @param visaSerialNo
	 * @param businessNo
	 * @param userCode
	 * @param userName
	 * @throws SQLException
	 * @throws Exception
	 */
	public void doUsed(String visaCode,String visaSerialNo,String businessNo,String userCode,String userName)throws SQLException,Exception{
		blVisaFacade.doUsed(visaCode,visaSerialNo,businessNo,userCode,userName);
	}
	/**
	 * 业务对有号单证的作废操作
	 * @param visaCode
	 * @param visaSerialNo
	 * @param businessNo
	 * @param userCode
	 * @param userName
	 * @throws SQLException
	 * @throws Exception
	 */
	public void doAnnul(String visaCode,String visaSerialNo,String userCode,String userName)throws SQLException,Exception{
		blVisaFacade.doAnnul(visaCode,visaSerialNo,userCode,userName);
	}
}
