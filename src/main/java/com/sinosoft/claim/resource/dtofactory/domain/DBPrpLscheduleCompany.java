package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleCompany--����������ʾ��Ϣ���ñ�����ݷ��ʶ�����<br>
 * ������ 2005-08-08 21:52:10.851<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleCompany extends DBPrpLscheduleCompanyBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleCompany.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleCompany(DBManager dbManager){
        super(dbManager);
    }
}
