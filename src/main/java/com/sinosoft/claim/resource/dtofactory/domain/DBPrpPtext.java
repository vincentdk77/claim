package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpptext����������Ϣ�����ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:18.203<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPtext extends DBPrpPtextBase{
    private static Log logger = LogFactory.getLog(DBPrpPtext.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPtext(DBManager dbManager){
        super(dbManager);
    }
}
