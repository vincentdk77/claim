package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpphead������Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:17.390<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPhead extends DBPrpPheadBase{
    private static Log logger = LogFactory.getLog(DBPrpPhead.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPhead(DBManager dbManager){
        super(dbManager);
    }
}
