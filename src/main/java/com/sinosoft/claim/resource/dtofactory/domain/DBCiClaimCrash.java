package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����CIClaimCrash ���������¼�����ݷ��ʶ�����<br>
 * ������ 2007-01-24 19:03:03.937<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimCrash extends DBCiClaimCrashBase{
    private static Log logger = LogFactory.getLog(DBCiClaimCrash.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCiClaimCrash(DBManager dbManager){
        super(dbManager);
    }
}
