package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonTrace ���˸��ٱ��ҵ�������չ��<br>
 * ������ 2005-02-18 10:21:28.781<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonTraceAction extends BLPrpLpersonTraceActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonTraceAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonTraceAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonTraceDto prpLpersonTraceDto,String mode) throws Exception{
    }
}
