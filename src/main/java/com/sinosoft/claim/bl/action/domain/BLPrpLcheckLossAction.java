package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcheckloss�鿱�¹ʹ��������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcheckLossAction extends BLPrpLcheckLossActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcheckLossAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcheckLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcheckLossDto prpLcheckLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckLossDto prpLcheckLossDto,String mode) throws Exception{
    }
}