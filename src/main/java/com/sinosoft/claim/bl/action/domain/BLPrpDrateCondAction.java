package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateCondDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdratecond费率条件表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateCondAction extends BLPrpDrateCondActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateCondAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDrateCondAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDrateCondDto prpDrateCondDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDrateCondDto prpDrateCondDto,String mode) throws Exception{
    }
}
