package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

public class DBCIClaimThirdCar extends DBCIClaimThirdCarbase {
	private static Log logger = LogFactory.getLog(DBCIClaimThirdCar.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimThirdCar(DBManager dbManager){
        super(dbManager);
    }
}
