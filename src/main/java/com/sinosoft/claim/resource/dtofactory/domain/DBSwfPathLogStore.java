package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfPathLogStore�����ݷ��ʶ�����<br>
 * ������ 2006-12-08 14:08:41.984<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfPathLogStore extends DBSwfPathLogStoreBase{
    private static Log logger = LogFactory.getLog(DBSwfPathLogStore.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfPathLogStore(DBManager dbManager){
        super(dbManager);
    }
}
