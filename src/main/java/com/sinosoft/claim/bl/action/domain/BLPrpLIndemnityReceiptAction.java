package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������վݵ�ҵ�������չ��<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLIndemnityReceiptAction extends BLPrpLIndemnityReceiptActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLIndemnityReceiptAction.class);

    /**
     * ���캯��
     */
    public BLPrpLIndemnityReceiptAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLIndemnityReceiptDto prpLIndemnityReceiptDto,String mode)
            throws Exception{
    }
}
