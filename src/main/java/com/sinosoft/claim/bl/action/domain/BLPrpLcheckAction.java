package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcheck�鿱/���鿱��Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcheckAction extends BLPrpLcheckActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcheckAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcheckAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLcheckDto prpLcheckDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckDto prpLcheckDto,String mode) throws Exception{
    }
}
