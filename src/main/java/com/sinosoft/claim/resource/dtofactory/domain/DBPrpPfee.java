package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppfee���ı���ѱ仯������ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:17.671<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPfee extends DBPrpPfeeBase{
    private static Log logger = LogFactory.getLog(DBPrpPfee.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPfee(DBManager dbManager){
        super(dbManager);
    }
}
