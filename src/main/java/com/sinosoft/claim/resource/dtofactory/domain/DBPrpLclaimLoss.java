package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss�����ݷ��ʶ�����<br>
 * ������ 2004-06-24 14:46:01.860<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimLoss extends DBPrpLclaimLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLclaimLoss.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimLoss(DBManager dbManager){
        super(dbManager);
    }
}
