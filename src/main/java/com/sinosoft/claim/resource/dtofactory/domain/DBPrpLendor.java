package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLendor�����ݷ��ʶ�����<br>
 * ������ 2007-06-12 15:24:00.218<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLendor extends DBPrpLendorBase{
    private static Log logger = LogFactory.getLog(DBPrpLendor.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLendor(DBManager dbManager){
        super(dbManager);
    }
}
