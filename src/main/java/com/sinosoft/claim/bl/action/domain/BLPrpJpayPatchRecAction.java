package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayPatchRecDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpaypatchrec�����շѵǼǱ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJpayPatchRecAction extends BLPrpJpayPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJpayPatchRecAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpJpayPatchRecAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpJpayPatchRecDto prpJpayPatchRecDto,String mode) throws Exception{
    }
}
