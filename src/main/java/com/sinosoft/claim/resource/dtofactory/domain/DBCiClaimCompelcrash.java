package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����CIClaimCompelcrash ���⳵���������ݱ�����ݷ��ʶ�����<br>
 * ������ 2007-01-24 19:03:03.875<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimCompelcrash extends DBCiClaimCompelcrashBase{
    private static Log logger = LogFactory.getLog(DBCiClaimCompelcrash.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCiClaimCompelcrash(DBManager dbManager){
        super(dbManager);
    }
}
