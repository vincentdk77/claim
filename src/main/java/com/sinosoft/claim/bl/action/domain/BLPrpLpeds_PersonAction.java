package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Person��Ա������ϸ��Ϣ���ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_PersonAction extends BLPrpLpeds_PersonActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_PersonAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpLpeds_PersonAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpeds_PersonDto prpLpeds_PersonDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpeds_PersonDto prpLpeds_PersonDto,String mode) throws Exception{
    }
}
