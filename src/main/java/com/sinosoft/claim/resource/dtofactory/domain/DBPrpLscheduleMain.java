package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMain-����������������ݷ��ʶ�����<br>
 * ������ 2005-03-18 16:42:19.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLscheduleMain extends DBPrpLscheduleMainBase{
    private static Log logger = LogFactory.getLog(DBPrpLscheduleMain.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLscheduleMain(DBManager dbManager){
        super(dbManager);
    }
    
}
