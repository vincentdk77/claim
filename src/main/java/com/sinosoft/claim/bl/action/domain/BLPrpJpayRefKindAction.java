package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRefKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpayrefkind�ո����ձ��̯���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayRefKindAction extends BLPrpJpayRefKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayRefKindAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJpayRefKindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJpayRefKindDto prpJpayRefKindDto,String mode) throws Exception{
    }
}
