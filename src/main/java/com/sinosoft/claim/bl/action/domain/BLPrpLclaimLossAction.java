package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss��ҵ�������չ��<br>
 * ������ 2004-06-24 14:46:15.079<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimLossAction extends BLPrpLclaimLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLossAction.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimLossDto prpLclaimLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimLossDto prpLclaimLossDto,String mode) throws Exception{
    }
}
