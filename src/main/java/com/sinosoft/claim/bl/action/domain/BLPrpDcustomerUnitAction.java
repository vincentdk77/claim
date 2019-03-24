package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDcustomerUnit单位客户代码表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerUnitAction extends BLPrpDcustomerUnitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerUnitAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDcustomerUnitAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcustomerUnitDto PrpDcustomerUnitDto,String mode) throws Exception{
    }
}
