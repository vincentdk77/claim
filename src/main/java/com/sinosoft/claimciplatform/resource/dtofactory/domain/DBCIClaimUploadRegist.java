package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣƽ̨�ϴ�ע�������ݷ��ʶ�����<br>
 * ������ 2006-06-21 20:29:13.609<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadRegist extends DBCIClaimUploadRegistBase{
    private static Log logger = LogFactory.getLog(DBCIClaimUploadRegist.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimUploadRegist(DBManager dbManager){
        super(dbManager);
    }
}
