package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǳб��ձ��ı�����ݷ��ʶ�����<br>
 * ������ 2007-07-05 14:54:47.140<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLkindItem extends DBPrpLkindItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLkindItem.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLkindItem(DBManager dbManager){
        super(dbManager);
    }
}
