package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyDirect-����ָ��(����)�����ݷ��ʶ�����<br>
 * ������ 2005-03-22 17:21:38.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcertifyDirect extends DBPrpLcertifyDirectBase{
    private static Log logger = LogFactory.getLog(DBPrpLcertifyDirect.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcertifyDirect(DBManager dbManager){
        super(dbManager);
    }
}
