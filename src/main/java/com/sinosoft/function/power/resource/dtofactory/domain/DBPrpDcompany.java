package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDcompany�������������ݷ��ʶ�����<br>
 * ������ 2004-11-09 18:30:40.448<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcompany extends DBPrpDcompanyBase{
    private static Log logger = LogFactory.getLog(DBPrpDcompany.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcompany(DBManager dbManager){
        super(dbManager);
    }
}
