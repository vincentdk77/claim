package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������ƽ̨��ѯ������ݷ��ʶ�����<br>
 * ������ 2006-06-21 20:28:57.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimDemand extends DBCIClaimDemandBase{
    private static Log logger = LogFactory.getLog(DBCIClaimDemand.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimDemand(DBManager dbManager){
        super(dbManager);
    }
}
