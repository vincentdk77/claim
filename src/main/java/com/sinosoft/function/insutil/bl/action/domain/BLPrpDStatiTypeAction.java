package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDStatiTypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdstatitype��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDStatiTypeAction extends BLPrpDStatiTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDStatiTypeAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDStatiTypeAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDStatiTypeDto prpDStatiTypeDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDStatiTypeDto prpDStatiTypeDto,String mode) throws Exception{
    }
}
