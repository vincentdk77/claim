package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcetainLoss�����ݷ��ʶ�����<br>
 * ������ 2005-03-18 15:44:09.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcetainLoss extends DBPrpLcetainLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLcetainLoss.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcetainLoss(DBManager dbManager){
        super(dbManager);
    }
}
