package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

public class DBCIClaimHistory extends DBCIClaimHistoryBase {
	private static Log logger = LogFactory.getLog(DBCIClaimHistory.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimHistory(DBManager dbManager){
        super(dbManager);
    }
}
