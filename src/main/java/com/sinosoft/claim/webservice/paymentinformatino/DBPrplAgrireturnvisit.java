package com.sinosoft.claim.webservice.paymentinformatino;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitBase;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLAGRIRETURNVISIT�����ݷ��ʶ�����
 * @author Administrator
 *
 */
public class DBPrplAgrireturnvisit extends DBPrplAgrireturnvisitBase{
    private static Logger logger = Logger.getLogger(DBPrplAgrireturnvisit.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplAgrireturnvisit(DBManager dbManager){
        super(dbManager);
    }
}
