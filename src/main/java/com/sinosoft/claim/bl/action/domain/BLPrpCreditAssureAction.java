package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditAssureDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpCreditAssure����Ԥ��ȷ�Ϻ��ű��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCreditAssureAction extends BLPrpCreditAssureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCreditAssureAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCreditAssureAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCreditAssureDto prpCreditAssureDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCreditAssureDto prpCreditAssureDto,String mode) throws Exception{
    }
}
