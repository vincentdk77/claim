package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcprofitdetail�Ż��ۿ���ϸ������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCprofitDetail extends DBPrpCprofitDetailBase{
    private static Log log = LogFactory.getLog(DBPrpCprofitDetail.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCprofitDetail(DBManager dbManager){
        super(dbManager);
    }
}
