package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdeprecateRateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpddeprecaterate折旧率表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeprecateRateAction extends BLPrpDdeprecateRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdeprecateRateAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDdeprecateRateAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDdeprecateRateDto prpDdeprecateRateDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDdeprecateRateDto prpDdeprecateRateDto,String mode) throws Exception{
    }
}
