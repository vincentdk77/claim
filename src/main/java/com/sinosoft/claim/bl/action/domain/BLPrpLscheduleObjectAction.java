package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLscheduleObject���ȶ�����ҵ�������չ��<br>
 * ������ 2004-07-16 09:32:43.664<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleObjectAction extends BLPrpLscheduleObjectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleObjectAction.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleObjectAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLscheduleObjectDto prpLscheduleObjectDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleObjectDto prpLscheduleObjectDto,String mode) throws Exception{
    }
}
