package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDcustomerUnit��λ�ͻ�������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerUnitAction extends BLPrpDcustomerUnitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerUnitAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcustomerUnitAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerUnitDto PrpDcustomerUnitDto,String mode) throws Exception{
    }
}
