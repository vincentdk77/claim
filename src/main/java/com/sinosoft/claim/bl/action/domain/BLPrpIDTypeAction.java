package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDTypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidtype�ӿڴ������ͱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDTypeAction extends BLPrpIDTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDTypeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpIDTypeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpIDTypeDto prpIDTypeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpIDTypeDto prpIDTypeDto,String mode) throws Exception{
    }
}
