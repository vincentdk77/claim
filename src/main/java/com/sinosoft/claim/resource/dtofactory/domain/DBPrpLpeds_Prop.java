package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Prop�Ʋ���ʧ�ӿ����ݱ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_Prop extends DBPrpLpeds_PropBase{
    private static Log log = LogFactory.getLog(DBPrpLpeds_Prop.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpeds_Prop(DBManager dbManager){
        super(dbManager);
    }
}
