package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Person��Ա������ϸ��Ϣ������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_Person extends DBPrpLpeds_PersonBase{
    private static Log log = LogFactory.getLog(DBPrpLpeds_Person.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpeds_Person(DBManager dbManager){
        super(dbManager);
    }
}
