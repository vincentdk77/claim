package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLdeductCond-�����������������ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLdeductCondAction extends BLPrpLdeductCondActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLdeductCondAction.class);

    /**
     * ���캯��
     */
    public BLPrpLdeductCondAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLdeductCondDto prpLdeductCondDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLdeductCondDto prpLdeductCondDto,String mode)
            throws Exception{
    }
}
