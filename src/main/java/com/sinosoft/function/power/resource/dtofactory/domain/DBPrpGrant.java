package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpGrant ��Ȩ��¼������ݷ��ʶ�����<br>
 * ������ 2004-11-09 10:40:49.331<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGrant extends DBPrpGrantBase{
    private static Log logger = LogFactory.getLog(DBPrpGrant.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpGrant(DBManager dbManager){
        super(dbManager);
    }
}
