package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLscheduleItem���������ı��ҵ�������չ��<br>
 * ������ 2004-07-16 09:32:43.634<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleItemAction extends BLPrpLscheduleItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleItemAction.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleItemAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleItemDto prpLscheduleItemDto,String mode) throws Exception{
    }
}
