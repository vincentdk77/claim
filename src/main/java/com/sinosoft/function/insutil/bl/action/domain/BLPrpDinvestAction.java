package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDinvestDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdinvest��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDinvestAction extends BLPrpDinvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpDinvestAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDinvestAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDinvestDto prpDinvestDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDinvestDto prpDinvestDto,String mode) throws Exception{
    }
}
