package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLmessage������ת�������Ա��ҵ�������չ��<br>
 * ������ 2004-07-27 16:11:43.096<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLmessageAction extends BLPrpLmessageActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmessageAction.class);

    /**
     * ���캯��
     */
    public BLPrpLmessageAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLmessageDto prpLmessageDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLmessageDto prpLmessageDto,String mode) throws Exception{
    }



}
