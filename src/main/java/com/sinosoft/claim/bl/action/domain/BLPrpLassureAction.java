package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplassure����������������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLassureAction extends BLPrpLassureActionBase{
    private static Log log = LogFactory.getLog(BLPrpLassureAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLassureAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLassureDto prpLassureDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLassureDto prpLassureDto,String mode) throws Exception{
    }
}
