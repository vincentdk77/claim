package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLverifyLoss�����������ҵ�������չ��<br>
 * ������ 2004-07-19 14:24:05.204<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLverifyLossAction extends BLPrpLverifyLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossAction.class);

    /**
     * ���캯��
     */
    public BLPrpLverifyLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLverifyLossDto prpLverifyLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLverifyLossDto prpLverifyLossDto,String mode) throws Exception{
    }
}
