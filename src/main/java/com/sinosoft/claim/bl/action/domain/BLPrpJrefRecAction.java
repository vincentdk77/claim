package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefrec���ѵǼǱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefRecAction extends BLPrpJrefRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefRecAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJrefRecAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJrefRecDto prpJrefRecDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJrefRecDto prpJrefRecDto,String mode) throws Exception{
    }
}
