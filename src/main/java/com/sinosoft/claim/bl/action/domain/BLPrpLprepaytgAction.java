package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepaytgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplprepayԤ��ǼǱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLprepaytgAction extends BLPrpLprepaytgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLprepaytgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLprepaytgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLprepaytgDto prpLprepaytgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLprepaytgDto prpLprepaytgDto,String mode) throws Exception{
    }
}
