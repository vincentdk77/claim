package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLear;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLearAction extends BLPrpLearActionBase{

	private static Log logger = LogFactory.getLog(BLPrpLearAction.class);

	public BLPrpLearAction() {
		super();
	}
	

	/**
	 * 校验耳标号是否重复
	 * @param dbManager
	 * @param registNo  报案号
	 * @param strEarNoIn
	 * @return
	 * @throws Exception
	 */
	public Collection checkEarNo(DBManager dbManager,String registNo, String strEarNoIn) throws Exception{
		Collection collection = null;
		DBPrpLear dbPrpLear = new DBPrpLear(dbManager);
		String condition = " and earno in (" + strEarNoIn + ") ";
		if(registNo != null && registNo.length() > 0){
			condition += " and registno<>'" + registNo + "'";
		}
		try {
			collection = dbPrpLear.checkEarNo(condition);
		} catch (Exception e) {
			throw e;
		}
		
		return collection;
	}
	
	
}
