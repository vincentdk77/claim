package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjallocmid������ҵ�񱣷ѷ�̯�м������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJallocMid extends DBPrpJallocMidBase{
    private static Log log = LogFactory.getLog(DBPrpJallocMid.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJallocMid(DBManager dbManager){
        super(dbManager);
    }
}
