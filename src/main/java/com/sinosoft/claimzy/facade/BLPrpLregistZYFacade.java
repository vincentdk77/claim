package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.RegistInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 报案信息类
 */

public class BLPrpLregistZYFacade {
	private static Log logger = LogFactory.getLog(BLPrpLregistZYFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLregistZYFacade(){
    }
	/**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @return 
	 * @throws Exception 
     */
    public RegistInfo findByPrimaryKey(String registNo) throws Exception{
    	DBManager dbManager = new DBManager();
    	DBPrpRegistInfoZY dbPrpRegistZY = new DBPrpRegistInfoZY(dbManager);
    	RegistInfo registInfo =null;
        try {
        	//dbManager.beginTransaction();
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//打开数据源
			registInfo = dbPrpRegistZY.findByPrimaryKey(registNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return registInfo;
    }
}
