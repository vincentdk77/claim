package com.sinosoft.ciplatform.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����Ͷ��ȷ������-CIInsureValid�����ݷ��ʶ�����<br>
 * ������ 2006-06-21 17:31:50.703<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIInsureValid extends DBCIInsureValidBase{
    private static Log logger = LogFactory.getLog(DBCIInsureValid.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIInsureValid(DBManager dbManager){
        super(dbManager);
    }
}
