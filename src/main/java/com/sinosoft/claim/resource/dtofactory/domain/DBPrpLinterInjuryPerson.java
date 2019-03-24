package com.sinosoft.claim.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLinterInjuryPerson extends DBPrpLinterInjuryPersonBase{
	   private static Logger logger = Logger.getLogger(DBPrpLinterInjuryPerson.class);

	    /**
	     * 构造函数
	     * @param dbManager 资源管理类
	     */
	    public DBPrpLinterInjuryPerson(DBManager dbManager){
	        super(dbManager);
	    }
}
