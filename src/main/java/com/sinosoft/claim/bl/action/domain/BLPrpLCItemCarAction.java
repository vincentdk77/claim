package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCItemCarDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLCItemCar���Ᵽ�����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLCItemCarAction extends BLPrpLCItemCarActionBase{
    private static Log log = LogFactory.getLog(BLPrpLCItemCarAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLCItemCarAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLCItemCarDto prpLCItemCarDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLCItemCarDto prpLCItemCarDto,String mode) throws Exception{
    }
}
