package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppprofit�Ż���Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:20.593<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPprofit extends DBPrpPprofitBase{
    private static Log logger = LogFactory.getLog(DBPrpPprofit.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPprofit(DBManager dbManager){
        super(dbManager);
    }
}
