package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDpersonPayDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdpersonpay��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayAction extends BLPrpDpersonPayActionBase{
    private static Log log = LogFactory.getLog(BLPrpDpersonPayAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDpersonPayAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDpersonPayDto prpDpersonPayDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto,String mode) throws Exception{
    }
}
