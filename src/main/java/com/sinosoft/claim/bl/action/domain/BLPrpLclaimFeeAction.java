package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaimfee估损金额表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimFeeAction extends BLPrpLclaimFeeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimFeeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimFeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimFeeDto prpLclaimFeeDto,String mode) throws Exception{
    }
}
