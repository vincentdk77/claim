package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcetainLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcetainLoss��ҵ�������չ��<br>
 * ������ 2005-03-18 15:44:09.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcetainLossAction extends BLPrpLcetainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcetainLossAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcetainLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcetainLossDto prpLcetainLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcetainLossDto prpLcetainLossDto,String mode) throws Exception{
    }
}
