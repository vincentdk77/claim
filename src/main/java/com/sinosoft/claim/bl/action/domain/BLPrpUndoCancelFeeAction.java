package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelFeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUndoCancelFee���ϻ�ɾ�������켣�����ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelFeeAction extends BLPrpUndoCancelFeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelFeeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpUndoCancelFeeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpUndoCancelFeeDto prpUndoCancelFeeDto,String mode) throws Exception{
    }
}
