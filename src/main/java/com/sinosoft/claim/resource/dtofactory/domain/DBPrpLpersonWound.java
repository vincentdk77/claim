package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonWound ������Ϣ������ݷ��ʶ�����<br>
 * ������ 2005-02-18 10:21:18.968<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpersonWound extends DBPrpLpersonWoundBase{
    private static Log logger = LogFactory.getLog(DBPrpLpersonWound.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpersonWound(DBManager dbManager){
        super(dbManager);
    }
}
