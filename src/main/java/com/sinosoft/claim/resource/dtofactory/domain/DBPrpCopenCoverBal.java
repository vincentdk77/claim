package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcopencoverbalЭ������¼������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCopenCoverBal extends DBPrpCopenCoverBalBase{
    private static Log log = LogFactory.getLog(DBPrpCopenCoverBal.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCopenCoverBal(DBManager dbManager){
        super(dbManager);
    }
}
