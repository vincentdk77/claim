package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcarLoss-����������ҵ�������չ��<br>
 * ������ 2005-03-18 15:44:09.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcarLossAction extends BLPrpLcarLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcarLossAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcarLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcarLossDto prpLcarLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcarLossDto prpLcarLossDto,String mode) throws Exception{
    }
}
