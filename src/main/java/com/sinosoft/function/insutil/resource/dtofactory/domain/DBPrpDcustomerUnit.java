package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomerunit�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:29<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerUnit extends DBPrpDcustomerUnitBase{
    private static Log log = LogFactory.getLog(DBPrpDcustomerUnit.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcustomerUnit(DBManager dbManager){
        super(dbManager);
    }
}
