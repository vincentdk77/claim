package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdpartyStatus-���������ҵ��Ϣ������Ϣ״̬������ݷ��ʶ�����<br>
 * ������ 2005-03-18 15:44:08.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdpartyStatus extends DBPrpLthirdpartyStatusBase{
    private static Log logger = LogFactory.getLog(DBPrpLthirdpartyStatus.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLthirdpartyStatus(DBManager dbManager){
        super(dbManager);
    }
}
