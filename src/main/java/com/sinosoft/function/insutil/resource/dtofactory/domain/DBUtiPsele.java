package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipsele�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:31<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPsele extends DBUtiPseleBase{
    private static Log log = LogFactory.getLog(DBUtiPsele.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiPsele(DBManager dbManager){
        super(dbManager);
    }
}
