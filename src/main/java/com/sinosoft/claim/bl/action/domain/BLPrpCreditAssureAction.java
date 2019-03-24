package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditAssureDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCreditAssure风险预警确认函号表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCreditAssureAction extends BLPrpCreditAssureActionBase{
    private static Log log = LogFactory.getLog(BLPrpCreditAssureAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCreditAssureAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCreditAssureDto prpCreditAssureDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCreditAssureDto prpCreditAssureDto,String mode) throws Exception{
    }
}
