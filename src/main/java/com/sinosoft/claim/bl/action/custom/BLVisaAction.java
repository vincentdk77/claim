package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.visa.bl.action.custom.BLInterfaceVsCodeAction;
import com.sinosoft.visa.bl.action.custom.BLInterfaceVsMarkAction;

public class BLVisaAction {
	private BLInterfaceVsCodeAction blInterfaceVsCodeAction = new BLInterfaceVsCodeAction();
	BLInterfaceVsMarkAction blInterfaceVsMarkAction = new BLInterfaceVsMarkAction();
	/**
	 * ����ҵ�����ֺ�ҵ�����ͻ�ȡ��Ӧ�ĵ�֤���ʹ��������
	 * @param dbManager
	 * @param comCode
	 * @param riskCode
	 * @param certiType
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection getVsCode(DBManager dbManager,String comCode,String riskCode,String certiType)throws SQLException,Exception{
		Collection list = blInterfaceVsCodeAction.getVisaCode(dbManager,riskCode,certiType,comCode);
		return list;
	}
	/**
	 * ����кŵ�֤�Ƿ����ʹ��
	 * @param dbManager
	 * @param visaCode
	 * @param visaSerialNo
	 * @param userCode
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
   public boolean checkVisaCodeValid(DBManager dbManager,String visaCode,String visaSerialNo,String userCode)throws SQLException,Exception{

		return blInterfaceVsMarkAction.checkVisaCodeValid(dbManager,visaCode,visaSerialNo,userCode);
	}
   /**
    * ҵ����кŵ�֤��ʹ�ò���
    * @param dbManager
    * @param VisaCode
    * @param VisaSerialNo
    * @param BusinessNo
    * @param UserCode
    * @param UserName
    */
   public void doUsed(DBManager dbManager,String visaCode,String visaSerialNo,String businessNo,String userCode,String userName)throws SQLException,Exception{
	   blInterfaceVsMarkAction.doUsed(dbManager,visaCode,visaSerialNo,businessNo,userCode,userName);
   }
   /**
    * ҵ����кŵ�֤�����ϲ���
    * @param dbManager
    * @param visaCode
    * @param visaSerialNo
    * @param userCode
    * @param userName
    * @return
    */
   public void doAnnul(DBManager dbManager,String visaCode,String visaSerialNo,String userCode,String userName)throws SQLException,Exception{
	   blInterfaceVsMarkAction.doAnnul(dbManager,visaCode,visaSerialNo,userCode,userName);
   }

   
   

	
}
