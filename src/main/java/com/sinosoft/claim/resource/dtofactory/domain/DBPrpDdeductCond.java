package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDdeductCond ��������������ݷ��ʶ�����<br>
 * ������ 2005-01-20 09:47:05.750<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDdeductCond extends DBPrpDdeductCondBase{
    private static Log logger = LogFactory.getLog(DBPrpDdeductCond.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDdeductCond(DBManager dbManager){
        super(dbManager);
    }
}
