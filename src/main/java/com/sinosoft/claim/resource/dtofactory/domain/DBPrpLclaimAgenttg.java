package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaimagent�����Ᵽ����Ϣ������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimAgenttg extends DBPrpLclaimAgenttgBase{
    private static Log log = LogFactory.getLog(DBPrpLclaimAgenttg.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimAgenttg(DBManager dbManager){
        super(dbManager);
    }
}
