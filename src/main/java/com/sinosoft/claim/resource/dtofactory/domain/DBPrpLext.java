package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLext�����ݷ��ʶ�����<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLext extends DBPrpLextBase{
    private static Log logger = LogFactory.getLog(DBPrpLext.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLext(DBManager dbManager){
        super(dbManager);
    }
}
