package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLacciCheckText�����ݷ��ʶ�����<br>
 * ������ 2005-06-14 12:03:15.687<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciCheckText extends DBPrpLacciCheckTextBase{
    private static Log logger = LogFactory.getLog(DBPrpLacciCheckText.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLacciCheckText(DBManager dbManager){
        super(dbManager);
    }
}
