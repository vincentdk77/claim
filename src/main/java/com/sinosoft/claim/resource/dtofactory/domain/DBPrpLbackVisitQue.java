package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitQue--�ط���ѯ������ݷ��ʶ�����<br>
 * ������ 2005-03-23 09:00:21.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisitQue extends DBPrpLbackVisitQueBase{
    private static Log logger = LogFactory.getLog(DBPrpLbackVisitQue.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLbackVisitQue(DBManager dbManager){
        super(dbManager);
    }
}
