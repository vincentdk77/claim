package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrationDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdration���������ձ������ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrationAction extends BLPrpDrationActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrationAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDrationAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDrationDto prpDrationDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrationDto prpDrationDto,String mode) throws Exception{
    }
}
