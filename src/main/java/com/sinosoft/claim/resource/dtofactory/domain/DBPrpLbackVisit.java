package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisit--�ط���Ϣ��������ݷ��ʶ�����<br>
 * ������ 2005-03-25 20:44:44.828<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisit extends DBPrpLbackVisitBase{
    private static Log logger = LogFactory.getLog(DBPrpLbackVisit.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLbackVisit(DBManager dbManager){
        super(dbManager);
    }
}
