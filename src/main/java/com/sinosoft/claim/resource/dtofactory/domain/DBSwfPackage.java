package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WFPACKAGE��������־ҵ����Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-08-09 19:54:51.932<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfPackage extends DBSwfPackageBase{
    private static Log logger = LogFactory.getLog(DBSwfPackage.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfPackage(DBManager dbManager){
        super(dbManager);
    }
}
