package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLverifyLossExt�����ݷ��ʶ�����<br>
 * ������ 2006-03-20 17:55:51.328<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLverifyLossExt extends DBPrpLverifyLossExtBase{
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossExt.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLverifyLossExt(DBManager dbManager){
        super(dbManager);
    }
}
