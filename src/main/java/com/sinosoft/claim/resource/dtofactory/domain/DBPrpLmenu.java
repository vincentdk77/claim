package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmenu-�˵���(����)�����ݷ��ʶ�����<br>
 * ������ 2005-05-08 15:15:52.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLmenu extends DBPrpLmenuBase{
    private static Log logger = LogFactory.getLog(DBPrpLmenu.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLmenu(DBManager dbManager){
        super(dbManager);
    }
}
