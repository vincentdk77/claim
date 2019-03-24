package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplrepairfee修理费用清单的业务对象扩展类<br>
 * 创建于 2004-05-09 11:07:47.725<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLrepairFeeAction extends BLPrpLrepairFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrepairFeeAction.class);

    /**
     * 构造函数
     */
    public BLPrpLrepairFeeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLrepairFeeDto prpLrepairFeeDto,String mode) throws Exception{
    }
}
