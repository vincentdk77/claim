package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ�����ݷ��ʶ�����<br>
 * ������ 2006-06-20 15:51:34.484<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDpersonFeeCodeRisk extends DBPrpDpersonFeeCodeRiskBase{
    private static Log logger = LogFactory.getLog(DBPrpDpersonFeeCodeRisk.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDpersonFeeCodeRisk(DBManager dbManager){
        super(dbManager);
    }
}
