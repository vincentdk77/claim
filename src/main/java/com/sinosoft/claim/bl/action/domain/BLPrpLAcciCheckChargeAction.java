package com.sinosoft.claim.bl.action.domain;

import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是调查费用表-PrpLAcciCheckCharge的业务对象扩展类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciCheckChargeAction extends BLPrpLAcciCheckChargeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLAcciCheckChargeAction.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciCheckChargeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLAcciCheckChargeDto prpLAcciCheckChargeDto,String mode)
            throws Exception{
    }
}
