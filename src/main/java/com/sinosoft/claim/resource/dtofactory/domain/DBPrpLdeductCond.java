package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLdeductCond-��������������������ݷ��ʶ�����<br>
 * ������ 2006-06-07 16:25:07.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLdeductCond extends DBPrpLdeductCondBase{
    private static Log logger = LogFactory.getLog(DBPrpLdeductCond.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLdeductCond(DBManager dbManager){
        super(dbManager);
    }
}
