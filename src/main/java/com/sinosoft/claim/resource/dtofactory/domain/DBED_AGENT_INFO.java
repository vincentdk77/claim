package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϯԱ����Ϣ������ݷ��ʶ�����<br>
 * ������ 2005-07-19 09:58:57.598<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBED_AGENT_INFO extends DBED_AGENT_INFOBase{
    private static Log logger = LogFactory.getLog(DBED_AGENT_INFO.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBED_AGENT_INFO(DBManager dbManager){
        super(dbManager);
    }
}
