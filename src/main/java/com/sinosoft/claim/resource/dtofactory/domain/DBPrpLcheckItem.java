package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLcheckItem�鿱�����ı�����ݷ��ʶ�����<br>
 * ������ 2004-07-28 16:34:57.625<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcheckItem extends DBPrpLcheckItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLcheckItem.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcheckItem(DBManager dbManager){
        super(dbManager);
    }
}
