package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDshortRateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdshortrate��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshortRateAction extends BLPrpDshortRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshortRateAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDshortRateAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDshortRateDto prpDshortRateDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDshortRateDto prpDshortRateDto,String mode) throws Exception{
    }
}
