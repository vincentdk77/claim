package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaUser-��ϯԱ��Ϣ������ݷ��ʶ�����<br>
 * ������ 2005-06-22 14:56:42.040<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaUser extends DBEdaUserBase{
    private static Log logger = LogFactory.getLog(DBEdaUser.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBEdaUser(DBManager dbManager){
        super(dbManager);
    }
}
