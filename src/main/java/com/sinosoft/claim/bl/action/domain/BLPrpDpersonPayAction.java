package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDpersonPay��Ա�⸶��׼�����ҵ�������չ��<br>
 * ������ 2004-09-20 14:11:31.382<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayAction extends BLPrpDpersonPayActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonPayAction.class);

    /**
     * ���캯��
     */
    public BLPrpDpersonPayAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDpersonPayDto prpDpersonPayDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto,String mode) throws Exception{
    }
}
