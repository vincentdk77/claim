package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensatetgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcompensate����������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcompensatetgAction extends BLPrpLcompensatetgActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcompensatetgAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLcompensatetgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcompensatetgDto prpLcompensatetgDto,String mode) throws Exception{
    }
}
