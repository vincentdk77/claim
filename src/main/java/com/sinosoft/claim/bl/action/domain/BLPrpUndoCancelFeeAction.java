package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUndoCancelFeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUndoCancelFee作废或删除操作轨迹附表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUndoCancelFeeAction extends BLPrpUndoCancelFeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUndoCancelFeeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpUndoCancelFeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpUndoCancelFeeDto prpUndoCancelFeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpUndoCancelFeeDto prpUndoCancelFeeDto,String mode) throws Exception{
    }
}
