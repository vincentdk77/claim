package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxpcol�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpXPcol extends DBPrpXPcolBase{
    private static Log log = LogFactory.getLog(DBPrpXPcol.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpXPcol(DBManager dbManager){
        super(dbManager);
    }
}
