package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplperson��Ա������ϸ��Ϣ���ҵ�������չ��<br>
 * ������ 2004-05-09 11:07:45.943<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpersonAction extends BLPrpLpersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpersonDto prpLpersonDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpersonDto prpLpersonDto,String mode) throws Exception{
    }
}
