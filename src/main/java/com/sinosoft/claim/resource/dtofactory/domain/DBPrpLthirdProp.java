package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdProp-�Ʋ���ʧ��λ������ݷ��ʶ�����<br>
 * ������ 2005-04-12 11:37:49.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdProp extends DBPrpLthirdPropBase{
    private static Log logger = LogFactory.getLog(DBPrpLthirdProp.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLthirdProp(DBManager dbManager){
        super(dbManager);
    }
}
