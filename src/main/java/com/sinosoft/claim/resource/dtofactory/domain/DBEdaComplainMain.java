package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaComplainMainͶ����Ϣ������ݷ��ʶ�����<br>
 * ������ 2005-08-20 17:41:16.322<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaComplainMain extends DBEdaComplainMainBase{
    private static Log logger = LogFactory.getLog(DBEdaComplainMain.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBEdaComplainMain(DBManager dbManager){
        super(dbManager);
    }
}
