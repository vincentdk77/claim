package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ���ǵ�����ñ�-PrpLAcciCheckCharge�����ݷ��ʶ�����<br>
 * ������ 2006-01-23 15:30:13.843<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciCheckCharge extends DBPrpLAcciCheckChargeBase{
    private static Log logger = LogFactory.getLog(DBPrpLAcciCheckCharge.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLAcciCheckCharge(DBManager dbManager){
        super(dbManager);
    }
}
