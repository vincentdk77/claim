package com.sinosoft.servlet.accisd.bl.action.domain;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PRPLACCICLAIMINFOSD��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciClaimInfoSDAction extends BLPrpLAcciClaimInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciClaimInfoSDAction.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciClaimInfoSDAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto,String mode)
            throws Exception{
    }
}
