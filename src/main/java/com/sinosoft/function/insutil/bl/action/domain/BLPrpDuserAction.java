package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpduser��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:32<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDuserAction extends BLPrpDuserActionBase{
    private static Log log = LogFactory.getLog(BLPrpDuserAction.class.getName());

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
