package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLscheduleNew�°�����ʾ���ҵ�������չ��<br>
 * ������ 2004-07-16 09:32:43.554<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleNewAction extends BLPrpLscheduleNewActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleNewAction.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleNewAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleNewDto prpLscheduleNewDto,String mode) throws Exception{
    }
}
