package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiworkflow������������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiWorkFlow extends DBUtiWorkFlowBase{
    private static Log log = LogFactory.getLog(DBUtiWorkFlow.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiWorkFlow(DBManager dbManager){
        super(dbManager);
    }
}
