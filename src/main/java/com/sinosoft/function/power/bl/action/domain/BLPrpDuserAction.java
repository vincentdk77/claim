package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDuser Ա��������ҵ�������չ��<br>
 * ������ 2004-11-09 18:29:25.850<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDuserAction extends BLPrpDuserActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDuserAction.class);

    /**
     * ���캯��
     */
    public BLPrpDuserAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpDuserDto prpDuserDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDuserDto prpDuserDto,String mode) throws Exception{
    }
}
