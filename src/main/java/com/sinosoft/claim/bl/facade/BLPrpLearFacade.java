package com.sinosoft.claim.bl.facade;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLearAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLearFacade extends BLPrpLearFacadeBase{
	 private static Log logger = LogFactory.getLog(BLPrpLearFacade.class);

    
    public BLPrpLearFacade() {
		super();
	}

    /**
     * 按报案号查询
     * @param registNo 报案号码
     * @throws Exception
     */
    public Collection checkEarNo(String registNo,String strEarNoIn) throws Exception{
        DBManager dbManager = new DBManager();
        Collection collection = null;
        BLPrpLearAction blPrpLearAction = new BLPrpLearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLearAction.checkEarNo(dbManager,registNo,strEarNoIn);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
	
}
