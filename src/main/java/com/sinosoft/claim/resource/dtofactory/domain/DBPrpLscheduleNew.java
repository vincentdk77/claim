package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLscheduleNew�°�����ʾ������ݷ��ʶ�����<br>
 * ������ 2004-07-15 21:00:43.044<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleNew extends DBPrpLscheduleNewBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleNew.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleNew(DBManager dbManager){
        super(dbManager);
    }
}
