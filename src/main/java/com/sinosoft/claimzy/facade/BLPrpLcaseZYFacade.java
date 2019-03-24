package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.CaseMainInfo;
import com.sinosoft.aip.webservice.server.ClaimMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLcaseZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLcaseZYFacade.class);
   /**
    * ���캯��
    */
	public BLPrpLcaseZYFacade(){
		
	}

   /**
    * ����������һ������
    * @param dbManager DB������
    * @param caseNo �ⰸ����
    * @return caseMainInfo
	* @throws Exception 
	* 
    */
	public CaseMainInfo findByPrimaryKey(String caseNo) throws Exception{
		DBManager dbManager = new DBManager();
		DBPrpCaseMainInfoZY dpcz = new DBPrpCaseMainInfoZY(dbManager);
		CaseMainInfo caseMainInfo = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//������Դ
			caseMainInfo = dpcz.findByPrimaryKey(caseNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return caseMainInfo;
	}
}
