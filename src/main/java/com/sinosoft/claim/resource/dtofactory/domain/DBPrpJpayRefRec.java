package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRefRec;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRefRecBase;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpJpayRefRec extends DBPrpJpayRefRecBase{
    private static Log logger = LogFactory.getLog(DBPrpJpayRefRec.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJpayRefRec(DBManager dbManager){
        super(dbManager);
    }
}
