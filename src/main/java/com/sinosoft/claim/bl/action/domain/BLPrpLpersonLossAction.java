package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplpersonloss��Ա�⸶��Ϣ����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonLossAction extends BLPrpLpersonLossActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpersonLossAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLpersonLossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpersonLossDto prpLpersonLossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonLossDto prpLpersonLossDto,String mode) throws Exception{
    }
}