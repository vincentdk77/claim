package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppitem_car�������ձ����Ϣ�����ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:18.000<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPitemCar extends DBPrpPitemCarBase{
    private static Log logger = LogFactory.getLog(DBPrpPitemCar.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPitemCar(DBManager dbManager){
        super(dbManager);
    }
}
