package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomer�ͻ���Ϣ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:46<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerAction extends BLPrpDcustomerActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcustomerAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcustomerDto prpDcustomerDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerDto prpDcustomerDto,String mode) throws Exception{
    }
}
