package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLqualityCheck-�����������ݱ�����ݷ��ʶ�����<br>
 * ������ 2005-04-14 15:56:46.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLqualityCheck extends DBPrpLqualityCheckBase{
    private static Log logger = LogFactory.getLog(DBPrpLqualityCheck.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLqualityCheck(DBManager dbManager){
        super(dbManager);
    }
}
