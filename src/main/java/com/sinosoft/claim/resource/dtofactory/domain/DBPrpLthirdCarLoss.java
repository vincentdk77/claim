package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdCarLoss��ʧ��λ�����ݷ��ʶ�����<br>
 * ������ 2004-12-06 12:08:36.555<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLthirdCarLoss extends DBPrpLthirdCarLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLthirdCarLoss.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLthirdCarLoss(DBManager dbManager){
        super(dbManager);
    }
}
