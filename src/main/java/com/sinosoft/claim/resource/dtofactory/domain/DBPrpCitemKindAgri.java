package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpCitemKindAgri�����ݷ��ʶ�����<br>
 * ������ 2007-01-30 20:27:06.515<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemKindAgri extends DBPrpCitemKindAgriBase{
    private static Log logger = LogFactory.getLog(DBPrpCitemKindAgri.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCitemKindAgri(DBManager dbManager){
        super(dbManager);
    }
}
