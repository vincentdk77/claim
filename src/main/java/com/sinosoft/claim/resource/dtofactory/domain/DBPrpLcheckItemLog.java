package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItemLog-�鿱������Ϣ������־������ݷ��ʶ�����<br>
 * ������ 2005-03-18 15:44:09.156<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcheckItemLog extends DBPrpLcheckItemLogBase{
    private static Log logger = LogFactory.getLog(DBPrpLcheckItemLog.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcheckItemLog(DBManager dbManager){
        super(dbManager);
    }
}
