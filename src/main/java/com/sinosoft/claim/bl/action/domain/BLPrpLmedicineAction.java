package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmedicineDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplmedicine��Աҽҩ���嵥���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLmedicineAction extends BLPrpLmedicineActionBase{
    private static Log log = LogFactory.getLog(BLPrpLmedicineAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLmedicineAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLmedicineDto prpLmedicineDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLmedicineDto prpLmedicineDto,String mode) throws Exception{
    }
}
