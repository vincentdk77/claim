package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplrepairfee��������嵥��ҵ�������չ��<br>
 * ������ 2004-05-09 11:07:47.725<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLrepairFeeAction extends BLPrpLrepairFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrepairFeeAction.class);

    /**
     * ���캯��
     */
    public BLPrpLrepairFeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLrepairFeeDto prpLrepairFeeDto,String mode) throws Exception{
    }
}
