package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpayObject-֧��������������ݷ��ʶ�����<br>
 * ������ 2006-08-03 14:43:26.173<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpayObjecttg extends DBPrpLpayObjecttgBase{
    private static Log logger = LogFactory.getLog(DBPrpLpayObjecttg.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayObjecttg(DBManager dbManager){
        super(dbManager);
    }
}
