package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaim����������Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimAction extends BLPrpLclaimActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLclaimDto prpLclaimDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimDto prpLclaimDto,String mode) throws Exception{
    }
}
