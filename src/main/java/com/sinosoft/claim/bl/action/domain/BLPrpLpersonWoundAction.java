package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonWound ������Ϣ���ҵ�������չ��<br>
 * ������ 2005-02-18 10:21:28.781<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonWoundAction extends BLPrpLpersonWoundActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonWoundAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonWoundAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonWoundDto prpLpersonWoundDto,String mode) throws Exception{
    }
}
