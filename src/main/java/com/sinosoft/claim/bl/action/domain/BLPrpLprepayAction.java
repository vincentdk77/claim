package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplprepayԤ��ǼǱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLprepayAction extends BLPrpLprepayActionBase{
    private static Log log = LogFactory.getLog(BLPrpLprepayAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLprepayAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLprepayDto prpLprepayDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLprepayDto prpLprepayDto,String mode) throws Exception{
    }
}
