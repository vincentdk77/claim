package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomer�ͻ���Ϣ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomer extends DBPrpDcustomerBase{
    private static Log log = LogFactory.getLog(DBPrpDcustomer.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcustomer(DBManager dbManager){
        super(dbManager);
    }
}
