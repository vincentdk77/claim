package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WFPATH������·�����������ݷ��ʶ�����<br>
 * ������ 2004-08-09 19:54:51.882<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfPath extends DBSwfPathBase{
    private static Log logger = LogFactory.getLog(DBSwfPath.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfPath(DBManager dbManager){
        super(dbManager);
    }
}
