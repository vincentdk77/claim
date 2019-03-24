package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLinterInjuryPersonAction extends BLPrpLinterInjuryPersonActionBase {
    private static Logger logger = Logger.getLogger(BLPrpLinterInjuryPersonAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterInjuryPersonAction(){
        super();
    }
    
    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param PrpLinterInjuryPersonDto prpLinterInjuryPersonDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterInjuryPersonDto prpLinterInjuryPersonDto,String mode)
            throws Exception{
    }
}
