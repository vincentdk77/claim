package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckItem-查勘任务标的表（新增）的业务对象扩展类<br>
 * 创建于 2005-03-18 15:44:09.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckItemAction extends BLPrpLcheckItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckItemAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcheckItemAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcheckItemDto prpLcheckItemDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcheckItemDto prpLcheckItemDto,String mode) throws Exception{
    }
}
