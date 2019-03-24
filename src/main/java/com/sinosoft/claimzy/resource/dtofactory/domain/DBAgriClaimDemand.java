package com.sinosoft.claimzy.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBAgriClaimDemand extends DBAgriClaimDemandBase{
	 private static Logger logger = Logger.getLogger(DBAgriClaimDemand.class);

	    /**
	     * 构造函数
	     * @param dbManager 资源管理类
	     */
	    public DBAgriClaimDemand(DBManager dbManager){
	        super(dbManager);
	    }
}
