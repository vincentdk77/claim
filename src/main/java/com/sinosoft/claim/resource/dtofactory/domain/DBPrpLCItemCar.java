package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCItemCar���Ᵽ��������������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLCItemCar extends DBPrpLCItemCarBase{
    private static Log log = LogFactory.getLog(DBPrpLCItemCar.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLCItemCar(DBManager dbManager){
        super(dbManager);
    }
}
