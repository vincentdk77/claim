package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpversion���ݿ�汾��Ϣ�������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpVersion extends DBPrpVersionBase{
    private static Log log = LogFactory.getLog(DBPrpVersion.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpVersion(DBManager dbManager){
        super(dbManager);
    }
}