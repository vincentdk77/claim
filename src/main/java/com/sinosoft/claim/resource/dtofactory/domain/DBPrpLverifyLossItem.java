package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLverifyLossItem���������ı�����ݷ��ʶ�����<br>
 * ������ 2004-11-11 14:31:03.533<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLverifyLossItem extends DBPrpLverifyLossItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossItem.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLverifyLossItem(DBManager dbManager){
        super(dbManager);
    }
}
