package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertainLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertainLoss ���������ҵ�������չ��<br>
 * ������ 2004-07-15 11:00:46.374<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcertainLossAction extends BLPrpLcertainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertainLossAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcertainLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcertainLossDto prpLcertainLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcertainLossDto prpLcertainLossDto,String mode) throws Exception{
    }
}
