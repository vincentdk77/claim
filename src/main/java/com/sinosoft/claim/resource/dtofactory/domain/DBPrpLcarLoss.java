package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcarLoss������������ݷ��ʶ�����<br>
 * ������ 2004-07-19 14:23:57.112<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcarLoss extends DBPrpLcarLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLcarLoss.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcarLoss(DBManager dbManager){
        super(dbManager);
    }
}
