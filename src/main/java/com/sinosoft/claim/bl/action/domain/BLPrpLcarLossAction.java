package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcarLoss-车辆定损表的业务对象扩展类<br>
 * 创建于 2005-03-18 15:44:09.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcarLossAction extends BLPrpLcarLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcarLossAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcarLossAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcarLossDto prpLcarLossDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcarLossDto prpLcarLossDto,String mode) throws Exception{
    }
}
