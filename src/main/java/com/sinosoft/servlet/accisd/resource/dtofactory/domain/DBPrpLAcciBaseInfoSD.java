package com.sinosoft.servlet.accisd.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLACCIBASEINFOSD�����ݷ��ʶ�����<br>
 * ������ 2018-07-24 15:18:40.245<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciBaseInfoSD extends DBPrpLAcciBaseInfoSDBase{
    private static Logger logger = Logger.getLogger(DBPrpLAcciBaseInfoSD.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLAcciBaseInfoSD(DBManager dbManager){
        super(dbManager);
    }
}
