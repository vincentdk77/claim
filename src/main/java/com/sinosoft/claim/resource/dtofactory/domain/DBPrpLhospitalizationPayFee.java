package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLhospitalizationPayFee�����ݷ��ʶ�����<br>
 * ������ 2007-05-23 14:10:26.242<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLhospitalizationPayFee extends DBPrpLhospitalizationPayFeeBase{
    private static Log logger = LogFactory.getLog(DBPrpLhospitalizationPayFee.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLhospitalizationPayFee(DBManager dbManager){
        super(dbManager);
    }
}
