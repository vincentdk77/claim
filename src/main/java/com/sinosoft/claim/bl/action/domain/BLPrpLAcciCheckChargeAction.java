package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǵ�����ñ�-PrpLAcciCheckCharge��ҵ�������չ��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciCheckChargeAction extends BLPrpLAcciCheckChargeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLAcciCheckChargeAction.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciCheckChargeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLAcciCheckChargeDto prpLAcciCheckChargeDto,String mode)
            throws Exception{
    }
}
