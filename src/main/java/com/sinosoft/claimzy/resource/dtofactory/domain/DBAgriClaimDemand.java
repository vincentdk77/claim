package com.sinosoft.claimzy.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBAgriClaimDemand extends DBAgriClaimDemandBase{
	 private static Logger logger = Logger.getLogger(DBAgriClaimDemand.class);

	    /**
	     * ���캯��
	     * @param dbManager ��Դ������
	     */
	    public DBAgriClaimDemand(DBManager dbManager){
	        super(dbManager);
	    }
}
