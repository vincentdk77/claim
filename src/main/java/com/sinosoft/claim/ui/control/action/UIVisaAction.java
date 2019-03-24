package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLVisaFacade;

public class UIVisaAction {

	private BLVisaFacade blVisaFacade = new BLVisaFacade();
	
	/**
	 * ����ҵ�����ֺ�ҵ�����ͻ�ȡ��Ӧ�ĵ�֤���ʹ��������
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
	 * ����кŵ�֤�Ƿ����ʹ��
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
	 * ҵ����кŵ�֤��ʹ�ò���
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
	 * ҵ����кŵ�֤�����ϲ���
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
