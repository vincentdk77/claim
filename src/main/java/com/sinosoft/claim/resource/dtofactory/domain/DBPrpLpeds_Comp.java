package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Comp�����嵥�ӿ����ݱ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_Comp extends DBPrpLpeds_CompBase{
    private static Log log = LogFactory.getLog(DBPrpLpeds_Comp.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpeds_Comp(DBManager dbManager){
        super(dbManager);
    }
}
