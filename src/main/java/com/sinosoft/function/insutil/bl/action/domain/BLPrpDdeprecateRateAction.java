package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdeprecateRateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddeprecaterate��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeprecateRateAction extends BLPrpDdeprecateRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdeprecateRateAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDdeprecateRateAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDdeprecateRateDto prpDdeprecateRateDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDdeprecateRateDto prpDdeprecateRateDto,String mode) throws Exception{
    }
}
