package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleCompanyMobile--�������ĵ绰������ݷ��ʶ�����<br>
 * ������ 2005-09-01 10:09:58.243<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleCompanyMobile extends DBPrpLscheduleCompanyMobileBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleCompanyMobile.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleCompanyMobile(DBManager dbManager){
        super(dbManager);
    }
}
