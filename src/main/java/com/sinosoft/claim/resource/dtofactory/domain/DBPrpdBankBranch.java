package com.sinosoft.claim.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpdBankBranch�����ݷ��ʶ�����<br>
 * ������ 2018-01-26 15:40:08.171<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpdBankBranch extends DBPrpdBankBranchBase{
    private static Logger logger = Logger.getLogger(DBPrpdBankBranch.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpdBankBranch(DBManager dbManager){
        super(dbManager);
    }
}
