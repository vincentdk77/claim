package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLscheduleMain-�������������ҵ�������չ��<br>
 * ������ 2005-03-18 16:42:20.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainAction extends BLPrpLscheduleMainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainAction.class);

    /**
     * ���캯��
     */
    public BLPrpLscheduleMainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLscheduleMainDto prpLscheduleMainDto,String mode) throws Exception{
    }
}
