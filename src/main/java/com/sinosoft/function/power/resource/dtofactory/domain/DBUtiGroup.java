package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiGroup  Ȩ����ű�����ݷ��ʶ�����<br>
 * ������ 2004-11-09 10:40:49.301<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiGroup extends DBUtiGroupBase{
    private static Log logger = LogFactory.getLog(DBUtiGroup.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiGroup(DBManager dbManager){
        super(dbManager);
    }
}
