package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLscheduleObject���ȶ��������ݷ��ʶ�����<br>
 * ������ 2004-07-15 21:00:43.255<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleObject extends DBPrpLscheduleObjectBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleObject.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleObject(DBManager dbManager){
        super(dbManager);
    }
}
