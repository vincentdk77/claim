package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcharge��������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLchargeAction extends BLPrpLchargeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLchargeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLchargeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLchargeDto prpLchargeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLchargeDto prpLchargeDto,String mode) throws Exception{
    }
}
