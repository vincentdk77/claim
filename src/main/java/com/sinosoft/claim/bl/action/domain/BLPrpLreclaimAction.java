package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreclaimDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplreclaim���������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLreclaimAction extends BLPrpLreclaimActionBase{
    private static Log log = LogFactory.getLog(BLPrpLreclaimAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLreclaimAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLreclaimDto prpLreclaimDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLreclaimDto prpLreclaimDto,String mode) throws Exception{
    }
}
