package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdAgentSysData�����ݷ��ʶ�����<br>
 * ������ 2005-07-19 09:58:57.598<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdAgentSysData extends DBEdAgentSysDataBase{
    private static Log logger = LogFactory.getLog(DBEdAgentSysData.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBEdAgentSysData(DBManager dbManager){
        super(dbManager);
    }
}
