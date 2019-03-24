package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcharge赔款费用信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLchargeAction extends BLPrpLchargeActionBase{
    private static Log log = LogFactory.getLog(BLPrpLchargeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLchargeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLchargeDto prpLchargeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLchargeDto prpLchargeDto,String mode) throws Exception{
    }
}
