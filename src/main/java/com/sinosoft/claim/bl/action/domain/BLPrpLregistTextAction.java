package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplregisttext�ⰸ���ֱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLregistTextAction extends BLPrpLregistTextActionBase{
    private static Log log = LogFactory.getLog(BLPrpLregistTextAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLregistTextAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLregistTextDto prpLregistTextDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLregistTextDto prpLregistTextDto,String mode) throws Exception{
    }
}
