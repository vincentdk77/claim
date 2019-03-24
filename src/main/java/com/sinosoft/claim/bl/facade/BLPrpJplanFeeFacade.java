package com.sinosoft.claim.bl.facade;


import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpJplanFeeAction;
import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是应收应付费信息表的业务对象Facade类<br>
 */
public class BLPrpJplanFeeFacade extends BLPrpJplanFeeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpJplanFeeFacade.class);

    /**
     * 构造函数
     */
    public BLPrpJplanFeeFacade(){
        super();
    }

	public Collection findJoinJpayRefRecByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            collection = blPrpJplanFeeAction.findJoinJpayRefRecByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
   
    
   
    
}
