package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplassuredetail��������������������ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLassureDetailAction extends BLPrpLassureDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpLassureDetailAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLassureDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLassureDetailDto prpLassureDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLassureDetailDto prpLassureDetailDto,String mode) throws Exception{
    }
}
