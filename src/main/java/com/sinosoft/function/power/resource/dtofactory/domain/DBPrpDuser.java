package com.sinosoft.function.power.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDuser Ա�����������ݷ��ʶ�����<br>
 * ������ 2004-11-09 18:30:40.418<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDuser extends DBPrpDuserBase{
    private static Log logger = LogFactory.getLog(DBPrpDuser.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDuser(DBManager dbManager){
        super(dbManager);
    }
}
