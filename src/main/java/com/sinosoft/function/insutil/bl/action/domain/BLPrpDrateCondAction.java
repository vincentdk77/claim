package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateCondDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdratecond��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateCondAction extends BLPrpDrateCondActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateCondAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpDrateCondAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDrateCondDto prpDrateCondDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrateCondDto prpDrateCondDto,String mode) throws Exception{
    }
}
