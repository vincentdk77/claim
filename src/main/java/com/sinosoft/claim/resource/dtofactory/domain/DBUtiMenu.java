package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utimenu�˵����Ʊ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiMenu extends DBUtiMenuBase{
    private static Log log = LogFactory.getLog(DBUtiMenu.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiMenu(DBManager dbManager){
        super(dbManager);
    }
}
