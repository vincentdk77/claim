package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������վݵ����ݷ��ʶ�����<br>
 * ������ 2006-02-25 11:37:06.984<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLIndemnityReceipt extends DBPrpLIndemnityReceiptBase{
    private static Log logger = LogFactory.getLog(DBPrpLIndemnityReceipt.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLIndemnityReceipt(DBManager dbManager){
        super(dbManager);
    }
}
