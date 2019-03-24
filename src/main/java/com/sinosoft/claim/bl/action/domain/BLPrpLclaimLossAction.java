package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimLoss的业务对象扩展类<br>
 * 创建于 2004-06-24 14:46:15.079<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimLossAction extends BLPrpLclaimLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLossAction.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimLossAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimLossDto prpLclaimLossDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimLossDto prpLclaimLossDto,String mode) throws Exception{
    }
}
