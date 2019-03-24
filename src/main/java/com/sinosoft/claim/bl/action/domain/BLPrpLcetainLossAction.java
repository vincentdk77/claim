package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcetainLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcetainLoss的业务对象扩展类<br>
 * 创建于 2005-03-18 15:44:09.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcetainLossAction extends BLPrpLcetainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcetainLossAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcetainLossAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcetainLossDto prpLcetainLossDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcetainLossDto prpLcetainLossDto,String mode) throws Exception{
    }
}
