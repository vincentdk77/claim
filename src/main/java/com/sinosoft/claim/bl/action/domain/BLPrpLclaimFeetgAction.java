package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeetgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplclaimfee��������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimFeetgAction extends BLPrpLclaimFeetgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimFeetgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLclaimFeetgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimFeetgDto prpLclaimFeetgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimFeetgDto prpLclaimFeetgDto,String mode) throws Exception{
    }
}
