package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLpreCharge extends DBPrpLpreChargeBase{
	private static Log log = LogFactory.getLog(DBPrpLpreCharge.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpreCharge(DBManager dbManager){
        super(dbManager);
    }
}
