package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDscrapTermDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdscrapterm�������ϱ�׼���ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDscrapTermAction extends BLPrpDscrapTermActionBase{
    private static Log log = LogFactory.getLog(BLPrpDscrapTermAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDscrapTermAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDscrapTermDto prpDscrapTermDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDscrapTermDto prpDscrapTermDto,String mode) throws Exception{
    }
}
