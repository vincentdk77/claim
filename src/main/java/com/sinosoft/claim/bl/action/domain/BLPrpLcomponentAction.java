package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcomponent������Ŀ�嵥��ҵ�������չ��<br>
 * ������ 2004-05-09 11:07:47.765<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcomponentAction extends BLPrpLcomponentActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomponentAction.class);

    /**
     * ���캯��
     */
    public BLPrpLcomponentAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcomponentDto prpLcomponentDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcomponentDto prpLcomponentDto,String mode) throws Exception{
    }
}
