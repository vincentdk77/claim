package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregistExt-������Ϣ����˵�������ݷ��ʶ�����<br>
 * ������ 2005-03-11 11:11:43.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLregistExt extends DBPrpLregistExtBase{
    private static Log logger = LogFactory.getLog(DBPrpLregistExt.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLregistExt(DBManager dbManager){
        super(dbManager);
    }
}
