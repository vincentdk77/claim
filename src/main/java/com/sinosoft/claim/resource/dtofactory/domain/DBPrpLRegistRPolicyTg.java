package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLRegistRPolicy�ⰸ��������������ݷ��ʶ�����<br>
 * ������ 2006-06-04 15:22:07.456<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLRegistRPolicyTg extends DBPrpLRegistRPolicyTgBase{
    private static Log logger = LogFactory.getLog(DBPrpLRegistRPolicyTg.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLRegistRPolicyTg(DBManager dbManager){
        super(dbManager);
    }
}
