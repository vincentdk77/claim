package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcurrencyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcurrency��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcurrencyAction extends BLPrpDcurrencyActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcurrencyAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDcurrencyAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDcurrencyDto prpDcurrencyDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcurrencyDto prpDcurrencyDto,String mode) throws Exception{
    }
}
