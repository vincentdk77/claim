package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUndoCancelFee���ϻ�ɾ�������켣��������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUndoCancelFee extends DBPrpUndoCancelFeeBase{
    private static Log log = LogFactory.getLog(DBPrpUndoCancelFee.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpUndoCancelFee(DBManager dbManager){
        super(dbManager);
    }
}
