package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����MidResultConfig���ҳ�����ñ�����ݷ��ʶ�����<br>
 * ������ 2005-03-11 10:51:27.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBMidResultConfig extends DBMidResultConfigBase{
    private static Log logger = LogFactory.getLog(DBMidResultConfig.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBMidResultConfig(DBManager dbManager){
        super(dbManager);
    }
}
