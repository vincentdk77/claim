package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppengage�ر�Լ��������ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:17.750<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPengage extends DBPrpPengageBase{
    private static Log logger = LogFactory.getLog(DBPrpPengage.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPengage(DBManager dbManager){
        super(dbManager);
    }
}
