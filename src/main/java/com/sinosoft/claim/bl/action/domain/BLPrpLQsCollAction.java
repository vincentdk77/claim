package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsCollDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLQs_coll��������ͨ�������ܱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsCollAction extends BLPrpLQsCollActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsCollAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLQsCollAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLQs_collDto prpLQs_collDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLQsCollDto prpLQs_collDto,String mode) throws Exception{
    }
}
