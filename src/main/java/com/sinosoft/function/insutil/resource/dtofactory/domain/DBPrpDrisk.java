package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrisk�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:29<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrisk extends DBPrpDriskBase{
    private static Log log = LogFactory.getLog(DBPrpDrisk.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrisk(DBManager dbManager){
        super(dbManager);
    }
}
