package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplloss�⸶�����Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLlossAction extends BLPrpLlossActionBase{
    private static Log log = LogFactory.getLog(BLPrpLlossAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLlossAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLlossDto prpLlossDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLlossDto prpLlossDto,String mode) throws Exception{
    }
}
