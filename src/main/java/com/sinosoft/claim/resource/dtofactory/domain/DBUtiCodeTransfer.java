package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiCodeTransfer -�������������ձ�����ݷ��ʶ�����<br>
 * ������ 2005-05-09 09:01:22.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBUtiCodeTransfer extends DBUtiCodeTransferBase{
    private static Log logger = LogFactory.getLog(DBUtiCodeTransfer.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiCodeTransfer(DBManager dbManager){
        super(dbManager);
    }
}
