package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrationlimit�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrationLimit extends DBPrpDrationLimitBase{
    private static Log log = LogFactory.getLog(DBPrpDrationLimit.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrationLimit(DBManager dbManager){
        super(dbManager);
    }
}
