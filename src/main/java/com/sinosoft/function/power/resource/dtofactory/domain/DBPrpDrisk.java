package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDrisk���ִ��������ݷ��ʶ�����<br>
 * ������ 2004-11-09 10:40:49.351<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrisk extends DBPrpDriskBase{
    private static Log logger = LogFactory.getLog(DBPrpDrisk.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrisk(DBManager dbManager){
        super(dbManager);
    }
}
