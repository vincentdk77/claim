package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPCMAINCARGO-�����ձ�����Ϣ�����ݷ��ʶ�����<br>
 * ������ 2005-06-02 10:27:47.265<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCmainCargo extends DBPrpCmainCargoBase{
    private static Log logger = LogFactory.getLog(DBPrpCmainCargo.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCmainCargo(DBManager dbManager){
        super(dbManager);
    }
}
