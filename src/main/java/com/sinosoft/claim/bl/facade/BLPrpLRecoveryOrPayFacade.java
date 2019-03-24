package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLRecoveryOrPayAction;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLRecoveryOrPayFacade extends BLPrpLRecoveryOrPayFacadeBase{
	 private static Log logger = LogFactory.getLog(BLPrpLRecoveryOrPayFacade.class);

	    /**
	     * ¹¹Ôìº¯Êý
	     */
	    public BLPrpLRecoveryOrPayFacade(){
	        super();
	    }
	    
	    public Collection findbyRecovery(String conditions) throws Exception{
	        Collection collection = new ArrayList();

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        DBManager dbManager = new DBManager();
	        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            collection = blPrpLRecoveryOrPayAction.findbyRecovery(dbManager,conditions);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return collection;
	    }
	    
	    public Collection findDistinctbyRecovery(String conditions) throws Exception{
	        Collection collection = new ArrayList();

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        DBManager dbManager = new DBManager();
	        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            collection = blPrpLRecoveryOrPayAction.findDistinctbyRecovery(dbManager,conditions);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return collection;
	    }
}
	   