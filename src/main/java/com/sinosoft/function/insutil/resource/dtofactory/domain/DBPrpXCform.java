package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxcform�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpXCform extends DBPrpXCformBase{
    private static Log log = LogFactory.getLog(DBPrpXCform.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpXCform(DBManager dbManager){
        super(dbManager);
    }
}
