package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcompensate����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcompensateAction extends BLPrpLcompensateActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcompensateAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcompensateAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcompensateDto prpLcompensateDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcompensateDto prpLcompensateDto,String mode) throws Exception{
    }
}
