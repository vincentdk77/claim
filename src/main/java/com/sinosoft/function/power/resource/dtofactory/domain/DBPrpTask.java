package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpTask�������������ݷ��ʶ�����<br>
 * ������ 2004-11-09 10:40:49.341<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpTask extends DBPrpTaskBase{
    private static Log logger = LogFactory.getLog(DBPrpTask.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpTask(DBManager dbManager){
        super(dbManager);
    }
}
