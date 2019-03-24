package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLoss定核损主表的业务对象扩展类<br>
 * 创建于 2004-07-19 14:24:05.204<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLverifyLossAction extends BLPrpLverifyLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossAction.class);

    /**
     * 构造函数
     */
    public BLPrpLverifyLossAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLverifyLossDto prpLverifyLossDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLverifyLossDto prpLverifyLossDto,String mode) throws Exception{
    }
}
