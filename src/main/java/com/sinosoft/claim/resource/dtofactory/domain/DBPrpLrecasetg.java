package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplrecase�ؿ��ⰸ������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLrecasetg extends DBPrpLrecasetgBase{
    private static Log log = LogFactory.getLog(DBPrpLrecasetg.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLrecasetg(DBManager dbManager){
        super(dbManager);
    }
}
