package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcomRepairBill车险维修发票表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcomRepairBillAction extends BLPrpLcomRepairBillActionBase{
    private static Log log = LogFactory.getLog(BLPrpLcomRepairBillAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLcomRepairBillAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param PrpLcomRepairBillDto prpLcomRepairBillDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcomRepairBillDto prpLcomRepairBillDto,String mode) throws Exception{
    }
}
