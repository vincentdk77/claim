package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonTrace ���˸��ٱ�����ݷ��ʶ�����<br>
 * ������ 2005-02-18 10:21:18.953<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpersonTrace extends DBPrpLpersonTraceBase{
    private static Log logger = LogFactory.getLog(DBPrpLpersonTrace.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpersonTrace(DBManager dbManager){
        super(dbManager);
    }
}
