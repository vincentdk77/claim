package com.sinosoft.servlet.accisd.bl.action.domain;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLACCICLAIMINFOSD的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciClaimInfoSDAction extends BLPrpLAcciClaimInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciClaimInfoSDAction.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciClaimInfoSDAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto,String mode)
            throws Exception{
    }
}
