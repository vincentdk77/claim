package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_list��������ͨ�������ϸ�嵥�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLQsList extends DBPrpLQsListBase{
    private static Log log = LogFactory.getLog(DBPrpLQsList.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLQsList(DBManager dbManager){
        super(dbManager);
    }
}
