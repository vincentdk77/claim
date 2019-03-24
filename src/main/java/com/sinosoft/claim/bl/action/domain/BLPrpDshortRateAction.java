package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshortRateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdshortrate月短期费率表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshortRateAction extends BLPrpDshortRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshortRateAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDshortRateAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDshortRateDto prpDshortRateDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDshortRateDto prpDshortRateDto,String mode) throws Exception{
    }
}
