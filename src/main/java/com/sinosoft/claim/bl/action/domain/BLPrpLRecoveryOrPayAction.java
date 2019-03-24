package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRecoveryOrPay;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLRecoveryOrPayAction extends BLPrpLRecoveryOrPayActionBase{
	 private static Log log = LogFactory.getLog(BLPrpLRecoveryOrPayAction.class.getName());

	    /**
	     * ¹¹Ôìº¯Êý
	     */
	    public BLPrpLRecoveryOrPayAction(){
	        super();
	    }

		
		 public Collection findbyRecovery(DBManager dbManager,String conditions) throws Exception{
		    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
		        Collection collection = new ArrayList();

		        if(conditions.trim().length()==0){
		            conditions = "1=1";
		        }

		        collection = dbPrpLRecoveryOrPay.findbyRecovery(conditions,0,0);
		        return collection;
		    }
		 public Collection findDistinctbyRecovery(DBManager dbManager,String conditions) throws Exception{
		    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
		        Collection collection = new ArrayList();

		        if(conditions.trim().length()==0){
		            conditions = "1=1";
		        }

		        collection = dbPrpLRecoveryOrPay.findDistinctbyRecovery(conditions,0,0);
		        return collection;
		    }
}
