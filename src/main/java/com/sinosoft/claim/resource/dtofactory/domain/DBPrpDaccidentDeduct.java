package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDaccidentDeduct-�¹����������ʵ����ݷ��ʶ�����<br>
 * ������ 2006-06-05 19:44:13.843<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDaccidentDeduct extends DBPrpDaccidentDeductBase{
    private static Log logger = LogFactory.getLog(DBPrpDaccidentDeduct.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDaccidentDeduct(DBManager dbManager){
        super(dbManager);
    }
}
