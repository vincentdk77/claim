package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeRiskDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcoderiskͨ�ô������ֶ��ձ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeRiskAction extends BLPrpDcodeRiskActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeRiskAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcodeRiskAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcodeRiskDto prpDcodeRiskDto,String mode) throws Exception{
    }
}
