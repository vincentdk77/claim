package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WfNode�������ڵ㶨�������ݷ��ʶ�����<br>
 * ������ 2004-08-09 19:54:51.862<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfNode extends DBSwfNodeBase{
    private static Log logger = LogFactory.getLog(DBSwfNode.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfNode(DBManager dbManager){
        super(dbManager);
    }
}
