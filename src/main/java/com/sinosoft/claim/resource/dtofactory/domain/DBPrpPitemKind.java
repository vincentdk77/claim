package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppitemkind���������Ϣ�����ݷ��ʶ�����<br>
 * ������ 2004-11-22 15:24:18.156<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPitemKind extends DBPrpPitemKindBase{
    private static Log logger = LogFactory.getLog(DBPrpPitemKind.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPitemKind(DBManager dbManager){
        super(dbManager);
    }
}
