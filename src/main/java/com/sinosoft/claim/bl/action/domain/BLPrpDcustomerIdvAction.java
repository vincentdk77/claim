package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomer_idv���˿ͻ�������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerIdvAction extends BLPrpDcustomerIdvActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerIdvAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcustomerIdvAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerIdvDto prpDcustomerIdvDto,String mode) throws Exception{
    }
}
