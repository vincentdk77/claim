package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcustomer��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerAction extends BLPrpDcustomerActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcustomerAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcustomerDto prpDcustomerDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerDto prpDcustomerDto,String mode) throws Exception{
    }
}
